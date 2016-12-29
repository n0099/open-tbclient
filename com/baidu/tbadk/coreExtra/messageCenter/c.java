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
import com.baidu.tieba.tbadkCore.util.l;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private static c alr = new c();
    public int als = 300;
    public boolean alt = true;
    public boolean alu = false;
    public boolean alv = true;
    public boolean alw = true;
    public boolean alx = true;
    public boolean aly = false;
    public boolean alz = true;
    public boolean alA = true;
    public boolean alB = false;
    public String alC = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String alD = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c yV() {
        return alr;
    }

    public void initSetting() {
        l.bgW();
    }

    public void yW() {
        l.yW();
    }

    public boolean yX() {
        return this.als > 0;
    }

    public int yY() {
        return this.als;
    }

    public boolean yZ() {
        return this.alu;
    }

    public boolean za() {
        return this.alv;
    }

    public boolean zb() {
        return this.alx;
    }

    public boolean zc() {
        return this.alw;
    }

    public boolean zd() {
        return this.alt;
    }

    public boolean ze() {
        return this.alz;
    }

    public boolean zf() {
        return this.alA;
    }

    public boolean zg() {
        return this.alB;
    }

    public boolean zh() {
        return this.aly;
    }

    public String zi() {
        return this.alC;
    }

    public String zj() {
        return this.alD;
    }

    public void aU(boolean z) {
        this.alt = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dJ(int i) {
        if (i == 0) {
            this.als = i;
            a.yy().aT(true);
        } else {
            this.als = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zk() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aV(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zl() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aW(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aX(boolean z) {
        this.alu = z;
    }

    public void aY(boolean z) {
        this.alB = z;
    }

    public void eu(String str) {
        this.alC = str;
    }

    public void ev(String str) {
        this.alD = str;
    }

    public void aZ(boolean z) {
        this.aly = z;
    }

    public void ba(boolean z) {
        this.alA = z;
    }

    public void bb(boolean z) {
        this.alz = z;
    }

    public void bc(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("permit_screen_lock", z);
    }

    public boolean zm() {
        return com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("permit_screen_lock", true);
    }

    public void bd(boolean z) {
        this.alw = z;
    }

    public void be(boolean z) {
        this.alv = z;
    }

    public void bf(boolean z) {
        this.alx = z;
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
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getSystemService("alarm");
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), 0, createIntentForSignAlarm, 134217728));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.m9getInst(), SignAlertReceiver.class);
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

    public void dK(int i) {
        if (i == 0) {
            bb(false);
            aZ(false);
        } else if (i == 1) {
            bb(true);
            aZ(false);
        } else if (i == 2) {
            bb(false);
            aZ(true);
        } else {
            bb(true);
            aZ(true);
        }
    }

    public int zn() {
        if (!this.alz && !this.aly) {
            return 0;
        }
        if (this.alz && !this.aly) {
            return 1;
        }
        if (!this.alz && this.aly) {
            return 2;
        }
        return 3;
    }

    public void bg(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean zo() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void bh(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean zp() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
