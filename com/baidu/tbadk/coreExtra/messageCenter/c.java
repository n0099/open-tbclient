package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes.dex */
public class c {
    private static c aQD = new c();
    public int aQE = 300;
    public boolean aQF = true;
    public boolean aQG = false;
    public boolean aQH = true;
    public boolean aQI = true;
    public boolean aQJ = true;
    public boolean aQK = true;
    public boolean aQL = false;
    public boolean aQM = true;
    public boolean aQN = true;
    public boolean aQO = false;
    public String aQP = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aQQ = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c IM() {
        return aQD;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bFM();
    }

    public void IN() {
        com.baidu.tieba.tbadkCore.util.a.IN();
    }

    public boolean IO() {
        return this.aQE > 0;
    }

    public int IP() {
        return this.aQE;
    }

    public boolean IQ() {
        return this.aQG;
    }

    public boolean IR() {
        return this.aQH;
    }

    public boolean IS() {
        return this.aQK;
    }

    public boolean IT() {
        return this.aQI;
    }

    public boolean IU() {
        return this.aQF;
    }

    public boolean IV() {
        return this.aQM;
    }

    public boolean IW() {
        return this.aQN;
    }

    public boolean IX() {
        return this.aQO;
    }

    public boolean IY() {
        return this.aQL;
    }

    public String IZ() {
        return this.aQP;
    }

    public String Ja() {
        return this.aQQ;
    }

    private void Jb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bR(boolean z) {
        this.aQF = z;
        Jb();
    }

    public void eY(int i) {
        if (i == 0) {
            this.aQE = i;
            a.If().setMsgBookmark(0);
            a.If().setMsgGiftNum(0);
            a.If().setMsgFans(0);
        } else {
            this.aQE = 300;
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
        return this.aQJ;
    }

    public void bT(boolean z) {
        this.aQJ = z;
        Jb();
    }

    public void bU(boolean z) {
        this.aQG = z;
    }

    public void bV(boolean z) {
        this.aQO = z;
    }

    public void gZ(String str) {
        this.aQP = str;
    }

    public void ha(String str) {
        this.aQQ = str;
    }

    public void bW(boolean z) {
        this.aQL = z;
    }

    public void bX(boolean z) {
        this.aQN = z;
    }

    public void bY(boolean z) {
        this.aQM = z;
    }

    public void bZ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean Je() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void ca(boolean z) {
        this.aQI = z;
        Jb();
    }

    public void cb(boolean z) {
        this.aQH = z;
        Jb();
    }

    public void cc(boolean z) {
        this.aQK = z;
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
        if (!this.aQM && !this.aQL) {
            return 0;
        }
        if (!this.aQM || this.aQL) {
            if (!this.aQM && this.aQL) {
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
