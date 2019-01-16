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
    private static final j cVh = new j();
    private final WeakReference<TBGLSurfaceView> cUp;
    private m cUr;
    private int cUw;
    private int cUx;
    private boolean cUy;
    private i cVi;
    private e cVj;
    private f cVk;
    private g cVl;
    private k cVm;
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
        this.cUp = new WeakReference<>(this);
        init();
    }

    public TBGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUp = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cVi != null) {
                this.cVi.aqg();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.cVm = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cUw = i2;
    }

    public int getDebugFlags() {
        return this.cUw;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cUy = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cUy;
    }

    public void setRenderer(m mVar) {
        apS();
        if (this.cVj == null) {
            this.cVj = new n(true);
        }
        if (this.cVk == null) {
            this.cVk = new c();
        }
        if (this.cVl == null) {
            this.cVl = new d();
        }
        this.cUr = mVar;
        this.cVi = new i(this.cUp);
        this.cVi.start();
    }

    public void setEGLContextFactory(f fVar) {
        apS();
        this.cVk = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        apS();
        this.cVl = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        apS();
        this.cVj = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        apS();
        this.cUx = i2;
    }

    public void setRenderMode(int i2) {
        this.cVi.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cVi.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cVi.aqe();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cVi.aqf();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cVi.ay(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cUr != null) {
            int renderMode = this.cVi != null ? this.cVi.getRenderMode() : 1;
            this.cVi = new i(this.cUp);
            if (renderMode != 1) {
                this.cVi.setRenderMode(renderMode);
            }
            this.cVi.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cVi != null) {
            this.cVi.aqg();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, TBGLSurfaceView.this.cUx, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TBGLSurfaceView.this.cUx == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.X("eglDestroyContex", egl10.eglGetError());
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
        protected int[] cUz;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cUz = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cUz, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cUz, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (TBGLSurfaceView.this.cUx == 2) {
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
        EGL10 cUC;
        EGLDisplay cUD;
        EGLSurface cUE;
        EGLConfig cUF;
        EGLContext cUG;
        private WeakReference<TBGLSurfaceView> cVo;

        public h(WeakReference<TBGLSurfaceView> weakReference) {
            this.cVo = weakReference;
        }

        public void start() {
            this.cUC = (EGL10) EGLContext.getEGL();
            this.cUD = this.cUC.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cUD == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cUC.eglInitialize(this.cUD, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TBGLSurfaceView tBGLSurfaceView = this.cVo.get();
            if (tBGLSurfaceView != null) {
                this.cUF = tBGLSurfaceView.cVj.chooseConfig(this.cUC, this.cUD);
                this.cUG = tBGLSurfaceView.cVk.createContext(this.cUC, this.cUD, this.cUF);
            } else {
                this.cUF = null;
                this.cUG = null;
            }
            if (this.cUG == null || this.cUG == EGL10.EGL_NO_CONTEXT) {
                this.cUG = null;
                mR("createContext");
            }
            this.cUE = null;
        }

        public boolean apU() {
            if (this.cUC == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cUD == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cUF == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            apY();
            TBGLSurfaceView tBGLSurfaceView = this.cVo.get();
            if (tBGLSurfaceView != null) {
                this.cUE = tBGLSurfaceView.cVl.createWindowSurface(this.cUC, this.cUD, this.cUF, tBGLSurfaceView.getHolder());
            } else {
                this.cUE = null;
            }
            if (this.cUE == null || this.cUE == EGL10.EGL_NO_SURFACE) {
                if (this.cUC.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cUC.eglMakeCurrent(this.cUD, this.cUE, this.cUE, this.cUG)) {
                h("EGLHelper", "eglMakeCurrent", this.cUC.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL apV() {
            l lVar;
            GL gl = this.cUG.getGL();
            TBGLSurfaceView tBGLSurfaceView = this.cVo.get();
            if (tBGLSurfaceView != null) {
                if (tBGLSurfaceView.cVm != null) {
                    gl = tBGLSurfaceView.cVm.wrap(gl);
                }
                if ((tBGLSurfaceView.cUw & 3) != 0) {
                    int i = 0;
                    if ((tBGLSurfaceView.cUw & 1) != 0) {
                        i = 1;
                    }
                    if ((tBGLSurfaceView.cUw & 2) == 0) {
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

        public int apW() {
            if (this.cUC.eglSwapBuffers(this.cUD, this.cUE)) {
                return 12288;
            }
            return this.cUC.eglGetError();
        }

        public void apX() {
            apY();
        }

        private void apY() {
            if (this.cUE != null && this.cUE != EGL10.EGL_NO_SURFACE) {
                this.cUC.eglMakeCurrent(this.cUD, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                TBGLSurfaceView tBGLSurfaceView = this.cVo.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cVl.destroySurface(this.cUC, this.cUD, this.cUE);
                }
                this.cUE = null;
            }
        }

        public void finish() {
            if (this.cUG != null) {
                TBGLSurfaceView tBGLSurfaceView = this.cVo.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cVk.destroyContext(this.cUC, this.cUD, this.cUG);
                }
                this.cUG = null;
            }
            if (this.cUD != null) {
                this.cUC.eglTerminate(this.cUD);
                this.cUD = null;
            }
        }

        private void mR(String str) {
            X(str, this.cUC.eglGetError());
        }

        public static void X(String str, int i) {
            throw new RuntimeException(Y(str, i));
        }

        public static void h(String str, String str2, int i) {
            Log.w(str, Y(str2, i));
        }

        public static String Y(String str, int i) {
            return str + " failed: " + com.baidu.tieba.animation3d.View.a.kF(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean cUH;
        private boolean cUI;
        private boolean cUJ;
        private boolean cUK;
        private boolean cUL;
        private boolean cUM;
        private boolean cUN;
        private boolean cUO;
        private boolean cUP;
        private boolean cUQ;
        private boolean cUT;
        private WeakReference<TBGLSurfaceView> cVo;
        private h cVp;
        private boolean mPaused;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean cUU = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cUS = true;
        private int cUR = 1;

        i(WeakReference<TBGLSurfaceView> weakReference) {
            this.cVo = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aqb();
                    TBGLSurfaceView.cVh.a(this);
                } catch (Exception e) {
                    af.DK().bu(false);
                    TBGLSurfaceView.cVh.a(this);
                }
            } catch (Throwable th) {
                TBGLSurfaceView.cVh.a(this);
                throw th;
            }
        }

        private void apZ() {
            if (this.cUO) {
                this.cUO = false;
                this.cVp.apX();
            }
        }

        private void aqa() {
            if (this.cUN) {
                this.cVp.finish();
                this.cUN = false;
                TBGLSurfaceView.cVh.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aqb() throws InterruptedException {
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
            this.cVp = new h(this.cVo);
            this.cUN = false;
            this.cUO = false;
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
                    synchronized (TBGLSurfaceView.cVh) {
                        while (!this.cUH) {
                            if (this.mEventQueue.isEmpty()) {
                                if (this.mPaused != this.cUJ) {
                                    boolean z23 = this.cUJ;
                                    this.mPaused = this.cUJ;
                                    TBGLSurfaceView.cVh.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cUQ) {
                                    apZ();
                                    aqa();
                                    this.cUQ = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    apZ();
                                    aqa();
                                    z19 = false;
                                }
                                if (z9 && this.cUO) {
                                    apZ();
                                }
                                if (z9 && this.cUN) {
                                    TBGLSurfaceView tBGLSurfaceView = this.cVo.get();
                                    if (!(tBGLSurfaceView == null ? false : tBGLSurfaceView.cUy) || TBGLSurfaceView.cVh.aqi()) {
                                        aqa();
                                    }
                                }
                                if (z9 && TBGLSurfaceView.cVh.aqj()) {
                                    this.cVp.finish();
                                }
                                if (!this.cUK && !this.cUM) {
                                    if (this.cUO) {
                                        apZ();
                                    }
                                    this.cUM = true;
                                    this.cUL = false;
                                    TBGLSurfaceView.cVh.notifyAll();
                                }
                                if (this.cUK && this.cUM) {
                                    this.cUM = false;
                                    TBGLSurfaceView.cVh.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cUT = true;
                                    TBGLSurfaceView.cVh.notifyAll();
                                }
                                if (aqd()) {
                                    if (!this.cUN) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (TBGLSurfaceView.cVh.b(this)) {
                                            try {
                                                this.cVp.start();
                                                this.cUN = true;
                                                z15 = true;
                                                TBGLSurfaceView.cVh.notifyAll();
                                            } catch (RuntimeException e) {
                                                TBGLSurfaceView.cVh.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cUN || this.cUO) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cUO = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cUO) {
                                        if (this.cUU) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cUU = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cUS = false;
                                        TBGLSurfaceView.cVh.notifyAll();
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
                                TBGLSurfaceView.cVh.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.mEventQueue.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (TBGLSurfaceView.cVh) {
                            apZ();
                            aqa();
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
                        } else if (this.cVp.apU()) {
                            synchronized (TBGLSurfaceView.cVh) {
                                this.cUP = true;
                                TBGLSurfaceView.cVh.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (TBGLSurfaceView.cVh) {
                                this.cUP = true;
                                this.cUL = true;
                                TBGLSurfaceView.cVh.notifyAll();
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
                            GL10 gl103 = (GL10) this.cVp.apV();
                            TBGLSurfaceView.cVh.c(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            TBGLSurfaceView tBGLSurfaceView2 = this.cVo.get();
                            if (tBGLSurfaceView2 != null) {
                                tBGLSurfaceView2.cUr.onSurfaceCreated(gl10, this.cVp.cUF);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            TBGLSurfaceView tBGLSurfaceView3 = this.cVo.get();
                            if (tBGLSurfaceView3 != null) {
                                tBGLSurfaceView3.cUr.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        TBGLSurfaceView tBGLSurfaceView4 = this.cVo.get();
                        if (tBGLSurfaceView4 != null) {
                            tBGLSurfaceView4.cUr.onDrawFrame(gl10);
                        }
                        int apW = this.cVp.apW();
                        switch (apW) {
                            case 12288:
                                break;
                            case Statistics.kTypeWhiteScreen /* 12302 */:
                                z4 = true;
                                break;
                            default:
                                h.h("GLThread", "eglSwapBuffers", apW);
                                synchronized (TBGLSurfaceView.cVh) {
                                    this.cUL = true;
                                    TBGLSurfaceView.cVh.notifyAll();
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
                    synchronized (TBGLSurfaceView.cVh) {
                        apZ();
                        aqa();
                        throw th;
                    }
                }
            }
        }

        public boolean aqc() {
            return this.cUN && this.cUO && aqd();
        }

        private boolean aqd() {
            return !this.mPaused && this.cUK && !this.cUL && this.mWidth > 0 && this.mHeight > 0 && (this.cUS || this.cUR == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (TBGLSurfaceView.cVh) {
                    this.cUR = i;
                    TBGLSurfaceView.cVh.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (TBGLSurfaceView.cVh) {
                i = this.cUR;
            }
            return i;
        }

        public void aqe() {
            synchronized (TBGLSurfaceView.cVh) {
                this.cUK = true;
                this.cUP = false;
                TBGLSurfaceView.cVh.notifyAll();
                while (this.cUM && !this.cUP && !this.cUI) {
                    try {
                        TBGLSurfaceView.cVh.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqf() {
            synchronized (TBGLSurfaceView.cVh) {
                this.cUK = false;
                TBGLSurfaceView.cVh.notifyAll();
                while (!this.cUM && !this.cUI) {
                    try {
                        TBGLSurfaceView.cVh.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ay(int i, int i2) {
            synchronized (TBGLSurfaceView.cVh) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cUU = true;
                this.cUS = true;
                this.cUT = false;
                TBGLSurfaceView.cVh.notifyAll();
                while (!this.cUI && !this.mPaused && !this.cUT && aqc()) {
                    try {
                        TBGLSurfaceView.cVh.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqg() {
            synchronized (TBGLSurfaceView.cVh) {
                this.cUH = true;
                TBGLSurfaceView.cVh.notifyAll();
                while (!this.cUI) {
                    try {
                        TBGLSurfaceView.cVh.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqh() {
            this.cUQ = true;
            TBGLSurfaceView.cVh.notifyAll();
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

    private void apS() {
        if (this.cVi != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cUW;
        private int cUX;
        private boolean cUY;
        private boolean cUZ;
        private boolean cVa;
        private i cVq;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cUI = true;
            if (this.cVq == iVar) {
                this.cVq = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cVq == iVar || this.cVq == null) {
                this.cVq = iVar;
                notifyAll();
                return true;
            }
            aqk();
            if (this.cUZ) {
                return true;
            }
            if (this.cVq != null) {
                this.cVq.aqh();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cVq == iVar) {
                this.cVq = null;
            }
            notifyAll();
        }

        public synchronized boolean aqi() {
            return this.cVa;
        }

        public synchronized boolean aqj() {
            aqk();
            return !this.cUZ;
        }

        public synchronized void c(GL10 gl10) {
            synchronized (this) {
                if (!this.cUY) {
                    aqk();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cUX < 131072) {
                        this.cUZ = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cVa = this.cUZ ? false : true;
                    this.cUY = true;
                }
            }
        }

        private void aqk() {
            if (!this.cUW) {
                this.cUZ = true;
                this.cUW = true;
            }
        }
    }
}
