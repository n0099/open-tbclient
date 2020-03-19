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
    private static d doU = new d();
    public int doV = 300;
    public boolean doW = true;
    public boolean doX = false;
    public boolean doY = true;
    public boolean doZ = true;
    public boolean dpa = true;
    public boolean dpb = true;
    public boolean dpc = false;
    public boolean dpd = true;
    public boolean dpe = true;
    public boolean dpf = false;
    public String dpg = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String dph = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aLq() {
        return doU;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cMs();
    }

    public void aLr() {
        com.baidu.tieba.tbadkCore.util.a.aLr();
    }

    public boolean aLs() {
        return this.doV > 0;
    }

    public int aLt() {
        return this.doV;
    }

    public boolean aLu() {
        return this.doX;
    }

    public boolean aLv() {
        return this.doY;
    }

    public boolean aLw() {
        return this.dpb;
    }

    public boolean aLx() {
        return this.doZ;
    }

    public boolean aLy() {
        return this.doW;
    }

    public boolean aLz() {
        return this.dpd;
    }

    public boolean aLA() {
        return this.dpe;
    }

    public boolean aLB() {
        return this.dpf;
    }

    public boolean aLC() {
        return this.dpc;
    }

    public String aLD() {
        return this.dpg;
    }

    public String aLE() {
        return this.dph;
    }

    private void aLF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void fZ(boolean z) {
        this.doW = z;
        aLF();
    }

    public void lR(int i) {
        if (i == 0) {
            this.doV = i;
            b.aKJ().setMsgBookmark(0);
            b.aKJ().setMsgGiftNum(0);
            b.aKJ().setMsgFans(0);
        } else {
            this.doV = 300;
        }
        aLF();
    }

    public boolean aLG() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void ga(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        aLF();
    }

    public boolean aLH() {
        return this.dpa;
    }

    public void gb(boolean z) {
        this.dpa = z;
        aLF();
    }

    public void gc(boolean z) {
        this.doX = z;
    }

    public void gd(boolean z) {
        this.dpf = z;
    }

    public void uq(String str) {
        this.dpg = str;
    }

    public void ur(String str) {
        this.dph = str;
    }

    public void ge(boolean z) {
        this.dpc = z;
    }

    public void gf(boolean z) {
        this.dpe = z;
    }

    public void gg(boolean z) {
        this.dpd = z;
    }

    public void gh(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean aLI() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void gi(boolean z) {
        this.doZ = z;
        aLF();
    }

    public void gj(boolean z) {
        this.doY = z;
        aLF();
    }

    public void gk(boolean z) {
        this.dpb = z;
    }

    public boolean isSignAlertOn() {
        return f.aLL().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aLL().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aLL().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aLL().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aLL().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aLL().updateSignAlarm();
    }

    public void lS(int i) {
        if (i == 0) {
            gg(false);
            ge(false);
        } else if (i == 1) {
            gg(true);
            ge(false);
        } else if (i == 2) {
            gg(false);
            ge(true);
        } else {
            gg(true);
            ge(true);
        }
    }

    public int aLJ() {
        if (!this.dpd && !this.dpc) {
            return 0;
        }
        if (!this.dpd || this.dpc) {
            if (!this.dpd && this.dpc) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void gl(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aLK() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
