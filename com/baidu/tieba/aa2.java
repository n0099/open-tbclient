package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.z92;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebSettings;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class aa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947608375, "Lcom/baidu/tieba/aa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947608375, "Lcom/baidu/tieba/aa2;");
                return;
            }
        }
        a = rr1.a;
    }

    @NonNull
    public static WebSettings.CodeCacheSetting a(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            WebSettings.CodeCacheSetting codeCacheSetting = new WebSettings.CodeCacheSetting();
            codeCacheSetting.id = str;
            ArrayList<String> arrayList = new ArrayList<>();
            codeCacheSetting.pathList = arrayList;
            arrayList.add(str2);
            if (str.hashCode() == 93029162 && str.equals("appjs")) {
                c = 0;
            } else {
                c = 65535;
            }
            if (c != 0) {
                codeCacheSetting.maxCount = 20;
                codeCacheSetting.sizeLimit = 102400;
            } else {
                z92.a d = z92.b.d();
                codeCacheSetting.maxCount = d.a;
                codeCacheSetting.sizeLimit = d.b;
                codeCacheSetting.diskCodeCacheSizeThreshold = d.c;
            }
            if (a) {
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting cacheType: " + str);
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
            }
            return codeCacheSetting;
        }
        return (WebSettings.CodeCacheSetting) invokeLL.objValue;
    }
}
