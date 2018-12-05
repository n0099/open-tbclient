package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class c {
    private static c aPW = new c();
    public int aPX = 300;
    public boolean aPY = true;
    public boolean aPZ = false;
    public boolean aQa = true;
    public boolean aQb = true;
    public boolean aQc = true;
    public boolean aQd = true;
    public boolean aQe = false;
    public boolean aQf = true;
    public boolean aQg = true;
    public boolean aQh = false;
    public String aQi = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aQj = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c Iw() {
        return aPW;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bEm();
    }

    public void Ix() {
        com.baidu.tieba.tbadkCore.util.a.Ix();
    }

    public boolean Iy() {
        return this.aPX > 0;
    }

    public int Iz() {
        return this.aPX;
    }

    public boolean IA() {
        return this.aPZ;
    }

    public boolean IB() {
        return this.aQa;
    }

    public boolean IC() {
        return this.aQd;
    }

    public boolean ID() {
        return this.aQb;
    }

    public boolean IE() {
        return this.aPY;
    }

    public boolean IF() {
        return this.aQf;
    }

    public boolean IG() {
        return this.aQg;
    }

    public boolean IH() {
        return this.aQh;
    }

    public boolean II() {
        return this.aQe;
    }

    public String IJ() {
        return this.aQi;
    }

    public String IK() {
        return this.aQj;
    }

    private void IL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bQ(boolean z) {
        this.aPY = z;
        IL();
    }

    public void eX(int i) {
        if (i == 0) {
            this.aPX = i;
            a.HP().setMsgBookmark(0);
            a.HP().setMsgGiftNum(0);
            a.HP().setMsgFans(0);
        } else {
            this.aPX = 300;
        }
        IL();
    }

    public boolean IM() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bR(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        IL();
    }

    public boolean IN() {
        return this.aQc;
    }

    public void bS(boolean z) {
        this.aQc = z;
        IL();
    }

    public void bT(boolean z) {
        this.aPZ = z;
    }

    public void bU(boolean z) {
        this.aQh = z;
    }

    public void gL(String str) {
        this.aQi = str;
    }

    public void gM(String str) {
        this.aQj = str;
    }

    public void bV(boolean z) {
        this.aQe = z;
    }

    public void bW(boolean z) {
        this.aQg = z;
    }

    public void bX(boolean z) {
        this.aQf = z;
    }

    public void bY(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean IO() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bZ(boolean z) {
        this.aQb = z;
        IL();
    }

    public void ca(boolean z) {
        this.aQa = z;
        IL();
    }

    public void cb(boolean z) {
        this.aQd = z;
    }

    public boolean isSignAlertOn() {
        return d.IR().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        d.IR().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return d.IR().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return d.IR().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        d.IR().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        d.IR().updateSignAlarm();
    }

    public void eY(int i) {
        if (i == 0) {
            bX(false);
            bV(false);
        } else if (i == 1) {
            bX(true);
            bV(false);
        } else if (i == 2) {
            bX(false);
            bV(true);
        } else {
            bX(true);
            bV(true);
        }
    }

    public int IP() {
        if (!this.aQf && !this.aQe) {
            return 0;
        }
        if (!this.aQf || this.aQe) {
            if (!this.aQf && this.aQe) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void cc(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean IQ() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
