package com.baidu.tieba;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes5.dex */
public class d2 extends j1 implements GLSurfaceView.Renderer {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final GLSurfaceView20 a;
    public int b;
    public int c;
    public u1 d;
    public v2 e;
    public w2 f;
    public GLVersion g;
    public String h;
    public long i;
    public long j;
    public long k;
    public int l;
    public volatile boolean m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public volatile boolean q;
    public final v1 r;
    public boolean s;
    public int[] t;
    public Object u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448300831, "Lcom/baidu/tieba/d2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448300831, "Lcom/baidu/tieba/d2;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d2 a;

        public a(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.o) {
                return;
            }
            this.a.onDrawFrame(null);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Graphics.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d2 d2Var, int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d2Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d2(u1 u1Var, v1 v1Var, s2 s2Var) {
        this(u1Var, v1Var, s2Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u1Var, v1Var, s2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((u1) objArr2[0], (v1) objArr2[1], (s2) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public d2(u1 u1Var, v1 v1Var, s2 s2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u1Var, v1Var, s2Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = System.nanoTime();
        this.j = System.nanoTime();
        this.k = -1L;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = true;
        this.t = new int[1];
        this.u = new Object();
        this.r = v1Var;
        this.d = u1Var;
        this.a = h(u1Var, s2Var);
        r();
        if (z) {
            this.a.setFocusable(true);
            this.a.setFocusableInTouchMode(true);
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.h == null) {
                this.h = o1.c.m(7939);
            }
            return this.h.contains(str);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public void t(boolean z) {
        ?? r5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && this.a != null) {
            if (!v && !z) {
                r5 = 0;
            } else {
                r5 = 1;
            }
            this.s = r5;
            this.a.setRenderMode(r5);
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public void c() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (gLSurfaceView20 = this.a) != null) {
            gLSurfaceView20.requestRender();
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Mesh.b(this.d);
            Texture.m(this.d);
            Cubemap.m(this.d);
            y2.m(this.d);
            e3.c(this.d);
            a3.f(this.d);
            n();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.u) {
                this.n = false;
                this.q = true;
                while (this.q) {
                    try {
                        this.u.wait();
                    } catch (InterruptedException unused) {
                        o1.a.log("AndroidGraphics", "waiting for destroy synchronization failed!");
                    }
                }
            }
        }
    }

    public GLSurfaceView.EGLConfigChooser k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            v1 v1Var = this.r;
            return new r2(v1Var.a, v1Var.b, v1Var.c, v1Var.d, v1Var.e, v1Var.f, v1Var.g);
        }
        return (GLSurfaceView.EGLConfigChooser) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void o() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (gLSurfaceView20 = this.a) != null) {
            gLSurfaceView20.onPause();
        }
    }

    public void p() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (gLSurfaceView20 = this.a) != null) {
            gLSurfaceView20.onResume();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.setPreserveEGLContextOnPause(true);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.u) {
                this.n = true;
                this.p = true;
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.d.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public Graphics.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.d.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return new b(this, displayMetrics.widthPixels, displayMetrics.heightPixels, 0, 0);
        }
        return (Graphics.a) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            o1.a.log("AndroidGraphics", Mesh.c());
            o1.a.log("AndroidGraphics", Texture.n());
            o1.a.log("AndroidGraphics", Cubemap.n());
            o1.a.log("AndroidGraphics", e3.f());
            o1.a.log("AndroidGraphics", a3.i());
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && Build.VERSION.SDK_INT >= 28) {
            try {
                DisplayCutout displayCutout = this.d.getApplicationWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
                if (displayCutout != null) {
                    displayCutout.getSafeInsetRight();
                    displayCutout.getSafeInsetBottom();
                    displayCutout.getSafeInsetTop();
                    displayCutout.getSafeInsetLeft();
                }
            } catch (UnsupportedOperationException unused) {
                o1.a.log("AndroidGraphics", "Unable to get safe area insets");
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eglGetDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344}, new EGLConfig[10], 10, iArr);
            egl10.eglTerminate(eglGetDisplay);
            if (iArr[0] > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this.u) {
                if (!this.n) {
                    return;
                }
                this.n = false;
                this.o = true;
                this.a.queueEvent(new a(this));
                while (this.o) {
                    try {
                        this.u.wait(4000L);
                        if (this.o) {
                            o1.a.error("AndroidGraphics", "waiting for pause synchronization took too long; assuming deadlock and killing");
                            Process.killProcess(Process.myPid());
                        }
                    } catch (InterruptedException unused) {
                        o1.a.log("AndroidGraphics", "waiting for pause synchronization failed!");
                    }
                }
            }
        }
    }

    public GLSurfaceView20 h(u1 u1Var, s2 s2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, u1Var, s2Var)) == null) {
            if (f()) {
                GLSurfaceView.EGLConfigChooser k = k();
                Context context = u1Var.getContext();
                if (this.r.t) {
                    i = 3;
                } else {
                    i = 2;
                }
                GLSurfaceView20 gLSurfaceView20 = new GLSurfaceView20(context, s2Var, i);
                if (k != null) {
                    gLSurfaceView20.setEGLConfigChooser(k);
                } else {
                    v1 v1Var = this.r;
                    gLSurfaceView20.setEGLConfigChooser(v1Var.a, v1Var.b, v1Var.c, v1Var.d, v1Var.e, v1Var.f);
                }
                gLSurfaceView20.setRenderer(this);
                return gLSurfaceView20;
            }
            throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
        }
        return (GLSurfaceView20) invokeLL.objValue;
    }

    public final int j(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.t)) {
                return this.t[0];
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public void m(EGLConfig eGLConfig) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eGLConfig) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            int j = j(egl10, eglGetDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
            int j2 = j(egl10, eglGetDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
            int j3 = j(egl10, eglGetDisplay, eGLConfig, 12322, 0);
            int j4 = j(egl10, eglGetDisplay, eGLConfig, 12321, 0);
            int j5 = j(egl10, eglGetDisplay, eGLConfig, 12325, 0);
            int j6 = j(egl10, eglGetDisplay, eGLConfig, 12326, 0);
            int max = Math.max(j(egl10, eglGetDisplay, eGLConfig, 12337, 0), j(egl10, eglGetDisplay, eGLConfig, 12513, 0));
            if (j(egl10, eglGetDisplay, eGLConfig, 12513, 0) != 0) {
                z = true;
            } else {
                z = false;
            }
            Application application = o1.a;
            application.log("AndroidGraphics", "framebuffer: (" + j + StringUtil.ARRAY_ELEMENT_SEPARATOR + j2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + j3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + j4 + SmallTailInfo.EMOTION_SUFFIX);
            Application application2 = o1.a;
            StringBuilder sb = new StringBuilder();
            sb.append("depthbuffer: (");
            sb.append(j5);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            application2.log("AndroidGraphics", sb.toString());
            Application application3 = o1.a;
            application3.log("AndroidGraphics", "stencilbuffer: (" + j6 + SmallTailInfo.EMOTION_SUFFIX);
            Application application4 = o1.a;
            application4.log("AndroidGraphics", "samples: (" + max + SmallTailInfo.EMOTION_SUFFIX);
            Application application5 = o1.a;
            application5.log("AndroidGraphics", "coverage sampling: (" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void u(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, gl10) == null) {
            GLVersion gLVersion = new GLVersion(Application.ApplicationType.Android, gl10.glGetString(7938), gl10.glGetString(7936), gl10.glGetString(7937));
            this.g = gLVersion;
            if (this.r.t && gLVersion.b() > 2) {
                if (this.f != null) {
                    return;
                }
                c2 c2Var = new c2();
                this.f = c2Var;
                this.e = c2Var;
                o1.c = c2Var;
                o1.d = c2Var;
                o1.e = c2Var;
            } else if (this.e != null) {
                return;
            } else {
                b2 b2Var = new b2();
                this.e = b2Var;
                o1.c = b2Var;
                o1.d = b2Var;
            }
            Application application = o1.a;
            application.log("AndroidGraphics", "OGL renderer: " + gl10.glGetString(7937));
            Application application2 = o1.a;
            application2.log("AndroidGraphics", "OGL vendor: " + gl10.glGetString(7936));
            Application application3 = o1.a;
            application3.log("AndroidGraphics", "OGL version: " + gl10.glGetString(7938));
            Application application4 = o1.a;
            application4.log("AndroidGraphics", "OGL extensions: " + gl10.glGetString(7939));
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gl10) == null) {
            long nanoTime = System.nanoTime();
            boolean z5 = this.p;
            this.i = nanoTime;
            synchronized (this.u) {
                z = this.n;
                z2 = this.o;
                z3 = this.q;
                z4 = this.p;
                if (this.p) {
                    this.p = false;
                }
                if (this.o) {
                    this.o = false;
                    this.u.notifyAll();
                }
                if (this.q) {
                    this.q = false;
                    this.u.notifyAll();
                }
            }
            if (z4) {
                w3<q1> lifecycleListeners = this.d.getLifecycleListeners();
                synchronized (lifecycleListeners) {
                    q1[] i = lifecycleListeners.i();
                    int i2 = lifecycleListeners.b;
                    for (int i3 = 0; i3 < i2; i3++) {
                        i[i3].resume();
                    }
                    lifecycleListeners.j();
                }
                this.d.getApplicationListener().resume();
                o1.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.d.getRunnables()) {
                    this.d.getExecutedRunnables().clear();
                    this.d.getExecutedRunnables().b(this.d.getRunnables());
                    this.d.getRunnables().clear();
                }
                for (int i4 = 0; i4 < this.d.getExecutedRunnables().b; i4++) {
                    try {
                        this.d.getExecutedRunnables().get(i4).run();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.d.mo7getInput().U1();
                this.k++;
                this.d.getApplicationListener().render();
            }
            if (z2) {
                w3<q1> lifecycleListeners2 = this.d.getLifecycleListeners();
                synchronized (lifecycleListeners2) {
                    q1[] i5 = lifecycleListeners2.i();
                    int i6 = lifecycleListeners2.b;
                    for (int i7 = 0; i7 < i6; i7++) {
                        i5[i7].pause();
                    }
                }
                this.d.getApplicationListener().pause();
                o1.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                w3<q1> lifecycleListeners3 = this.d.getLifecycleListeners();
                synchronized (lifecycleListeners3) {
                    q1[] i8 = lifecycleListeners3.i();
                    int i9 = lifecycleListeners3.b;
                    for (int i10 = 0; i10 < i9; i10++) {
                        i8[i10].dispose();
                    }
                }
                this.d.getApplicationListener().dispose();
                o1.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.j > 1000000000) {
                this.l = 0;
                this.j = nanoTime;
            }
            this.l++;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, gl10, i, i2) == null) {
            this.b = i;
            this.c = i2;
            v();
            w();
            gl10.glViewport(0, 0, this.b, this.c);
            if (!this.m) {
                this.d.getApplicationListener().create();
                this.m = true;
                synchronized (this) {
                    this.n = true;
                }
            }
            this.d.getApplicationListener().a(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, gl10, eGLConfig) == null) {
            ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
            u(gl10);
            m(eGLConfig);
            v();
            w();
            Mesh.d(this.d);
            Texture.o(this.d);
            Cubemap.o(this.d);
            y2.n(this.d);
            e3.g(this.d);
            a3.k(this.d);
            n();
            Display defaultDisplay = this.d.getWindowManager().getDefaultDisplay();
            this.b = defaultDisplay.getWidth();
            this.c = defaultDisplay.getHeight();
            this.i = System.nanoTime();
            gl10.glViewport(0, 0, this.b, this.c);
        }
    }
}
