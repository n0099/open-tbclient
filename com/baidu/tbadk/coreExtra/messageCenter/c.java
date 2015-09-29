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
    private static c agY = new c();
    public int agZ = 300;
    public boolean aha = true;
    public boolean ahb = false;
    public boolean ahc = true;
    public boolean ahd = true;
    public boolean ahe = true;
    public boolean ahf = false;
    public boolean ahg = true;
    public boolean ahh = true;
    public boolean ahi = false;
    public String ahj = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ahk = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c xh() {
        return agY;
    }

    public void initSetting() {
        m.axx();
    }

    public void xi() {
        m.xi();
    }

    public boolean xj() {
        return this.agZ > 0;
    }

    public int xk() {
        return this.agZ;
    }

    public boolean xl() {
        return this.ahb;
    }

    public boolean xm() {
        return this.ahc;
    }

    public boolean xn() {
        return this.ahe;
    }

    public boolean xo() {
        return this.ahd;
    }

    public boolean xp() {
        return this.aha;
    }

    public boolean xq() {
        return this.ahg;
    }

    public boolean xr() {
        return this.ahh;
    }

    public boolean xs() {
        return this.ahi;
    }

    public boolean xt() {
        return this.ahf;
    }

    public String xu() {
        return this.ahj;
    }

    public String xv() {
        return this.ahk;
    }

    public void az(boolean z) {
        this.aha = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dc(int i) {
        if (i == 0) {
            this.agZ = i;
            a.wK().ay(true);
        } else {
            this.agZ = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xw() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aA(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xx() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aB(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aC(boolean z) {
        this.ahb = z;
    }

    public void aD(boolean z) {
        this.ahi = z;
    }

    public void dY(String str) {
        this.ahj = str;
    }

    public void dZ(String str) {
        this.ahk = str;
    }

    public void aE(boolean z) {
        this.ahf = z;
    }

    public void aF(boolean z) {
        this.ahh = z;
    }

    public void aG(boolean z) {
        this.ahg = z;
    }

    public void aH(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("chat_float_window_switch", z);
    }

    public boolean xy() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("chat_float_window_switch", true);
    }

    public void aI(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("permit_screen_lock", z);
    }

    public boolean xz() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("permit_screen_lock", true);
    }

    public void aJ(boolean z) {
        this.ahd = z;
    }

    public void aK(boolean z) {
        this.ahc = z;
    }

    public void aL(boolean z) {
        this.ahe = z;
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

    public void dd(int i) {
        if (i == 0) {
            aG(false);
            aE(false);
        } else if (i == 1) {
            aG(true);
            aE(false);
        } else if (i == 2) {
            aG(false);
            aE(true);
        } else {
            aG(true);
            aE(true);
        }
    }

    public int xA() {
        if (!this.ahg && !this.ahf) {
            return 0;
        }
        if (this.ahg && !this.ahf) {
            return 1;
        }
        if (!this.ahg && this.ahf) {
            return 2;
        }
        return 3;
    }

    public void aM(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean xB() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }
}
