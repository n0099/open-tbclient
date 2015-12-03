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
import com.baidu.tieba.tbadkCore.util.m;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private static c aiR = new c();
    public int aiS = 300;
    public boolean aiT = true;
    public boolean aiU = false;
    public boolean aiV = true;
    public boolean aiW = true;
    public boolean aiX = true;
    public boolean aiY = false;
    public boolean aiZ = true;
    public boolean aja = true;
    public boolean ajb = false;
    public String ajc = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ajd = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c yg() {
        return aiR;
    }

    public void initSetting() {
        m.aEc();
    }

    public void yh() {
        m.yh();
    }

    public boolean yi() {
        return this.aiS > 0;
    }

    public int yj() {
        return this.aiS;
    }

    public boolean yk() {
        return this.aiU;
    }

    public boolean yl() {
        return this.aiV;
    }

    public boolean ym() {
        return this.aiX;
    }

    public boolean yn() {
        return this.aiW;
    }

    public boolean yo() {
        return this.aiT;
    }

    public boolean yp() {
        return this.aiZ;
    }

    public boolean yq() {
        return this.aja;
    }

    public boolean yr() {
        return this.ajb;
    }

    public boolean ys() {
        return this.aiY;
    }

    public String yt() {
        return this.ajc;
    }

    public String yu() {
        return this.ajd;
    }

    public void aE(boolean z) {
        this.aiT = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void ds(int i) {
        if (i == 0) {
            this.aiS = i;
            a.xJ().aD(true);
        } else {
            this.aiS = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean yv() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aF(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean yw() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aG(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aH(boolean z) {
        this.aiU = z;
    }

    public void aI(boolean z) {
        this.ajb = z;
    }

    public void eh(String str) {
        this.ajc = str;
    }

    public void ei(String str) {
        this.ajd = str;
    }

    public void aJ(boolean z) {
        this.aiY = z;
    }

    public void aK(boolean z) {
        this.aja = z;
    }

    public void aL(boolean z) {
        this.aiZ = z;
    }

    public void aM(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("chat_float_window_switch", z);
    }

    public boolean yx() {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("chat_float_window_switch", true);
    }

    public void aN(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("permit_screen_lock", z);
    }

    public boolean yy() {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("permit_screen_lock", true);
    }

    public void aO(boolean z) {
        this.aiW = z;
    }

    public void aP(boolean z) {
        this.aiV = z;
    }

    public void aQ(boolean z) {
        this.aiX = z;
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

    public void dt(int i) {
        if (i == 0) {
            aL(false);
            aJ(false);
        } else if (i == 1) {
            aL(true);
            aJ(false);
        } else if (i == 2) {
            aL(false);
            aJ(true);
        } else {
            aL(true);
            aJ(true);
        }
    }

    public int yz() {
        if (!this.aiZ && !this.aiY) {
            return 0;
        }
        if (this.aiZ && !this.aiY) {
            return 1;
        }
        if (!this.aiZ && this.aiY) {
            return 2;
        }
        return 3;
    }

    public void aR(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean yA() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }
}
