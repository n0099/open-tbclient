package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ah;
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
    private static final j bio = new j(null);
    private final WeakReference<a> bip;
    private i biq;
    private c.m bir;
    private e bis;
    private f bit;
    private g biu;
    private k biv;
    private int biw;
    private int bix;
    private boolean biy;
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
        this.bip = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.biq != null) {
                this.biq.QC();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.biv = kVar;
    }

    public void setDebugFlags(int i2) {
        this.biw = i2;
    }

    public int getDebugFlags() {
        return this.biw;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.biy = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.biy;
    }

    public void setRenderer(c.m mVar) {
        Qo();
        if (this.bis == null) {
            this.bis = new m(true);
        }
        if (this.bit == null) {
            this.bit = new c(this, null);
        }
        if (this.biu == null) {
            this.biu = new d(null);
        }
        this.bir = mVar;
        this.biq = new i(this.bip);
        this.biq.start();
    }

    public void setEGLContextFactory(f fVar) {
        Qo();
        this.bit = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Qo();
        this.biu = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Qo();
        this.bis = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Qo();
        this.bix = i2;
    }

    public void setRenderMode(int i2) {
        this.biq.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.biq.getRenderMode();
    }

    public void requestRender() {
        this.biq.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.biq.QA();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.biq.S(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.biq.S(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.biq.QB();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.biq.onPause();
    }

    public void onResume() {
        this.biq.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bir != null) {
            int renderMode = this.biq != null ? this.biq.getRenderMode() : 1;
            this.biq = new i(this.bip);
            if (renderMode != 1) {
                this.biq.setRenderMode(renderMode);
            }
            this.biq.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.biq != null) {
            this.biq.QC();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bix, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bix == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.I("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0054a implements e {
        protected int[] biz;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0054a(int[] iArr) {
            this.biz = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.biz, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.biz, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bix == 2) {
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
    private class b extends AbstractC0054a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0054a
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
        private WeakReference<a> biB;
        EGL10 biC;
        EGLDisplay biD;
        EGLSurface biE;
        EGLConfig biF;
        EGLContext biG;

        public h(WeakReference<a> weakReference) {
            this.biB = weakReference;
        }

        public void start() {
            this.biC = (EGL10) EGLContext.getEGL();
            this.biD = this.biC.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.biD == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.biC.eglInitialize(this.biD, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.biB.get();
            if (aVar == null) {
                this.biF = null;
                this.biG = null;
            } else {
                this.biF = aVar.bis.chooseConfig(this.biC, this.biD);
                try {
                    this.biG = aVar.bit.createContext(this.biC, this.biD, this.biF);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.biG == null || this.biG == EGL10.EGL_NO_CONTEXT) {
                this.biG = null;
                hY("createContext");
            }
            this.biE = null;
        }

        public boolean Qq() {
            if (this.biC == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.biD == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.biF == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Qu();
            a aVar = this.biB.get();
            if (aVar != null) {
                this.biE = aVar.biu.createWindowSurface(this.biC, this.biD, this.biF, aVar.getSurfaceTexture());
            } else {
                this.biE = null;
            }
            if (this.biE == null || this.biE == EGL10.EGL_NO_SURFACE) {
                if (this.biC.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.biC.eglMakeCurrent(this.biD, this.biE, this.biE, this.biG)) {
                f("EGLHelper", "eglMakeCurrent", this.biC.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Qr() {
            l lVar;
            GL gl = this.biG.getGL();
            a aVar = this.biB.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.biv != null) {
                gl = aVar.biv.wrap(gl);
            }
            if ((aVar.biw & 3) != 0) {
                int i = 0;
                if ((aVar.biw & 1) != 0) {
                    i = 1;
                }
                if ((aVar.biw & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Qs() {
            if (this.biC.eglSwapBuffers(this.biD, this.biE)) {
                return 12288;
            }
            return this.biC.eglGetError();
        }

        public void Qt() {
            Qu();
        }

        private void Qu() {
            if (this.biE != null && this.biE != EGL10.EGL_NO_SURFACE) {
                this.biC.eglMakeCurrent(this.biD, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.biB.get();
                if (aVar != null) {
                    aVar.biu.destroySurface(this.biC, this.biD, this.biE);
                }
                this.biE = null;
            }
        }

        public void finish() {
            if (this.biG != null) {
                a aVar = this.biB.get();
                if (aVar != null) {
                    try {
                        aVar.bit.destroyContext(this.biC, this.biD, this.biG);
                    } catch (Exception e) {
                    }
                }
                this.biG = null;
            }
            if (this.biD != null) {
                this.biC.eglTerminate(this.biD);
                this.biD = null;
            }
        }

        private void hY(String str) {
            I(str, this.biC.eglGetError());
        }

        public static void I(String str, int i) {
            throw new RuntimeException(J(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, J(str2, i));
        }

        public static String J(String str, int i) {
            return String.valueOf(str) + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> biB;
        private boolean biH;
        private boolean biI;
        private boolean biJ;
        private boolean biK;
        private boolean biL;
        private boolean biM;
        private boolean biN;
        private boolean biO;
        private boolean biP;
        private boolean biQ;
        private boolean biR;
        private boolean biU;
        private h biX;
        private ArrayList<Runnable> biV = new ArrayList<>();
        private boolean biW = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean biT = true;
        private int biS = 1;

        i(WeakReference<a> weakReference) {
            this.biB = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Qx();
                    a.bio.a(this);
                } catch (Exception e) {
                    ah.uP().aE(false);
                    a.bio.a(this);
                }
            } catch (Throwable th) {
                a.bio.a(this);
                throw th;
            }
        }

        private void Qv() {
            if (this.biP) {
                this.biP = false;
                this.biX.Qt();
            }
        }

        private void Qw() {
            if (this.biO) {
                this.biX.finish();
                this.biO = false;
                a.bio.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Qx() throws InterruptedException {
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
            this.biX = new h(this.biB);
            this.biO = false;
            this.biP = false;
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
                    synchronized (a.bio) {
                        while (!this.biH) {
                            if (this.biV.isEmpty()) {
                                if (this.biK != this.biJ) {
                                    boolean z23 = this.biJ;
                                    this.biK = this.biJ;
                                    a.bio.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.biR) {
                                    Qv();
                                    Qw();
                                    this.biR = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Qv();
                                    Qw();
                                    z20 = false;
                                }
                                if (z9 && this.biP) {
                                    Qv();
                                }
                                if (z9 && this.biO) {
                                    a aVar = this.biB.get();
                                    if (!(aVar == null ? false : aVar.biy) || a.bio.QE()) {
                                        Qw();
                                    }
                                }
                                if (z9 && a.bio.QF()) {
                                    this.biX.finish();
                                }
                                if (!this.biL && !this.biN) {
                                    if (this.biP) {
                                        Qv();
                                    }
                                    this.biN = true;
                                    this.biM = false;
                                    a.bio.notifyAll();
                                }
                                if (this.biL && this.biN) {
                                    this.biN = false;
                                    a.bio.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.biU = true;
                                    a.bio.notifyAll();
                                }
                                if (Qz()) {
                                    if (!this.biO) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bio.b(this)) {
                                            try {
                                                this.biX.start();
                                                this.biO = true;
                                                z15 = true;
                                                a.bio.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bio.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.biO || this.biP) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.biP = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.biP) {
                                        if (this.biW) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.biW = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.biT = false;
                                        a.bio.notifyAll();
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
                                a.bio.wait();
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
                                remove = this.biV.remove(0);
                            }
                        }
                        synchronized (a.bio) {
                            Qv();
                            Qw();
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
                        } else if (this.biX.Qq()) {
                            synchronized (a.bio) {
                                this.biQ = true;
                                a.bio.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bio) {
                                this.biQ = true;
                                this.biM = true;
                                a.bio.notifyAll();
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
                            GL10 gl103 = (GL10) this.biX.Qr();
                            a.bio.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.biB.get();
                            if (aVar2 != null) {
                                aVar2.bir.onSurfaceCreated(gl10, this.biX.biF);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.biB.get();
                            if (aVar3 != null) {
                                aVar3.bir.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.biB.get();
                        if (aVar4 != null) {
                            aVar4.bir.onDrawFrame(gl10);
                        }
                        int Qs = this.biX.Qs();
                        switch (Qs) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Qs);
                                synchronized (a.bio) {
                                    this.biM = true;
                                    a.bio.notifyAll();
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
                    synchronized (a.bio) {
                        Qv();
                        Qw();
                        throw th;
                    }
                }
            }
        }

        public boolean Qy() {
            return this.biO && this.biP && Qz();
        }

        private boolean Qz() {
            return !this.biK && this.biL && !this.biM && this.mWidth > 0 && this.mHeight > 0 && (this.biT || this.biS == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.bio) {
                this.biS = i;
                a.bio.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bio) {
                i = this.biS;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bio) {
                this.biT = true;
                a.bio.notifyAll();
            }
        }

        public void QA() {
            synchronized (a.bio) {
                this.biL = true;
                this.biQ = false;
                a.bio.notifyAll();
                while (this.biN && !this.biQ && !this.biI) {
                    try {
                        a.bio.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void QB() {
            synchronized (a.bio) {
                this.biL = false;
                a.bio.notifyAll();
                while (!this.biN && !this.biI) {
                    try {
                        a.bio.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bio) {
                this.biJ = true;
                a.bio.notifyAll();
                while (!this.biI && !this.biK) {
                    try {
                        a.bio.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bio) {
                this.biJ = false;
                this.biT = true;
                this.biU = false;
                a.bio.notifyAll();
                while (!this.biI && this.biK && !this.biU) {
                    try {
                        a.bio.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void S(int i, int i2) {
            synchronized (a.bio) {
                this.mWidth = i;
                this.mHeight = i2;
                this.biW = true;
                this.biT = true;
                this.biU = false;
                a.bio.notifyAll();
                while (!this.biI && !this.biK && !this.biU && Qy()) {
                    try {
                        a.bio.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void QC() {
            synchronized (a.bio) {
                this.biH = true;
                a.bio.notifyAll();
                while (!this.biI) {
                    try {
                        a.bio.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void QD() {
            this.biR = true;
            a.bio.notifyAll();
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

    private void Qo() {
        if (this.biq != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean biY;
        private int biZ;
        private boolean bja;
        private boolean bjb;
        private boolean bjc;
        private i bjd;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.biI = true;
            if (this.bjd == iVar) {
                this.bjd = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bjd == iVar || this.bjd == null) {
                this.bjd = iVar;
                notifyAll();
                return true;
            }
            QG();
            if (this.bjb) {
                return true;
            }
            if (this.bjd != null) {
                this.bjd.QD();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bjd == iVar) {
                this.bjd = null;
            }
            notifyAll();
        }

        public synchronized boolean QE() {
            return this.bjc;
        }

        public synchronized boolean QF() {
            QG();
            return !this.bjb;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bja) {
                    QG();
                    String glGetString = gl10.glGetString(7937);
                    if (this.biZ < 131072) {
                        this.bjb = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bjc = this.bjb ? false : true;
                    this.bja = true;
                }
            }
        }

        private void QG() {
            if (!this.biY) {
                this.bjb = true;
                this.biY = true;
            }
        }
    }
}
