package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d cjn = new d();
    public int cjo = 300;
    public boolean cjp = true;
    public boolean cjq = false;
    public boolean cjr = true;
    public boolean cjs = true;
    public boolean cjt = true;
    public boolean cju = true;
    public boolean cjv = false;
    public boolean cjw = true;
    public boolean cjx = true;
    public boolean cjy = false;
    public String cjz = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String cjA = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aoy() {
        return cjn;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cru();
    }

    public void aoz() {
        com.baidu.tieba.tbadkCore.util.a.aoz();
    }

    public boolean aoA() {
        return this.cjo > 0;
    }

    public int aoB() {
        return this.cjo;
    }

    public boolean aoC() {
        return this.cjq;
    }

    public boolean aoD() {
        return this.cjr;
    }

    public boolean aoE() {
        return this.cju;
    }

    public boolean aoF() {
        return this.cjs;
    }

    public boolean aoG() {
        return this.cjp;
    }

    public boolean aoH() {
        return this.cjw;
    }

    public boolean aoI() {
        return this.cjx;
    }

    public boolean aoJ() {
        return this.cjy;
    }

    public boolean aoK() {
        return this.cjv;
    }

    public String aoL() {
        return this.cjz;
    }

    public String aoM() {
        return this.cjA;
    }

    private void aoN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void eE(boolean z) {
        this.cjp = z;
        aoN();
    }

    public void jB(int i) {
        if (i == 0) {
            this.cjo = i;
            b.anR().setMsgBookmark(0);
            b.anR().setMsgGiftNum(0);
            b.anR().setMsgFans(0);
        } else {
            this.cjo = 300;
        }
        aoN();
    }

    public boolean aoO() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void eF(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        aoN();
    }

    public boolean aoP() {
        return this.cjt;
    }

    public void eG(boolean z) {
        this.cjt = z;
        aoN();
    }

    public void eH(boolean z) {
        this.cjq = z;
    }

    public void eI(boolean z) {
        this.cjy = z;
    }

    public void px(String str) {
        this.cjz = str;
    }

    public void py(String str) {
        this.cjA = str;
    }

    public void eJ(boolean z) {
        this.cjv = z;
    }

    public void eK(boolean z) {
        this.cjx = z;
    }

    public void eL(boolean z) {
        this.cjw = z;
    }

    public void eM(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("permit_screen_lock", z);
    }

    public boolean aoQ() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("permit_screen_lock", true);
    }

    public void eN(boolean z) {
        this.cjs = z;
        aoN();
    }

    public void eO(boolean z) {
        this.cjr = z;
        aoN();
    }

    public void eP(boolean z) {
        this.cju = z;
    }

    public boolean isSignAlertOn() {
        return f.aoT().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aoT().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aoT().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aoT().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aoT().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aoT().updateSignAlarm();
    }

    public void jC(int i) {
        if (i == 0) {
            eL(false);
            eJ(false);
        } else if (i == 1) {
            eL(true);
            eJ(false);
        } else if (i == 2) {
            eL(false);
            eJ(true);
        } else {
            eL(true);
            eJ(true);
        }
    }

    public int aoR() {
        if (!this.cjw && !this.cjv) {
            return 0;
        }
        if (!this.cjw || this.cjv) {
            if (!this.cjw && this.cjv) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void eQ(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean aoS() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
