package com.baidu.tieba.aiapps.apps.dispatcher;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.oma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class WeChatMiniProgramDispatcher implements oma {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PACKAGE_NAME_WECHAT = "com.tencent.mm";
    public transient /* synthetic */ FieldHolder $fh;

    public WeChatMiniProgramDispatcher() {
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

    @Override // com.baidu.tieba.oma
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            if (!UtilHelper.isInstallApk(context, "com.tencent.mm")) {
                BdToast.makeText(context, context.getText(R.string.tie_plus_wechat_not_install)).show();
                return;
            }
            String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
            String optString2 = jSONObject.optString("path");
            int optInt = jSONObject.optInt("miniProgramType", 0);
            if (StringUtils.isNotNull(optString)) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, TbConfig.WEIXIN_APP_ID);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = optString;
                if (StringUtils.isNotNull(optString2)) {
                    req.path = optString2;
                }
                req.miniprogramType = optInt;
                createWXAPI.sendReq(req);
            }
        }
    }
}
