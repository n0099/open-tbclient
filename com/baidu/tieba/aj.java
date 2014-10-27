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
import com.baidu.tbadk.core.util.bn;
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
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class aj {
    private int adI;
    private String adP;
    private PersonChangeData adR;
    private int adU;
    private int adV;
    private int adW;
    private static aj adr = new aj();
    private static final byte[] adS = new byte[0];
    private static volatile Boolean adT = null;
    private int adq = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> ads = null;
    private int yR = 1;
    private boolean adt = false;
    private com.baidu.tieba.util.o adu = null;
    private com.baidu.tieba.util.o adv = null;
    private long adw = 0;
    private boolean adx = false;
    private VersionData mVersionData = null;
    private CombineDownload ady = null;
    private BannerData adz = null;
    public long jV = 0;
    private int yS = 0;
    private boolean yT = true;
    private boolean adA = true;
    private boolean adB = false;
    private boolean adC = false;
    private com.baidu.adp.lib.cache.t<String> adD = null;
    private int adE = 10;
    private int adF = 0;
    private boolean adG = false;
    private boolean adH = true;
    private boolean adJ = false;
    private Boolean adK = false;
    private int adL = 0;
    private Hashtable<String, Integer> adM = null;
    private Hashtable<String, Integer> adN = null;
    private Hashtable<String, Integer> adO = null;
    private boolean adQ = false;
    public Handler handler = new Handler(new ak(this));
    com.baidu.adp.lib.d.d locationCallBack = new am(this);
    boolean adX = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void wh() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005005, new an());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2005006, new ao());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2005007, new aq());
        customMessageTask3.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    public void aN(boolean z) {
        this.adJ = z;
    }

    public boolean wi() {
        return this.adJ;
    }

    private void wj() {
        PluginCenter.createPluginCenter(TbadkApplication.m251getInst());
        if (!PluginCenter.getInstance().checkPluginInstalled(PluginNameList.NAME_NIGHT_RESOURCE)) {
            wk().setSkinType(0);
        }
        if (TbadkApplication.m251getInst().isMainProcess(true)) {
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_SOCIAL_SHARE, null);
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_RANDCHAT, new ar(this));
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_DQ_SDK, null);
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_LIVE, new as(this));
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_NIGHT_RESOURCE, null);
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_ZXING, null);
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_HAO123, null);
            PluginCenter.getInstance().installPluginFromAsset(PluginNameList.NAME_BAOBAO, null);
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

    public static aj wk() {
        return adr;
    }

    private static void wl() {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().a(new at());
    }

    public void init(Application application) {
        Plugin pluginByName;
        XiubaPlugin xiubaPlugin;
        Hao123Plugin hao123Plugin;
        if (application != null) {
            ai.init();
            wl();
            new av(null).execute(new String[0]);
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
            bn.u(TbadkApplication.m251getInst());
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
                wj();
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
                this.ads = new HashMap<>();
                com.baidu.tieba.util.j.aeH();
                this.adu = new com.baidu.tieba.util.o(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
                this.adv = new com.baidu.tieba.util.o(100);
                wD();
                wr();
                ws();
                wN();
                SDCardChangeReceiver sDCardChangeReceiver = new SDCardChangeReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_EJECT");
                TbadkApplication.m251getInst().registerReceiver(sDCardChangeReceiver, intentFilter);
            } else {
                TbadkApplication.m251getInst().mRemoteActivity = new ArrayList<>();
            }
            com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012000, new au(this));
            aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(aVar);
            wm();
            if (TbadkApplication.m251getInst().isMainProcess(true)) {
                TbadkApplication.m251getInst().sendMessageForEnterBackground();
                wo();
            }
            if (TbadkApplication.m251getInst().isHao123HelperShouldOpen() && TbadkApplication.m251getInst().isTiebaHelperOpen()) {
                try {
                    Plugin pluginByName2 = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
                    if (pluginByName2 != null && pluginByName2.checkEnable() && (hao123Plugin = (Hao123Plugin) pluginByName2.getClassInstance(Hao123Plugin.class)) != null) {
                        hao123Plugin.openFloating(application);
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            if (TbadkApplication.m251getInst().isXiubaProcess() && (pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_XIUBA)) != null && pluginByName.checkEnable() && (xiubaPlugin = (XiubaPlugin) pluginByName.getClassInstance(XiubaPlugin.class)) != null) {
                xiubaPlugin.init(TbadkApplication.m251getInst());
            }
        }
    }

    private void wm() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012100, new al(this));
        aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
    }

    public Application getApp() {
        return TbadkApplication.m251getInst().getApp();
    }

    public Context getContext() {
        return TbadkApplication.m251getInst();
    }

    public void wn() {
        init(TbadkApplication.m251getInst());
    }

    public void wo() {
        com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
    }

    public boolean dT(String str) {
        return (this.adM == null || str == null || !this.adM.containsKey(str)) ? false : true;
    }

    public void f(String str, int i, int i2) {
        if (!dT(str) && this.adM != null && str != null) {
            if (this.adM.size() > 100) {
                this.adM.clear();
                this.adN.clear();
            }
            this.adM.put(str, Integer.valueOf(i));
            this.adN.put(str, Integer.valueOf(i2));
        }
    }

    public void wp() {
        if (this.adM != null) {
            this.adM.clear();
        }
        if (this.adN != null) {
            this.adN.clear();
        }
    }

    public int dU(String str) {
        if (dT(str)) {
            return this.adN.get(str).intValue();
        }
        return -1;
    }

    public int wq() {
        if (this.adM != null) {
            return this.adM.size();
        }
        return 0;
    }

    public void wr() {
        if (this.adM == null) {
            this.adM = new Hashtable<>();
        }
        if (this.adN == null) {
            this.adN = new Hashtable<>();
        }
    }

    public int dV(String str) {
        if (this.adO == null || str == null || !this.adO.containsKey(str)) {
            return 0;
        }
        return this.adO.get(str).intValue();
    }

    public void dW(String str) {
        if (this.adO != null && str != null) {
            this.adO.put(str, 1);
            aR(true);
            if (this.adO.size() > 200) {
                this.adO.clear();
            }
        }
    }

    public void dX(String str) {
        if (this.adO != null && str != null) {
            this.adO.put(str, -1);
            aR(true);
            if (this.adO.size() > 200) {
                this.adO.clear();
            }
        }
    }

    public void ws() {
        if (this.adO == null) {
            this.adO = new Hashtable<>();
        }
    }

    private void initSettings() {
        this.yS = TbadkSettings.getInst().loadInt("image_quality", 0);
        TbadkApplication.m251getInst().mViewImageQuality = TbadkSettings.getInst().loadInt("view_image_quality", 0);
        this.yT = TbadkSettings.getInst().loadBoolean("show_images", true);
        this.yR = TbadkSettings.getInst().loadInt("new_display_photo", 1);
        TbadkApplication.m251getInst().setSkinTypeValue(TbadkSettings.getInst().loadInt("skin", 0));
        this.adw = TbadkSettings.getInst().loadLong("message_id", 0L);
        this.adC = TbadkSettings.getInst().loadBoolean("app_switcher", false);
        this.adG = TbadkSettings.getInst().loadBoolean("manage_mode", false);
        this.adA = TbadkSettings.getInst().loadBoolean("location_on", true);
        this.adB = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
        this.adF = TbadkSettings.getInst().loadInt("new_vcode_webview_crash_count", 0);
        this.adH = TbadkSettings.getInst().loadBoolean("search_mode", true);
        this.adI = TbadkSettings.getInst().loadInt("search_mode_int", 0);
        this.adE = TbadkSettings.getInst().loadInt("perform_sample_count", 0);
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        com.baidu.adp.lib.d.a.dE().setBaiduOn(loadBoolean);
        com.baidu.tbadk.core.k.js().initSetting();
        this.adQ = TbadkSettings.getInst().loadBoolean("has_show_mutiimage_tip", false);
    }

    public void aO(boolean z) {
        com.baidu.adp.lib.d.a.dE().setBaiduOn(z);
        TbadkSettings.getInst().saveBoolean("bd_loc_switcher", z);
    }

    public void aP(boolean z) {
        this.adH = z;
        TbadkSettings.getInst().saveBoolean("search_mode", z);
    }

    public boolean wt() {
        return this.adH;
    }

    public boolean wu() {
        return this.adA;
    }

    public void aQ(boolean z) {
        TbadkSettings.getInst().saveBoolean("app_switcher", z);
        this.adC = z;
    }

    public boolean wv() {
        return this.adC;
    }

    public com.baidu.adp.widget.a.a dY(String str) {
        SoftReference<com.baidu.adp.widget.a.a> softReference = this.ads.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.a.a dn = TbFaceManager.sf().dn(str);
        if (dn != null) {
            this.ads.put(str, new SoftReference<>(dn));
            return dn;
        }
        return dn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(AccountData accountData, Application application) {
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oF();
        if (accountData != null) {
            TiebaStatic.setUserInfo(accountData.getAccount(), accountData.getID(), TbadkApplication.getCurrentBduss());
        }
        String str = null;
        if (accountData != null) {
            str = accountData.getAccount();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2005002, new InvokeOnAccountChangedMessageConfig(application, str)));
        if (TbadkApplication.isLogin()) {
            com.baidu.tieba.runing.a.abM().abN();
            com.baidu.tieba.service.g.abQ().abN();
        } else {
            com.baidu.tieba.runing.a.abM().destroy();
            com.baidu.tieba.service.g.abQ().destroy();
        }
        bs.WZ().reset();
    }

    public static void ww() {
        TbadkSettings.getInst().saveLong("tdatabasecreatetime", new Date().getTime());
    }

    public void aR(boolean z) {
        this.adt = z;
    }

    public boolean wx() {
        return this.adt;
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

    public int wy() {
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
            wk().aS(false);
            wk().aU(false);
        } else if (i == 1) {
            wk().aS(true);
            wk().aU(false);
        } else if (i == 2) {
            wk().aS(false);
            wk().aU(true);
        } else {
            wk().aS(true);
            wk().aU(true);
        }
    }

    public void dA(int i) {
        if (i == 0) {
            TbadkApplication.m251getInst().mMsgFrequency = i;
            com.baidu.tbadk.coreExtra.messageCenter.a.oB().ac(true);
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

    public boolean wz() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    public void ba(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        wD();
    }

    public int wA() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            wB();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    private void wB() {
        Calendar calendar = Calendar.getInstance();
        D(calendar.get(11), calendar.get(12));
    }

    public int wC() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            wB();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    public void D(int i, int i2) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        wD();
    }

    public void wD() {
        AlarmManager alarmManager = (AlarmManager) TbadkApplication.m251getInst().getSystemService("alarm");
        Intent wE = wE();
        if (wz()) {
            Calendar calendar = Calendar.getInstance();
            int wA = wA();
            int i = calendar.get(11);
            int wC = wC();
            int i2 = calendar.get(12);
            calendar.set(11, wA);
            calendar.set(12, wC);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= wA && (i != wA || i2 >= wC)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkApplication.m251getInst(), 0, wE, 268435456));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkApplication.m251getInst(), 0, wE, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    protected Intent wE() {
        Intent intent = new Intent(com.baidu.tieba.data.e.yx());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkApplication.m251getInst(), SignAlertReceiver.class);
        return intent;
    }

    public boolean jw() {
        return this.yT;
    }

    public void setSkinType(int i) {
        AppsActivity.Ue();
        TbadkApplication.m251getInst().setSkinTypeValue(i);
        TbadkSettings.getInst().saveInt("skin", i);
        dB(i);
    }

    private void dB(int i) {
        Intent intent = new Intent();
        intent.setAction(com.baidu.tieba.data.e.yv());
        intent.putExtra("skin_type", i);
        TbadkApplication.m251getInst().sendBroadcast(intent);
    }

    public int wF() {
        return this.adE;
    }

    public void dC(int i) {
        this.adE = i;
        TbadkSettings.getInst().saveInt("perform_sample_count", i);
    }

    public int wG() {
        return this.adF;
    }

    public void dD(int i) {
        this.adF = i;
        TbadkSettings.getInst().saveInt("new_vcode_webview_crash_count", i);
    }

    public void wH() {
        int loadInt = TbadkSettings.getInst().loadInt("bd_loc_crash_count", 0) + 1;
        TbadkSettings.getInst().saveInt("bd_loc_crash_count", loadInt);
        if (loadInt > 3) {
            aO(false);
        }
    }

    public void bb(boolean z) {
        this.adx = z;
    }

    public void a(CombineDownload combineDownload) {
        this.ady = combineDownload;
    }

    public VersionData wI() {
        return this.mVersionData;
    }

    public void a(VersionData versionData) {
        this.mVersionData = versionData;
    }

    public com.baidu.tieba.util.o wJ() {
        return this.adu;
    }

    public String wK() {
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

    public boolean wL() {
        return TbadkSettings.getInst().loadBoolean("first_sync_image_quality", true);
    }

    public void wM() {
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

    public void wN() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (!TextUtils.isEmpty(loadString)) {
            com.baidu.tieba.model.af afVar = new com.baidu.tieba.model.af();
            afVar.parserJson(loadString);
            com.baidu.tbadk.coreExtra.websocketBase.h qz = com.baidu.tbadk.coreExtra.websocketBase.h.qz();
            qz.am(afVar.Ty() == 1);
            qz.cz(afVar.Tz());
            qz.o(afVar.TA() * 1000);
            this.adU = afVar.TC();
            this.adV = afVar.TD();
            this.adW = afVar.TE();
            if (afVar.TB() != null) {
                qz.b(afVar.TB());
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

    public com.baidu.adp.lib.cache.t<String> wO() {
        if (this.adD == null) {
            this.adD = BdCacheService.cr().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.adD;
    }

    public void wP() {
        try {
            TbadkApplication.m251getInst().startService(new Intent(TbadkApplication.m251getInst(), ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public void wQ() {
        TbadkApplication.m251getInst().startService(new Intent(TbadkApplication.m251getInst(), TiebaSyncService.class));
    }

    public void wR() {
        TbadkApplication.m251getInst().stopService(new Intent(TbadkApplication.m251getInst(), TiebaSyncService.class));
    }

    public void wS() {
        TbadkApplication.m251getInst().startService(new Intent(TbadkApplication.m251getInst(), SyncLoginService.class));
    }

    public void wT() {
        TbadkApplication.m251getInst().startService(new Intent(TbadkApplication.m251getInst(), TiebaActiveService.class));
    }

    public void wU() {
        TbadkApplication.m251getInst().stopService(new Intent(TbadkApplication.m251getInst(), TiebaActiveService.class));
    }

    public void bd(boolean z) {
        this.adX = z;
    }

    public void a(PersonChangeData personChangeData) {
        this.adR = personChangeData;
    }

    public void be(boolean z) {
        this.adQ = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean wV() {
        return this.adQ;
    }

    public String wW() {
        return this.adP;
    }

    public void ef(String str) {
        this.adP = str;
    }
}
