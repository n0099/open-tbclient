package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ae;
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
    private static final j bAE = new j();
    private final WeakReference<a> bAF;
    private i bAG;
    private c.m bAH;
    private e bAI;
    private f bAJ;
    private g bAK;
    private k bAL;
    private int bAM;
    private int bAN;
    private boolean bAO;
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
        this.bAF = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bAG != null) {
                this.bAG.UX();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bAL = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bAM = i2;
    }

    public int getDebugFlags() {
        return this.bAM;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bAO = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bAO;
    }

    public void setRenderer(c.m mVar) {
        UK();
        if (this.bAI == null) {
            this.bAI = new m(true);
        }
        if (this.bAJ == null) {
            this.bAJ = new c();
        }
        if (this.bAK == null) {
            this.bAK = new d();
        }
        this.bAH = mVar;
        this.bAG = new i(this.bAF);
        this.bAG.start();
    }

    public void setEGLContextFactory(f fVar) {
        UK();
        this.bAJ = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        UK();
        this.bAK = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        UK();
        this.bAI = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        UK();
        this.bAN = i2;
    }

    public void setRenderMode(int i2) {
        this.bAG.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bAG.getRenderMode();
    }

    public void requestRender() {
        this.bAG.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bAG.UW();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bAG.Y(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bAG.Y(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bAG.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bAG.onPause();
    }

    public void onResume() {
        this.bAG.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bAH != null) {
            int renderMode = this.bAG != null ? this.bAG.getRenderMode() : 1;
            this.bAG = new i(this.bAF);
            if (renderMode != 1) {
                this.bAG.setRenderMode(renderMode);
            }
            this.bAG.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bAG != null) {
            this.bAG.UX();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bAN, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bAN == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
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
    private abstract class AbstractC0073a implements e {
        protected int[] bAP;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0073a(int[] iArr) {
            this.bAP = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bAP, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bAP, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bAN == 2) {
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
    private class b extends AbstractC0073a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0073a
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
        private WeakReference<a> bAR;
        EGL10 bAS;
        EGLDisplay bAT;
        EGLSurface bAU;
        EGLConfig bAV;
        EGLContext bAW;

        public h(WeakReference<a> weakReference) {
            this.bAR = weakReference;
        }

        public void start() {
            this.bAS = (EGL10) EGLContext.getEGL();
            this.bAT = this.bAS.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bAT == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bAS.eglInitialize(this.bAT, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bAR.get();
            if (aVar != null) {
                this.bAV = aVar.bAI.chooseConfig(this.bAS, this.bAT);
                try {
                    this.bAW = aVar.bAJ.createContext(this.bAS, this.bAT, this.bAV);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bAV = null;
                this.bAW = null;
            }
            if (this.bAW == null || this.bAW == EGL10.EGL_NO_CONTEXT) {
                this.bAW = null;
                iP("createContext");
            }
            this.bAU = null;
        }

        public boolean UM() {
            if (this.bAS == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bAT == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bAV == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            UQ();
            a aVar = this.bAR.get();
            if (aVar != null) {
                this.bAU = aVar.bAK.createWindowSurface(this.bAS, this.bAT, this.bAV, aVar.getSurfaceTexture());
            } else {
                this.bAU = null;
            }
            if (this.bAU == null || this.bAU == EGL10.EGL_NO_SURFACE) {
                if (this.bAS.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bAS.eglMakeCurrent(this.bAT, this.bAU, this.bAU, this.bAW)) {
                f("EGLHelper", "eglMakeCurrent", this.bAS.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL UN() {
            l lVar;
            GL gl = this.bAW.getGL();
            a aVar = this.bAR.get();
            if (aVar != null) {
                if (aVar.bAL != null) {
                    gl = aVar.bAL.wrap(gl);
                }
                if ((aVar.bAM & 3) != 0) {
                    int i = 0;
                    if ((aVar.bAM & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bAM & 2) == 0) {
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

        public int UO() {
            if (this.bAS.eglSwapBuffers(this.bAT, this.bAU)) {
                return 12288;
            }
            return this.bAS.eglGetError();
        }

        public void UP() {
            UQ();
        }

        private void UQ() {
            if (this.bAU != null && this.bAU != EGL10.EGL_NO_SURFACE) {
                this.bAS.eglMakeCurrent(this.bAT, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bAR.get();
                if (aVar != null) {
                    aVar.bAK.destroySurface(this.bAS, this.bAT, this.bAU);
                }
                this.bAU = null;
            }
        }

        public void finish() {
            if (this.bAW != null) {
                a aVar = this.bAR.get();
                if (aVar != null) {
                    try {
                        aVar.bAJ.destroyContext(this.bAS, this.bAT, this.bAW);
                    } catch (Exception e) {
                    }
                }
                this.bAW = null;
            }
            if (this.bAT != null) {
                this.bAS.eglTerminate(this.bAT);
                this.bAT = null;
            }
        }

        private void iP(String str) {
            G(str, this.bAS.eglGetError());
        }

        public static void G(String str, int i) {
            throw new RuntimeException(H(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, H(str2, i));
        }

        public static String H(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> bAR;
        private boolean bAX;
        private boolean bAY;
        private boolean bAZ;
        private boolean bBa;
        private boolean bBb;
        private boolean bBc;
        private boolean bBd;
        private boolean bBe;
        private boolean bBf;
        private boolean bBg;
        private boolean bBh;
        private boolean bBk;
        private h bBn;
        private ArrayList<Runnable> bBl = new ArrayList<>();
        private boolean bBm = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bBj = true;
        private int bBi = 1;

        i(WeakReference<a> weakReference) {
            this.bAR = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    UT();
                    a.bAE.a(this);
                } catch (Exception e) {
                    ae.vp().aC(false);
                    a.bAE.a(this);
                }
            } catch (Throwable th) {
                a.bAE.a(this);
                throw th;
            }
        }

        private void UR() {
            if (this.bBf) {
                this.bBf = false;
                this.bBn.UP();
            }
        }

        private void US() {
            if (this.bBe) {
                this.bBn.finish();
                this.bBe = false;
                a.bAE.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void UT() throws InterruptedException {
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
            this.bBn = new h(this.bAR);
            this.bBe = false;
            this.bBf = false;
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
                    synchronized (a.bAE) {
                        while (!this.bAX) {
                            if (this.bBl.isEmpty()) {
                                if (this.bBa != this.bAZ) {
                                    boolean z23 = this.bAZ;
                                    this.bBa = this.bAZ;
                                    a.bAE.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bBh) {
                                    UR();
                                    US();
                                    this.bBh = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    UR();
                                    US();
                                    z19 = false;
                                }
                                if (z9 && this.bBf) {
                                    UR();
                                }
                                if (z9 && this.bBe) {
                                    a aVar = this.bAR.get();
                                    if (!(aVar == null ? false : aVar.bAO) || a.bAE.UZ()) {
                                        US();
                                    }
                                }
                                if (z9 && a.bAE.Va()) {
                                    this.bBn.finish();
                                }
                                if (!this.bBb && !this.bBd) {
                                    if (this.bBf) {
                                        UR();
                                    }
                                    this.bBd = true;
                                    this.bBc = false;
                                    a.bAE.notifyAll();
                                }
                                if (this.bBb && this.bBd) {
                                    this.bBd = false;
                                    a.bAE.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bBk = true;
                                    a.bAE.notifyAll();
                                }
                                if (UV()) {
                                    if (!this.bBe) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bAE.b(this)) {
                                            try {
                                                this.bBn.start();
                                                this.bBe = true;
                                                z15 = true;
                                                a.bAE.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bAE.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bBe || this.bBf) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bBf = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bBf) {
                                        if (this.bBm) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bBm = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bBj = false;
                                        a.bAE.notifyAll();
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
                                a.bAE.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bBl.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bAE) {
                            UR();
                            US();
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
                        } else if (this.bBn.UM()) {
                            synchronized (a.bAE) {
                                this.bBg = true;
                                a.bAE.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bAE) {
                                this.bBg = true;
                                this.bBc = true;
                                a.bAE.notifyAll();
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
                            GL10 gl103 = (GL10) this.bBn.UN();
                            a.bAE.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bAR.get();
                            if (aVar2 != null) {
                                aVar2.bAH.onSurfaceCreated(gl10, this.bBn.bAV);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bAR.get();
                            if (aVar3 != null) {
                                aVar3.bAH.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bAR.get();
                        if (aVar4 != null) {
                            aVar4.bAH.onDrawFrame(gl10);
                        }
                        int UO = this.bBn.UO();
                        switch (UO) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", UO);
                                synchronized (a.bAE) {
                                    this.bBc = true;
                                    a.bAE.notifyAll();
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
                    synchronized (a.bAE) {
                        UR();
                        US();
                        throw th;
                    }
                }
            }
        }

        public boolean UU() {
            return this.bBe && this.bBf && UV();
        }

        private boolean UV() {
            return !this.bBa && this.bBb && !this.bBc && this.mWidth > 0 && this.mHeight > 0 && (this.bBj || this.bBi == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bAE) {
                    this.bBi = i;
                    a.bAE.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bAE) {
                i = this.bBi;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bAE) {
                this.bBj = true;
                a.bAE.notifyAll();
            }
        }

        public void UW() {
            synchronized (a.bAE) {
                this.bBb = true;
                this.bBg = false;
                a.bAE.notifyAll();
                while (this.bBd && !this.bBg && !this.bAY) {
                    try {
                        a.bAE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bAE) {
                this.bBb = false;
                a.bAE.notifyAll();
                while (!this.bBd && !this.bAY) {
                    try {
                        a.bAE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bAE) {
                this.bAZ = true;
                a.bAE.notifyAll();
                while (!this.bAY && !this.bBa) {
                    try {
                        a.bAE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bAE) {
                this.bAZ = false;
                this.bBj = true;
                this.bBk = false;
                a.bAE.notifyAll();
                while (!this.bAY && this.bBa && !this.bBk) {
                    try {
                        a.bAE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Y(int i, int i2) {
            synchronized (a.bAE) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bBm = true;
                this.bBj = true;
                this.bBk = false;
                a.bAE.notifyAll();
                while (!this.bAY && !this.bBa && !this.bBk && UU()) {
                    try {
                        a.bAE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void UX() {
            synchronized (a.bAE) {
                this.bAX = true;
                a.bAE.notifyAll();
                while (!this.bAY) {
                    try {
                        a.bAE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void UY() {
            this.bBh = true;
            a.bAE.notifyAll();
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

    private void UK() {
        if (this.bAG != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bBo;
        private int bBp;
        private boolean bBq;
        private boolean bBr;
        private boolean bBs;
        private i bBt;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bAY = true;
            if (this.bBt == iVar) {
                this.bBt = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bBt == iVar || this.bBt == null) {
                this.bBt = iVar;
                notifyAll();
                return true;
            }
            Vb();
            if (this.bBr) {
                return true;
            }
            if (this.bBt != null) {
                this.bBt.UY();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bBt == iVar) {
                this.bBt = null;
            }
            notifyAll();
        }

        public synchronized boolean UZ() {
            return this.bBs;
        }

        public synchronized boolean Va() {
            Vb();
            return !this.bBr;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bBq) {
                    Vb();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bBp < 131072) {
                        this.bBr = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bBs = this.bBr ? false : true;
                    this.bBq = true;
                }
            }
        }

        private void Vb() {
            if (!this.bBo) {
                this.bBr = true;
                this.bBo = true;
            }
        }
    }
}
