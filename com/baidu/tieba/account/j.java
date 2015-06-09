package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class j extends Thread {
    final /* synthetic */ AccountActivity awg;
    private String wk;

    public j(AccountActivity accountActivity, String str) {
        this.awg = accountActivity;
        this.wk = null;
        this.wk = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
        aaVar.sX().tS().WD = false;
        aaVar.sX().tS().mIsUseCurrentBDUSS = false;
        aaVar.o("BDUSS", this.wk);
        aaVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        aaVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        aaVar.sw();
    }
}
