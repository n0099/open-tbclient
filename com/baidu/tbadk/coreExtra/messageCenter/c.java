package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class c {
    private static c aHe = new c();
    public int aHf = 300;
    public boolean aHg = true;
    public boolean aHh = false;
    public boolean aHi = true;
    public boolean aHj = true;
    public boolean aHk = true;
    public boolean aHl = true;
    public boolean aHm = false;
    public boolean aHn = true;
    public boolean aHo = true;
    public boolean aHp = false;
    public String aHq = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aHr = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c Ff() {
        return aHe;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bzH();
    }

    public void Fg() {
        com.baidu.tieba.tbadkCore.util.a.Fg();
    }

    public boolean Fh() {
        return this.aHf > 0;
    }

    public int Fi() {
        return this.aHf;
    }

    public boolean Fj() {
        return this.aHh;
    }

    public boolean Fk() {
        return this.aHi;
    }

    public boolean Fl() {
        return this.aHl;
    }

    public boolean Fm() {
        return this.aHj;
    }

    public boolean Fn() {
        return this.aHg;
    }

    public boolean Fo() {
        return this.aHn;
    }

    public boolean Fp() {
        return this.aHo;
    }

    public boolean Fq() {
        return this.aHp;
    }

    public boolean Fr() {
        return this.aHm;
    }

    public String Fs() {
        return this.aHq;
    }

    public String Ft() {
        return this.aHr;
    }

    private void Fu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bp(boolean z) {
        this.aHg = z;
        Fu();
    }

    public void em(int i) {
        if (i == 0) {
            this.aHf = i;
            a.Ey().setMsgBookmark(0);
            a.Ey().setMsgGiftNum(0);
            a.Ey().setMsgFans(0);
        } else {
            this.aHf = 300;
        }
        Fu();
    }

    public boolean Fv() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bq(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        Fu();
    }

    public boolean Fw() {
        return this.aHk;
    }

    public void br(boolean z) {
        this.aHk = z;
        Fu();
    }

    public void bs(boolean z) {
        this.aHh = z;
    }

    public void bt(boolean z) {
        this.aHp = z;
    }

    public void gd(String str) {
        this.aHq = str;
    }

    public void ge(String str) {
        this.aHr = str;
    }

    public void bu(boolean z) {
        this.aHm = z;
    }

    public void bv(boolean z) {
        this.aHo = z;
    }

    public void bw(boolean z) {
        this.aHn = z;
    }

    public void bx(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean Fx() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void by(boolean z) {
        this.aHj = z;
        Fu();
    }

    public void bz(boolean z) {
        this.aHi = z;
        Fu();
    }

    public void bA(boolean z) {
        this.aHl = z;
    }

    public boolean isSignAlertOn() {
        return d.FA().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        d.FA().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return d.FA().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return d.FA().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        d.FA().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        d.FA().updateSignAlarm();
    }

    public void en(int i) {
        if (i == 0) {
            bw(false);
            bu(false);
        } else if (i == 1) {
            bw(true);
            bu(false);
        } else if (i == 2) {
            bw(false);
            bu(true);
        } else {
            bw(true);
            bu(true);
        }
    }

    public int Fy() {
        if (!this.aHn && !this.aHm) {
            return 0;
        }
        if (!this.aHn || this.aHm) {
            if (!this.aHn && this.aHm) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bB(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean Fz() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
