package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ AccountActivity amI;
    private String mBduss;

    public l(AccountActivity accountActivity, String str) {
        this.amI = accountActivity;
        this.mBduss = null;
        this.mBduss = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REGISTER_ADDRESS);
        adVar.oZ().qg().Kx = false;
        adVar.oZ().qg().mIsUseCurrentBDUSS = false;
        adVar.o("BDUSS", this.mBduss);
        adVar.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        adVar.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        adVar.oy();
    }
}
