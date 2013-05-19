package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.baidu.account.AccountProxy;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.a.bf;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.service.MessagePullService;
import com.baidu.tieba.service.TiebaMessageService;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class TiebaApplication extends com.baidu.adp.a.b {
    private static TiebaApplication f;
    private LocationManager E;
    private static com.baidu.tieba.a.a i = null;
    private static String n = null;
    private static boolean o = false;
    private static boolean ae = false;
    private static Intent af = null;
    private static String au = "79A74DC064B49770ED928E44E679A79E86AD9B9A";
    private int e = 0;
    private HashMap g = null;
    private boolean h = true;
    private boolean j = false;
    private com.baidu.tieba.d.ab k = null;
    private com.baidu.tieba.d.ab l = null;
    private String m = null;
    private boolean p = false;
    private String q = null;
    private int r = 0;
    private long s = 0;
    private long t = 0;
    private long u = -1;
    private String v = null;
    private String w = null;
    private bf x = null;
    private com.baidu.tieba.a.c y = null;
    public long a = 0;
    private int z = -1;
    private boolean A = true;
    private com.baidu.location.e B = null;
    private com.baidu.location.c C = null;
    private int D = 0;
    private Address F = null;
    private ap G = null;
    private ArrayList H = null;
    private ExecutorService I = null;
    private int J = 2;
    private int K = 1;
    private boolean L = true;
    private int M = 3;
    private boolean N = true;
    private int O = 0;
    private boolean P = true;
    private boolean Q = true;
    private boolean R = true;
    private boolean S = false;
    private int T = 2;
    private boolean U = true;
    private int V = 0;
    private int W = 10;
    private int X = 0;
    private boolean Y = false;
    private boolean Z = true;
    private int aa = 0;
    private long ab = 0;
    private long ac = 0;
    private long ad = 0;
    public ArrayList b = null;
    private Hashtable ag = null;
    public Handler c = new Handler(new aj(this));
    private int ah = 0;
    private boolean ai = true;
    private boolean aj = true;
    private boolean ak = true;
    private boolean al = true;
    private boolean am = false;
    private boolean an = true;
    private long ao = 0;
    private long ap = 0;
    private long aq = 0;
    NotificationManager d = null;
    private final LocationListener ar = new ak(this);
    private boolean as = false;
    private BMapManager at = null;
    private boolean av = false;

    public static void a(Intent intent) {
        af = intent;
    }

    public static Intent c() {
        return af;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        f = this;
        com.baidu.tieba.a.i.q();
        com.baidu.tieba.d.w.e();
        aO();
        aP();
        aJ();
        aN();
        n = a((Context) this);
        aK();
        aL();
        com.baidu.tieba.a.i.d(this);
        com.baidu.tieba.a.i.b(this);
        com.baidu.tieba.a.i.c(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.d.af());
        } catch (SecurityException e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "onCreate", e.getMessage());
        }
        getContentResolver().registerContentObserver(Uri.parse("content://telephony/carriers"), true, new al(this, new Handler()));
        this.p = aM();
        if (this.p) {
            com.baidu.tbadk.a.d.a().a(50, com.baidu.tieba.a.i.d());
            com.baidu.tbadk.a.a.a().a(this, new com.baidu.tieba.d.n());
            aD();
            this.g = new HashMap();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                i = com.baidu.tieba.d.k.m();
            }
            if (i()) {
                a.a(this);
            } else {
                com.baidu.tieba.account.a.a().a(this);
            }
            com.baidu.tieba.d.k.u();
            f();
            this.k = new com.baidu.tieba.d.ab(MKEvent.ERROR_PERMISSION_DENIED);
            this.l = new com.baidu.tieba.d.ab(100);
            this.d = (NotificationManager) getSystemService("notification");
            new com.baidu.tieba.account.af("open").start();
            if (P()) {
                g();
            }
            if (ah()) {
                new com.baidu.tieba.account.af("frs_abstract", "1").start();
            }
            aU();
            this.H = new ArrayList();
        } else {
            this.b = new ArrayList();
        }
        registerReceiver(new com.baidu.tieba.service.g(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        super.onCreate();
    }

    public static TiebaApplication d() {
        return f;
    }

    public void a(String str) {
        this.q = str;
    }

    public String e() {
        return this.q;
    }

    public boolean b(String str) {
        return (this.ag == null || str == null || !this.ag.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.ag != null && str != null) {
            this.ag.put(str, 1);
            new com.baidu.tieba.d.p(1, str).start();
        }
    }

    public void d(String str) {
        if (b(str) && this.ag != null && str != null) {
            this.ag.remove(str);
            new com.baidu.tieba.d.p(2, str).start();
        }
    }

    public void f() {
        this.ag = new Hashtable();
        new com.baidu.tieba.d.p(this.ag).start();
    }

    public void g() {
        startService(new Intent(this, MessagePullService.class));
    }

    public void h() {
        stopService(new Intent(this, MessagePullService.class));
    }

    public void a(e eVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ((e) this.b.get(i2)).a_();
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b(getClass().getName(), "addRemoteActivity", e.getMessage());
                }
            }
            if (eVar != null) {
                this.b.add(eVar);
            }
        }
    }

    public void b(e eVar) {
        if (this.b != null) {
            this.b.remove(eVar);
        }
    }

    private void aJ() {
        if (Build.VERSION.SDK_INT >= 5) {
            o = new AccountProxy(this).hasBaiduAccount();
        } else {
            o = false;
        }
    }

    public static boolean i() {
        return o;
    }

    private void aK() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.m = telephonyManager.getDeviceId();
        }
    }

    private void aL() {
        if (this.w == null || this.w.length() < 0) {
            this.w = CommonParam.getCUID(this);
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("cuid", this.w);
            edit.commit();
        }
    }

    public String j() {
        return this.w;
    }

    public String k() {
        return this.m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r0.equalsIgnoreCase("com.baidu.tieba:remote") != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean aM() {
        boolean z = false;
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        int myPid = Process.myPid();
        if (runningAppProcesses != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i2).pid != myPid) {
                    i2++;
                } else {
                    String str = runningAppProcesses.get(i2).processName;
                    if (str != null) {
                        if (!str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1")) {
                        }
                    }
                }
            }
        }
        z = true;
        return z;
    }

    private void aN() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
        this.J = sharedPreferences.getInt("image_quality", 2);
        this.K = sharedPreferences.getInt("view_image_quality", 2);
        this.L = sharedPreferences.getBoolean("show_images", true);
        this.M = sharedPreferences.getInt("font_size", 2);
        this.an = sharedPreferences.getBoolean("permoted_message", true);
        this.h = sharedPreferences.getBoolean("display_photo", true);
        this.N = sharedPreferences.getBoolean("abstract_state", true);
        this.O = sharedPreferences.getInt("skin", 0);
        this.t = sharedPreferences.getLong("message_id", 0L);
        this.R = sharedPreferences.getBoolean("gpu_open", true);
        this.Q = sharedPreferences.getBoolean("motu_on", true);
        this.S = sharedPreferences.getBoolean("app_switcher", false);
        this.T = sharedPreferences.getInt("browser_type", 2);
        this.Y = sharedPreferences.getBoolean("manage_mode", false);
        this.P = sharedPreferences.getBoolean("location_on", true);
        this.ab = sharedPreferences.getLong("refresh_recommend_time", 0L);
        this.ac = sharedPreferences.getLong("refresh_guess_time", 0L);
        this.aa = sharedPreferences.getInt("guide_page_bits", 0);
        this.v = sharedPreferences.getString("show_all_like_items", null);
        this.V = sharedPreferences.getInt("webview_crash_count", 0);
        this.X = sharedPreferences.getInt("new_vcode_webview_crash_count", 0);
        this.A = sharedPreferences.getBoolean("bd_loc_switcher", true);
        this.Z = sharedPreferences.getBoolean("search_mode", true);
        this.ad = sharedPreferences.getLong("show_nearby_guide_time", 0L);
        this.w = sharedPreferences.getString("cuid", null);
        this.W = sharedPreferences.getInt("perform_sample_count", 0);
        if (Build.VERSION.SDK_INT <= 4) {
            this.A = false;
        }
    }

    public int l() {
        return this.T;
    }

    public void a(int i2) {
        if (this.T != i2) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putInt("browser_type", i2);
            edit.commit();
            this.T = i2;
        }
    }

    public void a(boolean z) {
        this.A = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("bd_loc_switcher", this.A);
        edit.commit();
    }

    public void b(boolean z) {
        this.Z = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("search_mode", this.Z);
        edit.commit();
    }

    public boolean m() {
        return this.Z;
    }

    public boolean n() {
        return this.U;
    }

    public void c(boolean z) {
        this.U = z;
    }

    public boolean o() {
        return this.P;
    }

    public void d(boolean z) {
        this.P = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("location_on", this.P);
        edit.commit();
    }

    public void e(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("motu_on", z);
        edit.commit();
        this.Q = z;
    }

    public boolean p() {
        return this.Q;
    }

    public void f(boolean z) {
        if (this.R != z) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putBoolean("gpu_open", z);
            edit.commit();
            this.R = z;
        }
    }

    public boolean q() {
        return this.R;
    }

    public void g(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.S = z;
    }

    public boolean r() {
        return this.S;
    }

    public void s() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("show_all_like_items", com.baidu.tieba.a.i.h());
        edit.commit();
        this.v = com.baidu.tieba.a.i.h();
    }

    public String t() {
        return this.v;
    }

    private void aO() {
        try {
            com.baidu.tieba.a.i.b(getPackageManager().getPackageInfo("com.baidu.tieba", 16384).versionName);
            if (com.baidu.tieba.a.i.h() == null) {
                com.baidu.tieba.a.i.b("");
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "InitVersion", e.getMessage());
            com.baidu.tieba.a.i.b("");
        }
    }

    private void aP() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String aQ = aQ();
                if (aQ == null) {
                    String aR = aR();
                    if (aR != null && aR.length() > 0) {
                        com.baidu.tieba.a.i.a(aR);
                        k(aR);
                        bufferedReader = null;
                    } else {
                        bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && readLine.length() > 0) {
                                com.baidu.tieba.a.i.a(readLine);
                                k(readLine);
                                l(readLine);
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            com.baidu.tieba.d.ae.b(getClass().getName(), "InitFrom", e.getMessage());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            com.baidu.tieba.d.ae.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.i.a());
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } else {
                    com.baidu.tieba.a.i.a(aQ);
                    bufferedReader = null;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
        com.baidu.tieba.d.ae.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.i.a());
    }

    private String aQ() {
        return getSharedPreferences("settings", 0).getString("from_id", null);
    }

    private void k(String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("from_id", str);
            edit.commit();
        }
    }

    private String aR() {
        String str = null;
        try {
            File c = com.baidu.tieba.d.o.c("from.dat");
            if (c != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(c));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "getFromByFile", e.getMessage());
        }
        return str;
    }

    private void l(String str) {
        if (str != null && str.length() > 0) {
            try {
                File e = com.baidu.tieba.d.o.e("from.dat");
                if (e != null) {
                    FileWriter fileWriter = new FileWriter(e);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e2) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "saveFromToFile", e2.getMessage());
            }
        }
    }

    public static String u() {
        return com.baidu.tieba.a.i.a();
    }

    public void v() {
        a(0L, 0L, 0L);
        com.baidu.tieba.d.k.u();
    }

    public Bitmap e(String str) {
        SoftReference softReference = (SoftReference) this.g.get(str);
        if (softReference != null && softReference.get() != null) {
            return (Bitmap) softReference.get();
        }
        Bitmap a = com.baidu.tbadk.a.a.a().a(str);
        if (a != null) {
            this.g.put(str, new SoftReference(a));
            return a;
        }
        return a;
    }

    public void a(Boolean bool) {
        this.h = bool.booleanValue();
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("display_photo", bool.booleanValue());
        edit.commit();
    }

    public boolean w() {
        return this.h;
    }

    public void a(long j) {
        this.ad = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("show_nearby_guide_time", j);
        edit.commit();
    }

    public long x() {
        return this.ad;
    }

    public void b(long j) {
        this.ab = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public long y() {
        return this.ab;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    public static String z() {
        if (i != null) {
            com.baidu.tieba.d.ae.a("TiebaApplication", "getCurrentAccount", String.valueOf(i.a()));
            return i.a();
        }
        return null;
    }

    public static void a(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public static String A() {
        if (i != null) {
            return i.d();
        }
        return null;
    }

    public static String B() {
        if (i != null) {
            return i.f();
        }
        return null;
    }

    public static void f(String str) {
        if (i != null) {
            i.d(str);
        }
    }

    public static com.baidu.tieba.a.a C() {
        return i;
    }

    public static String D() {
        if (i != null) {
            return i.b();
        }
        return null;
    }

    public static void b(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public int E() {
        int i2 = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        com.baidu.tieba.d.ae.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i2));
        return i2;
    }

    public void b(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i2);
        edit.commit();
    }

    public long F() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        com.baidu.tieba.d.ae.a("TiebaApplication", "getTDatabaseCreateTime", com.baidu.tieba.d.ad.a(j));
        return j;
    }

    public void c(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("update_notify_time", j);
        edit.commit();
    }

    public long G() {
        return getSharedPreferences("settings", 0).getLong("update_notify_time", 0L);
    }

    public void g(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("update_dialog_version", str);
        edit.commit();
    }

    public String H() {
        return getSharedPreferences("settings", 0).getString("update_dialog_version", null);
    }

    public void I() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("tdatabasecreatetime", new Date().getTime());
        edit.commit();
    }

    public boolean J() {
        return E() > 50 && new Date().getTime() - F() > 2592000000L;
    }

    @Override // android.app.Application
    public void onTerminate() {
        if (this.at != null) {
            this.at.destroy();
            this.at = null;
        }
        super.onTerminate();
    }

    public void h(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (i != null) {
                    i.e(str);
                }
            }
        }
    }

    public String K() {
        if (i != null) {
            return i.f();
        }
        return null;
    }

    public static String a(Context context) {
        String str = null;
        String string = context.getSharedPreferences("settings", 0).getString("client_id", null);
        if (string != null) {
            int indexOf = string.indexOf("\t");
            if (indexOf != -1) {
                if (com.baidu.tieba.a.i.h().equals(string.substring(0, indexOf))) {
                    str = string.substring(indexOf + 1);
                } else {
                    b((Context) d());
                }
            } else {
                b((Context) d());
            }
        } else {
            str = string;
        }
        com.baidu.tieba.d.ae.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String L() {
        return n;
    }

    public static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("settings", 0).edit();
        edit.remove("client_id");
        edit.commit();
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences("settings", 0).edit();
            edit.putString("client_id", String.valueOf(com.baidu.tieba.a.i.h()) + "\t" + str);
            edit.commit();
        }
    }

    public static void i(String str) {
        n = str;
    }

    public void h(boolean z) {
        this.j = z;
    }

    public boolean M() {
        return this.j;
    }

    public int N() {
        return this.ah;
    }

    public void O() {
        d(MKEvent.ERROR_PERMISSION_DENIED);
        l(true);
        n(true);
        m(true);
    }

    public void i(boolean z) {
        this.an = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            g();
        } else {
            h();
        }
    }

    public boolean P() {
        return this.an;
    }

    public void j(boolean z) {
        if (this.al != z) {
            this.al = z;
        }
    }

    public boolean Q() {
        return this.al;
    }

    public void k(boolean z) {
        this.am = z;
    }

    public boolean R() {
        return this.am;
    }

    public int S() {
        if (!this.al && !this.am) {
            return 0;
        }
        if (this.al && !this.am) {
            return 1;
        }
        if (!this.al && this.am) {
            return 2;
        }
        return 3;
    }

    public void c(int i2) {
        if (i2 == 0) {
            d().j(false);
            d().k(false);
        } else if (i2 == 1) {
            d().j(true);
            d().k(false);
        } else if (i2 == 2) {
            d().j(false);
            d().k(true);
        } else {
            d().j(true);
            d().k(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 int)] */
    public void d(int i2) {
        com.baidu.tieba.d.ae.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i2).toString());
        this.ah = i2;
        if (i2 == 0) {
            a(0L, 0L, 0L);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean T() {
        return this.ai;
    }

    public void l(boolean z) {
        this.ai = z;
        if (!z) {
            f(0L);
        }
    }

    public boolean U() {
        return this.aj;
    }

    public void m(boolean z) {
        this.aj = z;
        if (!z) {
            e(0L);
        }
    }

    public boolean V() {
        return this.ak;
    }

    public void n(boolean z) {
        this.ak = z;
        if (!z) {
            d(0L);
        }
    }

    public boolean W() {
        return this.ah > 0 && (this.ak || this.aj || this.ai);
    }

    public void X() {
        if (d().W()) {
            startService(new Intent(this, TiebaMessageService.class));
        }
    }

    public void Y() {
        stopService(new Intent(this, TiebaMessageService.class));
    }

    public long Z() {
        return this.ao;
    }

    public void d(long j) {
        if (j >= 0) {
            a(j, this.ap, this.aq);
        }
    }

    public long aa() {
        return this.ap;
    }

    public void e(long j) {
        if (j >= 0) {
            a(this.ao, j, this.aq);
        }
    }

    public long ab() {
        return this.aq;
    }

    public void f(long j) {
        if (j >= 0) {
            a(this.ao, this.ap, j);
        }
    }

    public void ac() {
        this.ao = 0L;
        this.ap = 0L;
        this.aq = 0L;
    }

    public int ad() {
        return this.J;
    }

    public int ae() {
        return this.K;
    }

    public void e(int i2) {
        if (this.J != i2) {
            this.J = i2;
            getSharedPreferences("settings", 0).edit().putInt("image_quality", i2).commit();
        }
    }

    public void f(int i2) {
        if (this.K != i2) {
            this.K = i2;
            getSharedPreferences("settings", 0).edit().putInt("view_image_quality", i2).commit();
        }
    }

    public boolean af() {
        return this.L;
    }

    public void o(boolean z) {
        if (this.L != z) {
            this.L = z;
            getSharedPreferences("settings", 0).edit().putBoolean("show_images", z).commit();
        }
    }

    public int ag() {
        return this.M;
    }

    public void g(int i2) {
        if (this.M != i2) {
            this.M = i2;
            getSharedPreferences("settings", 0).edit().putInt("font_size", i2).commit();
        }
    }

    public void p(boolean z) {
        this.N = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    public boolean ah() {
        return this.N;
    }

    public void h(int i2) {
        AppsActivity.b();
        i(i2);
        getSharedPreferences("settings", 0).edit().putInt("skin", i2).commit();
        m(i2);
    }

    public void i(int i2) {
        this.O = i2;
    }

    private void m(int i2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i2);
        sendBroadcast(intent);
    }

    public int ai() {
        return this.O;
    }

    public int aj() {
        return this.V;
    }

    public void j(int i2) {
        this.V = i2;
        getSharedPreferences("settings", 0).edit().putInt("webview_crash_count", i2).commit();
    }

    public int ak() {
        return this.W;
    }

    public void k(int i2) {
        this.W = i2;
        getSharedPreferences("settings", 0).edit().putInt("perform_sample_count", i2).commit();
    }

    public int al() {
        return this.X;
    }

    public void l(int i2) {
        this.X = i2;
        getSharedPreferences("settings", 0).edit().putInt("new_vcode_webview_crash_count", i2).commit();
    }

    public void am() {
        int i2 = getSharedPreferences("settings", 0).getInt("bd_loc_crash_count", 0) + 1;
        getSharedPreferences("settings", 0).edit().putInt("bd_loc_crash_count", i2).commit();
        if (i2 > 3) {
            a(false);
        }
    }

    public void a(bf bfVar) {
        this.x = bfVar;
    }

    public void a(long j, long j2, long j3) {
        if (j != this.ao || j2 != this.ap || j3 != this.aq) {
            int i2 = 0;
            if (j > this.ao || j2 > this.ap || j3 > this.aq) {
                i2 = 1;
            } else if (j < this.ao || j2 < this.ap || j3 < this.aq) {
                i2 = 2;
            }
            this.ao = j;
            this.ap = j2;
            this.aq = j3;
            aS();
            n(i2);
        }
    }

    private void n(int i2) {
        if (this.d != null) {
            try {
                if (i2 == 1) {
                    Notification notification = new Notification(R.drawable.icon, getString(R.string.notify_text), System.currentTimeMillis());
                    Intent intent = null;
                    StringBuffer stringBuffer = new StringBuffer();
                    if (this.ao > 0 || this.ap > 0) {
                        stringBuffer.append(String.valueOf(this.ao + this.ap));
                        stringBuffer.append(getString(R.string.notify_msg));
                    }
                    if (this.aq > 0) {
                        stringBuffer.append(String.valueOf(this.aq));
                        stringBuffer.append(getString(R.string.notify_fans));
                    }
                    if ((this.ao > 0 || this.ap > 0) && this.aq > 0) {
                        intent = new Intent(this, PersonInfoActivity.class);
                        intent.putExtra("self", true);
                        intent.putExtra("tab_page", false);
                        intent.putExtra("tab_msg", true);
                        intent.putExtra("un", z());
                    } else if (this.ao > 0 || this.ap > 0) {
                        intent = new Intent(this, MentionActivity.class);
                    } else if (this.aq > 0) {
                        intent = new Intent(this, PersonListActivity.class);
                        intent.putExtra("follow", false);
                        intent.putExtra("un", z());
                    }
                    if (intent != null) {
                        stringBuffer.append(getString(R.string.notify_click));
                        intent.setFlags(268435456);
                        notification.setLatestEventInfo(this, getString(R.string.app_name), stringBuffer, PendingIntent.getActivity(this, 0, intent, 0));
                        notification.defaults = -1;
                        notification.flags = 16;
                        notification.audioStreamType = 5;
                        if (!this.al) {
                            notification.defaults &= -2;
                        }
                        if (!this.am) {
                            notification.defaults &= -3;
                        }
                        this.d.notify(R.drawable.icon, notification);
                    }
                } else if (i2 == 2) {
                    this.d.cancel(R.drawable.icon);
                }
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    public void an() {
        if (this.d != null) {
            this.d.cancel(R.drawable.icon);
        }
    }

    public static boolean ao() {
        return ae;
    }

    public static void q(boolean z) {
        ae = z;
    }

    private void aS() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", Z());
        intent.putExtra("at_me", aa());
        intent.putExtra("fans", ab());
        sendBroadcast(intent);
        com.baidu.tieba.d.ae.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(Z()), Long.valueOf(aa()), Long.valueOf(ab())));
    }

    public com.baidu.tieba.d.ab ap() {
        return this.k;
    }

    public int aq() {
        switch (this.J) {
            case 1:
                return BdWebErrorView.ERROR_CODE_900;
            case 2:
            default:
                return 600;
            case 3:
                return MKEvent.ERROR_PERMISSION_DENIED;
        }
    }

    public void ar() {
        this.u = System.currentTimeMillis();
    }

    public void as() {
        this.u = -1L;
    }

    public void at() {
        if (this.u > 0) {
            this.u = System.currentTimeMillis() - this.u;
            if (this.u > 0) {
                new com.baidu.tieba.account.af("startup_time", String.valueOf(this.u));
            }
            com.baidu.tieba.d.ae.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.u));
        }
        this.u = -1L;
    }

    public void au() {
        this.r++;
        aT();
    }

    public void av() {
        this.r--;
        aT();
    }

    private void aT() {
        if (this.p) {
            if (this.r < 0) {
                this.r = 0;
            }
            if (this.s == 0 && this.r > 0) {
                this.s = System.nanoTime();
            }
            com.baidu.tieba.d.ae.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.r));
            this.c.removeMessages(4);
            if (this.r == 0 && this.s > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 60000L);
            }
        }
    }

    public boolean aw() {
        return !getSharedPreferences("settings", 0).getString("lase_version", "").equals(com.baidu.tieba.a.i.h());
    }

    public void ax() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("lase_version", com.baidu.tieba.a.i.h());
        edit.commit();
    }

    public void ay() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.remove("account_share");
        edit.commit();
    }

    public String az() {
        return getSharedPreferences("settings", 0).getString("account_share", null);
    }

    public void j(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("account_share", str);
        edit.commit();
    }

    private void aU() {
        try {
            this.E = (LocationManager) getSystemService(Headers.LOCATION);
            if (this.A) {
                this.C = new an(this);
                com.baidu.location.j jVar = new com.baidu.location.j();
                jVar.a(true);
                jVar.c("tieba");
                jVar.b("all");
                jVar.a("bd09ll");
                jVar.a(BdWebErrorView.ERROR_CODE_500);
                jVar.b(true);
                this.B = new com.baidu.location.e(getApplicationContext());
                this.B.b(this.C);
                this.B.a(jVar);
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public void aA() {
        try {
            if (this.F == null || System.currentTimeMillis() - this.a > 300000) {
                this.F = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.E != null) {
                    this.E.removeUpdates(this.ar);
                }
                if (this.A) {
                    if (!this.B.c()) {
                        this.B.d();
                    }
                    this.B.b();
                }
                this.D = 4;
                if (this.E != null && !this.E.isProviderEnabled("gps") && !this.E.isProviderEnabled("network")) {
                    this.D = 3;
                    if (!this.A) {
                        this.c.sendMessageDelayed(this.c.obtainMessage(5), 100L);
                        return;
                    }
                }
                if (this.E != null && this.E.isProviderEnabled("gps")) {
                    m("gps");
                } else {
                    this.D = 1;
                }
                if (this.E != null && this.E.isProviderEnabled("network")) {
                    m("network");
                } else {
                    this.D = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), 60000L);
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    private void m(String str) {
        if (this.E.isProviderEnabled(str)) {
            this.E.requestLocationUpdates(str, 10000L, 100.0f, this.ar);
        }
    }

    public void aB() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.E != null) {
            this.E.removeUpdates(this.ar);
        }
        if (this.A && this.B != null && this.B.c()) {
            this.B.e();
        }
        if (this.G != null) {
            this.G.cancel();
        }
    }

    public Address aC() {
        return this.F;
    }

    public Address a(am amVar) {
        boolean z;
        if (this.F != null && System.currentTimeMillis() - this.a <= 300000) {
            return this.F;
        }
        if (amVar != null) {
            int i2 = 0;
            while (true) {
                if (i2 < this.H.size()) {
                    am amVar2 = (am) ((SoftReference) this.H.get(i2)).get();
                    if (amVar2 == null || !amVar2.equals(amVar)) {
                        i2++;
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
                if (this.H.size() > 10) {
                    this.H.remove(0);
                }
                this.H.add(new SoftReference(amVar));
            }
            aA();
        }
        return null;
    }

    public void b(am amVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.H.size()) {
                SoftReference softReference = (SoftReference) this.H.get(i3);
                am amVar2 = (am) softReference.get();
                if (amVar2 == null || !amVar2.equals(amVar)) {
                    i2 = i3 + 1;
                } else {
                    this.H.remove(softReference);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void a(int i2, String str, Address address) {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.H != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.H.size()) {
                    am amVar = (am) ((SoftReference) this.H.get(i4)).get();
                    if (amVar != null) {
                        amVar.a(i2, str, address);
                    }
                    i3 = i4 + 1;
                } else {
                    this.H.clear();
                    return;
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        if (z2) {
            this.z |= 16;
            if (z) {
                this.z |= 32;
            }
        } else {
            this.z |= 256;
            if (z) {
                this.z |= 512;
            }
        }
        edit.putInt("check_network_confirm", this.z);
        edit.commit();
    }

    public int aD() {
        this.z = getSharedPreferences("settings", 0).getInt("check_network_confirm", 0);
        return this.z;
    }

    public int r(boolean z) {
        if (z) {
            if ((this.z & 16) == 0) {
                return -1;
            }
            return (this.z & 32) == 0 ? 0 : 1;
        } else if ((this.z & 256) != 0) {
            return (this.z & 512) == 0 ? 0 : 1;
        } else {
            return -1;
        }
    }

    public void g(long j) {
        this.t = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("message_id", j);
        edit.commit();
    }

    public long aE() {
        return this.t;
    }

    public void a(int i2, int i3, String str) {
        if (this.I == null) {
            this.I = Executors.newSingleThreadExecutor();
        }
        com.baidu.tieba.d.ae.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + HanziToPinyin.Token.SEPARATOR + "img_total" + i3);
        com.baidu.tieba.account.ae aeVar = new com.baidu.tieba.account.ae(i2, i3);
        aeVar.a(str);
        this.I.execute(aeVar);
    }

    public void a(com.baidu.tieba.a.c cVar) {
        this.y = cVar;
    }

    public com.baidu.tieba.a.c aF() {
        return this.y;
    }

    public boolean aG() {
        return this.as;
    }

    public void s(boolean z) {
        this.as = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aH() {
        if (d().aG()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(d().G()).longValue() > 86400000;
        }
        return false;
    }

    public BMapManager aI() {
        return this.at;
    }

    public boolean c(Context context) {
        boolean z = false;
        try {
            if (this.at == null) {
                this.at = new BMapManager(context);
            }
            if (this.at != null) {
                if (this.at.init(au, new ao())) {
                    z = true;
                }
            }
        } catch (Exception e) {
            this.at = null;
            com.baidu.tieba.d.ae.a(getClass().getName(), "initEngineManager", e.toString());
        }
        this.av = z;
        return z;
    }
}
