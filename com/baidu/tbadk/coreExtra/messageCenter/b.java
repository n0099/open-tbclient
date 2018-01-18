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
    private static b bhb = new b();
    public int bhc = 300;
    public boolean bhd = true;
    public boolean bhe = false;
    public boolean bhf = true;
    public boolean bhg = true;
    public boolean bhh = true;
    public boolean bhi = false;
    public boolean bhj = true;
    public boolean bhk = true;
    public boolean bhl = false;
    public String bhm = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bhn = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private b() {
    }

    public static b GC() {
        return bhb;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bwD();
    }

    public void GD() {
        com.baidu.tieba.tbadkCore.util.a.GD();
    }

    public boolean GE() {
        return this.bhc > 0;
    }

    public int GF() {
        return this.bhc;
    }

    public boolean GG() {
        return this.bhe;
    }

    public boolean GH() {
        return this.bhf;
    }

    public boolean GI() {
        return this.bhh;
    }

    public boolean GJ() {
        return this.bhg;
    }

    public boolean GK() {
        return this.bhd;
    }

    public boolean GL() {
        return this.bhj;
    }

    public boolean GM() {
        return this.bhk;
    }

    public boolean GN() {
        return this.bhl;
    }

    public boolean GO() {
        return this.bhi;
    }

    public String GP() {
        return this.bhm;
    }

    public String GQ() {
        return this.bhn;
    }

    public void bz(boolean z) {
        this.bhd = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void gT(int i) {
        if (i == 0) {
            this.bhc = i;
            a.Gf().by(true);
        } else {
            this.bhc = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean GR() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bA(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean GS() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void bB(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void bC(boolean z) {
        this.bhe = z;
    }

    public void bD(boolean z) {
        this.bhl = z;
    }

    public void eX(String str) {
        this.bhm = str;
    }

    public void eY(String str) {
        this.bhn = str;
    }

    public void bE(boolean z) {
        this.bhi = z;
    }

    public void bF(boolean z) {
        this.bhk = z;
    }

    public void bG(boolean z) {
        this.bhj = z;
    }

    public void bH(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean GT() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bI(boolean z) {
        this.bhg = z;
    }

    public void bJ(boolean z) {
        this.bhf = z;
    }

    public void bK(boolean z) {
        this.bhh = z;
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
            bG(false);
            bE(false);
        } else if (i == 1) {
            bG(true);
            bE(false);
        } else if (i == 2) {
            bG(false);
            bE(true);
        } else {
            bG(true);
            bE(true);
        }
    }

    public int GU() {
        if (!this.bhj && !this.bhi) {
            return 0;
        }
        if (!this.bhj || this.bhi) {
            if (!this.bhj && this.bhi) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bL(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", z);
    }

    public boolean GV() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", true);
    }

    public void bM(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean GW() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
