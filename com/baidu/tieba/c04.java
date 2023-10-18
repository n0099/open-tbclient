package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int b(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z && z2) {
                return 3;
            }
            if (z) {
                return 1;
            }
            return z2 ? 2 : 0;
        }
        return invokeCommon.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947620930, "Lcom/baidu/tieba/c04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947620930, "Lcom/baidu/tieba/c04;");
                return;
            }
        }
        a = am1.a;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting a(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
            codeCacheSetting.id = str;
            ArrayList<String> arrayList = new ArrayList<>();
            codeCacheSetting.pathList = arrayList;
            arrayList.add(str2);
            if (str.hashCode() == -1253235525 && str.equals("gamejs")) {
                c = 0;
            } else {
                c = 65535;
            }
            if (c != 0) {
                codeCacheSetting.maxCount = 20;
                codeCacheSetting.sizeLimit = 102400;
            } else {
                a04 a2 = b04.a();
                codeCacheSetting.maxCount = a2.a;
                codeCacheSetting.sizeLimit = a2.b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.c;
            }
            if (a) {
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting cacheType: " + str);
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting cachePath: " + str2);
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting diskCodeCacheSizeThreshold: " + codeCacheSetting.diskCodeCacheSizeThreshold);
            }
            return codeCacheSetting;
        }
        return (V8EngineConfiguration.CodeCacheSetting) invokeLL.objValue;
    }
}
