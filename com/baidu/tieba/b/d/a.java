package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.b.d.c;
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
    private static final j bGj = new j();
    private final WeakReference<a> bGk;
    private i bGl;
    private c.m bGm;
    private e bGn;
    private f bGo;
    private g bGp;
    private k bGq;
    private int bGr;
    private int bGs;
    private boolean bGt;
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
        this.bGk = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bGl != null) {
                this.bGl.WJ();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bGq = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bGr = i2;
    }

    public int getDebugFlags() {
        return this.bGr;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bGt = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bGt;
    }

    public void setRenderer(c.m mVar) {
        Ww();
        if (this.bGn == null) {
            this.bGn = new m(true);
        }
        if (this.bGo == null) {
            this.bGo = new c();
        }
        if (this.bGp == null) {
            this.bGp = new d();
        }
        this.bGm = mVar;
        this.bGl = new i(this.bGk);
        this.bGl.start();
    }

    public void setEGLContextFactory(f fVar) {
        Ww();
        this.bGo = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Ww();
        this.bGp = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Ww();
        this.bGn = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Ww();
        this.bGs = i2;
    }

    public void setRenderMode(int i2) {
        this.bGl.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bGl.getRenderMode();
    }

    public void requestRender() {
        this.bGl.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bGl.WI();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bGl.ac(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bGl.ac(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bGl.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bGl.onPause();
    }

    public void onResume() {
        this.bGl.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bGm != null) {
            int renderMode = this.bGl != null ? this.bGl.getRenderMode() : 1;
            this.bGl = new i(this.bGk);
            if (renderMode != 1) {
                this.bGl.setRenderMode(renderMode);
            }
            this.bGl.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bGl != null) {
            this.bGl.WJ();
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

        @Override // com.baidu.tieba.b.d.a.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bGs, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bGs == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.G("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements g {
        private d() {
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
    private abstract class AbstractC0075a implements e {
        protected int[] bGu;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0075a(int[] iArr) {
            this.bGu = f(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bGu, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bGu, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] f(int[] iArr) {
            if (a.this.bGs == 2) {
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
    private class b extends AbstractC0075a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0075a
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
        EGLConfig bGA;
        EGLContext bGB;
        private WeakReference<a> bGw;
        EGL10 bGx;
        EGLDisplay bGy;
        EGLSurface bGz;

        public h(WeakReference<a> weakReference) {
            this.bGw = weakReference;
        }

        public void start() {
            this.bGx = (EGL10) EGLContext.getEGL();
            this.bGy = this.bGx.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bGy == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bGx.eglInitialize(this.bGy, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bGw.get();
            if (aVar != null) {
                this.bGA = aVar.bGn.chooseConfig(this.bGx, this.bGy);
                try {
                    this.bGB = aVar.bGo.createContext(this.bGx, this.bGy, this.bGA);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bGA = null;
                this.bGB = null;
            }
            if (this.bGB == null || this.bGB == EGL10.EGL_NO_CONTEXT) {
                this.bGB = null;
                jl("createContext");
            }
            this.bGz = null;
        }

        public boolean Wy() {
            if (this.bGx == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bGy == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bGA == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            WC();
            a aVar = this.bGw.get();
            if (aVar != null) {
                this.bGz = aVar.bGp.createWindowSurface(this.bGx, this.bGy, this.bGA, aVar.getSurfaceTexture());
            } else {
                this.bGz = null;
            }
            if (this.bGz == null || this.bGz == EGL10.EGL_NO_SURFACE) {
                if (this.bGx.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bGx.eglMakeCurrent(this.bGy, this.bGz, this.bGz, this.bGB)) {
                f("EGLHelper", "eglMakeCurrent", this.bGx.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Wz() {
            l lVar;
            GL gl = this.bGB.getGL();
            a aVar = this.bGw.get();
            if (aVar != null) {
                if (aVar.bGq != null) {
                    gl = aVar.bGq.wrap(gl);
                }
                if ((aVar.bGr & 3) != 0) {
                    int i = 0;
                    if ((aVar.bGr & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bGr & 2) == 0) {
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

        public int WA() {
            if (this.bGx.eglSwapBuffers(this.bGy, this.bGz)) {
                return 12288;
            }
            return this.bGx.eglGetError();
        }

        public void WB() {
            WC();
        }

        private void WC() {
            if (this.bGz != null && this.bGz != EGL10.EGL_NO_SURFACE) {
                this.bGx.eglMakeCurrent(this.bGy, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bGw.get();
                if (aVar != null) {
                    aVar.bGp.destroySurface(this.bGx, this.bGy, this.bGz);
                }
                this.bGz = null;
            }
        }

        public void finish() {
            if (this.bGB != null) {
                a aVar = this.bGw.get();
                if (aVar != null) {
                    try {
                        aVar.bGo.destroyContext(this.bGx, this.bGy, this.bGB);
                    } catch (Exception e) {
                    }
                }
                this.bGB = null;
            }
            if (this.bGy != null) {
                this.bGx.eglTerminate(this.bGy);
                this.bGy = null;
            }
        }

        private void jl(String str) {
            G(str, this.bGx.eglGetError());
        }

        public static void G(String str, int i) {
            throw new RuntimeException(H(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, H(str2, i));
        }

        public static String H(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean bGC;
        private boolean bGD;
        private boolean bGE;
        private boolean bGF;
        private boolean bGG;
        private boolean bGH;
        private boolean bGI;
        private boolean bGJ;
        private boolean bGK;
        private boolean bGL;
        private boolean bGM;
        private boolean bGP;
        private h bGS;
        private WeakReference<a> bGw;
        private ArrayList<Runnable> bGQ = new ArrayList<>();
        private boolean bGR = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bGO = true;
        private int bGN = 1;

        i(WeakReference<a> weakReference) {
            this.bGw = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    WF();
                    a.bGj.a(this);
                } catch (Exception e) {
                    af.vx().aC(false);
                    a.bGj.a(this);
                }
            } catch (Throwable th) {
                a.bGj.a(this);
                throw th;
            }
        }

        private void WD() {
            if (this.bGK) {
                this.bGK = false;
                this.bGS.WB();
            }
        }

        private void WE() {
            if (this.bGJ) {
                this.bGS.finish();
                this.bGJ = false;
                a.bGj.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void WF() throws InterruptedException {
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
            this.bGS = new h(this.bGw);
            this.bGJ = false;
            this.bGK = false;
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
                    synchronized (a.bGj) {
                        while (!this.bGC) {
                            if (this.bGQ.isEmpty()) {
                                if (this.bGF != this.bGE) {
                                    boolean z23 = this.bGE;
                                    this.bGF = this.bGE;
                                    a.bGj.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bGM) {
                                    WD();
                                    WE();
                                    this.bGM = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    WD();
                                    WE();
                                    z19 = false;
                                }
                                if (z9 && this.bGK) {
                                    WD();
                                }
                                if (z9 && this.bGJ) {
                                    a aVar = this.bGw.get();
                                    if (!(aVar == null ? false : aVar.bGt) || a.bGj.WL()) {
                                        WE();
                                    }
                                }
                                if (z9 && a.bGj.WM()) {
                                    this.bGS.finish();
                                }
                                if (!this.bGG && !this.bGI) {
                                    if (this.bGK) {
                                        WD();
                                    }
                                    this.bGI = true;
                                    this.bGH = false;
                                    a.bGj.notifyAll();
                                }
                                if (this.bGG && this.bGI) {
                                    this.bGI = false;
                                    a.bGj.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bGP = true;
                                    a.bGj.notifyAll();
                                }
                                if (WH()) {
                                    if (!this.bGJ) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bGj.b(this)) {
                                            try {
                                                this.bGS.start();
                                                this.bGJ = true;
                                                z15 = true;
                                                a.bGj.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bGj.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bGJ || this.bGK) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bGK = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bGK) {
                                        if (this.bGR) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bGR = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bGO = false;
                                        a.bGj.notifyAll();
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
                                a.bGj.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bGQ.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bGj) {
                            WD();
                            WE();
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
                        } else if (this.bGS.Wy()) {
                            synchronized (a.bGj) {
                                this.bGL = true;
                                a.bGj.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bGj) {
                                this.bGL = true;
                                this.bGH = true;
                                a.bGj.notifyAll();
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
                            GL10 gl103 = (GL10) this.bGS.Wz();
                            a.bGj.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bGw.get();
                            if (aVar2 != null) {
                                aVar2.bGm.onSurfaceCreated(gl10, this.bGS.bGA);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bGw.get();
                            if (aVar3 != null) {
                                aVar3.bGm.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bGw.get();
                        if (aVar4 != null) {
                            aVar4.bGm.onDrawFrame(gl10);
                        }
                        int WA = this.bGS.WA();
                        switch (WA) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", WA);
                                synchronized (a.bGj) {
                                    this.bGH = true;
                                    a.bGj.notifyAll();
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
                    synchronized (a.bGj) {
                        WD();
                        WE();
                        throw th;
                    }
                }
            }
        }

        public boolean WG() {
            return this.bGJ && this.bGK && WH();
        }

        private boolean WH() {
            return !this.bGF && this.bGG && !this.bGH && this.mWidth > 0 && this.mHeight > 0 && (this.bGO || this.bGN == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bGj) {
                    this.bGN = i;
                    a.bGj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bGj) {
                i = this.bGN;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bGj) {
                this.bGO = true;
                a.bGj.notifyAll();
            }
        }

        public void WI() {
            synchronized (a.bGj) {
                this.bGG = true;
                this.bGL = false;
                a.bGj.notifyAll();
                while (this.bGI && !this.bGL && !this.bGD) {
                    try {
                        a.bGj.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bGj) {
                this.bGG = false;
                a.bGj.notifyAll();
                while (!this.bGI && !this.bGD) {
                    try {
                        a.bGj.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bGj) {
                this.bGE = true;
                a.bGj.notifyAll();
                while (!this.bGD && !this.bGF) {
                    try {
                        a.bGj.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bGj) {
                this.bGE = false;
                this.bGO = true;
                this.bGP = false;
                a.bGj.notifyAll();
                while (!this.bGD && this.bGF && !this.bGP) {
                    try {
                        a.bGj.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ac(int i, int i2) {
            synchronized (a.bGj) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bGR = true;
                this.bGO = true;
                this.bGP = false;
                a.bGj.notifyAll();
                while (!this.bGD && !this.bGF && !this.bGP && WG()) {
                    try {
                        a.bGj.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void WJ() {
            synchronized (a.bGj) {
                this.bGC = true;
                a.bGj.notifyAll();
                while (!this.bGD) {
                    try {
                        a.bGj.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void WK() {
            this.bGM = true;
            a.bGj.notifyAll();
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

    private void Ww() {
        if (this.bGl != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bGT;
        private int bGU;
        private boolean bGV;
        private boolean bGW;
        private boolean bGX;
        private i bGY;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bGD = true;
            if (this.bGY == iVar) {
                this.bGY = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bGY == iVar || this.bGY == null) {
                this.bGY = iVar;
                notifyAll();
                return true;
            }
            WN();
            if (this.bGW) {
                return true;
            }
            if (this.bGY != null) {
                this.bGY.WK();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bGY == iVar) {
                this.bGY = null;
            }
            notifyAll();
        }

        public synchronized boolean WL() {
            return this.bGX;
        }

        public synchronized boolean WM() {
            WN();
            return !this.bGW;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bGV) {
                    WN();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bGU < 131072) {
                        this.bGW = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bGX = this.bGW ? false : true;
                    this.bGV = true;
                }
            }
        }

        private void WN() {
            if (!this.bGT) {
                this.bGW = true;
                this.bGT = true;
            }
        }
    }
}
