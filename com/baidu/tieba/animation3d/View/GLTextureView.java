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
    private static final j cQM = new j();
    private final WeakReference<GLTextureView> cQN;
    private i cQO;
    private TBGLSurfaceView.m cQP;
    private e cQQ;
    private f cQR;
    private g cQS;
    private k cQT;
    private int cQU;
    private int cQV;
    private boolean cQW;
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
        this.cQN = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cQN = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cQO != null) {
                this.cQO.aoT();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cQT = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cQU = i2;
    }

    public int getDebugFlags() {
        return this.cQU;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cQW = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cQW;
    }

    public void setRenderer(TBGLSurfaceView.m mVar) {
        aoF();
        if (this.cQQ == null) {
            this.cQQ = new m(true);
        }
        if (this.cQR == null) {
            this.cQR = new c();
        }
        if (this.cQS == null) {
            this.cQS = new d();
        }
        this.cQP = mVar;
        this.cQO = new i(this.cQN);
        this.cQO.start();
    }

    public void setEGLContextFactory(f fVar) {
        aoF();
        this.cQR = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aoF();
        this.cQS = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aoF();
        this.cQQ = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        aoF();
        this.cQV = i2;
    }

    public void setRenderMode(int i2) {
        this.cQO.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cQO.getRenderMode();
    }

    public void requestRender() {
        this.cQO.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cQO.aoR();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cQO.ax(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cQO.ax(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cQO.aoS();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cQO.onPause();
    }

    public void onResume() {
        this.cQO.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cQP != null) {
            int renderMode = this.cQO != null ? this.cQO.getRenderMode() : 1;
            this.cQO = new i(this.cQN);
            if (renderMode != 1) {
                this.cQO.setRenderMode(renderMode);
            }
            this.cQO.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cQO != null) {
            this.cQO.aoT();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.cQV, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.cQV == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.W("eglDestroyContex", egl10.eglGetError());
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
        protected int[] cQX;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cQX = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cQX, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cQX, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (GLTextureView.this.cQV == 2) {
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
        private WeakReference<GLTextureView> cQZ;
        EGL10 cRa;
        EGLDisplay cRb;
        EGLSurface cRc;
        EGLConfig cRd;
        EGLContext cRe;

        public h(WeakReference<GLTextureView> weakReference) {
            this.cQZ = weakReference;
        }

        public void start() {
            this.cRa = (EGL10) EGLContext.getEGL();
            this.cRb = this.cRa.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cRb == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cRa.eglInitialize(this.cRb, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.cQZ.get();
            if (gLTextureView != null) {
                this.cRd = gLTextureView.cQQ.chooseConfig(this.cRa, this.cRb);
                try {
                    this.cRe = gLTextureView.cQR.createContext(this.cRa, this.cRb, this.cRd);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.cRd = null;
                this.cRe = null;
            }
            if (this.cRe == null || this.cRe == EGL10.EGL_NO_CONTEXT) {
                this.cRe = null;
                my("createContext");
            }
            this.cRc = null;
        }

        public boolean aoH() {
            if (this.cRa == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cRb == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cRd == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aoL();
            GLTextureView gLTextureView = this.cQZ.get();
            if (gLTextureView != null) {
                this.cRc = gLTextureView.cQS.createWindowSurface(this.cRa, this.cRb, this.cRd, gLTextureView.getSurfaceTexture());
            } else {
                this.cRc = null;
            }
            if (this.cRc == null || this.cRc == EGL10.EGL_NO_SURFACE) {
                if (this.cRa.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cRa.eglMakeCurrent(this.cRb, this.cRc, this.cRc, this.cRe)) {
                g("EGLHelper", "eglMakeCurrent", this.cRa.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aoI() {
            l lVar;
            GL gl = this.cRe.getGL();
            GLTextureView gLTextureView = this.cQZ.get();
            if (gLTextureView != null) {
                if (gLTextureView.cQT != null) {
                    gl = gLTextureView.cQT.wrap(gl);
                }
                if ((gLTextureView.cQU & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.cQU & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.cQU & 2) == 0) {
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

        public int aoJ() {
            if (this.cRa.eglSwapBuffers(this.cRb, this.cRc)) {
                return 12288;
            }
            return this.cRa.eglGetError();
        }

        public void aoK() {
            aoL();
        }

        private void aoL() {
            if (this.cRc != null && this.cRc != EGL10.EGL_NO_SURFACE) {
                this.cRa.eglMakeCurrent(this.cRb, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.cQZ.get();
                if (gLTextureView != null) {
                    gLTextureView.cQS.destroySurface(this.cRa, this.cRb, this.cRc);
                }
                this.cRc = null;
            }
        }

        public void finish() {
            if (this.cRe != null) {
                GLTextureView gLTextureView = this.cQZ.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.cQR.destroyContext(this.cRa, this.cRb, this.cRe);
                    } catch (Exception e) {
                    }
                }
                this.cRe = null;
            }
            if (this.cRb != null) {
                this.cRa.eglTerminate(this.cRb);
                this.cRb = null;
            }
        }

        private void my(String str) {
            W(str, this.cRa.eglGetError());
        }

        public static void W(String str, int i) {
            throw new RuntimeException(X(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, X(str2, i));
        }

        public static String X(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<GLTextureView> cQZ;
        private boolean cRf;
        private boolean cRg;
        private boolean cRh;
        private boolean cRi;
        private boolean cRj;
        private boolean cRk;
        private boolean cRl;
        private boolean cRm;
        private boolean cRn;
        private boolean cRo;
        private boolean cRr;
        private h cRu;
        private boolean mPaused;
        private ArrayList<Runnable> cRs = new ArrayList<>();
        private boolean cRt = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cRq = true;
        private int cRp = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.cQZ = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aoO();
                    GLTextureView.cQM.a(this);
                } catch (Exception e) {
                    af.Dx().bt(false);
                    GLTextureView.cQM.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.cQM.a(this);
                throw th;
            }
        }

        private void aoM() {
            if (this.cRm) {
                this.cRm = false;
                this.cRu.aoK();
            }
        }

        private void aoN() {
            if (this.cRl) {
                this.cRu.finish();
                this.cRl = false;
                GLTextureView.cQM.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aoO() throws InterruptedException {
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
            this.cRu = new h(this.cQZ);
            this.cRl = false;
            this.cRm = false;
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
                    synchronized (GLTextureView.cQM) {
                        while (!this.cRf) {
                            if (this.cRs.isEmpty()) {
                                if (this.mPaused != this.cRh) {
                                    boolean z23 = this.cRh;
                                    this.mPaused = this.cRh;
                                    GLTextureView.cQM.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cRo) {
                                    aoM();
                                    aoN();
                                    this.cRo = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aoM();
                                    aoN();
                                    z19 = false;
                                }
                                if (z9 && this.cRm) {
                                    aoM();
                                }
                                if (z9 && this.cRl) {
                                    GLTextureView gLTextureView = this.cQZ.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.cQW) || GLTextureView.cQM.aoV()) {
                                        aoN();
                                    }
                                }
                                if (z9 && GLTextureView.cQM.aoW()) {
                                    this.cRu.finish();
                                }
                                if (!this.cRi && !this.cRk) {
                                    if (this.cRm) {
                                        aoM();
                                    }
                                    this.cRk = true;
                                    this.cRj = false;
                                    GLTextureView.cQM.notifyAll();
                                }
                                if (this.cRi && this.cRk) {
                                    this.cRk = false;
                                    GLTextureView.cQM.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cRr = true;
                                    GLTextureView.cQM.notifyAll();
                                }
                                if (aoQ()) {
                                    if (!this.cRl) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.cQM.b(this)) {
                                            try {
                                                this.cRu.start();
                                                this.cRl = true;
                                                z15 = true;
                                                GLTextureView.cQM.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.cQM.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cRl || this.cRm) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cRm = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cRm) {
                                        if (this.cRt) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cRt = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cRq = false;
                                        GLTextureView.cQM.notifyAll();
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
                                GLTextureView.cQM.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cRs.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (GLTextureView.cQM) {
                            aoM();
                            aoN();
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
                        } else if (this.cRu.aoH()) {
                            synchronized (GLTextureView.cQM) {
                                this.cRn = true;
                                GLTextureView.cQM.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.cQM) {
                                this.cRn = true;
                                this.cRj = true;
                                GLTextureView.cQM.notifyAll();
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
                            GL10 gl103 = (GL10) this.cRu.aoI();
                            GLTextureView.cQM.c(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.cQZ.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.cQP.onSurfaceCreated(gl10, this.cRu.cRd);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.cQZ.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.cQP.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.cQZ.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.cQP.onDrawFrame(gl10);
                        }
                        int aoJ = this.cRu.aoJ();
                        switch (aoJ) {
                            case 12288:
                                break;
                            case Statistics.kTypeWhiteScreen /* 12302 */:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", aoJ);
                                synchronized (GLTextureView.cQM) {
                                    this.cRj = true;
                                    GLTextureView.cQM.notifyAll();
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
                    synchronized (GLTextureView.cQM) {
                        aoM();
                        aoN();
                        throw th;
                    }
                }
            }
        }

        public boolean aoP() {
            return this.cRl && this.cRm && aoQ();
        }

        private boolean aoQ() {
            return !this.mPaused && this.cRi && !this.cRj && this.mWidth > 0 && this.mHeight > 0 && (this.cRq || this.cRp == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (GLTextureView.cQM) {
                    this.cRp = i;
                    GLTextureView.cQM.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.cQM) {
                i = this.cRp;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.cQM) {
                this.cRq = true;
                GLTextureView.cQM.notifyAll();
            }
        }

        public void aoR() {
            synchronized (GLTextureView.cQM) {
                this.cRi = true;
                this.cRn = false;
                GLTextureView.cQM.notifyAll();
                while (this.cRk && !this.cRn && !this.cRg) {
                    try {
                        GLTextureView.cQM.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aoS() {
            synchronized (GLTextureView.cQM) {
                this.cRi = false;
                GLTextureView.cQM.notifyAll();
                while (!this.cRk && !this.cRg) {
                    try {
                        GLTextureView.cQM.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.cQM) {
                this.cRh = true;
                GLTextureView.cQM.notifyAll();
                while (!this.cRg && !this.mPaused) {
                    try {
                        GLTextureView.cQM.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.cQM) {
                this.cRh = false;
                this.cRq = true;
                this.cRr = false;
                GLTextureView.cQM.notifyAll();
                while (!this.cRg && this.mPaused && !this.cRr) {
                    try {
                        GLTextureView.cQM.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ax(int i, int i2) {
            synchronized (GLTextureView.cQM) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cRt = true;
                this.cRq = true;
                this.cRr = false;
                GLTextureView.cQM.notifyAll();
                while (!this.cRg && !this.mPaused && !this.cRr && aoP()) {
                    try {
                        GLTextureView.cQM.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aoT() {
            synchronized (GLTextureView.cQM) {
                this.cRf = true;
                GLTextureView.cQM.notifyAll();
                while (!this.cRg) {
                    try {
                        GLTextureView.cQM.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aoU() {
            this.cRo = true;
            GLTextureView.cQM.notifyAll();
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

    private void aoF() {
        if (this.cQO != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i cRA;
        private boolean cRv;
        private int cRw;
        private boolean cRx;
        private boolean cRy;
        private boolean cRz;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cRg = true;
            if (this.cRA == iVar) {
                this.cRA = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cRA == iVar || this.cRA == null) {
                this.cRA = iVar;
                notifyAll();
                return true;
            }
            aoX();
            if (this.cRy) {
                return true;
            }
            if (this.cRA != null) {
                this.cRA.aoU();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cRA == iVar) {
                this.cRA = null;
            }
            notifyAll();
        }

        public synchronized boolean aoV() {
            return this.cRz;
        }

        public synchronized boolean aoW() {
            aoX();
            return !this.cRy;
        }

        public synchronized void c(GL10 gl10) {
            synchronized (this) {
                if (!this.cRx) {
                    aoX();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cRw < 131072) {
                        this.cRy = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cRz = this.cRy ? false : true;
                    this.cRx = true;
                }
            }
        }

        private void aoX() {
            if (!this.cRv) {
                this.cRy = true;
                this.cRv = true;
            }
        }
    }
}
