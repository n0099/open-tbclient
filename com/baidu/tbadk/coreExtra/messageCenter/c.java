package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class c {
    private static c aLH = new c();
    public int aLI = 300;
    public boolean aLJ = true;
    public boolean aLK = false;
    public boolean aLL = true;
    public boolean aLM = true;
    public boolean aLN = true;
    public boolean aLO = true;
    public boolean aLP = false;
    public boolean aLQ = true;
    public boolean aLR = true;
    public boolean aLS = false;
    public String aLT = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aLU = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c Hg() {
        return aLH;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bCW();
    }

    public void Hh() {
        com.baidu.tieba.tbadkCore.util.a.Hh();
    }

    public boolean Hi() {
        return this.aLI > 0;
    }

    public int Hj() {
        return this.aLI;
    }

    public boolean Hk() {
        return this.aLK;
    }

    public boolean Hl() {
        return this.aLL;
    }

    public boolean Hm() {
        return this.aLO;
    }

    public boolean Hn() {
        return this.aLM;
    }

    public boolean Ho() {
        return this.aLJ;
    }

    public boolean Hp() {
        return this.aLQ;
    }

    public boolean Hq() {
        return this.aLR;
    }

    public boolean Hr() {
        return this.aLS;
    }

    public boolean Hs() {
        return this.aLP;
    }

    public String Ht() {
        return this.aLT;
    }

    public String Hu() {
        return this.aLU;
    }

    private void Hv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void by(boolean z) {
        this.aLJ = z;
        Hv();
    }

    public void ev(int i) {
        if (i == 0) {
            this.aLI = i;
            a.Gz().setMsgBookmark(0);
            a.Gz().setMsgGiftNum(0);
            a.Gz().setMsgFans(0);
        } else {
            this.aLI = 300;
        }
        Hv();
    }

    public boolean Hw() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bz(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        Hv();
    }

    public boolean Hx() {
        return this.aLN;
    }

    public void bA(boolean z) {
        this.aLN = z;
        Hv();
    }

    public void bB(boolean z) {
        this.aLK = z;
    }

    public void bC(boolean z) {
        this.aLS = z;
    }

    public void gr(String str) {
        this.aLT = str;
    }

    public void gt(String str) {
        this.aLU = str;
    }

    public void bD(boolean z) {
        this.aLP = z;
    }

    public void bE(boolean z) {
        this.aLR = z;
    }

    public void bF(boolean z) {
        this.aLQ = z;
    }

    public void bG(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean Hy() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bH(boolean z) {
        this.aLM = z;
        Hv();
    }

    public void bI(boolean z) {
        this.aLL = z;
        Hv();
    }

    public void bJ(boolean z) {
        this.aLO = z;
    }

    public boolean isSignAlertOn() {
        return d.HB().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        d.HB().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return d.HB().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return d.HB().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        d.HB().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        d.HB().updateSignAlarm();
    }

    public void ew(int i) {
        if (i == 0) {
            bF(false);
            bD(false);
        } else if (i == 1) {
            bF(true);
            bD(false);
        } else if (i == 2) {
            bF(false);
            bD(true);
        } else {
            bF(true);
            bD(true);
        }
    }

    public int Hz() {
        if (!this.aLQ && !this.aLP) {
            return 0;
        }
        if (!this.aLQ || this.aLP) {
            if (!this.aLQ && this.aLP) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bK(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean HA() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
