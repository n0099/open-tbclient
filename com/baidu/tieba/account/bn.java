package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bn implements az {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.tieba.account.az
    public void a(String str) {
    }

    @Override // com.baidu.tieba.account.az
    public void a(AccountData accountData) {
        TiebaApplication.a(accountData, this.a);
        new bo(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.account.az
    public void a(String str, String str2) {
        com.baidu.adp.lib.util.f.e("simon", "onFailure", str2);
        this.a.showToast(R.string.relogin_fail);
        this.a.finish();
    }
}
