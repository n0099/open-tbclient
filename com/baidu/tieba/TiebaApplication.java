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

    public void b(Application application) {
        AccountData l;
        if (application != null) {
            an = application;
            g = this;
            FrontiaApplication.initFrontia(an);
            new ba(null).execute(new String[0]);
            NetWorkCore.F();
            bz();
            if (q()) {
                com.baidu.tieba.sharedPref.b.a().b();
            }
            bA();
            by();
            ch.a(an);
            o = a((Context) an);
            bw();
            bx();
            com.baidu.tieba.data.i.d(an);
            com.baidu.tieba.data.i.b(an);
            com.baidu.tieba.data.i.c(an);
            SapiFastRegActivity.a(an);
            try {
                Thread.setDefaultUncaughtExceptionHandler(new ce());
            } catch (SecurityException e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate", e.getMessage());
            }
            com.baidu.tbplugin.j.a(an);
            if (q()) {
                new com.baidu.tbplugin.a(an, BdBrowserDelegate.class, new at(this)).a();
                cb.a(an);
                if (aE()) {
                    com.baidu.adp.lib.a.d.a().b();
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
                n();
                this.l = new bo(300);
                this.m = new bo(100);
                com.baidu.tieba.mention.v.a().b();
                ad();
                l();
                m();
                com.baidu.tieba.im.f.a(an);
                new com.baidu.tieba.account.ax("open").start();
                com.baidu.tieba.data.emotions.l.a().b();
            } else {
                this.b = new ArrayList<>();
            }
            try {
                an.registerReceiver(new com.baidu.tieba.service.e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b(e2.getMessage());
            }
            TbImageView.setSkinMode(this.G);
            try {
                com.baidu.adp.lib.c.a.a().a(an, "tieba");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (q()) {
                bE();
                h();
            }
            this.aj = new LimitList(50);
            this.al = SmartBarUtils.hasSmartBar();
        }
    }

    @Override // com.baidu.adp.a.b
    public Application b() {
        return an;
    }

    @Override // com.baidu.adp.a.b
    public Context c() {
        return an;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        if (!d()) {
            CertVerifier.getInstance().verify(this, new au(this));
        }
        b((Application) this);
        com.baidu.tieba.f.b.a();
    }

    public void h() {
        com.baidu.adp.lib.c.a.a().a(true, this.d);
    }

    public boolean i() {
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
        if (com.baidu.adp.lib.util.f.a()) {
            com.baidu.adp.lib.util.f.d("device:[" + trim + "], default GPU on:" + z);
        }
        return z;
    }

    public boolean a(String str) {
        return (this.ad == null || str == null || !this.ad.containsKey(str)) ? false : true;
    }

    public void a(String str, int i, int i2) {
        if (!a(str) && this.ad != null && str != null) {
            if (this.ad.size() > 100) {
                this.ad.clear();
                this.ae.clear();
            }
            this.ad.put(str, Integer.valueOf(i));
            this.ae.put(str, Integer.valueOf(i2));
        }
    }

    public void j() {
        if (this.ad != null) {
            this.ad.clear();
        }
        if (this.ae != null) {
            this.ae.clear();
        }
    }

    public int b(String str) {
        if (a(str)) {
            return this.ad.get(str).intValue();
        }
        return 0;
    }

    public int c(String str) {
        if (a(str)) {
            return this.ae.get(str).intValue();
        }
        return -1;
    }

    public int k() {
        if (this.ad != null) {
            return this.ad.size();
        }
        return 0;
    }

    public void l() {
        if (this.ad == null) {
            this.ad = new Hashtable<>();
        }
        if (this.ae == null) {
            this.ae = new Hashtable<>();
        }
    }

    public int d(String str) {
        if (this.af == null || str == null || !this.af.containsKey(str)) {
            return 0;
        }
        return this.af.get(str).intValue();
    }

    public void e(String str) {
        if (this.af != null && str != null) {
            this.af.put(str, 1);
            h(true);
            if (this.af.size() > 200) {
                this.af.clear();
            }
        }
    }

    public void f(String str) {
        if (this.af != null && str != null) {
            this.af.put(str, -1);
            h(true);
            if (this.af.size() > 200) {
                this.af.clear();
            }
        }
    }

    public void m() {
        if (this.af == null) {
            this.af = new Hashtable<>();
        }
    }

    public boolean g(String str) {
        return (this.ac == null || str == null || !this.ac.containsKey(str)) ? false : true;
    }

    public void h(String str) {
        if (!g(str) && this.ac != null && str != null) {
            this.ac.put(str, 1);
            new com.baidu.tieba.util.ah(1, str).start();
        }
    }

    public void i(String str) {
        if (g(str) && this.ac != null && str != null) {
            this.ac.remove(str);
            new com.baidu.tieba.util.ah(2, str).start();
        }
    }

    public void n() {
        this.ac = new Hashtable<>();
        new com.baidu.tieba.util.ah(this.ac).start();
    }

    public void a(f fVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.b.get(i).releaseResouce();
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "addRemoteActivity", e.getMessage());
                }
            }
            if (fVar != null) {
                this.b.add(fVar);
            }
        }
    }

    public void b(f fVar) {
        if (this.b != null) {
            this.b.remove(fVar);
        }
    }

    private void bw() {
        TelephonyManager telephonyManager = (TelephonyManager) an.getSystemService("phone");
        if (telephonyManager != null) {
            this.n = telephonyManager.getDeviceId();
        }
        if (this.n == null) {
            this.n = "000000000000000";
        }
    }

    private void bx() {
        if (this.u == null || this.u.length() < 0) {
            this.u = CommonParam.getCUID(an);
            com.baidu.adp.lib.util.f.d("----cuid:" + this.u);
            b(SocialConstants.PARAM_CUID, this.u);
        }
    }

    public String o() {
        return this.u;
    }

    public String p() {
        return this.n;
    }

    public boolean q() {
        boolean z = false;
        if (this.z != null) {
            return this.z.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) an.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
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

    private void by() {
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
        this.K = a("gpu_open", i());
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
        boolean a = a("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            a = false;
        }
        com.baidu.adp.lib.c.a.a().a(a);
        com.baidu.tieba.h.a.a().b();
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.LOG) == 0) {
            com.baidu.tieba.log.a.a(true);
        } else {
            com.baidu.tieba.log.a.a(false);
        }
        this.ak = a("has_show_mutiimage_tip", false);
    }

    public void a(boolean z) {
        com.baidu.adp.lib.c.a.a().a(z);
        b("bd_loc_switcher", z);
    }

    public void b(boolean z) {
        this.T = z;
        b("search_mode", z);
    }

    public boolean r() {
        return this.T;
    }

    public boolean s() {
        return this.M;
    }

    public void c(boolean z) {
        this.M = z;
    }

    public boolean t() {
        return this.H;
    }

    public void d(boolean z) {
        b("gpu_open", z);
        this.K = z;
    }

    public boolean u() {
        return this.K;
    }

    public void e(boolean z) {
        b("moplus_service", z);
    }

    public boolean v() {
        return a("moplus_service", true);
    }

    public void f(boolean z) {
        b("push_service", z);
    }

    public boolean w() {
        return a("push_service", true);
    }

    public void g(boolean z) {
        b("app_switcher", z);
        this.L = z;
    }

    public boolean x() {
        return this.L;
    }

    private void bz() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = an.getPackageManager().getApplicationInfo(an.getPackageName(), 128);
            com.baidu.tieba.data.i.a(com.baidu.adp.lib.f.b.a(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
        } catch (Exception e) {
            com.baidu.tieba.data.i.a(3);
            com.baidu.adp.lib.util.f.b(getClass().getName(), "InitVersion", e.getMessage());
        }
        try {
            if (com.baidu.tieba.data.i.w() == 2) {
                com.baidu.tieba.data.i.c(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                return;
            }
            com.baidu.tieba.data.i.c(an.getPackageManager().getPackageInfo(an.getPackageName(), 0).versionName);
            if (com.baidu.tieba.data.i.w() == 1) {
                com.baidu.tieba.data.i.d(String.valueOf(applicationInfo.metaData.get("subVersion")));
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "InitVersion", e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bA() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String bB = bB();
                bufferedReader = new BufferedReader(new InputStreamReader(an.getResources().getAssets().open("channel"), "gbk"));
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.tieba.data.i.b(readLine);
                    if (bB == null) {
                        String bC = bC();
                        if (bC != null && bC.length() > 0) {
                            com.baidu.tieba.data.i.a(bC);
                            A(bC);
                        } else if (readLine != null && readLine.length() > 0) {
                            com.baidu.tieba.data.i.a(readLine);
                            A(readLine);
                            B(readLine);
                        }
                    } else {
                        com.baidu.tieba.data.i.a(bB);
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "InitFrom", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    com.baidu.adp.lib.util.f.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.i.l());
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        com.baidu.adp.lib.util.f.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.i.l());
    }

    private String bB() {
        return a("from_id", (String) null);
    }

    private void A(String str) {
        if (str != null && str.length() > 0 && q()) {
            b("from_id", str);
        }
    }

    private String bC() {
        String str = null;
        try {
            File d = com.baidu.tieba.util.af.d("from.dat");
            if (d != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getFromByFile", e.getMessage());
            cb.a(e, "TiebaApplication.getFromByFile");
        }
        return str;
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
                com.baidu.adp.lib.util.f.b(getClass().getName(), "saveFromToFile", e.getMessage());
                cb.a(e, "TiebaApplication.saveFromToFile");
            }
        }
    }

    public static String y() {
        return com.baidu.tieba.data.i.l();
    }

    public void z() {
        com.baidu.tieba.mention.v.a().a(true);
        DatabaseService.s();
    }

    public com.baidu.adp.widget.ImageView.b j(String str) {
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
    public void e() {
        int b = com.baidu.tbadk.imageManager.e.a().b();
        int max = (int) Math.max(b * 0.8d, com.baidu.tieba.data.i.p());
        if (max < b) {
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.imageManager.e.a().b(max);
        }
    }

    public static String A() {
        if (j != null) {
            return j.getID();
        }
        return null;
    }

    public static boolean B() {
        String A = A();
        return A != null && A.length() > 0;
    }

    public static void a(AccountData accountData, Context context) {
        boolean z = true;
        if ((accountData != null || j == null) && ((j != null || accountData == null) && (j == null || accountData == null || TextUtils.equals(j.getAccount(), accountData.getAccount())))) {
            z = false;
        }
        j = accountData;
        if (context != null) {
            if (g().w()) {
                UtilHelper.f(context);
            } else {
                UtilHelper.g(context);
            }
        }
        a(accountData);
        if (z && accountData != null) {
            a(accountData, an);
        }
    }

    private static void a(AccountData accountData) {
        String str;
        String str2 = null;
        if (accountData != null) {
            str = accountData.getID();
            str2 = accountData.getAccount();
        } else {
            str = null;
        }
        Intent intent = new Intent();
        intent.setAction("adp.bdstatisticsmanager2.account_changed");
        intent.putExtra("intent_data_userid", str);
        intent.putExtra("intent_data_username", str2);
        intent.putExtra("intent_data_bduss", D());
        g().b().sendStickyBroadcast(intent);
    }

    protected static void a(AccountData accountData, Application application) {
        if (BdUtilHelper.c()) {
            b(accountData, application);
        } else if (g() != null) {
            g().c.post(new av(accountData, application));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(AccountData accountData, Application application) {
        com.baidu.tieba.mention.v.a().d();
        if (accountData != null) {
            cb.a(accountData.getAccount(), accountData.getID(), D());
        }
        com.baidu.tieba.im.j.a(new aw(), new ax(accountData, application));
        C();
        com.baidu.tieba.mention.v.a().k();
        com.baidu.tieba.data.emotions.l.a().b();
    }

    public static void C() {
        com.baidu.tieba.im.j.a(new ay(), new az());
    }

    public static String D() {
        if (j != null) {
            return j.getBDUSS();
        }
        return null;
    }

    public static AccountData E() {
        return j;
    }

    public static String F() {
        if (j != null) {
            return j.getAccount();
        }
        return null;
    }

    public void a(long j2) {
        b("update_notify_time", j2);
    }

    public long G() {
        return a("update_notify_time", 0L);
    }

    public void k(String str) {
        b("install_other_app_file_name", str);
    }

    public String H() {
        return a("install_other_app_file_name", (String) null);
    }

    public void I() {
        b("tdatabasecreatetime", new Date().getTime());
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public void l(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (j != null) {
                    j.setTbs(str);
                }
            }
        }
    }

    public String J() {
        if (j != null) {
            return j.getTbs();
        }
        return null;
    }

    public String a(Context context) {
        String str = null;
        String a = a(SocialConstants.PARAM_CLIENT_ID, (String) null);
        if (a != null) {
            int indexOf = a.indexOf("\t");
            if (indexOf != -1) {
                if (com.baidu.tieba.data.i.u().equals(a.substring(0, indexOf))) {
                    str = a.substring(indexOf + 1);
                } else {
                    b((Context) an);
                }
            } else {
                b((Context) an);
            }
        } else {
            str = a;
        }
        com.baidu.adp.lib.util.f.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String K() {
        return o;
    }

    public void b(Context context) {
        com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CLIENT_ID);
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tieba.sharedPref.b.a().b(SocialConstants.PARAM_CLIENT_ID, String.valueOf(com.baidu.tieba.data.i.u()) + "\t" + str);
        }
    }

    public static void m(String str) {
        o = str;
    }

    public void h(boolean z) {
        this.k = z;
    }

    public boolean L() {
        return this.k;
    }

    public int M() {
        return this.ao;
    }

    public void i(boolean z) {
        this.au = z;
        b("permoted_message", z);
    }

    public boolean N() {
        return this.au;
    }

    public void j(boolean z) {
        if (this.as != z) {
            this.as = z;
        }
    }

    public boolean O() {
        return this.aw;
    }

    public void k(boolean z) {
        this.aw = z;
    }

    public String P() {
        return this.ax;
    }

    public void n(String str) {
        this.ax = str;
    }

    public String Q() {
        return this.ay;
    }

    public void o(String str) {
        this.ay = str;
    }

    public boolean R() {
        return this.as;
    }

    public void l(boolean z) {
        this.at = z;
    }

    public boolean S() {
        return this.at;
    }

    public int T() {
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

    public void a(int i) {
        if (i == 0) {
            g().j(false);
            g().l(false);
        } else if (i == 1) {
            g().j(true);
            g().l(false);
        } else if (i == 2) {
            g().j(false);
            g().l(true);
        } else {
            g().j(true);
            g().l(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 int)] */
    public void b(int i) {
        com.baidu.adp.lib.util.f.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i).toString());
        if (i == 0) {
            this.ao = i;
            com.baidu.tieba.mention.v.a().a(true);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.ao = 300;
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean U() {
        return this.ap;
    }

    public void m(boolean z) {
        this.ap = z;
        if (!z) {
            com.baidu.tieba.mention.v.a().d(0);
        }
    }

    public boolean V() {
        return this.aq;
    }

    public void n(boolean z) {
        this.aq = z;
        if (!z) {
            com.baidu.tieba.mention.v.a().c(0);
        }
    }

    public boolean W() {
        return this.ar;
    }

    public void o(boolean z) {
        this.ar = z;
        if (!z) {
            com.baidu.tieba.mention.v.a().b(0);
        }
    }

    public boolean X() {
        return this.av;
    }

    public void p(boolean z) {
        this.av = z;
        if (!z) {
            com.baidu.tieba.mention.v.a().e(0);
        }
    }

    public boolean Y() {
        return a("group_notify", true);
    }

    public void q(boolean z) {
        b("group_notify", z);
    }

    public boolean Z() {
        return this.ao > 0;
    }

    private boolean a(String str, boolean z) {
        return com.baidu.tieba.sharedPref.b.a().a(str, z);
    }

    private void b(String str, boolean z) {
        com.baidu.tieba.sharedPref.b.a().b(str, z);
    }

    private int a(String str, int i) {
        return com.baidu.tieba.sharedPref.b.a().a(str, i);
    }

    private void b(String str, int i) {
        com.baidu.tieba.sharedPref.b.a().b(str, i);
    }

    private long a(String str, long j2) {
        return com.baidu.tieba.sharedPref.b.a().a(str, j2);
    }

    private void b(String str, long j2) {
        com.baidu.tieba.sharedPref.b.a().b(str, j2);
    }

    private String a(String str, String str2) {
        return com.baidu.tieba.sharedPref.b.a().a(str, str2);
    }

    private void b(String str, String str2) {
        com.baidu.tieba.sharedPref.b.a().b(str, str2);
    }

    public boolean aa() {
        return a("alert_sign_on", false);
    }

    public void r(boolean z) {
        b("alert_sign_on", z);
        ad();
    }

    public int ab() {
        int a = a("alert_sign_hours", -1);
        if (a == -1) {
            bD();
            return a("alert_sign_hours", 12);
        }
        return a;
    }

    private void bD() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int ac() {
        int a = a("alert_sign_mins", -1);
        if (a == -1) {
            bD();
            return a("alert_sign_mins", 30);
        }
        return a;
    }

    public void a(int i, int i2) {
        b("alert_sign_hours", i);
        b("alert_sign_mins", i2);
        ad();
    }

    public void ad() {
        AlarmManager alarmManager = (AlarmManager) an.getSystemService("alarm");
        Intent ae = ae();
        if (aa()) {
            Calendar calendar = Calendar.getInstance();
            int ab2 = ab();
            int i = calendar.get(11);
            int ac = ac();
            int i2 = calendar.get(12);
            calendar.set(11, ab2);
            calendar.set(12, ac);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= ab2 && (i != ab2 || i2 >= ac)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(an, 0, ae, 268435456));
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.e("sign-alert alarm set to :" + bs.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(an, 0, ae, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.e("sign-alert alarm cancelled.");
            }
        }
    }

    protected Intent ae() {
        Intent intent = new Intent(com.baidu.tieba.data.i.h());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(an, SignAlertReceiver.class);
        return intent;
    }

    public int af() {
        return this.C;
    }

    public boolean ag() {
        return this.D;
    }

    public int ah() {
        return this.E;
    }

    public void c(int i) {
        if (this.E != i) {
            this.E = i;
            b("font_size", i);
        }
    }

    public boolean ai() {
        return this.J == 1;
    }

    public void s(boolean z) {
        int i = z ? 1 : 0;
        if (this.J != i) {
            this.J = i;
            b("voice_headset_mode", i);
        }
    }

    public void d(int i) {
        this.F = i;
        b("new_abstract_state", i);
    }

    public int aj() {
        return this.F;
    }

    public void t(boolean z) {
        this.I = z;
        b("has_showed_del_ga_tip", z);
    }

    public boolean ak() {
        return this.I;
    }

    public void e(int i) {
        AppsActivity.a();
        f(i);
        b("skin", i);
        TbImageView.setSkinMode(i);
        s(i);
    }

    public void f(int i) {
        this.G = i;
    }

    private void s(int i) {
        Intent intent = new Intent();
        intent.setAction(com.baidu.tieba.data.i.f());
        intent.putExtra("skin_type", i);
        an.sendBroadcast(intent);
    }

    public int al() {
        return this.G;
    }

    public int am() {
        return this.P;
    }

    public void g(int i) {
        this.P = i;
        b("webview_crash_count", i);
    }

    public int an() {
        return this.Q;
    }

    public void h(int i) {
        this.Q = i;
        b("perform_sample_count", i);
    }

    public int ao() {
        return this.R;
    }

    public void i(int i) {
        this.R = i;
        b("new_vcode_webview_crash_count", i);
    }

    public void ap() {
        int a = a("bd_loc_crash_count", 0) + 1;
        b("bd_loc_crash_count", a);
        if (a > 3) {
            a(false);
        }
    }

    public boolean aq() {
        return this.v;
    }

    public void u(boolean z) {
        this.v = z;
    }

    public void a(CombineDownload combineDownload) {
        this.x = combineDownload;
    }

    public CombineDownload ar() {
        return this.x;
    }

    public VersionData as() {
        return this.w;
    }

    public void a(VersionData versionData) {
        this.w = versionData;
    }

    public static void v(boolean z) {
        X = z;
    }

    public bo at() {
        return this.l;
    }

    public void au() {
        this.t = System.currentTimeMillis();
    }

    public void av() {
        this.t = -1L;
    }

    public void aw() {
        if (this.t > 0) {
            this.t = System.currentTimeMillis() - this.t;
            if (this.t > 0) {
                new com.baidu.tieba.account.ax("startup_time", String.valueOf(this.t));
                cb.a("op_launch", this.t);
            }
            com.baidu.adp.lib.util.f.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.t));
        }
        this.t = -1L;
    }

    public void ax() {
        this.p++;
        bF();
    }

    public void ay() {
        this.p--;
        bF();
    }

    private void bE() {
        this.c.sendMessageDelayed(this.c.obtainMessage(5, Boolean.TRUE), 1000L);
    }

    private void bF() {
        if (q()) {
            if (this.p < 0) {
                this.p = 0;
            }
            if (this.q == 0 && this.p > 0) {
                this.q = System.nanoTime();
            }
            com.baidu.adp.lib.util.f.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.p));
            this.c.removeMessages(4);
            if (this.p == 0 && this.q > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 60000L);
            }
            this.c.removeMessages(5);
            if (this.p == 0) {
                bE();
            } else if (this.Y == null || this.Y.get()) {
                this.c.sendMessageDelayed(this.c.obtainMessage(5, Boolean.FALSE), 1000L);
            }
        }
    }

    public boolean az() {
        if (this.Y == null) {
            return true;
        }
        return this.Y.get();
    }

    public void aA() {
        if (this.Y == null) {
            this.Y = new AtomicBoolean(false);
        }
        if (!this.Y.get()) {
            this.Y.set(true);
            com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.im.message.a(true));
            cc.a(null);
            cb.a();
        }
    }

    public void aB() {
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
            com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.im.message.a(false));
        }
    }

    public int aC() {
        return this.Z;
    }

    public void aD() {
        this.Z = 0;
    }

    public boolean aE() {
        if (com.baidu.tieba.util.ag.a("/package.cur/" + com.baidu.tieba.data.i.u())) {
            return false;
        }
        p(com.baidu.tieba.util.ag.d("/package.cur"));
        return true;
    }

    public void aF() {
        com.baidu.tieba.util.ag.c("/package.cur");
        com.baidu.tieba.util.ag.b("/package.cur/" + com.baidu.tieba.data.i.u());
    }

    public void p(String str) {
        if (!bs.c(str) && !"null".equals(str)) {
            com.baidu.tieba.util.ag.c("/package.last");
            com.baidu.tieba.util.ag.b("/package.last/" + str);
        }
    }

    public String aG() {
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

    public void w(boolean z) {
        b("first_sync_image_quality", z);
    }

    public boolean aH() {
        return a("first_sync_image_quality", true);
    }

    public void aI() {
        p("active_clear");
    }

    public void aJ() {
        com.baidu.tieba.sharedPref.b.a().a("account_share");
    }

    public String aK() {
        return a("account_share", (String) null);
    }

    public void q(String str) {
        b("account_share", str);
    }

    public void b(long j2) {
        this.r = j2;
        b("message_id", j2);
    }

    public void a(int i, int i2, String str) {
        if (this.A == null) {
            this.A = Executors.newSingleThreadExecutor();
        }
        com.baidu.adp.lib.util.f.a(getClass().getName(), "pv_addImagePv", "img_num=" + i + " img_total" + i2);
        com.baidu.tieba.account.aw awVar = new com.baidu.tieba.account.aw(i, i2);
        awVar.a(str);
        this.A.execute(awVar);
    }

    public boolean aL() {
        return this.az;
    }

    public void x(boolean z) {
        this.az = z;
        an.sendBroadcast(new Intent(com.baidu.tieba.data.i.a()));
    }

    public static boolean aM() {
        if (g().aL()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(g().G()).longValue() > 86400000;
        }
        return false;
    }

    public void r(String str) {
        s = str;
    }

    public String aN() {
        return s;
    }

    public long aO() {
        return a("last_notify_sound_time", 0L);
    }

    public void c(long j2) {
        b("last_notify_sound_time", j2);
    }

    public void j(int i) {
        b("kn_vote_cd", i);
    }

    public int aP() {
        return a("networkcore_type", 1);
    }

    public void k(int i) {
        bf.a(i);
        b("networkcore_type", i);
    }

    public int aQ() {
        return a("keepalive_wifi", 1);
    }

    public void l(int i) {
        b("keepalive_wifi", i);
    }

    public int aR() {
        return a("keepalive_nonwifi", 1);
    }

    public void m(int i) {
        b("keepalive_nonwifi", i);
    }

    public void s(String str) {
        b("socket_reconn_strategy", str);
    }

    public void t(String str) {
        b("socket_heartbeat_strategy", str);
    }

    public void u(String str) {
        b("socket_getmsg_strategy", str);
    }

    public void y(boolean z) {
        b("is_spring_egg", z);
    }

    public boolean aS() {
        return a("is_spring_egg", false);
    }

    public void a(int[] iArr) {
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

    public int[] aT() {
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
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
        }
        return iArr;
    }

    public int[] aU() {
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

    public int[] aV() {
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

    public int[] aW() {
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

    public void n(int i) {
        b("kn_vote_max", i);
    }

    public void o(int i) {
        b("kn_vote_rate", i);
    }

    public void v(String str) {
        b("push_channel_id", str);
    }

    public String aX() {
        return a("push_channel_userId", "");
    }

    public void w(String str) {
        b("push_channel_userId", str);
    }

    public String aY() {
        return a("push_channel_id", "");
    }

    public void d(long j2) {
        b("nearbygroup_date", j2);
    }

    public long aZ() {
        return a("nearbygroup_date", 0L);
    }

    public void e(long j2) {
        b("banner_date", j2);
    }

    public long ba() {
        return a("banner_date", 0L);
    }

    public void f(long j2) {
        b("group_banner_date", j2);
    }

    public long bb() {
        return a("group_banner_date", 0L);
    }

    public void x(String str) {
        b("location_lat", str);
    }

    public String bc() {
        return a("location_lat", "");
    }

    public void y(String str) {
        b("location_lng", str);
    }

    public boolean bd() {
        return a("location_shared", false);
    }

    public void z(boolean z) {
        b("location_shared", z);
    }

    public String be() {
        return a("location_lng", "");
    }

    public void z(String str) {
        b("location_pos", str);
    }

    public com.baidu.adp.lib.cache.s<String> bf() {
        if (this.N == null) {
            this.N = BdCacheService.c().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.N;
    }

    public void p(int i) {
        int max = Math.max((int) (UtilHelper.a(g().b()) * 0.28f), i);
        com.baidu.adp.lib.util.f.d("set pic cache size to :" + (max / LocationClientOption.MIN_SCAN_SPAN) + "KB. needed:" + (i / LocationClientOption.MIN_SCAN_SPAN) + "KB.");
        com.baidu.tbadk.imageManager.e.a().b(max);
    }

    public int bg() {
        return this.ag;
    }

    public void q(int i) {
        this.ag = i;
        b("faceshop_version", this.ag);
    }

    public void r(int i) {
        this.ah = i;
    }

    public boolean bh() {
        return this.O;
    }

    public int bi() {
        return this.ah;
    }

    public boolean bj() {
        return this.ai;
    }

    public void A(boolean z) {
        this.ai = z;
    }

    public void bk() {
        try {
            an.startService(new Intent(an, FatalErrorService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("failed to start FatalErrorService:" + th.getMessage());
        }
    }

    public void bl() {
        try {
            an.startService(new Intent(an, ClearTempService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
        }
    }

    public void bm() {
        an.startService(new Intent(an, TiebaSyncService.class));
    }

    public void bn() {
        an.stopService(new Intent(an, TiebaSyncService.class));
    }

    public void bo() {
        an.startService(new Intent(an, TiebaActiveService.class));
    }

    public void bp() {
        an.stopService(new Intent(an, TiebaActiveService.class));
    }

    public void a(PersonChangeData personChangeData) {
        this.am = personChangeData;
    }

    public PersonChangeData bq() {
        return this.am;
    }

    public LimitList br() {
        return this.aj;
    }

    public void bs() {
        if (this.aj != null) {
            this.aj.clear();
        }
    }

    public void B(boolean z) {
        this.ak = z;
        b("has_show_mutiimage_tip", z);
    }

    public boolean bt() {
        return this.ak;
    }

    public boolean bu() {
        return this.al;
    }
}
