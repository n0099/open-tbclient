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
import com.baidu.tieba.ay8;
import com.baidu.tieba.zu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OpenWebViewDispatcher implements ay8 {
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

    @Override // com.baidu.tieba.ay8
    public void dispatch(JSONObject jSONObject, Context context) {
        TbPageContext currentPageContext;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, jSONObject, context) != null) || jSONObject == null || context == null || (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(context)) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(currentPageContext) || StringUtils.isNull(jSONObject.optString("url"))) {
            return;
        }
        String optString = jSONObject.optString("url");
        jSONObject.optString("pageType");
        String optString2 = jSONObject.optString("title");
        boolean optBoolean = jSONObject.optBoolean("navigationBar", true);
        boolean optBoolean2 = jSONObject.optBoolean("cookie", true);
        boolean optBoolean3 = jSONObject.optBoolean("enableJs", true);
        boolean optBoolean4 = jSONObject.optBoolean(WebViewActivityConfig.TAG_ADD_PARMAS, true);
        boolean z = false;
        boolean optBoolean5 = jSONObject.optBoolean("immersiveSticky", false);
        boolean optBoolean6 = jSONObject.optBoolean("fixTitle", false);
        if (jSONObject.optInt(WebViewActivityConfig.TAG_AUTO_PLAY_VIDEO) == 1) {
            z = true;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("bundle");
        try {
            Uri parse = Uri.parse(optString);
            Bundle bundle = null;
            if (parse != null) {
                str = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_OPEN_TYPE);
            } else {
                str = null;
            }
            if (optJSONObject != null) {
                String optString3 = optJSONObject.optString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE);
                if (!StringUtils.isNull(optString3)) {
                    str = optString3;
                }
            }
            if (!StringUtils.isNull(str)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE, str);
                bundle = bundle2;
            }
            zu4.C(context, optString2, optString, optBoolean, optBoolean2, optBoolean3, false, optBoolean4, optBoolean5, optBoolean6, z, bundle);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
