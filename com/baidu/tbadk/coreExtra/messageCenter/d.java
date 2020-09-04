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
    private static d eCy = new d();
    public int eCz = 300;
    public boolean eCA = true;
    public boolean eCB = false;
    public boolean eCC = true;
    public boolean eCD = true;
    public boolean eCE = true;
    public boolean eCF = true;
    public boolean eCG = false;
    public boolean eCH = true;
    public boolean eCI = true;
    public boolean eCJ = false;
    public String eCK = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String eCL = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d boy() {
        return eCy;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dxE();
    }

    public void boz() {
        com.baidu.tieba.tbadkCore.util.a.boz();
    }

    public boolean boA() {
        return this.eCz > 0;
    }

    public int boB() {
        return this.eCz;
    }

    public boolean boC() {
        return this.eCB;
    }

    public boolean boD() {
        return this.eCC;
    }

    public boolean boE() {
        return this.eCF;
    }

    public boolean boF() {
        return this.eCD;
    }

    public boolean boG() {
        return this.eCA;
    }

    public boolean boH() {
        return this.eCH;
    }

    public boolean boI() {
        return this.eCI;
    }

    public boolean boJ() {
        return this.eCJ;
    }

    public boolean boK() {
        return this.eCG;
    }

    public String boL() {
        return this.eCK;
    }

    public String boM() {
        return this.eCL;
    }

    private void boN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void iH(boolean z) {
        this.eCA = z;
        boN();
    }

    public void pE(int i) {
        if (i == 0) {
            this.eCz = i;
            b.bnV().setMsgBookmark(0);
            b.bnV().setMsgGiftNum(0);
        } else {
            this.eCz = 300;
        }
        boN();
    }

    public boolean boO() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void iI(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        boN();
    }

    public boolean boP() {
        return this.eCE;
    }

    public void iJ(boolean z) {
        this.eCE = z;
        boN();
    }

    public void iK(boolean z) {
        this.eCB = z;
    }

    public void iL(boolean z) {
        this.eCJ = z;
    }

    public void Bd(String str) {
        this.eCK = str;
    }

    public void Be(String str) {
        this.eCL = str;
    }

    public void iM(boolean z) {
        this.eCG = z;
    }

    public void iN(boolean z) {
        this.eCI = z;
    }

    public void iO(boolean z) {
        this.eCH = z;
    }

    public void iP(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean boQ() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void iQ(boolean z) {
        this.eCD = z;
        boN();
    }

    public void iR(boolean z) {
        this.eCC = z;
        boN();
    }

    public void iS(boolean z) {
        this.eCF = z;
        boN();
    }

    public boolean isSignAlertOn() {
        return f.boU().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.boU().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.boU().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.boU().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.boU().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.boU().updateSignAlarm();
    }

    public void pF(int i) {
        if (i == 0) {
            iO(false);
            iM(false);
        } else if (i == 1) {
            iO(true);
            iM(false);
        } else if (i == 2) {
            iO(false);
            iM(true);
        } else {
            iO(true);
            iM(true);
        }
    }

    public int boR() {
        if (!this.eCH && !this.eCG) {
            return 0;
        }
        if (!this.eCH || this.eCG) {
            if (!this.eCH && this.eCG) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void iT(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean boS() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void iU(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean boT() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
