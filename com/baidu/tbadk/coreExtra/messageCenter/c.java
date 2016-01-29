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
    private static c akN = new c();
    public int akO = 300;
    public boolean akP = true;
    public boolean akQ = false;
    public boolean akR = true;
    public boolean akS = true;
    public boolean akT = true;
    public boolean akU = false;
    public boolean akV = true;
    public boolean akW = true;
    public boolean akX = false;
    public String akY = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String akZ = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c zk() {
        return akN;
    }

    public void initSetting() {
        m.aNu();
    }

    public void zl() {
        m.zl();
    }

    public boolean zm() {
        return this.akO > 0;
    }

    public int zn() {
        return this.akO;
    }

    public boolean zo() {
        return this.akQ;
    }

    public boolean zp() {
        return this.akR;
    }

    public boolean zq() {
        return this.akT;
    }

    public boolean zr() {
        return this.akS;
    }

    public boolean zs() {
        return this.akP;
    }

    public boolean zt() {
        return this.akV;
    }

    public boolean zu() {
        return this.akW;
    }

    public boolean zv() {
        return this.akX;
    }

    public boolean zw() {
        return this.akU;
    }

    public String zx() {
        return this.akY;
    }

    public String zy() {
        return this.akZ;
    }

    public void aC(boolean z) {
        this.akP = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dH(int i) {
        if (i == 0) {
            this.akO = i;
            a.yN().aB(true);
        } else {
            this.akO = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zz() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aD(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zA() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aE(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aF(boolean z) {
        this.akQ = z;
    }

    public void aG(boolean z) {
        this.akX = z;
    }

    public void ei(String str) {
        this.akY = str;
    }

    public void ej(String str) {
        this.akZ = str;
    }

    public void aH(boolean z) {
        this.akU = z;
    }

    public void aI(boolean z) {
        this.akW = z;
    }

    public void aJ(boolean z) {
        this.akV = z;
    }

    public void aK(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("chat_float_window_switch", z);
    }

    public boolean zB() {
        return com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("chat_float_window_switch", true);
    }

    public void aL(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("permit_screen_lock", z);
    }

    public boolean zC() {
        return com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("permit_screen_lock", true);
    }

    public void aM(boolean z) {
        this.akS = z;
    }

    public void aN(boolean z) {
        this.akR = z;
    }

    public void aO(boolean z) {
        this.akT = z;
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

    public void dI(int i) {
        if (i == 0) {
            aJ(false);
            aH(false);
        } else if (i == 1) {
            aJ(true);
            aH(false);
        } else if (i == 2) {
            aJ(false);
            aH(true);
        } else {
            aJ(true);
            aH(true);
        }
    }

    public int zD() {
        if (!this.akV && !this.akU) {
            return 0;
        }
        if (this.akV && !this.akU) {
            return 1;
        }
        if (!this.akV && this.akU) {
            return 2;
        }
        return 3;
    }

    public void aP(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean zE() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }
}
