package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d che = new d();
    public int chf = 300;
    public boolean chg = true;
    public boolean chh = false;
    public boolean chi = true;
    public boolean chj = true;
    public boolean chk = true;
    public boolean chl = true;
    public boolean chm = false;
    public boolean chn = true;
    public boolean cho = true;
    public boolean chp = false;
    public String chq = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String chr = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d anf() {
        return che;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cnq();
    }

    public void ang() {
        com.baidu.tieba.tbadkCore.util.a.ang();
    }

    public boolean anh() {
        return this.chf > 0;
    }

    public int ani() {
        return this.chf;
    }

    public boolean anj() {
        return this.chh;
    }

    public boolean ank() {
        return this.chi;
    }

    public boolean anl() {
        return this.chl;
    }

    public boolean anm() {
        return this.chj;
    }

    public boolean ann() {
        return this.chg;
    }

    public boolean ano() {
        return this.chn;
    }

    public boolean anp() {
        return this.cho;
    }

    public boolean anq() {
        return this.chp;
    }

    public boolean anr() {
        return this.chm;
    }

    public String ans() {
        return this.chq;
    }

    public String ant() {
        return this.chr;
    }

    private void anu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void ex(boolean z) {
        this.chg = z;
        anu();
    }

    public void jr(int i) {
        if (i == 0) {
            this.chf = i;
            b.amy().setMsgBookmark(0);
            b.amy().setMsgGiftNum(0);
            b.amy().setMsgFans(0);
        } else {
            this.chf = 300;
        }
        anu();
    }

    public boolean anv() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void ey(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        anu();
    }

    public boolean anw() {
        return this.chk;
    }

    public void ez(boolean z) {
        this.chk = z;
        anu();
    }

    public void eA(boolean z) {
        this.chh = z;
    }

    public void eB(boolean z) {
        this.chp = z;
    }

    public void oW(String str) {
        this.chq = str;
    }

    public void oX(String str) {
        this.chr = str;
    }

    public void eC(boolean z) {
        this.chm = z;
    }

    public void eD(boolean z) {
        this.cho = z;
    }

    public void eE(boolean z) {
        this.chn = z;
    }

    public void eF(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("permit_screen_lock", z);
    }

    public boolean anx() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("permit_screen_lock", true);
    }

    public void eG(boolean z) {
        this.chj = z;
        anu();
    }

    public void eH(boolean z) {
        this.chi = z;
        anu();
    }

    public void eI(boolean z) {
        this.chl = z;
    }

    public boolean isSignAlertOn() {
        return f.anA().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.anA().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.anA().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.anA().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.anA().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.anA().updateSignAlarm();
    }

    public void js(int i) {
        if (i == 0) {
            eE(false);
            eC(false);
        } else if (i == 1) {
            eE(true);
            eC(false);
        } else if (i == 2) {
            eE(false);
            eC(true);
        } else {
            eE(true);
            eC(true);
        }
    }

    public int any() {
        if (!this.chn && !this.chm) {
            return 0;
        }
        if (!this.chn || this.chm) {
            if (!this.chn && this.chm) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void eJ(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean anz() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
