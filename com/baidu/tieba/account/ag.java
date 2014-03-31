package com.baidu.tieba.account;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class ag implements com.baidu.tbadk.core.a.u {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(String str) {
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(AccountData accountData) {
        TbadkApplication.a(accountData, this.a);
        new ah(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(String str, String str2) {
        com.baidu.adp.lib.util.f.e("simon", "onFailure", str2);
        this.a.showToast(com.baidu.tieba.a.k.relogin_fail);
        this.a.finish();
    }
}
