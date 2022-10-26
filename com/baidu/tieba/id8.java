package com.baidu.tieba;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpReqMsg;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class id8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebView a;
    public BdUniqueId b;
    public do8 c;
    public HashSet d;
    public HashMap e;
    public HashMap f;
    public boolean g;
    public String h;
    public HttpMessageListener i;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(id8 id8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id8Var, Integer.valueOf(i)};
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
            this.a = id8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            String str2;
            boolean z;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof QuickWebViewHttpResMsg)) {
                return;
            }
            QuickWebViewHttpResMsg quickWebViewHttpResMsg = (QuickWebViewHttpResMsg) httpResponsedMessage;
            int i = 0;
            String str5 = null;
            if (!(quickWebViewHttpResMsg.getOrginalMessage() instanceof QuickWebViewHttpReqMsg)) {
                str = "";
                str2 = null;
                z = false;
            } else {
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = (QuickWebViewHttpReqMsg) quickWebViewHttpResMsg.getOrginalMessage();
                z = quickWebViewHttpReqMsg.isFromRequestByNative;
                if (StringUtils.isNull(quickWebViewHttpReqMsg.url)) {
                    str = "";
                    str2 = null;
                } else {
                    String str6 = quickWebViewHttpReqMsg.url;
                    long j = quickWebViewHttpReqMsg.begin;
                    str = quickWebViewHttpReqMsg.module;
                    String str7 = quickWebViewHttpReqMsg.jsCallbackMethod;
                    if (TextUtils.isEmpty(str7) && !z) {
                        str7 = (String) this.a.e.remove(str6);
                        i = 1;
                    }
                    this.a.d.remove(str6);
                    str5 = str7;
                    str2 = str6;
                }
            }
            if (quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                str4 = quickWebViewHttpResMsg.getResult();
                str3 = BasicPushStatus.SUCCESS_CODE;
            } else {
                str3 = quickWebViewHttpResMsg.getError() + "";
                str4 = "\"\"";
            }
            String s = jd8.q().s(str);
            if (s == null) {
                s = "0.0.0.0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\"status\":");
            sb.append("\"");
            sb.append(str3);
            sb.append("\"");
            sb.append(",");
            sb.append("\"data\":");
            sb.append(str4);
            sb.append(",");
            sb.append("\"cache_version\":");
            sb.append("\"");
            sb.append(s);
            sb.append("\"");
            sb.append(",");
            sb.append("\"cache\":");
            sb.append("\"");
            sb.append(i);
            sb.append("\"");
            sb.append("}");
            if (z) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(TiebaStatic.LogFields.RESULT, sb.toString());
                linkedHashMap.put("NotificationKey", str2);
                this.a.c.h(this.a.a, "RequestByNativeToH5", linkedHashMap);
            } else if (StringUtils.isNull(str5)) {
                this.a.f.put(str2, sb.toString());
            } else {
                this.a.k(str5, sb.toString());
            }
        }
    }

    public id8(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new HashSet();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = false;
        this.i = new a(this, CmdConfigHttp.CMD_WEB_HTTP_PROXY);
        this.a = webView;
        this.h = webView.getSettings().getUserAgentString();
        BdUniqueId gen = BdUniqueId.gen();
        this.b = gen;
        this.i.setTag(gen);
        this.i.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.i);
    }

    public void l(do8 do8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, do8Var) == null) {
            this.c = do8Var;
        }
    }

    public void j(QuickWebViewBridgeData quickWebViewBridgeData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, quickWebViewBridgeData, str, z) == null) {
            g(quickWebViewBridgeData, str, z);
        }
    }

    public final void g(QuickWebViewBridgeData quickWebViewBridgeData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048576, this, quickWebViewBridgeData, str, z) == null) && !this.g && quickWebViewBridgeData != null && !StringUtils.isNull(quickWebViewBridgeData.url) && !StringUtils.isNull(quickWebViewBridgeData.type)) {
            String str2 = (String) this.f.remove(quickWebViewBridgeData.url);
            if (!StringUtils.isNull(str2) && str != null) {
                k(str, str2);
            } else if (!StringUtils.isNull(str2) && z) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(TiebaStatic.LogFields.RESULT, str2);
                linkedHashMap.put("NotificationKey", quickWebViewBridgeData.url);
                this.c.h(this.a, "RequestByNativeToH5", linkedHashMap);
            } else if (this.d.contains(quickWebViewBridgeData.url) && !z) {
                if (!TextUtils.isEmpty(str)) {
                    this.e.put(quickWebViewBridgeData.url, str);
                }
            } else {
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
                quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
                quickWebViewHttpReqMsg.module = quickWebViewBridgeData.module;
                quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
                quickWebViewHttpReqMsg.jsCallbackMethod = str;
                quickWebViewHttpReqMsg.setTag(this.b);
                quickWebViewHttpReqMsg.isFromRequestByNative = z;
                CookieSyncManager.createInstance(this.a.getContext());
                String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
                if (!TextUtils.isEmpty(cookie)) {
                    HashMap headers = quickWebViewHttpReqMsg.getHeaders();
                    if (headers != null) {
                        String str3 = (String) headers.get("Cookie");
                        if (!TextUtils.isEmpty(str3)) {
                            if (str3.endsWith(ParamableElem.DIVIDE_PARAM)) {
                                cookie = str3 + cookie;
                            } else {
                                cookie = str3 + ParamableElem.DIVIDE_PARAM + cookie;
                            }
                        }
                        quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                    } else {
                        quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                    }
                }
                quickWebViewHttpReqMsg.setUserAgent(this.h);
                quickWebViewHttpReqMsg.addCookie("cache_version", jd8.q().s(quickWebViewBridgeData.module));
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_WEB_HTTP_PROXY, quickWebViewBridgeData.url);
                tbHttpMessageTask.setResponsedClass(QuickWebViewHttpResMsg.class);
                tbHttpMessageTask.setIsNeedAddCommenParam(false);
                tbHttpMessageTask.setIsUseCurrentBDUSS(false);
                tbHttpMessageTask.setPriority(4);
                if (quickWebViewBridgeData.type.toLowerCase().equals("post")) {
                    Map map = quickWebViewBridgeData.data;
                    if (map != null && !map.isEmpty()) {
                        for (Map.Entry entry : quickWebViewBridgeData.data.entrySet()) {
                            quickWebViewHttpReqMsg.addParam((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                } else {
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
                }
                MessageManager.getInstance().sendMessage(quickWebViewHttpReqMsg, tbHttpMessageTask);
                this.d.add(quickWebViewBridgeData.url);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g = true;
            MessageManager.getInstance().unRegisterListener(this.b);
            MessageManager.getInstance().removeMessage(this.b);
            this.d.clear();
            this.d = null;
            this.e.clear();
            this.e = null;
            this.f.clear();
            this.f = null;
        }
    }

    public void i(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, quickWebViewBridgeData, str) == null) {
            g(quickWebViewBridgeData, str, false);
        }
    }

    public final void k(String str, String str2) {
        WebView webView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && (webView = this.a) != null) {
            webView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }
}
