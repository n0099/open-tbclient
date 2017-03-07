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
    private static final j boX = new j(null);
    private final WeakReference<a> boY;
    private i boZ;
    private c.m bpa;
    private e bpb;
    private f bpc;
    private g bpd;
    private k bpe;
    private int bpf;
    private int bpg;
    private boolean bph;
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
        this.boY = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.boZ != null) {
                this.boZ.Ru();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bpe = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bpf = i2;
    }

    public int getDebugFlags() {
        return this.bpf;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bph = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bph;
    }

    public void setRenderer(c.m mVar) {
        Rh();
        if (this.bpb == null) {
            this.bpb = new m(true);
        }
        if (this.bpc == null) {
            this.bpc = new c(this, null);
        }
        if (this.bpd == null) {
            this.bpd = new d(null);
        }
        this.bpa = mVar;
        this.boZ = new i(this.boY);
        this.boZ.start();
    }

    public void setEGLContextFactory(f fVar) {
        Rh();
        this.bpc = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Rh();
        this.bpd = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Rh();
        this.bpb = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Rh();
        this.bpg = i2;
    }

    public void setRenderMode(int i2) {
        this.boZ.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.boZ.getRenderMode();
    }

    public void requestRender() {
        this.boZ.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.boZ.Rt();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.boZ.Y(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.boZ.Y(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.boZ.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.boZ.onPause();
    }

    public void onResume() {
        this.boZ.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bpa != null) {
            int renderMode = this.boZ != null ? this.boZ.getRenderMode() : 1;
            this.boZ = new i(this.boY);
            if (renderMode != 1) {
                this.boZ.setRenderMode(renderMode);
            }
            this.boZ.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.boZ != null) {
            this.boZ.Ru();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bpg, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bpg == 0) {
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
    private abstract class AbstractC0053a implements e {
        protected int[] bpi;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0053a(int[] iArr) {
            this.bpi = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bpi, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bpi, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bpg == 2) {
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
    private class b extends AbstractC0053a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0053a
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
        private WeakReference<a> bpk;
        EGL10 bpl;
        EGLDisplay bpm;
        EGLSurface bpn;
        EGLConfig bpo;
        EGLContext bpp;

        public h(WeakReference<a> weakReference) {
            this.bpk = weakReference;
        }

        public void start() {
            this.bpl = (EGL10) EGLContext.getEGL();
            this.bpm = this.bpl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bpm == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bpl.eglInitialize(this.bpm, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bpk.get();
            if (aVar == null) {
                this.bpo = null;
                this.bpp = null;
            } else {
                this.bpo = aVar.bpb.chooseConfig(this.bpl, this.bpm);
                try {
                    this.bpp = aVar.bpc.createContext(this.bpl, this.bpm, this.bpo);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.bpp == null || this.bpp == EGL10.EGL_NO_CONTEXT) {
                this.bpp = null;
                hO("createContext");
            }
            this.bpn = null;
        }

        public boolean Rj() {
            if (this.bpl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bpm == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bpo == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Rn();
            a aVar = this.bpk.get();
            if (aVar != null) {
                this.bpn = aVar.bpd.createWindowSurface(this.bpl, this.bpm, this.bpo, aVar.getSurfaceTexture());
            } else {
                this.bpn = null;
            }
            if (this.bpn == null || this.bpn == EGL10.EGL_NO_SURFACE) {
                if (this.bpl.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bpl.eglMakeCurrent(this.bpm, this.bpn, this.bpn, this.bpp)) {
                f("EGLHelper", "eglMakeCurrent", this.bpl.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Rk() {
            l lVar;
            GL gl = this.bpp.getGL();
            a aVar = this.bpk.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.bpe != null) {
                gl = aVar.bpe.wrap(gl);
            }
            if ((aVar.bpf & 3) != 0) {
                int i = 0;
                if ((aVar.bpf & 1) != 0) {
                    i = 1;
                }
                if ((aVar.bpf & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Rl() {
            if (this.bpl.eglSwapBuffers(this.bpm, this.bpn)) {
                return 12288;
            }
            return this.bpl.eglGetError();
        }

        public void Rm() {
            Rn();
        }

        private void Rn() {
            if (this.bpn != null && this.bpn != EGL10.EGL_NO_SURFACE) {
                this.bpl.eglMakeCurrent(this.bpm, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bpk.get();
                if (aVar != null) {
                    aVar.bpd.destroySurface(this.bpl, this.bpm, this.bpn);
                }
                this.bpn = null;
            }
        }

        public void finish() {
            if (this.bpp != null) {
                a aVar = this.bpk.get();
                if (aVar != null) {
                    try {
                        aVar.bpc.destroyContext(this.bpl, this.bpm, this.bpp);
                    } catch (Exception e) {
                    }
                }
                this.bpp = null;
            }
            if (this.bpm != null) {
                this.bpl.eglTerminate(this.bpm);
                this.bpm = null;
            }
        }

        private void hO(String str) {
            F(str, this.bpl.eglGetError());
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
        private boolean bpA;
        private boolean bpD;
        private h bpG;
        private WeakReference<a> bpk;
        private boolean bpq;
        private boolean bpr;
        private boolean bps;
        private boolean bpt;
        private boolean bpu;
        private boolean bpv;
        private boolean bpw;
        private boolean bpx;
        private boolean bpy;
        private boolean bpz;
        private ArrayList<Runnable> bpE = new ArrayList<>();
        private boolean bpF = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bpC = true;
        private int bpB = 1;

        i(WeakReference<a> weakReference) {
            this.bpk = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Rq();
                    a.boX.a(this);
                } catch (Exception e) {
                    ai.vm().aD(false);
                    a.boX.a(this);
                }
            } catch (Throwable th) {
                a.boX.a(this);
                throw th;
            }
        }

        private void Ro() {
            if (this.bpy) {
                this.bpy = false;
                this.bpG.Rm();
            }
        }

        private void Rp() {
            if (this.bpx) {
                this.bpG.finish();
                this.bpx = false;
                a.boX.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Rq() throws InterruptedException {
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
            this.bpG = new h(this.bpk);
            this.bpx = false;
            this.bpy = false;
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
                    synchronized (a.boX) {
                        while (!this.bpq) {
                            if (this.bpE.isEmpty()) {
                                if (this.bpt != this.bps) {
                                    boolean z23 = this.bps;
                                    this.bpt = this.bps;
                                    a.boX.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bpA) {
                                    Ro();
                                    Rp();
                                    this.bpA = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Ro();
                                    Rp();
                                    z20 = false;
                                }
                                if (z9 && this.bpy) {
                                    Ro();
                                }
                                if (z9 && this.bpx) {
                                    a aVar = this.bpk.get();
                                    if (!(aVar == null ? false : aVar.bph) || a.boX.Rw()) {
                                        Rp();
                                    }
                                }
                                if (z9 && a.boX.Rx()) {
                                    this.bpG.finish();
                                }
                                if (!this.bpu && !this.bpw) {
                                    if (this.bpy) {
                                        Ro();
                                    }
                                    this.bpw = true;
                                    this.bpv = false;
                                    a.boX.notifyAll();
                                }
                                if (this.bpu && this.bpw) {
                                    this.bpw = false;
                                    a.boX.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.bpD = true;
                                    a.boX.notifyAll();
                                }
                                if (Rs()) {
                                    if (!this.bpx) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.boX.b(this)) {
                                            try {
                                                this.bpG.start();
                                                this.bpx = true;
                                                z15 = true;
                                                a.boX.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.boX.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bpx || this.bpy) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.bpy = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bpy) {
                                        if (this.bpF) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bpF = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bpC = false;
                                        a.boX.notifyAll();
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
                                a.boX.wait();
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
                                remove = this.bpE.remove(0);
                            }
                        }
                        synchronized (a.boX) {
                            Ro();
                            Rp();
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
                        } else if (this.bpG.Rj()) {
                            synchronized (a.boX) {
                                this.bpz = true;
                                a.boX.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.boX) {
                                this.bpz = true;
                                this.bpv = true;
                                a.boX.notifyAll();
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
                            GL10 gl103 = (GL10) this.bpG.Rk();
                            a.boX.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bpk.get();
                            if (aVar2 != null) {
                                aVar2.bpa.onSurfaceCreated(gl10, this.bpG.bpo);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.bpk.get();
                            if (aVar3 != null) {
                                aVar3.bpa.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.bpk.get();
                        if (aVar4 != null) {
                            aVar4.bpa.onDrawFrame(gl10);
                        }
                        int Rl = this.bpG.Rl();
                        switch (Rl) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Rl);
                                synchronized (a.boX) {
                                    this.bpv = true;
                                    a.boX.notifyAll();
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
                    synchronized (a.boX) {
                        Ro();
                        Rp();
                        throw th;
                    }
                }
            }
        }

        public boolean Rr() {
            return this.bpx && this.bpy && Rs();
        }

        private boolean Rs() {
            return !this.bpt && this.bpu && !this.bpv && this.mWidth > 0 && this.mHeight > 0 && (this.bpC || this.bpB == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.boX) {
                this.bpB = i;
                a.boX.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.boX) {
                i = this.bpB;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.boX) {
                this.bpC = true;
                a.boX.notifyAll();
            }
        }

        public void Rt() {
            synchronized (a.boX) {
                this.bpu = true;
                this.bpz = false;
                a.boX.notifyAll();
                while (this.bpw && !this.bpz && !this.bpr) {
                    try {
                        a.boX.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.boX) {
                this.bpu = false;
                a.boX.notifyAll();
                while (!this.bpw && !this.bpr) {
                    try {
                        a.boX.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.boX) {
                this.bps = true;
                a.boX.notifyAll();
                while (!this.bpr && !this.bpt) {
                    try {
                        a.boX.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.boX) {
                this.bps = false;
                this.bpC = true;
                this.bpD = false;
                a.boX.notifyAll();
                while (!this.bpr && this.bpt && !this.bpD) {
                    try {
                        a.boX.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Y(int i, int i2) {
            synchronized (a.boX) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bpF = true;
                this.bpC = true;
                this.bpD = false;
                a.boX.notifyAll();
                while (!this.bpr && !this.bpt && !this.bpD && Rr()) {
                    try {
                        a.boX.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Ru() {
            synchronized (a.boX) {
                this.bpq = true;
                a.boX.notifyAll();
                while (!this.bpr) {
                    try {
                        a.boX.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Rv() {
            this.bpA = true;
            a.boX.notifyAll();
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

    private void Rh() {
        if (this.boZ != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bpH;
        private int bpI;
        private boolean bpJ;
        private boolean bpK;
        private boolean bpL;
        private i bpM;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.bpr = true;
            if (this.bpM == iVar) {
                this.bpM = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bpM == iVar || this.bpM == null) {
                this.bpM = iVar;
                notifyAll();
                return true;
            }
            Ry();
            if (this.bpK) {
                return true;
            }
            if (this.bpM != null) {
                this.bpM.Rv();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bpM == iVar) {
                this.bpM = null;
            }
            notifyAll();
        }

        public synchronized boolean Rw() {
            return this.bpL;
        }

        public synchronized boolean Rx() {
            Ry();
            return !this.bpK;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bpJ) {
                    Ry();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bpI < 131072) {
                        this.bpK = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bpL = this.bpK ? false : true;
                    this.bpJ = true;
                }
            }
        }

        private void Ry() {
            if (!this.bpH) {
                this.bpK = true;
                this.bpH = true;
            }
        }
    }
}
