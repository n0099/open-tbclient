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
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.InvokeOnAccountChangedMessageConfig;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.NetWorkCore;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.pb.main.bq;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.SDCardChangeReceiver;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.service.SyncLoginService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.switchs.features.LogSwitchStatic;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class ai {
    private int A;
    private PersonChangeData I;
    private int L;
    private int M;
    private int N;
    private static ai f = new ai();
    private static final byte[] J = new byte[0];
    private static volatile Boolean K = null;
    private int e = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> g = null;
    private int h = 1;
    private boolean i = false;
    private com.baidu.tieba.util.p j = null;
    private com.baidu.tieba.util.p k = null;
    private long l = 0;
    private boolean m = false;
    private VersionData n = null;
    private CombineDownload o = null;
    private BannerData p = null;
    public long a = 0;
    private int q = 0;
    private boolean r = true;
    private boolean s = true;
    private boolean t = false;
    private boolean u = false;
    private com.baidu.adp.lib.cache.s<String> v = null;
    private int w = 10;
    private int x = 0;
    private boolean y = false;
    private boolean z = true;
    private boolean B = false;
    private Boolean C = false;
    private int D = 0;
    private Hashtable<String, Integer> E = null;
    private Hashtable<String, Integer> F = null;
    private Hashtable<String, Integer> G = null;
    private boolean H = false;
    public Handler b = new Handler(new aj(this));
    com.baidu.adp.lib.c.d c = new al(this);
    boolean d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005005, new am());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2005006, new an());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2005007, new ap());
        customMessageTask3.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean b() {
        return this.B;
    }

    private void R() {
        com.baidu.tbadk.tbplugin.m.a(TbadkApplication.m252getInst());
        new com.baidu.tbadk.plugins.a().a(e(), TbadkApplication.m252getInst().isMainProcess(false), TbadkApplication.m252getInst().getIsFirstUse(), new aq(this));
    }

    public static ai c() {
        return f;
    }

    private static void S() {
        DatabaseManager.a(new as());
    }

    public void a(Application application) {
        if (application != null) {
            n.a();
            S();
            new av(null).execute(new String[0]);
            NetWorkCore.j();
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.addMessageRule(new com.baidu.tbadk.a.d(0));
            messageManager.addMessageRule(new com.baidu.tbadk.a.a(0));
            messageManager.addResponsedMessageRule(new com.baidu.tbadk.a.c(0));
            messageManager.addRemovedMessageRule(new com.baidu.tbadk.a.b(0));
            if (TbadkApplication.m252getInst().isMainProcess(true)) {
                com.baidu.tbadk.core.sharedPref.b.a().b();
            }
            U();
            bx.a(TbadkApplication.m252getInst());
            TbConfig.initBigImageWidth(TbadkApplication.m252getInst());
            TbConfig.initFriendPhotoConfig(TbadkApplication.m252getInst());
            try {
                Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.util.q());
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
            }
            R();
            this.b.postDelayed(new at(this, application), 2000L);
            boolean isMainProcess = TbadkApplication.m252getInst().isMainProcess(true);
            TiebaStatic.init(TbadkApplication.m252getInst(), isMainProcess);
            if (isMainProcess) {
                if (TbadkApplication.m252getInst().getIsFirstUse()) {
                    com.baidu.adp.lib.a.f.a().b();
                    if (!TbadkApplication.m252getInst().getCapabilityOfWebp()) {
                        TiebaStatic.eventStat(d(), "LocalWebpUnSupport", "");
                    } else {
                        TiebaStatic.eventStat(d(), "LocalWebpSupport", "");
                    }
                }
                this.g = new HashMap<>();
                com.baidu.tieba.util.k.n();
                TbadkApplication.m252getInst().initFrsImageForums();
                this.j = new com.baidu.tieba.util.p(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
                this.k = new com.baidu.tieba.util.p(100);
                v();
                j();
                k();
                G();
                SDCardChangeReceiver sDCardChangeReceiver = new SDCardChangeReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_EJECT");
                TbadkApplication.m252getInst().registerReceiver(sDCardChangeReceiver, intentFilter);
            } else {
                TbadkApplication.m252getInst().mRemoteActivity = new ArrayList<>();
            }
            com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012000, new au(this));
            aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(aVar);
            T();
            if (TbadkApplication.m252getInst().isMainProcess(true)) {
                TbadkApplication.m252getInst().sendMessageForEnterBackground();
                g();
            }
            Hao123Plugin hao123Plugin = (Hao123Plugin) com.baidu.tbadk.tbplugin.m.a().b(Hao123Plugin.class);
            if (hao123Plugin != null) {
                hao123Plugin.init();
                if (TbadkApplication.m252getInst().isHao123HelperShouldOpen() && TbadkApplication.m252getInst().isTiebaHelperOpen()) {
                    hao123Plugin.openFloating(application);
                }
            }
        }
    }

    private void T() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012100, new ak(this));
        aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
    }

    public Application d() {
        return TbadkApplication.m252getInst().getApp();
    }

    public Context e() {
        return TbadkApplication.m252getInst();
    }

    public void f() {
        a(TbadkApplication.m252getInst());
    }

    public void g() {
        com.baidu.adp.lib.c.a.a().a(true, this.c);
    }

    public boolean a(String str) {
        return (this.E == null || str == null || !this.E.containsKey(str)) ? false : true;
    }

    public void a(String str, int i, int i2) {
        if (!a(str) && this.E != null && str != null) {
            if (this.E.size() > 100) {
                this.E.clear();
                this.F.clear();
            }
            this.E.put(str, Integer.valueOf(i));
            this.F.put(str, Integer.valueOf(i2));
        }
    }

    public void h() {
        if (this.E != null) {
            this.E.clear();
        }
        if (this.F != null) {
            this.F.clear();
        }
    }

    public int b(String str) {
        if (a(str)) {
            return this.E.get(str).intValue();
        }
        return 0;
    }

    public int c(String str) {
        if (a(str)) {
            return this.F.get(str).intValue();
        }
        return -1;
    }

    public int i() {
        if (this.E != null) {
            return this.E.size();
        }
        return 0;
    }

    public void j() {
        if (this.E == null) {
            this.E = new Hashtable<>();
        }
        if (this.F == null) {
            this.F = new Hashtable<>();
        }
    }

    public int d(String str) {
        if (this.G == null || str == null || !this.G.containsKey(str)) {
            return 0;
        }
        return this.G.get(str).intValue();
    }

    public void e(String str) {
        if (this.G != null && str != null) {
            this.G.put(str, 1);
            e(true);
            if (this.G.size() > 200) {
                this.G.clear();
            }
        }
    }

    public void f(String str) {
        if (this.G != null && str != null) {
            this.G.put(str, -1);
            e(true);
            if (this.G.size() > 200) {
                this.G.clear();
            }
        }
    }

    public void k() {
        if (this.G == null) {
            this.G = new Hashtable<>();
        }
    }

    private void U() {
        this.q = com.baidu.tbadk.i.a().a("image_quality", 0);
        TbadkApplication.m252getInst().mViewImageQuality = com.baidu.tbadk.i.a().a("view_image_quality", 0);
        this.r = com.baidu.tbadk.i.a().a("show_images", true);
        this.h = com.baidu.tbadk.i.a().a("new_display_photo", 1);
        TbadkApplication.m252getInst().setSkinTypeValue(com.baidu.tbadk.i.a().a("skin", 0));
        this.l = com.baidu.tbadk.i.a().a("message_id", 0L);
        this.u = com.baidu.tbadk.i.a().a("app_switcher", false);
        this.y = com.baidu.tbadk.i.a().a("manage_mode", false);
        this.s = com.baidu.tbadk.i.a().a("location_on", true);
        this.t = com.baidu.tbadk.i.a().a("has_showed_del_ga_tip", false);
        this.x = com.baidu.tbadk.i.a().a("new_vcode_webview_crash_count", 0);
        this.z = com.baidu.tbadk.i.a().a("search_mode", true);
        this.A = com.baidu.tbadk.i.a().a("search_mode_int", 0);
        this.w = com.baidu.tbadk.i.a().a("perform_sample_count", 0);
        boolean a = com.baidu.tbadk.i.a().a("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            a = false;
        }
        com.baidu.adp.lib.c.a.a().a(a);
        com.baidu.tbadk.core.h.a().b();
        if (com.baidu.adp.lib.a.f.a().b(LogSwitchStatic.LOG) == 0) {
            com.baidu.tbadk.core.log.a.a(true);
        } else {
            com.baidu.tbadk.core.log.a.a(false);
        }
        this.H = com.baidu.tbadk.i.a().a("has_show_mutiimage_tip", false);
    }

    public void b(boolean z) {
        com.baidu.adp.lib.c.a.a().a(z);
        com.baidu.tbadk.i.a().c("bd_loc_switcher", z);
    }

    public void c(boolean z) {
        this.z = z;
        com.baidu.tbadk.i.a().c("search_mode", z);
    }

    public boolean l() {
        return this.z;
    }

    public boolean m() {
        return this.s;
    }

    public void d(boolean z) {
        com.baidu.tbadk.i.a().c("app_switcher", z);
        this.u = z;
    }

    public boolean n() {
        return this.u;
    }

    public com.baidu.adp.widget.a.a g(String str) {
        SoftReference<com.baidu.adp.widget.a.a> softReference = this.g.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.a.a a = TbFaceManager.a().a(str);
        if (a != null) {
            this.g.put(str, new SoftReference<>(a));
            return a;
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(AccountData accountData, Application application) {
        com.baidu.tbadk.coreExtra.messageCenter.a.a().c();
        if (accountData != null) {
            TiebaStatic.setUserInfo(accountData.getAccount(), accountData.getID(), TbadkApplication.getCurrentBduss());
        }
        String str = null;
        if (accountData != null) {
            str = accountData.getAccount();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2005002, new InvokeOnAccountChangedMessageConfig(application, str)));
        o();
        if (TbadkApplication.isLogin()) {
            com.baidu.tieba.runing.a.a().b();
        } else {
            com.baidu.tieba.runing.a.a().d();
        }
        bq.a().f();
        if (accountData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bh(application)));
        }
    }

    public static void o() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2005001));
    }

    public static void p() {
        com.baidu.tbadk.i.a().b("tdatabasecreatetime", new Date().getTime());
    }

    public void e(boolean z) {
        this.i = z;
    }

    public boolean q() {
        return this.i;
    }

    public void f(boolean z) {
        if (TbadkApplication.m252getInst().mRemindToneOn != z) {
            TbadkApplication.m252getInst().mRemindToneOn = z;
        }
    }

    public void g(boolean z) {
        TbadkApplication.m252getInst().mNoDisturbOn = z;
    }

    public void h(String str) {
        TbadkApplication.m252getInst().mNoDisturbStartTime = str;
    }

    public void i(String str) {
        TbadkApplication.m252getInst().mNoDisturbEndTime = str;
    }

    public void h(boolean z) {
        TbadkApplication.m252getInst().mRemindVibrateOn = z;
    }

    public int r() {
        if (!TbadkApplication.m252getInst().mRemindToneOn && !TbadkApplication.m252getInst().mRemindVibrateOn) {
            return 0;
        }
        if (TbadkApplication.m252getInst().mRemindToneOn && !TbadkApplication.m252getInst().mRemindVibrateOn) {
            return 1;
        }
        if (!TbadkApplication.m252getInst().mRemindToneOn && TbadkApplication.m252getInst().mRemindVibrateOn) {
            return 2;
        }
        return 3;
    }

    public void a(int i) {
        if (i == 0) {
            c().f(false);
            c().h(false);
        } else if (i == 1) {
            c().f(true);
            c().h(false);
        } else if (i == 2) {
            c().f(false);
            c().h(true);
        } else {
            c().f(true);
            c().h(true);
        }
    }

    public void b(int i) {
        if (i == 0) {
            TbadkApplication.m252getInst().mMsgFrequency = i;
            com.baidu.tbadk.coreExtra.messageCenter.a.a().a(true);
            this.b.sendMessage(this.b.obtainMessage(3));
            return;
        }
        TbadkApplication.m252getInst().mMsgFrequency = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.b.sendMessage(this.b.obtainMessage(2));
    }

    public void i(boolean z) {
        TbadkApplication.m252getInst().mMsgAtmeOn = z;
        if (!z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().c(0);
        }
    }

    public void j(boolean z) {
        TbadkApplication.m252getInst().mMsgZanOn = z;
    }

    public void k(boolean z) {
        TbadkApplication.m252getInst().mMsgReplymeOn = z;
        if (!z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().b(0);
        }
    }

    public void l(boolean z) {
        TbadkApplication.m252getInst().mMsgChatOn = z;
        if (!z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().d(0);
        }
    }

    public boolean s() {
        return com.baidu.tbadk.i.a().a("alert_sign_on", false);
    }

    public void m(boolean z) {
        com.baidu.tbadk.i.a().c("alert_sign_on", z);
        v();
    }

    public int t() {
        int a = com.baidu.tbadk.i.a().a("alert_sign_hours", -1);
        if (a == -1) {
            V();
            return com.baidu.tbadk.i.a().a("alert_sign_hours", 12);
        }
        return a;
    }

    private void V() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int u() {
        int a = com.baidu.tbadk.i.a().a("alert_sign_mins", -1);
        if (a == -1) {
            V();
            return com.baidu.tbadk.i.a().a("alert_sign_mins", 30);
        }
        return a;
    }

    public void a(int i, int i2) {
        com.baidu.tbadk.i.a().b("alert_sign_hours", i);
        com.baidu.tbadk.i.a().b("alert_sign_mins", i2);
        v();
    }

    public void v() {
        AlarmManager alarmManager = (AlarmManager) TbadkApplication.m252getInst().getSystemService("alarm");
        Intent w = w();
        if (s()) {
            Calendar calendar = Calendar.getInstance();
            int t = t();
            int i = calendar.get(11);
            int u = u();
            int i2 = calendar.get(12);
            calendar.set(11, t);
            calendar.set(12, u);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= t && (i != t || i2 >= u)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkApplication.m252getInst(), 0, w, 268435456));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkApplication.m252getInst(), 0, w, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    protected Intent w() {
        Intent intent = new Intent(com.baidu.tieba.data.e.e());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkApplication.m252getInst(), SignAlertReceiver.class);
        return intent;
    }

    public boolean x() {
        return this.r;
    }

    public void c(int i) {
        AppsActivity.a();
        TbadkApplication.m252getInst().setSkinTypeValue(i);
        com.baidu.tbadk.i.a().b("skin", i);
        i(i);
    }

    private void i(int i) {
        Intent intent = new Intent();
        intent.setAction(com.baidu.tieba.data.e.c());
        intent.putExtra("skin_type", i);
        TbadkApplication.m252getInst().sendBroadcast(intent);
    }

    public int y() {
        return this.w;
    }

    public void d(int i) {
        this.w = i;
        com.baidu.tbadk.i.a().b("perform_sample_count", i);
    }

    public int z() {
        return this.x;
    }

    public void e(int i) {
        this.x = i;
        com.baidu.tbadk.i.a().b("new_vcode_webview_crash_count", i);
    }

    public void A() {
        int a = com.baidu.tbadk.i.a().a("bd_loc_crash_count", 0) + 1;
        com.baidu.tbadk.i.a().b("bd_loc_crash_count", a);
        if (a > 3) {
            b(false);
        }
    }

    public void n(boolean z) {
        this.m = z;
    }

    public void a(CombineDownload combineDownload) {
        this.o = combineDownload;
    }

    public VersionData B() {
        return this.n;
    }

    public void a(VersionData versionData) {
        this.n = versionData;
    }

    public com.baidu.tieba.util.p C() {
        return this.j;
    }

    public String D() {
        String d;
        if (!com.baidu.tbadk.core.util.aa.a("/package.last")) {
            d = com.baidu.tbadk.i.a().b("active_version", "");
        } else {
            d = com.baidu.tbadk.core.util.aa.d("/package.last");
        }
        if ("active_clear".equals(d)) {
            return null;
        }
        return d;
    }

    public void o(boolean z) {
    }

    public boolean E() {
        return com.baidu.tbadk.i.a().a("first_sync_image_quality", true);
    }

    public void F() {
        TbadkApplication.m252getInst().setActiveVersion("active_clear");
    }

    public void f(int i) {
        com.baidu.tbadk.i.a().b("kn_vote_cd", i);
    }

    public void j(String str) {
        com.baidu.tbadk.i.a().a("socket_reconn_strategy", str);
    }

    public void k(String str) {
        com.baidu.tbadk.i.a().a("socket_heartbeat_strategy", str);
    }

    public void l(String str) {
        com.baidu.tbadk.i.a().a("socket_getmsg_strategy", str);
    }

    public void m(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.i.a().a("lcs_switch_strategy", str);
    }

    public void G() {
        String b = com.baidu.tbadk.i.a().b("lcs_switch_strategy", (String) null);
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tieba.model.ad adVar = new com.baidu.tieba.model.ad();
            adVar.a(b);
            com.baidu.tbadk.coreExtra.websocketBase.h a = com.baidu.tbadk.coreExtra.websocketBase.h.a();
            a.a(adVar.a() == 1);
            a.d(adVar.b());
            a.a(adVar.c() * 1000);
            this.L = adVar.e();
            this.M = adVar.f();
            this.N = adVar.g();
            if (adVar.d() != null) {
                a.a(adVar.d());
            }
        }
    }

    public void a(int[] iArr) {
        if (iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i : iArr) {
                sb.append(i);
                sb.append("|");
            }
            com.baidu.tbadk.i.a().a("socket_time_out", sb.toString());
            com.baidu.adp.framework.c.c.a().a(iArr[0], iArr[1], iArr[2]);
        }
    }

    public void g(int i) {
        com.baidu.tbadk.i.a().b("kn_vote_max", i);
    }

    public void h(int i) {
        com.baidu.tbadk.i.a().b("kn_vote_rate", i);
    }

    public com.baidu.adp.lib.cache.s<String> H() {
        if (this.v == null) {
            this.v = BdCacheService.c().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.v;
    }

    public void I() {
        try {
            TbadkApplication.m252getInst().startService(new Intent(TbadkApplication.m252getInst(), ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public void J() {
        TbadkApplication.m252getInst().startService(new Intent(TbadkApplication.m252getInst(), TiebaSyncService.class));
    }

    public void K() {
        TbadkApplication.m252getInst().stopService(new Intent(TbadkApplication.m252getInst(), TiebaSyncService.class));
    }

    public void L() {
        TbadkApplication.m252getInst().startService(new Intent(TbadkApplication.m252getInst(), SyncLoginService.class));
    }

    public void M() {
        TbadkApplication.m252getInst().startService(new Intent(TbadkApplication.m252getInst(), TiebaActiveService.class));
    }

    public void N() {
        TbadkApplication.m252getInst().stopService(new Intent(TbadkApplication.m252getInst(), TiebaActiveService.class));
    }

    public void p(boolean z) {
        this.d = z;
    }

    public void a(PersonChangeData personChangeData) {
        this.I = personChangeData;
    }

    public PersonChangeData O() {
        return this.I;
    }

    public void q(boolean z) {
        this.H = z;
        com.baidu.tbadk.i.a().c("has_show_mutiimage_tip", z);
    }

    public boolean P() {
        return this.H;
    }
}
