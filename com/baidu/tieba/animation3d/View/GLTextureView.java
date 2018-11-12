package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.animation3d.View.TBGLSurfaceView;
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
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j cKf = new j();
    private final WeakReference<GLTextureView> cKg;
    private i cKh;
    private TBGLSurfaceView.m cKi;
    private e cKj;
    private f cKk;
    private g cKl;
    private k cKm;
    private int cKn;
    private int cKo;
    private boolean cKp;
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

    public GLTextureView(Context context) {
        super(context);
        this.cKg = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKg = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cKh != null) {
                this.cKh.anh();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cKm = kVar;
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

    public void setRenderer(TBGLSurfaceView.m mVar) {
        amT();
        if (this.cKj == null) {
            this.cKj = new m(true);
        }
        if (this.cKk == null) {
            this.cKk = new c();
        }
        if (this.cKl == null) {
            this.cKl = new d();
        }
        this.cKi = mVar;
        this.cKh = new i(this.cKg);
        this.cKh.start();
    }

    public void setEGLContextFactory(f fVar) {
        amT();
        this.cKk = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        amT();
        this.cKl = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        amT();
        this.cKj = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        amT();
        this.cKo = i2;
    }

    public void setRenderMode(int i2) {
        this.cKh.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cKh.getRenderMode();
    }

    public void requestRender() {
        this.cKh.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cKh.anf();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cKh.aw(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cKh.aw(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cKh.ang();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cKh.onPause();
    }

    public void onResume() {
        this.cKh.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cKi != null) {
            int renderMode = this.cKh != null ? this.cKh.getRenderMode() : 1;
            this.cKh = new i(this.cKg);
            if (renderMode != 1) {
                this.cKh.setRenderMode(renderMode);
            }
            this.cKh.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cKh != null) {
            this.cKh.anh();
        }
        this.mDetached = true;
        try {
            super.onDetachedFromWindow();
        } catch (Exception e2) {
        }
    }

    /* loaded from: classes.dex */
    private class c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.cKo, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.cKo == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
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

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.g
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

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
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
            if (GLTextureView.this.cKo == 2) {
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

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.a
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
    private class m extends b {
        public m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h {
        private WeakReference<GLTextureView> cKs;
        EGL10 cKt;
        EGLDisplay cKu;
        EGLSurface cKv;
        EGLConfig cKw;
        EGLContext cKx;

        public h(WeakReference<GLTextureView> weakReference) {
            this.cKs = weakReference;
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
            GLTextureView gLTextureView = this.cKs.get();
            if (gLTextureView != null) {
                this.cKw = gLTextureView.cKj.chooseConfig(this.cKt, this.cKu);
                try {
                    this.cKx = gLTextureView.cKk.createContext(this.cKt, this.cKu, this.cKw);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
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
            GLTextureView gLTextureView = this.cKs.get();
            if (gLTextureView != null) {
                this.cKv = gLTextureView.cKl.createWindowSurface(this.cKt, this.cKu, this.cKw, gLTextureView.getSurfaceTexture());
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
            GLTextureView gLTextureView = this.cKs.get();
            if (gLTextureView != null) {
                if (gLTextureView.cKm != null) {
                    gl = gLTextureView.cKm.wrap(gl);
                }
                if ((gLTextureView.cKn & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.cKn & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.cKn & 2) == 0) {
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
                GLTextureView gLTextureView = this.cKs.get();
                if (gLTextureView != null) {
                    gLTextureView.cKl.destroySurface(this.cKt, this.cKu, this.cKv);
                }
                this.cKv = null;
            }
        }

        public void finish() {
            if (this.cKx != null) {
                GLTextureView gLTextureView = this.cKs.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.cKk.destroyContext(this.cKt, this.cKu, this.cKx);
                    } catch (Exception e) {
                    }
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
            return str + " failed";
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
        private h cKN;
        private WeakReference<GLTextureView> cKs;
        private boolean cKy;
        private boolean cKz;
        private boolean mPaused;
        private ArrayList<Runnable> cKL = new ArrayList<>();
        private boolean cKM = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cKJ = true;
        private int cKI = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.cKs = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    anc();
                    GLTextureView.cKf.a(this);
                } catch (Exception e) {
                    af.Ct().bs(false);
                    GLTextureView.cKf.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.cKf.a(this);
                throw th;
            }
        }

        private void ana() {
            if (this.cKF) {
                this.cKF = false;
                this.cKN.amY();
            }
        }

        private void anb() {
            if (this.cKE) {
                this.cKN.finish();
                this.cKE = false;
                GLTextureView.cKf.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
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
            this.cKN = new h(this.cKs);
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
                    sleep(4L);
                    synchronized (GLTextureView.cKf) {
                        while (!this.cKy) {
                            if (this.cKL.isEmpty()) {
                                if (this.mPaused != this.cKA) {
                                    boolean z23 = this.cKA;
                                    this.mPaused = this.cKA;
                                    GLTextureView.cKf.notifyAll();
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
                                    GLTextureView gLTextureView = this.cKs.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.cKp) || GLTextureView.cKf.anj()) {
                                        anb();
                                    }
                                }
                                if (z9 && GLTextureView.cKf.ank()) {
                                    this.cKN.finish();
                                }
                                if (!this.cKB && !this.cKD) {
                                    if (this.cKF) {
                                        ana();
                                    }
                                    this.cKD = true;
                                    this.cKC = false;
                                    GLTextureView.cKf.notifyAll();
                                }
                                if (this.cKB && this.cKD) {
                                    this.cKD = false;
                                    GLTextureView.cKf.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cKK = true;
                                    GLTextureView.cKf.notifyAll();
                                }
                                if (ane()) {
                                    if (!this.cKE) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.cKf.b(this)) {
                                            try {
                                                this.cKN.start();
                                                this.cKE = true;
                                                z15 = true;
                                                GLTextureView.cKf.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.cKf.c(this);
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
                                        GLTextureView.cKf.notifyAll();
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
                                GLTextureView.cKf.wait();
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
                        synchronized (GLTextureView.cKf) {
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
                        } else if (this.cKN.amV()) {
                            synchronized (GLTextureView.cKf) {
                                this.cKG = true;
                                GLTextureView.cKf.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.cKf) {
                                this.cKG = true;
                                this.cKC = true;
                                GLTextureView.cKf.notifyAll();
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
                            GL10 gl103 = (GL10) this.cKN.amW();
                            GLTextureView.cKf.c(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.cKs.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.cKi.onSurfaceCreated(gl10, this.cKN.cKw);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.cKs.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.cKi.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.cKs.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.cKi.onDrawFrame(gl10);
                        }
                        int amX = this.cKN.amX();
                        switch (amX) {
                            case 12288:
                                break;
                            case Statistics.kTypeWhiteScreen /* 12302 */:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", amX);
                                synchronized (GLTextureView.cKf) {
                                    this.cKC = true;
                                    GLTextureView.cKf.notifyAll();
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
                    synchronized (GLTextureView.cKf) {
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
                synchronized (GLTextureView.cKf) {
                    this.cKI = i;
                    GLTextureView.cKf.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.cKf) {
                i = this.cKI;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.cKf) {
                this.cKJ = true;
                GLTextureView.cKf.notifyAll();
            }
        }

        public void anf() {
            synchronized (GLTextureView.cKf) {
                this.cKB = true;
                this.cKG = false;
                GLTextureView.cKf.notifyAll();
                while (this.cKD && !this.cKG && !this.cKz) {
                    try {
                        GLTextureView.cKf.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ang() {
            synchronized (GLTextureView.cKf) {
                this.cKB = false;
                GLTextureView.cKf.notifyAll();
                while (!this.cKD && !this.cKz) {
                    try {
                        GLTextureView.cKf.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.cKf) {
                this.cKA = true;
                GLTextureView.cKf.notifyAll();
                while (!this.cKz && !this.mPaused) {
                    try {
                        GLTextureView.cKf.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.cKf) {
                this.cKA = false;
                this.cKJ = true;
                this.cKK = false;
                GLTextureView.cKf.notifyAll();
                while (!this.cKz && this.mPaused && !this.cKK) {
                    try {
                        GLTextureView.cKf.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aw(int i, int i2) {
            synchronized (GLTextureView.cKf) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cKM = true;
                this.cKJ = true;
                this.cKK = false;
                GLTextureView.cKf.notifyAll();
                while (!this.cKz && !this.mPaused && !this.cKK && and()) {
                    try {
                        GLTextureView.cKf.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void anh() {
            synchronized (GLTextureView.cKf) {
                this.cKy = true;
                GLTextureView.cKf.notifyAll();
                while (!this.cKz) {
                    try {
                        GLTextureView.cKf.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ani() {
            this.cKH = true;
            GLTextureView.cKf.notifyAll();
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
        if (this.cKh != null) {
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
        private i cKT;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cKz = true;
            if (this.cKT == iVar) {
                this.cKT = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cKT == iVar || this.cKT == null) {
                this.cKT = iVar;
                notifyAll();
                return true;
            }
            anl();
            if (this.cKR) {
                return true;
            }
            if (this.cKT != null) {
                this.cKT.ani();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cKT == iVar) {
                this.cKT = null;
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
