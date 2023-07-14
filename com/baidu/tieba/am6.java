package com.baidu.tieba;

import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.webview.flyweight.loader.WebViewDiskLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class am6 extends bm6<WebResourceResponse> {
    public static /* synthetic */ Interceptable $ic;
    public static volatile am6 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final cm6 b;

    @Override // com.baidu.tieba.bm6
    public boolean e(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, map)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public am6() {
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
        this.b = new cm6();
        WebViewDiskLoader webViewDiskLoader = new WebViewDiskLoader();
        webViewDiskLoader.d(this.b);
        d(webViewDiskLoader);
    }

    public static am6 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (am6.class) {
                    if (c == null) {
                        c = new am6();
                    }
                }
            }
            return c;
        }
        return (am6) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bm6
    /* renamed from: h */
    public WebResourceResponse c(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, map)) == null) {
            if (a() != null) {
                return a().b(str, str2, map);
            }
            return null;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public void f(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, map) == null) {
            this.b.p(str, map);
        }
    }
}
