package com.baidu.tieba;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class hw3 {
    public static /* synthetic */ Interceptable $ic;
    public static Method a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947838085, "Lcom/baidu/tieba/hw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947838085, "Lcom/baidu/tieba/hw3;");
                return;
            }
        }
        try {
            a = lf4.i(lf4.b(CountryCodeBean.ANDRIOD_SYSTEMPROP, true), CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class);
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Method method = a;
            if (method != null) {
                try {
                    return (String) method.invoke(null, str);
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
