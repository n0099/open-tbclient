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
    private static d eZg = new d();
    public int eZh = 300;
    public boolean eZi = true;
    public boolean eZj = false;
    public boolean eZk = true;
    public boolean eZl = true;
    public boolean eZm = true;
    public boolean eZn = true;
    public boolean eZo = false;
    public boolean eZp = true;
    public boolean eZq = true;
    public boolean eZr = false;
    public String eZs = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String eZt = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d btV() {
        return eZg;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dIr();
    }

    public void btW() {
        com.baidu.tieba.tbadkCore.util.a.btW();
    }

    public boolean btX() {
        return this.eZh > 0;
    }

    public int btY() {
        return this.eZh;
    }

    public boolean btZ() {
        return this.eZj;
    }

    public boolean bua() {
        return this.eZk;
    }

    public boolean bub() {
        return this.eZn;
    }

    public boolean buc() {
        return this.eZl;
    }

    public boolean bud() {
        return this.eZi;
    }

    public boolean bue() {
        return this.eZp;
    }

    public boolean buf() {
        return this.eZq;
    }

    public boolean bug() {
        return this.eZr;
    }

    public boolean buh() {
        return this.eZo;
    }

    public String bui() {
        return this.eZs;
    }

    public String buj() {
        return this.eZt;
    }

    private void buk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void jp(boolean z) {
        this.eZi = z;
        buk();
    }

    public void qA(int i) {
        if (i == 0) {
            this.eZh = i;
            b.bts().setMsgBookmark(0);
            b.bts().setMsgGiftNum(0);
        } else {
            this.eZh = 300;
        }
        buk();
    }

    public boolean bul() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void jq(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        buk();
    }

    public boolean bum() {
        return this.eZm;
    }

    public void jr(boolean z) {
        this.eZm = z;
        buk();
    }

    public void js(boolean z) {
        this.eZj = z;
    }

    public void jt(boolean z) {
        this.eZr = z;
    }

    public void CE(String str) {
        this.eZs = str;
    }

    public void CF(String str) {
        this.eZt = str;
    }

    public void ju(boolean z) {
        this.eZo = z;
    }

    public void jv(boolean z) {
        this.eZq = z;
    }

    public void jw(boolean z) {
        this.eZp = z;
    }

    public void jx(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bun() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void jy(boolean z) {
        this.eZl = z;
        buk();
    }

    public void jz(boolean z) {
        this.eZk = z;
        buk();
    }

    public void jA(boolean z) {
        this.eZn = z;
        buk();
    }

    public boolean isSignAlertOn() {
        return f.bur().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bur().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bur().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bur().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bur().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bur().updateSignAlarm();
    }

    public void qB(int i) {
        if (i == 0) {
            jw(false);
            ju(false);
        } else if (i == 1) {
            jw(true);
            ju(false);
        } else if (i == 2) {
            jw(false);
            ju(true);
        } else {
            jw(true);
            ju(true);
        }
    }

    public int buo() {
        if (!this.eZp && !this.eZo) {
            return 0;
        }
        if (!this.eZp || this.eZo) {
            if (!this.eZp && this.eZo) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void jB(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bup() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void jC(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean buq() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
