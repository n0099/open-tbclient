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
import com.baidu.tieba.qz2;
import com.baidu.tieba.tt2;
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
public class ez2 extends HandlerThread implements dz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gz2 a;
        public Deque<gz2> b;
        public boolean c;
        public qz2 d;
        public int e;
        public HashMap<String, Integer> f;
        public rz2 g;
        public final /* synthetic */ ez2 h;

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.ez2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0262a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.ez2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class RunnableC0263a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0263a(RunnableC0262a runnableC0262a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0262a, swanAppActivity};
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
                            if (ez2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0262a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        qm3.a0(new RunnableC0263a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            iz2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            x82.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            x82.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && fz2.g()) {
                            x82.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = ju2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    ql3.f().execute(new RunnableC0262a(this, nm3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.ez2$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0261a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gz2 a;
            public final /* synthetic */ a b;

            public RunnableC0261a(a aVar, gz2 gz2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gz2Var};
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
                this.a = gz2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = nm3.p();
                    if (p != null) {
                        gz2 gz2Var = this.a;
                        Message.obtain(this.b, 8, new oz2(gz2Var.a, p, gz2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ez2 ez2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ez2Var, looper};
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
            this.h = ez2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = qz2.a.a("simple_parser");
            this.g = (rz2) qz2.a.a("hsv_parser");
        }

        public final void g(gz2 gz2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, gz2Var) == null) && gz2Var != null && i(gz2Var.a)) {
                qm3.e0(new RunnableC0261a(this, gz2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                gz2 gz2Var = this.a;
                if (gz2Var != null && str != null && TextUtils.equals(str, gz2Var.a)) {
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
                gz2 gz2Var = this.a;
                if (gz2Var != null && gz2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (ez2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                qm3.a0(new b(this));
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
                if (ez2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (kf3.d) {
                            q((nz2) message.obj);
                            return;
                        } else {
                            p((nz2) message.obj);
                            return;
                        }
                    case 2:
                        g((gz2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((mz2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        lz2 lz2Var = (lz2) message.obj;
                        if (lz2Var != null) {
                            if (lz2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((pz2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((oz2) message.obj);
                        return;
                    case 9:
                        o((nz2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((nz2) message.obj);
                        return;
                    case 13:
                        q((nz2) message.obj);
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
                gz2 gz2Var = this.a;
                if (gz2Var != null && !gz2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (ez2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = kh3.a().getString("screenshot_upload_switch", "1");
                if (ez2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(nz2 nz2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, nz2Var) == null) {
                this.h.a.removeMessages(2);
                gz2 gz2Var = this.a;
                if (gz2Var != null) {
                    str = gz2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (ez2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + nz2Var.a());
                }
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                hz2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                ju2.U().u(xe3.a(new xe3()));
                ju2.U().m(str, xe3.a(new xe3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                gz2 gz2Var = this.a;
                if (gz2Var != null && gz2Var.c() && this.a.c && h()) {
                    hz2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    hz2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    y82.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                gz2 gz2Var = this.a;
                if (gz2Var != null && gz2Var.i && !gz2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (ez2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            tt2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = ju2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                yn3 T = activity.T();
                if (T != null && (view2 = T.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (ez2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                pk3 pk3Var = new pk3();
                pk3Var.k(5L);
                pk3Var.i(19L);
                pk3Var.f("loading=true");
                w83 b0 = w83.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                xf3 xf3Var = new xf3();
                xf3Var.p(pk3Var);
                xf3Var.r(W);
                xf3Var.q(pf3.n(v83.K().k()));
                xf3Var.m(v83.K().getAppId());
                xf3Var.s(String.valueOf(this.b.size()));
                xf3Var.n(false);
                pf3.R(xf3Var);
            }
        }

        public final void o(@NonNull nz2 nz2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, nz2Var) == null) && nz2Var.c() >= 0) {
                f82 V = ju2.U().V();
                if (V != null && V.k() > 0) {
                    return;
                }
                if (ez2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + nz2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, nz2Var), nz2Var.c());
            }
        }

        public final void r(pz2 pz2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, pz2Var) != null) || pz2Var == null) {
                return;
            }
            String d = pz2Var.d();
            gz2 gz2Var = null;
            Iterator<gz2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                gz2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    gz2Var = next;
                    break;
                }
            }
            int i = 1;
            if (pz2Var.e()) {
                if (gz2Var != null) {
                    gz2Var.g++;
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
            } else if (gz2Var != null) {
                gz2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void p(nz2 nz2Var) {
            e82 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, nz2Var) == null) && (f = fz2.f()) != null) {
                String t3 = f.t3();
                cv1 o3 = f.o3();
                if (ez2.b && o3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + t3);
                }
                if (o3 != null && !i(t3)) {
                    gz2 gz2Var = new gz2(t3, f.m3().a, nz2Var.c(), nz2Var.a());
                    this.b.addLast(gz2Var);
                    this.a = gz2Var;
                    o3.t(kz2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(t3)) {
                        this.a.g = this.f.remove(t3).intValue();
                    }
                    if (!this.c && gz2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, gz2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(nz2 nz2Var) {
            e82 f;
            cv1 o3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, nz2Var) != null) || (f = fz2.f()) == null || (o3 = f.o3()) == null) {
                return;
            }
            String t3 = f.t3();
            gz2 gz2Var = new gz2(t3, f.m3().a, nz2Var.c(), nz2Var.a());
            if (!i(t3)) {
                this.b.addLast(gz2Var);
                o3.t(kz2.e());
            }
            this.a = gz2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.get(t3).intValue();
            }
            if (!this.c && gz2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, gz2Var), this.a.b());
                if (ez2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + t3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void s(oz2 oz2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, oz2Var) == null) && oz2Var != null && i(oz2Var.d())) {
                hz2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = oz2Var.e();
                e82 f = fz2.f();
                View B = ju2.U().B(oz2Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = fz2.b(e, f, B);
                    this.d.c(fz2.d(f));
                    this.a.g();
                    boolean a = oz2Var.a();
                    if (!fz2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            hz2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            fz2.i(a, oz2Var.d());
                            int i = 19;
                            if (kf3.d && !a) {
                                i = 55;
                            }
                            iz2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        hz2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (ez2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + oz2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            hz2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (kf3.d && !a) {
                                i3 = 56;
                            }
                            iz2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            w92 w92Var = new w92();
                            if (fz2.g()) {
                                if (i2 >= 0) {
                                    w92Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    w92Var.d(oz2Var.d());
                                    this.a.c = true;
                                    hz2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                w92Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                w92Var.d(oz2Var.d());
                                this.a.c = true;
                                hz2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                l92.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947751564, "Lcom/baidu/tieba/ez2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947751564, "Lcom/baidu/tieba/ez2;");
                return;
            }
        }
        b = w83.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez2() {
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

    @Override // com.baidu.tieba.dz2
    public void a(nz2 nz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nz2Var) == null) {
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
            if (nz2Var != null) {
                Message.obtain(this.a, nz2Var.b(), nz2Var).sendToTarget();
            }
        }
    }
}
