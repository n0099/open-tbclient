package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tieba.animation3d.View.TBGLSurfaceView;
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
    private static final j cua = new j();
    private final WeakReference<GLTextureView> cub;
    private i cuc;
    private TBGLSurfaceView.m cud;
    private e cue;
    private f cuf;
    private g cug;
    private k cuh;
    private int cui;
    private int cuj;
    private boolean cuk;
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
        this.cub = new WeakReference<>(this);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cub = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cuc != null) {
                this.cuc.aiu();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.cuh = kVar;
    }

    public void setDebugFlags(int i2) {
        this.cui = i2;
    }

    public int getDebugFlags() {
        return this.cui;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.cuk = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.cuk;
    }

    public void setRenderer(TBGLSurfaceView.m mVar) {
        aih();
        if (this.cue == null) {
            this.cue = new m(true);
        }
        if (this.cuf == null) {
            this.cuf = new c();
        }
        if (this.cug == null) {
            this.cug = new d();
        }
        this.cud = mVar;
        this.cuc = new i(this.cub);
        this.cuc.start();
    }

    public void setEGLContextFactory(f fVar) {
        aih();
        this.cuf = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        aih();
        this.cug = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        aih();
        this.cue = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        aih();
        this.cuj = i2;
    }

    public void setRenderMode(int i2) {
        this.cuc.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.cuc.getRenderMode();
    }

    public void requestRender() {
        this.cuc.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cuc.ait();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.cuc.al(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.cuc.al(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.cuc.surfaceDestroyed();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.cuc.onPause();
    }

    public void onResume() {
        this.cuc.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.cud != null) {
            int renderMode = this.cuc != null ? this.cuc.getRenderMode() : 1;
            this.cuc = new i(this.cub);
            if (renderMode != 1) {
                this.cuc.setRenderMode(renderMode);
            }
            this.cuc.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.cuc != null) {
            this.cuc.aiu();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.cuj, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.cuj == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.f
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
        protected int[] cul;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.cul = i(iArr);
        }

        @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cul, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.cul, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] i(int[] iArr) {
            if (GLTextureView.this.cuj == 2) {
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
        private WeakReference<GLTextureView> cun;
        EGL10 cuo;
        EGLDisplay cup;
        EGLSurface cuq;
        EGLConfig cus;
        EGLContext cut;

        public h(WeakReference<GLTextureView> weakReference) {
            this.cun = weakReference;
        }

        public void start() {
            this.cuo = (EGL10) EGLContext.getEGL();
            this.cup = this.cuo.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.cup == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.cuo.eglInitialize(this.cup, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.cun.get();
            if (gLTextureView != null) {
                this.cus = gLTextureView.cue.chooseConfig(this.cuo, this.cup);
                try {
                    this.cut = gLTextureView.cuf.createContext(this.cuo, this.cup, this.cus);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            } else {
                this.cus = null;
                this.cut = null;
            }
            if (this.cut == null || this.cut == EGL10.EGL_NO_CONTEXT) {
                this.cut = null;
                kV("createContext");
            }
            this.cuq = null;
        }

        public boolean aij() {
            if (this.cuo == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.cup == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cus == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ain();
            GLTextureView gLTextureView = this.cun.get();
            if (gLTextureView != null) {
                this.cuq = gLTextureView.cug.createWindowSurface(this.cuo, this.cup, this.cus, gLTextureView.getSurfaceTexture());
            } else {
                this.cuq = null;
            }
            if (this.cuq == null || this.cuq == EGL10.EGL_NO_SURFACE) {
                if (this.cuo.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.cuo.eglMakeCurrent(this.cup, this.cuq, this.cuq, this.cut)) {
                g("EGLHelper", "eglMakeCurrent", this.cuo.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL aik() {
            l lVar;
            GL gl = this.cut.getGL();
            GLTextureView gLTextureView = this.cun.get();
            if (gLTextureView != null) {
                if (gLTextureView.cuh != null) {
                    gl = gLTextureView.cuh.wrap(gl);
                }
                if ((gLTextureView.cui & 3) != 0) {
                    int i = 0;
                    if ((gLTextureView.cui & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.cui & 2) == 0) {
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

        public int ail() {
            if (this.cuo.eglSwapBuffers(this.cup, this.cuq)) {
                return 12288;
            }
            return this.cuo.eglGetError();
        }

        public void aim() {
            ain();
        }

        private void ain() {
            if (this.cuq != null && this.cuq != EGL10.EGL_NO_SURFACE) {
                this.cuo.eglMakeCurrent(this.cup, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.cun.get();
                if (gLTextureView != null) {
                    gLTextureView.cug.destroySurface(this.cuo, this.cup, this.cuq);
                }
                this.cuq = null;
            }
        }

        public void finish() {
            if (this.cut != null) {
                GLTextureView gLTextureView = this.cun.get();
                if (gLTextureView != null) {
                    try {
                        gLTextureView.cuf.destroyContext(this.cuo, this.cup, this.cut);
                    } catch (Exception e) {
                    }
                }
                this.cut = null;
            }
            if (this.cup != null) {
                this.cuo.eglTerminate(this.cup);
                this.cup = null;
            }
        }

        private void kV(String str) {
            S(str, this.cuo.eglGetError());
        }

        public static void S(String str, int i) {
            throw new RuntimeException(T(str, i));
        }

        public static void g(String str, String str2, int i) {
            Log.w(str, T(str2, i));
        }

        public static String T(String str, int i) {
            return str + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean cuA;
        private boolean cuB;
        private boolean cuC;
        private boolean cuD;
        private boolean cuG;
        private h cuJ;
        private WeakReference<GLTextureView> cun;
        private boolean cuu;
        private boolean cuv;
        private boolean cuw;
        private boolean cux;
        private boolean cuy;
        private boolean cuz;
        private boolean mPaused;
        private ArrayList<Runnable> cuH = new ArrayList<>();
        private boolean cuI = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean cuF = true;
        private int cuE = 1;

        i(WeakReference<GLTextureView> weakReference) {
            this.cun = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    aiq();
                    GLTextureView.cua.a(this);
                } catch (Exception e) {
                    ag.yX().aH(false);
                    GLTextureView.cua.a(this);
                }
            } catch (Throwable th) {
                GLTextureView.cua.a(this);
                throw th;
            }
        }

        private void aio() {
            if (this.cuB) {
                this.cuB = false;
                this.cuJ.aim();
            }
        }

        private void aip() {
            if (this.cuA) {
                this.cuJ.finish();
                this.cuA = false;
                GLTextureView.cua.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1395=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void aiq() throws InterruptedException {
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
            this.cuJ = new h(this.cun);
            this.cuA = false;
            this.cuB = false;
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
                    synchronized (GLTextureView.cua) {
                        while (!this.cuu) {
                            if (this.cuH.isEmpty()) {
                                if (this.mPaused != this.cuw) {
                                    boolean z23 = this.cuw;
                                    this.mPaused = this.cuw;
                                    GLTextureView.cua.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.cuD) {
                                    aio();
                                    aip();
                                    this.cuD = false;
                                    z16 = true;
                                }
                                if (z19) {
                                    aio();
                                    aip();
                                    z19 = false;
                                }
                                if (z9 && this.cuB) {
                                    aio();
                                }
                                if (z9 && this.cuA) {
                                    GLTextureView gLTextureView = this.cun.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.cuk) || GLTextureView.cua.aiw()) {
                                        aip();
                                    }
                                }
                                if (z9 && GLTextureView.cua.aix()) {
                                    this.cuJ.finish();
                                }
                                if (!this.cux && !this.cuz) {
                                    if (this.cuB) {
                                        aio();
                                    }
                                    this.cuz = true;
                                    this.cuy = false;
                                    GLTextureView.cua.notifyAll();
                                }
                                if (this.cux && this.cuz) {
                                    this.cuz = false;
                                    GLTextureView.cua.notifyAll();
                                }
                                if (z22) {
                                    z17 = false;
                                    z22 = false;
                                    this.cuG = true;
                                    GLTextureView.cua.notifyAll();
                                }
                                if (ais()) {
                                    if (!this.cuA) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (GLTextureView.cua.b(this)) {
                                            try {
                                                this.cuJ.start();
                                                this.cuA = true;
                                                z15 = true;
                                                GLTextureView.cua.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.cua.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.cuA || this.cuB) {
                                        z10 = z18;
                                        z11 = z20;
                                    } else {
                                        this.cuB = true;
                                        z21 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.cuB) {
                                        if (this.cuI) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.cuI = false;
                                        } else {
                                            z12 = z21;
                                            int i7 = i6;
                                            z13 = z17;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.cuF = false;
                                        GLTextureView.cua.notifyAll();
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
                                GLTextureView.cua.wait();
                            } else {
                                z = z22;
                                i = i6;
                                remove = this.cuH.remove(0);
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                z5 = z18;
                                z6 = z17;
                                z7 = z16;
                                i2 = i5;
                            }
                        }
                        synchronized (GLTextureView.cua) {
                            aio();
                            aip();
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
                        } else if (this.cuJ.aij()) {
                            synchronized (GLTextureView.cua) {
                                this.cuC = true;
                                GLTextureView.cua.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (GLTextureView.cua) {
                                this.cuC = true;
                                this.cuy = true;
                                GLTextureView.cua.notifyAll();
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
                            GL10 gl103 = (GL10) this.cuJ.aik();
                            GLTextureView.cua.b(gl103);
                            z3 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            GLTextureView gLTextureView2 = this.cun.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.cud.onSurfaceCreated(gl10, this.cuJ.cus);
                            }
                            z15 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView3 = this.cun.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.cud.onSurfaceChanged(gl10, i, i2);
                            }
                            z5 = false;
                        }
                        GLTextureView gLTextureView4 = this.cun.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.cud.onDrawFrame(gl10);
                        }
                        int ail = this.cuJ.ail();
                        switch (ail) {
                            case 12288:
                                break;
                            case 12302:
                                z4 = true;
                                break;
                            default:
                                h.g("GLThread", "eglSwapBuffers", ail);
                                synchronized (GLTextureView.cua) {
                                    this.cuy = true;
                                    GLTextureView.cua.notifyAll();
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
                    synchronized (GLTextureView.cua) {
                        aio();
                        aip();
                        throw th;
                    }
                }
            }
        }

        public boolean air() {
            return this.cuA && this.cuB && ais();
        }

        private boolean ais() {
            return !this.mPaused && this.cux && !this.cuy && this.mWidth > 0 && this.mHeight > 0 && (this.cuF || this.cuE == 1);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (GLTextureView.cua) {
                    this.cuE = i;
                    GLTextureView.cua.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.cua) {
                i = this.cuE;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.cua) {
                this.cuF = true;
                GLTextureView.cua.notifyAll();
            }
        }

        public void ait() {
            synchronized (GLTextureView.cua) {
                this.cux = true;
                this.cuC = false;
                GLTextureView.cua.notifyAll();
                while (this.cuz && !this.cuC && !this.cuv) {
                    try {
                        GLTextureView.cua.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLTextureView.cua) {
                this.cux = false;
                GLTextureView.cua.notifyAll();
                while (!this.cuz && !this.cuv) {
                    try {
                        GLTextureView.cua.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.cua) {
                this.cuw = true;
                GLTextureView.cua.notifyAll();
                while (!this.cuv && !this.mPaused) {
                    try {
                        GLTextureView.cua.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.cua) {
                this.cuw = false;
                this.cuF = true;
                this.cuG = false;
                GLTextureView.cua.notifyAll();
                while (!this.cuv && this.mPaused && !this.cuG) {
                    try {
                        GLTextureView.cua.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void al(int i, int i2) {
            synchronized (GLTextureView.cua) {
                this.mWidth = i;
                this.mHeight = i2;
                this.cuI = true;
                this.cuF = true;
                this.cuG = false;
                GLTextureView.cua.notifyAll();
                while (!this.cuv && !this.mPaused && !this.cuG && air()) {
                    try {
                        GLTextureView.cua.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiu() {
            synchronized (GLTextureView.cua) {
                this.cuu = true;
                GLTextureView.cua.notifyAll();
                while (!this.cuv) {
                    try {
                        GLTextureView.cua.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void aiv() {
            this.cuD = true;
            GLTextureView.cua.notifyAll();
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

    private void aih() {
        if (this.cuc != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean cuK;
        private int cuL;
        private boolean cuM;
        private boolean cuN;
        private boolean cuO;
        private i cuP;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.cuv = true;
            if (this.cuP == iVar) {
                this.cuP = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.cuP == iVar || this.cuP == null) {
                this.cuP = iVar;
                notifyAll();
                return true;
            }
            aiy();
            if (this.cuN) {
                return true;
            }
            if (this.cuP != null) {
                this.cuP.aiv();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.cuP == iVar) {
                this.cuP = null;
            }
            notifyAll();
        }

        public synchronized boolean aiw() {
            return this.cuO;
        }

        public synchronized boolean aix() {
            aiy();
            return !this.cuN;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.cuM) {
                    aiy();
                    String glGetString = gl10.glGetString(7937);
                    if (this.cuL < 131072) {
                        this.cuN = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.cuO = this.cuN ? false : true;
                    this.cuM = true;
                }
            }
        }

        private void aiy() {
            if (!this.cuK) {
                this.cuN = true;
                this.cuK = true;
            }
        }
    }
}
