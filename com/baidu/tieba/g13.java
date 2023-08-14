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
import com.baidu.tieba.s13;
import com.baidu.tieba.vv2;
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
/* loaded from: classes6.dex */
public class g13 extends HandlerThread implements f13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public i13 a;
        public Deque<i13> b;
        public boolean c;
        public s13 d;
        public int e;
        public HashMap<String, Integer> f;
        public t13 g;
        public final /* synthetic */ g13 h;

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.g13$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0310a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.g13$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0311a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0311a(RunnableC0310a runnableC0310a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0310a, swanAppActivity};
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
                            if (g13.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0310a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        so3.a0(new RunnableC0311a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            k13.c(this.c.a.a, 33, false, this.c.a.b.size());
                            za2.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            za2.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && h13.g()) {
                            za2.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = lw2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    sn3.f().execute(new RunnableC0310a(this, po3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.g13$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0309a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i13 a;
            public final /* synthetic */ a b;

            public RunnableC0309a(a aVar, i13 i13Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, i13Var};
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
                this.a = i13Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = po3.p();
                    if (p != null) {
                        i13 i13Var = this.a;
                        Message.obtain(this.b, 8, new q13(i13Var.a, p, i13Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g13 g13Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g13Var, looper};
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
            this.h = g13Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = s13.a.a("simple_parser");
            this.g = (t13) s13.a.a("hsv_parser");
        }

        public final void g(i13 i13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, i13Var) == null) && i13Var != null && i(i13Var.a)) {
                so3.e0(new RunnableC0309a(this, i13Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                i13 i13Var = this.a;
                if (i13Var != null && str != null && TextUtils.equals(str, i13Var.a)) {
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
                i13 i13Var = this.a;
                if (i13Var != null && i13Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (g13.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                so3.a0(new b(this));
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
                if (g13.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (mh3.d) {
                            q((p13) message.obj);
                            return;
                        } else {
                            p((p13) message.obj);
                            return;
                        }
                    case 2:
                        g((i13) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((o13) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        n13 n13Var = (n13) message.obj;
                        if (n13Var != null) {
                            if (n13Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((r13) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((q13) message.obj);
                        return;
                    case 9:
                        o((p13) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((p13) message.obj);
                        return;
                    case 13:
                        q((p13) message.obj);
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
                i13 i13Var = this.a;
                if (i13Var != null && !i13Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (g13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = mj3.a().getString("screenshot_upload_switch", "1");
                if (g13.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(p13 p13Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, p13Var) == null) {
                this.h.a.removeMessages(2);
                i13 i13Var = this.a;
                if (i13Var != null) {
                    str = i13Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (g13.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + p13Var.a());
                }
            }
        }

        public final void o(@NonNull p13 p13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, p13Var) == null) && p13Var.c() >= 0) {
                ha2 U = lw2.T().U();
                if (U != null && U.k() > 0) {
                    return;
                }
                if (g13.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + p13Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, p13Var), p13Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                j13.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                lw2.T().u(zg3.a(new zg3()));
                lw2.T().m(str, zg3.a(new zg3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                i13 i13Var = this.a;
                if (i13Var != null && i13Var.c() && this.a.c && h()) {
                    j13.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    j13.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    ab2.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                i13 i13Var = this.a;
                if (i13Var != null && i13Var.i && !i13Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (g13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            vv2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = lw2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                aq3 U = activity.U();
                if (U != null && (view2 = U.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (g13.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                rm3 rm3Var = new rm3();
                rm3Var.k(5L);
                rm3Var.i(19L);
                rm3Var.f("loading=true");
                ya3 b0 = ya3.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                zh3 zh3Var = new zh3();
                zh3Var.p(rm3Var);
                zh3Var.r(W);
                zh3Var.q(rh3.n(xa3.K().k()));
                zh3Var.m(xa3.K().getAppId());
                zh3Var.s(String.valueOf(this.b.size()));
                zh3Var.n(false);
                rh3.R(zh3Var);
            }
        }

        public final void p(p13 p13Var) {
            ga2 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, p13Var) == null) && (f = h13.f()) != null) {
                String v3 = f.v3();
                ex1 q3 = f.q3();
                if (g13.b && q3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + v3);
                }
                if (q3 != null && !i(v3)) {
                    i13 i13Var = new i13(v3, f.o3().a, p13Var.c(), p13Var.a());
                    this.b.addLast(i13Var);
                    this.a = i13Var;
                    q3.s(m13.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(v3)) {
                        this.a.g = this.f.remove(v3).intValue();
                    }
                    if (!this.c && i13Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, i13Var), this.a.b());
                    }
                }
            }
        }

        public final void q(p13 p13Var) {
            ga2 f;
            ex1 q3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, p13Var) != null) || (f = h13.f()) == null || (q3 = f.q3()) == null) {
                return;
            }
            String v3 = f.v3();
            i13 i13Var = new i13(v3, f.o3().a, p13Var.c(), p13Var.a());
            if (!i(v3)) {
                this.b.addLast(i13Var);
                q3.s(m13.e());
            }
            this.a = i13Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(v3)) {
                this.a.g = this.f.get(v3).intValue();
            }
            if (!this.c && i13Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, i13Var), this.a.b());
                if (g13.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + v3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(r13 r13Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, r13Var) != null) || r13Var == null) {
                return;
            }
            String d = r13Var.d();
            i13 i13Var = null;
            Iterator<i13> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i13 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    i13Var = next;
                    break;
                }
            }
            int i = 1;
            if (r13Var.e()) {
                if (i13Var != null) {
                    i13Var.g++;
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
            } else if (i13Var != null) {
                i13Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(q13 q13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, q13Var) == null) && q13Var != null && i(q13Var.d())) {
                j13.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = q13Var.e();
                ga2 f = h13.f();
                View B = lw2.T().B(q13Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = h13.b(e, f, B);
                    this.d.c(h13.d(f));
                    this.a.g();
                    boolean a = q13Var.a();
                    if (!h13.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            j13.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            h13.i(a, q13Var.d());
                            int i = 19;
                            if (mh3.d && !a) {
                                i = 55;
                            }
                            k13.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        j13.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (g13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + q13Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            j13.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (mh3.d && !a) {
                                i3 = 56;
                            }
                            k13.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            yb2 yb2Var = new yb2();
                            if (h13.g()) {
                                if (i2 >= 0) {
                                    yb2Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    yb2Var.d(q13Var.d());
                                    this.a.c = true;
                                    j13.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                yb2Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                yb2Var.d(q13Var.d());
                                this.a.c = true;
                                j13.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                nb2.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947741024, "Lcom/baidu/tieba/g13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947741024, "Lcom/baidu/tieba/g13;");
                return;
            }
        }
        b = ya3.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g13() {
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

    @Override // com.baidu.tieba.f13
    public void a(p13 p13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p13Var) == null) {
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
            if (p13Var != null) {
                Message.obtain(this.a, p13Var.b(), p13Var).sendToTarget();
            }
        }
    }
}
