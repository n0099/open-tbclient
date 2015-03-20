package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends AuthorizationListener {
    final /* synthetic */ LoginActivity aar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LoginActivity loginActivity) {
        this.aar = loginActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        this.aar.uq();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.aar.showToast(y.data_load_error);
        } else {
            this.aar.showToast(str);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public boolean onForgetPwd() {
        this.aar.startActivity(new Intent(this.aar.getPageContext().getPageActivity(), ForgetPwdActivity.class));
        return true;
    }
}
