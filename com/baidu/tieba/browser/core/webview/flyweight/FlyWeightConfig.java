package com.baidu.tieba.browser.core.webview.flyweight;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.jf6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class FlyWeightConfig {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public static final Set<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-183945277, "Lcom/baidu/tieba/browser/core/webview/flyweight/FlyWeightConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-183945277, "Lcom/baidu/tieba/browser/core/webview/flyweight/FlyWeightConfig;");
                return;
            }
        }
        a = new HashSet<String>() { // from class: com.baidu.tieba.browser.core.webview.flyweight.FlyWeightConfig.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("html");
                add("htm");
                add("css");
                add("js");
                add("eot");
                add("otf");
                add("ttf");
                add("woff");
                add("woff2");
            }
        };
        b = new HashSet<String>() { // from class: com.baidu.tieba.browser.core.webview.flyweight.FlyWeightConfig.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("jpg");
                add("jpeg");
                add("webp");
                add("png");
                add("ico");
                add(NativeConstants.TYPE_GIF);
                add("mp4");
            }
        };
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String a2 = jf6.a(str);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            if (b.contains(a2)) {
                return true;
            }
            return b.contains(a2.toLowerCase().trim());
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (a.contains(str)) {
                return true;
            }
            return a.contains(str.toLowerCase().trim());
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            String a2 = jf6.a(str);
            if (TextUtils.isEmpty(a2) && !TextUtils.isEmpty(map.get("Accept")) && map.get("Accept").contains(SapiWebView.DATA_MIME_TYPE)) {
                a2 = "html";
            }
            return b(a2);
        }
        return invokeLL.booleanValue;
    }
}
