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
import android.location.Location;
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
import com.baidu.tieba.a.az;
import com.baidu.tieba.account.aj;
import com.baidu.tieba.account.ak;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ag;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class TiebaApplication extends Application {
    private static TiebaApplication f;
    private LocationManager D;
    private static com.baidu.tieba.a.a i = null;
    private static String o = null;
    private static boolean p = false;
    private static boolean Y = false;
    private static Intent Z = null;
    private int e = 0;
    private HashMap g = null;
    private boolean h = true;
    private boolean j = false;
    private com.baidu.tieba.c.ab k = null;
    private com.baidu.tieba.c.aa l = null;
    private com.baidu.tieba.c.aa m = null;
    private String n = null;
    private boolean q = false;
    private String r = null;
    private int s = 0;
    private long t = 0;
    private long u = 0;
    private String v = null;
    private az w = null;
    private com.baidu.tieba.a.c x = null;
    public long a = 0;
    private int y = -1;
    private boolean z = true;
    private LocationClient A = null;
    private BDLocationListener B = null;
    private int C = 0;
    private Location E = null;
    private ArrayList F = null;
    private ExecutorService G = null;
    private int H = 2;
    private int I = 1;
    private boolean J = true;
    private int K = 3;
    private boolean L = true;
    private int M = 0;
    private boolean N = true;
    private boolean O = true;
    private boolean P = false;
    private int Q = 2;
    private boolean R = true;
    private int S = 0;
    private boolean T = false;
    private boolean U = true;
    private int V = 0;
    private long W = 0;
    private long X = 0;
    public ArrayList b = null;
    private Hashtable aa = null;
    public Handler c = new Handler(new u(this));
    private int ab = 0;
    private boolean ac = true;
    private boolean ad = true;
    private boolean ae = true;
    private boolean af = true;
    private boolean ag = false;
    private boolean ah = true;
    private long ai = 0;
    private long aj = 0;
    private long ak = 0;
    NotificationManager d = null;
    private final LocationListener al = new v(this);
    private boolean am = false;

    public static void a(Intent intent) {
        Z = intent;
    }

    public static Intent a() {
        return Z;
    }

    @Override // android.app.Application
    public void onCreate() {
        f = this;
        com.baidu.tieba.a.i.m();
        com.baidu.tieba.c.w.c();
        aG();
        aH();
        aC();
        aF();
        o = a((Context) this);
        aD();
        com.baidu.tieba.a.i.c(this);
        com.baidu.tieba.a.i.b(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ag());
        } catch (SecurityException e) {
            af.b(getClass().getName(), "onCreate", e.getMessage());
        }
        getContentResolver().registerContentObserver(Uri.parse("content://telephony/carriers"), true, new w(this, new Handler()));
        this.q = aE();
        if (this.q) {
            ax();
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
            this.k = new com.baidu.tieba.c.ab();
            this.l = new com.baidu.tieba.c.aa(300);
            this.m = new com.baidu.tieba.c.aa(100);
            this.d = (NotificationManager) getSystemService("notification");
            new ak("open").start();
            if (M()) {
                e();
            }
            if (ae()) {
                new ak("frs_abstract", "1").start();
            }
            aM();
            this.F = new ArrayList();
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
        return (this.aa == null || str == null || !this.aa.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.aa != null && str != null) {
            this.aa.put(str, 1);
            new com.baidu.tieba.c.p(1, str).start();
        }
    }

    public void d(String str) {
        if (b(str) && this.aa != null && str != null) {
            this.aa.remove(str);
            new com.baidu.tieba.c.p(2, str).start();
        }
    }

    public void d() {
        this.aa = new Hashtable();
        new com.baidu.tieba.c.p(this.aa).start();
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
                    af.b(getClass().getName(), "addRemoteActivity", e.getMessage());
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

    private void aC() {
        if (Build.VERSION.SDK_INT >= 5) {
            p = new AccountProxy(this).hasBaiduAccount();
        } else {
            p = false;
        }
    }

    public static boolean g() {
        return p;
    }

    private void aD() {
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
    private boolean aE() {
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

    private void aF() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
        this.H = sharedPreferences.getInt("image_quality", 2);
        this.I = sharedPreferences.getInt("view_image_quality", 2);
        this.J = sharedPreferences.getBoolean("show_images", true);
        this.K = sharedPreferences.getInt("font_size", 2);
        this.ah = sharedPreferences.getBoolean("permoted_message", true);
        this.h = sharedPreferences.getBoolean("display_photo", true);
        this.L = sharedPreferences.getBoolean("abstract_state", true);
        this.M = sharedPreferences.getInt("skin", 0);
        this.u = sharedPreferences.getLong("message_id", 0L);
        this.O = sharedPreferences.getBoolean("motu_on", true);
        this.P = sharedPreferences.getBoolean("app_switcher", false);
        this.Q = sharedPreferences.getInt("browser_type", 2);
        this.T = sharedPreferences.getBoolean("manage_mode", false);
        this.N = sharedPreferences.getBoolean("location_on", true);
        this.W = sharedPreferences.getLong("refresh_recommend_time", 0L);
        this.X = sharedPreferences.getLong("refresh_guess_time", 0L);
        this.V = sharedPreferences.getInt("guide_page_bits", 0);
        this.v = sharedPreferences.getString("show_all_like_items", null);
        this.S = sharedPreferences.getInt("webview_crash_count", 0);
        this.z = sharedPreferences.getBoolean("bd_loc_switcher", true);
        this.U = sharedPreferences.getBoolean("search_mode", true);
        if (Build.VERSION.SDK_INT <= 4) {
            this.z = false;
        }
    }

    public int i() {
        return this.Q;
    }

    public void a(int i2) {
        if (this.Q != i2) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putInt("browser_type", i2);
            edit.commit();
            this.Q = i2;
        }
    }

    public void a(boolean z) {
        this.z = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("bd_loc_switcher", this.z);
        edit.commit();
    }

    public void b(boolean z) {
        this.U = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("search_mode", this.U);
        edit.commit();
    }

    public boolean j() {
        return this.U;
    }

    public boolean k() {
        return this.R;
    }

    public void c(boolean z) {
        this.R = z;
    }

    public boolean l() {
        return this.N;
    }

    public void d(boolean z) {
        this.N = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("location_on", this.N);
        edit.commit();
    }

    public void e(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("motu_on", z);
        edit.commit();
        this.O = z;
    }

    public boolean m() {
        return this.O;
    }

    public void f(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.P = z;
    }

    public boolean n() {
        return this.P;
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

    private void aG() {
        try {
            com.baidu.tieba.a.i.b(getPackageManager().getPackageInfo("com.baidu.tieba", 16384).versionName);
            if (com.baidu.tieba.a.i.h() == null) {
                com.baidu.tieba.a.i.b("");
            }
        } catch (Exception e) {
            af.b(getClass().getName(), "InitVersion", e.getMessage());
            com.baidu.tieba.a.i.b("");
        }
    }

    private void aH() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String aI = aI();
                if (aI == null) {
                    String aJ = aJ();
                    if (aJ != null && aJ.length() > 0) {
                        com.baidu.tieba.a.i.a(aJ);
                        k(aJ);
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
                            af.b(getClass().getName(), "InitFrom", e.getMessage());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            af.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.i.a());
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
                    com.baidu.tieba.a.i.a(aI);
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
        af.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.i.a());
    }

    private String aI() {
        return getSharedPreferences("settings", 0).getString("from_id", null);
    }

    private void k(String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("from_id", str);
            edit.commit();
        }
    }

    private String aJ() {
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
            af.b(getClass().getName(), "getFromByFile", e.getMessage());
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
                af.b(getClass().getName(), "saveFromToFile", e2.getMessage());
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
        this.T = bool.booleanValue();
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("manage_mode", bool.booleanValue());
        edit.commit();
    }

    public boolean t() {
        return this.T;
    }

    public void a(long j) {
        this.W = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public long u() {
        return this.W;
    }

    public void b(long j) {
        this.X = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_guess_time", j);
        edit.commit();
    }

    public long v() {
        return this.X;
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

    public static String w() {
        if (i != null) {
            af.a("TiebaApplication", "getCurrentAccount", String.valueOf(i.a()));
            return i.a();
        }
        return null;
    }

    public static void a(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public static String x() {
        if (i != null) {
            return i.d();
        }
        return null;
    }

    public static String y() {
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

    public static com.baidu.tieba.a.a z() {
        return i;
    }

    public static String A() {
        if (i != null) {
            return i.b();
        }
        return null;
    }

    public static void b(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public int B() {
        int i2 = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        af.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i2));
        return i2;
    }

    public void b(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i2);
        edit.commit();
    }

    public long C() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        af.a("TiebaApplication", "getTDatabaseCreateTime", ae.a(j));
        return j;
    }

    public void c(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("update_notify_time", j);
        edit.commit();
    }

    public long D() {
        return getSharedPreferences("settings", 0).getLong("update_notify_time", 0L);
    }

    public void g(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("update_dialog_version", str);
        edit.commit();
    }

    public String E() {
        return getSharedPreferences("settings", 0).getString("update_dialog_version", null);
    }

    public void F() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("tdatabasecreatetime", new Date().getTime());
        edit.commit();
    }

    public boolean G() {
        return B() > 50 && new Date().getTime() - C() > 2592000000L;
    }

    @Override // android.app.Application
    public void onTerminate() {
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

    public String H() {
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
        af.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String I() {
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

    public boolean J() {
        return this.j;
    }

    public int K() {
        return this.ab;
    }

    public void L() {
        d(300);
        k(true);
        m(true);
        l(true);
    }

    public void h(boolean z) {
        this.ah = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            e();
        } else {
            f();
        }
    }

    public boolean M() {
        return this.ah;
    }

    public void i(boolean z) {
        if (this.af != z) {
            this.af = z;
        }
    }

    public boolean N() {
        return this.af;
    }

    public void j(boolean z) {
        this.ag = z;
    }

    public boolean O() {
        return this.ag;
    }

    public int P() {
        if (!this.af && !this.ag) {
            return 0;
        }
        if (this.af && !this.ag) {
            return 1;
        }
        if (!this.af && this.ag) {
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
        af.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i2).toString());
        this.ab = i2;
        if (i2 == 0) {
            a(0L, 0L, 0L);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean Q() {
        return this.ac;
    }

    public void k(boolean z) {
        this.ac = z;
        if (!z) {
            f(0L);
        }
    }

    public boolean R() {
        return this.ad;
    }

    public void l(boolean z) {
        this.ad = z;
        if (!z) {
            e(0L);
        }
    }

    public boolean S() {
        return this.ae;
    }

    public void m(boolean z) {
        this.ae = z;
        if (!z) {
            d(0L);
        }
    }

    public boolean T() {
        return this.ab > 0 && (this.ae || this.ad || this.ac);
    }

    public void U() {
        if (b().T()) {
            startService(new Intent(this, TiebaMessageService.class));
        }
    }

    public void V() {
        stopService(new Intent(this, TiebaMessageService.class));
    }

    public long W() {
        return this.ai;
    }

    public void d(long j) {
        if (j >= 0) {
            a(j, this.aj, this.ak);
        }
    }

    public long X() {
        return this.aj;
    }

    public void e(long j) {
        if (j >= 0) {
            a(this.ai, j, this.ak);
        }
    }

    public long Y() {
        return this.ak;
    }

    public void f(long j) {
        if (j >= 0) {
            a(this.ai, this.aj, j);
        }
    }

    public void Z() {
        this.ai = 0L;
        this.aj = 0L;
        this.ak = 0L;
    }

    public int aa() {
        return this.H;
    }

    public int ab() {
        return this.I;
    }

    public void e(int i2) {
        if (this.H != i2) {
            this.H = i2;
            getSharedPreferences("settings", 0).edit().putInt("image_quality", i2).commit();
        }
    }

    public void f(int i2) {
        if (this.I != i2) {
            this.I = i2;
            getSharedPreferences("settings", 0).edit().putInt("view_image_quality", i2).commit();
        }
    }

    public boolean ac() {
        return this.J;
    }

    public void n(boolean z) {
        if (this.J != z) {
            this.J = z;
            getSharedPreferences("settings", 0).edit().putBoolean("show_images", z).commit();
        }
    }

    public int ad() {
        return this.K;
    }

    public void g(int i2) {
        if (this.K != i2) {
            this.K = i2;
            getSharedPreferences("settings", 0).edit().putInt("font_size", i2).commit();
        }
    }

    public void o(boolean z) {
        this.L = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    public boolean ae() {
        return this.L;
    }

    public void h(int i2) {
        AppsActivity.i();
        i(i2);
        getSharedPreferences("settings", 0).edit().putInt("skin", i2).commit();
        k(i2);
    }

    public void i(int i2) {
        this.M = i2;
    }

    private void k(int i2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i2);
        sendBroadcast(intent);
    }

    public int af() {
        return this.M;
    }

    public int ag() {
        return this.S;
    }

    public void j(int i2) {
        this.S = i2;
        getSharedPreferences("settings", 0).edit().putInt("webview_crash_count", i2).commit();
    }

    public void ah() {
        int i2 = getSharedPreferences("settings", 0).getInt("bd_loc_crash_count", 0) + 1;
        getSharedPreferences("settings", 0).edit().putInt("bd_loc_crash_count", i2).commit();
        if (i2 > 3) {
            a(false);
        }
    }

    public void a(az azVar) {
        this.w = azVar;
    }

    public void a(long j, long j2, long j3) {
        if (j != this.ai || j2 != this.aj || j3 != this.ak) {
            int i2 = 0;
            if (j > this.ai || j2 > this.aj || j3 > this.ak) {
                i2 = 1;
            } else if (j < this.ai || j2 < this.aj || j3 < this.ak) {
                i2 = 2;
            }
            this.ai = j;
            this.aj = j2;
            this.ak = j3;
            aK();
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
                    if (this.ai > 0 || this.aj > 0) {
                        stringBuffer.append(String.valueOf(this.ai + this.aj));
                        stringBuffer.append(getString(R.string.notify_msg));
                    }
                    if (this.ak > 0) {
                        stringBuffer.append(String.valueOf(this.ak));
                        stringBuffer.append(getString(R.string.notify_fans));
                    }
                    if ((this.ai > 0 || this.aj > 0) && this.ak > 0) {
                        intent = new Intent(this, PersonInfoActivity.class);
                        intent.putExtra("self", true);
                        intent.putExtra("tab_page", false);
                        intent.putExtra("tab_msg", true);
                        intent.putExtra("un", w());
                    } else if (this.ai > 0 || this.aj > 0) {
                        intent = new Intent(this, MentionActivity.class);
                    } else if (this.ak > 0) {
                        intent = new Intent(this, PersonListActivity.class);
                        intent.putExtra("follow", false);
                        intent.putExtra("un", w());
                    }
                    if (intent != null) {
                        stringBuffer.append(getString(R.string.notify_click));
                        intent.setFlags(268435456);
                        notification.setLatestEventInfo(this, getString(R.string.app_name), stringBuffer, PendingIntent.getActivity(this, 0, intent, 0));
                        notification.defaults = -1;
                        notification.flags = 16;
                        notification.audioStreamType = 5;
                        if (!this.af) {
                            notification.defaults &= -2;
                        }
                        if (!this.ag) {
                            notification.defaults &= -3;
                        }
                        this.d.notify(R.drawable.icon, notification);
                    }
                } else if (i2 == 2) {
                    this.d.cancel(R.drawable.icon);
                }
            } catch (Exception e) {
                af.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    public void ai() {
        if (this.d != null) {
            this.d.cancel(R.drawable.icon);
        }
    }

    public static boolean aj() {
        return Y;
    }

    public static void p(boolean z) {
        Y = z;
    }

    private void aK() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", W());
        intent.putExtra("at_me", X());
        intent.putExtra("fans", Y());
        sendBroadcast(intent);
        af.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(W()), Long.valueOf(X()), Long.valueOf(Y())));
    }

    public com.baidu.tieba.c.ab ak() {
        return this.k;
    }

    public com.baidu.tieba.c.aa al() {
        return this.l;
    }

    public com.baidu.tieba.c.aa am() {
        return this.m;
    }

    public int an() {
        switch (this.H) {
            case 1:
                return BdWebErrorView.ERROR_CODE_900;
            case 2:
            default:
                return 600;
            case 3:
                return 300;
        }
    }

    public void ao() {
        this.s++;
        aL();
    }

    public void ap() {
        this.s--;
        aL();
    }

    private void aL() {
        if (this.q) {
            if (this.s < 0) {
                this.s = 0;
            }
            if (this.t == 0 && this.s > 0) {
                this.t = System.nanoTime();
            }
            af.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.s));
            this.c.removeMessages(4);
            if (this.s == 0 && this.t > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 180000L);
            }
        }
    }

    public boolean aq() {
        return !getSharedPreferences("settings", 0).getString("lase_version", "").equals(com.baidu.tieba.a.i.h());
    }

    public void ar() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("lase_version", com.baidu.tieba.a.i.h());
        edit.commit();
    }

    public void as() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.remove("account_share");
        edit.commit();
    }

    public String at() {
        return getSharedPreferences("settings", 0).getString("account_share", null);
    }

    public void j(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("account_share", str);
        edit.commit();
    }

    private void aM() {
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
            af.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public void au() {
        try {
            if (this.E == null || System.currentTimeMillis() - this.a > 300000) {
                this.E = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.D != null) {
                    this.D.removeUpdates(this.al);
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
            af.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    private void m(String str) {
        if (this.D.isProviderEnabled(str)) {
            this.D.requestLocationUpdates(str, 10000L, 100.0f, this.al);
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
                TiebaApplication.this.av();
                TiebaApplication.this.E = new Location("baidu_provider");
                TiebaApplication.this.E.setAltitude(bDLocation.getAltitude());
                TiebaApplication.this.E.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.E.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.a = System.currentTimeMillis();
                TiebaApplication.this.a(TiebaApplication.this.C, "", TiebaApplication.this.E);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public void av() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.D != null) {
            this.D.removeUpdates(this.al);
        }
        if (this.z && this.A != null && this.A.isStarted()) {
            this.A.stop();
        }
    }

    public Location aw() {
        return this.E;
    }

    public Location a(x xVar) {
        boolean z;
        if (this.E != null && System.currentTimeMillis() - this.a <= 300000) {
            return this.E;
        }
        if (xVar != null) {
            int i2 = 0;
            while (true) {
                if (i2 < this.F.size()) {
                    x xVar2 = (x) ((SoftReference) this.F.get(i2)).get();
                    if (xVar2 == null || !xVar2.equals(xVar)) {
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
                if (this.F.size() > 10) {
                    this.F.remove(0);
                }
                this.F.add(new SoftReference(xVar));
            }
            au();
        }
        return null;
    }

    public void b(x xVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.F.size()) {
                SoftReference softReference = (SoftReference) this.F.get(i3);
                x xVar2 = (x) softReference.get();
                if (xVar2 == null || !xVar2.equals(xVar)) {
                    i2 = i3 + 1;
                } else {
                    this.F.remove(softReference);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void a(int i2, String str, Location location) {
        if (this.F != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.F.size()) {
                    x xVar = (x) ((SoftReference) this.F.get(i4)).get();
                    if (xVar != null) {
                        xVar.a(i2, str, location);
                    }
                    i3 = i4 + 1;
                } else {
                    this.F.clear();
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

    public int ax() {
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

    public void g(long j) {
        this.u = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("message_id", j);
        edit.commit();
    }

    public long ay() {
        return this.u;
    }

    public void a(int i2, int i3, String str) {
        if (this.G == null) {
            this.G = Executors.newSingleThreadExecutor();
        }
        af.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + " img_total" + i3);
        aj ajVar = new aj(i2, i3);
        ajVar.a(str);
        this.G.execute(ajVar);
    }

    public void a(com.baidu.tieba.a.c cVar) {
        this.x = cVar;
    }

    public com.baidu.tieba.a.c az() {
        return this.x;
    }

    public boolean aA() {
        return this.am;
    }

    public void r(boolean z) {
        this.am = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aB() {
        if (b().aA()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(b().D()).longValue() > 86400000;
        }
        return false;
    }
}
