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
    private static final j bDt = new j();
    private m bCB;
    private int bCG;
    private int bCH;
    private boolean bCI;
    private final WeakReference<c> bCz;
    private i bDu;
    private e bDv;
    private f bDw;
    private g bDx;
    private k bDy;
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
            if (this.bDu != null) {
                this.bDu.Vv();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bDy = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bCG = i2;
    }

    public int getDebugFlags() {
        return this.bCG;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bCI = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bCI;
    }

    public void setRenderer(m mVar) {
        Vi();
        if (this.bDv == null) {
            this.bDv = new n(true);
        }
        if (this.bDw == null) {
            this.bDw = new C0074c();
        }
        if (this.bDx == null) {
            this.bDx = new d();
        }
        this.bCB = mVar;
        this.bDu = new i(this.bCz);
        this.bDu.start();
    }

    public void setEGLContextFactory(f fVar) {
        Vi();
        this.bDw = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Vi();
        this.bDx = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Vi();
        this.bDv = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Vi();
        this.bCH = i2;
    }

    public void setRenderMode(int i2) {
        this.bDu.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bDu.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bDu.Vu();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bDu.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bDu.Z(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bCB != null) {
            int renderMode = this.bDu != null ? this.bDu.getRenderMode() : 1;
            this.bDu = new i(this.bCz);
            if (renderMode != 1) {
                this.bDu.setRenderMode(renderMode);
            }
            this.bDu.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bDu != null) {
            this.bDu.Vv();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bCH, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bCH == 0) {
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
        protected int[] bCJ;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bCJ = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bCJ, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bCJ, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (c.this.bCH == 2) {
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
        EGL10 bCM;
        EGLDisplay bCN;
        EGLSurface bCO;
        EGLConfig bCP;
        EGLContext bCQ;
        private WeakReference<c> bDA;

        public h(WeakReference<c> weakReference) {
            this.bDA = weakReference;
        }

        public void start() {
            this.bCM = (EGL10) EGLContext.getEGL();
            this.bCN = this.bCM.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bCN == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bCM.eglInitialize(this.bCN, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bDA.get();
            if (cVar != null) {
                this.bCP = cVar.bDv.chooseConfig(this.bCM, this.bCN);
                this.bCQ = cVar.bDw.createContext(this.bCM, this.bCN, this.bCP);
            } else {
                this.bCP = null;
                this.bCQ = null;
            }
            if (this.bCQ == null || this.bCQ == EGL10.EGL_NO_CONTEXT) {
                this.bCQ = null;
                iY("createContext");
            }
            this.bCO = null;
        }

        public boolean Vk() {
            if (this.bCM == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bCN == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bCP == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Vo();
            c cVar = this.bDA.get();
            if (cVar != null) {
                this.bCO = cVar.bDx.createWindowSurface(this.bCM, this.bCN, this.bCP, cVar.getHolder());
            } else {
                this.bCO = null;
            }
            if (this.bCO == null || this.bCO == EGL10.EGL_NO_SURFACE) {
                if (this.bCM.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bCM.eglMakeCurrent(this.bCN, this.bCO, this.bCO, this.bCQ)) {
                f("EGLHelper", "eglMakeCurrent", this.bCM.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Vl() {
            l lVar;
            GL gl = this.bCQ.getGL();
            c cVar = this.bDA.get();
            if (cVar != null) {
                if (cVar.bDy != null) {
                    gl = cVar.bDy.wrap(gl);
                }
                if ((cVar.bCG & 3) != 0) {
                    int i = 0;
                    if ((cVar.bCG & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bCG & 2) == 0) {
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

        public int Vm() {
            if (this.bCM.eglSwapBuffers(this.bCN, this.bCO)) {
                return 12288;
            }
            return this.bCM.eglGetError();
        }

        public void Vn() {
            Vo();
        }

        private void Vo() {
            if (this.bCO != null && this.bCO != EGL10.EGL_NO_SURFACE) {
                this.bCM.eglMakeCurrent(this.bCN, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bDA.get();
                if (cVar != null) {
                    cVar.bDx.destroySurface(this.bCM, this.bCN, this.bCO);
                }
                this.bCO = null;
            }
        }

        public void finish() {
            if (this.bCQ != null) {
                c cVar = this.bDA.get();
                if (cVar != null) {
                    cVar.bDw.destroyContext(this.bCM, this.bCN, this.bCQ);
                }
                this.bCQ = null;
            }
            if (this.bCN != null) {
                this.bCM.eglTerminate(this.bCN);
                this.bCN = null;
            }
        }

        private void iY(String str) {
            G(str, this.bCM.eglGetError());
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
        private boolean bCR;
        private boolean bCS;
        private boolean bCT;
        private boolean bCU;
        private boolean bCV;
        private boolean bCW;
        private boolean bCX;
        private boolean bCY;
        private boolean bCZ;
        private WeakReference<c> bDA;
        private h bDB;
        private boolean bDa;
        private boolean bDb;
        private boolean bDe;
        private ArrayList<Runnable> bDf = new ArrayList<>();
        private boolean bDg = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bDd = true;
        private int bDc = 1;

        i(WeakReference<c> weakReference) {
            this.bDA = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Vr();
                    c.bDt.a(this);
                } catch (Exception e) {
                    ae.vA().aC(false);
                    c.bDt.a(this);
                }
            } catch (Throwable th) {
                c.bDt.a(this);
                throw th;
            }
        }

        private void Vp() {
            if (this.bCZ) {
                this.bCZ = false;
                this.bDB.Vn();
            }
        }

        private void Vq() {
            if (this.bCY) {
                this.bDB.finish();
                this.bCY = false;
                c.bDt.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Vr() throws InterruptedException {
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
            this.bDB = new h(this.bDA);
            this.bCY = false;
            this.bCZ = false;
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
                    synchronized (c.bDt) {
                        while (!this.bCR) {
                            if (this.bDf.isEmpty()) {
                                if (this.bCU != this.bCT) {
                                    boolean z23 = this.bCT;
                                    this.bCU = this.bCT;
                                    c.bDt.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bDb) {
                                    Vp();
                                    Vq();
                                    this.bDb = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    Vp();
                                    Vq();
                                    z19 = false;
                                }
                                if (z9 && this.bCZ) {
                                    Vp();
                                }
                                if (z9 && this.bCY) {
                                    c cVar = this.bDA.get();
                                    if (!(cVar == null ? false : cVar.bCI) || c.bDt.Vx()) {
                                        Vq();
                                    }
                                }
                                if (z9 && c.bDt.Vy()) {
                                    this.bDB.finish();
                                }
                                if (!this.bCV && !this.bCX) {
                                    if (this.bCZ) {
                                        Vp();
                                    }
                                    this.bCX = true;
                                    this.bCW = false;
                                    c.bDt.notifyAll();
                                }
                                if (this.bCV && this.bCX) {
                                    this.bCX = false;
                                    c.bDt.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bDe = true;
                                    c.bDt.notifyAll();
                                }
                                if (Vt()) {
                                    if (!this.bCY) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bDt.b(this)) {
                                            try {
                                                this.bDB.start();
                                                this.bCY = true;
                                                z15 = true;
                                                c.bDt.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bDt.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bCY || this.bCZ) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bCZ = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bCZ) {
                                        if (this.bDg) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bDg = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bDd = false;
                                        c.bDt.notifyAll();
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
                                c.bDt.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bDf.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bDt) {
                            Vp();
                            Vq();
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
                        } else if (this.bDB.Vk()) {
                            synchronized (c.bDt) {
                                this.bDa = true;
                                c.bDt.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bDt) {
                                this.bDa = true;
                                this.bCW = true;
                                c.bDt.notifyAll();
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
                            GL10 gl103 = (GL10) this.bDB.Vl();
                            c.bDt.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bDA.get();
                            if (cVar2 != null) {
                                cVar2.bCB.onSurfaceCreated(gl10, this.bDB.bCP);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bDA.get();
                            if (cVar3 != null) {
                                cVar3.bCB.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bDA.get();
                        if (cVar4 != null) {
                            cVar4.bCB.onDrawFrame(gl10);
                        }
                        int Vm = this.bDB.Vm();
                        switch (Vm) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Vm);
                                synchronized (c.bDt) {
                                    this.bCW = true;
                                    c.bDt.notifyAll();
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
                    synchronized (c.bDt) {
                        Vp();
                        Vq();
                        throw th;
                    }
                }
            }
        }

        public boolean Vs() {
            return this.bCY && this.bCZ && Vt();
        }

        private boolean Vt() {
            return !this.bCU && this.bCV && !this.bCW && this.mWidth > 0 && this.mHeight > 0 && (this.bDd || this.bDc == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bDt) {
                    this.bDc = i;
                    c.bDt.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bDt) {
                i = this.bDc;
            }
            return i;
        }

        public void Vu() {
            synchronized (c.bDt) {
                this.bCV = true;
                this.bDa = false;
                c.bDt.notifyAll();
                while (this.bCX && !this.bDa && !this.bCS) {
                    try {
                        c.bDt.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bDt) {
                this.bCV = false;
                c.bDt.notifyAll();
                while (!this.bCX && !this.bCS) {
                    try {
                        c.bDt.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Z(int i, int i2) {
            synchronized (c.bDt) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bDg = true;
                this.bDd = true;
                this.bDe = false;
                c.bDt.notifyAll();
                while (!this.bCS && !this.bCU && !this.bDe && Vs()) {
                    try {
                        c.bDt.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vv() {
            synchronized (c.bDt) {
                this.bCR = true;
                c.bDt.notifyAll();
                while (!this.bCS) {
                    try {
                        c.bDt.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vw() {
            this.bDb = true;
            c.bDt.notifyAll();
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

    private void Vi() {
        if (this.bDu != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i bDC;
        private boolean bDi;
        private int bDj;
        private boolean bDk;
        private boolean bDl;
        private boolean bDm;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bCS = true;
            if (this.bDC == iVar) {
                this.bDC = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bDC == iVar || this.bDC == null) {
                this.bDC = iVar;
                notifyAll();
                return true;
            }
            Vz();
            if (this.bDl) {
                return true;
            }
            if (this.bDC != null) {
                this.bDC.Vw();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bDC == iVar) {
                this.bDC = null;
            }
            notifyAll();
        }

        public synchronized boolean Vx() {
            return this.bDm;
        }

        public synchronized boolean Vy() {
            Vz();
            return !this.bDl;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bDk) {
                    Vz();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bDj < 131072) {
                        this.bDl = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bDm = this.bDl ? false : true;
                    this.bDk = true;
                }
            }
        }

        private void Vz() {
            if (!this.bDi) {
                this.bDl = true;
                this.bDi = true;
            }
        }
    }
}
