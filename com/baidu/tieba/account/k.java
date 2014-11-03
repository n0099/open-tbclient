package com.baidu.tieba.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class k extends Thread {
    final /* synthetic */ AccountActivity aew;
    private String mBduss;

    public k(AccountActivity accountActivity, String str) {
        this.aew = accountActivity;
        this.mBduss = null;
        this.mBduss = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REGISTER_ADDRESS);
        acVar.mc().na().FU = false;
        acVar.mc().na().mIsUseCurrentBDUSS = false;
        acVar.k("BDUSS", this.mBduss);
        acVar.k("channel_id", TbadkApplication.m251getInst().getPushChannelId());
        acVar.k("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId());
        acVar.lA();
    }
}
