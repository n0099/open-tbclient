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
    private static d cxb = new d();
    public int cxc = 300;
    public boolean cxd = true;
    public boolean cxe = false;
    public boolean cxf = true;
    public boolean cxg = true;
    public boolean cxh = true;
    public boolean cxi = true;
    public boolean cxj = false;
    public boolean cxk = true;
    public boolean cxl = true;
    public boolean cxm = false;
    public String cxn = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String cxo = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d ara() {
        return cxb;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cpn();
    }

    public void arb() {
        com.baidu.tieba.tbadkCore.util.a.arb();
    }

    public boolean arc() {
        return this.cxc > 0;
    }

    public int ard() {
        return this.cxc;
    }

    public boolean are() {
        return this.cxe;
    }

    public boolean arf() {
        return this.cxf;
    }

    public boolean arg() {
        return this.cxi;
    }

    public boolean arh() {
        return this.cxg;
    }

    public boolean ari() {
        return this.cxd;
    }

    public boolean arj() {
        return this.cxk;
    }

    public boolean ark() {
        return this.cxl;
    }

    public boolean arl() {
        return this.cxm;
    }

    public boolean arm() {
        return this.cxj;
    }

    public String arn() {
        return this.cxn;
    }

    public String aro() {
        return this.cxo;
    }

    private void arp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void eA(boolean z) {
        this.cxd = z;
        arp();
    }

    public void jm(int i) {
        if (i == 0) {
            this.cxc = i;
            b.aqt().setMsgBookmark(0);
            b.aqt().setMsgGiftNum(0);
            b.aqt().setMsgFans(0);
        } else {
            this.cxc = 300;
        }
        arp();
    }

    public boolean arq() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void eB(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        arp();
    }

    public boolean arr() {
        return this.cxh;
    }

    public void eC(boolean z) {
        this.cxh = z;
        arp();
    }

    public void eD(boolean z) {
        this.cxe = z;
    }

    public void eE(boolean z) {
        this.cxm = z;
    }

    public void oQ(String str) {
        this.cxn = str;
    }

    public void oR(String str) {
        this.cxo = str;
    }

    public void eF(boolean z) {
        this.cxj = z;
    }

    public void eG(boolean z) {
        this.cxl = z;
    }

    public void eH(boolean z) {
        this.cxk = z;
    }

    public void eI(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean ars() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void eJ(boolean z) {
        this.cxg = z;
        arp();
    }

    public void eK(boolean z) {
        this.cxf = z;
        arp();
    }

    public void eL(boolean z) {
        this.cxi = z;
    }

    public boolean isSignAlertOn() {
        return f.arv().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.arv().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.arv().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.arv().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.arv().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.arv().updateSignAlarm();
    }

    public void jn(int i) {
        if (i == 0) {
            eH(false);
            eF(false);
        } else if (i == 1) {
            eH(true);
            eF(false);
        } else if (i == 2) {
            eH(false);
            eF(true);
        } else {
            eH(true);
            eF(true);
        }
    }

    public int art() {
        if (!this.cxk && !this.cxj) {
            return 0;
        }
        if (!this.cxk || this.cxj) {
            if (!this.cxk && this.cxj) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void eM(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aru() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
