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
    private static d fsX = new d();
    public int fsY = 300;
    public boolean fsZ = true;
    public boolean fta = false;
    public boolean ftb = true;
    public boolean ftc = true;
    public boolean ftd = true;
    public boolean fte = true;
    public boolean ftf = false;
    public boolean ftg = true;
    public boolean fth = true;
    public boolean fti = false;
    public String ftj = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ftk = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bye() {
        return fsX;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dOJ();
    }

    public void byf() {
        com.baidu.tieba.tbadkCore.util.a.byf();
    }

    public boolean byg() {
        return this.fsY > 0;
    }

    public int byh() {
        return this.fsY;
    }

    public boolean byi() {
        return this.fta;
    }

    public boolean byj() {
        return this.ftb;
    }

    public boolean byk() {
        return this.fte;
    }

    public boolean byl() {
        return this.ftc;
    }

    public boolean bym() {
        return this.fsZ;
    }

    public boolean byn() {
        return this.ftg;
    }

    public boolean byo() {
        return this.fth;
    }

    public boolean byp() {
        return this.fti;
    }

    public boolean byq() {
        return this.ftf;
    }

    public String byr() {
        return this.ftj;
    }

    public String bys() {
        return this.ftk;
    }

    private void byt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void kk(boolean z) {
        this.fsZ = z;
        byt();
    }

    public void qu(int i) {
        if (i == 0) {
            this.fsY = i;
            b.bxB().setMsgBookmark(0);
            b.bxB().setMsgGiftNum(0);
        } else {
            this.fsY = 300;
        }
        byt();
    }

    public boolean byu() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public void kl(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        byt();
    }

    public boolean byv() {
        return this.ftd;
    }

    public void km(boolean z) {
        this.ftd = z;
        byt();
    }

    public void kn(boolean z) {
        this.fta = z;
    }

    public void ko(boolean z) {
        this.fti = z;
    }

    public void Cc(String str) {
        this.ftj = str;
    }

    public void Cd(String str) {
        this.ftk = str;
    }

    public void kp(boolean z) {
        this.ftf = z;
    }

    public void kq(boolean z) {
        this.fth = z;
    }

    public void kr(boolean z) {
        this.ftg = z;
    }

    public void ks(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean byw() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void kt(boolean z) {
        this.ftc = z;
        byt();
    }

    public void ku(boolean z) {
        this.ftb = z;
        byt();
    }

    public void kv(boolean z) {
        this.fte = z;
        byt();
    }

    public boolean isSignAlertOn() {
        return f.byA().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.byA().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.byA().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.byA().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.byA().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.byA().updateSignAlarm();
    }

    public void qv(int i) {
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

    public int byx() {
        if (!this.ftg && !this.ftf) {
            return 0;
        }
        if (!this.ftg || this.ftf) {
            if (!this.ftg && this.ftf) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void kw(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean byy() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void kx(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean byz() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
