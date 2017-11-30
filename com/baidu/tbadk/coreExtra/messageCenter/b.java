package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.service.SignAlertReceiver;
import java.util.Calendar;
/* loaded from: classes.dex */
public class b {
    private static b asB = new b();
    public int asC = 300;
    public boolean asD = true;
    public boolean asE = false;
    public boolean asF = true;
    public boolean asG = true;
    public boolean asH = true;
    public boolean asI = false;
    public boolean asJ = true;
    public boolean asK = true;
    public boolean asL = false;
    public String asM = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String asN = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private b() {
    }

    public static b zj() {
        return asB;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bxk();
    }

    public void zk() {
        com.baidu.tieba.tbadkCore.util.a.zk();
    }

    public boolean zl() {
        return this.asC > 0;
    }

    public int zm() {
        return this.asC;
    }

    public boolean zn() {
        return this.asE;
    }

    public boolean zo() {
        return this.asF;
    }

    public boolean zp() {
        return this.asH;
    }

    public boolean zq() {
        return this.asG;
    }

    public boolean zr() {
        return this.asD;
    }

    public boolean zs() {
        return this.asJ;
    }

    public boolean zt() {
        return this.asK;
    }

    public boolean zu() {
        return this.asL;
    }

    public boolean zv() {
        return this.asI;
    }

    public String zw() {
        return this.asM;
    }

    public String zx() {
        return this.asN;
    }

    public void aS(boolean z) {
        this.asD = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dY(int i) {
        if (i == 0) {
            this.asC = i;
            a.yM().aR(true);
        } else {
            this.asC = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zy() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aT(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zz() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aU(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aV(boolean z) {
        this.asE = z;
    }

    public void aW(boolean z) {
        this.asL = z;
    }

    public void eQ(String str) {
        this.asM = str;
    }

    public void eR(String str) {
        this.asN = str;
    }

    public void aX(boolean z) {
        this.asI = z;
    }

    public void aY(boolean z) {
        this.asK = z;
    }

    public void aZ(boolean z) {
        this.asJ = z;
    }

    public void ba(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean zA() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bb(boolean z) {
        this.asG = z;
    }

    public void bc(boolean z) {
        this.asF = z;
    }

    public void bd(boolean z) {
        this.asH = z;
    }

    public boolean isSignAlertOn() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    public void setSignAlertOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        updateSignAlarm();
    }

    public int getSignAlertHours() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    public void updateSignAlarm() {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getSystemService("alarm");
        Intent createIntentForSignAlarm = createIntentForSignAlarm();
        if (isSignAlertOn()) {
            Calendar calendar = Calendar.getInstance();
            int signAlertHours = getSignAlertHours();
            int i = calendar.get(11);
            int signAlertMins = getSignAlertMins();
            int i2 = calendar.get(12);
            calendar.set(11, signAlertHours);
            calendar.set(12, signAlertMins);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= signAlertHours && (i != signAlertHours || i2 >= signAlertMins)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), 0, createIntentForSignAlarm, 134217728));
            if (BdLog.isDebugMode()) {
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (BdLog.isDebugMode()) {
            }
        }
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
        return intent;
    }

    private void prepareForDefaultAlertTime() {
        Calendar calendar = Calendar.getInstance();
        setSignAlertTime(calendar.get(11), calendar.get(12));
    }

    public int getSignAlertMins() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    public void setSignAlertTime(int i, int i2) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        updateSignAlarm();
    }

    public void dZ(int i) {
        if (i == 0) {
            aZ(false);
            aX(false);
        } else if (i == 1) {
            aZ(true);
            aX(false);
        } else if (i == 2) {
            aZ(false);
            aX(true);
        } else {
            aZ(true);
            aX(true);
        }
    }

    public int zB() {
        if (!this.asJ && !this.asI) {
            return 0;
        }
        if (!this.asJ || this.asI) {
            if (!this.asJ && this.asI) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void be(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", z);
    }

    public boolean zC() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", true);
    }

    public void bf(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean zD() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
