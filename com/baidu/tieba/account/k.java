package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ae;
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
        ae aeVar = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REGISTER_ADDRESS);
        aeVar.a().a().b = false;
        aeVar.a().a().c = false;
        aeVar.a("BDUSS", this.b);
        aeVar.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        aeVar.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        aeVar.h();
    }
}
