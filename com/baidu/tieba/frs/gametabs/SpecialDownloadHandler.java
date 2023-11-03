package com.baidu.tieba.frs.gametabs;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.nda;
import com.baidu.tieba.v35;
import com.baidu.tieba.x35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SpecialDownloadHandler extends NamedBridgeHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v35 mBridge;
    public String mFid;

    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
    public String scope() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_DOWNLOAD_GAME" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialDownloadHandler(v35 v35Var, String str) {
        super(v35Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v35Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((v35) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBridge = v35Var;
        this.mFid = str;
    }

    @x35(isAsync = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("packageName");
        String optString2 = jSONObject.optString("downloadUrl");
        String optString3 = jSONObject.optString("imageUrl");
        if (StringUtils.isNull(optString)) {
            return;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            UtilHelper.showToast(getContext(), (int) R.string.obfuscated_res_0x7f0f0e61);
            return;
        }
        if (StringUtils.isNull(optString2)) {
            jumpAppMarket(optString);
        } else {
            nda.n().E(optString, optString2, optString, 0, nda.o(optString).intValue(), null, true, false, true, optString3, null, null);
        }
        StatisticItem statisticItem = new StatisticItem("c12775");
        if (StringUtils.isNull(this.mFid)) {
            str = "";
        } else {
            str = this.mFid;
        }
        TiebaStatic.log(statisticItem.param("fid", str));
    }

    private void jumpAppMarket(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("market://details?id=" + str));
            try {
                if (!(this.mBridge.f() instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                this.mBridge.f().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
