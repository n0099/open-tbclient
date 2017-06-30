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
import com.baidu.tieba.tbadkCore.util.l;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    private static c aqY = new c();
    public int aqZ = 300;
    public boolean ara = true;
    public boolean arb = false;
    public boolean arc = true;
    public boolean ard = true;
    public boolean are = true;
    public boolean arf = false;
    public boolean arg = true;
    public boolean arh = true;
    public boolean ari = false;
    public String arj = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String ark = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c zd() {
        return aqY;
    }

    public void initSetting() {
        l.bno();
    }

    public void ze() {
        l.ze();
    }

    public boolean zf() {
        return this.aqZ > 0;
    }

    public int zg() {
        return this.aqZ;
    }

    public boolean zh() {
        return this.arb;
    }

    public boolean zi() {
        return this.arc;
    }

    public boolean zj() {
        return this.are;
    }

    public boolean zk() {
        return this.ard;
    }

    public boolean zl() {
        return this.ara;
    }

    public boolean zm() {
        return this.arg;
    }

    public boolean zn() {
        return this.arh;
    }

    public boolean zo() {
        return this.ari;
    }

    public boolean zp() {
        return this.arf;
    }

    public String zq() {
        return this.arj;
    }

    public String zr() {
        return this.ark;
    }

    public void aT(boolean z) {
        this.ara = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dJ(int i) {
        if (i == 0) {
            this.aqZ = i;
            a.yG().aS(true);
        } else {
            this.aqZ = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zs() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aU(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zt() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aV(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aW(boolean z) {
        this.arb = z;
    }

    public void aX(boolean z) {
        this.ari = z;
    }

    public void eE(String str) {
        this.arj = str;
    }

    public void eF(String str) {
        this.ark = str;
    }

    public void aY(boolean z) {
        this.arf = z;
    }

    public void aZ(boolean z) {
        this.arh = z;
    }

    public void ba(boolean z) {
        this.arg = z;
    }

    public void bb(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean zu() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bc(boolean z) {
        this.ard = z;
    }

    public void bd(boolean z) {
        this.arc = z;
    }

    public void be(boolean z) {
        this.are = z;
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

    public void dK(int i) {
        if (i == 0) {
            ba(false);
            aY(false);
        } else if (i == 1) {
            ba(true);
            aY(false);
        } else if (i == 2) {
            ba(false);
            aY(true);
        } else {
            ba(true);
            aY(true);
        }
    }

    public int zv() {
        if (!this.arg && !this.arf) {
            return 0;
        }
        if (this.arg && !this.arf) {
            return 1;
        }
        if (!this.arg && this.arf) {
            return 2;
        }
        return 3;
    }

    public void bf(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean zw() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void bg(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean zx() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
