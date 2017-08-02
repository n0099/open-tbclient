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
    private static final j bBz = new j();
    private final WeakReference<c> bAF;
    private m bAH;
    private int bAM;
    private int bAN;
    private boolean bAO;
    private i bBA;
    private e bBB;
    private f bBC;
    private g bBD;
    private k bBE;
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
            if (this.bBA != null) {
                this.bBA.UX();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bBE = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bAM = i2;
    }

    public int getDebugFlags() {
        return this.bAM;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bAO = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bAO;
    }

    public void setRenderer(m mVar) {
        UK();
        if (this.bBB == null) {
            this.bBB = new n(true);
        }
        if (this.bBC == null) {
            this.bBC = new C0074c();
        }
        if (this.bBD == null) {
            this.bBD = new d();
        }
        this.bAH = mVar;
        this.bBA = new i(this.bAF);
        this.bBA.start();
    }

    public void setEGLContextFactory(f fVar) {
        UK();
        this.bBC = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        UK();
        this.bBD = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        UK();
        this.bBB = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        UK();
        this.bAN = i2;
    }

    public void setRenderMode(int i2) {
        this.bBA.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bBA.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bBA.UW();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bBA.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bBA.Y(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bAH != null) {
            int renderMode = this.bBA != null ? this.bBA.getRenderMode() : 1;
            this.bBA = new i(this.bAF);
            if (renderMode != 1) {
                this.bBA.setRenderMode(renderMode);
            }
            this.bBA.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bBA != null) {
            this.bBA.UX();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bAN, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bAN == 0) {
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
        protected int[] bAP;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bAP = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bAP, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bAP, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (c.this.bAN == 2) {
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
        EGL10 bAS;
        EGLDisplay bAT;
        EGLSurface bAU;
        EGLConfig bAV;
        EGLContext bAW;
        private WeakReference<c> bBG;

        public h(WeakReference<c> weakReference) {
            this.bBG = weakReference;
        }

        public void start() {
            this.bAS = (EGL10) EGLContext.getEGL();
            this.bAT = this.bAS.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bAT == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bAS.eglInitialize(this.bAT, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bBG.get();
            if (cVar != null) {
                this.bAV = cVar.bBB.chooseConfig(this.bAS, this.bAT);
                this.bAW = cVar.bBC.createContext(this.bAS, this.bAT, this.bAV);
            } else {
                this.bAV = null;
                this.bAW = null;
            }
            if (this.bAW == null || this.bAW == EGL10.EGL_NO_CONTEXT) {
                this.bAW = null;
                iP("createContext");
            }
            this.bAU = null;
        }

        public boolean UM() {
            if (this.bAS == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bAT == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bAV == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            UQ();
            c cVar = this.bBG.get();
            if (cVar != null) {
                this.bAU = cVar.bBD.createWindowSurface(this.bAS, this.bAT, this.bAV, cVar.getHolder());
            } else {
                this.bAU = null;
            }
            if (this.bAU == null || this.bAU == EGL10.EGL_NO_SURFACE) {
                if (this.bAS.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bAS.eglMakeCurrent(this.bAT, this.bAU, this.bAU, this.bAW)) {
                f("EGLHelper", "eglMakeCurrent", this.bAS.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL UN() {
            l lVar;
            GL gl = this.bAW.getGL();
            c cVar = this.bBG.get();
            if (cVar != null) {
                if (cVar.bBE != null) {
                    gl = cVar.bBE.wrap(gl);
                }
                if ((cVar.bAM & 3) != 0) {
                    int i = 0;
                    if ((cVar.bAM & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bAM & 2) == 0) {
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

        public int UO() {
            if (this.bAS.eglSwapBuffers(this.bAT, this.bAU)) {
                return 12288;
            }
            return this.bAS.eglGetError();
        }

        public void UP() {
            UQ();
        }

        private void UQ() {
            if (this.bAU != null && this.bAU != EGL10.EGL_NO_SURFACE) {
                this.bAS.eglMakeCurrent(this.bAT, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bBG.get();
                if (cVar != null) {
                    cVar.bBD.destroySurface(this.bAS, this.bAT, this.bAU);
                }
                this.bAU = null;
            }
        }

        public void finish() {
            if (this.bAW != null) {
                c cVar = this.bBG.get();
                if (cVar != null) {
                    cVar.bBC.destroyContext(this.bAS, this.bAT, this.bAW);
                }
                this.bAW = null;
            }
            if (this.bAT != null) {
                this.bAS.eglTerminate(this.bAT);
                this.bAT = null;
            }
        }

        private void iP(String str) {
            G(str, this.bAS.eglGetError());
        }

        public static void G(String str, int i) {
            throw new RuntimeException(H(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, H(str2, i));
        }

        public static String H(String str, int i) {
            return str + " failed: " + com.baidu.tieba.b.d.b.hk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean bAX;
        private boolean bAY;
        private boolean bAZ;
        private WeakReference<c> bBG;
        private h bBH;
        private boolean bBa;
        private boolean bBb;
        private boolean bBc;
        private boolean bBd;
        private boolean bBe;
        private boolean bBf;
        private boolean bBg;
        private boolean bBh;
        private boolean bBk;
        private ArrayList<Runnable> bBl = new ArrayList<>();
        private boolean bBm = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bBj = true;
        private int bBi = 1;

        i(WeakReference<c> weakReference) {
            this.bBG = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    UT();
                    c.bBz.a(this);
                } catch (Exception e) {
                    ae.vp().aC(false);
                    c.bBz.a(this);
                }
            } catch (Throwable th) {
                c.bBz.a(this);
                throw th;
            }
        }

        private void UR() {
            if (this.bBf) {
                this.bBf = false;
                this.bBH.UP();
            }
        }

        private void US() {
            if (this.bBe) {
                this.bBH.finish();
                this.bBe = false;
                c.bBz.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void UT() throws InterruptedException {
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
            this.bBH = new h(this.bBG);
            this.bBe = false;
            this.bBf = false;
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
                    synchronized (c.bBz) {
                        while (!this.bAX) {
                            if (this.bBl.isEmpty()) {
                                if (this.bBa != this.bAZ) {
                                    boolean z23 = this.bAZ;
                                    this.bBa = this.bAZ;
                                    c.bBz.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bBh) {
                                    UR();
                                    US();
                                    this.bBh = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    UR();
                                    US();
                                    z19 = false;
                                }
                                if (z9 && this.bBf) {
                                    UR();
                                }
                                if (z9 && this.bBe) {
                                    c cVar = this.bBG.get();
                                    if (!(cVar == null ? false : cVar.bAO) || c.bBz.UZ()) {
                                        US();
                                    }
                                }
                                if (z9 && c.bBz.Va()) {
                                    this.bBH.finish();
                                }
                                if (!this.bBb && !this.bBd) {
                                    if (this.bBf) {
                                        UR();
                                    }
                                    this.bBd = true;
                                    this.bBc = false;
                                    c.bBz.notifyAll();
                                }
                                if (this.bBb && this.bBd) {
                                    this.bBd = false;
                                    c.bBz.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bBk = true;
                                    c.bBz.notifyAll();
                                }
                                if (UV()) {
                                    if (!this.bBe) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bBz.b(this)) {
                                            try {
                                                this.bBH.start();
                                                this.bBe = true;
                                                z15 = true;
                                                c.bBz.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bBz.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bBe || this.bBf) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bBf = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bBf) {
                                        if (this.bBm) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bBm = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bBj = false;
                                        c.bBz.notifyAll();
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
                                c.bBz.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bBl.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bBz) {
                            UR();
                            US();
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
                        } else if (this.bBH.UM()) {
                            synchronized (c.bBz) {
                                this.bBg = true;
                                c.bBz.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bBz) {
                                this.bBg = true;
                                this.bBc = true;
                                c.bBz.notifyAll();
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
                            GL10 gl103 = (GL10) this.bBH.UN();
                            c.bBz.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bBG.get();
                            if (cVar2 != null) {
                                cVar2.bAH.onSurfaceCreated(gl10, this.bBH.bAV);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bBG.get();
                            if (cVar3 != null) {
                                cVar3.bAH.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bBG.get();
                        if (cVar4 != null) {
                            cVar4.bAH.onDrawFrame(gl10);
                        }
                        int UO = this.bBH.UO();
                        switch (UO) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", UO);
                                synchronized (c.bBz) {
                                    this.bBc = true;
                                    c.bBz.notifyAll();
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
                    synchronized (c.bBz) {
                        UR();
                        US();
                        throw th;
                    }
                }
            }
        }

        public boolean UU() {
            return this.bBe && this.bBf && UV();
        }

        private boolean UV() {
            return !this.bBa && this.bBb && !this.bBc && this.mWidth > 0 && this.mHeight > 0 && (this.bBj || this.bBi == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bBz) {
                    this.bBi = i;
                    c.bBz.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bBz) {
                i = this.bBi;
            }
            return i;
        }

        public void UW() {
            synchronized (c.bBz) {
                this.bBb = true;
                this.bBg = false;
                c.bBz.notifyAll();
                while (this.bBd && !this.bBg && !this.bAY) {
                    try {
                        c.bBz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bBz) {
                this.bBb = false;
                c.bBz.notifyAll();
                while (!this.bBd && !this.bAY) {
                    try {
                        c.bBz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Y(int i, int i2) {
            synchronized (c.bBz) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bBm = true;
                this.bBj = true;
                this.bBk = false;
                c.bBz.notifyAll();
                while (!this.bAY && !this.bBa && !this.bBk && UU()) {
                    try {
                        c.bBz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void UX() {
            synchronized (c.bBz) {
                this.bAX = true;
                c.bBz.notifyAll();
                while (!this.bAY) {
                    try {
                        c.bBz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void UY() {
            this.bBh = true;
            c.bBz.notifyAll();
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

    private void UK() {
        if (this.bBA != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i bBI;
        private boolean bBo;
        private int bBp;
        private boolean bBq;
        private boolean bBr;
        private boolean bBs;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bAY = true;
            if (this.bBI == iVar) {
                this.bBI = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bBI == iVar || this.bBI == null) {
                this.bBI = iVar;
                notifyAll();
                return true;
            }
            Vb();
            if (this.bBr) {
                return true;
            }
            if (this.bBI != null) {
                this.bBI.UY();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bBI == iVar) {
                this.bBI = null;
            }
            notifyAll();
        }

        public synchronized boolean UZ() {
            return this.bBs;
        }

        public synchronized boolean Va() {
            Vb();
            return !this.bBr;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bBq) {
                    Vb();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bBp < 131072) {
                        this.bBr = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bBs = this.bBr ? false : true;
                    this.bBq = true;
                }
            }
        }

        private void Vb() {
            if (!this.bBo) {
                this.bBr = true;
                this.bBo = true;
            }
        }
    }
}
