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
    private static final j bXE = new j();
    private final WeakReference<a> bXF;
    private i bXG;
    private c.m bXH;
    private e bXI;
    private f bXJ;
    private g bXK;
    private k bXL;
    private int bXM;
    private int bXN;
    private boolean bXO;
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
        this.bXF = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bXG != null) {
                this.bXG.abf();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bXL = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bXM = i2;
    }

    public int getDebugFlags() {
        return this.bXM;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bXO = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bXO;
    }

    public void setRenderer(c.m mVar) {
        aaS();
        if (this.bXI == null) {
            this.bXI = new m(true);
        }
        if (this.bXJ == null) {
            this.bXJ = new c();
        }
        if (this.bXK == null) {
            this.bXK = new d();
        }
        this.bXH = mVar;
        this.bXG = new i(this.bXF);
        this.bXG.start();
    }

    public void setEGLContextFactory(f fVar) {
        aaS();
        this.bXJ = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aaS();
        this.bXK = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aaS();
        this.bXI = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        aaS();
        this.bXN = i2;
    }

    public void setRenderMode(int i2) {
        this.bXG.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bXG.getRenderMode();
    }

    public void requestRender() {
        this.bXG.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bXG.abe();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bXG.ak(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bXG.ak(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bXG.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bXG.onPause();
    }

    public void onResume() {
        this.bXG.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bXH != null) {
            int renderMode = this.bXG != null ? this.bXG.getRenderMode() : 1;
            this.bXG = new i(this.bXF);
            if (renderMode != 1) {
                this.bXG.setRenderMode(renderMode);
            }
            this.bXG.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bXG != null) {
            this.bXG.abf();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bXN, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bXN == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.O("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0091a implements e {
        protected int[] bXP;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0091a(int[] iArr) {
            this.bXP = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXP, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXP, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (a.this.bXN == 2) {
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
    private class b extends AbstractC0091a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0091a
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
        private WeakReference<a> bXR;
        EGL10 bXS;
        EGLDisplay bXT;
        EGLSurface bXU;
        EGLConfig bXV;
        EGLContext bXW;

        public h(WeakReference<a> weakReference) {
            this.bXR = weakReference;
        }

        public void start() {
            this.bXS = (EGL10) EGLContext.getEGL();
            this.bXT = this.bXS.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bXT == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bXS.eglInitialize(this.bXT, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bXR.get();
            if (aVar != null) {
                this.bXV = aVar.bXI.chooseConfig(this.bXS, this.bXT);
                try {
                    this.bXW = aVar.bXJ.createContext(this.bXS, this.bXT, this.bXV);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bXV = null;
                this.bXW = null;
            }
            if (this.bXW == null || this.bXW == EGL10.EGL_NO_CONTEXT) {
                this.bXW = null;
                jI("createContext");
            }
            this.bXU = null;
        }

        public boolean aaU() {
            if (this.bXS == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bXT == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bXV == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aaY();
            a aVar = this.bXR.get();
            if (aVar != null) {
                this.bXU = aVar.bXK.createWindowSurface(this.bXS, this.bXT, this.bXV, aVar.getSurfaceTexture());
            } else {
                this.bXU = null;
            }
            if (this.bXU == null || this.bXU == EGL10.EGL_NO_SURFACE) {
                if (this.bXS.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bXS.eglMakeCurrent(this.bXT, this.bXU, this.bXU, this.bXW)) {
                f("EGLHelper", "eglMakeCurrent", this.bXS.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aaV() {
            l lVar;
            GL gl = this.bXW.getGL();
            a aVar = this.bXR.get();
            if (aVar != null) {
                if (aVar.bXL != null) {
                    gl = aVar.bXL.wrap(gl);
                }
                if ((aVar.bXM & 3) != 0) {
                    int i = 0;
                    if ((aVar.bXM & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bXM & 2) == 0) {
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

        public int aaW() {
            if (this.bXS.eglSwapBuffers(this.bXT, this.bXU)) {
                return 12288;
            }
            return this.bXS.eglGetError();
        }

        public void aaX() {
            aaY();
        }

        private void aaY() {
            if (this.bXU != null && this.bXU != EGL10.EGL_NO_SURFACE) {
                this.bXS.eglMakeCurrent(this.bXT, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bXR.get();
                if (aVar != null) {
                    aVar.bXK.destroySurface(this.bXS, this.bXT, this.bXU);
                }
                this.bXU = null;
            }
        }

        public void finish() {
            if (this.bXW != null) {
                a aVar = this.bXR.get();
                if (aVar != null) {
                    try {
                        aVar.bXJ.destroyContext(this.bXS, this.bXT, this.bXW);
                    } catch (Exception e) {
                    }
                }
                this.bXW = null;
            }
            if (this.bXT != null) {
                this.bXS.eglTerminate(this.bXT);
                this.bXT = null;
            }
        }

        private void jI(String str) {
            O(str, this.bXS.eglGetError());
        }

        public static void O(String str, int i) {
            throw new RuntimeException(P(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, P(str2, i));
        }

        public static String P(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> bXR;
        private boolean bXX;
        private boolean bXY;
        private boolean bXZ;
        private boolean bYa;
        private boolean bYb;
        private boolean bYc;
        private boolean bYd;
        private boolean bYe;
        private boolean bYf;
        private boolean bYg;
        private boolean bYh;
        private boolean bYk;
        private h bYn;
        private ArrayList<Runnable> bYl = new ArrayList<>();
        private boolean bYm = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bYj = true;
        private int bYi = 1;

        i(WeakReference<a> weakReference) {
            this.bXR = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    abb();
                    a.bXE.a(this);
                } catch (Exception e) {
                    af.vb().az(false);
                    a.bXE.a(this);
                }
            } catch (Throwable th) {
                a.bXE.a(this);
                throw th;
            }
        }

        private void aaZ() {
            if (this.bYf) {
                this.bYf = false;
                this.bYn.aaX();
            }
        }

        private void aba() {
            if (this.bYe) {
                this.bYn.finish();
                this.bYe = false;
                a.bXE.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void abb() throws InterruptedException {
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
            this.bYn = new h(this.bXR);
            this.bYe = false;
            this.bYf = false;
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
                    synchronized (a.bXE) {
                        while (!this.bXX) {
                            if (this.bYl.isEmpty()) {
                                if (this.bYa != this.bXZ) {
                                    boolean z23 = this.bXZ;
                                    this.bYa = this.bXZ;
                                    a.bXE.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bYh) {
                                    aaZ();
                                    aba();
                                    this.bYh = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aaZ();
                                    aba();
                                    z19 = false;
                                }
                                if (z9 && this.bYf) {
                                    aaZ();
                                }
                                if (z9 && this.bYe) {
                                    a aVar = this.bXR.get();
                                    if (!(aVar == null ? false : aVar.bXO) || a.bXE.abh()) {
                                        aba();
                                    }
                                }
                                if (z9 && a.bXE.abi()) {
                                    this.bYn.finish();
                                }
                                if (!this.bYb && !this.bYd) {
                                    if (this.bYf) {
                                        aaZ();
                                    }
                                    this.bYd = true;
                                    this.bYc = false;
                                    a.bXE.notifyAll();
                                }
                                if (this.bYb && this.bYd) {
                                    this.bYd = false;
                                    a.bXE.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bYk = true;
                                    a.bXE.notifyAll();
                                }
                                if (abd()) {
                                    if (!this.bYe) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bXE.b(this)) {
                                            try {
                                                this.bYn.start();
                                                this.bYe = true;
                                                z15 = true;
                                                a.bXE.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bXE.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bYe || this.bYf) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bYf = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bYf) {
                                        if (this.bYm) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bYm = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bYj = false;
                                        a.bXE.notifyAll();
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
                                a.bXE.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bYl.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bXE) {
                            aaZ();
                            aba();
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
                        } else if (this.bYn.aaU()) {
                            synchronized (a.bXE) {
                                this.bYg = true;
                                a.bXE.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bXE) {
                                this.bYg = true;
                                this.bYc = true;
                                a.bXE.notifyAll();
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
                            GL10 gl103 = (GL10) this.bYn.aaV();
                            a.bXE.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bXR.get();
                            if (aVar2 != null) {
                                aVar2.bXH.onSurfaceCreated(gl10, this.bYn.bXV);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bXR.get();
                            if (aVar3 != null) {
                                aVar3.bXH.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bXR.get();
                        if (aVar4 != null) {
                            aVar4.bXH.onDrawFrame(gl10);
                        }
                        int aaW = this.bYn.aaW();
                        switch (aaW) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", aaW);
                                synchronized (a.bXE) {
                                    this.bYc = true;
                                    a.bXE.notifyAll();
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
                    synchronized (a.bXE) {
                        aaZ();
                        aba();
                        throw th;
                    }
                }
            }
        }

        public boolean abc() {
            return this.bYe && this.bYf && abd();
        }

        private boolean abd() {
            return !this.bYa && this.bYb && !this.bYc && this.mWidth > 0 && this.mHeight > 0 && (this.bYj || this.bYi == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bXE) {
                    this.bYi = i;
                    a.bXE.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bXE) {
                i = this.bYi;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bXE) {
                this.bYj = true;
                a.bXE.notifyAll();
            }
        }

        public void abe() {
            synchronized (a.bXE) {
                this.bYb = true;
                this.bYg = false;
                a.bXE.notifyAll();
                while (this.bYd && !this.bYg && !this.bXY) {
                    try {
                        a.bXE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bXE) {
                this.bYb = false;
                a.bXE.notifyAll();
                while (!this.bYd && !this.bXY) {
                    try {
                        a.bXE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bXE) {
                this.bXZ = true;
                a.bXE.notifyAll();
                while (!this.bXY && !this.bYa) {
                    try {
                        a.bXE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bXE) {
                this.bXZ = false;
                this.bYj = true;
                this.bYk = false;
                a.bXE.notifyAll();
                while (!this.bXY && this.bYa && !this.bYk) {
                    try {
                        a.bXE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (a.bXE) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bYm = true;
                this.bYj = true;
                this.bYk = false;
                a.bXE.notifyAll();
                while (!this.bXY && !this.bYa && !this.bYk && abc()) {
                    try {
                        a.bXE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abf() {
            synchronized (a.bXE) {
                this.bXX = true;
                a.bXE.notifyAll();
                while (!this.bXY) {
                    try {
                        a.bXE.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abg() {
            this.bYh = true;
            a.bXE.notifyAll();
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

    private void aaS() {
        if (this.bXG != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bYo;
        private int bYp;
        private boolean bYq;
        private boolean bYr;
        private boolean bYs;
        private i bYt;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bXY = true;
            if (this.bYt == iVar) {
                this.bYt = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bYt == iVar || this.bYt == null) {
                this.bYt = iVar;
                notifyAll();
                return true;
            }
            abj();
            if (this.bYr) {
                return true;
            }
            if (this.bYt != null) {
                this.bYt.abg();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bYt == iVar) {
                this.bYt = null;
            }
            notifyAll();
        }

        public synchronized boolean abh() {
            return this.bYs;
        }

        public synchronized boolean abi() {
            abj();
            return !this.bYr;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bYq) {
                    abj();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bYp < 131072) {
                        this.bYr = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bYs = this.bYr ? false : true;
                    this.bYq = true;
                }
            }
        }

        private void abj() {
            if (!this.bYo) {
                this.bYr = true;
                this.bYo = true;
            }
        }
    }
}
