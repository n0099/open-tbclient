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
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.tbadkCore.util.j;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private static c acI = new c();
    public int acJ = 300;
    public boolean acK = true;
    public boolean acL = true;
    public boolean acM = true;
    public boolean acN = true;
    public boolean acO = true;
    public boolean acP = false;
    public boolean acQ = true;
    public boolean acR = true;
    public boolean acS = false;
    public String acT = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String acU = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c wg() {
        return acI;
    }

    public void initSetting() {
        j.apB();
    }

    public void wh() {
        j.wh();
    }

    public boolean wi() {
        return this.acJ > 0;
    }

    public int wj() {
        return this.acJ;
    }

    public boolean wk() {
        return this.acL;
    }

    public boolean wl() {
        return this.acM;
    }

    public boolean wm() {
        return this.acO;
    }

    public boolean wn() {
        return this.acN;
    }

    public boolean wo() {
        return this.acK;
    }

    public boolean wp() {
        return this.acQ;
    }

    public boolean wq() {
        return this.acR;
    }

    public boolean wr() {
        return this.acS;
    }

    public boolean ws() {
        return this.acP;
    }

    public String wt() {
        return this.acT;
    }

    public String wu() {
        return this.acU;
    }

    public void aw(boolean z) {
        this.acK = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void cL(int i) {
        if (i == 0) {
            this.acJ = i;
            a.vJ().av(true);
        } else {
            this.acJ = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean wv() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true);
    }

    public void ax(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean ww() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void ay(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void az(boolean z) {
        this.acL = z;
    }

    public void aA(boolean z) {
        this.acS = z;
    }

    public void dL(String str) {
        this.acT = str;
    }

    public void dM(String str) {
        this.acU = str;
    }

    public void aB(boolean z) {
        this.acP = z;
    }

    public void aC(boolean z) {
        this.acR = z;
    }

    public void aD(boolean z) {
        this.acQ = z;
    }

    public void aE(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("chat_float_window_switch", z);
    }

    public boolean wx() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("chat_float_window_switch", true);
    }

    public void aF(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("permit_screen_lock", z);
    }

    public boolean wy() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("permit_screen_lock", true);
    }

    public void aG(boolean z) {
        this.acN = z;
    }

    public void aH(boolean z) {
        this.acM = z;
    }

    public void aI(boolean z) {
        this.acO = z;
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
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getSystemService("alarm");
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst(), 0, createIntentForSignAlarm, 268435456));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.m411getInst(), SignAlertReceiver.class);
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

    public void cM(int i) {
        if (i == 0) {
            aD(false);
            aB(false);
        } else if (i == 1) {
            aD(true);
            aB(false);
        } else if (i == 2) {
            aD(false);
            aB(true);
        } else {
            aD(true);
            aB(true);
        }
    }

    public int wz() {
        if (!this.acQ && !this.acP) {
            return 0;
        }
        if (this.acQ && !this.acP) {
            return 1;
        }
        if (!this.acQ && this.acP) {
            return 2;
        }
        return 3;
    }
}
