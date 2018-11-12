package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.tbadk.core.util.af;
import com.baidu.webkit.internal.Statistics;
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
public class TBGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final j cKZ = new j();
    private final WeakReference<TBGLSurfaceView> cKg;
    private m cKi;
    private int cKn;
    private int cKo;
    private boolean cKp;
    private i cLa;
    private e cLb;
    private f cLc;
    private g cLd;
    private k cLe;
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

    public TBGLSurfaceView(Context context) {
        super(context);
        this.cKg = new WeakReference<>(this);
        init();
    }

    public TBGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKg = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cLa != null) {
                this.cLa.anh();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.cLe = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cKn = i2;
    }

    public int getDebugFlags() {
        return this.cKn;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cKp = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cKp;
    }

    public void setRenderer(m mVar) {
        amT();
        if (this.cLb == null) {
            this.cLb = new n(true);
        }
        if (this.cLc == null) {
            this.cLc = new c();
        }
        if (this.cLd == null) {
            this.cLd = new d();
        }
        this.cKi = mVar;
        this.cLa = new i(this.cKg);
        this.cLa.start();
    }

    public void setEGLContextFactory(f fVar) {
        amT();
        this.cLc = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        amT();
        this.cLd = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        amT();
        this.cLb = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        amT();
        this.cKo = i2;
    }

    public void setRenderMode(int i2) {
        this.cLa.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cLa.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cLa.anf();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cLa.ang();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cLa.aw(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cKi != null) {
            int renderMode = this.cLa != null ? this.cLa.getRenderMode() : 1;
            this.cLa = new i(this.cKg);
            if (renderMode != 1) {
                this.cLa.setRenderMode(renderMode);
            }
            this.cLa.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cLa != null) {
            this.cLa.anh();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* loaded from: classes.dex */
    private class c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, TBGLSurfaceView.this.cKo, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TBGLSurfaceView.this.cKo == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.V("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements g {
        private d() {
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes.dex */
    private abstract class a implements e {
        protected int[] cKq;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cKq = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cKq, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cKq, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (TBGLSurfaceView.this.cKo == 2) {
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

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.a
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
        EGL10 cKt;
        EGLDisplay cKu;
        EGLSurface cKv;
        EGLConfig cKw;
        EGLContext cKx;
        private WeakReference<TBGLSurfaceView> cLg;

        public h(WeakReference<TBGLSurfaceView> weakReference) {
            this.cLg = weakReference;
        }

        public void start() {
            this.cKt = (EGL10) EGLContext.getEGL();
            this.cKu = this.cKt.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cKu == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cKt.eglInitialize(this.cKu, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TBGLSurfaceView tBGLSurfaceView = this.cLg.get();
            if (tBGLSurfaceView != null) {
                this.cKw = tBGLSurfaceView.cLb.chooseConfig(this.cKt, this.cKu);
                this.cKx = tBGLSurfaceView.cLc.createContext(this.cKt, this.cKu, this.cKw);
            } else {
                this.cKw = null;
                this.cKx = null;
            }
            if (this.cKx == null || this.cKx == EGL10.EGL_NO_CONTEXT) {
                this.cKx = null;
                lZ("createContext");
            }
            this.cKv = null;
        }

        public boolean amV() {
            if (this.cKt == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cKu == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cKw == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            amZ();
            TBGLSurfaceView tBGLSurfaceView = this.cLg.get();
            if (tBGLSurfaceView != null) {
                this.cKv = tBGLSurfaceView.cLd.createWindowSurface(this.cKt, this.cKu, this.cKw, tBGLSurfaceView.getHolder());
            } else {
                this.cKv = null;
            }
            if (this.cKv == null || this.cKv == EGL10.EGL_NO_SURFACE) {
                if (this.cKt.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cKt.eglMakeCurrent(this.cKu, this.cKv, this.cKv, this.cKx)) {
                g("EGLHelper", "eglMakeCurrent", this.cKt.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL amW() {
            l lVar;
            GL gl = this.cKx.getGL();
            TBGLSurfaceView tBGLSurfaceView = this.cLg.get();
            if (tBGLSurfaceView != null) {
                if (tBGLSurfaceView.cLe != null) {
                    gl = tBGLSurfaceView.cLe.wrap(gl);
                }
                if ((tBGLSurfaceView.cKn & 3) != 0) {
                    int i = 0;
                    if ((tBGLSurfaceView.cKn & 1) != 0) {
                        i = 1;
                    }
                    if ((tBGLSurfaceView.cKn & 2) == 0) {
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

        public int amX() {
            if (this.cKt.eglSwapBuffers(this.cKu, this.cKv)) {
                return 12288;
            }
            return this.cKt.eglGetError();
        }

        public void amY() {
            amZ();
        }

        private void amZ() {
            if (this.cKv != null && this.cKv != EGL10.EGL_NO_SURFACE) {
                this.cKt.eglMakeCurrent(this.cKu, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                TBGLSurfaceView tBGLSurfaceView = this.cLg.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cLd.destroySurface(this.cKt, this.cKu, this.cKv);
                }
                this.cKv = null;
            }
        }

        public void finish() {
            if (this.cKx != null) {
                TBGLSurfaceView tBGLSurfaceView = this.cLg.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cLc.destroyContext(this.cKt, this.cKu, this.cKx);
                }
                this.cKx = null;
            }
            if (this.cKu != null) {
                this.cKt.eglTerminate(this.cKu);
                this.cKu = null;
            }
        }

        private void lZ(String str) {
            V(str, this.cKt.eglGetError());
        }

        public static void V(String str, int i) {
            throw new RuntimeException(W(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, W(str2, i));
        }

        public static String W(String str, int i) {
            return str + " failed: " + com.baidu.tieba.animation3d.View.a.kd(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean cKA;
        private boolean cKB;
        private boolean cKC;
        private boolean cKD;
        private boolean cKE;
        private boolean cKF;
        private boolean cKG;
        private boolean cKH;
        private boolean cKK;
        private boolean cKy;
        private boolean cKz;
        private WeakReference<TBGLSurfaceView> cLg;
        private h cLh;
        private boolean mPaused;
        private ArrayList<Runnable> cKL = new ArrayList<>();
        private boolean cKM = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cKJ = true;
        private int cKI = 1;

        i(WeakReference<TBGLSurfaceView> weakReference) {
            this.cLg = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    anc();
                    TBGLSurfaceView.cKZ.a(this);
                } catch (Exception e) {
                    af.Ct().bs(false);
                    TBGLSurfaceView.cKZ.a(this);
                }
            } catch (Throwable th) {
                TBGLSurfaceView.cKZ.a(this);
                throw th;
            }
        }

        private void ana() {
            if (this.cKF) {
                this.cKF = false;
                this.cLh.amY();
            }
        }

        private void anb() {
            if (this.cKE) {
                this.cLh.finish();
                this.cKE = false;
                TBGLSurfaceView.cKZ.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void anc() throws InterruptedException {
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
            this.cLh = new h(this.cLg);
            this.cKE = false;
            this.cKF = false;
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
                    synchronized (TBGLSurfaceView.cKZ) {
                        while (!this.cKy) {
                            if (this.cKL.isEmpty()) {
                                if (this.mPaused != this.cKA) {
                                    boolean z23 = this.cKA;
                                    this.mPaused = this.cKA;
                                    TBGLSurfaceView.cKZ.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cKH) {
                                    ana();
                                    anb();
                                    this.cKH = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    ana();
                                    anb();
                                    z19 = false;
                                }
                                if (z9 && this.cKF) {
                                    ana();
                                }
                                if (z9 && this.cKE) {
                                    TBGLSurfaceView tBGLSurfaceView = this.cLg.get();
                                    if (!(tBGLSurfaceView == null ? false : tBGLSurfaceView.cKp) || TBGLSurfaceView.cKZ.anj()) {
                                        anb();
                                    }
                                }
                                if (z9 && TBGLSurfaceView.cKZ.ank()) {
                                    this.cLh.finish();
                                }
                                if (!this.cKB && !this.cKD) {
                                    if (this.cKF) {
                                        ana();
                                    }
                                    this.cKD = true;
                                    this.cKC = false;
                                    TBGLSurfaceView.cKZ.notifyAll();
                                }
                                if (this.cKB && this.cKD) {
                                    this.cKD = false;
                                    TBGLSurfaceView.cKZ.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cKK = true;
                                    TBGLSurfaceView.cKZ.notifyAll();
                                }
                                if (ane()) {
                                    if (!this.cKE) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (TBGLSurfaceView.cKZ.b(this)) {
                                            try {
                                                this.cLh.start();
                                                this.cKE = true;
                                                z15 = true;
                                                TBGLSurfaceView.cKZ.notifyAll();
                                            } catch (RuntimeException e) {
                                                TBGLSurfaceView.cKZ.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cKE || this.cKF) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cKF = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cKF) {
                                        if (this.cKM) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cKM = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cKJ = false;
                                        TBGLSurfaceView.cKZ.notifyAll();
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
                                TBGLSurfaceView.cKZ.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cKL.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (TBGLSurfaceView.cKZ) {
                            ana();
                            anb();
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
                        } else if (this.cLh.amV()) {
                            synchronized (TBGLSurfaceView.cKZ) {
                                this.cKG = true;
                                TBGLSurfaceView.cKZ.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (TBGLSurfaceView.cKZ) {
                                this.cKG = true;
                                this.cKC = true;
                                TBGLSurfaceView.cKZ.notifyAll();
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
                            GL10 gl103 = (GL10) this.cLh.amW();
                            TBGLSurfaceView.cKZ.c(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            TBGLSurfaceView tBGLSurfaceView2 = this.cLg.get();
                            if (tBGLSurfaceView2 != null) {
                                tBGLSurfaceView2.cKi.onSurfaceCreated(gl10, this.cLh.cKw);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            TBGLSurfaceView tBGLSurfaceView3 = this.cLg.get();
                            if (tBGLSurfaceView3 != null) {
                                tBGLSurfaceView3.cKi.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        TBGLSurfaceView tBGLSurfaceView4 = this.cLg.get();
                        if (tBGLSurfaceView4 != null) {
                            tBGLSurfaceView4.cKi.onDrawFrame(gl10);
                        }
                        int amX = this.cLh.amX();
                        switch (amX) {
                            case 12288:
                                break;
                            case Statistics.kTypeWhiteScreen /* 12302 */:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", amX);
                                synchronized (TBGLSurfaceView.cKZ) {
                                    this.cKC = true;
                                    TBGLSurfaceView.cKZ.notifyAll();
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
                    synchronized (TBGLSurfaceView.cKZ) {
                        ana();
                        anb();
                        throw th;
                    }
                }
            }
        }

        public boolean and() {
            return this.cKE && this.cKF && ane();
        }

        private boolean ane() {
            return !this.mPaused && this.cKB && !this.cKC && this.mWidth > 0 && this.mHeight > 0 && (this.cKJ || this.cKI == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (TBGLSurfaceView.cKZ) {
                    this.cKI = i;
                    TBGLSurfaceView.cKZ.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (TBGLSurfaceView.cKZ) {
                i = this.cKI;
            }
            return i;
        }

        public void anf() {
            synchronized (TBGLSurfaceView.cKZ) {
                this.cKB = true;
                this.cKG = false;
                TBGLSurfaceView.cKZ.notifyAll();
                while (this.cKD && !this.cKG && !this.cKz) {
                    try {
                        TBGLSurfaceView.cKZ.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ang() {
            synchronized (TBGLSurfaceView.cKZ) {
                this.cKB = false;
                TBGLSurfaceView.cKZ.notifyAll();
                while (!this.cKD && !this.cKz) {
                    try {
                        TBGLSurfaceView.cKZ.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aw(int i, int i2) {
            synchronized (TBGLSurfaceView.cKZ) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cKM = true;
                this.cKJ = true;
                this.cKK = false;
                TBGLSurfaceView.cKZ.notifyAll();
                while (!this.cKz && !this.mPaused && !this.cKK && and()) {
                    try {
                        TBGLSurfaceView.cKZ.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void anh() {
            synchronized (TBGLSurfaceView.cKZ) {
                this.cKy = true;
                TBGLSurfaceView.cKZ.notifyAll();
                while (!this.cKz) {
                    try {
                        TBGLSurfaceView.cKZ.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ani() {
            this.cKH = true;
            TBGLSurfaceView.cKZ.notifyAll();
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

    private void amT() {
        if (this.cLa != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cKO;
        private int cKP;
        private boolean cKQ;
        private boolean cKR;
        private boolean cKS;
        private i cLi;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cKz = true;
            if (this.cLi == iVar) {
                this.cLi = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cLi == iVar || this.cLi == null) {
                this.cLi = iVar;
                notifyAll();
                return true;
            }
            anl();
            if (this.cKR) {
                return true;
            }
            if (this.cLi != null) {
                this.cLi.ani();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cLi == iVar) {
                this.cLi = null;
            }
            notifyAll();
        }

        public synchronized boolean anj() {
            return this.cKS;
        }

        public synchronized boolean ank() {
            anl();
            return !this.cKR;
        }

        public synchronized void c(GL10 gl10) {
            synchronized (this) {
                if (!this.cKQ) {
                    anl();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cKP < 131072) {
                        this.cKR = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cKS = this.cKR ? false : true;
                    this.cKQ = true;
                }
            }
        }

        private void anl() {
            if (!this.cKO) {
                this.cKR = true;
                this.cKO = true;
            }
        }
    }
}
