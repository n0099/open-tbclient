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
    private static final j cUp = new j();
    private final WeakReference<GLTextureView> cUq;
    private i cUr;
    private TBGLSurfaceView.m cUs;
    private e cUt;
    private f cUu;
    private g cUv;
    private k cUw;
    private int cUx;
    private int cUy;
    private boolean cUz;
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
        this.cUq = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUq = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cUr != null) {
                this.cUr.aqg();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cUw = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cUx = i2;
    }

    public int getDebugFlags() {
        return this.cUx;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cUz = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cUz;
    }

    public void setRenderer(TBGLSurfaceView.m mVar) {
        apS();
        if (this.cUt == null) {
            this.cUt = new m(true);
        }
        if (this.cUu == null) {
            this.cUu = new c();
        }
        if (this.cUv == null) {
            this.cUv = new d();
        }
        this.cUs = mVar;
        this.cUr = new i(this.cUq);
        this.cUr.start();
    }

    public void setEGLContextFactory(f fVar) {
        apS();
        this.cUu = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        apS();
        this.cUv = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        apS();
        this.cUt = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        apS();
        this.cUy = i2;
    }

    public void setRenderMode(int i2) {
        this.cUr.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cUr.getRenderMode();
    }

    public void requestRender() {
        this.cUr.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cUr.aqe();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cUr.ay(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cUr.ay(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cUr.aqf();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cUr.onPause();
    }

    public void onResume() {
        this.cUr.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cUs != null) {
            int renderMode = this.cUr != null ? this.cUr.getRenderMode() : 1;
            this.cUr = new i(this.cUq);
            if (renderMode != 1) {
                this.cUr.setRenderMode(renderMode);
            }
            this.cUr.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cUr != null) {
            this.cUr.aqg();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.cUy, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.cUy == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
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
        protected int[] cUA;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cUA = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cUA, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cUA, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (GLTextureView.this.cUy == 2) {
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
        private WeakReference<GLTextureView> cUC;
        EGL10 cUD;
        EGLDisplay cUE;
        EGLSurface cUF;
        EGLConfig cUG;
        EGLContext cUH;

        public h(WeakReference<GLTextureView> weakReference) {
            this.cUC = weakReference;
        }

        public void start() {
            this.cUD = (EGL10) EGLContext.getEGL();
            this.cUE = this.cUD.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cUE == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cUD.eglInitialize(this.cUE, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.cUC.get();
            if (gLTextureView != null) {
                this.cUG = gLTextureView.cUt.chooseConfig(this.cUD, this.cUE);
                try {
                    this.cUH = gLTextureView.cUu.createContext(this.cUD, this.cUE, this.cUG);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.cUG = null;
                this.cUH = null;
            }
            if (this.cUH == null || this.cUH == EGL10.EGL_NO_CONTEXT) {
                this.cUH = null;
                mR("createContext");
            }
            this.cUF = null;
        }

        public boolean apU() {
            if (this.cUD == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cUE == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cUG == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            apY();
            GLTextureView gLTextureView = this.cUC.get();
            if (gLTextureView != null) {
                this.cUF = gLTextureView.cUv.createWindowSurface(this.cUD, this.cUE, this.cUG, gLTextureView.getSurfaceTexture());
            } else {
                this.cUF = null;
            }
            if (this.cUF == null || this.cUF == EGL10.EGL_NO_SURFACE) {
                if (this.cUD.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cUD.eglMakeCurrent(this.cUE, this.cUF, this.cUF, this.cUH)) {
                h("EGLHelper", "eglMakeCurrent", this.cUD.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL apV() {
            l lVar;
            GL gl = this.cUH.getGL();
            GLTextureView gLTextureView = this.cUC.get();
            if (gLTextureView != null) {
                if (gLTextureView.cUw != null) {
                    gl = gLTextureView.cUw.wrap(gl);
                }
                if ((gLTextureView.cUx & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.cUx & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.cUx & 2) == 0) {
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
            if (this.cUD.eglSwapBuffers(this.cUE, this.cUF)) {
                return 12288;
            }
            return this.cUD.eglGetError();
        }

        public void apX() {
            apY();
        }

        private void apY() {
            if (this.cUF != null && this.cUF != EGL10.EGL_NO_SURFACE) {
                this.cUD.eglMakeCurrent(this.cUE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.cUC.get();
                if (gLTextureView != null) {
                    gLTextureView.cUv.destroySurface(this.cUD, this.cUE, this.cUF);
                }
                this.cUF = null;
            }
        }

        public void finish() {
            if (this.cUH != null) {
                GLTextureView gLTextureView = this.cUC.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.cUu.destroyContext(this.cUD, this.cUE, this.cUH);
                    } catch (Exception e) {
                    }
                }
                this.cUH = null;
            }
            if (this.cUE != null) {
                this.cUD.eglTerminate(this.cUE);
                this.cUE = null;
            }
        }

        private void mR(String str) {
            X(str, this.cUD.eglGetError());
        }

        public static void X(String str, int i) {
            throw new RuntimeException(Y(str, i));
        }

        public static void h(String str, String str2, int i) {
            Log.w(str, Y(str2, i));
        }

        public static String Y(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<GLTextureView> cUC;
        private boolean cUI;
        private boolean cUJ;
        private boolean cUK;
        private boolean cUL;
        private boolean cUM;
        private boolean cUN;
        private boolean cUO;
        private boolean cUP;
        private boolean cUQ;
        private boolean cUR;
        private boolean cUU;
        private h cUW;
        private boolean mPaused;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean cUV = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cUT = true;
        private int cUS = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.cUC = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aqb();
                    GLTextureView.cUp.a(this);
                } catch (Exception e) {
                    af.DK().bu(false);
                    GLTextureView.cUp.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.cUp.a(this);
                throw th;
            }
        }

        private void apZ() {
            if (this.cUP) {
                this.cUP = false;
                this.cUW.apX();
            }
        }

        private void aqa() {
            if (this.cUO) {
                this.cUW.finish();
                this.cUO = false;
                GLTextureView.cUp.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
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
            this.cUW = new h(this.cUC);
            this.cUO = false;
            this.cUP = false;
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
                    synchronized (GLTextureView.cUp) {
                        while (!this.cUI) {
                            if (this.mEventQueue.isEmpty()) {
                                if (this.mPaused != this.cUK) {
                                    boolean z23 = this.cUK;
                                    this.mPaused = this.cUK;
                                    GLTextureView.cUp.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cUR) {
                                    apZ();
                                    aqa();
                                    this.cUR = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    apZ();
                                    aqa();
                                    z19 = false;
                                }
                                if (z9 && this.cUP) {
                                    apZ();
                                }
                                if (z9 && this.cUO) {
                                    GLTextureView gLTextureView = this.cUC.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.cUz) || GLTextureView.cUp.aqi()) {
                                        aqa();
                                    }
                                }
                                if (z9 && GLTextureView.cUp.aqj()) {
                                    this.cUW.finish();
                                }
                                if (!this.cUL && !this.cUN) {
                                    if (this.cUP) {
                                        apZ();
                                    }
                                    this.cUN = true;
                                    this.cUM = false;
                                    GLTextureView.cUp.notifyAll();
                                }
                                if (this.cUL && this.cUN) {
                                    this.cUN = false;
                                    GLTextureView.cUp.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cUU = true;
                                    GLTextureView.cUp.notifyAll();
                                }
                                if (aqd()) {
                                    if (!this.cUO) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.cUp.b(this)) {
                                            try {
                                                this.cUW.start();
                                                this.cUO = true;
                                                z15 = true;
                                                GLTextureView.cUp.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.cUp.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cUO || this.cUP) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cUP = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cUP) {
                                        if (this.cUV) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cUV = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cUT = false;
                                        GLTextureView.cUp.notifyAll();
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
                                GLTextureView.cUp.wait();
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
                        synchronized (GLTextureView.cUp) {
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
                        } else if (this.cUW.apU()) {
                            synchronized (GLTextureView.cUp) {
                                this.cUQ = true;
                                GLTextureView.cUp.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.cUp) {
                                this.cUQ = true;
                                this.cUM = true;
                                GLTextureView.cUp.notifyAll();
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
                            GL10 gl103 = (GL10) this.cUW.apV();
                            GLTextureView.cUp.c(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.cUC.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.cUs.onSurfaceCreated(gl10, this.cUW.cUG);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.cUC.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.cUs.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.cUC.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.cUs.onDrawFrame(gl10);
                        }
                        int apW = this.cUW.apW();
                        switch (apW) {
                            case 12288:
                                break;
                            case Statistics.kTypeWhiteScreen /* 12302 */:
                                z4 = true;
                                break;
                            default:
                                h.h("GLThread", "eglSwapBuffers", apW);
                                synchronized (GLTextureView.cUp) {
                                    this.cUM = true;
                                    GLTextureView.cUp.notifyAll();
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
                    synchronized (GLTextureView.cUp) {
                        apZ();
                        aqa();
                        throw th;
                    }
                }
            }
        }

        public boolean aqc() {
            return this.cUO && this.cUP && aqd();
        }

        private boolean aqd() {
            return !this.mPaused && this.cUL && !this.cUM && this.mWidth > 0 && this.mHeight > 0 && (this.cUT || this.cUS == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (GLTextureView.cUp) {
                    this.cUS = i;
                    GLTextureView.cUp.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.cUp) {
                i = this.cUS;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.cUp) {
                this.cUT = true;
                GLTextureView.cUp.notifyAll();
            }
        }

        public void aqe() {
            synchronized (GLTextureView.cUp) {
                this.cUL = true;
                this.cUQ = false;
                GLTextureView.cUp.notifyAll();
                while (this.cUN && !this.cUQ && !this.cUJ) {
                    try {
                        GLTextureView.cUp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqf() {
            synchronized (GLTextureView.cUp) {
                this.cUL = false;
                GLTextureView.cUp.notifyAll();
                while (!this.cUN && !this.cUJ) {
                    try {
                        GLTextureView.cUp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.cUp) {
                this.cUK = true;
                GLTextureView.cUp.notifyAll();
                while (!this.cUJ && !this.mPaused) {
                    try {
                        GLTextureView.cUp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.cUp) {
                this.cUK = false;
                this.cUT = true;
                this.cUU = false;
                GLTextureView.cUp.notifyAll();
                while (!this.cUJ && this.mPaused && !this.cUU) {
                    try {
                        GLTextureView.cUp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ay(int i, int i2) {
            synchronized (GLTextureView.cUp) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cUV = true;
                this.cUT = true;
                this.cUU = false;
                GLTextureView.cUp.notifyAll();
                while (!this.cUJ && !this.mPaused && !this.cUU && aqc()) {
                    try {
                        GLTextureView.cUp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqg() {
            synchronized (GLTextureView.cUp) {
                this.cUI = true;
                GLTextureView.cUp.notifyAll();
                while (!this.cUJ) {
                    try {
                        GLTextureView.cUp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqh() {
            this.cUR = true;
            GLTextureView.cUp.notifyAll();
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
        if (this.cUr != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cUX;
        private int cUY;
        private boolean cUZ;
        private boolean cVa;
        private boolean cVb;
        private i cVc;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cUJ = true;
            if (this.cVc == iVar) {
                this.cVc = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cVc == iVar || this.cVc == null) {
                this.cVc = iVar;
                notifyAll();
                return true;
            }
            aqk();
            if (this.cVa) {
                return true;
            }
            if (this.cVc != null) {
                this.cVc.aqh();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cVc == iVar) {
                this.cVc = null;
            }
            notifyAll();
        }

        public synchronized boolean aqi() {
            return this.cVb;
        }

        public synchronized boolean aqj() {
            aqk();
            return !this.cVa;
        }

        public synchronized void c(GL10 gl10) {
            synchronized (this) {
                if (!this.cUZ) {
                    aqk();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cUY < 131072) {
                        this.cVa = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cVb = this.cVa ? false : true;
                    this.cUZ = true;
                }
            }
        }

        private void aqk() {
            if (!this.cUX) {
                this.cVa = true;
                this.cUX = true;
            }
        }
    }
}
