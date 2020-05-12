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
    private static d dOR = new d();
    public int dOS = 300;
    public boolean dOT = true;
    public boolean dOU = false;
    public boolean dOV = true;
    public boolean dOW = true;
    public boolean dOX = true;
    public boolean dOY = true;
    public boolean dOZ = false;
    public boolean dPa = true;
    public boolean dPb = true;
    public boolean dPc = false;
    public String dPd = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String dPe = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aTL() {
        return dOR;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cXm();
    }

    public void aTM() {
        com.baidu.tieba.tbadkCore.util.a.aTM();
    }

    public boolean aTN() {
        return this.dOS > 0;
    }

    public int aTO() {
        return this.dOS;
    }

    public boolean aTP() {
        return this.dOU;
    }

    public boolean aTQ() {
        return this.dOV;
    }

    public boolean aTR() {
        return this.dOY;
    }

    public boolean aTS() {
        return this.dOW;
    }

    public boolean aTT() {
        return this.dOT;
    }

    public boolean aTU() {
        return this.dPa;
    }

    public boolean aTV() {
        return this.dPb;
    }

    public boolean aTW() {
        return this.dPc;
    }

    public boolean aTX() {
        return this.dOZ;
    }

    public String aTY() {
        return this.dPd;
    }

    public String aTZ() {
        return this.dPe;
    }

    private void aUa() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void gX(boolean z) {
        this.dOT = z;
        aUa();
    }

    public void md(int i) {
        if (i == 0) {
            this.dOS = i;
            b.aTe().setMsgBookmark(0);
            b.aTe().setMsgGiftNum(0);
            b.aTe().setMsgFans(0);
        } else {
            this.dOS = 300;
        }
        aUa();
    }

    public boolean aUb() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void gY(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        aUa();
    }

    public boolean aUc() {
        return this.dOX;
    }

    public void gZ(boolean z) {
        this.dOX = z;
        aUa();
    }

    public void ha(boolean z) {
        this.dOU = z;
    }

    public void hb(boolean z) {
        this.dPc = z;
    }

    public void vH(String str) {
        this.dPd = str;
    }

    public void vI(String str) {
        this.dPe = str;
    }

    public void hc(boolean z) {
        this.dOZ = z;
    }

    public void hd(boolean z) {
        this.dPb = z;
    }

    public void he(boolean z) {
        this.dPa = z;
    }

    public void hf(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean aUd() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void hg(boolean z) {
        this.dOW = z;
        aUa();
    }

    public void hh(boolean z) {
        this.dOV = z;
        aUa();
    }

    public void hi(boolean z) {
        this.dOY = z;
    }

    public boolean isSignAlertOn() {
        return f.aUg().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aUg().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aUg().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aUg().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aUg().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aUg().updateSignAlarm();
    }

    public void me(int i) {
        if (i == 0) {
            he(false);
            hc(false);
        } else if (i == 1) {
            he(true);
            hc(false);
        } else if (i == 2) {
            he(false);
            hc(true);
        } else {
            he(true);
            hc(true);
        }
    }

    public int aUe() {
        if (!this.dPa && !this.dOZ) {
            return 0;
        }
        if (!this.dPa || this.dOZ) {
            if (!this.dPa && this.dOZ) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void hj(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aUf() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
