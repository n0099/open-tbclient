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
    private static final j bIP = new j();
    private final WeakReference<c> bHV;
    private m bHX;
    private i bIQ;
    private e bIR;
    private f bIS;
    private g bIT;
    private k bIU;
    private int bIc;
    private int bId;
    private boolean bIe;
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
            if (this.bIQ != null) {
                this.bIQ.Xd();
            }
        } finally {
            super.finalize();
        }
    }

    public void setGLWrapper(k kVar) {
        this.bIU = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bIc = i2;
    }

    public int getDebugFlags() {
        return this.bIc;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bIe = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bIe;
    }

    public void setRenderer(m mVar) {
        WQ();
        if (this.bIR == null) {
            this.bIR = new n(true);
        }
        if (this.bIS == null) {
            this.bIS = new C0077c();
        }
        if (this.bIT == null) {
            this.bIT = new d();
        }
        this.bHX = mVar;
        this.bIQ = new i(this.bHV);
        this.bIQ.start();
    }

    public void setEGLContextFactory(f fVar) {
        WQ();
        this.bIS = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        WQ();
        this.bIT = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        WQ();
        this.bIR = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        WQ();
        this.bId = i2;
    }

    public void setRenderMode(int i2) {
        this.bIQ.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bIQ.getRenderMode();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.bIQ.Xc();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.bIQ.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.bIQ.ag(i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bHX != null) {
            int renderMode = this.bIQ != null ? this.bIQ.getRenderMode() : 1;
            this.bIQ = new i(this.bHV);
            if (renderMode != 1) {
                this.bIQ.setRenderMode(renderMode);
            }
            this.bIQ.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.bIQ != null) {
            this.bIQ.Xd();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, c.this.bId, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (c.this.bId == 0) {
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
        protected int[] bIf;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.bIf = f(iArr);
        }

        @Override // com.baidu.tieba.b.d.c.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bIf, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bIf, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] f(int[] iArr) {
            if (c.this.bId == 2) {
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
        private WeakReference<c> bIW;
        EGL10 bIi;
        EGLDisplay bIj;
        EGLSurface bIk;
        EGLConfig bIl;
        EGLContext bIm;

        public h(WeakReference<c> weakReference) {
            this.bIW = weakReference;
        }

        public void start() {
            this.bIi = (EGL10) EGLContext.getEGL();
            this.bIj = this.bIi.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bIj == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bIi.eglInitialize(this.bIj, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            c cVar = this.bIW.get();
            if (cVar != null) {
                this.bIl = cVar.bIR.chooseConfig(this.bIi, this.bIj);
                this.bIm = cVar.bIS.createContext(this.bIi, this.bIj, this.bIl);
            } else {
                this.bIl = null;
                this.bIm = null;
            }
            if (this.bIm == null || this.bIm == EGL10.EGL_NO_CONTEXT) {
                this.bIm = null;
                jg("createContext");
            }
            this.bIk = null;
        }

        public boolean WS() {
            if (this.bIi == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bIj == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bIl == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            WW();
            c cVar = this.bIW.get();
            if (cVar != null) {
                this.bIk = cVar.bIT.createWindowSurface(this.bIi, this.bIj, this.bIl, cVar.getHolder());
            } else {
                this.bIk = null;
            }
            if (this.bIk == null || this.bIk == EGL10.EGL_NO_SURFACE) {
                if (this.bIi.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bIi.eglMakeCurrent(this.bIj, this.bIk, this.bIk, this.bIm)) {
                f("EGLHelper", "eglMakeCurrent", this.bIi.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL WT() {
            l lVar;
            GL gl = this.bIm.getGL();
            c cVar = this.bIW.get();
            if (cVar != null) {
                if (cVar.bIU != null) {
                    gl = cVar.bIU.wrap(gl);
                }
                if ((cVar.bIc & 3) != 0) {
                    int i = 0;
                    if ((cVar.bIc & 1) != 0) {
                        i = 1;
                    }
                    if ((cVar.bIc & 2) == 0) {
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

        public int WU() {
            if (this.bIi.eglSwapBuffers(this.bIj, this.bIk)) {
                return 12288;
            }
            return this.bIi.eglGetError();
        }

        public void WV() {
            WW();
        }

        private void WW() {
            if (this.bIk != null && this.bIk != EGL10.EGL_NO_SURFACE) {
                this.bIi.eglMakeCurrent(this.bIj, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c cVar = this.bIW.get();
                if (cVar != null) {
                    cVar.bIT.destroySurface(this.bIi, this.bIj, this.bIk);
                }
                this.bIk = null;
            }
        }

        public void finish() {
            if (this.bIm != null) {
                c cVar = this.bIW.get();
                if (cVar != null) {
                    cVar.bIS.destroyContext(this.bIi, this.bIj, this.bIm);
                }
                this.bIm = null;
            }
            if (this.bIj != null) {
                this.bIi.eglTerminate(this.bIj);
                this.bIj = null;
            }
        }

        private void jg(String str) {
            G(str, this.bIi.eglGetError());
        }

        public static void G(String str, int i) {
            throw new RuntimeException(H(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, H(str2, i));
        }

        public static String H(String str, int i) {
            return str + " failed: " + com.baidu.tieba.b.d.b.hN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean bIA;
        private WeakReference<c> bIW;
        private h bIX;
        private boolean bIn;
        private boolean bIo;
        private boolean bIp;
        private boolean bIq;
        private boolean bIr;
        private boolean bIs;
        private boolean bIt;
        private boolean bIu;
        private boolean bIv;
        private boolean bIw;
        private boolean bIx;
        private ArrayList<Runnable> bIB = new ArrayList<>();
        private boolean bIC = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bIz = true;
        private int bIy = 1;

        i(WeakReference<c> weakReference) {
            this.bIW = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    WZ();
                    c.bIP.a(this);
                } catch (Exception e) {
                    af.vb().aC(false);
                    c.bIP.a(this);
                }
            } catch (Throwable th) {
                c.bIP.a(this);
                throw th;
            }
        }

        private void WX() {
            if (this.bIv) {
                this.bIv = false;
                this.bIX.WV();
            }
        }

        private void WY() {
            if (this.bIu) {
                this.bIX.finish();
                this.bIu = false;
                c.bIP.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1399=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void WZ() throws InterruptedException {
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
            this.bIX = new h(this.bIW);
            this.bIu = false;
            this.bIv = false;
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
                    synchronized (c.bIP) {
                        while (!this.bIn) {
                            if (this.bIB.isEmpty()) {
                                if (this.bIq != this.bIp) {
                                    boolean z23 = this.bIp;
                                    this.bIq = this.bIp;
                                    c.bIP.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bIx) {
                                    WX();
                                    WY();
                                    this.bIx = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    WX();
                                    WY();
                                    z19 = false;
                                }
                                if (z9 && this.bIv) {
                                    WX();
                                }
                                if (z9 && this.bIu) {
                                    c cVar = this.bIW.get();
                                    if (!(cVar == null ? false : cVar.bIe) || c.bIP.Xf()) {
                                        WY();
                                    }
                                }
                                if (z9 && c.bIP.Xg()) {
                                    this.bIX.finish();
                                }
                                if (!this.bIr && !this.bIt) {
                                    if (this.bIv) {
                                        WX();
                                    }
                                    this.bIt = true;
                                    this.bIs = false;
                                    c.bIP.notifyAll();
                                }
                                if (this.bIr && this.bIt) {
                                    this.bIt = false;
                                    c.bIP.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bIA = true;
                                    c.bIP.notifyAll();
                                }
                                if (Xb()) {
                                    if (!this.bIu) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (c.bIP.b(this)) {
                                            try {
                                                this.bIX.start();
                                                this.bIu = true;
                                                z15 = true;
                                                c.bIP.notifyAll();
                                            } catch (RuntimeException e) {
                                                c.bIP.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bIu || this.bIv) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bIv = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bIv) {
                                        if (this.bIC) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bIC = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bIz = false;
                                        c.bIP.notifyAll();
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
                                c.bIP.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bIB.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (c.bIP) {
                            WX();
                            WY();
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
                        } else if (this.bIX.WS()) {
                            synchronized (c.bIP) {
                                this.bIw = true;
                                c.bIP.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (c.bIP) {
                                this.bIw = true;
                                this.bIs = true;
                                c.bIP.notifyAll();
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
                            GL10 gl103 = (GL10) this.bIX.WT();
                            c.bIP.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            c cVar2 = this.bIW.get();
                            if (cVar2 != null) {
                                cVar2.bHX.onSurfaceCreated(gl10, this.bIX.bIl);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            c cVar3 = this.bIW.get();
                            if (cVar3 != null) {
                                cVar3.bHX.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        c cVar4 = this.bIW.get();
                        if (cVar4 != null) {
                            cVar4.bHX.onDrawFrame(gl10);
                        }
                        int WU = this.bIX.WU();
                        switch (WU) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", WU);
                                synchronized (c.bIP) {
                                    this.bIs = true;
                                    c.bIP.notifyAll();
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
                    synchronized (c.bIP) {
                        WX();
                        WY();
                        throw th;
                    }
                }
            }
        }

        public boolean Xa() {
            return this.bIu && this.bIv && Xb();
        }

        private boolean Xb() {
            return !this.bIq && this.bIr && !this.bIs && this.mWidth > 0 && this.mHeight > 0 && (this.bIz || this.bIy == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (c.bIP) {
                    this.bIy = i;
                    c.bIP.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (c.bIP) {
                i = this.bIy;
            }
            return i;
        }

        public void Xc() {
            synchronized (c.bIP) {
                this.bIr = true;
                this.bIw = false;
                c.bIP.notifyAll();
                while (this.bIt && !this.bIw && !this.bIo) {
                    try {
                        c.bIP.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (c.bIP) {
                this.bIr = false;
                c.bIP.notifyAll();
                while (!this.bIt && !this.bIo) {
                    try {
                        c.bIP.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ag(int i, int i2) {
            synchronized (c.bIP) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bIC = true;
                this.bIz = true;
                this.bIA = false;
                c.bIP.notifyAll();
                while (!this.bIo && !this.bIq && !this.bIA && Xa()) {
                    try {
                        c.bIP.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Xd() {
            synchronized (c.bIP) {
                this.bIn = true;
                c.bIP.notifyAll();
                while (!this.bIo) {
                    try {
                        c.bIP.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Xe() {
            this.bIx = true;
            c.bIP.notifyAll();
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

    private void WQ() {
        if (this.bIQ != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bIE;
        private int bIF;
        private boolean bIG;
        private boolean bIH;
        private boolean bII;
        private i bIY;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bIo = true;
            if (this.bIY == iVar) {
                this.bIY = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bIY == iVar || this.bIY == null) {
                this.bIY = iVar;
                notifyAll();
                return true;
            }
            Xh();
            if (this.bIH) {
                return true;
            }
            if (this.bIY != null) {
                this.bIY.Xe();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bIY == iVar) {
                this.bIY = null;
            }
            notifyAll();
        }

        public synchronized boolean Xf() {
            return this.bII;
        }

        public synchronized boolean Xg() {
            Xh();
            return !this.bIH;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bIG) {
                    Xh();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bIF < 131072) {
                        this.bIH = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bII = this.bIH ? false : true;
                    this.bIG = true;
                }
            }
        }

        private void Xh() {
            if (!this.bIE) {
                this.bIH = true;
                this.bIE = true;
            }
        }
    }
}
