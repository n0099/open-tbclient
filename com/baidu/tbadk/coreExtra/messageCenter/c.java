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
import com.baidu.tieba.tbadkCore.util.k;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private static c aib = new c();
    public int aic = 300;
    public boolean aid = true;
    public boolean aie = false;
    public boolean aif = true;
    public boolean aig = true;
    public boolean aih = true;
    public boolean aii = false;
    public boolean aij = true;
    public boolean aik = true;
    public boolean ail = false;
    public String aim = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ain = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c xw() {
        return aib;
    }

    public void initSetting() {
        k.avk();
    }

    public void xx() {
        k.xx();
    }

    public boolean xy() {
        return this.aic > 0;
    }

    public int xz() {
        return this.aic;
    }

    public boolean xA() {
        return this.aie;
    }

    public boolean xB() {
        return this.aif;
    }

    public boolean xC() {
        return this.aih;
    }

    public boolean xD() {
        return this.aig;
    }

    public boolean xE() {
        return this.aid;
    }

    public boolean xF() {
        return this.aij;
    }

    public boolean xG() {
        return this.aik;
    }

    public boolean xH() {
        return this.ail;
    }

    public boolean xI() {
        return this.aii;
    }

    public String xJ() {
        return this.aim;
    }

    public String xK() {
        return this.ain;
    }

    public void aA(boolean z) {
        this.aid = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void db(int i) {
        if (i == 0) {
            this.aic = i;
            a.wZ().az(true);
        } else {
            this.aic = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xL() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aB(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xM() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aC(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aD(boolean z) {
        this.aie = z;
    }

    public void aE(boolean z) {
        this.ail = z;
    }

    public void dV(String str) {
        this.aim = str;
    }

    public void dW(String str) {
        this.ain = str;
    }

    public void aF(boolean z) {
        this.aii = z;
    }

    public void aG(boolean z) {
        this.aik = z;
    }

    public void aH(boolean z) {
        this.aij = z;
    }

    public void aI(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("chat_float_window_switch", z);
    }

    public boolean xN() {
        return com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("chat_float_window_switch", true);
    }

    public void aJ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("permit_screen_lock", z);
    }

    public boolean xO() {
        return com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("permit_screen_lock", true);
    }

    public void aK(boolean z) {
        this.aig = z;
    }

    public void aL(boolean z) {
        this.aif = z;
    }

    public void aM(boolean z) {
        this.aih = z;
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst(), 0, createIntentForSignAlarm, 134217728));
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

    public void dc(int i) {
        if (i == 0) {
            aH(false);
            aF(false);
        } else if (i == 1) {
            aH(true);
            aF(false);
        } else if (i == 2) {
            aH(false);
            aF(true);
        } else {
            aH(true);
            aF(true);
        }
    }

    public int xP() {
        if (!this.aij && !this.aii) {
            return 0;
        }
        if (this.aij && !this.aii) {
            return 1;
        }
        if (!this.aij && this.aii) {
            return 2;
        }
        return 3;
    }

    public void aN(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean xQ() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }
}
