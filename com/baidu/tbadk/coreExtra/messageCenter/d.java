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

    public static d bBF() {
        return fvp;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.dQh();
    }

    public void bBG() {
        com.baidu.tieba.tbadkCore.util.a.bBG();
    }

    public boolean bBH() {
        return this.fvq > 0;
    }

    public int bBI() {
        return this.fvq;
    }

    public boolean bBJ() {
        return this.fvs;
    }

    public boolean bBK() {
        return this.fvt;
    }

    public boolean bBL() {
        return this.fvw;
    }

    public boolean bBM() {
        return this.fvu;
    }

    public boolean bBN() {
        return this.fvr;
    }

    public boolean bBO() {
        return this.fvy;
    }

    public boolean bBP() {
        return this.fvz;
    }

    public boolean bBQ() {
        return this.fvA;
    }

    public boolean bBR() {
        return this.fvx;
    }

    public String bBS() {
        return this.fvB;
    }

    public String bBT() {
        return this.fvC;
    }

    private void bBU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void kl(boolean z) {
        this.fvr = z;
        bBU();
    }

    public void rV(int i) {
        if (i == 0) {
            this.fvq = i;
            b.bBc().setMsgBookmark(0);
            b.bBc().setMsgGiftNum(0);
        } else {
            this.fvq = 300;
        }
        bBU();
    }

    public boolean bBV() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public void km(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GROUP_NOTIFY, z);
        bBU();
    }

    public boolean bBW() {
        return this.fvv;
    }

    public void kn(boolean z) {
        this.fvv = z;
        bBU();
    }

    public void ko(boolean z) {
        this.fvs = z;
    }

    public void kp(boolean z) {
        this.fvA = z;
    }

    public void CX(String str) {
        this.fvB = str;
    }

    public void CY(String str) {
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
        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, z);
    }

    public boolean bBX() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.PERMIT_SCREEN_LOCK, true);
    }

    public void ku(boolean z) {
        this.fvu = z;
        bBU();
    }

    public void kv(boolean z) {
        this.fvt = z;
        bBU();
    }

    public void kw(boolean z) {
        this.fvw = z;
        bBU();
    }

    public boolean isSignAlertOn() {
        return f.bCb().isSignAlertOn();
    }

    public void setSignAlertOn(boolean z) {
        f.bCb().setSignAlertOn(z);
    }

    public int getSignAlertHours() {
        return f.bCb().getSignAlertHours();
    }

    public int getSignAlertMins() {
        return f.bCb().getSignAlertMins();
    }

    public void setSignAlertTime(int i, int i2) {
        f.bCb().setSignAlertTime(i, i2);
    }

    public void updateSignAlarm() {
        f.bCb().updateSignAlarm();
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

    public int bBY() {
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

    public boolean bBZ() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_FORUM_BROADCAST_SWITCH, true);
    }

    public void ky(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public boolean bCa() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }
}
