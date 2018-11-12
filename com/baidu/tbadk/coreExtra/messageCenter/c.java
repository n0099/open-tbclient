package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class c {
    private static c aMx = new c();
    public int aMy = 300;
    public boolean aMz = true;
    public boolean aMA = false;
    public boolean aMB = true;
    public boolean aMC = true;
    public boolean aMD = true;
    public boolean aME = true;
    public boolean aMF = false;
    public boolean aMG = true;
    public boolean aMH = true;
    public boolean aMI = false;
    public String aMJ = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aMK = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c Hs() {
        return aMx;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bCr();
    }

    public void Ht() {
        com.baidu.tieba.tbadkCore.util.a.Ht();
    }

    public boolean Hu() {
        return this.aMy > 0;
    }

    public int Hv() {
        return this.aMy;
    }

    public boolean Hw() {
        return this.aMA;
    }

    public boolean Hx() {
        return this.aMB;
    }

    public boolean Hy() {
        return this.aME;
    }

    public boolean Hz() {
        return this.aMC;
    }

    public boolean HA() {
        return this.aMz;
    }

    public boolean HB() {
        return this.aMG;
    }

    public boolean HC() {
        return this.aMH;
    }

    public boolean HD() {
        return this.aMI;
    }

    public boolean HE() {
        return this.aMF;
    }

    public String HF() {
        return this.aMJ;
    }

    public String HG() {
        return this.aMK;
    }

    private void HH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bP(boolean z) {
        this.aMz = z;
        HH();
    }

    public void eJ(int i) {
        if (i == 0) {
            this.aMy = i;
            a.GL().setMsgBookmark(0);
            a.GL().setMsgGiftNum(0);
            a.GL().setMsgFans(0);
        } else {
            this.aMy = 300;
        }
        HH();
    }

    public boolean HI() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bQ(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        HH();
    }

    public boolean HJ() {
        return this.aMD;
    }

    public void bR(boolean z) {
        this.aMD = z;
        HH();
    }

    public void bS(boolean z) {
        this.aMA = z;
    }

    public void bT(boolean z) {
        this.aMI = z;
    }

    public void gt(String str) {
        this.aMJ = str;
    }

    public void gu(String str) {
        this.aMK = str;
    }

    public void bU(boolean z) {
        this.aMF = z;
    }

    public void bV(boolean z) {
        this.aMH = z;
    }

    public void bW(boolean z) {
        this.aMG = z;
    }

    public void bX(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean HK() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bY(boolean z) {
        this.aMC = z;
        HH();
    }

    public void bZ(boolean z) {
        this.aMB = z;
        HH();
    }

    public void ca(boolean z) {
        this.aME = z;
    }

    public boolean isSignAlertOn() {
        return d.HN().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        d.HN().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return d.HN().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return d.HN().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        d.HN().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        d.HN().updateSignAlarm();
    }

    public void eK(int i) {
        if (i == 0) {
            bW(false);
            bU(false);
        } else if (i == 1) {
            bW(true);
            bU(false);
        } else if (i == 2) {
            bW(false);
            bU(true);
        } else {
            bW(true);
            bU(true);
        }
    }

    public int HL() {
        if (!this.aMG && !this.aMF) {
            return 0;
        }
        if (!this.aMG || this.aMF) {
            if (!this.aMG && this.aMF) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void cb(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean HM() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
