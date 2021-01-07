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
    private static d fvp = new d();
    public int fvq = 300;
    public boolean fvr = true;
    public boolean fvs = false;
    public boolean fvt = true;
    public boolean fvu = true;
    public boolean fvv = true;
    public boolean fvw = true;
    public boolean fvx = false;
    public boolean fvy = true;
    public boolean fvz = true;
    public boolean fvA = false;
    public String fvB = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String fvC = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private d() {
    }

    public static d bBG() {
        return fvp;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dQi();
    }

    public void bBH() {
        com.baidu.tieba.tbadkCore.util.a.bBH();
    }

    public boolean bBI() {
        return this.fvq > 0;
    }

    public int bBJ() {
        return this.fvq;
    }

    public boolean bBK() {
        return this.fvs;
    }

    public boolean bBL() {
        return this.fvt;
    }

    public boolean bBM() {
        return this.fvw;
    }

    public boolean bBN() {
        return this.fvu;
    }

    public boolean bBO() {
        return this.fvr;
    }

    public boolean bBP() {
        return this.fvy;
    }

    public boolean bBQ() {
        return this.fvz;
    }

    public boolean bBR() {
        return this.fvA;
    }

    public boolean bBS() {
        return this.fvx;
    }

    public String bBT() {
        return this.fvB;
    }

    public String bBU() {
        return this.fvC;
    }

    private void bBV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void kl(boolean z) {
        this.fvr = z;
        bBV();
    }

    public void rV(int i) {
        if (i == 0) {
            this.fvq = i;
            b.bBd().setMsgBookmark(0);
            b.bBd().setMsgGiftNum(0);
        } else {
            this.fvq = 300;
        }
        bBV();
    }

    public boolean bBW() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public void km(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bBV();
    }

    public boolean bBX() {
        return this.fvv;
    }

    public void kn(boolean z) {
        this.fvv = z;
        bBV();
    }

    public void ko(boolean z) {
        this.fvs = z;
    }

    public void kp(boolean z) {
        this.fvA = z;
    }

    public void CW(String str) {
        this.fvB = str;
    }

    public void CX(String str) {
        this.fvC = str;
    }

    public void kq(boolean z) {
        this.fvx = z;
    }

    public void kr(boolean z) {
        this.fvz = z;
    }

    public void ks(boolean z) {
        this.fvy = z;
    }

    public void kt(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bBY() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void ku(boolean z) {
        this.fvu = z;
        bBV();
    }

    public void kv(boolean z) {
        this.fvt = z;
        bBV();
    }

    public void kw(boolean z) {
        this.fvw = z;
        bBV();
    }

    public boolean isSignAlertOn() {
        return f.bCc().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bCc().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bCc().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bCc().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bCc().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bCc().updateSignAlarm();
    }

    public void rW(int i) {
        if (i == 0) {
            ks(false);
            kq(false);
        } else if (i == 1) {
            ks(true);
            kq(false);
        } else if (i == 2) {
            ks(false);
            kq(true);
        } else {
            ks(true);
            kq(true);
        }
    }

    public int bBZ() {
        if (!this.fvy && !this.fvx) {
            return 0;
        }
        if (!this.fvy || this.fvx) {
            if (!this.fvy && this.fvx) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void kx(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, z);
    }

    public boolean bCa() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void ky(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean bCb() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
