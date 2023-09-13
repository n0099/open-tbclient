package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes5.dex */
public class f44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            e44 e44Var = new e44();
            e44Var.b = str;
            e44Var.e = str2;
            if (hb3.M() != null && hb3.M().Y() != null) {
                ew2.a Y = hb3.M().Y();
                e44Var.a = ai3.n(Y.G());
                e44Var.f = Y.H();
                e44Var.c = Y.T();
                e44Var.a("play_time", Long.valueOf(j));
            }
            ai3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, e44Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        ew2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (hb3.M() != null && hb3.M().Y() != null) {
                aVar = hb3.M().Y();
                str3 = ai3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                e44 e44Var = new e44();
                e44Var.b = str;
                e44Var.e = str2;
                e44Var.a = str3;
                e44Var.f = aVar.H();
                e44Var.c = aVar.T();
                ai3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, e44Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            e44 e44Var = new e44();
            e44Var.b = str;
            e44Var.e = str2;
            if (hb3.M() != null && hb3.M().Y() != null) {
                ew2.a Y = hb3.M().Y();
                e44Var.a = ai3.n(Y.G());
                e44Var.f = Y.H();
                e44Var.c = Y.T();
            }
            e44Var.k = str3;
            ai3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, e44Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            e44 e44Var = new e44();
            e44Var.b = str;
            e44Var.e = "show";
            if (hb3.M() != null && hb3.M().Y() != null) {
                ew2.a Y = hb3.M().Y();
                e44Var.a = ai3.n(Y.G());
                e44Var.f = Y.H();
                e44Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            e44Var.a("early", str2);
            ai3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, e44Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (ec4.c() > 0 && r74.c() && System.currentTimeMillis() - ec4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
