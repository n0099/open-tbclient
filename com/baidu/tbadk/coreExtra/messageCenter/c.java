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
    private static c bjm = new c();
    public int bjn = 300;
    public boolean bjo = true;
    public boolean bjp = false;
    public boolean bjq = true;
    public boolean bjr = true;
    public boolean bjs = true;
    public boolean bjt = true;
    public boolean bju = false;
    public boolean bjv = true;
    public boolean bjw = true;
    public boolean bjx = false;
    public String bjy = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bjz = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c Hp() {
        return bjm;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bxN();
    }

    public void Hq() {
        com.baidu.tieba.tbadkCore.util.a.Hq();
    }

    public boolean Hr() {
        return this.bjn > 0;
    }

    public int Hs() {
        return this.bjn;
    }

    public boolean Ht() {
        return this.bjp;
    }

    public boolean Hu() {
        return this.bjq;
    }

    public boolean Hv() {
        return this.bjt;
    }

    public boolean Hw() {
        return this.bjr;
    }

    public boolean Hx() {
        return this.bjo;
    }

    public boolean Hy() {
        return this.bjv;
    }

    public boolean Hz() {
        return this.bjw;
    }

    public boolean HA() {
        return this.bjx;
    }

    public boolean HB() {
        return this.bju;
    }

    public String HC() {
        return this.bjy;
    }

    public String HD() {
        return this.bjz;
    }

    public void bF(boolean z) {
        this.bjo = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void gW(int i) {
        if (i == 0) {
            this.bjn = i;
            a.GI().setMsgBookmark(0);
            a.GI().setMsgGiftNum(0);
            a.GI().setMsgFans(0);
        } else {
            this.bjn = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean HE() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bG(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean HF() {
        return this.bjs;
    }

    public void bH(boolean z) {
        this.bjs = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bI(boolean z) {
        this.bjp = z;
    }

    public void bJ(boolean z) {
        this.bjx = z;
    }

    public void fq(String str) {
        this.bjy = str;
    }

    public void fr(String str) {
        this.bjz = str;
    }

    public void bK(boolean z) {
        this.bju = z;
    }

    public void bL(boolean z) {
        this.bjw = z;
    }

    public void bM(boolean z) {
        this.bjv = z;
    }

    public void bN(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean HG() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bO(boolean z) {
        this.bjr = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bP(boolean z) {
        this.bjq = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bQ(boolean z) {
        this.bjt = z;
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

    public void gX(int i) {
        if (i == 0) {
            bM(false);
            bK(false);
        } else if (i == 1) {
            bM(true);
            bK(false);
        } else if (i == 2) {
            bM(false);
            bK(true);
        } else {
            bM(true);
            bK(true);
        }
    }

    public int HH() {
        if (!this.bjv && !this.bju) {
            return 0;
        }
        if (!this.bjv || this.bju) {
            if (!this.bjv && this.bju) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bR(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean HI() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
