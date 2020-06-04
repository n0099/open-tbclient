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
    private static d edi = new d();
    public int edj = 300;
    public boolean edk = true;
    public boolean edl = false;
    public boolean edm = true;
    public boolean edn = true;
    public boolean edo = true;
    public boolean edp = true;
    public boolean edq = false;
    public boolean edr = true;
    public boolean eds = true;
    public boolean edt = false;
    public String edu = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String edv = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aZT() {
        return edi;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.deI();
    }

    public void aZU() {
        com.baidu.tieba.tbadkCore.util.a.aZU();
    }

    public boolean aZV() {
        return this.edj > 0;
    }

    public int aZW() {
        return this.edj;
    }

    public boolean aZX() {
        return this.edl;
    }

    public boolean aZY() {
        return this.edm;
    }

    public boolean aZZ() {
        return this.edp;
    }

    public boolean baa() {
        return this.edn;
    }

    public boolean bab() {
        return this.edk;
    }

    public boolean bac() {
        return this.edr;
    }

    public boolean bad() {
        return this.eds;
    }

    public boolean bae() {
        return this.edt;
    }

    public boolean baf() {
        return this.edq;
    }

    public String bag() {
        return this.edu;
    }

    public String bah() {
        return this.edv;
    }

    private void bai() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void hv(boolean z) {
        this.edk = z;
        bai();
    }

    public void mI(int i) {
        if (i == 0) {
            this.edj = i;
            b.aZm().setMsgBookmark(0);
            b.aZm().setMsgGiftNum(0);
            b.aZm().setMsgFans(0);
        } else {
            this.edj = 300;
        }
        bai();
    }

    public boolean baj() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void hw(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bai();
    }

    public boolean bak() {
        return this.edo;
    }

    public void hx(boolean z) {
        this.edo = z;
        bai();
    }

    public void hy(boolean z) {
        this.edl = z;
    }

    public void hz(boolean z) {
        this.edt = z;
    }

    public void xn(String str) {
        this.edu = str;
    }

    public void xo(String str) {
        this.edv = str;
    }

    public void hA(boolean z) {
        this.edq = z;
    }

    public void hB(boolean z) {
        this.eds = z;
    }

    public void hC(boolean z) {
        this.edr = z;
    }

    public void hD(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bal() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void hE(boolean z) {
        this.edn = z;
        bai();
    }

    public void hF(boolean z) {
        this.edm = z;
        bai();
    }

    public void hG(boolean z) {
        this.edp = z;
    }

    public boolean isSignAlertOn() {
        return f.bao().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bao().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bao().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bao().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bao().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bao().updateSignAlarm();
    }

    public void mJ(int i) {
        if (i == 0) {
            hC(false);
            hA(false);
        } else if (i == 1) {
            hC(true);
            hA(false);
        } else if (i == 2) {
            hC(false);
            hA(true);
        } else {
            hC(true);
            hA(true);
        }
    }

    public int bam() {
        if (!this.edr && !this.edq) {
            return 0;
        }
        if (!this.edr || this.edq) {
            if (!this.edr && this.edq) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void hH(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean ban() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
