package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class gt2 implements it2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public cu1 a;
    public h83 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public jt2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    @Override // com.baidu.tieba.it2
    public lp1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (lp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public op1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (op1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public op1 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (op1) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ gt2 b;

        public a(gt2 gt2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gt2Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (swanAppActivity = this.b.d) != null) {
                int taskId = swanAppActivity.getTaskId();
                this.b.d.finish();
                if (this.a) {
                    this.b.d.overridePendingTransition(0, R.anim.obfuscated_res_0x7f010026);
                }
                dk3.m().l(taskId);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt2 a;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(gt2 gt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt2Var;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q().V();
            }
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
        j = ho1.a;
    }

    @Override // com.baidu.tieba.it2
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f72 H = H();
            if (H != null) {
                return H.w3();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    @Nullable
    public x73 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return x73.M();
        }
        return (x73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    @NonNull
    public final ag3 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            x73 b0 = x73.b0();
            if (b0 == null) {
                return new yf3();
            }
            return b0.h0();
        }
        return (ag3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public f72 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            g72 T = T();
            if (T == null) {
                return null;
            }
            return T.o();
        }
        return (f72) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public void I() {
        jt2 jt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (jt2Var = this.e) != null) {
            jt2Var.i();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            f72 H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.q3();
        }
        return (Pair) invokeV.objValue;
    }

    public g72 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.Z();
        }
        return (g72) invokeV.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f);
                }
            }
            cu1 cu1Var = this.a;
            if (cu1Var != null) {
                cu1Var.E();
            }
            w42.e();
        }
    }

    @Override // com.baidu.tieba.it2
    public void a() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (w = w73.K().w()) != null && !w.isFinishing()) {
            w.B0();
        }
    }

    @Override // com.baidu.tieba.it2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            x73 b0 = x73.b0();
            if (b0 != null && b0.Y() != null) {
                return us2.m1(b0.Y(), kt2.U().s());
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.it2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            R(true);
        }
    }

    @Override // com.baidu.tieba.it2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                return "";
            }
            return s.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return w73.K().w();
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public eu1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            fu1 A = A(C());
            if (A == null) {
                return null;
            }
            return A.s();
        }
        return (eu1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public void o() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (w = w73.K().w()) != null && !w.isFinishing()) {
            w.x0();
        }
    }

    @Override // com.baidu.tieba.it2
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.it2
    @DebugTrace
    public cu1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            cu1 b2 = w42.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.F((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f090173));
            }
            return b2;
        }
        return (cu1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            w73 K = w73.K();
            if (K.E()) {
                return K.q().Q();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                return "";
            }
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public gt2() {
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
        this.b = new h83();
        re2.U();
        jt2 jt2Var = new jt2();
        this.e = jt2Var;
        jt2Var.h(this);
    }

    @Override // com.baidu.tieba.it2
    public boolean N() {
        InterceptResult invokeV;
        us2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Q();
            x73 M = x73.M();
            if (M != null) {
                aVar = M.Y();
            } else {
                aVar = null;
            }
            if (aVar != null && ((j && aVar.n0()) || zz1.g(aVar) || zz1.d(aVar))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.it2
    @CallSuper
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            jt2 jt2Var = this.e;
            if (jt2Var != null) {
                jt2Var.j();
                this.e = null;
            }
            b43.b().d();
            U();
            a23.e().g(w73.K().getAppId());
            tg3.u(true);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.it2
    public fu1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return re2.U().e0(str);
        }
        return (fu1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.it2
    public View B(String str) {
        InterceptResult invokeL;
        eu1 s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            fu1 A = A(str);
            if (A == null || (s = A.s()) == null) {
                return null;
            }
            return s.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.it2
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && this.d != null) {
            rl3.e0(new a(this, z));
        }
    }

    @Override // com.baidu.tieba.jt2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            Q();
            dk3.m().x(this.d);
            R(false);
        }
    }

    @Override // com.baidu.tieba.it2
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.baidu.tieba.it2
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, context) != null) || this.e == null) {
            return;
        }
        Q();
        this.e.c(context);
    }

    @Override // com.baidu.tieba.it2
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            re2.U().z0(intent);
        }
    }

    @Override // com.baidu.tieba.it2
    public void unregisterReceiver(Context context) {
        jt2 jt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, context) != null) || (jt2Var = this.e) == null) {
            return;
        }
        jt2Var.f(context);
    }

    @Override // com.baidu.tieba.it2
    @CallSuper
    public void E(us2 us2Var, rq2 rq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, us2Var, rq2Var) == null) {
            Q();
        }
    }

    @Override // com.baidu.tieba.it2
    @CallSuper
    public void d(us2 us2Var, rq2 rq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, us2Var, rq2Var) == null) {
            Q();
        }
    }

    @Override // com.baidu.tieba.it2
    public void m(String str, xh2 xh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, xh2Var) == null) {
            re2.U().V0(str, xh2Var);
        }
    }

    @Override // com.baidu.tieba.it2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f090173)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.it2
    public void u(xh2 xh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, xh2Var) == null) {
            if (!w73.K().q().y0()) {
                re2.U().U0(xh2Var);
                return;
            }
            re2.U().V0(pn3.c().h(), xh2Var);
        }
    }

    @Override // com.baidu.tieba.it2
    @NonNull
    public m83 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (m83) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.it2
    @NonNull
    public m83 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return m83.d();
            }
            return this.b.b(z(), str, s.e);
        }
        return (m83) invokeL.objValue;
    }

    @Override // com.baidu.tieba.it2
    public m83 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return m83.d();
            }
            return this.b.a(z(), str, s.e);
        }
        return (m83) invokeL.objValue;
    }

    @Override // com.baidu.tieba.it2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = g63.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01bd));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08015f);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.it2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Pair<Integer, Integer> S = S();
            int intValue = ((Integer) S.first).intValue();
            int intValue2 = ((Integer) S.second).intValue();
            if (intValue == 0) {
                intValue = ol3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = ol3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    @CallSuper
    public void v() {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Q();
            String g0 = x73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", getActivity().getTaskId());
            n43.e().h(new p43(9, bundle));
            if (x73.b0() == null) {
                O = "";
            } else {
                O = x73.b0().O();
            }
            er2.H().c(O);
        }
    }

    @Override // com.baidu.tieba.it2
    @CallSuper
    public void w() {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String g0 = x73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            I();
            x73 b0 = x73.b0();
            if (b0 != null) {
                b0.B().I(b0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", zl3.b().a());
            n43.e().h(new p43(10, bundle));
            if (x73.b0() == null) {
                O = "";
            } else {
                O = x73.b0().O();
            }
            er2.H().a(O);
            er2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.tieba.it2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = ol3.n(appContext);
            if (w73.K().w() != null && (window = w73.K().w().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
                i = viewGroup.getMeasuredHeight();
            } else {
                i = 0;
            }
            if (i >= n) {
                return new Pair<>(Integer.valueOf(ol3.o(appContext)), Integer.valueOf(i));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += gl3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(ol3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.baidu.tieba.it2
    public void y(ai2 ai2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, ai2Var, z) == null) {
            b13.a("postMessage", "handleNativeMessage start.");
            if (ai2Var == null) {
                return;
            }
            di2 di2Var = new di2();
            di2Var.c = ai2Var.b;
            di2Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + ai2Var.b + " ; needEncode = " + z);
            }
            m(ai2Var.a, di2Var);
            b13.a("postMessage", "handleNativeMessage end.");
        }
    }
}
