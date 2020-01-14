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
    private static d dkm = new d();
    public int dkn = 300;
    public boolean dko = true;
    public boolean dkp = false;
    public boolean dkq = true;
    public boolean dkr = true;
    public boolean dks = true;
    public boolean dkt = true;
    public boolean dku = false;
    public boolean dkv = true;
    public boolean dkw = true;
    public boolean dkx = false;
    public String dky = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String dkz = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d aIQ() {
        return dkm;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.cKx();
    }

    public void aIR() {
        com.baidu.tieba.tbadkCore.util.a.aIR();
    }

    public boolean aIS() {
        return this.dkn > 0;
    }

    public int aIT() {
        return this.dkn;
    }

    public boolean aIU() {
        return this.dkp;
    }

    public boolean aIV() {
        return this.dkq;
    }

    public boolean aIW() {
        return this.dkt;
    }

    public boolean aIX() {
        return this.dkr;
    }

    public boolean aIY() {
        return this.dko;
    }

    public boolean aIZ() {
        return this.dkv;
    }

    public boolean aJa() {
        return this.dkw;
    }

    public boolean aJb() {
        return this.dkx;
    }

    public boolean aJc() {
        return this.dku;
    }

    public String aJd() {
        return this.dky;
    }

    public String aJe() {
        return this.dkz;
    }

    private void aJf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void fR(boolean z) {
        this.dko = z;
        aJf();
    }

    public void ly(int i) {
        if (i == 0) {
            this.dkn = i;
            b.aIj().setMsgBookmark(0);
            b.aIj().setMsgGiftNum(0);
            b.aIj().setMsgFans(0);
        } else {
            this.dkn = 300;
        }
        aJf();
    }

    public boolean aJg() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void fS(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        aJf();
    }

    public boolean aJh() {
        return this.dks;
    }

    public void fT(boolean z) {
        this.dks = z;
        aJf();
    }

    public void fU(boolean z) {
        this.dkp = z;
    }

    public void fV(boolean z) {
        this.dkx = z;
    }

    public void tY(String str) {
        this.dky = str;
    }

    public void tZ(String str) {
        this.dkz = str;
    }

    public void fW(boolean z) {
        this.dku = z;
    }

    public void fX(boolean z) {
        this.dkw = z;
    }

    public void fY(boolean z) {
        this.dkv = z;
    }

    public void fZ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean aJi() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void ga(boolean z) {
        this.dkr = z;
        aJf();
    }

    public void gb(boolean z) {
        this.dkq = z;
        aJf();
    }

    public void gc(boolean z) {
        this.dkt = z;
    }

    public boolean isSignAlertOn() {
        return f.aJl().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.aJl().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.aJl().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.aJl().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.aJl().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.aJl().updateSignAlarm();
    }

    public void lz(int i) {
        if (i == 0) {
            fY(false);
            fW(false);
        } else if (i == 1) {
            fY(true);
            fW(false);
        } else if (i == 2) {
            fY(false);
            fW(true);
        } else {
            fY(true);
            fW(true);
        }
    }

    public int aJj() {
        if (!this.dkv && !this.dku) {
            return 0;
        }
        if (!this.dkv || this.dku) {
            if (!this.dkv && this.dku) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void gd(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean aJk() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
