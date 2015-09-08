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
    final /* synthetic */ LoginActivity agO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.agO = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cc(String str) {
        if (this.agO.getLoadingDialog() == null || !this.agO.getLoadingDialog().isShowing()) {
            this.agO.showLoadingDialog(this.agO.getPageContext().getString(i.h.sapi_logining), new o(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.agO.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            j(accountData);
            this.agO.wm();
            i = this.agO.mFrom;
            if (i != 4) {
                this.agO.wh();
                return;
            } else {
                this.agO.wo();
                return;
            }
        }
        this.agO.f(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.agO.closeLoadingDialog();
        this.agO.showToast(str2);
        if (com.baidu.adp.lib.util.i.iL()) {
            sapiWebView = this.agO.agG;
            if (sapiWebView != null) {
                sapiWebView2 = this.agO.agG;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void j(AccountData accountData) {
        com.baidu.adp.lib.g.k.hg().b(new p(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.agO.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.g.W(TbadkCoreApplication.m411getInst());
    }
}
