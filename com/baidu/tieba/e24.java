package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes5.dex */
public class e24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            d24 d24Var = new d24();
            d24Var.b = str;
            d24Var.e = str2;
            if (g93.M() != null && g93.M().Y() != null) {
                du2.a Y = g93.M().Y();
                d24Var.a = zf3.n(Y.G());
                d24Var.f = Y.H();
                d24Var.c = Y.T();
                d24Var.a("play_time", Long.valueOf(j));
            }
            zf3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, d24Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        du2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (g93.M() != null && g93.M().Y() != null) {
                aVar = g93.M().Y();
                str3 = zf3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                d24 d24Var = new d24();
                d24Var.b = str;
                d24Var.e = str2;
                d24Var.a = str3;
                d24Var.f = aVar.H();
                d24Var.c = aVar.T();
                zf3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, d24Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            d24 d24Var = new d24();
            d24Var.b = str;
            d24Var.e = str2;
            if (g93.M() != null && g93.M().Y() != null) {
                du2.a Y = g93.M().Y();
                d24Var.a = zf3.n(Y.G());
                d24Var.f = Y.H();
                d24Var.c = Y.T();
            }
            d24Var.k = str3;
            zf3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, d24Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            d24 d24Var = new d24();
            d24Var.b = str;
            d24Var.e = "show";
            if (g93.M() != null && g93.M().Y() != null) {
                du2.a Y = g93.M().Y();
                d24Var.a = zf3.n(Y.G());
                d24Var.f = Y.H();
                d24Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            d24Var.a("early", str2);
            zf3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, d24Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (da4.c() > 0 && q54.c() && System.currentTimeMillis() - da4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
