package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d bZh = new d();
    public int bZi = 300;
    public boolean bZj = true;
    public boolean bZk = false;
    public boolean bZl = true;
    public boolean bZm = true;
    public boolean bZn = true;
    public boolean bZo = true;
    public boolean bZp = false;
    public boolean bZq = true;
    public boolean bZr = true;
    public boolean bZs = false;
    public String bZt = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bZu = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aie() {
        return bZh;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cfk();
    }

    public void aif() {
        com.baidu.tieba.tbadkCore.util.a.aif();
    }

    public boolean aig() {
        return this.bZi > 0;
    }

    public int aih() {
        return this.bZi;
    }

    public boolean aii() {
        return this.bZk;
    }

    public boolean aij() {
        return this.bZl;
    }

    public boolean aik() {
        return this.bZo;
    }

    public boolean ail() {
        return this.bZm;
    }

    public boolean aim() {
        return this.bZj;
    }

    public boolean ain() {
        return this.bZq;
    }

    public boolean aio() {
        return this.bZr;
    }

    public boolean aip() {
        return this.bZs;
    }

    public boolean aiq() {
        return this.bZp;
    }

    public String air() {
        return this.bZt;
    }

    public String ais() {
        return this.bZu;
    }

    private void ait() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void ea(boolean z) {
        this.bZj = z;
        ait();
    }

    public void iD(int i) {
        if (i == 0) {
            this.bZi = i;
            b.ahx().setMsgBookmark(0);
            b.ahx().setMsgGiftNum(0);
            b.ahx().setMsgFans(0);
        } else {
            this.bZi = 300;
        }
        ait();
    }

    public boolean aiu() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void eb(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        ait();
    }

    public boolean aiv() {
        return this.bZn;
    }

    public void ec(boolean z) {
        this.bZn = z;
        ait();
    }

    public void ed(boolean z) {
        this.bZk = z;
    }

    public void ee(boolean z) {
        this.bZs = z;
    }

    public void nM(String str) {
        this.bZt = str;
    }

    public void nN(String str) {
        this.bZu = str;
    }

    public void ef(boolean z) {
        this.bZp = z;
    }

    public void eg(boolean z) {
        this.bZr = z;
    }

    public void eh(boolean z) {
        this.bZq = z;
    }

    public void ei(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean aiw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void ej(boolean z) {
        this.bZm = z;
        ait();
    }

    public void ek(boolean z) {
        this.bZl = z;
        ait();
    }

    public void el(boolean z) {
        this.bZo = z;
    }

    public boolean isSignAlertOn() {
        return f.aiz().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aiz().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aiz().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aiz().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aiz().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aiz().updateSignAlarm();
    }

    public void iE(int i) {
        if (i == 0) {
            eh(false);
            ef(false);
        } else if (i == 1) {
            eh(true);
            ef(false);
        } else if (i == 2) {
            eh(false);
            ef(true);
        } else {
            eh(true);
            ef(true);
        }
    }

    public int aix() {
        if (!this.bZq && !this.bZp) {
            return 0;
        }
        if (!this.bZq || this.bZp) {
            if (!this.bZq && this.bZp) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void em(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean aiy() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
