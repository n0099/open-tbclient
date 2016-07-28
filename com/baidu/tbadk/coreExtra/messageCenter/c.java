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
    private static c aik = new c();
    public int ail = 300;
    public boolean aim = true;
    public boolean ain = false;
    public boolean aio = true;
    public boolean aip = true;
    public boolean aiq = true;
    public boolean air = false;
    public boolean ais = true;
    public boolean ait = true;
    public boolean aiu = false;
    public String aiv = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aiw = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c xK() {
        return aik;
    }

    public void initSetting() {
        m.bgz();
    }

    public void xL() {
        m.xL();
    }

    public boolean xM() {
        return this.ail > 0;
    }

    public int xN() {
        return this.ail;
    }

    public boolean xO() {
        return this.ain;
    }

    public boolean xP() {
        return this.aio;
    }

    public boolean xQ() {
        return this.aiq;
    }

    public boolean xR() {
        return this.aip;
    }

    public boolean xS() {
        return this.aim;
    }

    public boolean xT() {
        return this.ais;
    }

    public boolean xU() {
        return this.ait;
    }

    public boolean xV() {
        return this.aiu;
    }

    public boolean xW() {
        return this.air;
    }

    public String xX() {
        return this.aiv;
    }

    public String xY() {
        return this.aiw;
    }

    public void aO(boolean z) {
        this.aim = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dr(int i) {
        if (i == 0) {
            this.ail = i;
            a.xn().aN(true);
        } else {
            this.ail = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean xZ() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m10getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aP(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean ya() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aQ(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aR(boolean z) {
        this.ain = z;
    }

    public void aS(boolean z) {
        this.aiu = z;
    }

    public void ep(String str) {
        this.aiv = str;
    }

    public void eq(String str) {
        this.aiw = str;
    }

    public void aT(boolean z) {
        this.air = z;
    }

    public void aU(boolean z) {
        this.ait = z;
    }

    public void aV(boolean z) {
        this.ais = z;
    }

    public void aW(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("chat_float_window_switch", z);
    }

    public boolean yb() {
        return com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("chat_float_window_switch", true);
    }

    public void aX(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("permit_screen_lock", z);
    }

    public boolean yc() {
        return com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("permit_screen_lock", true);
    }

    public void aY(boolean z) {
        this.aip = z;
    }

    public void aZ(boolean z) {
        this.aio = z;
    }

    public void ba(boolean z) {
        this.aiq = z;
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
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m10getInst().getSystemService("alarm");
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkCoreApplication.m10getInst(), 0, createIntentForSignAlarm, 134217728));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m10getInst(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.m10getInst(), SignAlertReceiver.class);
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
            aV(false);
            aT(false);
        } else if (i == 1) {
            aV(true);
            aT(false);
        } else if (i == 2) {
            aV(false);
            aT(true);
        } else {
            aV(true);
            aT(true);
        }
    }

    public int yd() {
        if (!this.ais && !this.air) {
            return 0;
        }
        if (this.ais && !this.air) {
            return 1;
        }
        if (!this.ais && this.air) {
            return 2;
        }
        return 3;
    }

    public void bb(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean ye() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void bc(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean yf() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
