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
    private static final j cuV = new j();
    private i cuW;
    private e cuX;
    private f cuY;
    private g cuZ;
    private final WeakReference<TBGLSurfaceView> cub;
    private m cud;
    private int cui;
    private int cuj;
    private boolean cuk;
    private k cva;
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
        this.cub = new WeakReference<>(this);
        init();
    }

    public TBGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cub = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cuW != null) {
                this.cuW.aiu();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.cva = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cui = i2;
    }

    public int getDebugFlags() {
        return this.cui;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cuk = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cuk;
    }

    public void setRenderer(m mVar) {
        aih();
        if (this.cuX == null) {
            this.cuX = new n(true);
        }
        if (this.cuY == null) {
            this.cuY = new c();
        }
        if (this.cuZ == null) {
            this.cuZ = new d();
        }
        this.cud = mVar;
        this.cuW = new i(this.cub);
        this.cuW.start();
    }

    public void setEGLContextFactory(f fVar) {
        aih();
        this.cuY = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aih();
        this.cuZ = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aih();
        this.cuX = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        aih();
        this.cuj = i2;
    }

    public void setRenderMode(int i2) {
        this.cuW.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cuW.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cuW.ait();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cuW.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cuW.al(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cud != null) {
            int renderMode = this.cuW != null ? this.cuW.getRenderMode() : 1;
            this.cuW = new i(this.cub);
            if (renderMode != 1) {
                this.cuW.setRenderMode(renderMode);
            }
            this.cuW.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cuW != null) {
            this.cuW.aiu();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, TBGLSurfaceView.this.cuj, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TBGLSurfaceView.this.cuj == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.S("eglDestroyContex", egl10.eglGetError());
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
        protected int[] cul;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cul = i(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cul, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cul, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] i(int[] iArr) {
            if (TBGLSurfaceView.this.cuj == 2) {
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
        EGL10 cuo;
        EGLDisplay cup;
        EGLSurface cuq;
        EGLConfig cus;
        EGLContext cut;
        private WeakReference<TBGLSurfaceView> cvc;

        public h(WeakReference<TBGLSurfaceView> weakReference) {
            this.cvc = weakReference;
        }

        public void start() {
            this.cuo = (EGL10) EGLContext.getEGL();
            this.cup = this.cuo.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cup == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cuo.eglInitialize(this.cup, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TBGLSurfaceView tBGLSurfaceView = this.cvc.get();
            if (tBGLSurfaceView != null) {
                this.cus = tBGLSurfaceView.cuX.chooseConfig(this.cuo, this.cup);
                this.cut = tBGLSurfaceView.cuY.createContext(this.cuo, this.cup, this.cus);
            } else {
                this.cus = null;
                this.cut = null;
            }
            if (this.cut == null || this.cut == EGL10.EGL_NO_CONTEXT) {
                this.cut = null;
                kV("createContext");
            }
            this.cuq = null;
        }

        public boolean aij() {
            if (this.cuo == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cup == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cus == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ain();
            TBGLSurfaceView tBGLSurfaceView = this.cvc.get();
            if (tBGLSurfaceView != null) {
                this.cuq = tBGLSurfaceView.cuZ.createWindowSurface(this.cuo, this.cup, this.cus, tBGLSurfaceView.getHolder());
            } else {
                this.cuq = null;
            }
            if (this.cuq == null || this.cuq == EGL10.EGL_NO_SURFACE) {
                if (this.cuo.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cuo.eglMakeCurrent(this.cup, this.cuq, this.cuq, this.cut)) {
                g("EGLHelper", "eglMakeCurrent", this.cuo.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aik() {
            l lVar;
            GL gl = this.cut.getGL();
            TBGLSurfaceView tBGLSurfaceView = this.cvc.get();
            if (tBGLSurfaceView != null) {
                if (tBGLSurfaceView.cva != null) {
                    gl = tBGLSurfaceView.cva.wrap(gl);
                }
                if ((tBGLSurfaceView.cui & 3) != 0) {
                    int i = 0;
                    if ((tBGLSurfaceView.cui & 1) != 0) {
                        i = 1;
                    }
                    if ((tBGLSurfaceView.cui & 2) == 0) {
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

        public int ail() {
            if (this.cuo.eglSwapBuffers(this.cup, this.cuq)) {
                return 12288;
            }
            return this.cuo.eglGetError();
        }

        public void aim() {
            ain();
        }

        private void ain() {
            if (this.cuq != null && this.cuq != EGL10.EGL_NO_SURFACE) {
                this.cuo.eglMakeCurrent(this.cup, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                TBGLSurfaceView tBGLSurfaceView = this.cvc.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cuZ.destroySurface(this.cuo, this.cup, this.cuq);
                }
                this.cuq = null;
            }
        }

        public void finish() {
            if (this.cut != null) {
                TBGLSurfaceView tBGLSurfaceView = this.cvc.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cuY.destroyContext(this.cuo, this.cup, this.cut);
                }
                this.cut = null;
            }
            if (this.cup != null) {
                this.cuo.eglTerminate(this.cup);
                this.cup = null;
            }
        }

        private void kV(String str) {
            S(str, this.cuo.eglGetError());
        }

        public static void S(String str, int i) {
            throw new RuntimeException(T(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, T(str2, i));
        }

        public static String T(String str, int i) {
            return str + " failed: " + com.baidu.tieba.animation3d.View.a.iF(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean cuA;
        private boolean cuB;
        private boolean cuC;
        private boolean cuD;
        private boolean cuG;
        private boolean cuu;
        private boolean cuv;
        private boolean cuw;
        private boolean cux;
        private boolean cuy;
        private boolean cuz;
        private WeakReference<TBGLSurfaceView> cvc;
        private h cvd;
        private boolean mPaused;
        private ArrayList<Runnable> cuH = new ArrayList<>();
        private boolean cuI = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cuF = true;
        private int cuE = 1;

        i(WeakReference<TBGLSurfaceView> weakReference) {
            this.cvc = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aiq();
                    TBGLSurfaceView.cuV.a(this);
                } catch (Exception e) {
                    ag.yX().aH(false);
                    TBGLSurfaceView.cuV.a(this);
                }
            } catch (Throwable th) {
                TBGLSurfaceView.cuV.a(this);
                throw th;
            }
        }

        private void aio() {
            if (this.cuB) {
                this.cuB = false;
                this.cvd.aim();
            }
        }

        private void aip() {
            if (this.cuA) {
                this.cvd.finish();
                this.cuA = false;
                TBGLSurfaceView.cuV.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aiq() throws InterruptedException {
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
            this.cvd = new h(this.cvc);
            this.cuA = false;
            this.cuB = false;
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
                    synchronized (TBGLSurfaceView.cuV) {
                        while (!this.cuu) {
                            if (this.cuH.isEmpty()) {
                                if (this.mPaused != this.cuw) {
                                    boolean z23 = this.cuw;
                                    this.mPaused = this.cuw;
                                    TBGLSurfaceView.cuV.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cuD) {
                                    aio();
                                    aip();
                                    this.cuD = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aio();
                                    aip();
                                    z19 = false;
                                }
                                if (z9 && this.cuB) {
                                    aio();
                                }
                                if (z9 && this.cuA) {
                                    TBGLSurfaceView tBGLSurfaceView = this.cvc.get();
                                    if (!(tBGLSurfaceView == null ? false : tBGLSurfaceView.cuk) || TBGLSurfaceView.cuV.aiw()) {
                                        aip();
                                    }
                                }
                                if (z9 && TBGLSurfaceView.cuV.aix()) {
                                    this.cvd.finish();
                                }
                                if (!this.cux && !this.cuz) {
                                    if (this.cuB) {
                                        aio();
                                    }
                                    this.cuz = true;
                                    this.cuy = false;
                                    TBGLSurfaceView.cuV.notifyAll();
                                }
                                if (this.cux && this.cuz) {
                                    this.cuz = false;
                                    TBGLSurfaceView.cuV.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cuG = true;
                                    TBGLSurfaceView.cuV.notifyAll();
                                }
                                if (ais()) {
                                    if (!this.cuA) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (TBGLSurfaceView.cuV.b(this)) {
                                            try {
                                                this.cvd.start();
                                                this.cuA = true;
                                                z15 = true;
                                                TBGLSurfaceView.cuV.notifyAll();
                                            } catch (RuntimeException e) {
                                                TBGLSurfaceView.cuV.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cuA || this.cuB) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cuB = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cuB) {
                                        if (this.cuI) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cuI = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cuF = false;
                                        TBGLSurfaceView.cuV.notifyAll();
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
                                TBGLSurfaceView.cuV.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cuH.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (TBGLSurfaceView.cuV) {
                            aio();
                            aip();
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
                        } else if (this.cvd.aij()) {
                            synchronized (TBGLSurfaceView.cuV) {
                                this.cuC = true;
                                TBGLSurfaceView.cuV.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (TBGLSurfaceView.cuV) {
                                this.cuC = true;
                                this.cuy = true;
                                TBGLSurfaceView.cuV.notifyAll();
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
                            GL10 gl103 = (GL10) this.cvd.aik();
                            TBGLSurfaceView.cuV.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            TBGLSurfaceView tBGLSurfaceView2 = this.cvc.get();
                            if (tBGLSurfaceView2 != null) {
                                tBGLSurfaceView2.cud.onSurfaceCreated(gl10, this.cvd.cus);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            TBGLSurfaceView tBGLSurfaceView3 = this.cvc.get();
                            if (tBGLSurfaceView3 != null) {
                                tBGLSurfaceView3.cud.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        TBGLSurfaceView tBGLSurfaceView4 = this.cvc.get();
                        if (tBGLSurfaceView4 != null) {
                            tBGLSurfaceView4.cud.onDrawFrame(gl10);
                        }
                        int ail = this.cvd.ail();
                        switch (ail) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", ail);
                                synchronized (TBGLSurfaceView.cuV) {
                                    this.cuy = true;
                                    TBGLSurfaceView.cuV.notifyAll();
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
                    synchronized (TBGLSurfaceView.cuV) {
                        aio();
                        aip();
                        throw th;
                    }
                }
            }
        }

        public boolean air() {
            return this.cuA && this.cuB && ais();
        }

        private boolean ais() {
            return !this.mPaused && this.cux && !this.cuy && this.mWidth > 0 && this.mHeight > 0 && (this.cuF || this.cuE == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (TBGLSurfaceView.cuV) {
                    this.cuE = i;
                    TBGLSurfaceView.cuV.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (TBGLSurfaceView.cuV) {
                i = this.cuE;
            }
            return i;
        }

        public void ait() {
            synchronized (TBGLSurfaceView.cuV) {
                this.cux = true;
                this.cuC = false;
                TBGLSurfaceView.cuV.notifyAll();
                while (this.cuz && !this.cuC && !this.cuv) {
                    try {
                        TBGLSurfaceView.cuV.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (TBGLSurfaceView.cuV) {
                this.cux = false;
                TBGLSurfaceView.cuV.notifyAll();
                while (!this.cuz && !this.cuv) {
                    try {
                        TBGLSurfaceView.cuV.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void al(int i, int i2) {
            synchronized (TBGLSurfaceView.cuV) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cuI = true;
                this.cuF = true;
                this.cuG = false;
                TBGLSurfaceView.cuV.notifyAll();
                while (!this.cuv && !this.mPaused && !this.cuG && air()) {
                    try {
                        TBGLSurfaceView.cuV.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiu() {
            synchronized (TBGLSurfaceView.cuV) {
                this.cuu = true;
                TBGLSurfaceView.cuV.notifyAll();
                while (!this.cuv) {
                    try {
                        TBGLSurfaceView.cuV.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiv() {
            this.cuD = true;
            TBGLSurfaceView.cuV.notifyAll();
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

    private void aih() {
        if (this.cuW != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cuK;
        private int cuL;
        private boolean cuM;
        private boolean cuN;
        private boolean cuO;
        private i cve;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cuv = true;
            if (this.cve == iVar) {
                this.cve = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cve == iVar || this.cve == null) {
                this.cve = iVar;
                notifyAll();
                return true;
            }
            aiy();
            if (this.cuN) {
                return true;
            }
            if (this.cve != null) {
                this.cve.aiv();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cve == iVar) {
                this.cve = null;
            }
            notifyAll();
        }

        public synchronized boolean aiw() {
            return this.cuO;
        }

        public synchronized boolean aix() {
            aiy();
            return !this.cuN;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cuM) {
                    aiy();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cuL < 131072) {
                        this.cuN = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cuO = this.cuN ? false : true;
                    this.cuM = true;
                }
            }
        }

        private void aiy() {
            if (!this.cuK) {
                this.cuN = true;
                this.cuK = true;
            }
        }
    }
}
