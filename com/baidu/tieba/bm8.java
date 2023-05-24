package com.baidu.tieba;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes5.dex */
public class bm8 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                try {
                    Field declaredField = Class.forName("dalvik.system.VMRuntime").getDeclaredField("ABI_TO_INSTRUCTION_SET_MAP");
                    declaredField.setAccessible(true);
                    a = (Map) declaredField.get(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return a;
        }
        return (Map) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            try {
                ApplicationInfo.class.getField("primaryCpuAbi").set(((PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0])).applicationInfo, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
