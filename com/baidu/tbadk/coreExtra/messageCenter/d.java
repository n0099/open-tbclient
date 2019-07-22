package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d cil = new d();
    public int cim = 300;
    public boolean cin = true;
    public boolean cio = false;
    public boolean cip = true;
    public boolean ciq = true;
    public boolean cir = true;
    public boolean cis = true;
    public boolean cit = false;
    public boolean ciu = true;
    public boolean civ = true;
    public boolean ciw = false;
    public String cix = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ciy = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aok() {
        return cil;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cqk();
    }

    public void aol() {
        com.baidu.tieba.tbadkCore.util.a.aol();
    }

    public boolean aom() {
        return this.cim > 0;
    }

    public int aon() {
        return this.cim;
    }

    public boolean aoo() {
        return this.cio;
    }

    public boolean aop() {
        return this.cip;
    }

    public boolean aoq() {
        return this.cis;
    }

    public boolean aor() {
        return this.ciq;
    }

    public boolean aos() {
        return this.cin;
    }

    public boolean aot() {
        return this.ciu;
    }

    public boolean aou() {
        return this.civ;
    }

    public boolean aov() {
        return this.ciw;
    }

    public boolean aow() {
        return this.cit;
    }

    public String aox() {
        return this.cix;
    }

    public String aoy() {
        return this.ciy;
    }

    private void aoz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void eB(boolean z) {
        this.cin = z;
        aoz();
    }

    public void jx(int i) {
        if (i == 0) {
            this.cim = i;
            b.anD().setMsgBookmark(0);
            b.anD().setMsgGiftNum(0);
            b.anD().setMsgFans(0);
        } else {
            this.cim = 300;
        }
        aoz();
    }

    public boolean aoA() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void eC(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        aoz();
    }

    public boolean aoB() {
        return this.cir;
    }

    public void eD(boolean z) {
        this.cir = z;
        aoz();
    }

    public void eE(boolean z) {
        this.cio = z;
    }

    public void eF(boolean z) {
        this.ciw = z;
    }

    public void pm(String str) {
        this.cix = str;
    }

    public void pn(String str) {
        this.ciy = str;
    }

    public void eG(boolean z) {
        this.cit = z;
    }

    public void eH(boolean z) {
        this.civ = z;
    }

    public void eI(boolean z) {
        this.ciu = z;
    }

    public void eJ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("permit_screen_lock", z);
    }

    public boolean aoC() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("permit_screen_lock", true);
    }

    public void eK(boolean z) {
        this.ciq = z;
        aoz();
    }

    public void eL(boolean z) {
        this.cip = z;
        aoz();
    }

    public void eM(boolean z) {
        this.cis = z;
    }

    public boolean isSignAlertOn() {
        return f.aoF().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aoF().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aoF().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aoF().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aoF().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aoF().updateSignAlarm();
    }

    public void jy(int i) {
        if (i == 0) {
            eI(false);
            eG(false);
        } else if (i == 1) {
            eI(true);
            eG(false);
        } else if (i == 2) {
            eI(false);
            eG(true);
        } else {
            eI(true);
            eG(true);
        }
    }

    public int aoD() {
        if (!this.ciu && !this.cit) {
            return 0;
        }
        if (!this.ciu || this.cit) {
            if (!this.ciu && this.cit) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void eN(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean aoE() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
