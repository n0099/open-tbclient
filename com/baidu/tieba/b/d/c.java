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
    private static final j bpS = new j(null);
    private final WeakReference<c> boY;
    private i bpT;
    private e bpU;
    private f bpV;
    private g bpW;
    private k bpX;
    private m bpa;
    private int bpf;
    private int bpg;
    private boolean bph;
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
        this.boY = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bpT != null) {
                this.bpT.Ru();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.bpX = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bpf = i2;
    }

    public int getDebugFlags() {
        return this.bpf;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bph = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bph;
    }

    public void setRenderer(m mVar) {
        Rh();
        if (this.bpU == null) {
            this.bpU = new n(true);
        }
        if (this.bpV == null) {
            this.bpV = new C0054c(this, null);
        }
        if (this.bpW == null) {
            this.bpW = new d(null);
        }
        this.bpa = mVar;
        this.bpT = new i(this.boY);
        this.bpT.start();
    }

    public void setEGLContextFactory(f fVar) {
        Rh();
        this.bpV = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Rh();
        this.bpW = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Rh();
        this.bpU = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        Rh();
        this.bpg = i2;
    }

    public void setRenderMode(int i2) {
        this.bpT.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bpT.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bpT.Rt();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bpT.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bpT.Y(i3, i4);
    }

    public void onPause() {
        this.bpT.onPause();
    }

    public void onResume() {
        this.bpT.onResume();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bpa != null) {
            int renderMode = this.bpT != null ? this.bpT.getRenderMode() : 1;
            this.bpT = new i(this.boY);
            if (renderMode != 1) {
                this.bpT.setRenderMode(renderMode);
            }
            this.bpT.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bpT != null) {
            this.bpT.Ru();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    /* renamed from: com.baidu.tieba.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0054c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C0054c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ C0054c(c cVar, C0054c c0054c) {
            this();
        }

        @Override // com.baidu.tieba.b.d.c.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bpg, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bpg == 0) {
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
        protected int[] bpi;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bpi = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bpi, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bpi, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (c.this.bpg == 2) {
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
        private WeakReference<c> bpZ;
        EGL10 bpl;
        EGLDisplay bpm;
        EGLSurface bpn;
        EGLConfig bpo;
        EGLContext bpp;

        public h(WeakReference<c> weakReference) {
            this.bpZ = weakReference;
        }

        public void start() {
            this.bpl = (EGL10) EGLContext.getEGL();
            this.bpm = this.bpl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bpm == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bpl.eglInitialize(this.bpm, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bpZ.get();
            if (cVar == null) {
                this.bpo = null;
                this.bpp = null;
            } else {
                this.bpo = cVar.bpU.chooseConfig(this.bpl, this.bpm);
                this.bpp = cVar.bpV.createContext(this.bpl, this.bpm, this.bpo);
            }
            if (this.bpp == null || this.bpp == EGL10.EGL_NO_CONTEXT) {
                this.bpp = null;
                hO("createContext");
            }
            this.bpn = null;
        }

        public boolean Rj() {
            if (this.bpl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bpm == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bpo == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Rn();
            c cVar = this.bpZ.get();
            if (cVar != null) {
                this.bpn = cVar.bpW.createWindowSurface(this.bpl, this.bpm, this.bpo, cVar.getHolder());
            } else {
                this.bpn = null;
            }
            if (this.bpn == null || this.bpn == EGL10.EGL_NO_SURFACE) {
                if (this.bpl.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bpl.eglMakeCurrent(this.bpm, this.bpn, this.bpn, this.bpp)) {
                f("EGLHelper", "eglMakeCurrent", this.bpl.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Rk() {
            l lVar;
            GL gl = this.bpp.getGL();
            c cVar = this.bpZ.get();
            if (cVar == null) {
                return gl;
            }
            if (cVar.bpX != null) {
                gl = cVar.bpX.wrap(gl);
            }
            if ((cVar.bpf & 3) != 0) {
                int i = 0;
                if ((cVar.bpf & 1) != 0) {
                    i = 1;
                }
                if ((cVar.bpf & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Rl() {
            if (this.bpl.eglSwapBuffers(this.bpm, this.bpn)) {
                return 12288;
            }
            return this.bpl.eglGetError();
        }

        public void Rm() {
            Rn();
        }

        private void Rn() {
            if (this.bpn != null && this.bpn != EGL10.EGL_NO_SURFACE) {
                this.bpl.eglMakeCurrent(this.bpm, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bpZ.get();
                if (cVar != null) {
                    cVar.bpW.destroySurface(this.bpl, this.bpm, this.bpn);
                }
                this.bpn = null;
            }
        }

        public void finish() {
            if (this.bpp != null) {
                c cVar = this.bpZ.get();
                if (cVar != null) {
                    cVar.bpV.destroyContext(this.bpl, this.bpm, this.bpp);
                }
                this.bpp = null;
            }
            if (this.bpm != null) {
                this.bpl.eglTerminate(this.bpm);
                this.bpm = null;
            }
        }

        private void hO(String str) {
            F(str, this.bpl.eglGetError());
        }

        public static void F(String str, int i) {
            throw new RuntimeException(G(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, G(str2, i));
        }

        public static String G(String str, int i) {
            return String.valueOf(str) + " failed: " + com.baidu.tieba.b.d.b.gC(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean bpA;
        private boolean bpD;
        private WeakReference<c> bpZ;
        private boolean bpq;
        private boolean bpr;
        private boolean bps;
        private boolean bpt;
        private boolean bpu;
        private boolean bpv;
        private boolean bpw;
        private boolean bpx;
        private boolean bpy;
        private boolean bpz;
        private h bqa;
        private ArrayList<Runnable> bpE = new ArrayList<>();
        private boolean bpF = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bpC = true;
        private int bpB = 1;

        i(WeakReference<c> weakReference) {
            this.bpZ = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Rq();
                    c.bpS.a(this);
                } catch (Exception e) {
                    ai.vm().aD(false);
                    c.bpS.a(this);
                }
            } catch (Throwable th) {
                c.bpS.a(this);
                throw th;
            }
        }

        private void Ro() {
            if (this.bpy) {
                this.bpy = false;
                this.bqa.Rm();
            }
        }

        private void Rp() {
            if (this.bpx) {
                this.bqa.finish();
                this.bpx = false;
                c.bpS.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1396=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Rq() throws InterruptedException {
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
            this.bqa = new h(this.bpZ);
            this.bpx = false;
            this.bpy = false;
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
                    synchronized (c.bpS) {
                        while (!this.bpq) {
                            if (this.bpE.isEmpty()) {
                                if (this.bpt != this.bps) {
                                    boolean z23 = this.bps;
                                    this.bpt = this.bps;
                                    c.bpS.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bpA) {
                                    Ro();
                                    Rp();
                                    this.bpA = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Ro();
                                    Rp();
                                    z20 = false;
                                }
                                if (z9 && this.bpy) {
                                    Ro();
                                }
                                if (z9 && this.bpx) {
                                    c cVar = this.bpZ.get();
                                    if (!(cVar == null ? false : cVar.bph) || c.bpS.Rw()) {
                                        Rp();
                                    }
                                }
                                if (z9 && c.bpS.Rx()) {
                                    this.bqa.finish();
                                }
                                if (!this.bpu && !this.bpw) {
                                    if (this.bpy) {
                                        Ro();
                                    }
                                    this.bpw = true;
                                    this.bpv = false;
                                    c.bpS.notifyAll();
                                }
                                if (this.bpu && this.bpw) {
                                    this.bpw = false;
                                    c.bpS.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.bpD = true;
                                    c.bpS.notifyAll();
                                }
                                if (Rs()) {
                                    if (!this.bpx) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bpS.b(this)) {
                                            try {
                                                this.bqa.start();
                                                this.bpx = true;
                                                z15 = true;
                                                c.bpS.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bpS.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bpx || this.bpy) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.bpy = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bpy) {
                                        if (this.bpF) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bpF = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bpC = false;
                                        c.bpS.notifyAll();
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
                                c.bpS.wait();
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
                                remove = this.bpE.remove(0);
                            }
                        }
                        synchronized (c.bpS) {
                            Ro();
                            Rp();
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
                        } else if (this.bqa.Rj()) {
                            synchronized (c.bpS) {
                                this.bpz = true;
                                c.bpS.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bpS) {
                                this.bpz = true;
                                this.bpv = true;
                                c.bpS.notifyAll();
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
                            GL10 gl103 = (GL10) this.bqa.Rk();
                            c.bpS.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bpZ.get();
                            if (cVar2 != null) {
                                cVar2.bpa.onSurfaceCreated(gl10, this.bqa.bpo);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            c cVar3 = this.bpZ.get();
                            if (cVar3 != null) {
                                cVar3.bpa.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        c cVar4 = this.bpZ.get();
                        if (cVar4 != null) {
                            cVar4.bpa.onDrawFrame(gl10);
                        }
                        int Rl = this.bqa.Rl();
                        switch (Rl) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Rl);
                                synchronized (c.bpS) {
                                    this.bpv = true;
                                    c.bpS.notifyAll();
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
                    synchronized (c.bpS) {
                        Ro();
                        Rp();
                        throw th;
                    }
                }
            }
        }

        public boolean Rr() {
            return this.bpx && this.bpy && Rs();
        }

        private boolean Rs() {
            return !this.bpt && this.bpu && !this.bpv && this.mWidth > 0 && this.mHeight > 0 && (this.bpC || this.bpB == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (c.bpS) {
                this.bpB = i;
                c.bpS.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bpS) {
                i = this.bpB;
            }
            return i;
        }

        public void Rt() {
            synchronized (c.bpS) {
                this.bpu = true;
                this.bpz = false;
                c.bpS.notifyAll();
                while (this.bpw && !this.bpz && !this.bpr) {
                    try {
                        c.bpS.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bpS) {
                this.bpu = false;
                c.bpS.notifyAll();
                while (!this.bpw && !this.bpr) {
                    try {
                        c.bpS.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (c.bpS) {
                this.bps = true;
                c.bpS.notifyAll();
                while (!this.bpr && !this.bpt) {
                    try {
                        c.bpS.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (c.bpS) {
                this.bps = false;
                this.bpC = true;
                this.bpD = false;
                c.bpS.notifyAll();
                while (!this.bpr && this.bpt && !this.bpD) {
                    try {
                        c.bpS.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Y(int i, int i2) {
            synchronized (c.bpS) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bpF = true;
                this.bpC = true;
                this.bpD = false;
                c.bpS.notifyAll();
                while (!this.bpr && !this.bpt && !this.bpD && Rr()) {
                    try {
                        c.bpS.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Ru() {
            synchronized (c.bpS) {
                this.bpq = true;
                c.bpS.notifyAll();
                while (!this.bpr) {
                    try {
                        c.bpS.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Rv() {
            this.bpA = true;
            c.bpS.notifyAll();
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

    private void Rh() {
        if (this.bpT != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bpH;
        private int bpI;
        private boolean bpJ;
        private boolean bpK;
        private boolean bpL;
        private i bqb;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.bpr = true;
            if (this.bqb == iVar) {
                this.bqb = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bqb == iVar || this.bqb == null) {
                this.bqb = iVar;
                notifyAll();
                return true;
            }
            Ry();
            if (this.bpK) {
                return true;
            }
            if (this.bqb != null) {
                this.bqb.Rv();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bqb == iVar) {
                this.bqb = null;
            }
            notifyAll();
        }

        public synchronized boolean Rw() {
            return this.bpL;
        }

        public synchronized boolean Rx() {
            Ry();
            return !this.bpK;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bpJ) {
                    Ry();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bpI < 131072) {
                        this.bpK = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bpL = this.bpK ? false : true;
                    this.bpJ = true;
                }
            }
        }

        private void Ry() {
            if (!this.bpH) {
                this.bpK = true;
                this.bpH = true;
            }
        }
    }
}
