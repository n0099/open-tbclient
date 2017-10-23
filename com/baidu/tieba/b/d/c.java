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
    private static final j bID = new j();
    private final WeakReference<c> bHJ;
    private m bHL;
    private int bHQ;
    private int bHR;
    private boolean bHS;
    private i bIE;
    private e bIF;
    private f bIG;
    private g bIH;
    private k bII;
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
            if (this.bIE != null) {
                this.bIE.WZ();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bII = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bHQ = i2;
    }

    public int getDebugFlags() {
        return this.bHQ;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bHS = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bHS;
    }

    public void setRenderer(m mVar) {
        WM();
        if (this.bIF == null) {
            this.bIF = new n(true);
        }
        if (this.bIG == null) {
            this.bIG = new C0077c();
        }
        if (this.bIH == null) {
            this.bIH = new d();
        }
        this.bHL = mVar;
        this.bIE = new i(this.bHJ);
        this.bIE.start();
    }

    public void setEGLContextFactory(f fVar) {
        WM();
        this.bIG = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        WM();
        this.bIH = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        WM();
        this.bIF = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        WM();
        this.bHR = i2;
    }

    public void setRenderMode(int i2) {
        this.bIE.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bIE.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bIE.WY();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bIE.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bIE.ag(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bHL != null) {
            int renderMode = this.bIE != null ? this.bIE.getRenderMode() : 1;
            this.bIE = new i(this.bHJ);
            if (renderMode != 1) {
                this.bIE.setRenderMode(renderMode);
            }
            this.bIE.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bIE != null) {
            this.bIE.WZ();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0077c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0077c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bHR, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bHR == 0) {
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
        protected int[] bHT;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bHT = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bHT, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bHT, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (c.this.bHR == 2) {
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
        EGL10 bHW;
        EGLDisplay bHX;
        EGLSurface bHY;
        EGLConfig bHZ;
        private WeakReference<c> bIK;
        EGLContext bIa;

        public h(WeakReference<c> weakReference) {
            this.bIK = weakReference;
        }

        public void start() {
            this.bHW = (EGL10) EGLContext.getEGL();
            this.bHX = this.bHW.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bHX == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bHW.eglInitialize(this.bHX, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bIK.get();
            if (cVar != null) {
                this.bHZ = cVar.bIF.chooseConfig(this.bHW, this.bHX);
                this.bIa = cVar.bIG.createContext(this.bHW, this.bHX, this.bHZ);
            } else {
                this.bHZ = null;
                this.bIa = null;
            }
            if (this.bIa == null || this.bIa == EGL10.EGL_NO_CONTEXT) {
                this.bIa = null;
                jf("createContext");
            }
            this.bHY = null;
        }

        public boolean WO() {
            if (this.bHW == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bHX == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bHZ == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            WS();
            c cVar = this.bIK.get();
            if (cVar != null) {
                this.bHY = cVar.bIH.createWindowSurface(this.bHW, this.bHX, this.bHZ, cVar.getHolder());
            } else {
                this.bHY = null;
            }
            if (this.bHY == null || this.bHY == EGL10.EGL_NO_SURFACE) {
                if (this.bHW.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bHW.eglMakeCurrent(this.bHX, this.bHY, this.bHY, this.bIa)) {
                f("EGLHelper", "eglMakeCurrent", this.bHW.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL WP() {
            l lVar;
            GL gl = this.bIa.getGL();
            c cVar = this.bIK.get();
            if (cVar != null) {
                if (cVar.bII != null) {
                    gl = cVar.bII.wrap(gl);
                }
                if ((cVar.bHQ & 3) != 0) {
                    int i = 0;
                    if ((cVar.bHQ & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bHQ & 2) == 0) {
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

        public int WQ() {
            if (this.bHW.eglSwapBuffers(this.bHX, this.bHY)) {
                return 12288;
            }
            return this.bHW.eglGetError();
        }

        public void WR() {
            WS();
        }

        private void WS() {
            if (this.bHY != null && this.bHY != EGL10.EGL_NO_SURFACE) {
                this.bHW.eglMakeCurrent(this.bHX, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bIK.get();
                if (cVar != null) {
                    cVar.bIH.destroySurface(this.bHW, this.bHX, this.bHY);
                }
                this.bHY = null;
            }
        }

        public void finish() {
            if (this.bIa != null) {
                c cVar = this.bIK.get();
                if (cVar != null) {
                    cVar.bIG.destroyContext(this.bHW, this.bHX, this.bIa);
                }
                this.bIa = null;
            }
            if (this.bHX != null) {
                this.bHW.eglTerminate(this.bHX);
                this.bHX = null;
            }
        }

        private void jf(String str) {
            G(str, this.bHW.eglGetError());
        }

        public static void G(String str, int i) {
            throw new RuntimeException(H(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, H(str2, i));
        }

        public static String H(String str, int i) {
            return str + " failed: " + com.baidu.tieba.b.d.b.hM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<c> bIK;
        private h bIL;
        private boolean bIb;
        private boolean bIc;
        private boolean bId;
        private boolean bIe;
        private boolean bIf;
        private boolean bIg;
        private boolean bIh;
        private boolean bIi;
        private boolean bIj;
        private boolean bIk;
        private boolean bIl;
        private boolean bIo;
        private ArrayList<Runnable> bIp = new ArrayList<>();
        private boolean bIq = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bIn = true;
        private int bIm = 1;

        i(WeakReference<c> weakReference) {
            this.bIK = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    WV();
                    c.bID.a(this);
                } catch (Exception e) {
                    af.uU().aB(false);
                    c.bID.a(this);
                }
            } catch (Throwable th) {
                c.bID.a(this);
                throw th;
            }
        }

        private void WT() {
            if (this.bIj) {
                this.bIj = false;
                this.bIL.WR();
            }
        }

        private void WU() {
            if (this.bIi) {
                this.bIL.finish();
                this.bIi = false;
                c.bID.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void WV() throws InterruptedException {
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
            this.bIL = new h(this.bIK);
            this.bIi = false;
            this.bIj = false;
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
                    synchronized (c.bID) {
                        while (!this.bIb) {
                            if (this.bIp.isEmpty()) {
                                if (this.bIe != this.bId) {
                                    boolean z23 = this.bId;
                                    this.bIe = this.bId;
                                    c.bID.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bIl) {
                                    WT();
                                    WU();
                                    this.bIl = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    WT();
                                    WU();
                                    z19 = false;
                                }
                                if (z9 && this.bIj) {
                                    WT();
                                }
                                if (z9 && this.bIi) {
                                    c cVar = this.bIK.get();
                                    if (!(cVar == null ? false : cVar.bHS) || c.bID.Xb()) {
                                        WU();
                                    }
                                }
                                if (z9 && c.bID.Xc()) {
                                    this.bIL.finish();
                                }
                                if (!this.bIf && !this.bIh) {
                                    if (this.bIj) {
                                        WT();
                                    }
                                    this.bIh = true;
                                    this.bIg = false;
                                    c.bID.notifyAll();
                                }
                                if (this.bIf && this.bIh) {
                                    this.bIh = false;
                                    c.bID.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bIo = true;
                                    c.bID.notifyAll();
                                }
                                if (WX()) {
                                    if (!this.bIi) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bID.b(this)) {
                                            try {
                                                this.bIL.start();
                                                this.bIi = true;
                                                z15 = true;
                                                c.bID.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bID.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bIi || this.bIj) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bIj = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bIj) {
                                        if (this.bIq) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bIq = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bIn = false;
                                        c.bID.notifyAll();
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
                                c.bID.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bIp.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bID) {
                            WT();
                            WU();
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
                        } else if (this.bIL.WO()) {
                            synchronized (c.bID) {
                                this.bIk = true;
                                c.bID.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bID) {
                                this.bIk = true;
                                this.bIg = true;
                                c.bID.notifyAll();
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
                            GL10 gl103 = (GL10) this.bIL.WP();
                            c.bID.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bIK.get();
                            if (cVar2 != null) {
                                cVar2.bHL.onSurfaceCreated(gl10, this.bIL.bHZ);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bIK.get();
                            if (cVar3 != null) {
                                cVar3.bHL.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bIK.get();
                        if (cVar4 != null) {
                            cVar4.bHL.onDrawFrame(gl10);
                        }
                        int WQ = this.bIL.WQ();
                        switch (WQ) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", WQ);
                                synchronized (c.bID) {
                                    this.bIg = true;
                                    c.bID.notifyAll();
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
                    synchronized (c.bID) {
                        WT();
                        WU();
                        throw th;
                    }
                }
            }
        }

        public boolean WW() {
            return this.bIi && this.bIj && WX();
        }

        private boolean WX() {
            return !this.bIe && this.bIf && !this.bIg && this.mWidth > 0 && this.mHeight > 0 && (this.bIn || this.bIm == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bID) {
                    this.bIm = i;
                    c.bID.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bID) {
                i = this.bIm;
            }
            return i;
        }

        public void WY() {
            synchronized (c.bID) {
                this.bIf = true;
                this.bIk = false;
                c.bID.notifyAll();
                while (this.bIh && !this.bIk && !this.bIc) {
                    try {
                        c.bID.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bID) {
                this.bIf = false;
                c.bID.notifyAll();
                while (!this.bIh && !this.bIc) {
                    try {
                        c.bID.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ag(int i, int i2) {
            synchronized (c.bID) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bIq = true;
                this.bIn = true;
                this.bIo = false;
                c.bID.notifyAll();
                while (!this.bIc && !this.bIe && !this.bIo && WW()) {
                    try {
                        c.bID.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void WZ() {
            synchronized (c.bID) {
                this.bIb = true;
                c.bID.notifyAll();
                while (!this.bIc) {
                    try {
                        c.bID.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Xa() {
            this.bIl = true;
            c.bID.notifyAll();
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

    private void WM() {
        if (this.bIE != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i bIM;
        private boolean bIs;
        private int bIt;
        private boolean bIu;
        private boolean bIv;
        private boolean bIw;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bIc = true;
            if (this.bIM == iVar) {
                this.bIM = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bIM == iVar || this.bIM == null) {
                this.bIM = iVar;
                notifyAll();
                return true;
            }
            Xd();
            if (this.bIv) {
                return true;
            }
            if (this.bIM != null) {
                this.bIM.Xa();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bIM == iVar) {
                this.bIM = null;
            }
            notifyAll();
        }

        public synchronized boolean Xb() {
            return this.bIw;
        }

        public synchronized boolean Xc() {
            Xd();
            return !this.bIv;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bIu) {
                    Xd();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bIt < 131072) {
                        this.bIv = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bIw = this.bIv ? false : true;
                    this.bIu = true;
                }
            }
        }

        private void Xd() {
            if (!this.bIs) {
                this.bIv = true;
                this.bIs = true;
            }
        }
    }
}
