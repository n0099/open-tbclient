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
    private static final j bHI = new j();
    private final WeakReference<a> bHJ;
    private i bHK;
    private c.m bHL;
    private e bHM;
    private f bHN;
    private g bHO;
    private k bHP;
    private int bHQ;
    private int bHR;
    private boolean bHS;
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
        this.bHJ = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bHK != null) {
                this.bHK.WZ();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bHP = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bHQ = i2;
    }

    public int getDebugFlags() {
        return this.bHQ;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bHS = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bHS;
    }

    public void setRenderer(c.m mVar) {
        WM();
        if (this.bHM == null) {
            this.bHM = new m(true);
        }
        if (this.bHN == null) {
            this.bHN = new c();
        }
        if (this.bHO == null) {
            this.bHO = new d();
        }
        this.bHL = mVar;
        this.bHK = new i(this.bHJ);
        this.bHK.start();
    }

    public void setEGLContextFactory(f fVar) {
        WM();
        this.bHN = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        WM();
        this.bHO = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        WM();
        this.bHM = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        WM();
        this.bHR = i2;
    }

    public void setRenderMode(int i2) {
        this.bHK.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bHK.getRenderMode();
    }

    public void requestRender() {
        this.bHK.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bHK.WY();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bHK.ag(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bHK.ag(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bHK.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bHK.onPause();
    }

    public void onResume() {
        this.bHK.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bHL != null) {
            int renderMode = this.bHK != null ? this.bHK.getRenderMode() : 1;
            this.bHK = new i(this.bHJ);
            if (renderMode != 1) {
                this.bHK.setRenderMode(renderMode);
            }
            this.bHK.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bHK != null) {
            this.bHK.WZ();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bHR, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bHR == 0) {
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
        protected int[] bHT;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0076a(int[] iArr) {
            this.bHT = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bHT, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bHT, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (a.this.bHR == 2) {
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
        private WeakReference<a> bHV;
        EGL10 bHW;
        EGLDisplay bHX;
        EGLSurface bHY;
        EGLConfig bHZ;
        EGLContext bIa;

        public h(WeakReference<a> weakReference) {
            this.bHV = weakReference;
        }

        public void start() {
            this.bHW = (EGL10) EGLContext.getEGL();
            this.bHX = this.bHW.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bHX == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bHW.eglInitialize(this.bHX, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bHV.get();
            if (aVar != null) {
                this.bHZ = aVar.bHM.chooseConfig(this.bHW, this.bHX);
                try {
                    this.bIa = aVar.bHN.createContext(this.bHW, this.bHX, this.bHZ);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bHZ = null;
                this.bIa = null;
            }
            if (this.bIa == null || this.bIa == EGL10.EGL_NO_CONTEXT) {
                this.bIa = null;
                jf("createContext");
            }
            this.bHY = null;
        }

        public boolean WO() {
            if (this.bHW == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bHX == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bHZ == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            WS();
            a aVar = this.bHV.get();
            if (aVar != null) {
                this.bHY = aVar.bHO.createWindowSurface(this.bHW, this.bHX, this.bHZ, aVar.getSurfaceTexture());
            } else {
                this.bHY = null;
            }
            if (this.bHY == null || this.bHY == EGL10.EGL_NO_SURFACE) {
                if (this.bHW.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bHW.eglMakeCurrent(this.bHX, this.bHY, this.bHY, this.bIa)) {
                f("EGLHelper", "eglMakeCurrent", this.bHW.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL WP() {
            l lVar;
            GL gl = this.bIa.getGL();
            a aVar = this.bHV.get();
            if (aVar != null) {
                if (aVar.bHP != null) {
                    gl = aVar.bHP.wrap(gl);
                }
                if ((aVar.bHQ & 3) != 0) {
                    int i = 0;
                    if ((aVar.bHQ & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bHQ & 2) == 0) {
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

        public int WQ() {
            if (this.bHW.eglSwapBuffers(this.bHX, this.bHY)) {
                return 12288;
            }
            return this.bHW.eglGetError();
        }

        public void WR() {
            WS();
        }

        private void WS() {
            if (this.bHY != null && this.bHY != EGL10.EGL_NO_SURFACE) {
                this.bHW.eglMakeCurrent(this.bHX, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bHV.get();
                if (aVar != null) {
                    aVar.bHO.destroySurface(this.bHW, this.bHX, this.bHY);
                }
                this.bHY = null;
            }
        }

        public void finish() {
            if (this.bIa != null) {
                a aVar = this.bHV.get();
                if (aVar != null) {
                    try {
                        aVar.bHN.destroyContext(this.bHW, this.bHX, this.bIa);
                    } catch (Exception e) {
                    }
                }
                this.bIa = null;
            }
            if (this.bHX != null) {
                this.bHW.eglTerminate(this.bHX);
                this.bHX = null;
            }
        }

        private void jf(String str) {
            G(str, this.bHW.eglGetError());
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
        private WeakReference<a> bHV;
        private boolean bIb;
        private boolean bIc;
        private boolean bId;
        private boolean bIe;
        private boolean bIf;
        private boolean bIg;
        private boolean bIh;
        private boolean bIi;
        private boolean bIj;
        private boolean bIk;
        private boolean bIl;
        private boolean bIo;
        private h bIr;
        private ArrayList<Runnable> bIp = new ArrayList<>();
        private boolean bIq = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bIn = true;
        private int bIm = 1;

        i(WeakReference<a> weakReference) {
            this.bHV = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    WV();
                    a.bHI.a(this);
                } catch (Exception e) {
                    af.uU().aB(false);
                    a.bHI.a(this);
                }
            } catch (Throwable th) {
                a.bHI.a(this);
                throw th;
            }
        }

        private void WT() {
            if (this.bIj) {
                this.bIj = false;
                this.bIr.WR();
            }
        }

        private void WU() {
            if (this.bIi) {
                this.bIr.finish();
                this.bIi = false;
                a.bHI.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void WV() throws InterruptedException {
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
            this.bIr = new h(this.bHV);
            this.bIi = false;
            this.bIj = false;
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
                    synchronized (a.bHI) {
                        while (!this.bIb) {
                            if (this.bIp.isEmpty()) {
                                if (this.bIe != this.bId) {
                                    boolean z23 = this.bId;
                                    this.bIe = this.bId;
                                    a.bHI.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bIl) {
                                    WT();
                                    WU();
                                    this.bIl = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    WT();
                                    WU();
                                    z19 = false;
                                }
                                if (z9 && this.bIj) {
                                    WT();
                                }
                                if (z9 && this.bIi) {
                                    a aVar = this.bHV.get();
                                    if (!(aVar == null ? false : aVar.bHS) || a.bHI.Xb()) {
                                        WU();
                                    }
                                }
                                if (z9 && a.bHI.Xc()) {
                                    this.bIr.finish();
                                }
                                if (!this.bIf && !this.bIh) {
                                    if (this.bIj) {
                                        WT();
                                    }
                                    this.bIh = true;
                                    this.bIg = false;
                                    a.bHI.notifyAll();
                                }
                                if (this.bIf && this.bIh) {
                                    this.bIh = false;
                                    a.bHI.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bIo = true;
                                    a.bHI.notifyAll();
                                }
                                if (WX()) {
                                    if (!this.bIi) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bHI.b(this)) {
                                            try {
                                                this.bIr.start();
                                                this.bIi = true;
                                                z15 = true;
                                                a.bHI.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bHI.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bIi || this.bIj) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bIj = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bIj) {
                                        if (this.bIq) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bIq = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bIn = false;
                                        a.bHI.notifyAll();
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
                                a.bHI.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bIp.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bHI) {
                            WT();
                            WU();
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
                        } else if (this.bIr.WO()) {
                            synchronized (a.bHI) {
                                this.bIk = true;
                                a.bHI.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bHI) {
                                this.bIk = true;
                                this.bIg = true;
                                a.bHI.notifyAll();
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
                            GL10 gl103 = (GL10) this.bIr.WP();
                            a.bHI.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bHV.get();
                            if (aVar2 != null) {
                                aVar2.bHL.onSurfaceCreated(gl10, this.bIr.bHZ);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bHV.get();
                            if (aVar3 != null) {
                                aVar3.bHL.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bHV.get();
                        if (aVar4 != null) {
                            aVar4.bHL.onDrawFrame(gl10);
                        }
                        int WQ = this.bIr.WQ();
                        switch (WQ) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", WQ);
                                synchronized (a.bHI) {
                                    this.bIg = true;
                                    a.bHI.notifyAll();
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
                    synchronized (a.bHI) {
                        WT();
                        WU();
                        throw th;
                    }
                }
            }
        }

        public boolean WW() {
            return this.bIi && this.bIj && WX();
        }

        private boolean WX() {
            return !this.bIe && this.bIf && !this.bIg && this.mWidth > 0 && this.mHeight > 0 && (this.bIn || this.bIm == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bHI) {
                    this.bIm = i;
                    a.bHI.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bHI) {
                i = this.bIm;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bHI) {
                this.bIn = true;
                a.bHI.notifyAll();
            }
        }

        public void WY() {
            synchronized (a.bHI) {
                this.bIf = true;
                this.bIk = false;
                a.bHI.notifyAll();
                while (this.bIh && !this.bIk && !this.bIc) {
                    try {
                        a.bHI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bHI) {
                this.bIf = false;
                a.bHI.notifyAll();
                while (!this.bIh && !this.bIc) {
                    try {
                        a.bHI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bHI) {
                this.bId = true;
                a.bHI.notifyAll();
                while (!this.bIc && !this.bIe) {
                    try {
                        a.bHI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bHI) {
                this.bId = false;
                this.bIn = true;
                this.bIo = false;
                a.bHI.notifyAll();
                while (!this.bIc && this.bIe && !this.bIo) {
                    try {
                        a.bHI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ag(int i, int i2) {
            synchronized (a.bHI) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bIq = true;
                this.bIn = true;
                this.bIo = false;
                a.bHI.notifyAll();
                while (!this.bIc && !this.bIe && !this.bIo && WW()) {
                    try {
                        a.bHI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void WZ() {
            synchronized (a.bHI) {
                this.bIb = true;
                a.bHI.notifyAll();
                while (!this.bIc) {
                    try {
                        a.bHI.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Xa() {
            this.bIl = true;
            a.bHI.notifyAll();
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

    private void WM() {
        if (this.bHK != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bIs;
        private int bIt;
        private boolean bIu;
        private boolean bIv;
        private boolean bIw;
        private i bIx;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bIc = true;
            if (this.bIx == iVar) {
                this.bIx = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bIx == iVar || this.bIx == null) {
                this.bIx = iVar;
                notifyAll();
                return true;
            }
            Xd();
            if (this.bIv) {
                return true;
            }
            if (this.bIx != null) {
                this.bIx.Xa();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bIx == iVar) {
                this.bIx = null;
            }
            notifyAll();
        }

        public synchronized boolean Xb() {
            return this.bIw;
        }

        public synchronized boolean Xc() {
            Xd();
            return !this.bIv;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bIu) {
                    Xd();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bIt < 131072) {
                        this.bIv = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bIw = this.bIv ? false : true;
                    this.bIu = true;
                }
            }
        }

        private void Xd() {
            if (!this.bIs) {
                this.bIv = true;
                this.bIs = true;
            }
        }
    }
}
