package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAppInfoAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.s.c.n;
import d.a.r0.z0.p0;
/* loaded from: classes5.dex */
public class UtilityAppInfo implements TiebaUtilityAppInfoAuto.HostUtilityAppInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityAppInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAppInfoAuto.HostUtilityAppInfo
    public void getAppVersion(TiebaUtilityAppInfoAuto.Result<TiebaUtilityAppInfoAuto.AppInfoStringResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, result) == null) {
            TiebaUtilityAppInfoAuto.AppInfoStringResult appInfoStringResult = new TiebaUtilityAppInfoAuto.AppInfoStringResult();
            appInfoStringResult.setResult(TbConfig.getVersion());
            result.success(appInfoStringResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAppInfoAuto.HostUtilityAppInfo
    public void getChannelTabInfo(TiebaUtilityAppInfoAuto.Result<TiebaUtilityAppInfoAuto.ChannelTab> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result) == null) {
            TiebaUtilityAppInfoAuto.ChannelTab channelTab = new TiebaUtilityAppInfoAuto.ChannelTab();
            n c2 = TbSingleton.getInstance().getChannelConfigModel().c();
            if (c2 != null) {
                if (!TextUtils.isEmpty(c2.e())) {
                    channelTab.setTid(c2.e());
                }
                if (!TextUtils.isEmpty(c2.d())) {
                    channelTab.setTabCode(c2.d());
                }
                channelTab.setTabType(String.valueOf(c2.a()));
            }
            result.success(channelTab);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAppInfoAuto.HostUtilityAppInfo
    public void getWebViewUserAgent(TiebaUtilityAppInfoAuto.Result<TiebaUtilityAppInfoAuto.AppInfoStringResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, result) == null) {
            TiebaUtilityAppInfoAuto.AppInfoStringResult appInfoStringResult = new TiebaUtilityAppInfoAuto.AppInfoStringResult();
            appInfoStringResult.setResult(p0.b());
            result.success(appInfoStringResult);
        }
    }
}
