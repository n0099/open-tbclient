package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.b.d.c;
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
public class a extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j bPo = new j();
    private final WeakReference<a> bPp;
    private i bPq;
    private c.m bPr;
    private e bPs;
    private f bPt;
    private g bPu;
    private k bPv;
    private int bPw;
    private int bPx;
    private boolean bPy;
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

    public a(Context context) {
        super(context);
        this.bPp = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bPq != null) {
                this.bPq.Zj();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bPv = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bPw = i2;
    }

    public int getDebugFlags() {
        return this.bPw;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bPy = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bPy;
    }

    public void setRenderer(c.m mVar) {
        YW();
        if (this.bPs == null) {
            this.bPs = new m(true);
        }
        if (this.bPt == null) {
            this.bPt = new c();
        }
        if (this.bPu == null) {
            this.bPu = new d();
        }
        this.bPr = mVar;
        this.bPq = new i(this.bPp);
        this.bPq.start();
    }

    public void setEGLContextFactory(f fVar) {
        YW();
        this.bPt = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        YW();
        this.bPu = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        YW();
        this.bPs = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        YW();
        this.bPx = i2;
    }

    public void setRenderMode(int i2) {
        this.bPq.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bPq.getRenderMode();
    }

    public void requestRender() {
        this.bPq.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bPq.Zi();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bPq.ak(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bPq.ak(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bPq.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bPq.onPause();
    }

    public void onResume() {
        this.bPq.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bPr != null) {
            int renderMode = this.bPq != null ? this.bPq.getRenderMode() : 1;
            this.bPq = new i(this.bPp);
            if (renderMode != 1) {
                this.bPq.setRenderMode(renderMode);
            }
            this.bPq.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bPq != null) {
            this.bPq.Zj();
        }
        this.mDetached = true;
        try {
            super.onDetachedFromWindow();
        } catch (Exception e2) {
        }
    }

    /* loaded from: classes.dex */
    private class c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.baidu.tieba.b.d.a.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bPx, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bPx == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.M("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements g {
        private d() {
        }

        @Override // com.baidu.tieba.b.d.a.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.b.d.a.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: com.baidu.tieba.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private abstract class AbstractC0076a implements e {
        protected int[] bPz;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0076a(int[] iArr) {
            this.bPz = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bPz, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bPz, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (a.this.bPx == 2) {
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
    private class b extends AbstractC0076a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0076a
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
    private class m extends b {
        public m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h {
        private WeakReference<a> bPB;
        EGL10 bPC;
        EGLDisplay bPD;
        EGLSurface bPE;
        EGLConfig bPF;
        EGLContext bPG;

        public h(WeakReference<a> weakReference) {
            this.bPB = weakReference;
        }

        public void start() {
            this.bPC = (EGL10) EGLContext.getEGL();
            this.bPD = this.bPC.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bPD == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bPC.eglInitialize(this.bPD, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bPB.get();
            if (aVar != null) {
                this.bPF = aVar.bPs.chooseConfig(this.bPC, this.bPD);
                try {
                    this.bPG = aVar.bPt.createContext(this.bPC, this.bPD, this.bPF);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bPF = null;
                this.bPG = null;
            }
            if (this.bPG == null || this.bPG == EGL10.EGL_NO_CONTEXT) {
                this.bPG = null;
                jE("createContext");
            }
            this.bPE = null;
        }

        public boolean YY() {
            if (this.bPC == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bPD == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bPF == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Zc();
            a aVar = this.bPB.get();
            if (aVar != null) {
                this.bPE = aVar.bPu.createWindowSurface(this.bPC, this.bPD, this.bPF, aVar.getSurfaceTexture());
            } else {
                this.bPE = null;
            }
            if (this.bPE == null || this.bPE == EGL10.EGL_NO_SURFACE) {
                if (this.bPC.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bPC.eglMakeCurrent(this.bPD, this.bPE, this.bPE, this.bPG)) {
                f("EGLHelper", "eglMakeCurrent", this.bPC.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL YZ() {
            l lVar;
            GL gl = this.bPG.getGL();
            a aVar = this.bPB.get();
            if (aVar != null) {
                if (aVar.bPv != null) {
                    gl = aVar.bPv.wrap(gl);
                }
                if ((aVar.bPw & 3) != 0) {
                    int i = 0;
                    if ((aVar.bPw & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bPw & 2) == 0) {
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

        public int Za() {
            if (this.bPC.eglSwapBuffers(this.bPD, this.bPE)) {
                return 12288;
            }
            return this.bPC.eglGetError();
        }

        public void Zb() {
            Zc();
        }

        private void Zc() {
            if (this.bPE != null && this.bPE != EGL10.EGL_NO_SURFACE) {
                this.bPC.eglMakeCurrent(this.bPD, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bPB.get();
                if (aVar != null) {
                    aVar.bPu.destroySurface(this.bPC, this.bPD, this.bPE);
                }
                this.bPE = null;
            }
        }

        public void finish() {
            if (this.bPG != null) {
                a aVar = this.bPB.get();
                if (aVar != null) {
                    try {
                        aVar.bPt.destroyContext(this.bPC, this.bPD, this.bPG);
                    } catch (Exception e) {
                    }
                }
                this.bPG = null;
            }
            if (this.bPD != null) {
                this.bPC.eglTerminate(this.bPD);
                this.bPD = null;
            }
        }

        private void jE(String str) {
            M(str, this.bPC.eglGetError());
        }

        public static void M(String str, int i) {
            throw new RuntimeException(N(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, N(str2, i));
        }

        public static String N(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> bPB;
        private boolean bPH;
        private boolean bPI;
        private boolean bPJ;
        private boolean bPK;
        private boolean bPL;
        private boolean bPM;
        private boolean bPN;
        private boolean bPO;
        private boolean bPP;
        private boolean bPQ;
        private boolean bPR;
        private boolean bPU;
        private h bPX;
        private ArrayList<Runnable> bPV = new ArrayList<>();
        private boolean bPW = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bPT = true;
        private int bPS = 1;

        i(WeakReference<a> weakReference) {
            this.bPB = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Zf();
                    a.bPo.a(this);
                } catch (Exception e) {
                    af.vb().az(false);
                    a.bPo.a(this);
                }
            } catch (Throwable th) {
                a.bPo.a(this);
                throw th;
            }
        }

        private void Zd() {
            if (this.bPP) {
                this.bPP = false;
                this.bPX.Zb();
            }
        }

        private void Ze() {
            if (this.bPO) {
                this.bPX.finish();
                this.bPO = false;
                a.bPo.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Zf() throws InterruptedException {
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
            this.bPX = new h(this.bPB);
            this.bPO = false;
            this.bPP = false;
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
                    sleep(4L);
                    synchronized (a.bPo) {
                        while (!this.bPH) {
                            if (this.bPV.isEmpty()) {
                                if (this.bPK != this.bPJ) {
                                    boolean z23 = this.bPJ;
                                    this.bPK = this.bPJ;
                                    a.bPo.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bPR) {
                                    Zd();
                                    Ze();
                                    this.bPR = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    Zd();
                                    Ze();
                                    z19 = false;
                                }
                                if (z9 && this.bPP) {
                                    Zd();
                                }
                                if (z9 && this.bPO) {
                                    a aVar = this.bPB.get();
                                    if (!(aVar == null ? false : aVar.bPy) || a.bPo.Zl()) {
                                        Ze();
                                    }
                                }
                                if (z9 && a.bPo.Zm()) {
                                    this.bPX.finish();
                                }
                                if (!this.bPL && !this.bPN) {
                                    if (this.bPP) {
                                        Zd();
                                    }
                                    this.bPN = true;
                                    this.bPM = false;
                                    a.bPo.notifyAll();
                                }
                                if (this.bPL && this.bPN) {
                                    this.bPN = false;
                                    a.bPo.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bPU = true;
                                    a.bPo.notifyAll();
                                }
                                if (Zh()) {
                                    if (!this.bPO) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bPo.b(this)) {
                                            try {
                                                this.bPX.start();
                                                this.bPO = true;
                                                z15 = true;
                                                a.bPo.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bPo.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bPO || this.bPP) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bPP = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bPP) {
                                        if (this.bPW) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bPW = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bPT = false;
                                        a.bPo.notifyAll();
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
                                a.bPo.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bPV.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bPo) {
                            Zd();
                            Ze();
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
                        } else if (this.bPX.YY()) {
                            synchronized (a.bPo) {
                                this.bPQ = true;
                                a.bPo.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bPo) {
                                this.bPQ = true;
                                this.bPM = true;
                                a.bPo.notifyAll();
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
                            GL10 gl103 = (GL10) this.bPX.YZ();
                            a.bPo.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bPB.get();
                            if (aVar2 != null) {
                                aVar2.bPr.onSurfaceCreated(gl10, this.bPX.bPF);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bPB.get();
                            if (aVar3 != null) {
                                aVar3.bPr.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bPB.get();
                        if (aVar4 != null) {
                            aVar4.bPr.onDrawFrame(gl10);
                        }
                        int Za = this.bPX.Za();
                        switch (Za) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Za);
                                synchronized (a.bPo) {
                                    this.bPM = true;
                                    a.bPo.notifyAll();
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
                    synchronized (a.bPo) {
                        Zd();
                        Ze();
                        throw th;
                    }
                }
            }
        }

        public boolean Zg() {
            return this.bPO && this.bPP && Zh();
        }

        private boolean Zh() {
            return !this.bPK && this.bPL && !this.bPM && this.mWidth > 0 && this.mHeight > 0 && (this.bPT || this.bPS == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bPo) {
                    this.bPS = i;
                    a.bPo.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bPo) {
                i = this.bPS;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bPo) {
                this.bPT = true;
                a.bPo.notifyAll();
            }
        }

        public void Zi() {
            synchronized (a.bPo) {
                this.bPL = true;
                this.bPQ = false;
                a.bPo.notifyAll();
                while (this.bPN && !this.bPQ && !this.bPI) {
                    try {
                        a.bPo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bPo) {
                this.bPL = false;
                a.bPo.notifyAll();
                while (!this.bPN && !this.bPI) {
                    try {
                        a.bPo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bPo) {
                this.bPJ = true;
                a.bPo.notifyAll();
                while (!this.bPI && !this.bPK) {
                    try {
                        a.bPo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bPo) {
                this.bPJ = false;
                this.bPT = true;
                this.bPU = false;
                a.bPo.notifyAll();
                while (!this.bPI && this.bPK && !this.bPU) {
                    try {
                        a.bPo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (a.bPo) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bPW = true;
                this.bPT = true;
                this.bPU = false;
                a.bPo.notifyAll();
                while (!this.bPI && !this.bPK && !this.bPU && Zg()) {
                    try {
                        a.bPo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Zj() {
            synchronized (a.bPo) {
                this.bPH = true;
                a.bPo.notifyAll();
                while (!this.bPI) {
                    try {
                        a.bPo.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Zk() {
            this.bPR = true;
            a.bPo.notifyAll();
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

    private void YW() {
        if (this.bPq != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bPY;
        private int bPZ;
        private boolean bQa;
        private boolean bQb;
        private boolean bQc;
        private i bQd;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bPI = true;
            if (this.bQd == iVar) {
                this.bQd = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bQd == iVar || this.bQd == null) {
                this.bQd = iVar;
                notifyAll();
                return true;
            }
            Zn();
            if (this.bQb) {
                return true;
            }
            if (this.bQd != null) {
                this.bQd.Zk();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bQd == iVar) {
                this.bQd = null;
            }
            notifyAll();
        }

        public synchronized boolean Zl() {
            return this.bQc;
        }

        public synchronized boolean Zm() {
            Zn();
            return !this.bQb;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bQa) {
                    Zn();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bPZ < 131072) {
                        this.bQb = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bQc = this.bQb ? false : true;
                    this.bQa = true;
                }
            }
        }

        private void Zn() {
            if (!this.bPY) {
                this.bQb = true;
                this.bPY = true;
            }
        }
    }
}
