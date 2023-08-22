package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.aw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes5.dex */
public class b44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            a44 a44Var = new a44();
            a44Var.b = str;
            a44Var.e = str2;
            if (db3.M() != null && db3.M().Y() != null) {
                aw2.a Y = db3.M().Y();
                a44Var.a = wh3.n(Y.G());
                a44Var.f = Y.H();
                a44Var.c = Y.T();
                a44Var.a("play_time", Long.valueOf(j));
            }
            wh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, a44Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        aw2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (db3.M() != null && db3.M().Y() != null) {
                aVar = db3.M().Y();
                str3 = wh3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                a44 a44Var = new a44();
                a44Var.b = str;
                a44Var.e = str2;
                a44Var.a = str3;
                a44Var.f = aVar.H();
                a44Var.c = aVar.T();
                wh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, a44Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            a44 a44Var = new a44();
            a44Var.b = str;
            a44Var.e = str2;
            if (db3.M() != null && db3.M().Y() != null) {
                aw2.a Y = db3.M().Y();
                a44Var.a = wh3.n(Y.G());
                a44Var.f = Y.H();
                a44Var.c = Y.T();
            }
            a44Var.k = str3;
            wh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, a44Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a44 a44Var = new a44();
            a44Var.b = str;
            a44Var.e = "show";
            if (db3.M() != null && db3.M().Y() != null) {
                aw2.a Y = db3.M().Y();
                a44Var.a = wh3.n(Y.G());
                a44Var.f = Y.H();
                a44Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            a44Var.a("early", str2);
            wh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, a44Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (ac4.c() > 0 && n74.c() && System.currentTimeMillis() - ac4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
