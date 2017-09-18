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
    private static final j bHe = new j();
    private final WeakReference<c> bGk;
    private m bGm;
    private int bGr;
    private int bGs;
    private boolean bGt;
    private i bHf;
    private e bHg;
    private f bHh;
    private g bHi;
    private k bHj;
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
            if (this.bHf != null) {
                this.bHf.WJ();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bHj = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bGr = i2;
    }

    public int getDebugFlags() {
        return this.bGr;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bGt = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bGt;
    }

    public void setRenderer(m mVar) {
        Ww();
        if (this.bHg == null) {
            this.bHg = new n(true);
        }
        if (this.bHh == null) {
            this.bHh = new C0076c();
        }
        if (this.bHi == null) {
            this.bHi = new d();
        }
        this.bGm = mVar;
        this.bHf = new i(this.bGk);
        this.bHf.start();
    }

    public void setEGLContextFactory(f fVar) {
        Ww();
        this.bHh = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Ww();
        this.bHi = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Ww();
        this.bHg = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Ww();
        this.bGs = i2;
    }

    public void setRenderMode(int i2) {
        this.bHf.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bHf.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bHf.WI();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bHf.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bHf.ac(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bGm != null) {
            int renderMode = this.bHf != null ? this.bHf.getRenderMode() : 1;
            this.bHf = new i(this.bGk);
            if (renderMode != 1) {
                this.bHf.setRenderMode(renderMode);
            }
            this.bHf.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bHf != null) {
            this.bHf.WJ();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0076c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0076c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bGs, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bGs == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.c.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.G("eglDestroyContex", egl10.eglGetError());
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
        protected int[] bGu;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bGu = f(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bGu, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bGu, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] f(int[] iArr) {
            if (c.this.bGs == 2) {
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
        EGLConfig bGA;
        EGLContext bGB;
        EGL10 bGx;
        EGLDisplay bGy;
        EGLSurface bGz;
        private WeakReference<c> bHl;

        public h(WeakReference<c> weakReference) {
            this.bHl = weakReference;
        }

        public void start() {
            this.bGx = (EGL10) EGLContext.getEGL();
            this.bGy = this.bGx.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bGy == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bGx.eglInitialize(this.bGy, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bHl.get();
            if (cVar != null) {
                this.bGA = cVar.bHg.chooseConfig(this.bGx, this.bGy);
                this.bGB = cVar.bHh.createContext(this.bGx, this.bGy, this.bGA);
            } else {
                this.bGA = null;
                this.bGB = null;
            }
            if (this.bGB == null || this.bGB == EGL10.EGL_NO_CONTEXT) {
                this.bGB = null;
                jl("createContext");
            }
            this.bGz = null;
        }

        public boolean Wy() {
            if (this.bGx == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bGy == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bGA == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            WC();
            c cVar = this.bHl.get();
            if (cVar != null) {
                this.bGz = cVar.bHi.createWindowSurface(this.bGx, this.bGy, this.bGA, cVar.getHolder());
            } else {
                this.bGz = null;
            }
            if (this.bGz == null || this.bGz == EGL10.EGL_NO_SURFACE) {
                if (this.bGx.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bGx.eglMakeCurrent(this.bGy, this.bGz, this.bGz, this.bGB)) {
                f("EGLHelper", "eglMakeCurrent", this.bGx.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Wz() {
            l lVar;
            GL gl = this.bGB.getGL();
            c cVar = this.bHl.get();
            if (cVar != null) {
                if (cVar.bHj != null) {
                    gl = cVar.bHj.wrap(gl);
                }
                if ((cVar.bGr & 3) != 0) {
                    int i = 0;
                    if ((cVar.bGr & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bGr & 2) == 0) {
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

        public int WA() {
            if (this.bGx.eglSwapBuffers(this.bGy, this.bGz)) {
                return 12288;
            }
            return this.bGx.eglGetError();
        }

        public void WB() {
            WC();
        }

        private void WC() {
            if (this.bGz != null && this.bGz != EGL10.EGL_NO_SURFACE) {
                this.bGx.eglMakeCurrent(this.bGy, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bHl.get();
                if (cVar != null) {
                    cVar.bHi.destroySurface(this.bGx, this.bGy, this.bGz);
                }
                this.bGz = null;
            }
        }

        public void finish() {
            if (this.bGB != null) {
                c cVar = this.bHl.get();
                if (cVar != null) {
                    cVar.bHh.destroyContext(this.bGx, this.bGy, this.bGB);
                }
                this.bGB = null;
            }
            if (this.bGy != null) {
                this.bGx.eglTerminate(this.bGy);
                this.bGy = null;
            }
        }

        private void jl(String str) {
            G(str, this.bGx.eglGetError());
        }

        public static void G(String str, int i) {
            throw new RuntimeException(H(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, H(str2, i));
        }

        public static String H(String str, int i) {
            return str + " failed: " + com.baidu.tieba.b.d.b.hz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean bGC;
        private boolean bGD;
        private boolean bGE;
        private boolean bGF;
        private boolean bGG;
        private boolean bGH;
        private boolean bGI;
        private boolean bGJ;
        private boolean bGK;
        private boolean bGL;
        private boolean bGM;
        private boolean bGP;
        private WeakReference<c> bHl;
        private h bHm;
        private ArrayList<Runnable> bGQ = new ArrayList<>();
        private boolean bGR = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bGO = true;
        private int bGN = 1;

        i(WeakReference<c> weakReference) {
            this.bHl = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    WF();
                    c.bHe.a(this);
                } catch (Exception e) {
                    af.vx().aC(false);
                    c.bHe.a(this);
                }
            } catch (Throwable th) {
                c.bHe.a(this);
                throw th;
            }
        }

        private void WD() {
            if (this.bGK) {
                this.bGK = false;
                this.bHm.WB();
            }
        }

        private void WE() {
            if (this.bGJ) {
                this.bHm.finish();
                this.bGJ = false;
                c.bHe.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void WF() throws InterruptedException {
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
            this.bHm = new h(this.bHl);
            this.bGJ = false;
            this.bGK = false;
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
                    synchronized (c.bHe) {
                        while (!this.bGC) {
                            if (this.bGQ.isEmpty()) {
                                if (this.bGF != this.bGE) {
                                    boolean z23 = this.bGE;
                                    this.bGF = this.bGE;
                                    c.bHe.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bGM) {
                                    WD();
                                    WE();
                                    this.bGM = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    WD();
                                    WE();
                                    z19 = false;
                                }
                                if (z9 && this.bGK) {
                                    WD();
                                }
                                if (z9 && this.bGJ) {
                                    c cVar = this.bHl.get();
                                    if (!(cVar == null ? false : cVar.bGt) || c.bHe.WL()) {
                                        WE();
                                    }
                                }
                                if (z9 && c.bHe.WM()) {
                                    this.bHm.finish();
                                }
                                if (!this.bGG && !this.bGI) {
                                    if (this.bGK) {
                                        WD();
                                    }
                                    this.bGI = true;
                                    this.bGH = false;
                                    c.bHe.notifyAll();
                                }
                                if (this.bGG && this.bGI) {
                                    this.bGI = false;
                                    c.bHe.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bGP = true;
                                    c.bHe.notifyAll();
                                }
                                if (WH()) {
                                    if (!this.bGJ) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bHe.b(this)) {
                                            try {
                                                this.bHm.start();
                                                this.bGJ = true;
                                                z15 = true;
                                                c.bHe.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bHe.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bGJ || this.bGK) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bGK = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bGK) {
                                        if (this.bGR) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bGR = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bGO = false;
                                        c.bHe.notifyAll();
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
                                c.bHe.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bGQ.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bHe) {
                            WD();
                            WE();
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
                        } else if (this.bHm.Wy()) {
                            synchronized (c.bHe) {
                                this.bGL = true;
                                c.bHe.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bHe) {
                                this.bGL = true;
                                this.bGH = true;
                                c.bHe.notifyAll();
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
                            GL10 gl103 = (GL10) this.bHm.Wz();
                            c.bHe.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bHl.get();
                            if (cVar2 != null) {
                                cVar2.bGm.onSurfaceCreated(gl10, this.bHm.bGA);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bHl.get();
                            if (cVar3 != null) {
                                cVar3.bGm.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bHl.get();
                        if (cVar4 != null) {
                            cVar4.bGm.onDrawFrame(gl10);
                        }
                        int WA = this.bHm.WA();
                        switch (WA) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", WA);
                                synchronized (c.bHe) {
                                    this.bGH = true;
                                    c.bHe.notifyAll();
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
                    synchronized (c.bHe) {
                        WD();
                        WE();
                        throw th;
                    }
                }
            }
        }

        public boolean WG() {
            return this.bGJ && this.bGK && WH();
        }

        private boolean WH() {
            return !this.bGF && this.bGG && !this.bGH && this.mWidth > 0 && this.mHeight > 0 && (this.bGO || this.bGN == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bHe) {
                    this.bGN = i;
                    c.bHe.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bHe) {
                i = this.bGN;
            }
            return i;
        }

        public void WI() {
            synchronized (c.bHe) {
                this.bGG = true;
                this.bGL = false;
                c.bHe.notifyAll();
                while (this.bGI && !this.bGL && !this.bGD) {
                    try {
                        c.bHe.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bHe) {
                this.bGG = false;
                c.bHe.notifyAll();
                while (!this.bGI && !this.bGD) {
                    try {
                        c.bHe.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ac(int i, int i2) {
            synchronized (c.bHe) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bGR = true;
                this.bGO = true;
                this.bGP = false;
                c.bHe.notifyAll();
                while (!this.bGD && !this.bGF && !this.bGP && WG()) {
                    try {
                        c.bHe.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void WJ() {
            synchronized (c.bHe) {
                this.bGC = true;
                c.bHe.notifyAll();
                while (!this.bGD) {
                    try {
                        c.bHe.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void WK() {
            this.bGM = true;
            c.bHe.notifyAll();
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

    private void Ww() {
        if (this.bHf != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bGT;
        private int bGU;
        private boolean bGV;
        private boolean bGW;
        private boolean bGX;
        private i bHn;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bGD = true;
            if (this.bHn == iVar) {
                this.bHn = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bHn == iVar || this.bHn == null) {
                this.bHn = iVar;
                notifyAll();
                return true;
            }
            WN();
            if (this.bGW) {
                return true;
            }
            if (this.bHn != null) {
                this.bHn.WK();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bHn == iVar) {
                this.bHn = null;
            }
            notifyAll();
        }

        public synchronized boolean WL() {
            return this.bGX;
        }

        public synchronized boolean WM() {
            WN();
            return !this.bGW;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bGV) {
                    WN();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bGU < 131072) {
                        this.bGW = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bGX = this.bGW ? false : true;
                    this.bGV = true;
                }
            }
        }

        private void WN() {
            if (!this.bGT) {
                this.bGW = true;
                this.bGT = true;
            }
        }
    }
}
