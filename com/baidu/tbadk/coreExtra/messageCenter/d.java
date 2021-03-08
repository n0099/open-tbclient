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
    private static d fux = new d();
    public int fuy = 300;
    public boolean fuz = true;
    public boolean fuA = false;
    public boolean fuB = true;
    public boolean fuC = true;
    public boolean fuD = true;
    public boolean fuE = true;
    public boolean fuF = false;
    public boolean fuG = true;
    public boolean fuH = true;
    public boolean fuI = false;
    public String fuJ = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String fuK = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d byh() {
        return fux;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dOS();
    }

    public void byi() {
        com.baidu.tieba.tbadkCore.util.a.byi();
    }

    public boolean byj() {
        return this.fuy > 0;
    }

    public int byk() {
        return this.fuy;
    }

    public boolean byl() {
        return this.fuA;
    }

    public boolean bym() {
        return this.fuB;
    }

    public boolean byn() {
        return this.fuE;
    }

    public boolean byo() {
        return this.fuC;
    }

    public boolean byp() {
        return this.fuz;
    }

    public boolean byq() {
        return this.fuG;
    }

    public boolean byr() {
        return this.fuH;
    }

    public boolean bys() {
        return this.fuI;
    }

    public boolean byt() {
        return this.fuF;
    }

    public String byu() {
        return this.fuJ;
    }

    public String byv() {
        return this.fuK;
    }

    private void byw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void kk(boolean z) {
        this.fuz = z;
        byw();
    }

    public void qv(int i) {
        if (i == 0) {
            this.fuy = i;
            b.bxE().setMsgBookmark(0);
            b.bxE().setMsgGiftNum(0);
        } else {
            this.fuy = 300;
        }
        byw();
    }

    public boolean byx() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public void kl(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        byw();
    }

    public boolean byy() {
        return this.fuD;
    }

    public void km(boolean z) {
        this.fuD = z;
        byw();
    }

    public void kn(boolean z) {
        this.fuA = z;
    }

    public void ko(boolean z) {
        this.fuI = z;
    }

    public void Cj(String str) {
        this.fuJ = str;
    }

    public void Ck(String str) {
        this.fuK = str;
    }

    public void kp(boolean z) {
        this.fuF = z;
    }

    public void kq(boolean z) {
        this.fuH = z;
    }

    public void kr(boolean z) {
        this.fuG = z;
    }

    public void ks(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean byz() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void kt(boolean z) {
        this.fuC = z;
        byw();
    }

    public void ku(boolean z) {
        this.fuB = z;
        byw();
    }

    public void kv(boolean z) {
        this.fuE = z;
        byw();
    }

    public boolean isSignAlertOn() {
        return f.byD().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.byD().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.byD().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.byD().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.byD().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.byD().updateSignAlarm();
    }

    public void qw(int i) {
        if (i == 0) {
            kr(false);
            kp(false);
        } else if (i == 1) {
            kr(true);
            kp(false);
        } else if (i == 2) {
            kr(false);
            kp(true);
        } else {
            kr(true);
            kp(true);
        }
    }

    public int byA() {
        if (!this.fuG && !this.fuF) {
            return 0;
        }
        if (!this.fuG || this.fuF) {
            if (!this.fuG && this.fuF) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void kw(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean byB() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void kx(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean byC() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
