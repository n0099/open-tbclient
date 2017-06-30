package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ak;
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
    private static final j bwv = new j(null);
    private f bwA;
    private g bwB;
    private k bwC;
    private int bwD;
    private int bwE;
    private boolean bwF;
    private final WeakReference<a> bww;
    private i bwx;
    private c.m bwy;
    private e bwz;
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
        this.bww = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bwx != null) {
                this.bwx.Un();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bwC = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bwD = i2;
    }

    public int getDebugFlags() {
        return this.bwD;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bwF = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bwF;
    }

    public void setRenderer(c.m mVar) {
        Ua();
        if (this.bwz == null) {
            this.bwz = new m(true);
        }
        if (this.bwA == null) {
            this.bwA = new c(this, null);
        }
        if (this.bwB == null) {
            this.bwB = new d(null);
        }
        this.bwy = mVar;
        this.bwx = new i(this.bww);
        this.bwx.start();
    }

    public void setEGLContextFactory(f fVar) {
        Ua();
        this.bwA = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Ua();
        this.bwB = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Ua();
        this.bwz = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Ua();
        this.bwE = i2;
    }

    public void setRenderMode(int i2) {
        this.bwx.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bwx.getRenderMode();
    }

    public void requestRender() {
        this.bwx.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bwx.Um();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bwx.aa(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bwx.aa(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bwx.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bwx.onPause();
    }

    public void onResume() {
        this.bwx.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bwy != null) {
            int renderMode = this.bwx != null ? this.bwx.getRenderMode() : 1;
            this.bwx = new i(this.bww);
            if (renderMode != 1) {
                this.bwx.setRenderMode(renderMode);
            }
            this.bwx.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bwx != null) {
            this.bwx.Un();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bwE, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bwE == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.H("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0058a implements e {
        protected int[] bwG;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0058a(int[] iArr) {
            this.bwG = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bwG, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bwG, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bwE == 2) {
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
    private class b extends AbstractC0058a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0058a
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
        private WeakReference<a> bwI;
        EGL10 bwJ;
        EGLDisplay bwK;
        EGLSurface bwL;
        EGLConfig bwM;
        EGLContext bwN;

        public h(WeakReference<a> weakReference) {
            this.bwI = weakReference;
        }

        public void start() {
            this.bwJ = (EGL10) EGLContext.getEGL();
            this.bwK = this.bwJ.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bwK == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bwJ.eglInitialize(this.bwK, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bwI.get();
            if (aVar == null) {
                this.bwM = null;
                this.bwN = null;
            } else {
                this.bwM = aVar.bwz.chooseConfig(this.bwJ, this.bwK);
                try {
                    this.bwN = aVar.bwA.createContext(this.bwJ, this.bwK, this.bwM);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.bwN == null || this.bwN == EGL10.EGL_NO_CONTEXT) {
                this.bwN = null;
                iz("createContext");
            }
            this.bwL = null;
        }

        public boolean Uc() {
            if (this.bwJ == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bwK == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bwM == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Ug();
            a aVar = this.bwI.get();
            if (aVar != null) {
                this.bwL = aVar.bwB.createWindowSurface(this.bwJ, this.bwK, this.bwM, aVar.getSurfaceTexture());
            } else {
                this.bwL = null;
            }
            if (this.bwL == null || this.bwL == EGL10.EGL_NO_SURFACE) {
                if (this.bwJ.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bwJ.eglMakeCurrent(this.bwK, this.bwL, this.bwL, this.bwN)) {
                f("EGLHelper", "eglMakeCurrent", this.bwJ.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Ud() {
            l lVar;
            GL gl = this.bwN.getGL();
            a aVar = this.bwI.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.bwC != null) {
                gl = aVar.bwC.wrap(gl);
            }
            if ((aVar.bwD & 3) != 0) {
                int i = 0;
                if ((aVar.bwD & 1) != 0) {
                    i = 1;
                }
                if ((aVar.bwD & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Ue() {
            if (this.bwJ.eglSwapBuffers(this.bwK, this.bwL)) {
                return 12288;
            }
            return this.bwJ.eglGetError();
        }

        public void Uf() {
            Ug();
        }

        private void Ug() {
            if (this.bwL != null && this.bwL != EGL10.EGL_NO_SURFACE) {
                this.bwJ.eglMakeCurrent(this.bwK, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bwI.get();
                if (aVar != null) {
                    aVar.bwB.destroySurface(this.bwJ, this.bwK, this.bwL);
                }
                this.bwL = null;
            }
        }

        public void finish() {
            if (this.bwN != null) {
                a aVar = this.bwI.get();
                if (aVar != null) {
                    try {
                        aVar.bwA.destroyContext(this.bwJ, this.bwK, this.bwN);
                    } catch (Exception e) {
                    }
                }
                this.bwN = null;
            }
            if (this.bwK != null) {
                this.bwJ.eglTerminate(this.bwK);
                this.bwK = null;
            }
        }

        private void iz(String str) {
            H(str, this.bwJ.eglGetError());
        }

        public static void H(String str, int i) {
            throw new RuntimeException(I(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, I(str2, i));
        }

        public static String I(String str, int i) {
            return String.valueOf(str) + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> bwI;
        private boolean bwO;
        private boolean bwP;
        private boolean bwQ;
        private boolean bwR;
        private boolean bwS;
        private boolean bwT;
        private boolean bwU;
        private boolean bwV;
        private boolean bwW;
        private boolean bwX;
        private boolean bwY;
        private boolean bxb;
        private h bxe;
        private ArrayList<Runnable> bxc = new ArrayList<>();
        private boolean bxd = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bxa = true;
        private int bwZ = 1;

        i(WeakReference<a> weakReference) {
            this.bwI = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Uj();
                    a.bwv.a(this);
                } catch (Exception e) {
                    ak.vj().aD(false);
                    a.bwv.a(this);
                }
            } catch (Throwable th) {
                a.bwv.a(this);
                throw th;
            }
        }

        private void Uh() {
            if (this.bwW) {
                this.bwW = false;
                this.bxe.Uf();
            }
        }

        private void Ui() {
            if (this.bwV) {
                this.bxe.finish();
                this.bwV = false;
                a.bwv.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Uj() throws InterruptedException {
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
            this.bxe = new h(this.bwI);
            this.bwV = false;
            this.bwW = false;
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
                    synchronized (a.bwv) {
                        while (!this.bwO) {
                            if (this.bxc.isEmpty()) {
                                if (this.bwR != this.bwQ) {
                                    boolean z23 = this.bwQ;
                                    this.bwR = this.bwQ;
                                    a.bwv.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bwY) {
                                    Uh();
                                    Ui();
                                    this.bwY = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Uh();
                                    Ui();
                                    z20 = false;
                                }
                                if (z9 && this.bwW) {
                                    Uh();
                                }
                                if (z9 && this.bwV) {
                                    a aVar = this.bwI.get();
                                    if (!(aVar == null ? false : aVar.bwF) || a.bwv.Up()) {
                                        Ui();
                                    }
                                }
                                if (z9 && a.bwv.Uq()) {
                                    this.bxe.finish();
                                }
                                if (!this.bwS && !this.bwU) {
                                    if (this.bwW) {
                                        Uh();
                                    }
                                    this.bwU = true;
                                    this.bwT = false;
                                    a.bwv.notifyAll();
                                }
                                if (this.bwS && this.bwU) {
                                    this.bwU = false;
                                    a.bwv.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.bxb = true;
                                    a.bwv.notifyAll();
                                }
                                if (Ul()) {
                                    if (!this.bwV) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bwv.b(this)) {
                                            try {
                                                this.bxe.start();
                                                this.bwV = true;
                                                z15 = true;
                                                a.bwv.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bwv.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bwV || this.bwW) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.bwW = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bwW) {
                                        if (this.bxd) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bxd = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bxa = false;
                                        a.bwv.notifyAll();
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
                                a.bwv.wait();
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
                                remove = this.bxc.remove(0);
                            }
                        }
                        synchronized (a.bwv) {
                            Uh();
                            Ui();
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
                        } else if (this.bxe.Uc()) {
                            synchronized (a.bwv) {
                                this.bwX = true;
                                a.bwv.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bwv) {
                                this.bwX = true;
                                this.bwT = true;
                                a.bwv.notifyAll();
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
                            GL10 gl103 = (GL10) this.bxe.Ud();
                            a.bwv.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bwI.get();
                            if (aVar2 != null) {
                                aVar2.bwy.onSurfaceCreated(gl10, this.bxe.bwM);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.bwI.get();
                            if (aVar3 != null) {
                                aVar3.bwy.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.bwI.get();
                        if (aVar4 != null) {
                            aVar4.bwy.onDrawFrame(gl10);
                        }
                        int Ue = this.bxe.Ue();
                        switch (Ue) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Ue);
                                synchronized (a.bwv) {
                                    this.bwT = true;
                                    a.bwv.notifyAll();
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
                    synchronized (a.bwv) {
                        Uh();
                        Ui();
                        throw th;
                    }
                }
            }
        }

        public boolean Uk() {
            return this.bwV && this.bwW && Ul();
        }

        private boolean Ul() {
            return !this.bwR && this.bwS && !this.bwT && this.mWidth > 0 && this.mHeight > 0 && (this.bxa || this.bwZ == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.bwv) {
                this.bwZ = i;
                a.bwv.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bwv) {
                i = this.bwZ;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bwv) {
                this.bxa = true;
                a.bwv.notifyAll();
            }
        }

        public void Um() {
            synchronized (a.bwv) {
                this.bwS = true;
                this.bwX = false;
                a.bwv.notifyAll();
                while (this.bwU && !this.bwX && !this.bwP) {
                    try {
                        a.bwv.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bwv) {
                this.bwS = false;
                a.bwv.notifyAll();
                while (!this.bwU && !this.bwP) {
                    try {
                        a.bwv.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bwv) {
                this.bwQ = true;
                a.bwv.notifyAll();
                while (!this.bwP && !this.bwR) {
                    try {
                        a.bwv.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bwv) {
                this.bwQ = false;
                this.bxa = true;
                this.bxb = false;
                a.bwv.notifyAll();
                while (!this.bwP && this.bwR && !this.bxb) {
                    try {
                        a.bwv.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aa(int i, int i2) {
            synchronized (a.bwv) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bxd = true;
                this.bxa = true;
                this.bxb = false;
                a.bwv.notifyAll();
                while (!this.bwP && !this.bwR && !this.bxb && Uk()) {
                    try {
                        a.bwv.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Un() {
            synchronized (a.bwv) {
                this.bwO = true;
                a.bwv.notifyAll();
                while (!this.bwP) {
                    try {
                        a.bwv.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Uo() {
            this.bwY = true;
            a.bwv.notifyAll();
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

    private void Ua() {
        if (this.bwx != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bxf;
        private int bxg;
        private boolean bxh;
        private boolean bxi;
        private boolean bxj;
        private i bxk;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.bwP = true;
            if (this.bxk == iVar) {
                this.bxk = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bxk == iVar || this.bxk == null) {
                this.bxk = iVar;
                notifyAll();
                return true;
            }
            Ur();
            if (this.bxi) {
                return true;
            }
            if (this.bxk != null) {
                this.bxk.Uo();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bxk == iVar) {
                this.bxk = null;
            }
            notifyAll();
        }

        public synchronized boolean Up() {
            return this.bxj;
        }

        public synchronized boolean Uq() {
            Ur();
            return !this.bxi;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bxh) {
                    Ur();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bxg < 131072) {
                        this.bxi = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bxj = this.bxi ? false : true;
                    this.bxh = true;
                }
            }
        }

        private void Ur() {
            if (!this.bxf) {
                this.bxi = true;
                this.bxf = true;
            }
        }
    }
}
