package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.webview.flyweight.FlyWeightConfig;
import com.baidu.tieba.browser.core.webview.flyweight.loader.ImageLoader;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes5.dex */
public class em6 implements gm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dm6 a;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public dm6 a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public gm6 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new em6(this);
            }
            return (gm6) invokeV.objValue;
        }

        public void c(dm6 dm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm6Var) == null) {
                this.a = dm6Var;
            }
        }
    }

    public em6(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar.a;
    }

    @Override // com.baidu.tieba.gm6
    public WebResourceResponse a(String str, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, webResourceRequest)) == null) {
            if (webResourceRequest == null || !TextUtils.equals("GET", webResourceRequest.getMethod())) {
                return null;
            }
            String uri = webResourceRequest.getUrl().toString();
            if (!URLUtil.isNetworkUrl(uri)) {
                return null;
            }
            if (ml6.isOn() && !uri.contains("tieba-ares.cdn") && !uri.contains("bdstatic.com") && !uri.contains(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE) && !uri.contains("tieba.com") && !uri.contains("baidu-int.com")) {
                h29 hybridLog = HybridLog.getInstance();
                hybridLog.c("Proxy", "非贴吧url，不代理网络请求：" + uri);
                return null;
            }
            dm6 dm6Var = this.a;
            if (dm6Var != null && !dm6Var.a(str)) {
                return null;
            }
            return c(str, uri, webResourceRequest.getRequestHeaders());
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public final WebResourceResponse b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            fm6 fm6Var = tl6.b().get(str);
            if (fm6Var != null) {
                h29 hybridLog = HybridLog.getInstance();
                hybridLog.c("Proxy", "PreFetch命中缓存，返回数据：" + fm6Var);
                if (fm6Var.b()) {
                    tl6.b().remove(str);
                }
                if (fm6Var.c()) {
                    return fm6Var.a();
                }
                tl6.b().remove(str);
                return null;
            }
            return null;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final WebResourceResponse c(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, map)) == null) {
            if (ul6.b().c(str2)) {
                long currentTimeMillis = System.currentTimeMillis();
                ul6.b().d(str2, 5000L);
                vn6.b("Proxy", "当前已有请求，等待一下，waitTime = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return b(str2);
            } else if (tl6.b().contains(str2)) {
                return b(str2);
            } else {
                if (FlyWeightConfig.c(str2, map)) {
                    String c = co6.c(str2);
                    if (tl6.b().contains(c)) {
                        return b(c);
                    }
                    return am6.g().b(str, str2, map);
                } else if (FlyWeightConfig.a(str2)) {
                    return ImageLoader.c(str, str2, map);
                } else {
                    return null;
                }
            }
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }
}
