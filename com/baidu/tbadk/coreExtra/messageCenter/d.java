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
    private static d fef = new d();
    public int feg = 300;
    public boolean feh = true;
    public boolean fei = false;
    public boolean fej = true;
    public boolean fek = true;
    public boolean fel = true;
    public boolean fem = true;
    public boolean fen = false;
    public boolean feo = true;
    public boolean fep = true;
    public boolean feq = false;
    public String fer = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String fes = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bvL() {
        return fef;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dKS();
    }

    public void bvM() {
        com.baidu.tieba.tbadkCore.util.a.bvM();
    }

    public boolean bvN() {
        return this.feg > 0;
    }

    public int bvO() {
        return this.feg;
    }

    public boolean bvP() {
        return this.fei;
    }

    public boolean bvQ() {
        return this.fej;
    }

    public boolean bvR() {
        return this.fem;
    }

    public boolean bvS() {
        return this.fek;
    }

    public boolean bvT() {
        return this.feh;
    }

    public boolean bvU() {
        return this.feo;
    }

    public boolean bvV() {
        return this.fep;
    }

    public boolean bvW() {
        return this.feq;
    }

    public boolean bvX() {
        return this.fen;
    }

    public String bvY() {
        return this.fer;
    }

    public String bvZ() {
        return this.fes;
    }

    private void bwa() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void jz(boolean z) {
        this.feh = z;
        bwa();
    }

    public void ri(int i) {
        if (i == 0) {
            this.feg = i;
            b.bvi().setMsgBookmark(0);
            b.bvi().setMsgGiftNum(0);
        } else {
            this.feg = 300;
        }
        bwa();
    }

    public boolean bwb() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public void jA(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bwa();
    }

    public boolean bwc() {
        return this.fel;
    }

    public void jB(boolean z) {
        this.fel = z;
        bwa();
    }

    public void jC(boolean z) {
        this.fei = z;
    }

    public void jD(boolean z) {
        this.feq = z;
    }

    public void Cr(String str) {
        this.fer = str;
    }

    public void Cs(String str) {
        this.fes = str;
    }

    public void jE(boolean z) {
        this.fen = z;
    }

    public void jF(boolean z) {
        this.fep = z;
    }

    public void jG(boolean z) {
        this.feo = z;
    }

    public void jH(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bwd() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void jI(boolean z) {
        this.fek = z;
        bwa();
    }

    public void jJ(boolean z) {
        this.fej = z;
        bwa();
    }

    public void jK(boolean z) {
        this.fem = z;
        bwa();
    }

    public boolean isSignAlertOn() {
        return f.bwh().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bwh().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bwh().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bwh().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bwh().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bwh().updateSignAlarm();
    }

    public void rj(int i) {
        if (i == 0) {
            jG(false);
            jE(false);
        } else if (i == 1) {
            jG(true);
            jE(false);
        } else if (i == 2) {
            jG(false);
            jE(true);
        } else {
            jG(true);
            jE(true);
        }
    }

    public int bwe() {
        if (!this.feo && !this.fen) {
            return 0;
        }
        if (!this.feo || this.fen) {
            if (!this.feo && this.fen) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void jL(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bwf() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void jM(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean bwg() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
