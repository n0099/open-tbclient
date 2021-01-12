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
    private static d fqE = new d();
    public int fqF = 300;
    public boolean fqG = true;
    public boolean fqH = false;
    public boolean fqI = true;
    public boolean fqJ = true;
    public boolean fqK = true;
    public boolean fqL = true;
    public boolean fqM = false;
    public boolean fqN = true;
    public boolean fqO = true;
    public boolean fqP = false;
    public String fqQ = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String fqR = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bxM() {
        return fqE;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dMq();
    }

    public void bxN() {
        com.baidu.tieba.tbadkCore.util.a.bxN();
    }

    public boolean bxO() {
        return this.fqF > 0;
    }

    public int bxP() {
        return this.fqF;
    }

    public boolean bxQ() {
        return this.fqH;
    }

    public boolean bxR() {
        return this.fqI;
    }

    public boolean bxS() {
        return this.fqL;
    }

    public boolean bxT() {
        return this.fqJ;
    }

    public boolean bxU() {
        return this.fqG;
    }

    public boolean bxV() {
        return this.fqN;
    }

    public boolean bxW() {
        return this.fqO;
    }

    public boolean bxX() {
        return this.fqP;
    }

    public boolean bxY() {
        return this.fqM;
    }

    public String bxZ() {
        return this.fqQ;
    }

    public String bya() {
        return this.fqR;
    }

    private void byb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void kh(boolean z) {
        this.fqG = z;
        byb();
    }

    public void qp(int i) {
        if (i == 0) {
            this.fqF = i;
            b.bxj().setMsgBookmark(0);
            b.bxj().setMsgGiftNum(0);
        } else {
            this.fqF = 300;
        }
        byb();
    }

    public boolean byc() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public void ki(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        byb();
    }

    public boolean byd() {
        return this.fqK;
    }

    public void kj(boolean z) {
        this.fqK = z;
        byb();
    }

    public void kk(boolean z) {
        this.fqH = z;
    }

    public void kl(boolean z) {
        this.fqP = z;
    }

    public void BL(String str) {
        this.fqQ = str;
    }

    public void BM(String str) {
        this.fqR = str;
    }

    public void km(boolean z) {
        this.fqM = z;
    }

    public void kn(boolean z) {
        this.fqO = z;
    }

    public void ko(boolean z) {
        this.fqN = z;
    }

    public void kp(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bye() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void kq(boolean z) {
        this.fqJ = z;
        byb();
    }

    public void kr(boolean z) {
        this.fqI = z;
        byb();
    }

    public void ks(boolean z) {
        this.fqL = z;
        byb();
    }

    public boolean isSignAlertOn() {
        return f.byi().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.byi().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.byi().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.byi().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.byi().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.byi().updateSignAlarm();
    }

    public void qq(int i) {
        if (i == 0) {
            ko(false);
            km(false);
        } else if (i == 1) {
            ko(true);
            km(false);
        } else if (i == 2) {
            ko(false);
            km(true);
        } else {
            ko(true);
            km(true);
        }
    }

    public int byf() {
        if (!this.fqN && !this.fqM) {
            return 0;
        }
        if (!this.fqN || this.fqM) {
            if (!this.fqN && this.fqM) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void kt(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean byg() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void ku(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean byh() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
