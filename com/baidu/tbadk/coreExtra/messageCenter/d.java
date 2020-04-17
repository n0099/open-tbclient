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
    private static d dOM = new d();
    public int dON = 300;
    public boolean dOO = true;
    public boolean dOP = false;
    public boolean dOQ = true;
    public boolean dOR = true;
    public boolean dOS = true;
    public boolean dOT = true;
    public boolean dOU = false;
    public boolean dOV = true;
    public boolean dOW = true;
    public boolean dOX = false;
    public String dOY = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String dOZ = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aTN() {
        return dOM;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cXo();
    }

    public void aTO() {
        com.baidu.tieba.tbadkCore.util.a.aTO();
    }

    public boolean aTP() {
        return this.dON > 0;
    }

    public int aTQ() {
        return this.dON;
    }

    public boolean aTR() {
        return this.dOP;
    }

    public boolean aTS() {
        return this.dOQ;
    }

    public boolean aTT() {
        return this.dOT;
    }

    public boolean aTU() {
        return this.dOR;
    }

    public boolean aTV() {
        return this.dOO;
    }

    public boolean aTW() {
        return this.dOV;
    }

    public boolean aTX() {
        return this.dOW;
    }

    public boolean aTY() {
        return this.dOX;
    }

    public boolean aTZ() {
        return this.dOU;
    }

    public String aUa() {
        return this.dOY;
    }

    public String aUb() {
        return this.dOZ;
    }

    private void aUc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void gX(boolean z) {
        this.dOO = z;
        aUc();
    }

    public void md(int i) {
        if (i == 0) {
            this.dON = i;
            b.aTg().setMsgBookmark(0);
            b.aTg().setMsgGiftNum(0);
            b.aTg().setMsgFans(0);
        } else {
            this.dON = 300;
        }
        aUc();
    }

    public boolean aUd() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void gY(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        aUc();
    }

    public boolean aUe() {
        return this.dOS;
    }

    public void gZ(boolean z) {
        this.dOS = z;
        aUc();
    }

    public void ha(boolean z) {
        this.dOP = z;
    }

    public void hb(boolean z) {
        this.dOX = z;
    }

    public void vE(String str) {
        this.dOY = str;
    }

    public void vF(String str) {
        this.dOZ = str;
    }

    public void hc(boolean z) {
        this.dOU = z;
    }

    public void hd(boolean z) {
        this.dOW = z;
    }

    public void he(boolean z) {
        this.dOV = z;
    }

    public void hf(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean aUf() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void hg(boolean z) {
        this.dOR = z;
        aUc();
    }

    public void hh(boolean z) {
        this.dOQ = z;
        aUc();
    }

    public void hi(boolean z) {
        this.dOT = z;
    }

    public boolean isSignAlertOn() {
        return f.aUi().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aUi().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aUi().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aUi().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aUi().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aUi().updateSignAlarm();
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

    public int aUg() {
        if (!this.dOV && !this.dOU) {
            return 0;
        }
        if (!this.dOV || this.dOU) {
            if (!this.dOV && this.dOU) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void hj(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aUh() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
