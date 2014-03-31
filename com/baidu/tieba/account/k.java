package com.baidu.tieba.account;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class k extends Thread {
    final /* synthetic */ AccountActivity a;
    private String b;

    public k(AccountActivity accountActivity, String str) {
        this.a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/m/register");
        akVar.a().a().b = false;
        akVar.a().a().c = false;
        akVar.a("BDUSS", this.b);
        akVar.a("channel_id", TbadkApplication.j().S());
        akVar.a("channel_uid", TbadkApplication.j().R());
        akVar.i();
    }
}
