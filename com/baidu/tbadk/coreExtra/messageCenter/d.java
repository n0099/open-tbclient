package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d cis = new d();
    public int cit = 300;
    public boolean ciu = true;
    public boolean civ = false;
    public boolean ciw = true;
    public boolean cix = true;
    public boolean ciy = true;
    public boolean ciz = true;
    public boolean ciA = false;
    public boolean ciB = true;
    public boolean ciC = true;
    public boolean ciD = false;
    public String ciE = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ciF = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aom() {
        return cis;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cqG();
    }

    public void aon() {
        com.baidu.tieba.tbadkCore.util.a.aon();
    }

    public boolean aoo() {
        return this.cit > 0;
    }

    public int aop() {
        return this.cit;
    }

    public boolean aoq() {
        return this.civ;
    }

    public boolean aor() {
        return this.ciw;
    }

    public boolean aos() {
        return this.ciz;
    }

    public boolean aot() {
        return this.cix;
    }

    public boolean aou() {
        return this.ciu;
    }

    public boolean aov() {
        return this.ciB;
    }

    public boolean aow() {
        return this.ciC;
    }

    public boolean aox() {
        return this.ciD;
    }

    public boolean aoy() {
        return this.ciA;
    }

    public String aoz() {
        return this.ciE;
    }

    public String aoA() {
        return this.ciF;
    }

    private void aoB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void eB(boolean z) {
        this.ciu = z;
        aoB();
    }

    public void jy(int i) {
        if (i == 0) {
            this.cit = i;
            b.anF().setMsgBookmark(0);
            b.anF().setMsgGiftNum(0);
            b.anF().setMsgFans(0);
        } else {
            this.cit = 300;
        }
        aoB();
    }

    public boolean aoC() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void eC(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        aoB();
    }

    public boolean aoD() {
        return this.ciy;
    }

    public void eD(boolean z) {
        this.ciy = z;
        aoB();
    }

    public void eE(boolean z) {
        this.civ = z;
    }

    public void eF(boolean z) {
        this.ciD = z;
    }

    public void pm(String str) {
        this.ciE = str;
    }

    public void pn(String str) {
        this.ciF = str;
    }

    public void eG(boolean z) {
        this.ciA = z;
    }

    public void eH(boolean z) {
        this.ciC = z;
    }

    public void eI(boolean z) {
        this.ciB = z;
    }

    public void eJ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("permit_screen_lock", z);
    }

    public boolean aoE() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("permit_screen_lock", true);
    }

    public void eK(boolean z) {
        this.cix = z;
        aoB();
    }

    public void eL(boolean z) {
        this.ciw = z;
        aoB();
    }

    public void eM(boolean z) {
        this.ciz = z;
    }

    public boolean isSignAlertOn() {
        return f.aoH().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aoH().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aoH().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aoH().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aoH().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aoH().updateSignAlarm();
    }

    public void jz(int i) {
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

    public int aoF() {
        if (!this.ciB && !this.ciA) {
            return 0;
        }
        if (!this.ciB || this.ciA) {
            if (!this.ciB && this.ciA) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void eN(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean aoG() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
