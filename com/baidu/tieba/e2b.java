package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes5.dex */
public class e2b {
    public static /* synthetic */ Interceptable $ic;
    public static final SharedPreferences a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947683860, "Lcom/baidu/tieba/e2b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947683860, "Lcom/baidu/tieba/e2b;");
                return;
            }
        }
        a = FunAdSdk.getAppContext().getSharedPreferences("fun_ad_sdk_req_id", 0);
    }
}
