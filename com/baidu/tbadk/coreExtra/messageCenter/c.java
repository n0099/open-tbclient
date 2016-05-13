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
    private static c agR = new c();
    public int agS = 300;
    public boolean agT = true;
    public boolean agU = false;
    public boolean agV = true;
    public boolean agW = true;
    public boolean agX = true;
    public boolean agY = false;
    public boolean agZ = true;
    public boolean aha = true;
    public boolean ahb = false;
    public String ahc = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ahd = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c xG() {
        return agR;
    }

    public void initSetting() {
        m.aUW();
    }

    public void xH() {
        m.xH();
    }

    public boolean xI() {
        return this.agS > 0;
    }

    public int xJ() {
        return this.agS;
    }

    public boolean xK() {
        return this.agU;
    }

    public boolean xL() {
        return this.agV;
    }

    public boolean xM() {
        return this.agX;
    }

    public boolean xN() {
        return this.agW;
    }

    public boolean xO() {
        return this.agT;
    }

    public boolean xP() {
        return this.agZ;
    }

    public boolean xQ() {
        return this.aha;
    }

    public boolean xR() {
        return this.ahb;
    }

    public boolean xS() {
        return this.agY;
    }

    public String xT() {
        return this.ahc;
    }

    public String xU() {
        return this.ahd;
    }

    public void aN(boolean z) {
        this.agT = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dp(int i) {
        if (i == 0) {
            this.agS = i;
            a.xj().aM(true);
        } else {
            this.agS = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xV() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m11getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aO(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xW() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aP(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aQ(boolean z) {
        this.agU = z;
    }

    public void aR(boolean z) {
        this.ahb = z;
    }

    public void em(String str) {
        this.ahc = str;
    }

    public void en(String str) {
        this.ahd = str;
    }

    public void aS(boolean z) {
        this.agY = z;
    }

    public void aT(boolean z) {
        this.aha = z;
    }

    public void aU(boolean z) {
        this.agZ = z;
    }

    public void aV(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("chat_float_window_switch", z);
    }

    public boolean xX() {
        return com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("chat_float_window_switch", true);
    }

    public void aW(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("permit_screen_lock", z);
    }

    public boolean xY() {
        return com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("permit_screen_lock", true);
    }

    public void aX(boolean z) {
        this.agW = z;
    }

    public void aY(boolean z) {
        this.agV = z;
    }

    public void aZ(boolean z) {
        this.agX = z;
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
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m11getInst().getSystemService("alarm");
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkCoreApplication.m11getInst(), 0, createIntentForSignAlarm, 134217728));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m11getInst(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.m11getInst(), SignAlertReceiver.class);
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

    public void dq(int i) {
        if (i == 0) {
            aU(false);
            aS(false);
        } else if (i == 1) {
            aU(true);
            aS(false);
        } else if (i == 2) {
            aU(false);
            aS(true);
        } else {
            aU(true);
            aS(true);
        }
    }

    public int xZ() {
        if (!this.agZ && !this.agY) {
            return 0;
        }
        if (this.agZ && !this.agY) {
            return 1;
        }
        if (!this.agZ && this.agY) {
            return 2;
        }
        return 3;
    }

    public void ba(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean ya() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void bb(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean yb() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
