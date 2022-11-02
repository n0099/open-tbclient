package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.bp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            bx3 bx3Var = new bx3();
            bx3Var.b = str;
            bx3Var.e = str2;
            if (e43.M() != null && e43.M().Y() != null) {
                bp2.a Y = e43.M().Y();
                bx3Var.a = xa3.n(Y.G());
                bx3Var.f = Y.H();
                bx3Var.c = Y.T();
                bx3Var.a("play_time", Long.valueOf(j));
            }
            xa3.y("916", "68", bx3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        bp2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (e43.M() != null && e43.M().Y() != null) {
                aVar = e43.M().Y();
                str3 = xa3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                bx3 bx3Var = new bx3();
                bx3Var.b = str;
                bx3Var.e = str2;
                bx3Var.a = str3;
                bx3Var.f = aVar.H();
                bx3Var.c = aVar.T();
                xa3.y("916", "68", bx3Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            bx3 bx3Var = new bx3();
            bx3Var.b = str;
            bx3Var.e = str2;
            if (e43.M() != null && e43.M().Y() != null) {
                bp2.a Y = e43.M().Y();
                bx3Var.a = xa3.n(Y.G());
                bx3Var.f = Y.H();
                bx3Var.c = Y.T();
            }
            bx3Var.k = str3;
            xa3.y("916", "68", bx3Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            bx3 bx3Var = new bx3();
            bx3Var.b = str;
            bx3Var.e = "show";
            if (e43.M() != null && e43.M().Y() != null) {
                bp2.a Y = e43.M().Y();
                bx3Var.a = xa3.n(Y.G());
                bx3Var.f = Y.H();
                bx3Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            bx3Var.a("early", str2);
            xa3.y("916", "68", bx3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b54.c() > 0 && o04.c() && System.currentTimeMillis() - b54.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
