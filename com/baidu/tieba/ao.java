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
import com.baidu.tbadk.coreExtra.data.BannerData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.service.SignAlertReceiver;
import java.util.Calendar;
/* loaded from: classes.dex */
public class ao {
    private static ao alY = new ao();
    private static final byte[] amj = new byte[0];
    private static volatile Boolean amk = null;
    private int ame;
    private int alX = 0;
    private int CK = 1;
    private com.baidu.tieba.tbadkCore.util.l alZ = null;
    private long ama = 0;
    private boolean mHasNewVersion = false;
    private VersionData mVersionData = null;
    private CombineDownload mCombineDownload = null;
    private BannerData amb = null;
    public long kb = 0;
    private int CL = 0;
    private boolean CM = true;
    private com.baidu.adp.lib.cache.t<String> alw = null;
    private boolean amc = false;
    private boolean amd = true;
    private Boolean amf = false;
    private int amg = 0;
    private boolean amh = false;
    public Handler handler = new Handler(new ap(this));
    public Handler ami = new aq(this);
    com.baidu.adp.lib.d.d locationCallBack = new ar(this);
    boolean aml = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void AI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005005, new as());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2005006, new at());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2005007, new av());
        customMessageTask3.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    public static ao AJ() {
        return alY;
    }

    public void init(Application application) {
        if (application != null) {
            new aw(null).execute(new String[0]);
            com.baidu.tbadk.core.util.ae.pb();
            initSettings();
            if (TbadkApplication.getInst().isMainProcess(true)) {
                this.alZ = new com.baidu.tieba.tbadkCore.util.l(100);
                updateSignAlarm();
            }
        }
    }

    public void AK() {
        init(TbadkApplication.getInst().getApp());
    }

    private void initSettings() {
        this.CL = TbadkSettings.getInst().loadInt("image_quality", 0);
        TbadkApplication.getInst().mViewImageQuality = TbadkSettings.getInst().loadInt("view_image_quality", 0);
        this.CM = TbadkSettings.getInst().loadBoolean("show_images", true);
        this.CK = TbadkSettings.getInst().loadInt("new_display_photo", 1);
        TbadkApplication.getInst().setSkinTypeValue(TbadkSettings.getInst().loadInt("skin", 0));
        this.ama = TbadkSettings.getInst().loadLong("message_id", 0L);
        this.amc = TbadkSettings.getInst().loadBoolean("manage_mode", false);
        this.amd = TbadkSettings.getInst().loadBoolean("search_mode", true);
        this.ame = TbadkSettings.getInst().loadInt("search_mode_int", 0);
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        com.baidu.adp.lib.d.a.dB().y(loadBoolean);
        com.baidu.tbadk.core.l.lV().initSetting();
        this.amh = TbadkSettings.getInst().loadBoolean("has_show_mutiimage_tip", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(AccountData accountData, Application application) {
        com.baidu.tbadk.coreExtra.messageCenter.a.rS().rW();
        if (accountData != null) {
            TiebaStatic.setUserInfo(accountData.getAccount(), accountData.getID(), TbadkApplication.getCurrentBduss());
        }
        if (TbadkApplication.isLogin()) {
            com.baidu.tieba.runing.a.acw().acx();
            com.baidu.tieba.service.g.acN().acx();
        } else {
            com.baidu.tieba.runing.a.acw().destroy();
            com.baidu.tieba.service.g.acN().destroy();
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

    public boolean lZ() {
        return this.CM;
    }

    public void bf(boolean z) {
        this.aml = z;
    }
}
