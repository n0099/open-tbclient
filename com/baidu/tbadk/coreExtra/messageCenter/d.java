package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class d {
    private static d bZe = new d();
    public int bZf = 300;
    public boolean bZg = true;
    public boolean bZh = false;
    public boolean bZi = true;
    public boolean bZj = true;
    public boolean bZk = true;
    public boolean bZl = true;
    public boolean bZm = false;
    public boolean bZn = true;
    public boolean bZo = true;
    public boolean bZp = false;
    public String bZq = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bZr = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aih() {
        return bZe;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cfo();
    }

    public void aii() {
        com.baidu.tieba.tbadkCore.util.a.aii();
    }

    public boolean aij() {
        return this.bZf > 0;
    }

    public int aik() {
        return this.bZf;
    }

    public boolean ail() {
        return this.bZh;
    }

    public boolean aim() {
        return this.bZi;
    }

    public boolean ain() {
        return this.bZl;
    }

    public boolean aio() {
        return this.bZj;
    }

    public boolean aip() {
        return this.bZg;
    }

    public boolean aiq() {
        return this.bZn;
    }

    public boolean air() {
        return this.bZo;
    }

    public boolean ais() {
        return this.bZp;
    }

    public boolean ait() {
        return this.bZm;
    }

    public String aiu() {
        return this.bZq;
    }

    public String aiv() {
        return this.bZr;
    }

    private void aiw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void ea(boolean z) {
        this.bZg = z;
        aiw();
    }

    public void iE(int i) {
        if (i == 0) {
            this.bZf = i;
            b.ahA().setMsgBookmark(0);
            b.ahA().setMsgGiftNum(0);
            b.ahA().setMsgFans(0);
        } else {
            this.bZf = 300;
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
        return this.bZk;
    }

    public void ec(boolean z) {
        this.bZk = z;
        aiw();
    }

    public void ed(boolean z) {
        this.bZh = z;
    }

    public void ee(boolean z) {
        this.bZp = z;
    }

    public void nL(String str) {
        this.bZq = str;
    }

    public void nM(String str) {
        this.bZr = str;
    }

    public void ef(boolean z) {
        this.bZm = z;
    }

    public void eg(boolean z) {
        this.bZo = z;
    }

    public void eh(boolean z) {
        this.bZn = z;
    }

    public void ei(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean aiz() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void ej(boolean z) {
        this.bZj = z;
        aiw();
    }

    public void ek(boolean z) {
        this.bZi = z;
        aiw();
    }

    public void el(boolean z) {
        this.bZl = z;
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
        if (!this.bZn && !this.bZm) {
            return 0;
        }
        if (!this.bZn || this.bZm) {
            if (!this.bZn && this.bZm) {
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
