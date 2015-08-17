package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.InterfaceC0040a {
    final /* synthetic */ LoginActivity agE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.agE = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cb(String str) {
        if (this.agE.getLoadingDialog() == null || !this.agE.getLoadingDialog().isShowing()) {
            this.agE.showLoadingDialog(this.agE.getPageContext().getString(i.C0057i.sapi_logining), new o(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.agE.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            k(accountData);
            this.agE.wh();
            i = this.agE.mFrom;
            if (i != 4) {
                this.agE.wc();
                return;
            } else {
                this.agE.wj();
                return;
            }
        }
        this.agE.f(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.agE.closeLoadingDialog();
        this.agE.showToast(str2);
        if (com.baidu.adp.lib.util.i.iO()) {
            sapiWebView = this.agE.agw;
            if (sapiWebView != null) {
                sapiWebView2 = this.agE.agw;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void k(AccountData accountData) {
        com.baidu.adp.lib.g.k.hj().b(new p(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.agE.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.W(TbadkCoreApplication.m411getInst());
    }
}
