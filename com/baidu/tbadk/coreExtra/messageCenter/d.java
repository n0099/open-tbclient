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
    private static d flE = new d();
    public int flF = 300;
    public boolean flG = true;
    public boolean flH = false;
    public boolean flI = true;
    public boolean flJ = true;
    public boolean flK = true;
    public boolean flL = true;
    public boolean flM = false;
    public boolean flN = true;
    public boolean flO = true;
    public boolean flP = false;
    public String flQ = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String flR = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bzl() {
        return flE;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dQl();
    }

    public void bzm() {
        com.baidu.tieba.tbadkCore.util.a.bzm();
    }

    public boolean bzn() {
        return this.flF > 0;
    }

    public int bzo() {
        return this.flF;
    }

    public boolean bzp() {
        return this.flH;
    }

    public boolean bzq() {
        return this.flI;
    }

    public boolean bzr() {
        return this.flL;
    }

    public boolean bzs() {
        return this.flJ;
    }

    public boolean bzt() {
        return this.flG;
    }

    public boolean bzu() {
        return this.flN;
    }

    public boolean bzv() {
        return this.flO;
    }

    public boolean bzw() {
        return this.flP;
    }

    public boolean bzx() {
        return this.flM;
    }

    public String bzy() {
        return this.flQ;
    }

    public String bzz() {
        return this.flR;
    }

    private void bzA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void jP(boolean z) {
        this.flG = z;
        bzA();
    }

    public void rJ(int i) {
        if (i == 0) {
            this.flF = i;
            b.byI().setMsgBookmark(0);
            b.byI().setMsgGiftNum(0);
        } else {
            this.flF = 300;
        }
        bzA();
    }

    public boolean bzB() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public void jQ(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bzA();
    }

    public boolean bzC() {
        return this.flK;
    }

    public void jR(boolean z) {
        this.flK = z;
        bzA();
    }

    public void jS(boolean z) {
        this.flH = z;
    }

    public void jT(boolean z) {
        this.flP = z;
    }

    public void CZ(String str) {
        this.flQ = str;
    }

    public void Da(String str) {
        this.flR = str;
    }

    public void jU(boolean z) {
        this.flM = z;
    }

    public void jV(boolean z) {
        this.flO = z;
    }

    public void jW(boolean z) {
        this.flN = z;
    }

    public void jX(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bzD() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void jY(boolean z) {
        this.flJ = z;
        bzA();
    }

    public void jZ(boolean z) {
        this.flI = z;
        bzA();
    }

    public void ka(boolean z) {
        this.flL = z;
        bzA();
    }

    public boolean isSignAlertOn() {
        return f.bzH().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bzH().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bzH().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bzH().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bzH().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bzH().updateSignAlarm();
    }

    public void rK(int i) {
        if (i == 0) {
            jW(false);
            jU(false);
        } else if (i == 1) {
            jW(true);
            jU(false);
        } else if (i == 2) {
            jW(false);
            jU(true);
        } else {
            jW(true);
            jU(true);
        }
    }

    public int bzE() {
        if (!this.flN && !this.flM) {
            return 0;
        }
        if (!this.flN || this.flM) {
            if (!this.flN && this.flM) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void kb(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bzF() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void kc(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean bzG() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
