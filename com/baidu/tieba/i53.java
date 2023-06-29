package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.hi2;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i53 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947804450, "Lcom/baidu/tieba/i53;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947804450, "Lcom/baidu/tieba/i53;");
        }
    }

    public static void a(String str, @Nullable c23 c23Var) {
        cc3 M;
        zw2.a Y;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, str, c23Var) != null) || (M = cc3.M()) == null || (Y = M.Y()) == null) {
            return;
        }
        HybridUbcFlow q = h53.q("route", str);
        q.D("appid", Y.H());
        q.D("swan", hl3.i(Y.j0(), Y.G()));
        q.D("net", SwanAppNetworkUtils.f().type);
        q.D("appversion", Y.v1());
        q.D("thirdversion", Y.w1());
        q.D("mobile", so3.c());
        q.D("scheme", Y.W());
        q.D("launchid", Y.V());
        q.E("from", "swan");
        q.D("web_widget_state", "0");
        q.A();
        if (c23Var != null) {
            q.E("na_multi_jump_dst_path", c23Var.a());
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            p23.j(true);
            h53.s("route", str);
            HybridUbcFlow q = h53.q("route", str);
            q.F(new UbcFlowEvent("na_first_receive_action"));
            q.D("sub_state", "0");
            a = System.currentTimeMillis();
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && TextUtils.equals(h53.q("route", str).h("sub_state"), "1")) {
            h53.q("route", str).F(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void c(int i, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, str) == null) {
            hu2.c(i);
            HybridUbcFlow q = h53.q("route", str);
            if (i != 6 && i != 4 && i != 1) {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE);
            } else {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
            }
            q.E("type", Integer.valueOf(i));
            kb2 H = px2.T().H();
            if (H != null) {
                str2 = H.o3().a();
            } else {
                str2 = "";
            }
            q.E("na_multi_jump_src_path", str2);
        }
    }

    public static void e(hi2.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eVar, str) == null) {
            h53.q("route", str).F(new UbcFlowEvent("na_pre_load_slave_ok"));
            if (eVar == null) {
                return;
            }
            iy1 iy1Var = eVar.a;
            if (iy1Var != null) {
                iy1Var.u(str);
            }
            HybridUbcFlow q = h53.q("route", str);
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
            HybridUbcFlow q = h53.q("route", str);
            q.F(new UbcFlowEvent("web_widget_first_screen_finish"));
            q.D("web_widget_state", "1");
            q.T();
        }
    }
}
