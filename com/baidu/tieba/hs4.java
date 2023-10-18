package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.messageCenter.SignManager;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hs4 implements gh6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int b = 5;
    public static int c = 6;
    public static int d = 7;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947834272, "Lcom/baidu/tieba/hs4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947834272, "Lcom/baidu/tieba/hs4;");
        }
    }

    @Override // com.baidu.tieba.gh6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        fh6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.gh6
    public /* synthetic */ void onDestroy() {
        fh6.b(this);
    }

    public hs4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
    }

    @Override // com.baidu.tieba.gh6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.TOAST_POPUPVIEW.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(h(webView, jSONObject.optInt("show_type"), jSONObject.optInt("ahead_type"), jSONObject.optString("message"), jSONObject.optString("btn_text"), jSONObject.optInt("toast_duration"), jSONObject.optString("schema"), jSONObject.optString("token"), jSONObject.optDouble(NativeConstants.OPACITY), jSONObject.optString(BigdayActivityConfig.IMG_URL), jSONObject.optString("url"), jSONObject.optInt("mission_id"), jSONObject.optString("btn_color"), jSONObject.optString("message_color"), jSONObject.optString("btn_text_color"), jSONObject.optInt("status"), jSONObject.optInt(CommonTbJsBridge.FINISH_THIS_PAGE)).a());
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            } else if (CommonTbJsBridge.SHOW_TIP_TOAST.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(i(webView, jSONObject2.optString("content"), jSONObject2.optString(GameAssistConstKt.KEY_LINKURL), jSONObject2.optString("key"), jSONObject2.optInt("maxTimes"), jSONObject2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE)).a());
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
        TbPageContext<?> d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !ad.isEmpty(str) && (d2 = d(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            UrlManager.getInstance().dealOneLink(d2, new String[]{str});
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
    public ifa e(WebView webView, String str) {
        InterceptResult invokeLL;
        String signInfo;
        JSONObject newGodDataJson;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            ifa ifaVar = new ifa();
            JSONObject jSONObject = null;
            int i = 0;
            try {
                signInfo = SignManager.getInstance().getSignInfo();
                newGodDataJson = TbSingleton.getInstance().getNewGodDataJson();
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (!ad.isEmpty(str)) {
                int indexOf = str.indexOf(WebViewActivityConfig.TAG_NEW_GOD_INVITE);
                if (newGodDataJson != null && indexOf != -1) {
                    jSONObject = newGodDataJson;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                jSONObject2.put(SourceConstant.SOURCE_USER_INFO, jSONObject);
                ifaVar.o(jSONObject2.toString());
                return ifaVar;
            }
            if (!TextUtils.isEmpty(signInfo)) {
                jSONObject = new JSONObject(signInfo);
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("resultCode", i);
            jSONObject22.put(SourceConstant.SOURCE_USER_INFO, jSONObject);
            ifaVar.o(jSONObject22.toString());
            return ifaVar;
            i = 1;
            JSONObject jSONObject222 = new JSONObject();
            jSONObject222.put("resultCode", i);
            jSONObject222.put(SourceConstant.SOURCE_USER_INFO, jSONObject);
            ifaVar.o(jSONObject222.toString());
            return ifaVar;
        }
        return (ifa) invokeLL.objValue;
    }

    public ifa f(@NonNull WebView webView, int i, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048581, this, webView, i, str, str2)) == null) {
            ifa ifaVar = new ifa();
            Activity a = vg6.a(webView.getContext());
            if (a == null || !nt4.d(a, webView, i, str, str2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 0);
                    jSONObject.put("dialogId", str2);
                    ifaVar.o(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return ifaVar;
        }
        return (ifa) invokeLILL.objValue;
    }

    public ifa g(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, hashMap)) == null) {
            ifa ifaVar = new ifa();
            JSONObject jSONObject = new JSONObject();
            gl6.a(jSONObject, "resultCode", hashMap.get("resultCode"));
            gl6.a(jSONObject, "dialogId", hashMap.get("dialogId"));
            gl6.a(jSONObject, "btnId", hashMap.get("btnId"));
            ifaVar.o(jSONObject.toString());
            return ifaVar;
        }
        return (ifa) invokeLL.objValue;
    }

    public ifa h(WebView webView, int i, int i2, String str, String str2, int i3, String str3, String str4, double d2, String str5, String str6, int i4, String str7, String str8, String str9, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{webView, Integer.valueOf(i), Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3, str4, Double.valueOf(d2), str5, str6, Integer.valueOf(i4), str7, str8, str9, Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            ifa ifaVar = new ifa();
            to4 to4Var = new to4();
            to4Var.c = i;
            to4Var.d = i2;
            to4Var.e = str;
            to4Var.f = str2;
            to4Var.i = i3;
            to4Var.l = str3;
            to4Var.n = d2;
            to4Var.j = str5;
            to4Var.k = str6;
            to4Var.b = i4;
            to4Var.o = str7;
            to4Var.p = str8;
            to4Var.q = str9;
            if (i == to4.y) {
                oz4.h(TbadkCoreApplication.getInst().getCurrentActivity(), to4Var).j();
            } else if (i == to4.z) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                fv4 fv4Var = new fv4(currentActivity);
                if (currentActivity != null) {
                    fv4Var.d(currentActivity, to4Var);
                    fv4Var.i();
                }
            } else if (i == to4.A) {
                if (i2 == to4.C) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), to4Var.l) && !ad.isEmpty(to4Var.k)) {
                        c(to4Var.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                    }
                } else if (i2 == to4.D && !ad.isEmpty(str6)) {
                    c(to4Var.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else {
                int i7 = 0;
                if (i == b) {
                    Activity a = vg6.a(webView.getContext());
                    if (i6 == 1 && a != null) {
                        a.finish();
                    }
                    if (System.currentTimeMillis() - this.a < 1500) {
                        i7 = 1500;
                    }
                    this.a = System.currentTimeMillis();
                    MutiProcessManager.publishEvent(new TopToastEvent(i5, str, i7));
                } else if (i == c) {
                    Activity a2 = vg6.a(webView.getContext());
                    if (i6 == 1 && a2 != null) {
                        a2.finish();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        BdToastData bdToastData = new BdToastData();
                        bdToastData.parserJson(str);
                        BdToastHelper.toast(bdToastData);
                    }
                } else if (i == d) {
                    Toast.makeText(vg6.a(webView.getContext()), (int) R.string.too_many_face, 0).show();
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                ifaVar.o(jSONObject.toString());
                return ifaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return ifaVar;
            }
        }
        return (ifa) invokeCommon.objValue;
    }

    public ifa i(WebView webView, String str, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            ifa ifaVar = new ifa();
            Activity a = vg6.a(webView.getContext());
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            i3 = 0;
            if (!TextUtils.isEmpty(str) && a != null) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "showToast_" + str3;
                    int i4 = SharedPrefHelper.getInstance().getInt(str4, 0);
                    if (i4 < i) {
                        SharedPrefHelper.getInstance().putInt(str4, i4);
                        Intent intent = a.getIntent();
                        if (i2 == 1) {
                            z = true;
                        }
                        MutiProcessManager.publishEvent(new TipEvent(intent, str, str2, z));
                    }
                } else {
                    Intent intent2 = a.getIntent();
                    if (i2 == 1) {
                        z2 = true;
                    }
                    MutiProcessManager.publishEvent(new TipEvent(intent2, str, str2, z2));
                }
                if (i2 == 1) {
                    a.finish();
                }
                i3 = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i3);
                ifaVar.o(jSONObject.toString());
                return ifaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return ifaVar;
            }
        }
        return (ifa) invokeCommon.objValue;
    }
}
