package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.message.WebViewCacheReqMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.TriState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bu4 implements re6 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.re6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        qe6.a(this, webView, str, jSONObject);
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947657448, "Lcom/baidu/tieba/bu4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947657448, "Lcom/baidu/tieba/bu4;");
                return;
            }
        }
        a = TbConfig.SERVER_ADDRESS + TbConfig.WEBVIEW_CACHE_URL;
    }

    public bu4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.re6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.FETCH_OFFLINE_USER_INFO.equals(str2)) {
                jsPromptResult.confirm(d(webView).a());
                return true;
            } else if (CommonTbJsBridge.DELETE_OFFLINE_BUNDLE.equals(str2)) {
                jsPromptResult.confirm(c(webView).a());
                return true;
            } else if (CommonTbJsBridge.UPDATE_OFFLINE_BUNDLE.equals(str2)) {
                jsPromptResult.confirm(i(webView).a());
                return true;
            } else if (CommonTbJsBridge.SWITCH_OFFLINE_INTERFACE.equals(str2)) {
                try {
                    jsPromptResult.confirm(g(webView, new JSONObject(str3).optString("host")).a());
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            } else if (CommonTbJsBridge.SWITCH_OFFLINE_BUNDLE_STATUS.equals(str2)) {
                try {
                    jsPromptResult.confirm(f(webView, new JSONObject(str3).optInt("isOn")).a());
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return false;
                }
            } else if (CommonTbJsBridge.SWITCH_URL_HOST.equals(str2)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str3).optJSONArray("hostArr");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, optJSONArray);
                    jsPromptResult.confirm(h(webView, arrayList).a());
                    return true;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public km9 c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView)) == null) {
            km9 km9Var = new km9();
            if (!e()) {
                return km9Var;
            }
            try {
                t99.n().g();
                u99.a().i(null);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                km9Var.o(jSONObject.toString());
                return km9Var;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (km9) invokeL.objValue;
    }

    public km9 d(WebView webView) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, webView)) == null) {
            km9 km9Var = new km9();
            if (!e()) {
                return km9Var;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", TbConfig.getVersion());
                jSONObject.put("cuid", TbadkCoreApplication.getInst().getCuid());
                jSONObject.put("uid", TbadkCoreApplication.getCurrentAccountId());
                jSONObject.put("hybridVersion", t99.n().B());
                if (QuickWebViewSwitch.getInOn()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("hybridOffline", i);
                jSONObject.put("offlineApiHost", a);
                if (TbDebugSingleton.getInstance().getUrlSwitchMap() != null && !TextUtils.isEmpty(TbDebugSingleton.getInstance().getUrlSwitchMap().b)) {
                    jSONObject.put("hostArr", TbDebugSingleton.getInstance().getUrlSwitchMap().b);
                }
                jSONObject.put("resultCode", 1);
                km9Var.o(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return km9Var;
        }
        return (km9) invokeL.objValue;
    }

    public km9 f(WebView webView, int i) {
        InterceptResult invokeLI;
        boolean z;
        TriState triState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, webView, i)) == null) {
            km9 km9Var = new km9();
            if (!e()) {
                return km9Var;
            }
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            try {
                if (z) {
                    triState = TriState.YES;
                } else {
                    triState = TriState.NO;
                }
                QuickWebViewSwitch.setState(triState);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                km9Var.o(jSONObject.toString());
                return km9Var;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (km9) invokeLI.objValue;
    }

    public km9 g(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) {
            km9 km9Var = new km9();
            if (!e()) {
                return km9Var;
            }
            try {
                if (StringUtils.isNull(str)) {
                    str = TbConfig.SERVER_ADDRESS + TbConfig.WEBVIEW_CACHE_URL;
                }
                a = str;
                za5.a().i(true);
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, a + "?cmd=309485");
                tbHttpMessageTask.setResponsedClass(WebViewCacheResHttpMsg.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                km9Var.o(jSONObject.toString());
                return km9Var;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (km9) invokeLL.objValue;
    }

    public km9 h(WebView webView, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, arrayList)) == null) {
            km9 km9Var = new km9();
            if (!e()) {
                return km9Var;
            }
            try {
                nt4 nt4Var = new nt4();
                nt4Var.a = new LinkedHashMap();
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        JSONObject jSONObject = arrayList.get(i);
                        if (jSONObject != null) {
                            nt4Var.a.put(jSONObject.optString("path"), jSONObject.optString("host"));
                        }
                    }
                    if (nt4Var.a.size() > 0) {
                        nt4Var.b = new JSONObject().put("hostArr", new JSONArray((Collection) arrayList)).toString();
                        TbDebugSingleton.getInstance().setUrlSwitchMap(nt4Var);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 1);
                km9Var.o(jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return km9Var;
        }
        return (km9) invokeLL.objValue;
    }

    public km9 i(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView)) == null) {
            km9 km9Var = new km9();
            if (!e()) {
                return km9Var;
            }
            try {
                t99.n().g();
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                km9Var.o(jSONObject.toString());
                return km9Var;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (km9) invokeL.objValue;
    }
}
