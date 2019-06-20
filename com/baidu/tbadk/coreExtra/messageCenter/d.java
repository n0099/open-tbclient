package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d chf = new d();
    public int chg = 300;
    public boolean chh = true;
    public boolean chi = false;
    public boolean chj = true;
    public boolean chk = true;
    public boolean chl = true;
    public boolean chm = true;
    public boolean chn = false;
    public boolean cho = true;
    public boolean chp = true;
    public boolean chq = false;
    public String chr = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String chs = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d anf() {
        return chf;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cnr();
    }

    public void ang() {
        com.baidu.tieba.tbadkCore.util.a.ang();
    }

    public boolean anh() {
        return this.chg > 0;
    }

    public int ani() {
        return this.chg;
    }

    public boolean anj() {
        return this.chi;
    }

    public boolean ank() {
        return this.chj;
    }

    public boolean anl() {
        return this.chm;
    }

    public boolean anm() {
        return this.chk;
    }

    public boolean ann() {
        return this.chh;
    }

    public boolean ano() {
        return this.cho;
    }

    public boolean anp() {
        return this.chp;
    }

    public boolean anq() {
        return this.chq;
    }

    public boolean anr() {
        return this.chn;
    }

    public String ans() {
        return this.chr;
    }

    public String ant() {
        return this.chs;
    }

    private void anu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void ex(boolean z) {
        this.chh = z;
        anu();
    }

    public void jr(int i) {
        if (i == 0) {
            this.chg = i;
            b.amy().setMsgBookmark(0);
            b.amy().setMsgGiftNum(0);
            b.amy().setMsgFans(0);
        } else {
            this.chg = 300;
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
        return this.chl;
    }

    public void ez(boolean z) {
        this.chl = z;
        anu();
    }

    public void eA(boolean z) {
        this.chi = z;
    }

    public void eB(boolean z) {
        this.chq = z;
    }

    public void oV(String str) {
        this.chr = str;
    }

    public void oW(String str) {
        this.chs = str;
    }

    public void eC(boolean z) {
        this.chn = z;
    }

    public void eD(boolean z) {
        this.chp = z;
    }

    public void eE(boolean z) {
        this.cho = z;
    }

    public void eF(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("permit_screen_lock", z);
    }

    public boolean anx() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("permit_screen_lock", true);
    }

    public void eG(boolean z) {
        this.chk = z;
        anu();
    }

    public void eH(boolean z) {
        this.chj = z;
        anu();
    }

    public void eI(boolean z) {
        this.chm = z;
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
        if (!this.cho && !this.chn) {
            return 0;
        }
        if (!this.cho || this.chn) {
            if (!this.cho && this.chn) {
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
