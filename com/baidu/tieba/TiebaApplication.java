package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.switchs.SwitchModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.ba;
import com.baidu.zeus.Headers;
import com.tencent.mm.sdk.platformtools.Util;
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
/* loaded from: classes.dex */
public class TiebaApplication extends com.baidu.adp.a.b {
    private static TiebaApplication e;
    private LocationManager C;
    private Boolean x;
    private static AccountData h = null;
    private static String m = null;
    private static boolean n = false;
    private static boolean Y = false;
    private static Intent Z = null;
    private static final byte[] aq = new byte[0];
    private static volatile Boolean ar = null;
    private int d = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.a.c>> f = null;
    private int g = 1;
    private boolean i = false;
    private com.baidu.tieba.util.ak j = null;
    private com.baidu.tieba.util.ak k = null;
    private String l = null;
    private String o = null;
    private int p = 0;
    private long q = 0;
    private long r = 0;
    private long s = -1;
    private String t = null;
    private VersionData u = null;
    private BannerData v = null;

    /* renamed from: a  reason: collision with root package name */
    public long f859a = 0;
    private Boolean w = false;
    private boolean y = true;
    private LocationClient z = null;
    private BDLocationListener A = null;
    private int B = 0;
    private Address D = null;
    private ao E = null;
    private ArrayList<SoftReference<an>> F = null;
    private ExecutorService G = null;
    private int H = 0;
    private int I = 0;
    private boolean J = true;
    private int K = 3;
    private int L = 1;
    private int M = 0;
    private boolean N = true;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = true;
    private com.baidu.adp.lib.cache.q<String> S = null;
    private int T = 0;
    private int U = 10;
    private int V = 0;
    private boolean W = false;
    private boolean X = true;
    public ArrayList<j> b = null;
    private Hashtable<String, Integer> aa = null;
    private Hashtable<String, Integer> ab = null;
    private Hashtable<String, Integer> ac = null;
    public Handler c = new Handler(new al(this));
    private int ad = 0;
    private boolean ae = true;
    private boolean af = true;
    private boolean ag = true;
    private boolean ah = true;
    private boolean ai = false;
    private boolean aj = true;
    private boolean ak = true;
    private boolean al = false;
    private String am = "23:00";
    private String an = "09:00";
    private final LocationListener ao = new am(this);
    private boolean ap = false;

    public void a(Boolean bool) {
        this.w = bool;
    }

    public Boolean d() {
        return this.w;
    }

    public static void a(Intent intent) {
        Z = intent;
    }

