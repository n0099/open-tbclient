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
    private static b asc = new b();
    public int asd = 300;
    public boolean ase = true;
    public boolean asf = false;
    public boolean asg = true;
    public boolean ash = true;
    public boolean asi = true;
    public boolean asj = false;
    public boolean ask = true;
    public boolean asl = true;
    public boolean asm = false;
    public String asn = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String aso = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    private b() {
    }

    public static b yZ() {
        return asc;
    }

    public void initSetting() {
        com.baidu.tieba.tbadkCore.util.a.bvo();
    }

    public void za() {
        com.baidu.tieba.tbadkCore.util.a.za();
    }

    public boolean zb() {
        return this.asd > 0;
    }

    public int zc() {
        return this.asd;
    }

    public boolean zd() {
        return this.asf;
    }

    public boolean ze() {
        return this.asg;
    }

    public boolean zf() {
        return this.asi;
    }

    public boolean zg() {
        return this.ash;
    }

    public boolean zh() {
        return this.ase;
    }

    public boolean zi() {
        return this.ask;
    }

    public boolean zj() {
        return this.asl;
    }

    public boolean zk() {
        return this.asm;
    }

    public boolean zl() {
        return this.asj;
    }

    public String zm() {
        return this.asn;
    }

    public String zn() {
        return this.aso;
    }

    public void aR(boolean z) {
        this.ase = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public void dY(int i) {
        if (i == 0) {
            this.asd = i;
            a.yC().aQ(true);
        } else {
            this.asd = 300;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zo() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true) && TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
    }

    public void aS(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean zp() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), true);
    }

    public void aT(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void aU(boolean z) {
        this.asf = z;
    }

    public void aV(boolean z) {
        this.asm = z;
    }

    public void eL(String str) {
        this.asn = str;
    }

    public void eM(String str) {
        this.aso = str;
    }

    public void aW(boolean z) {
        this.asj = z;
    }

    public void aX(boolean z) {
        this.asl = z;
    }

    public void aY(boolean z) {
        this.ask = z;
    }

    public void aZ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("permit_screen_lock", z);
    }

    public boolean zq() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("permit_screen_lock", true);
    }

    public void ba(boolean z) {
        this.ash = z;
    }

    public void bb(boolean z) {
        this.asg = z;
    }

    public void bc(boolean z) {
        this.asi = z;
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

    public void dZ(int i) {
        if (i == 0) {
            aY(false);
            aW(false);
        } else if (i == 1) {
            aY(true);
            aW(false);
        } else if (i == 2) {
            aY(false);
            aW(true);
        } else {
            aY(true);
            aW(true);
        }
    }

    public int zr() {
        if (!this.ask && !this.asj) {
            return 0;
        }
        if (!this.ask || this.asj) {
            if (!this.ask && this.asj) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void bd(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", z);
    }

    public boolean zs() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_switch", true);
    }

    public void be(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public boolean zt() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }
}
