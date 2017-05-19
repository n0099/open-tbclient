package com.baidu.tieba.b.d;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.tbadk.core.util.ai;
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
    private static final j bsz = new j(null);
    private final WeakReference<c> brF;
    private m brH;
    private int brM;
    private int brN;
    private boolean brO;
    private i bsA;
    private e bsB;
    private f bsC;
    private g bsD;
    private k bsE;
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

    public c(Context context) {
        super(context);
        this.brF = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bsA != null) {
                this.bsA.Sp();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.bsE = kVar;
    }

    public void setDebugFlags(int i2) {
        this.brM = i2;
    }

    public int getDebugFlags() {
        return this.brM;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.brO = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.brO;
    }

    public void setRenderer(m mVar) {
        Sc();
        if (this.bsB == null) {
            this.bsB = new n(true);
        }
        if (this.bsC == null) {
            this.bsC = new C0057c(this, null);
        }
        if (this.bsD == null) {
            this.bsD = new d(null);
        }
        this.brH = mVar;
        this.bsA = new i(this.brF);
        this.bsA.start();
    }

    public void setEGLContextFactory(f fVar) {
        Sc();
        this.bsC = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Sc();
        this.bsD = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Sc();
        this.bsB = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        Sc();
        this.brN = i2;
    }

    public void setRenderMode(int i2) {
        this.bsA.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bsA.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bsA.So();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bsA.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bsA.Z(i3, i4);
    }

    public void onPause() {
        this.bsA.onPause();
    }

    public void onResume() {
        this.bsA.onResume();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.brH != null) {
            int renderMode = this.bsA != null ? this.bsA.getRenderMode() : 1;
            this.bsA = new i(this.brF);
            if (renderMode != 1) {
                this.bsA.setRenderMode(renderMode);
            }
            this.bsA.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bsA != null) {
            this.bsA.Sp();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0057c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0057c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ C0057c(c cVar, C0057c c0057c) {
            this();
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.brN, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.brN == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.c.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.F("eglDestroyContex", egl10.eglGetError());
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
        protected int[] brP;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.brP = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.brP, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.brP, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (c.this.brN == 2) {
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
        EGL10 brS;
        EGLDisplay brT;
        EGLSurface brU;
        EGLConfig brV;
        EGLContext brW;
        private WeakReference<c> bsG;

        public h(WeakReference<c> weakReference) {
            this.bsG = weakReference;
        }

        public void start() {
            this.brS = (EGL10) EGLContext.getEGL();
            this.brT = this.brS.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.brT == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.brS.eglInitialize(this.brT, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bsG.get();
            if (cVar == null) {
                this.brV = null;
                this.brW = null;
            } else {
                this.brV = cVar.bsB.chooseConfig(this.brS, this.brT);
                this.brW = cVar.bsC.createContext(this.brS, this.brT, this.brV);
            }
            if (this.brW == null || this.brW == EGL10.EGL_NO_CONTEXT) {
                this.brW = null;
                hS("createContext");
            }
            this.brU = null;
        }

        public boolean Se() {
            if (this.brS == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.brT == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.brV == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Si();
            c cVar = this.bsG.get();
            if (cVar != null) {
                this.brU = cVar.bsD.createWindowSurface(this.brS, this.brT, this.brV, cVar.getHolder());
            } else {
                this.brU = null;
            }
            if (this.brU == null || this.brU == EGL10.EGL_NO_SURFACE) {
                if (this.brS.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.brS.eglMakeCurrent(this.brT, this.brU, this.brU, this.brW)) {
                f("EGLHelper", "eglMakeCurrent", this.brS.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Sf() {
            l lVar;
            GL gl = this.brW.getGL();
            c cVar = this.bsG.get();
            if (cVar == null) {
                return gl;
            }
            if (cVar.bsE != null) {
                gl = cVar.bsE.wrap(gl);
            }
            if ((cVar.brM & 3) != 0) {
                int i = 0;
                if ((cVar.brM & 1) != 0) {
                    i = 1;
                }
                if ((cVar.brM & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Sg() {
            if (this.brS.eglSwapBuffers(this.brT, this.brU)) {
                return 12288;
            }
            return this.brS.eglGetError();
        }

        public void Sh() {
            Si();
        }

        private void Si() {
            if (this.brU != null && this.brU != EGL10.EGL_NO_SURFACE) {
                this.brS.eglMakeCurrent(this.brT, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bsG.get();
                if (cVar != null) {
                    cVar.bsD.destroySurface(this.brS, this.brT, this.brU);
                }
                this.brU = null;
            }
        }

        public void finish() {
            if (this.brW != null) {
                c cVar = this.bsG.get();
                if (cVar != null) {
                    cVar.bsC.destroyContext(this.brS, this.brT, this.brW);
                }
                this.brW = null;
            }
            if (this.brT != null) {
                this.brS.eglTerminate(this.brT);
                this.brT = null;
            }
        }

        private void hS(String str) {
            F(str, this.brS.eglGetError());
        }

        public static void F(String str, int i) {
            throw new RuntimeException(G(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, G(str2, i));
        }

        public static String G(String str, int i) {
            return String.valueOf(str) + " failed: " + com.baidu.tieba.b.d.b.gI(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean brX;
        private boolean brY;
        private boolean brZ;
        private WeakReference<c> bsG;
        private h bsH;
        private boolean bsa;
        private boolean bsb;
        private boolean bsc;
        private boolean bsd;
        private boolean bse;
        private boolean bsf;
        private boolean bsg;
        private boolean bsh;
        private boolean bsk;
        private ArrayList<Runnable> bsl = new ArrayList<>();
        private boolean bsm = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bsj = true;
        private int bsi = 1;

        i(WeakReference<c> weakReference) {
            this.bsG = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Sl();
                    c.bsz.a(this);
                } catch (Exception e) {
                    ai.uW().aD(false);
                    c.bsz.a(this);
                }
            } catch (Throwable th) {
                c.bsz.a(this);
                throw th;
            }
        }

        private void Sj() {
            if (this.bsf) {
                this.bsf = false;
                this.bsH.Sh();
            }
        }

        private void Sk() {
            if (this.bse) {
                this.bsH.finish();
                this.bse = false;
                c.bsz.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1396=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Sl() throws InterruptedException {
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
            this.bsH = new h(this.bsG);
            this.bse = false;
            this.bsf = false;
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
                    synchronized (c.bsz) {
                        while (!this.brX) {
                            if (this.bsl.isEmpty()) {
                                if (this.bsa != this.brZ) {
                                    boolean z23 = this.brZ;
                                    this.bsa = this.brZ;
                                    c.bsz.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bsh) {
                                    Sj();
                                    Sk();
                                    this.bsh = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Sj();
                                    Sk();
                                    z20 = false;
                                }
                                if (z9 && this.bsf) {
                                    Sj();
                                }
                                if (z9 && this.bse) {
                                    c cVar = this.bsG.get();
                                    if (!(cVar == null ? false : cVar.brO) || c.bsz.Sr()) {
                                        Sk();
                                    }
                                }
                                if (z9 && c.bsz.Ss()) {
                                    this.bsH.finish();
                                }
                                if (!this.bsb && !this.bsd) {
                                    if (this.bsf) {
                                        Sj();
                                    }
                                    this.bsd = true;
                                    this.bsc = false;
                                    c.bsz.notifyAll();
                                }
                                if (this.bsb && this.bsd) {
                                    this.bsd = false;
                                    c.bsz.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.bsk = true;
                                    c.bsz.notifyAll();
                                }
                                if (Sn()) {
                                    if (!this.bse) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bsz.b(this)) {
                                            try {
                                                this.bsH.start();
                                                this.bse = true;
                                                z15 = true;
                                                c.bsz.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bsz.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bse || this.bsf) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.bsf = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bsf) {
                                        if (this.bsm) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bsm = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bsj = false;
                                        c.bsz.notifyAll();
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
                                c.bsz.wait();
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
                                remove = this.bsl.remove(0);
                            }
                        }
                        synchronized (c.bsz) {
                            Sj();
                            Sk();
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
                        } else if (this.bsH.Se()) {
                            synchronized (c.bsz) {
                                this.bsg = true;
                                c.bsz.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bsz) {
                                this.bsg = true;
                                this.bsc = true;
                                c.bsz.notifyAll();
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
                            GL10 gl103 = (GL10) this.bsH.Sf();
                            c.bsz.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bsG.get();
                            if (cVar2 != null) {
                                cVar2.brH.onSurfaceCreated(gl10, this.bsH.brV);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            c cVar3 = this.bsG.get();
                            if (cVar3 != null) {
                                cVar3.brH.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        c cVar4 = this.bsG.get();
                        if (cVar4 != null) {
                            cVar4.brH.onDrawFrame(gl10);
                        }
                        int Sg = this.bsH.Sg();
                        switch (Sg) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Sg);
                                synchronized (c.bsz) {
                                    this.bsc = true;
                                    c.bsz.notifyAll();
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
                    synchronized (c.bsz) {
                        Sj();
                        Sk();
                        throw th;
                    }
                }
            }
        }

        public boolean Sm() {
            return this.bse && this.bsf && Sn();
        }

        private boolean Sn() {
            return !this.bsa && this.bsb && !this.bsc && this.mWidth > 0 && this.mHeight > 0 && (this.bsj || this.bsi == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (c.bsz) {
                this.bsi = i;
                c.bsz.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bsz) {
                i = this.bsi;
            }
            return i;
        }

        public void So() {
            synchronized (c.bsz) {
                this.bsb = true;
                this.bsg = false;
                c.bsz.notifyAll();
                while (this.bsd && !this.bsg && !this.brY) {
                    try {
                        c.bsz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bsz) {
                this.bsb = false;
                c.bsz.notifyAll();
                while (!this.bsd && !this.brY) {
                    try {
                        c.bsz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (c.bsz) {
                this.brZ = true;
                c.bsz.notifyAll();
                while (!this.brY && !this.bsa) {
                    try {
                        c.bsz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (c.bsz) {
                this.brZ = false;
                this.bsj = true;
                this.bsk = false;
                c.bsz.notifyAll();
                while (!this.brY && this.bsa && !this.bsk) {
                    try {
                        c.bsz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Z(int i, int i2) {
            synchronized (c.bsz) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bsm = true;
                this.bsj = true;
                this.bsk = false;
                c.bsz.notifyAll();
                while (!this.brY && !this.bsa && !this.bsk && Sm()) {
                    try {
                        c.bsz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Sp() {
            synchronized (c.bsz) {
                this.brX = true;
                c.bsz.notifyAll();
                while (!this.brY) {
                    try {
                        c.bsz.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Sq() {
            this.bsh = true;
            c.bsz.notifyAll();
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

    private void Sc() {
        if (this.bsA != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private i bsI;
        private boolean bso;
        private int bsp;
        private boolean bsq;
        private boolean bsr;
        private boolean bss;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.brY = true;
            if (this.bsI == iVar) {
                this.bsI = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bsI == iVar || this.bsI == null) {
                this.bsI = iVar;
                notifyAll();
                return true;
            }
            St();
            if (this.bsr) {
                return true;
            }
            if (this.bsI != null) {
                this.bsI.Sq();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bsI == iVar) {
                this.bsI = null;
            }
            notifyAll();
        }

        public synchronized boolean Sr() {
            return this.bss;
        }

        public synchronized boolean Ss() {
            St();
            return !this.bsr;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bsq) {
                    St();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bsp < 131072) {
                        this.bsr = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bss = this.bsr ? false : true;
                    this.bsq = true;
                }
            }
        }

        private void St() {
            if (!this.bso) {
                this.bsr = true;
                this.bso = true;
            }
        }
    }
}
