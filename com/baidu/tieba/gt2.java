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
import com.baidu.tieba.st2;
import com.baidu.tieba.vn2;
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
public class gt2 extends HandlerThread implements ft2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public it2 a;
        public Deque<it2> b;
        public boolean c;
        public st2 d;
        public int e;
        public HashMap<String, Integer> f;
        public tt2 g;
        public final /* synthetic */ gt2 h;

        /* renamed from: com.baidu.tieba.gt2$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0276a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ it2 a;
            public final /* synthetic */ a b;

            public RunnableC0276a(a aVar, it2 it2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, it2Var};
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
                this.a = it2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = pg3.p();
                    if (p != null) {
                        it2 it2Var = this.a;
                        Message.obtain(this.b, 8, new qt2(it2Var.a, p, it2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.gt2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0277a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.gt2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class RunnableC0278a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0278a(RunnableC0277a runnableC0277a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0277a, swanAppActivity};
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
                            if (gt2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0277a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        sg3.a0(new RunnableC0278a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            kt2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            z22.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            z22.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d < 0.5d || !ht2.g()) {
                        } else {
                            z22.a("exit_whiteScreen_L3");
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = lo2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.a.a == null) {
                    return;
                }
                sf3.f().execute(new RunnableC0277a(this, pg3.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gt2 gt2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt2Var, looper};
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
            this.h = gt2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = st2.a.a("simple_parser");
            this.g = (tt2) st2.a.a("hsv_parser");
        }

        public final void g(it2 it2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, it2Var) == null) && it2Var != null && i(it2Var.a)) {
                sg3.e0(new RunnableC0276a(this, it2Var));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                it2 it2Var = this.a;
                return it2Var != null && it2Var.i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (gt2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (m93.d) {
                            q((pt2) message.obj);
                            return;
                        } else {
                            p((pt2) message.obj);
                            return;
                        }
                    case 2:
                        g((it2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((ot2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        nt2 nt2Var = (nt2) message.obj;
                        if (nt2Var != null) {
                            if (nt2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((rt2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((qt2) message.obj);
                        return;
                    case 9:
                        o((pt2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((pt2) message.obj);
                        return;
                    case 13:
                        q((pt2) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                it2 it2Var = this.a;
                return (it2Var == null || str == null || !TextUtils.equals(str, it2Var.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                it2 it2Var = this.a;
                if (it2Var == null || it2Var.c()) {
                    return;
                }
                if (this.h.a != null) {
                    this.h.a.removeMessages(2);
                }
                this.a.d();
                if (gt2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void k(pt2 pt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, pt2Var) == null) {
                this.h.a.removeMessages(2);
                it2 it2Var = this.a;
                String str = it2Var != null ? it2Var.a : StringUtil.NULL_STRING;
                if (gt2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + pt2Var.a());
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                it2 it2Var = this.a;
                if (it2Var != null && it2Var.c() && this.a.c && h()) {
                    jt2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    jt2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    a32.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                it2 it2Var = this.a;
                if (it2Var == null || !it2Var.i || it2Var.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                }
                if (gt2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = lo2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            ai3 T = activity.T();
            boolean z = (T == null || (view2 = T.a) == null || view2.getVisibility() != 0) ? false : true;
            if (gt2.b) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                re3 re3Var = new re3();
                re3Var.k(5L);
                re3Var.i(19L);
                re3Var.f("loading=true");
                y23 b0 = y23.b0();
                vn2.a W = b0 == null ? null : b0.W();
                z93 z93Var = new z93();
                z93Var.p(re3Var);
                z93Var.r(W);
                z93Var.q(r93.n(x23.K().k()));
                z93Var.m(x23.K().getAppId());
                z93Var.s(String.valueOf(this.b.size()));
                z93Var.n(false);
                r93.R(z93Var);
            }
        }

        public final void o(@NonNull pt2 pt2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, pt2Var) == null) || pt2Var.c() < 0) {
                return;
            }
            h22 V = lo2.U().V();
            if (V == null || V.k() <= 0) {
                if (gt2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + pt2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, pt2Var), pt2Var.c());
            }
        }

        public final void p(pt2 pt2Var) {
            g22 f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, pt2Var) == null) || (f = ht2.f()) == null) {
                return;
            }
            String t3 = f.t3();
            ep1 o3 = f.o3();
            if (gt2.b && o3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + t3);
            }
            if (o3 == null || i(t3)) {
                return;
            }
            it2 it2Var = new it2(t3, f.m3().a, pt2Var.c(), pt2Var.a());
            this.b.addLast(it2Var);
            this.a = it2Var;
            o3.t(mt2.e());
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.remove(t3).intValue();
            }
            if (this.c || it2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, it2Var), this.a.b());
        }

        public final void q(pt2 pt2Var) {
            g22 f;
            ep1 o3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, pt2Var) == null) || (f = ht2.f()) == null || (o3 = f.o3()) == null) {
                return;
            }
            String t3 = f.t3();
            it2 it2Var = new it2(t3, f.m3().a, pt2Var.c(), pt2Var.a());
            if (!i(t3)) {
                this.b.addLast(it2Var);
                o3.t(mt2.e());
            }
            this.a = it2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.get(t3).intValue();
            }
            if (this.c || it2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, it2Var), this.a.b());
            if (gt2.b) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + t3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
            }
        }

        public final void r(rt2 rt2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, rt2Var) == null) || rt2Var == null) {
                return;
            }
            String d = rt2Var.d();
            it2 it2Var = null;
            Iterator<it2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                it2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    it2Var = next;
                    break;
                }
            }
            if (rt2Var.e()) {
                if (it2Var != null) {
                    it2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                this.f.put(d, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (it2Var != null) {
                it2Var.g--;
            } else {
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap == null || (num = hashMap.get(d)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f.put(d, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(qt2 qt2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, qt2Var) == null) && qt2Var != null && i(qt2Var.d())) {
                jt2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = qt2Var.e();
                g22 f = ht2.f();
                View B = lo2.U().B(qt2Var.d());
                if (e == null || B == null || f == null) {
                    return;
                }
                Rect b2 = ht2.b(e, f, B);
                this.d.c(ht2.d(f));
                this.a.g();
                boolean a = qt2Var.a();
                if (!ht2.h() && this.e <= 0) {
                    this.a.c = this.d.a(e, b2);
                    if (this.a.c) {
                        jt2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e);
                            this.a.h = b2;
                        }
                        ht2.i(a, qt2Var.d());
                        int i = 19;
                        if (m93.d && !a) {
                            i = 55;
                        }
                        kt2.c(this.a, i, a, this.b.size());
                    }
                } else {
                    jt2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                    this.a.c = false;
                }
                this.a.a();
                if (gt2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + qt2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                }
                if (this.a.c) {
                    return;
                }
                double d = this.g.d(e, b2);
                int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                if (i2 >= 0) {
                    jt2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i3 = 28;
                    if (m93.d && !a) {
                        i3 = 56;
                    }
                    kt2.d(this.a, i3, w(), e, a, this.b.size());
                }
                if (a) {
                    y32 y32Var = new y32();
                    if (ht2.g()) {
                        if (i2 >= 0) {
                            y32Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            y32Var.d(qt2Var.d());
                            this.a.c = true;
                            jt2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.e == 0 && d >= 0.7d) {
                        y32Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        y32Var.d(qt2Var.d());
                        this.a.c = true;
                        jt2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        n32.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (gt2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                sg3.a0(new b(this));
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

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                jt2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                lo2.U().u(z83.a(new z83()));
                lo2.U().m(str, z83.a(new z83()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = mb3.a().getString("screenshot_upload_switch", "1");
                if (gt2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947805380, "Lcom/baidu/tieba/gt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947805380, "Lcom/baidu/tieba/gt2;");
                return;
            }
        }
        b = y23.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt2() {
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

    @Override // com.baidu.tieba.ft2
    public void a(pt2 pt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pt2Var) == null) {
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
            if (pt2Var != null) {
                Message.obtain(this.a, pt2Var.b(), pt2Var).sendToTarget();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.a = new a(this, getLooper());
        }
    }
}
