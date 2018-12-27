package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.animation3d.View.TBGLSurfaceView;
import com.baidu.webkit.internal.Statistics;
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
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j cTD = new j();
    private final WeakReference<GLTextureView> cTE;
    private i cTF;
    private TBGLSurfaceView.m cTG;
    private e cTH;
    private f cTI;
    private g cTJ;
    private k cTK;
    private int cTL;
    private int cTM;
    private boolean cTN;
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

    public GLTextureView(Context context) {
        super(context);
        this.cTE = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cTE = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cTF != null) {
                this.cTF.apJ();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cTK = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cTL = i2;
    }

    public int getDebugFlags() {
        return this.cTL;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cTN = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cTN;
    }

    public void setRenderer(TBGLSurfaceView.m mVar) {
        apv();
        if (this.cTH == null) {
            this.cTH = new m(true);
        }
        if (this.cTI == null) {
            this.cTI = new c();
        }
        if (this.cTJ == null) {
            this.cTJ = new d();
        }
        this.cTG = mVar;
        this.cTF = new i(this.cTE);
        this.cTF.start();
    }

    public void setEGLContextFactory(f fVar) {
        apv();
        this.cTI = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        apv();
        this.cTJ = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        apv();
        this.cTH = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        apv();
        this.cTM = i2;
    }

    public void setRenderMode(int i2) {
        this.cTF.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cTF.getRenderMode();
    }

    public void requestRender() {
        this.cTF.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cTF.apH();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cTF.ay(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cTF.ay(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cTF.apI();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cTF.onPause();
    }

    public void onResume() {
        this.cTF.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cTG != null) {
            int renderMode = this.cTF != null ? this.cTF.getRenderMode() : 1;
            this.cTF = new i(this.cTE);
            if (renderMode != 1) {
                this.cTF.setRenderMode(renderMode);
            }
            this.cTF.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cTF != null) {
            this.cTF.apJ();
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

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.cTM, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.cTM == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.X("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements g {
        private d() {
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes.dex */
    private abstract class a implements e {
        protected int[] cTO;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cTO = j(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cTO, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cTO, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] j(int[] iArr) {
            if (GLTextureView.this.cTM == 2) {
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
    private class b extends a {
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

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.a
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
        private WeakReference<GLTextureView> cTQ;
        EGL10 cTR;
        EGLDisplay cTS;
        EGLSurface cTT;
        EGLConfig cTU;
        EGLContext cTV;

        public h(WeakReference<GLTextureView> weakReference) {
            this.cTQ = weakReference;
        }

        public void start() {
            this.cTR = (EGL10) EGLContext.getEGL();
            this.cTS = this.cTR.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cTS == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cTR.eglInitialize(this.cTS, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.cTQ.get();
            if (gLTextureView != null) {
                this.cTU = gLTextureView.cTH.chooseConfig(this.cTR, this.cTS);
                try {
                    this.cTV = gLTextureView.cTI.createContext(this.cTR, this.cTS, this.cTU);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.cTU = null;
                this.cTV = null;
            }
            if (this.cTV == null || this.cTV == EGL10.EGL_NO_CONTEXT) {
                this.cTV = null;
                mB("createContext");
            }
            this.cTT = null;
        }

        public boolean apx() {
            if (this.cTR == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cTS == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cTU == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            apB();
            GLTextureView gLTextureView = this.cTQ.get();
            if (gLTextureView != null) {
                this.cTT = gLTextureView.cTJ.createWindowSurface(this.cTR, this.cTS, this.cTU, gLTextureView.getSurfaceTexture());
            } else {
                this.cTT = null;
            }
            if (this.cTT == null || this.cTT == EGL10.EGL_NO_SURFACE) {
                if (this.cTR.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cTR.eglMakeCurrent(this.cTS, this.cTT, this.cTT, this.cTV)) {
                g("EGLHelper", "eglMakeCurrent", this.cTR.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL apy() {
            l lVar;
            GL gl = this.cTV.getGL();
            GLTextureView gLTextureView = this.cTQ.get();
            if (gLTextureView != null) {
                if (gLTextureView.cTK != null) {
                    gl = gLTextureView.cTK.wrap(gl);
                }
                if ((gLTextureView.cTL & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.cTL & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.cTL & 2) == 0) {
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

        public int apz() {
            if (this.cTR.eglSwapBuffers(this.cTS, this.cTT)) {
                return 12288;
            }
            return this.cTR.eglGetError();
        }

        public void apA() {
            apB();
        }

        private void apB() {
            if (this.cTT != null && this.cTT != EGL10.EGL_NO_SURFACE) {
                this.cTR.eglMakeCurrent(this.cTS, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.cTQ.get();
                if (gLTextureView != null) {
                    gLTextureView.cTJ.destroySurface(this.cTR, this.cTS, this.cTT);
                }
                this.cTT = null;
            }
        }

        public void finish() {
            if (this.cTV != null) {
                GLTextureView gLTextureView = this.cTQ.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.cTI.destroyContext(this.cTR, this.cTS, this.cTV);
                    } catch (Exception e) {
                    }
                }
                this.cTV = null;
            }
            if (this.cTS != null) {
                this.cTR.eglTerminate(this.cTS);
                this.cTS = null;
            }
        }

        private void mB(String str) {
            X(str, this.cTR.eglGetError());
        }

        public static void X(String str, int i) {
            throw new RuntimeException(Y(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, Y(str2, i));
        }

        public static String Y(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<GLTextureView> cTQ;
        private boolean cTW;
        private boolean cTX;
        private boolean cTY;
        private boolean cTZ;
        private boolean cUa;
        private boolean cUb;
        private boolean cUc;
        private boolean cUd;
        private boolean cUe;
        private boolean cUf;
        private boolean cUi;
        private h cUk;
        private boolean mPaused;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean cUj = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cUh = true;
        private int cUg = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.cTQ = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    apE();
                    GLTextureView.cTD.a(this);
                } catch (Exception e) {
                    af.Dx().bt(false);
                    GLTextureView.cTD.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.cTD.a(this);
                throw th;
            }
        }

        private void apC() {
            if (this.cUd) {
                this.cUd = false;
                this.cUk.apA();
            }
        }

        private void apD() {
            if (this.cUc) {
                this.cUk.finish();
                this.cUc = false;
                GLTextureView.cTD.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void apE() throws InterruptedException {
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
            this.cUk = new h(this.cTQ);
            this.cUc = false;
            this.cUd = false;
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
                    synchronized (GLTextureView.cTD) {
                        while (!this.cTW) {
                            if (this.mEventQueue.isEmpty()) {
                                if (this.mPaused != this.cTY) {
                                    boolean z23 = this.cTY;
                                    this.mPaused = this.cTY;
                                    GLTextureView.cTD.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cUf) {
                                    apC();
                                    apD();
                                    this.cUf = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    apC();
                                    apD();
                                    z19 = false;
                                }
                                if (z9 && this.cUd) {
                                    apC();
                                }
                                if (z9 && this.cUc) {
                                    GLTextureView gLTextureView = this.cTQ.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.cTN) || GLTextureView.cTD.apL()) {
                                        apD();
                                    }
                                }
                                if (z9 && GLTextureView.cTD.apM()) {
                                    this.cUk.finish();
                                }
                                if (!this.cTZ && !this.cUb) {
                                    if (this.cUd) {
                                        apC();
                                    }
                                    this.cUb = true;
                                    this.cUa = false;
                                    GLTextureView.cTD.notifyAll();
                                }
                                if (this.cTZ && this.cUb) {
                                    this.cUb = false;
                                    GLTextureView.cTD.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cUi = true;
                                    GLTextureView.cTD.notifyAll();
                                }
                                if (apG()) {
                                    if (!this.cUc) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.cTD.b(this)) {
                                            try {
                                                this.cUk.start();
                                                this.cUc = true;
                                                z15 = true;
                                                GLTextureView.cTD.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.cTD.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cUc || this.cUd) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cUd = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cUd) {
                                        if (this.cUj) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cUj = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cUh = false;
                                        GLTextureView.cTD.notifyAll();
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
                                GLTextureView.cTD.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.mEventQueue.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (GLTextureView.cTD) {
                            apC();
                            apD();
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
                        } else if (this.cUk.apx()) {
                            synchronized (GLTextureView.cTD) {
                                this.cUe = true;
                                GLTextureView.cTD.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.cTD) {
                                this.cUe = true;
                                this.cUa = true;
                                GLTextureView.cTD.notifyAll();
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
                            GL10 gl103 = (GL10) this.cUk.apy();
                            GLTextureView.cTD.c(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.cTQ.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.cTG.onSurfaceCreated(gl10, this.cUk.cTU);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.cTQ.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.cTG.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.cTQ.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.cTG.onDrawFrame(gl10);
                        }
                        int apz = this.cUk.apz();
                        switch (apz) {
                            case 12288:
                                break;
                            case Statistics.kTypeWhiteScreen /* 12302 */:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", apz);
                                synchronized (GLTextureView.cTD) {
                                    this.cUa = true;
                                    GLTextureView.cTD.notifyAll();
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
                    synchronized (GLTextureView.cTD) {
                        apC();
                        apD();
                        throw th;
                    }
                }
            }
        }

        public boolean apF() {
            return this.cUc && this.cUd && apG();
        }

        private boolean apG() {
            return !this.mPaused && this.cTZ && !this.cUa && this.mWidth > 0 && this.mHeight > 0 && (this.cUh || this.cUg == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (GLTextureView.cTD) {
                    this.cUg = i;
                    GLTextureView.cTD.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.cTD) {
                i = this.cUg;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.cTD) {
                this.cUh = true;
                GLTextureView.cTD.notifyAll();
            }
        }

        public void apH() {
            synchronized (GLTextureView.cTD) {
                this.cTZ = true;
                this.cUe = false;
                GLTextureView.cTD.notifyAll();
                while (this.cUb && !this.cUe && !this.cTX) {
                    try {
                        GLTextureView.cTD.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void apI() {
            synchronized (GLTextureView.cTD) {
                this.cTZ = false;
                GLTextureView.cTD.notifyAll();
                while (!this.cUb && !this.cTX) {
                    try {
                        GLTextureView.cTD.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.cTD) {
                this.cTY = true;
                GLTextureView.cTD.notifyAll();
                while (!this.cTX && !this.mPaused) {
                    try {
                        GLTextureView.cTD.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.cTD) {
                this.cTY = false;
                this.cUh = true;
                this.cUi = false;
                GLTextureView.cTD.notifyAll();
                while (!this.cTX && this.mPaused && !this.cUi) {
                    try {
                        GLTextureView.cTD.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void ay(int i, int i2) {
            synchronized (GLTextureView.cTD) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cUj = true;
                this.cUh = true;
                this.cUi = false;
                GLTextureView.cTD.notifyAll();
                while (!this.cTX && !this.mPaused && !this.cUi && apF()) {
                    try {
                        GLTextureView.cTD.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void apJ() {
            synchronized (GLTextureView.cTD) {
                this.cTW = true;
                GLTextureView.cTD.notifyAll();
                while (!this.cTX) {
                    try {
                        GLTextureView.cTD.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void apK() {
            this.cUf = true;
            GLTextureView.cTD.notifyAll();
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

    private void apv() {
        if (this.cTF != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cUl;
        private int cUm;
        private boolean cUn;
        private boolean cUo;
        private boolean cUp;
        private i cUq;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cTX = true;
            if (this.cUq == iVar) {
                this.cUq = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cUq == iVar || this.cUq == null) {
                this.cUq = iVar;
                notifyAll();
                return true;
            }
            apN();
            if (this.cUo) {
                return true;
            }
            if (this.cUq != null) {
                this.cUq.apK();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cUq == iVar) {
                this.cUq = null;
            }
            notifyAll();
        }

        public synchronized boolean apL() {
            return this.cUp;
        }

        public synchronized boolean apM() {
            apN();
            return !this.cUo;
        }

        public synchronized void c(GL10 gl10) {
            synchronized (this) {
                if (!this.cUn) {
                    apN();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cUm < 131072) {
                        this.cUo = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cUp = this.cUo ? false : true;
                    this.cUn = true;
                }
            }
        }

        private void apN() {
            if (!this.cUl) {
                this.cUo = true;
                this.cUl = true;
            }
        }
    }
}
