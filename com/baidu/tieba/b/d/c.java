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
    private static final j cNj = new j();
    private final WeakReference<c> cMq;
    private m cMs;
    private int cMx;
    private int cMy;
    private boolean cMz;
    private i cNk;
    private e cNl;
    private f cNm;
    private g cNn;
    private k cNo;
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
            if (this.cNk != null) {
                this.cNk.aiL();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.cNo = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cMx = i2;
    }

    public int getDebugFlags() {
        return this.cMx;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cMz = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cMz;
    }

    public void setRenderer(m mVar) {
        aiy();
        if (this.cNl == null) {
            this.cNl = new n(true);
        }
        if (this.cNm == null) {
            this.cNm = new C0104c();
        }
        if (this.cNn == null) {
            this.cNn = new d();
        }
        this.cMs = mVar;
        this.cNk = new i(this.cMq);
        this.cNk.start();
    }

    public void setEGLContextFactory(f fVar) {
        aiy();
        this.cNm = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aiy();
        this.cNn = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aiy();
        this.cNl = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        aiy();
        this.cMy = i2;
    }

    public void setRenderMode(int i2) {
        this.cNk.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cNk.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.cNk.aiK();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cNk.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.cNk.bj(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cMs != null) {
            int renderMode = this.cNk != null ? this.cNk.getRenderMode() : 1;
            this.cNk = new i(this.cMq);
            if (renderMode != 1) {
                this.cNk.setRenderMode(renderMode);
            }
            this.cNk.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.cNk != null) {
            this.cNk.aiL();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.cMy, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.cMy == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.c.f
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
        protected int[] cMA;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cMA = o(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cMA, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cMA, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] o(int[] iArr) {
            if (c.this.cMy == 2) {
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
        EGL10 cMD;
        EGLDisplay cME;
        EGLSurface cMF;
        EGLConfig cMG;
        EGLContext cMH;
        private WeakReference<c> cNq;

        public h(WeakReference<c> weakReference) {
            this.cNq = weakReference;
        }

        public void start() {
            this.cMD = (EGL10) EGLContext.getEGL();
            this.cME = this.cMD.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cME == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cMD.eglInitialize(this.cME, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.cNq.get();
            if (cVar != null) {
                this.cMG = cVar.cNl.chooseConfig(this.cMD, this.cME);
                this.cMH = cVar.cNm.createContext(this.cMD, this.cME, this.cMG);
            } else {
                this.cMG = null;
                this.cMH = null;
            }
            if (this.cMH == null || this.cMH == EGL10.EGL_NO_CONTEXT) {
                this.cMH = null;
                jN("createContext");
            }
            this.cMF = null;
        }

        public boolean aiA() {
            if (this.cMD == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cME == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cMG == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aiE();
            c cVar = this.cNq.get();
            if (cVar != null) {
                this.cMF = cVar.cNn.createWindowSurface(this.cMD, this.cME, this.cMG, cVar.getHolder());
            } else {
                this.cMF = null;
            }
            if (this.cMF == null || this.cMF == EGL10.EGL_NO_SURFACE) {
                if (this.cMD.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cMD.eglMakeCurrent(this.cME, this.cMF, this.cMF, this.cMH)) {
                f("EGLHelper", "eglMakeCurrent", this.cMD.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aiB() {
            l lVar;
            GL gl = this.cMH.getGL();
            c cVar = this.cNq.get();
            if (cVar != null) {
                if (cVar.cNo != null) {
                    gl = cVar.cNo.wrap(gl);
                }
                if ((cVar.cMx & 3) != 0) {
                    int i = 0;
                    if ((cVar.cMx & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.cMx & 2) == 0) {
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

        public int aiC() {
            if (this.cMD.eglSwapBuffers(this.cME, this.cMF)) {
                return 12288;
            }
            return this.cMD.eglGetError();
        }

        public void aiD() {
            aiE();
        }

        private void aiE() {
            if (this.cMF != null && this.cMF != EGL10.EGL_NO_SURFACE) {
                this.cMD.eglMakeCurrent(this.cME, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.cNq.get();
                if (cVar != null) {
                    cVar.cNn.destroySurface(this.cMD, this.cME, this.cMF);
                }
                this.cMF = null;
            }
        }

        public void finish() {
            if (this.cMH != null) {
                c cVar = this.cNq.get();
                if (cVar != null) {
                    cVar.cNm.destroyContext(this.cMD, this.cME, this.cMH);
                }
                this.cMH = null;
            }
            if (this.cME != null) {
                this.cMD.eglTerminate(this.cME);
                this.cME = null;
            }
        }

        private void jN(String str) {
            Q(str, this.cMD.eglGetError());
        }

        public static void Q(String str, int i) {
            throw new RuntimeException(R(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, R(str2, i));
        }

        public static String R(String str, int i) {
            return str + " failed: " + com.baidu.tieba.b.d.b.lz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean cMI;
        private boolean cMJ;
        private boolean cMK;
        private boolean cML;
        private boolean cMM;
        private boolean cMN;
        private boolean cMO;
        private boolean cMP;
        private boolean cMQ;
        private boolean cMR;
        private boolean cMU;
        private WeakReference<c> cNq;
        private h cNr;
        private boolean vv;
        private ArrayList<Runnable> cMV = new ArrayList<>();
        private boolean cMW = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cMT = true;
        private int cMS = 1;

        i(WeakReference<c> weakReference) {
            this.cNq = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aiH();
                    c.cNj.a(this);
                } catch (Exception e) {
                    af.CB().bh(false);
                    c.cNj.a(this);
                }
            } catch (Throwable th) {
                c.cNj.a(this);
                throw th;
            }
        }

        private void aiF() {
            if (this.cMP) {
                this.cMP = false;
                this.cNr.aiD();
            }
        }

        private void aiG() {
            if (this.cMO) {
                this.cNr.finish();
                this.cMO = false;
                c.cNj.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aiH() throws InterruptedException {
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
            this.cNr = new h(this.cNq);
            this.cMO = false;
            this.cMP = false;
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
                    synchronized (c.cNj) {
                        while (!this.cMI) {
                            if (this.cMV.isEmpty()) {
                                if (this.vv != this.cMK) {
                                    boolean z23 = this.cMK;
                                    this.vv = this.cMK;
                                    c.cNj.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cMR) {
                                    aiF();
                                    aiG();
                                    this.cMR = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aiF();
                                    aiG();
                                    z19 = false;
                                }
                                if (z9 && this.cMP) {
                                    aiF();
                                }
                                if (z9 && this.cMO) {
                                    c cVar = this.cNq.get();
                                    if (!(cVar == null ? false : cVar.cMz) || c.cNj.aiN()) {
                                        aiG();
                                    }
                                }
                                if (z9 && c.cNj.aiO()) {
                                    this.cNr.finish();
                                }
                                if (!this.cML && !this.cMN) {
                                    if (this.cMP) {
                                        aiF();
                                    }
                                    this.cMN = true;
                                    this.cMM = false;
                                    c.cNj.notifyAll();
                                }
                                if (this.cML && this.cMN) {
                                    this.cMN = false;
                                    c.cNj.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cMU = true;
                                    c.cNj.notifyAll();
                                }
                                if (aiJ()) {
                                    if (!this.cMO) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.cNj.b(this)) {
                                            try {
                                                this.cNr.start();
                                                this.cMO = true;
                                                z15 = true;
                                                c.cNj.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.cNj.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cMO || this.cMP) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cMP = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cMP) {
                                        if (this.cMW) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cMW = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cMT = false;
                                        c.cNj.notifyAll();
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
                                c.cNj.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cMV.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.cNj) {
                            aiF();
                            aiG();
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
                        } else if (this.cNr.aiA()) {
                            synchronized (c.cNj) {
                                this.cMQ = true;
                                c.cNj.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.cNj) {
                                this.cMQ = true;
                                this.cMM = true;
                                c.cNj.notifyAll();
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
                            GL10 gl103 = (GL10) this.cNr.aiB();
                            c.cNj.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.cNq.get();
                            if (cVar2 != null) {
                                cVar2.cMs.onSurfaceCreated(gl10, this.cNr.cMG);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.cNq.get();
                            if (cVar3 != null) {
                                cVar3.cMs.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.cNq.get();
                        if (cVar4 != null) {
                            cVar4.cMs.onDrawFrame(gl10);
                        }
                        int aiC = this.cNr.aiC();
                        switch (aiC) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", aiC);
                                synchronized (c.cNj) {
                                    this.cMM = true;
                                    c.cNj.notifyAll();
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
                    synchronized (c.cNj) {
                        aiF();
                        aiG();
                        throw th;
                    }
                }
            }
        }

        public boolean aiI() {
            return this.cMO && this.cMP && aiJ();
        }

        private boolean aiJ() {
            return !this.vv && this.cML && !this.cMM && this.mWidth > 0 && this.mHeight > 0 && (this.cMT || this.cMS == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.cNj) {
                    this.cMS = i;
                    c.cNj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.cNj) {
                i = this.cMS;
            }
            return i;
        }

        public void aiK() {
            synchronized (c.cNj) {
                this.cML = true;
                this.cMQ = false;
                c.cNj.notifyAll();
                while (this.cMN && !this.cMQ && !this.cMJ) {
                    try {
                        c.cNj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.cNj) {
                this.cML = false;
                c.cNj.notifyAll();
                while (!this.cMN && !this.cMJ) {
                    try {
                        c.cNj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void bj(int i, int i2) {
            synchronized (c.cNj) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cMW = true;
                this.cMT = true;
                this.cMU = false;
                c.cNj.notifyAll();
                while (!this.cMJ && !this.vv && !this.cMU && aiI()) {
                    try {
                        c.cNj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiL() {
            synchronized (c.cNj) {
                this.cMI = true;
                c.cNj.notifyAll();
                while (!this.cMJ) {
                    try {
                        c.cNj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiM() {
            this.cMR = true;
            c.cNj.notifyAll();
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

    private void aiy() {
        if (this.cNk != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cMY;
        private int cMZ;
        private boolean cNa;
        private boolean cNb;
        private boolean cNc;
        private i cNs;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cMJ = true;
            if (this.cNs == iVar) {
                this.cNs = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cNs == iVar || this.cNs == null) {
                this.cNs = iVar;
                notifyAll();
                return true;
            }
            aiP();
            if (this.cNb) {
                return true;
            }
            if (this.cNs != null) {
                this.cNs.aiM();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cNs == iVar) {
                this.cNs = null;
            }
            notifyAll();
        }

        public synchronized boolean aiN() {
            return this.cNc;
        }

        public synchronized boolean aiO() {
            aiP();
            return !this.cNb;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cNa) {
                    aiP();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cMZ < 131072) {
                        this.cNb = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cNc = this.cNb ? false : true;
                    this.cNa = true;
                }
            }
        }

        private void aiP() {
            if (!this.cMY) {
                this.cNb = true;
                this.cMY = true;
            }
        }
    }
}
