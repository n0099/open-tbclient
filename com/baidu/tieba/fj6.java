package com.baidu.tieba;

import android.app.Activity;
import android.webkit.URLUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Activity activity, String str, boolean z, boolean z2) {
        qk6 qk6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{activity, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if ((URLUtil.isNetworkUrl(str) || URLUtil.isFileUrl(str) || URLUtil.isAssetUrl(str)) && (qk6Var = (qk6) ServiceManager.getService(qk6.a)) != null) {
                qk6Var.a(activity, str, z, z2);
            }
        }
    }
}
