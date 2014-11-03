package com.baidu.tieba;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.atomData.InvokeOnAccountChangedMessageConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bo;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tbadk.plugins.LivePlugin;
import com.baidu.tbadk.plugins.RandChatPlugin;
import com.baidu.tbadk.plugins.XiubaPlugin;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.pb.main.bs;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.SDCardChangeReceiver;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.service.SyncLoginService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.xiuba.StartupReceiver;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class aj {
    private int adN;
    private String adU;
    private PersonChangeData adW;
    private int aea;
    private int aeb;
    private int aec;
    private static aj adw = new aj();
    private static final byte[] adY = new byte[0];
    private static volatile Boolean adZ = null;
    private int adv = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> adx = null;
    private int yR = 1;
    private boolean ady = false;
    private com.baidu.tieba.util.o adz = null;
    private com.baidu.tieba.util.o adA = null;
    private long adB = 0;
    private boolean adC = false;
    private VersionData mVersionData = null;
    private CombineDownload adD = null;
    private BannerData adE = null;
    public long jV = 0;
    private int yS = 0;
    private boolean yT = true;
    private boolean adF = true;
    private boolean adG = false;
    private boolean adH = false;
    private com.baidu.adp.lib.cache.t<String> adI = null;
    private int adJ = 10;
    private int adK = 0;
    private boolean adL = false;
    private boolean adM = true;
    private boolean adO = false;
    private Boolean adP = false;
    private int adQ = 0;
    private Hashtable<String, Integer> adR = null;
    private Hashtable<String, Integer> adS = null;
    private Hashtable<String, Integer> adT = null;
    private boolean adV = false;
    public Handler handler = new Handler(new ak(this));
    public Handler adX = new av(this);
    com.baidu.adp.lib.d.d locationCallBack = new aw(this);
    boolean aed = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void wj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005005, new ax());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2005006, new ay());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2005007, new ba());
        customMessageTask3.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    public void aN(boolean z) {
        this.adO = z;
    }

    public boolean wk() {
        return this.adO;
    }

    private void wl() {
        PluginCenter.createPluginCenter(TbadkApplication.m251getInst());
        if (!PluginCenter.getInstance().checkPluginInstalled(PluginNameList.NAME_NIGHT_RESOURCE)) {
            wm().setSkinType(0);
        }
        if (TbadkApplication.m251getInst().isMainProcess(true)) {
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_NIGHT_RESOURCE, new bb(this));
            this.adX.postDelayed(new bc(this), 300L);
            this.adX.postDelayed(new bd(this), 600L);
            this.adX.postDelayed(new al(this), 900L);
            this.adX.postDelayed(new an(this), 1200L);
            this.adX.postDelayed(new ao(this), 1500L);
            this.adX.postDelayed(new aq(this), 2100L);
            this.adX.postDelayed(new ar(this), 2400L);
        }
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_LIVE);
        if (pluginByName != null) {
            pluginByName.getClassInstance(LivePlugin.class);
        }
        Plugin pluginByName2 = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_RANDCHAT);
        if (pluginByName2 != null) {
            pluginByName2.getClassInstance(RandChatPlugin.class);
        }
    }

    public static aj wm() {
        return adw;
    }

    private static void wn() {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().a(new as());
    }

    public void init(Application application) {
        XiubaPlugin xiubaPlugin;
        Hao123Plugin hao123Plugin;
        if (application != null) {
            ai.init();
            wn();
            new be(null).execute(new String[0]);
            com.baidu.tbadk.core.util.ad.ml();
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.addMessageRule(new com.baidu.tbadk.d.d(0));
            messageManager.addMessageRule(new com.baidu.tbadk.d.a(0));
            messageManager.addResponsedMessageRule(new com.baidu.tbadk.d.c(0));
            messageManager.addRemovedMessageRule(new com.baidu.tbadk.d.b(0));
            if (TbadkApplication.m251getInst().isMainProcess(true)) {
                com.baidu.tbadk.core.sharedPref.b.lk().lm();
            }
            initSettings();
            bo.u(TbadkApplication.m251getInst());
            TbConfig.initBigImageWidth(TbadkApplication.m251getInst());
            TbConfig.initFriendPhotoConfig(TbadkApplication.m251getInst());
            try {
                Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.util.p());
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
            }
            boolean isMainProcess = TbadkApplication.m251getInst().isMainProcess(true);
            TiebaStatic.init(TbadkApplication.m251getInst(), isMainProcess);
            if (!TbadkApplication.m251getInst().isTbCDNTachometerProcess() && !TbadkApplication.m251getInst().isDaemonProcess()) {
                wl();
            }
            if (isMainProcess) {
                if (TbadkApplication.m251getInst().getIsFirstUse()) {
                    com.baidu.adp.lib.b.f.db().clear();
                    if (!TbadkApplication.m251getInst().getCapabilityOfWebp()) {
                        TiebaStatic.eventStat(getApp(), "LocalWebpUnSupport", "");
                    } else {
                        TiebaStatic.eventStat(getApp(), "LocalWebpSupport", "");
                    }
                }
                this.adx = new HashMap<>();
                com.baidu.tieba.util.j.aeK();
                this.adz = new com.baidu.tieba.util.o(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
                this.adA = new com.baidu.tieba.util.o(100);
                wF();
                wt();
                wu();
                wP();
                SDCardChangeReceiver sDCardChangeReceiver = new SDCardChangeReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_EJECT");
                TbadkApplication.m251getInst().registerReceiver(sDCardChangeReceiver, intentFilter);
            } else {
                TbadkApplication.m251getInst().mRemoteActivity = new ArrayList<>();
            }
            com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012000, new at(this));
            aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(aVar);
            wo();
            if (TbadkApplication.m251getInst().isMainProcess(true)) {
                TbadkApplication.m251getInst().sendMessageForEnterBackground();
                wq();
            }
            if (TbadkApplication.m251getInst().isHao123HelperShouldOpen() && TbadkApplication.m251getInst().isTiebaHelperOpen()) {
                try {
                    Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
                    if (pluginByName != null && pluginByName.checkEnable() && (hao123Plugin = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
                        hao123Plugin.openFloating(application);
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            if (TbadkApplication.m251getInst().isXiubaProcess()) {
                Plugin pluginByName2 = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_XIUBA);
                if (pluginByName2 != null && pluginByName2.checkEnable() && (xiubaPlugin = (XiubaPlugin) pluginByName2.getClassInstance(XiubaPlugin.class)) != null) {
                    xiubaPlugin.init(TbadkApplication.m251getInst());
                }
                try {
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.intent.action.BOOT_COMPLETED");
                    intentFilter2.addCategory("android.intent.category.LAUNCHER");
                    application.registerReceiver(new StartupReceiver(), intentFilter2);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    BdLog.e(th2.getMessage());
                }
            }
        }
    }

    private void wo() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012100, new au(this));
        aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
    }

    public Application getApp() {
        return TbadkApplication.m251getInst().getApp();
    }

    public Context getContext() {
        return TbadkApplication.m251getInst();
    }

    public void wp() {
        init(TbadkApplication.m251getInst());
    }

    public void wq() {
        com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
    }

    public boolean dT(String str) {
        return (this.adR == null || str == null || !this.adR.containsKey(str)) ? false : true;
    }

    public void f(String str, int i, int i2) {
        if (!dT(str) && this.adR != null && str != null) {
            if (this.adR.size() > 100) {
                this.adR.clear();
                this.adS.clear();
            }
            this.adR.put(str, Integer.valueOf(i));
            this.adS.put(str, Integer.valueOf(i2));
        }
    }

    public void wr() {
        if (this.adR != null) {
            this.adR.clear();
        }
        if (this.adS != null) {
            this.adS.clear();
        }
    }

    public int dU(String str) {
        if (dT(str)) {
            return this.adS.get(str).intValue();
        }
        return -1;
    }

    public int ws() {
        if (this.adR != null) {
            return this.adR.size();
        }
        return 0;
    }

    public void wt() {
        if (this.adR == null) {
            this.adR = new Hashtable<>();
        }
        if (this.adS == null) {
            this.adS = new Hashtable<>();
        }
    }

    public int dV(String str) {
        if (this.adT == null || str == null || !this.adT.containsKey(str)) {
            return 0;
        }
        return this.adT.get(str).intValue();
    }

    public void dW(String str) {
        if (this.adT != null && str != null) {
            this.adT.put(str, 1);
            aR(true);
            if (this.adT.size() > 200) {
                this.adT.clear();
            }
        }
    }

    public void dX(String str) {
        if (this.adT != null && str != null) {
            this.adT.put(str, -1);
            aR(true);
            if (this.adT.size() > 200) {
                this.adT.clear();
            }
        }
    }

    public void wu() {
        if (this.adT == null) {
            this.adT = new Hashtable<>();
        }
    }

    private void initSettings() {
        this.yS = TbadkSettings.getInst().loadInt("image_quality", 0);
        TbadkApplication.m251getInst().mViewImageQuality = TbadkSettings.getInst().loadInt("view_image_quality", 0);
        this.yT = TbadkSettings.getInst().loadBoolean("show_images", true);
        this.yR = TbadkSettings.getInst().loadInt("new_display_photo", 1);
        TbadkApplication.m251getInst().setSkinTypeValue(TbadkSettings.getInst().loadInt("skin", 0));
        this.adB = TbadkSettings.getInst().loadLong("message_id", 0L);
        this.adH = TbadkSettings.getInst().loadBoolean("app_switcher", false);
        this.adL = TbadkSettings.getInst().loadBoolean("manage_mode", false);
        this.adF = TbadkSettings.getInst().loadBoolean("location_on", true);
        this.adG = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
        this.adK = TbadkSettings.getInst().loadInt("new_vcode_webview_crash_count", 0);
        this.adM = TbadkSettings.getInst().loadBoolean("search_mode", true);
        this.adN = TbadkSettings.getInst().loadInt("search_mode_int", 0);
        this.adJ = TbadkSettings.getInst().loadInt("perform_sample_count", 0);
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        com.baidu.adp.lib.d.a.dE().setBaiduOn(loadBoolean);
        com.baidu.tbadk.core.l.js().initSetting();
        this.adV = TbadkSettings.getInst().loadBoolean("has_show_mutiimage_tip", false);
    }

    public void aO(boolean z) {
        com.baidu.adp.lib.d.a.dE().setBaiduOn(z);
        TbadkSettings.getInst().saveBoolean("bd_loc_switcher", z);
    }

    public void aP(boolean z) {
        this.adM = z;
        TbadkSettings.getInst().saveBoolean("search_mode", z);
    }

    public boolean wv() {
        return this.adM;
    }

    public boolean ww() {
        return this.adF;
    }

    public void aQ(boolean z) {
        TbadkSettings.getInst().saveBoolean("app_switcher", z);
        this.adH = z;
    }

    public boolean wx() {
        return this.adH;
    }

    public com.baidu.adp.widget.a.a dY(String str) {
        SoftReference<com.baidu.adp.widget.a.a> softReference = this.adx.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.a.a dn = TbFaceManager.sh().dn(str);
        if (dn != null) {
            this.adx.put(str, new SoftReference<>(dn));
            return dn;
        }
        return dn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(AccountData accountData, Application application) {
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().oH();
        if (accountData != null) {
            TiebaStatic.setUserInfo(accountData.getAccount(), accountData.getID(), TbadkApplication.getCurrentBduss());
        }
        String str = null;
        if (accountData != null) {
            str = accountData.getAccount();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2005002, new InvokeOnAccountChangedMessageConfig(application, str)));
        if (TbadkApplication.isLogin()) {
            com.baidu.tieba.runing.a.abP().abQ();
            com.baidu.tieba.service.g.abT().abQ();
        } else {
            com.baidu.tieba.runing.a.abP().destroy();
            com.baidu.tieba.service.g.abT().destroy();
        }
        bs.Xc().reset();
    }

    public static void wy() {
        TbadkSettings.getInst().saveLong("tdatabasecreatetime", new Date().getTime());
    }

    public void aR(boolean z) {
        this.ady = z;
    }

    public boolean wz() {
        return this.ady;
    }

    public void aS(boolean z) {
        if (TbadkApplication.m251getInst().mRemindToneOn != z) {
            TbadkApplication.m251getInst().mRemindToneOn = z;
        }
    }

    public void aT(boolean z) {
        TbadkApplication.m251getInst().mNoDisturbOn = z;
    }

    public void dZ(String str) {
        TbadkApplication.m251getInst().mNoDisturbStartTime = str;
    }

    public void ea(String str) {
        TbadkApplication.m251getInst().mNoDisturbEndTime = str;
    }

    public void aU(boolean z) {
        TbadkApplication.m251getInst().mRemindVibrateOn = z;
    }

    public void aV(boolean z) {
        TbadkApplication.m251getInst().mRemindLightOn = z;
    }

    public int wA() {
        if (!TbadkApplication.m251getInst().mRemindToneOn && !TbadkApplication.m251getInst().mRemindVibrateOn) {
            return 0;
        }
        if (TbadkApplication.m251getInst().mRemindToneOn && !TbadkApplication.m251getInst().mRemindVibrateOn) {
            return 1;
        }
        if (!TbadkApplication.m251getInst().mRemindToneOn && TbadkApplication.m251getInst().mRemindVibrateOn) {
            return 2;
        }
        return 3;
    }

    public void dz(int i) {
        if (i == 0) {
            wm().aS(false);
            wm().aU(false);
        } else if (i == 1) {
            wm().aS(true);
            wm().aU(false);
        } else if (i == 2) {
            wm().aS(false);
            wm().aU(true);
        } else {
            wm().aS(true);
            wm().aU(true);
        }
    }

    public void dA(int i) {
        if (i == 0) {
            TbadkApplication.m251getInst().mMsgFrequency = i;
            com.baidu.tbadk.coreExtra.messageCenter.a.oD().ac(true);
            this.handler.sendMessage(this.handler.obtainMessage(3));
        } else {
            TbadkApplication.m251getInst().mMsgFrequency = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
            this.handler.sendMessage(this.handler.obtainMessage(2));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void aW(boolean z) {
        TbadkApplication.m251getInst().mMsgAtmeOn = z;
    }

    public void setMsgZanOn(boolean z) {
        TbadkApplication.m251getInst().setMsgZanOn(z);
    }

    public void aX(boolean z) {
        TbadkApplication.m251getInst().mMsgReplymeOn = z;
    }

    public void aY(boolean z) {
        TbadkApplication.m251getInst().mMsgNewFansOn = z;
    }

    public void aZ(boolean z) {
        TbadkApplication.m251getInst().mMsgChatOn = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean wB() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    public void ba(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        wF();
    }

    public int wC() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            wD();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    private void wD() {
        Calendar calendar = Calendar.getInstance();
        D(calendar.get(11), calendar.get(12));
    }

    public int wE() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            wD();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    public void D(int i, int i2) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        wF();
    }

    public void wF() {
        AlarmManager alarmManager = (AlarmManager) TbadkApplication.m251getInst().getSystemService("alarm");
        Intent wG = wG();
        if (wB()) {
            Calendar calendar = Calendar.getInstance();
            int wC = wC();
            int i = calendar.get(11);
            int wE = wE();
            int i2 = calendar.get(12);
            calendar.set(11, wC);
            calendar.set(12, wE);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= wC && (i != wC || i2 >= wE)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkApplication.m251getInst(), 0, wG, 268435456));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkApplication.m251getInst(), 0, wG, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    protected Intent wG() {
        Intent intent = new Intent(com.baidu.tieba.data.e.yz());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkApplication.m251getInst(), SignAlertReceiver.class);
        return intent;
    }

    public boolean jw() {
        return this.yT;
    }

    public void setSkinType(int i) {
        AppsActivity.Uh();
        TbadkApplication.m251getInst().setSkinTypeValue(i);
        TbadkSettings.getInst().saveInt("skin", i);
        dB(i);
    }

    private void dB(int i) {
        Intent intent = new Intent();
        intent.setAction(com.baidu.tieba.data.e.yx());
        intent.putExtra("skin_type", i);
        TbadkApplication.m251getInst().sendBroadcast(intent);
    }

    public int wH() {
        return this.adJ;
    }

    public void dC(int i) {
        this.adJ = i;
        TbadkSettings.getInst().saveInt("perform_sample_count", i);
    }

    public int wI() {
        return this.adK;
    }

    public void dD(int i) {
        this.adK = i;
        TbadkSettings.getInst().saveInt("new_vcode_webview_crash_count", i);
    }

    public void wJ() {
        int loadInt = TbadkSettings.getInst().loadInt("bd_loc_crash_count", 0) + 1;
        TbadkSettings.getInst().saveInt("bd_loc_crash_count", loadInt);
        if (loadInt > 3) {
            aO(false);
        }
    }

    public void bb(boolean z) {
        this.adC = z;
    }

    public void a(CombineDownload combineDownload) {
        this.adD = combineDownload;
    }

    public VersionData wK() {
        return this.mVersionData;
    }

    public void a(VersionData versionData) {
        this.mVersionData = versionData;
    }

    public com.baidu.tieba.util.o wL() {
        return this.adz;
    }

    public String wM() {
        String bC;
        if (!com.baidu.tbadk.core.util.t.bz("/package.last")) {
            bC = TbadkSettings.getInst().loadString("active_version", "");
        } else {
            bC = com.baidu.tbadk.core.util.t.bC("/package.last");
        }
        if ("active_clear".equals(bC)) {
            return null;
        }
        return bC;
    }

    public void bc(boolean z) {
    }

    public boolean wN() {
        return TbadkSettings.getInst().loadBoolean("first_sync_image_quality", true);
    }

    public void wO() {
        TbadkApplication.m251getInst().setActiveVersion("active_clear");
    }

    public void dE(int i) {
        TbadkSettings.getInst().saveInt("kn_vote_cd", i);
    }

    public void eb(String str) {
        TbadkSettings.getInst().saveString("socket_reconn_strategy", str);
    }

    public void ec(String str) {
        TbadkSettings.getInst().saveString("socket_heartbeat_strategy", str);
    }

    public void ed(String str) {
        TbadkSettings.getInst().saveString("socket_getmsg_strategy", str);
    }

    public void ee(String str) {
        if (str == null) {
            str = "";
        }
        TbadkSettings.getInst().saveString("lcs_switch_strategy", str);
    }

    public void wP() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (!TextUtils.isEmpty(loadString)) {
            com.baidu.tieba.model.af afVar = new com.baidu.tieba.model.af();
            afVar.parserJson(loadString);
            com.baidu.tbadk.coreExtra.websocketBase.h qB = com.baidu.tbadk.coreExtra.websocketBase.h.qB();
            qB.am(afVar.TB() == 1);
            qB.cz(afVar.TC());
            qB.o(afVar.TD() * 1000);
            this.aea = afVar.TF();
            this.aeb = afVar.TG();
            this.aec = afVar.TH();
            if (afVar.TE() != null) {
                qB.b(afVar.TE());
            }
        }
    }

    public void c(int[] iArr) {
        if (iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i : iArr) {
                sb.append(i);
                sb.append("|");
            }
            TbadkSettings.getInst().saveString("socket_time_out", sb.toString());
            com.baidu.adp.framework.c.c.aX().c(iArr[0], iArr[1], iArr[2]);
        }
    }

    public void dF(int i) {
        TbadkSettings.getInst().saveInt("kn_vote_max", i);
    }

    public void dG(int i) {
        TbadkSettings.getInst().saveInt("kn_vote_rate", i);
    }

    public com.baidu.adp.lib.cache.t<String> wQ() {
        if (this.adI == null) {
            this.adI = BdCacheService.cr().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.adI;
    }

    public void wR() {
        try {
            TbadkApplication.m251getInst().startService(new Intent(TbadkApplication.m251getInst(), ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public void wS() {
        TbadkApplication.m251getInst().startService(new Intent(TbadkApplication.m251getInst(), TiebaSyncService.class));
    }

    public void wT() {
        TbadkApplication.m251getInst().stopService(new Intent(TbadkApplication.m251getInst(), TiebaSyncService.class));
    }

    public void wU() {
        TbadkApplication.m251getInst().startService(new Intent(TbadkApplication.m251getInst(), SyncLoginService.class));
    }

    public void wV() {
        TbadkApplication.m251getInst().startService(new Intent(TbadkApplication.m251getInst(), TiebaActiveService.class));
    }

    public void wW() {
        TbadkApplication.m251getInst().stopService(new Intent(TbadkApplication.m251getInst(), TiebaActiveService.class));
    }

    public void bd(boolean z) {
        this.aed = z;
    }

    public void a(PersonChangeData personChangeData) {
        this.adW = personChangeData;
    }

    public void be(boolean z) {
        this.adV = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean wX() {
        return this.adV;
    }

    public String wY() {
        return this.adU;
    }

    public void ef(String str) {
        this.adU = str;
    }
}
