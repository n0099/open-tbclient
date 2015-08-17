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
    private static c ahS = new c();
    public int ahT = 300;
    public boolean ahU = true;
    public boolean ahV = false;
    public boolean ahW = true;
    public boolean ahX = true;
    public boolean ahY = true;
    public boolean ahZ = false;
    public boolean aia = true;
    public boolean aib = true;
    public boolean aic = false;
    public String aid = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aie = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c xq() {
        return ahS;
    }

    public void initSetting() {
        k.aqW();
    }

    public void xr() {
        k.xr();
    }

    public boolean xs() {
        return this.ahT > 0;
    }

    public int xt() {
        return this.ahT;
    }

    public boolean xu() {
        return this.ahV;
    }

    public boolean xv() {
        return this.ahW;
    }

    public boolean xw() {
        return this.ahY;
    }

    public boolean xx() {
        return this.ahX;
    }

    public boolean xy() {
        return this.ahU;
    }

    public boolean xz() {
        return this.aia;
    }

    public boolean xA() {
        return this.aib;
    }

    public boolean xB() {
        return this.aic;
    }

    public boolean xC() {
        return this.ahZ;
    }

    public String xD() {
        return this.aid;
    }

    public String xE() {
        return this.aie;
    }

    public void aA(boolean z) {
        this.ahU = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void cV(int i) {
        if (i == 0) {
            this.ahT = i;
            a.wT().az(true);
        } else {
            this.ahT = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xF() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aB(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xG() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aC(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aD(boolean z) {
        this.ahV = z;
    }

    public void aE(boolean z) {
        this.aic = z;
    }

    public void dO(String str) {
        this.aid = str;
    }

    public void dP(String str) {
        this.aie = str;
    }

    public void aF(boolean z) {
        this.ahZ = z;
    }

    public void aG(boolean z) {
        this.aib = z;
    }

    public void aH(boolean z) {
        this.aia = z;
    }

    public void aI(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("chat_float_window_switch", z);
    }

    public boolean xH() {
        return com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("chat_float_window_switch", true);
    }

    public void aJ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("permit_screen_lock", z);
    }

    public boolean xI() {
        return com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("permit_screen_lock", true);
    }

    public void aK(boolean z) {
        this.ahX = z;
    }

    public void aL(boolean z) {
        this.ahW = z;
    }

    public void aM(boolean z) {
        this.ahY = z;
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

    public void cW(int i) {
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

    public int xJ() {
        if (!this.aia && !this.ahZ) {
            return 0;
        }
        if (this.aia && !this.ahZ) {
            return 1;
        }
        if (!this.aia && this.ahZ) {
            return 2;
        }
        return 3;
    }
}
