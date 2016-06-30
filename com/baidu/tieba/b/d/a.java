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
    private static final j aPX = new j(null);
    private final WeakReference<a> aPY;
    private i aPZ;
    private GLSurfaceView.Renderer aQa;
    private e aQb;
    private f aQc;
    private g aQd;
    private k aQe;
    private int aQf;
    private int aQg;
    private boolean aQh;
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
        this.aPY = new WeakReference<>(this);
        init();
    }

    protected void finalize() {
        try {
            if (this.aPZ != null) {
                this.aPZ.Ku();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.aQe = kVar;
    }

    public void setDebugFlags(int i2) {
        this.aQf = i2;
    }

    public int getDebugFlags() {
        return this.aQf;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.aQh = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.aQh;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Kg();
        if (this.aQb == null) {
            this.aQb = new m(true);
        }
        if (this.aQc == null) {
            this.aQc = new c(this, null);
        }
        if (this.aQd == null) {
            this.aQd = new d(null);
        }
        this.aQa = renderer;
        this.aPZ = new i(this.aPY);
        this.aPZ.start();
    }

    public void setEGLContextFactory(f fVar) {
        Kg();
        this.aQc = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Kg();
        this.aQd = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Kg();
        this.aQb = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Kg();
        this.aQg = i2;
    }

    public void setRenderMode(int i2) {
        this.aPZ.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.aPZ.getRenderMode();
    }

    public void requestRender() {
        this.aPZ.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aPZ.Ks();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aPZ.M(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.aPZ.M(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.aPZ.Kt();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.aPZ.onPause();
    }

    public void onResume() {
        this.aPZ.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.aQa != null) {
            int renderMode = this.aPZ != null ? this.aPZ.getRenderMode() : 1;
            this.aPZ = new i(this.aPY);
            if (renderMode != 1) {
                this.aPZ.setRenderMode(renderMode);
            }
            this.aPZ.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.aPZ != null) {
            this.aPZ.Ku();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.aQg, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.aQg == 0) {
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
    private abstract class AbstractC0051a implements e {
        protected int[] aQi;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0051a(int[] iArr) {
            this.aQi = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aQi, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aQi, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.aQg == 2) {
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
    private class b extends AbstractC0051a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0051a
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
        private WeakReference<a> aQk;
        EGL10 aQl;
        EGLDisplay aQm;
        EGLSurface aQn;
        EGLConfig aQo;
        EGLContext aQp;

        public h(WeakReference<a> weakReference) {
            this.aQk = weakReference;
        }

        public void start() {
            this.aQl = (EGL10) EGLContext.getEGL();
            this.aQm = this.aQl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.aQm == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.aQl.eglInitialize(this.aQm, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.aQk.get();
            if (aVar == null) {
                this.aQo = null;
                this.aQp = null;
            } else {
                this.aQo = aVar.aQb.chooseConfig(this.aQl, this.aQm);
                try {
                    this.aQp = aVar.aQc.createContext(this.aQl, this.aQm, this.aQo);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.aQp == null || this.aQp == EGL10.EGL_NO_CONTEXT) {
                this.aQp = null;
                gY("createContext");
            }
            this.aQn = null;
        }

        public boolean Ki() {
            if (this.aQl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.aQm == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aQo == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Km();
            a aVar = this.aQk.get();
            if (aVar != null) {
                this.aQn = aVar.aQd.createWindowSurface(this.aQl, this.aQm, this.aQo, aVar.getSurfaceTexture());
            } else {
                this.aQn = null;
            }
            if (this.aQn == null || this.aQn == EGL10.EGL_NO_SURFACE) {
                if (this.aQl.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.aQl.eglMakeCurrent(this.aQm, this.aQn, this.aQn, this.aQp)) {
                f("EGLHelper", "eglMakeCurrent", this.aQl.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Kj() {
            l lVar;
            GL gl = this.aQp.getGL();
            a aVar = this.aQk.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.aQe != null) {
                gl = aVar.aQe.wrap(gl);
            }
            if ((aVar.aQf & 3) != 0) {
                int i = 0;
                if ((aVar.aQf & 1) != 0) {
                    i = 1;
                }
                if ((aVar.aQf & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Kk() {
            if (this.aQl.eglSwapBuffers(this.aQm, this.aQn)) {
                return 12288;
            }
            return this.aQl.eglGetError();
        }

        public void Kl() {
            Km();
        }

        private void Km() {
            if (this.aQn != null && this.aQn != EGL10.EGL_NO_SURFACE) {
                this.aQl.eglMakeCurrent(this.aQm, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.aQk.get();
                if (aVar != null) {
                    aVar.aQd.destroySurface(this.aQl, this.aQm, this.aQn);
                }
                this.aQn = null;
            }
        }

        public void finish() {
            if (this.aQp != null) {
                a aVar = this.aQk.get();
                if (aVar != null) {
                    try {
                        aVar.aQc.destroyContext(this.aQl, this.aQm, this.aQp);
                    } catch (Exception e) {
                    }
                }
                this.aQp = null;
            }
            if (this.aQm != null) {
                this.aQl.eglTerminate(this.aQm);
                this.aQm = null;
            }
        }

        private void gY(String str) {
            K(str, this.aQl.eglGetError());
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
        private boolean aQA;
        private boolean aQD;
        private h aQG;
        private WeakReference<a> aQk;
        private boolean aQq;
        private boolean aQr;
        private boolean aQs;
        private boolean aQt;
        private boolean aQu;
        private boolean aQv;
        private boolean aQw;
        private boolean aQx;
        private boolean aQy;
        private boolean aQz;
        private ArrayList<Runnable> aQE = new ArrayList<>();
        private boolean aQF = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aQC = true;
        private int aQB = 1;

        i(WeakReference<a> weakReference) {
            this.aQk = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Kp();
                    a.aPX.a(this);
                } catch (Exception e) {
                    am.tN().aw(false);
                    a.aPX.a(this);
                }
            } catch (Throwable th) {
                a.aPX.a(this);
                throw th;
            }
        }

        private void Kn() {
            if (this.aQy) {
                this.aQy = false;
                this.aQG.Kl();
            }
        }

        private void Ko() {
            if (this.aQx) {
                this.aQG.finish();
                this.aQx = false;
                a.aPX.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Kp() {
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
            this.aQG = new h(this.aQk);
            this.aQx = false;
            this.aQy = false;
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
                    synchronized (a.aPX) {
                        while (!this.aQq) {
                            if (this.aQE.isEmpty()) {
                                if (this.aQt != this.aQs) {
                                    boolean z23 = this.aQs;
                                    this.aQt = this.aQs;
                                    a.aPX.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.aQA) {
                                    Kn();
                                    Ko();
                                    this.aQA = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Kn();
                                    Ko();
                                    z20 = false;
                                }
                                if (z9 && this.aQy) {
                                    Kn();
                                }
                                if (z9 && this.aQx) {
                                    a aVar = this.aQk.get();
                                    if (!(aVar == null ? false : aVar.aQh) || a.aPX.Kw()) {
                                        Ko();
                                    }
                                }
                                if (z9 && a.aPX.Kx()) {
                                    this.aQG.finish();
                                }
                                if (!this.aQu && !this.aQw) {
                                    if (this.aQy) {
                                        Kn();
                                    }
                                    this.aQw = true;
                                    this.aQv = false;
                                    a.aPX.notifyAll();
                                }
                                if (this.aQu && this.aQw) {
                                    this.aQw = false;
                                    a.aPX.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.aQD = true;
                                    a.aPX.notifyAll();
                                }
                                if (Kr()) {
                                    if (!this.aQx) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.aPX.b(this)) {
                                            try {
                                                this.aQG.start();
                                                this.aQx = true;
                                                z15 = true;
                                                a.aPX.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.aPX.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.aQx || this.aQy) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.aQy = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.aQy) {
                                        if (this.aQF) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.aQF = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.aQC = false;
                                        a.aPX.notifyAll();
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
                                a.aPX.wait();
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
                                remove = this.aQE.remove(0);
                            }
                        }
                        synchronized (a.aPX) {
                            Kn();
                            Ko();
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
                        } else if (this.aQG.Ki()) {
                            synchronized (a.aPX) {
                                this.aQz = true;
                                a.aPX.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.aPX) {
                                this.aQz = true;
                                this.aQv = true;
                                a.aPX.notifyAll();
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
                            GL10 gl103 = (GL10) this.aQG.Kj();
                            a.aPX.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.aQk.get();
                            if (aVar2 != null) {
                                aVar2.aQa.onSurfaceCreated(gl10, this.aQG.aQo);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.aQk.get();
                            if (aVar3 != null) {
                                aVar3.aQa.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.aQk.get();
                        if (aVar4 != null) {
                            aVar4.aQa.onDrawFrame(gl10);
                        }
                        int Kk = this.aQG.Kk();
                        switch (Kk) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Kk);
                                synchronized (a.aPX) {
                                    this.aQv = true;
                                    a.aPX.notifyAll();
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
                    synchronized (a.aPX) {
                        Kn();
                        Ko();
                        throw th;
                    }
                }
            }
        }

        public boolean Kq() {
            return this.aQx && this.aQy && Kr();
        }

        private boolean Kr() {
            return !this.aQt && this.aQu && !this.aQv && this.mWidth > 0 && this.mHeight > 0 && (this.aQC || this.aQB == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.aPX) {
                this.aQB = i;
                a.aPX.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.aPX) {
                i = this.aQB;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.aPX) {
                this.aQC = true;
                a.aPX.notifyAll();
            }
        }

        public void Ks() {
            synchronized (a.aPX) {
                this.aQu = true;
                this.aQz = false;
                a.aPX.notifyAll();
                while (this.aQw && !this.aQz && !this.aQr) {
                    try {
                        a.aPX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Kt() {
            synchronized (a.aPX) {
                this.aQu = false;
                a.aPX.notifyAll();
                while (!this.aQw && !this.aQr) {
                    try {
                        a.aPX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.aPX) {
                this.aQs = true;
                a.aPX.notifyAll();
                while (!this.aQr && !this.aQt) {
                    try {
                        a.aPX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.aPX) {
                this.aQs = false;
                this.aQC = true;
                this.aQD = false;
                a.aPX.notifyAll();
                while (!this.aQr && this.aQt && !this.aQD) {
                    try {
                        a.aPX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void M(int i, int i2) {
            synchronized (a.aPX) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aQF = true;
                this.aQC = true;
                this.aQD = false;
                a.aPX.notifyAll();
                while (!this.aQr && !this.aQt && !this.aQD && Kq()) {
                    try {
                        a.aPX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Ku() {
            synchronized (a.aPX) {
                this.aQq = true;
                a.aPX.notifyAll();
                while (!this.aQr) {
                    try {
                        a.aPX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Kv() {
            this.aQA = true;
            a.aPX.notifyAll();
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

    private void Kg() {
        if (this.aPZ != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean aQH;
        private int aQI;
        private boolean aQJ;
        private boolean aQK;
        private boolean aQL;
        private i aQM;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.aQr = true;
            if (this.aQM == iVar) {
                this.aQM = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.aQM == iVar || this.aQM == null) {
                this.aQM = iVar;
                notifyAll();
                return true;
            }
            Ky();
            if (this.aQK) {
                return true;
            }
            if (this.aQM != null) {
                this.aQM.Kv();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.aQM == iVar) {
                this.aQM = null;
            }
            notifyAll();
        }

        public synchronized boolean Kw() {
            return this.aQL;
        }

        public synchronized boolean Kx() {
            Ky();
            return !this.aQK;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.aQJ) {
                    Ky();
                    String glGetString = gl10.glGetString(7937);
                    if (this.aQI < 131072) {
                        this.aQK = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.aQL = this.aQK ? false : true;
                    this.aQJ = true;
                }
            }
        }

        private void Ky() {
            if (!this.aQH) {
                this.aQK = true;
                this.aQH = true;
            }
        }
    }
}
