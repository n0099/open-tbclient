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
import java.util.Calendar;
/* loaded from: classes.dex */
public class b {
    private static b arJ = new b();
    public int arK = 300;
    public boolean arL = true;
    public boolean arM = false;
    public boolean arN = true;
    public boolean arO = true;
    public boolean arP = true;
    public boolean arQ = false;
    public boolean arR = true;
    public boolean arS = true;
    public boolean arT = false;
    public String arU = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String arV = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private b() {
    }

    public static b yS() {
        return arJ;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bsk();
    }

    public void yT() {
        com.baidu.tieba.tbadkCore.util.a.yT();
    }

    public boolean yU() {
        return this.arK > 0;
    }

    public int yV() {
        return this.arK;
    }

    public boolean yW() {
        return this.arM;
    }

    public boolean yX() {
        return this.arN;
    }

    public boolean yY() {
        return this.arP;
    }

    public boolean yZ() {
        return this.arO;
    }

    public boolean za() {
        return this.arL;
    }

    public boolean zb() {
        return this.arR;
    }

    public boolean zc() {
        return this.arS;
    }

    public boolean zd() {
        return this.arT;
    }

    public boolean ze() {
        return this.arQ;
    }

    public String zf() {
        return this.arU;
    }

    public String zg() {
        return this.arV;
    }

    public void aT(boolean z) {
        this.arL = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dX(int i) {
        if (i == 0) {
            this.arK = i;
            a.yv().aS(true);
        } else {
            this.arK = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zh() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aU(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zi() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aV(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aW(boolean z) {
        this.arM = z;
    }

    public void aX(boolean z) {
        this.arT = z;
    }

    public void eE(String str) {
        this.arU = str;
    }

    public void eF(String str) {
        this.arV = str;
    }

    public void aY(boolean z) {
        this.arQ = z;
    }

    public void aZ(boolean z) {
        this.arS = z;
    }

    public void ba(boolean z) {
        this.arR = z;
    }

    public void bb(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean zj() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void bc(boolean z) {
        this.arO = z;
    }

    public void bd(boolean z) {
        this.arN = z;
    }

    public void be(boolean z) {
        this.arP = z;
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
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getSystemService("alarm");
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

    public void dY(int i) {
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

    public int zk() {
        if (!this.arR && !this.arQ) {
            return 0;
        }
        if (!this.arR || this.arQ) {
            if (!this.arR && this.arQ) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bf(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", z);
    }

    public boolean zl() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", true);
    }

    public void bg(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean zm() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
