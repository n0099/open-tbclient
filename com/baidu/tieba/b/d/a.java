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
    private static final j aWT = new j(null);
    private final WeakReference<a> aWU;
    private i aWV;
    private GLSurfaceView.Renderer aWW;
    private e aWX;
    private f aWY;
    private g aWZ;
    private k aXa;
    private int aXb;
    private int aXc;
    private boolean aXd;
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
        this.aWU = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aWV != null) {
                this.aWV.Nw();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.aXa = kVar;
    }

    public void setDebugFlags(int i2) {
        this.aXb = i2;
    }

    public int getDebugFlags() {
        return this.aXb;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.aXd = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.aXd;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Ni();
        if (this.aWX == null) {
            this.aWX = new m(true);
        }
        if (this.aWY == null) {
            this.aWY = new c(this, null);
        }
        if (this.aWZ == null) {
            this.aWZ = new d(null);
        }
        this.aWW = renderer;
        this.aWV = new i(this.aWU);
        this.aWV.start();
    }

    public void setEGLContextFactory(f fVar) {
        Ni();
        this.aWY = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Ni();
        this.aWZ = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Ni();
        this.aWX = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Ni();
        this.aXc = i2;
    }

    public void setRenderMode(int i2) {
        this.aWV.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.aWV.getRenderMode();
    }

    public void requestRender() {
        this.aWV.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aWV.Nu();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aWV.Q(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.aWV.Q(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.aWV.Nv();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.aWV.onPause();
    }

    public void onResume() {
        this.aWV.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.aWW != null) {
            int renderMode = this.aWV != null ? this.aWV.getRenderMode() : 1;
            this.aWV = new i(this.aWU);
            if (renderMode != 1) {
                this.aWV.setRenderMode(renderMode);
            }
            this.aWV.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.aWV != null) {
            this.aWV.Nw();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.aXc, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.aXc == 0) {
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
    private abstract class AbstractC0055a implements e {
        protected int[] aXe;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0055a(int[] iArr) {
            this.aXe = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aXe, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aXe, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.aXc == 2) {
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
    private class b extends AbstractC0055a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0055a
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
        private WeakReference<a> aXg;
        EGL10 aXh;
        EGLDisplay aXi;
        EGLSurface aXj;
        EGLConfig aXk;
        EGLContext aXl;

        public h(WeakReference<a> weakReference) {
            this.aXg = weakReference;
        }

        public void start() {
            this.aXh = (EGL10) EGLContext.getEGL();
            this.aXi = this.aXh.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.aXi == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.aXh.eglInitialize(this.aXi, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.aXg.get();
            if (aVar == null) {
                this.aXk = null;
                this.aXl = null;
            } else {
                this.aXk = aVar.aWX.chooseConfig(this.aXh, this.aXi);
                try {
                    this.aXl = aVar.aWY.createContext(this.aXh, this.aXi, this.aXk);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.aXl == null || this.aXl == EGL10.EGL_NO_CONTEXT) {
                this.aXl = null;
                hK("createContext");
            }
            this.aXj = null;
        }

        public boolean Nk() {
            if (this.aXh == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.aXi == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aXk == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            No();
            a aVar = this.aXg.get();
            if (aVar != null) {
                this.aXj = aVar.aWZ.createWindowSurface(this.aXh, this.aXi, this.aXk, aVar.getSurfaceTexture());
            } else {
                this.aXj = null;
            }
            if (this.aXj == null || this.aXj == EGL10.EGL_NO_SURFACE) {
                if (this.aXh.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.aXh.eglMakeCurrent(this.aXi, this.aXj, this.aXj, this.aXl)) {
                f("EGLHelper", "eglMakeCurrent", this.aXh.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Nl() {
            l lVar;
            GL gl = this.aXl.getGL();
            a aVar = this.aXg.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.aXa != null) {
                gl = aVar.aXa.wrap(gl);
            }
            if ((aVar.aXb & 3) != 0) {
                int i = 0;
                if ((aVar.aXb & 1) != 0) {
                    i = 1;
                }
                if ((aVar.aXb & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Nm() {
            if (this.aXh.eglSwapBuffers(this.aXi, this.aXj)) {
                return 12288;
            }
            return this.aXh.eglGetError();
        }

        public void Nn() {
            No();
        }

        private void No() {
            if (this.aXj != null && this.aXj != EGL10.EGL_NO_SURFACE) {
                this.aXh.eglMakeCurrent(this.aXi, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.aXg.get();
                if (aVar != null) {
                    aVar.aWZ.destroySurface(this.aXh, this.aXi, this.aXj);
                }
                this.aXj = null;
            }
        }

        public void finish() {
            if (this.aXl != null) {
                a aVar = this.aXg.get();
                if (aVar != null) {
                    try {
                        aVar.aWY.destroyContext(this.aXh, this.aXi, this.aXl);
                    } catch (Exception e) {
                    }
                }
                this.aXl = null;
            }
            if (this.aXi != null) {
                this.aXh.eglTerminate(this.aXi);
                this.aXi = null;
            }
        }

        private void hK(String str) {
            J(str, this.aXh.eglGetError());
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
        private h aXC;
        private WeakReference<a> aXg;
        private boolean aXm;
        private boolean aXn;
        private boolean aXo;
        private boolean aXp;
        private boolean aXq;
        private boolean aXr;
        private boolean aXs;
        private boolean aXt;
        private boolean aXu;
        private boolean aXv;
        private boolean aXw;
        private boolean aXz;
        private ArrayList<Runnable> aXA = new ArrayList<>();
        private boolean aXB = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aXy = true;
        private int aXx = 1;

        i(WeakReference<a> weakReference) {
            this.aXg = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Nr();
                    a.aWT.a(this);
                } catch (Exception e) {
                    am.vh().aA(false);
                    a.aWT.a(this);
                }
            } catch (Throwable th) {
                a.aWT.a(this);
                throw th;
            }
        }

        private void Np() {
            if (this.aXu) {
                this.aXu = false;
                this.aXC.Nn();
            }
        }

        private void Nq() {
            if (this.aXt) {
                this.aXC.finish();
                this.aXt = false;
                a.aWT.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Nr() throws InterruptedException {
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
            this.aXC = new h(this.aXg);
            this.aXt = false;
            this.aXu = false;
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
                    synchronized (a.aWT) {
                        while (!this.aXm) {
                            if (this.aXA.isEmpty()) {
                                if (this.aXp != this.aXo) {
                                    boolean z23 = this.aXo;
                                    this.aXp = this.aXo;
                                    a.aWT.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.aXw) {
                                    Np();
                                    Nq();
                                    this.aXw = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Np();
                                    Nq();
                                    z20 = false;
                                }
                                if (z9 && this.aXu) {
                                    Np();
                                }
                                if (z9 && this.aXt) {
                                    a aVar = this.aXg.get();
                                    if (!(aVar == null ? false : aVar.aXd) || a.aWT.Ny()) {
                                        Nq();
                                    }
                                }
                                if (z9 && a.aWT.Nz()) {
                                    this.aXC.finish();
                                }
                                if (!this.aXq && !this.aXs) {
                                    if (this.aXu) {
                                        Np();
                                    }
                                    this.aXs = true;
                                    this.aXr = false;
                                    a.aWT.notifyAll();
                                }
                                if (this.aXq && this.aXs) {
                                    this.aXs = false;
                                    a.aWT.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.aXz = true;
                                    a.aWT.notifyAll();
                                }
                                if (Nt()) {
                                    if (!this.aXt) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.aWT.b(this)) {
                                            try {
                                                this.aXC.start();
                                                this.aXt = true;
                                                z15 = true;
                                                a.aWT.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.aWT.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.aXt || this.aXu) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.aXu = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.aXu) {
                                        if (this.aXB) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.aXB = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.aXy = false;
                                        a.aWT.notifyAll();
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
                                a.aWT.wait();
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
                                remove = this.aXA.remove(0);
                            }
                        }
                        synchronized (a.aWT) {
                            Np();
                            Nq();
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
                        } else if (this.aXC.Nk()) {
                            synchronized (a.aWT) {
                                this.aXv = true;
                                a.aWT.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.aWT) {
                                this.aXv = true;
                                this.aXr = true;
                                a.aWT.notifyAll();
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
                            GL10 gl103 = (GL10) this.aXC.Nl();
                            a.aWT.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.aXg.get();
                            if (aVar2 != null) {
                                aVar2.aWW.onSurfaceCreated(gl10, this.aXC.aXk);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.aXg.get();
                            if (aVar3 != null) {
                                aVar3.aWW.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.aXg.get();
                        if (aVar4 != null) {
                            aVar4.aWW.onDrawFrame(gl10);
                        }
                        int Nm = this.aXC.Nm();
                        switch (Nm) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Nm);
                                synchronized (a.aWT) {
                                    this.aXr = true;
                                    a.aWT.notifyAll();
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
                    synchronized (a.aWT) {
                        Np();
                        Nq();
                        throw th;
                    }
                }
            }
        }

        public boolean Ns() {
            return this.aXt && this.aXu && Nt();
        }

        private boolean Nt() {
            return !this.aXp && this.aXq && !this.aXr && this.mWidth > 0 && this.mHeight > 0 && (this.aXy || this.aXx == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.aWT) {
                this.aXx = i;
                a.aWT.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.aWT) {
                i = this.aXx;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.aWT) {
                this.aXy = true;
                a.aWT.notifyAll();
            }
        }

        public void Nu() {
            synchronized (a.aWT) {
                this.aXq = true;
                this.aXv = false;
                a.aWT.notifyAll();
                while (this.aXs && !this.aXv && !this.aXn) {
                    try {
                        a.aWT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Nv() {
            synchronized (a.aWT) {
                this.aXq = false;
                a.aWT.notifyAll();
                while (!this.aXs && !this.aXn) {
                    try {
                        a.aWT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.aWT) {
                this.aXo = true;
                a.aWT.notifyAll();
                while (!this.aXn && !this.aXp) {
                    try {
                        a.aWT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.aWT) {
                this.aXo = false;
                this.aXy = true;
                this.aXz = false;
                a.aWT.notifyAll();
                while (!this.aXn && this.aXp && !this.aXz) {
                    try {
                        a.aWT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Q(int i, int i2) {
            synchronized (a.aWT) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aXB = true;
                this.aXy = true;
                this.aXz = false;
                a.aWT.notifyAll();
                while (!this.aXn && !this.aXp && !this.aXz && Ns()) {
                    try {
                        a.aWT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Nw() {
            synchronized (a.aWT) {
                this.aXm = true;
                a.aWT.notifyAll();
                while (!this.aXn) {
                    try {
                        a.aWT.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Nx() {
            this.aXw = true;
            a.aWT.notifyAll();
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

    private void Ni() {
        if (this.aWV != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean aXD;
        private int aXE;
        private boolean aXF;
        private boolean aXG;
        private boolean aXH;
        private i aXI;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.aXn = true;
            if (this.aXI == iVar) {
                this.aXI = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.aXI == iVar || this.aXI == null) {
                this.aXI = iVar;
                notifyAll();
                return true;
            }
            NA();
            if (this.aXG) {
                return true;
            }
            if (this.aXI != null) {
                this.aXI.Nx();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.aXI == iVar) {
                this.aXI = null;
            }
            notifyAll();
        }

        public synchronized boolean Ny() {
            return this.aXH;
        }

        public synchronized boolean Nz() {
            NA();
            return !this.aXG;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.aXF) {
                    NA();
                    String glGetString = gl10.glGetString(7937);
                    if (this.aXE < 131072) {
                        this.aXG = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.aXH = this.aXG ? false : true;
                    this.aXF = true;
                }
            }
        }

        private void NA() {
            if (!this.aXD) {
                this.aXG = true;
                this.aXD = true;
            }
        }
    }
}
