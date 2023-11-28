package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.er2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes6.dex */
public class fz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            ez3 ez3Var = new ez3();
            ez3Var.b = str;
            ez3Var.e = str2;
            if (h63.M() != null && h63.M().Z() != null) {
                er2.a Z = h63.M().Z();
                ez3Var.a = ad3.n(Z.H());
                ez3Var.f = Z.I();
                ez3Var.c = Z.U();
                ez3Var.a("play_time", Long.valueOf(j));
            }
            ad3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, ez3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        er2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (h63.M() != null && h63.M().Z() != null) {
                aVar = h63.M().Z();
                str3 = ad3.n(aVar.H());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                ez3 ez3Var = new ez3();
                ez3Var.b = str;
                ez3Var.e = str2;
                ez3Var.a = str3;
                ez3Var.f = aVar.I();
                ez3Var.c = aVar.U();
                ad3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, ez3Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            ez3 ez3Var = new ez3();
            ez3Var.b = str;
            ez3Var.e = str2;
            if (h63.M() != null && h63.M().Z() != null) {
                er2.a Z = h63.M().Z();
                ez3Var.a = ad3.n(Z.H());
                ez3Var.f = Z.I();
                ez3Var.c = Z.U();
            }
            ez3Var.k = str3;
            ad3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, ez3Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            ez3 ez3Var = new ez3();
            ez3Var.b = str;
            ez3Var.e = "show";
            if (h63.M() != null && h63.M().Z() != null) {
                er2.a Z = h63.M().Z();
                ez3Var.a = ad3.n(Z.H());
                ez3Var.f = Z.I();
                ez3Var.c = Z.U();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            ez3Var.a("early", str2);
            ad3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, ez3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e74.c() > 0 && r24.c() && System.currentTimeMillis() - e74.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
