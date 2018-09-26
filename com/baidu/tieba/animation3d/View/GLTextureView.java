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
    private static final j cAx = new j();
    private TBGLSurfaceView.m cAA;
    private e cAB;
    private f cAC;
    private g cAD;
    private k cAE;
    private int cAF;
    private int cAG;
    private boolean cAH;
    private final WeakReference<GLTextureView> cAy;
    private i cAz;
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
        this.cAy = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAy = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cAz != null) {
                this.cAz.akb();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cAE = kVar;
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

    public void setRenderer(TBGLSurfaceView.m mVar) {
        ajO();
        if (this.cAB == null) {
            this.cAB = new m(true);
        }
        if (this.cAC == null) {
            this.cAC = new c();
        }
        if (this.cAD == null) {
            this.cAD = new d();
        }
        this.cAA = mVar;
        this.cAz = new i(this.cAy);
        this.cAz.start();
    }

    public void setEGLContextFactory(f fVar) {
        ajO();
        this.cAC = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ajO();
        this.cAD = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ajO();
        this.cAB = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        ajO();
        this.cAG = i2;
    }

    public void setRenderMode(int i2) {
        this.cAz.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cAz.getRenderMode();
    }

    public void requestRender() {
        this.cAz.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cAz.aka();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cAz.ar(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cAz.ar(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cAz.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cAz.onPause();
    }

    public void onResume() {
        this.cAz.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cAA != null) {
            int renderMode = this.cAz != null ? this.cAz.getRenderMode() : 1;
            this.cAz = new i(this.cAy);
            if (renderMode != 1) {
                this.cAz.setRenderMode(renderMode);
            }
            this.cAz.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cAz != null) {
            this.cAz.akb();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.cAG, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.cAG == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
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
        protected int[] cAI;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cAI = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
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
            if (GLTextureView.this.cAG == 2) {
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
        private WeakReference<GLTextureView> cAK;
        EGL10 cAL;
        EGLDisplay cAM;
        EGLSurface cAN;
        EGLConfig cAO;
        EGLContext cAP;

        public h(WeakReference<GLTextureView> weakReference) {
            this.cAK = weakReference;
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
            GLTextureView gLTextureView = this.cAK.get();
            if (gLTextureView != null) {
                this.cAO = gLTextureView.cAB.chooseConfig(this.cAL, this.cAM);
                try {
                    this.cAP = gLTextureView.cAC.createContext(this.cAL, this.cAM, this.cAO);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
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
            GLTextureView gLTextureView = this.cAK.get();
            if (gLTextureView != null) {
                this.cAN = gLTextureView.cAD.createWindowSurface(this.cAL, this.cAM, this.cAO, gLTextureView.getSurfaceTexture());
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
            GLTextureView gLTextureView = this.cAK.get();
            if (gLTextureView != null) {
                if (gLTextureView.cAE != null) {
                    gl = gLTextureView.cAE.wrap(gl);
                }
                if ((gLTextureView.cAF & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.cAF & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.cAF & 2) == 0) {
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
                GLTextureView gLTextureView = this.cAK.get();
                if (gLTextureView != null) {
                    gLTextureView.cAD.destroySurface(this.cAL, this.cAM, this.cAN);
                }
                this.cAN = null;
            }
        }

        public void finish() {
            if (this.cAP != null) {
                GLTextureView gLTextureView = this.cAK.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.cAC.destroyContext(this.cAL, this.cAM, this.cAP);
                    } catch (Exception e) {
                    }
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
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<GLTextureView> cAK;
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
        private h cBf;
        private boolean mPaused;
        private ArrayList<Runnable> cBd = new ArrayList<>();
        private boolean cBe = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cBb = true;
        private int cBa = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.cAK = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ajX();
                    GLTextureView.cAx.a(this);
                } catch (Exception e) {
                    af.Af().aS(false);
                    GLTextureView.cAx.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.cAx.a(this);
                throw th;
            }
        }

        private void ajV() {
            if (this.cAX) {
                this.cAX = false;
                this.cBf.ajT();
            }
        }

        private void ajW() {
            if (this.cAW) {
                this.cBf.finish();
                this.cAW = false;
                GLTextureView.cAx.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
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
            this.cBf = new h(this.cAK);
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
                    sleep(4L);
                    synchronized (GLTextureView.cAx) {
                        while (!this.cAQ) {
                            if (this.cBd.isEmpty()) {
                                if (this.mPaused != this.cAS) {
                                    boolean z23 = this.cAS;
                                    this.mPaused = this.cAS;
                                    GLTextureView.cAx.notifyAll();
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
                                    GLTextureView gLTextureView = this.cAK.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.cAH) || GLTextureView.cAx.akd()) {
                                        ajW();
                                    }
                                }
                                if (z9 && GLTextureView.cAx.ake()) {
                                    this.cBf.finish();
                                }
                                if (!this.cAT && !this.cAV) {
                                    if (this.cAX) {
                                        ajV();
                                    }
                                    this.cAV = true;
                                    this.cAU = false;
                                    GLTextureView.cAx.notifyAll();
                                }
                                if (this.cAT && this.cAV) {
                                    this.cAV = false;
                                    GLTextureView.cAx.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cBc = true;
                                    GLTextureView.cAx.notifyAll();
                                }
                                if (ajZ()) {
                                    if (!this.cAW) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.cAx.b(this)) {
                                            try {
                                                this.cBf.start();
                                                this.cAW = true;
                                                z15 = true;
                                                GLTextureView.cAx.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.cAx.c(this);
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
                                        GLTextureView.cAx.notifyAll();
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
                                GLTextureView.cAx.wait();
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
                        synchronized (GLTextureView.cAx) {
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
                        } else if (this.cBf.ajQ()) {
                            synchronized (GLTextureView.cAx) {
                                this.cAY = true;
                                GLTextureView.cAx.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.cAx) {
                                this.cAY = true;
                                this.cAU = true;
                                GLTextureView.cAx.notifyAll();
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
                            GL10 gl103 = (GL10) this.cBf.ajR();
                            GLTextureView.cAx.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.cAK.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.cAA.onSurfaceCreated(gl10, this.cBf.cAO);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.cAK.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.cAA.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.cAK.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.cAA.onDrawFrame(gl10);
                        }
                        int ajS = this.cBf.ajS();
                        switch (ajS) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", ajS);
                                synchronized (GLTextureView.cAx) {
                                    this.cAU = true;
                                    GLTextureView.cAx.notifyAll();
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
                    synchronized (GLTextureView.cAx) {
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
                synchronized (GLTextureView.cAx) {
                    this.cBa = i;
                    GLTextureView.cAx.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.cAx) {
                i = this.cBa;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.cAx) {
                this.cBb = true;
                GLTextureView.cAx.notifyAll();
            }
        }

        public void aka() {
            synchronized (GLTextureView.cAx) {
                this.cAT = true;
                this.cAY = false;
                GLTextureView.cAx.notifyAll();
                while (this.cAV && !this.cAY && !this.cAR) {
                    try {
                        GLTextureView.cAx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLTextureView.cAx) {
                this.cAT = false;
                GLTextureView.cAx.notifyAll();
                while (!this.cAV && !this.cAR) {
                    try {
                        GLTextureView.cAx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.cAx) {
                this.cAS = true;
                GLTextureView.cAx.notifyAll();
                while (!this.cAR && !this.mPaused) {
                    try {
                        GLTextureView.cAx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.cAx) {
                this.cAS = false;
                this.cBb = true;
                this.cBc = false;
                GLTextureView.cAx.notifyAll();
                while (!this.cAR && this.mPaused && !this.cBc) {
                    try {
                        GLTextureView.cAx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ar(int i, int i2) {
            synchronized (GLTextureView.cAx) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cBe = true;
                this.cBb = true;
                this.cBc = false;
                GLTextureView.cAx.notifyAll();
                while (!this.cAR && !this.mPaused && !this.cBc && ajY()) {
                    try {
                        GLTextureView.cAx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void akb() {
            synchronized (GLTextureView.cAx) {
                this.cAQ = true;
                GLTextureView.cAx.notifyAll();
                while (!this.cAR) {
                    try {
                        GLTextureView.cAx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void akc() {
            this.cAZ = true;
            GLTextureView.cAx.notifyAll();
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
        if (this.cAz != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cBg;
        private int cBh;
        private boolean cBi;
        private boolean cBj;
        private boolean cBk;
        private i cBl;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cAR = true;
            if (this.cBl == iVar) {
                this.cBl = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cBl == iVar || this.cBl == null) {
                this.cBl = iVar;
                notifyAll();
                return true;
            }
            akf();
            if (this.cBj) {
                return true;
            }
            if (this.cBl != null) {
                this.cBl.akc();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cBl == iVar) {
                this.cBl = null;
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
