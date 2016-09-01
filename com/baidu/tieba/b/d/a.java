package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.am;
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
    private static final j aWp = new j(null);
    private final WeakReference<a> aWq;
    private i aWr;
    private GLSurfaceView.Renderer aWs;
    private e aWt;
    private f aWu;
    private g aWv;
    private k aWw;
    private int aWx;
    private int aWy;
    private boolean aWz;
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
        this.aWq = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aWr != null) {
                this.aWr.MV();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.aWw = kVar;
    }

    public void setDebugFlags(int i2) {
        this.aWx = i2;
    }

    public int getDebugFlags() {
        return this.aWx;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.aWz = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.aWz;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        MH();
        if (this.aWt == null) {
            this.aWt = new m(true);
        }
        if (this.aWu == null) {
            this.aWu = new c(this, null);
        }
        if (this.aWv == null) {
            this.aWv = new d(null);
        }
        this.aWs = renderer;
        this.aWr = new i(this.aWq);
        this.aWr.start();
    }

    public void setEGLContextFactory(f fVar) {
        MH();
        this.aWu = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        MH();
        this.aWv = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        MH();
        this.aWt = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        MH();
        this.aWy = i2;
    }

    public void setRenderMode(int i2) {
        this.aWr.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.aWr.getRenderMode();
    }

    public void requestRender() {
        this.aWr.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aWr.MT();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aWr.P(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.aWr.P(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.aWr.MU();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.aWr.onPause();
    }

    public void onResume() {
        this.aWr.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.aWs != null) {
            int renderMode = this.aWr != null ? this.aWr.getRenderMode() : 1;
            this.aWr = new i(this.aWq);
            if (renderMode != 1) {
                this.aWr.setRenderMode(renderMode);
            }
            this.aWr.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.aWr != null) {
            this.aWr.MV();
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

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        @Override // com.baidu.tieba.b.d.a.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.aWy, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.aWy == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.J("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0052a implements e {
        protected int[] aWA;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0052a(int[] iArr) {
            this.aWA = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aWA, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aWA, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.aWy == 2) {
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
    private class b extends AbstractC0052a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0052a
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
        private WeakReference<a> aWC;
        EGL10 aWD;
        EGLDisplay aWE;
        EGLSurface aWF;
        EGLConfig aWG;
        EGLContext aWH;

        public h(WeakReference<a> weakReference) {
            this.aWC = weakReference;
        }

        public void start() {
            this.aWD = (EGL10) EGLContext.getEGL();
            this.aWE = this.aWD.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.aWE == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.aWD.eglInitialize(this.aWE, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.aWC.get();
            if (aVar == null) {
                this.aWG = null;
                this.aWH = null;
            } else {
                this.aWG = aVar.aWt.chooseConfig(this.aWD, this.aWE);
                try {
                    this.aWH = aVar.aWu.createContext(this.aWD, this.aWE, this.aWG);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.aWH == null || this.aWH == EGL10.EGL_NO_CONTEXT) {
                this.aWH = null;
                hD("createContext");
            }
            this.aWF = null;
        }

        public boolean MJ() {
            if (this.aWD == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.aWE == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aWG == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            MN();
            a aVar = this.aWC.get();
            if (aVar != null) {
                this.aWF = aVar.aWv.createWindowSurface(this.aWD, this.aWE, this.aWG, aVar.getSurfaceTexture());
            } else {
                this.aWF = null;
            }
            if (this.aWF == null || this.aWF == EGL10.EGL_NO_SURFACE) {
                if (this.aWD.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.aWD.eglMakeCurrent(this.aWE, this.aWF, this.aWF, this.aWH)) {
                f("EGLHelper", "eglMakeCurrent", this.aWD.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL MK() {
            l lVar;
            GL gl = this.aWH.getGL();
            a aVar = this.aWC.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.aWw != null) {
                gl = aVar.aWw.wrap(gl);
            }
            if ((aVar.aWx & 3) != 0) {
                int i = 0;
                if ((aVar.aWx & 1) != 0) {
                    i = 1;
                }
                if ((aVar.aWx & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int ML() {
            if (this.aWD.eglSwapBuffers(this.aWE, this.aWF)) {
                return 12288;
            }
            return this.aWD.eglGetError();
        }

        public void MM() {
            MN();
        }

        private void MN() {
            if (this.aWF != null && this.aWF != EGL10.EGL_NO_SURFACE) {
                this.aWD.eglMakeCurrent(this.aWE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.aWC.get();
                if (aVar != null) {
                    aVar.aWv.destroySurface(this.aWD, this.aWE, this.aWF);
                }
                this.aWF = null;
            }
        }

        public void finish() {
            if (this.aWH != null) {
                a aVar = this.aWC.get();
                if (aVar != null) {
                    try {
                        aVar.aWu.destroyContext(this.aWD, this.aWE, this.aWH);
                    } catch (Exception e) {
                    }
                }
                this.aWH = null;
            }
            if (this.aWE != null) {
                this.aWD.eglTerminate(this.aWE);
                this.aWE = null;
            }
        }

        private void hD(String str) {
            J(str, this.aWD.eglGetError());
        }

        public static void J(String str, int i) {
            throw new RuntimeException(K(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, K(str2, i));
        }

        public static String K(String str, int i) {
            return String.valueOf(str) + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> aWC;
        private boolean aWI;
        private boolean aWJ;
        private boolean aWK;
        private boolean aWL;
        private boolean aWM;
        private boolean aWN;
        private boolean aWO;
        private boolean aWP;
        private boolean aWQ;
        private boolean aWR;
        private boolean aWS;
        private boolean aWV;
        private h aWY;
        private ArrayList<Runnable> aWW = new ArrayList<>();
        private boolean aWX = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aWU = true;
        private int aWT = 1;

        i(WeakReference<a> weakReference) {
            this.aWC = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    MQ();
                    a.aWp.a(this);
                } catch (Exception e) {
                    am.uS().aA(false);
                    a.aWp.a(this);
                }
            } catch (Throwable th) {
                a.aWp.a(this);
                throw th;
            }
        }

        private void MO() {
            if (this.aWQ) {
                this.aWQ = false;
                this.aWY.MM();
            }
        }

        private void MP() {
            if (this.aWP) {
                this.aWY.finish();
                this.aWP = false;
                a.aWp.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void MQ() throws InterruptedException {
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
            this.aWY = new h(this.aWC);
            this.aWP = false;
            this.aWQ = false;
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
                    sleep(4L);
                    synchronized (a.aWp) {
                        while (!this.aWI) {
                            if (this.aWW.isEmpty()) {
                                if (this.aWL != this.aWK) {
                                    boolean z23 = this.aWK;
                                    this.aWL = this.aWK;
                                    a.aWp.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.aWS) {
                                    MO();
                                    MP();
                                    this.aWS = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    MO();
                                    MP();
                                    z20 = false;
                                }
                                if (z9 && this.aWQ) {
                                    MO();
                                }
                                if (z9 && this.aWP) {
                                    a aVar = this.aWC.get();
                                    if (!(aVar == null ? false : aVar.aWz) || a.aWp.MX()) {
                                        MP();
                                    }
                                }
                                if (z9 && a.aWp.MY()) {
                                    this.aWY.finish();
                                }
                                if (!this.aWM && !this.aWO) {
                                    if (this.aWQ) {
                                        MO();
                                    }
                                    this.aWO = true;
                                    this.aWN = false;
                                    a.aWp.notifyAll();
                                }
                                if (this.aWM && this.aWO) {
                                    this.aWO = false;
                                    a.aWp.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.aWV = true;
                                    a.aWp.notifyAll();
                                }
                                if (MS()) {
                                    if (!this.aWP) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.aWp.b(this)) {
                                            try {
                                                this.aWY.start();
                                                this.aWP = true;
                                                z15 = true;
                                                a.aWp.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.aWp.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.aWP || this.aWQ) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.aWQ = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.aWQ) {
                                        if (this.aWX) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.aWX = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.aWU = false;
                                        a.aWp.notifyAll();
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
                                a.aWp.wait();
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
                                remove = this.aWW.remove(0);
                            }
                        }
                        synchronized (a.aWp) {
                            MO();
                            MP();
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
                        } else if (this.aWY.MJ()) {
                            synchronized (a.aWp) {
                                this.aWR = true;
                                a.aWp.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.aWp) {
                                this.aWR = true;
                                this.aWN = true;
                                a.aWp.notifyAll();
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
                            GL10 gl103 = (GL10) this.aWY.MK();
                            a.aWp.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.aWC.get();
                            if (aVar2 != null) {
                                aVar2.aWs.onSurfaceCreated(gl10, this.aWY.aWG);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.aWC.get();
                            if (aVar3 != null) {
                                aVar3.aWs.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.aWC.get();
                        if (aVar4 != null) {
                            aVar4.aWs.onDrawFrame(gl10);
                        }
                        int ML = this.aWY.ML();
                        switch (ML) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", ML);
                                synchronized (a.aWp) {
                                    this.aWN = true;
                                    a.aWp.notifyAll();
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
                    synchronized (a.aWp) {
                        MO();
                        MP();
                        throw th;
                    }
                }
            }
        }

        public boolean MR() {
            return this.aWP && this.aWQ && MS();
        }

        private boolean MS() {
            return !this.aWL && this.aWM && !this.aWN && this.mWidth > 0 && this.mHeight > 0 && (this.aWU || this.aWT == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.aWp) {
                this.aWT = i;
                a.aWp.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.aWp) {
                i = this.aWT;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.aWp) {
                this.aWU = true;
                a.aWp.notifyAll();
            }
        }

        public void MT() {
            synchronized (a.aWp) {
                this.aWM = true;
                this.aWR = false;
                a.aWp.notifyAll();
                while (this.aWO && !this.aWR && !this.aWJ) {
                    try {
                        a.aWp.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void MU() {
            synchronized (a.aWp) {
                this.aWM = false;
                a.aWp.notifyAll();
                while (!this.aWO && !this.aWJ) {
                    try {
                        a.aWp.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.aWp) {
                this.aWK = true;
                a.aWp.notifyAll();
                while (!this.aWJ && !this.aWL) {
                    try {
                        a.aWp.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.aWp) {
                this.aWK = false;
                this.aWU = true;
                this.aWV = false;
                a.aWp.notifyAll();
                while (!this.aWJ && this.aWL && !this.aWV) {
                    try {
                        a.aWp.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void P(int i, int i2) {
            synchronized (a.aWp) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aWX = true;
                this.aWU = true;
                this.aWV = false;
                a.aWp.notifyAll();
                while (!this.aWJ && !this.aWL && !this.aWV && MR()) {
                    try {
                        a.aWp.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void MV() {
            synchronized (a.aWp) {
                this.aWI = true;
                a.aWp.notifyAll();
                while (!this.aWJ) {
                    try {
                        a.aWp.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void MW() {
            this.aWS = true;
            a.aWp.notifyAll();
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

    private void MH() {
        if (this.aWr != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean aWZ;
        private int aXa;
        private boolean aXb;
        private boolean aXc;
        private boolean aXd;
        private i aXe;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.aWJ = true;
            if (this.aXe == iVar) {
                this.aXe = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.aXe == iVar || this.aXe == null) {
                this.aXe = iVar;
                notifyAll();
                return true;
            }
            MZ();
            if (this.aXc) {
                return true;
            }
            if (this.aXe != null) {
                this.aXe.MW();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.aXe == iVar) {
                this.aXe = null;
            }
            notifyAll();
        }

        public synchronized boolean MX() {
            return this.aXd;
        }

        public synchronized boolean MY() {
            MZ();
            return !this.aXc;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.aXb) {
                    MZ();
                    String glGetString = gl10.glGetString(7937);
                    if (this.aXa < 131072) {
                        this.aXc = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.aXd = this.aXc ? false : true;
                    this.aXb = true;
                }
            }
        }

        private void MZ() {
            if (!this.aWZ) {
                this.aXc = true;
                this.aWZ = true;
            }
        }
    }
}
