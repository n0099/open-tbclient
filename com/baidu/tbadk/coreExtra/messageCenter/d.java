package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes2.dex */
public class d {
    private static d eCu = new d();
    public int eCv = 300;
    public boolean eCw = true;
    public boolean eCx = false;
    public boolean eCy = true;
    public boolean eCz = true;
    public boolean eCA = true;
    public boolean eCB = true;
    public boolean eCC = false;
    public boolean eCD = true;
    public boolean eCE = true;
    public boolean eCF = false;
    public String eCG = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String eCH = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d boy() {
        return eCu;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dxz();
    }

    public void boz() {
        com.baidu.tieba.tbadkCore.util.a.boz();
    }

    public boolean boA() {
        return this.eCv > 0;
    }

    public int boB() {
        return this.eCv;
    }

    public boolean boC() {
        return this.eCx;
    }

    public boolean boD() {
        return this.eCy;
    }

    public boolean boE() {
        return this.eCB;
    }

    public boolean boF() {
        return this.eCz;
    }

    public boolean boG() {
        return this.eCw;
    }

    public boolean boH() {
        return this.eCD;
    }

    public boolean boI() {
        return this.eCE;
    }

    public boolean boJ() {
        return this.eCF;
    }

    public boolean boK() {
        return this.eCC;
    }

    public String boL() {
        return this.eCG;
    }

    public String boM() {
        return this.eCH;
    }

    private void boN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void iG(boolean z) {
        this.eCw = z;
        boN();
    }

    public void pE(int i) {
        if (i == 0) {
            this.eCv = i;
            b.bnV().setMsgBookmark(0);
            b.bnV().setMsgGiftNum(0);
        } else {
            this.eCv = 300;
        }
        boN();
    }

    public boolean boO() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void iH(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        boN();
    }

    public boolean boP() {
        return this.eCA;
    }

    public void iI(boolean z) {
        this.eCA = z;
        boN();
    }

    public void iJ(boolean z) {
        this.eCx = z;
    }

    public void iK(boolean z) {
        this.eCF = z;
    }

    public void Bc(String str) {
        this.eCG = str;
    }

    public void Bd(String str) {
        this.eCH = str;
    }

    public void iL(boolean z) {
        this.eCC = z;
    }

    public void iM(boolean z) {
        this.eCE = z;
    }

    public void iN(boolean z) {
        this.eCD = z;
    }

    public void iO(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean boQ() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void iP(boolean z) {
        this.eCz = z;
        boN();
    }

    public void iQ(boolean z) {
        this.eCy = z;
        boN();
    }

    public void iR(boolean z) {
        this.eCB = z;
        boN();
    }

    public boolean isSignAlertOn() {
        return f.boT().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.boT().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.boT().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.boT().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.boT().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.boT().updateSignAlarm();
    }

    public void pF(int i) {
        if (i == 0) {
            iN(false);
            iL(false);
        } else if (i == 1) {
            iN(true);
            iL(false);
        } else if (i == 2) {
            iN(false);
            iL(true);
        } else {
            iN(true);
            iL(true);
        }
    }

    public int boR() {
        if (!this.eCD && !this.eCC) {
            return 0;
        }
        if (!this.eCD || this.eCC) {
            if (!this.eCD && this.eCC) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void iS(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean boS() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
