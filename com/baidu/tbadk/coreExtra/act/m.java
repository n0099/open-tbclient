package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ LoginActivity aat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LoginActivity loginActivity) {
        this.aat = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void bO(String str) {
        if (this.aat.getLoadingDialog() == null || !this.aat.getLoadingDialog().isShowing()) {
            this.aat.showLoadingDialog(this.aat.getPageContext().getString(y.sapi_logining), new n(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        this.aat.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            com.baidu.adp.lib.g.l.hJ().b(new o(this, accountData));
            TbadkCoreApplication.setCurrentAccount(accountData, this.aat.getBaseContext());
            com.baidu.tbadk.browser.f.U(TbadkCoreApplication.m411getInst());
            this.aat.up();
            return;
        }
        this.aat.f(accountData);
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        this.aat.closeLoadingDialog();
        this.aat.showToast(str2);
        if (com.baidu.adp.lib.util.k.iH()) {
            sapiWebView = this.aat.aao;
            sapiWebView.loadLogin();
        }
    }
}
