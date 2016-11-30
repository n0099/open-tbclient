package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.TextureView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ak;
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
    private static final j bab = new j(null);
    private final WeakReference<a> bac;
    private i bad;
    private GLSurfaceView.Renderer bae;
    private e baf;
    private f bag;
    private g bah;
    private k bai;
    private int baj;
    private int bak;
    private boolean bal;
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
        this.bac = new WeakReference<>(this);
        init();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bad != null) {
                this.bad.Oz();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.bai = kVar;
    }

    public void setDebugFlags(int i2) {
        this.baj = i2;
    }

    public int getDebugFlags() {
        return this.baj;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.bal = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.bal;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Ol();
        if (this.baf == null) {
            this.baf = new m(true);
        }
        if (this.bag == null) {
            this.bag = new c(this, null);
        }
        if (this.bah == null) {
            this.bah = new d(null);
        }
        this.bae = renderer;
        this.bad = new i(this.bac);
        this.bad.start();
    }

    public void setEGLContextFactory(f fVar) {
        Ol();
        this.bag = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        Ol();
        this.bah = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        Ol();
        this.baf = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(z));
    }

    public void setEGLContextClientVersion(int i2) {
        Ol();
        this.bak = i2;
    }

    public void setRenderMode(int i2) {
        this.bad.setRenderMode(i2);
    }

    public int getRenderMode() {
        return this.bad.getRenderMode();
    }

    public void requestRender() {
        this.bad.requestRender();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bad.Ox();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.bad.R(i2, i3);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.bad.R(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.bad.Oy();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    public void onPause() {
        this.bad.onPause();
    }

    public void onResume() {
        this.bad.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.bae != null) {
            int renderMode = this.bad != null ? this.bad.getRenderMode() : 1;
            this.bad = new i(this.bac);
            if (renderMode != 1) {
                this.bad.setRenderMode(renderMode);
            }
            this.bad.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.bad != null) {
            this.bad.Oz();
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
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, a.this.bak, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.bak == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.tieba.b.d.a.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.J("eglDestroyContex", egl10.eglGetError());
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
    private abstract class AbstractC0055a implements e {
        protected int[] bam;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public AbstractC0055a(int[] iArr) {
            this.bam = e(iArr);
        }

        @Override // com.baidu.tieba.b.d.a.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bam, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.bam, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        private int[] e(int[] iArr) {
            if (a.this.bak == 2) {
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
    private class b extends AbstractC0055a {
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

        @Override // com.baidu.tieba.b.d.a.AbstractC0055a
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
        private WeakReference<a> bao;
        EGL10 bap;
        EGLDisplay baq;
        EGLSurface bas;
        EGLConfig bat;
        EGLContext bau;

        public h(WeakReference<a> weakReference) {
            this.bao = weakReference;
        }

        public void start() {
            this.bap = (EGL10) EGLContext.getEGL();
            this.baq = this.bap.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.baq == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.bap.eglInitialize(this.baq, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.bao.get();
            if (aVar == null) {
                this.bat = null;
                this.bau = null;
            } else {
                this.bat = aVar.baf.chooseConfig(this.bap, this.baq);
                try {
                    this.bau = aVar.bag.createContext(this.bap, this.baq, this.bat);
                } catch (IllegalArgumentException e) {
                    BdLog.e(e);
                }
            }
            if (this.bau == null || this.bau == EGL10.EGL_NO_CONTEXT) {
                this.bau = null;
                hO("createContext");
            }
            this.bas = null;
        }

        public boolean On() {
            if (this.bap == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.baq == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bat == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            Or();
            a aVar = this.bao.get();
            if (aVar != null) {
                this.bas = aVar.bah.createWindowSurface(this.bap, this.baq, this.bat, aVar.getSurfaceTexture());
            } else {
                this.bas = null;
            }
            if (this.bas == null || this.bas == EGL10.EGL_NO_SURFACE) {
                if (this.bap.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (!this.bap.eglMakeCurrent(this.baq, this.bas, this.bas, this.bau)) {
                f("EGLHelper", "eglMakeCurrent", this.bap.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL Oo() {
            l lVar;
            GL gl = this.bau.getGL();
            a aVar = this.bao.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.bai != null) {
                gl = aVar.bai.wrap(gl);
            }
            if ((aVar.baj & 3) != 0) {
                int i = 0;
                if ((aVar.baj & 1) != 0) {
                    i = 1;
                }
                if ((aVar.baj & 2) == 0) {
                    lVar = null;
                } else {
                    lVar = new l();
                }
                return GLDebugHelper.wrap(gl, i, lVar);
            }
            return gl;
        }

        public int Op() {
            if (this.bap.eglSwapBuffers(this.baq, this.bas)) {
                return 12288;
            }
            return this.bap.eglGetError();
        }

        public void Oq() {
            Or();
        }

        private void Or() {
            if (this.bas != null && this.bas != EGL10.EGL_NO_SURFACE) {
                this.bap.eglMakeCurrent(this.baq, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.bao.get();
                if (aVar != null) {
                    aVar.bah.destroySurface(this.bap, this.baq, this.bas);
                }
                this.bas = null;
            }
        }

        public void finish() {
            if (this.bau != null) {
                a aVar = this.bao.get();
                if (aVar != null) {
                    try {
                        aVar.bag.destroyContext(this.bap, this.baq, this.bau);
                    } catch (Exception e) {
                    }
                }
                this.bau = null;
            }
            if (this.baq != null) {
                this.bap.eglTerminate(this.baq);
                this.baq = null;
            }
        }

        private void hO(String str) {
            J(str, this.bap.eglGetError());
        }

        public static void J(String str, int i) {
            throw new RuntimeException(K(str, i));
        }

        public static void f(String str, String str2, int i) {
            Log.w(str, K(str2, i));
        }

        public static String K(String str, int i) {
            return String.valueOf(str) + " failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends Thread {
        private boolean baA;
        private boolean baB;
        private boolean baC;
        private boolean baD;
        private boolean baE;
        private boolean baF;
        private boolean baI;
        private h baL;
        private WeakReference<a> bao;
        private boolean bav;
        private boolean baw;
        private boolean bax;
        private boolean bay;
        private boolean baz;
        private ArrayList<Runnable> baJ = new ArrayList<>();
        private boolean baK = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean baH = true;
        private int baG = 1;

        i(WeakReference<a> weakReference) {
            this.bao = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                try {
                    Ou();
                    a.bab.a(this);
                } catch (Exception e) {
                    ak.vl().aD(false);
                    a.bab.a(this);
                }
            } catch (Throwable th) {
                a.bab.a(this);
                throw th;
            }
        }

        private void Os() {
            if (this.baD) {
                this.baD = false;
                this.baL.Oq();
            }
        }

        private void Ot() {
            if (this.baC) {
                this.baL.finish();
                this.baC = false;
                a.bab.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1392=5] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void Ou() throws InterruptedException {
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
            this.baL = new h(this.bao);
            this.baC = false;
            this.baD = false;
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
                    synchronized (a.bab) {
                        while (!this.bav) {
                            if (this.baJ.isEmpty()) {
                                if (this.bay != this.bax) {
                                    boolean z23 = this.bax;
                                    this.bay = this.bax;
                                    a.bab.notifyAll();
                                    z9 = z23;
                                } else {
                                    z9 = false;
                                }
                                if (this.baF) {
                                    Os();
                                    Ot();
                                    this.baF = false;
                                    z16 = true;
                                }
                                if (z20) {
                                    Os();
                                    Ot();
                                    z20 = false;
                                }
                                if (z9 && this.baD) {
                                    Os();
                                }
                                if (z9 && this.baC) {
                                    a aVar = this.bao.get();
                                    if (!(aVar == null ? false : aVar.bal) || a.bab.OB()) {
                                        Ot();
                                    }
                                }
                                if (z9 && a.bab.OC()) {
                                    this.baL.finish();
                                }
                                if (!this.baz && !this.baB) {
                                    if (this.baD) {
                                        Os();
                                    }
                                    this.baB = true;
                                    this.baA = false;
                                    a.bab.notifyAll();
                                }
                                if (this.baz && this.baB) {
                                    this.baB = false;
                                    a.bab.notifyAll();
                                }
                                if (z17) {
                                    z18 = false;
                                    z17 = false;
                                    this.baI = true;
                                    a.bab.notifyAll();
                                }
                                if (Ow()) {
                                    if (!this.baC) {
                                        if (z16) {
                                            z16 = false;
                                        } else if (a.bab.b(this)) {
                                            try {
                                                this.baL.start();
                                                this.baC = true;
                                                z15 = true;
                                                a.bab.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.bab.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.baC || this.baD) {
                                        z10 = z19;
                                        z11 = z21;
                                    } else {
                                        this.baD = true;
                                        z22 = true;
                                        z10 = true;
                                        z11 = true;
                                    }
                                    if (this.baD) {
                                        if (this.baK) {
                                            z14 = true;
                                            i4 = this.mWidth;
                                            i3 = this.mHeight;
                                            z13 = true;
                                            z12 = true;
                                            this.baK = false;
                                        } else {
                                            z12 = z22;
                                            int i7 = i6;
                                            z13 = z18;
                                            z14 = z10;
                                            i3 = i5;
                                            i4 = i7;
                                        }
                                        this.baH = false;
                                        a.bab.notifyAll();
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
                                a.bab.wait();
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
                                remove = this.baJ.remove(0);
                            }
                        }
                        synchronized (a.bab) {
                            Os();
                            Ot();
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
                        } else if (this.baL.On()) {
                            synchronized (a.bab) {
                                this.baE = true;
                                a.bab.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (a.bab) {
                                this.baE = true;
                                this.baA = true;
                                a.bab.notifyAll();
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
                            GL10 gl103 = (GL10) this.baL.Oo();
                            a.bab.b(gl103);
                            z2 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z15) {
                            a aVar2 = this.bao.get();
                            if (aVar2 != null) {
                                aVar2.bae.onSurfaceCreated(gl10, this.baL.bat);
                            }
                            z15 = false;
                        }
                        if (z4) {
                            a aVar3 = this.bao.get();
                            if (aVar3 != null) {
                                aVar3.bae.onSurfaceChanged(gl10, i, i2);
                            }
                            z4 = false;
                        }
                        a aVar4 = this.bao.get();
                        if (aVar4 != null) {
                            aVar4.bae.onDrawFrame(gl10);
                        }
                        int Op = this.baL.Op();
                        switch (Op) {
                            case 12288:
                                break;
                            case 12302:
                                z3 = true;
                                break;
                            default:
                                h.f("GLThread", "eglSwapBuffers", Op);
                                synchronized (a.bab) {
                                    this.baA = true;
                                    a.bab.notifyAll();
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
                    synchronized (a.bab) {
                        Os();
                        Ot();
                        throw th;
                    }
                }
            }
        }

        public boolean Ov() {
            return this.baC && this.baD && Ow();
        }

        private boolean Ow() {
            return !this.bay && this.baz && !this.baA && this.mWidth > 0 && this.mHeight > 0 && (this.baH || this.baG == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.bab) {
                this.baG = i;
                a.bab.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (a.bab) {
                i = this.baG;
            }
            return i;
        }

        public void requestRender() {
            synchronized (a.bab) {
                this.baH = true;
                a.bab.notifyAll();
            }
        }

        public void Ox() {
            synchronized (a.bab) {
                this.baz = true;
                this.baE = false;
                a.bab.notifyAll();
                while (this.baB && !this.baE && !this.baw) {
                    try {
                        a.bab.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Oy() {
            synchronized (a.bab) {
                this.baz = false;
                a.bab.notifyAll();
                while (!this.baB && !this.baw) {
                    try {
                        a.bab.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (a.bab) {
                this.bax = true;
                a.bab.notifyAll();
                while (!this.baw && !this.bay) {
                    try {
                        a.bab.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (a.bab) {
                this.bax = false;
                this.baH = true;
                this.baI = false;
                a.bab.notifyAll();
                while (!this.baw && this.bay && !this.baI) {
                    try {
                        a.bab.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void R(int i, int i2) {
            synchronized (a.bab) {
                this.mWidth = i;
                this.mHeight = i2;
                this.baK = true;
                this.baH = true;
                this.baI = false;
                a.bab.notifyAll();
                while (!this.baw && !this.bay && !this.baI && Ov()) {
                    try {
                        a.bab.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void Oz() {
            synchronized (a.bab) {
                this.bav = true;
                a.bab.notifyAll();
                while (!this.baw) {
                    try {
                        a.bab.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void OA() {
            this.baF = true;
            a.bab.notifyAll();
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

    private void Ol() {
        if (this.bad != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean baM;
        private int baN;
        private boolean baO;
        private boolean baP;
        private boolean baQ;
        private i baR;

        private j() {
        }

        /* synthetic */ j(j jVar) {
            this();
        }

        public synchronized void a(i iVar) {
            iVar.baw = true;
            if (this.baR == iVar) {
                this.baR = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            if (this.baR == iVar || this.baR == null) {
                this.baR = iVar;
                notifyAll();
                return true;
            }
            OD();
            if (this.baP) {
                return true;
            }
            if (this.baR != null) {
                this.baR.OA();
            }
            return false;
        }

        public void c(i iVar) {
            if (this.baR == iVar) {
                this.baR = null;
            }
            notifyAll();
        }

        public synchronized boolean OB() {
            return this.baQ;
        }

        public synchronized boolean OC() {
            OD();
            return !this.baP;
        }

        public synchronized void b(GL10 gl10) {
            synchronized (this) {
                if (!this.baO) {
                    OD();
                    String glGetString = gl10.glGetString(7937);
                    if (this.baN < 131072) {
                        this.baP = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.baQ = this.baP ? false : true;
                    this.baO = true;
                }
            }
        }

        private void OD() {
            if (!this.baM) {
                this.baP = true;
                this.baM = true;
            }
        }
    }
}
