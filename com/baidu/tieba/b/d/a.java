package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ai;
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
    private static final j boQ = new j(null);
    private final WeakReference<a> boR;
    private i boS;
    private c.m boT;
    private e boU;
    private f boV;
    private g boW;
    private k boX;
    private int boY;
    private int boZ;
    private boolean bpa;
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
        this.boR = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.boS != null) {
                this.boS.RS();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.boX = kVar;
    }

    public void setDebugFlags(int i2) {
        this.boY = i2;
    }

    public int getDebugFlags() {
        return this.boY;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bpa = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bpa;
    }

    public void setRenderer(c.m mVar) {
        RF();
        if (this.boU == null) {
            this.boU = new m(true);
        }
        if (this.boV == null) {
            this.boV = new c(this, null);
        }
        if (this.boW == null) {
            this.boW = new d(null);
        }
        this.boT = mVar;
        this.boS = new i(this.boR);
        this.boS.start();
    }

    public void setEGLContextFactory(f fVar) {
        RF();
        this.boV = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        RF();
        this.boW = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        RF();
        this.boU = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        RF();
        this.boZ = i2;
    }

    public void setRenderMode(int i2) {
        this.boS.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.boS.getRenderMode();
    }

    public void requestRender() {
        this.boS.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.boS.RR();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.boS.Y(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.boS.Y(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.boS.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.boS.onPause();
    }

    public void onResume() {
        this.boS.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.boT != null) {
            int renderMode = this.boS != null ? this.boS.getRenderMode() : 1;
            this.boS = new i(this.boR);
            if (renderMode != 1) {
                this.boS.setRenderMode(renderMode);
            }
            this.boS.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.boS != null) {
            this.boS.RS();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.boZ, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.boZ == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.F("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0052a implements e {
        protected int[] bpb;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0052a(int[] iArr) {
            this.bpb = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bpb, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bpb, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.boZ == 2) {
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
    private class b extends AbstractC0052a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0052a
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
        private WeakReference<a> bpd;
        EGL10 bpe;
        EGLDisplay bpf;
        EGLSurface bpg;
        EGLConfig bph;
        EGLContext bpi;

        public h(WeakReference<a> weakReference) {
            this.bpd = weakReference;
        }

        public void start() {
            this.bpe = (EGL10) EGLContext.getEGL();
            this.bpf = this.bpe.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bpf == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bpe.eglInitialize(this.bpf, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bpd.get();
            if (aVar == null) {
                this.bph = null;
                this.bpi = null;
            } else {
                this.bph = aVar.boU.chooseConfig(this.bpe, this.bpf);
                try {
                    this.bpi = aVar.boV.createContext(this.bpe, this.bpf, this.bph);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.bpi == null || this.bpi == EGL10.EGL_NO_CONTEXT) {
                this.bpi = null;
                hS("createContext");
            }
            this.bpg = null;
        }

        public boolean RH() {
            if (this.bpe == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bpf == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bph == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            RL();
            a aVar = this.bpd.get();
            if (aVar != null) {
                this.bpg = aVar.boW.createWindowSurface(this.bpe, this.bpf, this.bph, aVar.getSurfaceTexture());
            } else {
                this.bpg = null;
            }
            if (this.bpg == null || this.bpg == EGL10.EGL_NO_SURFACE) {
                if (this.bpe.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bpe.eglMakeCurrent(this.bpf, this.bpg, this.bpg, this.bpi)) {
                f("EGLHelper", "eglMakeCurrent", this.bpe.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL RI() {
            l lVar;
            GL gl = this.bpi.getGL();
            a aVar = this.bpd.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.boX != null) {
                gl = aVar.boX.wrap(gl);
            }
            if ((aVar.boY & 3) != 0) {
                int i = 0;
                if ((aVar.boY & 1) != 0) {
                    i = 1;
                }
                if ((aVar.boY & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int RJ() {
            if (this.bpe.eglSwapBuffers(this.bpf, this.bpg)) {
                return 12288;
            }
            return this.bpe.eglGetError();
        }

        public void RK() {
            RL();
        }

        private void RL() {
            if (this.bpg != null && this.bpg != EGL10.EGL_NO_SURFACE) {
                this.bpe.eglMakeCurrent(this.bpf, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bpd.get();
                if (aVar != null) {
                    aVar.boW.destroySurface(this.bpe, this.bpf, this.bpg);
                }
                this.bpg = null;
            }
        }

        public void finish() {
            if (this.bpi != null) {
                a aVar = this.bpd.get();
                if (aVar != null) {
                    try {
                        aVar.boV.destroyContext(this.bpe, this.bpf, this.bpi);
                    } catch (Exception e) {
                    }
                }
                this.bpi = null;
            }
            if (this.bpf != null) {
                this.bpe.eglTerminate(this.bpf);
                this.bpf = null;
            }
        }

        private void hS(String str) {
            F(str, this.bpe.eglGetError());
        }

        public static void F(String str, int i) {
            throw new RuntimeException(G(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, G(str2, i));
        }

        public static String G(String str, int i) {
            return String.valueOf(str) + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> bpd;
        private boolean bpj;
        private boolean bpk;
        private boolean bpl;
        private boolean bpm;
        private boolean bpn;
        private boolean bpo;
        private boolean bpp;
        private boolean bpq;
        private boolean bpr;
        private boolean bps;
        private boolean bpt;
        private boolean bpw;
        private h bpz;
        private ArrayList<Runnable> bpx = new ArrayList<>();
        private boolean bpy = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bpv = true;
        private int bpu = 1;

        i(WeakReference<a> weakReference) {
            this.bpd = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    RO();
                    a.boQ.a(this);
                } catch (Exception e) {
                    ai.vJ().aF(false);
                    a.boQ.a(this);
                }
            } catch (Throwable th) {
                a.boQ.a(this);
                throw th;
            }
        }

        private void RM() {
            if (this.bpr) {
                this.bpr = false;
                this.bpz.RK();
            }
        }

        private void RN() {
            if (this.bpq) {
                this.bpz.finish();
                this.bpq = false;
                a.boQ.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void RO() throws InterruptedException {
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
            this.bpz = new h(this.bpd);
            this.bpq = false;
            this.bpr = false;
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
                    synchronized (a.boQ) {
                        while (!this.bpj) {
                            if (this.bpx.isEmpty()) {
                                if (this.bpm != this.bpl) {
                                    boolean z23 = this.bpl;
                                    this.bpm = this.bpl;
                                    a.boQ.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bpt) {
                                    RM();
                                    RN();
                                    this.bpt = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    RM();
                                    RN();
                                    z20 = false;
                                }
                                if (z9 && this.bpr) {
                                    RM();
                                }
                                if (z9 && this.bpq) {
                                    a aVar = this.bpd.get();
                                    if (!(aVar == null ? false : aVar.bpa) || a.boQ.RU()) {
                                        RN();
                                    }
                                }
                                if (z9 && a.boQ.RV()) {
                                    this.bpz.finish();
                                }
                                if (!this.bpn && !this.bpp) {
                                    if (this.bpr) {
                                        RM();
                                    }
                                    this.bpp = true;
                                    this.bpo = false;
                                    a.boQ.notifyAll();
                                }
                                if (this.bpn && this.bpp) {
                                    this.bpp = false;
                                    a.boQ.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.bpw = true;
                                    a.boQ.notifyAll();
                                }
                                if (RQ()) {
                                    if (!this.bpq) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.boQ.b(this)) {
                                            try {
                                                this.bpz.start();
                                                this.bpq = true;
                                                z15 = true;
                                                a.boQ.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.boQ.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bpq || this.bpr) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.bpr = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bpr) {
                                        if (this.bpy) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bpy = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bpv = false;
                                        a.boQ.notifyAll();
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
                                a.boQ.wait();
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
                                remove = this.bpx.remove(0);
                            }
                        }
                        synchronized (a.boQ) {
                            RM();
                            RN();
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
                        } else if (this.bpz.RH()) {
                            synchronized (a.boQ) {
                                this.bps = true;
                                a.boQ.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.boQ) {
                                this.bps = true;
                                this.bpo = true;
                                a.boQ.notifyAll();
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
                            GL10 gl103 = (GL10) this.bpz.RI();
                            a.boQ.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bpd.get();
                            if (aVar2 != null) {
                                aVar2.boT.onSurfaceCreated(gl10, this.bpz.bph);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.bpd.get();
                            if (aVar3 != null) {
                                aVar3.boT.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.bpd.get();
                        if (aVar4 != null) {
                            aVar4.boT.onDrawFrame(gl10);
                        }
                        int RJ = this.bpz.RJ();
                        switch (RJ) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", RJ);
                                synchronized (a.boQ) {
                                    this.bpo = true;
                                    a.boQ.notifyAll();
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
                    synchronized (a.boQ) {
                        RM();
                        RN();
                        throw th;
                    }
                }
            }
        }

        public boolean RP() {
            return this.bpq && this.bpr && RQ();
        }

        private boolean RQ() {
            return !this.bpm && this.bpn && !this.bpo && this.mWidth > 0 && this.mHeight > 0 && (this.bpv || this.bpu == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.boQ) {
                this.bpu = i;
                a.boQ.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.boQ) {
                i = this.bpu;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.boQ) {
                this.bpv = true;
                a.boQ.notifyAll();
            }
        }

        public void RR() {
            synchronized (a.boQ) {
                this.bpn = true;
                this.bps = false;
                a.boQ.notifyAll();
                while (this.bpp && !this.bps && !this.bpk) {
                    try {
                        a.boQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.boQ) {
                this.bpn = false;
                a.boQ.notifyAll();
                while (!this.bpp && !this.bpk) {
                    try {
                        a.boQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.boQ) {
                this.bpl = true;
                a.boQ.notifyAll();
                while (!this.bpk && !this.bpm) {
                    try {
                        a.boQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.boQ) {
                this.bpl = false;
                this.bpv = true;
                this.bpw = false;
                a.boQ.notifyAll();
                while (!this.bpk && this.bpm && !this.bpw) {
                    try {
                        a.boQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Y(int i, int i2) {
            synchronized (a.boQ) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bpy = true;
                this.bpv = true;
                this.bpw = false;
                a.boQ.notifyAll();
                while (!this.bpk && !this.bpm && !this.bpw && RP()) {
                    try {
                        a.boQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void RS() {
            synchronized (a.boQ) {
                this.bpj = true;
                a.boQ.notifyAll();
                while (!this.bpk) {
                    try {
                        a.boQ.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void RT() {
            this.bpt = true;
            a.boQ.notifyAll();
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

    private void RF() {
        if (this.boS != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bpA;
        private int bpB;
        private boolean bpC;
        private boolean bpD;
        private boolean bpE;
        private i bpF;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.bpk = true;
            if (this.bpF == iVar) {
                this.bpF = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bpF == iVar || this.bpF == null) {
                this.bpF = iVar;
                notifyAll();
                return true;
            }
            RW();
            if (this.bpD) {
                return true;
            }
            if (this.bpF != null) {
                this.bpF.RT();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bpF == iVar) {
                this.bpF = null;
            }
            notifyAll();
        }

        public synchronized boolean RU() {
            return this.bpE;
        }

        public synchronized boolean RV() {
            RW();
            return !this.bpD;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bpC) {
                    RW();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bpB < 131072) {
                        this.bpD = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bpE = this.bpD ? false : true;
                    this.bpC = true;
                }
            }
        }

        private void RW() {
            if (!this.bpA) {
                this.bpD = true;
                this.bpA = true;
            }
        }
    }
}
