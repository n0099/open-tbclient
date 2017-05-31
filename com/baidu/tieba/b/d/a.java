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
    private static final j bsL = new j(null);
    private final WeakReference<a> bsM;
    private i bsN;
    private c.m bsO;
    private e bsP;
    private f bsQ;
    private g bsR;
    private k bsS;
    private int bsT;
    private int bsU;
    private boolean bsV;
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
        this.bsM = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bsN != null) {
                this.bsN.SB();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bsS = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bsT = i2;
    }

    public int getDebugFlags() {
        return this.bsT;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bsV = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bsV;
    }

    public void setRenderer(c.m mVar) {
        So();
        if (this.bsP == null) {
            this.bsP = new m(true);
        }
        if (this.bsQ == null) {
            this.bsQ = new c(this, null);
        }
        if (this.bsR == null) {
            this.bsR = new d(null);
        }
        this.bsO = mVar;
        this.bsN = new i(this.bsM);
        this.bsN.start();
    }

    public void setEGLContextFactory(f fVar) {
        So();
        this.bsQ = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        So();
        this.bsR = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        So();
        this.bsP = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        So();
        this.bsU = i2;
    }

    public void setRenderMode(int i2) {
        this.bsN.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bsN.getRenderMode();
    }

    public void requestRender() {
        this.bsN.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bsN.SA();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bsN.X(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bsN.X(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bsN.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bsN.onPause();
    }

    public void onResume() {
        this.bsN.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bsO != null) {
            int renderMode = this.bsN != null ? this.bsN.getRenderMode() : 1;
            this.bsN = new i(this.bsM);
            if (renderMode != 1) {
                this.bsN.setRenderMode(renderMode);
            }
            this.bsN.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bsN != null) {
            this.bsN.SB();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bsU, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bsU == 0) {
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
    private abstract class AbstractC0056a implements e {
        protected int[] bsW;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0056a(int[] iArr) {
            this.bsW = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bsW, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bsW, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bsU == 2) {
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
    private class b extends AbstractC0056a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0056a
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
        private WeakReference<a> bsY;
        EGL10 bsZ;
        EGLDisplay bta;
        EGLSurface btb;
        EGLConfig btc;
        EGLContext btd;

        public h(WeakReference<a> weakReference) {
            this.bsY = weakReference;
        }

        public void start() {
            this.bsZ = (EGL10) EGLContext.getEGL();
            this.bta = this.bsZ.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bta == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bsZ.eglInitialize(this.bta, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bsY.get();
            if (aVar == null) {
                this.btc = null;
                this.btd = null;
            } else {
                this.btc = aVar.bsP.chooseConfig(this.bsZ, this.bta);
                try {
                    this.btd = aVar.bsQ.createContext(this.bsZ, this.bta, this.btc);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.btd == null || this.btd == EGL10.EGL_NO_CONTEXT) {
                this.btd = null;
                hT("createContext");
            }
            this.btb = null;
        }

        public boolean Sq() {
            if (this.bsZ == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bta == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.btc == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Su();
            a aVar = this.bsY.get();
            if (aVar != null) {
                this.btb = aVar.bsR.createWindowSurface(this.bsZ, this.bta, this.btc, aVar.getSurfaceTexture());
            } else {
                this.btb = null;
            }
            if (this.btb == null || this.btb == EGL10.EGL_NO_SURFACE) {
                if (this.bsZ.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bsZ.eglMakeCurrent(this.bta, this.btb, this.btb, this.btd)) {
                f("EGLHelper", "eglMakeCurrent", this.bsZ.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Sr() {
            l lVar;
            GL gl = this.btd.getGL();
            a aVar = this.bsY.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.bsS != null) {
                gl = aVar.bsS.wrap(gl);
            }
            if ((aVar.bsT & 3) != 0) {
                int i = 0;
                if ((aVar.bsT & 1) != 0) {
                    i = 1;
                }
                if ((aVar.bsT & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Ss() {
            if (this.bsZ.eglSwapBuffers(this.bta, this.btb)) {
                return 12288;
            }
            return this.bsZ.eglGetError();
        }

        public void St() {
            Su();
        }

        private void Su() {
            if (this.btb != null && this.btb != EGL10.EGL_NO_SURFACE) {
                this.bsZ.eglMakeCurrent(this.bta, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bsY.get();
                if (aVar != null) {
                    aVar.bsR.destroySurface(this.bsZ, this.bta, this.btb);
                }
                this.btb = null;
            }
        }

        public void finish() {
            if (this.btd != null) {
                a aVar = this.bsY.get();
                if (aVar != null) {
                    try {
                        aVar.bsQ.destroyContext(this.bsZ, this.bta, this.btd);
                    } catch (Exception e) {
                    }
                }
                this.btd = null;
            }
            if (this.bta != null) {
                this.bsZ.eglTerminate(this.bta);
                this.bta = null;
            }
        }

        private void hT(String str) {
            F(str, this.bsZ.eglGetError());
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
        private WeakReference<a> bsY;
        private boolean bte;
        private boolean btf;
        private boolean btg;
        private boolean bth;
        private boolean bti;
        private boolean btj;
        private boolean btk;
        private boolean btl;
        private boolean btm;
        private boolean bto;
        private boolean btp;
        private boolean bts;
        private h btv;
        private ArrayList<Runnable> btt = new ArrayList<>();
        private boolean btu = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean btr = true;
        private int btq = 1;

        i(WeakReference<a> weakReference) {
            this.bsY = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Sx();
                    a.bsL.a(this);
                } catch (Exception e) {
                    ai.uT().aC(false);
                    a.bsL.a(this);
                }
            } catch (Throwable th) {
                a.bsL.a(this);
                throw th;
            }
        }

        private void Sv() {
            if (this.btm) {
                this.btm = false;
                this.btv.St();
            }
        }

        private void Sw() {
            if (this.btl) {
                this.btv.finish();
                this.btl = false;
                a.bsL.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Sx() throws InterruptedException {
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
            this.btv = new h(this.bsY);
            this.btl = false;
            this.btm = false;
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
                    synchronized (a.bsL) {
                        while (!this.bte) {
                            if (this.btt.isEmpty()) {
                                if (this.bth != this.btg) {
                                    boolean z23 = this.btg;
                                    this.bth = this.btg;
                                    a.bsL.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.btp) {
                                    Sv();
                                    Sw();
                                    this.btp = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Sv();
                                    Sw();
                                    z20 = false;
                                }
                                if (z9 && this.btm) {
                                    Sv();
                                }
                                if (z9 && this.btl) {
                                    a aVar = this.bsY.get();
                                    if (!(aVar == null ? false : aVar.bsV) || a.bsL.SD()) {
                                        Sw();
                                    }
                                }
                                if (z9 && a.bsL.SE()) {
                                    this.btv.finish();
                                }
                                if (!this.bti && !this.btk) {
                                    if (this.btm) {
                                        Sv();
                                    }
                                    this.btk = true;
                                    this.btj = false;
                                    a.bsL.notifyAll();
                                }
                                if (this.bti && this.btk) {
                                    this.btk = false;
                                    a.bsL.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.bts = true;
                                    a.bsL.notifyAll();
                                }
                                if (Sz()) {
                                    if (!this.btl) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bsL.b(this)) {
                                            try {
                                                this.btv.start();
                                                this.btl = true;
                                                z15 = true;
                                                a.bsL.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bsL.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.btl || this.btm) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.btm = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.btm) {
                                        if (this.btu) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.btu = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.btr = false;
                                        a.bsL.notifyAll();
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
                                a.bsL.wait();
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
                                remove = this.btt.remove(0);
                            }
                        }
                        synchronized (a.bsL) {
                            Sv();
                            Sw();
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
                        } else if (this.btv.Sq()) {
                            synchronized (a.bsL) {
                                this.bto = true;
                                a.bsL.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bsL) {
                                this.bto = true;
                                this.btj = true;
                                a.bsL.notifyAll();
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
                            GL10 gl103 = (GL10) this.btv.Sr();
                            a.bsL.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bsY.get();
                            if (aVar2 != null) {
                                aVar2.bsO.onSurfaceCreated(gl10, this.btv.btc);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.bsY.get();
                            if (aVar3 != null) {
                                aVar3.bsO.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.bsY.get();
                        if (aVar4 != null) {
                            aVar4.bsO.onDrawFrame(gl10);
                        }
                        int Ss = this.btv.Ss();
                        switch (Ss) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Ss);
                                synchronized (a.bsL) {
                                    this.btj = true;
                                    a.bsL.notifyAll();
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
                    synchronized (a.bsL) {
                        Sv();
                        Sw();
                        throw th;
                    }
                }
            }
        }

        public boolean Sy() {
            return this.btl && this.btm && Sz();
        }

        private boolean Sz() {
            return !this.bth && this.bti && !this.btj && this.mWidth > 0 && this.mHeight > 0 && (this.btr || this.btq == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.bsL) {
                this.btq = i;
                a.bsL.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bsL) {
                i = this.btq;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bsL) {
                this.btr = true;
                a.bsL.notifyAll();
            }
        }

        public void SA() {
            synchronized (a.bsL) {
                this.bti = true;
                this.bto = false;
                a.bsL.notifyAll();
                while (this.btk && !this.bto && !this.btf) {
                    try {
                        a.bsL.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bsL) {
                this.bti = false;
                a.bsL.notifyAll();
                while (!this.btk && !this.btf) {
                    try {
                        a.bsL.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bsL) {
                this.btg = true;
                a.bsL.notifyAll();
                while (!this.btf && !this.bth) {
                    try {
                        a.bsL.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bsL) {
                this.btg = false;
                this.btr = true;
                this.bts = false;
                a.bsL.notifyAll();
                while (!this.btf && this.bth && !this.bts) {
                    try {
                        a.bsL.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void X(int i, int i2) {
            synchronized (a.bsL) {
                this.mWidth = i;
                this.mHeight = i2;
                this.btu = true;
                this.btr = true;
                this.bts = false;
                a.bsL.notifyAll();
                while (!this.btf && !this.bth && !this.bts && Sy()) {
                    try {
                        a.bsL.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void SB() {
            synchronized (a.bsL) {
                this.bte = true;
                a.bsL.notifyAll();
                while (!this.btf) {
                    try {
                        a.bsL.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void SC() {
            this.btp = true;
            a.bsL.notifyAll();
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

    private void So() {
        if (this.bsN != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean btA;
        private i btB;
        private boolean btw;
        private int btx;
        private boolean bty;
        private boolean btz;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.btf = true;
            if (this.btB == iVar) {
                this.btB = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.btB == iVar || this.btB == null) {
                this.btB = iVar;
                notifyAll();
                return true;
            }
            SF();
            if (this.btz) {
                return true;
            }
            if (this.btB != null) {
                this.btB.SC();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.btB == iVar) {
                this.btB = null;
            }
            notifyAll();
        }

        public synchronized boolean SD() {
            return this.btA;
        }

        public synchronized boolean SE() {
            SF();
            return !this.btz;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bty) {
                    SF();
                    String glGetString = gl10.glGetString(7937);
                    if (this.btx < 131072) {
                        this.btz = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.btA = this.btz ? false : true;
                    this.bty = true;
                }
            }
        }

        private void SF() {
            if (!this.btw) {
                this.btz = true;
                this.btw = true;
            }
        }
    }
}
