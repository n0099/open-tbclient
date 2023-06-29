package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
public class dta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (b()) {
                try {
                    return (String) Class.forName("okhttp3.internal.Version").getMethod(TTDownloadField.TT_USERAGENT, new Class[0]).invoke(null, new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class.forName("okhttp3.OkHttpClient");
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean c() throws RuntimeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String a = a();
            if (!a.isEmpty()) {
                String[] split = a.split("/");
                if (split.length == 2) {
                    String[] split2 = split[1].split("\\.");
                    if (split2.length == 3) {
                        try {
                            if (Integer.parseInt(split2[0]) == 3) {
                                if (Integer.parseInt(split2[1]) >= 9) {
                                    return true;
                                }
                            }
                            return false;
                        } catch (NumberFormatException unused) {
                            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a));
                        }
                    }
                    throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a));
                }
                throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a));
            }
            throw new NoSuchElementException();
        }
        return invokeV.booleanValue;
    }
}
