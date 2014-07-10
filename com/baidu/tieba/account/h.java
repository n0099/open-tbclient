package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aq;
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
        aq aqVar = new aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
        aqVar.a().a().b = false;
        aqVar.a().a().c = false;
        aqVar.a("BDUSS", this.b);
        aqVar.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        aqVar.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        aqVar.i();
    }
}
