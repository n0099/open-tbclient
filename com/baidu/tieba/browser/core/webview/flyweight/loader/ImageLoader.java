package com.baidu.tieba.browser.core.webview.flyweight.loader;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.tieba.aj6;
import com.baidu.tieba.ak6;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.kl6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.sj6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ImageLoader {
    public static /* synthetic */ Interceptable $ic;
    public static final aj6 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699590284, "Lcom/baidu/tieba/browser/core/webview/flyweight/loader/ImageLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699590284, "Lcom/baidu/tieba/browser/core/webview/flyweight/loader/ImageLoader;");
                return;
            }
        }
        a = new aj6();
    }

    public static WebResourceResponse a(String str, Map<String, String> map, Pair<InputStream, Long> pair) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, map, pair)) == null) {
            String b = kl6.b(str);
            HashMap<String, String> hashMap = new HashMap<String, String>() { // from class: com.baidu.tieba.browser.core.webview.flyweight.loader.ImageLoader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    put("access-control-allow-origin", "*");
                    put(Headers.CACHE_CONTROL, "no-cache");
                }
            };
            if (map != null && !TextUtils.isEmpty(map.get("Range"))) {
                i = 206;
                hashMap.put(Util.ACCEPT_RANGES, "bytes");
                hashMap.put("Content-Length", pair.second + "");
                hashMap.put("Content-Range", "bytes 0-" + (pair.second.longValue() - 1) + "/" + pair.second);
            } else {
                i = 200;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(b, "UTF-8", pair.first);
            webResourceResponse.setStatusCodeAndReasonPhrase(i, "OK");
            webResourceResponse.setResponseHeaders(hashMap);
            return webResourceResponse;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            ak6 f = sj6.e().f(str);
            if (f == null) {
                f = sj6.e().f(kl6.c(str2));
            }
            if (f == null) {
                return null;
            }
            String c = kl6.c(str2);
            String str3 = "";
            for (String str4 : f.f) {
                if (c.endsWith(str4)) {
                    str3 = f.e + str4;
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public static WebResourceResponse c(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        Pair<InputStream, Long> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, map)) == null) {
            try {
                String b = b(str, str2);
                if (!TextUtils.isEmpty(b) && (a2 = a.a(b)) != null && a2.first != null) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.i("Offline", "返回离线包图片数据:" + b + " originUrl：" + str + " url：" + str2);
                    return a(str2, map, a2);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            return null;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }
}
