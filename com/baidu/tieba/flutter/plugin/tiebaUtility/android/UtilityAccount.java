package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAccountAuto;
import d.b.i0.l.a;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class UtilityAccount implements TiebaUtilityAccountAuto.HostUtilityAccount {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAccountAuto.HostUtilityAccount
    public void goToLogin() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(TbadkCoreApplication.getInst().getContext(), true)));
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAccountAuto.HostUtilityAccount
    public void isLogin(TiebaUtilityAccountAuto.Result<TiebaUtilityAccountAuto.AccountBoolResult> result) {
        TiebaUtilityAccountAuto.AccountBoolResult accountBoolResult = new TiebaUtilityAccountAuto.AccountBoolResult();
        accountBoolResult.setResult(Boolean.valueOf(TbadkCoreApplication.isLogin()));
        result.success(accountBoolResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAccountAuto.HostUtilityAccount
    public void jumpRealNameAuthWebActivity() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        a.q(applicationContext, "", UrlSchemaHelper.REAL_NAME_AUTH_URL + "&u=" + URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW), true, true, true, true, true, false);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAccountAuto.HostUtilityAccount
    public void showLoginAwardCell(TiebaUtilityAccountAuto.Result<TiebaUtilityAccountAuto.AccountBoolResult> result) {
        TiebaUtilityAccountAuto.AccountBoolResult accountBoolResult = new TiebaUtilityAccountAuto.AccountBoolResult();
        accountBoolResult.setResult(Boolean.valueOf(TbadkCoreApplication.getInst().getActivityPrizeData().f()));
        result.success(accountBoolResult);
    }
}
