package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d bZd = new d();
    public int bZe = 300;
    public boolean bZf = true;
    public boolean bZg = false;
    public boolean bZh = true;
    public boolean bZi = true;
    public boolean bZj = true;
    public boolean bZk = true;
    public boolean bZl = false;
    public boolean bZm = true;
    public boolean bZn = true;
    public boolean bZo = false;
    public String bZp = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bZq = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aih() {
        return bZd;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cfl();
    }

    public void aii() {
        com.baidu.tieba.tbadkCore.util.a.aii();
    }

    public boolean aij() {
        return this.bZe > 0;
    }

    public int aik() {
        return this.bZe;
    }

    public boolean ail() {
        return this.bZg;
    }

    public boolean aim() {
        return this.bZh;
    }

    public boolean ain() {
        return this.bZk;
    }

    public boolean aio() {
        return this.bZi;
    }

    public boolean aip() {
        return this.bZf;
    }

    public boolean aiq() {
        return this.bZm;
    }

    public boolean air() {
        return this.bZn;
    }

    public boolean ais() {
        return this.bZo;
    }

    public boolean ait() {
        return this.bZl;
    }

    public String aiu() {
        return this.bZp;
    }

    public String aiv() {
        return this.bZq;
    }

    private void aiw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void ea(boolean z) {
        this.bZf = z;
        aiw();
    }

    public void iE(int i) {
        if (i == 0) {
            this.bZe = i;
            b.ahA().setMsgBookmark(0);
            b.ahA().setMsgGiftNum(0);
            b.ahA().setMsgFans(0);
        } else {
            this.bZe = 300;
        }
        aiw();
    }

    public boolean aix() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void eb(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        aiw();
    }

    public boolean aiy() {
        return this.bZj;
    }

    public void ec(boolean z) {
        this.bZj = z;
        aiw();
    }

    public void ed(boolean z) {
        this.bZg = z;
    }

    public void ee(boolean z) {
        this.bZo = z;
    }

    public void nL(String str) {
        this.bZp = str;
    }

    public void nM(String str) {
        this.bZq = str;
    }

    public void ef(boolean z) {
        this.bZl = z;
    }

    public void eg(boolean z) {
        this.bZn = z;
    }

    public void eh(boolean z) {
        this.bZm = z;
    }

    public void ei(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean aiz() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void ej(boolean z) {
        this.bZi = z;
        aiw();
    }

    public void ek(boolean z) {
        this.bZh = z;
        aiw();
    }

    public void el(boolean z) {
        this.bZk = z;
    }

    public boolean isSignAlertOn() {
        return f.aiC().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aiC().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aiC().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aiC().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aiC().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aiC().updateSignAlarm();
    }

    public void iF(int i) {
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

    public int aiA() {
        if (!this.bZm && !this.bZl) {
            return 0;
        }
        if (!this.bZm || this.bZl) {
            if (!this.bZm && this.bZl) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void em(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean aiB() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
