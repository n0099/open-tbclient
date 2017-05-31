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
    private static final j btH = new j(null);
    private final WeakReference<c> bsM;
    private m bsO;
    private int bsT;
    private int bsU;
    private boolean bsV;
    private i btI;
    private e btJ;
    private f btK;
    private g btL;
    private k btM;
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
        this.bsM = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.btI != null) {
                this.btI.SB();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.btM = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bsT = i2;
    }

    public int getDebugFlags() {
        return this.bsT;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bsV = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bsV;
    }

    public void setRenderer(m mVar) {
        So();
        if (this.btJ == null) {
            this.btJ = new n(true);
        }
        if (this.btK == null) {
            this.btK = new C0057c(this, null);
        }
        if (this.btL == null) {
            this.btL = new d(null);
        }
        this.bsO = mVar;
        this.btI = new i(this.bsM);
        this.btI.start();
    }

    public void setEGLContextFactory(f fVar) {
        So();
        this.btK = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        So();
        this.btL = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        So();
        this.btJ = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        So();
        this.bsU = i2;
    }

    public void setRenderMode(int i2) {
        this.btI.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.btI.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.btI.SA();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.btI.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.btI.X(i3, i4);
    }

    public void onPause() {
        this.btI.onPause();
    }

    public void onResume() {
        this.btI.onResume();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bsO != null) {
            int renderMode = this.btI != null ? this.btI.getRenderMode() : 1;
            this.btI = new i(this.bsM);
            if (renderMode != 1) {
                this.btI.setRenderMode(renderMode);
            }
            this.btI.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.btI != null) {
            this.btI.SB();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bsU, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bsU == 0) {
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
        protected int[] bsW;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bsW = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bsW, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bsW, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (c.this.bsU == 2) {
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
        EGL10 bsZ;
        private WeakReference<c> btO;
        EGLDisplay bta;
        EGLSurface btb;
        EGLConfig btc;
        EGLContext btd;

        public h(WeakReference<c> weakReference) {
            this.btO = weakReference;
        }

        public void start() {
            this.bsZ = (EGL10) EGLContext.getEGL();
            this.bta = this.bsZ.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bta == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bsZ.eglInitialize(this.bta, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.btO.get();
            if (cVar == null) {
                this.btc = null;
                this.btd = null;
            } else {
                this.btc = cVar.btJ.chooseConfig(this.bsZ, this.bta);
                this.btd = cVar.btK.createContext(this.bsZ, this.bta, this.btc);
            }
            if (this.btd == null || this.btd == EGL10.EGL_NO_CONTEXT) {
                this.btd = null;
                hT("createContext");
            }
            this.btb = null;
        }

        public boolean Sq() {
            if (this.bsZ == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bta == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.btc == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Su();
            c cVar = this.btO.get();
            if (cVar != null) {
                this.btb = cVar.btL.createWindowSurface(this.bsZ, this.bta, this.btc, cVar.getHolder());
            } else {
                this.btb = null;
            }
            if (this.btb == null || this.btb == EGL10.EGL_NO_SURFACE) {
                if (this.bsZ.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bsZ.eglMakeCurrent(this.bta, this.btb, this.btb, this.btd)) {
                f("EGLHelper", "eglMakeCurrent", this.bsZ.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Sr() {
            l lVar;
            GL gl = this.btd.getGL();
            c cVar = this.btO.get();
            if (cVar == null) {
                return gl;
            }
            if (cVar.btM != null) {
                gl = cVar.btM.wrap(gl);
            }
            if ((cVar.bsT & 3) != 0) {
                int i = 0;
                if ((cVar.bsT & 1) != 0) {
                    i = 1;
                }
                if ((cVar.bsT & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Ss() {
            if (this.bsZ.eglSwapBuffers(this.bta, this.btb)) {
                return 12288;
            }
            return this.bsZ.eglGetError();
        }

        public void St() {
            Su();
        }

        private void Su() {
            if (this.btb != null && this.btb != EGL10.EGL_NO_SURFACE) {
                this.bsZ.eglMakeCurrent(this.bta, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.btO.get();
                if (cVar != null) {
                    cVar.btL.destroySurface(this.bsZ, this.bta, this.btb);
                }
                this.btb = null;
            }
        }

        public void finish() {
            if (this.btd != null) {
                c cVar = this.btO.get();
                if (cVar != null) {
                    cVar.btK.destroyContext(this.bsZ, this.bta, this.btd);
                }
                this.btd = null;
            }
            if (this.bta != null) {
                this.bsZ.eglTerminate(this.bta);
                this.bta = null;
            }
        }

        private void hT(String str) {
            F(str, this.bsZ.eglGetError());
        }

        public static void F(String str, int i) {
            throw new RuntimeException(G(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, G(str2, i));
        }

        public static String G(String str, int i) {
            return String.valueOf(str) + " failed: " + com.baidu.tieba.b.d.b.gZ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<c> btO;
        private h btP;
        private boolean bte;
        private boolean btf;
        private boolean btg;
        private boolean bth;
        private boolean bti;
        private boolean btj;
        private boolean btk;
        private boolean btl;
        private boolean btm;
        private boolean bto;
        private boolean btp;
        private boolean bts;
        private ArrayList<Runnable> btt = new ArrayList<>();
        private boolean btu = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean btr = true;
        private int btq = 1;

        i(WeakReference<c> weakReference) {
            this.btO = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Sx();
                    c.btH.a(this);
                } catch (Exception e) {
                    ai.uT().aC(false);
                    c.btH.a(this);
                }
            } catch (Throwable th) {
                c.btH.a(this);
                throw th;
            }
        }

        private void Sv() {
            if (this.btm) {
                this.btm = false;
                this.btP.St();
            }
        }

        private void Sw() {
            if (this.btl) {
                this.btP.finish();
                this.btl = false;
                c.btH.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1396=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Sx() throws InterruptedException {
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
            this.btP = new h(this.btO);
            this.btl = false;
            this.btm = false;
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
                    synchronized (c.btH) {
                        while (!this.bte) {
                            if (this.btt.isEmpty()) {
                                if (this.bth != this.btg) {
                                    boolean z23 = this.btg;
                                    this.bth = this.btg;
                                    c.btH.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.btp) {
                                    Sv();
                                    Sw();
                                    this.btp = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Sv();
                                    Sw();
                                    z20 = false;
                                }
                                if (z9 && this.btm) {
                                    Sv();
                                }
                                if (z9 && this.btl) {
                                    c cVar = this.btO.get();
                                    if (!(cVar == null ? false : cVar.bsV) || c.btH.SD()) {
                                        Sw();
                                    }
                                }
                                if (z9 && c.btH.SE()) {
                                    this.btP.finish();
                                }
                                if (!this.bti && !this.btk) {
                                    if (this.btm) {
                                        Sv();
                                    }
                                    this.btk = true;
                                    this.btj = false;
                                    c.btH.notifyAll();
                                }
                                if (this.bti && this.btk) {
                                    this.btk = false;
                                    c.btH.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.bts = true;
                                    c.btH.notifyAll();
                                }
                                if (Sz()) {
                                    if (!this.btl) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.btH.b(this)) {
                                            try {
                                                this.btP.start();
                                                this.btl = true;
                                                z15 = true;
                                                c.btH.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.btH.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.btl || this.btm) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.btm = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.btm) {
                                        if (this.btu) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.btu = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.btr = false;
                                        c.btH.notifyAll();
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
                                c.btH.wait();
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
                                remove = this.btt.remove(0);
                            }
                        }
                        synchronized (c.btH) {
                            Sv();
                            Sw();
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
                        } else if (this.btP.Sq()) {
                            synchronized (c.btH) {
                                this.bto = true;
                                c.btH.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.btH) {
                                this.bto = true;
                                this.btj = true;
                                c.btH.notifyAll();
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
                            GL10 gl103 = (GL10) this.btP.Sr();
                            c.btH.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.btO.get();
                            if (cVar2 != null) {
                                cVar2.bsO.onSurfaceCreated(gl10, this.btP.btc);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            c cVar3 = this.btO.get();
                            if (cVar3 != null) {
                                cVar3.bsO.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        c cVar4 = this.btO.get();
                        if (cVar4 != null) {
                            cVar4.bsO.onDrawFrame(gl10);
                        }
                        int Ss = this.btP.Ss();
                        switch (Ss) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Ss);
                                synchronized (c.btH) {
                                    this.btj = true;
                                    c.btH.notifyAll();
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
                    synchronized (c.btH) {
                        Sv();
                        Sw();
                        throw th;
                    }
                }
            }
        }

        public boolean Sy() {
            return this.btl && this.btm && Sz();
        }

        private boolean Sz() {
            return !this.bth && this.bti && !this.btj && this.mWidth > 0 && this.mHeight > 0 && (this.btr || this.btq == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (c.btH) {
                this.btq = i;
                c.btH.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (c.btH) {
                i = this.btq;
            }
            return i;
        }

        public void SA() {
            synchronized (c.btH) {
                this.bti = true;
                this.bto = false;
                c.btH.notifyAll();
                while (this.btk && !this.bto && !this.btf) {
                    try {
                        c.btH.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.btH) {
                this.bti = false;
                c.btH.notifyAll();
                while (!this.btk && !this.btf) {
                    try {
                        c.btH.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (c.btH) {
                this.btg = true;
                c.btH.notifyAll();
                while (!this.btf && !this.bth) {
                    try {
                        c.btH.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (c.btH) {
                this.btg = false;
                this.btr = true;
                this.bts = false;
                c.btH.notifyAll();
                while (!this.btf && this.bth && !this.bts) {
                    try {
                        c.btH.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void X(int i, int i2) {
            synchronized (c.btH) {
                this.mWidth = i;
                this.mHeight = i2;
                this.btu = true;
                this.btr = true;
                this.bts = false;
                c.btH.notifyAll();
                while (!this.btf && !this.bth && !this.bts && Sy()) {
                    try {
                        c.btH.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void SB() {
            synchronized (c.btH) {
                this.bte = true;
                c.btH.notifyAll();
                while (!this.btf) {
                    try {
                        c.btH.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void SC() {
            this.btp = true;
            c.btH.notifyAll();
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

    private void So() {
        if (this.btI != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean btA;
        private i btQ;
        private boolean btw;
        private int btx;
        private boolean bty;
        private boolean btz;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.btf = true;
            if (this.btQ == iVar) {
                this.btQ = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.btQ == iVar || this.btQ == null) {
                this.btQ = iVar;
                notifyAll();
                return true;
            }
            SF();
            if (this.btz) {
                return true;
            }
            if (this.btQ != null) {
                this.btQ.SC();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.btQ == iVar) {
                this.btQ = null;
            }
            notifyAll();
        }

        public synchronized boolean SD() {
            return this.btA;
        }

        public synchronized boolean SE() {
            SF();
            return !this.btz;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bty) {
                    SF();
                    String glGetString = gl10.glGetString(7937);
                    if (this.btx < 131072) {
                        this.btz = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.btA = this.btz ? false : true;
                    this.bty = true;
                }
            }
        }

        private void SF() {
            if (!this.btw) {
                this.btz = true;
                this.btw = true;
            }
        }
    }
}
