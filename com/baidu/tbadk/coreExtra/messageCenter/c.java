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
import com.baidu.tieba.service.SignAlertReceiver;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private static c auU = new c();
    public int auV = 300;
    public boolean auW = true;
    public boolean auX = false;
    public boolean auY = true;
    public boolean auZ = true;
    public boolean ava = true;
    public boolean avb = true;
    public boolean avc = false;
    public boolean avd = true;
    public boolean ave = true;
    public boolean avf = false;
    public String avg = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String avh = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c Ad() {
        return auU;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bsQ();
    }

    public void Ae() {
        com.baidu.tieba.tbadkCore.util.a.Ae();
    }

    public boolean Af() {
        return this.auV > 0;
    }

    public int Ag() {
        return this.auV;
    }

    public boolean Ah() {
        return this.auX;
    }

    public boolean Ai() {
        return this.auY;
    }

    public boolean Aj() {
        return this.avb;
    }

    public boolean Ak() {
        return this.auZ;
    }

    public boolean Al() {
        return this.auW;
    }

    public boolean Am() {
        return this.avd;
    }

    public boolean An() {
        return this.ave;
    }

    public boolean Ao() {
        return this.avf;
    }

    public boolean Ap() {
        return this.avc;
    }

    public String Aq() {
        return this.avg;
    }

    public String Ar() {
        return this.avh;
    }

    public void aX(boolean z) {
        this.auW = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void dV(int i) {
        if (i == 0) {
            this.auV = i;
            a.zw().setMsgBookmark(0);
            a.zw().setMsgGiftNum(0);
            a.zw().setMsgFans(0);
        } else {
            this.auV = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean As() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aY(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean At() {
        return this.ava;
    }

    public void aZ(boolean z) {
        this.ava = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void ba(boolean z) {
        this.auX = z;
    }

    public void bb(boolean z) {
        this.avf = z;
    }

    public void fi(String str) {
        this.avg = str;
    }

    public void fj(String str) {
        this.avh = str;
    }

    public void bc(boolean z) {
        this.avc = z;
    }

    public void bd(boolean z) {
        this.ave = z;
    }

    public void be(boolean z) {
        this.avd = z;
    }

    public void bf(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean Au() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bg(boolean z) {
        this.auZ = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bh(boolean z) {
        this.auY = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bi(boolean z) {
        this.avb = z;
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

    public void dW(int i) {
        if (i == 0) {
            be(false);
            bc(false);
        } else if (i == 1) {
            be(true);
            bc(false);
        } else if (i == 2) {
            be(false);
            bc(true);
        } else {
            be(true);
            bc(true);
        }
    }

    public int Av() {
        if (!this.avd && !this.avc) {
            return 0;
        }
        if (!this.avd || this.avc) {
            if (!this.avd && this.avc) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bj(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean Aw() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
