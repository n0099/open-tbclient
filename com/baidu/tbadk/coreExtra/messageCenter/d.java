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
    private static d dou = new d();
    public int dov = 300;
    public boolean dow = true;
    public boolean dox = false;
    public boolean doy = true;
    public boolean doz = true;
    public boolean doA = true;
    public boolean doB = true;
    public boolean doC = false;
    public boolean doD = true;
    public boolean doE = true;
    public boolean doF = false;
    public String doG = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String doH = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aLl() {
        return dou;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cLX();
    }

    public void aLm() {
        com.baidu.tieba.tbadkCore.util.a.aLm();
    }

    public boolean aLn() {
        return this.dov > 0;
    }

    public int aLo() {
        return this.dov;
    }

    public boolean aLp() {
        return this.dox;
    }

    public boolean aLq() {
        return this.doy;
    }

    public boolean aLr() {
        return this.doB;
    }

    public boolean aLs() {
        return this.doz;
    }

    public boolean aLt() {
        return this.dow;
    }

    public boolean aLu() {
        return this.doD;
    }

    public boolean aLv() {
        return this.doE;
    }

    public boolean aLw() {
        return this.doF;
    }

    public boolean aLx() {
        return this.doC;
    }

    public String aLy() {
        return this.doG;
    }

    public String aLz() {
        return this.doH;
    }

    private void aLA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void fY(boolean z) {
        this.dow = z;
        aLA();
    }

    public void lP(int i) {
        if (i == 0) {
            this.dov = i;
            b.aKE().setMsgBookmark(0);
            b.aKE().setMsgGiftNum(0);
            b.aKE().setMsgFans(0);
        } else {
            this.dov = 300;
        }
        aLA();
    }

    public boolean aLB() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void fZ(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        aLA();
    }

    public boolean aLC() {
        return this.doA;
    }

    public void ga(boolean z) {
        this.doA = z;
        aLA();
    }

    public void gb(boolean z) {
        this.dox = z;
    }

    public void gc(boolean z) {
        this.doF = z;
    }

    public void up(String str) {
        this.doG = str;
    }

    public void uq(String str) {
        this.doH = str;
    }

    public void gd(boolean z) {
        this.doC = z;
    }

    public void ge(boolean z) {
        this.doE = z;
    }

    public void gf(boolean z) {
        this.doD = z;
    }

    public void gg(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean aLD() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void gh(boolean z) {
        this.doz = z;
        aLA();
    }

    public void gi(boolean z) {
        this.doy = z;
        aLA();
    }

    public void gj(boolean z) {
        this.doB = z;
    }

    public boolean isSignAlertOn() {
        return f.aLG().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aLG().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aLG().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aLG().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aLG().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aLG().updateSignAlarm();
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

    public int aLE() {
        if (!this.doD && !this.doC) {
            return 0;
        }
        if (!this.doD || this.doC) {
            if (!this.doD && this.doC) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void gk(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aLF() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
