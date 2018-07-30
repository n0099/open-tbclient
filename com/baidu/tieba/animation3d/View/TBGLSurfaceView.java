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
    private static final j cvE = new j();
    private final WeakReference<TBGLSurfaceView> cuL;
    private m cuN;
    private int cuS;
    private int cuT;
    private boolean cuU;
    private i cvF;
    private e cvG;
    private f cvH;
    private g cvI;
    private k cvJ;
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
        this.cuL = new WeakReference<>(this);
        init();
    }

    public TBGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cuL = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cvF != null) {
                this.cvF.aim();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.cvJ = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cuS = i2;
    }

    public int getDebugFlags() {
        return this.cuS;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cuU = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cuU;
    }

    public void setRenderer(m mVar) {
        ahZ();
        if (this.cvG == null) {
            this.cvG = new n(true);
        }
        if (this.cvH == null) {
            this.cvH = new c();
        }
        if (this.cvI == null) {
            this.cvI = new d();
        }
        this.cuN = mVar;
        this.cvF = new i(this.cuL);
        this.cvF.start();
    }

    public void setEGLContextFactory(f fVar) {
        ahZ();
        this.cvH = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ahZ();
        this.cvI = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ahZ();
        this.cvG = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        ahZ();
        this.cuT = i2;
    }

    public void setRenderMode(int i2) {
        this.cvF.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cvF.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cvF.ail();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cvF.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cvF.an(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cuN != null) {
            int renderMode = this.cvF != null ? this.cvF.getRenderMode() : 1;
            this.cvF = new i(this.cuL);
            if (renderMode != 1) {
                this.cvF.setRenderMode(renderMode);
            }
            this.cvF.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cvF != null) {
            this.cvF.aim();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, TBGLSurfaceView.this.cuT, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TBGLSurfaceView.this.cuT == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.f
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
        protected int[] cuV;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cuV = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cuV, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cuV, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (TBGLSurfaceView.this.cuT == 2) {
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
        EGL10 cuY;
        EGLDisplay cuZ;
        private WeakReference<TBGLSurfaceView> cvL;
        EGLSurface cva;
        EGLConfig cvb;
        EGLContext cvc;

        public h(WeakReference<TBGLSurfaceView> weakReference) {
            this.cvL = weakReference;
        }

        public void start() {
            this.cuY = (EGL10) EGLContext.getEGL();
            this.cuZ = this.cuY.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cuZ == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cuY.eglInitialize(this.cuZ, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TBGLSurfaceView tBGLSurfaceView = this.cvL.get();
            if (tBGLSurfaceView != null) {
                this.cvb = tBGLSurfaceView.cvG.chooseConfig(this.cuY, this.cuZ);
                this.cvc = tBGLSurfaceView.cvH.createContext(this.cuY, this.cuZ, this.cvb);
            } else {
                this.cvb = null;
                this.cvc = null;
            }
            if (this.cvc == null || this.cvc == EGL10.EGL_NO_CONTEXT) {
                this.cvc = null;
                kQ("createContext");
            }
            this.cva = null;
        }

        public boolean aib() {
            if (this.cuY == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cuZ == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cvb == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aif();
            TBGLSurfaceView tBGLSurfaceView = this.cvL.get();
            if (tBGLSurfaceView != null) {
                this.cva = tBGLSurfaceView.cvI.createWindowSurface(this.cuY, this.cuZ, this.cvb, tBGLSurfaceView.getHolder());
            } else {
                this.cva = null;
            }
            if (this.cva == null || this.cva == EGL10.EGL_NO_SURFACE) {
                if (this.cuY.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cuY.eglMakeCurrent(this.cuZ, this.cva, this.cva, this.cvc)) {
                g("EGLHelper", "eglMakeCurrent", this.cuY.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aic() {
            l lVar;
            GL gl = this.cvc.getGL();
            TBGLSurfaceView tBGLSurfaceView = this.cvL.get();
            if (tBGLSurfaceView != null) {
                if (tBGLSurfaceView.cvJ != null) {
                    gl = tBGLSurfaceView.cvJ.wrap(gl);
                }
                if ((tBGLSurfaceView.cuS & 3) != 0) {
                    int i = 0;
                    if ((tBGLSurfaceView.cuS & 1) != 0) {
                        i = 1;
                    }
                    if ((tBGLSurfaceView.cuS & 2) == 0) {
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

        public int aid() {
            if (this.cuY.eglSwapBuffers(this.cuZ, this.cva)) {
                return 12288;
            }
            return this.cuY.eglGetError();
        }

        public void aie() {
            aif();
        }

        private void aif() {
            if (this.cva != null && this.cva != EGL10.EGL_NO_SURFACE) {
                this.cuY.eglMakeCurrent(this.cuZ, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                TBGLSurfaceView tBGLSurfaceView = this.cvL.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cvI.destroySurface(this.cuY, this.cuZ, this.cva);
                }
                this.cva = null;
            }
        }

        public void finish() {
            if (this.cvc != null) {
                TBGLSurfaceView tBGLSurfaceView = this.cvL.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cvH.destroyContext(this.cuY, this.cuZ, this.cvc);
                }
                this.cvc = null;
            }
            if (this.cuZ != null) {
                this.cuY.eglTerminate(this.cuZ);
                this.cuZ = null;
            }
        }

        private void kQ(String str) {
            M(str, this.cuY.eglGetError());
        }

        public static void M(String str, int i) {
            throw new RuntimeException(N(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, N(str2, i));
        }

        public static String N(String str, int i) {
            return str + " failed: " + com.baidu.tieba.animation3d.View.a.iN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<TBGLSurfaceView> cvL;
        private h cvM;
        private boolean cvd;
        private boolean cve;
        private boolean cvf;
        private boolean cvg;
        private boolean cvh;
        private boolean cvi;
        private boolean cvj;
        private boolean cvk;
        private boolean cvl;
        private boolean cvm;
        private boolean cvp;
        private boolean mPaused;
        private ArrayList<Runnable> cvq = new ArrayList<>();
        private boolean cvr = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cvo = true;
        private int cvn = 1;

        i(WeakReference<TBGLSurfaceView> weakReference) {
            this.cvL = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aii();
                    TBGLSurfaceView.cvE.a(this);
                } catch (Exception e) {
                    ag.zc().aH(false);
                    TBGLSurfaceView.cvE.a(this);
                }
            } catch (Throwable th) {
                TBGLSurfaceView.cvE.a(this);
                throw th;
            }
        }

        private void aig() {
            if (this.cvk) {
                this.cvk = false;
                this.cvM.aie();
            }
        }

        private void aih() {
            if (this.cvj) {
                this.cvM.finish();
                this.cvj = false;
                TBGLSurfaceView.cvE.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aii() throws InterruptedException {
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
            this.cvM = new h(this.cvL);
            this.cvj = false;
            this.cvk = false;
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
                    synchronized (TBGLSurfaceView.cvE) {
                        while (!this.cvd) {
                            if (this.cvq.isEmpty()) {
                                if (this.mPaused != this.cvf) {
                                    boolean z23 = this.cvf;
                                    this.mPaused = this.cvf;
                                    TBGLSurfaceView.cvE.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cvm) {
                                    aig();
                                    aih();
                                    this.cvm = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aig();
                                    aih();
                                    z19 = false;
                                }
                                if (z9 && this.cvk) {
                                    aig();
                                }
                                if (z9 && this.cvj) {
                                    TBGLSurfaceView tBGLSurfaceView = this.cvL.get();
                                    if (!(tBGLSurfaceView == null ? false : tBGLSurfaceView.cuU) || TBGLSurfaceView.cvE.aio()) {
                                        aih();
                                    }
                                }
                                if (z9 && TBGLSurfaceView.cvE.aip()) {
                                    this.cvM.finish();
                                }
                                if (!this.cvg && !this.cvi) {
                                    if (this.cvk) {
                                        aig();
                                    }
                                    this.cvi = true;
                                    this.cvh = false;
                                    TBGLSurfaceView.cvE.notifyAll();
                                }
                                if (this.cvg && this.cvi) {
                                    this.cvi = false;
                                    TBGLSurfaceView.cvE.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cvp = true;
                                    TBGLSurfaceView.cvE.notifyAll();
                                }
                                if (aik()) {
                                    if (!this.cvj) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (TBGLSurfaceView.cvE.b(this)) {
                                            try {
                                                this.cvM.start();
                                                this.cvj = true;
                                                z15 = true;
                                                TBGLSurfaceView.cvE.notifyAll();
                                            } catch (RuntimeException e) {
                                                TBGLSurfaceView.cvE.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cvj || this.cvk) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cvk = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cvk) {
                                        if (this.cvr) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cvr = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cvo = false;
                                        TBGLSurfaceView.cvE.notifyAll();
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
                                TBGLSurfaceView.cvE.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cvq.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (TBGLSurfaceView.cvE) {
                            aig();
                            aih();
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
                        } else if (this.cvM.aib()) {
                            synchronized (TBGLSurfaceView.cvE) {
                                this.cvl = true;
                                TBGLSurfaceView.cvE.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (TBGLSurfaceView.cvE) {
                                this.cvl = true;
                                this.cvh = true;
                                TBGLSurfaceView.cvE.notifyAll();
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
                            GL10 gl103 = (GL10) this.cvM.aic();
                            TBGLSurfaceView.cvE.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            TBGLSurfaceView tBGLSurfaceView2 = this.cvL.get();
                            if (tBGLSurfaceView2 != null) {
                                tBGLSurfaceView2.cuN.onSurfaceCreated(gl10, this.cvM.cvb);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            TBGLSurfaceView tBGLSurfaceView3 = this.cvL.get();
                            if (tBGLSurfaceView3 != null) {
                                tBGLSurfaceView3.cuN.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        TBGLSurfaceView tBGLSurfaceView4 = this.cvL.get();
                        if (tBGLSurfaceView4 != null) {
                            tBGLSurfaceView4.cuN.onDrawFrame(gl10);
                        }
                        int aid = this.cvM.aid();
                        switch (aid) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", aid);
                                synchronized (TBGLSurfaceView.cvE) {
                                    this.cvh = true;
                                    TBGLSurfaceView.cvE.notifyAll();
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
                    synchronized (TBGLSurfaceView.cvE) {
                        aig();
                        aih();
                        throw th;
                    }
                }
            }
        }

        public boolean aij() {
            return this.cvj && this.cvk && aik();
        }

        private boolean aik() {
            return !this.mPaused && this.cvg && !this.cvh && this.mWidth > 0 && this.mHeight > 0 && (this.cvo || this.cvn == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (TBGLSurfaceView.cvE) {
                    this.cvn = i;
                    TBGLSurfaceView.cvE.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (TBGLSurfaceView.cvE) {
                i = this.cvn;
            }
            return i;
        }

        public void ail() {
            synchronized (TBGLSurfaceView.cvE) {
                this.cvg = true;
                this.cvl = false;
                TBGLSurfaceView.cvE.notifyAll();
                while (this.cvi && !this.cvl && !this.cve) {
                    try {
                        TBGLSurfaceView.cvE.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (TBGLSurfaceView.cvE) {
                this.cvg = false;
                TBGLSurfaceView.cvE.notifyAll();
                while (!this.cvi && !this.cve) {
                    try {
                        TBGLSurfaceView.cvE.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void an(int i, int i2) {
            synchronized (TBGLSurfaceView.cvE) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cvr = true;
                this.cvo = true;
                this.cvp = false;
                TBGLSurfaceView.cvE.notifyAll();
                while (!this.cve && !this.mPaused && !this.cvp && aij()) {
                    try {
                        TBGLSurfaceView.cvE.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aim() {
            synchronized (TBGLSurfaceView.cvE) {
                this.cvd = true;
                TBGLSurfaceView.cvE.notifyAll();
                while (!this.cve) {
                    try {
                        TBGLSurfaceView.cvE.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ain() {
            this.cvm = true;
            TBGLSurfaceView.cvE.notifyAll();
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

    private void ahZ() {
        if (this.cvF != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i cvN;
        private boolean cvt;
        private int cvu;
        private boolean cvv;
        private boolean cvw;
        private boolean cvx;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cve = true;
            if (this.cvN == iVar) {
                this.cvN = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cvN == iVar || this.cvN == null) {
                this.cvN = iVar;
                notifyAll();
                return true;
            }
            aiq();
            if (this.cvw) {
                return true;
            }
            if (this.cvN != null) {
                this.cvN.ain();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cvN == iVar) {
                this.cvN = null;
            }
            notifyAll();
        }

        public synchronized boolean aio() {
            return this.cvx;
        }

        public synchronized boolean aip() {
            aiq();
            return !this.cvw;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cvv) {
                    aiq();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cvu < 131072) {
                        this.cvw = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cvx = this.cvw ? false : true;
                    this.cvv = true;
                }
            }
        }

        private void aiq() {
            if (!this.cvt) {
                this.cvw = true;
                this.cvt = true;
            }
        }
    }
}
