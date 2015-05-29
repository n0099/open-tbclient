package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ LoginActivity abx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LoginActivity loginActivity) {
        this.abx = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
        if (this.abx.getLoadingDialog() == null || !this.abx.getLoadingDialog().isShowing()) {
            this.abx.showLoadingDialog(this.abx.getPageContext().getString(com.baidu.tieba.t.sapi_logining), new n(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        this.abx.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            com.baidu.adp.lib.g.l.ht().b(new o(this, accountData));
            TbadkCoreApplication.setCurrentAccount(accountData, this.abx.getBaseContext());
            com.baidu.tbadk.browser.f.U(TbadkCoreApplication.m411getInst());
            this.abx.vb();
            this.abx.uY();
            return;
        }
        this.abx.f(accountData);
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        this.abx.closeLoadingDialog();
        this.abx.showToast(str2);
        if (com.baidu.adp.lib.util.k.iX()) {
            sapiWebView = this.abx.abp;
            sapiWebView.loadLogin();
        }
    }
}
