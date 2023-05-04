package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.ry2;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes4.dex */
public class fy2 extends HandlerThread implements ey2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hy2 a;
        public Deque<hy2> b;
        public boolean c;
        public ry2 d;
        public int e;
        public HashMap<String, Integer> f;
        public sy2 g;
        public final /* synthetic */ fy2 h;

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.fy2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0278a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.fy2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class RunnableC0279a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0279a(RunnableC0278a runnableC0278a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0278a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            if (fy2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0278a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = bVar;
                    this.a = bitmap;
                    this.b = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        rl3.a0(new RunnableC0279a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            jy2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            y72.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            y72.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && gy2.g()) {
                            y72.a("exit_whiteScreen_L3");
                            a(this.b);
                        }
                    }
                }
            }

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = kt2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    rk3.f().execute(new RunnableC0278a(this, ol3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.fy2$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0277a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hy2 a;
            public final /* synthetic */ a b;

            public RunnableC0277a(a aVar, hy2 hy2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hy2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = hy2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = ol3.p();
                    if (p != null) {
                        hy2 hy2Var = this.a;
                        Message.obtain(this.b, 8, new py2(hy2Var.a, p, hy2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fy2 fy2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy2Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = fy2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = ry2.a.a("simple_parser");
            this.g = (sy2) ry2.a.a("hsv_parser");
        }

        public final void g(hy2 hy2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hy2Var) == null) && hy2Var != null && i(hy2Var.a)) {
                rl3.e0(new RunnableC0277a(this, hy2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                hy2 hy2Var = this.a;
                if (hy2Var != null && str != null && TextUtils.equals(str, hy2Var.a)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                hy2 hy2Var = this.a;
                if (hy2Var != null && hy2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (fy2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                rl3.a0(new b(this));
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.b.clear();
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.a = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (fy2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (le3.d) {
                            q((oy2) message.obj);
                            return;
                        } else {
                            p((oy2) message.obj);
                            return;
                        }
                    case 2:
                        g((hy2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((ny2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        my2 my2Var = (my2) message.obj;
                        if (my2Var != null) {
                            if (my2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((qy2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((py2) message.obj);
                        return;
                    case 9:
                        o((oy2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((oy2) message.obj);
                        return;
                    case 13:
                        q((oy2) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                hy2 hy2Var = this.a;
                if (hy2Var != null && !hy2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (fy2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = lg3.a().getString("screenshot_upload_switch", "1");
                if (fy2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(oy2 oy2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, oy2Var) == null) {
                this.h.a.removeMessages(2);
                hy2 hy2Var = this.a;
                if (hy2Var != null) {
                    str = hy2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (fy2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + oy2Var.a());
                }
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                iy2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                kt2.U().u(yd3.a(new yd3()));
                kt2.U().m(str, yd3.a(new yd3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                hy2 hy2Var = this.a;
                if (hy2Var != null && hy2Var.c() && this.a.c && h()) {
                    iy2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    iy2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    z72.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                hy2 hy2Var = this.a;
                if (hy2Var != null && hy2Var.i && !hy2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (fy2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            us2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = kt2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                zm3 V = activity.V();
                if (V != null && (view2 = V.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (fy2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                qj3 qj3Var = new qj3();
                qj3Var.k(5L);
                qj3Var.i(19L);
                qj3Var.f("loading=true");
                x73 b0 = x73.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                ye3 ye3Var = new ye3();
                ye3Var.p(qj3Var);
                ye3Var.r(W);
                ye3Var.q(qe3.n(w73.K().k()));
                ye3Var.m(w73.K().getAppId());
                ye3Var.s(String.valueOf(this.b.size()));
                ye3Var.n(false);
                qe3.R(ye3Var);
            }
        }

        public final void o(@NonNull oy2 oy2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, oy2Var) == null) && oy2Var.c() >= 0) {
                g72 V = kt2.U().V();
                if (V != null && V.k() > 0) {
                    return;
                }
                if (fy2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + oy2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, oy2Var), oy2Var.c());
            }
        }

        public final void r(qy2 qy2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, qy2Var) != null) || qy2Var == null) {
                return;
            }
            String d = qy2Var.d();
            hy2 hy2Var = null;
            Iterator<hy2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                hy2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    hy2Var = next;
                    break;
                }
            }
            int i = 1;
            if (qy2Var.e()) {
                if (hy2Var != null) {
                    hy2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                HashMap<String, Integer> hashMap = this.f;
                if (num2 != null) {
                    i = 1 + num2.intValue();
                }
                hashMap.put(d, Integer.valueOf(i));
            } else if (hy2Var != null) {
                hy2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void p(oy2 oy2Var) {
            f72 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, oy2Var) == null) && (f = gy2.f()) != null) {
                String w3 = f.w3();
                du1 r3 = f.r3();
                if (fy2.b && r3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + w3);
                }
                if (r3 != null && !i(w3)) {
                    hy2 hy2Var = new hy2(w3, f.p3().a, oy2Var.c(), oy2Var.a());
                    this.b.addLast(hy2Var);
                    this.a = hy2Var;
                    r3.t(ly2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(w3)) {
                        this.a.g = this.f.remove(w3).intValue();
                    }
                    if (!this.c && hy2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, hy2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(oy2 oy2Var) {
            f72 f;
            du1 r3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, oy2Var) != null) || (f = gy2.f()) == null || (r3 = f.r3()) == null) {
                return;
            }
            String w3 = f.w3();
            hy2 hy2Var = new hy2(w3, f.p3().a, oy2Var.c(), oy2Var.a());
            if (!i(w3)) {
                this.b.addLast(hy2Var);
                r3.t(ly2.e());
            }
            this.a = hy2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(w3)) {
                this.a.g = this.f.get(w3).intValue();
            }
            if (!this.c && hy2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, hy2Var), this.a.b());
                if (fy2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + w3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void s(py2 py2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, py2Var) == null) && py2Var != null && i(py2Var.d())) {
                iy2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = py2Var.e();
                f72 f = gy2.f();
                View B = kt2.U().B(py2Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = gy2.b(e, f, B);
                    this.d.c(gy2.d(f));
                    this.a.g();
                    boolean a = py2Var.a();
                    if (!gy2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            iy2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            gy2.i(a, py2Var.d());
                            int i = 19;
                            if (le3.d && !a) {
                                i = 55;
                            }
                            jy2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        iy2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (fy2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + py2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            iy2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (le3.d && !a) {
                                i3 = 56;
                            }
                            jy2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            x82 x82Var = new x82();
                            if (gy2.g()) {
                                if (i2 >= 0) {
                                    x82Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    x82Var.d(py2Var.d());
                                    this.a.c = true;
                                    iy2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                x82Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                x82Var.d(py2Var.d());
                                this.a.c = true;
                                iy2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                m82.b().a();
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947780394, "Lcom/baidu/tieba/fy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947780394, "Lcom/baidu/tieba/fy2;");
                return;
            }
        }
        b = x73.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fy2() {
        super("SwanAppPageMonitor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.a = new a(this, getLooper());
        }
    }

    @Override // com.baidu.tieba.ey2
    public void a(oy2 oy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oy2Var) == null) {
            if (!isAlive()) {
                if (b) {
                    Log.d("SwanAppPageMonitor", "thread is not alive");
                }
                try {
                    d();
                } catch (Error | Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (oy2Var != null) {
                Message.obtain(this.a, oy2Var.b(), oy2Var).sendToTarget();
            }
        }
    }
}
