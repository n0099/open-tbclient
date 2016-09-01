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
import com.baidu.tieba.tbadkCore.util.m;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private static c alp = new c();
    public int alq = 300;
    public boolean alr = true;
    public boolean als = false;
    public boolean alt = true;
    public boolean alu = true;
    public boolean alv = true;
    public boolean alw = false;
    public boolean alx = true;
    public boolean aly = true;
    public boolean alz = false;
    public String alA = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String alB = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c yX() {
        return alp;
    }

    public void initSetting() {
        m.bka();
    }

    public void yY() {
        m.yY();
    }

    public boolean yZ() {
        return this.alq > 0;
    }

    public int za() {
        return this.alq;
    }

    public boolean zb() {
        return this.als;
    }

    public boolean zc() {
        return this.alt;
    }

    public boolean zd() {
        return this.alv;
    }

    public boolean ze() {
        return this.alu;
    }

    public boolean zf() {
        return this.alr;
    }

    public boolean zg() {
        return this.alx;
    }

    public boolean zh() {
        return this.aly;
    }

    public boolean zi() {
        return this.alz;
    }

    public boolean zj() {
        return this.alw;
    }

    public String zk() {
        return this.alA;
    }

    public String zl() {
        return this.alB;
    }

    public void aQ(boolean z) {
        this.alr = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dF(int i) {
        if (i == 0) {
            this.alq = i;
            a.yA().aP(true);
        } else {
            this.alq = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zm() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aR(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zn() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aS(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aT(boolean z) {
        this.als = z;
    }

    public void aU(boolean z) {
        this.alz = z;
    }

    public void es(String str) {
        this.alA = str;
    }

    public void et(String str) {
        this.alB = str;
    }

    public void aV(boolean z) {
        this.alw = z;
    }

    public void aW(boolean z) {
        this.aly = z;
    }

    public void aX(boolean z) {
        this.alx = z;
    }

    public void aY(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("chat_float_window_switch", z);
    }

    public boolean zo() {
        return com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("chat_float_window_switch", true);
    }

    public void aZ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("permit_screen_lock", z);
    }

    public boolean zp() {
        return com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("permit_screen_lock", true);
    }

    public void ba(boolean z) {
        this.alu = z;
    }

    public void bb(boolean z) {
        this.alt = z;
    }

    public void bc(boolean z) {
        this.alv = z;
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

    public void dG(int i) {
        if (i == 0) {
            aX(false);
            aV(false);
        } else if (i == 1) {
            aX(true);
            aV(false);
        } else if (i == 2) {
            aX(false);
            aV(true);
        } else {
            aX(true);
            aV(true);
        }
    }

    public int zq() {
        if (!this.alx && !this.alw) {
            return 0;
        }
        if (this.alx && !this.alw) {
            return 1;
        }
        if (!this.alx && this.alw) {
            return 2;
        }
        return 3;
    }

    public void bd(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean zr() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void be(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean zs() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
