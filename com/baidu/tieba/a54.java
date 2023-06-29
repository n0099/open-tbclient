package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes4.dex */
public class a54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            z44 z44Var = new z44();
            z44Var.b = str;
            z44Var.e = str2;
            if (cc3.M() != null && cc3.M().Y() != null) {
                zw2.a Y = cc3.M().Y();
                z44Var.a = vi3.n(Y.G());
                z44Var.f = Y.H();
                z44Var.c = Y.T();
                z44Var.a("play_time", Long.valueOf(j));
            }
            vi3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, z44Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        zw2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (cc3.M() != null && cc3.M().Y() != null) {
                aVar = cc3.M().Y();
                str3 = vi3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                z44 z44Var = new z44();
                z44Var.b = str;
                z44Var.e = str2;
                z44Var.a = str3;
                z44Var.f = aVar.H();
                z44Var.c = aVar.T();
                vi3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, z44Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            z44 z44Var = new z44();
            z44Var.b = str;
            z44Var.e = str2;
            if (cc3.M() != null && cc3.M().Y() != null) {
                zw2.a Y = cc3.M().Y();
                z44Var.a = vi3.n(Y.G());
                z44Var.f = Y.H();
                z44Var.c = Y.T();
            }
            z44Var.k = str3;
            vi3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, z44Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            z44 z44Var = new z44();
            z44Var.b = str;
            z44Var.e = "show";
            if (cc3.M() != null && cc3.M().Y() != null) {
                zw2.a Y = cc3.M().Y();
                z44Var.a = vi3.n(Y.G());
                z44Var.f = Y.H();
                z44Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            z44Var.a("early", str2);
            vi3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, z44Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (zc4.c() > 0 && m84.c() && System.currentTimeMillis() - zc4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
