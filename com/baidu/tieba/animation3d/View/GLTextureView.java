package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tieba.animation3d.View.TBGLSurfaceView;
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
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j cuH = new j();
    private final WeakReference<GLTextureView> cuI;
    private i cuJ;
    private TBGLSurfaceView.m cuK;
    private e cuL;
    private f cuM;
    private g cuN;
    private k cuO;
    private int cuP;
    private int cuQ;
    private boolean cuR;
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

    public GLTextureView(Context context) {
        super(context);
        this.cuI = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cuI = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cuJ != null) {
                this.cuJ.aip();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cuO = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cuP = i2;
    }

    public int getDebugFlags() {
        return this.cuP;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cuR = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cuR;
    }

    public void setRenderer(TBGLSurfaceView.m mVar) {
        aic();
        if (this.cuL == null) {
            this.cuL = new m(true);
        }
        if (this.cuM == null) {
            this.cuM = new c();
        }
        if (this.cuN == null) {
            this.cuN = new d();
        }
        this.cuK = mVar;
        this.cuJ = new i(this.cuI);
        this.cuJ.start();
    }

    public void setEGLContextFactory(f fVar) {
        aic();
        this.cuM = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aic();
        this.cuN = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aic();
        this.cuL = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        aic();
        this.cuQ = i2;
    }

    public void setRenderMode(int i2) {
        this.cuJ.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cuJ.getRenderMode();
    }

    public void requestRender() {
        this.cuJ.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cuJ.aio();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cuJ.an(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cuJ.an(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cuJ.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cuJ.onPause();
    }

    public void onResume() {
        this.cuJ.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cuK != null) {
            int renderMode = this.cuJ != null ? this.cuJ.getRenderMode() : 1;
            this.cuJ = new i(this.cuI);
            if (renderMode != 1) {
                this.cuJ.setRenderMode(renderMode);
            }
            this.cuJ.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cuJ != null) {
            this.cuJ.aip();
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

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.cuQ, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.cuQ == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
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

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes.dex */
    private abstract class a implements e {
        protected int[] cuS;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cuS = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cuS, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cuS, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (GLTextureView.this.cuQ == 2) {
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

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.a
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
        private WeakReference<GLTextureView> cuU;
        EGL10 cuV;
        EGLDisplay cuW;
        EGLSurface cuX;
        EGLConfig cuY;
        EGLContext cuZ;

        public h(WeakReference<GLTextureView> weakReference) {
            this.cuU = weakReference;
        }

        public void start() {
            this.cuV = (EGL10) EGLContext.getEGL();
            this.cuW = this.cuV.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cuW == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cuV.eglInitialize(this.cuW, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.cuU.get();
            if (gLTextureView != null) {
                this.cuY = gLTextureView.cuL.chooseConfig(this.cuV, this.cuW);
                try {
                    this.cuZ = gLTextureView.cuM.createContext(this.cuV, this.cuW, this.cuY);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.cuY = null;
                this.cuZ = null;
            }
            if (this.cuZ == null || this.cuZ == EGL10.EGL_NO_CONTEXT) {
                this.cuZ = null;
                kS("createContext");
            }
            this.cuX = null;
        }

        public boolean aie() {
            if (this.cuV == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cuW == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cuY == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aii();
            GLTextureView gLTextureView = this.cuU.get();
            if (gLTextureView != null) {
                this.cuX = gLTextureView.cuN.createWindowSurface(this.cuV, this.cuW, this.cuY, gLTextureView.getSurfaceTexture());
            } else {
                this.cuX = null;
            }
            if (this.cuX == null || this.cuX == EGL10.EGL_NO_SURFACE) {
                if (this.cuV.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cuV.eglMakeCurrent(this.cuW, this.cuX, this.cuX, this.cuZ)) {
                g("EGLHelper", "eglMakeCurrent", this.cuV.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aif() {
            l lVar;
            GL gl = this.cuZ.getGL();
            GLTextureView gLTextureView = this.cuU.get();
            if (gLTextureView != null) {
                if (gLTextureView.cuO != null) {
                    gl = gLTextureView.cuO.wrap(gl);
                }
                if ((gLTextureView.cuP & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.cuP & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.cuP & 2) == 0) {
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

        public int aig() {
            if (this.cuV.eglSwapBuffers(this.cuW, this.cuX)) {
                return 12288;
            }
            return this.cuV.eglGetError();
        }

        public void aih() {
            aii();
        }

        private void aii() {
            if (this.cuX != null && this.cuX != EGL10.EGL_NO_SURFACE) {
                this.cuV.eglMakeCurrent(this.cuW, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.cuU.get();
                if (gLTextureView != null) {
                    gLTextureView.cuN.destroySurface(this.cuV, this.cuW, this.cuX);
                }
                this.cuX = null;
            }
        }

        public void finish() {
            if (this.cuZ != null) {
                GLTextureView gLTextureView = this.cuU.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.cuM.destroyContext(this.cuV, this.cuW, this.cuZ);
                    } catch (Exception e) {
                    }
                }
                this.cuZ = null;
            }
            if (this.cuW != null) {
                this.cuV.eglTerminate(this.cuW);
                this.cuW = null;
            }
        }

        private void kS(String str) {
            M(str, this.cuV.eglGetError());
        }

        public static void M(String str, int i) {
            throw new RuntimeException(N(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, N(str2, i));
        }

        public static String N(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<GLTextureView> cuU;
        private boolean cva;
        private boolean cvb;
        private boolean cvc;
        private boolean cvd;
        private boolean cve;
        private boolean cvf;
        private boolean cvg;
        private boolean cvh;
        private boolean cvi;
        private boolean cvj;
        private boolean cvm;
        private h cvp;
        private boolean mPaused;
        private ArrayList<Runnable> cvn = new ArrayList<>();
        private boolean cvo = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cvl = true;
        private int cvk = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.cuU = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ail();
                    GLTextureView.cuH.a(this);
                } catch (Exception e) {
                    ag.za().aI(false);
                    GLTextureView.cuH.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.cuH.a(this);
                throw th;
            }
        }

        private void aij() {
            if (this.cvh) {
                this.cvh = false;
                this.cvp.aih();
            }
        }

        private void aik() {
            if (this.cvg) {
                this.cvp.finish();
                this.cvg = false;
                GLTextureView.cuH.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void ail() throws InterruptedException {
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
            this.cvp = new h(this.cuU);
            this.cvg = false;
            this.cvh = false;
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
                    synchronized (GLTextureView.cuH) {
                        while (!this.cva) {
                            if (this.cvn.isEmpty()) {
                                if (this.mPaused != this.cvc) {
                                    boolean z23 = this.cvc;
                                    this.mPaused = this.cvc;
                                    GLTextureView.cuH.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cvj) {
                                    aij();
                                    aik();
                                    this.cvj = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aij();
                                    aik();
                                    z19 = false;
                                }
                                if (z9 && this.cvh) {
                                    aij();
                                }
                                if (z9 && this.cvg) {
                                    GLTextureView gLTextureView = this.cuU.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.cuR) || GLTextureView.cuH.air()) {
                                        aik();
                                    }
                                }
                                if (z9 && GLTextureView.cuH.ais()) {
                                    this.cvp.finish();
                                }
                                if (!this.cvd && !this.cvf) {
                                    if (this.cvh) {
                                        aij();
                                    }
                                    this.cvf = true;
                                    this.cve = false;
                                    GLTextureView.cuH.notifyAll();
                                }
                                if (this.cvd && this.cvf) {
                                    this.cvf = false;
                                    GLTextureView.cuH.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cvm = true;
                                    GLTextureView.cuH.notifyAll();
                                }
                                if (ain()) {
                                    if (!this.cvg) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.cuH.b(this)) {
                                            try {
                                                this.cvp.start();
                                                this.cvg = true;
                                                z15 = true;
                                                GLTextureView.cuH.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.cuH.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cvg || this.cvh) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cvh = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cvh) {
                                        if (this.cvo) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cvo = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cvl = false;
                                        GLTextureView.cuH.notifyAll();
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
                                GLTextureView.cuH.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cvn.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (GLTextureView.cuH) {
                            aij();
                            aik();
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
                        } else if (this.cvp.aie()) {
                            synchronized (GLTextureView.cuH) {
                                this.cvi = true;
                                GLTextureView.cuH.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.cuH) {
                                this.cvi = true;
                                this.cve = true;
                                GLTextureView.cuH.notifyAll();
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
                            GL10 gl103 = (GL10) this.cvp.aif();
                            GLTextureView.cuH.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.cuU.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.cuK.onSurfaceCreated(gl10, this.cvp.cuY);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.cuU.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.cuK.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.cuU.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.cuK.onDrawFrame(gl10);
                        }
                        int aig = this.cvp.aig();
                        switch (aig) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", aig);
                                synchronized (GLTextureView.cuH) {
                                    this.cve = true;
                                    GLTextureView.cuH.notifyAll();
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
                    synchronized (GLTextureView.cuH) {
                        aij();
                        aik();
                        throw th;
                    }
                }
            }
        }

        public boolean aim() {
            return this.cvg && this.cvh && ain();
        }

        private boolean ain() {
            return !this.mPaused && this.cvd && !this.cve && this.mWidth > 0 && this.mHeight > 0 && (this.cvl || this.cvk == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (GLTextureView.cuH) {
                    this.cvk = i;
                    GLTextureView.cuH.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.cuH) {
                i = this.cvk;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.cuH) {
                this.cvl = true;
                GLTextureView.cuH.notifyAll();
            }
        }

        public void aio() {
            synchronized (GLTextureView.cuH) {
                this.cvd = true;
                this.cvi = false;
                GLTextureView.cuH.notifyAll();
                while (this.cvf && !this.cvi && !this.cvb) {
                    try {
                        GLTextureView.cuH.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLTextureView.cuH) {
                this.cvd = false;
                GLTextureView.cuH.notifyAll();
                while (!this.cvf && !this.cvb) {
                    try {
                        GLTextureView.cuH.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.cuH) {
                this.cvc = true;
                GLTextureView.cuH.notifyAll();
                while (!this.cvb && !this.mPaused) {
                    try {
                        GLTextureView.cuH.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.cuH) {
                this.cvc = false;
                this.cvl = true;
                this.cvm = false;
                GLTextureView.cuH.notifyAll();
                while (!this.cvb && this.mPaused && !this.cvm) {
                    try {
                        GLTextureView.cuH.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void an(int i, int i2) {
            synchronized (GLTextureView.cuH) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cvo = true;
                this.cvl = true;
                this.cvm = false;
                GLTextureView.cuH.notifyAll();
                while (!this.cvb && !this.mPaused && !this.cvm && aim()) {
                    try {
                        GLTextureView.cuH.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aip() {
            synchronized (GLTextureView.cuH) {
                this.cva = true;
                GLTextureView.cuH.notifyAll();
                while (!this.cvb) {
                    try {
                        GLTextureView.cuH.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiq() {
            this.cvj = true;
            GLTextureView.cuH.notifyAll();
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

    private void aic() {
        if (this.cuJ != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cvq;
        private int cvr;
        private boolean cvs;
        private boolean cvt;
        private boolean cvu;
        private i cvv;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cvb = true;
            if (this.cvv == iVar) {
                this.cvv = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cvv == iVar || this.cvv == null) {
                this.cvv = iVar;
                notifyAll();
                return true;
            }
            ait();
            if (this.cvt) {
                return true;
            }
            if (this.cvv != null) {
                this.cvv.aiq();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cvv == iVar) {
                this.cvv = null;
            }
            notifyAll();
        }

        public synchronized boolean air() {
            return this.cvu;
        }

        public synchronized boolean ais() {
            ait();
            return !this.cvt;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cvs) {
                    ait();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cvr < 131072) {
                        this.cvt = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cvu = this.cvt ? false : true;
                    this.cvs = true;
                }
            }
        }

        private void ait() {
            if (!this.cvq) {
                this.cvt = true;
                this.cvq = true;
            }
        }
    }
}
