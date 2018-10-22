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
    private static final j cJT = new j();
    private i cJU;
    private e cJV;
    private f cJW;
    private g cJX;
    private k cJY;
    private final WeakReference<TBGLSurfaceView> cJa;
    private m cJc;
    private int cJh;
    private int cJi;
    private boolean cJj;
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
        this.cJa = new WeakReference<>(this);
        init();
    }

    public TBGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJa = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cJU != null) {
                this.cJU.anG();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.cJY = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cJh = i2;
    }

    public int getDebugFlags() {
        return this.cJh;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cJj = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cJj;
    }

    public void setRenderer(m mVar) {
        ant();
        if (this.cJV == null) {
            this.cJV = new n(true);
        }
        if (this.cJW == null) {
            this.cJW = new c();
        }
        if (this.cJX == null) {
            this.cJX = new d();
        }
        this.cJc = mVar;
        this.cJU = new i(this.cJa);
        this.cJU.start();
    }

    public void setEGLContextFactory(f fVar) {
        ant();
        this.cJW = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ant();
        this.cJX = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ant();
        this.cJV = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        ant();
        this.cJi = i2;
    }

    public void setRenderMode(int i2) {
        this.cJU.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cJU.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cJU.anF();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cJU.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cJU.au(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cJc != null) {
            int renderMode = this.cJU != null ? this.cJU.getRenderMode() : 1;
            this.cJU = new i(this.cJa);
            if (renderMode != 1) {
                this.cJU.setRenderMode(renderMode);
            }
            this.cJU.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cJU != null) {
            this.cJU.anG();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, TBGLSurfaceView.this.cJi, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TBGLSurfaceView.this.cJi == 0) {
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
        protected int[] cJk;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cJk = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cJk, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cJk, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (TBGLSurfaceView.this.cJi == 2) {
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
        EGL10 cJn;
        EGLDisplay cJo;
        EGLSurface cJp;
        EGLConfig cJq;
        EGLContext cJr;
        private WeakReference<TBGLSurfaceView> cKa;

        public h(WeakReference<TBGLSurfaceView> weakReference) {
            this.cKa = weakReference;
        }

        public void start() {
            this.cJn = (EGL10) EGLContext.getEGL();
            this.cJo = this.cJn.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cJo == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cJn.eglInitialize(this.cJo, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            TBGLSurfaceView tBGLSurfaceView = this.cKa.get();
            if (tBGLSurfaceView != null) {
                this.cJq = tBGLSurfaceView.cJV.chooseConfig(this.cJn, this.cJo);
                this.cJr = tBGLSurfaceView.cJW.createContext(this.cJn, this.cJo, this.cJq);
            } else {
                this.cJq = null;
                this.cJr = null;
            }
            if (this.cJr == null || this.cJr == EGL10.EGL_NO_CONTEXT) {
                this.cJr = null;
                lY("createContext");
            }
            this.cJp = null;
        }

        public boolean anv() {
            if (this.cJn == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cJo == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cJq == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            anz();
            TBGLSurfaceView tBGLSurfaceView = this.cKa.get();
            if (tBGLSurfaceView != null) {
                this.cJp = tBGLSurfaceView.cJX.createWindowSurface(this.cJn, this.cJo, this.cJq, tBGLSurfaceView.getHolder());
            } else {
                this.cJp = null;
            }
            if (this.cJp == null || this.cJp == EGL10.EGL_NO_SURFACE) {
                if (this.cJn.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cJn.eglMakeCurrent(this.cJo, this.cJp, this.cJp, this.cJr)) {
                g("EGLHelper", "eglMakeCurrent", this.cJn.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL anw() {
            l lVar;
            GL gl = this.cJr.getGL();
            TBGLSurfaceView tBGLSurfaceView = this.cKa.get();
            if (tBGLSurfaceView != null) {
                if (tBGLSurfaceView.cJY != null) {
                    gl = tBGLSurfaceView.cJY.wrap(gl);
                }
                if ((tBGLSurfaceView.cJh & 3) != 0) {
                    int i = 0;
                    if ((tBGLSurfaceView.cJh & 1) != 0) {
                        i = 1;
                    }
                    if ((tBGLSurfaceView.cJh & 2) == 0) {
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

        public int anx() {
            if (this.cJn.eglSwapBuffers(this.cJo, this.cJp)) {
                return 12288;
            }
            return this.cJn.eglGetError();
        }

        public void any() {
            anz();
        }

        private void anz() {
            if (this.cJp != null && this.cJp != EGL10.EGL_NO_SURFACE) {
                this.cJn.eglMakeCurrent(this.cJo, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                TBGLSurfaceView tBGLSurfaceView = this.cKa.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cJX.destroySurface(this.cJn, this.cJo, this.cJp);
                }
                this.cJp = null;
            }
        }

        public void finish() {
            if (this.cJr != null) {
                TBGLSurfaceView tBGLSurfaceView = this.cKa.get();
                if (tBGLSurfaceView != null) {
                    tBGLSurfaceView.cJW.destroyContext(this.cJn, this.cJo, this.cJr);
                }
                this.cJr = null;
            }
            if (this.cJo != null) {
                this.cJn.eglTerminate(this.cJo);
                this.cJo = null;
            }
        }

        private void lY(String str) {
            V(str, this.cJn.eglGetError());
        }

        public static void V(String str, int i) {
            throw new RuntimeException(W(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, W(str2, i));
        }

        public static String W(String str, int i) {
            return str + " failed: " + com.baidu.tieba.animation3d.View.a.jK(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean cJA;
        private boolean cJB;
        private boolean cJE;
        private boolean cJs;
        private boolean cJt;
        private boolean cJu;
        private boolean cJv;
        private boolean cJw;
        private boolean cJx;
        private boolean cJy;
        private boolean cJz;
        private WeakReference<TBGLSurfaceView> cKa;
        private h cKb;
        private boolean mPaused;
        private ArrayList<Runnable> cJF = new ArrayList<>();
        private boolean cJG = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cJD = true;
        private int cJC = 1;

        i(WeakReference<TBGLSurfaceView> weakReference) {
            this.cKa = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    anC();
                    TBGLSurfaceView.cJT.a(this);
                } catch (Exception e) {
                    af.Cm().bc(false);
                    TBGLSurfaceView.cJT.a(this);
                }
            } catch (Throwable th) {
                TBGLSurfaceView.cJT.a(this);
                throw th;
            }
        }

        private void anA() {
            if (this.cJz) {
                this.cJz = false;
                this.cKb.any();
            }
        }

        private void anB() {
            if (this.cJy) {
                this.cKb.finish();
                this.cJy = false;
                TBGLSurfaceView.cJT.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void anC() throws InterruptedException {
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
            this.cKb = new h(this.cKa);
            this.cJy = false;
            this.cJz = false;
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
                    synchronized (TBGLSurfaceView.cJT) {
                        while (!this.cJs) {
                            if (this.cJF.isEmpty()) {
                                if (this.mPaused != this.cJu) {
                                    boolean z23 = this.cJu;
                                    this.mPaused = this.cJu;
                                    TBGLSurfaceView.cJT.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cJB) {
                                    anA();
                                    anB();
                                    this.cJB = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    anA();
                                    anB();
                                    z19 = false;
                                }
                                if (z9 && this.cJz) {
                                    anA();
                                }
                                if (z9 && this.cJy) {
                                    TBGLSurfaceView tBGLSurfaceView = this.cKa.get();
                                    if (!(tBGLSurfaceView == null ? false : tBGLSurfaceView.cJj) || TBGLSurfaceView.cJT.anI()) {
                                        anB();
                                    }
                                }
                                if (z9 && TBGLSurfaceView.cJT.anJ()) {
                                    this.cKb.finish();
                                }
                                if (!this.cJv && !this.cJx) {
                                    if (this.cJz) {
                                        anA();
                                    }
                                    this.cJx = true;
                                    this.cJw = false;
                                    TBGLSurfaceView.cJT.notifyAll();
                                }
                                if (this.cJv && this.cJx) {
                                    this.cJx = false;
                                    TBGLSurfaceView.cJT.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cJE = true;
                                    TBGLSurfaceView.cJT.notifyAll();
                                }
                                if (anE()) {
                                    if (!this.cJy) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (TBGLSurfaceView.cJT.b(this)) {
                                            try {
                                                this.cKb.start();
                                                this.cJy = true;
                                                z15 = true;
                                                TBGLSurfaceView.cJT.notifyAll();
                                            } catch (RuntimeException e) {
                                                TBGLSurfaceView.cJT.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cJy || this.cJz) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cJz = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cJz) {
                                        if (this.cJG) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cJG = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cJD = false;
                                        TBGLSurfaceView.cJT.notifyAll();
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
                                TBGLSurfaceView.cJT.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cJF.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (TBGLSurfaceView.cJT) {
                            anA();
                            anB();
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
                        } else if (this.cKb.anv()) {
                            synchronized (TBGLSurfaceView.cJT) {
                                this.cJA = true;
                                TBGLSurfaceView.cJT.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (TBGLSurfaceView.cJT) {
                                this.cJA = true;
                                this.cJw = true;
                                TBGLSurfaceView.cJT.notifyAll();
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
                            GL10 gl103 = (GL10) this.cKb.anw();
                            TBGLSurfaceView.cJT.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            TBGLSurfaceView tBGLSurfaceView2 = this.cKa.get();
                            if (tBGLSurfaceView2 != null) {
                                tBGLSurfaceView2.cJc.onSurfaceCreated(gl10, this.cKb.cJq);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            TBGLSurfaceView tBGLSurfaceView3 = this.cKa.get();
                            if (tBGLSurfaceView3 != null) {
                                tBGLSurfaceView3.cJc.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        TBGLSurfaceView tBGLSurfaceView4 = this.cKa.get();
                        if (tBGLSurfaceView4 != null) {
                            tBGLSurfaceView4.cJc.onDrawFrame(gl10);
                        }
                        int anx = this.cKb.anx();
                        switch (anx) {
                            case 12288:
                                break;
                            case Statistics.kTypeWhiteScreen /* 12302 */:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", anx);
                                synchronized (TBGLSurfaceView.cJT) {
                                    this.cJw = true;
                                    TBGLSurfaceView.cJT.notifyAll();
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
                    synchronized (TBGLSurfaceView.cJT) {
                        anA();
                        anB();
                        throw th;
                    }
                }
            }
        }

        public boolean anD() {
            return this.cJy && this.cJz && anE();
        }

        private boolean anE() {
            return !this.mPaused && this.cJv && !this.cJw && this.mWidth > 0 && this.mHeight > 0 && (this.cJD || this.cJC == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (TBGLSurfaceView.cJT) {
                    this.cJC = i;
                    TBGLSurfaceView.cJT.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (TBGLSurfaceView.cJT) {
                i = this.cJC;
            }
            return i;
        }

        public void anF() {
            synchronized (TBGLSurfaceView.cJT) {
                this.cJv = true;
                this.cJA = false;
                TBGLSurfaceView.cJT.notifyAll();
                while (this.cJx && !this.cJA && !this.cJt) {
                    try {
                        TBGLSurfaceView.cJT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (TBGLSurfaceView.cJT) {
                this.cJv = false;
                TBGLSurfaceView.cJT.notifyAll();
                while (!this.cJx && !this.cJt) {
                    try {
                        TBGLSurfaceView.cJT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void au(int i, int i2) {
            synchronized (TBGLSurfaceView.cJT) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cJG = true;
                this.cJD = true;
                this.cJE = false;
                TBGLSurfaceView.cJT.notifyAll();
                while (!this.cJt && !this.mPaused && !this.cJE && anD()) {
                    try {
                        TBGLSurfaceView.cJT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void anG() {
            synchronized (TBGLSurfaceView.cJT) {
                this.cJs = true;
                TBGLSurfaceView.cJT.notifyAll();
                while (!this.cJt) {
                    try {
                        TBGLSurfaceView.cJT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void anH() {
            this.cJB = true;
            TBGLSurfaceView.cJT.notifyAll();
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

    private void ant() {
        if (this.cJU != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cJI;
        private int cJJ;
        private boolean cJK;
        private boolean cJL;
        private boolean cJM;
        private i cKc;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cJt = true;
            if (this.cKc == iVar) {
                this.cKc = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cKc == iVar || this.cKc == null) {
                this.cKc = iVar;
                notifyAll();
                return true;
            }
            anK();
            if (this.cJL) {
                return true;
            }
            if (this.cKc != null) {
                this.cKc.anH();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cKc == iVar) {
                this.cKc = null;
            }
            notifyAll();
        }

        public synchronized boolean anI() {
            return this.cJM;
        }

        public synchronized boolean anJ() {
            anK();
            return !this.cJL;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cJK) {
                    anK();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cJJ < 131072) {
                        this.cJL = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cJM = this.cJL ? false : true;
                    this.cJK = true;
                }
            }
        }

        private void anK() {
            if (!this.cJI) {
                this.cJL = true;
                this.cJI = true;
            }
        }
    }
}
