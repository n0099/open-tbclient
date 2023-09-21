package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.dw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes5.dex */
public class e44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            d44 d44Var = new d44();
            d44Var.b = str;
            d44Var.e = str2;
            if (gb3.M() != null && gb3.M().Y() != null) {
                dw2.a Y = gb3.M().Y();
                d44Var.a = zh3.n(Y.G());
                d44Var.f = Y.H();
                d44Var.c = Y.T();
                d44Var.a("play_time", Long.valueOf(j));
            }
            zh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, d44Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        dw2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (gb3.M() != null && gb3.M().Y() != null) {
                aVar = gb3.M().Y();
                str3 = zh3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                d44 d44Var = new d44();
                d44Var.b = str;
                d44Var.e = str2;
                d44Var.a = str3;
                d44Var.f = aVar.H();
                d44Var.c = aVar.T();
                zh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, d44Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            d44 d44Var = new d44();
            d44Var.b = str;
            d44Var.e = str2;
            if (gb3.M() != null && gb3.M().Y() != null) {
                dw2.a Y = gb3.M().Y();
                d44Var.a = zh3.n(Y.G());
                d44Var.f = Y.H();
                d44Var.c = Y.T();
            }
            d44Var.k = str3;
            zh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, d44Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            d44 d44Var = new d44();
            d44Var.b = str;
            d44Var.e = "show";
            if (gb3.M() != null && gb3.M().Y() != null) {
                dw2.a Y = gb3.M().Y();
                d44Var.a = zh3.n(Y.G());
                d44Var.f = Y.H();
                d44Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            d44Var.a("early", str2);
            zh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, d44Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (dc4.c() > 0 && q74.c() && System.currentTimeMillis() - dc4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
