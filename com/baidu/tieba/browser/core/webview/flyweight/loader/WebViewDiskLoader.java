package com.baidu.tieba.browser.core.webview.flyweight.loader;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aj6;
import com.baidu.tieba.ak6;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.jj6;
import com.baidu.tieba.kl6;
import com.baidu.tieba.sj6;
import com.baidu.tieba.zi6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class WebViewDiskLoader extends jj6<WebResourceResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zi6<String, Pair<InputStream, Long>> b;

    @Override // com.baidu.tieba.jj6
    public boolean e(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, map)) == null) {
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public WebViewDiskLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new aj6();
    }

    public final WebResourceResponse f(String str, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, inputStream)) == null) {
            WebResourceResponse webResourceResponse = new WebResourceResponse(kl6.b(str), "UTF-8", inputStream);
            webResourceResponse.setStatusCodeAndReasonPhrase(200, "OK");
            webResourceResponse.setResponseHeaders(new HashMap<String, String>(this) { // from class: com.baidu.tieba.browser.core.webview.flyweight.loader.WebViewDiskLoader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebViewDiskLoader this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    put("access-control-allow-origin", "*");
                }
            });
            return webResourceResponse;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jj6
    /* renamed from: g */
    public WebResourceResponse c(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        ak6 f;
        String str3;
        Pair<InputStream, Long> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, map)) == null) {
            try {
                f = sj6.e().f(str);
                if (f == null) {
                    f = sj6.e().f(kl6.c(str2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (f == null) {
                return null;
            }
            String str4 = "";
            if (str2.startsWith(str)) {
                String str5 = f.d;
                if (!str5.endsWith(".html")) {
                    str5 = str5 + ".html";
                }
                str3 = f.e + str5;
            } else {
                String c = kl6.c(str2);
                for (String str6 : f.f) {
                    if (c.endsWith(str6)) {
                        str4 = f.e + str6;
                    }
                }
                str3 = str4;
            }
            if (!TextUtils.isEmpty(str3) && (a = this.b.a(str3)) != null && a.first != null) {
                WebResourceResponse f2 = f(str3, a.first);
                HybridLog.getInstance().i("Offline", "返回离线包文件数据:" + str3 + " originUrl：" + str + " url：" + str2);
                return f2;
            }
            return null;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }
}
