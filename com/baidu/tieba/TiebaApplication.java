package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.common.util.CommonParam;
import com.baidu.bdcvf.CertVerifier;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.frontia.FrontiaApplication;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbplugin.plugins.BdBrowserDelegate;
import com.baidu.tieba.account.SapiFastRegActivity;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.im.util.LimitList;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.switchs.SwitchModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.util.cc;
import com.baidu.tieba.util.ce;
import com.baidu.tieba.util.ch;
import com.compatible.smartbarutil.SmartBarUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class TiebaApplication extends com.baidu.adp.a.b {
    private static TiebaApplication g;
    private int U;
    private boolean al;
    private PersonChangeData am;
    private Boolean z;
    private static AccountData j = null;
    private static String o = null;
    private static String s = "armcv";
    private static boolean X = false;
    private static Intent ab = null;
    private static Application an = null;
    private static final byte[] aA = new byte[0];
    private static volatile Boolean aB = null;
    private int f = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.b>> h = null;
    private int i = 1;
    private boolean k = false;
    private bo l = null;
    private bo m = null;
    private String n = null;
    private int p = 0;
    private long q = 0;
    private long r = 0;
    private long t = -1;
    private String u = null;
    private boolean v = false;
    private VersionData w = null;
    private CombineDownload x = null;
    private BannerData y = null;
    public long a = 0;
    private ExecutorService A = null;
    private int B = 0;
    private int C = 0;
    private boolean D = true;
    private int E = 3;
    private int F = 1;
    private int G = 0;
    private boolean H = true;
    private boolean I = false;
    private int J = 0;
    private boolean K = false;
    private boolean L = false;
    private boolean M = true;
    private com.baidu.adp.lib.cache.s<String> N = null;
    private boolean O = true;
    private int P = 0;
    private int Q = 10;
    private int R = 0;
    private boolean S = false;
    private boolean T = true;
    private Boolean V = false;
    private int W = 0;
    private AtomicBoolean Y = null;
    private int Z = 0;
    private long aa = 0;
    public ArrayList<f> b = null;
    private Hashtable<String, Integer> ac = null;
    private Hashtable<String, Integer> ad = null;
    private Hashtable<String, Integer> ae = null;
    private Hashtable<String, Integer> af = null;
    private int ag = -1;
    private int ah = -1;
    private boolean ai = false;
    private LimitList aj = null;
    private boolean ak = false;
    public Handler c = new Handler(new ar(this));
    com.baidu.adp.lib.c.d d = new as(this);
    private int ao = 0;
    private boolean ap = true;
    private boolean aq = true;
    private boolean ar = true;
    private boolean as = true;
    private boolean at = false;
    private boolean au = true;
    private boolean av = true;
    private boolean aw = false;
    private String ax = "23:00";
    private String ay = "09:00";
    private boolean az = false;
    boolean e = false;

    public static void a(Intent intent) {
        ab = intent;
    }

    public static Intent f() {
        return ab;
    }

    public static TiebaApplication g() {
        return g;
    }

    @Override // com.baidu.adp.a.b
    public final Application b() {
        return an;
    }

    @Override // com.baidu.adp.a.b
    public final Context c() {
        return an;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:120:0x046a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:99:0x0415 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005e A[Catch: Exception -> 0x03ca, TRY_LEAVE, TryCatch #2 {Exception -> 0x03ca, blocks: (B:9:0x0058, B:11:0x005e, B:79:0x039d, B:81:0x03b9), top: B:124:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0418 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5 A[Catch: Exception -> 0x03f1, all -> 0x0415, TryCatch #5 {Exception -> 0x03f1, blocks: (B:16:0x009c, B:18:0x00a5, B:20:0x00ab, B:22:0x00b1, B:86:0x03e0, B:88:0x03e6, B:97:0x0410), top: B:129:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x039d A[Catch: Exception -> 0x03ca, TRY_ENTER, TryCatch #2 {Exception -> 0x03ca, blocks: (B:9:0x0058, B:11:0x005e, B:79:0x039d, B:81:0x03b9), top: B:124:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0410 A[Catch: Exception -> 0x03f1, all -> 0x0415, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x03f1, blocks: (B:16:0x009c, B:18:0x00a5, B:20:0x00ab, B:22:0x00b1, B:86:0x03e0, B:88:0x03e6, B:97:0x0410), top: B:129:0x009c }] */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.BufferedReader] */
    @Override // com.baidu.adp.a.b, android.app.Application
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate() {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        ?? r3;
        BufferedReader bufferedReader;
        String a;
        TelephonyManager telephonyManager;
        AccountData l;
        String a2;
        super.onCreate();
        if (!d()) {
            CertVerifier.getInstance().verify(this, new au(this));
        }
        if (this != null) {
            an = this;
            g = this;
            FrontiaApplication.initFrontia(an);
            new ba((byte) 0).execute(new String[0]);
            NetWorkCore.D();
            try {
                applicationInfo = an.getPackageManager().getApplicationInfo(an.getPackageName(), 128);
                try {
                    com.baidu.tieba.data.i.a(com.baidu.adp.lib.f.b.a(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
                    applicationInfo2 = applicationInfo;
                } catch (Exception e) {
                    e = e;
                    com.baidu.tieba.data.i.a(3);
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "InitVersion", e.getMessage());
                    applicationInfo2 = applicationInfo;
                    if (com.baidu.tieba.data.i.w() != 2) {
                    }
                    if (l()) {
                    }
                    try {
                        a2 = a("from_id", (String) null);
                        bufferedReader = new BufferedReader(new InputStreamReader(an.getResources().getAssets().open("channel"), "gbk"));
                        try {
                            String readLine = bufferedReader.readLine();
                            com.baidu.tieba.data.i.b(readLine);
                            if (a2 != null) {
                            }
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            com.baidu.adp.lib.util.e.b(getClass().getName(), "InitFrom", e.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            com.baidu.adp.lib.util.e.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.i.l());
                            SwitchModel.initSwitchManager();
                            this.B = a("image_quality", 0);
                            this.C = a("view_image_quality", 0);
                            this.D = a("show_images", true);
                            this.E = a("font_size", 2);
                            this.au = a("permoted_message", true);
                            this.i = a("new_display_photo", 1);
                            this.F = a("new_abstract_state", 0);
                            this.G = a("skin", 0);
                            this.r = a("message_id", 0L);
                            this.J = a("voice_headset_mode", 0);
                            this.K = a("gpu_open", bo());
                            this.L = a("app_switcher", false);
                            this.S = a("manage_mode", false);
                            this.H = a("location_on", true);
                            this.I = a("has_showed_del_ga_tip", false);
                            this.P = a("webview_crash_count", 0);
                            this.R = a("new_vcode_webview_crash_count", 0);
                            this.T = a("search_mode", true);
                            this.U = a("search_mode_int", 0);
                            this.u = a(SocialConstants.PARAM_CUID, (String) null);
                            this.Q = a("perform_sample_count", 0);
                            this.ag = a("faceshop_version", -1);
                            boolean a3 = a("bd_loc_switcher", true);
                            if (Build.VERSION.SDK_INT <= 4) {
                            }
                            com.baidu.adp.lib.c.a.a().a(a3);
                            com.baidu.tieba.h.a.a().b();
                            com.baidu.adp.lib.a.d.a().b(SwitchKey.LOG);
                            com.baidu.tieba.log.a.a();
                            this.ak = a("has_show_mutiimage_tip", false);
                            ch.a(an);
                            Application application = an;
                            a = a(SocialConstants.PARAM_CLIENT_ID, (String) null);
                            if (a != null) {
                            }
                            com.baidu.adp.lib.util.e.a("TiebaApplication", "readClientId", a);
                            o = a;
                            telephonyManager = (TelephonyManager) an.getSystemService("phone");
                            if (telephonyManager != null) {
                            }
                            if (this.n == null) {
                            }
                            if (this.u != null) {
                            }
                            this.u = CommonParam.getCUID(an);
                            com.baidu.adp.lib.util.e.d("----cuid:" + this.u);
                            b(SocialConstants.PARAM_CUID, this.u);
                            com.baidu.tieba.data.i.c(an);
                            com.baidu.tieba.data.i.a(an);
                            com.baidu.tieba.data.i.b(an);
                            SapiFastRegActivity.a(an);
                            Thread.setDefaultUncaughtExceptionHandler(new ce());
                            com.baidu.tbplugin.j.a(an);
                            if (l()) {
                            }
                            an.registerReceiver(new com.baidu.tieba.service.e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                            TbImageView.setSkinMode(this.G);
                            com.baidu.adp.lib.c.a.a().a(an, "tieba");
                            if (l()) {
                            }
                            this.aj = new LimitList(50);
                            this.al = SmartBarUtils.hasSmartBar();
                            com.baidu.tieba.f.b.a();
                        }
                        com.baidu.adp.lib.util.e.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.i.l());
                        SwitchModel.initSwitchManager();
                        this.B = a("image_quality", 0);
                        this.C = a("view_image_quality", 0);
                        this.D = a("show_images", true);
                        this.E = a("font_size", 2);
                        this.au = a("permoted_message", true);
                        this.i = a("new_display_photo", 1);
                        this.F = a("new_abstract_state", 0);
                        this.G = a("skin", 0);
                        this.r = a("message_id", 0L);
                        this.J = a("voice_headset_mode", 0);
                        this.K = a("gpu_open", bo());
                        this.L = a("app_switcher", false);
                        this.S = a("manage_mode", false);
                        this.H = a("location_on", true);
                        this.I = a("has_showed_del_ga_tip", false);
                        this.P = a("webview_crash_count", 0);
                        this.R = a("new_vcode_webview_crash_count", 0);
                        this.T = a("search_mode", true);
                        this.U = a("search_mode_int", 0);
                        this.u = a(SocialConstants.PARAM_CUID, (String) null);
                        this.Q = a("perform_sample_count", 0);
                        this.ag = a("faceshop_version", -1);
                        boolean a32 = a("bd_loc_switcher", true);
                        if (Build.VERSION.SDK_INT <= 4) {
                        }
                        com.baidu.adp.lib.c.a.a().a(a32);
                        com.baidu.tieba.h.a.a().b();
                        com.baidu.adp.lib.a.d.a().b(SwitchKey.LOG);
                        com.baidu.tieba.log.a.a();
                        this.ak = a("has_show_mutiimage_tip", false);
                        ch.a(an);
                        Application application2 = an;
                        a = a(SocialConstants.PARAM_CLIENT_ID, (String) null);
                        if (a != null) {
                        }
                        com.baidu.adp.lib.util.e.a("TiebaApplication", "readClientId", a);
                        o = a;
                        telephonyManager = (TelephonyManager) an.getSystemService("phone");
                        if (telephonyManager != null) {
                        }
                        if (this.n == null) {
                        }
                        if (this.u != null) {
                        }
                        this.u = CommonParam.getCUID(an);
                        com.baidu.adp.lib.util.e.d("----cuid:" + this.u);
                        b(SocialConstants.PARAM_CUID, this.u);
                        com.baidu.tieba.data.i.c(an);
                        com.baidu.tieba.data.i.a(an);
                        com.baidu.tieba.data.i.b(an);
                        SapiFastRegActivity.a(an);
                        Thread.setDefaultUncaughtExceptionHandler(new ce());
                        com.baidu.tbplugin.j.a(an);
                        if (l()) {
                        }
                        an.registerReceiver(new com.baidu.tieba.service.e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        TbImageView.setSkinMode(this.G);
                        com.baidu.adp.lib.c.a.a().a(an, "tieba");
                        if (l()) {
                        }
                        this.aj = new LimitList(50);
                        this.al = SmartBarUtils.hasSmartBar();
                        com.baidu.tieba.f.b.a();
                    } catch (Throwable th) {
                        th = th;
                        if (r3 != 0) {
                            try {
                                r3.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                applicationInfo = null;
            }
            try {
                if (com.baidu.tieba.data.i.w() != 2) {
                    com.baidu.tieba.data.i.c(String.valueOf(applicationInfo2.metaData.get("grayVersion")));
                    r3 = "grayVersion";
                } else {
                    com.baidu.tieba.data.i.c(an.getPackageManager().getPackageInfo(an.getPackageName(), 0).versionName);
                    r3 = applicationInfo2;
                    if (com.baidu.tieba.data.i.w() == 1) {
                        com.baidu.tieba.data.i.d(String.valueOf(applicationInfo2.metaData.get("subVersion")));
                        r3 = "subVersion";
                    }
                }
            } catch (Exception e7) {
                String name = getClass().getName();
                com.baidu.adp.lib.util.e.b(name, "InitVersion", e7.getMessage());
                r3 = name;
            }
            if (l()) {
                com.baidu.tieba.sharedPref.b.a();
                com.baidu.tieba.sharedPref.b.b();
            }
            try {
                a2 = a("from_id", (String) null);
                bufferedReader = new BufferedReader(new InputStreamReader(an.getResources().getAssets().open("channel"), "gbk"));
                String readLine2 = bufferedReader.readLine();
                com.baidu.tieba.data.i.b(readLine2);
                if (a2 != null) {
                    String bp = bp();
                    if (bp != null && bp.length() > 0) {
                        com.baidu.tieba.data.i.a(bp);
                        A(bp);
                    } else if (readLine2 != null && readLine2.length() > 0) {
                        com.baidu.tieba.data.i.a(readLine2);
                        A(readLine2);
                        B(readLine2);
                    }
                } else {
                    com.baidu.tieba.data.i.a(a2);
                }
                bufferedReader.close();
            } catch (Exception e8) {
                e = e8;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                r3 = 0;
                if (r3 != 0) {
                }
                throw th;
            }
            com.baidu.adp.lib.util.e.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.i.l());
            SwitchModel.initSwitchManager();
            this.B = a("image_quality", 0);
            this.C = a("view_image_quality", 0);
            this.D = a("show_images", true);
            this.E = a("font_size", 2);
            this.au = a("permoted_message", true);
            this.i = a("new_display_photo", 1);
            this.F = a("new_abstract_state", 0);
            this.G = a("skin", 0);
            this.r = a("message_id", 0L);
            this.J = a("voice_headset_mode", 0);
            this.K = a("gpu_open", bo());
            this.L = a("app_switcher", false);
            this.S = a("manage_mode", false);
            this.H = a("location_on", true);
            this.I = a("has_showed_del_ga_tip", false);
            this.P = a("webview_crash_count", 0);
            this.R = a("new_vcode_webview_crash_count", 0);
            this.T = a("search_mode", true);
            this.U = a("search_mode_int", 0);
            this.u = a(SocialConstants.PARAM_CUID, (String) null);
            this.Q = a("perform_sample_count", 0);
            this.ag = a("faceshop_version", -1);
            boolean a322 = a("bd_loc_switcher", true);
            if (Build.VERSION.SDK_INT <= 4) {
                a322 = false;
            }
            com.baidu.adp.lib.c.a.a().a(a322);
            com.baidu.tieba.h.a.a().b();
            com.baidu.adp.lib.a.d.a().b(SwitchKey.LOG);
            com.baidu.tieba.log.a.a();
            this.ak = a("has_show_mutiimage_tip", false);
            ch.a(an);
            Application application22 = an;
            a = a(SocialConstants.PARAM_CLIENT_ID, (String) null);
            if (a != null) {
                int indexOf = a.indexOf("\t");
                if (indexOf == -1) {
                    Application application3 = an;
                    bq();
                    a = null;
                } else if (com.baidu.tieba.data.i.u().equals(a.substring(0, indexOf))) {
                    a = a.substring(indexOf + 1);
                } else {
                    Application application4 = an;
                    bq();
                    a = null;
                }
            }
            com.baidu.adp.lib.util.e.a("TiebaApplication", "readClientId", a);
            o = a;
            telephonyManager = (TelephonyManager) an.getSystemService("phone");
            if (telephonyManager != null) {
                this.n = telephonyManager.getDeviceId();
            }
            if (this.n == null) {
                this.n = "000000000000000";
            }
            if (this.u != null || this.u.length() < 0) {
                this.u = CommonParam.getCUID(an);
                com.baidu.adp.lib.util.e.d("----cuid:" + this.u);
                b(SocialConstants.PARAM_CUID, this.u);
            }
            com.baidu.tieba.data.i.c(an);
            com.baidu.tieba.data.i.a(an);
            com.baidu.tieba.data.i.b(an);
            SapiFastRegActivity.a(an);
            try {
                Thread.setDefaultUncaughtExceptionHandler(new ce());
            } catch (SecurityException e9) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "onCreate", e9.getMessage());
            }
            com.baidu.tbplugin.j.a(an);
            if (l()) {
                cb.a(an);
                if (ax()) {
                    com.baidu.adp.lib.a.d.a().b();
                    new com.baidu.tbplugin.a(an, BdBrowserDelegate.class, new at(this)).a();
                }
                com.baidu.tbadk.imageManager.e.a().a(50, com.baidu.tieba.data.i.p());
                com.baidu.adp.lib.e.c.a().a(com.baidu.tieba.util.a.g.a());
                TbFaceManager.a().a(an, new com.baidu.tieba.util.ad());
                this.h = new HashMap<>();
                if (an.getDatabasePath("baidu_tieba.db").exists() && (l = DatabaseService.l()) != null) {
                    a(l, (Context) an);
                }
                com.baidu.tieba.account.m.a().a(an);
                DatabaseService.s();
                this.ac = new Hashtable<>();
                new com.baidu.tieba.util.ah(this.ac).start();
                this.l = new bo(300);
                this.m = new bo(100);
                com.baidu.tieba.mention.v.a().b();
                X();
                if (this.ad == null) {
                    this.ad = new Hashtable<>();
                }
                if (this.ae == null) {
                    this.ae = new Hashtable<>();
                }
                if (this.af == null) {
                    this.af = new Hashtable<>();
                }
                com.baidu.tieba.im.e.a(an);
                new com.baidu.tieba.account.ax("open").start();
                com.baidu.tieba.data.emotions.l.a().b();
            } else {
                this.b = new ArrayList<>();
            }
            try {
                an.registerReceiver(new com.baidu.tieba.service.e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e10) {
                com.baidu.adp.lib.util.e.b(e10.getMessage());
            }
            TbImageView.setSkinMode(this.G);
            try {
                com.baidu.adp.lib.c.a.a().a(an, "tieba");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (l()) {
                bs();
                com.baidu.adp.lib.c.a.a().a(true, this.d);
            }
            this.aj = new LimitList(50);
            this.al = SmartBarUtils.hasSmartBar();
        }
        com.baidu.tieba.f.b.a();
    }

    private static boolean bo() {
        boolean z = false;
        String trim = Build.MODEL.trim();
        if (trim == null) {
            return true;
        }
        String[] strArr = {"M040", "M032", "M031", "M030", "HUAWEI C8813", "ZTE U970", "MediaPad 10 FHD", "GT-I9000", "DOEASY E930", "H8205", "GT-N7108", "GT-N7102", "GT-N719", "GT-N7100", "galaxy nexus", " ZTE U808", "UMI_X1", "nexus s", "AMOI N820", "JY-G", "XT885", "U701T", "Lenovo A750", "ZTE U807", "vivo S11t", "Droid Bionic", "MORAL_N01", "XT910", "GT-S7562", "Lenovo A798t", "vivo E5", "U705T", "HUAWEI T8951", "ME865", "HUAWEI P1XL", "KPT A9PLUS", "vivo Y11", "T9200", "XT928", "HUAWEI Y500-T00", "BBK Y3t", "Lenovo K860", "vivo X1", "HUAWEI T8833", "Lenovo A789", "ZTE U960E"};
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (strArr[i].equalsIgnoreCase(trim)) {
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (com.baidu.adp.lib.util.e.a()) {
            com.baidu.adp.lib.util.e.d("device:[" + trim + "], default GPU on:" + z);
        }
        return z;
    }

    public final boolean a(String str) {
        return (this.ad == null || str == null || !this.ad.containsKey(str)) ? false : true;
    }

    public final void a(String str, int i, int i2) {
        if (!a(str) && this.ad != null && str != null) {
            if (this.ad.size() > 100) {
                this.ad.clear();
                this.ae.clear();
            }
            this.ad.put(str, Integer.valueOf(i));
            this.ae.put(str, Integer.valueOf(i2));
        }
    }

    public final void h() {
        if (this.ad != null) {
            this.ad.clear();
        }
        if (this.ae != null) {
            this.ae.clear();
        }
    }

    public final int b(String str) {
        if (a(str)) {
            return this.ad.get(str).intValue();
        }
        return 0;
    }

    public final int c(String str) {
        if (a(str)) {
            return this.ae.get(str).intValue();
        }
        return -1;
    }

    public final int i() {
        if (this.ad != null) {
            return this.ad.size();
        }
        return 0;
    }

    public final int d(String str) {
        if (this.af == null || str == null || !this.af.containsKey(str)) {
            return 0;
        }
        return this.af.get(str).intValue();
    }

    public final void e(String str) {
        if (this.af != null && str != null) {
            this.af.put(str, 1);
            this.k = true;
            if (this.af.size() > 200) {
                this.af.clear();
            }
        }
    }

    public final void f(String str) {
        if (this.af != null && str != null) {
            this.af.put(str, -1);
            this.k = true;
            if (this.af.size() > 200) {
                this.af.clear();
            }
        }
    }

    public final boolean g(String str) {
        return (this.ac == null || str == null || !this.ac.containsKey(str)) ? false : true;
    }

    public final void h(String str) {
        if (!g(str) && this.ac != null && str != null) {
            this.ac.put(str, 1);
            new com.baidu.tieba.util.ah(1, str).start();
        }
    }

    public final void i(String str) {
        if (g(str) && this.ac != null && str != null) {
            this.ac.remove(str);
            new com.baidu.tieba.util.ah(2, str).start();
        }
    }

    public final void a(f fVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.b.get(i).releaseResouce();
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "addRemoteActivity", e.getMessage());
                }
            }
            if (fVar != null) {
                this.b.add(fVar);
            }
        }
    }

    public final void b(f fVar) {
        if (this.b != null) {
            this.b.remove(fVar);
        }
    }

    public final String j() {
        return this.u;
    }

    public final String k() {
        return this.n;
    }

    public final boolean l() {
        boolean z = false;
        if (this.z != null) {
            return this.z.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) an.getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            int myPid = Process.myPid();
            if (runningAppProcesses != null) {
                this.z = Boolean.TRUE;
                int i = 0;
                while (true) {
                    if (i >= runningAppProcesses.size()) {
                        break;
                    } else if (runningAppProcesses.get(i).pid != myPid) {
                        i++;
                    } else {
                        String str = runningAppProcesses.get(i).processName;
                        if (str != null && (str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1") || str.equalsIgnoreCase("com.baidu.tieba:remote") || str.equalsIgnoreCase("com.baidu.tieba:bdservice_v1"))) {
                            this.z = Boolean.FALSE;
                        }
                    }
                }
            }
            z = true;
            return z;
        }
        return true;
    }

    public final void a(boolean z) {
        this.T = z;
        b("search_mode", z);
    }

    public final boolean m() {
        return this.T;
    }

    public final boolean n() {
        return this.M;
    }

    public final void b(boolean z) {
        this.M = z;
    }

    public final boolean o() {
        return this.H;
    }

    public final void c(boolean z) {
        b("gpu_open", z);
        this.K = z;
    }

    public final boolean p() {
        return this.K;
    }

    public final void d(boolean z) {
        b("moplus_service", z);
    }

    public final boolean q() {
        return a("moplus_service", true);
    }

    public final void e(boolean z) {
        b("push_service", z);
    }

    public final boolean r() {
        return a("push_service", true);
    }

    public final void f(boolean z) {
        b("app_switcher", z);
        this.L = z;
    }

    public final boolean s() {
        return this.L;
    }

    private void A(String str) {
        if (str != null && str.length() > 0 && l()) {
            b("from_id", str);
        }
    }

    private String bp() {
        String str = null;
        try {
            File d = com.baidu.tieba.util.af.d("from.dat");
            if (d == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
            str = bufferedReader.readLine();
            bufferedReader.close();
            return str;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "getFromByFile", e.getMessage());
            cb.a(e, "TiebaApplication.getFromByFile");
            return str;
        }
    }

    private void B(String str) {
        if (str != null && str.length() > 0) {
            try {
                File f = com.baidu.tieba.util.af.f("from.dat");
                if (f != null) {
                    FileWriter fileWriter = new FileWriter(f);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "saveFromToFile", e.getMessage());
                cb.a(e, "TiebaApplication.saveFromToFile");
            }
        }
    }

    public static String t() {
        return com.baidu.tieba.data.i.l();
    }

    public static void u() {
        com.baidu.tieba.mention.v.a().a(true);
        DatabaseService.s();
    }

    public final com.baidu.adp.widget.ImageView.b j(String str) {
        SoftReference<com.baidu.adp.widget.ImageView.b> softReference = this.h.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.ImageView.b a = TbFaceManager.a().a(str);
        if (a != null) {
            this.h.put(str, new SoftReference<>(a));
            return a;
        }
        return a;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        e();
        super.onLowMemory();
    }

    @Override // com.baidu.adp.a.b
    public final void e() {
        int b = com.baidu.tbadk.imageManager.e.a().b();
        int max = (int) Math.max(b * 0.8d, com.baidu.tieba.data.i.p());
        if (max < b) {
            if (com.baidu.adp.lib.util.e.a()) {
                com.baidu.adp.lib.util.e.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.imageManager.e.a().a(max);
        }
    }

    public static String v() {
        if (j != null) {
            return j.getID();
        }
        return null;
    }

    public static boolean w() {
        String v = v();
        return v != null && v.length() > 0;
    }

    public static void a(AccountData accountData, Context context) {
        String str;
        String str2 = null;
        boolean z = false;
        if (accountData == null && j != null) {
            z = true;
        } else if (j == null && accountData != null) {
            z = true;
        } else if (j != null && accountData != null && !TextUtils.equals(j.getAccount(), accountData.getAccount())) {
            z = true;
        }
        j = accountData;
        if (context != null) {
            TiebaApplication tiebaApplication = g;
            if (a("push_service", true)) {
                UtilHelper.f(context);
            } else {
                UtilHelper.g(context);
            }
        }
        if (accountData != null) {
            str2 = accountData.getID();
            str = accountData.getAccount();
        } else {
            str = null;
        }
        Intent intent = new Intent();
        intent.setAction("adp.bdstatisticsmanager2.account_changed");
        intent.putExtra("intent_data_userid", str2);
        intent.putExtra("intent_data_username", str);
        intent.putExtra("intent_data_bduss", x());
        TiebaApplication tiebaApplication2 = g;
        an.sendStickyBroadcast(intent);
        if (z && accountData != null) {
            Application application = an;
            if (!BdUtilHelper.c()) {
                if (g != null) {
                    g.c.post(new av(accountData, application));
                    return;
                }
                return;
            }
            a(accountData, application);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(AccountData accountData, Application application) {
        com.baidu.tieba.mention.v.a().d();
        if (accountData != null) {
            cb.a(accountData.getAccount(), accountData.getID(), x());
        }
        com.baidu.tieba.im.i.a(new aw(), new ax(accountData, application));
        com.baidu.tieba.im.i.a(new ay(), new az());
        com.baidu.tieba.mention.v.a().i();
        com.baidu.tieba.data.emotions.l.a().b();
    }

    public static String x() {
        if (j != null) {
            return j.getBDUSS();
        }
        return null;
    }

    public static AccountData y() {
        return j;
    }

    public static String z() {
        if (j != null) {
            return j.getAccount();
        }
        return null;
    }

    public final void a(long j2) {
        b("update_notify_time", j2);
    }

    public final long A() {
        return a("update_notify_time", 0L);
    }

    public final void k(String str) {
        b("install_other_app_file_name", str);
    }

    public final String B() {
        return a("install_other_app_file_name", (String) null);
    }

    public final void C() {
        b("tdatabasecreatetime", new Date().getTime());
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public final void l(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (j != null) {
                    j.setTbs(str);
                }
            }
        }
    }

    public static String D() {
        if (j != null) {
            return j.getTbs();
        }
        return null;
    }

    public static String E() {
        return o;
    }

    private static void bq() {
        com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CLIENT_ID);
    }

    public static void m(String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tieba.sharedPref.b.a().b(SocialConstants.PARAM_CLIENT_ID, String.valueOf(com.baidu.tieba.data.i.u()) + "\t" + str);
        }
    }

    public static void n(String str) {
        o = str;
    }

    public final void g(boolean z) {
        this.k = z;
    }

    public final boolean F() {
        return this.k;
    }

    public final int G() {
        return this.ao;
    }

    public final void h(boolean z) {
        this.au = z;
        b("permoted_message", z);
    }

    public final boolean H() {
        return this.au;
    }

    public final void i(boolean z) {
        if (this.as != z) {
            this.as = z;
        }
    }

    public final boolean I() {
        return this.aw;
    }

    public final void j(boolean z) {
        this.aw = z;
    }

    public final String J() {
        return this.ax;
    }

    public final void o(String str) {
        this.ax = str;
    }

    public final String K() {
        return this.ay;
    }

    public final void p(String str) {
        this.ay = str;
    }

    public final boolean L() {
        return this.as;
    }

    public final void k(boolean z) {
        this.at = z;
    }

    public final boolean M() {
        return this.at;
    }

    public final int N() {
        if (!this.as && !this.at) {
            return 0;
        }
        if (this.as && !this.at) {
            return 1;
        }
        if (!this.as && this.at) {
            return 2;
        }
        return 3;
    }

    public static void a(int i) {
        if (i == 0) {
            g.i(false);
            g.at = false;
        } else if (i == 1) {
            g.i(true);
            g.at = false;
        } else if (i == 2) {
            g.i(false);
            g.at = true;
        } else {
            g.i(true);
            g.at = true;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 int)] */
    public final void b(int i) {
        com.baidu.adp.lib.util.e.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i).toString());
        if (i == 0) {
            this.ao = i;
            com.baidu.tieba.mention.v.a().a(true);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.ao = 300;
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public final boolean O() {
        return this.ap;
    }

    public final void l(boolean z) {
        this.ap = z;
        if (!z) {
            com.baidu.tieba.mention.v.a().d(0);
        }
    }

    public final boolean P() {
        return this.aq;
    }

    public final void m(boolean z) {
        this.aq = z;
        if (!z) {
            com.baidu.tieba.mention.v.a().c(0);
        }
    }

    public final boolean Q() {
        return this.ar;
    }

    public final void n(boolean z) {
        this.ar = z;
        if (!z) {
            com.baidu.tieba.mention.v.a().b(0);
        }
    }

    public final boolean R() {
        return this.av;
    }

    public final void o(boolean z) {
        this.av = z;
        if (!z) {
            com.baidu.tieba.mention.v.a().e(0);
        }
    }

    public final boolean S() {
        return a("group_notify", true);
    }

    public final void p(boolean z) {
        b("group_notify", z);
    }

    public final boolean T() {
        return this.ao > 0;
    }

    private static boolean a(String str, boolean z) {
        return com.baidu.tieba.sharedPref.b.a().a(str, z);
    }

    private static void b(String str, boolean z) {
        com.baidu.tieba.sharedPref.b.a().b(str, z);
    }

    private static int a(String str, int i) {
        return com.baidu.tieba.sharedPref.b.a().a(str, i);
    }

    private static void b(String str, int i) {
        com.baidu.tieba.sharedPref.b.a().b(str, i);
    }

    private static long a(String str, long j2) {
        return com.baidu.tieba.sharedPref.b.a().a(str, 0L);
    }

    private static void b(String str, long j2) {
        com.baidu.tieba.sharedPref.b.a().b(str, j2);
    }

    private static String a(String str, String str2) {
        return com.baidu.tieba.sharedPref.b.a().a(str, str2);
    }

    private static void b(String str, String str2) {
        com.baidu.tieba.sharedPref.b.a().b(str, str2);
    }

    public final boolean U() {
        return a("alert_sign_on", false);
    }

    public final void q(boolean z) {
        b("alert_sign_on", z);
        X();
    }

    public final int V() {
        int a = a("alert_sign_hours", -1);
        if (a == -1) {
            br();
            return a("alert_sign_hours", 12);
        }
        return a;
    }

    private void br() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public final int W() {
        int a = a("alert_sign_mins", -1);
        if (a == -1) {
            br();
            return a("alert_sign_mins", 30);
        }
        return a;
    }

    public final void a(int i, int i2) {
        b("alert_sign_hours", i);
        b("alert_sign_mins", i2);
        X();
    }

    public final void X() {
        AlarmManager alarmManager = (AlarmManager) an.getSystemService("alarm");
        Intent intent = new Intent(com.baidu.tieba.data.i.h());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(an, SignAlertReceiver.class);
        if (a("alert_sign_on", false)) {
            Calendar calendar = Calendar.getInstance();
            int V = V();
            int i = calendar.get(11);
            int W = W();
            int i2 = calendar.get(12);
            calendar.set(11, V);
            calendar.set(12, W);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= V && (i != V || i2 >= W)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(an, 0, intent, 268435456));
            if (com.baidu.adp.lib.util.e.a()) {
                com.baidu.adp.lib.util.e.e("sign-alert alarm set to :" + bs.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(an, 0, intent, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.util.e.a()) {
                com.baidu.adp.lib.util.e.e("sign-alert alarm cancelled.");
            }
        }
    }

    public final int Y() {
        return this.C;
    }

    public final boolean Z() {
        return this.D;
    }

    public final int aa() {
        return this.E;
    }

    public final void c(int i) {
        if (this.E != i) {
            this.E = i;
            b("font_size", i);
        }
    }

    public final boolean ab() {
        return this.J == 1;
    }

    public final void r(boolean z) {
        int i = z ? 1 : 0;
        if (this.J != i) {
            this.J = i;
            b("voice_headset_mode", i);
        }
    }

    public final void d(int i) {
        this.F = i;
        b("new_abstract_state", i);
    }

    public final int ac() {
        return this.F;
    }

    public final void s(boolean z) {
        this.I = true;
        b("has_showed_del_ga_tip", true);
    }

    public final boolean ad() {
        return this.I;
    }

    public final void e(int i) {
        AppsActivity.a();
        this.G = i;
        b("skin", i);
        TbImageView.setSkinMode(i);
        Intent intent = new Intent();
        intent.setAction(com.baidu.tieba.data.i.f());
        intent.putExtra("skin_type", i);
        an.sendBroadcast(intent);
    }

    public final void f(int i) {
        this.G = i;
    }

    public final int ae() {
        return this.G;
    }

    public final int af() {
        return this.P;
    }

    public final void g(int i) {
        this.P = i;
        b("webview_crash_count", i);
    }

    public final int ag() {
        return this.Q;
    }

    public final void h(int i) {
        this.Q = i;
        b("perform_sample_count", i);
    }

    public final int ah() {
        return this.R;
    }

    public final void i(int i) {
        this.R = i;
        b("new_vcode_webview_crash_count", i);
    }

    public final void ai() {
        int a = a("bd_loc_crash_count", 0) + 1;
        b("bd_loc_crash_count", a);
        if (a > 3) {
            com.baidu.adp.lib.c.a.a().a(false);
            b("bd_loc_switcher", false);
        }
    }

    public final boolean aj() {
        return this.v;
    }

    public final void t(boolean z) {
        this.v = true;
    }

    public final void a(CombineDownload combineDownload) {
        this.x = combineDownload;
    }

    public final CombineDownload ak() {
        return this.x;
    }

    public final VersionData al() {
        return this.w;
    }

    public final void a(VersionData versionData) {
        this.w = versionData;
    }

    public static void u(boolean z) {
        X = true;
    }

    public final bo am() {
        return this.l;
    }

    public final void an() {
        this.t = System.currentTimeMillis();
    }

    public final void ao() {
        this.t = -1L;
    }

    public final void ap() {
        if (this.t > 0) {
            this.t = System.currentTimeMillis() - this.t;
            if (this.t > 0) {
                new com.baidu.tieba.account.ax("startup_time", String.valueOf(this.t));
            }
            com.baidu.adp.lib.util.e.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.t));
        }
        this.t = -1L;
    }

    public final void aq() {
        this.p++;
        bt();
    }

    public final void ar() {
        this.p--;
        bt();
    }

    private void bs() {
        this.c.sendMessageDelayed(this.c.obtainMessage(5, Boolean.TRUE), 1000L);
    }

    private void bt() {
        if (l()) {
            if (this.p < 0) {
                this.p = 0;
            }
            if (this.q == 0 && this.p > 0) {
                this.q = System.nanoTime();
            }
            com.baidu.adp.lib.util.e.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.p));
            this.c.removeMessages(4);
            if (this.p == 0 && this.q > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 60000L);
            }
            this.c.removeMessages(5);
            if (this.p == 0) {
                bs();
            } else if (this.Y == null || this.Y.get()) {
                this.c.sendMessageDelayed(this.c.obtainMessage(5, Boolean.FALSE), 1000L);
            }
        }
    }

    public final boolean as() {
        if (this.Y == null) {
            return true;
        }
        return this.Y.get();
    }

    public final void at() {
        if (this.Y == null) {
            this.Y = new AtomicBoolean(false);
        }
        if (!this.Y.get()) {
            this.Y.set(true);
            com.baidu.tieba.im.messageCenter.d.a().d(new com.baidu.tieba.im.message.a(true));
            cc.a(null);
            cb.a();
        }
    }

    public final void au() {
        if (this.Y == null) {
            this.Y = new AtomicBoolean(true);
        }
        if (this.Y.get()) {
            this.Y.set(false);
            this.Z++;
            if (System.currentTimeMillis() - this.aa > 3600000 || this.aa == 0) {
                this.aa = System.currentTimeMillis();
                new com.baidu.tieba.account.w().start();
            }
            com.baidu.tieba.im.messageCenter.d.a().d(new com.baidu.tieba.im.message.a(false));
        }
    }

    public final int av() {
        return this.Z;
    }

    public final void aw() {
        this.Z = 0;
    }

    public final boolean ax() {
        if (com.baidu.tieba.util.ag.a("/package.cur/" + com.baidu.tieba.data.i.u())) {
            return false;
        }
        C(com.baidu.tieba.util.ag.d("/package.cur"));
        return true;
    }

    public static void ay() {
        com.baidu.tieba.util.ag.c("/package.cur");
        com.baidu.tieba.util.ag.b("/package.cur/" + com.baidu.tieba.data.i.u());
    }

    private static void C(String str) {
        if (!bs.c(str) && !"null".equals(str)) {
            com.baidu.tieba.util.ag.c("/package.last");
            com.baidu.tieba.util.ag.b("/package.last/" + str);
        }
    }

    public final String az() {
        String d;
        if (!com.baidu.tieba.util.ag.a("/package.last")) {
            d = a("active_version", "");
        } else {
            d = com.baidu.tieba.util.ag.d("/package.last");
        }
        if ("active_clear".equals(d)) {
            return null;
        }
        return d;
    }

    public final void v(boolean z) {
        b("first_sync_image_quality", z);
    }

    public final boolean aA() {
        return a("first_sync_image_quality", true);
    }

    public final void aB() {
        C("active_clear");
    }

    public static void aC() {
        com.baidu.tieba.sharedPref.b.a().a("account_share");
    }

    public final String aD() {
        return a("account_share", (String) null);
    }

    public final void q(String str) {
        b("account_share", str);
    }

    public final void b(long j2) {
        this.r = j2;
        b("message_id", j2);
    }

    public final void a(int i, int i2, String str) {
        if (this.A == null) {
            this.A = Executors.newSingleThreadExecutor();
        }
        com.baidu.adp.lib.util.e.a(getClass().getName(), "pv_addImagePv", "img_num=" + i + " img_total" + i2);
        com.baidu.tieba.account.aw awVar = new com.baidu.tieba.account.aw(i, i2);
        awVar.a(str);
        this.A.execute(awVar);
    }

    public final void w(boolean z) {
        this.az = z;
        an.sendBroadcast(new Intent(com.baidu.tieba.data.i.a()));
    }

    public static boolean aE() {
        if (g.az) {
            TiebaApplication tiebaApplication = g;
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(a("update_notify_time", 0L)).longValue() > 86400000;
        }
        return false;
    }

    public static void r(String str) {
        s = str;
    }

    public static String aF() {
        return s;
    }

    public final long aG() {
        return a("last_notify_sound_time", 0L);
    }

    public final void c(long j2) {
        b("last_notify_sound_time", j2);
    }

    public final void j(int i) {
        b("kn_vote_cd", i);
    }

    public final int aH() {
        return a("networkcore_type", 1);
    }

    public final void k(int i) {
        bf.a(i);
        b("networkcore_type", i);
    }

    public final int aI() {
        return a("keepalive_wifi", 1);
    }

    public final void l(int i) {
        b("keepalive_wifi", i);
    }

    public final int aJ() {
        return a("keepalive_nonwifi", 1);
    }

    public final void m(int i) {
        b("keepalive_nonwifi", i);
    }

    public final void s(String str) {
        b("socket_reconn_strategy", str);
    }

    public final void t(String str) {
        b("socket_heartbeat_strategy", str);
    }

    public final void u(String str) {
        b("socket_getmsg_strategy", str);
    }

    public final void x(boolean z) {
        b("is_spring_egg", z);
    }

    public final boolean aK() {
        return a("is_spring_egg", false);
    }

    public final void a(int[] iArr) {
        if (iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i : iArr) {
                sb.append(i);
                sb.append("|");
            }
            b("socket_time_out", sb.toString());
            com.baidu.tieba.im.net.p.a().a(iArr);
        }
    }

    public final int[] aL() {
        String[] split;
        String a = a("socket_time_out", (String) null);
        if (a == null || (split = a.split("\\|")) == null || split.length != 3) {
            return null;
        }
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = 0;
            try {
                iArr[i] = Integer.valueOf(split[i]).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(e.getMessage());
            }
        }
        return iArr;
    }

    public final int[] aM() {
        int[] iArr = new int[0];
        try {
            String a = a("socket_reconn_strategy", "");
            if (a != null && !TextUtils.isEmpty(a)) {
                String[] split = a.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public final int[] aN() {
        int[] iArr = new int[0];
        try {
            String a = a("socket_heartbeat_strategy", "");
            if (a != null && !TextUtils.isEmpty(a)) {
                String[] split = a.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public final int[] aO() {
        int[] iArr = new int[0];
        try {
            String a = a("socket_getmsg_strategy", "");
            if (a != null && !TextUtils.isEmpty(a)) {
                String[] split = a.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public final void n(int i) {
        b("kn_vote_max", i);
    }

    public final void o(int i) {
        b("kn_vote_rate", i);
    }

    public final void v(String str) {
        b("push_channel_id", str);
    }

    public final String aP() {
        return a("push_channel_userId", "");
    }

    public final void w(String str) {
        b("push_channel_userId", str);
    }

    public final String aQ() {
        return a("push_channel_id", "");
    }

    public final void d(long j2) {
        b("nearbygroup_date", j2);
    }

    public final long aR() {
        return a("nearbygroup_date", 0L);
    }

    public final void e(long j2) {
        b("banner_date", j2);
    }

    public final long aS() {
        return a("banner_date", 0L);
    }

    public final void f(long j2) {
        b("group_banner_date", j2);
    }

    public final long aT() {
        return a("group_banner_date", 0L);
    }

    public final void x(String str) {
        b("location_lat", str);
    }

    public final String aU() {
        return a("location_lat", "");
    }

    public final void y(String str) {
        b("location_lng", str);
    }

    public final boolean aV() {
        return a("location_shared", false);
    }

    public final void y(boolean z) {
        b("location_shared", z);
    }

    public final String aW() {
        return a("location_lng", "");
    }

    public final void z(String str) {
        b("location_pos", str);
    }

    public final com.baidu.adp.lib.cache.s<String> aX() {
        if (this.N == null) {
            this.N = BdCacheService.a().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.N;
    }

    public static void p(int i) {
        TiebaApplication tiebaApplication = g;
        int max = Math.max((int) (UtilHelper.a(an) * 0.28f), i);
        com.baidu.adp.lib.util.e.d("set pic cache size to :" + (max / LocationClientOption.MIN_SCAN_SPAN) + "KB. needed:" + (i / LocationClientOption.MIN_SCAN_SPAN) + "KB.");
        com.baidu.tbadk.imageManager.e.a().a(max);
    }

    public final int aY() {
        return this.ag;
    }

    public final void q(int i) {
        this.ag = i;
        b("faceshop_version", this.ag);
    }

    public final void r(int i) {
        this.ah = i;
    }

    public final boolean aZ() {
        return this.O;
    }

    public final int ba() {
        return this.ah;
    }

    public final boolean bb() {
        return this.ai;
    }

    public final void z(boolean z) {
        this.ai = z;
    }

    public static void bc() {
        try {
            an.startService(new Intent(an, FatalErrorService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.b("failed to start FatalErrorService:" + th.getMessage());
        }
    }

    public static void bd() {
        try {
            an.startService(new Intent(an, ClearTempService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.b(th.getMessage());
        }
    }

    public static void be() {
        an.startService(new Intent(an, TiebaSyncService.class));
    }

    public static void bf() {
        an.stopService(new Intent(an, TiebaSyncService.class));
    }

    public static void bg() {
        an.startService(new Intent(an, TiebaActiveService.class));
    }

    public static void bh() {
        an.stopService(new Intent(an, TiebaActiveService.class));
    }

    public final void a(PersonChangeData personChangeData) {
        this.am = personChangeData;
    }

    public final PersonChangeData bi() {
        return this.am;
    }

    public final LimitList bj() {
        return this.aj;
    }

    public final void bk() {
        if (this.aj != null) {
            this.aj.clear();
        }
    }

    public final void A(boolean z) {
        this.ak = true;
        b("has_show_mutiimage_tip", true);
    }

    public final boolean bl() {
        return this.ak;
    }

    public final boolean bm() {
        return this.al;
    }
}
