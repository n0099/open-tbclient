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
    private static c aql = new c();
    public int aqm = 300;
    public boolean aqn = true;
    public boolean aqo = false;
    public boolean aqp = true;
    public boolean aqq = true;
    public boolean aqr = true;
    public boolean aqs = false;
    public boolean aqt = true;
    public boolean aqu = true;
    public boolean aqv = false;
    public String aqw = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aqx = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c zG() {
        return aql;
    }

    public void initSetting() {
        l.bkj();
    }

    public void zH() {
        l.zH();
    }

    public boolean zI() {
        return this.aqm > 0;
    }

    public int zJ() {
        return this.aqm;
    }

    public boolean zK() {
        return this.aqo;
    }

    public boolean zL() {
        return this.aqp;
    }

    public boolean zM() {
        return this.aqr;
    }

    public boolean zN() {
        return this.aqq;
    }

    public boolean zO() {
        return this.aqn;
    }

    public boolean zP() {
        return this.aqt;
    }

    public boolean zQ() {
        return this.aqu;
    }

    public boolean zR() {
        return this.aqv;
    }

    public boolean zS() {
        return this.aqs;
    }

    public String zT() {
        return this.aqw;
    }

    public String zU() {
        return this.aqx;
    }

    public void aV(boolean z) {
        this.aqn = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dI(int i) {
        if (i == 0) {
            this.aqm = i;
            a.zj().aU(true);
        } else {
            this.aqm = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zV() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aW(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zW() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aX(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aY(boolean z) {
        this.aqo = z;
    }

    public void aZ(boolean z) {
        this.aqv = z;
    }

    public void en(String str) {
        this.aqw = str;
    }

    public void eo(String str) {
        this.aqx = str;
    }

    public void ba(boolean z) {
        this.aqs = z;
    }

    public void bb(boolean z) {
        this.aqu = z;
    }

    public void bc(boolean z) {
        this.aqt = z;
    }

    public void bd(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("permit_screen_lock", z);
    }

    public boolean zX() {
        return com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("permit_screen_lock", true);
    }

    public void be(boolean z) {
        this.aqq = z;
    }

    public void bf(boolean z) {
        this.aqp = z;
    }

    public void bg(boolean z) {
        this.aqr = z;
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

    public void dJ(int i) {
        if (i == 0) {
            bc(false);
            ba(false);
        } else if (i == 1) {
            bc(true);
            ba(false);
        } else if (i == 2) {
            bc(false);
            ba(true);
        } else {
            bc(true);
            ba(true);
        }
    }

    public int zY() {
        if (!this.aqt && !this.aqs) {
            return 0;
        }
        if (this.aqt && !this.aqs) {
            return 1;
        }
        if (!this.aqt && this.aqs) {
            return 2;
        }
        return 3;
    }

    public void bh(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean zZ() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void bi(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean Aa() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
