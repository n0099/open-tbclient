package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class i extends Thread {
    final /* synthetic */ AccountActivity auu;
    private String xh;

    public i(AccountActivity accountActivity, String str) {
        this.auu = accountActivity;
        this.xh = null;
        this.xh = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
        aaVar.sp().tp().VU = false;
        aaVar.sp().tp().mIsUseCurrentBDUSS = false;
        aaVar.o("BDUSS", this.xh);
        aaVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        aaVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        aaVar.rO();
    }
}
