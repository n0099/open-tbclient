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
    private static final j cRl = new j();
    private final WeakReference<a> cRm;
    private i cRn;
    private c.m cRo;
    private e cRp;
    private f cRq;
    private g cRr;
    private k cRs;
    private int cRt;
    private int cRu;
    private boolean cRv;
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
        this.cRm = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cRn != null) {
                this.cRn.ajT();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cRs = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cRt = i2;
    }

    public int getDebugFlags() {
        return this.cRt;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cRv = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cRv;
    }

    public void setRenderer(c.m mVar) {
        ajG();
        if (this.cRp == null) {
            this.cRp = new m(true);
        }
        if (this.cRq == null) {
            this.cRq = new c();
        }
        if (this.cRr == null) {
            this.cRr = new d();
        }
        this.cRo = mVar;
        this.cRn = new i(this.cRm);
        this.cRn.start();
    }

    public void setEGLContextFactory(f fVar) {
        ajG();
        this.cRq = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        ajG();
        this.cRr = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        ajG();
        this.cRp = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        ajG();
        this.cRu = i2;
    }

    public void setRenderMode(int i2) {
        this.cRn.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cRn.getRenderMode();
    }

    public void requestRender() {
        this.cRn.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cRn.ajS();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cRn.bj(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cRn.bj(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cRn.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cRn.onPause();
    }

    public void onResume() {
        this.cRn.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cRo != null) {
            int renderMode = this.cRn != null ? this.cRn.getRenderMode() : 1;
            this.cRn = new i(this.cRm);
            if (renderMode != 1) {
                this.cRn.setRenderMode(renderMode);
            }
            this.cRn.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cRn != null) {
            this.cRn.ajT();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.cRu, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.cRu == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.S("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0103a implements e {
        protected int[] cRw;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0103a(int[] iArr) {
            this.cRw = o(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cRw, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cRw, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] o(int[] iArr) {
            if (a.this.cRu == 2) {
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
    private class b extends AbstractC0103a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0103a
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
        EGLDisplay cRA;
        EGLSurface cRB;
        EGLConfig cRC;
        EGLContext cRD;
        private WeakReference<a> cRy;
        EGL10 cRz;

        public h(WeakReference<a> weakReference) {
            this.cRy = weakReference;
        }

        public void start() {
            this.cRz = (EGL10) EGLContext.getEGL();
            this.cRA = this.cRz.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cRA == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cRz.eglInitialize(this.cRA, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.cRy.get();
            if (aVar != null) {
                this.cRC = aVar.cRp.chooseConfig(this.cRz, this.cRA);
                try {
                    this.cRD = aVar.cRq.createContext(this.cRz, this.cRA, this.cRC);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.cRC = null;
                this.cRD = null;
            }
            if (this.cRD == null || this.cRD == EGL10.EGL_NO_CONTEXT) {
                this.cRD = null;
                ke("createContext");
            }
            this.cRB = null;
        }

        public boolean ajI() {
            if (this.cRz == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cRA == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cRC == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ajM();
            a aVar = this.cRy.get();
            if (aVar != null) {
                this.cRB = aVar.cRr.createWindowSurface(this.cRz, this.cRA, this.cRC, aVar.getSurfaceTexture());
            } else {
                this.cRB = null;
            }
            if (this.cRB == null || this.cRB == EGL10.EGL_NO_SURFACE) {
                if (this.cRz.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cRz.eglMakeCurrent(this.cRA, this.cRB, this.cRB, this.cRD)) {
                f("EGLHelper", "eglMakeCurrent", this.cRz.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL ajJ() {
            l lVar;
            GL gl = this.cRD.getGL();
            a aVar = this.cRy.get();
            if (aVar != null) {
                if (aVar.cRs != null) {
                    gl = aVar.cRs.wrap(gl);
                }
                if ((aVar.cRt & 3) != 0) {
                    int i = 0;
                    if ((aVar.cRt & 1) != 0) {
                        i = 1;
                    }
                    if ((aVar.cRt & 2) == 0) {
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

        public int ajK() {
            if (this.cRz.eglSwapBuffers(this.cRA, this.cRB)) {
                return 12288;
            }
            return this.cRz.eglGetError();
        }

        public void ajL() {
            ajM();
        }

        private void ajM() {
            if (this.cRB != null && this.cRB != EGL10.EGL_NO_SURFACE) {
                this.cRz.eglMakeCurrent(this.cRA, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.cRy.get();
                if (aVar != null) {
                    aVar.cRr.destroySurface(this.cRz, this.cRA, this.cRB);
                }
                this.cRB = null;
            }
        }

        public void finish() {
            if (this.cRD != null) {
                a aVar = this.cRy.get();
                if (aVar != null) {
                    try {
                        aVar.cRq.destroyContext(this.cRz, this.cRA, this.cRD);
                    } catch (Exception e) {
                    }
                }
                this.cRD = null;
            }
            if (this.cRA != null) {
                this.cRz.eglTerminate(this.cRA);
                this.cRA = null;
            }
        }

        private void ke(String str) {
            S(str, this.cRz.eglGetError());
        }

        public static void S(String str, int i) {
            throw new RuntimeException(T(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, T(str2, i));
        }

        public static String T(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean cRE;
        private boolean cRF;
        private boolean cRG;
        private boolean cRH;
        private boolean cRI;
        private boolean cRJ;
        private boolean cRK;
        private boolean cRL;
        private boolean cRM;
        private boolean cRN;
        private boolean cRQ;
        private h cRT;
        private WeakReference<a> cRy;
        private boolean vv;
        private ArrayList<Runnable> cRR = new ArrayList<>();
        private boolean cRS = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cRP = true;
        private int cRO = 1;

        i(WeakReference<a> weakReference) {
            this.cRy = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    ajP();
                    a.cRl.a(this);
                } catch (Exception e) {
                    af.Cu().bi(false);
                    a.cRl.a(this);
                }
            } catch (Throwable th) {
                a.cRl.a(this);
                throw th;
            }
        }

        private void ajN() {
            if (this.cRL) {
                this.cRL = false;
                this.cRT.ajL();
            }
        }

        private void ajO() {
            if (this.cRK) {
                this.cRT.finish();
                this.cRK = false;
                a.cRl.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void ajP() throws InterruptedException {
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
            this.cRT = new h(this.cRy);
            this.cRK = false;
            this.cRL = false;
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
                    synchronized (a.cRl) {
                        while (!this.cRE) {
                            if (this.cRR.isEmpty()) {
                                if (this.vv != this.cRG) {
                                    boolean z23 = this.cRG;
                                    this.vv = this.cRG;
                                    a.cRl.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cRN) {
                                    ajN();
                                    ajO();
                                    this.cRN = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    ajN();
                                    ajO();
                                    z19 = false;
                                }
                                if (z9 && this.cRL) {
                                    ajN();
                                }
                                if (z9 && this.cRK) {
                                    a aVar = this.cRy.get();
                                    if (!(aVar == null ? false : aVar.cRv) || a.cRl.ajV()) {
                                        ajO();
                                    }
                                }
                                if (z9 && a.cRl.ajW()) {
                                    this.cRT.finish();
                                }
                                if (!this.cRH && !this.cRJ) {
                                    if (this.cRL) {
                                        ajN();
                                    }
                                    this.cRJ = true;
                                    this.cRI = false;
                                    a.cRl.notifyAll();
                                }
                                if (this.cRH && this.cRJ) {
                                    this.cRJ = false;
                                    a.cRl.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cRQ = true;
                                    a.cRl.notifyAll();
                                }
                                if (ajR()) {
                                    if (!this.cRK) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.cRl.b(this)) {
                                            try {
                                                this.cRT.start();
                                                this.cRK = true;
                                                z15 = true;
                                                a.cRl.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.cRl.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cRK || this.cRL) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cRL = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cRL) {
                                        if (this.cRS) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cRS = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cRP = false;
                                        a.cRl.notifyAll();
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
                                a.cRl.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cRR.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (a.cRl) {
                            ajN();
                            ajO();
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
                        } else if (this.cRT.ajI()) {
                            synchronized (a.cRl) {
                                this.cRM = true;
                                a.cRl.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.cRl) {
                                this.cRM = true;
                                this.cRI = true;
                                a.cRl.notifyAll();
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
                            GL10 gl103 = (GL10) this.cRT.ajJ();
                            a.cRl.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.cRy.get();
                            if (aVar2 != null) {
                                aVar2.cRo.onSurfaceCreated(gl10, this.cRT.cRC);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            a aVar3 = this.cRy.get();
                            if (aVar3 != null) {
                                aVar3.cRo.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        a aVar4 = this.cRy.get();
                        if (aVar4 != null) {
                            aVar4.cRo.onDrawFrame(gl10);
                        }
                        int ajK = this.cRT.ajK();
                        switch (ajK) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", ajK);
                                synchronized (a.cRl) {
                                    this.cRI = true;
                                    a.cRl.notifyAll();
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
                    synchronized (a.cRl) {
                        ajN();
                        ajO();
                        throw th;
                    }
                }
            }
        }

        public boolean ajQ() {
            return this.cRK && this.cRL && ajR();
        }

        private boolean ajR() {
            return !this.vv && this.cRH && !this.cRI && this.mWidth > 0 && this.mHeight > 0 && (this.cRP || this.cRO == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (a.cRl) {
                    this.cRO = i;
                    a.cRl.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (a.cRl) {
                i = this.cRO;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.cRl) {
                this.cRP = true;
                a.cRl.notifyAll();
            }
        }

        public void ajS() {
            synchronized (a.cRl) {
                this.cRH = true;
                this.cRM = false;
                a.cRl.notifyAll();
                while (this.cRJ && !this.cRM && !this.cRF) {
                    try {
                        a.cRl.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (a.cRl) {
                this.cRH = false;
                a.cRl.notifyAll();
                while (!this.cRJ && !this.cRF) {
                    try {
                        a.cRl.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.cRl) {
                this.cRG = true;
                a.cRl.notifyAll();
                while (!this.cRF && !this.vv) {
                    try {
                        a.cRl.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.cRl) {
                this.cRG = false;
                this.cRP = true;
                this.cRQ = false;
                a.cRl.notifyAll();
                while (!this.cRF && this.vv && !this.cRQ) {
                    try {
                        a.cRl.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void bj(int i, int i2) {
            synchronized (a.cRl) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cRS = true;
                this.cRP = true;
                this.cRQ = false;
                a.cRl.notifyAll();
                while (!this.cRF && !this.vv && !this.cRQ && ajQ()) {
                    try {
                        a.cRl.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ajT() {
            synchronized (a.cRl) {
                this.cRE = true;
                a.cRl.notifyAll();
                while (!this.cRF) {
                    try {
                        a.cRl.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ajU() {
            this.cRN = true;
            a.cRl.notifyAll();
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

    private void ajG() {
        if (this.cRn != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cRU;
        private int cRV;
        private boolean cRW;
        private boolean cRX;
        private boolean cRY;
        private i cRZ;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cRF = true;
            if (this.cRZ == iVar) {
                this.cRZ = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cRZ == iVar || this.cRZ == null) {
                this.cRZ = iVar;
                notifyAll();
                return true;
            }
            ajX();
            if (this.cRX) {
                return true;
            }
            if (this.cRZ != null) {
                this.cRZ.ajU();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cRZ == iVar) {
                this.cRZ = null;
            }
            notifyAll();
        }

        public synchronized boolean ajV() {
            return this.cRY;
        }

        public synchronized boolean ajW() {
            ajX();
            return !this.cRX;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cRW) {
                    ajX();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cRV < 131072) {
                        this.cRX = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cRY = this.cRX ? false : true;
                    this.cRW = true;
                }
            }
        }

        private void ajX() {
            if (!this.cRU) {
                this.cRX = true;
                this.cRU = true;
            }
        }
    }
}
