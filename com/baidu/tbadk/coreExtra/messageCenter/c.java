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
    private static c akV = new c();
    public int akW = 300;
    public boolean akX = true;
    public boolean akY = false;
    public boolean akZ = true;
    public boolean ala = true;
    public boolean alb = true;
    public boolean alc = false;
    public boolean ald = true;
    public boolean ale = true;
    public boolean alf = false;
    public String alg = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String alh = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c za() {
        return akV;
    }

    public void initSetting() {
        m.bkM();
    }

    public void zb() {
        m.zb();
    }

    public boolean zc() {
        return this.akW > 0;
    }

    public int zd() {
        return this.akW;
    }

    public boolean ze() {
        return this.akY;
    }

    public boolean zf() {
        return this.akZ;
    }

    public boolean zg() {
        return this.alb;
    }

    public boolean zh() {
        return this.ala;
    }

    public boolean zi() {
        return this.akX;
    }

    public boolean zj() {
        return this.ald;
    }

    public boolean zk() {
        return this.ale;
    }

    public boolean zl() {
        return this.alf;
    }

    public boolean zm() {
        return this.alc;
    }

    public String zn() {
        return this.alg;
    }

    public String zo() {
        return this.alh;
    }

    public void aP(boolean z) {
        this.akX = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dF(int i) {
        if (i == 0) {
            this.akW = i;
            a.yD().aO(true);
        } else {
            this.akW = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zp() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aQ(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zq() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aR(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aS(boolean z) {
        this.akY = z;
    }

    public void aT(boolean z) {
        this.alf = z;
    }

    public void ev(String str) {
        this.alg = str;
    }

    public void ew(String str) {
        this.alh = str;
    }

    public void aU(boolean z) {
        this.alc = z;
    }

    public void aV(boolean z) {
        this.ale = z;
    }

    public void aW(boolean z) {
        this.ald = z;
    }

    public void aX(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("chat_float_window_switch", z);
    }

    public boolean zr() {
        return com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("chat_float_window_switch", true);
    }

    public void aY(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("permit_screen_lock", z);
    }

    public boolean zs() {
        return com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("permit_screen_lock", true);
    }

    public void aZ(boolean z) {
        this.ala = z;
    }

    public void ba(boolean z) {
        this.akZ = z;
    }

    public void bb(boolean z) {
        this.alb = z;
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

    public void dG(int i) {
        if (i == 0) {
            aW(false);
            aU(false);
        } else if (i == 1) {
            aW(true);
            aU(false);
        } else if (i == 2) {
            aW(false);
            aU(true);
        } else {
            aW(true);
            aU(true);
        }
    }

    public int zt() {
        if (!this.ald && !this.alc) {
            return 0;
        }
        if (this.ald && !this.alc) {
            return 1;
        }
        if (!this.ald && this.alc) {
            return 2;
        }
        return 3;
    }

    public void bc(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean zu() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void bd(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean zv() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
