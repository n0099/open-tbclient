package com.baidu.tieba.b.d;

import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.tbadk.core.util.af;
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
public class c extends SurfaceView implements SurfaceHolder.Callback {
    private static final j cRK = new j();
    private final WeakReference<c> cQR;
    private m cQT;
    private int cQY;
    private int cQZ;
    private i cRL;
    private e cRM;
    private f cRN;
    private g cRO;
    private k cRP;
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

    /* loaded from: classes.dex */
    public interface m {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cRL != null) {
                this.cRL.ajO();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.cRP = kVar;
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

    public void setRenderer(m mVar) {
        ajB();
        if (this.cRM == null) {
            this.cRM = new n(true);
        }
        if (this.cRN == null) {
            this.cRN = new C0103c();
        }
        if (this.cRO == null) {
            this.cRO = new d();
        }
        this.cQT = mVar;
        this.cRL = new i(this.cQR);
        this.cRL.start();
    }

    public void setEGLContextFactory(f fVar) {
        ajB();
        this.cRN = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ajB();
        this.cRO = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ajB();
        this.cRM = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        ajB();
        this.cQZ = i2;
    }

    public void setRenderMode(int i2) {
        this.cRL.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cRL.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cRL.ajN();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cRL.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cRL.bj(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cQT != null) {
            int renderMode = this.cRL != null ? this.cRL.getRenderMode() : 1;
            this.cRL = new i(this.cQR);
            if (renderMode != 1) {
                this.cRL.setRenderMode(renderMode);
            }
            this.cRL.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cRL != null) {
            this.cRL.ajO();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0103c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0103c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.cQZ, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.cQZ == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.c.f
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

        @Override // com.baidu.tieba.b.d.c.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.b.d.c.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes.dex */
    private abstract class a implements e {
        protected int[] cRb;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cRb = o(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
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
            if (c.this.cQZ == 2) {
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

        @Override // com.baidu.tieba.b.d.c.a
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
    private class n extends b {
        public n(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h {
        private WeakReference<c> cRR;
        EGL10 cRe;
        EGLDisplay cRf;
        EGLSurface cRg;
        EGLConfig cRh;
        EGLContext cRi;

        public h(WeakReference<c> weakReference) {
            this.cRR = weakReference;
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
            c cVar = this.cRR.get();
            if (cVar != null) {
                this.cRh = cVar.cRM.chooseConfig(this.cRe, this.cRf);
                this.cRi = cVar.cRN.createContext(this.cRe, this.cRf, this.cRh);
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
            c cVar = this.cRR.get();
            if (cVar != null) {
                this.cRg = cVar.cRO.createWindowSurface(this.cRe, this.cRf, this.cRh, cVar.getHolder());
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
            c cVar = this.cRR.get();
            if (cVar != null) {
                if (cVar.cRP != null) {
                    gl = cVar.cRP.wrap(gl);
                }
                if ((cVar.cQY & 3) != 0) {
                    int i = 0;
                    if ((cVar.cQY & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.cQY & 2) == 0) {
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
                c cVar = this.cRR.get();
                if (cVar != null) {
                    cVar.cRO.destroySurface(this.cRe, this.cRf, this.cRg);
                }
                this.cRg = null;
            }
        }

        public void finish() {
            if (this.cRi != null) {
                c cVar = this.cRR.get();
                if (cVar != null) {
                    cVar.cRN.destroyContext(this.cRe, this.cRf, this.cRi);
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
            return str + " failed: " + com.baidu.tieba.b.d.b.lB(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<c> cRR;
        private h cRS;
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
        private boolean vv;
        private ArrayList<Runnable> cRw = new ArrayList<>();
        private boolean cRx = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cRu = true;
        private int cRt = 1;

        i(WeakReference<c> weakReference) {
            this.cRR = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ajK();
                    c.cRK.a(this);
                } catch (Exception e) {
                    af.Ct().bh(false);
                    c.cRK.a(this);
                }
            } catch (Throwable th) {
                c.cRK.a(this);
                throw th;
            }
        }

        private void ajI() {
            if (this.cRq) {
                this.cRq = false;
                this.cRS.ajG();
            }
        }

        private void ajJ() {
            if (this.cRp) {
                this.cRS.finish();
                this.cRp = false;
                c.cRK.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
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
            this.cRS = new h(this.cRR);
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
                    synchronized (c.cRK) {
                        while (!this.cRj) {
                            if (this.cRw.isEmpty()) {
                                if (this.vv != this.cRl) {
                                    boolean z23 = this.cRl;
                                    this.vv = this.cRl;
                                    c.cRK.notifyAll();
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
                                    c cVar = this.cRR.get();
                                    if (!(cVar == null ? false : cVar.cRa) || c.cRK.ajQ()) {
                                        ajJ();
                                    }
                                }
                                if (z9 && c.cRK.ajR()) {
                                    this.cRS.finish();
                                }
                                if (!this.cRm && !this.cRo) {
                                    if (this.cRq) {
                                        ajI();
                                    }
                                    this.cRo = true;
                                    this.cRn = false;
                                    c.cRK.notifyAll();
                                }
                                if (this.cRm && this.cRo) {
                                    this.cRo = false;
                                    c.cRK.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cRv = true;
                                    c.cRK.notifyAll();
                                }
                                if (ajM()) {
                                    if (!this.cRp) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.cRK.b(this)) {
                                            try {
                                                this.cRS.start();
                                                this.cRp = true;
                                                z15 = true;
                                                c.cRK.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.cRK.c(this);
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
                                        c.cRK.notifyAll();
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
                                c.cRK.wait();
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
                        synchronized (c.cRK) {
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
                        } else if (this.cRS.ajD()) {
                            synchronized (c.cRK) {
                                this.cRr = true;
                                c.cRK.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.cRK) {
                                this.cRr = true;
                                this.cRn = true;
                                c.cRK.notifyAll();
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
                            GL10 gl103 = (GL10) this.cRS.ajE();
                            c.cRK.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.cRR.get();
                            if (cVar2 != null) {
                                cVar2.cQT.onSurfaceCreated(gl10, this.cRS.cRh);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.cRR.get();
                            if (cVar3 != null) {
                                cVar3.cQT.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.cRR.get();
                        if (cVar4 != null) {
                            cVar4.cQT.onDrawFrame(gl10);
                        }
                        int ajF = this.cRS.ajF();
                        switch (ajF) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", ajF);
                                synchronized (c.cRK) {
                                    this.cRn = true;
                                    c.cRK.notifyAll();
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
                    synchronized (c.cRK) {
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
                synchronized (c.cRK) {
                    this.cRt = i;
                    c.cRK.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.cRK) {
                i = this.cRt;
            }
            return i;
        }

        public void ajN() {
            synchronized (c.cRK) {
                this.cRm = true;
                this.cRr = false;
                c.cRK.notifyAll();
                while (this.cRo && !this.cRr && !this.cRk) {
                    try {
                        c.cRK.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.cRK) {
                this.cRm = false;
                c.cRK.notifyAll();
                while (!this.cRo && !this.cRk) {
                    try {
                        c.cRK.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void bj(int i, int i2) {
            synchronized (c.cRK) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cRx = true;
                this.cRu = true;
                this.cRv = false;
                c.cRK.notifyAll();
                while (!this.cRk && !this.vv && !this.cRv && ajL()) {
                    try {
                        c.cRK.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ajO() {
            synchronized (c.cRK) {
                this.cRj = true;
                c.cRK.notifyAll();
                while (!this.cRk) {
                    try {
                        c.cRK.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ajP() {
            this.cRs = true;
            c.cRK.notifyAll();
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
        if (this.cRL != null) {
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
        private i cRT;
        private boolean cRz;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cRk = true;
            if (this.cRT == iVar) {
                this.cRT = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cRT == iVar || this.cRT == null) {
                this.cRT = iVar;
                notifyAll();
                return true;
            }
            ajS();
            if (this.cRC) {
                return true;
            }
            if (this.cRT != null) {
                this.cRT.ajP();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cRT == iVar) {
                this.cRT = null;
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
