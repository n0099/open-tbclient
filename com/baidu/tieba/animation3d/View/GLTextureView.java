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
    private static final j cUo = new j();
    private final WeakReference<GLTextureView> cUp;
    private i cUq;
    private TBGLSurfaceView.m cUr;
    private e cUs;
    private f cUt;
    private g cUu;
    private k cUv;
    private int cUw;
    private int cUx;
    private boolean cUy;
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
        this.cUp = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUp = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cUq != null) {
                this.cUq.aqg();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cUv = kVar;
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

    public void setRenderer(TBGLSurfaceView.m mVar) {
        apS();
        if (this.cUs == null) {
            this.cUs = new m(true);
        }
        if (this.cUt == null) {
            this.cUt = new c();
        }
        if (this.cUu == null) {
            this.cUu = new d();
        }
        this.cUr = mVar;
        this.cUq = new i(this.cUp);
        this.cUq.start();
    }

    public void setEGLContextFactory(f fVar) {
        apS();
        this.cUt = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        apS();
        this.cUu = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        apS();
        this.cUs = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        apS();
        this.cUx = i2;
    }

    public void setRenderMode(int i2) {
        this.cUq.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cUq.getRenderMode();
    }

    public void requestRender() {
        this.cUq.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cUq.aqe();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cUq.ay(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cUq.ay(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cUq.aqf();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cUq.onPause();
    }

    public void onResume() {
        this.cUq.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cUr != null) {
            int renderMode = this.cUq != null ? this.cUq.getRenderMode() : 1;
            this.cUq = new i(this.cUp);
            if (renderMode != 1) {
                this.cUq.setRenderMode(renderMode);
            }
            this.cUq.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cUq != null) {
            this.cUq.aqg();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.cUx, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.cUx == 0) {
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
        protected int[] cUz;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cUz = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
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
            if (GLTextureView.this.cUx == 2) {
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
        private WeakReference<GLTextureView> cUB;
        EGL10 cUC;
        EGLDisplay cUD;
        EGLSurface cUE;
        EGLConfig cUF;
        EGLContext cUG;

        public h(WeakReference<GLTextureView> weakReference) {
            this.cUB = weakReference;
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
            GLTextureView gLTextureView = this.cUB.get();
            if (gLTextureView != null) {
                this.cUF = gLTextureView.cUs.chooseConfig(this.cUC, this.cUD);
                try {
                    this.cUG = gLTextureView.cUt.createContext(this.cUC, this.cUD, this.cUF);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
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
            GLTextureView gLTextureView = this.cUB.get();
            if (gLTextureView != null) {
                this.cUE = gLTextureView.cUu.createWindowSurface(this.cUC, this.cUD, this.cUF, gLTextureView.getSurfaceTexture());
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
            GLTextureView gLTextureView = this.cUB.get();
            if (gLTextureView != null) {
                if (gLTextureView.cUv != null) {
                    gl = gLTextureView.cUv.wrap(gl);
                }
                if ((gLTextureView.cUw & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.cUw & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.cUw & 2) == 0) {
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
                GLTextureView gLTextureView = this.cUB.get();
                if (gLTextureView != null) {
                    gLTextureView.cUu.destroySurface(this.cUC, this.cUD, this.cUE);
                }
                this.cUE = null;
            }
        }

        public void finish() {
            if (this.cUG != null) {
                GLTextureView gLTextureView = this.cUB.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.cUt.destroyContext(this.cUC, this.cUD, this.cUG);
                    } catch (Exception e) {
                    }
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
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<GLTextureView> cUB;
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
        private h cUV;
        private boolean mPaused;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean cUU = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cUS = true;
        private int cUR = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.cUB = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aqb();
                    GLTextureView.cUo.a(this);
                } catch (Exception e) {
                    af.DK().bu(false);
                    GLTextureView.cUo.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.cUo.a(this);
                throw th;
            }
        }

        private void apZ() {
            if (this.cUO) {
                this.cUO = false;
                this.cUV.apX();
            }
        }

        private void aqa() {
            if (this.cUN) {
                this.cUV.finish();
                this.cUN = false;
                GLTextureView.cUo.c(this);
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
            this.cUV = new h(this.cUB);
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
                    sleep(4L);
                    synchronized (GLTextureView.cUo) {
                        while (!this.cUH) {
                            if (this.mEventQueue.isEmpty()) {
                                if (this.mPaused != this.cUJ) {
                                    boolean z23 = this.cUJ;
                                    this.mPaused = this.cUJ;
                                    GLTextureView.cUo.notifyAll();
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
                                    GLTextureView gLTextureView = this.cUB.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.cUy) || GLTextureView.cUo.aqi()) {
                                        aqa();
                                    }
                                }
                                if (z9 && GLTextureView.cUo.aqj()) {
                                    this.cUV.finish();
                                }
                                if (!this.cUK && !this.cUM) {
                                    if (this.cUO) {
                                        apZ();
                                    }
                                    this.cUM = true;
                                    this.cUL = false;
                                    GLTextureView.cUo.notifyAll();
                                }
                                if (this.cUK && this.cUM) {
                                    this.cUM = false;
                                    GLTextureView.cUo.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cUT = true;
                                    GLTextureView.cUo.notifyAll();
                                }
                                if (aqd()) {
                                    if (!this.cUN) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.cUo.b(this)) {
                                            try {
                                                this.cUV.start();
                                                this.cUN = true;
                                                z15 = true;
                                                GLTextureView.cUo.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.cUo.c(this);
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
                                        GLTextureView.cUo.notifyAll();
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
                                GLTextureView.cUo.wait();
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
                        synchronized (GLTextureView.cUo) {
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
                        } else if (this.cUV.apU()) {
                            synchronized (GLTextureView.cUo) {
                                this.cUP = true;
                                GLTextureView.cUo.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.cUo) {
                                this.cUP = true;
                                this.cUL = true;
                                GLTextureView.cUo.notifyAll();
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
                            GL10 gl103 = (GL10) this.cUV.apV();
                            GLTextureView.cUo.c(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.cUB.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.cUr.onSurfaceCreated(gl10, this.cUV.cUF);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.cUB.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.cUr.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.cUB.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.cUr.onDrawFrame(gl10);
                        }
                        int apW = this.cUV.apW();
                        switch (apW) {
                            case 12288:
                                break;
                            case Statistics.kTypeWhiteScreen /* 12302 */:
                                z4 = true;
                                break;
                            default:
                                h.h("GLThread", "eglSwapBuffers", apW);
                                synchronized (GLTextureView.cUo) {
                                    this.cUL = true;
                                    GLTextureView.cUo.notifyAll();
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
                    synchronized (GLTextureView.cUo) {
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
                synchronized (GLTextureView.cUo) {
                    this.cUR = i;
                    GLTextureView.cUo.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.cUo) {
                i = this.cUR;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.cUo) {
                this.cUS = true;
                GLTextureView.cUo.notifyAll();
            }
        }

        public void aqe() {
            synchronized (GLTextureView.cUo) {
                this.cUK = true;
                this.cUP = false;
                GLTextureView.cUo.notifyAll();
                while (this.cUM && !this.cUP && !this.cUI) {
                    try {
                        GLTextureView.cUo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqf() {
            synchronized (GLTextureView.cUo) {
                this.cUK = false;
                GLTextureView.cUo.notifyAll();
                while (!this.cUM && !this.cUI) {
                    try {
                        GLTextureView.cUo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.cUo) {
                this.cUJ = true;
                GLTextureView.cUo.notifyAll();
                while (!this.cUI && !this.mPaused) {
                    try {
                        GLTextureView.cUo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.cUo) {
                this.cUJ = false;
                this.cUS = true;
                this.cUT = false;
                GLTextureView.cUo.notifyAll();
                while (!this.cUI && this.mPaused && !this.cUT) {
                    try {
                        GLTextureView.cUo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ay(int i, int i2) {
            synchronized (GLTextureView.cUo) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cUU = true;
                this.cUS = true;
                this.cUT = false;
                GLTextureView.cUo.notifyAll();
                while (!this.cUI && !this.mPaused && !this.cUT && aqc()) {
                    try {
                        GLTextureView.cUo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqg() {
            synchronized (GLTextureView.cUo) {
                this.cUH = true;
                GLTextureView.cUo.notifyAll();
                while (!this.cUI) {
                    try {
                        GLTextureView.cUo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aqh() {
            this.cUQ = true;
            GLTextureView.cUo.notifyAll();
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
        if (this.cUq != null) {
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
        private i cVb;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cUI = true;
            if (this.cVb == iVar) {
                this.cVb = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cVb == iVar || this.cVb == null) {
                this.cVb = iVar;
                notifyAll();
                return true;
            }
            aqk();
            if (this.cUZ) {
                return true;
            }
            if (this.cVb != null) {
                this.cVb.aqh();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cVb == iVar) {
                this.cVb = null;
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
