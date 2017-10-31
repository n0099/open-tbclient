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
    private static final j bQj = new j();
    private final WeakReference<c> bPp;
    private m bPr;
    private int bPw;
    private int bPx;
    private boolean bPy;
    private i bQk;
    private e bQl;
    private f bQm;
    private g bQn;
    private k bQo;
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
            if (this.bQk != null) {
                this.bQk.Zj();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bQo = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bPw = i2;
    }

    public int getDebugFlags() {
        return this.bPw;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bPy = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bPy;
    }

    public void setRenderer(m mVar) {
        YW();
        if (this.bQl == null) {
            this.bQl = new n(true);
        }
        if (this.bQm == null) {
            this.bQm = new C0077c();
        }
        if (this.bQn == null) {
            this.bQn = new d();
        }
        this.bPr = mVar;
        this.bQk = new i(this.bPp);
        this.bQk.start();
    }

    public void setEGLContextFactory(f fVar) {
        YW();
        this.bQm = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        YW();
        this.bQn = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        YW();
        this.bQl = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        YW();
        this.bPx = i2;
    }

    public void setRenderMode(int i2) {
        this.bQk.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bQk.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bQk.Zi();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bQk.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bQk.ak(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bPr != null) {
            int renderMode = this.bQk != null ? this.bQk.getRenderMode() : 1;
            this.bQk = new i(this.bPp);
            if (renderMode != 1) {
                this.bQk.setRenderMode(renderMode);
            }
            this.bQk.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bQk != null) {
            this.bQk.Zj();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0077c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0077c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bPx, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bPx == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.c.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.M("eglDestroyContex", egl10.eglGetError());
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
        protected int[] bPz;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bPz = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bPz, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bPz, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (c.this.bPx == 2) {
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
        EGL10 bPC;
        EGLDisplay bPD;
        EGLSurface bPE;
        EGLConfig bPF;
        EGLContext bPG;
        private WeakReference<c> bQq;

        public h(WeakReference<c> weakReference) {
            this.bQq = weakReference;
        }

        public void start() {
            this.bPC = (EGL10) EGLContext.getEGL();
            this.bPD = this.bPC.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bPD == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bPC.eglInitialize(this.bPD, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bQq.get();
            if (cVar != null) {
                this.bPF = cVar.bQl.chooseConfig(this.bPC, this.bPD);
                this.bPG = cVar.bQm.createContext(this.bPC, this.bPD, this.bPF);
            } else {
                this.bPF = null;
                this.bPG = null;
            }
            if (this.bPG == null || this.bPG == EGL10.EGL_NO_CONTEXT) {
                this.bPG = null;
                jE("createContext");
            }
            this.bPE = null;
        }

        public boolean YY() {
            if (this.bPC == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bPD == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bPF == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Zc();
            c cVar = this.bQq.get();
            if (cVar != null) {
                this.bPE = cVar.bQn.createWindowSurface(this.bPC, this.bPD, this.bPF, cVar.getHolder());
            } else {
                this.bPE = null;
            }
            if (this.bPE == null || this.bPE == EGL10.EGL_NO_SURFACE) {
                if (this.bPC.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bPC.eglMakeCurrent(this.bPD, this.bPE, this.bPE, this.bPG)) {
                f("EGLHelper", "eglMakeCurrent", this.bPC.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL YZ() {
            l lVar;
            GL gl = this.bPG.getGL();
            c cVar = this.bQq.get();
            if (cVar != null) {
                if (cVar.bQo != null) {
                    gl = cVar.bQo.wrap(gl);
                }
                if ((cVar.bPw & 3) != 0) {
                    int i = 0;
                    if ((cVar.bPw & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bPw & 2) == 0) {
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

        public int Za() {
            if (this.bPC.eglSwapBuffers(this.bPD, this.bPE)) {
                return 12288;
            }
            return this.bPC.eglGetError();
        }

        public void Zb() {
            Zc();
        }

        private void Zc() {
            if (this.bPE != null && this.bPE != EGL10.EGL_NO_SURFACE) {
                this.bPC.eglMakeCurrent(this.bPD, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bQq.get();
                if (cVar != null) {
                    cVar.bQn.destroySurface(this.bPC, this.bPD, this.bPE);
                }
                this.bPE = null;
            }
        }

        public void finish() {
            if (this.bPG != null) {
                c cVar = this.bQq.get();
                if (cVar != null) {
                    cVar.bQm.destroyContext(this.bPC, this.bPD, this.bPG);
                }
                this.bPG = null;
            }
            if (this.bPD != null) {
                this.bPC.eglTerminate(this.bPD);
                this.bPD = null;
            }
        }

        private void jE(String str) {
            M(str, this.bPC.eglGetError());
        }

        public static void M(String str, int i) {
            throw new RuntimeException(N(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, N(str2, i));
        }

        public static String N(String str, int i) {
            return str + " failed: " + com.baidu.tieba.b.d.b.ig(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean bPH;
        private boolean bPI;
        private boolean bPJ;
        private boolean bPK;
        private boolean bPL;
        private boolean bPM;
        private boolean bPN;
        private boolean bPO;
        private boolean bPP;
        private boolean bPQ;
        private boolean bPR;
        private boolean bPU;
        private WeakReference<c> bQq;
        private h bQr;
        private ArrayList<Runnable> bPV = new ArrayList<>();
        private boolean bPW = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bPT = true;
        private int bPS = 1;

        i(WeakReference<c> weakReference) {
            this.bQq = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Zf();
                    c.bQj.a(this);
                } catch (Exception e) {
                    af.vb().az(false);
                    c.bQj.a(this);
                }
            } catch (Throwable th) {
                c.bQj.a(this);
                throw th;
            }
        }

        private void Zd() {
            if (this.bPP) {
                this.bPP = false;
                this.bQr.Zb();
            }
        }

        private void Ze() {
            if (this.bPO) {
                this.bQr.finish();
                this.bPO = false;
                c.bQj.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Zf() throws InterruptedException {
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
            this.bQr = new h(this.bQq);
            this.bPO = false;
            this.bPP = false;
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
                    synchronized (c.bQj) {
                        while (!this.bPH) {
                            if (this.bPV.isEmpty()) {
                                if (this.bPK != this.bPJ) {
                                    boolean z23 = this.bPJ;
                                    this.bPK = this.bPJ;
                                    c.bQj.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bPR) {
                                    Zd();
                                    Ze();
                                    this.bPR = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    Zd();
                                    Ze();
                                    z19 = false;
                                }
                                if (z9 && this.bPP) {
                                    Zd();
                                }
                                if (z9 && this.bPO) {
                                    c cVar = this.bQq.get();
                                    if (!(cVar == null ? false : cVar.bPy) || c.bQj.Zl()) {
                                        Ze();
                                    }
                                }
                                if (z9 && c.bQj.Zm()) {
                                    this.bQr.finish();
                                }
                                if (!this.bPL && !this.bPN) {
                                    if (this.bPP) {
                                        Zd();
                                    }
                                    this.bPN = true;
                                    this.bPM = false;
                                    c.bQj.notifyAll();
                                }
                                if (this.bPL && this.bPN) {
                                    this.bPN = false;
                                    c.bQj.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bPU = true;
                                    c.bQj.notifyAll();
                                }
                                if (Zh()) {
                                    if (!this.bPO) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bQj.b(this)) {
                                            try {
                                                this.bQr.start();
                                                this.bPO = true;
                                                z15 = true;
                                                c.bQj.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bQj.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bPO || this.bPP) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bPP = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bPP) {
                                        if (this.bPW) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bPW = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bPT = false;
                                        c.bQj.notifyAll();
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
                                c.bQj.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bPV.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bQj) {
                            Zd();
                            Ze();
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
                        } else if (this.bQr.YY()) {
                            synchronized (c.bQj) {
                                this.bPQ = true;
                                c.bQj.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bQj) {
                                this.bPQ = true;
                                this.bPM = true;
                                c.bQj.notifyAll();
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
                            GL10 gl103 = (GL10) this.bQr.YZ();
                            c.bQj.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bQq.get();
                            if (cVar2 != null) {
                                cVar2.bPr.onSurfaceCreated(gl10, this.bQr.bPF);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bQq.get();
                            if (cVar3 != null) {
                                cVar3.bPr.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bQq.get();
                        if (cVar4 != null) {
                            cVar4.bPr.onDrawFrame(gl10);
                        }
                        int Za = this.bQr.Za();
                        switch (Za) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Za);
                                synchronized (c.bQj) {
                                    this.bPM = true;
                                    c.bQj.notifyAll();
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
                    synchronized (c.bQj) {
                        Zd();
                        Ze();
                        throw th;
                    }
                }
            }
        }

        public boolean Zg() {
            return this.bPO && this.bPP && Zh();
        }

        private boolean Zh() {
            return !this.bPK && this.bPL && !this.bPM && this.mWidth > 0 && this.mHeight > 0 && (this.bPT || this.bPS == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bQj) {
                    this.bPS = i;
                    c.bQj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bQj) {
                i = this.bPS;
            }
            return i;
        }

        public void Zi() {
            synchronized (c.bQj) {
                this.bPL = true;
                this.bPQ = false;
                c.bQj.notifyAll();
                while (this.bPN && !this.bPQ && !this.bPI) {
                    try {
                        c.bQj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bQj) {
                this.bPL = false;
                c.bQj.notifyAll();
                while (!this.bPN && !this.bPI) {
                    try {
                        c.bQj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (c.bQj) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bPW = true;
                this.bPT = true;
                this.bPU = false;
                c.bQj.notifyAll();
                while (!this.bPI && !this.bPK && !this.bPU && Zg()) {
                    try {
                        c.bQj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Zj() {
            synchronized (c.bQj) {
                this.bPH = true;
                c.bQj.notifyAll();
                while (!this.bPI) {
                    try {
                        c.bQj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Zk() {
            this.bPR = true;
            c.bQj.notifyAll();
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

    private void YW() {
        if (this.bQk != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bPY;
        private int bPZ;
        private boolean bQa;
        private boolean bQb;
        private boolean bQc;
        private i bQs;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bPI = true;
            if (this.bQs == iVar) {
                this.bQs = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bQs == iVar || this.bQs == null) {
                this.bQs = iVar;
                notifyAll();
                return true;
            }
            Zn();
            if (this.bQb) {
                return true;
            }
            if (this.bQs != null) {
                this.bQs.Zk();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bQs == iVar) {
                this.bQs = null;
            }
            notifyAll();
        }

        public synchronized boolean Zl() {
            return this.bQc;
        }

        public synchronized boolean Zm() {
            Zn();
            return !this.bQb;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bQa) {
                    Zn();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bPZ < 131072) {
                        this.bQb = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bQc = this.bQb ? false : true;
                    this.bQa = true;
                }
            }
        }

        private void Zn() {
            if (!this.bPY) {
                this.bQb = true;
                this.bPY = true;
            }
        }
    }
}
