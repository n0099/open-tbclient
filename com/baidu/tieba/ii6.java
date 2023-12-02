package com.baidu.tieba;

import android.text.Html;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.sapi2.SapiWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Codec;
/* loaded from: classes6.dex */
public class ii6 extends hi6<WebResourceResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wh6<Pair<String, Map<String, String>>, Response> b;

    /* loaded from: classes6.dex */
    public class a implements soc<Response, Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ii6 e;

        /* renamed from: com.baidu.tieba.ii6$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0330a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0330a(a aVar) {
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
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && yh6.b().contains(bi6.a(this.a.a))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "prefetchLog").param("obj_source", "error").param("obj_name", this.a.a).param("obj_param1", this.a.c).param(TiebaStatic.Params.OBJ_PARAM2, this.a.d));
                }
            }
        }

        public a(ii6 ii6Var, String str, Map map, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii6Var, str, map, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ii6Var;
            this.a = str;
            this.b = map;
            this.c = str2;
            this.d = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: b */
        public void a(Response response, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, exc) == null) {
                if (this.e.l(response) && response.body() != null && exc == null) {
                    try {
                        this.e.j(this.a, response, this.b);
                        TbLog hybridLog = HybridLog.getInstance();
                        hybridLog.i("PreFetch", "sendASyncRequest，预取成功:" + this.a + " headers:" + this.b);
                        SafeHandler.getInst().postDelayed(new RunnableC0330a(this), 30000L);
                    } catch (IOException e) {
                        BdLog.e(e);
                    }
                }
                zh6.b().e(this.a);
            }
        }
    }

    public ii6() {
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
        this.b = new ai6();
    }

    @Override // com.baidu.tieba.hi6
    public boolean e(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, map)) == null) {
            if (!URLUtil.isHttpsUrl(str2) && !URLUtil.isHttpUrl(str2)) {
                return false;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void o(String str, WebResourceResponse webResourceResponse, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, str, webResourceResponse, bArr) == null) && !jk6.d(bArr)) {
            yh6.b().put(bi6.a(str), new li6(str, webResourceResponse, bArr));
        }
    }

    public final Map<String, String> h(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            CookieSyncManager.createInstance(fj6.b());
            String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
            if (!TextUtils.isEmpty(cookie)) {
                String str = map.get("Cookie");
                if (!TextUtils.isEmpty(str)) {
                    if (str.endsWith(ParamableElem.DIVIDE_PARAM)) {
                        cookie = str + cookie;
                    } else {
                        cookie = str + ParamableElem.DIVIDE_PARAM + cookie;
                    }
                }
                map.put("Cookie", cookie);
            }
            return map;
        }
        return (Map) invokeL.objValue;
    }

    public final Map<String, String> i(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, response)) == null) {
            Set<String> names = response.headers().names();
            HashMap hashMap = new HashMap();
            for (String str : names) {
                hashMap.put(str, response.header(str));
            }
            hashMap.put("access-control-allow-origin", "*");
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final String k(ResponseBody responseBody) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responseBody)) == null) {
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

    public final WebResourceResponse j(String str, Response response, Map<String, String> map) throws IOException {
        InterceptResult invokeLLL;
        ResponseBody body;
        WebResourceResponse webResourceResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, response, map)) == null) {
            if (response == null || !response.isSuccessful() || (body = response.body()) == null) {
                return null;
            }
            byte[] bytes = body.bytes();
            String k = k(body);
            if (qh6.isOn()) {
                webResourceResponse = new WebResourceResponse(k, response.header(Http2Codec.ENCODING, null), new ByteArrayInputStream(bytes));
            } else {
                webResourceResponse = new WebResourceResponse(k, response.header(Http2Codec.ENCODING, Util.UTF_8.name()), new ByteArrayInputStream(bytes));
            }
            webResourceResponse.setStatusCodeAndReasonPhrase(response.code(), com.baidu.mobads.sdk.internal.bx.k);
            Map<String, String> i = i(response);
            if (map.containsKey("tieba-response-via")) {
                i.put("tieba-response-via", PrefetchEvent.MODULE);
                i.put("tieba-response-time", String.valueOf(System.currentTimeMillis()));
            }
            webResourceResponse.setResponseHeaders(i);
            o(str, webResourceResponse, bytes);
            if (response.cacheResponse() != null) {
                dk6.c("PreFetch", "hit network cache：" + str);
            } else {
                dk6.c("PreFetch", "hit network：" + str);
            }
            if (map.containsKey("BdLoadMode") && TextUtils.equals(SapiWebView.DATA_MIME_TYPE, k)) {
                n(response, bytes);
            }
            return webResourceResponse;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public final boolean l(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, response)) == null) {
            if (response == null || !response.isSuccessful() || response.isRedirect() || response.body() == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hi6
    /* renamed from: m */
    public WebResourceResponse c(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        WebResourceResponse webResourceResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, str2, map)) == null) {
            zh6.b().a(str2);
            try {
                Map<String, String> h = h(map);
                webResourceResponse = j(str2, this.b.a(Pair.create(str2, h)), h);
            } catch (Exception e) {
                e.printStackTrace();
                webResourceResponse = null;
            }
            zh6.b().e(str2);
            return webResourceResponse;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public final void n(Response response, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, response, bArr) == null) {
            try {
                ei6 ei6Var = new ei6(response.request().isHttps());
                ei6Var.c("link", new di6());
                ei6Var.c(ARPMessageType.ARPMessageParamKeys.MAP_NPC_KEY_NAME, new fi6());
                Html.fromHtml(new String(bArr), null, ei6Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void p(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, map) == null) {
            zh6.b().a(str);
            String remove = map.remove("tb-prefetch-origin-url");
            String remove2 = map.remove("tb-prefetch-error-key");
            Map<String, String> h = h(map);
            this.b.b(Pair.create(str, h), new a(this, str, h, remove2, remove));
        }
    }
}
