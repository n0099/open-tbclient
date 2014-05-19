package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
class h extends Thread {
    final /* synthetic */ AccountActivity a;
    private String b;

    public h(AccountActivity accountActivity, String str) {
        this.a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        al alVar = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
        alVar.a().a().b = false;
        alVar.a().a().c = false;
        alVar.a("BDUSS", this.b);
        alVar.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        alVar.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        alVar.i();
    }
}
