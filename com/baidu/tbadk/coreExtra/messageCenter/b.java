package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.service.SignAlertReceiver;
import java.util.Calendar;
/* loaded from: classes.dex */
public class b {
    private static b bhj = new b();
    public int bhk = 300;
    public boolean bhl = true;
    public boolean bhm = false;
    public boolean bhn = true;
    public boolean bho = true;
    public boolean bhp = true;
    public boolean bhq = false;
    public boolean bhr = true;
    public boolean bhs = true;
    public boolean bht = false;
    public String bhu = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bhv = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private b() {
    }

    public static b GE() {
        return bhj;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bwF();
    }

    public void GF() {
        com.baidu.tieba.tbadkCore.util.a.GF();
    }

    public boolean GG() {
        return this.bhk > 0;
    }

    public int GH() {
        return this.bhk;
    }

    public boolean GI() {
        return this.bhm;
    }

    public boolean GJ() {
        return this.bhn;
    }

    public boolean GK() {
        return this.bhp;
    }

    public boolean GL() {
        return this.bho;
    }

    public boolean GM() {
        return this.bhl;
    }

    public boolean GN() {
        return this.bhr;
    }

    public boolean GO() {
        return this.bhs;
    }

    public boolean GP() {
        return this.bht;
    }

    public boolean GQ() {
        return this.bhq;
    }

    public String GR() {
        return this.bhu;
    }

    public String GS() {
        return this.bhv;
    }

    public void bA(boolean z) {
        this.bhl = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void gT(int i) {
        if (i == 0) {
            this.bhk = i;
            a.Gh().bz(true);
        } else {
            this.bhk = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean GT() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bB(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean GU() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void bC(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void bD(boolean z) {
        this.bhm = z;
    }

    public void bE(boolean z) {
        this.bht = z;
    }

    public void fe(String str) {
        this.bhu = str;
    }

    public void ff(String str) {
        this.bhv = str;
    }

    public void bF(boolean z) {
        this.bhq = z;
    }

    public void bG(boolean z) {
        this.bhs = z;
    }

    public void bH(boolean z) {
        this.bhr = z;
    }

    public void bI(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean GV() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bJ(boolean z) {
        this.bho = z;
    }

    public void bK(boolean z) {
        this.bhn = z;
    }

    public void bL(boolean z) {
        this.bhp = z;
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
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getSystemService(NotificationCompat.CATEGORY_ALARM);
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), 0, createIntentForSignAlarm, 134217728));
            if (BdLog.isDebugMode()) {
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (BdLog.isDebugMode()) {
            }
        }
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
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

    public void gU(int i) {
        if (i == 0) {
            bH(false);
            bF(false);
        } else if (i == 1) {
            bH(true);
            bF(false);
        } else if (i == 2) {
            bH(false);
            bF(true);
        } else {
            bH(true);
            bF(true);
        }
    }

    public int GW() {
        if (!this.bhr && !this.bhq) {
            return 0;
        }
        if (!this.bhr || this.bhq) {
            if (!this.bhr && this.bhq) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bM(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", z);
    }

    public boolean GX() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", true);
    }

    public void bN(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean GY() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
