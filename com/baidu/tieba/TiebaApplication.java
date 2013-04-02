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
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.a.bb;
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
    private LocationManager F;
    private static com.baidu.tieba.a.a i = null;
    private static String o = null;
    private static boolean p = false;
    private static boolean ad = false;
    private static Intent ae = null;
    private static String at = "79A74DC064B49770ED928E44E679A79E86AD9B9A";
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
    private long v = -1;
    private String w = null;
    private String x = null;
    private bb y = null;
    private com.baidu.tieba.a.c z = null;
    public long a = 0;
    private int A = -1;
    private boolean B = true;
    private LocationClient C = null;
    private BDLocationListener D = null;
    private int E = 0;
    private Address G = null;
    private ap H = null;
    private ArrayList I = null;
    private ExecutorService J = null;
    private int K = 2;
    private int L = 1;
    private boolean M = true;
    private int N = 3;
    private boolean O = true;
    private int P = 0;
    private boolean Q = true;
    private boolean R = true;
    private boolean S = false;
    private int T = 2;
    private boolean U = true;
    private int V = 0;
    private int W = 0;
    private boolean X = false;
    private boolean Y = true;
    private int Z = 0;
    private long aa = 0;
    private long ab = 0;
    private long ac = 0;
    public ArrayList b = null;
    private Hashtable af = null;
    public Handler c = new Handler(new ak(this));
    private int ag = 0;
    private boolean ah = true;
    private boolean ai = true;
    private boolean aj = true;
    private boolean ak = true;
    private boolean al = false;
    private boolean am = true;
    private long an = 0;
    private long ao = 0;
    private long ap = 0;
    NotificationManager d = null;
    private final LocationListener aq = new al(this);
    private boolean ar = false;
    private BMapManager as = null;
    private boolean au = false;

    public static void a(Intent intent) {
        ae = intent;
    }

    public static Intent a() {
        return ae;
    }

    @Override // android.app.Application
    public void onCreate() {
        f = this;
        com.baidu.tieba.a.i.m();
        com.baidu.tieba.c.w.e();
        aO();
        aP();
        aJ();
        aN();
        o = a((Context) this);
        aK();
        aL();
        com.baidu.tieba.a.i.c(this);
        com.baidu.tieba.a.i.b(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.c.ah());
        } catch (SecurityException e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onCreate", e.getMessage());
        }
        getContentResolver().registerContentObserver(Uri.parse("content://telephony/carriers"), true, new am(this, new Handler()));
        this.q = aM();
        if (this.q) {
            aD();
            this.g = new HashMap();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                i = com.baidu.tieba.c.k.m();
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
            new com.baidu.tieba.account.ak("open").start();
            if (O()) {
                e();
            }
            if (ag()) {
                new com.baidu.tieba.account.ak("frs_abstract", "1").start();
            }
            aU();
            this.I = new ArrayList();
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
        return (this.af == null || str == null || !this.af.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.af != null && str != null) {
            this.af.put(str, 1);
            new com.baidu.tieba.c.p(1, str).start();
        }
    }

    public void d(String str) {
        if (b(str) && this.af != null && str != null) {
            this.af.remove(str);
            new com.baidu.tieba.c.p(2, str).start();
        }
    }

    public void d() {
        this.af = new Hashtable();
        new com.baidu.tieba.c.p(this.af).start();
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
                    com.baidu.tieba.c.ag.b(getClass().getName(), "addRemoteActivity", e.getMessage());
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
            p = new AccountProxy(this).hasBaiduAccount();
        } else {
            p = false;
        }
    }

    public static boolean g() {
        return p;
    }

    private void aK() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.n = telephonyManager.getDeviceId();
        }
    }

    private void aL() {
        if (this.x == null || this.x.length() < 0) {
            this.x = CommonParam.getCUID(this);
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("cuid", this.x);
            edit.commit();
        }
    }

    public String h() {
        return this.x;
    }

    public String i() {
        return this.n;
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
        this.K = sharedPreferences.getInt("image_quality", 2);
        this.L = sharedPreferences.getInt("view_image_quality", 2);
        this.M = sharedPreferences.getBoolean("show_images", true);
        this.N = sharedPreferences.getInt("font_size", 2);
        this.am = sharedPreferences.getBoolean("permoted_message", true);
        this.h = sharedPreferences.getBoolean("display_photo", true);
        this.O = sharedPreferences.getBoolean("abstract_state", true);
        this.P = sharedPreferences.getInt("skin", 0);
        this.u = sharedPreferences.getLong("message_id", 0L);
        this.R = sharedPreferences.getBoolean("motu_on", true);
        this.S = sharedPreferences.getBoolean("app_switcher", false);
        this.T = sharedPreferences.getInt("browser_type", 2);
        this.X = sharedPreferences.getBoolean("manage_mode", false);
        this.Q = sharedPreferences.getBoolean("location_on", true);
        this.aa = sharedPreferences.getLong("refresh_recommend_time", 0L);
        this.ab = sharedPreferences.getLong("refresh_guess_time", 0L);
        this.Z = sharedPreferences.getInt("guide_page_bits", 0);
        this.w = sharedPreferences.getString("show_all_like_items", null);
        this.V = sharedPreferences.getInt("webview_crash_count", 0);
        this.W = sharedPreferences.getInt("new_vcode_webview_crash_count", 0);
        this.B = sharedPreferences.getBoolean("bd_loc_switcher", true);
        this.Y = sharedPreferences.getBoolean("search_mode", true);
        this.ac = sharedPreferences.getLong("show_nearby_guide_time", 0L);
        this.x = sharedPreferences.getString("cuid", null);
        if (Build.VERSION.SDK_INT <= 4) {
            this.B = false;
        }
    }

    public int j() {
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
        this.B = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("bd_loc_switcher", this.B);
        edit.commit();
    }

    public void b(boolean z) {
        this.Y = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("search_mode", this.Y);
        edit.commit();
    }

    public boolean k() {
        return this.Y;
    }

    public boolean l() {
        return this.U;
    }

    public void c(boolean z) {
        this.U = z;
    }

    public boolean m() {
        return this.Q;
    }

    public void d(boolean z) {
        this.Q = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("location_on", this.Q);
        edit.commit();
    }

    public void e(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("motu_on", z);
        edit.commit();
        this.R = z;
    }

    public boolean n() {
        return this.R;
    }

    public void f(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.S = z;
    }

    public boolean o() {
        return this.S;
    }

    public void p() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("show_all_like_items", com.baidu.tieba.a.i.h());
        edit.commit();
        this.w = com.baidu.tieba.a.i.h();
    }

    public String q() {
        return this.w;
    }

    private void aO() {
        try {
            com.baidu.tieba.a.i.b(getPackageManager().getPackageInfo("com.baidu.tieba", 16384).versionName);
            if (com.baidu.tieba.a.i.h() == null) {
                com.baidu.tieba.a.i.b("");
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "InitVersion", e.getMessage());
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
                            com.baidu.tieba.c.ag.b(getClass().getName(), "InitFrom", e.getMessage());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            com.baidu.tieba.c.ag.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.i.a());
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
        com.baidu.tieba.c.ag.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.i.a());
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
            File c = com.baidu.tieba.c.o.c("from.dat");
            if (c != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(c));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "getFromByFile", e.getMessage());
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
                com.baidu.tieba.c.ag.b(getClass().getName(), "saveFromToFile", e2.getMessage());
            }
        }
    }

    public static String r() {
        return com.baidu.tieba.a.i.a();
    }

    public void s() {
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

    public boolean t() {
        return this.h;
    }

    public void b(Boolean bool) {
        this.X = bool.booleanValue();
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("manage_mode", bool.booleanValue());
        edit.commit();
    }

    public boolean u() {
        return this.X;
    }

    public void a(long j) {
        this.ac = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("show_nearby_guide_time", j);
        edit.commit();
    }

    public long v() {
        return this.ac;
    }

    public void b(long j) {
        this.aa = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public long w() {
        return this.aa;
    }

    public void c(long j) {
        this.ab = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_guess_time", j);
        edit.commit();
    }

    public long x() {
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

    public static String y() {
        if (i != null) {
            com.baidu.tieba.c.ag.a("TiebaApplication", "getCurrentAccount", String.valueOf(i.a()));
            return i.a();
        }
        return null;
    }

    public static void a(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public static String z() {
        if (i != null) {
            return i.d();
        }
        return null;
    }

    public static String A() {
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

    public static com.baidu.tieba.a.a B() {
        return i;
    }

    public static String C() {
        if (i != null) {
            return i.b();
        }
        return null;
    }

    public static void b(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public int D() {
        int i2 = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        com.baidu.tieba.c.ag.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i2));
        return i2;
    }

    public void b(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i2);
        edit.commit();
    }

    public long E() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        com.baidu.tieba.c.ag.a("TiebaApplication", "getTDatabaseCreateTime", com.baidu.tieba.c.af.a(j));
        return j;
    }

    public void d(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("update_notify_time", j);
        edit.commit();
    }

    public long F() {
        return getSharedPreferences("settings", 0).getLong("update_notify_time", 0L);
    }

    public void g(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("update_dialog_version", str);
        edit.commit();
    }

    public String G() {
        return getSharedPreferences("settings", 0).getString("update_dialog_version", null);
    }

    public void H() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("tdatabasecreatetime", new Date().getTime());
        edit.commit();
    }

    public boolean I() {
        return D() > 50 && new Date().getTime() - E() > 2592000000L;
    }

    @Override // android.app.Application
    public void onTerminate() {
        if (this.as != null) {
            this.as.destroy();
            this.as = null;
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

    public String J() {
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
        com.baidu.tieba.c.ag.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String K() {
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

    public boolean L() {
        return this.j;
    }

    public int M() {
        return this.ag;
    }

    public void N() {
        d(MKEvent.ERROR_PERMISSION_DENIED);
        k(true);
        m(true);
        l(true);
    }

    public void h(boolean z) {
        this.am = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            e();
        } else {
            f();
        }
    }

    public boolean O() {
        return this.am;
    }

    public void i(boolean z) {
        if (this.ak != z) {
            this.ak = z;
        }
    }

    public boolean P() {
        return this.ak;
    }

    public void j(boolean z) {
        this.al = z;
    }

    public boolean Q() {
        return this.al;
    }

    public int R() {
        if (!this.ak && !this.al) {
            return 0;
        }
        if (this.ak && !this.al) {
            return 1;
        }
        if (!this.ak && this.al) {
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
        com.baidu.tieba.c.ag.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i2).toString());
        this.ag = i2;
        if (i2 == 0) {
            a(0L, 0L, 0L);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean S() {
        return this.ah;
    }

    public void k(boolean z) {
        this.ah = z;
        if (!z) {
            g(0L);
        }
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
        return this.ag > 0 && (this.aj || this.ai || this.ah);
    }

    public void W() {
        if (b().V()) {
            startService(new Intent(this, TiebaMessageService.class));
        }
    }

    public void X() {
        stopService(new Intent(this, TiebaMessageService.class));
    }

    public long Y() {
        return this.an;
    }

    public void e(long j) {
        if (j >= 0) {
            a(j, this.ao, this.ap);
        }
    }

    public long Z() {
        return this.ao;
    }

    public void f(long j) {
        if (j >= 0) {
            a(this.an, j, this.ap);
        }
    }

    public long aa() {
        return this.ap;
    }

    public void g(long j) {
        if (j >= 0) {
            a(this.an, this.ao, j);
        }
    }

    public void ab() {
        this.an = 0L;
        this.ao = 0L;
        this.ap = 0L;
    }

    public int ac() {
        return this.K;
    }

    public int ad() {
        return this.L;
    }

    public void e(int i2) {
        if (this.K != i2) {
            this.K = i2;
            getSharedPreferences("settings", 0).edit().putInt("image_quality", i2).commit();
        }
    }

    public void f(int i2) {
        if (this.L != i2) {
            this.L = i2;
            getSharedPreferences("settings", 0).edit().putInt("view_image_quality", i2).commit();
        }
    }

    public boolean ae() {
        return this.M;
    }

    public void n(boolean z) {
        if (this.M != z) {
            this.M = z;
            getSharedPreferences("settings", 0).edit().putBoolean("show_images", z).commit();
        }
    }

    public int af() {
        return this.N;
    }

    public void g(int i2) {
        if (this.N != i2) {
            this.N = i2;
            getSharedPreferences("settings", 0).edit().putInt("font_size", i2).commit();
        }
    }

    public void o(boolean z) {
        this.O = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    public boolean ag() {
        return this.O;
    }

    public void h(int i2) {
        AppsActivity.i();
        i(i2);
        getSharedPreferences("settings", 0).edit().putInt("skin", i2).commit();
        l(i2);
    }

    public void i(int i2) {
        this.P = i2;
    }

    private void l(int i2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i2);
        sendBroadcast(intent);
    }

    public int ah() {
        return this.P;
    }

    public int ai() {
        return this.V;
    }

    public void j(int i2) {
        this.V = i2;
        getSharedPreferences("settings", 0).edit().putInt("webview_crash_count", i2).commit();
    }

    public int aj() {
        return this.W;
    }

    public void k(int i2) {
        this.W = i2;
        getSharedPreferences("settings", 0).edit().putInt("new_vcode_webview_crash_count", i2).commit();
    }

    public void ak() {
        int i2 = getSharedPreferences("settings", 0).getInt("bd_loc_crash_count", 0) + 1;
        getSharedPreferences("settings", 0).edit().putInt("bd_loc_crash_count", i2).commit();
        if (i2 > 3) {
            a(false);
        }
    }

    public void a(bb bbVar) {
        this.y = bbVar;
    }

    public void a(long j, long j2, long j3) {
        if (j != this.an || j2 != this.ao || j3 != this.ap) {
            int i2 = 0;
            if (j > this.an || j2 > this.ao || j3 > this.ap) {
                i2 = 1;
            } else if (j < this.an || j2 < this.ao || j3 < this.ap) {
                i2 = 2;
            }
            this.an = j;
            this.ao = j2;
            this.ap = j3;
            aS();
            m(i2);
        }
    }

    private void m(int i2) {
        if (this.d != null) {
            try {
                if (i2 == 1) {
                    Notification notification = new Notification(R.drawable.icon, getString(R.string.notify_text), System.currentTimeMillis());
                    Intent intent = null;
                    StringBuffer stringBuffer = new StringBuffer();
                    if (this.an > 0 || this.ao > 0) {
                        stringBuffer.append(String.valueOf(this.an + this.ao));
                        stringBuffer.append(getString(R.string.notify_msg));
                    }
                    if (this.ap > 0) {
                        stringBuffer.append(String.valueOf(this.ap));
                        stringBuffer.append(getString(R.string.notify_fans));
                    }
                    if ((this.an > 0 || this.ao > 0) && this.ap > 0) {
                        intent = new Intent(this, PersonInfoActivity.class);
                        intent.putExtra("self", true);
                        intent.putExtra("tab_page", false);
                        intent.putExtra("tab_msg", true);
                        intent.putExtra("un", y());
                    } else if (this.an > 0 || this.ao > 0) {
                        intent = new Intent(this, MentionActivity.class);
                    } else if (this.ap > 0) {
                        intent = new Intent(this, PersonListActivity.class);
                        intent.putExtra("follow", false);
                        intent.putExtra("un", y());
                    }
                    if (intent != null) {
                        stringBuffer.append(getString(R.string.notify_click));
                        intent.setFlags(268435456);
                        notification.setLatestEventInfo(this, getString(R.string.app_name), stringBuffer, PendingIntent.getActivity(this, 0, intent, 0));
                        notification.defaults = -1;
                        notification.flags = 16;
                        notification.audioStreamType = 5;
                        if (!this.ak) {
                            notification.defaults &= -2;
                        }
                        if (!this.al) {
                            notification.defaults &= -3;
                        }
                        this.d.notify(R.drawable.icon, notification);
                    }
                } else if (i2 == 2) {
                    this.d.cancel(R.drawable.icon);
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    public void al() {
        if (this.d != null) {
            this.d.cancel(R.drawable.icon);
        }
    }

    public static boolean am() {
        return ad;
    }

    public static void p(boolean z) {
        ad = z;
    }

    private void aS() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", Y());
        intent.putExtra("at_me", Z());
        intent.putExtra("fans", aa());
        sendBroadcast(intent);
        com.baidu.tieba.c.ag.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(Y()), Long.valueOf(Z()), Long.valueOf(aa())));
    }

    public com.baidu.tieba.c.ac an() {
        return this.k;
    }

    public com.baidu.tieba.c.ab ao() {
        return this.l;
    }

    public com.baidu.tieba.c.ab ap() {
        return this.m;
    }

    public int aq() {
        switch (this.K) {
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
        this.v = System.currentTimeMillis();
    }

    public void as() {
        this.v = -1L;
    }

    public void at() {
        if (this.v > 0) {
            this.v = System.currentTimeMillis() - this.v;
            if (this.v > 0) {
                new com.baidu.tieba.account.ak("startup_time", String.valueOf(this.v));
            }
            com.baidu.tieba.c.ag.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.v));
        }
        this.v = -1L;
    }

    public void au() {
        this.s++;
        aT();
    }

    public void av() {
        this.s--;
        aT();
    }

    private void aT() {
        if (this.q) {
            if (this.s < 0) {
                this.s = 0;
            }
            if (this.t == 0 && this.s > 0) {
                this.t = System.nanoTime();
            }
            com.baidu.tieba.c.ag.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.s));
            this.c.removeMessages(4);
            if (this.s == 0 && this.t > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 180000L);
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
            this.F = (LocationManager) getSystemService(Headers.LOCATION);
            if (this.B) {
                this.D = new MyBDLocationListenner();
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName("tieba");
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(BdWebErrorView.ERROR_CODE_500);
                locationClientOption.disableCache(true);
                this.C = new LocationClient(getApplicationContext());
                this.C.registerLocationListener(this.D);
                this.C.setLocOption(locationClientOption);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public void aA() {
        try {
            if (this.G == null || System.currentTimeMillis() - this.a > 300000) {
                this.G = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.F != null) {
                    this.F.removeUpdates(this.aq);
                }
                if (this.B) {
                    if (!this.C.isStarted()) {
                        this.C.start();
                    }
                    this.C.requestLocation();
                }
                this.E = 4;
                if (this.F != null && !this.F.isProviderEnabled("gps") && !this.F.isProviderEnabled("network")) {
                    this.E = 3;
                    if (!this.B) {
                        this.c.sendMessageDelayed(this.c.obtainMessage(5), 100L);
                        return;
                    }
                }
                if (this.F != null && this.F.isProviderEnabled("gps")) {
                    m("gps");
                } else {
                    this.E = 1;
                }
                if (this.F != null && this.F.isProviderEnabled("network")) {
                    m("network");
                } else {
                    this.E = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), 60000L);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    private void m(String str) {
        if (this.F.isProviderEnabled(str)) {
            this.F.requestLocationUpdates(str, 10000L, 100.0f, this.aq);
        }
    }

    /* loaded from: classes.dex */
    public class MyBDLocationListenner implements BDLocationListener {
        public MyBDLocationListenner() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                TiebaApplication.this.E = 0;
                TiebaApplication.this.aB();
                TiebaApplication.this.G = new Address(Locale.getDefault());
                TiebaApplication.this.G.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.G.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.a = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    TiebaApplication.this.G.setAddressLine(0, stringBuffer.toString());
                }
                TiebaApplication.this.a(TiebaApplication.this.E, "", TiebaApplication.this.G);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public void aB() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.F != null) {
            this.F.removeUpdates(this.aq);
        }
        if (this.B && this.C != null && this.C.isStarted()) {
            this.C.stop();
        }
        if (this.H != null) {
            this.H.a();
        }
    }

    public Address aC() {
        return this.G;
    }

    public Address a(an anVar) {
        boolean z;
        if (this.G != null && System.currentTimeMillis() - this.a <= 300000) {
            return this.G;
        }
        if (anVar != null) {
            int i2 = 0;
            while (true) {
                if (i2 < this.I.size()) {
                    an anVar2 = (an) ((SoftReference) this.I.get(i2)).get();
                    if (anVar2 == null || !anVar2.equals(anVar)) {
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
                if (this.I.size() > 10) {
                    this.I.remove(0);
                }
                this.I.add(new SoftReference(anVar));
            }
            aA();
        }
        return null;
    }

    public void b(an anVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.I.size()) {
                SoftReference softReference = (SoftReference) this.I.get(i3);
                an anVar2 = (an) softReference.get();
                if (anVar2 == null || !anVar2.equals(anVar)) {
                    i2 = i3 + 1;
                } else {
                    this.I.remove(softReference);
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
        if (this.I != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.I.size()) {
                    an anVar = (an) ((SoftReference) this.I.get(i4)).get();
                    if (anVar != null) {
                        anVar.a(i2, str, address);
                    }
                    i3 = i4 + 1;
                } else {
                    this.I.clear();
                    return;
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        if (z2) {
            this.A |= 16;
            if (z) {
                this.A |= 32;
            }
        } else {
            this.A |= 256;
            if (z) {
                this.A |= 512;
            }
        }
        edit.putInt("check_network_confirm", this.A);
        edit.commit();
    }

    public int aD() {
        this.A = getSharedPreferences("settings", 0).getInt("check_network_confirm", 0);
        return this.A;
    }

    public int q(boolean z) {
        if (z) {
            if ((this.A & 16) == 0) {
                return -1;
            }
            return (this.A & 32) == 0 ? 0 : 1;
        } else if ((this.A & 256) != 0) {
            return (this.A & 512) == 0 ? 0 : 1;
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

    public long aE() {
        return this.u;
    }

    public void a(int i2, int i3, String str) {
        if (this.J == null) {
            this.J = Executors.newSingleThreadExecutor();
        }
        com.baidu.tieba.c.ag.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + HanziToPinyin.Token.SEPARATOR + "img_total" + i3);
        com.baidu.tieba.account.aj ajVar = new com.baidu.tieba.account.aj(i2, i3);
        ajVar.a(str);
        this.J.execute(ajVar);
    }

    public void a(com.baidu.tieba.a.c cVar) {
        this.z = cVar;
    }

    public com.baidu.tieba.a.c aF() {
        return this.z;
    }

    public boolean aG() {
        return this.ar;
    }

    public void r(boolean z) {
        this.ar = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aH() {
        if (b().aG()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(b().F()).longValue() > 86400000;
        }
        return false;
    }

    public BMapManager aI() {
        return this.as;
    }

    public boolean c(Context context) {
        boolean z = false;
        try {
            if (this.as == null) {
                this.as = new BMapManager(context);
            }
            if (this.as != null) {
                if (this.as.init(at, new ao())) {
                    z = true;
                }
            }
        } catch (Exception e) {
            this.as = null;
            com.baidu.tieba.c.ag.a(getClass().getName(), "initEngineManager", e.toString());
        }
        this.au = z;
        return z;
    }
}
