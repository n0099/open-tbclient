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
    private static c ale = new c();
    public int alf = 300;
    public boolean alg = true;
    public boolean alh = false;
    public boolean ali = true;
    public boolean alj = true;
    public boolean alk = true;
    public boolean all = false;
    public boolean alm = true;
    public boolean aln = true;
    public boolean alo = false;
    public String alp = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String alq = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private c() {
    }

    public static c zM() {
        return ale;
    }

    public void initSetting() {
        m.aUv();
    }

    public void zN() {
        m.zN();
    }

    public boolean zO() {
        return this.alf > 0;
    }

    public int zP() {
        return this.alf;
    }

    public boolean zQ() {
        return this.alh;
    }

    public boolean zR() {
        return this.ali;
    }

    public boolean zS() {
        return this.alk;
    }

    public boolean zT() {
        return this.alj;
    }

    public boolean zU() {
        return this.alg;
    }

    public boolean zV() {
        return this.alm;
    }

    public boolean zW() {
        return this.aln;
    }

    public boolean zX() {
        return this.alo;
    }

    public boolean zY() {
        return this.all;
    }

    public String zZ() {
        return this.alp;
    }

    public String Aa() {
        return this.alq;
    }

    public void aH(boolean z) {
        this.alg = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dK(int i) {
        if (i == 0) {
            this.alf = i;
            a.zp().aG(true);
        } else {
            this.alf = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean Ab() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aI(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean Ac() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aJ(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aK(boolean z) {
        this.alh = z;
    }

    public void aL(boolean z) {
        this.alo = z;
    }

    public void ep(String str) {
        this.alp = str;
    }

    public void eq(String str) {
        this.alq = str;
    }

    public void aM(boolean z) {
        this.all = z;
    }

    public void aN(boolean z) {
        this.aln = z;
    }

    public void aO(boolean z) {
        this.alm = z;
    }

    public void aP(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("chat_float_window_switch", z);
    }

    public boolean Ad() {
        return com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("chat_float_window_switch", true);
    }

    public void aQ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("permit_screen_lock", z);
    }

    public boolean Ae() {
        return com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("permit_screen_lock", true);
    }

    public void aR(boolean z) {
        this.alj = z;
    }

    public void aS(boolean z) {
        this.ali = z;
    }

    public void aT(boolean z) {
        this.alk = z;
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

    public void dL(int i) {
        if (i == 0) {
            aO(false);
            aM(false);
        } else if (i == 1) {
            aO(true);
            aM(false);
        } else if (i == 2) {
            aO(false);
            aM(true);
        } else {
            aO(true);
            aM(true);
        }
    }

    public int Af() {
        if (!this.alm && !this.all) {
            return 0;
        }
        if (this.alm && !this.all) {
            return 1;
        }
        if (!this.alm && this.all) {
            return 2;
        }
        return 3;
    }

    public void aU(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", z);
    }

    public boolean Ag() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_switch", true);
    }

    public void aV(boolean z) {
        TbadkSettings.getInst().saveBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", z);
    }

    public boolean Ah() {
        return TbadkSettings.getInst().loadBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_forum_broadcast_switch", true);
    }
}
