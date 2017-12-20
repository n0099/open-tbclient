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
    private static b asG = new b();
    public int asH = 300;
    public boolean asI = true;
    public boolean asJ = false;
    public boolean asK = true;
    public boolean asL = true;
    public boolean asM = true;
    public boolean asN = false;
    public boolean asO = true;
    public boolean asP = true;
    public boolean asQ = false;
    public String asR = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String asS = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private b() {
    }

    public static b zk() {
        return asG;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bxQ();
    }

    public void zl() {
        com.baidu.tieba.tbadkCore.util.a.zl();
    }

    public boolean zm() {
        return this.asH > 0;
    }

    public int zn() {
        return this.asH;
    }

    public boolean zo() {
        return this.asJ;
    }

    public boolean zp() {
        return this.asK;
    }

    public boolean zq() {
        return this.asM;
    }

    public boolean zr() {
        return this.asL;
    }

    public boolean zs() {
        return this.asI;
    }

    public boolean zt() {
        return this.asO;
    }

    public boolean zu() {
        return this.asP;
    }

    public boolean zv() {
        return this.asQ;
    }

    public boolean zw() {
        return this.asN;
    }

    public String zx() {
        return this.asR;
    }

    public String zy() {
        return this.asS;
    }

    public void aT(boolean z) {
        this.asI = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dY(int i) {
        if (i == 0) {
            this.asH = i;
            a.yN().aS(true);
        } else {
            this.asH = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zz() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aU(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zA() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aV(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aW(boolean z) {
        this.asJ = z;
    }

    public void aX(boolean z) {
        this.asQ = z;
    }

    public void eQ(String str) {
        this.asR = str;
    }

    public void eR(String str) {
        this.asS = str;
    }

    public void aY(boolean z) {
        this.asN = z;
    }

    public void aZ(boolean z) {
        this.asP = z;
    }

    public void ba(boolean z) {
        this.asO = z;
    }

    public void bb(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean zB() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bc(boolean z) {
        this.asL = z;
    }

    public void bd(boolean z) {
        this.asK = z;
    }

    public void be(boolean z) {
        this.asM = z;
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
            ba(false);
            aY(false);
        } else if (i == 1) {
            ba(true);
            aY(false);
        } else if (i == 2) {
            ba(false);
            aY(true);
        } else {
            ba(true);
            aY(true);
        }
    }

    public int zC() {
        if (!this.asO && !this.asN) {
            return 0;
        }
        if (!this.asO || this.asN) {
            if (!this.asO && this.asN) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bf(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", z);
    }

    public boolean zD() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", true);
    }

    public void bg(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean zE() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
