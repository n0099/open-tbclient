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
    private static final j bCy = new j();
    private i bCA;
    private c.m bCB;
    private e bCC;
    private f bCD;
    private g bCE;
    private k bCF;
    private int bCG;
    private int bCH;
    private boolean bCI;
    private final WeakReference<a> bCz;
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
        this.bCz = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bCA != null) {
                this.bCA.Vv();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bCF = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bCG = i2;
    }

    public int getDebugFlags() {
        return this.bCG;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bCI = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bCI;
    }

    public void setRenderer(c.m mVar) {
        Vi();
        if (this.bCC == null) {
            this.bCC = new m(true);
        }
        if (this.bCD == null) {
            this.bCD = new c();
        }
        if (this.bCE == null) {
            this.bCE = new d();
        }
        this.bCB = mVar;
        this.bCA = new i(this.bCz);
        this.bCA.start();
    }

    public void setEGLContextFactory(f fVar) {
        Vi();
        this.bCD = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Vi();
        this.bCE = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Vi();
        this.bCC = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Vi();
        this.bCH = i2;
    }

    public void setRenderMode(int i2) {
        this.bCA.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bCA.getRenderMode();
    }

    public void requestRender() {
        this.bCA.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bCA.Vu();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bCA.Z(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bCA.Z(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bCA.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bCA.onPause();
    }

    public void onResume() {
        this.bCA.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bCB != null) {
            int renderMode = this.bCA != null ? this.bCA.getRenderMode() : 1;
            this.bCA = new i(this.bCz);
            if (renderMode != 1) {
                this.bCA.setRenderMode(renderMode);
            }
            this.bCA.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bCA != null) {
            this.bCA.Vv();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bCH, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bCH == 0) {
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
        protected int[] bCJ;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0073a(int[] iArr) {
            this.bCJ = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bCJ, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bCJ, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bCH == 2) {
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
        private WeakReference<a> bCL;
        EGL10 bCM;
        EGLDisplay bCN;
        EGLSurface bCO;
        EGLConfig bCP;
        EGLContext bCQ;

        public h(WeakReference<a> weakReference) {
            this.bCL = weakReference;
        }

        public void start() {
            this.bCM = (EGL10) EGLContext.getEGL();
            this.bCN = this.bCM.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bCN == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bCM.eglInitialize(this.bCN, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bCL.get();
            if (aVar != null) {
                this.bCP = aVar.bCC.chooseConfig(this.bCM, this.bCN);
                try {
                    this.bCQ = aVar.bCD.createContext(this.bCM, this.bCN, this.bCP);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bCP = null;
                this.bCQ = null;
            }
            if (this.bCQ == null || this.bCQ == EGL10.EGL_NO_CONTEXT) {
                this.bCQ = null;
                iY("createContext");
            }
            this.bCO = null;
        }

        public boolean Vk() {
            if (this.bCM == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bCN == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bCP == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Vo();
            a aVar = this.bCL.get();
            if (aVar != null) {
                this.bCO = aVar.bCE.createWindowSurface(this.bCM, this.bCN, this.bCP, aVar.getSurfaceTexture());
            } else {
                this.bCO = null;
            }
            if (this.bCO == null || this.bCO == EGL10.EGL_NO_SURFACE) {
                if (this.bCM.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bCM.eglMakeCurrent(this.bCN, this.bCO, this.bCO, this.bCQ)) {
                f("EGLHelper", "eglMakeCurrent", this.bCM.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Vl() {
            l lVar;
            GL gl = this.bCQ.getGL();
            a aVar = this.bCL.get();
            if (aVar != null) {
                if (aVar.bCF != null) {
                    gl = aVar.bCF.wrap(gl);
                }
                if ((aVar.bCG & 3) != 0) {
                    int i = 0;
                    if ((aVar.bCG & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bCG & 2) == 0) {
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

        public int Vm() {
            if (this.bCM.eglSwapBuffers(this.bCN, this.bCO)) {
                return 12288;
            }
            return this.bCM.eglGetError();
        }

        public void Vn() {
            Vo();
        }

        private void Vo() {
            if (this.bCO != null && this.bCO != EGL10.EGL_NO_SURFACE) {
                this.bCM.eglMakeCurrent(this.bCN, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bCL.get();
                if (aVar != null) {
                    aVar.bCE.destroySurface(this.bCM, this.bCN, this.bCO);
                }
                this.bCO = null;
            }
        }

        public void finish() {
            if (this.bCQ != null) {
                a aVar = this.bCL.get();
                if (aVar != null) {
                    try {
                        aVar.bCD.destroyContext(this.bCM, this.bCN, this.bCQ);
                    } catch (Exception e) {
                    }
                }
                this.bCQ = null;
            }
            if (this.bCN != null) {
                this.bCM.eglTerminate(this.bCN);
                this.bCN = null;
            }
        }

        private void iY(String str) {
            G(str, this.bCM.eglGetError());
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
        private WeakReference<a> bCL;
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
        private boolean bDb;
        private boolean bDe;
        private h bDh;
        private ArrayList<Runnable> bDf = new ArrayList<>();
        private boolean bDg = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bDd = true;
        private int bDc = 1;

        i(WeakReference<a> weakReference) {
            this.bCL = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Vr();
                    a.bCy.a(this);
                } catch (Exception e) {
                    ae.vA().aC(false);
                    a.bCy.a(this);
                }
            } catch (Throwable th) {
                a.bCy.a(this);
                throw th;
            }
        }

        private void Vp() {
            if (this.bCZ) {
                this.bCZ = false;
                this.bDh.Vn();
            }
        }

        private void Vq() {
            if (this.bCY) {
                this.bDh.finish();
                this.bCY = false;
                a.bCy.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Vr() throws InterruptedException {
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
            this.bDh = new h(this.bCL);
            this.bCY = false;
            this.bCZ = false;
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
                    synchronized (a.bCy) {
                        while (!this.bCR) {
                            if (this.bDf.isEmpty()) {
                                if (this.bCU != this.bCT) {
                                    boolean z23 = this.bCT;
                                    this.bCU = this.bCT;
                                    a.bCy.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bDb) {
                                    Vp();
                                    Vq();
                                    this.bDb = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    Vp();
                                    Vq();
                                    z19 = false;
                                }
                                if (z9 && this.bCZ) {
                                    Vp();
                                }
                                if (z9 && this.bCY) {
                                    a aVar = this.bCL.get();
                                    if (!(aVar == null ? false : aVar.bCI) || a.bCy.Vx()) {
                                        Vq();
                                    }
                                }
                                if (z9 && a.bCy.Vy()) {
                                    this.bDh.finish();
                                }
                                if (!this.bCV && !this.bCX) {
                                    if (this.bCZ) {
                                        Vp();
                                    }
                                    this.bCX = true;
                                    this.bCW = false;
                                    a.bCy.notifyAll();
                                }
                                if (this.bCV && this.bCX) {
                                    this.bCX = false;
                                    a.bCy.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bDe = true;
                                    a.bCy.notifyAll();
                                }
                                if (Vt()) {
                                    if (!this.bCY) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bCy.b(this)) {
                                            try {
                                                this.bDh.start();
                                                this.bCY = true;
                                                z15 = true;
                                                a.bCy.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bCy.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bCY || this.bCZ) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bCZ = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bCZ) {
                                        if (this.bDg) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bDg = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bDd = false;
                                        a.bCy.notifyAll();
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
                                a.bCy.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bDf.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bCy) {
                            Vp();
                            Vq();
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
                        } else if (this.bDh.Vk()) {
                            synchronized (a.bCy) {
                                this.bDa = true;
                                a.bCy.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bCy) {
                                this.bDa = true;
                                this.bCW = true;
                                a.bCy.notifyAll();
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
                            GL10 gl103 = (GL10) this.bDh.Vl();
                            a.bCy.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bCL.get();
                            if (aVar2 != null) {
                                aVar2.bCB.onSurfaceCreated(gl10, this.bDh.bCP);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bCL.get();
                            if (aVar3 != null) {
                                aVar3.bCB.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bCL.get();
                        if (aVar4 != null) {
                            aVar4.bCB.onDrawFrame(gl10);
                        }
                        int Vm = this.bDh.Vm();
                        switch (Vm) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Vm);
                                synchronized (a.bCy) {
                                    this.bCW = true;
                                    a.bCy.notifyAll();
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
                    synchronized (a.bCy) {
                        Vp();
                        Vq();
                        throw th;
                    }
                }
            }
        }

        public boolean Vs() {
            return this.bCY && this.bCZ && Vt();
        }

        private boolean Vt() {
            return !this.bCU && this.bCV && !this.bCW && this.mWidth > 0 && this.mHeight > 0 && (this.bDd || this.bDc == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bCy) {
                    this.bDc = i;
                    a.bCy.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bCy) {
                i = this.bDc;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bCy) {
                this.bDd = true;
                a.bCy.notifyAll();
            }
        }

        public void Vu() {
            synchronized (a.bCy) {
                this.bCV = true;
                this.bDa = false;
                a.bCy.notifyAll();
                while (this.bCX && !this.bDa && !this.bCS) {
                    try {
                        a.bCy.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bCy) {
                this.bCV = false;
                a.bCy.notifyAll();
                while (!this.bCX && !this.bCS) {
                    try {
                        a.bCy.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bCy) {
                this.bCT = true;
                a.bCy.notifyAll();
                while (!this.bCS && !this.bCU) {
                    try {
                        a.bCy.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bCy) {
                this.bCT = false;
                this.bDd = true;
                this.bDe = false;
                a.bCy.notifyAll();
                while (!this.bCS && this.bCU && !this.bDe) {
                    try {
                        a.bCy.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Z(int i, int i2) {
            synchronized (a.bCy) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bDg = true;
                this.bDd = true;
                this.bDe = false;
                a.bCy.notifyAll();
                while (!this.bCS && !this.bCU && !this.bDe && Vs()) {
                    try {
                        a.bCy.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vv() {
            synchronized (a.bCy) {
                this.bCR = true;
                a.bCy.notifyAll();
                while (!this.bCS) {
                    try {
                        a.bCy.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vw() {
            this.bDb = true;
            a.bCy.notifyAll();
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

    private void Vi() {
        if (this.bCA != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bDi;
        private int bDj;
        private boolean bDk;
        private boolean bDl;
        private boolean bDm;
        private i bDn;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bCS = true;
            if (this.bDn == iVar) {
                this.bDn = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bDn == iVar || this.bDn == null) {
                this.bDn = iVar;
                notifyAll();
                return true;
            }
            Vz();
            if (this.bDl) {
                return true;
            }
            if (this.bDn != null) {
                this.bDn.Vw();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bDn == iVar) {
                this.bDn = null;
            }
            notifyAll();
        }

        public synchronized boolean Vx() {
            return this.bDm;
        }

        public synchronized boolean Vy() {
            Vz();
            return !this.bDl;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bDk) {
                    Vz();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bDj < 131072) {
                        this.bDl = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bDm = this.bDl ? false : true;
                    this.bDk = true;
                }
            }
        }

        private void Vz() {
            if (!this.bDi) {
                this.bDl = true;
                this.bDi = true;
            }
        }
    }
}
