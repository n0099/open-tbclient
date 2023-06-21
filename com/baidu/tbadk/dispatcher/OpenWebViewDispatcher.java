package com.baidu.tbadk.dispatcher;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.data.JSONLikeSerializable;
import com.baidu.tieba.lq9;
import com.baidu.tieba.mz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OpenWebViewDispatcher implements lq9 {
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

    @Override // com.baidu.tieba.lq9
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
        try {
            Uri parse = Uri.parse(optString);
            if (parse != null) {
                str = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_OPEN_TYPE);
            } else {
                str = null;
            }
            String optString3 = jSONObject.optString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE);
            if (!StringUtils.isNull(optString3)) {
                str = optString3;
            }
            if (!StringUtils.isNull(str)) {
                bundle = new Bundle();
                bundle.putString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE, str);
            } else {
                bundle = null;
            }
            mz4 j = mz4.j(context, optString);
            j.p(optString2);
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
                JSONLikeSerializable jSONLikeSerializable = new JSONLikeSerializable();
                jSONLikeSerializable.parseJsonObject(optJSONObject);
                hashMap.put("initData", jSONLikeSerializable);
                j.f(hashMap);
            }
            j.o();
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
