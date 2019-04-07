package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d bZg = new d();
    public int bZh = 300;
    public boolean bZi = true;
    public boolean bZj = false;
    public boolean bZk = true;
    public boolean bZl = true;
    public boolean bZm = true;
    public boolean bZn = true;
    public boolean bZo = false;
    public boolean bZp = true;
    public boolean bZq = true;
    public boolean bZr = false;
    public String bZs = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bZt = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aie() {
        return bZg;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cfk();
    }

    public void aif() {
        com.baidu.tieba.tbadkCore.util.a.aif();
    }

    public boolean aig() {
        return this.bZh > 0;
    }

    public int aih() {
        return this.bZh;
    }

    public boolean aii() {
        return this.bZj;
    }

    public boolean aij() {
        return this.bZk;
    }

    public boolean aik() {
        return this.bZn;
    }

    public boolean ail() {
        return this.bZl;
    }

    public boolean aim() {
        return this.bZi;
    }

    public boolean ain() {
        return this.bZp;
    }

    public boolean aio() {
        return this.bZq;
    }

    public boolean aip() {
        return this.bZr;
    }

    public boolean aiq() {
        return this.bZo;
    }

    public String air() {
        return this.bZs;
    }

    public String ais() {
        return this.bZt;
    }

    private void ait() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void ea(boolean z) {
        this.bZi = z;
        ait();
    }

    public void iD(int i) {
        if (i == 0) {
            this.bZh = i;
            b.ahx().setMsgBookmark(0);
            b.ahx().setMsgGiftNum(0);
            b.ahx().setMsgFans(0);
        } else {
            this.bZh = 300;
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
        return this.bZm;
    }

    public void ec(boolean z) {
        this.bZm = z;
        ait();
    }

    public void ed(boolean z) {
        this.bZj = z;
    }

    public void ee(boolean z) {
        this.bZr = z;
    }

    public void nM(String str) {
        this.bZs = str;
    }

    public void nN(String str) {
        this.bZt = str;
    }

    public void ef(boolean z) {
        this.bZo = z;
    }

    public void eg(boolean z) {
        this.bZq = z;
    }

    public void eh(boolean z) {
        this.bZp = z;
    }

    public void ei(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean aiw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void ej(boolean z) {
        this.bZl = z;
        ait();
    }

    public void ek(boolean z) {
        this.bZk = z;
        ait();
    }

    public void el(boolean z) {
        this.bZn = z;
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
        if (!this.bZp && !this.bZo) {
            return 0;
        }
        if (!this.bZp || this.bZo) {
            if (!this.bZp && this.bZo) {
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
