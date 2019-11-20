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
    private static d cwk = new d();
    public int cwl = 300;
    public boolean cwm = true;
    public boolean cwn = false;
    public boolean cwo = true;
    public boolean cwp = true;
    public boolean cwq = true;
    public boolean cwr = true;
    public boolean cws = false;
    public boolean cwt = true;
    public boolean cwu = true;
    public boolean cwv = false;
    public String cww = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String cwx = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aqY() {
        return cwk;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cpl();
    }

    public void aqZ() {
        com.baidu.tieba.tbadkCore.util.a.aqZ();
    }

    public boolean ara() {
        return this.cwl > 0;
    }

    public int arb() {
        return this.cwl;
    }

    public boolean arc() {
        return this.cwn;
    }

    public boolean ard() {
        return this.cwo;
    }

    public boolean are() {
        return this.cwr;
    }

    public boolean arf() {
        return this.cwp;
    }

    public boolean arg() {
        return this.cwm;
    }

    public boolean arh() {
        return this.cwt;
    }

    public boolean ari() {
        return this.cwu;
    }

    public boolean arj() {
        return this.cwv;
    }

    public boolean ark() {
        return this.cws;
    }

    public String arl() {
        return this.cww;
    }

    public String arm() {
        return this.cwx;
    }

    private void arn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void eA(boolean z) {
        this.cwm = z;
        arn();
    }

    public void jl(int i) {
        if (i == 0) {
            this.cwl = i;
            b.aqr().setMsgBookmark(0);
            b.aqr().setMsgGiftNum(0);
            b.aqr().setMsgFans(0);
        } else {
            this.cwl = 300;
        }
        arn();
    }

    public boolean aro() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void eB(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        arn();
    }

    public boolean arp() {
        return this.cwq;
    }

    public void eC(boolean z) {
        this.cwq = z;
        arn();
    }

    public void eD(boolean z) {
        this.cwn = z;
    }

    public void eE(boolean z) {
        this.cwv = z;
    }

    public void oQ(String str) {
        this.cww = str;
    }

    public void oR(String str) {
        this.cwx = str;
    }

    public void eF(boolean z) {
        this.cws = z;
    }

    public void eG(boolean z) {
        this.cwu = z;
    }

    public void eH(boolean z) {
        this.cwt = z;
    }

    public void eI(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean arq() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void eJ(boolean z) {
        this.cwp = z;
        arn();
    }

    public void eK(boolean z) {
        this.cwo = z;
        arn();
    }

    public void eL(boolean z) {
        this.cwr = z;
    }

    public boolean isSignAlertOn() {
        return f.art().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.art().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.art().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.art().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.art().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.art().updateSignAlarm();
    }

    public void jm(int i) {
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

    public int arr() {
        if (!this.cwt && !this.cws) {
            return 0;
        }
        if (!this.cwt || this.cws) {
            if (!this.cwt && this.cws) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void eM(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean ars() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
