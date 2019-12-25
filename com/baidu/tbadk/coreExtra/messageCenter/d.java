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
    private static d djW = new d();
    public int djX = 300;
    public boolean djY = true;
    public boolean djZ = false;
    public boolean dka = true;
    public boolean dkb = true;
    public boolean dkc = true;
    public boolean dkd = true;
    public boolean dke = false;
    public boolean dkf = true;
    public boolean dkg = true;
    public boolean dkh = false;
    public String dki = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String dkj = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aIw() {
        return djW;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cJr();
    }

    public void aIx() {
        com.baidu.tieba.tbadkCore.util.a.aIx();
    }

    public boolean aIy() {
        return this.djX > 0;
    }

    public int aIz() {
        return this.djX;
    }

    public boolean aIA() {
        return this.djZ;
    }

    public boolean aIB() {
        return this.dka;
    }

    public boolean aIC() {
        return this.dkd;
    }

    public boolean aID() {
        return this.dkb;
    }

    public boolean aIE() {
        return this.djY;
    }

    public boolean aIF() {
        return this.dkf;
    }

    public boolean aIG() {
        return this.dkg;
    }

    public boolean aIH() {
        return this.dkh;
    }

    public boolean aII() {
        return this.dke;
    }

    public String aIJ() {
        return this.dki;
    }

    public String aIK() {
        return this.dkj;
    }

    private void aIL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void fM(boolean z) {
        this.djY = z;
        aIL();
    }

    public void ly(int i) {
        if (i == 0) {
            this.djX = i;
            b.aHP().setMsgBookmark(0);
            b.aHP().setMsgGiftNum(0);
            b.aHP().setMsgFans(0);
        } else {
            this.djX = 300;
        }
        aIL();
    }

    public boolean aIM() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void fN(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        aIL();
    }

    public boolean aIN() {
        return this.dkc;
    }

    public void fO(boolean z) {
        this.dkc = z;
        aIL();
    }

    public void fP(boolean z) {
        this.djZ = z;
    }

    public void fQ(boolean z) {
        this.dkh = z;
    }

    public void tT(String str) {
        this.dki = str;
    }

    public void tU(String str) {
        this.dkj = str;
    }

    public void fR(boolean z) {
        this.dke = z;
    }

    public void fS(boolean z) {
        this.dkg = z;
    }

    public void fT(boolean z) {
        this.dkf = z;
    }

    public void fU(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean aIO() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void fV(boolean z) {
        this.dkb = z;
        aIL();
    }

    public void fW(boolean z) {
        this.dka = z;
        aIL();
    }

    public void fX(boolean z) {
        this.dkd = z;
    }

    public boolean isSignAlertOn() {
        return f.aIR().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aIR().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aIR().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aIR().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aIR().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aIR().updateSignAlarm();
    }

    public void lz(int i) {
        if (i == 0) {
            fT(false);
            fR(false);
        } else if (i == 1) {
            fT(true);
            fR(false);
        } else if (i == 2) {
            fT(false);
            fR(true);
        } else {
            fT(true);
            fR(true);
        }
    }

    public int aIP() {
        if (!this.dkf && !this.dke) {
            return 0;
        }
        if (!this.dkf || this.dke) {
            if (!this.dkf && this.dke) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void fY(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aIQ() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
