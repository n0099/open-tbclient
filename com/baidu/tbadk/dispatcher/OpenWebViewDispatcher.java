package com.baidu.tbadk.dispatcher;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.data.JSONLikeSerializable;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.dx;
import com.baidu.tieba.oma;
import com.baidu.tieba.pu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class OpenWebViewDispatcher implements oma {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String URL_PREFIX = "com.baidu.tieba://unidispatch/tbwebview";
    public transient /* synthetic */ FieldHolder $fh;

    public OpenWebViewDispatcher() {
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

    @NonNull
    public static String assembleH5DialogSchemaUrl(@NonNull String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("openType", 1);
            hashMap.put("disableLoading", 1);
            if (str2 != null) {
                hashMap.put("dialogName", str2);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("page", "h5/openWebView");
            hashMap2.put(YunDialogManager.PAGE_PARAMS_KEY, hashMap);
            return UrlUtils.appendParam("tiebaapp://router/portal", "params", dx.a(DataExt.toJson(hashMap2)));
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.oma
    public void dispatch(JSONObject jSONObject, Context context) {
        TbPageContext currentPageContext;
        String str;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, jSONObject, context) != null) || jSONObject == null || context == null || (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(context)) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(currentPageContext) || StringUtils.isNull(jSONObject.optString("url"))) {
            return;
        }
        String optString = jSONObject.optString("url");
        jSONObject.optString("pageType");
        String optString2 = jSONObject.optString("title");
        boolean z = true;
        boolean optBoolean = jSONObject.optBoolean("navigationBar", true);
        boolean optBoolean2 = jSONObject.optBoolean("cookie", true);
        boolean optBoolean3 = jSONObject.optBoolean("enableJs", true);
        boolean optBoolean4 = jSONObject.optBoolean(WebViewActivityConfig.TAG_ADD_PARMAS, true);
        boolean optBoolean5 = jSONObject.optBoolean("immersiveSticky", false);
        boolean optBoolean6 = jSONObject.optBoolean("fixTitle", false);
        if (jSONObject.optInt(WebViewActivityConfig.TAG_AUTO_PLAY_VIDEO) != 1) {
            z = false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("initData");
        String optString3 = jSONObject.optString("dialogName");
        try {
            Uri parse = Uri.parse(optString);
            if (parse != null) {
                str = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_OPEN_TYPE);
            } else {
                str = null;
            }
            String optString4 = jSONObject.optString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE);
            if (!StringUtils.isNull(optString4)) {
                str = optString4;
            }
            if (!StringUtils.isNull(str)) {
                bundle = new Bundle();
                bundle.putString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE, str);
                if (!TextUtils.isEmpty(optString3) && "1".equals(str)) {
                    bundle.putString(WebViewActivityConfig.TAG_WEB_DIALOG_NAME, optString3);
                    YunDialogManager.markShowingDialogName(optString3);
                }
            } else {
                bundle = null;
            }
            pu4 j = pu4.j(context, optString);
            j.r(optString2);
            j.m(optBoolean);
            j.k(optBoolean2);
            j.c(optBoolean3);
            j.i(false);
            j.g(optBoolean4);
            j.l(optBoolean5);
            j.d(optBoolean6);
            j.h(z);
            j.a(bundle);
            if (optJSONObject != null) {
                HashMap<String, Serializable> hashMap = new HashMap<>();
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = optJSONObject.opt(next);
                    if (opt instanceof JSONObject) {
                        JSONLikeSerializable jSONLikeSerializable = new JSONLikeSerializable();
                        jSONLikeSerializable.parseJsonObject((JSONObject) opt);
                        hashMap.put(next, jSONLikeSerializable);
                    } else if (opt instanceof JSONArray) {
                        JSONLikeSerializable jSONLikeSerializable2 = new JSONLikeSerializable();
                        jSONLikeSerializable2.parseJsonArray((JSONArray) opt);
                        hashMap.put(next, jSONLikeSerializable2);
                    } else if (opt instanceof Serializable) {
                        hashMap.put(next, (Serializable) opt);
                    }
                }
                j.f(hashMap);
            }
            j.p();
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
