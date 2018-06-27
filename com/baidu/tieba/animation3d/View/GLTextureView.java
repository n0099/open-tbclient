package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ag;
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
    private static final j csh = new j();
    private final WeakReference<GLTextureView> csi;
    private i csj;
    private TBGLSurfaceView.m csk;
    private e csl;
    private f csm;
    private g csn;
    private k cso;
    private int csp;
    private int csq;
    private boolean csr;
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
        this.csi = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csi = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.csj != null) {
                this.csj.ahN();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cso = kVar;
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

    public void setRenderer(TBGLSurfaceView.m mVar) {
        ahA();
        if (this.csl == null) {
            this.csl = new m(true);
        }
        if (this.csm == null) {
            this.csm = new c();
        }
        if (this.csn == null) {
            this.csn = new d();
        }
        this.csk = mVar;
        this.csj = new i(this.csi);
        this.csj.start();
    }

    public void setEGLContextFactory(f fVar) {
        ahA();
        this.csm = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ahA();
        this.csn = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ahA();
        this.csl = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        ahA();
        this.csq = i2;
    }

    public void setRenderMode(int i2) {
        this.csj.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.csj.getRenderMode();
    }

    public void requestRender() {
        this.csj.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.csj.ahM();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.csj.ak(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.csj.ak(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.csj.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.csj.onPause();
    }

    public void onResume() {
        this.csj.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.csk != null) {
            int renderMode = this.csj != null ? this.csj.getRenderMode() : 1;
            this.csj = new i(this.csi);
            if (renderMode != 1) {
                this.csj.setRenderMode(renderMode);
            }
            this.csj.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.csj != null) {
            this.csj.ahN();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.csq, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.csq == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
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
        protected int[] css;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.css = i(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
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
            if (GLTextureView.this.csq == 2) {
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
        private WeakReference<GLTextureView> csu;
        EGL10 csv;
        EGLDisplay csw;
        EGLSurface csx;
        EGLConfig csy;
        EGLContext csz;

        public h(WeakReference<GLTextureView> weakReference) {
            this.csu = weakReference;
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
            GLTextureView gLTextureView = this.csu.get();
            if (gLTextureView != null) {
                this.csy = gLTextureView.csl.chooseConfig(this.csv, this.csw);
                try {
                    this.csz = gLTextureView.csm.createContext(this.csv, this.csw, this.csy);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
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
            GLTextureView gLTextureView = this.csu.get();
            if (gLTextureView != null) {
                this.csx = gLTextureView.csn.createWindowSurface(this.csv, this.csw, this.csy, gLTextureView.getSurfaceTexture());
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
            GLTextureView gLTextureView = this.csu.get();
            if (gLTextureView != null) {
                if (gLTextureView.cso != null) {
                    gl = gLTextureView.cso.wrap(gl);
                }
                if ((gLTextureView.csp & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.csp & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.csp & 2) == 0) {
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
                GLTextureView gLTextureView = this.csu.get();
                if (gLTextureView != null) {
                    gLTextureView.csn.destroySurface(this.csv, this.csw, this.csx);
                }
                this.csx = null;
            }
        }

        public void finish() {
            if (this.csz != null) {
                GLTextureView gLTextureView = this.csu.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.csm.destroyContext(this.csv, this.csw, this.csz);
                    } catch (Exception e) {
                    }
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
            return str + " failed";
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
        private h csP;
        private WeakReference<GLTextureView> csu;
        private boolean mPaused;
        private ArrayList<Runnable> csN = new ArrayList<>();
        private boolean csO = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean csL = true;
        private int csK = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.csu = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ahJ();
                    GLTextureView.csh.a(this);
                } catch (Exception e) {
                    ag.zl().aJ(false);
                    GLTextureView.csh.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.csh.a(this);
                throw th;
            }
        }

        private void ahH() {
            if (this.csH) {
                this.csH = false;
                this.csP.ahF();
            }
        }

        private void ahI() {
            if (this.csG) {
                this.csP.finish();
                this.csG = false;
                GLTextureView.csh.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
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
            this.csP = new h(this.csu);
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
                    sleep(4L);
                    synchronized (GLTextureView.csh) {
                        while (!this.csA) {
                            if (this.csN.isEmpty()) {
                                if (this.mPaused != this.csC) {
                                    boolean z23 = this.csC;
                                    this.mPaused = this.csC;
                                    GLTextureView.csh.notifyAll();
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
                                    GLTextureView gLTextureView = this.csu.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.csr) || GLTextureView.csh.ahP()) {
                                        ahI();
                                    }
                                }
                                if (z9 && GLTextureView.csh.ahQ()) {
                                    this.csP.finish();
                                }
                                if (!this.csD && !this.csF) {
                                    if (this.csH) {
                                        ahH();
                                    }
                                    this.csF = true;
                                    this.csE = false;
                                    GLTextureView.csh.notifyAll();
                                }
                                if (this.csD && this.csF) {
                                    this.csF = false;
                                    GLTextureView.csh.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.csM = true;
                                    GLTextureView.csh.notifyAll();
                                }
                                if (ahL()) {
                                    if (!this.csG) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.csh.b(this)) {
                                            try {
                                                this.csP.start();
                                                this.csG = true;
                                                z15 = true;
                                                GLTextureView.csh.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.csh.c(this);
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
                                        GLTextureView.csh.notifyAll();
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
                                GLTextureView.csh.wait();
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
                        synchronized (GLTextureView.csh) {
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
                        } else if (this.csP.ahC()) {
                            synchronized (GLTextureView.csh) {
                                this.csI = true;
                                GLTextureView.csh.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.csh) {
                                this.csI = true;
                                this.csE = true;
                                GLTextureView.csh.notifyAll();
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
                            GL10 gl103 = (GL10) this.csP.ahD();
                            GLTextureView.csh.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.csu.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.csk.onSurfaceCreated(gl10, this.csP.csy);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.csu.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.csk.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.csu.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.csk.onDrawFrame(gl10);
                        }
                        int ahE = this.csP.ahE();
                        switch (ahE) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", ahE);
                                synchronized (GLTextureView.csh) {
                                    this.csE = true;
                                    GLTextureView.csh.notifyAll();
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
                    synchronized (GLTextureView.csh) {
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
                synchronized (GLTextureView.csh) {
                    this.csK = i;
                    GLTextureView.csh.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.csh) {
                i = this.csK;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.csh) {
                this.csL = true;
                GLTextureView.csh.notifyAll();
            }
        }

        public void ahM() {
            synchronized (GLTextureView.csh) {
                this.csD = true;
                this.csI = false;
                GLTextureView.csh.notifyAll();
                while (this.csF && !this.csI && !this.csB) {
                    try {
                        GLTextureView.csh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLTextureView.csh) {
                this.csD = false;
                GLTextureView.csh.notifyAll();
                while (!this.csF && !this.csB) {
                    try {
                        GLTextureView.csh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.csh) {
                this.csC = true;
                GLTextureView.csh.notifyAll();
                while (!this.csB && !this.mPaused) {
                    try {
                        GLTextureView.csh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.csh) {
                this.csC = false;
                this.csL = true;
                this.csM = false;
                GLTextureView.csh.notifyAll();
                while (!this.csB && this.mPaused && !this.csM) {
                    try {
                        GLTextureView.csh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (GLTextureView.csh) {
                this.mWidth = i;
                this.mHeight = i2;
                this.csO = true;
                this.csL = true;
                this.csM = false;
                GLTextureView.csh.notifyAll();
                while (!this.csB && !this.mPaused && !this.csM && ahK()) {
                    try {
                        GLTextureView.csh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ahN() {
            synchronized (GLTextureView.csh) {
                this.csA = true;
                GLTextureView.csh.notifyAll();
                while (!this.csB) {
                    try {
                        GLTextureView.csh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ahO() {
            this.csJ = true;
            GLTextureView.csh.notifyAll();
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
        if (this.csj != null) {
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
        private i csV;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.csB = true;
            if (this.csV == iVar) {
                this.csV = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.csV == iVar || this.csV == null) {
                this.csV = iVar;
                notifyAll();
                return true;
            }
            ahR();
            if (this.csT) {
                return true;
            }
            if (this.csV != null) {
                this.csV.ahO();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.csV == iVar) {
                this.csV = null;
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
