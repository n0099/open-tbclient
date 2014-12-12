package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h extends Thread {
    final /* synthetic */ AccountActivity alO;
    private String mBduss;

    public h(AccountActivity accountActivity, String str) {
        this.alO = accountActivity;
        this.mBduss = null;
        this.mBduss = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/logout");
        adVar.oW().pV().Ke = false;
        adVar.oW().pV().mIsUseCurrentBDUSS = false;
        adVar.o("BDUSS", this.mBduss);
        adVar.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        adVar.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        adVar.ov();
    }
}
