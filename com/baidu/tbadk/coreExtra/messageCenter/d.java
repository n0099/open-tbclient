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
    private static d eED = new d();
    public int eEE = 300;
    public boolean eEF = true;
    public boolean eEG = false;
    public boolean eEH = true;
    public boolean eEI = true;
    public boolean eEJ = true;
    public boolean eEK = true;
    public boolean eEL = false;
    public boolean eEM = true;
    public boolean eEN = true;
    public boolean eEO = false;
    public String eEP = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String eEQ = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bps() {
        return eED;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dBx();
    }

    public void bpt() {
        com.baidu.tieba.tbadkCore.util.a.bpt();
    }

    public boolean bpu() {
        return this.eEE > 0;
    }

    public int bpv() {
        return this.eEE;
    }

    public boolean bpw() {
        return this.eEG;
    }

    public boolean bpx() {
        return this.eEH;
    }

    public boolean bpy() {
        return this.eEK;
    }

    public boolean bpz() {
        return this.eEI;
    }

    public boolean bpA() {
        return this.eEF;
    }

    public boolean bpB() {
        return this.eEM;
    }

    public boolean bpC() {
        return this.eEN;
    }

    public boolean bpD() {
        return this.eEO;
    }

    public boolean bpE() {
        return this.eEL;
    }

    public String bpF() {
        return this.eEP;
    }

    public String bpG() {
        return this.eEQ;
    }

    private void bpH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void iE(boolean z) {
        this.eEF = z;
        bpH();
    }

    public void pR(int i) {
        if (i == 0) {
            this.eEE = i;
            b.boP().setMsgBookmark(0);
            b.boP().setMsgGiftNum(0);
        } else {
            this.eEE = 300;
        }
        bpH();
    }

    public boolean bpI() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void iF(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bpH();
    }

    public boolean bpJ() {
        return this.eEJ;
    }

    public void iG(boolean z) {
        this.eEJ = z;
        bpH();
    }

    public void iH(boolean z) {
        this.eEG = z;
    }

    public void iI(boolean z) {
        this.eEO = z;
    }

    public void Bz(String str) {
        this.eEP = str;
    }

    public void BA(String str) {
        this.eEQ = str;
    }

    public void iJ(boolean z) {
        this.eEL = z;
    }

    public void iK(boolean z) {
        this.eEN = z;
    }

    public void iL(boolean z) {
        this.eEM = z;
    }

    public void iM(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bpK() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void iN(boolean z) {
        this.eEI = z;
        bpH();
    }

    public void iO(boolean z) {
        this.eEH = z;
        bpH();
    }

    public void iP(boolean z) {
        this.eEK = z;
        bpH();
    }

    public boolean isSignAlertOn() {
        return f.bpO().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bpO().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bpO().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bpO().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bpO().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bpO().updateSignAlarm();
    }

    public void pS(int i) {
        if (i == 0) {
            iL(false);
            iJ(false);
        } else if (i == 1) {
            iL(true);
            iJ(false);
        } else if (i == 2) {
            iL(false);
            iJ(true);
        } else {
            iL(true);
            iJ(true);
        }
    }

    public int bpL() {
        if (!this.eEM && !this.eEL) {
            return 0;
        }
        if (!this.eEM || this.eEL) {
            if (!this.eEM && this.eEL) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void iQ(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bpM() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void iR(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean bpN() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
