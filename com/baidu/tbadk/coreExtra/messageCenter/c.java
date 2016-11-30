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
    private static c alP = new c();
    public int alQ = 300;
    public boolean alR = true;
    public boolean alS = false;
    public boolean alT = true;
    public boolean alU = true;
    public boolean alV = true;
    public boolean alW = false;
    public boolean alX = true;
    public boolean alY = true;
    public boolean alZ = false;
    public String ama = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String amb = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c zh() {
        return alP;
    }

    public void initSetting() {
        l.bnc();
    }

    public void zi() {
        l.zi();
    }

    public boolean zj() {
        return this.alQ > 0;
    }

    public int zk() {
        return this.alQ;
    }

    public boolean zl() {
        return this.alS;
    }

    public boolean zm() {
        return this.alT;
    }

    public boolean zn() {
        return this.alV;
    }

    public boolean zo() {
        return this.alU;
    }

    public boolean zp() {
        return this.alR;
    }

    public boolean zq() {
        return this.alX;
    }

    public boolean zr() {
        return this.alY;
    }

    public boolean zs() {
        return this.alZ;
    }

    public boolean zt() {
        return this.alW;
    }

    public String zu() {
        return this.ama;
    }

    public String zv() {
        return this.amb;
    }

    public void aT(boolean z) {
        this.alR = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dH(int i) {
        if (i == 0) {
            this.alQ = i;
            a.yK().aS(true);
        } else {
            this.alQ = 300;
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
        this.alS = z;
    }

    public void aX(boolean z) {
        this.alZ = z;
    }

    public void ex(String str) {
        this.ama = str;
    }

    public void ey(String str) {
        this.amb = str;
    }

    public void aY(boolean z) {
        this.alW = z;
    }

    public void aZ(boolean z) {
        this.alY = z;
    }

    public void ba(boolean z) {
        this.alX = z;
    }

    public void bb(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("chat_float_window_switch", z);
    }

    public boolean zy() {
        return com.baidu.tbadk.core.sharedPref.b.um().getBoolean("chat_float_window_switch", true);
    }

    public void bc(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("permit_screen_lock", z);
    }

    public boolean zz() {
        return com.baidu.tbadk.core.sharedPref.b.um().getBoolean("permit_screen_lock", true);
    }

    public void bd(boolean z) {
        this.alU = z;
    }

    public void be(boolean z) {
        this.alT = z;
    }

    public void bf(boolean z) {
        this.alV = z;
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

    public void dI(int i) {
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

    public int zA() {
        if (!this.alX && !this.alW) {
            return 0;
        }
        if (this.alX && !this.alW) {
            return 1;
        }
        if (!this.alX && this.alW) {
            return 2;
        }
        return 3;
    }

    public void bg(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean zB() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void bh(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean zC() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
