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
    private static final j bXA = new j();
    private final WeakReference<a> bXB;
    private i bXC;
    private c.m bXD;
    private e bXE;
    private f bXF;
    private g bXG;
    private k bXH;
    private int bXI;
    private int bXJ;
    private boolean bXK;
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
        this.bXB = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bXC != null) {
                this.bXC.abe();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bXH = kVar;
    }

    public void setDebugFlags(int i2) {
        this.bXI = i2;
    }

    public int getDebugFlags() {
        return this.bXI;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bXK = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bXK;
    }

    public void setRenderer(c.m mVar) {
        aaR();
        if (this.bXE == null) {
            this.bXE = new m(true);
        }
        if (this.bXF == null) {
            this.bXF = new c();
        }
        if (this.bXG == null) {
            this.bXG = new d();
        }
        this.bXD = mVar;
        this.bXC = new i(this.bXB);
        this.bXC.start();
    }

    public void setEGLContextFactory(f fVar) {
        aaR();
        this.bXF = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aaR();
        this.bXG = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aaR();
        this.bXE = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        aaR();
        this.bXJ = i2;
    }

    public void setRenderMode(int i2) {
        this.bXC.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bXC.getRenderMode();
    }

    public void requestRender() {
        this.bXC.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bXC.abd();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bXC.aj(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bXC.aj(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bXC.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bXC.onPause();
    }

    public void onResume() {
        this.bXC.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bXD != null) {
            int renderMode = this.bXC != null ? this.bXC.getRenderMode() : 1;
            this.bXC = new i(this.bXB);
            if (renderMode != 1) {
                this.bXC.setRenderMode(renderMode);
            }
            this.bXC.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bXC != null) {
            this.bXC.abe();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bXJ, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bXJ == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.O("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0077a implements e {
        protected int[] bXL;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0077a(int[] iArr) {
            this.bXL = h(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXL, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bXL, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] h(int[] iArr) {
            if (a.this.bXJ == 2) {
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
    private class b extends AbstractC0077a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0077a
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
        private WeakReference<a> bXN;
        EGL10 bXO;
        EGLDisplay bXP;
        EGLSurface bXQ;
        EGLConfig bXR;
        EGLContext bXS;

        public h(WeakReference<a> weakReference) {
            this.bXN = weakReference;
        }

        public void start() {
            this.bXO = (EGL10) EGLContext.getEGL();
            this.bXP = this.bXO.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.bXP == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bXO.eglInitialize(this.bXP, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bXN.get();
            if (aVar != null) {
                this.bXR = aVar.bXE.chooseConfig(this.bXO, this.bXP);
                try {
                    this.bXS = aVar.bXF.createContext(this.bXO, this.bXP, this.bXR);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.bXR = null;
                this.bXS = null;
            }
            if (this.bXS == null || this.bXS == EGL10.EGL_NO_CONTEXT) {
                this.bXS = null;
                jK("createContext");
            }
            this.bXQ = null;
        }

        public boolean aaT() {
            if (this.bXO == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.bXP == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bXR == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            aaX();
            a aVar = this.bXN.get();
            if (aVar != null) {
                this.bXQ = aVar.bXG.createWindowSurface(this.bXO, this.bXP, this.bXR, aVar.getSurfaceTexture());
            } else {
                this.bXQ = null;
            }
            if (this.bXQ == null || this.bXQ == EGL10.EGL_NO_SURFACE) {
                if (this.bXO.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bXO.eglMakeCurrent(this.bXP, this.bXQ, this.bXQ, this.bXS)) {
                f("EGLHelper", "eglMakeCurrent", this.bXO.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aaU() {
            l lVar;
            GL gl = this.bXS.getGL();
            a aVar = this.bXN.get();
            if (aVar != null) {
                if (aVar.bXH != null) {
                    gl = aVar.bXH.wrap(gl);
                }
                if ((aVar.bXI & 3) != 0) {
                    int i = 0;
                    if ((aVar.bXI & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.bXI & 2) == 0) {
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

        public int aaV() {
            if (this.bXO.eglSwapBuffers(this.bXP, this.bXQ)) {
                return 12288;
            }
            return this.bXO.eglGetError();
        }

        public void aaW() {
            aaX();
        }

        private void aaX() {
            if (this.bXQ != null && this.bXQ != EGL10.EGL_NO_SURFACE) {
                this.bXO.eglMakeCurrent(this.bXP, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bXN.get();
                if (aVar != null) {
                    aVar.bXG.destroySurface(this.bXO, this.bXP, this.bXQ);
                }
                this.bXQ = null;
            }
        }

        public void finish() {
            if (this.bXS != null) {
                a aVar = this.bXN.get();
                if (aVar != null) {
                    try {
                        aVar.bXF.destroyContext(this.bXO, this.bXP, this.bXS);
                    } catch (Exception e) {
                    }
                }
                this.bXS = null;
            }
            if (this.bXP != null) {
                this.bXO.eglTerminate(this.bXP);
                this.bXP = null;
            }
        }

        private void jK(String str) {
            O(str, this.bXO.eglGetError());
        }

        public static void O(String str, int i) {
            throw new RuntimeException(P(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, P(str2, i));
        }

        public static String P(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> bXN;
        private boolean bXT;
        private boolean bXU;
        private boolean bXV;
        private boolean bXW;
        private boolean bXX;
        private boolean bXY;
        private boolean bXZ;
        private boolean bYa;
        private boolean bYb;
        private boolean bYc;
        private boolean bYd;
        private boolean bYg;
        private h bYj;
        private ArrayList<Runnable> bYh = new ArrayList<>();
        private boolean bYi = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean bYf = true;
        private int bYe = 1;

        i(WeakReference<a> weakReference) {
            this.bXN = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aba();
                    a.bXA.a(this);
                } catch (Exception e) {
                    af.ve().az(false);
                    a.bXA.a(this);
                }
            } catch (Throwable th) {
                a.bXA.a(this);
                throw th;
            }
        }

        private void aaY() {
            if (this.bYb) {
                this.bYb = false;
                this.bYj.aaW();
            }
        }

        private void aaZ() {
            if (this.bYa) {
                this.bYj.finish();
                this.bYa = false;
                a.bXA.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aba() throws InterruptedException {
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
            this.bYj = new h(this.bXN);
            this.bYa = false;
            this.bYb = false;
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
                    synchronized (a.bXA) {
                        while (!this.bXT) {
                            if (this.bYh.isEmpty()) {
                                if (this.bXW != this.bXV) {
                                    boolean z23 = this.bXV;
                                    this.bXW = this.bXV;
                                    a.bXA.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.bYd) {
                                    aaY();
                                    aaZ();
                                    this.bYd = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aaY();
                                    aaZ();
                                    z19 = false;
                                }
                                if (z9 && this.bYb) {
                                    aaY();
                                }
                                if (z9 && this.bYa) {
                                    a aVar = this.bXN.get();
                                    if (!(aVar == null ? false : aVar.bXK) || a.bXA.abg()) {
                                        aaZ();
                                    }
                                }
                                if (z9 && a.bXA.abh()) {
                                    this.bYj.finish();
                                }
                                if (!this.bXX && !this.bXZ) {
                                    if (this.bYb) {
                                        aaY();
                                    }
                                    this.bXZ = true;
                                    this.bXY = false;
                                    a.bXA.notifyAll();
                                }
                                if (this.bXX && this.bXZ) {
                                    this.bXZ = false;
                                    a.bXA.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.bYg = true;
                                    a.bXA.notifyAll();
                                }
                                if (abc()) {
                                    if (!this.bYa) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bXA.b(this)) {
                                            try {
                                                this.bYj.start();
                                                this.bYa = true;
                                                z15 = true;
                                                a.bXA.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bXA.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.bYa || this.bYb) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.bYb = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.bYb) {
                                        if (this.bYi) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.bYi = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.bYf = false;
                                        a.bXA.notifyAll();
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
                                a.bXA.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.bYh.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.bXA) {
                            aaY();
                            aaZ();
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
                        } else if (this.bYj.aaT()) {
                            synchronized (a.bXA) {
                                this.bYc = true;
                                a.bXA.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bXA) {
                                this.bYc = true;
                                this.bXY = true;
                                a.bXA.notifyAll();
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
                            GL10 gl103 = (GL10) this.bYj.aaU();
                            a.bXA.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bXN.get();
                            if (aVar2 != null) {
                                aVar2.bXD.onSurfaceCreated(gl10, this.bYj.bXR);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.bXN.get();
                            if (aVar3 != null) {
                                aVar3.bXD.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.bXN.get();
                        if (aVar4 != null) {
                            aVar4.bXD.onDrawFrame(gl10);
                        }
                        int aaV = this.bYj.aaV();
                        switch (aaV) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", aaV);
                                synchronized (a.bXA) {
                                    this.bXY = true;
                                    a.bXA.notifyAll();
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
                    synchronized (a.bXA) {
                        aaY();
                        aaZ();
                        throw th;
                    }
                }
            }
        }

        public boolean abb() {
            return this.bYa && this.bYb && abc();
        }

        private boolean abc() {
            return !this.bXW && this.bXX && !this.bXY && this.mWidth > 0 && this.mHeight > 0 && (this.bYf || this.bYe == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.bXA) {
                    this.bYe = i;
                    a.bXA.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bXA) {
                i = this.bYe;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bXA) {
                this.bYf = true;
                a.bXA.notifyAll();
            }
        }

        public void abd() {
            synchronized (a.bXA) {
                this.bXX = true;
                this.bYc = false;
                a.bXA.notifyAll();
                while (this.bXZ && !this.bYc && !this.bXU) {
                    try {
                        a.bXA.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.bXA) {
                this.bXX = false;
                a.bXA.notifyAll();
                while (!this.bXZ && !this.bXU) {
                    try {
                        a.bXA.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bXA) {
                this.bXV = true;
                a.bXA.notifyAll();
                while (!this.bXU && !this.bXW) {
                    try {
                        a.bXA.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bXA) {
                this.bXV = false;
                this.bYf = true;
                this.bYg = false;
                a.bXA.notifyAll();
                while (!this.bXU && this.bXW && !this.bYg) {
                    try {
                        a.bXA.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aj(int i, int i2) {
            synchronized (a.bXA) {
                this.mWidth = i;
                this.mHeight = i2;
                this.bYi = true;
                this.bYf = true;
                this.bYg = false;
                a.bXA.notifyAll();
                while (!this.bXU && !this.bXW && !this.bYg && abb()) {
                    try {
                        a.bXA.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abe() {
            synchronized (a.bXA) {
                this.bXT = true;
                a.bXA.notifyAll();
                while (!this.bXU) {
                    try {
                        a.bXA.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void abf() {
            this.bYd = true;
            a.bXA.notifyAll();
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

    private void aaR() {
        if (this.bXC != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean bYk;
        private int bYl;
        private boolean bYm;
        private boolean bYn;
        private boolean bYo;
        private i bYp;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.bXU = true;
            if (this.bYp == iVar) {
                this.bYp = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.bYp == iVar || this.bYp == null) {
                this.bYp = iVar;
                notifyAll();
                return true;
            }
            abi();
            if (this.bYn) {
                return true;
            }
            if (this.bYp != null) {
                this.bYp.abf();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.bYp == iVar) {
                this.bYp = null;
            }
            notifyAll();
        }

        public synchronized boolean abg() {
            return this.bYo;
        }

        public synchronized boolean abh() {
            abi();
            return !this.bYn;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.bYm) {
                    abi();
                    String glGetString = gl10.glGetString(7937);
                    if (this.bYl < 131072) {
                        this.bYn = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.bYo = this.bYn ? false : true;
                    this.bYm = true;
                }
            }
        }

        private void abi() {
            if (!this.bYk) {
                this.bYn = true;
                this.bYk = true;
            }
        }
    }
}
