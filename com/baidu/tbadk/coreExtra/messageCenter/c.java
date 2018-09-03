package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tieba.service.SignAlertReceiver;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private static c aDY = new c();
    public int aDZ = 300;
    public boolean aEa = true;
    public boolean aEb = false;
    public boolean aEc = true;
    public boolean aEd = true;
    public boolean aEe = true;
    public boolean aEf = true;
    public boolean aEg = false;
    public boolean aEh = true;
    public boolean aEi = true;
    public boolean aEj = false;
    public String aEk = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aEl = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c DS() {
        return aDY;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bxd();
    }

    public void DT() {
        com.baidu.tieba.tbadkCore.util.a.DT();
    }

    public boolean DU() {
        return this.aDZ > 0;
    }

    public int DV() {
        return this.aDZ;
    }

    public boolean DW() {
        return this.aEb;
    }

    public boolean DX() {
        return this.aEc;
    }

    public boolean DY() {
        return this.aEf;
    }

    public boolean DZ() {
        return this.aEd;
    }

    public boolean Ea() {
        return this.aEa;
    }

    public boolean Eb() {
        return this.aEh;
    }

    public boolean Ec() {
        return this.aEi;
    }

    public boolean Ed() {
        return this.aEj;
    }

    public boolean Ee() {
        return this.aEg;
    }

    public String Ef() {
        return this.aEk;
    }

    public String Eg() {
        return this.aEl;
    }

    public void bd(boolean z) {
        this.aEa = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void ea(int i) {
        if (i == 0) {
            this.aDZ = i;
            a.Dl().setMsgBookmark(0);
            a.Dl().setMsgGiftNum(0);
            a.Dl().setMsgFans(0);
        } else {
            this.aDZ = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean Eh() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void be(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean Ei() {
        return this.aEe;
    }

    public void bf(boolean z) {
        this.aEe = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bg(boolean z) {
        this.aEb = z;
    }

    public void bh(boolean z) {
        this.aEj = z;
    }

    public void fH(String str) {
        this.aEk = str;
    }

    public void fI(String str) {
        this.aEl = str;
    }

    public void bi(boolean z) {
        this.aEg = z;
    }

    public void bj(boolean z) {
        this.aEi = z;
    }

    public void bk(boolean z) {
        this.aEh = z;
    }

    public void bl(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean Ej() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bm(boolean z) {
        this.aEd = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bn(boolean z) {
        this.aEc = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bo(boolean z) {
        this.aEf = z;
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
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getSystemService(NotificationCompat.CATEGORY_ALARM);
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

    public void eb(int i) {
        if (i == 0) {
            bk(false);
            bi(false);
        } else if (i == 1) {
            bk(true);
            bi(false);
        } else if (i == 2) {
            bk(false);
            bi(true);
        } else {
            bk(true);
            bi(true);
        }
    }

    public int Ek() {
        if (!this.aEh && !this.aEg) {
            return 0;
        }
        if (!this.aEh || this.aEg) {
            if (!this.aEh && this.aEg) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bp(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean El() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
