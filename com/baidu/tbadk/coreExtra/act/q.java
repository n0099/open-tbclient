package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends AuthorizationListener {
    final /* synthetic */ LoginActivity abx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LoginActivity loginActivity) {
        this.abx = loginActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        this.abx.uZ();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.abx.showToast(com.baidu.tieba.t.data_load_error);
        } else {
            this.abx.showToast(str);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public boolean onForgetPwd() {
        this.abx.startActivity(new Intent(this.abx.getPageContext().getPageActivity(), ForgetPwdActivity.class));
        return true;
    }
}
