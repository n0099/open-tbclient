package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.browser.auth.AliAuthHttpProxy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.certification.CertificationCheckParams;
import com.baidu.tbadk.core.account.certification.CertificationRequestParams;
import com.baidu.tbadk.core.account.certification.ICertificationCallback;
import com.baidu.tbadk.core.account.certification.ICheckCertificationCallback;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.hy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hy4 implements ul6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AliAuthHttpProxy a;

    @Override // com.baidu.tieba.ul6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        tl6.a(this, webView, str, jSONObject);
    }

    /* loaded from: classes6.dex */
    public class a implements ICheckCertificationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        public a(hy4 hy4Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hy4Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
        }

        @Override // com.baidu.tbadk.core.account.certification.ICheckCertificationCallback
        public void onResult(@Nullable s05 s05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s05Var) == null) {
                if (s05Var == null) {
                    DefaultLog.getInstance().b("CheckCertificationResult", "---- no result ----");
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("status", Integer.valueOf(s05Var.c));
                hashMap.put(StatConstants.KEY_EXT_ERR_MSG, s05Var.d);
                hashMap.put("livingUname", s05Var.e);
                hashMap.put("authsid", s05Var.f);
                hashMap.put("authWidgetURL", s05Var.g);
                hashMap.put("realNameStatus", Integer.valueOf(s05Var.a()));
                hashMap.put(StatConstants.KEY_EXT_ERR_CODE, Integer.valueOf(s05Var.a));
                vl6.a().d(this.a, "authStateResult", hashMap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ICertificationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        public b(hy4 hy4Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hy4Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
        }

        @Override // com.baidu.tbadk.core.account.certification.ICertificationCallback
        public void onResult(t05 t05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t05Var) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(StatConstants.KEY_EXT_ERR_CODE, Integer.valueOf(t05Var.a));
                linkedHashMap.put(StatConstants.KEY_EXT_ERR_MSG, t05Var.b);
                linkedHashMap.put("subResultCode", Integer.valueOf(t05Var.c));
                linkedHashMap.put("subResultMsg", t05Var.d);
                linkedHashMap.put("status", Integer.valueOf(t05Var.a()));
                linkedHashMap.put("callbackkey", t05Var.g);
                if (this.a != null) {
                    vl6.a().d(this.a, "realNameAuthResult", linkedHashMap);
                }
            }
        }
    }

    public hy4() {
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

    @Override // com.baidu.tieba.ul6
    public void onDestroy() {
        AliAuthHttpProxy aliAuthHttpProxy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (aliAuthHttpProxy = this.a) != null) {
            aliAuthHttpProxy.k();
        }
    }

    @Override // com.baidu.tieba.ul6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!TextUtils.equals("CommonJSBridge", str)) {
                return false;
            }
            if (TextUtils.equals("startLoginModule", str2)) {
                try {
                    jsPromptResult.confirm(q(webView, new JSONObject(str3).optString("cssUrl")).a());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (CommonTbJsBridge.LOAD_THIRD_PARTY_LOGIN.equals(str2)) {
                jsPromptResult.confirm(i(webView, str3));
            } else if (CommonTbJsBridge.START_DOWNLOAD_CSS.equals(str2)) {
                try {
                    jsPromptResult.confirm(p(webView, new JSONObject(str3).optString(TTDownloadField.TT_DOWNLOAD_URL)).a());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            } else if (UegTbJsBridge.METHOD_BIND_MOBILE_NUMBER.equals(str2)) {
                jsPromptResult.confirm(c(webView).a());
                return true;
            } else if (TextUtils.equals("startAllLoginModule", str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(o(webView, jSONObject.optString("type"), jSONObject.optString("addObserverNotify"), jSONObject.optString("activityId"), jSONObject.optString("cssUrl")).a());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public bz9 c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView)) == null) {
            bz9 bz9Var = new bz9();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, rc5.b()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bz9Var;
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 f(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, webView)) == null) {
            if (this.a == null) {
                this.a = new AliAuthHttpProxy(webView);
            }
            return this.a.l();
        }
        return (bz9) invokeL.objValue;
    }

    public /* synthetic */ void h(WebView webView) {
        vl6.a().d(webView, "commonLogin", new HashMap<String, Object>(this) { // from class: com.baidu.tbadk.browser.bridge.AccountJsBridgePlugin$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hy4 this$0;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                put("resultCode", 2);
                put("hasLogin", Boolean.TRUE);
            }
        });
    }

    public bz9 d(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
            bz9 bz9Var = new bz9();
            HashMap hashMap = new HashMap();
            hashMap.put("scene", l(str));
            MessageManager.getInstance().runTask(2921709, String.class, new CertificationCheckParams(hashMap, new a(this, webView)));
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    public final String i(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
            if (!ui.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return g(webView, jSONObject.optInt("socialType", 0), jSONObject.optString("activityId")).a();
                } catch (JSONException e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public bz9 q(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            bz9 bz9Var = new bz9();
            Activity a2 = jl6.a(webView.getContext());
            if (a2 != null) {
                ViewHelper.checkUpIsLoginFromH5(a2, webView.getOriginalUrl(), str);
            }
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            bz9Var.o(OrmObject.jsonStrWithObject(jSResultData));
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 e(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, hashMap)) == null) {
            bz9 bz9Var = new bz9();
            bz9Var.o(j(hashMap).toString());
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 n(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, hashMap)) == null) {
            bz9 bz9Var = new bz9();
            if (hashMap != null && !hashMap.isEmpty()) {
                bz9Var.o(j(hashMap).toString());
            }
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 g(WebView webView, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, webView, i, str)) == null) {
            bz9 bz9Var = new bz9();
            JSONObject jSONObject = new JSONObject();
            Activity a2 = jl6.a(webView.getContext());
            if (a2 == null) {
                try {
                    jSONObject.put("resultCode", 0);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                bz9Var.o(jSONObject.toString());
                return bz9Var;
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) a2, true);
            loginActivityConfig.setThirdPartyLoginForResult(i, str);
            loginActivityConfig.setUrl(webView.getOriginalUrl());
            ViewHelper.checkUpIsLoginFromH5(loginActivityConfig);
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            bz9Var.o(jSONObject.toString());
            return bz9Var;
        }
        return (bz9) invokeLIL.objValue;
    }

    public final JSONObject j(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    zq8 hybridLog = HybridLog.getInstance();
                    hybridLog.b("AccountJsBridgePlugin", "Map转json失败:" + e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1018959312) {
                if (hashCode != -142547405) {
                    if (hashCode == 1368645956 && str.equals(FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH)) {
                        c = 2;
                    }
                } else if (str.equals("baidu_mini_programs")) {
                    c = 0;
                }
            } else if (str.equals("netdisk_2pwd")) {
                c = 1;
            }
            if (c == 0) {
                return "baidu_mini_programs";
            }
            if (c == 1) {
                return "netdisk_2pwd";
            }
            if (c != 2) {
                return FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE;
            }
            return FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH;
        }
        return (String) invokeL.objValue;
    }

    public bz9 k(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, hashMap)) == null) {
            bz9 bz9Var = new bz9();
            int i2 = -1;
            try {
                i2 = Integer.parseInt(hashMap.get("status"));
                bz9Var.y(i2);
                bz9Var.u(hashMap.get("message"));
                if (i2 == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("avatar", hashMap.get("avatar"));
                    jSONObject.put("nick_name", hashMap.get("nick_name"));
                    jSONObject.put("alipay_user_id", hashMap.get("alipay_user_id"));
                    bz9Var.o(jSONObject.toString());
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GET_ALI_PAY_USER_INFO);
            if (i2 == 0) {
                i = 0;
            } else {
                i = 1;
            }
            TiebaStatic.log(statisticItem.param("obj_param1", i));
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 p(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, str)) == null) {
            bz9 bz9Var = new bz9();
            JSONObject jSONObject = new JSONObject();
            if (!ui.isEmpty(str)) {
                try {
                    if (ui.isEmpty(str)) {
                        jSONObject.put("resultCode", 0);
                        bz9Var.o(jSONObject.toString());
                        return bz9Var;
                    }
                    String customLoginCssFileName = FileHelper.getCustomLoginCssFileName(str);
                    String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(str);
                    if (!FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
                        jSONObject.put("resultCode", 0);
                        bz9Var.o(jSONObject.toString());
                        return bz9Var;
                    }
                    DownloadData downloadData = new DownloadData(customLoginCssFileName, customLoginCssFileName, str, null);
                    downloadData.setPath(customLoginCssStoragePath);
                    qh5.k().l(downloadData);
                    jSONObject.put("resultCode", 1);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            bz9Var.o(jSONObject.toString());
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 m(WebView webView, String str, boolean z, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{webView, str, Boolean.valueOf(z), str2, Integer.valueOf(i)})) == null) {
            bz9 bz9Var = new bz9();
            MessageManager.getInstance().runTask(2921710, String.class, new CertificationRequestParams(l(str), z, i, str2, new b(this, webView)));
            return bz9Var;
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 o(final WebView webView, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048590, this, webView, str, str2, str3, str4)) == null) {
            bz9 bz9Var = new bz9();
            if (TbadkCoreApplication.isLogin()) {
                ml6.a().c(new Runnable() { // from class: com.baidu.tieba.cy4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            hy4.this.h(webView);
                        }
                    }
                });
                return bz9Var;
            }
            if ((str.equals("0") || str.equals("")) && str4 != null) {
                Activity a2 = jl6.a(webView.getContext());
                if (a2 != null) {
                    ViewHelper.checkUpIsLoginFromH5(a2, webView.getOriginalUrl(), str4);
                }
                JSResultData jSResultData = new JSResultData();
                jSResultData.setStatus(1);
                jSResultData.setErrorCode("0");
                jSResultData.setErrorMsg("");
                bz9Var.o(OrmObject.jsonStrWithObject(jSResultData));
            }
            if ((str3 != null && !StringUtils.isNull(str) && (str.equals("1") || str.equals("2"))) || str.equals("3") || str.equals(YYOption.UrlProtocol.USER)) {
                JSONObject jSONObject = new JSONObject();
                Activity a3 = jl6.a(webView.getContext());
                if (a3 == null) {
                    try {
                        jSONObject.put("resultCode", 0);
                        jSONObject.put("status", 403);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    bz9Var.o(jSONObject.toString());
                    return bz9Var;
                }
                if (!StringUtils.isNull(str) && str.equals(YYOption.UrlProtocol.USER)) {
                    DialogLoginHelper.checkUpIsLogin(new LoginDialogData(jl6.a(webView.getContext()), LoginDialogData.SCHEMA_LOGIN));
                }
                if (!StringUtils.isNull(str) && (str.equals("1") || str.equals("2") || str.equals("3"))) {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) a3, true);
                    loginActivityConfig.setThirdPartyLoginForResult(Integer.parseInt(str), str3);
                    loginActivityConfig.setUrl(webView.getOriginalUrl());
                    ViewHelper.checkUpIsLoginFromH5(loginActivityConfig);
                }
                try {
                    jSONObject.put("resultCode", 1);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                bz9Var.o(jSONObject.toString());
            }
            return bz9Var;
        }
        return (bz9) invokeLLLLL.objValue;
    }

    public bz9 r(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, hashMap)) == null) {
            bz9 bz9Var = new bz9();
            JSONObject jSONObject = new JSONObject();
            if (hashMap != null && hashMap.get("hasLogin") != null && Boolean.TRUE.equals(hashMap.get("hasLogin"))) {
                try {
                    jSONObject.put("resultCode", 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bz9Var.o(jSONObject.toString());
                return bz9Var;
            } else if (hashMap != null && hashMap.get("isLogin") != null && Boolean.TRUE.equals(hashMap.get("isLogin")) && (!hashMap.containsKey("resultCode") || ((Integer) hashMap.get("resultCode")).intValue() != 0)) {
                try {
                    jSONObject.put("resultCode", 1);
                    jSONObject.put("socialType", hashMap.get("social_type"));
                    jSONObject.put("activityId", hashMap.get("activityId"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                a(webView, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, jSONObject);
                bz9Var.o(jSONObject.toString());
                return bz9Var;
            } else {
                try {
                    jSONObject.put("resultCode", 0);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                bz9Var.o(jSONObject.toString());
                bz9Var.q(403, "登录失败！");
                return bz9Var;
            }
        }
        return (bz9) invokeLL.objValue;
    }
}
