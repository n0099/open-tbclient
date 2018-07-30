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
    private static c aDZ = new c();
    public int aEa = 300;
    public boolean aEb = true;
    public boolean aEc = false;
    public boolean aEd = true;
    public boolean aEe = true;
    public boolean aEf = true;
    public boolean aEg = true;
    public boolean aEh = false;
    public boolean aEi = true;
    public boolean aEj = true;
    public boolean aEk = false;
    public String aEl = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aEm = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c DS() {
        return aDZ;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bxc();
    }

    public void DT() {
        com.baidu.tieba.tbadkCore.util.a.DT();
    }

    public boolean DU() {
        return this.aEa > 0;
    }

    public int DV() {
        return this.aEa;
    }

    public boolean DW() {
        return this.aEc;
    }

    public boolean DX() {
        return this.aEd;
    }

    public boolean DY() {
        return this.aEg;
    }

    public boolean DZ() {
        return this.aEe;
    }

    public boolean Ea() {
        return this.aEb;
    }

    public boolean Eb() {
        return this.aEi;
    }

    public boolean Ec() {
        return this.aEj;
    }

    public boolean Ed() {
        return this.aEk;
    }

    public boolean Ee() {
        return this.aEh;
    }

    public String Ef() {
        return this.aEl;
    }

    public String Eg() {
        return this.aEm;
    }

    public void bc(boolean z) {
        this.aEb = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void eb(int i) {
        if (i == 0) {
            this.aEa = i;
            a.Dl().setMsgBookmark(0);
            a.Dl().setMsgGiftNum(0);
            a.Dl().setMsgFans(0);
        } else {
            this.aEa = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean Eh() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bd(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean Ei() {
        return this.aEf;
    }

    public void be(boolean z) {
        this.aEf = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bf(boolean z) {
        this.aEc = z;
    }

    public void bg(boolean z) {
        this.aEk = z;
    }

    public void fH(String str) {
        this.aEl = str;
    }

    public void fI(String str) {
        this.aEm = str;
    }

    public void bh(boolean z) {
        this.aEh = z;
    }

    public void bi(boolean z) {
        this.aEj = z;
    }

    public void bj(boolean z) {
        this.aEi = z;
    }

    public void bk(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean Ej() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bl(boolean z) {
        this.aEe = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bm(boolean z) {
        this.aEd = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bn(boolean z) {
        this.aEg = z;
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

    public void ec(int i) {
        if (i == 0) {
            bj(false);
            bh(false);
        } else if (i == 1) {
            bj(true);
            bh(false);
        } else if (i == 2) {
            bj(false);
            bh(true);
        } else {
            bj(true);
            bh(true);
        }
    }

    public int Ek() {
        if (!this.aEi && !this.aEh) {
            return 0;
        }
        if (!this.aEi || this.aEh) {
            if (!this.aEi && this.aEh) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bo(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean El() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
