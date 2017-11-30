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
    private static final j bYv = new j();
    private final WeakReference<c> bXB;
    private m bXD;
    private int bXI;
    private int bXJ;
    private boolean bXK;
    private k bYA;
    private i bYw;
    private e bYx;
    private f bYy;
    private g bYz;
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
            if (this.bYw != null) {
                this.bYw.abe();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bYA = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bXI = i2;
    }

    public int getDebugFlags() {
        return this.bXI;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bXK = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bXK;
    }

    public void setRenderer(m mVar) {
        aaR();
        if (this.bYx == null) {
            this.bYx = new n(true);
        }
        if (this.bYy == null) {
            this.bYy = new C0078c();
        }
        if (this.bYz == null) {
            this.bYz = new d();
        }
        this.bXD = mVar;
        this.bYw = new i(this.bXB);
        this.bYw.start();
    }

    public void setEGLContextFactory(f fVar) {
        aaR();
        this.bYy = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aaR();
        this.bYz = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aaR();
        this.bYx = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        aaR();
        this.bXJ = i2;
    }

    public void setRenderMode(int i2) {
        this.bYw.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bYw.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bYw.abd();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bYw.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bYw.aj(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bXD != null) {
            int renderMode = this.bYw != null ? this.bYw.getRenderMode() : 1;
            this.bYw = new i(this.bXB);
            if (renderMode != 1) {
                this.bYw.setRenderMode(renderMode);
            }
            this.bYw.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bYw != null) {
            this.bYw.abe();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0078c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0078c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bXJ, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bXJ == 0) {
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
        protected int[] bXL;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bXL = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXL, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXL, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (c.this.bXJ == 2) {
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
        EGL10 bXO;
        EGLDisplay bXP;
        EGLSurface bXQ;
        EGLConfig bXR;
        EGLContext bXS;
        private WeakReference<c> bYC;

        public h(WeakReference<c> weakReference) {
            this.bYC = weakReference;
        }

        public void start() {
            this.bXO = (EGL10) EGLContext.getEGL();
            this.bXP = this.bXO.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bXP == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bXO.eglInitialize(this.bXP, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bYC.get();
            if (cVar != null) {
                this.bXR = cVar.bYx.chooseConfig(this.bXO, this.bXP);
                this.bXS = cVar.bYy.createContext(this.bXO, this.bXP, this.bXR);
            } else {
                this.bXR = null;
                this.bXS = null;
            }
            if (this.bXS == null || this.bXS == EGL10.EGL_NO_CONTEXT) {
                this.bXS = null;
                jK("createContext");
            }
            this.bXQ = null;
        }

        public boolean aaT() {
            if (this.bXO == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bXP == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bXR == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aaX();
            c cVar = this.bYC.get();
            if (cVar != null) {
                this.bXQ = cVar.bYz.createWindowSurface(this.bXO, this.bXP, this.bXR, cVar.getHolder());
            } else {
                this.bXQ = null;
            }
            if (this.bXQ == null || this.bXQ == EGL10.EGL_NO_SURFACE) {
                if (this.bXO.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bXO.eglMakeCurrent(this.bXP, this.bXQ, this.bXQ, this.bXS)) {
                f("EGLHelper", "eglMakeCurrent", this.bXO.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aaU() {
            l lVar;
            GL gl = this.bXS.getGL();
            c cVar = this.bYC.get();
            if (cVar != null) {
                if (cVar.bYA != null) {
                    gl = cVar.bYA.wrap(gl);
                }
                if ((cVar.bXI & 3) != 0) {
                    int i = 0;
                    if ((cVar.bXI & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bXI & 2) == 0) {
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

        public int aaV() {
            if (this.bXO.eglSwapBuffers(this.bXP, this.bXQ)) {
                return 12288;
            }
            return this.bXO.eglGetError();
        }

        public void aaW() {
            aaX();
        }

        private void aaX() {
            if (this.bXQ != null && this.bXQ != EGL10.EGL_NO_SURFACE) {
                this.bXO.eglMakeCurrent(this.bXP, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bYC.get();
                if (cVar != null) {
                    cVar.bYz.destroySurface(this.bXO, this.bXP, this.bXQ);
                }
                this.bXQ = null;
            }
        }

        public void finish() {
            if (this.bXS != null) {
                c cVar = this.bYC.get();
                if (cVar != null) {
                    cVar.bYy.destroyContext(this.bXO, this.bXP, this.bXS);
                }
                this.bXS = null;
            }
            if (this.bXP != null) {
                this.bXO.eglTerminate(this.bXP);
                this.bXP = null;
            }
        }

        private void jK(String str) {
            O(str, this.bXO.eglGetError());
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
        private boolean bXT;
        private boolean bXU;
        private boolean bXV;
        private boolean bXW;
        private boolean bXX;
        private boolean bXY;
        private boolean bXZ;
        private WeakReference<c> bYC;
        private h bYD;
        private boolean bYa;
        private boolean bYb;
        private boolean bYc;
        private boolean bYd;
        private boolean bYg;
        private ArrayList<Runnable> bYh = new ArrayList<>();
        private boolean bYi = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bYf = true;
        private int bYe = 1;

        i(WeakReference<c> weakReference) {
            this.bYC = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aba();
                    c.bYv.a(this);
                } catch (Exception e) {
                    af.ve().az(false);
                    c.bYv.a(this);
                }
            } catch (Throwable th) {
                c.bYv.a(this);
                throw th;
            }
        }

        private void aaY() {
            if (this.bYb) {
                this.bYb = false;
                this.bYD.aaW();
            }
        }

        private void aaZ() {
            if (this.bYa) {
                this.bYD.finish();
                this.bYa = false;
                c.bYv.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aba() throws InterruptedException {
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
            this.bYD = new h(this.bYC);
            this.bYa = false;
            this.bYb = false;
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
                    synchronized (c.bYv) {
                        while (!this.bXT) {
                            if (this.bYh.isEmpty()) {
                                if (this.bXW != this.bXV) {
                                    boolean z23 = this.bXV;
                                    this.bXW = this.bXV;
                                    c.bYv.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bYd) {
                                    aaY();
                                    aaZ();
                                    this.bYd = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aaY();
                                    aaZ();
                                    z19 = false;
                                }
                                if (z9 && this.bYb) {
                                    aaY();
                                }
                                if (z9 && this.bYa) {
                                    c cVar = this.bYC.get();
                                    if (!(cVar == null ? false : cVar.bXK) || c.bYv.abg()) {
                                        aaZ();
                                    }
                                }
                                if (z9 && c.bYv.abh()) {
                                    this.bYD.finish();
                                }
                                if (!this.bXX && !this.bXZ) {
                                    if (this.bYb) {
                                        aaY();
                                    }
                                    this.bXZ = true;
                                    this.bXY = false;
                                    c.bYv.notifyAll();
                                }
                                if (this.bXX && this.bXZ) {
                                    this.bXZ = false;
                                    c.bYv.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bYg = true;
                                    c.bYv.notifyAll();
                                }
                                if (abc()) {
                                    if (!this.bYa) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bYv.b(this)) {
                                            try {
                                                this.bYD.start();
                                                this.bYa = true;
                                                z15 = true;
                                                c.bYv.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bYv.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bYa || this.bYb) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bYb = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bYb) {
                                        if (this.bYi) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bYi = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bYf = false;
                                        c.bYv.notifyAll();
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
                                c.bYv.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bYh.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bYv) {
                            aaY();
                            aaZ();
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
                        } else if (this.bYD.aaT()) {
                            synchronized (c.bYv) {
                                this.bYc = true;
                                c.bYv.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bYv) {
                                this.bYc = true;
                                this.bXY = true;
                                c.bYv.notifyAll();
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
                            GL10 gl103 = (GL10) this.bYD.aaU();
                            c.bYv.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bYC.get();
                            if (cVar2 != null) {
                                cVar2.bXD.onSurfaceCreated(gl10, this.bYD.bXR);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bYC.get();
                            if (cVar3 != null) {
                                cVar3.bXD.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bYC.get();
                        if (cVar4 != null) {
                            cVar4.bXD.onDrawFrame(gl10);
                        }
                        int aaV = this.bYD.aaV();
                        switch (aaV) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", aaV);
                                synchronized (c.bYv) {
                                    this.bXY = true;
                                    c.bYv.notifyAll();
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
                    synchronized (c.bYv) {
                        aaY();
                        aaZ();
                        throw th;
                    }
                }
            }
        }

        public boolean abb() {
            return this.bYa && this.bYb && abc();
        }

        private boolean abc() {
            return !this.bXW && this.bXX && !this.bXY && this.mWidth > 0 && this.mHeight > 0 && (this.bYf || this.bYe == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bYv) {
                    this.bYe = i;
                    c.bYv.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bYv) {
                i = this.bYe;
            }
            return i;
        }

        public void abd() {
            synchronized (c.bYv) {
                this.bXX = true;
                this.bYc = false;
                c.bYv.notifyAll();
                while (this.bXZ && !this.bYc && !this.bXU) {
                    try {
                        c.bYv.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bYv) {
                this.bXX = false;
                c.bYv.notifyAll();
                while (!this.bXZ && !this.bXU) {
                    try {
                        c.bYv.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aj(int i, int i2) {
            synchronized (c.bYv) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bYi = true;
                this.bYf = true;
                this.bYg = false;
                c.bYv.notifyAll();
                while (!this.bXU && !this.bXW && !this.bYg && abb()) {
                    try {
                        c.bYv.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abe() {
            synchronized (c.bYv) {
                this.bXT = true;
                c.bYv.notifyAll();
                while (!this.bXU) {
                    try {
                        c.bYv.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abf() {
            this.bYd = true;
            c.bYv.notifyAll();
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

    private void aaR() {
        if (this.bYw != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i bYE;
        private boolean bYk;
        private int bYl;
        private boolean bYm;
        private boolean bYn;
        private boolean bYo;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bXU = true;
            if (this.bYE == iVar) {
                this.bYE = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bYE == iVar || this.bYE == null) {
                this.bYE = iVar;
                notifyAll();
                return true;
            }
            abi();
            if (this.bYn) {
                return true;
            }
            if (this.bYE != null) {
                this.bYE.abf();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bYE == iVar) {
                this.bYE = null;
            }
            notifyAll();
        }

        public synchronized boolean abg() {
            return this.bYo;
        }

        public synchronized boolean abh() {
            abi();
            return !this.bYn;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bYm) {
                    abi();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bYl < 131072) {
                        this.bYn = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bYo = this.bYn ? false : true;
                    this.bYm = true;
                }
            }
        }

        private void abi() {
            if (!this.bYk) {
                this.bYn = true;
                this.bYk = true;
            }
        }
    }
}
