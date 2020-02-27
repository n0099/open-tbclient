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
    private static d dos = new d();
    public int dou = 300;
    public boolean dov = true;
    public boolean dow = false;
    public boolean dox = true;
    public boolean doy = true;
    public boolean doz = true;
    public boolean doA = true;
    public boolean doB = false;
    public boolean doC = true;
    public boolean doD = true;
    public boolean doE = false;
    public String doF = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String doG = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aLj() {
        return dos;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cLV();
    }

    public void aLk() {
        com.baidu.tieba.tbadkCore.util.a.aLk();
    }

    public boolean aLl() {
        return this.dou > 0;
    }

    public int aLm() {
        return this.dou;
    }

    public boolean aLn() {
        return this.dow;
    }

    public boolean aLo() {
        return this.dox;
    }

    public boolean aLp() {
        return this.doA;
    }

    public boolean aLq() {
        return this.doy;
    }

    public boolean aLr() {
        return this.dov;
    }

    public boolean aLs() {
        return this.doC;
    }

    public boolean aLt() {
        return this.doD;
    }

    public boolean aLu() {
        return this.doE;
    }

    public boolean aLv() {
        return this.doB;
    }

    public String aLw() {
        return this.doF;
    }

    public String aLx() {
        return this.doG;
    }

    private void aLy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void fY(boolean z) {
        this.dov = z;
        aLy();
    }

    public void lP(int i) {
        if (i == 0) {
            this.dou = i;
            b.aKC().setMsgBookmark(0);
            b.aKC().setMsgGiftNum(0);
            b.aKC().setMsgFans(0);
        } else {
            this.dou = 300;
        }
        aLy();
    }

    public boolean aLz() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void fZ(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        aLy();
    }

    public boolean aLA() {
        return this.doz;
    }

    public void ga(boolean z) {
        this.doz = z;
        aLy();
    }

    public void gb(boolean z) {
        this.dow = z;
    }

    public void gc(boolean z) {
        this.doE = z;
    }

    public void up(String str) {
        this.doF = str;
    }

    public void uq(String str) {
        this.doG = str;
    }

    public void gd(boolean z) {
        this.doB = z;
    }

    public void ge(boolean z) {
        this.doD = z;
    }

    public void gf(boolean z) {
        this.doC = z;
    }

    public void gg(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean aLB() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void gh(boolean z) {
        this.doy = z;
        aLy();
    }

    public void gi(boolean z) {
        this.dox = z;
        aLy();
    }

    public void gj(boolean z) {
        this.doA = z;
    }

    public boolean isSignAlertOn() {
        return f.aLE().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aLE().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aLE().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aLE().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aLE().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aLE().updateSignAlarm();
    }

    public void lQ(int i) {
        if (i == 0) {
            gf(false);
            gd(false);
        } else if (i == 1) {
            gf(true);
            gd(false);
        } else if (i == 2) {
            gf(false);
            gd(true);
        } else {
            gf(true);
            gd(true);
        }
    }

    public int aLC() {
        if (!this.doC && !this.doB) {
            return 0;
        }
        if (!this.doC || this.doB) {
            if (!this.doC && this.doB) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void gk(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aLD() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
