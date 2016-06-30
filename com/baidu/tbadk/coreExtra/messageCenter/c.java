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
    private static c ahv = new c();
    public int ahw = 300;
    public boolean ahx = true;
    public boolean ahy = false;
    public boolean ahz = true;
    public boolean ahA = true;
    public boolean ahB = true;
    public boolean ahC = false;
    public boolean ahD = true;
    public boolean ahE = true;
    public boolean ahF = false;
    public String ahG = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ahH = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c xK() {
        return ahv;
    }

    public void initSetting() {
        m.bdk();
    }

    public void xL() {
        m.xL();
    }

    public boolean xM() {
        return this.ahw > 0;
    }

    public int xN() {
        return this.ahw;
    }

    public boolean xO() {
        return this.ahy;
    }

    public boolean xP() {
        return this.ahz;
    }

    public boolean xQ() {
        return this.ahB;
    }

    public boolean xR() {
        return this.ahA;
    }

    public boolean xS() {
        return this.ahx;
    }

    public boolean xT() {
        return this.ahD;
    }

    public boolean xU() {
        return this.ahE;
    }

    public boolean xV() {
        return this.ahF;
    }

    public boolean xW() {
        return this.ahC;
    }

    public String xX() {
        return this.ahG;
    }

    public String xY() {
        return this.ahH;
    }

    public void aL(boolean z) {
        this.ahx = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dr(int i) {
        if (i == 0) {
            this.ahw = i;
            a.xn().aK(true);
        } else {
            this.ahw = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xZ() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aM(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean ya() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aN(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aO(boolean z) {
        this.ahy = z;
    }

    public void aP(boolean z) {
        this.ahF = z;
    }

    public void eq(String str) {
        this.ahG = str;
    }

    public void er(String str) {
        this.ahH = str;
    }

    public void aQ(boolean z) {
        this.ahC = z;
    }

    public void aR(boolean z) {
        this.ahE = z;
    }

    public void aS(boolean z) {
        this.ahD = z;
    }

    public void aT(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("chat_float_window_switch", z);
    }

    public boolean yb() {
        return com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("chat_float_window_switch", true);
    }

    public void aU(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("permit_screen_lock", z);
    }

    public boolean yc() {
        return com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("permit_screen_lock", true);
    }

    public void aV(boolean z) {
        this.ahA = z;
    }

    public void aW(boolean z) {
        this.ahz = z;
    }

    public void aX(boolean z) {
        this.ahB = z;
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
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getSystemService("alarm");
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), 0, createIntentForSignAlarm, 134217728));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.m9getInst(), SignAlertReceiver.class);
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

    public void ds(int i) {
        if (i == 0) {
            aS(false);
            aQ(false);
        } else if (i == 1) {
            aS(true);
            aQ(false);
        } else if (i == 2) {
            aS(false);
            aQ(true);
        } else {
            aS(true);
            aQ(true);
        }
    }

    public int yd() {
        if (!this.ahD && !this.ahC) {
            return 0;
        }
        if (this.ahD && !this.ahC) {
            return 1;
        }
        if (!this.ahD && this.ahC) {
            return 2;
        }
        return 3;
    }

    public void aY(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean ye() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void aZ(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean yf() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
