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
    private static c apV = new c();
    public int apW = 300;
    public boolean apX = true;
    public boolean apY = false;
    public boolean apZ = true;
    public boolean aqa = true;
    public boolean aqb = true;
    public boolean aqc = false;
    public boolean aqd = true;
    public boolean aqe = true;
    public boolean aqf = false;
    public String aqg = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aqh = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c zh() {
        return apV;
    }

    public void initSetting() {
        l.bix();
    }

    public void zi() {
        l.zi();
    }

    public boolean zj() {
        return this.apW > 0;
    }

    public int zk() {
        return this.apW;
    }

    public boolean zl() {
        return this.apY;
    }

    public boolean zm() {
        return this.apZ;
    }

    public boolean zn() {
        return this.aqb;
    }

    public boolean zo() {
        return this.aqa;
    }

    public boolean zp() {
        return this.apX;
    }

    public boolean zq() {
        return this.aqd;
    }

    public boolean zr() {
        return this.aqe;
    }

    public boolean zs() {
        return this.aqf;
    }

    public boolean zt() {
        return this.aqc;
    }

    public String zu() {
        return this.aqg;
    }

    public String zv() {
        return this.aqh;
    }

    public void aT(boolean z) {
        this.apX = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dF(int i) {
        if (i == 0) {
            this.apW = i;
            a.yK().aS(true);
        } else {
            this.apW = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zw() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aU(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zx() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aV(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aW(boolean z) {
        this.apY = z;
    }

    public void aX(boolean z) {
        this.aqf = z;
    }

    public void eh(String str) {
        this.aqg = str;
    }

    public void ei(String str) {
        this.aqh = str;
    }

    public void aY(boolean z) {
        this.aqc = z;
    }

    public void aZ(boolean z) {
        this.aqe = z;
    }

    public void ba(boolean z) {
        this.aqd = z;
    }

    public void bb(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("permit_screen_lock", z);
    }

    public boolean zy() {
        return com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("permit_screen_lock", true);
    }

    public void bc(boolean z) {
        this.aqa = z;
    }

    public void bd(boolean z) {
        this.apZ = z;
    }

    public void be(boolean z) {
        this.aqb = z;
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

    public int zz() {
        if (!this.aqd && !this.aqc) {
            return 0;
        }
        if (this.aqd && !this.aqc) {
            return 1;
        }
        if (!this.aqd && this.aqc) {
            return 2;
        }
        return 3;
    }

    public void bf(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean zA() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void bg(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean zB() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
