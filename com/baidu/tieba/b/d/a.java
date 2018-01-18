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
    private static final j cQQ = new j();
    private final WeakReference<a> cQR;
    private i cQS;
    private c.m cQT;
    private e cQU;
    private f cQV;
    private g cQW;
    private k cQX;
    private int cQY;
    private int cQZ;
    private boolean cRa;
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
        this.cQR = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cQS != null) {
                this.cQS.ajO();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cQX = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cQY = i2;
    }

    public int getDebugFlags() {
        return this.cQY;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cRa = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cRa;
    }

    public void setRenderer(c.m mVar) {
        ajB();
        if (this.cQU == null) {
            this.cQU = new m(true);
        }
        if (this.cQV == null) {
            this.cQV = new c();
        }
        if (this.cQW == null) {
            this.cQW = new d();
        }
        this.cQT = mVar;
        this.cQS = new i(this.cQR);
        this.cQS.start();
    }

    public void setEGLContextFactory(f fVar) {
        ajB();
        this.cQV = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ajB();
        this.cQW = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ajB();
        this.cQU = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        ajB();
        this.cQZ = i2;
    }

    public void setRenderMode(int i2) {
        this.cQS.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cQS.getRenderMode();
    }

    public void requestRender() {
        this.cQS.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cQS.ajN();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cQS.bj(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cQS.bj(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cQS.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cQS.onPause();
    }

    public void onResume() {
        this.cQS.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cQT != null) {
            int renderMode = this.cQS != null ? this.cQS.getRenderMode() : 1;
            this.cQS = new i(this.cQR);
            if (renderMode != 1) {
                this.cQS.setRenderMode(renderMode);
            }
            this.cQS.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cQS != null) {
            this.cQS.ajO();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.cQZ, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.cQZ == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.S("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0102a implements e {
        protected int[] cRb;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0102a(int[] iArr) {
            this.cRb = o(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cRb, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cRb, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] o(int[] iArr) {
            if (a.this.cQZ == 2) {
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
    private class b extends AbstractC0102a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0102a
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
        private WeakReference<a> cRd;
        EGL10 cRe;
        EGLDisplay cRf;
        EGLSurface cRg;
        EGLConfig cRh;
        EGLContext cRi;

        public h(WeakReference<a> weakReference) {
            this.cRd = weakReference;
        }

        public void start() {
            this.cRe = (EGL10) EGLContext.getEGL();
            this.cRf = this.cRe.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cRf == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cRe.eglInitialize(this.cRf, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.cRd.get();
            if (aVar != null) {
                this.cRh = aVar.cQU.chooseConfig(this.cRe, this.cRf);
                try {
                    this.cRi = aVar.cQV.createContext(this.cRe, this.cRf, this.cRh);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.cRh = null;
                this.cRi = null;
            }
            if (this.cRi == null || this.cRi == EGL10.EGL_NO_CONTEXT) {
                this.cRi = null;
                jW("createContext");
            }
            this.cRg = null;
        }

        public boolean ajD() {
            if (this.cRe == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cRf == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cRh == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ajH();
            a aVar = this.cRd.get();
            if (aVar != null) {
                this.cRg = aVar.cQW.createWindowSurface(this.cRe, this.cRf, this.cRh, aVar.getSurfaceTexture());
            } else {
                this.cRg = null;
            }
            if (this.cRg == null || this.cRg == EGL10.EGL_NO_SURFACE) {
                if (this.cRe.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cRe.eglMakeCurrent(this.cRf, this.cRg, this.cRg, this.cRi)) {
                f("EGLHelper", "eglMakeCurrent", this.cRe.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL ajE() {
            l lVar;
            GL gl = this.cRi.getGL();
            a aVar = this.cRd.get();
            if (aVar != null) {
                if (aVar.cQX != null) {
                    gl = aVar.cQX.wrap(gl);
                }
                if ((aVar.cQY & 3) != 0) {
                    int i = 0;
                    if ((aVar.cQY & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.cQY & 2) == 0) {
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

        public int ajF() {
            if (this.cRe.eglSwapBuffers(this.cRf, this.cRg)) {
                return 12288;
            }
            return this.cRe.eglGetError();
        }

        public void ajG() {
            ajH();
        }

        private void ajH() {
            if (this.cRg != null && this.cRg != EGL10.EGL_NO_SURFACE) {
                this.cRe.eglMakeCurrent(this.cRf, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.cRd.get();
                if (aVar != null) {
                    aVar.cQW.destroySurface(this.cRe, this.cRf, this.cRg);
                }
                this.cRg = null;
            }
        }

        public void finish() {
            if (this.cRi != null) {
                a aVar = this.cRd.get();
                if (aVar != null) {
                    try {
                        aVar.cQV.destroyContext(this.cRe, this.cRf, this.cRi);
                    } catch (Exception e) {
                    }
                }
                this.cRi = null;
            }
            if (this.cRf != null) {
                this.cRe.eglTerminate(this.cRf);
                this.cRf = null;
            }
        }

        private void jW(String str) {
            S(str, this.cRe.eglGetError());
        }

        public static void S(String str, int i) {
            throw new RuntimeException(T(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, T(str2, i));
        }

        public static String T(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> cRd;
        private boolean cRj;
        private boolean cRk;
        private boolean cRl;
        private boolean cRm;
        private boolean cRn;
        private boolean cRo;
        private boolean cRp;
        private boolean cRq;
        private boolean cRr;
        private boolean cRs;
        private boolean cRv;
        private h cRy;
        private boolean vv;
        private ArrayList<Runnable> cRw = new ArrayList<>();
        private boolean cRx = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cRu = true;
        private int cRt = 1;

        i(WeakReference<a> weakReference) {
            this.cRd = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ajK();
                    a.cQQ.a(this);
                } catch (Exception e) {
                    af.Ct().bh(false);
                    a.cQQ.a(this);
                }
            } catch (Throwable th) {
                a.cQQ.a(this);
                throw th;
            }
        }

        private void ajI() {
            if (this.cRq) {
                this.cRq = false;
                this.cRy.ajG();
            }
        }

        private void ajJ() {
            if (this.cRp) {
                this.cRy.finish();
                this.cRp = false;
                a.cQQ.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void ajK() throws InterruptedException {
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
            this.cRy = new h(this.cRd);
            this.cRp = false;
            this.cRq = false;
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
                    synchronized (a.cQQ) {
                        while (!this.cRj) {
                            if (this.cRw.isEmpty()) {
                                if (this.vv != this.cRl) {
                                    boolean z23 = this.cRl;
                                    this.vv = this.cRl;
                                    a.cQQ.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cRs) {
                                    ajI();
                                    ajJ();
                                    this.cRs = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    ajI();
                                    ajJ();
                                    z19 = false;
                                }
                                if (z9 && this.cRq) {
                                    ajI();
                                }
                                if (z9 && this.cRp) {
                                    a aVar = this.cRd.get();
                                    if (!(aVar == null ? false : aVar.cRa) || a.cQQ.ajQ()) {
                                        ajJ();
                                    }
                                }
                                if (z9 && a.cQQ.ajR()) {
                                    this.cRy.finish();
                                }
                                if (!this.cRm && !this.cRo) {
                                    if (this.cRq) {
                                        ajI();
                                    }
                                    this.cRo = true;
                                    this.cRn = false;
                                    a.cQQ.notifyAll();
                                }
                                if (this.cRm && this.cRo) {
                                    this.cRo = false;
                                    a.cQQ.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cRv = true;
                                    a.cQQ.notifyAll();
                                }
                                if (ajM()) {
                                    if (!this.cRp) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.cQQ.b(this)) {
                                            try {
                                                this.cRy.start();
                                                this.cRp = true;
                                                z15 = true;
                                                a.cQQ.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.cQQ.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cRp || this.cRq) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cRq = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cRq) {
                                        if (this.cRx) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cRx = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cRu = false;
                                        a.cQQ.notifyAll();
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
                                a.cQQ.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cRw.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.cQQ) {
                            ajI();
                            ajJ();
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
                        } else if (this.cRy.ajD()) {
                            synchronized (a.cQQ) {
                                this.cRr = true;
                                a.cQQ.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.cQQ) {
                                this.cRr = true;
                                this.cRn = true;
                                a.cQQ.notifyAll();
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
                            GL10 gl103 = (GL10) this.cRy.ajE();
                            a.cQQ.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.cRd.get();
                            if (aVar2 != null) {
                                aVar2.cQT.onSurfaceCreated(gl10, this.cRy.cRh);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.cRd.get();
                            if (aVar3 != null) {
                                aVar3.cQT.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.cRd.get();
                        if (aVar4 != null) {
                            aVar4.cQT.onDrawFrame(gl10);
                        }
                        int ajF = this.cRy.ajF();
                        switch (ajF) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", ajF);
                                synchronized (a.cQQ) {
                                    this.cRn = true;
                                    a.cQQ.notifyAll();
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
                    synchronized (a.cQQ) {
                        ajI();
                        ajJ();
                        throw th;
                    }
                }
            }
        }

        public boolean ajL() {
            return this.cRp && this.cRq && ajM();
        }

        private boolean ajM() {
            return !this.vv && this.cRm && !this.cRn && this.mWidth > 0 && this.mHeight > 0 && (this.cRu || this.cRt == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.cQQ) {
                    this.cRt = i;
                    a.cQQ.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.cQQ) {
                i = this.cRt;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.cQQ) {
                this.cRu = true;
                a.cQQ.notifyAll();
            }
        }

        public void ajN() {
            synchronized (a.cQQ) {
                this.cRm = true;
                this.cRr = false;
                a.cQQ.notifyAll();
                while (this.cRo && !this.cRr && !this.cRk) {
                    try {
                        a.cQQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.cQQ) {
                this.cRm = false;
                a.cQQ.notifyAll();
                while (!this.cRo && !this.cRk) {
                    try {
                        a.cQQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.cQQ) {
                this.cRl = true;
                a.cQQ.notifyAll();
                while (!this.cRk && !this.vv) {
                    try {
                        a.cQQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.cQQ) {
                this.cRl = false;
                this.cRu = true;
                this.cRv = false;
                a.cQQ.notifyAll();
                while (!this.cRk && this.vv && !this.cRv) {
                    try {
                        a.cQQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void bj(int i, int i2) {
            synchronized (a.cQQ) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cRx = true;
                this.cRu = true;
                this.cRv = false;
                a.cQQ.notifyAll();
                while (!this.cRk && !this.vv && !this.cRv && ajL()) {
                    try {
                        a.cQQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ajO() {
            synchronized (a.cQQ) {
                this.cRj = true;
                a.cQQ.notifyAll();
                while (!this.cRk) {
                    try {
                        a.cQQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ajP() {
            this.cRs = true;
            a.cQQ.notifyAll();
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

    private void ajB() {
        if (this.cQS != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private int cRA;
        private boolean cRB;
        private boolean cRC;
        private boolean cRD;
        private i cRE;
        private boolean cRz;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cRk = true;
            if (this.cRE == iVar) {
                this.cRE = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cRE == iVar || this.cRE == null) {
                this.cRE = iVar;
                notifyAll();
                return true;
            }
            ajS();
            if (this.cRC) {
                return true;
            }
            if (this.cRE != null) {
                this.cRE.ajP();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cRE == iVar) {
                this.cRE = null;
            }
            notifyAll();
        }

        public synchronized boolean ajQ() {
            return this.cRD;
        }

        public synchronized boolean ajR() {
            ajS();
            return !this.cRC;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cRB) {
                    ajS();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cRA < 131072) {
                        this.cRC = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cRD = this.cRC ? false : true;
                    this.cRB = true;
                }
            }
        }

        private void ajS() {
            if (!this.cRz) {
                this.cRC = true;
                this.cRz = true;
            }
        }
    }
}
