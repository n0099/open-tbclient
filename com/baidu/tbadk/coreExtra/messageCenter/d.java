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
    private static d eQK = new d();
    public int eQL = 300;
    public boolean eQM = true;
    public boolean eQN = false;
    public boolean eQO = true;
    public boolean eQP = true;
    public boolean eQQ = true;
    public boolean eQR = true;
    public boolean eQS = false;
    public boolean eQT = true;
    public boolean eQU = true;
    public boolean eQV = false;
    public String eQW = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String eQX = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bsc() {
        return eQK;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dFj();
    }

    public void bsd() {
        com.baidu.tieba.tbadkCore.util.a.bsd();
    }

    public boolean bse() {
        return this.eQL > 0;
    }

    public int bsf() {
        return this.eQL;
    }

    public boolean bsg() {
        return this.eQN;
    }

    public boolean bsh() {
        return this.eQO;
    }

    public boolean bsi() {
        return this.eQR;
    }

    public boolean bsj() {
        return this.eQP;
    }

    public boolean bsk() {
        return this.eQM;
    }

    public boolean bsl() {
        return this.eQT;
    }

    public boolean bsm() {
        return this.eQU;
    }

    public boolean bsn() {
        return this.eQV;
    }

    public boolean bso() {
        return this.eQS;
    }

    public String bsp() {
        return this.eQW;
    }

    public String bsq() {
        return this.eQX;
    }

    private void bsr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void jc(boolean z) {
        this.eQM = z;
        bsr();
    }

    public void qp(int i) {
        if (i == 0) {
            this.eQL = i;
            b.brz().setMsgBookmark(0);
            b.brz().setMsgGiftNum(0);
        } else {
            this.eQL = 300;
        }
        bsr();
    }

    public boolean bss() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void jd(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bsr();
    }

    public boolean bst() {
        return this.eQQ;
    }

    public void je(boolean z) {
        this.eQQ = z;
        bsr();
    }

    public void jf(boolean z) {
        this.eQN = z;
    }

    public void jg(boolean z) {
        this.eQV = z;
    }

    public void Cl(String str) {
        this.eQW = str;
    }

    public void Cm(String str) {
        this.eQX = str;
    }

    public void jh(boolean z) {
        this.eQS = z;
    }

    public void ji(boolean z) {
        this.eQU = z;
    }

    public void jj(boolean z) {
        this.eQT = z;
    }

    public void jk(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bsu() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void jl(boolean z) {
        this.eQP = z;
        bsr();
    }

    public void jm(boolean z) {
        this.eQO = z;
        bsr();
    }

    public void jn(boolean z) {
        this.eQR = z;
        bsr();
    }

    public boolean isSignAlertOn() {
        return f.bsy().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bsy().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bsy().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bsy().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bsy().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bsy().updateSignAlarm();
    }

    public void qq(int i) {
        if (i == 0) {
            jj(false);
            jh(false);
        } else if (i == 1) {
            jj(true);
            jh(false);
        } else if (i == 2) {
            jj(false);
            jh(true);
        } else {
            jj(true);
            jh(true);
        }
    }

    public int bsv() {
        if (!this.eQT && !this.eQS) {
            return 0;
        }
        if (!this.eQT || this.eQS) {
            if (!this.eQT && this.eQS) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void jo(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bsw() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void jp(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean bsx() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
