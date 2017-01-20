package com.baidu.tieba.b.d;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.tbadk.core.util.ah;
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
    private static final j bjj = new j(null);
    private final WeakReference<c> bip;
    private m bir;
    private int biw;
    private int bix;
    private boolean biy;
    private i bjk;
    private e bjl;
    private f bjm;
    private g bjn;
    private k bjo;
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

    public c(Context context) {
        super(context);
        this.bip = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bjk != null) {
                this.bjk.QC();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.bjo = kVar;
    }

    public void setDebugFlags(int i2) {
        this.biw = i2;
    }

    public int getDebugFlags() {
        return this.biw;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.biy = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.biy;
    }

    public void setRenderer(m mVar) {
        Qo();
        if (this.bjl == null) {
            this.bjl = new n(true);
        }
        if (this.bjm == null) {
            this.bjm = new C0055c(this, null);
        }
        if (this.bjn == null) {
            this.bjn = new d(null);
        }
        this.bir = mVar;
        this.bjk = new i(this.bip);
        this.bjk.start();
    }

    public void setEGLContextFactory(f fVar) {
        Qo();
        this.bjm = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Qo();
        this.bjn = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Qo();
        this.bjl = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        Qo();
        this.bix = i2;
    }

    public void setRenderMode(int i2) {
        this.bjk.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bjk.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bjk.QA();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bjk.QB();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bjk.S(i3, i4);
    }

    public void onPause() {
        this.bjk.onPause();
    }

    public void onResume() {
        this.bjk.onResume();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bir != null) {
            int renderMode = this.bjk != null ? this.bjk.getRenderMode() : 1;
            this.bjk = new i(this.bip);
            if (renderMode != 1) {
                this.bjk.setRenderMode(renderMode);
            }
            this.bjk.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bjk != null) {
            this.bjk.QC();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0055c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0055c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ C0055c(c cVar, C0055c c0055c) {
            this();
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bix, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bix == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.c.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.I("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements g {
        private d() {
        }

        /* synthetic */ d(d dVar) {
            this();
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
        protected int[] biz;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.biz = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.biz, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.biz, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (c.this.bix == 2) {
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
        EGL10 biC;
        EGLDisplay biD;
        EGLSurface biE;
        EGLConfig biF;
        EGLContext biG;
        private WeakReference<c> bjq;

        public h(WeakReference<c> weakReference) {
            this.bjq = weakReference;
        }

        public void start() {
            this.biC = (EGL10) EGLContext.getEGL();
            this.biD = this.biC.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.biD == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.biC.eglInitialize(this.biD, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bjq.get();
            if (cVar == null) {
                this.biF = null;
                this.biG = null;
            } else {
                this.biF = cVar.bjl.chooseConfig(this.biC, this.biD);
                this.biG = cVar.bjm.createContext(this.biC, this.biD, this.biF);
            }
            if (this.biG == null || this.biG == EGL10.EGL_NO_CONTEXT) {
                this.biG = null;
                hY("createContext");
            }
            this.biE = null;
        }

        public boolean Qq() {
            if (this.biC == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.biD == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.biF == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Qu();
            c cVar = this.bjq.get();
            if (cVar != null) {
                this.biE = cVar.bjn.createWindowSurface(this.biC, this.biD, this.biF, cVar.getHolder());
            } else {
                this.biE = null;
            }
            if (this.biE == null || this.biE == EGL10.EGL_NO_SURFACE) {
                if (this.biC.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.biC.eglMakeCurrent(this.biD, this.biE, this.biE, this.biG)) {
                f("EGLHelper", "eglMakeCurrent", this.biC.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Qr() {
            l lVar;
            GL gl = this.biG.getGL();
            c cVar = this.bjq.get();
            if (cVar == null) {
                return gl;
            }
            if (cVar.bjo != null) {
                gl = cVar.bjo.wrap(gl);
            }
            if ((cVar.biw & 3) != 0) {
                int i = 0;
                if ((cVar.biw & 1) != 0) {
                    i = 1;
                }
                if ((cVar.biw & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Qs() {
            if (this.biC.eglSwapBuffers(this.biD, this.biE)) {
                return 12288;
            }
            return this.biC.eglGetError();
        }

        public void Qt() {
            Qu();
        }

        private void Qu() {
            if (this.biE != null && this.biE != EGL10.EGL_NO_SURFACE) {
                this.biC.eglMakeCurrent(this.biD, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bjq.get();
                if (cVar != null) {
                    cVar.bjn.destroySurface(this.biC, this.biD, this.biE);
                }
                this.biE = null;
            }
        }

        public void finish() {
            if (this.biG != null) {
                c cVar = this.bjq.get();
                if (cVar != null) {
                    cVar.bjm.destroyContext(this.biC, this.biD, this.biG);
                }
                this.biG = null;
            }
            if (this.biD != null) {
                this.biC.eglTerminate(this.biD);
                this.biD = null;
            }
        }

        private void hY(String str) {
            I(str, this.biC.eglGetError());
        }

        public static void I(String str, int i) {
            throw new RuntimeException(J(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, J(str2, i));
        }

        public static String J(String str, int i) {
            return String.valueOf(str) + " failed: " + com.baidu.tieba.b.d.b.gF(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean biH;
        private boolean biI;
        private boolean biJ;
        private boolean biK;
        private boolean biL;
        private boolean biM;
        private boolean biN;
        private boolean biO;
        private boolean biP;
        private boolean biQ;
        private boolean biR;
        private boolean biU;
        private WeakReference<c> bjq;
        private h bjr;
        private ArrayList<Runnable> biV = new ArrayList<>();
        private boolean biW = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean biT = true;
        private int biS = 1;

        i(WeakReference<c> weakReference) {
            this.bjq = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Qx();
                    c.bjj.a(this);
                } catch (Exception e) {
                    ah.uP().aE(false);
                    c.bjj.a(this);
                }
            } catch (Throwable th) {
                c.bjj.a(this);
                throw th;
            }
        }

        private void Qv() {
            if (this.biP) {
                this.biP = false;
                this.bjr.Qt();
            }
        }

        private void Qw() {
            if (this.biO) {
                this.bjr.finish();
                this.biO = false;
                c.bjj.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1396=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Qx() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            int i;
            int i2;
            Runnable remove;
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
            this.bjr = new h(this.bjq);
            this.biO = false;
            this.biP = false;
            boolean z15 = false;
            GL10 gl102 = null;
            Runnable runnable = null;
            int i5 = 0;
            int i6 = 0;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            boolean z20 = false;
            boolean z21 = false;
            boolean z22 = false;
            while (true) {
                try {
                    synchronized (c.bjj) {
                        while (!this.biH) {
                            if (this.biV.isEmpty()) {
                                if (this.biK != this.biJ) {
                                    boolean z23 = this.biJ;
                                    this.biK = this.biJ;
                                    c.bjj.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.biR) {
                                    Qv();
                                    Qw();
                                    this.biR = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Qv();
                                    Qw();
                                    z20 = false;
                                }
                                if (z9 && this.biP) {
                                    Qv();
                                }
                                if (z9 && this.biO) {
                                    c cVar = this.bjq.get();
                                    if (!(cVar == null ? false : cVar.biy) || c.bjj.QE()) {
                                        Qw();
                                    }
                                }
                                if (z9 && c.bjj.QF()) {
                                    this.bjr.finish();
                                }
                                if (!this.biL && !this.biN) {
                                    if (this.biP) {
                                        Qv();
                                    }
                                    this.biN = true;
                                    this.biM = false;
                                    c.bjj.notifyAll();
                                }
                                if (this.biL && this.biN) {
                                    this.biN = false;
                                    c.bjj.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.biU = true;
                                    c.bjj.notifyAll();
                                }
                                if (Qz()) {
                                    if (!this.biO) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bjj.b(this)) {
                                            try {
                                                this.bjr.start();
                                                this.biO = true;
                                                z15 = true;
                                                c.bjj.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bjj.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.biO || this.biP) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.biP = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.biP) {
                                        if (this.biW) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.biW = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.biT = false;
                                        c.bjj.notifyAll();
                                        z2 = z11;
                                        z5 = z13;
                                        i2 = i3;
                                        z = z12;
                                        z3 = z20;
                                        z4 = z14;
                                        z6 = z17;
                                        z7 = z16;
                                        i = i4;
                                        remove = runnable;
                                    } else {
                                        z21 = z11;
                                        z19 = z10;
                                    }
                                }
                                c.bjj.wait();
                            } else {
                                z = z22;
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i = i6;
                                i2 = i5;
                                remove = this.biV.remove(0);
                            }
                        }
                        synchronized (c.bjj) {
                            Qv();
                            Qw();
                        }
                        return;
                    }
                    if (remove != null) {
                        remove.run();
                        runnable = null;
                        i5 = i2;
                        i6 = i;
                        z16 = z7;
                        z17 = z6;
                        z18 = z5;
                        z19 = z4;
                        z20 = z3;
                        z21 = z2;
                        z22 = z;
                    } else {
                        if (!z) {
                            z8 = z;
                        } else if (this.bjr.Qq()) {
                            synchronized (c.bjj) {
                                this.biQ = true;
                                c.bjj.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bjj) {
                                this.biQ = true;
                                this.biM = true;
                                c.bjj.notifyAll();
                            }
                            runnable = remove;
                            i5 = i2;
                            i6 = i;
                            z16 = z7;
                            z17 = z6;
                            z18 = z5;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            z22 = z;
                        }
                        if (z2) {
                            GL10 gl103 = (GL10) this.bjr.Qr();
                            c.bjj.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bjq.get();
                            if (cVar2 != null) {
                                cVar2.bir.onSurfaceCreated(gl10, this.bjr.biF);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            c cVar3 = this.bjq.get();
                            if (cVar3 != null) {
                                cVar3.bir.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        c cVar4 = this.bjq.get();
                        if (cVar4 != null) {
                            cVar4.bir.onDrawFrame(gl10);
                        }
                        int Qs = this.bjr.Qs();
                        switch (Qs) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Qs);
                                synchronized (c.bjj) {
                                    this.biM = true;
                                    c.bjj.notifyAll();
                                    break;
                                }
                        }
                        if (z5) {
                            gl102 = gl10;
                            int i8 = i2;
                            i6 = i;
                            z16 = z7;
                            z17 = true;
                            z18 = z5;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            z22 = z8;
                            runnable = remove;
                            i5 = i8;
                        } else {
                            gl102 = gl10;
                            int i9 = i2;
                            i6 = i;
                            z16 = z7;
                            z17 = z6;
                            z18 = z5;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            z22 = z8;
                            runnable = remove;
                            i5 = i9;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (c.bjj) {
                        Qv();
                        Qw();
                        throw th;
                    }
                }
            }
        }

        public boolean Qy() {
            return this.biO && this.biP && Qz();
        }

        private boolean Qz() {
            return !this.biK && this.biL && !this.biM && this.mWidth > 0 && this.mHeight > 0 && (this.biT || this.biS == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (c.bjj) {
                this.biS = i;
                c.bjj.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bjj) {
                i = this.biS;
            }
            return i;
        }

        public void QA() {
            synchronized (c.bjj) {
                this.biL = true;
                this.biQ = false;
                c.bjj.notifyAll();
                while (this.biN && !this.biQ && !this.biI) {
                    try {
                        c.bjj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void QB() {
            synchronized (c.bjj) {
                this.biL = false;
                c.bjj.notifyAll();
                while (!this.biN && !this.biI) {
                    try {
                        c.bjj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (c.bjj) {
                this.biJ = true;
                c.bjj.notifyAll();
                while (!this.biI && !this.biK) {
                    try {
                        c.bjj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (c.bjj) {
                this.biJ = false;
                this.biT = true;
                this.biU = false;
                c.bjj.notifyAll();
                while (!this.biI && this.biK && !this.biU) {
                    try {
                        c.bjj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void S(int i, int i2) {
            synchronized (c.bjj) {
                this.mWidth = i;
                this.mHeight = i2;
                this.biW = true;
                this.biT = true;
                this.biU = false;
                c.bjj.notifyAll();
                while (!this.biI && !this.biK && !this.biU && Qy()) {
                    try {
                        c.bjj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void QC() {
            synchronized (c.bjj) {
                this.biH = true;
                c.bjj.notifyAll();
                while (!this.biI) {
                    try {
                        c.bjj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void QD() {
            this.biR = true;
            c.bjj.notifyAll();
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

    private void Qo() {
        if (this.bjk != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean biY;
        private int biZ;
        private boolean bja;
        private boolean bjb;
        private boolean bjc;
        private i bjs;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.biI = true;
            if (this.bjs == iVar) {
                this.bjs = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bjs == iVar || this.bjs == null) {
                this.bjs = iVar;
                notifyAll();
                return true;
            }
            QG();
            if (this.bjb) {
                return true;
            }
            if (this.bjs != null) {
                this.bjs.QD();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bjs == iVar) {
                this.bjs = null;
            }
            notifyAll();
        }

        public synchronized boolean QE() {
            return this.bjc;
        }

        public synchronized boolean QF() {
            QG();
            return !this.bjb;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bja) {
                    QG();
                    String glGetString = gl10.glGetString(7937);
                    if (this.biZ < 131072) {
                        this.bjb = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bjc = this.bjb ? false : true;
                    this.bja = true;
                }
            }
        }

        private void QG() {
            if (!this.biY) {
                this.bjb = true;
                this.biY = true;
            }
        }
    }
}
