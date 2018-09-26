package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
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
public class TBGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final j cBr = new j();
    private m cAA;
    private int cAF;
    private int cAG;
    private boolean cAH;
    private final WeakReference<TBGLSurfaceView> cAy;
    private i cBs;
    private e cBt;
    private f cBu;
    private g cBv;
    private k cBw;
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
        this.cAy = new WeakReference<>(this);
        init();
    }

    public TBGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAy = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cBs != null) {
                this.cBs.akb();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.cBw = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cAF = i2;
    }

    public int getDebugFlags() {
        return this.cAF;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cAH = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cAH;
    }

    public void setRenderer(m mVar) {
        ajO();
        if (this.cBt == null) {
            this.cBt = new n(true);
        }
        if (this.cBu == null) {
            this.cBu = new c();
        }
        if (this.cBv == null) {
            this.cBv = new d();
        }
        this.cAA = mVar;
        this.cBs = new i(this.cAy);
        this.cBs.start();
    }

    public void setEGLContextFactory(f fVar) {
        ajO();
        this.cBu = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ajO();
        this.cBv = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ajO();
        this.cBt = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        ajO();
        this.cAG = i2;
    }

    public void setRenderMode(int i2) {
        this.cBs.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cBs.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cBs.aka();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cBs.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cBs.ar(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cAA != null) {
            int renderMode = this.cBs != null ? this.cBs.getRenderMode() : 1;
            this.cBs = new i(this.cAy);
            if (renderMode != 1) {
                this.cBs.setRenderMode(renderMode);
            }
            this.cBs.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cBs != null) {
            this.cBs.akb();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, TBGLSurfaceView.this.cAG, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TBGLSurfaceView.this.cAG == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.R("eglDestroyContex", egl10.eglGetError());
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
        protected int[] cAI;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cAI = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cAI, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cAI, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (TBGLSurfaceView.this.cAG == 2) {
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
        EGL10 cAL;
        EGLDisplay cAM;
        EGLSurface cAN;
        EGLConfig cAO;
        EGLContext cAP;
        private WeakReference<TBGLSurfaceView> cBy;

        public h(WeakReference<TBGLSurfaceView> weakReference) {
            this.cBy = weakReference;
        }

        public void start() {
            this.cAL = (EGL10) EGLContext.getEGL();
            this.cAM = this.cAL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cAM == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cAL.eglInitialize(this.cAM, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TBGLSurfaceView tBGLSurfaceView = this.cBy.get();
            if (tBGLSurfaceView != null) {
                this.cAO = tBGLSurfaceView.cBt.chooseConfig(this.cAL, this.cAM);
                this.cAP = tBGLSurfaceView.cBu.createContext(this.cAL, this.cAM, this.cAO);
            } else {
                this.cAO = null;
                this.cAP = null;
            }
            if (this.cAP == null || this.cAP == EGL10.EGL_NO_CONTEXT) {
                this.cAP = null;
                lu("createContext");
            }
            this.cAN = null;
        }

        public boolean ajQ() {
            if (this.cAL == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cAM == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cAO == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ajU();
            TBGLSurfaceView tBGLSurfaceView = this.cBy.get();
            if (tBGLSurfaceView != null) {
                this.cAN = tBGLSurfaceView.cBv.createWindowSurface(this.cAL, this.cAM, this.cAO, tBGLSurfaceView.getHolder());
            } else {
                this.cAN = null;
            }
            if (this.cAN == null || this.cAN == EGL10.EGL_NO_SURFACE) {
                if (this.cAL.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cAL.eglMakeCurrent(this.cAM, this.cAN, this.cAN, this.cAP)) {
                g("EGLHelper", "eglMakeCurrent", this.cAL.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL ajR() {
            l lVar;
            GL gl = this.cAP.getGL();
            TBGLSurfaceView tBGLSurfaceView = this.cBy.get();
            if (tBGLSurfaceView != null) {
                if (tBGLSurfaceView.cBw != null) {
                    gl = tBGLSurfaceView.cBw.wrap(gl);
                }
                if ((tBGLSurfaceView.cAF & 3) != 0) {
                    int i = 0;
                    if ((tBGLSurfaceView.cAF & 1) != 0) {
                        i = 1;
                    }
                    if ((tBGLSurfaceView.cAF & 2) == 0) {
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

        public int ajS() {
            if (this.cAL.eglSwapBuffers(this.cAM, this.cAN)) {
                return 12288;
            }
            return this.cAL.eglGetError();
        }

        public void ajT() {
            ajU();
        }

        private void ajU() {
            if (this.cAN != null && this.cAN != EGL10.EGL_NO_SURFACE) {
                this.cAL.eglMakeCurrent(this.cAM, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                TBGLSurfaceView tBGLSurfaceView = this.cBy.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cBv.destroySurface(this.cAL, this.cAM, this.cAN);
                }
                this.cAN = null;
            }
        }

        public void finish() {
            if (this.cAP != null) {
                TBGLSurfaceView tBGLSurfaceView = this.cBy.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cBu.destroyContext(this.cAL, this.cAM, this.cAP);
                }
                this.cAP = null;
            }
            if (this.cAM != null) {
                this.cAL.eglTerminate(this.cAM);
                this.cAM = null;
            }
        }

        private void lu(String str) {
            R(str, this.cAL.eglGetError());
        }

        public static void R(String str, int i) {
            throw new RuntimeException(S(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, S(str2, i));
        }

        public static String S(String str, int i) {
            return str + " failed: " + com.baidu.tieba.animation3d.View.a.jl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean cAQ;
        private boolean cAR;
        private boolean cAS;
        private boolean cAT;
        private boolean cAU;
        private boolean cAV;
        private boolean cAW;
        private boolean cAX;
        private boolean cAY;
        private boolean cAZ;
        private boolean cBc;
        private WeakReference<TBGLSurfaceView> cBy;
        private h cBz;
        private boolean mPaused;
        private ArrayList<Runnable> cBd = new ArrayList<>();
        private boolean cBe = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cBb = true;
        private int cBa = 1;

        i(WeakReference<TBGLSurfaceView> weakReference) {
            this.cBy = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ajX();
                    TBGLSurfaceView.cBr.a(this);
                } catch (Exception e) {
                    af.Af().aS(false);
                    TBGLSurfaceView.cBr.a(this);
                }
            } catch (Throwable th) {
                TBGLSurfaceView.cBr.a(this);
                throw th;
            }
        }

        private void ajV() {
            if (this.cAX) {
                this.cAX = false;
                this.cBz.ajT();
            }
        }

        private void ajW() {
            if (this.cAW) {
                this.cBz.finish();
                this.cAW = false;
                TBGLSurfaceView.cBr.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void ajX() throws InterruptedException {
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
            this.cBz = new h(this.cBy);
            this.cAW = false;
            this.cAX = false;
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
                    synchronized (TBGLSurfaceView.cBr) {
                        while (!this.cAQ) {
                            if (this.cBd.isEmpty()) {
                                if (this.mPaused != this.cAS) {
                                    boolean z23 = this.cAS;
                                    this.mPaused = this.cAS;
                                    TBGLSurfaceView.cBr.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cAZ) {
                                    ajV();
                                    ajW();
                                    this.cAZ = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    ajV();
                                    ajW();
                                    z19 = false;
                                }
                                if (z9 && this.cAX) {
                                    ajV();
                                }
                                if (z9 && this.cAW) {
                                    TBGLSurfaceView tBGLSurfaceView = this.cBy.get();
                                    if (!(tBGLSurfaceView == null ? false : tBGLSurfaceView.cAH) || TBGLSurfaceView.cBr.akd()) {
                                        ajW();
                                    }
                                }
                                if (z9 && TBGLSurfaceView.cBr.ake()) {
                                    this.cBz.finish();
                                }
                                if (!this.cAT && !this.cAV) {
                                    if (this.cAX) {
                                        ajV();
                                    }
                                    this.cAV = true;
                                    this.cAU = false;
                                    TBGLSurfaceView.cBr.notifyAll();
                                }
                                if (this.cAT && this.cAV) {
                                    this.cAV = false;
                                    TBGLSurfaceView.cBr.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cBc = true;
                                    TBGLSurfaceView.cBr.notifyAll();
                                }
                                if (ajZ()) {
                                    if (!this.cAW) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (TBGLSurfaceView.cBr.b(this)) {
                                            try {
                                                this.cBz.start();
                                                this.cAW = true;
                                                z15 = true;
                                                TBGLSurfaceView.cBr.notifyAll();
                                            } catch (RuntimeException e) {
                                                TBGLSurfaceView.cBr.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cAW || this.cAX) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cAX = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cAX) {
                                        if (this.cBe) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cBe = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cBb = false;
                                        TBGLSurfaceView.cBr.notifyAll();
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
                                TBGLSurfaceView.cBr.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cBd.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (TBGLSurfaceView.cBr) {
                            ajV();
                            ajW();
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
                        } else if (this.cBz.ajQ()) {
                            synchronized (TBGLSurfaceView.cBr) {
                                this.cAY = true;
                                TBGLSurfaceView.cBr.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (TBGLSurfaceView.cBr) {
                                this.cAY = true;
                                this.cAU = true;
                                TBGLSurfaceView.cBr.notifyAll();
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
                            GL10 gl103 = (GL10) this.cBz.ajR();
                            TBGLSurfaceView.cBr.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            TBGLSurfaceView tBGLSurfaceView2 = this.cBy.get();
                            if (tBGLSurfaceView2 != null) {
                                tBGLSurfaceView2.cAA.onSurfaceCreated(gl10, this.cBz.cAO);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            TBGLSurfaceView tBGLSurfaceView3 = this.cBy.get();
                            if (tBGLSurfaceView3 != null) {
                                tBGLSurfaceView3.cAA.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        TBGLSurfaceView tBGLSurfaceView4 = this.cBy.get();
                        if (tBGLSurfaceView4 != null) {
                            tBGLSurfaceView4.cAA.onDrawFrame(gl10);
                        }
                        int ajS = this.cBz.ajS();
                        switch (ajS) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", ajS);
                                synchronized (TBGLSurfaceView.cBr) {
                                    this.cAU = true;
                                    TBGLSurfaceView.cBr.notifyAll();
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
                    synchronized (TBGLSurfaceView.cBr) {
                        ajV();
                        ajW();
                        throw th;
                    }
                }
            }
        }

        public boolean ajY() {
            return this.cAW && this.cAX && ajZ();
        }

        private boolean ajZ() {
            return !this.mPaused && this.cAT && !this.cAU && this.mWidth > 0 && this.mHeight > 0 && (this.cBb || this.cBa == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (TBGLSurfaceView.cBr) {
                    this.cBa = i;
                    TBGLSurfaceView.cBr.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (TBGLSurfaceView.cBr) {
                i = this.cBa;
            }
            return i;
        }

        public void aka() {
            synchronized (TBGLSurfaceView.cBr) {
                this.cAT = true;
                this.cAY = false;
                TBGLSurfaceView.cBr.notifyAll();
                while (this.cAV && !this.cAY && !this.cAR) {
                    try {
                        TBGLSurfaceView.cBr.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (TBGLSurfaceView.cBr) {
                this.cAT = false;
                TBGLSurfaceView.cBr.notifyAll();
                while (!this.cAV && !this.cAR) {
                    try {
                        TBGLSurfaceView.cBr.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ar(int i, int i2) {
            synchronized (TBGLSurfaceView.cBr) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cBe = true;
                this.cBb = true;
                this.cBc = false;
                TBGLSurfaceView.cBr.notifyAll();
                while (!this.cAR && !this.mPaused && !this.cBc && ajY()) {
                    try {
                        TBGLSurfaceView.cBr.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void akb() {
            synchronized (TBGLSurfaceView.cBr) {
                this.cAQ = true;
                TBGLSurfaceView.cBr.notifyAll();
                while (!this.cAR) {
                    try {
                        TBGLSurfaceView.cBr.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void akc() {
            this.cAZ = true;
            TBGLSurfaceView.cBr.notifyAll();
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

    private void ajO() {
        if (this.cBs != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i cBA;
        private boolean cBg;
        private int cBh;
        private boolean cBi;
        private boolean cBj;
        private boolean cBk;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cAR = true;
            if (this.cBA == iVar) {
                this.cBA = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cBA == iVar || this.cBA == null) {
                this.cBA = iVar;
                notifyAll();
                return true;
            }
            akf();
            if (this.cBj) {
                return true;
            }
            if (this.cBA != null) {
                this.cBA.akc();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cBA == iVar) {
                this.cBA = null;
            }
            notifyAll();
        }

        public synchronized boolean akd() {
            return this.cBk;
        }

        public synchronized boolean ake() {
            akf();
            return !this.cBj;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cBi) {
                    akf();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cBh < 131072) {
                        this.cBj = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cBk = this.cBj ? false : true;
                    this.cBi = true;
                }
            }
        }

        private void akf() {
            if (!this.cBg) {
                this.cBj = true;
                this.cBg = true;
            }
        }
    }
}
