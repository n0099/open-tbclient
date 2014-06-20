package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
class k extends Thread {
    final /* synthetic */ AccountActivity a;
    private String b;

    public k(AccountActivity accountActivity, String str) {
        this.a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        an anVar = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REGISTER_ADDRESS);
        anVar.a().a().b = false;
        anVar.a().a().c = false;
        anVar.a("BDUSS", this.b);
        anVar.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        anVar.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        anVar.i();
    }
}
