package com.baidu.tieba.account;

import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity axT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(SapiFastRegActivity sapiFastRegActivity) {
        this.axT = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        this.axT.Fv();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (str != null && !"".equals(str)) {
            this.axT.showToast(str);
        } else {
            this.axT.showToast(com.baidu.tieba.t.data_load_error);
        }
        this.axT.finish();
    }
}
