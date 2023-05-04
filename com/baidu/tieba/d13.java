package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ce2;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d13 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947651651, "Lcom/baidu/tieba/d13;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947651651, "Lcom/baidu/tieba/d13;");
        }
    }

    public static void a(String str, @Nullable xx2 xx2Var) {
        x73 M;
        us2.a Y;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, str, xx2Var) != null) || (M = x73.M()) == null || (Y = M.Y()) == null) {
            return;
        }
        HybridUbcFlow q = c13.q("route", str);
        q.D("appid", Y.H());
        q.D("swan", ch3.i(Y.j0(), Y.G()));
        q.D("net", SwanAppNetworkUtils.f().type);
        q.D("appversion", Y.v1());
        q.D("thirdversion", Y.w1());
        q.D("mobile", nk3.c());
        q.D("scheme", Y.W());
        q.D("launchid", Y.V());
        q.E("from", "swan");
        q.D("web_widget_state", "0");
        q.A();
        if (xx2Var != null) {
            q.E("na_multi_jump_dst_path", xx2Var.a());
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            ky2.j(true);
            c13.s("route", str);
            HybridUbcFlow q = c13.q("route", str);
            q.F(new UbcFlowEvent("na_first_receive_action"));
            q.D("sub_state", "0");
            a = System.currentTimeMillis();
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && TextUtils.equals(c13.q("route", str).h("sub_state"), "1")) {
            c13.q("route", str).F(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void c(int i, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, str) == null) {
            cq2.c(i);
            HybridUbcFlow q = c13.q("route", str);
            if (i != 6 && i != 4 && i != 1) {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE);
            } else {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
            }
            q.E("type", Integer.valueOf(i));
            f72 H = kt2.U().H();
            if (H != null) {
                str2 = H.p3().a();
            } else {
                str2 = "";
            }
            q.E("na_multi_jump_src_path", str2);
        }
    }

    public static void e(ce2.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eVar, str) == null) {
            c13.q("route", str).F(new UbcFlowEvent("na_pre_load_slave_ok"));
            if (eVar == null) {
                return;
            }
            du1 du1Var = eVar.a;
            if (du1Var != null) {
                du1Var.x(str);
            }
            HybridUbcFlow q = c13.q("route", str);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_slave_start");
            ubcFlowEvent.h(eVar.d);
            q.F(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_slave_end");
            ubcFlowEvent2.h(eVar.e);
            q.F(ubcFlowEvent2);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            HybridUbcFlow q = c13.q("route", str);
            q.F(new UbcFlowEvent("web_widget_first_screen_finish"));
            q.D("web_widget_state", "1");
            q.T();
        }
    }
}
