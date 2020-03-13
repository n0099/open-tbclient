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
    private static d doH = new d();
    public int doI = 300;
    public boolean doJ = true;
    public boolean doK = false;
    public boolean doL = true;
    public boolean doM = true;
    public boolean doN = true;
    public boolean doO = true;
    public boolean doP = false;
    public boolean doQ = true;
    public boolean doR = true;
    public boolean doS = false;
    public String doT = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String doU = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aLm() {
        return doH;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cLY();
    }

    public void aLn() {
        com.baidu.tieba.tbadkCore.util.a.aLn();
    }

    public boolean aLo() {
        return this.doI > 0;
    }

    public int aLp() {
        return this.doI;
    }

    public boolean aLq() {
        return this.doK;
    }

    public boolean aLr() {
        return this.doL;
    }

    public boolean aLs() {
        return this.doO;
    }

    public boolean aLt() {
        return this.doM;
    }

    public boolean aLu() {
        return this.doJ;
    }

    public boolean aLv() {
        return this.doQ;
    }

    public boolean aLw() {
        return this.doR;
    }

    public boolean aLx() {
        return this.doS;
    }

    public boolean aLy() {
        return this.doP;
    }

    public String aLz() {
        return this.doT;
    }

    public String aLA() {
        return this.doU;
    }

    private void aLB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void fY(boolean z) {
        this.doJ = z;
        aLB();
    }

    public void lP(int i) {
        if (i == 0) {
            this.doI = i;
            b.aKF().setMsgBookmark(0);
            b.aKF().setMsgGiftNum(0);
            b.aKF().setMsgFans(0);
        } else {
            this.doI = 300;
        }
        aLB();
    }

    public boolean aLC() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void fZ(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        aLB();
    }

    public boolean aLD() {
        return this.doN;
    }

    public void ga(boolean z) {
        this.doN = z;
        aLB();
    }

    public void gb(boolean z) {
        this.doK = z;
    }

    public void gc(boolean z) {
        this.doS = z;
    }

    public void uq(String str) {
        this.doT = str;
    }

    public void ur(String str) {
        this.doU = str;
    }

    public void gd(boolean z) {
        this.doP = z;
    }

    public void ge(boolean z) {
        this.doR = z;
    }

    public void gf(boolean z) {
        this.doQ = z;
    }

    public void gg(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean aLE() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void gh(boolean z) {
        this.doM = z;
        aLB();
    }

    public void gi(boolean z) {
        this.doL = z;
        aLB();
    }

    public void gj(boolean z) {
        this.doO = z;
    }

    public boolean isSignAlertOn() {
        return f.aLH().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aLH().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aLH().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aLH().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aLH().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aLH().updateSignAlarm();
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

    public int aLF() {
        if (!this.doQ && !this.doP) {
            return 0;
        }
        if (!this.doQ || this.doP) {
            if (!this.doQ && this.doP) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void gk(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aLG() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
