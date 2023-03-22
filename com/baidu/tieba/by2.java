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
import com.baidu.tieba.ny2;
import com.baidu.tieba.qs2;
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
/* loaded from: classes3.dex */
public class by2 extends HandlerThread implements ay2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public dy2 a;
        public Deque<dy2> b;
        public boolean c;
        public ny2 d;
        public int e;
        public HashMap<String, Integer> f;
        public oy2 g;
        public final /* synthetic */ by2 h;

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.by2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0231a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.by2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes3.dex */
                public class RunnableC0232a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0232a(RunnableC0231a runnableC0231a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0231a, swanAppActivity};
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
                            if (by2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0231a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        nl3.a0(new RunnableC0232a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            fy2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            u72.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            u72.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && cy2.g()) {
                            u72.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = gt2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    nk3.f().execute(new RunnableC0231a(this, kl3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.by2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0230a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dy2 a;
            public final /* synthetic */ a b;

            public RunnableC0230a(a aVar, dy2 dy2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dy2Var};
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
                this.a = dy2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = kl3.p();
                    if (p != null) {
                        dy2 dy2Var = this.a;
                        Message.obtain(this.b, 8, new ly2(dy2Var.a, p, dy2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(by2 by2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {by2Var, looper};
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
            this.h = by2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = ny2.a.a("simple_parser");
            this.g = (oy2) ny2.a.a("hsv_parser");
        }

        public final void g(dy2 dy2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dy2Var) == null) && dy2Var != null && i(dy2Var.a)) {
                nl3.e0(new RunnableC0230a(this, dy2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                dy2 dy2Var = this.a;
                if (dy2Var != null && str != null && TextUtils.equals(str, dy2Var.a)) {
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
                dy2 dy2Var = this.a;
                if (dy2Var != null && dy2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (by2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                nl3.a0(new b(this));
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
                if (by2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (he3.d) {
                            q((ky2) message.obj);
                            return;
                        } else {
                            p((ky2) message.obj);
                            return;
                        }
                    case 2:
                        g((dy2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((jy2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        iy2 iy2Var = (iy2) message.obj;
                        if (iy2Var != null) {
                            if (iy2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((my2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((ly2) message.obj);
                        return;
                    case 9:
                        o((ky2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((ky2) message.obj);
                        return;
                    case 13:
                        q((ky2) message.obj);
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
                dy2 dy2Var = this.a;
                if (dy2Var != null && !dy2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (by2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = hg3.a().getString("screenshot_upload_switch", "1");
                if (by2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(ky2 ky2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ky2Var) == null) {
                this.h.a.removeMessages(2);
                dy2 dy2Var = this.a;
                if (dy2Var != null) {
                    str = dy2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (by2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + ky2Var.a());
                }
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                ey2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                gt2.U().u(ud3.a(new ud3()));
                gt2.U().m(str, ud3.a(new ud3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                dy2 dy2Var = this.a;
                if (dy2Var != null && dy2Var.c() && this.a.c && h()) {
                    ey2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    ey2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    v72.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                dy2 dy2Var = this.a;
                if (dy2Var != null && dy2Var.i && !dy2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (by2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            qs2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = gt2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                vm3 V = activity.V();
                if (V != null && (view2 = V.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (by2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                mj3 mj3Var = new mj3();
                mj3Var.k(5L);
                mj3Var.i(19L);
                mj3Var.f("loading=true");
                t73 b0 = t73.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                ue3 ue3Var = new ue3();
                ue3Var.p(mj3Var);
                ue3Var.r(W);
                ue3Var.q(me3.n(s73.K().k()));
                ue3Var.m(s73.K().getAppId());
                ue3Var.s(String.valueOf(this.b.size()));
                ue3Var.n(false);
                me3.R(ue3Var);
            }
        }

        public final void o(@NonNull ky2 ky2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, ky2Var) == null) && ky2Var.c() >= 0) {
                c72 V = gt2.U().V();
                if (V != null && V.k() > 0) {
                    return;
                }
                if (by2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + ky2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, ky2Var), ky2Var.c());
            }
        }

        public final void r(my2 my2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, my2Var) != null) || my2Var == null) {
                return;
            }
            String d = my2Var.d();
            dy2 dy2Var = null;
            Iterator<dy2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                dy2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    dy2Var = next;
                    break;
                }
            }
            int i = 1;
            if (my2Var.e()) {
                if (dy2Var != null) {
                    dy2Var.g++;
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
            } else if (dy2Var != null) {
                dy2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void p(ky2 ky2Var) {
            b72 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, ky2Var) == null) && (f = cy2.f()) != null) {
                String w3 = f.w3();
                zt1 r3 = f.r3();
                if (by2.b && r3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + w3);
                }
                if (r3 != null && !i(w3)) {
                    dy2 dy2Var = new dy2(w3, f.p3().a, ky2Var.c(), ky2Var.a());
                    this.b.addLast(dy2Var);
                    this.a = dy2Var;
                    r3.t(hy2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(w3)) {
                        this.a.g = this.f.remove(w3).intValue();
                    }
                    if (!this.c && dy2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, dy2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(ky2 ky2Var) {
            b72 f;
            zt1 r3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, ky2Var) != null) || (f = cy2.f()) == null || (r3 = f.r3()) == null) {
                return;
            }
            String w3 = f.w3();
            dy2 dy2Var = new dy2(w3, f.p3().a, ky2Var.c(), ky2Var.a());
            if (!i(w3)) {
                this.b.addLast(dy2Var);
                r3.t(hy2.e());
            }
            this.a = dy2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(w3)) {
                this.a.g = this.f.get(w3).intValue();
            }
            if (!this.c && dy2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, dy2Var), this.a.b());
                if (by2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + w3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void s(ly2 ly2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, ly2Var) == null) && ly2Var != null && i(ly2Var.d())) {
                ey2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = ly2Var.e();
                b72 f = cy2.f();
                View B = gt2.U().B(ly2Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = cy2.b(e, f, B);
                    this.d.c(cy2.d(f));
                    this.a.g();
                    boolean a = ly2Var.a();
                    if (!cy2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            ey2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            cy2.i(a, ly2Var.d());
                            int i = 19;
                            if (he3.d && !a) {
                                i = 55;
                            }
                            fy2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        ey2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (by2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + ly2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            ey2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (he3.d && !a) {
                                i3 = 56;
                            }
                            fy2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            t82 t82Var = new t82();
                            if (cy2.g()) {
                                if (i2 >= 0) {
                                    t82Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    t82Var.d(ly2Var.d());
                                    this.a.c = true;
                                    ey2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                t82Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                t82Var.d(ly2Var.d());
                                this.a.c = true;
                                ey2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                i82.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947661230, "Lcom/baidu/tieba/by2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947661230, "Lcom/baidu/tieba/by2;");
                return;
            }
        }
        b = t73.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by2() {
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

    @Override // com.baidu.tieba.ay2
    public void a(ky2 ky2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ky2Var) == null) {
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
            if (ky2Var != null) {
                Message.obtain(this.a, ky2Var.b(), ky2Var).sendToTarget();
            }
        }
    }
}
