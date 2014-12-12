package com.baidu.tieba;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.coreExtra.data.BannerData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.service.SignAlertReceiver;
import java.util.Calendar;
/* loaded from: classes.dex */
public class al {
    private static al alh = new al();
    private static final byte[] als = new byte[0];
    private static volatile Boolean alt = null;
    private int mSearchMode;
    private int alg = 0;
    private int CO = 1;
    private com.baidu.tieba.tbadkCore.util.l ali = null;
    private long alj = 0;
    private boolean mHasNewVersion = false;
    private VersionData mVersionData = null;
    private CombineDownload mCombineDownload = null;
    private BannerData alk = null;
    public long jX = 0;
    private int CP = 0;
    private boolean CQ = true;
    private com.baidu.adp.lib.cache.t<String> akF = null;
    private boolean alm = false;
    private boolean aln = true;
    private Boolean alo = false;
    private int alp = 0;
    private boolean alq = false;
    public Handler handler = new Handler(new am(this));
    public Handler alr = new an(this);
    com.baidu.adp.lib.d.d locationCallBack = new ao(this);
    boolean alu = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Aq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005005, new ap());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2005006, new aq());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2005007, new as());
        customMessageTask3.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    public static al Ar() {
        return alh;
    }

    public void init(Application application) {
        if (application != null) {
            new at(null).execute(new String[0]);
            ae.pf();
            initSettings();
            if (TbadkApplication.getInst().isMainProcess(true)) {
                this.ali = new com.baidu.tieba.tbadkCore.util.l(100);
                updateSignAlarm();
            }
        }
    }

    public void As() {
        init(TbadkApplication.getInst().getApp());
    }

    private void initSettings() {
        this.CP = TbadkSettings.getInst().loadInt("image_quality", 0);
        TbadkApplication.getInst().mViewImageQuality = TbadkSettings.getInst().loadInt("view_image_quality", 0);
        this.CQ = TbadkSettings.getInst().loadBoolean("show_images", true);
        this.CO = TbadkSettings.getInst().loadInt("new_display_photo", 1);
        TbadkApplication.getInst().setSkinTypeValue(TbadkSettings.getInst().loadInt("skin", 0));
        this.alj = TbadkSettings.getInst().loadLong("message_id", 0L);
        this.alm = TbadkSettings.getInst().loadBoolean("manage_mode", false);
        this.aln = TbadkSettings.getInst().loadBoolean("search_mode", true);
        this.mSearchMode = TbadkSettings.getInst().loadInt("search_mode_int", 0);
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        com.baidu.adp.lib.d.a.dD().y(loadBoolean);
        com.baidu.tbadk.core.l.mc().initSetting();
        this.alq = TbadkSettings.getInst().loadBoolean("has_show_mutiimage_tip", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(AccountData accountData, Application application) {
        com.baidu.tbadk.coreExtra.messageCenter.a.rI().rM();
        if (accountData != null) {
            TiebaStatic.setUserInfo(accountData.getAccount(), accountData.getID(), TbadkApplication.getCurrentBduss());
        }
        if (TbadkApplication.isLogin()) {
            com.baidu.tieba.runing.a.abX().abY();
            com.baidu.tieba.service.g.aco().abY();
        } else {
            com.baidu.tieba.runing.a.abX().destroy();
            com.baidu.tieba.service.g.aco().destroy();
        }
        TbadkApplication.getInst().resetPbRecorder();
    }

    public boolean isSignAlertOn() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    public int getSignAlertHours() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
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

    public void updateSignAlarm() {
        AlarmManager alarmManager = (AlarmManager) TbadkApplication.getInst().getContext().getSystemService("alarm");
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkApplication.getInst().getContext(), 0, createIntentForSignAlarm, 268435456));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkApplication.getInst().getContext(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    protected Intent createIntentForSignAlarm() {
        Intent intent = new Intent(com.baidu.tbadk.data.b.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkApplication.getInst().getContext(), SignAlertReceiver.class);
        return intent;
    }

    public boolean mg() {
        return this.CQ;
    }

    public void bd(boolean z) {
        this.alu = z;
    }
}
