package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ae;
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
    private static final j bBO = new j();
    private final WeakReference<a> bBP;
    private i bBQ;
    private c.m bBR;
    private e bBS;
    private f bBT;
    private g bBU;
    private k bBV;
    private int bBW;
    private int bBX;
    private boolean bBY;
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
        this.bBP = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bBQ != null) {
                this.bBQ.Vc();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bBV = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bBW = i2;
    }

    public int getDebugFlags() {
        return this.bBW;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bBY = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bBY;
    }

    public void setRenderer(c.m mVar) {
        UP();
        if (this.bBS == null) {
            this.bBS = new m(true);
        }
        if (this.bBT == null) {
            this.bBT = new c();
        }
        if (this.bBU == null) {
            this.bBU = new d();
        }
        this.bBR = mVar;
        this.bBQ = new i(this.bBP);
        this.bBQ.start();
    }

    public void setEGLContextFactory(f fVar) {
        UP();
        this.bBT = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        UP();
        this.bBU = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        UP();
        this.bBS = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        UP();
        this.bBX = i2;
    }

    public void setRenderMode(int i2) {
        this.bBQ.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bBQ.getRenderMode();
    }

    public void requestRender() {
        this.bBQ.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bBQ.Vb();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bBQ.Z(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bBQ.Z(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bBQ.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bBQ.onPause();
    }

    public void onResume() {
        this.bBQ.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bBR != null) {
            int renderMode = this.bBQ != null ? this.bBQ.getRenderMode() : 1;
            this.bBQ = new i(this.bBP);
            if (renderMode != 1) {
                this.bBQ.setRenderMode(renderMode);
            }
            this.bBQ.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bBQ != null) {
            this.bBQ.Vc();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bBX, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bBX == 0) {
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
    private abstract class AbstractC0073a implements e {
        protected int[] bBZ;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0073a(int[] iArr) {
            this.bBZ = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bBZ, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bBZ, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bBX == 2) {
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
    private class b extends AbstractC0073a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0073a
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
        private WeakReference<a> bCb;
        EGL10 bCc;
        EGLDisplay bCd;
        EGLSurface bCe;
        EGLConfig bCf;
        EGLContext bCg;

        public h(WeakReference<a> weakReference) {
            this.bCb = weakReference;
        }

        public void start() {
            this.bCc = (EGL10) EGLContext.getEGL();
            this.bCd = this.bCc.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bCd == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bCc.eglInitialize(this.bCd, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bCb.get();
            if (aVar != null) {
                this.bCf = aVar.bBS.chooseConfig(this.bCc, this.bCd);
                try {
                    this.bCg = aVar.bBT.createContext(this.bCc, this.bCd, this.bCf);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bCf = null;
                this.bCg = null;
            }
            if (this.bCg == null || this.bCg == EGL10.EGL_NO_CONTEXT) {
                this.bCg = null;
                iU("createContext");
            }
            this.bCe = null;
        }

        public boolean UR() {
            if (this.bCc == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bCd == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bCf == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            UV();
            a aVar = this.bCb.get();
            if (aVar != null) {
                this.bCe = aVar.bBU.createWindowSurface(this.bCc, this.bCd, this.bCf, aVar.getSurfaceTexture());
            } else {
                this.bCe = null;
            }
            if (this.bCe == null || this.bCe == EGL10.EGL_NO_SURFACE) {
                if (this.bCc.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bCc.eglMakeCurrent(this.bCd, this.bCe, this.bCe, this.bCg)) {
                f("EGLHelper", "eglMakeCurrent", this.bCc.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL US() {
            l lVar;
            GL gl = this.bCg.getGL();
            a aVar = this.bCb.get();
            if (aVar != null) {
                if (aVar.bBV != null) {
                    gl = aVar.bBV.wrap(gl);
                }
                if ((aVar.bBW & 3) != 0) {
                    int i = 0;
                    if ((aVar.bBW & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bBW & 2) == 0) {
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

        public int UT() {
            if (this.bCc.eglSwapBuffers(this.bCd, this.bCe)) {
                return 12288;
            }
            return this.bCc.eglGetError();
        }

        public void UU() {
            UV();
        }

        private void UV() {
            if (this.bCe != null && this.bCe != EGL10.EGL_NO_SURFACE) {
                this.bCc.eglMakeCurrent(this.bCd, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bCb.get();
                if (aVar != null) {
                    aVar.bBU.destroySurface(this.bCc, this.bCd, this.bCe);
                }
                this.bCe = null;
            }
        }

        public void finish() {
            if (this.bCg != null) {
                a aVar = this.bCb.get();
                if (aVar != null) {
                    try {
                        aVar.bBT.destroyContext(this.bCc, this.bCd, this.bCg);
                    } catch (Exception e) {
                    }
                }
                this.bCg = null;
            }
            if (this.bCd != null) {
                this.bCc.eglTerminate(this.bCd);
                this.bCd = null;
            }
        }

        private void iU(String str) {
            G(str, this.bCc.eglGetError());
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
        private WeakReference<a> bCb;
        private boolean bCh;
        private boolean bCi;
        private boolean bCj;
        private boolean bCk;
        private boolean bCl;
        private boolean bCm;
        private boolean bCn;
        private boolean bCo;
        private boolean bCp;
        private boolean bCq;
        private boolean bCr;
        private boolean bCu;
        private h bCx;
        private ArrayList<Runnable> bCv = new ArrayList<>();
        private boolean bCw = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bCt = true;
        private int bCs = 1;

        i(WeakReference<a> weakReference) {
            this.bCb = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    UY();
                    a.bBO.a(this);
                } catch (Exception e) {
                    ae.vz().aC(false);
                    a.bBO.a(this);
                }
            } catch (Throwable th) {
                a.bBO.a(this);
                throw th;
            }
        }

        private void UW() {
            if (this.bCp) {
                this.bCp = false;
                this.bCx.UU();
            }
        }

        private void UX() {
            if (this.bCo) {
                this.bCx.finish();
                this.bCo = false;
                a.bBO.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void UY() throws InterruptedException {
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
            this.bCx = new h(this.bCb);
            this.bCo = false;
            this.bCp = false;
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
                    synchronized (a.bBO) {
                        while (!this.bCh) {
                            if (this.bCv.isEmpty()) {
                                if (this.bCk != this.bCj) {
                                    boolean z23 = this.bCj;
                                    this.bCk = this.bCj;
                                    a.bBO.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bCr) {
                                    UW();
                                    UX();
                                    this.bCr = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    UW();
                                    UX();
                                    z19 = false;
                                }
                                if (z9 && this.bCp) {
                                    UW();
                                }
                                if (z9 && this.bCo) {
                                    a aVar = this.bCb.get();
                                    if (!(aVar == null ? false : aVar.bBY) || a.bBO.Ve()) {
                                        UX();
                                    }
                                }
                                if (z9 && a.bBO.Vf()) {
                                    this.bCx.finish();
                                }
                                if (!this.bCl && !this.bCn) {
                                    if (this.bCp) {
                                        UW();
                                    }
                                    this.bCn = true;
                                    this.bCm = false;
                                    a.bBO.notifyAll();
                                }
                                if (this.bCl && this.bCn) {
                                    this.bCn = false;
                                    a.bBO.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bCu = true;
                                    a.bBO.notifyAll();
                                }
                                if (Va()) {
                                    if (!this.bCo) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bBO.b(this)) {
                                            try {
                                                this.bCx.start();
                                                this.bCo = true;
                                                z15 = true;
                                                a.bBO.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bBO.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bCo || this.bCp) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bCp = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bCp) {
                                        if (this.bCw) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bCw = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bCt = false;
                                        a.bBO.notifyAll();
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
                                a.bBO.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bCv.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bBO) {
                            UW();
                            UX();
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
                        } else if (this.bCx.UR()) {
                            synchronized (a.bBO) {
                                this.bCq = true;
                                a.bBO.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bBO) {
                                this.bCq = true;
                                this.bCm = true;
                                a.bBO.notifyAll();
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
                            GL10 gl103 = (GL10) this.bCx.US();
                            a.bBO.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bCb.get();
                            if (aVar2 != null) {
                                aVar2.bBR.onSurfaceCreated(gl10, this.bCx.bCf);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bCb.get();
                            if (aVar3 != null) {
                                aVar3.bBR.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bCb.get();
                        if (aVar4 != null) {
                            aVar4.bBR.onDrawFrame(gl10);
                        }
                        int UT = this.bCx.UT();
                        switch (UT) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", UT);
                                synchronized (a.bBO) {
                                    this.bCm = true;
                                    a.bBO.notifyAll();
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
                    synchronized (a.bBO) {
                        UW();
                        UX();
                        throw th;
                    }
                }
            }
        }

        public boolean UZ() {
            return this.bCo && this.bCp && Va();
        }

        private boolean Va() {
            return !this.bCk && this.bCl && !this.bCm && this.mWidth > 0 && this.mHeight > 0 && (this.bCt || this.bCs == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bBO) {
                    this.bCs = i;
                    a.bBO.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bBO) {
                i = this.bCs;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bBO) {
                this.bCt = true;
                a.bBO.notifyAll();
            }
        }

        public void Vb() {
            synchronized (a.bBO) {
                this.bCl = true;
                this.bCq = false;
                a.bBO.notifyAll();
                while (this.bCn && !this.bCq && !this.bCi) {
                    try {
                        a.bBO.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bBO) {
                this.bCl = false;
                a.bBO.notifyAll();
                while (!this.bCn && !this.bCi) {
                    try {
                        a.bBO.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bBO) {
                this.bCj = true;
                a.bBO.notifyAll();
                while (!this.bCi && !this.bCk) {
                    try {
                        a.bBO.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bBO) {
                this.bCj = false;
                this.bCt = true;
                this.bCu = false;
                a.bBO.notifyAll();
                while (!this.bCi && this.bCk && !this.bCu) {
                    try {
                        a.bBO.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Z(int i, int i2) {
            synchronized (a.bBO) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bCw = true;
                this.bCt = true;
                this.bCu = false;
                a.bBO.notifyAll();
                while (!this.bCi && !this.bCk && !this.bCu && UZ()) {
                    try {
                        a.bBO.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vc() {
            synchronized (a.bBO) {
                this.bCh = true;
                a.bBO.notifyAll();
                while (!this.bCi) {
                    try {
                        a.bBO.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Vd() {
            this.bCr = true;
            a.bBO.notifyAll();
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

    private void UP() {
        if (this.bBQ != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bCA;
        private boolean bCB;
        private boolean bCC;
        private i bCD;
        private boolean bCy;
        private int bCz;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bCi = true;
            if (this.bCD == iVar) {
                this.bCD = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bCD == iVar || this.bCD == null) {
                this.bCD = iVar;
                notifyAll();
                return true;
            }
            Vg();
            if (this.bCB) {
                return true;
            }
            if (this.bCD != null) {
                this.bCD.Vd();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bCD == iVar) {
                this.bCD = null;
            }
            notifyAll();
        }

        public synchronized boolean Ve() {
            return this.bCC;
        }

        public synchronized boolean Vf() {
            Vg();
            return !this.bCB;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bCA) {
                    Vg();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bCz < 131072) {
                        this.bCB = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bCC = this.bCB ? false : true;
                    this.bCA = true;
                }
            }
        }

        private void Vg() {
            if (!this.bCy) {
                this.bCB = true;
                this.bCy = true;
            }
        }
    }
}
