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
    private static c ajX = new c();
    public int ajY = 300;
    public boolean ajZ = true;
    public boolean aka = false;
    public boolean akb = true;
    public boolean akc = true;
    public boolean akd = true;
    public boolean ake = false;
    public boolean akf = true;
    public boolean akg = true;
    public boolean akh = false;
    public String aki = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String akj = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c xS() {
        return ajX;
    }

    public void initSetting() {
        m.aGp();
    }

    public void xT() {
        m.xT();
    }

    public boolean xU() {
        return this.ajY > 0;
    }

    public int xV() {
        return this.ajY;
    }

    public boolean xW() {
        return this.aka;
    }

    public boolean xX() {
        return this.akb;
    }

    public boolean xY() {
        return this.akd;
    }

    public boolean xZ() {
        return this.akc;
    }

    public boolean ya() {
        return this.ajZ;
    }

    public boolean yb() {
        return this.akf;
    }

    public boolean yc() {
        return this.akg;
    }

    public boolean yd() {
        return this.akh;
    }

    public boolean ye() {
        return this.ake;
    }

    public String yf() {
        return this.aki;
    }

    public String yg() {
        return this.akj;
    }

    public void aB(boolean z) {
        this.ajZ = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dl(int i) {
        if (i == 0) {
            this.ajY = i;
            a.xv().aA(true);
        } else {
            this.ajY = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean yh() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aC(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean yi() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aD(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aE(boolean z) {
        this.aka = z;
    }

    public void aF(boolean z) {
        this.akh = z;
    }

    public void ek(String str) {
        this.aki = str;
    }

    public void el(String str) {
        this.akj = str;
    }

    public void aG(boolean z) {
        this.ake = z;
    }

    public void aH(boolean z) {
        this.akg = z;
    }

    public void aI(boolean z) {
        this.akf = z;
    }

    public void aJ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("chat_float_window_switch", z);
    }

    public boolean yj() {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("chat_float_window_switch", true);
    }

    public void aK(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("permit_screen_lock", z);
    }

    public boolean yk() {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("permit_screen_lock", true);
    }

    public void aL(boolean z) {
        this.akc = z;
    }

    public void aM(boolean z) {
        this.akb = z;
    }

    public void aN(boolean z) {
        this.akd = z;
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

    public void dm(int i) {
        if (i == 0) {
            aI(false);
            aG(false);
        } else if (i == 1) {
            aI(true);
            aG(false);
        } else if (i == 2) {
            aI(false);
            aG(true);
        } else {
            aI(true);
            aG(true);
        }
    }

    public int yl() {
        if (!this.akf && !this.ake) {
            return 0;
        }
        if (this.akf && !this.ake) {
            return 1;
        }
        if (!this.akf && this.ake) {
            return 2;
        }
        return 3;
    }

    public void aO(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean ym() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }
}
