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
    private static final j bYz = new j();
    private final WeakReference<c> bXF;
    private m bXH;
    private int bXM;
    private int bXN;
    private boolean bXO;
    private i bYA;
    private e bYB;
    private f bYC;
    private g bYD;
    private k bYE;
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
            if (this.bYA != null) {
                this.bYA.abf();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bYE = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bXM = i2;
    }

    public int getDebugFlags() {
        return this.bXM;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bXO = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bXO;
    }

    public void setRenderer(m mVar) {
        aaS();
        if (this.bYB == null) {
            this.bYB = new n(true);
        }
        if (this.bYC == null) {
            this.bYC = new C0092c();
        }
        if (this.bYD == null) {
            this.bYD = new d();
        }
        this.bXH = mVar;
        this.bYA = new i(this.bXF);
        this.bYA.start();
    }

    public void setEGLContextFactory(f fVar) {
        aaS();
        this.bYC = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aaS();
        this.bYD = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aaS();
        this.bYB = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        aaS();
        this.bXN = i2;
    }

    public void setRenderMode(int i2) {
        this.bYA.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bYA.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bYA.abe();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bYA.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bYA.ak(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bXH != null) {
            int renderMode = this.bYA != null ? this.bYA.getRenderMode() : 1;
            this.bYA = new i(this.bXF);
            if (renderMode != 1) {
                this.bYA.setRenderMode(renderMode);
            }
            this.bYA.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bYA != null) {
            this.bYA.abf();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0092c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0092c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bXN, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bXN == 0) {
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
        protected int[] bXP;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bXP = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXP, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXP, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (c.this.bXN == 2) {
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
        EGL10 bXS;
        EGLDisplay bXT;
        EGLSurface bXU;
        EGLConfig bXV;
        EGLContext bXW;
        private WeakReference<c> bYG;

        public h(WeakReference<c> weakReference) {
            this.bYG = weakReference;
        }

        public void start() {
            this.bXS = (EGL10) EGLContext.getEGL();
            this.bXT = this.bXS.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bXT == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bXS.eglInitialize(this.bXT, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bYG.get();
            if (cVar != null) {
                this.bXV = cVar.bYB.chooseConfig(this.bXS, this.bXT);
                this.bXW = cVar.bYC.createContext(this.bXS, this.bXT, this.bXV);
            } else {
                this.bXV = null;
                this.bXW = null;
            }
            if (this.bXW == null || this.bXW == EGL10.EGL_NO_CONTEXT) {
                this.bXW = null;
                jI("createContext");
            }
            this.bXU = null;
        }

        public boolean aaU() {
            if (this.bXS == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bXT == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bXV == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aaY();
            c cVar = this.bYG.get();
            if (cVar != null) {
                this.bXU = cVar.bYD.createWindowSurface(this.bXS, this.bXT, this.bXV, cVar.getHolder());
            } else {
                this.bXU = null;
            }
            if (this.bXU == null || this.bXU == EGL10.EGL_NO_SURFACE) {
                if (this.bXS.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bXS.eglMakeCurrent(this.bXT, this.bXU, this.bXU, this.bXW)) {
                f("EGLHelper", "eglMakeCurrent", this.bXS.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aaV() {
            l lVar;
            GL gl = this.bXW.getGL();
            c cVar = this.bYG.get();
            if (cVar != null) {
                if (cVar.bYE != null) {
                    gl = cVar.bYE.wrap(gl);
                }
                if ((cVar.bXM & 3) != 0) {
                    int i = 0;
                    if ((cVar.bXM & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bXM & 2) == 0) {
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
            if (this.bXS.eglSwapBuffers(this.bXT, this.bXU)) {
                return 12288;
            }
            return this.bXS.eglGetError();
        }

        public void aaX() {
            aaY();
        }

        private void aaY() {
            if (this.bXU != null && this.bXU != EGL10.EGL_NO_SURFACE) {
                this.bXS.eglMakeCurrent(this.bXT, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bYG.get();
                if (cVar != null) {
                    cVar.bYD.destroySurface(this.bXS, this.bXT, this.bXU);
                }
                this.bXU = null;
            }
        }

        public void finish() {
            if (this.bXW != null) {
                c cVar = this.bYG.get();
                if (cVar != null) {
                    cVar.bYC.destroyContext(this.bXS, this.bXT, this.bXW);
                }
                this.bXW = null;
            }
            if (this.bXT != null) {
                this.bXS.eglTerminate(this.bXT);
                this.bXT = null;
            }
        }

        private void jI(String str) {
            O(str, this.bXS.eglGetError());
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
        private boolean bXX;
        private boolean bXY;
        private boolean bXZ;
        private WeakReference<c> bYG;
        private h bYH;
        private boolean bYa;
        private boolean bYb;
        private boolean bYc;
        private boolean bYd;
        private boolean bYe;
        private boolean bYf;
        private boolean bYg;
        private boolean bYh;
        private boolean bYk;
        private ArrayList<Runnable> bYl = new ArrayList<>();
        private boolean bYm = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bYj = true;
        private int bYi = 1;

        i(WeakReference<c> weakReference) {
            this.bYG = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    abb();
                    c.bYz.a(this);
                } catch (Exception e) {
                    af.vb().az(false);
                    c.bYz.a(this);
                }
            } catch (Throwable th) {
                c.bYz.a(this);
                throw th;
            }
        }

        private void aaZ() {
            if (this.bYf) {
                this.bYf = false;
                this.bYH.aaX();
            }
        }

        private void aba() {
            if (this.bYe) {
                this.bYH.finish();
                this.bYe = false;
                c.bYz.c(this);
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
            this.bYH = new h(this.bYG);
            this.bYe = false;
            this.bYf = false;
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
                    synchronized (c.bYz) {
                        while (!this.bXX) {
                            if (this.bYl.isEmpty()) {
                                if (this.bYa != this.bXZ) {
                                    boolean z23 = this.bXZ;
                                    this.bYa = this.bXZ;
                                    c.bYz.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bYh) {
                                    aaZ();
                                    aba();
                                    this.bYh = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aaZ();
                                    aba();
                                    z19 = false;
                                }
                                if (z9 && this.bYf) {
                                    aaZ();
                                }
                                if (z9 && this.bYe) {
                                    c cVar = this.bYG.get();
                                    if (!(cVar == null ? false : cVar.bXO) || c.bYz.abh()) {
                                        aba();
                                    }
                                }
                                if (z9 && c.bYz.abi()) {
                                    this.bYH.finish();
                                }
                                if (!this.bYb && !this.bYd) {
                                    if (this.bYf) {
                                        aaZ();
                                    }
                                    this.bYd = true;
                                    this.bYc = false;
                                    c.bYz.notifyAll();
                                }
                                if (this.bYb && this.bYd) {
                                    this.bYd = false;
                                    c.bYz.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bYk = true;
                                    c.bYz.notifyAll();
                                }
                                if (abd()) {
                                    if (!this.bYe) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bYz.b(this)) {
                                            try {
                                                this.bYH.start();
                                                this.bYe = true;
                                                z15 = true;
                                                c.bYz.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bYz.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bYe || this.bYf) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bYf = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bYf) {
                                        if (this.bYm) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bYm = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bYj = false;
                                        c.bYz.notifyAll();
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
                                c.bYz.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bYl.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bYz) {
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
                        } else if (this.bYH.aaU()) {
                            synchronized (c.bYz) {
                                this.bYg = true;
                                c.bYz.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bYz) {
                                this.bYg = true;
                                this.bYc = true;
                                c.bYz.notifyAll();
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
                            GL10 gl103 = (GL10) this.bYH.aaV();
                            c.bYz.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bYG.get();
                            if (cVar2 != null) {
                                cVar2.bXH.onSurfaceCreated(gl10, this.bYH.bXV);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bYG.get();
                            if (cVar3 != null) {
                                cVar3.bXH.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bYG.get();
                        if (cVar4 != null) {
                            cVar4.bXH.onDrawFrame(gl10);
                        }
                        int aaW = this.bYH.aaW();
                        switch (aaW) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", aaW);
                                synchronized (c.bYz) {
                                    this.bYc = true;
                                    c.bYz.notifyAll();
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
                    synchronized (c.bYz) {
                        aaZ();
                        aba();
                        throw th;
                    }
                }
            }
        }

        public boolean abc() {
            return this.bYe && this.bYf && abd();
        }

        private boolean abd() {
            return !this.bYa && this.bYb && !this.bYc && this.mWidth > 0 && this.mHeight > 0 && (this.bYj || this.bYi == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bYz) {
                    this.bYi = i;
                    c.bYz.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bYz) {
                i = this.bYi;
            }
            return i;
        }

        public void abe() {
            synchronized (c.bYz) {
                this.bYb = true;
                this.bYg = false;
                c.bYz.notifyAll();
                while (this.bYd && !this.bYg && !this.bXY) {
                    try {
                        c.bYz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bYz) {
                this.bYb = false;
                c.bYz.notifyAll();
                while (!this.bYd && !this.bXY) {
                    try {
                        c.bYz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (c.bYz) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bYm = true;
                this.bYj = true;
                this.bYk = false;
                c.bYz.notifyAll();
                while (!this.bXY && !this.bYa && !this.bYk && abc()) {
                    try {
                        c.bYz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abf() {
            synchronized (c.bYz) {
                this.bXX = true;
                c.bYz.notifyAll();
                while (!this.bXY) {
                    try {
                        c.bYz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abg() {
            this.bYh = true;
            c.bYz.notifyAll();
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
        if (this.bYA != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i bYI;
        private boolean bYo;
        private int bYp;
        private boolean bYq;
        private boolean bYr;
        private boolean bYs;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bXY = true;
            if (this.bYI == iVar) {
                this.bYI = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bYI == iVar || this.bYI == null) {
                this.bYI = iVar;
                notifyAll();
                return true;
            }
            abj();
            if (this.bYr) {
                return true;
            }
            if (this.bYI != null) {
                this.bYI.abg();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bYI == iVar) {
                this.bYI = null;
            }
            notifyAll();
        }

        public synchronized boolean abh() {
            return this.bYs;
        }

        public synchronized boolean abi() {
            abj();
            return !this.bYr;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bYq) {
                    abj();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bYp < 131072) {
                        this.bYr = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bYs = this.bYr ? false : true;
                    this.bYq = true;
                }
            }
        }

        private void abj() {
            if (!this.bYo) {
                this.bYr = true;
                this.bYo = true;
            }
        }
    }
}
