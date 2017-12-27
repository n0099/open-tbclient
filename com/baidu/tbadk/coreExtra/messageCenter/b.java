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
    private static b bgK = new b();
    public int bgL = 300;
    public boolean bgM = true;
    public boolean bgN = false;
    public boolean bgO = true;
    public boolean bgP = true;
    public boolean bgQ = true;
    public boolean bgR = false;
    public boolean bgS = true;
    public boolean bgT = true;
    public boolean bgU = false;
    public String bgV = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String bgW = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private b() {
    }

    public static b GJ() {
        return bgK;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bDh();
    }

    public void GK() {
        com.baidu.tieba.tbadkCore.util.a.GK();
    }

    public boolean GL() {
        return this.bgL > 0;
    }

    public int GM() {
        return this.bgL;
    }

    public boolean GN() {
        return this.bgN;
    }

    public boolean GO() {
        return this.bgO;
    }

    public boolean GP() {
        return this.bgQ;
    }

    public boolean GQ() {
        return this.bgP;
    }

    public boolean GR() {
        return this.bgM;
    }

    public boolean GS() {
        return this.bgS;
    }

    public boolean GT() {
        return this.bgT;
    }

    public boolean GU() {
        return this.bgU;
    }

    public boolean GV() {
        return this.bgR;
    }

    public String GW() {
        return this.bgV;
    }

    public String GX() {
        return this.bgW;
    }

    public void bz(boolean z) {
        this.bgM = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void gW(int i) {
        if (i == 0) {
            this.bgL = i;
            a.Gm().by(true);
        } else {
            this.bgL = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean GY() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void bA(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean GZ() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void bB(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void bC(boolean z) {
        this.bgN = z;
    }

    public void bD(boolean z) {
        this.bgU = z;
    }

    public void eX(String str) {
        this.bgV = str;
    }

    public void eY(String str) {
        this.bgW = str;
    }

    public void bE(boolean z) {
        this.bgR = z;
    }

    public void bF(boolean z) {
        this.bgT = z;
    }

    public void bG(boolean z) {
        this.bgS = z;
    }

    public void bH(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean Ha() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bI(boolean z) {
        this.bgP = z;
    }

    public void bJ(boolean z) {
        this.bgO = z;
    }

    public void bK(boolean z) {
        this.bgQ = z;
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

    public void gX(int i) {
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

    public int Hb() {
        if (!this.bgS && !this.bgR) {
            return 0;
        }
        if (!this.bgS || this.bgR) {
            if (!this.bgS && this.bgR) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bL(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", z);
    }

    public boolean Hc() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", true);
    }

    public void bM(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean Hd() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
