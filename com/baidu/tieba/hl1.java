package com.baidu.tieba;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.Log;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.heytap.mcssdk.constant.MessageConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public final class hl1 implements AREngineDelegate {
    public static /* synthetic */ Interceptable $ic;
    public static PermissionProxy o;
    public static int p;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ArBridge b;
    public ArrayList<DebugConsole> c;
    public int d;
    public long e;
    public float f;
    public float g;
    public GLSurfaceView.Renderer h;
    public boolean i;
    public final d j;
    public Object k;
    public SurfaceHolder l;
    public b m;
    public boolean n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947827452, "Lcom/baidu/tieba/hl1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947827452, "Lcom/baidu/tieba/hl1;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl1 a;

        public a(hl1 hl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m.i = true;
                this.a.b.smallGameDestroy();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinkedList<Runnable> A;
        public TreeSet<e> B;
        public boolean C;
        public c D;
        public d E;
        public hl1 F;
        public V8Engine G;
        public int a;
        public long b;
        public long c;
        public long d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public volatile boolean i;
        public volatile boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q;
        public boolean r;
        public boolean s;
        public int t;
        public int u;
        public int v;
        public boolean w;
        public boolean x;
        public boolean y;
        public LinkedList<Runnable> z;

        public b(hl1 hl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.b = 0L;
            this.c = 0L;
            this.d = 0L;
            this.e = 0L;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.z = new LinkedList<>();
            this.A = new LinkedList<>();
            this.B = new TreeSet<>();
            this.C = true;
            this.G = null;
            this.t = 0;
            this.u = 0;
            this.w = true;
            this.v = 1;
            this.x = false;
            this.F = hl1Var;
            this.E = hl1Var.j;
        }

        public void p(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, runnable) == null) {
                q(runnable, true);
            }
        }

        public void v(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, runnable) == null) {
                q(runnable, false);
            }
        }

        public void w(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
                if (i >= 0 && i <= 1) {
                    synchronized (this.E) {
                        this.v = i;
                        this.E.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("renderMode");
            }
        }

        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.E) {
                    this.m = true;
                    this.r = false;
                    this.E.notifyAll();
                    while (this.o && !this.r && !this.j) {
                        try {
                            this.E.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void B() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.E) {
                    this.m = false;
                    this.E.notifyAll();
                    while (!this.o && !this.j) {
                        try {
                            this.E.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public final Runnable g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this.E) {
                    if (!this.B.isEmpty() && this.B.first().b()) {
                        return this.B.pollFirst();
                    }
                    return this.z.pollFirst();
                }
            }
            return (Runnable) invokeV.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.p && this.q && r()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this.E) {
                    this.z.clear();
                    this.A.clear();
                    this.B.clear();
                }
            }
        }

        public int h() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this.E) {
                    i = this.v;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public final V8Engine i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.G == null) {
                    this.G = V8Engine.getInstance();
                }
                return this.G;
            }
            return (V8Engine) invokeV.objValue;
        }

        public final float k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                V8Engine i = i();
                if (i != null) {
                    return i.minFramesInterval();
                }
                return 16.666666f;
            }
            return invokeV.floatValue;
        }

        public final boolean r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (!this.l && this.m && !this.n && this.t > 0 && this.u > 0 && (this.w || this.v == 1)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
                synchronized (this.E) {
                    this.i = true;
                    this.E.notifyAll();
                    while (!this.j) {
                        try {
                            this.E.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                synchronized (this.E) {
                    this.w = true;
                    this.E.notifyAll();
                }
            }
        }

        public boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.F.b.mFirstFrameFinished && ((float) (currentTimeMillis - this.d)) > k()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void y() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.p) {
                this.D.c();
                this.p = false;
                this.E.a(this);
            }
        }

        public final void z() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.q) {
                this.q = false;
                this.D.b();
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a++;
                if (this.b != 0) {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - this.b)) / 1000.0f;
                    if (currentTimeMillis > 1.0f) {
                        this.F.q((int) (this.a / currentTimeMillis));
                        this.a = 0;
                        this.b = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                this.b = System.currentTimeMillis();
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                synchronized (this.E) {
                    Log.i(ArBridge.TAG, "onResume tid=" + getId());
                    this.k = false;
                    this.w = true;
                    this.y = false;
                    this.E.notifyAll();
                    while (!this.j && this.l && !this.y) {
                        Log.i("Main thread", "onResume waiting for !mPaused.");
                        try {
                            this.E.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                synchronized (this.E) {
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.x = true;
                    this.w = true;
                    this.y = false;
                    this.E.notifyAll();
                    while (!this.j && !this.l && !this.y && a()) {
                        try {
                            this.E.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x01a4, code lost:
            if (r20.g != false) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x01a8, code lost:
            if (r20.F == null) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x01aa, code lost:
            r20.g = true;
            r20.F.n("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x01b8, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x01bc, code lost:
            if (r20.F == null) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x01be, code lost:
            r20.F.m(1, r12.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x01c8, code lost:
            r12.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x01cc, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x01ce, code lost:
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x01ea, code lost:
            if (r7 == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x01f2, code lost:
            if (r20.D.a() == false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x01f4, code lost:
            r3 = r20.E;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x01f6, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x01f8, code lost:
            r20.r = true;
            r20.E.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x01ff, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x0200, code lost:
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x0205, code lost:
            r3 = r20.E;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x0207, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x0209, code lost:
            r20.r = true;
            r20.n = true;
            r20.E.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x0212, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0213, code lost:
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0219, code lost:
            if (r8 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x021b, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x021c, code lost:
            if (r6 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x021e, code lost:
            r0 = r20.F;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x0220, code lost:
            if (r0 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0222, code lost:
            r0.h.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x022a, code lost:
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x022b, code lost:
            if (r9 == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x022d, code lost:
            r0 = r20.F;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x022f, code lost:
            if (r0 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x0231, code lost:
            r0.h.onSurfaceChanged(null, r10, r11);
            r0.updateSurfaceViewSize(r10, r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x023e, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x023f, code lost:
            r0 = r20.F;
            r14 = java.lang.System.currentTimeMillis();
            r2 = r14 - r20.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x024f, code lost:
            if (r0.i == false) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x0258, code lost:
            if (((float) r2) < k()) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x025a, code lost:
            r20.c = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0262, code lost:
            if (r20.f != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x0266, code lost:
            if (r20.F == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0268, code lost:
            r20.f = true;
            r20.F.n("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x0272, code lost:
            r0.h.onDrawFrame(null);
            e();
            r2 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x0286, code lost:
            if ((r14 - r20.e) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x0288, code lost:
            r0.b.notifyFrameUpdated();
            r20.e = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x0293, code lost:
            if (r20.h == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x0295, code lost:
            r20.F.b.smallGameOnResume();
            r20.h = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x02a3, code lost:
            r4 = r0.b.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x02ab, code lost:
            if (r4 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x02ad, code lost:
            r14 = r20.D.i();
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x02b5, code lost:
            if (r14 == 12288) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x02b9, code lost:
            if (r14 == 12302) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x02bb, code lost:
            com.baidu.tieba.hl1.c.f(com.baidu.smallgame.sdk.ArBridge.TAG, "eglSwapBuffers", r14);
            r3 = r20.E;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x02c4, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x02c6, code lost:
            r20.n = true;
            r20.E.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x02cd, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x02d2, code lost:
            r14 = r2;
            r15 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x02d5, code lost:
            r14 = r2;
            r15 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x02d8, code lost:
            r20.d = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x02e8, code lost:
            if (r20.F.b.isRenderCallbackQueueEmpty() != false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x02ea, code lost:
            if (r4 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:190:0x02ec, code lost:
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:191:0x02ee, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x02f9, code lost:
            if ((r0.b.getStuckScreenHandler() instanceof com.baidu.tieba.il1) == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:194:0x02fb, code lost:
            ((com.baidu.tieba.il1) r0.b.getStuckScreenHandler()).f(r2, r20.d);
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x030a, code lost:
            r0 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:196:0x030d, code lost:
            r14 = r4;
            r0.i = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:197:0x0312, code lost:
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:198:0x0314, code lost:
            if (r13 == false) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:199:0x0316, code lost:
            r4 = true;
            r13 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:200:0x0319, code lost:
            r4 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:201:0x031a, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x01a0, code lost:
            if (r12 == null) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void j() {
            boolean z;
            boolean z2;
            Runnable runnable;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.D = new c(this.F);
                z = false;
                this.p = false;
                this.q = false;
                this.x = false;
                z2 = false;
                boolean z9 = false;
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                boolean z14 = false;
                int i = 0;
                int i2 = 0;
                runnable = null;
                boolean z15 = false;
                loop0: while (true) {
                    try {
                        synchronized (this.E) {
                            while (!this.i) {
                                if (!this.A.isEmpty()) {
                                    runnable = this.A.pollFirst();
                                } else if (!a() || (!x() && (runnable = g()) == null)) {
                                    if (this.l != this.k) {
                                        boolean z16 = this.k;
                                        this.l = this.k;
                                        if (this.k) {
                                            this.h = z;
                                            this.F.b.smallGameOnPauseOnGLThrad();
                                        } else {
                                            this.h = true;
                                        }
                                        this.E.notifyAll();
                                        StringBuilder sb = new StringBuilder();
                                        z6 = z16;
                                        sb.append("mPaused is now ");
                                        sb.append(this.l);
                                        sb.append(" tid=");
                                        z4 = z10;
                                        z5 = z11;
                                        sb.append(getId());
                                        Log.i(ArBridge.TAG, sb.toString());
                                    } else {
                                        z4 = z10;
                                        z5 = z11;
                                        z6 = false;
                                    }
                                    if (this.s) {
                                        z();
                                        y();
                                        this.s = false;
                                        z10 = true;
                                    } else {
                                        z10 = z4;
                                    }
                                    if (z2) {
                                        z();
                                        y();
                                        z2 = false;
                                    }
                                    if (z6 && this.q) {
                                        z();
                                    }
                                    if (z6) {
                                        boolean z17 = this.p;
                                    }
                                    if (!this.m && !this.o) {
                                        if (this.q) {
                                            z();
                                        }
                                        this.o = true;
                                        this.n = false;
                                        this.E.notifyAll();
                                    }
                                    if (this.m && this.o) {
                                        this.o = false;
                                        this.E.notifyAll();
                                    }
                                    if (z9) {
                                        this.x = false;
                                        this.y = true;
                                        this.E.notifyAll();
                                        z9 = false;
                                    }
                                    if (r()) {
                                        if (!this.p) {
                                            if (z10) {
                                                z11 = z5;
                                                z7 = false;
                                            } else {
                                                try {
                                                    this.D.h();
                                                    this.F.b.setEglContextToRecorder(this.F.l(), 0, 0);
                                                    this.p = true;
                                                    this.E.notifyAll();
                                                    z7 = z10;
                                                    z11 = true;
                                                } catch (RuntimeException e) {
                                                    this.E.a(this);
                                                    throw e;
                                                }
                                            }
                                        } else {
                                            z7 = z10;
                                            z11 = z5;
                                        }
                                        if (this.p && !this.q) {
                                            this.q = true;
                                            z12 = true;
                                            z13 = true;
                                            z14 = true;
                                        }
                                        if (this.q) {
                                            if (this.C) {
                                                int i3 = this.t;
                                                int i4 = this.u;
                                                this.x = true;
                                                this.C = false;
                                                i = i3;
                                                i2 = i4;
                                                z8 = false;
                                                z12 = true;
                                                z14 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            this.w = z8;
                                            this.E.notifyAll();
                                            z10 = z7;
                                            if (this.x) {
                                                z15 = true;
                                            }
                                        } else {
                                            z10 = z7;
                                        }
                                    } else {
                                        z11 = z5;
                                    }
                                    this.E.wait();
                                    z = false;
                                }
                                z3 = z2;
                            }
                            break loop0;
                        }
                    } catch (Throwable th) {
                        synchronized (this.E) {
                            if (this.F != null) {
                                this.F.b.smallGameDestroy();
                            }
                            V8Engine v8Engine = V8Engine.getInstance();
                            if (v8Engine != null && !v8Engine.isDestroyed()) {
                                Log.e(ArBridge.TAG, "v8engine is not destroyed. Please check that you have called the destroyEngine method");
                            }
                            z();
                            y();
                            throw th;
                        }
                    }
                }
                synchronized (this.E) {
                    if (this.F != null) {
                        this.F.b.smallGameDestroy();
                    }
                    V8Engine v8Engine2 = V8Engine.getInstance();
                    if (v8Engine2 != null && !v8Engine2.isDestroyed()) {
                        Log.e(ArBridge.TAG, "v8engine is not destroyed. Please check that you have called the destroyEngine method");
                    }
                    z();
                    y();
                }
                return;
            }
            return;
            if (V8Engine.isDebug() && this.F != null) {
                this.F.m(2, runnable.toString());
            }
            z2 = z3;
            z = false;
            runnable = null;
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (this.E) {
                    Log.i(ArBridge.TAG, "onPause tid=" + getId());
                    this.k = true;
                    if (this.F != null && (this.F.b.getStuckScreenHandler() instanceof il1)) {
                        ((il1) this.F.b.getStuckScreenHandler()).e();
                    }
                    this.E.notifyAll();
                    while (!this.j && !this.l) {
                        Log.i("Main thread", "onPause waiting for mPaused.");
                        try {
                            this.E.wait(500L);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.tieba.hl1, com.baidu.tieba.hl1$c, com.baidu.searchbox.v8engine.V8Engine] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                setName("ARGLThread " + getId());
                hl1 hl1Var = this.F;
                if (hl1Var != null) {
                    ArBridge k = hl1Var.k();
                    if (k != null) {
                        k.setGLThreadID(getId());
                        k.smallGameOnInit();
                        this.F.initDisplayMetrics();
                    } else {
                        Log.e(ArBridge.TAG, "Render Engine Init Failed. ArBridge is null");
                    }
                } else {
                    Log.e(ArBridge.TAG, "Render Engine Init Failed. AREngine is null");
                }
                try {
                    try {
                        j();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } finally {
                    this.E.b(this);
                    this.D.g();
                    this.D = null;
                    this.F = null;
                    this.G = null;
                }
            }
        }

        public void n(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
                synchronized (this.E) {
                    this.t = i;
                    this.u = i2;
                    this.C = true;
                    this.w = true;
                    this.y = false;
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.E.notifyAll();
                    while (!this.j && !this.l && !this.y && a()) {
                        try {
                            this.E.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public final void q(Runnable runnable, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048591, this, runnable, z) == null) {
                if (runnable != null) {
                    if (!this.i && !this.j) {
                        synchronized (this.E) {
                            if (V8Engine.isDebug() && this.F != null) {
                                this.F.m(0, runnable.toString());
                            }
                            if (!z && !a()) {
                                this.A.add(runnable);
                                this.E.notifyAll();
                            }
                            this.z.add(runnable);
                            this.E.notifyAll();
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("r must not be null");
            }
        }

        public void o(Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048589, this, runnable, j) == null) {
                if (runnable != null) {
                    if (!this.i && !this.j) {
                        synchronized (this.E) {
                            TreeSet<e> treeSet = this.B;
                            if (j <= 0) {
                                j = 0;
                            }
                            treeSet.add(new e(runnable, j));
                            this.E.notifyAll();
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("r must not be null");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hl1 a;
        public EGLDisplay b;
        public EGLSurface c;
        public EGLConfig d;
        public EGLContext e;

        public c(hl1 hl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl1Var;
        }

        public final void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                k(str, EGL14.eglGetError());
                throw null;
            }
        }

        public static String d(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
                return str + " failed: " + i;
            }
            return (String) invokeLI.objValue;
        }

        public static void k(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65539, null, str, i) == null) {
                throw new RuntimeException(d(str, i));
            }
        }

        public static void f(String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65538, null, str, str2, i) == null) {
                Log.w(str, d(str2, i));
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.b != null) {
                    if (this.d != null) {
                        b();
                        Object obj = this.a.l;
                        if (obj == null) {
                            obj = this.a.k;
                        }
                        if (obj != null) {
                            this.c = EGL14.eglCreateWindowSurface(this.b, this.d, obj, new int[]{12344}, 0);
                        } else {
                            this.c = null;
                        }
                        EGLSurface eGLSurface = this.c;
                        if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                            return EGL14.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e);
                        }
                        if (EGL14.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            return invokeV.booleanValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                this.b = eglGetDisplay;
                if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                    int[] iArr = new int[2];
                    if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                        EGLConfig e = e(0, 0, false);
                        this.d = e;
                        this.e = EGL14.eglCreateContext(this.b, e, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                        this.a.e = Thread.currentThread().getId();
                        EGLContext eGLContext = this.e;
                        if (eGLContext != null && eGLContext != EGL14.EGL_NO_CONTEXT) {
                            this.c = null;
                            return;
                        }
                        this.e = null;
                        j("createContext");
                        throw null;
                    }
                    this.b = null;
                    throw new RuntimeException("unable to initialize EGL14");
                }
                throw new RuntimeException("unable to get EGL14 display");
            }
        }

        public void b() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (eGLSurface = this.c) != null && eGLSurface != (eGLSurface2 = EGL14.EGL_NO_SURFACE)) {
                EGL14.eglMakeCurrent(this.b, eGLSurface2, eGLSurface2, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.b, this.c);
                this.c = null;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                EGLContext eGLContext = this.e;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.b, eGLContext);
                    this.e = null;
                }
                EGLDisplay eGLDisplay = this.b;
                if (eGLDisplay != null) {
                    EGL14.eglTerminate(eGLDisplay);
                    this.b = null;
                }
                this.a.e = -1L;
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a = null;
            }
        }

        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (!EGL14.eglSwapBuffers(this.b, this.c)) {
                    return EGL14.eglGetError();
                }
                return MessageConstant.CommandId.COMMAND_BASE;
            }
            return invokeV.intValue;
        }

        public final EGLConfig e(int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                if (z) {
                    i3 = 16;
                } else {
                    i3 = 0;
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!EGL14.eglChooseConfig(this.b, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12325, i3, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    Log.w(ArBridge.TAG, "unable to find RGB8888 / " + i2 + " EGLConfig");
                    return null;
                }
                return eGLConfigArr[0];
            }
            return (EGLConfig) invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-743578628, "Lcom/baidu/tieba/hl1$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-743578628, "Lcom/baidu/tieba/hl1$d;");
            }
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        public void a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (this.a == bVar) {
                    this.a = null;
                }
                synchronized (this) {
                    notifyAll();
                }
            }
        }

        public synchronized void b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                synchronized (this) {
                    bVar.j = true;
                    if (this.a == bVar) {
                        this.a = null;
                    }
                    notifyAll();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements Comparable<e>, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;
        public final Runnable b;

        public e(Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = runnable;
            this.a = System.currentTimeMillis() + j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                return (int) (this.a - eVar.a);
            }
            return invokeL.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (System.currentTimeMillis() >= this.a) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.run();
            }
        }
    }

    public hl1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = 0;
        this.f = 0.0f;
        this.g = 0.0f;
        this.i = false;
        this.j = new d(null);
        Log.setMinLogLevel(6, false);
        this.b = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.n && this.h != null) {
                b bVar = this.m;
                if (bVar != null) {
                    i = bVar.h();
                } else {
                    i = 1;
                }
                b bVar2 = new b(this);
                this.m = bVar2;
                if (i != 1) {
                    bVar2.w(i);
                }
                this.m.start();
            }
            this.n = false;
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] onAttachedToWindow");
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceCreated.");
            this.m.A();
            Context appContext = V8Engine.getAppContext();
            if (appContext != null) {
                p = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public synchronized void addDebugConsole(DebugConsole debugConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, debugConsole) == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new ArrayList<>(1);
                }
                this.c.add(debugConsole);
            }
        }
    }

    public void n(String str) {
        ArBridge arBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (arBridge = this.b) != null) {
            arBridge.getPerformanceJsonBean().put(str);
        }
    }

    public void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            this.a = context;
        }
    }

    public void p(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, surfaceHolder) == null) {
            this.l = (SurfaceHolder) new WeakReference(surfaceHolder).get();
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            if (i > 60) {
                i = 60;
            }
            this.d = i;
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, runnable) == null) && (bVar = this.m) != null) {
            bVar.p(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public synchronized void removeDebugConsole(DebugConsole debugConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, debugConsole) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return;
                }
                this.c.remove(debugConsole);
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, runnable) == null) && (bVar = this.m) != null) {
            bVar.v(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(zc0 zc0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, zc0Var) == null) && this.b.getGameRecorder() != null) {
            this.b.getGameRecorder().A(zc0Var);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, firstFrameListener) == null) {
            this.b.setFirstFrameListener(firstFrameListener);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(bd0 bd0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, bd0Var) == null) && this.b.getGameRecorder() != null) {
            this.b.getGameRecorder().C(bd0Var);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(kl1 kl1Var) {
        ArBridge arBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, kl1Var) == null) && (arBridge = this.b) != null) {
            arBridge.setOnStuckScreenListener(kl1Var);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, permissionProxy) == null) {
            o = permissionProxy;
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048615, this, i) == null) && (bVar = this.m) != null) {
            bVar.w(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, renderer) == null) {
            this.h = renderer;
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.b.setScreenShotStatus(z);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        ArBridge arBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048618, this, j) == null) && (arBridge = this.b) != null) {
            arBridge.setStuckScreenLimitTime(j);
        }
    }

    public final void m(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048593, this, i, str) == null) && this.c != null) {
            for (DebugConsole debugConsole : new ArrayList(this.c)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048604, this, runnable, j) == null) && (bVar = this.m) != null) {
            bVar.o(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = this.m;
            if (bVar != null && bVar.a()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bVar = this.m) != null) {
            bVar.f();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.s();
            }
            Log.e(ArBridge.TAG, "[V8Dispose][AREngine] exitGLThread.");
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                if (this.m != null) {
                    this.m.s();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.b.getGameRecorder() != null) {
                return this.b.getGameRecorder().s();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getFPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return (Thread) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArBridge arBridge = this.b;
            if (arBridge == null) {
                return new JSONArray();
            }
            return arBridge.getPerformanceJson();
        }
        return (JSONArray) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArBridge arBridge = this.b;
            if (arBridge == null) {
                return new PerformanceJsonBean();
            }
            return arBridge.getPerformanceJsonBean();
        }
        return (PerformanceJsonBean) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            b bVar = this.m;
            if (bVar != null) {
                return bVar.h();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public ml1 getStuckScreenHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArBridge arBridge = this.b;
            if (arBridge == null) {
                return null;
            }
            return arBridge.getStuckScreenHandler();
        }
        return (ml1) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public ArBridge k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b;
        }
        return (ArBridge) invokeV.objValue;
    }

    public EGLContext l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b bVar = this.m;
            if (bVar == null || bVar.D == null) {
                return null;
            }
            return this.m.D.e;
        }
        return (EGLContext) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!this.n && (bVar = this.m) != null) {
                bVar.s();
            }
            this.n = true;
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] onDetachedFromWindow");
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.l();
            }
            if (this.b.getGameRecorder() != null) {
                this.b.getGameRecorder().w();
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.m();
            }
            if (this.b.getGameRecorder() != null) {
                this.b.getGameRecorder().z();
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.b.getGameRecorder() != null) {
            this.b.getGameRecorder().v();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (bVar = this.m) != null) {
            bVar.t();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (bVar = this.m) != null) {
            bVar.u();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.b.getGameRecorder() != null) {
            this.b.getGameRecorder().y();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            b bVar = this.m;
            if (bVar == null) {
                Log.e(ArBridge.TAG, "Destroy AREngine fail. Because GLThread is null");
            } else {
                bVar.v(new a(this));
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.b.smallGameOnPause();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.b.smallGameUpdate();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.h != null) {
                b bVar = new b(this);
                this.m = bVar;
                bVar.start();
                return;
            }
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && this.b.getGameRecorder() != null) {
            this.b.getGameRecorder().I();
            this.b.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceDestroyed.");
            this.m.B();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void initDisplayMetrics() {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Context context = getContext();
            if (context != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                float f3 = displayMetrics.widthPixels;
                float f4 = displayMetrics.heightPixels;
                float f5 = this.f;
                if (f5 != 0.0f) {
                    f = f5;
                } else {
                    f = f3;
                }
                float f6 = this.g;
                if (f6 != 0.0f) {
                    f2 = f6;
                } else {
                    f2 = f4;
                }
                ArBridge arBridge = this.b;
                if (arBridge != null) {
                    arBridge.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
                    return;
                } else {
                    Log.e(ArBridge.TAG, "[RenderError] error init render display, because arbridge is null");
                    return;
                }
            }
            throw new NullPointerException("[RenderError] initDisplayMetrics Error. because AppContext is null");
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2)}) == null) && this.b.getGameRecorder() != null) {
            this.b.nativeUpdateRecordingStatus(true);
            this.b.getGameRecorder().F(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048625, this, i, i2) == null) {
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
            this.m.n(i, i2);
            this.b.setEglContextToRecorder(l(), i, i2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void updateSurfaceViewSize(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            Log.w(ArBridge.TAG, "[ARDispose] updateSurfaceViewSize, width=" + f + ", height=" + f2);
            this.f = f;
            this.g = f2;
            this.b.setSize(f, f2);
        }
    }
}
