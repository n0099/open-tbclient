package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes5.dex */
public class ez3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            dz3 dz3Var = new dz3();
            dz3Var.b = str;
            dz3Var.e = str2;
            if (g63.M() != null && g63.M().Z() != null) {
                dr2.a Z = g63.M().Z();
                dz3Var.a = zc3.n(Z.H());
                dz3Var.f = Z.I();
                dz3Var.c = Z.U();
                dz3Var.a("play_time", Long.valueOf(j));
            }
            zc3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, dz3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        dr2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (g63.M() != null && g63.M().Z() != null) {
                aVar = g63.M().Z();
                str3 = zc3.n(aVar.H());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                dz3 dz3Var = new dz3();
                dz3Var.b = str;
                dz3Var.e = str2;
                dz3Var.a = str3;
                dz3Var.f = aVar.I();
                dz3Var.c = aVar.U();
                zc3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, dz3Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            dz3 dz3Var = new dz3();
            dz3Var.b = str;
            dz3Var.e = str2;
            if (g63.M() != null && g63.M().Z() != null) {
                dr2.a Z = g63.M().Z();
                dz3Var.a = zc3.n(Z.H());
                dz3Var.f = Z.I();
                dz3Var.c = Z.U();
            }
            dz3Var.k = str3;
            zc3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, dz3Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            dz3 dz3Var = new dz3();
            dz3Var.b = str;
            dz3Var.e = "show";
            if (g63.M() != null && g63.M().Z() != null) {
                dr2.a Z = g63.M().Z();
                dz3Var.a = zc3.n(Z.H());
                dz3Var.f = Z.I();
                dz3Var.c = Z.U();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            dz3Var.a("early", str2);
            zc3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, dz3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d74.c() > 0 && q24.c() && System.currentTimeMillis() - d74.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
