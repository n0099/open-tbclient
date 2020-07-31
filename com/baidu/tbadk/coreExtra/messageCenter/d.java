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
    private static d esb = new d();
    public int esc = 300;
    public boolean esd = true;
    public boolean ese = false;
    public boolean esf = true;
    public boolean esg = true;
    public boolean esh = true;
    public boolean esi = true;
    public boolean esj = false;
    public boolean esk = true;
    public boolean esl = true;
    public boolean esm = false;
    public String esn = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String eso = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bfO() {
        return esb;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dmd();
    }

    public void bfP() {
        com.baidu.tieba.tbadkCore.util.a.bfP();
    }

    public boolean bfQ() {
        return this.esc > 0;
    }

    public int bfR() {
        return this.esc;
    }

    public boolean bfS() {
        return this.ese;
    }

    public boolean bfT() {
        return this.esf;
    }

    public boolean bfU() {
        return this.esi;
    }

    public boolean bfV() {
        return this.esg;
    }

    public boolean bfW() {
        return this.esd;
    }

    public boolean bfX() {
        return this.esk;
    }

    public boolean bfY() {
        return this.esl;
    }

    public boolean bfZ() {
        return this.esm;
    }

    public boolean bga() {
        return this.esj;
    }

    public String bgb() {
        return this.esn;
    }

    public String bgc() {
        return this.eso;
    }

    private void bgd() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void ii(boolean z) {
        this.esd = z;
        bgd();
    }

    public void nu(int i) {
        if (i == 0) {
            this.esc = i;
            b.bfl().setMsgBookmark(0);
            b.bfl().setMsgGiftNum(0);
        } else {
            this.esc = 300;
        }
        bgd();
    }

    public boolean bge() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GROUP_NOTIFY, true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void ij(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bgd();
    }

    public boolean bgf() {
        return this.esh;
    }

    public void ik(boolean z) {
        this.esh = z;
        bgd();
    }

    public void il(boolean z) {
        this.ese = z;
    }

    public void im(boolean z) {
        this.esm = z;
    }

    public void yM(String str) {
        this.esn = str;
    }

    public void yN(String str) {
        this.eso = str;
    }

    public void in(boolean z) {
        this.esj = z;
    }

    public void io(boolean z) {
        this.esl = z;
    }

    public void ip(boolean z) {
        this.esk = z;
    }

    public void iq(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bgg() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void ir(boolean z) {
        this.esg = z;
        bgd();
    }

    public void is(boolean z) {
        this.esf = z;
        bgd();
    }

    public void it(boolean z) {
        this.esi = z;
        bgd();
    }

    public boolean isSignAlertOn() {
        return f.bgj().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bgj().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bgj().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bgj().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bgj().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bgj().updateSignAlarm();
    }

    public void nv(int i) {
        if (i == 0) {
            ip(false);
            in(false);
        } else if (i == 1) {
            ip(true);
            in(false);
        } else if (i == 2) {
            ip(false);
            in(true);
        } else {
            ip(true);
            in(true);
        }
    }

    public int bgh() {
        if (!this.esk && !this.esj) {
            return 0;
        }
        if (!this.esk || this.esj) {
            if (!this.esk && this.esj) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void iu(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bgi() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }
}
