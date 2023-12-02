package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.browser.proxy.OfflineBridgeData;
import com.baidu.tbadk.browser.proxy.OfflineWebViewHttpReqMsg;
import com.baidu.tbadk.browser.proxy.OfflineWebViewHttpResMsg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public class eu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public Map<String, Boolean> b;
    public Map<String, String> c;
    public Map<String, String> d;
    public HttpMessageListener e;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(eu4 eu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x018b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x018e  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            String str2;
            WebView webView;
            String str3;
            int i;
            boolean z;
            int i2;
            String str4;
            String str5;
            String p;
            StringBuilder sb;
            String str6;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof OfflineWebViewHttpResMsg)) {
                return;
            }
            OfflineWebViewHttpResMsg offlineWebViewHttpResMsg = (OfflineWebViewHttpResMsg) httpResponsedMessage;
            int i3 = 0;
            String str7 = null;
            if (!(offlineWebViewHttpResMsg.getOrginalMessage() instanceof OfflineWebViewHttpReqMsg)) {
                str = "";
                str2 = null;
                webView = null;
                str3 = null;
                i = 0;
            } else {
                OfflineWebViewHttpReqMsg offlineWebViewHttpReqMsg = (OfflineWebViewHttpReqMsg) offlineWebViewHttpResMsg.getOrginalMessage();
                boolean z2 = offlineWebViewHttpReqMsg.isFromRequestByNative;
                webView = offlineWebViewHttpReqMsg.webView;
                if (StringUtils.isNull(offlineWebViewHttpReqMsg.url)) {
                    str = "";
                    str2 = null;
                    str3 = null;
                    i = z2;
                } else {
                    String str8 = offlineWebViewHttpReqMsg.url;
                    str = offlineWebViewHttpReqMsg.module;
                    str3 = offlineWebViewHttpReqMsg.urlSign;
                    String str9 = offlineWebViewHttpReqMsg.jsCallbackMethod;
                    if (TextUtils.isEmpty(str9) && z2 == 0) {
                        str9 = (String) this.a.c.remove(str3);
                        i3 = 1;
                    }
                    z = ((Boolean) this.a.b.remove(str3)).booleanValue();
                    str7 = str9;
                    str2 = str8;
                    i2 = z2;
                    if (!offlineWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(offlineWebViewHttpResMsg.getResult())) {
                        str5 = offlineWebViewHttpResMsg.getResult();
                        str4 = BasicPushStatus.SUCCESS_CODE;
                    } else {
                        str4 = offlineWebViewHttpResMsg.getError() + "";
                        str5 = "\"\"";
                    }
                    p = tga.n().p(str);
                    if (p == null) {
                        p = "0.0.0.0";
                    }
                    sb = new StringBuilder();
                    sb.append("{");
                    sb.append("\"status\":");
                    sb.append("\"");
                    sb.append(str4);
                    sb.append("\"");
                    sb.append(",");
                    sb.append("\"data\":");
                    sb.append(str5);
                    sb.append(",");
                    sb.append("\"cache_version\":");
                    sb.append("\"");
                    sb.append(p);
                    sb.append("\"");
                    sb.append(",");
                    sb.append("\"cache\":");
                    sb.append("\"");
                    sb.append(i3);
                    sb.append("\"");
                    sb.append(",");
                    sb.append("\"fromPreRequest\":");
                    sb.append("\"");
                    sb.append(i2 ^ 1);
                    sb.append("\"");
                    sb.append("}");
                    dk6.a("OfflineWebHttpProxy", "网络请求结果：fromPreRequest=" + (i2 ^ 1));
                    if (i2 != 0 && !z) {
                        if (StringUtils.isNull(str7)) {
                            dk6.a("OfflineWebHttpProxy", "请求完成：预请求-收到网络请求结果（" + httpResponsedMessage.getStatusCode() + "），缓存请求结果：url=" + str2);
                            this.a.d.put(str3, sb.toString());
                            return;
                        }
                        dk6.a("OfflineWebHttpProxy", "请求完成：预请求-收到网络请求结果（" + httpResponsedMessage.getStatusCode() + "），开始回调js函数(" + str7 + ")：url=" + str2);
                        this.a.l(webView, str7, sb.toString());
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("请求完成：");
                    if (i2 == 0) {
                        str6 = "端能力";
                    } else {
                        str6 = "预请求";
                    }
                    sb2.append(str6);
                    sb2.append("-收到网络请求结果（");
                    sb2.append(httpResponsedMessage.getStatusCode());
                    sb2.append("），开始回调端能力：url=");
                    sb2.append(str2);
                    dk6.a("OfflineWebHttpProxy", sb2.toString());
                    this.a.i(webView, str2, sb.toString());
                }
            }
            z = false;
            i2 = i;
            if (!offlineWebViewHttpResMsg.isSuccess()) {
            }
            str4 = offlineWebViewHttpResMsg.getError() + "";
            str5 = "\"\"";
            p = tga.n().p(str);
            if (p == null) {
            }
            sb = new StringBuilder();
            sb.append("{");
            sb.append("\"status\":");
            sb.append("\"");
            sb.append(str4);
            sb.append("\"");
            sb.append(",");
            sb.append("\"data\":");
            sb.append(str5);
            sb.append(",");
            sb.append("\"cache_version\":");
            sb.append("\"");
            sb.append(p);
            sb.append("\"");
            sb.append(",");
            sb.append("\"cache\":");
            sb.append("\"");
            sb.append(i3);
            sb.append("\"");
            sb.append(",");
            sb.append("\"fromPreRequest\":");
            sb.append("\"");
            sb.append(i2 ^ 1);
            sb.append("\"");
            sb.append("}");
            dk6.a("OfflineWebHttpProxy", "网络请求结果：fromPreRequest=" + (i2 ^ 1));
            if (i2 != 0) {
            }
            StringBuilder sb22 = new StringBuilder();
            sb22.append("请求完成：");
            if (i2 == 0) {
            }
            sb22.append(str6);
            sb22.append("-收到网络请求结果（");
            sb22.append(httpResponsedMessage.getStatusCode());
            sb22.append("），开始回调端能力：url=");
            sb22.append(str2);
            dk6.a("OfflineWebHttpProxy", sb22.toString());
            this.a.i(webView, str2, sb.toString());
        }
    }

    public eu4() {
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
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new a(this, CmdConfigHttp.CMD_WEB_HTTP_PROXY);
        BdUniqueId gen = BdUniqueId.gen();
        this.a = gen;
        this.e.setTag(gen);
        this.e.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.e);
    }

    public final void f(WebView webView, OfflineBridgeData offlineBridgeData, String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{webView, offlineBridgeData, str, Boolean.valueOf(z)}) == null) && offlineBridgeData != null && !StringUtils.isNull(offlineBridgeData.url) && !StringUtils.isNull(offlineBridgeData.type)) {
            String g = g(offlineBridgeData.url);
            String remove = this.d.remove(g);
            if (!TextUtils.isEmpty(remove) && str != null) {
                dk6.a("OfflineWebHttpProxy", "请求完成：命中预请求缓存-执行js回调，url=" + offlineBridgeData.url);
                l(webView, str, remove);
            } else if (!TextUtils.isEmpty(remove) && z) {
                dk6.a("OfflineWebHttpProxy", "请求完成：命中预请求缓存-执行端能力回调，url=" + offlineBridgeData.url);
                i(webView, offlineBridgeData.url, remove);
            } else if (this.b.containsKey(g)) {
                if (!TextUtils.isEmpty(str)) {
                    dk6.a("OfflineWebHttpProxy", "加入等待队列：重复的请求-js回调函数-等待网络结果完成后回调，url=" + offlineBridgeData.url);
                    this.c.put(g, str);
                } else if (z) {
                    dk6.a("OfflineWebHttpProxy", "加入等待队列：重复的请求-端能力-等待网络结果完成后回调，url=" + offlineBridgeData.url);
                    this.b.put(g, Boolean.TRUE);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                if (z) {
                    str2 = "端能力";
                } else {
                    str2 = "预请求";
                }
                sb.append(str2);
                sb.append("-正在发起网络请求：");
                sb.append(offlineBridgeData.url);
                dk6.a("OfflineWebHttpProxy", sb.toString());
                this.b.put(g, Boolean.valueOf(z));
                m(webView, offlineBridgeData, str, z, g);
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                Uri parse = Uri.parse(str);
                String str2 = parse.getScheme() + "://" + parse.getAuthority() + parse.getPath();
                TreeSet<String> treeSet = new TreeSet(parse.getQueryParameterNames());
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (String str3 : treeSet) {
                    if (z) {
                        z = false;
                        sb.append("?");
                        sb.append(str3);
                        sb.append("=");
                        sb.append(parse.getQueryParameter(str3));
                    } else {
                        sb.append("&");
                        sb.append(str3);
                        sb.append("=");
                        sb.append(parse.getQueryParameter(str3));
                    }
                }
                return xd.c(str2 + ((Object) sb));
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.a);
            MessageManager.getInstance().removeMessage(this.a);
            this.b.clear();
            this.b = null;
            this.d.clear();
            this.d = null;
            this.c.clear();
            this.c = null;
        }
    }

    public final void i(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, str2) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", str2);
            linkedHashMap.put("NotificationKey", str);
            rj6.a().d(webView, "RequestByNativeToH5", linkedHashMap);
        }
    }

    public void j(WebView webView, OfflineBridgeData offlineBridgeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, offlineBridgeData, str) == null) {
            dk6.a("OfflineWebHttpProxy", "预请求：" + offlineBridgeData.url);
            f(webView, offlineBridgeData, str, false);
        }
    }

    public void k(WebView webView, OfflineBridgeData offlineBridgeData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{webView, offlineBridgeData, str, Boolean.valueOf(z)}) == null) {
            dk6.a("OfflineWebHttpProxy", "端能力请求：" + offlineBridgeData.url);
            f(webView, offlineBridgeData, str, z);
        }
    }

    public final void l(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, webView, str, str2) == null) && webView != null) {
            webView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    public final void m(WebView webView, OfflineBridgeData offlineBridgeData, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{webView, offlineBridgeData, str, Boolean.valueOf(z), str2}) == null) {
            OfflineWebViewHttpReqMsg offlineWebViewHttpReqMsg = new OfflineWebViewHttpReqMsg();
            offlineWebViewHttpReqMsg.url = offlineBridgeData.url;
            offlineWebViewHttpReqMsg.urlSign = str2;
            offlineWebViewHttpReqMsg.module = offlineBridgeData.module;
            offlineWebViewHttpReqMsg.begin = offlineBridgeData.begin;
            offlineWebViewHttpReqMsg.jsCallbackMethod = str;
            offlineWebViewHttpReqMsg.webView = webView;
            offlineWebViewHttpReqMsg.setTag(this.a);
            offlineWebViewHttpReqMsg.isFromRequestByNative = z;
            CookieSyncManager.createInstance(fj6.b());
            String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
            if (!TextUtils.isEmpty(cookie)) {
                HashMap<String, String> headers = offlineWebViewHttpReqMsg.getHeaders();
                if (headers != null) {
                    String str3 = headers.get("Cookie");
                    if (!TextUtils.isEmpty(str3)) {
                        if (str3.endsWith(ParamableElem.DIVIDE_PARAM)) {
                            cookie = str3 + cookie;
                        } else {
                            cookie = str3 + ParamableElem.DIVIDE_PARAM + cookie;
                        }
                    }
                    offlineWebViewHttpReqMsg.addHeader("Cookie", cookie);
                } else {
                    offlineWebViewHttpReqMsg.addHeader("Cookie", cookie);
                }
            }
            offlineWebViewHttpReqMsg.setUserAgent(webView.getSettings().getUserAgentString());
            offlineWebViewHttpReqMsg.addCookie("cache_version", tga.n().p(offlineBridgeData.module));
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_WEB_HTTP_PROXY, offlineBridgeData.url);
            tbHttpMessageTask.setResponsedClass(OfflineWebViewHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setPriority(4);
            if (offlineBridgeData.type.toLowerCase().equals(CommandUBCHelper.COMMAND_UBC_SOURCE_SEND)) {
                Map<String, String> map = offlineBridgeData.data;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : offlineBridgeData.data.entrySet()) {
                        offlineWebViewHttpReqMsg.addParam(entry.getKey(), entry.getValue());
                    }
                }
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            } else {
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            }
            MessageManager.getInstance().sendMessage(offlineWebViewHttpReqMsg, tbHttpMessageTask);
        }
    }
}
