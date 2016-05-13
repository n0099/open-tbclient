package com.baidu.tieba.a.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.al;
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
    private static final j aME = new j(null);
    private final WeakReference<a> aMF;
    private i aMG;
    private GLSurfaceView.Renderer aMH;
    private e aMI;
    private f aMJ;
    private g aMK;
    private k aML;
    private int aMM;
    private int aMN;
    private boolean aMO;
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
        this.aMF = new WeakReference<>(this);
        init();
    }

    protected void finalize() {
        try {
            if (this.aMG != null) {
                this.aMG.Jw();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.aML = kVar;
    }

    public void setDebugFlags(int i2) {
        this.aMM = i2;
    }

    public int getDebugFlags() {
        return this.aMM;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.aMO = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.aMO;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Ji();
        if (this.aMI == null) {
            this.aMI = new m(true);
        }
        if (this.aMJ == null) {
            this.aMJ = new c(this, null);
        }
        if (this.aMK == null) {
            this.aMK = new d(null);
        }
        this.aMH = renderer;
        this.aMG = new i(this.aMF);
        this.aMG.start();
    }

    public void setEGLContextFactory(f fVar) {
        Ji();
        this.aMJ = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Ji();
        this.aMK = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Ji();
        this.aMI = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Ji();
        this.aMN = i2;
    }

    public void setRenderMode(int i2) {
        this.aMG.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.aMG.getRenderMode();
    }

    public void requestRender() {
        this.aMG.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aMG.Ju();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.aMG.K(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.aMG.K(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.aMG.Jv();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.aMG.onPause();
    }

    public void onResume() {
        this.aMG.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.aMH != null) {
            int renderMode = this.aMG != null ? this.aMG.getRenderMode() : 1;
            this.aMG = new i(this.aMF);
            if (renderMode != 1) {
                this.aMG.setRenderMode(renderMode);
            }
            this.aMG.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.aMG != null) {
            this.aMG.Jw();
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

        @Override // com.baidu.tieba.a.d.a.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.aMN, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.aMN == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.a.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.H("eglDestroyContex", egl10.eglGetError());
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

        @Override // com.baidu.tieba.a.d.a.g
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.tieba.a.d.a.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: com.baidu.tieba.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private abstract class AbstractC0051a implements e {
        protected int[] aMP;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0051a(int[] iArr) {
            this.aMP = d(iArr);
        }

        @Override // com.baidu.tieba.a.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aMP, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aMP, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] d(int[] iArr) {
            if (a.this.aMN == 2) {
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
    private class b extends AbstractC0051a {
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

        @Override // com.baidu.tieba.a.d.a.AbstractC0051a
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
        private WeakReference<a> aMR;
        EGL10 aMS;
        EGLDisplay aMT;
        EGLSurface aMU;
        EGLConfig aMV;
        EGLContext aMW;

        public h(WeakReference<a> weakReference) {
            this.aMR = weakReference;
        }

        public void start() {
            this.aMS = (EGL10) EGLContext.getEGL();
            this.aMT = this.aMS.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.aMT == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.aMS.eglInitialize(this.aMT, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.aMR.get();
            if (aVar == null) {
                this.aMV = null;
                this.aMW = null;
            } else {
                this.aMV = aVar.aMI.chooseConfig(this.aMS, this.aMT);
                try {
                    this.aMW = aVar.aMJ.createContext(this.aMS, this.aMT, this.aMV);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.aMW == null || this.aMW == EGL10.EGL_NO_CONTEXT) {
                this.aMW = null;
                gY("createContext");
            }
            this.aMU = null;
        }

        public boolean Jk() {
            if (this.aMS == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.aMT == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aMV == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Jo();
            a aVar = this.aMR.get();
            if (aVar != null) {
                this.aMU = aVar.aMK.createWindowSurface(this.aMS, this.aMT, this.aMV, aVar.getSurfaceTexture());
            } else {
                this.aMU = null;
            }
            if (this.aMU == null || this.aMU == EGL10.EGL_NO_SURFACE) {
                if (this.aMS.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.aMS.eglMakeCurrent(this.aMT, this.aMU, this.aMU, this.aMW)) {
                e("EGLHelper", "eglMakeCurrent", this.aMS.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Jl() {
            l lVar;
            GL gl = this.aMW.getGL();
            a aVar = this.aMR.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.aML != null) {
                gl = aVar.aML.wrap(gl);
            }
            if ((aVar.aMM & 3) != 0) {
                int i = 0;
                if ((aVar.aMM & 1) != 0) {
                    i = 1;
                }
                if ((aVar.aMM & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Jm() {
            if (this.aMS.eglSwapBuffers(this.aMT, this.aMU)) {
                return 12288;
            }
            return this.aMS.eglGetError();
        }

        public void Jn() {
            Jo();
        }

        private void Jo() {
            if (this.aMU != null && this.aMU != EGL10.EGL_NO_SURFACE) {
                this.aMS.eglMakeCurrent(this.aMT, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.aMR.get();
                if (aVar != null) {
                    aVar.aMK.destroySurface(this.aMS, this.aMT, this.aMU);
                }
                this.aMU = null;
            }
        }

        public void finish() {
            if (this.aMW != null) {
                a aVar = this.aMR.get();
                if (aVar != null) {
                    try {
                        aVar.aMJ.destroyContext(this.aMS, this.aMT, this.aMW);
                    } catch (Exception e) {
                    }
                }
                this.aMW = null;
            }
            if (this.aMT != null) {
                this.aMS.eglTerminate(this.aMT);
                this.aMT = null;
            }
        }

        private void gY(String str) {
            H(str, this.aMS.eglGetError());
        }

        public static void H(String str, int i) {
            throw new RuntimeException(I(str, i));
        }

        public static void e(String str, String str2, int i) {
            Log.w(str, I(str2, i));
        }

        public static String I(String str, int i) {
            return String.valueOf(str) + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private WeakReference<a> aMR;
        private boolean aMX;
        private boolean aMY;
        private boolean aMZ;
        private boolean aNa;
        private boolean aNb;
        private boolean aNc;
        private boolean aNd;
        private boolean aNe;
        private boolean aNf;
        private boolean aNg;
        private boolean aNh;
        private boolean aNk;
        private h aNn;
        private ArrayList<Runnable> aNl = new ArrayList<>();
        private boolean aNm = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aNj = true;
        private int aNi = 1;

        i(WeakReference<a> weakReference) {
            this.aMR = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Jr();
                    a.aME.a(this);
                } catch (Exception e) {
                    al.tO().ay(false);
                    a.aME.a(this);
                }
            } catch (Throwable th) {
                a.aME.a(this);
                throw th;
            }
        }

        private void Jp() {
            if (this.aNf) {
                this.aNf = false;
                this.aNn.Jn();
            }
        }

        private void Jq() {
            if (this.aNe) {
                this.aNn.finish();
                this.aNe = false;
                a.aME.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Jr() {
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
            this.aNn = new h(this.aMR);
            this.aNe = false;
            this.aNf = false;
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
                    synchronized (a.aME) {
                        while (!this.aMX) {
                            if (this.aNl.isEmpty()) {
                                if (this.aNa != this.aMZ) {
                                    boolean z23 = this.aMZ;
                                    this.aNa = this.aMZ;
                                    a.aME.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.aNh) {
                                    Jp();
                                    Jq();
                                    this.aNh = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Jp();
                                    Jq();
                                    z20 = false;
                                }
                                if (z9 && this.aNf) {
                                    Jp();
                                }
                                if (z9 && this.aNe) {
                                    a aVar = this.aMR.get();
                                    if (!(aVar == null ? false : aVar.aMO) || a.aME.Jy()) {
                                        Jq();
                                    }
                                }
                                if (z9 && a.aME.Jz()) {
                                    this.aNn.finish();
                                }
                                if (!this.aNb && !this.aNd) {
                                    if (this.aNf) {
                                        Jp();
                                    }
                                    this.aNd = true;
                                    this.aNc = false;
                                    a.aME.notifyAll();
                                }
                                if (this.aNb && this.aNd) {
                                    this.aNd = false;
                                    a.aME.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.aNk = true;
                                    a.aME.notifyAll();
                                }
                                if (Jt()) {
                                    if (!this.aNe) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.aME.b(this)) {
                                            try {
                                                this.aNn.start();
                                                this.aNe = true;
                                                z15 = true;
                                                a.aME.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.aME.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.aNe || this.aNf) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.aNf = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.aNf) {
                                        if (this.aNm) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.aNm = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.aNj = false;
                                        a.aME.notifyAll();
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
                                a.aME.wait();
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
                                remove = this.aNl.remove(0);
                            }
                        }
                        synchronized (a.aME) {
                            Jp();
                            Jq();
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
                        } else if (this.aNn.Jk()) {
                            synchronized (a.aME) {
                                this.aNg = true;
                                a.aME.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.aME) {
                                this.aNg = true;
                                this.aNc = true;
                                a.aME.notifyAll();
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
                            GL10 gl103 = (GL10) this.aNn.Jl();
                            a.aME.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.aMR.get();
                            if (aVar2 != null) {
                                aVar2.aMH.onSurfaceCreated(gl10, this.aNn.aMV);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.aMR.get();
                            if (aVar3 != null) {
                                aVar3.aMH.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.aMR.get();
                        if (aVar4 != null) {
                            aVar4.aMH.onDrawFrame(gl10);
                        }
                        int Jm = this.aNn.Jm();
                        switch (Jm) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.e("GLThread", "eglSwapBuffers", Jm);
                                synchronized (a.aME) {
                                    this.aNc = true;
                                    a.aME.notifyAll();
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
                    synchronized (a.aME) {
                        Jp();
                        Jq();
                        throw th;
                    }
                }
            }
        }

        public boolean Js() {
            return this.aNe && this.aNf && Jt();
        }

        private boolean Jt() {
            return !this.aNa && this.aNb && !this.aNc && this.mWidth > 0 && this.mHeight > 0 && (this.aNj || this.aNi == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.aME) {
                this.aNi = i;
                a.aME.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.aME) {
                i = this.aNi;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.aME) {
                this.aNj = true;
                a.aME.notifyAll();
            }
        }

        public void Ju() {
            synchronized (a.aME) {
                this.aNb = true;
                this.aNg = false;
                a.aME.notifyAll();
                while (this.aNd && !this.aNg && !this.aMY) {
                    try {
                        a.aME.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Jv() {
            synchronized (a.aME) {
                this.aNb = false;
                a.aME.notifyAll();
                while (!this.aNd && !this.aMY) {
                    try {
                        a.aME.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.aME) {
                this.aMZ = true;
                a.aME.notifyAll();
                while (!this.aMY && !this.aNa) {
                    try {
                        a.aME.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.aME) {
                this.aMZ = false;
                this.aNj = true;
                this.aNk = false;
                a.aME.notifyAll();
                while (!this.aMY && this.aNa && !this.aNk) {
                    try {
                        a.aME.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void K(int i, int i2) {
            synchronized (a.aME) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aNm = true;
                this.aNj = true;
                this.aNk = false;
                a.aME.notifyAll();
                while (!this.aMY && !this.aNa && !this.aNk && Js()) {
                    try {
                        a.aME.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Jw() {
            synchronized (a.aME) {
                this.aMX = true;
                a.aME.notifyAll();
                while (!this.aMY) {
                    try {
                        a.aME.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Jx() {
            this.aNh = true;
            a.aME.notifyAll();
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

    private void Ji() {
        if (this.aMG != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean aNo;
        private int aNp;
        private boolean aNq;
        private boolean aNr;
        private boolean aNs;
        private i aNt;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.aMY = true;
            if (this.aNt == iVar) {
                this.aNt = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.aNt == iVar || this.aNt == null) {
                this.aNt = iVar;
                notifyAll();
                return true;
            }
            JA();
            if (this.aNr) {
                return true;
            }
            if (this.aNt != null) {
                this.aNt.Jx();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.aNt == iVar) {
                this.aNt = null;
            }
            notifyAll();
        }

        public synchronized boolean Jy() {
            return this.aNs;
        }

        public synchronized boolean Jz() {
            JA();
            return !this.aNr;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.aNq) {
                    JA();
                    String glGetString = gl10.glGetString(7937);
                    if (this.aNp < 131072) {
                        this.aNr = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.aNs = this.aNr ? false : true;
                    this.aNq = true;
                }
            }
        }

        private void JA() {
            if (!this.aNo) {
                this.aNr = true;
                this.aNo = true;
            }
        }
    }
}
