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
    private static final j brh = new j(null);
    private final WeakReference<a> bri;
    private i brj;
    private c.m brk;
    private e brl;
    private f brm;
    private g brn;
    private k bro;
    private int brp;
    private int brq;
    private boolean brr;
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
        this.bri = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.brj != null) {
                this.brj.SU();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bro = kVar;
    }

    public void setDebugFlags(int i2) {
        this.brp = i2;
    }

    public int getDebugFlags() {
        return this.brp;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.brr = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.brr;
    }

    public void setRenderer(c.m mVar) {
        SH();
        if (this.brl == null) {
            this.brl = new m(true);
        }
        if (this.brm == null) {
            this.brm = new c(this, null);
        }
        if (this.brn == null) {
            this.brn = new d(null);
        }
        this.brk = mVar;
        this.brj = new i(this.bri);
        this.brj.start();
    }

    public void setEGLContextFactory(f fVar) {
        SH();
        this.brm = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        SH();
        this.brn = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        SH();
        this.brl = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        SH();
        this.brq = i2;
    }

    public void setRenderMode(int i2) {
        this.brj.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.brj.getRenderMode();
    }

    public void requestRender() {
        this.brj.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.brj.ST();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.brj.Y(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.brj.Y(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.brj.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.brj.onPause();
    }

    public void onResume() {
        this.brj.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.brk != null) {
            int renderMode = this.brj != null ? this.brj.getRenderMode() : 1;
            this.brj = new i(this.bri);
            if (renderMode != 1) {
                this.brj.setRenderMode(renderMode);
            }
            this.brj.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.brj != null) {
            this.brj.SU();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.brq, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.brq == 0) {
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
        protected int[] brs;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0052a(int[] iArr) {
            this.brs = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.brs, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.brs, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.brq == 2) {
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
        private WeakReference<a> bru;
        EGL10 brv;
        EGLDisplay brw;
        EGLSurface brx;
        EGLConfig bry;
        EGLContext brz;

        public h(WeakReference<a> weakReference) {
            this.bru = weakReference;
        }

        public void start() {
            this.brv = (EGL10) EGLContext.getEGL();
            this.brw = this.brv.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.brw == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.brv.eglInitialize(this.brw, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bru.get();
            if (aVar == null) {
                this.bry = null;
                this.brz = null;
            } else {
                this.bry = aVar.brl.chooseConfig(this.brv, this.brw);
                try {
                    this.brz = aVar.brm.createContext(this.brv, this.brw, this.bry);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.brz == null || this.brz == EGL10.EGL_NO_CONTEXT) {
                this.brz = null;
                hT("createContext");
            }
            this.brx = null;
        }

        public boolean SJ() {
            if (this.brv == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.brw == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bry == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            SN();
            a aVar = this.bru.get();
            if (aVar != null) {
                this.brx = aVar.brn.createWindowSurface(this.brv, this.brw, this.bry, aVar.getSurfaceTexture());
            } else {
                this.brx = null;
            }
            if (this.brx == null || this.brx == EGL10.EGL_NO_SURFACE) {
                if (this.brv.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.brv.eglMakeCurrent(this.brw, this.brx, this.brx, this.brz)) {
                f("EGLHelper", "eglMakeCurrent", this.brv.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL SK() {
            l lVar;
            GL gl = this.brz.getGL();
            a aVar = this.bru.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.bro != null) {
                gl = aVar.bro.wrap(gl);
            }
            if ((aVar.brp & 3) != 0) {
                int i = 0;
                if ((aVar.brp & 1) != 0) {
                    i = 1;
                }
                if ((aVar.brp & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int SL() {
            if (this.brv.eglSwapBuffers(this.brw, this.brx)) {
                return 12288;
            }
            return this.brv.eglGetError();
        }

        public void SM() {
            SN();
        }

        private void SN() {
            if (this.brx != null && this.brx != EGL10.EGL_NO_SURFACE) {
                this.brv.eglMakeCurrent(this.brw, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bru.get();
                if (aVar != null) {
                    aVar.brn.destroySurface(this.brv, this.brw, this.brx);
                }
                this.brx = null;
            }
        }

        public void finish() {
            if (this.brz != null) {
                a aVar = this.bru.get();
                if (aVar != null) {
                    try {
                        aVar.brm.destroyContext(this.brv, this.brw, this.brz);
                    } catch (Exception e) {
                    }
                }
                this.brz = null;
            }
            if (this.brw != null) {
                this.brv.eglTerminate(this.brw);
                this.brw = null;
            }
        }

        private void hT(String str) {
            F(str, this.brv.eglGetError());
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
        private boolean brA;
        private boolean brB;
        private boolean brC;
        private boolean brD;
        private boolean brE;
        private boolean brF;
        private boolean brG;
        private boolean brH;
        private boolean brI;
        private boolean brJ;
        private boolean brK;
        private boolean brN;
        private h brQ;
        private WeakReference<a> bru;
        private ArrayList<Runnable> brO = new ArrayList<>();
        private boolean brP = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean brM = true;
        private int brL = 1;

        i(WeakReference<a> weakReference) {
            this.bru = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    SQ();
                    a.brh.a(this);
                } catch (Exception e) {
                    ai.vJ().aF(false);
                    a.brh.a(this);
                }
            } catch (Throwable th) {
                a.brh.a(this);
                throw th;
            }
        }

        private void SO() {
            if (this.brI) {
                this.brI = false;
                this.brQ.SM();
            }
        }

        private void SP() {
            if (this.brH) {
                this.brQ.finish();
                this.brH = false;
                a.brh.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void SQ() throws InterruptedException {
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
            this.brQ = new h(this.bru);
            this.brH = false;
            this.brI = false;
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
                    synchronized (a.brh) {
                        while (!this.brA) {
                            if (this.brO.isEmpty()) {
                                if (this.brD != this.brC) {
                                    boolean z23 = this.brC;
                                    this.brD = this.brC;
                                    a.brh.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.brK) {
                                    SO();
                                    SP();
                                    this.brK = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    SO();
                                    SP();
                                    z20 = false;
                                }
                                if (z9 && this.brI) {
                                    SO();
                                }
                                if (z9 && this.brH) {
                                    a aVar = this.bru.get();
                                    if (!(aVar == null ? false : aVar.brr) || a.brh.SW()) {
                                        SP();
                                    }
                                }
                                if (z9 && a.brh.SX()) {
                                    this.brQ.finish();
                                }
                                if (!this.brE && !this.brG) {
                                    if (this.brI) {
                                        SO();
                                    }
                                    this.brG = true;
                                    this.brF = false;
                                    a.brh.notifyAll();
                                }
                                if (this.brE && this.brG) {
                                    this.brG = false;
                                    a.brh.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.brN = true;
                                    a.brh.notifyAll();
                                }
                                if (SS()) {
                                    if (!this.brH) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.brh.b(this)) {
                                            try {
                                                this.brQ.start();
                                                this.brH = true;
                                                z15 = true;
                                                a.brh.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.brh.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.brH || this.brI) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.brI = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.brI) {
                                        if (this.brP) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.brP = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.brM = false;
                                        a.brh.notifyAll();
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
                                a.brh.wait();
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
                                remove = this.brO.remove(0);
                            }
                        }
                        synchronized (a.brh) {
                            SO();
                            SP();
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
                        } else if (this.brQ.SJ()) {
                            synchronized (a.brh) {
                                this.brJ = true;
                                a.brh.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.brh) {
                                this.brJ = true;
                                this.brF = true;
                                a.brh.notifyAll();
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
                            GL10 gl103 = (GL10) this.brQ.SK();
                            a.brh.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bru.get();
                            if (aVar2 != null) {
                                aVar2.brk.onSurfaceCreated(gl10, this.brQ.bry);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.bru.get();
                            if (aVar3 != null) {
                                aVar3.brk.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.bru.get();
                        if (aVar4 != null) {
                            aVar4.brk.onDrawFrame(gl10);
                        }
                        int SL = this.brQ.SL();
                        switch (SL) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", SL);
                                synchronized (a.brh) {
                                    this.brF = true;
                                    a.brh.notifyAll();
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
                    synchronized (a.brh) {
                        SO();
                        SP();
                        throw th;
                    }
                }
            }
        }

        public boolean SR() {
            return this.brH && this.brI && SS();
        }

        private boolean SS() {
            return !this.brD && this.brE && !this.brF && this.mWidth > 0 && this.mHeight > 0 && (this.brM || this.brL == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.brh) {
                this.brL = i;
                a.brh.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.brh) {
                i = this.brL;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.brh) {
                this.brM = true;
                a.brh.notifyAll();
            }
        }

        public void ST() {
            synchronized (a.brh) {
                this.brE = true;
                this.brJ = false;
                a.brh.notifyAll();
                while (this.brG && !this.brJ && !this.brB) {
                    try {
                        a.brh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.brh) {
                this.brE = false;
                a.brh.notifyAll();
                while (!this.brG && !this.brB) {
                    try {
                        a.brh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.brh) {
                this.brC = true;
                a.brh.notifyAll();
                while (!this.brB && !this.brD) {
                    try {
                        a.brh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.brh) {
                this.brC = false;
                this.brM = true;
                this.brN = false;
                a.brh.notifyAll();
                while (!this.brB && this.brD && !this.brN) {
                    try {
                        a.brh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Y(int i, int i2) {
            synchronized (a.brh) {
                this.mWidth = i;
                this.mHeight = i2;
                this.brP = true;
                this.brM = true;
                this.brN = false;
                a.brh.notifyAll();
                while (!this.brB && !this.brD && !this.brN && SR()) {
                    try {
                        a.brh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void SU() {
            synchronized (a.brh) {
                this.brA = true;
                a.brh.notifyAll();
                while (!this.brB) {
                    try {
                        a.brh.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void SV() {
            this.brK = true;
            a.brh.notifyAll();
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

    private void SH() {
        if (this.brj != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean brR;
        private int brS;
        private boolean brT;
        private boolean brU;
        private boolean brV;
        private i brW;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.brB = true;
            if (this.brW == iVar) {
                this.brW = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.brW == iVar || this.brW == null) {
                this.brW = iVar;
                notifyAll();
                return true;
            }
            SY();
            if (this.brU) {
                return true;
            }
            if (this.brW != null) {
                this.brW.SV();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.brW == iVar) {
                this.brW = null;
            }
            notifyAll();
        }

        public synchronized boolean SW() {
            return this.brV;
        }

        public synchronized boolean SX() {
            SY();
            return !this.brU;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.brT) {
                    SY();
                    String glGetString = gl10.glGetString(7937);
                    if (this.brS < 131072) {
                        this.brU = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.brV = this.brU ? false : true;
                    this.brT = true;
                }
            }
        }

        private void SY() {
            if (!this.brR) {
                this.brU = true;
                this.brR = true;
            }
        }
    }
}
