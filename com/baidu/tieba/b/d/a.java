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
    private static final j bXI = new j();
    private final WeakReference<a> bXJ;
    private i bXK;
    private c.m bXL;
    private e bXM;
    private f bXN;
    private g bXO;
    private k bXP;
    private int bXQ;
    private int bXR;
    private boolean bXS;
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
        this.bXJ = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bXK != null) {
                this.bXK.abf();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bXP = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bXQ = i2;
    }

    public int getDebugFlags() {
        return this.bXQ;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bXS = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bXS;
    }

    public void setRenderer(c.m mVar) {
        aaS();
        if (this.bXM == null) {
            this.bXM = new m(true);
        }
        if (this.bXN == null) {
            this.bXN = new c();
        }
        if (this.bXO == null) {
            this.bXO = new d();
        }
        this.bXL = mVar;
        this.bXK = new i(this.bXJ);
        this.bXK.start();
    }

    public void setEGLContextFactory(f fVar) {
        aaS();
        this.bXN = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aaS();
        this.bXO = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aaS();
        this.bXM = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        aaS();
        this.bXR = i2;
    }

    public void setRenderMode(int i2) {
        this.bXK.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bXK.getRenderMode();
    }

    public void requestRender() {
        this.bXK.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bXK.abe();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bXK.ak(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bXK.ak(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bXK.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bXK.onPause();
    }

    public void onResume() {
        this.bXK.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bXL != null) {
            int renderMode = this.bXK != null ? this.bXK.getRenderMode() : 1;
            this.bXK = new i(this.bXJ);
            if (renderMode != 1) {
                this.bXK.setRenderMode(renderMode);
            }
            this.bXK.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bXK != null) {
            this.bXK.abf();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bXR, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bXR == 0) {
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
    private abstract class AbstractC0090a implements e {
        protected int[] bXT;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0090a(int[] iArr) {
            this.bXT = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXT, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXT, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (a.this.bXR == 2) {
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
    private class b extends AbstractC0090a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0090a
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
        private WeakReference<a> bXV;
        EGL10 bXW;
        EGLDisplay bXX;
        EGLSurface bXY;
        EGLConfig bXZ;
        EGLContext bYa;

        public h(WeakReference<a> weakReference) {
            this.bXV = weakReference;
        }

        public void start() {
            this.bXW = (EGL10) EGLContext.getEGL();
            this.bXX = this.bXW.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bXX == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bXW.eglInitialize(this.bXX, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bXV.get();
            if (aVar != null) {
                this.bXZ = aVar.bXM.chooseConfig(this.bXW, this.bXX);
                try {
                    this.bYa = aVar.bXN.createContext(this.bXW, this.bXX, this.bXZ);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bXZ = null;
                this.bYa = null;
            }
            if (this.bYa == null || this.bYa == EGL10.EGL_NO_CONTEXT) {
                this.bYa = null;
                jI("createContext");
            }
            this.bXY = null;
        }

        public boolean aaU() {
            if (this.bXW == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bXX == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bXZ == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aaY();
            a aVar = this.bXV.get();
            if (aVar != null) {
                this.bXY = aVar.bXO.createWindowSurface(this.bXW, this.bXX, this.bXZ, aVar.getSurfaceTexture());
            } else {
                this.bXY = null;
            }
            if (this.bXY == null || this.bXY == EGL10.EGL_NO_SURFACE) {
                if (this.bXW.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bXW.eglMakeCurrent(this.bXX, this.bXY, this.bXY, this.bYa)) {
                f("EGLHelper", "eglMakeCurrent", this.bXW.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aaV() {
            l lVar;
            GL gl = this.bYa.getGL();
            a aVar = this.bXV.get();
            if (aVar != null) {
                if (aVar.bXP != null) {
                    gl = aVar.bXP.wrap(gl);
                }
                if ((aVar.bXQ & 3) != 0) {
                    int i = 0;
                    if ((aVar.bXQ & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bXQ & 2) == 0) {
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
            if (this.bXW.eglSwapBuffers(this.bXX, this.bXY)) {
                return 12288;
            }
            return this.bXW.eglGetError();
        }

        public void aaX() {
            aaY();
        }

        private void aaY() {
            if (this.bXY != null && this.bXY != EGL10.EGL_NO_SURFACE) {
                this.bXW.eglMakeCurrent(this.bXX, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bXV.get();
                if (aVar != null) {
                    aVar.bXO.destroySurface(this.bXW, this.bXX, this.bXY);
                }
                this.bXY = null;
            }
        }

        public void finish() {
            if (this.bYa != null) {
                a aVar = this.bXV.get();
                if (aVar != null) {
                    try {
                        aVar.bXN.destroyContext(this.bXW, this.bXX, this.bYa);
                    } catch (Exception e) {
                    }
                }
                this.bYa = null;
            }
            if (this.bXX != null) {
                this.bXW.eglTerminate(this.bXX);
                this.bXX = null;
            }
        }

        private void jI(String str) {
            O(str, this.bXW.eglGetError());
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
        private WeakReference<a> bXV;
        private boolean bYb;
        private boolean bYc;
        private boolean bYd;
        private boolean bYe;
        private boolean bYf;
        private boolean bYg;
        private boolean bYh;
        private boolean bYi;
        private boolean bYj;
        private boolean bYk;
        private boolean bYl;
        private boolean bYo;
        private h bYr;
        private ArrayList<Runnable> bYp = new ArrayList<>();
        private boolean bYq = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bYn = true;
        private int bYm = 1;

        i(WeakReference<a> weakReference) {
            this.bXV = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    abb();
                    a.bXI.a(this);
                } catch (Exception e) {
                    af.vb().az(false);
                    a.bXI.a(this);
                }
            } catch (Throwable th) {
                a.bXI.a(this);
                throw th;
            }
        }

        private void aaZ() {
            if (this.bYj) {
                this.bYj = false;
                this.bYr.aaX();
            }
        }

        private void aba() {
            if (this.bYi) {
                this.bYr.finish();
                this.bYi = false;
                a.bXI.c(this);
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
            this.bYr = new h(this.bXV);
            this.bYi = false;
            this.bYj = false;
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
                    synchronized (a.bXI) {
                        while (!this.bYb) {
                            if (this.bYp.isEmpty()) {
                                if (this.bYe != this.bYd) {
                                    boolean z23 = this.bYd;
                                    this.bYe = this.bYd;
                                    a.bXI.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bYl) {
                                    aaZ();
                                    aba();
                                    this.bYl = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aaZ();
                                    aba();
                                    z19 = false;
                                }
                                if (z9 && this.bYj) {
                                    aaZ();
                                }
                                if (z9 && this.bYi) {
                                    a aVar = this.bXV.get();
                                    if (!(aVar == null ? false : aVar.bXS) || a.bXI.abh()) {
                                        aba();
                                    }
                                }
                                if (z9 && a.bXI.abi()) {
                                    this.bYr.finish();
                                }
                                if (!this.bYf && !this.bYh) {
                                    if (this.bYj) {
                                        aaZ();
                                    }
                                    this.bYh = true;
                                    this.bYg = false;
                                    a.bXI.notifyAll();
                                }
                                if (this.bYf && this.bYh) {
                                    this.bYh = false;
                                    a.bXI.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bYo = true;
                                    a.bXI.notifyAll();
                                }
                                if (abd()) {
                                    if (!this.bYi) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bXI.b(this)) {
                                            try {
                                                this.bYr.start();
                                                this.bYi = true;
                                                z15 = true;
                                                a.bXI.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bXI.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bYi || this.bYj) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bYj = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bYj) {
                                        if (this.bYq) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bYq = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bYn = false;
                                        a.bXI.notifyAll();
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
                                a.bXI.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bYp.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bXI) {
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
                        } else if (this.bYr.aaU()) {
                            synchronized (a.bXI) {
                                this.bYk = true;
                                a.bXI.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bXI) {
                                this.bYk = true;
                                this.bYg = true;
                                a.bXI.notifyAll();
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
                            GL10 gl103 = (GL10) this.bYr.aaV();
                            a.bXI.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bXV.get();
                            if (aVar2 != null) {
                                aVar2.bXL.onSurfaceCreated(gl10, this.bYr.bXZ);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bXV.get();
                            if (aVar3 != null) {
                                aVar3.bXL.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bXV.get();
                        if (aVar4 != null) {
                            aVar4.bXL.onDrawFrame(gl10);
                        }
                        int aaW = this.bYr.aaW();
                        switch (aaW) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", aaW);
                                synchronized (a.bXI) {
                                    this.bYg = true;
                                    a.bXI.notifyAll();
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
                    synchronized (a.bXI) {
                        aaZ();
                        aba();
                        throw th;
                    }
                }
            }
        }

        public boolean abc() {
            return this.bYi && this.bYj && abd();
        }

        private boolean abd() {
            return !this.bYe && this.bYf && !this.bYg && this.mWidth > 0 && this.mHeight > 0 && (this.bYn || this.bYm == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bXI) {
                    this.bYm = i;
                    a.bXI.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bXI) {
                i = this.bYm;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bXI) {
                this.bYn = true;
                a.bXI.notifyAll();
            }
        }

        public void abe() {
            synchronized (a.bXI) {
                this.bYf = true;
                this.bYk = false;
                a.bXI.notifyAll();
                while (this.bYh && !this.bYk && !this.bYc) {
                    try {
                        a.bXI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bXI) {
                this.bYf = false;
                a.bXI.notifyAll();
                while (!this.bYh && !this.bYc) {
                    try {
                        a.bXI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bXI) {
                this.bYd = true;
                a.bXI.notifyAll();
                while (!this.bYc && !this.bYe) {
                    try {
                        a.bXI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bXI) {
                this.bYd = false;
                this.bYn = true;
                this.bYo = false;
                a.bXI.notifyAll();
                while (!this.bYc && this.bYe && !this.bYo) {
                    try {
                        a.bXI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ak(int i, int i2) {
            synchronized (a.bXI) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bYq = true;
                this.bYn = true;
                this.bYo = false;
                a.bXI.notifyAll();
                while (!this.bYc && !this.bYe && !this.bYo && abc()) {
                    try {
                        a.bXI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abf() {
            synchronized (a.bXI) {
                this.bYb = true;
                a.bXI.notifyAll();
                while (!this.bYc) {
                    try {
                        a.bXI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abg() {
            this.bYl = true;
            a.bXI.notifyAll();
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
        if (this.bXK != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bYs;
        private int bYt;
        private boolean bYu;
        private boolean bYv;
        private boolean bYw;
        private i bYx;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bYc = true;
            if (this.bYx == iVar) {
                this.bYx = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bYx == iVar || this.bYx == null) {
                this.bYx = iVar;
                notifyAll();
                return true;
            }
            abj();
            if (this.bYv) {
                return true;
            }
            if (this.bYx != null) {
                this.bYx.abg();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bYx == iVar) {
                this.bYx = null;
            }
            notifyAll();
        }

        public synchronized boolean abh() {
            return this.bYw;
        }

        public synchronized boolean abi() {
            abj();
            return !this.bYv;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bYu) {
                    abj();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bYt < 131072) {
                        this.bYv = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bYw = this.bYv ? false : true;
                    this.bYu = true;
                }
            }
        }

        private void abj() {
            if (!this.bYs) {
                this.bYv = true;
                this.bYs = true;
            }
        }
    }
}
