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
import com.baidu.tieba.py2;
import com.baidu.tieba.ss2;
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
public class dy2 extends HandlerThread implements cy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fy2 a;
        public Deque<fy2> b;
        public boolean c;
        public py2 d;
        public int e;
        public HashMap<String, Integer> f;
        public qy2 g;
        public final /* synthetic */ dy2 h;

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.dy2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0245a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.dy2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class RunnableC0246a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0246a(RunnableC0245a runnableC0245a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0245a, swanAppActivity};
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
                            if (dy2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0245a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        pl3.a0(new RunnableC0246a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            hy2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            w72.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            w72.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && ey2.g()) {
                            w72.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = it2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    pk3.f().execute(new RunnableC0245a(this, ml3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.dy2$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0244a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fy2 a;
            public final /* synthetic */ a b;

            public RunnableC0244a(a aVar, fy2 fy2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fy2Var};
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
                this.a = fy2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = ml3.p();
                    if (p != null) {
                        fy2 fy2Var = this.a;
                        Message.obtain(this.b, 8, new ny2(fy2Var.a, p, fy2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dy2 dy2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy2Var, looper};
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
            this.h = dy2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = py2.a.a("simple_parser");
            this.g = (qy2) py2.a.a("hsv_parser");
        }

        public final void g(fy2 fy2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fy2Var) == null) && fy2Var != null && i(fy2Var.a)) {
                pl3.e0(new RunnableC0244a(this, fy2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                fy2 fy2Var = this.a;
                if (fy2Var != null && str != null && TextUtils.equals(str, fy2Var.a)) {
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
                fy2 fy2Var = this.a;
                if (fy2Var != null && fy2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (dy2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                pl3.a0(new b(this));
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
                if (dy2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (je3.d) {
                            q((my2) message.obj);
                            return;
                        } else {
                            p((my2) message.obj);
                            return;
                        }
                    case 2:
                        g((fy2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((ly2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        ky2 ky2Var = (ky2) message.obj;
                        if (ky2Var != null) {
                            if (ky2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((oy2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((ny2) message.obj);
                        return;
                    case 9:
                        o((my2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((my2) message.obj);
                        return;
                    case 13:
                        q((my2) message.obj);
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
                fy2 fy2Var = this.a;
                if (fy2Var != null && !fy2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (dy2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = jg3.a().getString("screenshot_upload_switch", "1");
                if (dy2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(my2 my2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, my2Var) == null) {
                this.h.a.removeMessages(2);
                fy2 fy2Var = this.a;
                if (fy2Var != null) {
                    str = fy2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (dy2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + my2Var.a());
                }
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                gy2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                it2.U().u(wd3.a(new wd3()));
                it2.U().m(str, wd3.a(new wd3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                fy2 fy2Var = this.a;
                if (fy2Var != null && fy2Var.c() && this.a.c && h()) {
                    gy2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    gy2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    x72.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                fy2 fy2Var = this.a;
                if (fy2Var != null && fy2Var.i && !fy2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (dy2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            ss2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = it2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                xm3 V = activity.V();
                if (V != null && (view2 = V.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (dy2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                oj3 oj3Var = new oj3();
                oj3Var.k(5L);
                oj3Var.i(19L);
                oj3Var.f("loading=true");
                v73 b0 = v73.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                we3 we3Var = new we3();
                we3Var.p(oj3Var);
                we3Var.r(W);
                we3Var.q(oe3.n(u73.K().k()));
                we3Var.m(u73.K().getAppId());
                we3Var.s(String.valueOf(this.b.size()));
                we3Var.n(false);
                oe3.R(we3Var);
            }
        }

        public final void o(@NonNull my2 my2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, my2Var) == null) && my2Var.c() >= 0) {
                e72 V = it2.U().V();
                if (V != null && V.k() > 0) {
                    return;
                }
                if (dy2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + my2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, my2Var), my2Var.c());
            }
        }

        public final void r(oy2 oy2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, oy2Var) != null) || oy2Var == null) {
                return;
            }
            String d = oy2Var.d();
            fy2 fy2Var = null;
            Iterator<fy2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                fy2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    fy2Var = next;
                    break;
                }
            }
            int i = 1;
            if (oy2Var.e()) {
                if (fy2Var != null) {
                    fy2Var.g++;
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
            } else if (fy2Var != null) {
                fy2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void p(my2 my2Var) {
            d72 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, my2Var) == null) && (f = ey2.f()) != null) {
                String w3 = f.w3();
                bu1 r3 = f.r3();
                if (dy2.b && r3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + w3);
                }
                if (r3 != null && !i(w3)) {
                    fy2 fy2Var = new fy2(w3, f.p3().a, my2Var.c(), my2Var.a());
                    this.b.addLast(fy2Var);
                    this.a = fy2Var;
                    r3.t(jy2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(w3)) {
                        this.a.g = this.f.remove(w3).intValue();
                    }
                    if (!this.c && fy2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, fy2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(my2 my2Var) {
            d72 f;
            bu1 r3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, my2Var) != null) || (f = ey2.f()) == null || (r3 = f.r3()) == null) {
                return;
            }
            String w3 = f.w3();
            fy2 fy2Var = new fy2(w3, f.p3().a, my2Var.c(), my2Var.a());
            if (!i(w3)) {
                this.b.addLast(fy2Var);
                r3.t(jy2.e());
            }
            this.a = fy2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(w3)) {
                this.a.g = this.f.get(w3).intValue();
            }
            if (!this.c && fy2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, fy2Var), this.a.b());
                if (dy2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + w3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void s(ny2 ny2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, ny2Var) == null) && ny2Var != null && i(ny2Var.d())) {
                gy2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = ny2Var.e();
                d72 f = ey2.f();
                View B = it2.U().B(ny2Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = ey2.b(e, f, B);
                    this.d.c(ey2.d(f));
                    this.a.g();
                    boolean a = ny2Var.a();
                    if (!ey2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            gy2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            ey2.i(a, ny2Var.d());
                            int i = 19;
                            if (je3.d && !a) {
                                i = 55;
                            }
                            hy2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        gy2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (dy2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + ny2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            gy2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (je3.d && !a) {
                                i3 = 56;
                            }
                            hy2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            v82 v82Var = new v82();
                            if (ey2.g()) {
                                if (i2 >= 0) {
                                    v82Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    v82Var.d(ny2Var.d());
                                    this.a.c = true;
                                    gy2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                v82Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                v82Var.d(ny2Var.d());
                                this.a.c = true;
                                gy2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                k82.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947720812, "Lcom/baidu/tieba/dy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947720812, "Lcom/baidu/tieba/dy2;");
                return;
            }
        }
        b = v73.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dy2() {
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

    @Override // com.baidu.tieba.cy2
    public void a(my2 my2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, my2Var) == null) {
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
            if (my2Var != null) {
                Message.obtain(this.a, my2Var.b(), my2Var).sendToTarget();
            }
        }
    }
}
