package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hu4 implements re6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.re6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        qe6.a(this, webView, str, jSONObject);
    }

    public hu4() {
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

    @Override // com.baidu.tieba.re6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.TOAST_POPUPVIEW.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(f(webView, jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE), jSONObject.optInt("ahead_type"), jSONObject.optString("message"), jSONObject.optString("btn_text"), jSONObject.optInt("toast_duration"), jSONObject.optString("schema"), jSONObject.optString("token"), jSONObject.optDouble(NativeConstants.OPACITY), jSONObject.optString(BigdayActivityConfig.IMG_URL), jSONObject.optString("url"), jSONObject.optInt("mission_id"), jSONObject.optString("btn_color"), jSONObject.optString("message_color"), jSONObject.optString("btn_text_color"), jSONObject.optInt("status"), jSONObject.optInt(CommonTbJsBridge.FINISH_THIS_PAGE)).a());
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            } else if (CommonTbJsBridge.SHOW_TIP_TOAST.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(g(webView, jSONObject2.optString("content"), jSONObject2.optString("linkUrl"), jSONObject2.optString("key"), jSONObject2.optInt("maxTimes"), jSONObject2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE)).a());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            } else if (CommonTbJsBridge.GET_MODAL_DATA.equals(str2)) {
                try {
                    try {
                        jsPromptResult.confirm(e(webView, new JSONObject(str3).optString("url")).a());
                        return false;
                    } catch (JSONException e3) {
                        e = e3;
                        BdLog.e(e);
                        return false;
                    }
                } catch (JSONException e4) {
                    e = e4;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final void c(String str) {
        TbPageContext<?> d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !hi.isEmpty(str) && (d = d(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            UrlManager.getInstance().dealOneLink(d, new String[]{str});
        }
    }

    public final TbPageContext d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:3|4|5|(5:7|(1:11)|13|14|15)(5:20|(2:22|23)|13|14|15)|12|13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
        com.baidu.adp.lib.util.BdLog.e(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public km9 e(WebView webView, String str) {
        InterceptResult invokeLL;
        String f;
        JSONObject newGodDataJson;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            km9 km9Var = new km9();
            JSONObject jSONObject = null;
            int i = 0;
            try {
                f = q95.c().f();
                newGodDataJson = TbSingleton.getInstance().getNewGodDataJson();
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (!hi.isEmpty(str)) {
                int indexOf = str.indexOf(WebViewActivityConfig.TAG_NEW_GOD_INVITE);
                if (newGodDataJson != null && indexOf != -1) {
                    jSONObject = newGodDataJson;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                jSONObject2.put("user_info", jSONObject);
                km9Var.o(jSONObject2.toString());
                return km9Var;
            }
            if (!TextUtils.isEmpty(f)) {
                jSONObject = new JSONObject(f);
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("resultCode", i);
            jSONObject22.put("user_info", jSONObject);
            km9Var.o(jSONObject22.toString());
            return km9Var;
            i = 1;
            JSONObject jSONObject222 = new JSONObject();
            jSONObject222.put("resultCode", i);
            jSONObject222.put("user_info", jSONObject);
            km9Var.o(jSONObject222.toString());
            return km9Var;
        }
        return (km9) invokeLL.objValue;
    }

    public km9 f(WebView webView, int i, int i2, String str, String str2, int i3, String str3, String str4, double d, String str5, String str6, int i4, String str7, String str8, String str9, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{webView, Integer.valueOf(i), Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3, str4, Double.valueOf(d), str5, str6, Integer.valueOf(i4), str7, str8, str9, Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            km9 km9Var = new km9();
            dr4 dr4Var = new dr4();
            dr4Var.c = i;
            dr4Var.d = i2;
            dr4Var.e = str;
            dr4Var.f = str2;
            dr4Var.i = i3;
            dr4Var.l = str3;
            dr4Var.n = d;
            dr4Var.j = str5;
            dr4Var.k = str6;
            dr4Var.b = i4;
            dr4Var.o = str7;
            dr4Var.p = str8;
            dr4Var.q = str9;
            if (i == dr4.y) {
                k05.h(TbadkCoreApplication.getInst().getCurrentActivity(), dr4Var).j();
            } else if (i == dr4.z) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                fw4 fw4Var = new fw4(currentActivity);
                if (currentActivity != null) {
                    fw4Var.d(currentActivity, dr4Var);
                    fw4Var.i();
                }
            } else if (i == dr4.A) {
                if (i2 == dr4.E) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), dr4Var.l) && !hi.isEmpty(dr4Var.k)) {
                        c(dr4Var.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                    }
                } else if (i2 == dr4.F && !hi.isEmpty(str6)) {
                    c(dr4Var.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i == dr4.C) {
                Activity a = he6.a(webView.getContext());
                if (i6 == 1 && a != null) {
                    a.finish();
                }
                bj5.i(new TopToastEvent(i5, str, 1500));
            } else if (i == dr4.D) {
                Activity a2 = he6.a(webView.getContext());
                if (i6 == 1 && a2 != null) {
                    a2.finish();
                }
                if (!TextUtils.isEmpty(str)) {
                    BdToastData bdToastData = new BdToastData();
                    bdToastData.parserJson(str);
                    BdToastHelper.toast(bdToastData);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                km9Var.o(jSONObject.toString());
                return km9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return km9Var;
            }
        }
        return (km9) invokeCommon.objValue;
    }

    public km9 g(WebView webView, String str, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            km9 km9Var = new km9();
            Activity a = he6.a(webView.getContext());
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            i3 = 0;
            if (!TextUtils.isEmpty(str) && a != null) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "showToast_" + str3;
                    int n = p45.m().n(str4, 0);
                    if (n < i) {
                        p45.m().z(str4, n);
                        Intent intent = a.getIntent();
                        if (i2 == 1) {
                            z = true;
                        }
                        bj5.i(new TipEvent(intent, str, str2, z));
                    }
                } else {
                    Intent intent2 = a.getIntent();
                    if (i2 == 1) {
                        z2 = true;
                    }
                    bj5.i(new TipEvent(intent2, str, str2, z2));
                }
                if (i2 == 1) {
                    a.finish();
                }
                i3 = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i3);
                km9Var.o(jSONObject.toString());
                return km9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return km9Var;
            }
        }
        return (km9) invokeCommon.objValue;
    }
}
