package com.baidu.tieba.account;

import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity axS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(SapiFastRegActivity sapiFastRegActivity) {
        this.axS = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        this.axS.Fu();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (str != null && !"".equals(str)) {
            this.axS.showToast(str);
        } else {
            this.axS.showToast(com.baidu.tieba.t.data_load_error);
        }
        this.axS.finish();
    }
}
