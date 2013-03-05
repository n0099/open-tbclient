package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.Application;
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
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.a.ax;
import com.baidu.tieba.account.aj;
import com.baidu.tieba.account.ak;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ah;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.service.MessagePullService;
import com.baidu.tieba.service.TiebaMessageService;
import com.baidu.zeus.Headers;
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
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class TiebaApplication extends Application {
    private static TiebaApplication f;
    private LocationManager D;
    private static com.baidu.tieba.a.a i = null;
    private static String o = null;
    private static boolean p = false;
    private static boolean aa = false;
    private static Intent ab = null;
    private static String aq = "79A74DC064B49770ED928E44E679A79E86AD9B9A";
    private int e = 0;
    private HashMap g = null;
    private boolean h = true;
    private boolean j = false;
    private com.baidu.tieba.c.ac k = null;
    private com.baidu.tieba.c.ab l = null;
    private com.baidu.tieba.c.ab m = null;
    private String n = null;
    private boolean q = false;
    private String r = null;
    private int s = 0;
    private long t = 0;
    private long u = 0;
    private String v = null;
    private ax w = null;
    private com.baidu.tieba.a.c x = null;
    public long a = 0;
    private int y = -1;
    private boolean z = true;
    private LocationClient A = null;
    private BDLocationListener B = null;
    private int C = 0;
    private Address E = null;
    private aa F = null;
    private ArrayList G = null;
    private ExecutorService H = null;
    private int I = 2;
    private int J = 1;
    private boolean K = true;
    private int L = 3;
    private boolean M = true;
    private int N = 0;
    private boolean O = true;
    private boolean P = true;
    private boolean Q = false;
    private int R = 2;
    private boolean S = true;
    private int T = 0;
    private boolean U = false;
    private boolean V = true;
    private int W = 0;
    private long X = 0;
    private long Y = 0;
    private long Z = 0;
    public ArrayList b = null;
    private Hashtable ac = null;
    public Handler c = new Handler(new v(this));
    private int ad = 0;
    private boolean ae = true;
    private boolean af = true;
    private boolean ag = true;
    private boolean ah = true;
    private boolean ai = false;
    private boolean aj = true;
    private long ak = 0;
    private long al = 0;
    private long am = 0;
    NotificationManager d = null;
    private final LocationListener an = new w(this);
    private boolean ao = false;
    private BMapManager ap = null;
    private boolean ar = false;

    public static void a(Intent intent) {
        ab = intent;
    }

    public static Intent a() {
        return ab;
    }

    @Override // android.app.Application
    public void onCreate() {
        f = this;
        com.baidu.tieba.a.i.m();
        com.baidu.tieba.c.w.d();
        aI();
        aJ();
        aE();
        aH();
        o = a((Context) this);
        aF();
        com.baidu.tieba.a.i.c(this);
        com.baidu.tieba.a.i.b(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ah());
        } catch (SecurityException e) {
            ag.b(getClass().getName(), "onCreate", e.getMessage());
        }
        getContentResolver().registerContentObserver(Uri.parse("content://telephony/carriers"), true, new x(this, new Handler()));
        this.q = aG();
        if (this.q) {
            ay();
            this.g = new HashMap();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                i = com.baidu.tieba.c.k.l();
            }
            if (g()) {
                a.a(this);
            } else {
                com.baidu.tieba.account.a.a().a(this);
            }
            com.baidu.tieba.c.k.w();
            d();
            this.k = new com.baidu.tieba.c.ac();
            this.l = new com.baidu.tieba.c.ab(MKEvent.ERROR_PERMISSION_DENIED);
            this.m = new com.baidu.tieba.c.ab(100);
            this.d = (NotificationManager) getSystemService("notification");
            new ak("open").start();
            if (N()) {
                e();
            }
            if (af()) {
                new ak("frs_abstract", "1").start();
            }
            aO();
            this.G = new ArrayList();
        } else {
            this.b = new ArrayList();
        }
        registerReceiver(new com.baidu.tieba.service.g(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        super.onCreate();
    }

    public static TiebaApplication b() {
        return f;
    }

    public void a(String str) {
        this.r = str;
    }

    public String c() {
        return this.r;
    }

    public boolean b(String str) {
        return (this.ac == null || str == null || !this.ac.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.ac != null && str != null) {
            this.ac.put(str, 1);
            new com.baidu.tieba.c.p(1, str).start();
        }
    }

    public void d(String str) {
        if (b(str) && this.ac != null && str != null) {
            this.ac.remove(str);
            new com.baidu.tieba.c.p(2, str).start();
        }
    }

    public void d() {
        this.ac = new Hashtable();
        new com.baidu.tieba.c.p(this.ac).start();
    }

    public void e() {
        startService(new Intent(this, MessagePullService.class));
    }

    public void f() {
        stopService(new Intent(this, MessagePullService.class));
    }

    public void a(e eVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ((e) this.b.get(i2)).b();
                } catch (Exception e) {
                    ag.b(getClass().getName(), "addRemoteActivity", e.getMessage());
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

    private void aE() {
        if (Build.VERSION.SDK_INT >= 5) {
            p = new AccountProxy(this).hasBaiduAccount();
        } else {
            p = false;
        }
    }

    public static boolean g() {
        return p;
    }

    private void aF() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.n = telephonyManager.getDeviceId();
        }
    }

    public String h() {
        return this.n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r0.equalsIgnoreCase("com.baidu.tieba:remote") != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean aG() {
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

    private void aH() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
        this.I = sharedPreferences.getInt("image_quality", 2);
        this.J = sharedPreferences.getInt("view_image_quality", 2);
        this.K = sharedPreferences.getBoolean("show_images", true);
        this.L = sharedPreferences.getInt("font_size", 2);
        this.aj = sharedPreferences.getBoolean("permoted_message", true);
        this.h = sharedPreferences.getBoolean("display_photo", true);
        this.M = sharedPreferences.getBoolean("abstract_state", true);
        this.N = sharedPreferences.getInt("skin", 0);
        this.u = sharedPreferences.getLong("message_id", 0L);
        this.P = sharedPreferences.getBoolean("motu_on", true);
        this.Q = sharedPreferences.getBoolean("app_switcher", false);
        this.R = sharedPreferences.getInt("browser_type", 2);
        this.U = sharedPreferences.getBoolean("manage_mode", false);
        this.O = sharedPreferences.getBoolean("location_on", true);
        this.X = sharedPreferences.getLong("refresh_recommend_time", 0L);
        this.Y = sharedPreferences.getLong("refresh_guess_time", 0L);
        this.W = sharedPreferences.getInt("guide_page_bits", 0);
        this.v = sharedPreferences.getString("show_all_like_items", null);
        this.T = sharedPreferences.getInt("webview_crash_count", 0);
        this.z = sharedPreferences.getBoolean("bd_loc_switcher", true);
        this.V = sharedPreferences.getBoolean("search_mode", true);
        this.Z = sharedPreferences.getLong("show_nearby_guide_time", 0L);
        if (Build.VERSION.SDK_INT <= 4) {
            this.z = false;
        }
    }

    public int i() {
        return this.R;
    }

    public void a(int i2) {
        if (this.R != i2) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putInt("browser_type", i2);
            edit.commit();
            this.R = i2;
        }
    }

    public void a(boolean z) {
        this.z = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("bd_loc_switcher", this.z);
        edit.commit();
    }

    public void b(boolean z) {
        this.V = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("search_mode", this.V);
        edit.commit();
    }

    public boolean j() {
        return this.V;
    }

    public boolean k() {
        return this.S;
    }

    public void c(boolean z) {
        this.S = z;
    }

    public boolean l() {
        return this.O;
    }

    public void d(boolean z) {
        this.O = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("location_on", this.O);
        edit.commit();
    }

    public void e(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("motu_on", z);
        edit.commit();
        this.P = z;
    }

    public boolean m() {
        return this.P;
    }

    public void f(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.Q = z;
    }

    public boolean n() {
        return this.Q;
    }

    public void o() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("show_all_like_items", com.baidu.tieba.a.i.h());
        edit.commit();
        this.v = com.baidu.tieba.a.i.h();
    }

    public String p() {
        return this.v;
    }

    private void aI() {
        try {
            com.baidu.tieba.a.i.b(getPackageManager().getPackageInfo("com.baidu.tieba", 16384).versionName);
            if (com.baidu.tieba.a.i.h() == null) {
                com.baidu.tieba.a.i.b("");
            }
        } catch (Exception e) {
            ag.b(getClass().getName(), "InitVersion", e.getMessage());
            com.baidu.tieba.a.i.b("");
        }
    }

    private void aJ() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String aK = aK();
                if (aK == null) {
                    String aL = aL();
                    if (aL != null && aL.length() > 0) {
                        com.baidu.tieba.a.i.a(aL);
                        k(aL);
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
                            ag.b(getClass().getName(), "InitFrom", e.getMessage());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            ag.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.i.a());
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
                    com.baidu.tieba.a.i.a(aK);
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
        ag.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.i.a());
    }

    private String aK() {
        return getSharedPreferences("settings", 0).getString("from_id", null);
    }

    private void k(String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("from_id", str);
            edit.commit();
        }
    }

    private String aL() {
        String str = null;
        try {
            File c = com.baidu.tieba.c.o.c("from.dat");
            if (c != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(c));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            ag.b(getClass().getName(), "getFromByFile", e.getMessage());
        }
        return str;
    }

    private void l(String str) {
        if (str != null && str.length() > 0) {
            try {
                File e = com.baidu.tieba.c.o.e("from.dat");
                if (e != null) {
                    FileWriter fileWriter = new FileWriter(e);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e2) {
                ag.b(getClass().getName(), "saveFromToFile", e2.getMessage());
            }
        }
    }

    public static String q() {
        return com.baidu.tieba.a.i.a();
    }

    public void r() {
        a(0L, 0L, 0L);
        com.baidu.tieba.c.k.w();
    }

    public Bitmap e(String str) {
        SoftReference softReference = (SoftReference) this.g.get(str);
        if (softReference != null && softReference.get() != null) {
            return (Bitmap) softReference.get();
        }
        Bitmap a = com.baidu.tieba.c.n.a(f, str);
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

    public boolean s() {
        return this.h;
    }

    public void b(Boolean bool) {
        this.U = bool.booleanValue();
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("manage_mode", bool.booleanValue());
        edit.commit();
    }

    public boolean t() {
        return this.U;
    }

    public void a(long j) {
        this.Z = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("show_nearby_guide_time", j);
        edit.commit();
    }

    public long u() {
        return this.Z;
    }

    public void b(long j) {
        this.X = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public long v() {
        return this.X;
    }

    public void c(long j) {
        this.Y = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_guess_time", j);
        edit.commit();
    }

    public long w() {
        return this.Y;
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

    public static String x() {
        if (i != null) {
            ag.a("TiebaApplication", "getCurrentAccount", String.valueOf(i.a()));
            return i.a();
        }
        return null;
    }

    public static void a(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public static String y() {
        if (i != null) {
            return i.d();
        }
        return null;
    }

    public static String z() {
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

    public static com.baidu.tieba.a.a A() {
        return i;
    }

    public static String B() {
        if (i != null) {
            return i.b();
        }
        return null;
    }

    public static void b(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public int C() {
        int i2 = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        ag.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i2));
        return i2;
    }

    public void b(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i2);
        edit.commit();
    }

    public long D() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        ag.a("TiebaApplication", "getTDatabaseCreateTime", af.a(j));
        return j;
    }

    public void d(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("update_notify_time", j);
        edit.commit();
    }

    public long E() {
        return getSharedPreferences("settings", 0).getLong("update_notify_time", 0L);
    }

    public void g(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("update_dialog_version", str);
        edit.commit();
    }

    public String F() {
        return getSharedPreferences("settings", 0).getString("update_dialog_version", null);
    }

    public void G() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("tdatabasecreatetime", new Date().getTime());
        edit.commit();
    }

    public boolean H() {
        return C() > 50 && new Date().getTime() - D() > 2592000000L;
    }

    @Override // android.app.Application
    public void onTerminate() {
        if (this.ap != null) {
            this.ap.destroy();
            this.ap = null;
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

    public String I() {
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
                    b((Context) b());
                }
            } else {
                b((Context) b());
            }
        } else {
            str = string;
        }
        ag.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String J() {
        return o;
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
        o = str;
    }

    public void g(boolean z) {
        this.j = z;
    }

    public boolean K() {
        return this.j;
    }

    public int L() {
        return this.ad;
    }

    public void M() {
        d(MKEvent.ERROR_PERMISSION_DENIED);
        k(true);
        m(true);
        l(true);
    }

    public void h(boolean z) {
        this.aj = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            e();
        } else {
            f();
        }
    }

    public boolean N() {
        return this.aj;
    }

    public void i(boolean z) {
        if (this.ah != z) {
            this.ah = z;
        }
    }

    public boolean O() {
        return this.ah;
    }

    public void j(boolean z) {
        this.ai = z;
    }

    public boolean P() {
        return this.ai;
    }

    public int Q() {
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

    public void c(int i2) {
        if (i2 == 0) {
            b().i(false);
            b().j(false);
        } else if (i2 == 1) {
            b().i(true);
            b().j(false);
        } else if (i2 == 2) {
            b().i(false);
            b().j(true);
        } else {
            b().i(true);
            b().j(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 int)] */
    public void d(int i2) {
        ag.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i2).toString());
        this.ad = i2;
        if (i2 == 0) {
            a(0L, 0L, 0L);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean R() {
        return this.ae;
    }

    public void k(boolean z) {
        this.ae = z;
        if (!z) {
            g(0L);
        }
    }

    public boolean S() {
        return this.af;
    }

    public void l(boolean z) {
        this.af = z;
        if (!z) {
            f(0L);
        }
    }

    public boolean T() {
        return this.ag;
    }

    public void m(boolean z) {
        this.ag = z;
        if (!z) {
            e(0L);
        }
    }

    public boolean U() {
        return this.ad > 0 && (this.ag || this.af || this.ae);
    }

    public void V() {
        if (b().U()) {
            startService(new Intent(this, TiebaMessageService.class));
        }
    }

    public void W() {
        stopService(new Intent(this, TiebaMessageService.class));
    }

    public long X() {
        return this.ak;
    }

    public void e(long j) {
        if (j >= 0) {
            a(j, this.al, this.am);
        }
    }

    public long Y() {
        return this.al;
    }

    public void f(long j) {
        if (j >= 0) {
            a(this.ak, j, this.am);
        }
    }

    public long Z() {
        return this.am;
    }

    public void g(long j) {
        if (j >= 0) {
            a(this.ak, this.al, j);
        }
    }

    public void aa() {
        this.ak = 0L;
        this.al = 0L;
        this.am = 0L;
    }

    public int ab() {
        return this.I;
    }

    public int ac() {
        return this.J;
    }

    public void e(int i2) {
        if (this.I != i2) {
            this.I = i2;
            getSharedPreferences("settings", 0).edit().putInt("image_quality", i2).commit();
        }
    }

    public void f(int i2) {
        if (this.J != i2) {
            this.J = i2;
            getSharedPreferences("settings", 0).edit().putInt("view_image_quality", i2).commit();
        }
    }

    public boolean ad() {
        return this.K;
    }

    public void n(boolean z) {
        if (this.K != z) {
            this.K = z;
            getSharedPreferences("settings", 0).edit().putBoolean("show_images", z).commit();
        }
    }

    public int ae() {
        return this.L;
    }

    public void g(int i2) {
        if (this.L != i2) {
            this.L = i2;
            getSharedPreferences("settings", 0).edit().putInt("font_size", i2).commit();
        }
    }

    public void o(boolean z) {
        this.M = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    public boolean af() {
        return this.M;
    }

    public void h(int i2) {
        AppsActivity.i();
        i(i2);
        getSharedPreferences("settings", 0).edit().putInt("skin", i2).commit();
        k(i2);
    }

    public void i(int i2) {
        this.N = i2;
    }

    private void k(int i2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i2);
        sendBroadcast(intent);
    }

    public int ag() {
        return this.N;
    }

    public int ah() {
        return this.T;
    }

    public void j(int i2) {
        this.T = i2;
        getSharedPreferences("settings", 0).edit().putInt("webview_crash_count", i2).commit();
    }

    public void ai() {
        int i2 = getSharedPreferences("settings", 0).getInt("bd_loc_crash_count", 0) + 1;
        getSharedPreferences("settings", 0).edit().putInt("bd_loc_crash_count", i2).commit();
        if (i2 > 3) {
            a(false);
        }
    }

    public void a(ax axVar) {
        this.w = axVar;
    }

    public void a(long j, long j2, long j3) {
        if (j != this.ak || j2 != this.al || j3 != this.am) {
            int i2 = 0;
            if (j > this.ak || j2 > this.al || j3 > this.am) {
                i2 = 1;
            } else if (j < this.ak || j2 < this.al || j3 < this.am) {
                i2 = 2;
            }
            this.ak = j;
            this.al = j2;
            this.am = j3;
            aM();
            l(i2);
        }
    }

    private void l(int i2) {
        if (this.d != null) {
            try {
                if (i2 == 1) {
                    Notification notification = new Notification(R.drawable.icon, getString(R.string.notify_text), System.currentTimeMillis());
                    Intent intent = null;
                    StringBuffer stringBuffer = new StringBuffer();
                    if (this.ak > 0 || this.al > 0) {
                        stringBuffer.append(String.valueOf(this.ak + this.al));
                        stringBuffer.append(getString(R.string.notify_msg));
                    }
                    if (this.am > 0) {
                        stringBuffer.append(String.valueOf(this.am));
                        stringBuffer.append(getString(R.string.notify_fans));
                    }
                    if ((this.ak > 0 || this.al > 0) && this.am > 0) {
                        intent = new Intent(this, PersonInfoActivity.class);
                        intent.putExtra("self", true);
                        intent.putExtra("tab_page", false);
                        intent.putExtra("tab_msg", true);
                        intent.putExtra("un", x());
                    } else if (this.ak > 0 || this.al > 0) {
                        intent = new Intent(this, MentionActivity.class);
                    } else if (this.am > 0) {
                        intent = new Intent(this, PersonListActivity.class);
                        intent.putExtra("follow", false);
                        intent.putExtra("un", x());
                    }
                    if (intent != null) {
                        stringBuffer.append(getString(R.string.notify_click));
                        intent.setFlags(268435456);
                        notification.setLatestEventInfo(this, getString(R.string.app_name), stringBuffer, PendingIntent.getActivity(this, 0, intent, 0));
                        notification.defaults = -1;
                        notification.flags = 16;
                        notification.audioStreamType = 5;
                        if (!this.ah) {
                            notification.defaults &= -2;
                        }
                        if (!this.ai) {
                            notification.defaults &= -3;
                        }
                        this.d.notify(R.drawable.icon, notification);
                    }
                } else if (i2 == 2) {
                    this.d.cancel(R.drawable.icon);
                }
            } catch (Exception e) {
                ag.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    public void aj() {
        if (this.d != null) {
            this.d.cancel(R.drawable.icon);
        }
    }

    public static boolean ak() {
        return aa;
    }

    public static void p(boolean z) {
        aa = z;
    }

    private void aM() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", X());
        intent.putExtra("at_me", Y());
        intent.putExtra("fans", Z());
        sendBroadcast(intent);
        ag.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(X()), Long.valueOf(Y()), Long.valueOf(Z())));
    }

    public com.baidu.tieba.c.ac al() {
        return this.k;
    }

    public com.baidu.tieba.c.ab am() {
        return this.l;
    }

    public com.baidu.tieba.c.ab an() {
        return this.m;
    }

    public int ao() {
        switch (this.I) {
            case 1:
                return BdWebErrorView.ERROR_CODE_900;
            case 2:
            default:
                return 600;
            case 3:
                return MKEvent.ERROR_PERMISSION_DENIED;
        }
    }

    public void ap() {
        this.s++;
        aN();
    }

    public void aq() {
        this.s--;
        aN();
    }

    private void aN() {
        if (this.q) {
            if (this.s < 0) {
                this.s = 0;
            }
            if (this.t == 0 && this.s > 0) {
                this.t = System.nanoTime();
            }
            ag.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.s));
            this.c.removeMessages(4);
            if (this.s == 0 && this.t > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 180000L);
            }
        }
    }

    public boolean ar() {
        return !getSharedPreferences("settings", 0).getString("lase_version", "").equals(com.baidu.tieba.a.i.h());
    }

    public void as() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("lase_version", com.baidu.tieba.a.i.h());
        edit.commit();
    }

    public void at() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.remove("account_share");
        edit.commit();
    }

    public String au() {
        return getSharedPreferences("settings", 0).getString("account_share", null);
    }

    public void j(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("account_share", str);
        edit.commit();
    }

    private void aO() {
        try {
            this.D = (LocationManager) getSystemService(Headers.LOCATION);
            if (this.z) {
                this.B = new MyBDLocationListenner();
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName("tieba");
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(BdWebErrorView.ERROR_CODE_500);
                locationClientOption.disableCache(true);
                this.A = new LocationClient(getApplicationContext());
                this.A.registerLocationListener(this.B);
                this.A.setLocOption(locationClientOption);
            }
        } catch (Exception e) {
            ag.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public void av() {
        try {
            if (this.E == null || System.currentTimeMillis() - this.a > 300000) {
                this.E = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.D != null) {
                    this.D.removeUpdates(this.an);
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
                    m("gps");
                } else {
                    this.C = 1;
                }
                if (this.D != null && this.D.isProviderEnabled("network")) {
                    m("network");
                } else {
                    this.C = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), 60000L);
            }
        } catch (Exception e) {
            ag.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    private void m(String str) {
        if (this.D.isProviderEnabled(str)) {
            this.D.requestLocationUpdates(str, 10000L, 100.0f, this.an);
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
                TiebaApplication.this.aw();
                TiebaApplication.this.E = new Address(Locale.getDefault());
                TiebaApplication.this.E.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.E.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.a = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
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

    public void aw() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.D != null) {
            this.D.removeUpdates(this.an);
        }
        if (this.z && this.A != null && this.A.isStarted()) {
            this.A.stop();
        }
        if (this.F != null) {
            this.F.a();
        }
    }

    public Address ax() {
        return this.E;
    }

    public Address a(y yVar) {
        boolean z;
        if (this.E != null && System.currentTimeMillis() - this.a <= 300000) {
            return this.E;
        }
        if (yVar != null) {
            int i2 = 0;
            while (true) {
                if (i2 < this.G.size()) {
                    y yVar2 = (y) ((SoftReference) this.G.get(i2)).get();
                    if (yVar2 == null || !yVar2.equals(yVar)) {
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
                if (this.G.size() > 10) {
                    this.G.remove(0);
                }
                this.G.add(new SoftReference(yVar));
            }
            av();
        }
        return null;
    }

    public void b(y yVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.G.size()) {
                SoftReference softReference = (SoftReference) this.G.get(i3);
                y yVar2 = (y) softReference.get();
                if (yVar2 == null || !yVar2.equals(yVar)) {
                    i2 = i3 + 1;
                } else {
                    this.G.remove(softReference);
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
        if (this.G != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.G.size()) {
                    y yVar = (y) ((SoftReference) this.G.get(i4)).get();
                    if (yVar != null) {
                        yVar.a(i2, str, address);
                    }
                    i3 = i4 + 1;
                } else {
                    this.G.clear();
                    return;
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        if (z2) {
            this.y |= 16;
            if (z) {
                this.y |= 32;
            }
        } else {
            this.y |= 256;
            if (z) {
                this.y |= 512;
            }
        }
        edit.putInt("check_network_confirm", this.y);
        edit.commit();
    }

    public int ay() {
        this.y = getSharedPreferences("settings", 0).getInt("check_network_confirm", 0);
        return this.y;
    }

    public int q(boolean z) {
        if (z) {
            if ((this.y & 16) == 0) {
                return -1;
            }
            return (this.y & 32) == 0 ? 0 : 1;
        } else if ((this.y & 256) != 0) {
            return (this.y & 512) == 0 ? 0 : 1;
        } else {
            return -1;
        }
    }

    public void h(long j) {
        this.u = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("message_id", j);
        edit.commit();
    }

    public long az() {
        return this.u;
    }

    public void a(int i2, int i3, String str) {
        if (this.H == null) {
            this.H = Executors.newSingleThreadExecutor();
        }
        ag.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + " img_total" + i3);
        aj ajVar = new aj(i2, i3);
        ajVar.a(str);
        this.H.execute(ajVar);
    }

    public void a(com.baidu.tieba.a.c cVar) {
        this.x = cVar;
    }

    public com.baidu.tieba.a.c aA() {
        return this.x;
    }

    public boolean aB() {
        return this.ao;
    }

    public void r(boolean z) {
        this.ao = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aC() {
        if (b().aB()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(b().E()).longValue() > 86400000;
        }
        return false;
    }

    public BMapManager aD() {
        return this.ap;
    }

    public boolean c(Context context) {
        boolean z = false;
        try {
            if (this.ap == null) {
                this.ap = new BMapManager(context);
            }
            if (this.ap != null) {
                if (this.ap.init(aq, new z())) {
                    z = true;
                }
            }
        } catch (Exception e) {
            this.ap = null;
            ag.a(getClass().getName(), "initEngineManager", e.toString());
        }
        this.ar = z;
        return z;
    }
}
