package com.baidu.tieba.flutter.plugin.tiebautility.android;

import android.content.Context;
import c.a.q0.m.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAccountAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes10.dex */
public class UtilityAccount implements TiebaUtilityAccountAuto.HostUtilityAccount {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityAccount() {
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

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAccountAuto.HostUtilityAccount
    public void goToLogin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(TbadkCoreApplication.getInst().getContext(), true)));
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAccountAuto.HostUtilityAccount
    public void isLogin(TiebaUtilityAccountAuto.Result<TiebaUtilityAccountAuto.AccountBoolResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result) == null) {
            TiebaUtilityAccountAuto.AccountBoolResult accountBoolResult = new TiebaUtilityAccountAuto.AccountBoolResult();
            accountBoolResult.setResult(Boolean.valueOf(TbadkCoreApplication.isLogin()));
            result.success(accountBoolResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAccountAuto.HostUtilityAccount
    public void jumpRealNameAuthWebActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
            a.s(applicationContext, "", UrlSchemaHelper.REAL_NAME_AUTH_URL + "&u=" + URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW), true, true, true, true, true, false);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAccountAuto.HostUtilityAccount
    public void showLoginAwardCell(TiebaUtilityAccountAuto.Result<TiebaUtilityAccountAuto.AccountBoolResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
            TiebaUtilityAccountAuto.AccountBoolResult accountBoolResult = new TiebaUtilityAccountAuto.AccountBoolResult();
            accountBoolResult.setResult(Boolean.valueOf(TbadkCoreApplication.getInst().getActivityPrizeData().f()));
            result.success(accountBoolResult);
        }
    }
}
