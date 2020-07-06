package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d elQ = new d();
    public int elR = 300;
    public boolean elS = true;
    public boolean elT = false;
    public boolean elU = true;
    public boolean elV = true;
    public boolean elW = true;
    public boolean elX = true;
    public boolean elY = false;
    public boolean elZ = true;
    public boolean ema = true;
    public boolean emb = false;
    public String emc = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String emd = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bbV() {
        return elQ;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.diV();
    }

    public void bbW() {
        com.baidu.tieba.tbadkCore.util.a.bbW();
    }

    public boolean bbX() {
        return this.elR > 0;
    }

    public int bbY() {
        return this.elR;
    }

    public boolean bbZ() {
        return this.elT;
    }

    public boolean bca() {
        return this.elU;
    }

    public boolean bcb() {
        return this.elX;
    }

    public boolean bcc() {
        return this.elV;
    }

    public boolean bcd() {
        return this.elS;
    }

    public boolean bce() {
        return this.elZ;
    }

    public boolean bcf() {
        return this.ema;
    }

    public boolean bcg() {
        return this.emb;
    }

    public boolean bch() {
        return this.elY;
    }

    public String bci() {
        return this.emc;
    }

    public String bcj() {
        return this.emd;
    }

    private void bck() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void hE(boolean z) {
        this.elS = z;
        bck();
    }

    public void nc(int i) {
        if (i == 0) {
            this.elR = i;
            b.bbo().setMsgBookmark(0);
            b.bbo().setMsgGiftNum(0);
            b.bbo().setMsgFans(0);
        } else {
            this.elR = 300;
        }
        bck();
    }

    public boolean bcl() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void hF(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bck();
    }

    public boolean bcm() {
        return this.elW;
    }

    public void hG(boolean z) {
        this.elW = z;
        bck();
    }

    public void hH(boolean z) {
        this.elT = z;
    }

    public void hI(boolean z) {
        this.emb = z;
    }

    public void xG(String str) {
        this.emc = str;
    }

    public void xH(String str) {
        this.emd = str;
    }

    public void hJ(boolean z) {
        this.elY = z;
    }

    public void hK(boolean z) {
        this.ema = z;
    }

    public void hL(boolean z) {
        this.elZ = z;
    }

    public void hM(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bcn() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void hN(boolean z) {
        this.elV = z;
        bck();
    }

    public void hO(boolean z) {
        this.elU = z;
        bck();
    }

    public void hP(boolean z) {
        this.elX = z;
    }

    public boolean isSignAlertOn() {
        return f.bcq().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bcq().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bcq().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bcq().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bcq().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bcq().updateSignAlarm();
    }

    public void nd(int i) {
        if (i == 0) {
            hL(false);
            hJ(false);
        } else if (i == 1) {
            hL(true);
            hJ(false);
        } else if (i == 2) {
            hL(false);
            hJ(true);
        } else {
            hL(true);
            hJ(true);
        }
    }

    public int bco() {
        if (!this.elZ && !this.elY) {
            return 0;
        }
        if (!this.elZ || this.elY) {
            if (!this.elZ && this.elY) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void hQ(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bcp() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
