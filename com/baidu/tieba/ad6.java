package com.baidu.tieba;

import android.text.Html;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Http2Codec;
/* loaded from: classes3.dex */
public class ad6 extends yc6<WebResourceResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lc6<Pair<String, Map<String, String>>, Response> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad6(yc6<WebResourceResponse> yc6Var) {
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
        this.b = new oc6();
    }

    public final String f(ResponseBody responseBody) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, responseBody)) == null) {
            MediaType contentType = responseBody.contentType();
            if (contentType == null) {
                return "";
            }
            String mediaType = contentType.toString();
            if (TextUtils.isEmpty(mediaType) || (split = mediaType.split(ParamableElem.DIVIDE_PARAM)) == null || split.length <= 0 || TextUtils.isEmpty(split[0])) {
                return "";
            }
            return split[0].trim();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yc6
    public boolean d(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map)) == null) {
            if (!URLUtil.isHttpsUrl(str) && !URLUtil.isHttpUrl(str)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final Map<String, String> e(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, response)) == null) {
            Set<String> names = response.headers().names();
            HashMap hashMap = new HashMap();
            for (String str : names) {
                hashMap.put(str, response.header(str));
            }
            hashMap.put("access-control-allow-origin", "*");
            hashMap.remove(Headers.CACHE_CONTROL);
            hashMap.remove(Headers.EXPIRES);
            hashMap.remove(Headers.ETAG);
            hashMap.remove("Age");
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean g(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, response)) == null) {
            if (response == null || !response.isSuccessful() || response.isRedirect() || response.body() == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yc6
    /* renamed from: h */
    public WebResourceResponse c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, map)) == null) {
            try {
                Response a = this.b.a(Pair.create(str, map));
                if (g(a) && a.body() != null) {
                    byte[] bytes = a.body().bytes();
                    String f = f(a.body());
                    WebResourceResponse webResourceResponse = new WebResourceResponse(f, a.header(Http2Codec.ENCODING, "uft-8"), new ByteArrayInputStream(bytes));
                    webResourceResponse.setStatusCodeAndReasonPhrase(a.code(), "OK");
                    webResourceResponse.setResponseHeaders(e(a));
                    if (map.containsKey("BdLoadMode") && TextUtils.equals(SapiWebView.DATA_MIME_TYPE, f)) {
                        i(a, bytes);
                    }
                    j(str, webResourceResponse, bytes);
                    if (a.cacheResponse() != null) {
                        ke6.b("lt-log", "hit network cache：" + str);
                    } else {
                        ke6.b("lt-log", "hit network：" + str);
                    }
                    return webResourceResponse;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public final void i(Response response, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, response, bArr) == null) {
            try {
                rc6 rc6Var = new rc6(response.request().isHttps());
                rc6Var.c("link", new qc6());
                rc6Var.c(ARPMessageType.ARPMessageParamKeys.MAP_NPC_KEY_NAME, new sc6());
                Html.fromHtml(new String(bArr), null, rc6Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void j(String str, WebResourceResponse webResourceResponse, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, webResourceResponse, bArr) == null) {
            nc6.a().put(ue6.a(str), new dd6(webResourceResponse, bArr));
        }
    }
}
