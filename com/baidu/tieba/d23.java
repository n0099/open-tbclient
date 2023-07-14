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
import com.baidu.tieba.p23;
import com.baidu.tieba.sw2;
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
/* loaded from: classes5.dex */
public class d23 extends HandlerThread implements c23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public f23 a;
        public Deque<f23> b;
        public boolean c;
        public p23 d;
        public int e;
        public HashMap<String, Integer> f;
        public q23 g;
        public final /* synthetic */ d23 h;

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.d23$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0263a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.d23$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public class RunnableC0264a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0264a(RunnableC0263a runnableC0263a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0263a, swanAppActivity};
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
                            if (d23.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0263a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        pp3.a0(new RunnableC0264a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            h23.c(this.c.a.a, 33, false, this.c.a.b.size());
                            wb2.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            wb2.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && e23.g()) {
                            wb2.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = ix2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    po3.f().execute(new RunnableC0263a(this, mp3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.d23$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0262a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f23 a;
            public final /* synthetic */ a b;

            public RunnableC0262a(a aVar, f23 f23Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, f23Var};
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
                this.a = f23Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = mp3.p();
                    if (p != null) {
                        f23 f23Var = this.a;
                        Message.obtain(this.b, 8, new n23(f23Var.a, p, f23Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d23 d23Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d23Var, looper};
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
            this.h = d23Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = p23.a.a("simple_parser");
            this.g = (q23) p23.a.a("hsv_parser");
        }

        public final void g(f23 f23Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, f23Var) == null) && f23Var != null && i(f23Var.a)) {
                pp3.e0(new RunnableC0262a(this, f23Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                f23 f23Var = this.a;
                if (f23Var != null && str != null && TextUtils.equals(str, f23Var.a)) {
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
                f23 f23Var = this.a;
                if (f23Var != null && f23Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (d23.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                pp3.a0(new b(this));
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
                if (d23.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (ji3.d) {
                            q((m23) message.obj);
                            return;
                        } else {
                            p((m23) message.obj);
                            return;
                        }
                    case 2:
                        g((f23) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((l23) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        k23 k23Var = (k23) message.obj;
                        if (k23Var != null) {
                            if (k23Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((o23) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((n23) message.obj);
                        return;
                    case 9:
                        o((m23) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((m23) message.obj);
                        return;
                    case 13:
                        q((m23) message.obj);
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
                f23 f23Var = this.a;
                if (f23Var != null && !f23Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (d23.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = jk3.a().getString("screenshot_upload_switch", "1");
                if (d23.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(m23 m23Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, m23Var) == null) {
                this.h.a.removeMessages(2);
                f23 f23Var = this.a;
                if (f23Var != null) {
                    str = f23Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (d23.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + m23Var.a());
                }
            }
        }

        public final void o(@NonNull m23 m23Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, m23Var) == null) && m23Var.c() >= 0) {
                eb2 U = ix2.T().U();
                if (U != null && U.k() > 0) {
                    return;
                }
                if (d23.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + m23Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, m23Var), m23Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                g23.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                ix2.T().u(wh3.a(new wh3()));
                ix2.T().m(str, wh3.a(new wh3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                f23 f23Var = this.a;
                if (f23Var != null && f23Var.c() && this.a.c && h()) {
                    g23.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    g23.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    xb2.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                f23 f23Var = this.a;
                if (f23Var != null && f23Var.i && !f23Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (d23.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            sw2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = ix2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                xq3 U = activity.U();
                if (U != null && (view2 = U.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (d23.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                on3 on3Var = new on3();
                on3Var.k(5L);
                on3Var.i(19L);
                on3Var.f("loading=true");
                vb3 b0 = vb3.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                wi3 wi3Var = new wi3();
                wi3Var.p(on3Var);
                wi3Var.r(W);
                wi3Var.q(oi3.n(ub3.K().k()));
                wi3Var.m(ub3.K().getAppId());
                wi3Var.s(String.valueOf(this.b.size()));
                wi3Var.n(false);
                oi3.R(wi3Var);
            }
        }

        public final void p(m23 m23Var) {
            db2 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, m23Var) == null) && (f = e23.f()) != null) {
                String v3 = f.v3();
                by1 q3 = f.q3();
                if (d23.b && q3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + v3);
                }
                if (q3 != null && !i(v3)) {
                    f23 f23Var = new f23(v3, f.o3().a, m23Var.c(), m23Var.a());
                    this.b.addLast(f23Var);
                    this.a = f23Var;
                    q3.s(j23.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(v3)) {
                        this.a.g = this.f.remove(v3).intValue();
                    }
                    if (!this.c && f23Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, f23Var), this.a.b());
                    }
                }
            }
        }

        public final void q(m23 m23Var) {
            db2 f;
            by1 q3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, m23Var) != null) || (f = e23.f()) == null || (q3 = f.q3()) == null) {
                return;
            }
            String v3 = f.v3();
            f23 f23Var = new f23(v3, f.o3().a, m23Var.c(), m23Var.a());
            if (!i(v3)) {
                this.b.addLast(f23Var);
                q3.s(j23.e());
            }
            this.a = f23Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(v3)) {
                this.a.g = this.f.get(v3).intValue();
            }
            if (!this.c && f23Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, f23Var), this.a.b());
                if (d23.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + v3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(o23 o23Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, o23Var) != null) || o23Var == null) {
                return;
            }
            String d = o23Var.d();
            f23 f23Var = null;
            Iterator<f23> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f23 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    f23Var = next;
                    break;
                }
            }
            int i = 1;
            if (o23Var.e()) {
                if (f23Var != null) {
                    f23Var.g++;
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
            } else if (f23Var != null) {
                f23Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(n23 n23Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, n23Var) == null) && n23Var != null && i(n23Var.d())) {
                g23.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = n23Var.e();
                db2 f = e23.f();
                View B = ix2.T().B(n23Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = e23.b(e, f, B);
                    this.d.c(e23.d(f));
                    this.a.g();
                    boolean a = n23Var.a();
                    if (!e23.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            g23.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            e23.i(a, n23Var.d());
                            int i = 19;
                            if (ji3.d && !a) {
                                i = 55;
                            }
                            h23.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        g23.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (d23.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + n23Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            g23.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (ji3.d && !a) {
                                i3 = 56;
                            }
                            h23.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            vc2 vc2Var = new vc2();
                            if (e23.g()) {
                                if (i2 >= 0) {
                                    vc2Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    vc2Var.d(n23Var.d());
                                    this.a.c = true;
                                    g23.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                vc2Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                vc2Var.d(n23Var.d());
                                this.a.c = true;
                                g23.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                kc2.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947652612, "Lcom/baidu/tieba/d23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947652612, "Lcom/baidu/tieba/d23;");
                return;
            }
        }
        b = vb3.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d23() {
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

    @Override // com.baidu.tieba.c23
    public void a(m23 m23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m23Var) == null) {
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
            if (m23Var != null) {
                Message.obtain(this.a, m23Var.b(), m23Var).sendToTarget();
            }
        }
    }
}
