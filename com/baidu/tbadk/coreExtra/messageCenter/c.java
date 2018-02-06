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
    private static c bjz = new c();
    public int bjA = 300;
    public boolean bjB = true;
    public boolean bjC = false;
    public boolean bjD = true;
    public boolean bjE = true;
    public boolean bjF = true;
    public boolean bjG = true;
    public boolean bjH = false;
    public boolean bjI = true;
    public boolean bjJ = true;
    public boolean bjK = false;
    public String bjL = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bjM = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c Hq() {
        return bjz;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bxO();
    }

    public void Hr() {
        com.baidu.tieba.tbadkCore.util.a.Hr();
    }

    public boolean Hs() {
        return this.bjA > 0;
    }

    public int Ht() {
        return this.bjA;
    }

    public boolean Hu() {
        return this.bjC;
    }

    public boolean Hv() {
        return this.bjD;
    }

    public boolean Hw() {
        return this.bjG;
    }

    public boolean Hx() {
        return this.bjE;
    }

    public boolean Hy() {
        return this.bjB;
    }

    public boolean Hz() {
        return this.bjI;
    }

    public boolean HA() {
        return this.bjJ;
    }

    public boolean HB() {
        return this.bjK;
    }

    public boolean HC() {
        return this.bjH;
    }

    public String HD() {
        return this.bjL;
    }

    public String HE() {
        return this.bjM;
    }

    public void bF(boolean z) {
        this.bjB = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void gW(int i) {
        if (i == 0) {
            this.bjA = i;
            a.GJ().setMsgBookmark(0);
            a.GJ().setMsgGiftNum(0);
            a.GJ().setMsgFans(0);
        } else {
            this.bjA = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean HF() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bG(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean HG() {
        return this.bjF;
    }

    public void bH(boolean z) {
        this.bjF = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bI(boolean z) {
        this.bjC = z;
    }

    public void bJ(boolean z) {
        this.bjK = z;
    }

    public void fq(String str) {
        this.bjL = str;
    }

    public void fr(String str) {
        this.bjM = str;
    }

    public void bK(boolean z) {
        this.bjH = z;
    }

    public void bL(boolean z) {
        this.bjJ = z;
    }

    public void bM(boolean z) {
        this.bjI = z;
    }

    public void bN(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean HH() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bO(boolean z) {
        this.bjE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bP(boolean z) {
        this.bjD = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bQ(boolean z) {
        this.bjG = z;
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

    public int HI() {
        if (!this.bjI && !this.bjH) {
            return 0;
        }
        if (!this.bjI || this.bjH) {
            if (!this.bjI && this.bjH) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bR(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean HJ() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
