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
    private static d feX = new d();
    public int feY = 300;
    public boolean feZ = true;
    public boolean ffa = false;
    public boolean ffb = true;
    public boolean ffc = true;
    public boolean ffd = true;
    public boolean ffe = true;
    public boolean fff = false;
    public boolean ffg = true;
    public boolean ffh = true;
    public boolean ffi = false;
    public String ffj = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ffk = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bwv() {
        return feX;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dKT();
    }

    public void bww() {
        com.baidu.tieba.tbadkCore.util.a.bww();
    }

    public boolean bwx() {
        return this.feY > 0;
    }

    public int bwy() {
        return this.feY;
    }

    public boolean bwz() {
        return this.ffa;
    }

    public boolean bwA() {
        return this.ffb;
    }

    public boolean bwB() {
        return this.ffe;
    }

    public boolean bwC() {
        return this.ffc;
    }

    public boolean bwD() {
        return this.feZ;
    }

    public boolean bwE() {
        return this.ffg;
    }

    public boolean bwF() {
        return this.ffh;
    }

    public boolean bwG() {
        return this.ffi;
    }

    public boolean bwH() {
        return this.fff;
    }

    public String bwI() {
        return this.ffj;
    }

    public String bwJ() {
        return this.ffk;
    }

    private void bwK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void jy(boolean z) {
        this.feZ = z;
        bwK();
    }

    public void qK(int i) {
        if (i == 0) {
            this.feY = i;
            b.bvS().setMsgBookmark(0);
            b.bvS().setMsgGiftNum(0);
        } else {
            this.feY = 300;
        }
        bwK();
    }

    public boolean bwL() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public void jz(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bwK();
    }

    public boolean bwM() {
        return this.ffd;
    }

    public void jA(boolean z) {
        this.ffd = z;
        bwK();
    }

    public void jB(boolean z) {
        this.ffa = z;
    }

    public void jC(boolean z) {
        this.ffi = z;
    }

    public void CS(String str) {
        this.ffj = str;
    }

    public void CT(String str) {
        this.ffk = str;
    }

    public void jD(boolean z) {
        this.fff = z;
    }

    public void jE(boolean z) {
        this.ffh = z;
    }

    public void jF(boolean z) {
        this.ffg = z;
    }

    public void jG(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bwN() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void jH(boolean z) {
        this.ffc = z;
        bwK();
    }

    public void jI(boolean z) {
        this.ffb = z;
        bwK();
    }

    public void jJ(boolean z) {
        this.ffe = z;
        bwK();
    }

    public boolean isSignAlertOn() {
        return f.bwR().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bwR().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bwR().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bwR().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bwR().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bwR().updateSignAlarm();
    }

    public void qL(int i) {
        if (i == 0) {
            jF(false);
            jD(false);
        } else if (i == 1) {
            jF(true);
            jD(false);
        } else if (i == 2) {
            jF(false);
            jD(true);
        } else {
            jF(true);
            jD(true);
        }
    }

    public int bwO() {
        if (!this.ffg && !this.fff) {
            return 0;
        }
        if (!this.ffg || this.fff) {
            if (!this.ffg && this.fff) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void jK(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bwP() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void jL(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean bwQ() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
