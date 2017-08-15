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
    private static final j bCx = new j();
    private c.m bCA;
    private e bCB;
    private f bCC;
    private g bCD;
    private k bCE;
    private int bCF;
    private int bCG;
    private boolean bCH;
    private final WeakReference<a> bCy;
    private i bCz;
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
        this.bCy = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bCz != null) {
                this.bCz.Vy();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bCE = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bCF = i2;
    }

    public int getDebugFlags() {
        return this.bCF;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bCH = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bCH;
    }

    public void setRenderer(c.m mVar) {
        Vl();
        if (this.bCB == null) {
            this.bCB = new m(true);
        }
        if (this.bCC == null) {
            this.bCC = new c();
        }
        if (this.bCD == null) {
            this.bCD = new d();
        }
        this.bCA = mVar;
        this.bCz = new i(this.bCy);
        this.bCz.start();
    }

    public void setEGLContextFactory(f fVar) {
        Vl();
        this.bCC = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Vl();
        this.bCD = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Vl();
        this.bCB = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Vl();
        this.bCG = i2;
    }

    public void setRenderMode(int i2) {
        this.bCz.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bCz.getRenderMode();
    }

    public void requestRender() {
        this.bCz.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bCz.Vx();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bCz.Z(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bCz.Z(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bCz.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bCz.onPause();
    }

    public void onResume() {
        this.bCz.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bCA != null) {
            int renderMode = this.bCz != null ? this.bCz.getRenderMode() : 1;
            this.bCz = new i(this.bCy);
            if (renderMode != 1) {
                this.bCz.setRenderMode(renderMode);
            }
            this.bCz.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bCz != null) {
            this.bCz.Vy();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bCG, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bCG == 0) {
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
        protected int[] bCI;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0073a(int[] iArr) {
            this.bCI = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bCI, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bCI, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bCG == 2) {
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
        private WeakReference<a> bCK;
        EGL10 bCL;
        EGLDisplay bCM;
        EGLSurface bCN;
        EGLConfig bCO;
        EGLContext bCP;

        public h(WeakReference<a> weakReference) {
            this.bCK = weakReference;
        }

        public void start() {
            this.bCL = (EGL10) EGLContext.getEGL();
            this.bCM = this.bCL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bCM == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bCL.eglInitialize(this.bCM, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bCK.get();
            if (aVar != null) {
                this.bCO = aVar.bCB.chooseConfig(this.bCL, this.bCM);
                try {
                    this.bCP = aVar.bCC.createContext(this.bCL, this.bCM, this.bCO);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bCO = null;
                this.bCP = null;
            }
            if (this.bCP == null || this.bCP == EGL10.EGL_NO_CONTEXT) {
                this.bCP = null;
                iV("createContext");
            }
            this.bCN = null;
        }

        public boolean Vn() {
            if (this.bCL == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bCM == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bCO == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Vr();
            a aVar = this.bCK.get();
            if (aVar != null) {
                this.bCN = aVar.bCD.createWindowSurface(this.bCL, this.bCM, this.bCO, aVar.getSurfaceTexture());
            } else {
                this.bCN = null;
            }
            if (this.bCN == null || this.bCN == EGL10.EGL_NO_SURFACE) {
                if (this.bCL.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bCL.eglMakeCurrent(this.bCM, this.bCN, this.bCN, this.bCP)) {
                f("EGLHelper", "eglMakeCurrent", this.bCL.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Vo() {
            l lVar;
            GL gl = this.bCP.getGL();
            a aVar = this.bCK.get();
            if (aVar != null) {
                if (aVar.bCE != null) {
                    gl = aVar.bCE.wrap(gl);
                }
                if ((aVar.bCF & 3) != 0) {
                    int i = 0;
                    if ((aVar.bCF & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bCF & 2) == 0) {
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

        public int Vp() {
            if (this.bCL.eglSwapBuffers(this.bCM, this.bCN)) {
                return 12288;
            }
            return this.bCL.eglGetError();
        }

        public void Vq() {
            Vr();
        }

        private void Vr() {
            if (this.bCN != null && this.bCN != EGL10.EGL_NO_SURFACE) {
                this.bCL.eglMakeCurrent(this.bCM, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bCK.get();
                if (aVar != null) {
                    aVar.bCD.destroySurface(this.bCL, this.bCM, this.bCN);
                }
                this.bCN = null;
            }
        }

        public void finish() {
            if (this.bCP != null) {
                a aVar = this.bCK.get();
                if (aVar != null) {
                    try {
                        aVar.bCC.destroyContext(this.bCL, this.bCM, this.bCP);
                    } catch (Exception e) {
                    }
                }
                this.bCP = null;
            }
            if (this.bCM != null) {
                this.bCL.eglTerminate(this.bCM);
                this.bCM = null;
            }
        }

        private void iV(String str) {
            G(str, this.bCL.eglGetError());
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
        private WeakReference<a> bCK;
        private boolean bCQ;
        private boolean bCR;
        private boolean bCS;
        private boolean bCT;
        private boolean bCU;
        private boolean bCV;
        private boolean bCW;
        private boolean bCX;
        private boolean bCY;
        private boolean bCZ;
        private boolean bDa;
        private boolean bDd;
        private h bDg;
        private ArrayList<Runnable> bDe = new ArrayList<>();
        private boolean bDf = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bDc = true;
        private int bDb = 1;

        i(WeakReference<a> weakReference) {
            this.bCK = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Vu();
                    a.bCx.a(this);
                } catch (Exception e) {
                    ae.vz().aC(false);
                    a.bCx.a(this);
                }
            } catch (Throwable th) {
                a.bCx.a(this);
                throw th;
            }
        }

        private void Vs() {
            if (this.bCY) {
                this.bCY = false;
                this.bDg.Vq();
            }
        }

        private void Vt() {
            if (this.bCX) {
                this.bDg.finish();
                this.bCX = false;
                a.bCx.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Vu() throws InterruptedException {
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
            this.bDg = new h(this.bCK);
            this.bCX = false;
            this.bCY = false;
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
                    synchronized (a.bCx) {
                        while (!this.bCQ) {
                            if (this.bDe.isEmpty()) {
                                if (this.bCT != this.bCS) {
                                    boolean z23 = this.bCS;
                                    this.bCT = this.bCS;
                                    a.bCx.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bDa) {
                                    Vs();
                                    Vt();
                                    this.bDa = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    Vs();
                                    Vt();
                                    z19 = false;
                                }
                                if (z9 && this.bCY) {
                                    Vs();
                                }
                                if (z9 && this.bCX) {
                                    a aVar = this.bCK.get();
                                    if (!(aVar == null ? false : aVar.bCH) || a.bCx.VA()) {
                                        Vt();
                                    }
                                }
                                if (z9 && a.bCx.VB()) {
                                    this.bDg.finish();
                                }
                                if (!this.bCU && !this.bCW) {
                                    if (this.bCY) {
                                        Vs();
                                    }
                                    this.bCW = true;
                                    this.bCV = false;
                                    a.bCx.notifyAll();
                                }
                                if (this.bCU && this.bCW) {
                                    this.bCW = false;
                                    a.bCx.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bDd = true;
                                    a.bCx.notifyAll();
                                }
                                if (Vw()) {
                                    if (!this.bCX) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bCx.b(this)) {
                                            try {
                                                this.bDg.start();
                                                this.bCX = true;
                                                z15 = true;
                                                a.bCx.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bCx.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bCX || this.bCY) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bCY = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bCY) {
                                        if (this.bDf) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bDf = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bDc = false;
                                        a.bCx.notifyAll();
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
                                a.bCx.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bDe.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bCx) {
                            Vs();
                            Vt();
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
                        } else if (this.bDg.Vn()) {
                            synchronized (a.bCx) {
                                this.bCZ = true;
                                a.bCx.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bCx) {
                                this.bCZ = true;
                                this.bCV = true;
                                a.bCx.notifyAll();
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
                            GL10 gl103 = (GL10) this.bDg.Vo();
                            a.bCx.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bCK.get();
                            if (aVar2 != null) {
                                aVar2.bCA.onSurfaceCreated(gl10, this.bDg.bCO);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bCK.get();
                            if (aVar3 != null) {
                                aVar3.bCA.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bCK.get();
                        if (aVar4 != null) {
                            aVar4.bCA.onDrawFrame(gl10);
                        }
                        int Vp = this.bDg.Vp();
                        switch (Vp) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Vp);
                                synchronized (a.bCx) {
                                    this.bCV = true;
                                    a.bCx.notifyAll();
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
                    synchronized (a.bCx) {
                        Vs();
                        Vt();
                        throw th;
                    }
                }
            }
        }

        public boolean Vv() {
            return this.bCX && this.bCY && Vw();
        }

        private boolean Vw() {
            return !this.bCT && this.bCU && !this.bCV && this.mWidth > 0 && this.mHeight > 0 && (this.bDc || this.bDb == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bCx) {
                    this.bDb = i;
                    a.bCx.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bCx) {
                i = this.bDb;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bCx) {
                this.bDc = true;
                a.bCx.notifyAll();
            }
        }

        public void Vx() {
            synchronized (a.bCx) {
                this.bCU = true;
                this.bCZ = false;
                a.bCx.notifyAll();
                while (this.bCW && !this.bCZ && !this.bCR) {
                    try {
                        a.bCx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bCx) {
                this.bCU = false;
                a.bCx.notifyAll();
                while (!this.bCW && !this.bCR) {
                    try {
                        a.bCx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bCx) {
                this.bCS = true;
                a.bCx.notifyAll();
                while (!this.bCR && !this.bCT) {
                    try {
                        a.bCx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bCx) {
                this.bCS = false;
                this.bDc = true;
                this.bDd = false;
                a.bCx.notifyAll();
                while (!this.bCR && this.bCT && !this.bDd) {
                    try {
                        a.bCx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Z(int i, int i2) {
            synchronized (a.bCx) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bDf = true;
                this.bDc = true;
                this.bDd = false;
                a.bCx.notifyAll();
                while (!this.bCR && !this.bCT && !this.bDd && Vv()) {
                    try {
                        a.bCx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vy() {
            synchronized (a.bCx) {
                this.bCQ = true;
                a.bCx.notifyAll();
                while (!this.bCR) {
                    try {
                        a.bCx.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vz() {
            this.bDa = true;
            a.bCx.notifyAll();
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

    private void Vl() {
        if (this.bCz != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bDh;
        private int bDi;
        private boolean bDj;
        private boolean bDk;
        private boolean bDl;
        private i bDm;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bCR = true;
            if (this.bDm == iVar) {
                this.bDm = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bDm == iVar || this.bDm == null) {
                this.bDm = iVar;
                notifyAll();
                return true;
            }
            VC();
            if (this.bDk) {
                return true;
            }
            if (this.bDm != null) {
                this.bDm.Vz();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bDm == iVar) {
                this.bDm = null;
            }
            notifyAll();
        }

        public synchronized boolean VA() {
            return this.bDl;
        }

        public synchronized boolean VB() {
            VC();
            return !this.bDk;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bDj) {
                    VC();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bDi < 131072) {
                        this.bDk = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bDl = this.bDk ? false : true;
                    this.bDj = true;
                }
            }
        }

        private void VC() {
            if (!this.bDh) {
                this.bDk = true;
                this.bDh = true;
            }
        }
    }
}