    public static Intent e() {
        return Z;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        e = this;
        new ap(null).execute(new String[0]);
        NetWorkCore.A();
        bd();
        if (q()) {
            com.baidu.tieba.sharedPref.b.a().b();
        }
        be();
        aZ();
        bc();
        ba.a(this);
        m = a((Context) this);
        ba();
        bb();
        com.baidu.tieba.data.g.d(this);
        com.baidu.tieba.data.g.b(this);
        com.baidu.tieba.data.g.c(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ax());
        } catch (SecurityException e2) {
            com.baidu.tieba.util.av.b(getClass().getName(), "onCreate", e2.getMessage());
        }
        if (q()) {
            if (aC()) {
                com.baidu.adp.lib.a.d.a().b();
            }
            com.baidu.tbadk.a.e.a().a(50, com.baidu.tieba.data.g.e());
            com.baidu.adp.lib.c.c.a().a(com.baidu.tieba.util.a.d.a());
            com.baidu.tbadk.a.a.a().a(this, new com.baidu.tieba.util.o());
            this.f = new HashMap<>();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                h = DatabaseService.n();
            }
            if (n()) {
                f.a(this);
            } else {
                com.baidu.tieba.account.a.a().b(this);
            }
            DatabaseService.v();
            m();
            this.j = new com.baidu.tieba.util.ak(300);
            this.k = new com.baidu.tieba.util.ak(100);
            com.baidu.tieba.mention.s.a().b();
            new com.baidu.tieba.account.ag("open").start();
            if (ao()) {
                new com.baidu.tieba.account.ag("frs_abstract", "1").start();
            }
            bj();
            this.F = new ArrayList<>();
            ah();
            new com.baidu.tieba.data.a.a().a();
            k();
            l();
        } else {
            this.b = new ArrayList<>();
        }
        try {
            registerReceiver(new com.baidu.tieba.service.e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e3) {
            com.baidu.adp.lib.f.d.a(e3.getMessage());
        }
        com.baidu.tieba.util.aw.a(this);
        TbImageView.setSkinMode(this.M);
    }

    public boolean f() {
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
        if (com.baidu.adp.lib.f.d.a()) {
            com.baidu.adp.lib.f.d.b("device:[" + trim + "], default GPU on:" + z);
        }
        return z;
    }

    public static TiebaApplication g() {
        return e;
    }

    public void a(String str) {
        this.o = str;
    }

    public String h() {
        return this.o;
    }

    public boolean b(String str) {
        return (this.ab == null || str == null || !this.ab.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.ab != null && str != null) {
            if (this.ab.size() > 100) {
                this.ab.clear();
            }
            this.ab.put(str, 1);
        }
    }

    public void i() {
        if (this.ab != null) {
            this.ab.clear();
        }
    }

    public int j() {
        if (this.ab != null) {
            return this.ab.size();
        }
        return 0;
    }

    public void k() {
        if (this.ab == null) {
            this.ab = new Hashtable<>();
        }
    }

    public int d(String str) {
        if (this.ac == null || str == null || !this.ac.containsKey(str)) {
            return 0;
        }
        return this.ac.get(str).intValue();
    }

    public void e(String str) {
        if (this.ac != null && str != null) {
            this.ac.put(str, 1);
            h(true);
            if (this.ac.size() > 200) {
                this.ac.clear();
            }
        }
    }

    public void f(String str) {
        if (this.ac != null && str != null) {
            this.ac.put(str, -1);
            h(true);
            if (this.ac.size() > 200) {
                this.ac.clear();
            }
        }
    }

    public void l() {
        if (this.ac == null) {
            this.ac = new Hashtable<>();
        }
    }

    public boolean g(String str) {
        return (this.aa == null || str == null || !this.aa.containsKey(str)) ? false : true;
    }

    public void h(String str) {
        if (!g(str) && this.aa != null && str != null) {
            this.aa.put(str, 1);
            new com.baidu.tieba.util.q(1, str).start();
        }
    }

    public void i(String str) {
        if (g(str) && this.aa != null && str != null) {
            this.aa.remove(str);
            new com.baidu.tieba.util.q(2, str).start();
        }
    }

    public void m() {
        this.aa = new Hashtable<>();
        new com.baidu.tieba.util.q(this.aa).start();
    }

    public void a(j jVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.b.get(i).a_();
                } catch (Exception e2) {
                    com.baidu.tieba.util.av.b(getClass().getName(), "addRemoteActivity", e2.getMessage());
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

    private void aZ() {
        if (Build.VERSION.SDK_INT >= 5) {
            n = new AccountProxy(this).hasBaiduAccount();
        } else {
            n = false;
        }
    }

    public static boolean n() {
        return n;
    }

    private void ba() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.l = telephonyManager.getDeviceId();
        }
    }

    private void bb() {
        if (this.t == null || this.t.length() < 0) {
            this.t = CommonParam.getCUID(this);
            com.baidu.tieba.sharedPref.b.a().b("cuid", this.t);
        }
    }

    public String o() {
        return this.t;
    }

    public String p() {
        return this.l;
    }

    public boolean q() {
        boolean z = false;
        if (this.x != null) {
            return this.x.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        int myPid = Process.myPid();
        if (runningAppProcesses != null) {
            this.x = Boolean.TRUE;
            int i = 0;
            while (true) {
                if (i >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i).pid != myPid) {
                    i++;
                } else {
                    String str = runningAppProcesses.get(i).processName;
                    if (str != null && (str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1") || str.equalsIgnoreCase("com.baidu.tieba:remote") || str.equalsIgnoreCase("com.baidu.tieba:bdservice_v1"))) {
                        this.x = Boolean.FALSE;
                    }
                }
            }
        }
        z = true;
        return z;
    }

    private void bc() {
        SwitchModel.initSwitchManager();
        this.H = com.baidu.tieba.sharedPref.b.a().a("image_quality", 0);
        this.I = com.baidu.tieba.sharedPref.b.a().a("view_image_quality", 0);
        this.J = com.baidu.tieba.sharedPref.b.a().a("show_images", true);
        this.K = com.baidu.tieba.sharedPref.b.a().a("font_size", 2);
        this.aj = com.baidu.tieba.sharedPref.b.a().a("permoted_message", true);
        this.g = com.baidu.tieba.sharedPref.b.a().a("new_display_photo", 1);
        this.L = com.baidu.tieba.sharedPref.b.a().a("new_abstract_state", 0);
        this.M = com.baidu.tieba.sharedPref.b.a().a("skin", 0);
        this.r = com.baidu.tieba.sharedPref.b.a().a("message_id", 0L);
        this.P = com.baidu.tieba.sharedPref.b.a().a("gpu_open", f());
        this.Q = com.baidu.tieba.sharedPref.b.a().a("app_switcher", false);
        this.W = com.baidu.tieba.sharedPref.b.a().a("manage_mode", false);
        this.N = com.baidu.tieba.sharedPref.b.a().a("location_on", true);
        this.O = com.baidu.tieba.sharedPref.b.a().a("open_local_popularize", false);
        this.T = com.baidu.tieba.sharedPref.b.a().a("webview_crash_count", 0);
        this.V = com.baidu.tieba.sharedPref.b.a().a("new_vcode_webview_crash_count", 0);
        this.y = com.baidu.tieba.sharedPref.b.a().a("bd_loc_switcher", true);
        this.X = com.baidu.tieba.sharedPref.b.a().a("search_mode", true);
        this.t = com.baidu.tieba.sharedPref.b.a().a("cuid", (String) null);
        this.U = com.baidu.tieba.sharedPref.b.a().a("perform_sample_count", 0);
        if (Build.VERSION.SDK_INT <= 4) {
            this.y = false;
        }
    }

    public void a(boolean z) {
        this.y = z;
        com.baidu.tieba.sharedPref.b.a().b("bd_loc_switcher", z);
    }

    public void b(boolean z) {
        this.X = z;
        com.baidu.tieba.sharedPref.b.a().b("search_mode", z);
    }

    public boolean r() {
        return this.X;
    }

    public boolean s() {
        return this.R;
    }

    public void c(boolean z) {
        this.R = z;
    }

    public boolean t() {
        return this.N;
    }

    public void d(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("gpu_open", z);
        this.P = z;
    }

    public boolean u() {
        return this.P;
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
        this.Q = z;
    }

    public boolean x() {
        return this.Q;
    }

    private void bd() {
        try {
            com.baidu.tieba.data.g.c(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            if (com.baidu.tieba.data.g.j() == null) {
                com.baidu.tieba.data.g.c("");
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.av.b(getClass().getName(), "InitVersion", e2.getMessage());
            com.baidu.tieba.data.g.c("");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void be() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String bf = bf();
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.tieba.data.g.b(readLine);
                    if (bf == null) {
                        String bg = bg();
                        if (bg != null && bg.length() > 0) {
                            com.baidu.tieba.data.g.a(bg);
                            t(bg);
                        } else if (readLine != null && readLine.length() > 0) {
                            com.baidu.tieba.data.g.a(readLine);
                            t(readLine);
                            u(readLine);
                        }
                    } else {
                        com.baidu.tieba.data.g.a(bf);
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.tieba.util.av.b(getClass().getName(), "InitFrom", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    com.baidu.tieba.util.av.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.g.a());
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        com.baidu.tieba.util.av.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.g.a());
    }

    private String bf() {
        return com.baidu.tieba.sharedPref.b.a().a("from_id", (String) null);
    }

    private void t(String str) {
        if (str != null && str.length() > 0 && q()) {
            com.baidu.tieba.sharedPref.b.a().b("from_id", str);
        }
    }

    private String bg() {
        String str = null;
        try {
            File c = com.baidu.tieba.util.p.c("from.dat");
            if (c != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(c));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.av.b(getClass().getName(), "getFromByFile", e2.getMessage());
        }
        return str;
    }

    private void u(String str) {
        if (str != null && str.length() > 0) {
            try {
                File e2 = com.baidu.tieba.util.p.e("from.dat");
                if (e2 != null) {
                    FileWriter fileWriter = new FileWriter(e2);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e3) {
                com.baidu.tieba.util.av.b(getClass().getName(), "saveFromToFile", e3.getMessage());
            }
        }
    }

    public static String y() {
        return com.baidu.tieba.data.g.a();
    }

    public void z() {
        com.baidu.tieba.mention.s.a().a(true);
        DatabaseService.v();
    }

    public com.baidu.adp.widget.a.c j(String str) {
        SoftReference<com.baidu.adp.widget.a.c> softReference = this.f.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.a.c a2 = com.baidu.tbadk.a.a.a().a(str);
        if (a2 != null) {
            this.f.put(str, new SoftReference<>(a2));
            return a2;
        }
        return a2;
    }

    public void a(int i) {
        this.g = i;
        com.baidu.tieba.sharedPref.b.a().b("new_display_photo", i);
    }

    public int A() {
        return this.g;
    }

    public boolean B() {
        if (this.g == 0) {
            if (com.baidu.tieba.util.au.a().c()) {
                return true;
            }
        } else if (this.g == 1) {
            return true;
        }
        return false;
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
        int b = com.baidu.tbadk.a.e.a().b();
        int max = (int) Math.max(b * 0.8d, com.baidu.tieba.data.g.e());
        if (max < b) {
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.a.e.a().b(max);
        }
    }

    public static String C() {
        if (h != null) {
            com.baidu.tieba.util.av.a("TiebaApplication", "getCurrentAccount", String.valueOf(h.getID()));
            return h.getID();
        }
        return null;
    }

    public static boolean D() {
        String C = C();
        return C != null && C.length() > 0;
    }

    public static void a(AccountData accountData, Context context) {
        boolean z = true;
        if ((accountData != null || h == null) && ((h != null || accountData == null) && (h == null || accountData == null || TextUtils.equals(h.getAccount(), accountData.getAccount())))) {
            z = false;
        }
        if (z) {
            com.baidu.tieba.mention.s.a().d();
        }
        h = accountData;
        if (g().w()) {
            UtilHelper.g(context);
        } else {
            UtilHelper.h(context);
        }
        if (accountData != null) {
            com.baidu.tieba.util.aw.a(accountData.getAccount(), accountData.getID());
        }
    }

    public static String E() {
        if (h != null) {
            return h.getBDUSS();
        }
        return null;
    }

    public static void k(String str) {
        if (h != null) {
            h.setBDUSS(str);
        }
    }

    public static AccountData F() {
        return h;
    }

    public static String G() {
        if (h != null) {
            return h.getAccount();
        }
        return null;
    }

    public int H() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("tdatabaseusetimes", 0);
        com.baidu.tieba.util.av.a("TiebaApplication", "getAPPUseTimes", String.valueOf(a2));
        return a2;
    }

    public void b(int i) {
        com.baidu.tieba.sharedPref.b.a().a("tdatabaseusetimes", i);
    }

    public long I() {
        long a2 = com.baidu.tieba.sharedPref.b.a().a("tdatabasecreatetime", 0L);
        com.baidu.tieba.util.av.a("TiebaApplication", "getTDatabaseCreateTime", com.baidu.tieba.util.at.a(a2));
        return a2;
    }

    public void a(long j) {
        com.baidu.tieba.sharedPref.b.a().b("update_notify_time", j);
    }

    public long J() {
        return com.baidu.tieba.sharedPref.b.a().a("update_notify_time", 0L);
    }

    public void l(String str) {
        com.baidu.tieba.sharedPref.b.a().b("install_other_app_file_name", str);
    }

    public String K() {
        return com.baidu.tieba.sharedPref.b.a().a("install_other_app_file_name", (String) null);
    }

    public void L() {
        com.baidu.tieba.sharedPref.b.a().b("tdatabasecreatetime", new Date().getTime());
    }

    public boolean M() {
        return H() > 50 && new Date().getTime() - I() > 2592000000L;
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public void m(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (h != null) {
                    h.setTbs(str);
                }
            }
        }
    }

    public String N() {
        if (h != null) {
            return h.getTbs();
        }
        return null;
    }

    public String a(Context context) {
        String str = null;
        String a2 = com.baidu.tieba.sharedPref.b.a().a("client_id", (String) null);
        if (a2 != null) {
            int indexOf = a2.indexOf("\t");
            if (indexOf != -1) {
                if (com.baidu.tieba.data.g.j().equals(a2.substring(0, indexOf))) {
                    str = a2.substring(indexOf + 1);
                } else {
                    b((Context) g());
                }
            } else {
                b((Context) g());
            }
        } else {
            str = a2;
        }
        com.baidu.tieba.util.av.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String O() {
        return m;
    }

    public void b(Context context) {
        com.baidu.tieba.sharedPref.b.a().a("client_id");
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tieba.sharedPref.b.a().b("client_id", String.valueOf(com.baidu.tieba.data.g.j()) + "\t" + str);
        }
    }

    public static void n(String str) {
        m = str;
    }

    public void h(boolean z) {
        this.i = z;
    }

    public boolean P() {
        return this.i;
    }

    public int Q() {
        return this.ad;
    }

    public void R() {
        d(300);
        m(true);
        o(true);
        n(true);
        p(true);
        k(false);
        o("23:00");
        p("09:00");
    }

    public void i(boolean z) {
        this.aj = z;
        com.baidu.tieba.sharedPref.b.a().b("permoted_message", z);
    }

    public boolean S() {
        return this.aj;
    }

    public void j(boolean z) {
        if (this.ah != z) {
            this.ah = z;
        }
    }

    public boolean T() {
        return this.al;
    }

    public void k(boolean z) {
        this.al = z;
    }

    public String U() {
        return this.am;
    }

    public void o(String str) {
        this.am = str;
    }

    public String V() {
        return this.an;
    }

    public void p(String str) {
        this.an = str;
    }

    public boolean W() {
        return this.ah;
    }

    public void l(boolean z) {
        this.ai = z;
    }

    public boolean X() {
        return this.ai;
    }

    public int Y() {
        if (!this.ah && !this.ai) {
            return 0;
        }
        if (this.ah && !this.ai) {
            return 1;
        }
        if (!this.ah && this.ai) {
            return 2;
        }
        return 3;
    }

    public void c(int i) {
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
    public void d(int i) {
        com.baidu.tieba.util.av.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i).toString());
        if (i == 0) {
            this.ad = i;
            com.baidu.tieba.mention.s.a().a(true);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.ad = 300;
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean Z() {
        return this.ae;
    }

    public void m(boolean z) {
        this.ae = z;
        if (!z) {
            com.baidu.tieba.mention.s.a().c(0L);
        }
    }

    public boolean aa() {
        return this.af;
    }

    public void n(boolean z) {
        this.af = z;
        if (!z) {
            com.baidu.tieba.mention.s.a().b(0L);
        }
    }

    public boolean ab() {
        return this.ag;
    }

    public void o(boolean z) {
        this.ag = z;
        if (!z) {
            com.baidu.tieba.mention.s.a().a(0L);
        }
    }

    public boolean ac() {
        return this.ak;
    }

    public void p(boolean z) {
        this.ak = z;
        if (!z) {
            com.baidu.tieba.mention.s.a().d(0L);
        }
    }

    public boolean ad() {
        return this.ad > 0;
    }

    public boolean ae() {
        return com.baidu.tieba.sharedPref.b.a().a("alert_sign_on", false);
    }

    public void q(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_on", z);
        ah();
    }

    public int af() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("alert_sign_hours", -1);
        if (a2 == -1) {
            bh();
            return com.baidu.tieba.sharedPref.b.a().a("alert_sign_hours", 12);
        }
        return a2;
    }

    private void bh() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int ag() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("alert_sign_mins", -1);
        if (a2 == -1) {
            bh();
            return com.baidu.tieba.sharedPref.b.a().a("alert_sign_mins", 30);
        }
        return a2;
    }

    public void a(int i, int i2) {
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_hours", i);
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_mins", i2);
        ah();
    }

    public void ah() {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent ai = ai();
        if (ae()) {
            Calendar calendar = Calendar.getInstance();
            int af = af();
            int i = calendar.get(11);
            int ag = ag();
            int i2 = calendar.get(12);
            calendar.set(11, af);
            calendar.set(12, ag);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= af && (i != af || i2 >= ag)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this, 0, ai, 268435456));
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.c("sign-alert alarm set to :" + com.baidu.tieba.util.at.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, ai, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.c("sign-alert alarm cancelled.");
            }
        }
    }

    protected Intent ai() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.signalert");
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(this, SignAlertReceiver.class);
        return intent;
    }

    public int aj() {
        return this.H;
    }

    public int ak() {
        return this.I;
    }

    public void e(int i) {
        if (this.H != i) {
            this.H = i;
            com.baidu.tieba.sharedPref.b.a().b("image_quality", i);
        }
    }

    public void f(int i) {
        if (this.I != i) {
            this.I = i;
            com.baidu.tieba.sharedPref.b.a().b("view_image_quality", i);
        }
    }

    public boolean al() {
        return this.J;
    }

    public void r(boolean z) {
        if (this.J != z) {
            this.J = z;
            com.baidu.tieba.sharedPref.b.a().b("show_images", z);
        }
    }

    public int am() {
        return this.K;
    }

    public void g(int i) {
        if (this.K != i) {
            this.K = i;
            com.baidu.tieba.sharedPref.b.a().b("font_size", i);
        }
    }

    public void h(int i) {
        this.L = i;
        com.baidu.tieba.sharedPref.b.a().b("new_abstract_state", i);
    }

    public int an() {
        return this.L;
    }

    public boolean ao() {
        if (this.L == 0) {
            if (com.baidu.tieba.util.au.a().c()) {
                return true;
            }
        } else if (this.L == 1) {
            return true;
        }
        return false;
    }

    public void s(boolean z) {
        this.O = z;
        com.baidu.tieba.sharedPref.b.a().b("open_local_popularize", z);
    }

    public void i(int i) {
        AppsActivity.b();
        j(i);
        com.baidu.tieba.sharedPref.b.a().b("skin", i);
        TbImageView.setSkinMode(i);
        t(i);
    }

    public void j(int i) {
        this.M = i;
    }

    private void t(int i) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i);
        sendBroadcast(intent);
    }

    public int ap() {
        return this.M;
    }

    public int aq() {
        return this.T;
    }

    public void k(int i) {
        this.T = i;
        com.baidu.tieba.sharedPref.b.a().b("webview_crash_count", i);
    }

    public int ar() {
        return this.U;
    }

    public void l(int i) {
        this.U = i;
        com.baidu.tieba.sharedPref.b.a().b("perform_sample_count", i);
    }

    public int as() {
        return this.V;
    }

    public void m(int i) {
        this.V = i;
        com.baidu.tieba.sharedPref.b.a().a("new_vcode_webview_crash_count", i);
    }

    public void at() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("bd_loc_crash_count", 0) + 1;
        com.baidu.tieba.sharedPref.b.a().b("bd_loc_crash_count", a2);
        if (a2 > 3) {
            a(false);
        }
    }

    public VersionData au() {
        return this.u;
    }

    public void a(VersionData versionData) {
        this.u = versionData;
    }

    public static boolean av() {
        return Y;
    }

    public static void t(boolean z) {
        Y = z;
    }

    public com.baidu.tieba.util.ak aw() {
        return this.j;
    }

    public void ax() {
        this.s = System.currentTimeMillis();
    }

    public void ay() {
        this.s = -1L;
    }

    public void az() {
        if (this.s > 0) {
            this.s = System.currentTimeMillis() - this.s;
            if (this.s > 0) {
                new com.baidu.tieba.account.ag("startup_time", String.valueOf(this.s));
                com.baidu.tieba.util.aw.a("op_launch", this.s, 0L);
            }
            com.baidu.tieba.util.av.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.s));
        }
        this.s = -1L;
    }

    public void aA() {
        this.p++;
        bi();
    }

    public void aB() {
        this.p--;
        bi();
    }

    private void bi() {
        if (q()) {
            if (this.p < 0) {
                this.p = 0;
            }
            if (this.q == 0 && this.p > 0) {
                this.q = System.nanoTime();
            }
            com.baidu.tieba.util.av.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.p));
            this.c.removeMessages(4);
            if (this.p == 0 && this.q > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), Util.MILLSECONDS_OF_MINUTE);
            }
        }
    }

    public boolean aC() {
        String a2 = com.baidu.tieba.sharedPref.b.a().a("lase_version", "");
        if (a2.equals(com.baidu.tieba.data.g.j())) {
            return false;
        }
        q(a2);
        return true;
    }

    public void aD() {
        com.baidu.tieba.sharedPref.b.a().b("lase_version", com.baidu.tieba.data.g.j());
    }

    public void q(String str) {
        com.baidu.tieba.sharedPref.b.a().b("active_version", str);
    }

    public String aE() {
        String a2 = com.baidu.tieba.sharedPref.b.a().a("active_version", "");
        if ("active_clear".equals(a2)) {
            return null;
        }
        return a2;
    }

    public void aF() {
        q("active_clear");
    }

    public void aG() {
        com.baidu.tieba.sharedPref.b.a().a("account_share");
    }

    public String aH() {
        return com.baidu.tieba.sharedPref.b.a().a("account_share", (String) null);
    }

    public void r(String str) {
        com.baidu.tieba.sharedPref.b.a().b("account_share", str);
    }

    private void bj() {
        try {
            this.C = (LocationManager) getSystemService(Headers.LOCATION);
            if (this.y) {
                this.A = new MyBDLocationListenner();
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName("tieba");
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(BdWebErrorView.ERROR_CODE_500);
                locationClientOption.disableCache(true);
                this.z = new LocationClient(getApplicationContext());
                this.z.registerLocationListener(this.A);
                this.z.setLocOption(locationClientOption);
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.av.b(getClass().getName(), "initLocationServer", e2.toString());
        }
    }

    public void aI() {
        try {
            if (this.D == null || System.currentTimeMillis() - this.f859a > 300000) {
                this.D = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.C != null) {
                    this.C.removeUpdates(this.ao);
                }
                if (this.y) {
                    if (!this.z.isStarted()) {
                        this.z.start();
                    }
                    this.z.requestLocation();
                }
                this.B = 4;
                if (this.C != null && !this.C.isProviderEnabled("gps") && !this.C.isProviderEnabled("network")) {
                    this.B = 3;
                    if (!this.y) {
                        this.c.sendMessageDelayed(this.c.obtainMessage(5), 100L);
                        return;
                    }
                }
                if (this.C != null && this.C.isProviderEnabled("gps")) {
                    v("gps");
                } else {
                    this.B = 1;
                }
                if (this.C != null && this.C.isProviderEnabled("network")) {
                    v("network");
                } else {
                    this.B = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), Util.MILLSECONDS_OF_MINUTE);
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.av.b(getClass().getName(), "startLocationServer", e2.toString());
        }
    }

    private void v(String str) {
        if (this.C.isProviderEnabled(str)) {
            this.C.requestLocationUpdates(str, 10000L, 100.0f, this.ao);
        }
    }

    /* loaded from: classes.dex */
    public class MyBDLocationListenner implements BDLocationListener {
        public MyBDLocationListenner() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                TiebaApplication.this.B = 0;
                TiebaApplication.this.aJ();
                TiebaApplication.this.D = new Address(Locale.getDefault());
                TiebaApplication.this.D.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.D.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.f859a = System.currentTimeMillis();
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
                    TiebaApplication.this.D.setAddressLine(0, stringBuffer.toString());
                }
                TiebaApplication.this.a(TiebaApplication.this.B, "", TiebaApplication.this.D);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public void aJ() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.C != null) {
            this.C.removeUpdates(this.ao);
        }
        if (this.y && this.z != null && this.z.isStarted()) {
            this.z.stop();
        }
        if (this.E != null) {
            this.E.cancel();
        }
    }

    public Address aK() {
        return this.D;
    }

    public Address a(an anVar) {
        boolean z;
        if (this.D != null && System.currentTimeMillis() - this.f859a <= 300000) {
            return this.D;
        }
        if (anVar != null) {
            int i = 0;
            while (true) {
                if (i < this.F.size()) {
                    an anVar2 = this.F.get(i).get();
                    if (anVar2 == null || !anVar2.equals(anVar)) {
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                if (this.F.size() > 10) {
                    this.F.remove(0);
                }
                this.F.add(new SoftReference<>(anVar));
            }
            aI();
        }
        return null;
    }

    public void a(int i, String str, Address address) {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.F != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.F.size()) {
                    an anVar = this.F.get(i3).get();
                    if (anVar != null) {
                        anVar.a(i, str, address);
                    }
                    i2 = i3 + 1;
                } else {
                    this.F.clear();
                    return;
                }
            }
        }
    }

    public void b(long j) {
        this.r = j;
        com.baidu.tieba.sharedPref.b.a().b("message_id", j);
    }

    public void a(int i, int i2, String str) {
        if (this.G == null) {
            this.G = Executors.newSingleThreadExecutor();
        }
        com.baidu.tieba.util.av.a(getClass().getName(), "pv_addImagePv", "img_num=" + i + " img_total" + i2);
        com.baidu.tieba.account.af afVar = new com.baidu.tieba.account.af(i, i2);
        afVar.a(str);
        this.G.execute(afVar);
    }

    public boolean aL() {
        return this.ap;
    }

    public void u(boolean z) {
        this.ap = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aM() {
        if (g().aL()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(g().J()).longValue() > Util.MILLSECONDS_OF_DAY;
        }
        return false;
    }

    public static boolean aN() {
        synchronized (aq) {
            while (ar == null) {
                try {
                    aq.wait();
                } catch (Exception e2) {
                    com.baidu.adp.lib.f.d.a(e2.getMessage());
                }
            }
            if (ar != null) {
                return ar.booleanValue();
            }
            return false;
        }
    }

    public boolean aO() {
        return com.baidu.tieba.sharedPref.b.a().a("is_pk_offline", false);
    }

    public long aP() {
        return com.baidu.tieba.sharedPref.b.a().a("last_notify_sound_time", 0L);
    }

    public void c(long j) {
        com.baidu.tieba.sharedPref.b.a().b("last_notify_sound_time", j);
    }

    public int aQ() {
        return com.baidu.tieba.sharedPref.b.a().a("kn_vote_cd", 600);
    }

    public void n(int i) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_cd", i);
    }

    public int aR() {
        return com.baidu.tieba.sharedPref.b.a().a("networkcore_type", 1);
    }

    public void o(int i) {
        com.baidu.tieba.sharedPref.b.a().b("networkcore_type", i);
    }

    public int aS() {
        return com.baidu.tieba.sharedPref.b.a().a("keepalive_wifi", 1);
    }

    public void p(int i) {
        com.baidu.tieba.sharedPref.b.a().b("keepalive_wifi", i);
    }

    public int aT() {
        return com.baidu.tieba.sharedPref.b.a().a("keepalive_nonwifi", 1);
    }

    public void q(int i) {
        com.baidu.tieba.sharedPref.b.a().b("keepalive_nonwifi", i);
    }

    public int aU() {
        return com.baidu.tieba.sharedPref.b.a().a("kn_vote_max", 10);
    }

    public void r(int i) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_max", i);
    }

    public int aV() {
        return com.baidu.tieba.sharedPref.b.a().a("kn_vote_rate", 10);
    }

    public void s(int i) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_rate", i);
    }

    public void s(String str) {
        com.baidu.tieba.sharedPref.b.a().b("push_channel_id", str);
    }

    public String aW() {
        return com.baidu.tieba.sharedPref.b.a().a("push_channel_id", "");
    }

    public com.baidu.adp.lib.cache.q<String> aX() {
        if (this.S == null) {
            this.S = BdCacheService.c().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.S;
    }
}
