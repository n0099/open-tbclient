package com.baidu.tieba;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class f61 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715976, "Lcom/baidu/tieba/f61;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715976, "Lcom/baidu/tieba/f61;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("__AD_EXTRA_PARAM_ENCODE_0__", 0);
        a.put("__AD_EXTRA_PARAM_ENCODE_1__", 1);
        a.put("__AD_EXTRA_PARAM_ENCODE_2__", 2);
        a.put("__AD_EXTRA_PARAM_ENCODE_3__", 3);
    }

    public static String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (i <= 0) {
                return str;
            }
            for (int i2 = 0; i2 < i; i2++) {
                str = Uri.encode(str);
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public static String i(@NonNull AdBaseModel adBaseModel, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, adBaseModel, str)) == null) {
            if (!o(str)) {
                return str;
            }
            String d = d(adBaseModel);
            if (!TextUtils.isEmpty(d)) {
                return n(str, d);
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String b(@NonNull AdBaseModel adBaseModel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, adBaseModel, str)) == null) {
            fr0 fr0Var = adBaseModel.l;
            if (fr0Var != null && fr0Var.e) {
                String str2 = fr0Var.a;
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                boolean f = f(str2);
                String str3 = fr0Var.b;
                if (f) {
                    if (TextUtils.isEmpty(str3)) {
                        return str;
                    }
                } else {
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                return str;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String c(String str, Long l, @Nullable List<MonitorUrl> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, l, list)) == null) {
            String a2 = m71.a(m71.a(str, "auto_pop", "1"), "charge_delay_time", String.valueOf(l));
            if (list != null) {
                for (MonitorUrl monitorUrl : list) {
                    if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.clickUrl)) {
                        a2 = m71.a(a2, "charge_url", monitorUrl.clickUrl);
                    }
                }
            }
            return a2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e(String str, Long l, @Nullable List<MonitorUrl> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, l, list)) == null) {
            String a2 = m71.a(m71.a(str, "auto_pop", "0"), "charge_delay_time", String.valueOf(l));
            if (list != null) {
                for (MonitorUrl monitorUrl : list) {
                    if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.clickUrl)) {
                        a2 = m71.a(a2, "charge_url", monitorUrl.clickUrl);
                    }
                }
            }
            return a2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adBaseModel)) == null) {
            if (adBaseModel != null && (str = adBaseModel.f.d) != null) {
                return str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                tj0.b().getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void g(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, adBaseModel) == null) {
            j(adBaseModel);
            l(adBaseModel);
        }
    }

    public static void h(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, adBaseModel) == null) && adBaseModel.d && !TextUtils.isEmpty(adBaseModel.h.d)) {
            AdOperator adOperator = adBaseModel.h;
            adOperator.d = i(adBaseModel, adOperator.d);
        }
    }

    public static void j(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, adBaseModel) == null) {
            k(adBaseModel);
            h(adBaseModel);
            m(adBaseModel);
        }
    }

    public static void k(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, adBaseModel) != null) || TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        nr0 nr0Var = adBaseModel.f;
        nr0Var.c = i(adBaseModel, nr0Var.c);
    }

    public static void m(AdBaseModel adBaseModel) {
        fr0 fr0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, adBaseModel) == null) && (fr0Var = adBaseModel.l) != null && (str = fr0Var.b) != null) {
            fr0Var.b = i(adBaseModel, str);
        }
    }

    public static void l(@NonNull AdBaseModel adBaseModel) {
        fr0 fr0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, adBaseModel) == null) && (fr0Var = adBaseModel.l) != null && fr0Var.e) {
            String str2 = fr0Var.b;
            if (str2.contains("__AUTO_INVOKE__")) {
                if (f(adBaseModel.l.a)) {
                    str = "0";
                } else {
                    str = "1";
                }
                adBaseModel.l.b = str2.replace("__AUTO_INVOKE__", str);
            }
        }
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (Map.Entry<String, Integer> entry : a.entrySet()) {
                if (str.contains(entry.getKey())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                for (Map.Entry<String, Integer> entry : a.entrySet()) {
                    if (str.contains(entry.getKey())) {
                        try {
                            str = str.replaceAll(entry.getKey(), a(str2, entry.getValue().intValue()));
                        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                        }
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }
}
