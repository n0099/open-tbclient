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
    private static c abD = new c();
    public int abE = 300;
    public boolean abF = true;
    public boolean abG = true;
    public boolean abH = true;
    public boolean abI = true;
    public boolean abJ = true;
    public boolean abK = false;
    public boolean abL = true;
    public boolean abM = true;
    public boolean abN = false;
    public String abO = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String abP = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c vw() {
        return abD;
    }

    public void initSetting() {
        j.anJ();
    }

    public void vx() {
        j.vx();
    }

    public boolean vy() {
        return this.abE > 0;
    }

    public int vz() {
        return this.abE;
    }

    public boolean vA() {
        return this.abG;
    }

    public boolean vB() {
        return this.abH;
    }

    public boolean vC() {
        return this.abJ;
    }

    public boolean vD() {
        return this.abI;
    }

    public boolean vE() {
        return this.abF;
    }

    public boolean vF() {
        return this.abL;
    }

    public boolean vG() {
        return this.abM;
    }

    public boolean vH() {
        return this.abN;
    }

    public boolean vI() {
        return this.abK;
    }

    public String vJ() {
        return this.abO;
    }

    public String vK() {
        return this.abP;
    }

    public void ap(boolean z) {
        this.abF = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void cE(int i) {
        if (i == 0) {
            this.abE = i;
            a.uZ().ao(true);
        } else {
            this.abE = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean vL() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true);
    }

    public void aq(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean vM() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void ar(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void as(boolean z) {
        this.abG = z;
    }

    public void at(boolean z) {
        this.abN = z;
    }

    public void du(String str) {
        this.abO = str;
    }

    public void dv(String str) {
        this.abP = str;
    }

    public void au(boolean z) {
        this.abK = z;
    }

    public void av(boolean z) {
        this.abM = z;
    }

    public void aw(boolean z) {
        this.abL = z;
    }

    public void ax(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("chat_float_window_switch", z);
    }

    public boolean vN() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("chat_float_window_switch", true);
    }

    public void ay(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("permit_screen_lock", z);
    }

    public boolean vO() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("permit_screen_lock", true);
    }

    public void az(boolean z) {
        this.abI = z;
    }

    public void aA(boolean z) {
        this.abH = z;
    }

    public void aB(boolean z) {
        this.abJ = z;
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

    public void cF(int i) {
        if (i == 0) {
            aw(false);
            au(false);
        } else if (i == 1) {
            aw(true);
            au(false);
        } else if (i == 2) {
            aw(false);
            au(true);
        } else {
            aw(true);
            au(true);
        }
    }

    public int vP() {
        if (!this.abL && !this.abK) {
            return 0;
        }
        if (this.abL && !this.abK) {
            return 1;
        }
        if (!this.abL && this.abK) {
            return 2;
        }
        return 3;
    }
}
