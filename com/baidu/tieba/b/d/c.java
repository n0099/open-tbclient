package com.baidu.tieba.b.d;

import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.tbadk.core.util.af;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class c extends SurfaceView implements SurfaceHolder.Callback {
    private static final j bYD = new j();
    private final WeakReference<c> bXJ;
    private m bXL;
    private int bXQ;
    private int bXR;
    private boolean bXS;
    private i bYE;
    private e bYF;
    private f bYG;
    private g bYH;
    private k bYI;
    private boolean mDetached;

    /* loaded from: classes.dex */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: classes.dex */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes.dex */
    public interface g {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* loaded from: classes.dex */
    public interface k {
        GL wrap(GL gl);
    }

    /* loaded from: classes.dex */
    public interface m {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bYE != null) {
                this.bYE.abf();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bYI = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bXQ = i2;
    }

    public int getDebugFlags() {
        return this.bXQ;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bXS = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bXS;
    }

    public void setRenderer(m mVar) {
        aaS();
        if (this.bYF == null) {
            this.bYF = new n(true);
        }
        if (this.bYG == null) {
            this.bYG = new C0091c();
        }
        if (this.bYH == null) {
            this.bYH = new d();
        }
        this.bXL = mVar;
        this.bYE = new i(this.bXJ);
        this.bYE.start();
    }

    public void setEGLContextFactory(f fVar) {
        aaS();
        this.bYG = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aaS();
        this.bYH = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aaS();
        this.bYF = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        aaS();
        this.bXR = i2;
    }

    public void setRenderMode(int i2) {
        this.bYE.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bYE.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bYE.abe();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bYE.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bYE.ak(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bXL != null) {
            int renderMode = this.bYE != null ? this.bYE.getRenderMode() : 1;
            this.bYE = new i(this.bXJ);
            if (renderMode != 1) {
                this.bYE.setRenderMode(renderMode);
            }
            this.bYE.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bYE != null) {
            this.bYE.abf();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0091c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0091c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bXR, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bXR == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.c.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.O("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements g {
        private d() {
        }

        @Override // com.baidu.tieba.b.d.c.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.b.d.c.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes.dex */
    private abstract class a implements e {
        protected int[] bXT;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bXT = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXT, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXT, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (c.this.bXR == 2) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                System.arraycopy(iArr, 0, iArr2, 0, length - 1);
                iArr2[length - 1] = 12352;
                iArr2[length] = 4;
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }
    }

    /* loaded from: classes.dex */
    private class b extends a {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mValue = new int[1];
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        @Override // com.baidu.tieba.b.d.c.a
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                return this.mValue[0];
            }
            return i2;
        }
    }

    /* loaded from: classes.dex */
    private class n extends b {
        public n(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h {
        EGL10 bXW;
        EGLDisplay bXX;
        EGLSurface bXY;
        EGLConfig bXZ;
        private WeakReference<c> bYK;
        EGLContext bYa;

        public h(WeakReference<c> weakReference) {
            this.bYK = weakReference;
        }

        public void start() {
            this.bXW = (EGL10) EGLContext.getEGL();
            this.bXX = this.bXW.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bXX == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bXW.eglInitialize(this.bXX, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bYK.get();
            if (cVar != null) {
                this.bXZ = cVar.bYF.chooseConfig(this.bXW, this.bXX);
                this.bYa = cVar.bYG.createContext(this.bXW, this.bXX, this.bXZ);
            } else {
                this.bXZ = null;
                this.bYa = null;
            }
            if (this.bYa == null || this.bYa == EGL10.EGL_NO_CONTEXT) {
                this.bYa = null;
                jI("createContext");
            }
            this.bXY = null;
        }

        public boolean aaU() {
            if (this.bXW == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bXX == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bXZ == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aaY();
            c cVar = this.bYK.get();
            if (cVar != null) {
                this.bXY = cVar.bYH.createWindowSurface(this.bXW, this.bXX, this.bXZ, cVar.getHolder());
            } else {
                this.bXY = null;
            }
            if (this.bXY == null || this.bXY == EGL10.EGL_NO_SURFACE) {
                if (this.bXW.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bXW.eglMakeCurrent(this.bXX, this.bXY, this.bXY, this.bYa)) {
                f("EGLHelper", "eglMakeCurrent", this.bXW.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aaV() {
            l lVar;
            GL gl = this.bYa.getGL();
            c cVar = this.bYK.get();
            if (cVar != null) {
                if (cVar.bYI != null) {
                    gl = cVar.bYI.wrap(gl);
                }
                if ((cVar.bXQ & 3) != 0) {
                    int i = 0;
                    if ((cVar.bXQ & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bXQ & 2) == 0) {
                        lVar = null;
                    } else {
                        lVar = new l();
                    }
                    return GLDebugHelper.wrap(gl, i, lVar);
                }
                return gl;
            }
            return gl;
        }

        public int aaW() {
            if (this.bXW.eglSwapBuffers(this.bXX, this.bXY)) {
                return 12288;
            }
            return this.bXW.eglGetError();
        }

        public void aaX() {
            aaY();
        }

        private void aaY() {
            if (this.bXY != null && this.bXY != EGL10.EGL_NO_SURFACE) {
                this.bXW.eglMakeCurrent(this.bXX, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bYK.get();
                if (cVar != null) {
                    cVar.bYH.destroySurface(this.bXW, this.bXX, this.bXY);
                }
                this.bXY = null;
            }
        }

        public void finish() {
            if (this.bYa != null) {
                c cVar = this.bYK.get();
                if (cVar != null) {
                    cVar.bYG.destroyContext(this.bXW, this.bXX, this.bYa);
                }
                this.bYa = null;
            }
            if (this.bXX != null) {
                this.bXW.eglTerminate(this.bXX);
                this.bXX = null;
            }
        }

        private void jI(String str) {
            O(str, this.bXW.eglGetError());
        }

        public static void O(String str, int i) {
            throw new RuntimeException(P(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, P(str2, i));
        }

        public static String P(String str, int i) {
            return str + " failed: " + com.baidu.tieba.b.d.b.iB(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<c> bYK;
        private h bYL;
        private boolean bYb;
        private boolean bYc;
        private boolean bYd;
        private boolean bYe;
        private boolean bYf;
        private boolean bYg;
        private boolean bYh;
        private boolean bYi;
        private boolean bYj;
        private boolean bYk;
        private boolean bYl;
        private boolean bYo;
        private ArrayList<Runnable> bYp = new ArrayList<>();
        private boolean bYq = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bYn = true;
        private int bYm = 1;

        i(WeakReference<c> weakReference) {
            this.bYK = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    abb();
                    c.bYD.a(this);
                } catch (Exception e) {
                    af.vb().az(false);
                    c.bYD.a(this);
                }
            } catch (Throwable th) {
                c.bYD.a(this);
                throw th;
            }
        }

        private void aaZ() {
            if (this.bYj) {
                this.bYj = false;
                this.bYL.aaX();
            }
        }

        private void aba() {
            if (this.bYi) {
                this.bYL.finish();
                this.bYi = false;
                c.bYD.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void abb() throws InterruptedException {
            boolean z;
            int i;
            Runnable remove;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            int i2;
            boolean z8;
            GL10 gl10;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            int i3;
            int i4;
            this.bYL = new h(this.bYK);
            this.bYi = false;
            this.bYj = false;
            boolean z15 = false;
            GL10 gl102 = null;
            int i5 = 0;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            boolean z20 = false;
            boolean z21 = false;
            Runnable runnable = null;
            int i6 = 0;
            boolean z22 = false;
            while (true) {
                try {
                    synchronized (c.bYD) {
                        while (!this.bYb) {
                            if (this.bYp.isEmpty()) {
                                if (this.bYe != this.bYd) {
                                    boolean z23 = this.bYd;
                                    this.bYe = this.bYd;
                                    c.bYD.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bYl) {
                                    aaZ();
                                    aba();
                                    this.bYl = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aaZ();
                                    aba();
                                    z19 = false;
                                }
                                if (z9 && this.bYj) {
                                    aaZ();
                                }
                                if (z9 && this.bYi) {
                                    c cVar = this.bYK.get();
                                    if (!(cVar == null ? false : cVar.bXS) || c.bYD.abh()) {
                                        aba();
                                    }
                                }
                                if (z9 && c.bYD.abi()) {
                                    this.bYL.finish();
                                }
                                if (!this.bYf && !this.bYh) {
                                    if (this.bYj) {
                                        aaZ();
                                    }
                                    this.bYh = true;
                                    this.bYg = false;
                                    c.bYD.notifyAll();
                                }
                                if (this.bYf && this.bYh) {
                                    this.bYh = false;
                                    c.bYD.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bYo = true;
                                    c.bYD.notifyAll();
                                }
                                if (abd()) {
                                    if (!this.bYi) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bYD.b(this)) {
                                            try {
                                                this.bYL.start();
                                                this.bYi = true;
                                                z15 = true;
                                                c.bYD.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bYD.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bYi || this.bYj) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bYj = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bYj) {
                                        if (this.bYq) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bYq = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bYn = false;
                                        c.bYD.notifyAll();
                                        z3 = z11;
                                        z6 = z13;
                                        remove = runnable;
                                        z = z22;
                                        i = i4;
                                        int i8 = i3;
                                        z2 = z12;
                                        z4 = z19;
                                        z5 = z14;
                                        z7 = z16;
                                        i2 = i8;
                                    } else {
                                        z20 = z11;
                                        z18 = z10;
                                    }
                                }
                                c.bYD.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bYp.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bYD) {
                            aaZ();
                            aba();
                        }
                        return;
                    }
                    if (remove != null) {
                        remove.run();
                        i5 = i2;
                        z16 = z7;
                        z17 = z6;
                        z18 = z5;
                        z19 = z4;
                        z20 = z3;
                        z21 = z2;
                        boolean z24 = z;
                        runnable = null;
                        i6 = i;
                        z22 = z24;
                    } else {
                        if (!z2) {
                            z8 = z2;
                        } else if (this.bYL.aaU()) {
                            synchronized (c.bYD) {
                                this.bYk = true;
                                c.bYD.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bYD) {
                                this.bYk = true;
                                this.bYg = true;
                                c.bYD.notifyAll();
                            }
                            i5 = i2;
                            z16 = z7;
                            z17 = z6;
                            z18 = z5;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            boolean z25 = z;
                            runnable = remove;
                            i6 = i;
                            z22 = z25;
                        }
                        if (z3) {
                            GL10 gl103 = (GL10) this.bYL.aaV();
                            c.bYD.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bYK.get();
                            if (cVar2 != null) {
                                cVar2.bXL.onSurfaceCreated(gl10, this.bYL.bXZ);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bYK.get();
                            if (cVar3 != null) {
                                cVar3.bXL.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bYK.get();
                        if (cVar4 != null) {
                            cVar4.bXL.onDrawFrame(gl10);
                        }
                        int aaW = this.bYL.aaW();
                        switch (aaW) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", aaW);
                                synchronized (c.bYD) {
                                    this.bYg = true;
                                    c.bYD.notifyAll();
                                    break;
                                }
                        }
                        boolean z26 = z6 ? true : z;
                        runnable = remove;
                        gl102 = gl10;
                        i6 = i;
                        z22 = z26;
                        boolean z27 = z7;
                        z17 = z6;
                        z18 = z5;
                        z19 = z4;
                        z20 = z3;
                        z21 = z8;
                        i5 = i2;
                        z16 = z27;
                    }
                } catch (Throwable th) {
                    synchronized (c.bYD) {
                        aaZ();
                        aba();
                        throw th;
                    }
                }
            }
        }

        public boolean abc() {
            return this.bYi && this.bYj && abd();
        }

        private boolean abd() {
            return !this.bYe && this.bYf && !this.bYg && this.mWidth > 0 && this.mHeight > 0 && (this.bYn || this.bYm == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bYD) {
                    this.bYm = i;
                    c.bYD.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bYD) {
                i = this.bYm;
            }
            return i;
        }

        public void abe() {
            synchronized (c.bYD) {
                this.bYf = true;
                this.bYk = false;
                c.bYD.notifyAll();
                while (this.bYh && !this.bYk && !this.bYc) {
                    try {
                        c.bYD.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bYD) {
                this.bYf = false;
                c.bYD.notifyAll();
                while (!this.bYh && !this.bYc) {
                    try {
                        c.bYD.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (c.bYD) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bYq = true;
                this.bYn = true;
                this.bYo = false;
                c.bYD.notifyAll();
                while (!this.bYc && !this.bYe && !this.bYo && abc()) {
                    try {
                        c.bYD.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abf() {
            synchronized (c.bYD) {
                this.bYb = true;
                c.bYD.notifyAll();
                while (!this.bYc) {
                    try {
                        c.bYD.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abg() {
            this.bYl = true;
            c.bYD.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        l() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v("GLSurfaceView", this.mBuilder.toString());
                this.mBuilder.delete(0, this.mBuilder.length());
            }
        }
    }

    private void aaS() {
        if (this.bYE != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i bYM;
        private boolean bYs;
        private int bYt;
        private boolean bYu;
        private boolean bYv;
        private boolean bYw;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bYc = true;
            if (this.bYM == iVar) {
                this.bYM = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bYM == iVar || this.bYM == null) {
                this.bYM = iVar;
                notifyAll();
                return true;
            }
            abj();
            if (this.bYv) {
                return true;
            }
            if (this.bYM != null) {
                this.bYM.abg();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bYM == iVar) {
                this.bYM = null;
            }
            notifyAll();
        }

        public synchronized boolean abh() {
            return this.bYw;
        }

        public synchronized boolean abi() {
            abj();
            return !this.bYv;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bYu) {
                    abj();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bYt < 131072) {
                        this.bYv = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bYw = this.bYv ? false : true;
                    this.bYu = true;
                }
            }
        }

        private void abj() {
            if (!this.bYs) {
                this.bYv = true;
                this.bYs = true;
            }
        }
    }
}
