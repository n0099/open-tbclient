package com.baidu.tieba;

import android.text.TextUtils;
import c.a.d.f.p.j;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class StringU {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(876253765, "Lcom/baidu/tieba/StringU;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(876253765, "Lcom/baidu/tieba/StringU;");
                return;
            }
        }
        try {
            boolean h2 = j.d().h("stringu", 2);
            a = h2;
            if (h2) {
                a("stringu_so_load_success", null);
            } else {
                a("stringu_so_load_retry_fail", "retry to load so failed at 2 times");
            }
        } catch (Exception e2) {
            a("stringu_so_load_fail", e2.getMessage());
        }
    }

    public StringU() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            if (TextUtils.isEmpty(str2)) {
                BdStatisticsManager.getInstance().eventStat(null, str, null, 1, new Object[0]);
            } else {
                BdStatisticsManager.getInstance().eventStat(null, str, null, 1, PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!a || TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                try {
                    str2 = toUpper(str);
                } catch (Exception e2) {
                    e = e2;
                    str2 = "";
                }
                try {
                    if (TextUtils.isEmpty(str2)) {
                        a("stringu_m_result_null", null);
                    }
                } catch (Exception e3) {
                    e = e3;
                    a("stringu_m_call_fail", e.getMessage());
                    if (str2 != null) {
                    }
                }
            }
            return str2 != null ? "" : str2;
        }
        return (String) invokeL.objValue;
    }

    public static native String toUpper(String str);
}
