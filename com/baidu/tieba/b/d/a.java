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
    private static final j bPB = new j();
    private final WeakReference<a> bPC;
    private i bPD;
    private c.m bPE;
    private e bPF;
    private f bPG;
    private g bPH;
    private k bPI;
    private int bPJ;
    private int bPK;
    private boolean bPL;
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
        this.bPC = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bPD != null) {
                this.bPD.Zv();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bPI = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bPJ = i2;
    }

    public int getDebugFlags() {
        return this.bPJ;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bPL = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bPL;
    }

    public void setRenderer(c.m mVar) {
        Zi();
        if (this.bPF == null) {
            this.bPF = new m(true);
        }
        if (this.bPG == null) {
            this.bPG = new c();
        }
        if (this.bPH == null) {
            this.bPH = new d();
        }
        this.bPE = mVar;
        this.bPD = new i(this.bPC);
        this.bPD.start();
    }

    public void setEGLContextFactory(f fVar) {
        Zi();
        this.bPG = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Zi();
        this.bPH = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Zi();
        this.bPF = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Zi();
        this.bPK = i2;
    }

    public void setRenderMode(int i2) {
        this.bPD.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bPD.getRenderMode();
    }

    public void requestRender() {
        this.bPD.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bPD.Zu();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bPD.ak(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bPD.ak(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bPD.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bPD.onPause();
    }

    public void onResume() {
        this.bPD.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bPE != null) {
            int renderMode = this.bPD != null ? this.bPD.getRenderMode() : 1;
            this.bPD = new i(this.bPC);
            if (renderMode != 1) {
                this.bPD.setRenderMode(renderMode);
            }
            this.bPD.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bPD != null) {
            this.bPD.Zv();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bPK, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bPK == 0) {
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
        protected int[] bPM;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0076a(int[] iArr) {
            this.bPM = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bPM, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bPM, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (a.this.bPK == 2) {
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
        private WeakReference<a> bPO;
        EGL10 bPP;
        EGLDisplay bPQ;
        EGLSurface bPR;
        EGLConfig bPS;
        EGLContext bPT;

        public h(WeakReference<a> weakReference) {
            this.bPO = weakReference;
        }

        public void start() {
            this.bPP = (EGL10) EGLContext.getEGL();
            this.bPQ = this.bPP.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bPQ == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bPP.eglInitialize(this.bPQ, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bPO.get();
            if (aVar != null) {
                this.bPS = aVar.bPF.chooseConfig(this.bPP, this.bPQ);
                try {
                    this.bPT = aVar.bPG.createContext(this.bPP, this.bPQ, this.bPS);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bPS = null;
                this.bPT = null;
            }
            if (this.bPT == null || this.bPT == EGL10.EGL_NO_CONTEXT) {
                this.bPT = null;
                jF("createContext");
            }
            this.bPR = null;
        }

        public boolean Zk() {
            if (this.bPP == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bPQ == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bPS == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Zo();
            a aVar = this.bPO.get();
            if (aVar != null) {
                this.bPR = aVar.bPH.createWindowSurface(this.bPP, this.bPQ, this.bPS, aVar.getSurfaceTexture());
            } else {
                this.bPR = null;
            }
            if (this.bPR == null || this.bPR == EGL10.EGL_NO_SURFACE) {
                if (this.bPP.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bPP.eglMakeCurrent(this.bPQ, this.bPR, this.bPR, this.bPT)) {
                f("EGLHelper", "eglMakeCurrent", this.bPP.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Zl() {
            l lVar;
            GL gl = this.bPT.getGL();
            a aVar = this.bPO.get();
            if (aVar != null) {
                if (aVar.bPI != null) {
                    gl = aVar.bPI.wrap(gl);
                }
                if ((aVar.bPJ & 3) != 0) {
                    int i = 0;
                    if ((aVar.bPJ & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bPJ & 2) == 0) {
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

        public int Zm() {
            if (this.bPP.eglSwapBuffers(this.bPQ, this.bPR)) {
                return 12288;
            }
            return this.bPP.eglGetError();
        }

        public void Zn() {
            Zo();
        }

        private void Zo() {
            if (this.bPR != null && this.bPR != EGL10.EGL_NO_SURFACE) {
                this.bPP.eglMakeCurrent(this.bPQ, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bPO.get();
                if (aVar != null) {
                    aVar.bPH.destroySurface(this.bPP, this.bPQ, this.bPR);
                }
                this.bPR = null;
            }
        }

        public void finish() {
            if (this.bPT != null) {
                a aVar = this.bPO.get();
                if (aVar != null) {
                    try {
                        aVar.bPG.destroyContext(this.bPP, this.bPQ, this.bPT);
                    } catch (Exception e) {
                    }
                }
                this.bPT = null;
            }
            if (this.bPQ != null) {
                this.bPP.eglTerminate(this.bPQ);
                this.bPQ = null;
            }
        }

        private void jF(String str) {
            M(str, this.bPP.eglGetError());
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
        private WeakReference<a> bPO;
        private boolean bPU;
        private boolean bPV;
        private boolean bPW;
        private boolean bPX;
        private boolean bPY;
        private boolean bPZ;
        private boolean bQa;
        private boolean bQb;
        private boolean bQc;
        private boolean bQd;
        private boolean bQe;
        private boolean bQh;
        private h bQk;
        private ArrayList<Runnable> bQi = new ArrayList<>();
        private boolean bQj = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bQg = true;
        private int bQf = 1;

        i(WeakReference<a> weakReference) {
            this.bPO = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Zr();
                    a.bPB.a(this);
                } catch (Exception e) {
                    af.vb().az(false);
                    a.bPB.a(this);
                }
            } catch (Throwable th) {
                a.bPB.a(this);
                throw th;
            }
        }

        private void Zp() {
            if (this.bQc) {
                this.bQc = false;
                this.bQk.Zn();
            }
        }

        private void Zq() {
            if (this.bQb) {
                this.bQk.finish();
                this.bQb = false;
                a.bPB.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Zr() throws InterruptedException {
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
            this.bQk = new h(this.bPO);
            this.bQb = false;
            this.bQc = false;
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
                    synchronized (a.bPB) {
                        while (!this.bPU) {
                            if (this.bQi.isEmpty()) {
                                if (this.bPX != this.bPW) {
                                    boolean z23 = this.bPW;
                                    this.bPX = this.bPW;
                                    a.bPB.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bQe) {
                                    Zp();
                                    Zq();
                                    this.bQe = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    Zp();
                                    Zq();
                                    z19 = false;
                                }
                                if (z9 && this.bQc) {
                                    Zp();
                                }
                                if (z9 && this.bQb) {
                                    a aVar = this.bPO.get();
                                    if (!(aVar == null ? false : aVar.bPL) || a.bPB.Zx()) {
                                        Zq();
                                    }
                                }
                                if (z9 && a.bPB.Zy()) {
                                    this.bQk.finish();
                                }
                                if (!this.bPY && !this.bQa) {
                                    if (this.bQc) {
                                        Zp();
                                    }
                                    this.bQa = true;
                                    this.bPZ = false;
                                    a.bPB.notifyAll();
                                }
                                if (this.bPY && this.bQa) {
                                    this.bQa = false;
                                    a.bPB.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bQh = true;
                                    a.bPB.notifyAll();
                                }
                                if (Zt()) {
                                    if (!this.bQb) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bPB.b(this)) {
                                            try {
                                                this.bQk.start();
                                                this.bQb = true;
                                                z15 = true;
                                                a.bPB.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bPB.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bQb || this.bQc) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bQc = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bQc) {
                                        if (this.bQj) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bQj = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bQg = false;
                                        a.bPB.notifyAll();
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
                                a.bPB.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bQi.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bPB) {
                            Zp();
                            Zq();
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
                        } else if (this.bQk.Zk()) {
                            synchronized (a.bPB) {
                                this.bQd = true;
                                a.bPB.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bPB) {
                                this.bQd = true;
                                this.bPZ = true;
                                a.bPB.notifyAll();
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
                            GL10 gl103 = (GL10) this.bQk.Zl();
                            a.bPB.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bPO.get();
                            if (aVar2 != null) {
                                aVar2.bPE.onSurfaceCreated(gl10, this.bQk.bPS);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bPO.get();
                            if (aVar3 != null) {
                                aVar3.bPE.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bPO.get();
                        if (aVar4 != null) {
                            aVar4.bPE.onDrawFrame(gl10);
                        }
                        int Zm = this.bQk.Zm();
                        switch (Zm) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Zm);
                                synchronized (a.bPB) {
                                    this.bPZ = true;
                                    a.bPB.notifyAll();
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
                    synchronized (a.bPB) {
                        Zp();
                        Zq();
                        throw th;
                    }
                }
            }
        }

        public boolean Zs() {
            return this.bQb && this.bQc && Zt();
        }

        private boolean Zt() {
            return !this.bPX && this.bPY && !this.bPZ && this.mWidth > 0 && this.mHeight > 0 && (this.bQg || this.bQf == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bPB) {
                    this.bQf = i;
                    a.bPB.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bPB) {
                i = this.bQf;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bPB) {
                this.bQg = true;
                a.bPB.notifyAll();
            }
        }

        public void Zu() {
            synchronized (a.bPB) {
                this.bPY = true;
                this.bQd = false;
                a.bPB.notifyAll();
                while (this.bQa && !this.bQd && !this.bPV) {
                    try {
                        a.bPB.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bPB) {
                this.bPY = false;
                a.bPB.notifyAll();
                while (!this.bQa && !this.bPV) {
                    try {
                        a.bPB.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bPB) {
                this.bPW = true;
                a.bPB.notifyAll();
                while (!this.bPV && !this.bPX) {
                    try {
                        a.bPB.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bPB) {
                this.bPW = false;
                this.bQg = true;
                this.bQh = false;
                a.bPB.notifyAll();
                while (!this.bPV && this.bPX && !this.bQh) {
                    try {
                        a.bPB.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (a.bPB) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bQj = true;
                this.bQg = true;
                this.bQh = false;
                a.bPB.notifyAll();
                while (!this.bPV && !this.bPX && !this.bQh && Zs()) {
                    try {
                        a.bPB.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Zv() {
            synchronized (a.bPB) {
                this.bPU = true;
                a.bPB.notifyAll();
                while (!this.bPV) {
                    try {
                        a.bPB.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Zw() {
            this.bQe = true;
            a.bPB.notifyAll();
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

    private void Zi() {
        if (this.bPD != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bQl;
        private int bQm;
        private boolean bQn;
        private boolean bQo;
        private boolean bQp;
        private i bQq;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bPV = true;
            if (this.bQq == iVar) {
                this.bQq = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bQq == iVar || this.bQq == null) {
                this.bQq = iVar;
                notifyAll();
                return true;
            }
            Zz();
            if (this.bQo) {
                return true;
            }
            if (this.bQq != null) {
                this.bQq.Zw();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bQq == iVar) {
                this.bQq = null;
            }
            notifyAll();
        }

        public synchronized boolean Zx() {
            return this.bQp;
        }

        public synchronized boolean Zy() {
            Zz();
            return !this.bQo;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bQn) {
                    Zz();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bQm < 131072) {
                        this.bQo = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bQp = this.bQo ? false : true;
                    this.bQn = true;
                }
            }
        }

        private void Zz() {
            if (!this.bQl) {
                this.bQo = true;
                this.bQl = true;
            }
        }
    }
}
