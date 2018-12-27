package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class c {
    private static c aPY = new c();
    public int aPZ = 300;
    public boolean aQa = true;
    public boolean aQb = false;
    public boolean aQc = true;
    public boolean aQd = true;
    public boolean aQe = true;
    public boolean aQf = true;
    public boolean aQg = false;
    public boolean aQh = true;
    public boolean aQi = true;
    public boolean aQj = false;
    public String aQk = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aQl = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c Ix() {
        return aPY;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bFd();
    }

    public void Iy() {
        com.baidu.tieba.tbadkCore.util.a.Iy();
    }

    public boolean Iz() {
        return this.aPZ > 0;
    }

    public int IA() {
        return this.aPZ;
    }

    public boolean IB() {
        return this.aQb;
    }

    public boolean IC() {
        return this.aQc;
    }

    public boolean ID() {
        return this.aQf;
    }

    public boolean IE() {
        return this.aQd;
    }

    public boolean IF() {
        return this.aQa;
    }

    public boolean IG() {
        return this.aQh;
    }

    public boolean IH() {
        return this.aQi;
    }

    public boolean II() {
        return this.aQj;
    }

    public boolean IJ() {
        return this.aQg;
    }

    public String IK() {
        return this.aQk;
    }

    public String IL() {
        return this.aQl;
    }

    private void IM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bQ(boolean z) {
        this.aQa = z;
        IM();
    }

    public void eY(int i) {
        if (i == 0) {
            this.aPZ = i;
            a.HQ().setMsgBookmark(0);
            a.HQ().setMsgGiftNum(0);
            a.HQ().setMsgFans(0);
        } else {
            this.aPZ = 300;
        }
        IM();
    }

    public boolean IN() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bR(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        IM();
    }

    public boolean IO() {
        return this.aQe;
    }

    public void bS(boolean z) {
        this.aQe = z;
        IM();
    }

    public void bT(boolean z) {
        this.aQb = z;
    }

    public void bU(boolean z) {
        this.aQj = z;
    }

    public void gM(String str) {
        this.aQk = str;
    }

    public void gN(String str) {
        this.aQl = str;
    }

    public void bV(boolean z) {
        this.aQg = z;
    }

    public void bW(boolean z) {
        this.aQi = z;
    }

    public void bX(boolean z) {
        this.aQh = z;
    }

    public void bY(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean IP() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bZ(boolean z) {
        this.aQd = z;
        IM();
    }

    public void ca(boolean z) {
        this.aQc = z;
        IM();
    }

    public void cb(boolean z) {
        this.aQf = z;
    }

    public boolean isSignAlertOn() {
        return d.IS().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        d.IS().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return d.IS().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return d.IS().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        d.IS().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        d.IS().updateSignAlarm();
    }

    public void eZ(int i) {
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

    public int IQ() {
        if (!this.aQh && !this.aQg) {
            return 0;
        }
        if (!this.aQh || this.aQg) {
            if (!this.aQh && this.aQg) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void cc(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean IR() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
