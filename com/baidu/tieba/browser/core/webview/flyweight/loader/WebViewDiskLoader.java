package com.baidu.tieba.browser.core.webview.flyweight.loader;

import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dd6;
import com.baidu.tieba.ke6;
import com.baidu.tieba.lc6;
import com.baidu.tieba.mc6;
import com.baidu.tieba.nc6;
import com.baidu.tieba.ue6;
import com.baidu.tieba.yc6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class WebViewDiskLoader extends yc6<WebResourceResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lc6<String, byte[]> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewDiskLoader(yc6<WebResourceResponse> yc6Var) {
        super(yc6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yc6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yc6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new mc6();
    }

    @Override // com.baidu.tieba.yc6
    public boolean d(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map)) == null) {
            return URLUtil.isFileUrl(str);
        }
        return invokeLL.booleanValue;
    }

    public final WebResourceResponse e(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr)) == null) {
            WebResourceResponse webResourceResponse = new WebResourceResponse(ue6.c(str), "UTF-8", new ByteArrayInputStream(bArr));
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
    @Override // com.baidu.tieba.yc6
    /* renamed from: f */
    public WebResourceResponse c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, map)) == null) {
            try {
                byte[] a = this.b.a(str);
                if (a != null && a.length > 0) {
                    WebResourceResponse e = e(str, a);
                    ke6.b("lt-log", "hit disk cache:" + str);
                    g(str, e, a);
                    return e;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public final void g(String str, WebResourceResponse webResourceResponse, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, webResourceResponse, bArr) == null) {
            nc6.a().put(ue6.a(str), new dd6(webResourceResponse, bArr));
        }
    }
}
