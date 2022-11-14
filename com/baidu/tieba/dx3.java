package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            cx3 cx3Var = new cx3();
            cx3Var.b = str;
            cx3Var.e = str2;
            if (f43.M() != null && f43.M().Y() != null) {
                cp2.a Y = f43.M().Y();
                cx3Var.a = ya3.n(Y.G());
                cx3Var.f = Y.H();
                cx3Var.c = Y.T();
                cx3Var.a("play_time", Long.valueOf(j));
            }
            ya3.y("916", "68", cx3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        cp2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (f43.M() != null && f43.M().Y() != null) {
                aVar = f43.M().Y();
                str3 = ya3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                cx3 cx3Var = new cx3();
                cx3Var.b = str;
                cx3Var.e = str2;
                cx3Var.a = str3;
                cx3Var.f = aVar.H();
                cx3Var.c = aVar.T();
                ya3.y("916", "68", cx3Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            cx3 cx3Var = new cx3();
            cx3Var.b = str;
            cx3Var.e = str2;
            if (f43.M() != null && f43.M().Y() != null) {
                cp2.a Y = f43.M().Y();
                cx3Var.a = ya3.n(Y.G());
                cx3Var.f = Y.H();
                cx3Var.c = Y.T();
            }
            cx3Var.k = str3;
            ya3.y("916", "68", cx3Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            cx3 cx3Var = new cx3();
            cx3Var.b = str;
            cx3Var.e = "show";
            if (f43.M() != null && f43.M().Y() != null) {
                cp2.a Y = f43.M().Y();
                cx3Var.a = ya3.n(Y.G());
                cx3Var.f = Y.H();
                cx3Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            cx3Var.a("early", str2);
            ya3.y("916", "68", cx3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c54.c() > 0 && p04.c() && System.currentTimeMillis() - c54.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
