package com.baidu.tieba.b.d;

import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.tbadk.core.util.ae;
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
    private static final j bDs = new j();
    private m bCA;
    private int bCF;
    private int bCG;
    private boolean bCH;
    private final WeakReference<c> bCy;
    private i bDt;
    private e bDu;
    private f bDv;
    private g bDw;
    private k bDx;
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
            if (this.bDt != null) {
                this.bDt.Vy();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bDx = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bCF = i2;
    }

    public int getDebugFlags() {
        return this.bCF;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bCH = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bCH;
    }

    public void setRenderer(m mVar) {
        Vl();
        if (this.bDu == null) {
            this.bDu = new n(true);
        }
        if (this.bDv == null) {
            this.bDv = new C0074c();
        }
        if (this.bDw == null) {
            this.bDw = new d();
        }
        this.bCA = mVar;
        this.bDt = new i(this.bCy);
        this.bDt.start();
    }

    public void setEGLContextFactory(f fVar) {
        Vl();
        this.bDv = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Vl();
        this.bDw = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Vl();
        this.bDu = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Vl();
        this.bCG = i2;
    }

    public void setRenderMode(int i2) {
        this.bDt.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bDt.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bDt.Vx();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bDt.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bDt.Z(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bCA != null) {
            int renderMode = this.bDt != null ? this.bDt.getRenderMode() : 1;
            this.bDt = new i(this.bCy);
            if (renderMode != 1) {
                this.bDt.setRenderMode(renderMode);
            }
            this.bDt.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bDt != null) {
            this.bDt.Vy();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0074c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0074c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bCG, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bCG == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.c.f
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
        protected int[] bCI;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bCI = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bCI, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bCI, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (c.this.bCG == 2) {
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
        EGL10 bCL;
        EGLDisplay bCM;
        EGLSurface bCN;
        EGLConfig bCO;
        EGLContext bCP;
        private WeakReference<c> bDz;

        public h(WeakReference<c> weakReference) {
            this.bDz = weakReference;
        }

        public void start() {
            this.bCL = (EGL10) EGLContext.getEGL();
            this.bCM = this.bCL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bCM == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bCL.eglInitialize(this.bCM, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bDz.get();
            if (cVar != null) {
                this.bCO = cVar.bDu.chooseConfig(this.bCL, this.bCM);
                this.bCP = cVar.bDv.createContext(this.bCL, this.bCM, this.bCO);
            } else {
                this.bCO = null;
                this.bCP = null;
            }
            if (this.bCP == null || this.bCP == EGL10.EGL_NO_CONTEXT) {
                this.bCP = null;
                iV("createContext");
            }
            this.bCN = null;
        }

        public boolean Vn() {
            if (this.bCL == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bCM == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bCO == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Vr();
            c cVar = this.bDz.get();
            if (cVar != null) {
                this.bCN = cVar.bDw.createWindowSurface(this.bCL, this.bCM, this.bCO, cVar.getHolder());
            } else {
                this.bCN = null;
            }
            if (this.bCN == null || this.bCN == EGL10.EGL_NO_SURFACE) {
                if (this.bCL.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bCL.eglMakeCurrent(this.bCM, this.bCN, this.bCN, this.bCP)) {
                f("EGLHelper", "eglMakeCurrent", this.bCL.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Vo() {
            l lVar;
            GL gl = this.bCP.getGL();
            c cVar = this.bDz.get();
            if (cVar != null) {
                if (cVar.bDx != null) {
                    gl = cVar.bDx.wrap(gl);
                }
                if ((cVar.bCF & 3) != 0) {
                    int i = 0;
                    if ((cVar.bCF & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bCF & 2) == 0) {
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

        public int Vp() {
            if (this.bCL.eglSwapBuffers(this.bCM, this.bCN)) {
                return 12288;
            }
            return this.bCL.eglGetError();
        }

        public void Vq() {
            Vr();
        }

        private void Vr() {
            if (this.bCN != null && this.bCN != EGL10.EGL_NO_SURFACE) {
                this.bCL.eglMakeCurrent(this.bCM, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bDz.get();
                if (cVar != null) {
                    cVar.bDw.destroySurface(this.bCL, this.bCM, this.bCN);
                }
                this.bCN = null;
            }
        }

        public void finish() {
            if (this.bCP != null) {
                c cVar = this.bDz.get();
                if (cVar != null) {
                    cVar.bDv.destroyContext(this.bCL, this.bCM, this.bCP);
                }
                this.bCP = null;
            }
            if (this.bCM != null) {
                this.bCL.eglTerminate(this.bCM);
                this.bCM = null;
            }
        }

        private void iV(String str) {
            G(str, this.bCL.eglGetError());
        }

        public static void G(String str, int i) {
            throw new RuntimeException(H(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, H(str2, i));
        }

        public static String H(String str, int i) {
            return str + " failed: " + com.baidu.tieba.b.d.b.getErrorString(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean bCQ;
        private boolean bCR;
        private boolean bCS;
        private boolean bCT;
        private boolean bCU;
        private boolean bCV;
        private boolean bCW;
        private boolean bCX;
        private boolean bCY;
        private boolean bCZ;
        private h bDA;
        private boolean bDa;
        private boolean bDd;
        private WeakReference<c> bDz;
        private ArrayList<Runnable> bDe = new ArrayList<>();
        private boolean bDf = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bDc = true;
        private int bDb = 1;

        i(WeakReference<c> weakReference) {
            this.bDz = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Vu();
                    c.bDs.a(this);
                } catch (Exception e) {
                    ae.vz().aC(false);
                    c.bDs.a(this);
                }
            } catch (Throwable th) {
                c.bDs.a(this);
                throw th;
            }
        }

        private void Vs() {
            if (this.bCY) {
                this.bCY = false;
                this.bDA.Vq();
            }
        }

        private void Vt() {
            if (this.bCX) {
                this.bDA.finish();
                this.bCX = false;
                c.bDs.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Vu() throws InterruptedException {
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
            this.bDA = new h(this.bDz);
            this.bCX = false;
            this.bCY = false;
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
                    synchronized (c.bDs) {
                        while (!this.bCQ) {
                            if (this.bDe.isEmpty()) {
                                if (this.bCT != this.bCS) {
                                    boolean z23 = this.bCS;
                                    this.bCT = this.bCS;
                                    c.bDs.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bDa) {
                                    Vs();
                                    Vt();
                                    this.bDa = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    Vs();
                                    Vt();
                                    z19 = false;
                                }
                                if (z9 && this.bCY) {
                                    Vs();
                                }
                                if (z9 && this.bCX) {
                                    c cVar = this.bDz.get();
                                    if (!(cVar == null ? false : cVar.bCH) || c.bDs.VA()) {
                                        Vt();
                                    }
                                }
                                if (z9 && c.bDs.VB()) {
                                    this.bDA.finish();
                                }
                                if (!this.bCU && !this.bCW) {
                                    if (this.bCY) {
                                        Vs();
                                    }
                                    this.bCW = true;
                                    this.bCV = false;
                                    c.bDs.notifyAll();
                                }
                                if (this.bCU && this.bCW) {
                                    this.bCW = false;
                                    c.bDs.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bDd = true;
                                    c.bDs.notifyAll();
                                }
                                if (Vw()) {
                                    if (!this.bCX) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bDs.b(this)) {
                                            try {
                                                this.bDA.start();
                                                this.bCX = true;
                                                z15 = true;
                                                c.bDs.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bDs.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bCX || this.bCY) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bCY = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bCY) {
                                        if (this.bDf) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bDf = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bDc = false;
                                        c.bDs.notifyAll();
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
                                c.bDs.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bDe.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bDs) {
                            Vs();
                            Vt();
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
                        } else if (this.bDA.Vn()) {
                            synchronized (c.bDs) {
                                this.bCZ = true;
                                c.bDs.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bDs) {
                                this.bCZ = true;
                                this.bCV = true;
                                c.bDs.notifyAll();
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
                            GL10 gl103 = (GL10) this.bDA.Vo();
                            c.bDs.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bDz.get();
                            if (cVar2 != null) {
                                cVar2.bCA.onSurfaceCreated(gl10, this.bDA.bCO);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bDz.get();
                            if (cVar3 != null) {
                                cVar3.bCA.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bDz.get();
                        if (cVar4 != null) {
                            cVar4.bCA.onDrawFrame(gl10);
                        }
                        int Vp = this.bDA.Vp();
                        switch (Vp) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Vp);
                                synchronized (c.bDs) {
                                    this.bCV = true;
                                    c.bDs.notifyAll();
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
                    synchronized (c.bDs) {
                        Vs();
                        Vt();
                        throw th;
                    }
                }
            }
        }

        public boolean Vv() {
            return this.bCX && this.bCY && Vw();
        }

        private boolean Vw() {
            return !this.bCT && this.bCU && !this.bCV && this.mWidth > 0 && this.mHeight > 0 && (this.bDc || this.bDb == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bDs) {
                    this.bDb = i;
                    c.bDs.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bDs) {
                i = this.bDb;
            }
            return i;
        }

        public void Vx() {
            synchronized (c.bDs) {
                this.bCU = true;
                this.bCZ = false;
                c.bDs.notifyAll();
                while (this.bCW && !this.bCZ && !this.bCR) {
                    try {
                        c.bDs.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bDs) {
                this.bCU = false;
                c.bDs.notifyAll();
                while (!this.bCW && !this.bCR) {
                    try {
                        c.bDs.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Z(int i, int i2) {
            synchronized (c.bDs) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bDf = true;
                this.bDc = true;
                this.bDd = false;
                c.bDs.notifyAll();
                while (!this.bCR && !this.bCT && !this.bDd && Vv()) {
                    try {
                        c.bDs.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vy() {
            synchronized (c.bDs) {
                this.bCQ = true;
                c.bDs.notifyAll();
                while (!this.bCR) {
                    try {
                        c.bDs.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vz() {
            this.bDa = true;
            c.bDs.notifyAll();
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

    private void Vl() {
        if (this.bDt != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i bDB;
        private boolean bDh;
        private int bDi;
        private boolean bDj;
        private boolean bDk;
        private boolean bDl;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bCR = true;
            if (this.bDB == iVar) {
                this.bDB = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bDB == iVar || this.bDB == null) {
                this.bDB = iVar;
                notifyAll();
                return true;
            }
            VC();
            if (this.bDk) {
                return true;
            }
            if (this.bDB != null) {
                this.bDB.Vz();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bDB == iVar) {
                this.bDB = null;
            }
            notifyAll();
        }

        public synchronized boolean VA() {
            return this.bDl;
        }

        public synchronized boolean VB() {
            VC();
            return !this.bDk;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bDj) {
                    VC();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bDi < 131072) {
                        this.bDk = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bDl = this.bDk ? false : true;
                    this.bDj = true;
                }
            }
        }

        private void VC() {
            if (!this.bDh) {
                this.bDk = true;
                this.bDh = true;
            }
        }
    }
}
