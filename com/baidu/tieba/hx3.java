package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.gp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            gx3 gx3Var = new gx3();
            gx3Var.b = str;
            gx3Var.e = str2;
            if (j43.M() != null && j43.M().Y() != null) {
                gp2.a Y = j43.M().Y();
                gx3Var.a = cb3.n(Y.G());
                gx3Var.f = Y.H();
                gx3Var.c = Y.T();
                gx3Var.a("play_time", Long.valueOf(j));
            }
            cb3.y("916", "68", gx3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        gp2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (j43.M() != null && j43.M().Y() != null) {
                aVar = j43.M().Y();
                str3 = cb3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                gx3 gx3Var = new gx3();
                gx3Var.b = str;
                gx3Var.e = str2;
                gx3Var.a = str3;
                gx3Var.f = aVar.H();
                gx3Var.c = aVar.T();
                cb3.y("916", "68", gx3Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            gx3 gx3Var = new gx3();
            gx3Var.b = str;
            gx3Var.e = str2;
            if (j43.M() != null && j43.M().Y() != null) {
                gp2.a Y = j43.M().Y();
                gx3Var.a = cb3.n(Y.G());
                gx3Var.f = Y.H();
                gx3Var.c = Y.T();
            }
            gx3Var.k = str3;
            cb3.y("916", "68", gx3Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            gx3 gx3Var = new gx3();
            gx3Var.b = str;
            gx3Var.e = "show";
            if (j43.M() != null && j43.M().Y() != null) {
                gp2.a Y = j43.M().Y();
                gx3Var.a = cb3.n(Y.G());
                gx3Var.f = Y.H();
                gx3Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            gx3Var.a("early", str2);
            cb3.y("916", "68", gx3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (g54.c() > 0 && t04.c() && System.currentTimeMillis() - g54.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
