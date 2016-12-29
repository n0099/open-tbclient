package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aj;
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
    private static final j aYP = new j(null);
    private final WeakReference<a> aYQ;
    private i aYR;
    private GLSurfaceView.Renderer aYS;
    private e aYT;
    private f aYU;
    private g aYV;
    private k aYW;
    private int aYX;
    private int aYY;
    private boolean aYZ;
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
        this.aYQ = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aYR != null) {
                this.aYR.NL();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.aYW = kVar;
    }

    public void setDebugFlags(int i2) {
        this.aYX = i2;
    }

    public int getDebugFlags() {
        return this.aYX;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.aYZ = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.aYZ;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Nx();
        if (this.aYT == null) {
            this.aYT = new m(true);
        }
        if (this.aYU == null) {
            this.aYU = new c(this, null);
        }
        if (this.aYV == null) {
            this.aYV = new d(null);
        }
        this.aYS = renderer;
        this.aYR = new i(this.aYQ);
        this.aYR.start();
    }

    public void setEGLContextFactory(f fVar) {
        Nx();
        this.aYU = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Nx();
        this.aYV = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Nx();
        this.aYT = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Nx();
        this.aYY = i2;
    }

    public void setRenderMode(int i2) {
        this.aYR.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.aYR.getRenderMode();
    }

    public void requestRender() {
        this.aYR.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aYR.NJ();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aYR.R(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.aYR.R(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.aYR.NK();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.aYR.onPause();
    }

    public void onResume() {
        this.aYR.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.aYS != null) {
            int renderMode = this.aYR != null ? this.aYR.getRenderMode() : 1;
            this.aYR = new i(this.aYQ);
            if (renderMode != 1) {
                this.aYR.setRenderMode(renderMode);
            }
            this.aYR.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.aYR != null) {
            this.aYR.NL();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.aYY, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.aYY == 0) {
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
        protected int[] aZa;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0055a(int[] iArr) {
            this.aZa = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aZa, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aZa, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.aYY == 2) {
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
        private WeakReference<a> aZc;
        EGL10 aZd;
        EGLDisplay aZe;
        EGLSurface aZf;
        EGLConfig aZg;
        EGLContext aZh;

        public h(WeakReference<a> weakReference) {
            this.aZc = weakReference;
        }

        public void start() {
            this.aZd = (EGL10) EGLContext.getEGL();
            this.aZe = this.aZd.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.aZe == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.aZd.eglInitialize(this.aZe, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.aZc.get();
            if (aVar == null) {
                this.aZg = null;
                this.aZh = null;
            } else {
                this.aZg = aVar.aYT.chooseConfig(this.aZd, this.aZe);
                try {
                    this.aZh = aVar.aYU.createContext(this.aZd, this.aZe, this.aZg);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.aZh == null || this.aZh == EGL10.EGL_NO_CONTEXT) {
                this.aZh = null;
                hI("createContext");
            }
            this.aZf = null;
        }

        public boolean Nz() {
            if (this.aZd == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.aZe == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aZg == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ND();
            a aVar = this.aZc.get();
            if (aVar != null) {
                this.aZf = aVar.aYV.createWindowSurface(this.aZd, this.aZe, this.aZg, aVar.getSurfaceTexture());
            } else {
                this.aZf = null;
            }
            if (this.aZf == null || this.aZf == EGL10.EGL_NO_SURFACE) {
                if (this.aZd.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.aZd.eglMakeCurrent(this.aZe, this.aZf, this.aZf, this.aZh)) {
                f("EGLHelper", "eglMakeCurrent", this.aZd.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL NA() {
            l lVar;
            GL gl = this.aZh.getGL();
            a aVar = this.aZc.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.aYW != null) {
                gl = aVar.aYW.wrap(gl);
            }
            if ((aVar.aYX & 3) != 0) {
                int i = 0;
                if ((aVar.aYX & 1) != 0) {
                    i = 1;
                }
                if ((aVar.aYX & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int NB() {
            if (this.aZd.eglSwapBuffers(this.aZe, this.aZf)) {
                return 12288;
            }
            return this.aZd.eglGetError();
        }

        public void NC() {
            ND();
        }

        private void ND() {
            if (this.aZf != null && this.aZf != EGL10.EGL_NO_SURFACE) {
                this.aZd.eglMakeCurrent(this.aZe, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.aZc.get();
                if (aVar != null) {
                    aVar.aYV.destroySurface(this.aZd, this.aZe, this.aZf);
                }
                this.aZf = null;
            }
        }

        public void finish() {
            if (this.aZh != null) {
                a aVar = this.aZc.get();
                if (aVar != null) {
                    try {
                        aVar.aYU.destroyContext(this.aZd, this.aZe, this.aZh);
                    } catch (Exception e) {
                    }
                }
                this.aZh = null;
            }
            if (this.aZe != null) {
                this.aZd.eglTerminate(this.aZe);
                this.aZe = null;
            }
        }

        private void hI(String str) {
            J(str, this.aZd.eglGetError());
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
        private WeakReference<a> aZc;
        private boolean aZi;
        private boolean aZj;
        private boolean aZk;
        private boolean aZl;
        private boolean aZm;
        private boolean aZn;
        private boolean aZo;
        private boolean aZp;
        private boolean aZq;
        private boolean aZr;
        private boolean aZs;
        private boolean aZv;
        private h aZy;
        private ArrayList<Runnable> aZw = new ArrayList<>();
        private boolean aZx = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aZu = true;
        private int aZt = 1;

        i(WeakReference<a> weakReference) {
            this.aZc = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    NG();
                    a.aYP.a(this);
                } catch (Exception e) {
                    aj.uV().aE(false);
                    a.aYP.a(this);
                }
            } catch (Throwable th) {
                a.aYP.a(this);
                throw th;
            }
        }

        private void NE() {
            if (this.aZq) {
                this.aZq = false;
                this.aZy.NC();
            }
        }

        private void NF() {
            if (this.aZp) {
                this.aZy.finish();
                this.aZp = false;
                a.aYP.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void NG() throws InterruptedException {
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
            this.aZy = new h(this.aZc);
            this.aZp = false;
            this.aZq = false;
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
                    synchronized (a.aYP) {
                        while (!this.aZi) {
                            if (this.aZw.isEmpty()) {
                                if (this.aZl != this.aZk) {
                                    boolean z23 = this.aZk;
                                    this.aZl = this.aZk;
                                    a.aYP.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.aZs) {
                                    NE();
                                    NF();
                                    this.aZs = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    NE();
                                    NF();
                                    z20 = false;
                                }
                                if (z9 && this.aZq) {
                                    NE();
                                }
                                if (z9 && this.aZp) {
                                    a aVar = this.aZc.get();
                                    if (!(aVar == null ? false : aVar.aYZ) || a.aYP.NN()) {
                                        NF();
                                    }
                                }
                                if (z9 && a.aYP.NO()) {
                                    this.aZy.finish();
                                }
                                if (!this.aZm && !this.aZo) {
                                    if (this.aZq) {
                                        NE();
                                    }
                                    this.aZo = true;
                                    this.aZn = false;
                                    a.aYP.notifyAll();
                                }
                                if (this.aZm && this.aZo) {
                                    this.aZo = false;
                                    a.aYP.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.aZv = true;
                                    a.aYP.notifyAll();
                                }
                                if (NI()) {
                                    if (!this.aZp) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.aYP.b(this)) {
                                            try {
                                                this.aZy.start();
                                                this.aZp = true;
                                                z15 = true;
                                                a.aYP.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.aYP.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.aZp || this.aZq) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.aZq = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.aZq) {
                                        if (this.aZx) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.aZx = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.aZu = false;
                                        a.aYP.notifyAll();
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
                                a.aYP.wait();
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
                                remove = this.aZw.remove(0);
                            }
                        }
                        synchronized (a.aYP) {
                            NE();
                            NF();
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
                        } else if (this.aZy.Nz()) {
                            synchronized (a.aYP) {
                                this.aZr = true;
                                a.aYP.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.aYP) {
                                this.aZr = true;
                                this.aZn = true;
                                a.aYP.notifyAll();
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
                            GL10 gl103 = (GL10) this.aZy.NA();
                            a.aYP.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.aZc.get();
                            if (aVar2 != null) {
                                aVar2.aYS.onSurfaceCreated(gl10, this.aZy.aZg);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.aZc.get();
                            if (aVar3 != null) {
                                aVar3.aYS.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.aZc.get();
                        if (aVar4 != null) {
                            aVar4.aYS.onDrawFrame(gl10);
                        }
                        int NB = this.aZy.NB();
                        switch (NB) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", NB);
                                synchronized (a.aYP) {
                                    this.aZn = true;
                                    a.aYP.notifyAll();
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
                    synchronized (a.aYP) {
                        NE();
                        NF();
                        throw th;
                    }
                }
            }
        }

        public boolean NH() {
            return this.aZp && this.aZq && NI();
        }

        private boolean NI() {
            return !this.aZl && this.aZm && !this.aZn && this.mWidth > 0 && this.mHeight > 0 && (this.aZu || this.aZt == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.aYP) {
                this.aZt = i;
                a.aYP.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.aYP) {
                i = this.aZt;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.aYP) {
                this.aZu = true;
                a.aYP.notifyAll();
            }
        }

        public void NJ() {
            synchronized (a.aYP) {
                this.aZm = true;
                this.aZr = false;
                a.aYP.notifyAll();
                while (this.aZo && !this.aZr && !this.aZj) {
                    try {
                        a.aYP.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void NK() {
            synchronized (a.aYP) {
                this.aZm = false;
                a.aYP.notifyAll();
                while (!this.aZo && !this.aZj) {
                    try {
                        a.aYP.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.aYP) {
                this.aZk = true;
                a.aYP.notifyAll();
                while (!this.aZj && !this.aZl) {
                    try {
                        a.aYP.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.aYP) {
                this.aZk = false;
                this.aZu = true;
                this.aZv = false;
                a.aYP.notifyAll();
                while (!this.aZj && this.aZl && !this.aZv) {
                    try {
                        a.aYP.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void R(int i, int i2) {
            synchronized (a.aYP) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aZx = true;
                this.aZu = true;
                this.aZv = false;
                a.aYP.notifyAll();
                while (!this.aZj && !this.aZl && !this.aZv && NH()) {
                    try {
                        a.aYP.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void NL() {
            synchronized (a.aYP) {
                this.aZi = true;
                a.aYP.notifyAll();
                while (!this.aZj) {
                    try {
                        a.aYP.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void NM() {
            this.aZs = true;
            a.aYP.notifyAll();
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

    private void Nx() {
        if (this.aYR != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private int aZA;
        private boolean aZB;
        private boolean aZC;
        private boolean aZD;
        private i aZE;
        private boolean aZz;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.aZj = true;
            if (this.aZE == iVar) {
                this.aZE = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.aZE == iVar || this.aZE == null) {
                this.aZE = iVar;
                notifyAll();
                return true;
            }
            NP();
            if (this.aZC) {
                return true;
            }
            if (this.aZE != null) {
                this.aZE.NM();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.aZE == iVar) {
                this.aZE = null;
            }
            notifyAll();
        }

        public synchronized boolean NN() {
            return this.aZD;
        }

        public synchronized boolean NO() {
            NP();
            return !this.aZC;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.aZB) {
                    NP();
                    String glGetString = gl10.glGetString(7937);
                    if (this.aZA < 131072) {
                        this.aZC = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.aZD = this.aZC ? false : true;
                    this.aZB = true;
                }
            }
        }

        private void NP() {
            if (!this.aZz) {
                this.aZC = true;
                this.aZz = true;
            }
        }
    }
}
