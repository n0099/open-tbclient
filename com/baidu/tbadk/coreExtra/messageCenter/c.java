package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class c {
    private static c aQC = new c();
    public int aQD = 300;
    public boolean aQE = true;
    public boolean aQF = false;
    public boolean aQG = true;
    public boolean aQH = true;
    public boolean aQI = true;
    public boolean aQJ = true;
    public boolean aQK = false;
    public boolean aQL = true;
    public boolean aQM = true;
    public boolean aQN = false;
    public String aQO = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aQP = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c IM() {
        return aQC;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bFM();
    }

    public void IN() {
        com.baidu.tieba.tbadkCore.util.a.IN();
    }

    public boolean IO() {
        return this.aQD > 0;
    }

    public int IP() {
        return this.aQD;
    }

    public boolean IQ() {
        return this.aQF;
    }

    public boolean IR() {
        return this.aQG;
    }

    public boolean IS() {
        return this.aQJ;
    }

    public boolean IT() {
        return this.aQH;
    }

    public boolean IU() {
        return this.aQE;
    }

    public boolean IV() {
        return this.aQL;
    }

    public boolean IW() {
        return this.aQM;
    }

    public boolean IX() {
        return this.aQN;
    }

    public boolean IY() {
        return this.aQK;
    }

    public String IZ() {
        return this.aQO;
    }

    public String Ja() {
        return this.aQP;
    }

    private void Jb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bR(boolean z) {
        this.aQE = z;
        Jb();
    }

    public void eY(int i) {
        if (i == 0) {
            this.aQD = i;
            a.If().setMsgBookmark(0);
            a.If().setMsgGiftNum(0);
            a.If().setMsgFans(0);
        } else {
            this.aQD = 300;
        }
        Jb();
    }

    public boolean Jc() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bS(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        Jb();
    }

    public boolean Jd() {
        return this.aQI;
    }

    public void bT(boolean z) {
        this.aQI = z;
        Jb();
    }

    public void bU(boolean z) {
        this.aQF = z;
    }

    public void bV(boolean z) {
        this.aQN = z;
    }

    public void gZ(String str) {
        this.aQO = str;
    }

    public void ha(String str) {
        this.aQP = str;
    }

    public void bW(boolean z) {
        this.aQK = z;
    }

    public void bX(boolean z) {
        this.aQM = z;
    }

    public void bY(boolean z) {
        this.aQL = z;
    }

    public void bZ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean Je() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void ca(boolean z) {
        this.aQH = z;
        Jb();
    }

    public void cb(boolean z) {
        this.aQG = z;
        Jb();
    }

    public void cc(boolean z) {
        this.aQJ = z;
    }

    public boolean isSignAlertOn() {
        return d.Jh().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        d.Jh().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return d.Jh().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return d.Jh().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        d.Jh().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        d.Jh().updateSignAlarm();
    }

    public void eZ(int i) {
        if (i == 0) {
            bY(false);
            bW(false);
        } else if (i == 1) {
            bY(true);
            bW(false);
        } else if (i == 2) {
            bY(false);
            bW(true);
        } else {
            bY(true);
            bW(true);
        }
    }

    public int Jf() {
        if (!this.aQL && !this.aQK) {
            return 0;
        }
        if (!this.aQL || this.aQK) {
            if (!this.aQL && this.aQK) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void cd(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean Jg() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
