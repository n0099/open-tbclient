package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class bn implements az {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.tieba.account.az
    public final void a(String str) {
    }

    @Override // com.baidu.tieba.account.az
    public final void a(AccountData accountData) {
        TiebaApplication.a(accountData, this.a);
        new bo(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.account.az
    public final void a(String str, String str2) {
        com.baidu.adp.lib.util.e.e("simon", "onFailure", str2);
        this.a.showToast(R.string.relogin_fail);
        this.a.finish();
    }
}
