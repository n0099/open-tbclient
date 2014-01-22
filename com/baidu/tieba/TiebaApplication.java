package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.location.Address;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.account.AccountProxy;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.android.common.util.CommonParam;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.frontia.FrontiaApplication;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.account.SapiFastRegActivity;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.switchs.SwitchModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bu;
import com.baidu.tieba.util.by;
import com.baidu.tieba.util.bz;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.util.ce;
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
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class TiebaApplication extends com.baidu.adp.a.b {
    private static TiebaApplication f;
    private LocationManager D;
    private int ab;
    private PersonChangeData ao;
    private com.baidu.tieba.dex.a ap;
    private Boolean y;
    private static AccountData i = null;
    private static String n = null;
    private static boolean o = false;
    private static boolean ac = false;
    private static Intent ag = null;
    private static final byte[] aD = new byte[0];
    private static volatile Boolean aE = null;
    private int e = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.d>> g = null;
    private int h = 1;
    private boolean j = false;
    private com.baidu.tieba.util.bq k = null;
    private com.baidu.tieba.util.bq l = null;
    private String m = null;
    private int p = 0;
    private long q = 0;
    private long r = 0;
    private long s = -1;
    private String t = null;
    private boolean u = false;
    private VersionData v = null;
    private CombineDownload w = null;
    private BannerData x = null;
    public long a = 0;
    private boolean z = true;
    private LocationClient A = null;
    private BDLocationListener B = null;
    private int C = 0;
    private Address E = null;
    private bm F = null;
    private ArrayList<SoftReference<bl>> G = null;
    private ExecutorService H = null;
    private int I = 0;
    private int J = 0;
    private boolean K = true;
    private int L = 3;
    private int M = 1;
    private int N = 0;
    private boolean O = true;
    private boolean P = false;
    private int Q = 0;
    private boolean R = false;
    private boolean S = false;
    private boolean T = true;
    private com.baidu.adp.lib.cache.s<String> U = null;
    private boolean V = true;
    private int W = 0;
    private int X = 10;
    private int Y = 0;
    private boolean Z = false;
    private boolean aa = true;
    private AtomicBoolean ad = null;
    private int ae = 0;
    private long af = 0;
    public ArrayList<j> b = null;
    private Hashtable<String, Integer> ah = null;
    private Hashtable<String, Integer> ai = null;
    private Hashtable<String, Integer> aj = null;
    private Hashtable<String, Integer> ak = null;
    private int al = -1;
    private int am = -1;
    private boolean an = false;
    public Handler c = new Handler(new bc(this));
    com.baidu.adp.lib.c.d d = new be(this);
    private int aq = 0;
    private boolean ar = true;
    private boolean as = true;
    private boolean at = true;
    private boolean au = true;
    private boolean av = false;
    private boolean aw = true;
    private boolean ax = true;
    private boolean ay = false;
    private String az = "23:00";
    private String aA = "09:00";
    private final LocationListener aB = new bk(this);
    private boolean aC = false;

    public static void a(Intent intent) {
        ag = intent;
    }

    public static Intent d() {
        return ag;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        if (!b()) {
            com.baidu.bdcvf.a.a().a(this, new bd(this));
        }
        f = this;
        FrontiaApplication.initFrontia(getApplicationContext());
        new bn(null).execute(new String[0]);
        NetWorkCore.F();
        bt();
        if (q()) {
            com.baidu.tieba.sharedPref.b.a().b();
        }
        bu();
        bp();
        bs();
        ce.a(this);
        n = a((Context) this);
        bq();
        br();
        com.baidu.tieba.data.h.d(this);
        com.baidu.tieba.data.h.b(this);
        com.baidu.tieba.data.h.c(this);
        SapiFastRegActivity.a(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new cb());
        } catch (SecurityException e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "onCreate", e.getMessage());
        }
        by.a(this);
        this.ap = new com.baidu.tieba.dex.a(this);
        if (q()) {
            if (aF()) {
                com.baidu.adp.lib.a.d.a().b();
            }
            com.baidu.tbadk.imageManager.d.a().a(50, com.baidu.tieba.data.h.e());
            com.baidu.adp.lib.e.c.a().a(com.baidu.tieba.util.a.g.a());
            TbFaceManager.a().a(this, new com.baidu.tieba.util.ab());
            this.g = new HashMap<>();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                i = DatabaseService.n();
                if (i != null) {
                    by.a(i.getAccount(), i.getID(), D());
                    a(i);
                    com.baidu.tieba.im.chat.q.a = com.baidu.tieba.im.db.au.a().b();
                }
            }
            if (n()) {
                f.a(this);
            } else {
                com.baidu.tieba.account.l.a().a(this);
            }
            DatabaseService.v();
            m();
            this.k = new com.baidu.tieba.util.bq(300);
            this.l = new com.baidu.tieba.util.bq(100);
            com.baidu.tieba.mention.s.a().b();
            bA();
            this.G = new ArrayList<>();
            ae();
            new com.baidu.tieba.data.chat.a().a();
            k();
            l();
            com.baidu.tieba.im.i.a(this);
            new com.baidu.tieba.account.av("open").start();
            com.baidu.tieba.data.emotions.l.a().b();
        } else {
            this.b = new ArrayList<>();
        }
        try {
            registerReceiver(new com.baidu.tieba.service.f(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e2) {
            com.baidu.adp.lib.g.e.a(e2.getMessage());
        }
        TbImageView.setSkinMode(this.N);
        try {
            com.baidu.adp.lib.c.a.a().a(this, "tieba");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (q()) {
            by();
            f();
        }
    }

    public com.baidu.tieba.dex.a e() {
        return this.ap;
    }

    public void f() {
        com.baidu.adp.lib.c.a.a().a(true, this.d);
    }

    public boolean g() {
        boolean z = false;
        String trim = Build.MODEL.trim();
        if (trim == null) {
            return true;
        }
        String[] strArr = {"M040", "M032", "M031", "M030", "HUAWEI C8813", "ZTE U970", "MediaPad 10 FHD", "GT-I9000", "DOEASY E930", "H8205", "GT-N7108", "GT-N7102", "GT-N719", "GT-N7100", "galaxy nexus", " ZTE U808", "UMI_X1", "nexus s", "AMOI N820", "JY-G", "XT885", "U701T", "Lenovo A750", "ZTE U807", "vivo S11t", "Droid Bionic", "MORAL_N01", "XT910", "GT-S7562", "Lenovo A798t", "vivo E5", "U705T", "HUAWEI T8951", "ME865", "HUAWEI P1XL", "KPT A9PLUS", "vivo Y11", "T9200", "XT928", "HUAWEI Y500-T00", "BBK Y3t", "Lenovo K860", "vivo X1", "HUAWEI T8833", "Lenovo A789", "ZTE U960E"};
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (strArr[i2].equalsIgnoreCase(trim)) {
                break;
            } else {
                i2++;
            }
        }
        if (com.baidu.adp.lib.g.e.a()) {
            com.baidu.adp.lib.g.e.c("device:[" + trim + "], default GPU on:" + z);
        }
        return z;
    }

    public static TiebaApplication h() {
        return f;
    }

    public boolean a(String str) {
        if (this.ai == null || str == null) {
            return false;
        }
        return this.ai.containsKey(str);
    }

    public void a(String str, int i2, int i3) {
        if (!a(str) && this.ai != null && str != null) {
            if (this.ai.size() > 100) {
                this.ai.clear();
                this.aj.clear();
            }
            this.ai.put(str, Integer.valueOf(i2));
            this.aj.put(str, Integer.valueOf(i3));
        }
    }

    public void i() {
        if (this.ai != null) {
            this.ai.clear();
        }
        if (this.aj != null) {
            this.aj.clear();
        }
    }

    public int b(String str) {
        if (a(str)) {
            return this.ai.get(str).intValue();
        }
        return 0;
    }

    public int c(String str) {
        if (a(str)) {
            return this.aj.get(str).intValue();
        }
        return -1;
    }

    public int j() {
        if (this.ai != null) {
            return this.ai.size();
        }
        return 0;
    }

    public void k() {
        if (this.ai == null) {
            this.ai = new Hashtable<>();
        }
        if (this.aj == null) {
            this.aj = new Hashtable<>();
        }
    }

    public int d(String str) {
        if (this.ak == null || str == null || !this.ak.containsKey(str)) {
            return 0;
        }
        return this.ak.get(str).intValue();
    }

    public void e(String str) {
        if (this.ak != null && str != null) {
            this.ak.put(str, 1);
            h(true);
            if (this.ak.size() > 200) {
                this.ak.clear();
            }
        }
    }

    public void f(String str) {
        if (this.ak != null && str != null) {
            this.ak.put(str, -1);
            h(true);
            if (this.ak.size() > 200) {
                this.ak.clear();
            }
        }
    }

    public void l() {
        if (this.ak == null) {
            this.ak = new Hashtable<>();
        }
    }

    public boolean g(String str) {
        if (this.ah == null || str == null) {
            return false;
        }
        return this.ah.containsKey(str);
    }

    public void h(String str) {
        if (!g(str) && this.ah != null && str != null) {
            this.ah.put(str, 1);
            new com.baidu.tieba.util.af(1, str).start();
        }
    }

    public void i(String str) {
        if (g(str) && this.ah != null && str != null) {
            this.ah.remove(str);
            new com.baidu.tieba.util.af(2, str).start();
        }
    }

    public void m() {
        this.ah = new Hashtable<>();
        new com.baidu.tieba.util.af(this.ah).start();
    }

    public void a(j jVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.b.get(i2).releaseResouce();
                } catch (Exception e) {
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "addRemoteActivity", e.getMessage());
                }
            }
            if (jVar != null) {
                this.b.add(jVar);
            }
        }
    }

    public void b(j jVar) {
        if (this.b != null) {
            this.b.remove(jVar);
        }
    }

    private void bp() {
        if (Build.VERSION.SDK_INT >= 5) {
            o = new AccountProxy(this).hasBaiduAccount();
        } else {
            o = false;
        }
    }

    public static boolean n() {
        return o;
    }

    private void bq() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.m = telephonyManager.getDeviceId();
        }
        if (this.m == null) {
            this.m = "000000000000000";
        }
    }

    private void br() {
        if (this.t == null || this.t.length() < 0) {
            this.t = CommonParam.getCUID(this);
            com.baidu.adp.lib.g.e.c("----cuid:" + this.t);
            com.baidu.tieba.sharedPref.b.a().b(SocialConstants.PARAM_CUID, this.t);
        }
    }

    public String o() {
        return this.t;
    }

    public String p() {
        return this.m;
    }

    public boolean q() {
        boolean z = false;
        if (this.y != null) {
            return this.y.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        int myPid = Process.myPid();
        if (runningAppProcesses != null) {
            this.y = Boolean.TRUE;
            int i2 = 0;
            while (true) {
                if (i2 >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i2).pid != myPid) {
                    i2++;
                } else {
                    String str = runningAppProcesses.get(i2).processName;
                    if (str != null && (str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1") || str.equalsIgnoreCase("com.baidu.tieba:remote") || str.equalsIgnoreCase("com.baidu.tieba:bdservice_v1"))) {
                        this.y = Boolean.FALSE;
                    }
                }
            }
        }
        z = true;
        return z;
    }

    private void bs() {
        SwitchModel.initSwitchManager();
        this.I = com.baidu.tieba.sharedPref.b.a().a("image_quality", 0);
        this.J = com.baidu.tieba.sharedPref.b.a().a("view_image_quality", 0);
        this.K = com.baidu.tieba.sharedPref.b.a().a("show_images", true);
        this.L = com.baidu.tieba.sharedPref.b.a().a("font_size", 2);
        this.aw = com.baidu.tieba.sharedPref.b.a().a("permoted_message", true);
        this.h = com.baidu.tieba.sharedPref.b.a().a("new_display_photo", 1);
        this.M = com.baidu.tieba.sharedPref.b.a().a("new_abstract_state", 0);
        this.N = com.baidu.tieba.sharedPref.b.a().a("skin", 0);
        this.r = com.baidu.tieba.sharedPref.b.a().a("message_id", 0L);
        this.Q = com.baidu.tieba.sharedPref.b.a().a("voice_headset_mode", 0);
        this.R = com.baidu.tieba.sharedPref.b.a().a("gpu_open", g());
        this.S = com.baidu.tieba.sharedPref.b.a().a("app_switcher", false);
        this.Z = com.baidu.tieba.sharedPref.b.a().a("manage_mode", false);
        this.O = com.baidu.tieba.sharedPref.b.a().a("location_on", true);
        this.P = com.baidu.tieba.sharedPref.b.a().a("open_local_popularize", false);
        this.W = com.baidu.tieba.sharedPref.b.a().a("webview_crash_count", 0);
        this.Y = com.baidu.tieba.sharedPref.b.a().a("new_vcode_webview_crash_count", 0);
        this.z = com.baidu.tieba.sharedPref.b.a().a("bd_loc_switcher", true);
        this.aa = com.baidu.tieba.sharedPref.b.a().a("search_mode", true);
        this.ab = com.baidu.tieba.sharedPref.b.a().a("search_mode_int", 0);
        this.t = com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CUID, (String) null);
        this.X = com.baidu.tieba.sharedPref.b.a().a("perform_sample_count", 0);
        this.al = com.baidu.tieba.sharedPref.b.a().a("faceshop_version", -1);
        if (Build.VERSION.SDK_INT <= 4) {
            this.z = false;
        }
        com.baidu.tieba.e.a.a().b();
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.LOG) == 0) {
            com.baidu.tieba.log.a.a(true);
        } else {
            com.baidu.tieba.log.a.a(false);
        }
    }

    public void a(boolean z) {
        this.z = z;
        com.baidu.tieba.sharedPref.b.a().b("bd_loc_switcher", z);
    }

    public void b(boolean z) {
        this.aa = z;
        com.baidu.tieba.sharedPref.b.a().b("search_mode", z);
    }

    public boolean r() {
        return this.aa;
    }

    public boolean s() {
        return this.T;
    }

    public void c(boolean z) {
        this.T = z;
    }

    public boolean t() {
        return this.O;
    }

    public void d(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("gpu_open", z);
        this.R = z;
    }

    public boolean u() {
        return this.R;
    }

    public void e(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("moplus_service", z);
    }

    public boolean v() {
        return com.baidu.tieba.sharedPref.b.a().a("moplus_service", true);
    }

    public void f(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("push_service", z);
    }

    public boolean w() {
        return com.baidu.tieba.sharedPref.b.a().a("push_service", true);
    }

    public void g(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("app_switcher", z);
        this.S = z;
    }

    public boolean x() {
        return this.S;
    }

    private void bt() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            com.baidu.tieba.data.h.a(com.baidu.adp.lib.f.b.a(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
        } catch (Exception e) {
            com.baidu.tieba.data.h.a(3);
            com.baidu.adp.lib.g.e.b(getClass().getName(), "InitVersion", e.getMessage());
        }
        try {
            if (com.baidu.tieba.data.h.l() == 2) {
                com.baidu.tieba.data.h.c(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                return;
            }
            com.baidu.tieba.data.h.c(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            if (com.baidu.tieba.data.h.l() == 1) {
                com.baidu.tieba.data.h.d(String.valueOf(applicationInfo.metaData.get("subVersion")));
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "InitVersion", e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bu() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String bv = bv();
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.tieba.data.h.b(readLine);
                    if (bv == null) {
                        String bw = bw();
                        if (bw != null && bw.length() > 0) {
                            com.baidu.tieba.data.h.a(bw);
                            A(bw);
                        } else if (readLine != null && readLine.length() > 0) {
                            com.baidu.tieba.data.h.a(readLine);
                            A(readLine);
                            B(readLine);
                        }
                    } else {
                        com.baidu.tieba.data.h.a(bv);
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
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "InitFrom", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    com.baidu.adp.lib.g.e.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.h.a());
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
        com.baidu.adp.lib.g.e.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.h.a());
    }

    private String bv() {
        return com.baidu.tieba.sharedPref.b.a().a("from_id", (String) null);
    }

    private void A(String str) {
        if (str != null && str.length() > 0 && q()) {
            com.baidu.tieba.sharedPref.b.a().b("from_id", str);
        }
    }

    private String bw() {
        String str = null;
        try {
            File d = com.baidu.tieba.util.ad.d("from.dat");
            if (d != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "getFromByFile", e.getMessage());
            by.a(e, "TiebaApplication.getFromByFile");
        }
        return str;
    }

    private void B(String str) {
        if (str != null && str.length() > 0) {
            try {
                File f2 = com.baidu.tieba.util.ad.f("from.dat");
                if (f2 != null) {
                    FileWriter fileWriter = new FileWriter(f2);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "saveFromToFile", e.getMessage());
                by.a(e, "TiebaApplication.saveFromToFile");
            }
        }
    }

    public static String y() {
        return com.baidu.tieba.data.h.a();
    }

    public void z() {
        com.baidu.tieba.mention.s.a().a(true);
        DatabaseService.v();
    }

    public com.baidu.adp.widget.ImageView.d j(String str) {
        SoftReference<com.baidu.adp.widget.ImageView.d> softReference = this.g.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.ImageView.d a = TbFaceManager.a().a(str);
        if (a != null) {
            this.g.put(str, new SoftReference<>(a));
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
        c();
        super.onLowMemory();
    }

    @Override // com.baidu.adp.a.b
    public void c() {
        int b = com.baidu.tbadk.imageManager.d.a().b();
        int max = (int) Math.max(b * 0.8d, com.baidu.tieba.data.h.e());
        if (max < b) {
            if (com.baidu.adp.lib.g.e.a()) {
                com.baidu.adp.lib.g.e.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.imageManager.d.a().b(max);
        }
    }

    public static String A() {
        if (i != null) {
            return i.getID();
        }
        return null;
    }

    public static boolean B() {
        String A = A();
        return A != null && A.length() > 0;
    }

    public static void a(AccountData accountData, Context context) {
        boolean z = true;
        if ((accountData != null || i == null) && ((i != null || accountData == null) && (i == null || accountData == null || TextUtils.equals(i.getAccount(), accountData.getAccount())))) {
            z = false;
        }
        i = accountData;
        if (context != null) {
            if (h().w()) {
                UtilHelper.e(context);
            } else {
                UtilHelper.f(context);
            }
        }
        a(accountData);
        if (z && accountData != null) {
            a(accountData, h());
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
        h().sendStickyBroadcast(intent);
    }

    protected static void a(AccountData accountData, TiebaApplication tiebaApplication) {
        if (com.baidu.adp.lib.g.g.b()) {
            b(accountData, tiebaApplication);
        } else if (h() != null) {
            h().c.post(new bf(accountData, tiebaApplication));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(AccountData accountData, TiebaApplication tiebaApplication) {
        com.baidu.tieba.mention.s.a().d();
        com.baidu.tieba.im.m.a(new bg(), new bh(accountData, tiebaApplication));
        C();
        com.baidu.tieba.mention.s.a().k();
        com.baidu.tieba.data.emotions.l.a().b();
    }

    public static void C() {
        com.baidu.tieba.im.db.ae.a().c();
        com.baidu.tieba.im.m.a(new bi(), new bj());
    }

    public static String D() {
        if (i != null) {
            return i.getBDUSS();
        }
        return null;
    }

    public static void k(String str) {
        boolean z = true;
        if (i != null) {
            if (str != null ? str.equals(i.getBDUSS()) : i.getBDUSS() == null) {
                z = false;
            }
            i.setBDUSS(str);
            if (z) {
                a(i, h());
            }
        }
    }

    public static AccountData E() {
        return i;
    }

    public static String F() {
        if (i != null) {
            return i.getAccount();
        }
        return null;
    }

    public void a(long j) {
        com.baidu.tieba.sharedPref.b.a().b("update_notify_time", j);
    }

    public long G() {
        return com.baidu.tieba.sharedPref.b.a().a("update_notify_time", 0L);
    }

    public void l(String str) {
        com.baidu.tieba.sharedPref.b.a().b("install_other_app_file_name", str);
    }

    public String H() {
        return com.baidu.tieba.sharedPref.b.a().a("install_other_app_file_name", (String) null);
    }

    public void I() {
        com.baidu.tieba.sharedPref.b.a().b("tdatabasecreatetime", new Date().getTime());
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public void m(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (i != null) {
                    i.setTbs(str);
                }
            }
        }
    }

    public String J() {
        if (i != null) {
            return i.getTbs();
        }
        return null;
    }

    public String a(Context context) {
        String str = null;
        String a = com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CLIENT_ID, (String) null);
        if (a != null) {
            int indexOf = a.indexOf("\t");
            if (indexOf != -1) {
                if (com.baidu.tieba.data.h.j().equals(a.substring(0, indexOf))) {
                    str = a.substring(indexOf + 1);
                } else {
                    b((Context) h());
                }
            } else {
                b((Context) h());
            }
        } else {
            str = a;
        }
        com.baidu.adp.lib.g.e.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String K() {
        return n;
    }

    public void b(Context context) {
        com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CLIENT_ID);
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tieba.sharedPref.b.a().b(SocialConstants.PARAM_CLIENT_ID, com.baidu.tieba.data.h.j() + "\t" + str);
        }
    }

    public static void n(String str) {
        n = str;
    }

    public void h(boolean z) {
        this.j = z;
    }

    public boolean L() {
        return this.j;
    }

    public int M() {
        return this.aq;
    }

    public void N() {
        b(300);
        m(true);
        o(true);
        n(true);
        p(true);
        k(false);
        o("23:00");
        p("09:00");
    }

    public void i(boolean z) {
        this.aw = z;
        com.baidu.tieba.sharedPref.b.a().b("permoted_message", z);
    }

    public boolean O() {
        return this.aw;
    }

    public void j(boolean z) {
        if (this.au != z) {
            this.au = z;
        }
    }

    public boolean P() {
        return this.ay;
    }

    public void k(boolean z) {
        this.ay = z;
    }

    public String Q() {
        return this.az;
    }

    public void o(String str) {
        this.az = str;
    }

    public String R() {
        return this.aA;
    }

    public void p(String str) {
        this.aA = str;
    }

    public boolean S() {
        return this.au;
    }

    public void l(boolean z) {
        this.av = z;
    }

    public boolean T() {
        return this.av;
    }

    public int U() {
        if (!this.au && !this.av) {
            return 0;
        }
        if (!this.au || this.av) {
            if (!this.au && this.av) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void a(int i2) {
        if (i2 == 0) {
            h().j(false);
            h().l(false);
        } else if (i2 == 1) {
            h().j(true);
            h().l(false);
        } else if (i2 == 2) {
            h().j(false);
            h().l(true);
        } else {
            h().j(true);
            h().l(true);
        }
    }

    public void b(int i2) {
        com.baidu.adp.lib.g.e.a(getClass().getName(), "setMsgFrequence", "" + i2);
        if (i2 == 0) {
            this.aq = i2;
            com.baidu.tieba.mention.s.a().a(true);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.aq = 300;
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean V() {
        return this.ar;
    }

    public void m(boolean z) {
        this.ar = z;
        if (!z) {
            com.baidu.tieba.mention.s.a().d(0);
        }
    }

    public boolean W() {
        return this.as;
    }

    public void n(boolean z) {
        this.as = z;
        if (!z) {
            com.baidu.tieba.mention.s.a().c(0);
        }
    }

    public boolean X() {
        return this.at;
    }

    public void o(boolean z) {
        this.at = z;
        if (!z) {
            com.baidu.tieba.mention.s.a().b(0);
        }
    }

    public boolean Y() {
        return this.ax;
    }

    public void p(boolean z) {
        this.ax = z;
        if (!z) {
            com.baidu.tieba.mention.s.a().e(0);
        }
    }

    public boolean Z() {
        return com.baidu.tieba.sharedPref.b.a().a("group_notify", true);
    }

    public void q(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("group_notify", z);
    }

    public boolean aa() {
        return this.aq > 0;
    }

    public boolean ab() {
        return com.baidu.tieba.sharedPref.b.a().a("alert_sign_on", false);
    }

    public void r(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_on", z);
        ae();
    }

    public int ac() {
        int a = com.baidu.tieba.sharedPref.b.a().a("alert_sign_hours", -1);
        if (a == -1) {
            bx();
            return com.baidu.tieba.sharedPref.b.a().a("alert_sign_hours", 12);
        }
        return a;
    }

    private void bx() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int ad() {
        int a = com.baidu.tieba.sharedPref.b.a().a("alert_sign_mins", -1);
        if (a == -1) {
            bx();
            return com.baidu.tieba.sharedPref.b.a().a("alert_sign_mins", 30);
        }
        return a;
    }

    public void a(int i2, int i3) {
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_hours", i2);
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_mins", i3);
        ae();
    }

    public void ae() {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent af = af();
        if (ab()) {
            Calendar calendar = Calendar.getInstance();
            int ac2 = ac();
            int i2 = calendar.get(11);
            int ad = ad();
            int i3 = calendar.get(12);
            calendar.set(11, ac2);
            calendar.set(12, ad);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i2 >= ac2 && (i2 != ac2 || i3 >= ad)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this, 0, af, 268435456));
            if (com.baidu.adp.lib.g.e.a()) {
                com.baidu.adp.lib.g.e.d("sign-alert alarm set to :" + bu.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, af, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.g.e.a()) {
                com.baidu.adp.lib.g.e.d("sign-alert alarm cancelled.");
            }
        }
    }

    protected Intent af() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.signalert");
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(this, SignAlertReceiver.class);
        return intent;
    }

    public int ag() {
        return this.J;
    }

    public boolean ah() {
        return this.K;
    }

    public int ai() {
        return this.L;
    }

    public void c(int i2) {
        if (this.L != i2) {
            this.L = i2;
            com.baidu.tieba.sharedPref.b.a().b("font_size", i2);
        }
    }

    public boolean aj() {
        return this.Q == 1;
    }

    public void s(boolean z) {
        int i2 = z ? 1 : 0;
        if (this.Q != i2) {
            this.Q = i2;
            com.baidu.tieba.sharedPref.b.a().b("voice_headset_mode", i2);
        }
    }

    public void d(int i2) {
        this.M = i2;
        com.baidu.tieba.sharedPref.b.a().b("new_abstract_state", i2);
    }

    public int ak() {
        return this.M;
    }

    public void t(boolean z) {
        this.P = z;
        com.baidu.tieba.sharedPref.b.a().b("open_local_popularize", z);
    }

    public void e(int i2) {
        AppsActivity.a();
        f(i2);
        com.baidu.tieba.sharedPref.b.a().b("skin", i2);
        TbImageView.setSkinMode(i2);
        s(i2);
    }

    public void f(int i2) {
        this.N = i2;
    }

    private void s(int i2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i2);
        sendBroadcast(intent);
    }

    public int al() {
        return this.N;
    }

    public int am() {
        return this.W;
    }

    public void g(int i2) {
        this.W = i2;
        com.baidu.tieba.sharedPref.b.a().b("webview_crash_count", i2);
    }

    public int an() {
        return this.X;
    }

    public void h(int i2) {
        this.X = i2;
        com.baidu.tieba.sharedPref.b.a().b("perform_sample_count", i2);
    }

    public int ao() {
        return this.Y;
    }

    public void i(int i2) {
        this.Y = i2;
        com.baidu.tieba.sharedPref.b.a().a("new_vcode_webview_crash_count", i2);
    }

    public void ap() {
        int a = com.baidu.tieba.sharedPref.b.a().a("bd_loc_crash_count", 0) + 1;
        com.baidu.tieba.sharedPref.b.a().b("bd_loc_crash_count", a);
        if (a > 3) {
            a(false);
        }
    }

    public boolean aq() {
        return this.u;
    }

    public void u(boolean z) {
        this.u = z;
    }

    public void a(CombineDownload combineDownload) {
        this.w = combineDownload;
    }

    public CombineDownload ar() {
        return this.w;
    }

    public VersionData as() {
        return this.v;
    }

    public void a(VersionData versionData) {
        this.v = versionData;
    }

    public static boolean at() {
        return ac;
    }

    public static void v(boolean z) {
        ac = z;
    }

    public com.baidu.tieba.util.bq au() {
        return this.k;
    }

    public void av() {
        this.s = System.currentTimeMillis();
    }

    public void aw() {
        this.s = -1L;
    }

    public void ax() {
        if (this.s > 0) {
            this.s = System.currentTimeMillis() - this.s;
            if (this.s > 0) {
                new com.baidu.tieba.account.av("startup_time", String.valueOf(this.s));
                by.a("op_launch", this.s);
            }
            com.baidu.adp.lib.g.e.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.s));
        }
        this.s = -1L;
    }

    public void ay() {
        this.p++;
        bz();
    }

    public void az() {
        this.p--;
        bz();
    }

    private void by() {
        this.c.sendMessageDelayed(this.c.obtainMessage(6, Boolean.TRUE), 1000L);
    }

    private void bz() {
        if (q()) {
            if (this.p < 0) {
                this.p = 0;
            }
            if (this.q == 0 && this.p > 0) {
                this.q = System.nanoTime();
            }
            com.baidu.adp.lib.g.e.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.p));
            this.c.removeMessages(4);
            if (this.p == 0 && this.q > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 60000L);
            }
            this.c.removeMessages(6);
            if (this.p == 0) {
                by();
            } else if (this.ad == null || this.ad.get()) {
                this.c.sendMessageDelayed(this.c.obtainMessage(6, Boolean.FALSE), 1000L);
            }
        }
    }

    public boolean aA() {
        if (this.ad == null) {
            return true;
        }
        return this.ad.get();
    }

    public void aB() {
        if (this.ad == null) {
            this.ad = new AtomicBoolean(false);
        }
        if (!this.ad.get()) {
            this.ad.set(true);
            com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.im.message.a(true));
            bz.a(null);
            by.a();
        }
    }

    public void aC() {
        if (this.ad == null) {
            this.ad = new AtomicBoolean(true);
        }
        if (this.ad.get()) {
            this.ad.set(false);
            this.ae++;
            if (System.currentTimeMillis() - this.af > 3600000 || this.af == 0) {
                this.af = System.currentTimeMillis();
                new com.baidu.tieba.account.v().start();
            }
            com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.im.message.a(false));
        }
    }

    public int aD() {
        return this.ae;
    }

    public void aE() {
        this.ae = 0;
    }

    public boolean aF() {
        if (com.baidu.tieba.util.ae.a("/package.cur/" + com.baidu.tieba.data.h.j())) {
            return false;
        }
        q(com.baidu.tieba.util.ae.d("/package.cur"));
        return true;
    }

    public void aG() {
        com.baidu.tieba.util.ae.c("/package.cur");
        com.baidu.tieba.util.ae.b("/package.cur/" + com.baidu.tieba.data.h.j());
    }

    public void q(String str) {
        if (!bu.c(str) && !"null".equals(str)) {
            com.baidu.tieba.util.ae.c("/package.last");
            com.baidu.tieba.util.ae.b("/package.last/" + str);
        }
    }

    public String aH() {
        String d;
        if (!com.baidu.tieba.util.ae.a("/package.last")) {
            d = com.baidu.tieba.sharedPref.b.a().a("active_version", "");
        } else {
            d = com.baidu.tieba.util.ae.d("/package.last");
        }
        if ("active_clear".equals(d)) {
            return null;
        }
        return d;
    }

    public void w(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("first_sync_image_quality", z);
    }

    public boolean aI() {
        return com.baidu.tieba.sharedPref.b.a().a("first_sync_image_quality", true);
    }

    public void aJ() {
        q("active_clear");
    }

    public void aK() {
        com.baidu.tieba.sharedPref.b.a().a("account_share");
    }

    public String aL() {
        return com.baidu.tieba.sharedPref.b.a().a("account_share", (String) null);
    }

    public void r(String str) {
        com.baidu.tieba.sharedPref.b.a().b("account_share", str);
    }

    private void bA() {
        try {
            this.D = (LocationManager) getSystemService("location");
            if (this.z) {
                this.B = new MyBDLocationListenner();
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName("tieba");
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(500);
                locationClientOption.disableCache(true);
                this.A = new LocationClient(getApplicationContext());
                this.A.registerLocationListener(this.B);
                this.A.setLocOption(locationClientOption);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public void aM() {
        try {
            if (this.E == null || System.currentTimeMillis() - this.a > 300000) {
                this.E = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.D != null) {
                    this.D.removeUpdates(this.aB);
                }
                if (this.z) {
                    if (!this.A.isStarted()) {
                        this.A.start();
                    }
                    this.A.requestLocation();
                }
                this.C = 4;
                if (this.D != null && !this.D.isProviderEnabled("gps") && !this.D.isProviderEnabled("network")) {
                    this.C = 3;
                    if (!this.z) {
                        this.c.sendMessageDelayed(this.c.obtainMessage(5), 100L);
                        return;
                    }
                }
                if (this.D != null && this.D.isProviderEnabled("gps")) {
                    C("gps");
                } else {
                    this.C = 1;
                }
                if (this.D != null && this.D.isProviderEnabled("network")) {
                    C("network");
                } else {
                    this.C = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), 60000L);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    private void C(String str) {
        if (this.D.isProviderEnabled(str)) {
            this.D.requestLocationUpdates(str, 10000L, 100.0f, this.aB);
        }
    }

    /* loaded from: classes.dex */
    public class MyBDLocationListenner implements BDLocationListener {
        public MyBDLocationListenner() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                TiebaApplication.this.C = 0;
                TiebaApplication.this.aN();
                TiebaApplication.this.E = new Address(Locale.getDefault());
                TiebaApplication.this.E.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.E.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.a = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if ((bDLocation.getDistrict() == null || bDLocation.getStreet() == null) && bDLocation.getCity() != null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                if (bDLocation.getDistrict() != null) {
                    stringBuffer.append(bDLocation.getDistrict());
                }
                if (bDLocation.getStreet() != null) {
                    stringBuffer.append(bDLocation.getStreet());
                }
                if (bDLocation.getAddrStr() != null) {
                    TiebaApplication.this.E.setAddressLine(0, stringBuffer.toString());
                }
                TiebaApplication.this.a(TiebaApplication.this.C, "", TiebaApplication.this.E);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public void aN() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.D != null) {
            this.D.removeUpdates(this.aB);
        }
        if (this.z && this.A != null && this.A.isStarted()) {
            this.A.stop();
        }
        if (this.F != null) {
            this.F.cancel();
        }
    }

    public Address aO() {
        return this.E;
    }

    public void a(int i2, String str, Address address) {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.G != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.G.size()) {
                    bl blVar = this.G.get(i4).get();
                    if (blVar != null) {
                        blVar.a(i2, str, address);
                    }
                    i3 = i4 + 1;
                } else {
                    this.G.clear();
                    return;
                }
            }
        }
    }

    public void b(long j) {
        this.r = j;
        com.baidu.tieba.sharedPref.b.a().b("message_id", j);
    }

    public void a(int i2, int i3, String str) {
        if (this.H == null) {
            this.H = Executors.newSingleThreadExecutor();
        }
        com.baidu.adp.lib.g.e.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + " img_total" + i3);
        com.baidu.tieba.account.au auVar = new com.baidu.tieba.account.au(i2, i3);
        auVar.a(str);
        this.H.execute(auVar);
    }

    public boolean aP() {
        return this.aC;
    }

    public void x(boolean z) {
        this.aC = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aQ() {
        if (h().aP()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(h().G()).longValue() > 86400000;
        }
        return false;
    }

    public long aR() {
        return com.baidu.tieba.sharedPref.b.a().a("last_notify_sound_time", 0L);
    }

    public void c(long j) {
        com.baidu.tieba.sharedPref.b.a().b("last_notify_sound_time", j);
    }

    public void j(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_cd", i2);
    }

    public int aS() {
        return com.baidu.tieba.sharedPref.b.a().a("networkcore_type", 1);
    }

    public void k(int i2) {
        com.baidu.tieba.util.bg.a(i2);
        com.baidu.tieba.sharedPref.b.a().b("networkcore_type", i2);
    }

    public int aT() {
        return com.baidu.tieba.sharedPref.b.a().a("keepalive_wifi", 1);
    }

    public void l(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("keepalive_wifi", i2);
    }

    public int aU() {
        return com.baidu.tieba.sharedPref.b.a().a("keepalive_nonwifi", 1);
    }

    public void m(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("keepalive_nonwifi", i2);
    }

    public void s(String str) {
        com.baidu.tieba.sharedPref.b.a().b("socket_reconn_strategy", str);
    }

    public void t(String str) {
        com.baidu.tieba.sharedPref.b.a().b("socket_heartbeat_strategy", str);
    }

    public void u(String str) {
        com.baidu.tieba.sharedPref.b.a().b("socket_getmsg_strategy", str);
    }

    public void y(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("is_spring_egg", z);
    }

    public boolean aV() {
        return com.baidu.tieba.sharedPref.b.a().a("is_spring_egg", false);
    }

    public void a(int[] iArr) {
        if (iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i2 : iArr) {
                sb.append(i2);
                sb.append("|");
            }
            com.baidu.tieba.sharedPref.b.a().b("socket_time_out", sb.toString());
            com.baidu.tieba.im.net.f.a().a(iArr);
        }
    }

    public int[] aW() {
        String[] split;
        String a = com.baidu.tieba.sharedPref.b.a().a("socket_time_out", (String) null);
        if (a == null || (split = a.split("\\|")) == null || split.length != 3) {
            return null;
        }
        int[] iArr = new int[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            iArr[i2] = 0;
            try {
                iArr[i2] = Integer.valueOf(split[i2]).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.a(e.getMessage());
            }
        }
        return iArr;
    }

    public int[] aX() {
        int[] iArr = new int[0];
        try {
            String a = com.baidu.tieba.sharedPref.b.a().a("socket_reconn_strategy", "");
            if (a != null && !TextUtils.isEmpty(a)) {
                String[] split = a.split(",");
                iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.valueOf(split[i2]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public int[] aY() {
        int[] iArr = new int[0];
        try {
            String a = com.baidu.tieba.sharedPref.b.a().a("socket_heartbeat_strategy", "");
            if (a != null && !TextUtils.isEmpty(a)) {
                String[] split = a.split(",");
                iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.valueOf(split[i2]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public int[] aZ() {
        int[] iArr = new int[0];
        try {
            String a = com.baidu.tieba.sharedPref.b.a().a("socket_getmsg_strategy", "");
            if (a != null && !TextUtils.isEmpty(a)) {
                String[] split = a.split(",");
                iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.valueOf(split[i2]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public void n(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_max", i2);
    }

    public void o(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_rate", i2);
    }

    public void v(String str) {
        com.baidu.tieba.sharedPref.b.a().b("push_channel_id", str);
    }

    public String ba() {
        return com.baidu.tieba.sharedPref.b.a().a("push_channel_userId", "");
    }

    public void w(String str) {
        com.baidu.tieba.sharedPref.b.a().b("push_channel_userId", str);
    }

    public String bb() {
        return com.baidu.tieba.sharedPref.b.a().a("push_channel_id", "");
    }

    public void d(long j) {
        com.baidu.tieba.sharedPref.b.a().b("nearbygroup_date", j);
    }

    public long bc() {
        return com.baidu.tieba.sharedPref.b.a().a("nearbygroup_date", 0L);
    }

    public void e(long j) {
        com.baidu.tieba.sharedPref.b.a().b("banner_date", j);
    }

    public long bd() {
        return com.baidu.tieba.sharedPref.b.a().a("banner_date", 0L);
    }

    public void f(long j) {
        com.baidu.tieba.sharedPref.b.a().b("group_banner_date", j);
    }

    public long be() {
        return com.baidu.tieba.sharedPref.b.a().a("group_banner_date", 0L);
    }

    public void x(String str) {
        com.baidu.tieba.sharedPref.b.a().b("location_lat", str);
    }

    public String bf() {
        return com.baidu.tieba.sharedPref.b.a().a("location_lat", "");
    }

    public void y(String str) {
        com.baidu.tieba.sharedPref.b.a().b("location_lng", str);
    }

    public boolean bg() {
        return com.baidu.tieba.sharedPref.b.a().a("location_shared", false);
    }

    public void z(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("location_shared", z);
    }

    public String bh() {
        return com.baidu.tieba.sharedPref.b.a().a("location_lng", "");
    }

    public void z(String str) {
        com.baidu.tieba.sharedPref.b.a().b("location_pos", str);
    }

    public com.baidu.adp.lib.cache.s<String> bi() {
        if (this.U == null) {
            this.U = BdCacheService.c().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.U;
    }

    public void p(int i2) {
        int max = Math.max((int) (UtilHelper.a(h()) * 0.28f), i2);
        com.baidu.adp.lib.g.e.c("set pic cache size to :" + (max / LocationClientOption.MIN_SCAN_SPAN) + "KB. needed:" + (i2 / LocationClientOption.MIN_SCAN_SPAN) + "KB.");
        com.baidu.tbadk.imageManager.d.a().b(max);
    }

    public int bj() {
        return this.al;
    }

    public void q(int i2) {
        this.al = i2;
        com.baidu.tieba.sharedPref.b.a().b("faceshop_version", this.al);
    }

    public void r(int i2) {
        this.am = i2;
    }

    public boolean bk() {
        return this.V;
    }

    public int bl() {
        return this.am;
    }

    public boolean bm() {
        return this.an;
    }

    public void A(boolean z) {
        this.an = z;
    }

    public void a(PersonChangeData personChangeData) {
        this.ao = personChangeData;
    }

    public PersonChangeData bn() {
        return this.ao;
    }
}
