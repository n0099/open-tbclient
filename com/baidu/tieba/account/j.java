package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class j extends Thread {
    final /* synthetic */ AccountActivity amF;
    private String mBduss;

    public j(AccountActivity accountActivity, String str) {
        this.amF = accountActivity;
        this.mBduss = null;
        this.mBduss = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
        adVar.oS().pZ().Ku = false;
        adVar.oS().pZ().mIsUseCurrentBDUSS = false;
        adVar.o("BDUSS", this.mBduss);
        adVar.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        adVar.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        adVar.or();
    }
}
