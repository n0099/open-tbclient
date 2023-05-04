package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class au3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (!SwanAppInitHelper.entranceOK()) {
                Log.w("SwanAppLaunchHelper", "entrance not open");
                p73.g(AppRuntime.getAppContext(), "not support for this android version").G();
            } else if (TextUtils.isEmpty(str)) {
                p73.g(AppRuntime.getAppContext(), ExceptionMessage.URL_EMPTY).G();
            } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
                b(str);
            } else if (str.startsWith("bdswan")) {
                b(str.replace("bdswan", SchemeConfig.getSchemeHead()));
            } else if (!str.startsWith("https") && !str.startsWith("http")) {
                p73.g(AppRuntime.getAppContext(), "not support this uri").G();
            } else {
                c(str);
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            zt3.e(str);
        }
    }
}
