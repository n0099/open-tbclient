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
    private static final j bsc = new j(null);
    private final WeakReference<c> bri;
    private m brk;
    private int brp;
    private int brq;
    private boolean brr;
    private i bsd;
    private e bse;
    private f bsf;
    private g bsg;
    private k bsh;
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
        this.bri = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bsd != null) {
                this.bsd.SU();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.bsh = kVar;
    }

    public void setDebugFlags(int i2) {
        this.brp = i2;
    }

    public int getDebugFlags() {
        return this.brp;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.brr = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.brr;
    }

    public void setRenderer(m mVar) {
        SH();
        if (this.bse == null) {
            this.bse = new n(true);
        }
        if (this.bsf == null) {
            this.bsf = new C0053c(this, null);
        }
        if (this.bsg == null) {
            this.bsg = new d(null);
        }
        this.brk = mVar;
        this.bsd = new i(this.bri);
        this.bsd.start();
    }

    public void setEGLContextFactory(f fVar) {
        SH();
        this.bsf = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        SH();
        this.bsg = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        SH();
        this.bse = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        SH();
        this.brq = i2;
    }

    public void setRenderMode(int i2) {
        this.bsd.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bsd.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bsd.ST();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bsd.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bsd.Y(i3, i4);
    }

    public void onPause() {
        this.bsd.onPause();
    }

    public void onResume() {
        this.bsd.onResume();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.brk != null) {
            int renderMode = this.bsd != null ? this.bsd.getRenderMode() : 1;
            this.bsd = new i(this.bri);
            if (renderMode != 1) {
                this.bsd.setRenderMode(renderMode);
            }
            this.bsd.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bsd != null) {
            this.bsd.SU();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0053c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0053c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ C0053c(c cVar, C0053c c0053c) {
            this();
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.brq, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.brq == 0) {
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
        protected int[] brs;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.brs = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.brs, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.brs, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (c.this.brq == 2) {
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
        EGL10 brv;
        EGLDisplay brw;
        EGLSurface brx;
        EGLConfig bry;
        EGLContext brz;
        private WeakReference<c> bsj;

        public h(WeakReference<c> weakReference) {
            this.bsj = weakReference;
        }

        public void start() {
            this.brv = (EGL10) EGLContext.getEGL();
            this.brw = this.brv.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.brw == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.brv.eglInitialize(this.brw, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bsj.get();
            if (cVar == null) {
                this.bry = null;
                this.brz = null;
            } else {
                this.bry = cVar.bse.chooseConfig(this.brv, this.brw);
                this.brz = cVar.bsf.createContext(this.brv, this.brw, this.bry);
            }
            if (this.brz == null || this.brz == EGL10.EGL_NO_CONTEXT) {
                this.brz = null;
                hT("createContext");
            }
            this.brx = null;
        }

        public boolean SJ() {
            if (this.brv == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.brw == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bry == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            SN();
            c cVar = this.bsj.get();
            if (cVar != null) {
                this.brx = cVar.bsg.createWindowSurface(this.brv, this.brw, this.bry, cVar.getHolder());
            } else {
                this.brx = null;
            }
            if (this.brx == null || this.brx == EGL10.EGL_NO_SURFACE) {
                if (this.brv.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.brv.eglMakeCurrent(this.brw, this.brx, this.brx, this.brz)) {
                f("EGLHelper", "eglMakeCurrent", this.brv.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL SK() {
            l lVar;
            GL gl = this.brz.getGL();
            c cVar = this.bsj.get();
            if (cVar == null) {
                return gl;
            }
            if (cVar.bsh != null) {
                gl = cVar.bsh.wrap(gl);
            }
            if ((cVar.brp & 3) != 0) {
                int i = 0;
                if ((cVar.brp & 1) != 0) {
                    i = 1;
                }
                if ((cVar.brp & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int SL() {
            if (this.brv.eglSwapBuffers(this.brw, this.brx)) {
                return 12288;
            }
            return this.brv.eglGetError();
        }

        public void SM() {
            SN();
        }

        private void SN() {
            if (this.brx != null && this.brx != EGL10.EGL_NO_SURFACE) {
                this.brv.eglMakeCurrent(this.brw, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bsj.get();
                if (cVar != null) {
                    cVar.bsg.destroySurface(this.brv, this.brw, this.brx);
                }
                this.brx = null;
            }
        }

        public void finish() {
            if (this.brz != null) {
                c cVar = this.bsj.get();
                if (cVar != null) {
                    cVar.bsf.destroyContext(this.brv, this.brw, this.brz);
                }
                this.brz = null;
            }
            if (this.brw != null) {
                this.brv.eglTerminate(this.brw);
                this.brw = null;
            }
        }

        private void hT(String str) {
            F(str, this.brv.eglGetError());
        }

        public static void F(String str, int i) {
            throw new RuntimeException(G(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, G(str2, i));
        }

        public static String G(String str, int i) {
            return String.valueOf(str) + " failed: " + com.baidu.tieba.b.d.b.gL(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean brA;
        private boolean brB;
        private boolean brC;
        private boolean brD;
        private boolean brE;
        private boolean brF;
        private boolean brG;
        private boolean brH;
        private boolean brI;
        private boolean brJ;
        private boolean brK;
        private boolean brN;
        private WeakReference<c> bsj;
        private h bsk;
        private ArrayList<Runnable> brO = new ArrayList<>();
        private boolean brP = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean brM = true;
        private int brL = 1;

        i(WeakReference<c> weakReference) {
            this.bsj = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    SQ();
                    c.bsc.a(this);
                } catch (Exception e) {
                    ai.vJ().aF(false);
                    c.bsc.a(this);
                }
            } catch (Throwable th) {
                c.bsc.a(this);
                throw th;
            }
        }

        private void SO() {
            if (this.brI) {
                this.brI = false;
                this.bsk.SM();
            }
        }

        private void SP() {
            if (this.brH) {
                this.bsk.finish();
                this.brH = false;
                c.bsc.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1396=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void SQ() throws InterruptedException {
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
            this.bsk = new h(this.bsj);
            this.brH = false;
            this.brI = false;
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
                    synchronized (c.bsc) {
                        while (!this.brA) {
                            if (this.brO.isEmpty()) {
                                if (this.brD != this.brC) {
                                    boolean z23 = this.brC;
                                    this.brD = this.brC;
                                    c.bsc.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.brK) {
                                    SO();
                                    SP();
                                    this.brK = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    SO();
                                    SP();
                                    z20 = false;
                                }
                                if (z9 && this.brI) {
                                    SO();
                                }
                                if (z9 && this.brH) {
                                    c cVar = this.bsj.get();
                                    if (!(cVar == null ? false : cVar.brr) || c.bsc.SW()) {
                                        SP();
                                    }
                                }
                                if (z9 && c.bsc.SX()) {
                                    this.bsk.finish();
                                }
                                if (!this.brE && !this.brG) {
                                    if (this.brI) {
                                        SO();
                                    }
                                    this.brG = true;
                                    this.brF = false;
                                    c.bsc.notifyAll();
                                }
                                if (this.brE && this.brG) {
                                    this.brG = false;
                                    c.bsc.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.brN = true;
                                    c.bsc.notifyAll();
                                }
                                if (SS()) {
                                    if (!this.brH) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bsc.b(this)) {
                                            try {
                                                this.bsk.start();
                                                this.brH = true;
                                                z15 = true;
                                                c.bsc.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bsc.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.brH || this.brI) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.brI = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.brI) {
                                        if (this.brP) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.brP = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.brM = false;
                                        c.bsc.notifyAll();
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
                                c.bsc.wait();
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
                                remove = this.brO.remove(0);
                            }
                        }
                        synchronized (c.bsc) {
                            SO();
                            SP();
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
                        } else if (this.bsk.SJ()) {
                            synchronized (c.bsc) {
                                this.brJ = true;
                                c.bsc.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bsc) {
                                this.brJ = true;
                                this.brF = true;
                                c.bsc.notifyAll();
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
                            GL10 gl103 = (GL10) this.bsk.SK();
                            c.bsc.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bsj.get();
                            if (cVar2 != null) {
                                cVar2.brk.onSurfaceCreated(gl10, this.bsk.bry);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            c cVar3 = this.bsj.get();
                            if (cVar3 != null) {
                                cVar3.brk.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        c cVar4 = this.bsj.get();
                        if (cVar4 != null) {
                            cVar4.brk.onDrawFrame(gl10);
                        }
                        int SL = this.bsk.SL();
                        switch (SL) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", SL);
                                synchronized (c.bsc) {
                                    this.brF = true;
                                    c.bsc.notifyAll();
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
                    synchronized (c.bsc) {
                        SO();
                        SP();
                        throw th;
                    }
                }
            }
        }

        public boolean SR() {
            return this.brH && this.brI && SS();
        }

        private boolean SS() {
            return !this.brD && this.brE && !this.brF && this.mWidth > 0 && this.mHeight > 0 && (this.brM || this.brL == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (c.bsc) {
                this.brL = i;
                c.bsc.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bsc) {
                i = this.brL;
            }
            return i;
        }

        public void ST() {
            synchronized (c.bsc) {
                this.brE = true;
                this.brJ = false;
                c.bsc.notifyAll();
                while (this.brG && !this.brJ && !this.brB) {
                    try {
                        c.bsc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bsc) {
                this.brE = false;
                c.bsc.notifyAll();
                while (!this.brG && !this.brB) {
                    try {
                        c.bsc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (c.bsc) {
                this.brC = true;
                c.bsc.notifyAll();
                while (!this.brB && !this.brD) {
                    try {
                        c.bsc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (c.bsc) {
                this.brC = false;
                this.brM = true;
                this.brN = false;
                c.bsc.notifyAll();
                while (!this.brB && this.brD && !this.brN) {
                    try {
                        c.bsc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Y(int i, int i2) {
            synchronized (c.bsc) {
                this.mWidth = i;
                this.mHeight = i2;
                this.brP = true;
                this.brM = true;
                this.brN = false;
                c.bsc.notifyAll();
                while (!this.brB && !this.brD && !this.brN && SR()) {
                    try {
                        c.bsc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void SU() {
            synchronized (c.bsc) {
                this.brA = true;
                c.bsc.notifyAll();
                while (!this.brB) {
                    try {
                        c.bsc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void SV() {
            this.brK = true;
            c.bsc.notifyAll();
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

    private void SH() {
        if (this.bsd != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean brR;
        private int brS;
        private boolean brT;
        private boolean brU;
        private boolean brV;
        private i bsl;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.brB = true;
            if (this.bsl == iVar) {
                this.bsl = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bsl == iVar || this.bsl == null) {
                this.bsl = iVar;
                notifyAll();
                return true;
            }
            SY();
            if (this.brU) {
                return true;
            }
            if (this.bsl != null) {
                this.bsl.SV();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bsl == iVar) {
                this.bsl = null;
            }
            notifyAll();
        }

        public synchronized boolean SW() {
            return this.brV;
        }

        public synchronized boolean SX() {
            SY();
            return !this.brU;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.brT) {
                    SY();
                    String glGetString = gl10.glGetString(7937);
                    if (this.brS < 131072) {
                        this.brU = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.brV = this.brU ? false : true;
                    this.brT = true;
                }
            }
        }

        private void SY() {
            if (!this.brR) {
                this.brU = true;
                this.brR = true;
            }
        }
    }
}
