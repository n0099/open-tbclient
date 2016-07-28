package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.am;
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
public class a extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j aQR = new j(null);
    private final WeakReference<a> aQS;
    private i aQT;
    private GLSurfaceView.Renderer aQU;
    private e aQV;
    private f aQW;
    private g aQX;
    private k aQY;
    private int aQZ;
    private int aRa;
    private boolean aRb;
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

    public a(Context context) {
        super(context);
        this.aQS = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aQT != null) {
                this.aQT.Kt();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.aQY = kVar;
    }

    public void setDebugFlags(int i2) {
        this.aQZ = i2;
    }

    public int getDebugFlags() {
        return this.aQZ;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.aRb = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.aRb;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Kf();
        if (this.aQV == null) {
            this.aQV = new m(true);
        }
        if (this.aQW == null) {
            this.aQW = new c(this, null);
        }
        if (this.aQX == null) {
            this.aQX = new d(null);
        }
        this.aQU = renderer;
        this.aQT = new i(this.aQS);
        this.aQT.start();
    }

    public void setEGLContextFactory(f fVar) {
        Kf();
        this.aQW = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Kf();
        this.aQX = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Kf();
        this.aQV = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Kf();
        this.aRa = i2;
    }

    public void setRenderMode(int i2) {
        this.aQT.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.aQT.getRenderMode();
    }

    public void requestRender() {
        this.aQT.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aQT.Kr();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aQT.M(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.aQT.M(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.aQT.Ks();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.aQT.onPause();
    }

    public void onResume() {
        this.aQT.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.aQU != null) {
            int renderMode = this.aQT != null ? this.aQT.getRenderMode() : 1;
            this.aQT = new i(this.aQS);
            if (renderMode != 1) {
                this.aQT.setRenderMode(renderMode);
            }
            this.aQT.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.aQT != null) {
            this.aQT.Kt();
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

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        @Override // com.baidu.tieba.b.d.a.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.aRa, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.aRa == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.K("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements g {
        private d() {
        }

        /* synthetic */ d(d dVar) {
            this();
        }

        @Override // com.baidu.tieba.b.d.a.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.b.d.a.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: com.baidu.tieba.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private abstract class AbstractC0052a implements e {
        protected int[] aRc;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0052a(int[] iArr) {
            this.aRc = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aRc, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aRc, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.aRa == 2) {
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
    private class b extends AbstractC0052a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0052a
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
        private WeakReference<a> aRe;
        EGL10 aRf;
        EGLDisplay aRg;
        EGLSurface aRh;
        EGLConfig aRi;
        EGLContext aRj;

        public h(WeakReference<a> weakReference) {
            this.aRe = weakReference;
        }

        public void start() {
            this.aRf = (EGL10) EGLContext.getEGL();
            this.aRg = this.aRf.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.aRg == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.aRf.eglInitialize(this.aRg, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.aRe.get();
            if (aVar == null) {
                this.aRi = null;
                this.aRj = null;
            } else {
                this.aRi = aVar.aQV.chooseConfig(this.aRf, this.aRg);
                try {
                    this.aRj = aVar.aQW.createContext(this.aRf, this.aRg, this.aRi);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.aRj == null || this.aRj == EGL10.EGL_NO_CONTEXT) {
                this.aRj = null;
                gY("createContext");
            }
            this.aRh = null;
        }

        public boolean Kh() {
            if (this.aRf == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.aRg == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aRi == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Kl();
            a aVar = this.aRe.get();
            if (aVar != null) {
                this.aRh = aVar.aQX.createWindowSurface(this.aRf, this.aRg, this.aRi, aVar.getSurfaceTexture());
            } else {
                this.aRh = null;
            }
            if (this.aRh == null || this.aRh == EGL10.EGL_NO_SURFACE) {
                if (this.aRf.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.aRf.eglMakeCurrent(this.aRg, this.aRh, this.aRh, this.aRj)) {
                f("EGLHelper", "eglMakeCurrent", this.aRf.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Ki() {
            l lVar;
            GL gl = this.aRj.getGL();
            a aVar = this.aRe.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.aQY != null) {
                gl = aVar.aQY.wrap(gl);
            }
            if ((aVar.aQZ & 3) != 0) {
                int i = 0;
                if ((aVar.aQZ & 1) != 0) {
                    i = 1;
                }
                if ((aVar.aQZ & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Kj() {
            if (this.aRf.eglSwapBuffers(this.aRg, this.aRh)) {
                return 12288;
            }
            return this.aRf.eglGetError();
        }

        public void Kk() {
            Kl();
        }

        private void Kl() {
            if (this.aRh != null && this.aRh != EGL10.EGL_NO_SURFACE) {
                this.aRf.eglMakeCurrent(this.aRg, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.aRe.get();
                if (aVar != null) {
                    aVar.aQX.destroySurface(this.aRf, this.aRg, this.aRh);
                }
                this.aRh = null;
            }
        }

        public void finish() {
            if (this.aRj != null) {
                a aVar = this.aRe.get();
                if (aVar != null) {
                    try {
                        aVar.aQW.destroyContext(this.aRf, this.aRg, this.aRj);
                    } catch (Exception e) {
                    }
                }
                this.aRj = null;
            }
            if (this.aRg != null) {
                this.aRf.eglTerminate(this.aRg);
                this.aRg = null;
            }
        }

        private void gY(String str) {
            K(str, this.aRf.eglGetError());
        }

        public static void K(String str, int i) {
            throw new RuntimeException(L(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, L(str2, i));
        }

        public static String L(String str, int i) {
            return String.valueOf(str) + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private h aRA;
        private WeakReference<a> aRe;
        private boolean aRk;
        private boolean aRl;
        private boolean aRm;
        private boolean aRn;
        private boolean aRo;
        private boolean aRp;
        private boolean aRq;
        private boolean aRr;
        private boolean aRs;
        private boolean aRt;
        private boolean aRu;
        private boolean aRx;
        private ArrayList<Runnable> aRy = new ArrayList<>();
        private boolean aRz = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aRw = true;
        private int aRv = 1;

        i(WeakReference<a> weakReference) {
            this.aRe = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Ko();
                    a.aQR.a(this);
                } catch (Exception e) {
                    am.tM().az(false);
                    a.aQR.a(this);
                }
            } catch (Throwable th) {
                a.aQR.a(this);
                throw th;
            }
        }

        private void Km() {
            if (this.aRs) {
                this.aRs = false;
                this.aRA.Kk();
            }
        }

        private void Kn() {
            if (this.aRr) {
                this.aRA.finish();
                this.aRr = false;
                a.aQR.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Ko() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            int i;
            int i2;
            Runnable remove;
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
            this.aRA = new h(this.aRe);
            this.aRr = false;
            this.aRs = false;
            boolean z15 = false;
            GL10 gl102 = null;
            Runnable runnable = null;
            int i5 = 0;
            int i6 = 0;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            boolean z20 = false;
            boolean z21 = false;
            boolean z22 = false;
            while (true) {
                try {
                    sleep(4L);
                    synchronized (a.aQR) {
                        while (!this.aRk) {
                            if (this.aRy.isEmpty()) {
                                if (this.aRn != this.aRm) {
                                    boolean z23 = this.aRm;
                                    this.aRn = this.aRm;
                                    a.aQR.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.aRu) {
                                    Km();
                                    Kn();
                                    this.aRu = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Km();
                                    Kn();
                                    z20 = false;
                                }
                                if (z9 && this.aRs) {
                                    Km();
                                }
                                if (z9 && this.aRr) {
                                    a aVar = this.aRe.get();
                                    if (!(aVar == null ? false : aVar.aRb) || a.aQR.Kv()) {
                                        Kn();
                                    }
                                }
                                if (z9 && a.aQR.Kw()) {
                                    this.aRA.finish();
                                }
                                if (!this.aRo && !this.aRq) {
                                    if (this.aRs) {
                                        Km();
                                    }
                                    this.aRq = true;
                                    this.aRp = false;
                                    a.aQR.notifyAll();
                                }
                                if (this.aRo && this.aRq) {
                                    this.aRq = false;
                                    a.aQR.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.aRx = true;
                                    a.aQR.notifyAll();
                                }
                                if (Kq()) {
                                    if (!this.aRr) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.aQR.b(this)) {
                                            try {
                                                this.aRA.start();
                                                this.aRr = true;
                                                z15 = true;
                                                a.aQR.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.aQR.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.aRr || this.aRs) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.aRs = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.aRs) {
                                        if (this.aRz) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.aRz = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.aRw = false;
                                        a.aQR.notifyAll();
                                        z2 = z11;
                                        z5 = z13;
                                        i2 = i3;
                                        z = z12;
                                        z3 = z20;
                                        z4 = z14;
                                        z6 = z17;
                                        z7 = z16;
                                        i = i4;
                                        remove = runnable;
                                    } else {
                                        z21 = z11;
                                        z19 = z10;
                                    }
                                }
                                a.aQR.wait();
                            } else {
                                z = z22;
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i = i6;
                                i2 = i5;
                                remove = this.aRy.remove(0);
                            }
                        }
                        synchronized (a.aQR) {
                            Km();
                            Kn();
                        }
                        return;
                    }
                    if (remove != null) {
                        remove.run();
                        runnable = null;
                        i5 = i2;
                        i6 = i;
                        z16 = z7;
                        z17 = z6;
                        z18 = z5;
                        z19 = z4;
                        z20 = z3;
                        z21 = z2;
                        z22 = z;
                    } else {
                        if (!z) {
                            z8 = z;
                        } else if (this.aRA.Kh()) {
                            synchronized (a.aQR) {
                                this.aRt = true;
                                a.aQR.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.aQR) {
                                this.aRt = true;
                                this.aRp = true;
                                a.aQR.notifyAll();
                            }
                            runnable = remove;
                            i5 = i2;
                            i6 = i;
                            z16 = z7;
                            z17 = z6;
                            z18 = z5;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            z22 = z;
                        }
                        if (z2) {
                            GL10 gl103 = (GL10) this.aRA.Ki();
                            a.aQR.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.aRe.get();
                            if (aVar2 != null) {
                                aVar2.aQU.onSurfaceCreated(gl10, this.aRA.aRi);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.aRe.get();
                            if (aVar3 != null) {
                                aVar3.aQU.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.aRe.get();
                        if (aVar4 != null) {
                            aVar4.aQU.onDrawFrame(gl10);
                        }
                        int Kj = this.aRA.Kj();
                        switch (Kj) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Kj);
                                synchronized (a.aQR) {
                                    this.aRp = true;
                                    a.aQR.notifyAll();
                                    break;
                                }
                        }
                        if (z5) {
                            gl102 = gl10;
                            int i8 = i2;
                            i6 = i;
                            z16 = z7;
                            z17 = true;
                            z18 = z5;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            z22 = z8;
                            runnable = remove;
                            i5 = i8;
                        } else {
                            gl102 = gl10;
                            int i9 = i2;
                            i6 = i;
                            z16 = z7;
                            z17 = z6;
                            z18 = z5;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            z22 = z8;
                            runnable = remove;
                            i5 = i9;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (a.aQR) {
                        Km();
                        Kn();
                        throw th;
                    }
                }
            }
        }

        public boolean Kp() {
            return this.aRr && this.aRs && Kq();
        }

        private boolean Kq() {
            return !this.aRn && this.aRo && !this.aRp && this.mWidth > 0 && this.mHeight > 0 && (this.aRw || this.aRv == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.aQR) {
                this.aRv = i;
                a.aQR.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.aQR) {
                i = this.aRv;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.aQR) {
                this.aRw = true;
                a.aQR.notifyAll();
            }
        }

        public void Kr() {
            synchronized (a.aQR) {
                this.aRo = true;
                this.aRt = false;
                a.aQR.notifyAll();
                while (this.aRq && !this.aRt && !this.aRl) {
                    try {
                        a.aQR.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Ks() {
            synchronized (a.aQR) {
                this.aRo = false;
                a.aQR.notifyAll();
                while (!this.aRq && !this.aRl) {
                    try {
                        a.aQR.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.aQR) {
                this.aRm = true;
                a.aQR.notifyAll();
                while (!this.aRl && !this.aRn) {
                    try {
                        a.aQR.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.aQR) {
                this.aRm = false;
                this.aRw = true;
                this.aRx = false;
                a.aQR.notifyAll();
                while (!this.aRl && this.aRn && !this.aRx) {
                    try {
                        a.aQR.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void M(int i, int i2) {
            synchronized (a.aQR) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aRz = true;
                this.aRw = true;
                this.aRx = false;
                a.aQR.notifyAll();
                while (!this.aRl && !this.aRn && !this.aRx && Kp()) {
                    try {
                        a.aQR.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Kt() {
            synchronized (a.aQR) {
                this.aRk = true;
                a.aQR.notifyAll();
                while (!this.aRl) {
                    try {
                        a.aQR.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Ku() {
            this.aRu = true;
            a.aQR.notifyAll();
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

    private void Kf() {
        if (this.aQT != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean aRB;
        private int aRC;
        private boolean aRD;
        private boolean aRE;
        private boolean aRF;
        private i aRG;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.aRl = true;
            if (this.aRG == iVar) {
                this.aRG = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.aRG == iVar || this.aRG == null) {
                this.aRG = iVar;
                notifyAll();
                return true;
            }
            Kx();
            if (this.aRE) {
                return true;
            }
            if (this.aRG != null) {
                this.aRG.Ku();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.aRG == iVar) {
                this.aRG = null;
            }
            notifyAll();
        }

        public synchronized boolean Kv() {
            return this.aRF;
        }

        public synchronized boolean Kw() {
            Kx();
            return !this.aRE;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.aRD) {
                    Kx();
                    String glGetString = gl10.glGetString(7937);
                    if (this.aRC < 131072) {
                        this.aRE = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.aRF = this.aRE ? false : true;
                    this.aRD = true;
                }
            }
        }

        private void Kx() {
            if (!this.aRB) {
                this.aRE = true;
                this.aRB = true;
            }
        }
    }
}
