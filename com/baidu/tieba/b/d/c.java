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
    private static final j cSf = new j();
    private final WeakReference<c> cRm;
    private m cRo;
    private int cRt;
    private int cRu;
    private boolean cRv;
    private i cSg;
    private e cSh;
    private f cSi;
    private g cSj;
    private k cSk;
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
            if (this.cSg != null) {
                this.cSg.ajT();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.cSk = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cRt = i2;
    }

    public int getDebugFlags() {
        return this.cRt;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cRv = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cRv;
    }

    public void setRenderer(m mVar) {
        ajG();
        if (this.cSh == null) {
            this.cSh = new n(true);
        }
        if (this.cSi == null) {
            this.cSi = new C0104c();
        }
        if (this.cSj == null) {
            this.cSj = new d();
        }
        this.cRo = mVar;
        this.cSg = new i(this.cRm);
        this.cSg.start();
    }

    public void setEGLContextFactory(f fVar) {
        ajG();
        this.cSi = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ajG();
        this.cSj = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ajG();
        this.cSh = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        ajG();
        this.cRu = i2;
    }

    public void setRenderMode(int i2) {
        this.cSg.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cSg.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cSg.ajS();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cSg.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cSg.bj(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cRo != null) {
            int renderMode = this.cSg != null ? this.cSg.getRenderMode() : 1;
            this.cSg = new i(this.cRm);
            if (renderMode != 1) {
                this.cSg.setRenderMode(renderMode);
            }
            this.cSg.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cSg != null) {
            this.cSg.ajT();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0104c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0104c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.cRu, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.cRu == 0) {
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
        protected int[] cRw;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cRw = o(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cRw, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cRw, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] o(int[] iArr) {
            if (c.this.cRu == 2) {
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
        EGLDisplay cRA;
        EGLSurface cRB;
        EGLConfig cRC;
        EGLContext cRD;
        EGL10 cRz;
        private WeakReference<c> cSm;

        public h(WeakReference<c> weakReference) {
            this.cSm = weakReference;
        }

        public void start() {
            this.cRz = (EGL10) EGLContext.getEGL();
            this.cRA = this.cRz.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cRA == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cRz.eglInitialize(this.cRA, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.cSm.get();
            if (cVar != null) {
                this.cRC = cVar.cSh.chooseConfig(this.cRz, this.cRA);
                this.cRD = cVar.cSi.createContext(this.cRz, this.cRA, this.cRC);
            } else {
                this.cRC = null;
                this.cRD = null;
            }
            if (this.cRD == null || this.cRD == EGL10.EGL_NO_CONTEXT) {
                this.cRD = null;
                ke("createContext");
            }
            this.cRB = null;
        }

        public boolean ajI() {
            if (this.cRz == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cRA == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cRC == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ajM();
            c cVar = this.cSm.get();
            if (cVar != null) {
                this.cRB = cVar.cSj.createWindowSurface(this.cRz, this.cRA, this.cRC, cVar.getHolder());
            } else {
                this.cRB = null;
            }
            if (this.cRB == null || this.cRB == EGL10.EGL_NO_SURFACE) {
                if (this.cRz.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cRz.eglMakeCurrent(this.cRA, this.cRB, this.cRB, this.cRD)) {
                f("EGLHelper", "eglMakeCurrent", this.cRz.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL ajJ() {
            l lVar;
            GL gl = this.cRD.getGL();
            c cVar = this.cSm.get();
            if (cVar != null) {
                if (cVar.cSk != null) {
                    gl = cVar.cSk.wrap(gl);
                }
                if ((cVar.cRt & 3) != 0) {
                    int i = 0;
                    if ((cVar.cRt & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.cRt & 2) == 0) {
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

        public int ajK() {
            if (this.cRz.eglSwapBuffers(this.cRA, this.cRB)) {
                return 12288;
            }
            return this.cRz.eglGetError();
        }

        public void ajL() {
            ajM();
        }

        private void ajM() {
            if (this.cRB != null && this.cRB != EGL10.EGL_NO_SURFACE) {
                this.cRz.eglMakeCurrent(this.cRA, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.cSm.get();
                if (cVar != null) {
                    cVar.cSj.destroySurface(this.cRz, this.cRA, this.cRB);
                }
                this.cRB = null;
            }
        }

        public void finish() {
            if (this.cRD != null) {
                c cVar = this.cSm.get();
                if (cVar != null) {
                    cVar.cSi.destroyContext(this.cRz, this.cRA, this.cRD);
                }
                this.cRD = null;
            }
            if (this.cRA != null) {
                this.cRz.eglTerminate(this.cRA);
                this.cRA = null;
            }
        }

        private void ke(String str) {
            S(str, this.cRz.eglGetError());
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
        private boolean cRE;
        private boolean cRF;
        private boolean cRG;
        private boolean cRH;
        private boolean cRI;
        private boolean cRJ;
        private boolean cRK;
        private boolean cRL;
        private boolean cRM;
        private boolean cRN;
        private boolean cRQ;
        private WeakReference<c> cSm;
        private h cSn;
        private boolean vv;
        private ArrayList<Runnable> cRR = new ArrayList<>();
        private boolean cRS = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cRP = true;
        private int cRO = 1;

        i(WeakReference<c> weakReference) {
            this.cSm = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ajP();
                    c.cSf.a(this);
                } catch (Exception e) {
                    af.Cu().bi(false);
                    c.cSf.a(this);
                }
            } catch (Throwable th) {
                c.cSf.a(this);
                throw th;
            }
        }

        private void ajN() {
            if (this.cRL) {
                this.cRL = false;
                this.cSn.ajL();
            }
        }

        private void ajO() {
            if (this.cRK) {
                this.cSn.finish();
                this.cRK = false;
                c.cSf.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void ajP() throws InterruptedException {
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
            this.cSn = new h(this.cSm);
            this.cRK = false;
            this.cRL = false;
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
                    synchronized (c.cSf) {
                        while (!this.cRE) {
                            if (this.cRR.isEmpty()) {
                                if (this.vv != this.cRG) {
                                    boolean z23 = this.cRG;
                                    this.vv = this.cRG;
                                    c.cSf.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cRN) {
                                    ajN();
                                    ajO();
                                    this.cRN = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    ajN();
                                    ajO();
                                    z19 = false;
                                }
                                if (z9 && this.cRL) {
                                    ajN();
                                }
                                if (z9 && this.cRK) {
                                    c cVar = this.cSm.get();
                                    if (!(cVar == null ? false : cVar.cRv) || c.cSf.ajV()) {
                                        ajO();
                                    }
                                }
                                if (z9 && c.cSf.ajW()) {
                                    this.cSn.finish();
                                }
                                if (!this.cRH && !this.cRJ) {
                                    if (this.cRL) {
                                        ajN();
                                    }
                                    this.cRJ = true;
                                    this.cRI = false;
                                    c.cSf.notifyAll();
                                }
                                if (this.cRH && this.cRJ) {
                                    this.cRJ = false;
                                    c.cSf.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cRQ = true;
                                    c.cSf.notifyAll();
                                }
                                if (ajR()) {
                                    if (!this.cRK) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.cSf.b(this)) {
                                            try {
                                                this.cSn.start();
                                                this.cRK = true;
                                                z15 = true;
                                                c.cSf.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.cSf.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cRK || this.cRL) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cRL = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cRL) {
                                        if (this.cRS) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cRS = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cRP = false;
                                        c.cSf.notifyAll();
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
                                c.cSf.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cRR.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.cSf) {
                            ajN();
                            ajO();
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
                        } else if (this.cSn.ajI()) {
                            synchronized (c.cSf) {
                                this.cRM = true;
                                c.cSf.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.cSf) {
                                this.cRM = true;
                                this.cRI = true;
                                c.cSf.notifyAll();
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
                            GL10 gl103 = (GL10) this.cSn.ajJ();
                            c.cSf.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.cSm.get();
                            if (cVar2 != null) {
                                cVar2.cRo.onSurfaceCreated(gl10, this.cSn.cRC);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.cSm.get();
                            if (cVar3 != null) {
                                cVar3.cRo.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.cSm.get();
                        if (cVar4 != null) {
                            cVar4.cRo.onDrawFrame(gl10);
                        }
                        int ajK = this.cSn.ajK();
                        switch (ajK) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", ajK);
                                synchronized (c.cSf) {
                                    this.cRI = true;
                                    c.cSf.notifyAll();
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
                    synchronized (c.cSf) {
                        ajN();
                        ajO();
                        throw th;
                    }
                }
            }
        }

        public boolean ajQ() {
            return this.cRK && this.cRL && ajR();
        }

        private boolean ajR() {
            return !this.vv && this.cRH && !this.cRI && this.mWidth > 0 && this.mHeight > 0 && (this.cRP || this.cRO == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.cSf) {
                    this.cRO = i;
                    c.cSf.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.cSf) {
                i = this.cRO;
            }
            return i;
        }

        public void ajS() {
            synchronized (c.cSf) {
                this.cRH = true;
                this.cRM = false;
                c.cSf.notifyAll();
                while (this.cRJ && !this.cRM && !this.cRF) {
                    try {
                        c.cSf.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.cSf) {
                this.cRH = false;
                c.cSf.notifyAll();
                while (!this.cRJ && !this.cRF) {
                    try {
                        c.cSf.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void bj(int i, int i2) {
            synchronized (c.cSf) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cRS = true;
                this.cRP = true;
                this.cRQ = false;
                c.cSf.notifyAll();
                while (!this.cRF && !this.vv && !this.cRQ && ajQ()) {
                    try {
                        c.cSf.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ajT() {
            synchronized (c.cSf) {
                this.cRE = true;
                c.cSf.notifyAll();
                while (!this.cRF) {
                    try {
                        c.cSf.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ajU() {
            this.cRN = true;
            c.cSf.notifyAll();
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

    private void ajG() {
        if (this.cSg != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cRU;
        private int cRV;
        private boolean cRW;
        private boolean cRX;
        private boolean cRY;
        private i cSo;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cRF = true;
            if (this.cSo == iVar) {
                this.cSo = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cSo == iVar || this.cSo == null) {
                this.cSo = iVar;
                notifyAll();
                return true;
            }
            ajX();
            if (this.cRX) {
                return true;
            }
            if (this.cSo != null) {
                this.cSo.ajU();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cSo == iVar) {
                this.cSo = null;
            }
            notifyAll();
        }

        public synchronized boolean ajV() {
            return this.cRY;
        }

        public synchronized boolean ajW() {
            ajX();
            return !this.cRX;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cRW) {
                    ajX();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cRV < 131072) {
                        this.cRX = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cRY = this.cRX ? false : true;
                    this.cRW = true;
                }
            }
        }

        private void ajX() {
            if (!this.cRU) {
                this.cRX = true;
                this.cRU = true;
            }
        }
    }
}
