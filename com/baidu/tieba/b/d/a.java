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
    private static final j bFs = new j();
    private int bFA;
    private int bFB;
    private boolean bFC;
    private final WeakReference<a> bFt;
    private i bFu;
    private c.m bFv;
    private e bFw;
    private f bFx;
    private g bFy;
    private k bFz;
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
        this.bFt = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bFu != null) {
                this.bFu.Wy();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bFz = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bFA = i2;
    }

    public int getDebugFlags() {
        return this.bFA;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bFC = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bFC;
    }

    public void setRenderer(c.m mVar) {
        Wl();
        if (this.bFw == null) {
            this.bFw = new m(true);
        }
        if (this.bFx == null) {
            this.bFx = new c();
        }
        if (this.bFy == null) {
            this.bFy = new d();
        }
        this.bFv = mVar;
        this.bFu = new i(this.bFt);
        this.bFu.start();
    }

    public void setEGLContextFactory(f fVar) {
        Wl();
        this.bFx = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Wl();
        this.bFy = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Wl();
        this.bFw = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Wl();
        this.bFB = i2;
    }

    public void setRenderMode(int i2) {
        this.bFu.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bFu.getRenderMode();
    }

    public void requestRender() {
        this.bFu.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bFu.Wx();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bFu.Y(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bFu.Y(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bFu.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bFu.onPause();
    }

    public void onResume() {
        this.bFu.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bFv != null) {
            int renderMode = this.bFu != null ? this.bFu.getRenderMode() : 1;
            this.bFu = new i(this.bFt);
            if (renderMode != 1) {
                this.bFu.setRenderMode(renderMode);
            }
            this.bFu.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bFu != null) {
            this.bFu.Wy();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bFB, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bFB == 0) {
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
    private abstract class AbstractC0076a implements e {
        protected int[] bFD;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0076a(int[] iArr) {
            this.bFD = f(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bFD, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bFD, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] f(int[] iArr) {
            if (a.this.bFB == 2) {
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
    private class b extends AbstractC0076a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0076a
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
        private WeakReference<a> bFF;
        EGL10 bFG;
        EGLDisplay bFH;
        EGLSurface bFI;
        EGLConfig bFJ;
        EGLContext bFK;

        public h(WeakReference<a> weakReference) {
            this.bFF = weakReference;
        }

        public void start() {
            this.bFG = (EGL10) EGLContext.getEGL();
            this.bFH = this.bFG.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bFH == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bFG.eglInitialize(this.bFH, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bFF.get();
            if (aVar != null) {
                this.bFJ = aVar.bFw.chooseConfig(this.bFG, this.bFH);
                try {
                    this.bFK = aVar.bFx.createContext(this.bFG, this.bFH, this.bFJ);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bFJ = null;
                this.bFK = null;
            }
            if (this.bFK == null || this.bFK == EGL10.EGL_NO_CONTEXT) {
                this.bFK = null;
                jj("createContext");
            }
            this.bFI = null;
        }

        public boolean Wn() {
            if (this.bFG == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bFH == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bFJ == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Wr();
            a aVar = this.bFF.get();
            if (aVar != null) {
                this.bFI = aVar.bFy.createWindowSurface(this.bFG, this.bFH, this.bFJ, aVar.getSurfaceTexture());
            } else {
                this.bFI = null;
            }
            if (this.bFI == null || this.bFI == EGL10.EGL_NO_SURFACE) {
                if (this.bFG.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bFG.eglMakeCurrent(this.bFH, this.bFI, this.bFI, this.bFK)) {
                f("EGLHelper", "eglMakeCurrent", this.bFG.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Wo() {
            l lVar;
            GL gl = this.bFK.getGL();
            a aVar = this.bFF.get();
            if (aVar != null) {
                if (aVar.bFz != null) {
                    gl = aVar.bFz.wrap(gl);
                }
                if ((aVar.bFA & 3) != 0) {
                    int i = 0;
                    if ((aVar.bFA & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bFA & 2) == 0) {
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

        public int Wp() {
            if (this.bFG.eglSwapBuffers(this.bFH, this.bFI)) {
                return 12288;
            }
            return this.bFG.eglGetError();
        }

        public void Wq() {
            Wr();
        }

        private void Wr() {
            if (this.bFI != null && this.bFI != EGL10.EGL_NO_SURFACE) {
                this.bFG.eglMakeCurrent(this.bFH, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bFF.get();
                if (aVar != null) {
                    aVar.bFy.destroySurface(this.bFG, this.bFH, this.bFI);
                }
                this.bFI = null;
            }
        }

        public void finish() {
            if (this.bFK != null) {
                a aVar = this.bFF.get();
                if (aVar != null) {
                    try {
                        aVar.bFx.destroyContext(this.bFG, this.bFH, this.bFK);
                    } catch (Exception e) {
                    }
                }
                this.bFK = null;
            }
            if (this.bFH != null) {
                this.bFG.eglTerminate(this.bFH);
                this.bFH = null;
            }
        }

        private void jj(String str) {
            G(str, this.bFG.eglGetError());
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
        private WeakReference<a> bFF;
        private boolean bFL;
        private boolean bFM;
        private boolean bFN;
        private boolean bFO;
        private boolean bFP;
        private boolean bFQ;
        private boolean bFR;
        private boolean bFS;
        private boolean bFT;
        private boolean bFU;
        private boolean bFV;
        private boolean bFY;
        private h bGb;
        private ArrayList<Runnable> bFZ = new ArrayList<>();
        private boolean bGa = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bFX = true;
        private int bFW = 1;

        i(WeakReference<a> weakReference) {
            this.bFF = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Wu();
                    a.bFs.a(this);
                } catch (Exception e) {
                    af.vx().aC(false);
                    a.bFs.a(this);
                }
            } catch (Throwable th) {
                a.bFs.a(this);
                throw th;
            }
        }

        private void Ws() {
            if (this.bFT) {
                this.bFT = false;
                this.bGb.Wq();
            }
        }

        private void Wt() {
            if (this.bFS) {
                this.bGb.finish();
                this.bFS = false;
                a.bFs.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Wu() throws InterruptedException {
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
            this.bGb = new h(this.bFF);
            this.bFS = false;
            this.bFT = false;
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
                    synchronized (a.bFs) {
                        while (!this.bFL) {
                            if (this.bFZ.isEmpty()) {
                                if (this.bFO != this.bFN) {
                                    boolean z23 = this.bFN;
                                    this.bFO = this.bFN;
                                    a.bFs.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bFV) {
                                    Ws();
                                    Wt();
                                    this.bFV = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    Ws();
                                    Wt();
                                    z19 = false;
                                }
                                if (z9 && this.bFT) {
                                    Ws();
                                }
                                if (z9 && this.bFS) {
                                    a aVar = this.bFF.get();
                                    if (!(aVar == null ? false : aVar.bFC) || a.bFs.WA()) {
                                        Wt();
                                    }
                                }
                                if (z9 && a.bFs.WB()) {
                                    this.bGb.finish();
                                }
                                if (!this.bFP && !this.bFR) {
                                    if (this.bFT) {
                                        Ws();
                                    }
                                    this.bFR = true;
                                    this.bFQ = false;
                                    a.bFs.notifyAll();
                                }
                                if (this.bFP && this.bFR) {
                                    this.bFR = false;
                                    a.bFs.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bFY = true;
                                    a.bFs.notifyAll();
                                }
                                if (Ww()) {
                                    if (!this.bFS) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bFs.b(this)) {
                                            try {
                                                this.bGb.start();
                                                this.bFS = true;
                                                z15 = true;
                                                a.bFs.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bFs.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bFS || this.bFT) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bFT = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bFT) {
                                        if (this.bGa) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bGa = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bFX = false;
                                        a.bFs.notifyAll();
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
                                a.bFs.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bFZ.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bFs) {
                            Ws();
                            Wt();
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
                        } else if (this.bGb.Wn()) {
                            synchronized (a.bFs) {
                                this.bFU = true;
                                a.bFs.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bFs) {
                                this.bFU = true;
                                this.bFQ = true;
                                a.bFs.notifyAll();
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
                            GL10 gl103 = (GL10) this.bGb.Wo();
                            a.bFs.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bFF.get();
                            if (aVar2 != null) {
                                aVar2.bFv.onSurfaceCreated(gl10, this.bGb.bFJ);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bFF.get();
                            if (aVar3 != null) {
                                aVar3.bFv.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bFF.get();
                        if (aVar4 != null) {
                            aVar4.bFv.onDrawFrame(gl10);
                        }
                        int Wp = this.bGb.Wp();
                        switch (Wp) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Wp);
                                synchronized (a.bFs) {
                                    this.bFQ = true;
                                    a.bFs.notifyAll();
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
                    synchronized (a.bFs) {
                        Ws();
                        Wt();
                        throw th;
                    }
                }
            }
        }

        public boolean Wv() {
            return this.bFS && this.bFT && Ww();
        }

        private boolean Ww() {
            return !this.bFO && this.bFP && !this.bFQ && this.mWidth > 0 && this.mHeight > 0 && (this.bFX || this.bFW == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bFs) {
                    this.bFW = i;
                    a.bFs.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bFs) {
                i = this.bFW;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bFs) {
                this.bFX = true;
                a.bFs.notifyAll();
            }
        }

        public void Wx() {
            synchronized (a.bFs) {
                this.bFP = true;
                this.bFU = false;
                a.bFs.notifyAll();
                while (this.bFR && !this.bFU && !this.bFM) {
                    try {
                        a.bFs.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bFs) {
                this.bFP = false;
                a.bFs.notifyAll();
                while (!this.bFR && !this.bFM) {
                    try {
                        a.bFs.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bFs) {
                this.bFN = true;
                a.bFs.notifyAll();
                while (!this.bFM && !this.bFO) {
                    try {
                        a.bFs.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bFs) {
                this.bFN = false;
                this.bFX = true;
                this.bFY = false;
                a.bFs.notifyAll();
                while (!this.bFM && this.bFO && !this.bFY) {
                    try {
                        a.bFs.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Y(int i, int i2) {
            synchronized (a.bFs) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bGa = true;
                this.bFX = true;
                this.bFY = false;
                a.bFs.notifyAll();
                while (!this.bFM && !this.bFO && !this.bFY && Wv()) {
                    try {
                        a.bFs.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Wy() {
            synchronized (a.bFs) {
                this.bFL = true;
                a.bFs.notifyAll();
                while (!this.bFM) {
                    try {
                        a.bFs.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Wz() {
            this.bFV = true;
            a.bFs.notifyAll();
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

    private void Wl() {
        if (this.bFu != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bGc;
        private int bGd;
        private boolean bGe;
        private boolean bGf;
        private boolean bGg;
        private i bGh;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bFM = true;
            if (this.bGh == iVar) {
                this.bGh = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bGh == iVar || this.bGh == null) {
                this.bGh = iVar;
                notifyAll();
                return true;
            }
            WC();
            if (this.bGf) {
                return true;
            }
            if (this.bGh != null) {
                this.bGh.Wz();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bGh == iVar) {
                this.bGh = null;
            }
            notifyAll();
        }

        public synchronized boolean WA() {
            return this.bGg;
        }

        public synchronized boolean WB() {
            WC();
            return !this.bGf;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bGe) {
                    WC();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bGd < 131072) {
                        this.bGf = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bGg = this.bGf ? false : true;
                    this.bGe = true;
                }
            }
        }

        private void WC() {
            if (!this.bGc) {
                this.bGf = true;
                this.bGc = true;
            }
        }
    }
}
