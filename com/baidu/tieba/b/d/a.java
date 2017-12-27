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
    private static final j cMp = new j();
    private final WeakReference<a> cMq;
    private i cMr;
    private c.m cMs;
    private e cMt;
    private f cMu;
    private g cMv;
    private k cMw;
    private int cMx;
    private int cMy;
    private boolean cMz;
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
        this.cMq = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cMr != null) {
                this.cMr.aiL();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cMw = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cMx = i2;
    }

    public int getDebugFlags() {
        return this.cMx;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cMz = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cMz;
    }

    public void setRenderer(c.m mVar) {
        aiy();
        if (this.cMt == null) {
            this.cMt = new m(true);
        }
        if (this.cMu == null) {
            this.cMu = new c();
        }
        if (this.cMv == null) {
            this.cMv = new d();
        }
        this.cMs = mVar;
        this.cMr = new i(this.cMq);
        this.cMr.start();
    }

    public void setEGLContextFactory(f fVar) {
        aiy();
        this.cMu = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aiy();
        this.cMv = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aiy();
        this.cMt = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        aiy();
        this.cMy = i2;
    }

    public void setRenderMode(int i2) {
        this.cMr.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cMr.getRenderMode();
    }

    public void requestRender() {
        this.cMr.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cMr.aiK();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cMr.bj(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cMr.bj(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cMr.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cMr.onPause();
    }

    public void onResume() {
        this.cMr.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cMs != null) {
            int renderMode = this.cMr != null ? this.cMr.getRenderMode() : 1;
            this.cMr = new i(this.cMq);
            if (renderMode != 1) {
                this.cMr.setRenderMode(renderMode);
            }
            this.cMr.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cMr != null) {
            this.cMr.aiL();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.cMy, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.cMy == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.Q("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0103a implements e {
        protected int[] cMA;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0103a(int[] iArr) {
            this.cMA = o(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cMA, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cMA, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] o(int[] iArr) {
            if (a.this.cMy == 2) {
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
    private class b extends AbstractC0103a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0103a
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
        private WeakReference<a> cMC;
        EGL10 cMD;
        EGLDisplay cME;
        EGLSurface cMF;
        EGLConfig cMG;
        EGLContext cMH;

        public h(WeakReference<a> weakReference) {
            this.cMC = weakReference;
        }

        public void start() {
            this.cMD = (EGL10) EGLContext.getEGL();
            this.cME = this.cMD.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cME == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cMD.eglInitialize(this.cME, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.cMC.get();
            if (aVar != null) {
                this.cMG = aVar.cMt.chooseConfig(this.cMD, this.cME);
                try {
                    this.cMH = aVar.cMu.createContext(this.cMD, this.cME, this.cMG);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.cMG = null;
                this.cMH = null;
            }
            if (this.cMH == null || this.cMH == EGL10.EGL_NO_CONTEXT) {
                this.cMH = null;
                jN("createContext");
            }
            this.cMF = null;
        }

        public boolean aiA() {
            if (this.cMD == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cME == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cMG == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aiE();
            a aVar = this.cMC.get();
            if (aVar != null) {
                this.cMF = aVar.cMv.createWindowSurface(this.cMD, this.cME, this.cMG, aVar.getSurfaceTexture());
            } else {
                this.cMF = null;
            }
            if (this.cMF == null || this.cMF == EGL10.EGL_NO_SURFACE) {
                if (this.cMD.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cMD.eglMakeCurrent(this.cME, this.cMF, this.cMF, this.cMH)) {
                f("EGLHelper", "eglMakeCurrent", this.cMD.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aiB() {
            l lVar;
            GL gl = this.cMH.getGL();
            a aVar = this.cMC.get();
            if (aVar != null) {
                if (aVar.cMw != null) {
                    gl = aVar.cMw.wrap(gl);
                }
                if ((aVar.cMx & 3) != 0) {
                    int i = 0;
                    if ((aVar.cMx & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.cMx & 2) == 0) {
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

        public int aiC() {
            if (this.cMD.eglSwapBuffers(this.cME, this.cMF)) {
                return 12288;
            }
            return this.cMD.eglGetError();
        }

        public void aiD() {
            aiE();
        }

        private void aiE() {
            if (this.cMF != null && this.cMF != EGL10.EGL_NO_SURFACE) {
                this.cMD.eglMakeCurrent(this.cME, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.cMC.get();
                if (aVar != null) {
                    aVar.cMv.destroySurface(this.cMD, this.cME, this.cMF);
                }
                this.cMF = null;
            }
        }

        public void finish() {
            if (this.cMH != null) {
                a aVar = this.cMC.get();
                if (aVar != null) {
                    try {
                        aVar.cMu.destroyContext(this.cMD, this.cME, this.cMH);
                    } catch (Exception e) {
                    }
                }
                this.cMH = null;
            }
            if (this.cME != null) {
                this.cMD.eglTerminate(this.cME);
                this.cME = null;
            }
        }

        private void jN(String str) {
            Q(str, this.cMD.eglGetError());
        }

        public static void Q(String str, int i) {
            throw new RuntimeException(R(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, R(str2, i));
        }

        public static String R(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> cMC;
        private boolean cMI;
        private boolean cMJ;
        private boolean cMK;
        private boolean cML;
        private boolean cMM;
        private boolean cMN;
        private boolean cMO;
        private boolean cMP;
        private boolean cMQ;
        private boolean cMR;
        private boolean cMU;
        private h cMX;
        private boolean vv;
        private ArrayList<Runnable> cMV = new ArrayList<>();
        private boolean cMW = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cMT = true;
        private int cMS = 1;

        i(WeakReference<a> weakReference) {
            this.cMC = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aiH();
                    a.cMp.a(this);
                } catch (Exception e) {
                    af.CB().bh(false);
                    a.cMp.a(this);
                }
            } catch (Throwable th) {
                a.cMp.a(this);
                throw th;
            }
        }

        private void aiF() {
            if (this.cMP) {
                this.cMP = false;
                this.cMX.aiD();
            }
        }

        private void aiG() {
            if (this.cMO) {
                this.cMX.finish();
                this.cMO = false;
                a.cMp.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aiH() throws InterruptedException {
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
            this.cMX = new h(this.cMC);
            this.cMO = false;
            this.cMP = false;
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
                    synchronized (a.cMp) {
                        while (!this.cMI) {
                            if (this.cMV.isEmpty()) {
                                if (this.vv != this.cMK) {
                                    boolean z23 = this.cMK;
                                    this.vv = this.cMK;
                                    a.cMp.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cMR) {
                                    aiF();
                                    aiG();
                                    this.cMR = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aiF();
                                    aiG();
                                    z19 = false;
                                }
                                if (z9 && this.cMP) {
                                    aiF();
                                }
                                if (z9 && this.cMO) {
                                    a aVar = this.cMC.get();
                                    if (!(aVar == null ? false : aVar.cMz) || a.cMp.aiN()) {
                                        aiG();
                                    }
                                }
                                if (z9 && a.cMp.aiO()) {
                                    this.cMX.finish();
                                }
                                if (!this.cML && !this.cMN) {
                                    if (this.cMP) {
                                        aiF();
                                    }
                                    this.cMN = true;
                                    this.cMM = false;
                                    a.cMp.notifyAll();
                                }
                                if (this.cML && this.cMN) {
                                    this.cMN = false;
                                    a.cMp.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cMU = true;
                                    a.cMp.notifyAll();
                                }
                                if (aiJ()) {
                                    if (!this.cMO) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.cMp.b(this)) {
                                            try {
                                                this.cMX.start();
                                                this.cMO = true;
                                                z15 = true;
                                                a.cMp.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.cMp.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cMO || this.cMP) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cMP = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cMP) {
                                        if (this.cMW) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cMW = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cMT = false;
                                        a.cMp.notifyAll();
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
                                a.cMp.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cMV.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.cMp) {
                            aiF();
                            aiG();
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
                        } else if (this.cMX.aiA()) {
                            synchronized (a.cMp) {
                                this.cMQ = true;
                                a.cMp.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.cMp) {
                                this.cMQ = true;
                                this.cMM = true;
                                a.cMp.notifyAll();
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
                            GL10 gl103 = (GL10) this.cMX.aiB();
                            a.cMp.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.cMC.get();
                            if (aVar2 != null) {
                                aVar2.cMs.onSurfaceCreated(gl10, this.cMX.cMG);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.cMC.get();
                            if (aVar3 != null) {
                                aVar3.cMs.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.cMC.get();
                        if (aVar4 != null) {
                            aVar4.cMs.onDrawFrame(gl10);
                        }
                        int aiC = this.cMX.aiC();
                        switch (aiC) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", aiC);
                                synchronized (a.cMp) {
                                    this.cMM = true;
                                    a.cMp.notifyAll();
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
                    synchronized (a.cMp) {
                        aiF();
                        aiG();
                        throw th;
                    }
                }
            }
        }

        public boolean aiI() {
            return this.cMO && this.cMP && aiJ();
        }

        private boolean aiJ() {
            return !this.vv && this.cML && !this.cMM && this.mWidth > 0 && this.mHeight > 0 && (this.cMT || this.cMS == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.cMp) {
                    this.cMS = i;
                    a.cMp.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.cMp) {
                i = this.cMS;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.cMp) {
                this.cMT = true;
                a.cMp.notifyAll();
            }
        }

        public void aiK() {
            synchronized (a.cMp) {
                this.cML = true;
                this.cMQ = false;
                a.cMp.notifyAll();
                while (this.cMN && !this.cMQ && !this.cMJ) {
                    try {
                        a.cMp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.cMp) {
                this.cML = false;
                a.cMp.notifyAll();
                while (!this.cMN && !this.cMJ) {
                    try {
                        a.cMp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.cMp) {
                this.cMK = true;
                a.cMp.notifyAll();
                while (!this.cMJ && !this.vv) {
                    try {
                        a.cMp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.cMp) {
                this.cMK = false;
                this.cMT = true;
                this.cMU = false;
                a.cMp.notifyAll();
                while (!this.cMJ && this.vv && !this.cMU) {
                    try {
                        a.cMp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void bj(int i, int i2) {
            synchronized (a.cMp) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cMW = true;
                this.cMT = true;
                this.cMU = false;
                a.cMp.notifyAll();
                while (!this.cMJ && !this.vv && !this.cMU && aiI()) {
                    try {
                        a.cMp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiL() {
            synchronized (a.cMp) {
                this.cMI = true;
                a.cMp.notifyAll();
                while (!this.cMJ) {
                    try {
                        a.cMp.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiM() {
            this.cMR = true;
            a.cMp.notifyAll();
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

    private void aiy() {
        if (this.cMr != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cMY;
        private int cMZ;
        private boolean cNa;
        private boolean cNb;
        private boolean cNc;
        private i cNd;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cMJ = true;
            if (this.cNd == iVar) {
                this.cNd = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cNd == iVar || this.cNd == null) {
                this.cNd = iVar;
                notifyAll();
                return true;
            }
            aiP();
            if (this.cNb) {
                return true;
            }
            if (this.cNd != null) {
                this.cNd.aiM();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cNd == iVar) {
                this.cNd = null;
            }
            notifyAll();
        }

        public synchronized boolean aiN() {
            return this.cNc;
        }

        public synchronized boolean aiO() {
            aiP();
            return !this.cNb;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cNa) {
                    aiP();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cMZ < 131072) {
                        this.cNb = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cNc = this.cNb ? false : true;
                    this.cNa = true;
                }
            }
        }

        private void aiP() {
            if (!this.cMY) {
                this.cNb = true;
                this.cMY = true;
            }
        }
    }
}
