package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.tbadk.core.util.ag;
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
    private static final j ctb = new j();
    private final WeakReference<TBGLSurfaceView> csi;
    private m csk;
    private int csp;
    private int csq;
    private boolean csr;
    private i ctc;
    private e ctd;
    private f cte;
    private g ctf;
    private k ctg;
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
        this.csi = new WeakReference<>(this);
        init();
    }

    public TBGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csi = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.ctc != null) {
                this.ctc.ahN();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.ctg = kVar;
    }

    public void setDebugFlags(int i2) {
        this.csp = i2;
    }

    public int getDebugFlags() {
        return this.csp;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.csr = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.csr;
    }

    public void setRenderer(m mVar) {
        ahA();
        if (this.ctd == null) {
            this.ctd = new n(true);
        }
        if (this.cte == null) {
            this.cte = new c();
        }
        if (this.ctf == null) {
            this.ctf = new d();
        }
        this.csk = mVar;
        this.ctc = new i(this.csi);
        this.ctc.start();
    }

    public void setEGLContextFactory(f fVar) {
        ahA();
        this.cte = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ahA();
        this.ctf = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ahA();
        this.ctd = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        ahA();
        this.csq = i2;
    }

    public void setRenderMode(int i2) {
        this.ctc.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.ctc.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.ctc.ahM();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.ctc.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.ctc.ak(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.csk != null) {
            int renderMode = this.ctc != null ? this.ctc.getRenderMode() : 1;
            this.ctc = new i(this.csi);
            if (renderMode != 1) {
                this.ctc.setRenderMode(renderMode);
            }
            this.ctc.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.ctc != null) {
            this.ctc.ahN();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, TBGLSurfaceView.this.csq, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TBGLSurfaceView.this.csq == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.Q("eglDestroyContex", egl10.eglGetError());
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
        protected int[] css;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.css = i(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.css, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.css, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] i(int[] iArr) {
            if (TBGLSurfaceView.this.csq == 2) {
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
        EGL10 csv;
        EGLDisplay csw;
        EGLSurface csx;
        EGLConfig csy;
        EGLContext csz;
        private WeakReference<TBGLSurfaceView> cti;

        public h(WeakReference<TBGLSurfaceView> weakReference) {
            this.cti = weakReference;
        }

        public void start() {
            this.csv = (EGL10) EGLContext.getEGL();
            this.csw = this.csv.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.csw == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.csv.eglInitialize(this.csw, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TBGLSurfaceView tBGLSurfaceView = this.cti.get();
            if (tBGLSurfaceView != null) {
                this.csy = tBGLSurfaceView.ctd.chooseConfig(this.csv, this.csw);
                this.csz = tBGLSurfaceView.cte.createContext(this.csv, this.csw, this.csy);
            } else {
                this.csy = null;
                this.csz = null;
            }
            if (this.csz == null || this.csz == EGL10.EGL_NO_CONTEXT) {
                this.csz = null;
                kS("createContext");
            }
            this.csx = null;
        }

        public boolean ahC() {
            if (this.csv == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.csw == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.csy == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ahG();
            TBGLSurfaceView tBGLSurfaceView = this.cti.get();
            if (tBGLSurfaceView != null) {
                this.csx = tBGLSurfaceView.ctf.createWindowSurface(this.csv, this.csw, this.csy, tBGLSurfaceView.getHolder());
            } else {
                this.csx = null;
            }
            if (this.csx == null || this.csx == EGL10.EGL_NO_SURFACE) {
                if (this.csv.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.csv.eglMakeCurrent(this.csw, this.csx, this.csx, this.csz)) {
                g("EGLHelper", "eglMakeCurrent", this.csv.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL ahD() {
            l lVar;
            GL gl = this.csz.getGL();
            TBGLSurfaceView tBGLSurfaceView = this.cti.get();
            if (tBGLSurfaceView != null) {
                if (tBGLSurfaceView.ctg != null) {
                    gl = tBGLSurfaceView.ctg.wrap(gl);
                }
                if ((tBGLSurfaceView.csp & 3) != 0) {
                    int i = 0;
                    if ((tBGLSurfaceView.csp & 1) != 0) {
                        i = 1;
                    }
                    if ((tBGLSurfaceView.csp & 2) == 0) {
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

        public int ahE() {
            if (this.csv.eglSwapBuffers(this.csw, this.csx)) {
                return 12288;
            }
            return this.csv.eglGetError();
        }

        public void ahF() {
            ahG();
        }

        private void ahG() {
            if (this.csx != null && this.csx != EGL10.EGL_NO_SURFACE) {
                this.csv.eglMakeCurrent(this.csw, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                TBGLSurfaceView tBGLSurfaceView = this.cti.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.ctf.destroySurface(this.csv, this.csw, this.csx);
                }
                this.csx = null;
            }
        }

        public void finish() {
            if (this.csz != null) {
                TBGLSurfaceView tBGLSurfaceView = this.cti.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cte.destroyContext(this.csv, this.csw, this.csz);
                }
                this.csz = null;
            }
            if (this.csw != null) {
                this.csv.eglTerminate(this.csw);
                this.csw = null;
            }
        }

        private void kS(String str) {
            Q(str, this.csv.eglGetError());
        }

        public static void Q(String str, int i) {
            throw new RuntimeException(R(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, R(str2, i));
        }

        public static String R(String str, int i) {
            return str + " failed: " + com.baidu.tieba.animation3d.View.a.iC(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean csA;
        private boolean csB;
        private boolean csC;
        private boolean csD;
        private boolean csE;
        private boolean csF;
        private boolean csG;
        private boolean csH;
        private boolean csI;
        private boolean csJ;
        private boolean csM;
        private WeakReference<TBGLSurfaceView> cti;
        private h ctj;
        private boolean mPaused;
        private ArrayList<Runnable> csN = new ArrayList<>();
        private boolean csO = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean csL = true;
        private int csK = 1;

        i(WeakReference<TBGLSurfaceView> weakReference) {
            this.cti = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ahJ();
                    TBGLSurfaceView.ctb.a(this);
                } catch (Exception e) {
                    ag.zl().aJ(false);
                    TBGLSurfaceView.ctb.a(this);
                }
            } catch (Throwable th) {
                TBGLSurfaceView.ctb.a(this);
                throw th;
            }
        }

        private void ahH() {
            if (this.csH) {
                this.csH = false;
                this.ctj.ahF();
            }
        }

        private void ahI() {
            if (this.csG) {
                this.ctj.finish();
                this.csG = false;
                TBGLSurfaceView.ctb.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void ahJ() throws InterruptedException {
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
            this.ctj = new h(this.cti);
            this.csG = false;
            this.csH = false;
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
                    synchronized (TBGLSurfaceView.ctb) {
                        while (!this.csA) {
                            if (this.csN.isEmpty()) {
                                if (this.mPaused != this.csC) {
                                    boolean z23 = this.csC;
                                    this.mPaused = this.csC;
                                    TBGLSurfaceView.ctb.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.csJ) {
                                    ahH();
                                    ahI();
                                    this.csJ = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    ahH();
                                    ahI();
                                    z19 = false;
                                }
                                if (z9 && this.csH) {
                                    ahH();
                                }
                                if (z9 && this.csG) {
                                    TBGLSurfaceView tBGLSurfaceView = this.cti.get();
                                    if (!(tBGLSurfaceView == null ? false : tBGLSurfaceView.csr) || TBGLSurfaceView.ctb.ahP()) {
                                        ahI();
                                    }
                                }
                                if (z9 && TBGLSurfaceView.ctb.ahQ()) {
                                    this.ctj.finish();
                                }
                                if (!this.csD && !this.csF) {
                                    if (this.csH) {
                                        ahH();
                                    }
                                    this.csF = true;
                                    this.csE = false;
                                    TBGLSurfaceView.ctb.notifyAll();
                                }
                                if (this.csD && this.csF) {
                                    this.csF = false;
                                    TBGLSurfaceView.ctb.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.csM = true;
                                    TBGLSurfaceView.ctb.notifyAll();
                                }
                                if (ahL()) {
                                    if (!this.csG) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (TBGLSurfaceView.ctb.b(this)) {
                                            try {
                                                this.ctj.start();
                                                this.csG = true;
                                                z15 = true;
                                                TBGLSurfaceView.ctb.notifyAll();
                                            } catch (RuntimeException e) {
                                                TBGLSurfaceView.ctb.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.csG || this.csH) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.csH = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.csH) {
                                        if (this.csO) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.csO = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.csL = false;
                                        TBGLSurfaceView.ctb.notifyAll();
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
                                TBGLSurfaceView.ctb.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.csN.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (TBGLSurfaceView.ctb) {
                            ahH();
                            ahI();
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
                        } else if (this.ctj.ahC()) {
                            synchronized (TBGLSurfaceView.ctb) {
                                this.csI = true;
                                TBGLSurfaceView.ctb.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (TBGLSurfaceView.ctb) {
                                this.csI = true;
                                this.csE = true;
                                TBGLSurfaceView.ctb.notifyAll();
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
                            GL10 gl103 = (GL10) this.ctj.ahD();
                            TBGLSurfaceView.ctb.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            TBGLSurfaceView tBGLSurfaceView2 = this.cti.get();
                            if (tBGLSurfaceView2 != null) {
                                tBGLSurfaceView2.csk.onSurfaceCreated(gl10, this.ctj.csy);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            TBGLSurfaceView tBGLSurfaceView3 = this.cti.get();
                            if (tBGLSurfaceView3 != null) {
                                tBGLSurfaceView3.csk.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        TBGLSurfaceView tBGLSurfaceView4 = this.cti.get();
                        if (tBGLSurfaceView4 != null) {
                            tBGLSurfaceView4.csk.onDrawFrame(gl10);
                        }
                        int ahE = this.ctj.ahE();
                        switch (ahE) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", ahE);
                                synchronized (TBGLSurfaceView.ctb) {
                                    this.csE = true;
                                    TBGLSurfaceView.ctb.notifyAll();
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
                    synchronized (TBGLSurfaceView.ctb) {
                        ahH();
                        ahI();
                        throw th;
                    }
                }
            }
        }

        public boolean ahK() {
            return this.csG && this.csH && ahL();
        }

        private boolean ahL() {
            return !this.mPaused && this.csD && !this.csE && this.mWidth > 0 && this.mHeight > 0 && (this.csL || this.csK == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (TBGLSurfaceView.ctb) {
                    this.csK = i;
                    TBGLSurfaceView.ctb.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (TBGLSurfaceView.ctb) {
                i = this.csK;
            }
            return i;
        }

        public void ahM() {
            synchronized (TBGLSurfaceView.ctb) {
                this.csD = true;
                this.csI = false;
                TBGLSurfaceView.ctb.notifyAll();
                while (this.csF && !this.csI && !this.csB) {
                    try {
                        TBGLSurfaceView.ctb.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (TBGLSurfaceView.ctb) {
                this.csD = false;
                TBGLSurfaceView.ctb.notifyAll();
                while (!this.csF && !this.csB) {
                    try {
                        TBGLSurfaceView.ctb.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (TBGLSurfaceView.ctb) {
                this.mWidth = i;
                this.mHeight = i2;
                this.csO = true;
                this.csL = true;
                this.csM = false;
                TBGLSurfaceView.ctb.notifyAll();
                while (!this.csB && !this.mPaused && !this.csM && ahK()) {
                    try {
                        TBGLSurfaceView.ctb.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ahN() {
            synchronized (TBGLSurfaceView.ctb) {
                this.csA = true;
                TBGLSurfaceView.ctb.notifyAll();
                while (!this.csB) {
                    try {
                        TBGLSurfaceView.ctb.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ahO() {
            this.csJ = true;
            TBGLSurfaceView.ctb.notifyAll();
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

    private void ahA() {
        if (this.ctc != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean csQ;
        private int csR;
        private boolean csS;
        private boolean csT;
        private boolean csU;
        private i ctk;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.csB = true;
            if (this.ctk == iVar) {
                this.ctk = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.ctk == iVar || this.ctk == null) {
                this.ctk = iVar;
                notifyAll();
                return true;
            }
            ahR();
            if (this.csT) {
                return true;
            }
            if (this.ctk != null) {
                this.ctk.ahO();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.ctk == iVar) {
                this.ctk = null;
            }
            notifyAll();
        }

        public synchronized boolean ahP() {
            return this.csU;
        }

        public synchronized boolean ahQ() {
            ahR();
            return !this.csT;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.csS) {
                    ahR();
                    String glGetString = gl10.glGetString(7937);
                    if (this.csR < 131072) {
                        this.csT = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.csU = this.csT ? false : true;
                    this.csS = true;
                }
            }
        }

        private void ahR() {
            if (!this.csQ) {
                this.csT = true;
                this.csQ = true;
            }
        }
    }
}
