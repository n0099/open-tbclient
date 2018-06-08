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
    private static c aDf = new c();
    public int aDg = 300;
    public boolean aDh = true;
    public boolean aDi = false;
    public boolean aDj = true;
    public boolean aDk = true;
    public boolean aDl = true;
    public boolean aDm = true;
    public boolean aDn = false;
    public boolean aDo = true;
    public boolean aDp = true;
    public boolean aDq = false;
    public String aDr = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aDs = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c DE() {
        return aDf;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bxV();
    }

    public void DF() {
        com.baidu.tieba.tbadkCore.util.a.DF();
    }

    public boolean DG() {
        return this.aDg > 0;
    }

    public int DH() {
        return this.aDg;
    }

    public boolean DI() {
        return this.aDi;
    }

    public boolean DJ() {
        return this.aDj;
    }

    public boolean DK() {
        return this.aDm;
    }

    public boolean DL() {
        return this.aDk;
    }

    public boolean DM() {
        return this.aDh;
    }

    public boolean DN() {
        return this.aDo;
    }

    public boolean DO() {
        return this.aDp;
    }

    public boolean DP() {
        return this.aDq;
    }

    public boolean DQ() {
        return this.aDn;
    }

    public String DR() {
        return this.aDr;
    }

    public String DS() {
        return this.aDs;
    }

    public void bb(boolean z) {
        this.aDh = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void dX(int i) {
        if (i == 0) {
            this.aDg = i;
            a.CX().setMsgBookmark(0);
            a.CX().setMsgGiftNum(0);
            a.CX().setMsgFans(0);
        } else {
            this.aDg = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean DT() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bc(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean DU() {
        return this.aDl;
    }

    public void bd(boolean z) {
        this.aDl = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void be(boolean z) {
        this.aDi = z;
    }

    public void bf(boolean z) {
        this.aDq = z;
    }

    public void fF(String str) {
        this.aDr = str;
    }

    public void fG(String str) {
        this.aDs = str;
    }

    public void bg(boolean z) {
        this.aDn = z;
    }

    public void bh(boolean z) {
        this.aDp = z;
    }

    public void bi(boolean z) {
        this.aDo = z;
    }

    public void bj(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean DV() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bk(boolean z) {
        this.aDk = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bl(boolean z) {
        this.aDj = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void bm(boolean z) {
        this.aDm = z;
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

    public void dY(int i) {
        if (i == 0) {
            bi(false);
            bg(false);
        } else if (i == 1) {
            bi(true);
            bg(false);
        } else if (i == 2) {
            bi(false);
            bg(true);
        } else {
            bi(true);
            bg(true);
        }
    }

    public int DW() {
        if (!this.aDo && !this.aDn) {
            return 0;
        }
        if (!this.aDo || this.aDn) {
            if (!this.aDo && this.aDn) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bn(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean DX() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
