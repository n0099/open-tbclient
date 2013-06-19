package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import com.baidu.tieba.a.bg;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.service.MessagePullService;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.service.TiebaMessageService;
import com.baidu.video.download.JNITaskBuffer;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
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
/* loaded from: classes.dex */
public class TiebaApplication extends com.baidu.adp.a.b {
    private static TiebaApplication f;
    private LocationManager E;
    private SharedPreferences ag;
    private Boolean z;
    private static com.baidu.tieba.a.a i = null;
    private static String n = null;
    private static boolean o = false;
    private static boolean ah = false;
    private static Intent ai = null;
    private static String ay = "79A74DC064B49770ED928E44E679A79E86AD9B9A";
    private static final byte[] aA = new byte[0];
    private static volatile Boolean aB = null;
    private int e = 0;
    private HashMap g = null;
    private boolean h = true;
    private boolean j = false;
    private com.baidu.tieba.d.ab k = null;
    private com.baidu.tieba.d.ab l = null;
    private String m = null;
    private String p = null;
    private int q = 0;
    private long r = 0;
    private long s = 0;
    private long t = -1;
    private String u = null;
    private String v = null;
    private bg w = null;
    private com.baidu.tieba.a.c x = null;
    public long a = 0;
    private int y = -1;
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
    private boolean Q = false;
    private boolean R = true;
    private boolean S = false;
    private boolean T = false;
    private int U = 2;
    private boolean V = true;
    private int W = 0;
    private int X = 10;
    private int Y = 0;
    private boolean Z = false;
    private boolean aa = true;
    private int ab = 0;
    private long ac = 0;
    private long ad = 0;
    private boolean ae = false;
    private long af = 0;
    public ArrayList b = null;
    private Hashtable aj = null;
    public Handler c = new Handler(new aj(this));
    private int ak = 0;
    private boolean al = true;
    private boolean am = true;
    private boolean an = true;
    private boolean ao = true;
    private boolean ap = false;
    private boolean aq = true;
    private long ar = 0;
    private long as = 0;
    private long at = 0;
    private long au = 0;
    NotificationManager d = null;
    private final LocationListener av = new ak(this);
    private boolean aw = false;
    private BMapManager ax = null;
    private boolean az = false;

    public static void a(Intent intent) {
        ai = intent;
    }

    public static Intent c() {
        return ai;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        f = this;
        this.ag = getSharedPreferences("settings", 0);
        new aq(null).execute(new String[0]);
        com.baidu.tieba.a.i.r();
        com.baidu.tieba.d.w.e();
        aZ();
        ba();
        aV();
        aY();
        n = a((Context) this);
        aW();
        aX();
        com.baidu.tieba.a.i.d(this);
        com.baidu.tieba.a.i.b(this);
        com.baidu.tieba.a.i.c(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.d.af());
        } catch (SecurityException e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "onCreate", e.getMessage());
        }
        getContentResolver().registerContentObserver(Uri.parse("content://telephony/carriers"), true, new al(this, new Handler()));
        if (m()) {
            com.baidu.tbadk.a.e.a().a(50, com.baidu.tieba.a.i.d());
            com.baidu.tbadk.a.a.a().a(this, new com.baidu.tieba.d.n());
            aN();
            this.g = new HashMap();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                i = com.baidu.tieba.d.k.n();
            }
            if (j()) {
                a.a(this);
            } else {
                com.baidu.tieba.account.a.a().a(this);
            }
            com.baidu.tieba.d.k.v();
            g();
            this.k = new com.baidu.tieba.d.ab(MKEvent.ERROR_PERMISSION_DENIED);
            this.l = new com.baidu.tieba.d.ab(100);
            this.d = (NotificationManager) getSystemService("notification");
            new com.baidu.tieba.account.af("open").start();
            if (S()) {
                h();
            }
            if (aq()) {
                new com.baidu.tieba.account.af("frs_abstract", "1").start();
            }
            bg();
            this.H = new ArrayList();
            ak();
            new com.baidu.tieba.a.a.a().a();
        } else {
            this.b = new ArrayList();
        }
        try {
            registerReceiver(new com.baidu.tieba.service.g(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e2) {
            com.baidu.adp.lib.e.b.a(e2.getMessage());
        }
    }

    public boolean d() {
        boolean z = false;
        String str = Build.MODEL;
        if (str == null) {
            return true;
        }
        String[] strArr = {"M040", "M032", "M031", "M030", "HUAWEI C8813", "ZTE U970", "MediaPad 10 FHD", "GT-I9000", "DOEASY E930", "H8205"};
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                if (strArr[i2].equalsIgnoreCase(str)) {
                    break;
                }
                i2++;
            } else {
                z = true;
                break;
            }
        }
        if (com.baidu.adp.lib.e.b.a()) {
            com.baidu.adp.lib.e.b.b("device:[" + str + "], default GPU on:" + z);
        }
        return z;
    }

    public static TiebaApplication e() {
        return f;
    }

    public void a(String str) {
        this.p = str;
    }

    public String f() {
        return this.p;
    }

    public boolean b(String str) {
        return (this.aj == null || str == null || !this.aj.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.aj != null && str != null) {
            this.aj.put(str, 1);
            new com.baidu.tieba.d.p(1, str).start();
        }
    }

    public void d(String str) {
        if (b(str) && this.aj != null && str != null) {
            this.aj.remove(str);
            new com.baidu.tieba.d.p(2, str).start();
        }
    }

    public void g() {
        this.aj = new Hashtable();
        new com.baidu.tieba.d.p(this.aj).start();
    }

    public void h() {
        startService(new Intent(this, MessagePullService.class));
    }

    public void i() {
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

    private void aV() {
        if (Build.VERSION.SDK_INT >= 5) {
            o = new AccountProxy(this).hasBaiduAccount();
        } else {
            o = false;
        }
    }

    public static boolean j() {
        return o;
    }

    private void aW() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.m = telephonyManager.getDeviceId();
        }
    }

    private void aX() {
        if (this.v == null || this.v.length() < 0) {
            this.v = CommonParam.getCUID(this);
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("cuid", this.v);
            edit.commit();
        }
    }

    public String k() {
        return this.v;
    }

    public String l() {
        return this.m;
    }

    public boolean m() {
        boolean z = false;
        if (this.z != null) {
            return this.z.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        int myPid = Process.myPid();
        if (runningAppProcesses != null) {
            this.z = Boolean.TRUE;
            int i2 = 0;
            while (true) {
                if (i2 >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i2).pid != myPid) {
                    i2++;
                } else {
                    String str = runningAppProcesses.get(i2).processName;
                    if (str != null && (str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1") || str.equalsIgnoreCase("com.baidu.tieba:remote"))) {
                        this.z = Boolean.FALSE;
                    }
                }
            }
        }
        z = true;
        return z;
    }

    private void aY() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
        this.J = sharedPreferences.getInt("image_quality", 2);
        this.K = sharedPreferences.getInt("view_image_quality", 2);
        this.L = sharedPreferences.getBoolean("show_images", true);
        this.M = sharedPreferences.getInt("font_size", 2);
        this.aq = sharedPreferences.getBoolean("permoted_message", true);
        this.h = sharedPreferences.getBoolean("display_photo", true);
        this.N = sharedPreferences.getBoolean("abstract_state", true);
        this.O = sharedPreferences.getInt("skin", 0);
        this.s = sharedPreferences.getLong("message_id", 0L);
        this.S = sharedPreferences.getBoolean("gpu_open", d());
        this.R = sharedPreferences.getBoolean("motu_on", true);
        this.T = sharedPreferences.getBoolean("app_switcher", false);
        this.U = sharedPreferences.getInt("browser_type", 2);
        this.Z = sharedPreferences.getBoolean("manage_mode", false);
        this.P = sharedPreferences.getBoolean("location_on", true);
        this.ac = sharedPreferences.getLong("refresh_recommend_time", 0L);
        this.ad = sharedPreferences.getLong("refresh_guess_time", 0L);
        this.Q = sharedPreferences.getBoolean("open_local_popularize", false);
        this.ae = sharedPreferences.getBoolean("local_app_has_showed_in_nearby", false);
        this.ab = sharedPreferences.getInt("guide_page_bits", 0);
        if (aG()) {
            this.ab = 0;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("guide_page_bits", this.ab);
            edit.commit();
        }
        this.u = sharedPreferences.getString("show_all_like_items", null);
        this.W = sharedPreferences.getInt("webview_crash_count", 0);
        this.Y = sharedPreferences.getInt("new_vcode_webview_crash_count", 0);
        this.A = sharedPreferences.getBoolean("bd_loc_switcher", true);
        this.aa = sharedPreferences.getBoolean("search_mode", true);
        this.af = sharedPreferences.getLong("show_nearby_guide_time", 0L);
        this.v = sharedPreferences.getString("cuid", null);
        this.X = sharedPreferences.getInt("perform_sample_count", 0);
        if (Build.VERSION.SDK_INT <= 4) {
            this.A = false;
        }
    }

    public int n() {
        return this.U;
    }

    public void a(int i2) {
        if (this.U != i2) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putInt("browser_type", i2);
            edit.commit();
            this.U = i2;
        }
    }

    public void a(boolean z) {
        this.A = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("bd_loc_switcher", this.A);
        edit.commit();
    }

    public void b(boolean z) {
        this.aa = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("search_mode", this.aa);
        edit.commit();
    }

    public boolean o() {
        return this.aa;
    }

    public boolean p() {
        return this.V;
    }

    public void c(boolean z) {
        this.V = z;
    }

    public boolean q() {
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
        this.R = z;
    }

    public boolean r() {
        return this.R;
    }

    public void f(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("gpu_open", z);
        edit.commit();
        this.S = z;
    }

    public boolean s() {
        return this.S;
    }

    public void g(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.T = z;
    }

    public boolean t() {
        return this.T;
    }

    public void u() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("show_all_like_items", com.baidu.tieba.a.i.i());
        edit.commit();
        this.u = com.baidu.tieba.a.i.i();
    }

    public String v() {
        return this.u;
    }

    private void aZ() {
        try {
            com.baidu.tieba.a.i.b(getPackageManager().getPackageInfo("com.baidu.tieba", JNITaskBuffer.BufferSize).versionName);
            if (com.baidu.tieba.a.i.i() == null) {
                com.baidu.tieba.a.i.b("");
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "InitVersion", e.getMessage());
            com.baidu.tieba.a.i.b("");
        }
    }

    private void ba() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String bb = bb();
                if (bb == null) {
                    String bc = bc();
                    if (bc != null && bc.length() > 0) {
                        com.baidu.tieba.a.i.a(bc);
                        k(bc);
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
                    com.baidu.tieba.a.i.a(bb);
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

    private String bb() {
        return getSharedPreferences("settings", 0).getString("from_id", null);
    }

    private void k(String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("from_id", str);
            edit.commit();
        }
    }

    private String bc() {
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

    public static String w() {
        return com.baidu.tieba.a.i.a();
    }

    public void x() {
        a(0L, 0L, 0L, 0L);
        com.baidu.tieba.d.k.v();
    }

    public com.baidu.adp.widget.a.b e(String str) {
        SoftReference softReference = (SoftReference) this.g.get(str);
        if (softReference != null && softReference.get() != null) {
            return (com.baidu.adp.widget.a.b) softReference.get();
        }
        com.baidu.adp.widget.a.b a = com.baidu.tbadk.a.a.a().a(str);
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

    public boolean y() {
        return this.h;
    }

    public boolean b(int i2) {
        return i2 < 0 || i2 >= 32 || ((1 << i2) & this.ab) != 0;
    }

    public void c(int i2) {
        if (i2 >= 0 && i2 < 32) {
            this.ab = (1 << i2) | this.ab;
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putInt("guide_page_bits", this.ab);
            edit.commit();
        }
    }

    public void a(long j) {
        this.af = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("show_nearby_guide_time", j);
        edit.commit();
    }

    public long z() {
        return this.af;
    }

    public void b(long j) {
        this.ac = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public long A() {
        return this.ac;
    }

    public void h(boolean z) {
        this.ae = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("local_app_has_showed_in_nearby", z);
        edit.commit();
    }

    public boolean B() {
        return this.ae;
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

    public static String C() {
        if (i != null) {
            com.baidu.tieba.d.ae.a("TiebaApplication", "getCurrentAccount", String.valueOf(i.a()));
            return i.a();
        }
        return null;
    }

    public static void a(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public static String D() {
        if (i != null) {
            return i.d();
        }
        return null;
    }

    public static String E() {
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

    public static com.baidu.tieba.a.a F() {
        return i;
    }

    public static String G() {
        if (i != null) {
            return i.b();
        }
        return null;
    }

    public static void b(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    public int H() {
        int i2 = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        com.baidu.tieba.d.ae.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i2));
        return i2;
    }

    public void d(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i2);
        edit.commit();
    }

    public long I() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        com.baidu.tieba.d.ae.a("TiebaApplication", "getTDatabaseCreateTime", com.baidu.tieba.d.ad.a(j));
        return j;
    }

    public void c(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("update_notify_time", j);
        edit.commit();
    }

    public long J() {
        return getSharedPreferences("settings", 0).getLong("update_notify_time", 0L);
    }

    public void g(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("update_dialog_version", str);
        edit.commit();
    }

    public String K() {
        return getSharedPreferences("settings", 0).getString("update_dialog_version", null);
    }

    public void L() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("tdatabasecreatetime", new Date().getTime());
        edit.commit();
    }

    public boolean M() {
        return H() > 50 && new Date().getTime() - I() > 2592000000L;
    }

    @Override // android.app.Application
    public void onTerminate() {
        if (this.ax != null) {
            this.ax.destroy();
            this.ax = null;
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

    public String N() {
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
                if (com.baidu.tieba.a.i.i().equals(string.substring(0, indexOf))) {
                    str = string.substring(indexOf + 1);
                } else {
                    b((Context) e());
                }
            } else {
                b((Context) e());
            }
        } else {
            str = string;
        }
        com.baidu.tieba.d.ae.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String O() {
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
            edit.putString("client_id", String.valueOf(com.baidu.tieba.a.i.i()) + "\t" + str);
            edit.commit();
        }
    }

    public static void i(String str) {
        n = str;
    }

    public void i(boolean z) {
        this.j = z;
    }

    public boolean P() {
        return this.j;
    }

    public int Q() {
        return this.ak;
    }

    public void R() {
        f(MKEvent.ERROR_PERMISSION_DENIED);
        m(true);
        o(true);
        n(true);
    }

    public void j(boolean z) {
        this.aq = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            h();
        } else {
            i();
        }
    }

    public boolean S() {
        return this.aq;
    }

    public void k(boolean z) {
        if (this.ao != z) {
            this.ao = z;
        }
    }

    public boolean T() {
        return this.ao;
    }

    public void l(boolean z) {
        this.ap = z;
    }

    public boolean U() {
        return this.ap;
    }

    public int V() {
        if (!this.ao && !this.ap) {
            return 0;
        }
        if (this.ao && !this.ap) {
            return 1;
        }
        if (!this.ao && this.ap) {
            return 2;
        }
        return 3;
    }

    public void e(int i2) {
        if (i2 == 0) {
            e().k(false);
            e().l(false);
        } else if (i2 == 1) {
            e().k(true);
            e().l(false);
        } else if (i2 == 2) {
            e().k(false);
            e().l(true);
        } else {
            e().k(true);
            e().l(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r10v0 int)] */
    public void f(int i2) {
        com.baidu.tieba.d.ae.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i2).toString());
        this.ak = i2;
        if (i2 == 0) {
            a(0L, 0L, 0L, 0L);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean W() {
        return this.al;
    }

    public void m(boolean z) {
        this.al = z;
        if (!z) {
            f(0L);
        }
    }

    public boolean X() {
        return this.am;
    }

    public void n(boolean z) {
        this.am = z;
        if (!z) {
            e(0L);
        }
    }

    public boolean Y() {
        return this.an;
    }

    public void o(boolean z) {
        this.an = z;
        if (!z) {
            d(0L);
        }
    }

    public boolean Z() {
        return this.ak > 0;
    }

    public void aa() {
        if (e().Z()) {
            startService(new Intent(this, TiebaMessageService.class));
        }
    }

    public void ab() {
        stopService(new Intent(this, TiebaMessageService.class));
    }

    public long ac() {
        return this.ar;
    }

    public void d(long j) {
        if (j >= 0) {
            a(j, this.as, this.at, this.au);
        }
    }

    public long ad() {
        return this.as;
    }

    public void e(long j) {
        if (j >= 0) {
            a(this.ar, j, this.at, this.au);
        }
    }

    public long ae() {
        return this.at;
    }

    public void f(long j) {
        if (j >= 0) {
            a(this.ar, this.as, j, this.au);
        }
    }

    public long af() {
        return this.au;
    }

    public void ag() {
        this.ar = 0L;
        this.as = 0L;
        this.at = 0L;
        this.au = 0L;
    }

    protected void a(String str, boolean z) {
        try {
            SharedPreferences.Editor edit = this.ag.edit();
            edit.putBoolean(str, z);
            edit.commit();
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.b.a()) {
                com.baidu.adp.lib.e.b.a("failed to saveBoolean:" + str + ", " + th.getMessage());
            }
        }
    }

    protected void a(String str, int i2) {
        try {
            SharedPreferences.Editor edit = this.ag.edit();
            edit.putInt(str, i2);
            edit.commit();
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.b.a()) {
                com.baidu.adp.lib.e.b.a("failed to saveInt:" + str + ", " + th.getMessage());
            }
        }
    }

    public boolean ah() {
        return this.ag.getBoolean("alert_sign_on", true);
    }

    public void p(boolean z) {
        a("alert_sign_on", z);
        ak();
    }

    public int ai() {
        int i2 = this.ag.getInt("alert_sign_hours", -1);
        if (i2 == -1) {
            bd();
            return this.ag.getInt("alert_sign_hours", 12);
        }
        return i2;
    }

    private void bd() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int aj() {
        int i2 = this.ag.getInt("alert_sign_mins", -1);
        if (i2 == -1) {
            bd();
            return this.ag.getInt("alert_sign_mins", 30);
        }
        return i2;
    }

    public void a(int i2, int i3) {
        a("alert_sign_hours", i2);
        a("alert_sign_mins", i3);
        ak();
    }

    public void ak() {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent al = al();
        if (ah()) {
            Calendar calendar = Calendar.getInstance();
            int ai2 = ai();
            int i2 = calendar.get(11);
            int aj = aj();
            int i3 = calendar.get(12);
            calendar.set(11, ai2);
            calendar.set(12, aj);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i2 >= ai2 && (i2 != ai2 || i3 >= aj)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this, 0, al, 268435456));
            if (com.baidu.adp.lib.e.b.a()) {
                com.baidu.adp.lib.e.b.c("sign-alert alarm set to :" + com.baidu.tieba.d.ad.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, al, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.e.b.a()) {
                com.baidu.adp.lib.e.b.c("sign-alert alarm cancelled.");
            }
        }
    }

    protected Intent al() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.signalert");
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(this, SignAlertReceiver.class);
        return intent;
    }

    public int am() {
        return this.J;
    }

    public int an() {
        return this.K;
    }

    public void g(int i2) {
        if (this.J != i2) {
            this.J = i2;
            getSharedPreferences("settings", 0).edit().putInt("image_quality", i2).commit();
        }
    }

    public void h(int i2) {
        if (this.K != i2) {
            this.K = i2;
            getSharedPreferences("settings", 0).edit().putInt("view_image_quality", i2).commit();
        }
    }

    public boolean ao() {
        return this.L;
    }

    public void q(boolean z) {
        if (this.L != z) {
            this.L = z;
            getSharedPreferences("settings", 0).edit().putBoolean("show_images", z).commit();
        }
    }

    public int ap() {
        return this.M;
    }

    public void i(int i2) {
        if (this.M != i2) {
            this.M = i2;
            getSharedPreferences("settings", 0).edit().putInt("font_size", i2).commit();
        }
    }

    public void r(boolean z) {
        this.N = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    public boolean aq() {
        return this.N;
    }

    public void s(boolean z) {
        this.Q = z;
        getSharedPreferences("settings", 0).edit().putBoolean("open_local_popularize", z).commit();
    }

    public boolean ar() {
        return this.Q;
    }

    public void j(int i2) {
        AppsActivity.b();
        k(i2);
        getSharedPreferences("settings", 0).edit().putInt("skin", i2).commit();
        o(i2);
    }

    public void k(int i2) {
        this.O = i2;
    }

    private void o(int i2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i2);
        sendBroadcast(intent);
    }

    public int as() {
        return this.O;
    }

    public int at() {
        return this.W;
    }

    public void l(int i2) {
        this.W = i2;
        getSharedPreferences("settings", 0).edit().putInt("webview_crash_count", i2).commit();
    }

    public int au() {
        return this.X;
    }

    public void m(int i2) {
        this.X = i2;
        getSharedPreferences("settings", 0).edit().putInt("perform_sample_count", i2).commit();
    }

    public int av() {
        return this.Y;
    }

    public void n(int i2) {
        this.Y = i2;
        getSharedPreferences("settings", 0).edit().putInt("new_vcode_webview_crash_count", i2).commit();
    }

    public void aw() {
        int i2 = getSharedPreferences("settings", 0).getInt("bd_loc_crash_count", 0) + 1;
        getSharedPreferences("settings", 0).edit().putInt("bd_loc_crash_count", i2).commit();
        if (i2 > 3) {
            a(false);
        }
    }

    public void a(bg bgVar) {
        this.w = bgVar;
    }

    public void a(long j, long j2, long j3, long j4) {
        if (j != this.ar || j2 != this.as || j3 != this.at || j4 != this.au) {
            int i2 = 0;
            if (j > this.ar || j2 > this.as || j3 > this.at || j4 > this.au) {
                i2 = 1;
            } else if (j < this.ar || j2 < this.as || j3 < this.at || j4 < this.au) {
                i2 = 2;
            }
            this.ar = j;
            this.as = j2;
            this.at = j3;
            this.au = j4;
            be();
            p(i2);
        }
    }

    public void b(long j, long j2, long j3, long j4) {
        if (j != this.ar || j2 != this.as || j3 != this.at || j4 != this.au) {
            this.ar = j;
            this.as = j2;
            this.at = j3;
            this.au = j4;
            be();
        }
    }

    private void p(int i2) {
        Intent intent;
        if (this.d != null) {
            try {
                if (i2 == 1) {
                    Notification notification = new Notification(R.drawable.icon, getString(R.string.notify_text), System.currentTimeMillis());
                    StringBuffer stringBuffer = new StringBuffer();
                    if (this.ar > 0 || this.as > 0) {
                        stringBuffer.append(String.valueOf(this.ar + this.as));
                        stringBuffer.append(getString(R.string.notify_msg));
                    }
                    if (this.at > 0) {
                        stringBuffer.append(String.valueOf(this.at));
                        stringBuffer.append(getString(R.string.notify_fans));
                    }
                    if (this.au > 0) {
                        stringBuffer.append(String.valueOf(this.au));
                        stringBuffer.append(getString(R.string.notify_chat));
                    }
                    if (this.at != 0 || this.ar != 0 || this.as != 0 || this.au != 0) {
                        if ((this.ar > 0 || this.as > 0) && this.at == 0 && this.au == 0) {
                            intent = new Intent(this, MentionActivity.class);
                        } else if (this.at > 0 && this.ar == 0 && this.as == 0 && this.au == 0) {
                            intent = new Intent(this, PersonListActivity.class);
                            intent.putExtra("follow", false);
                            intent.putExtra("un", C());
                        } else if (this.au > 0 && this.at == 0 && this.ar == 0 && this.as == 0) {
                            intent = new Intent(this, ChatListActivity.class);
                        } else {
                            intent = new Intent(this, PersonInfoActivity.class);
                            intent.putExtra("self", true);
                            intent.putExtra("tab_page", false);
                            intent.putExtra("tab_msg", true);
                            intent.putExtra("un", C());
                        }
                        stringBuffer.append(getString(R.string.notify_click));
                        intent.setFlags(268435456);
                        notification.setLatestEventInfo(this, getString(R.string.app_name), stringBuffer, PendingIntent.getActivity(this, 0, intent, 0));
                        notification.defaults = -1;
                        notification.flags = 16;
                        notification.audioStreamType = 5;
                        if (!this.ao) {
                            notification.defaults &= -2;
                        }
                        if (!this.ap) {
                            notification.defaults &= -3;
                        }
                        this.d.notify(11, notification);
                    }
                } else if (i2 == 2) {
                    this.d.cancel(11);
                }
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    public void ax() {
        if (this.d != null) {
            this.d.cancel(11);
        }
    }

    public static boolean ay() {
        return ah;
    }

    public static void t(boolean z) {
        ah = z;
    }

    private void be() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", ac());
        intent.putExtra("at_me", ad());
        intent.putExtra("fans", ae());
        intent.putExtra("pletter", af());
        sendBroadcast(intent);
        com.baidu.tieba.d.ae.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(ac()), Long.valueOf(ad()), Long.valueOf(ae())));
    }

    public com.baidu.tieba.d.ab az() {
        return this.k;
    }

    public int aA() {
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

    public void aB() {
        this.t = System.currentTimeMillis();
    }

    public void aC() {
        this.t = -1L;
    }

    public void aD() {
        if (this.t > 0) {
            this.t = System.currentTimeMillis() - this.t;
            if (this.t > 0) {
                new com.baidu.tieba.account.af("startup_time", String.valueOf(this.t));
            }
            com.baidu.tieba.d.ae.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.t));
        }
        this.t = -1L;
    }

    public void aE() {
        this.q++;
        bf();
    }

    public void aF() {
        this.q--;
        bf();
    }

    private void bf() {
        if (m()) {
            if (this.q < 0) {
                this.q = 0;
            }
            if (this.r == 0 && this.q > 0) {
                this.r = System.nanoTime();
            }
            com.baidu.tieba.d.ae.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.q));
            this.c.removeMessages(4);
            if (this.q == 0 && this.r > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 60000L);
            }
        }
    }

    public boolean aG() {
        return !getSharedPreferences("settings", 0).getString("lase_version", "").equals(com.baidu.tieba.a.i.i());
    }

    public void aH() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("lase_version", com.baidu.tieba.a.i.i());
        edit.commit();
    }

    public void aI() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.remove("account_share");
        edit.commit();
    }

    public String aJ() {
        return getSharedPreferences("settings", 0).getString("account_share", null);
    }

    public void j(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("account_share", str);
        edit.commit();
    }

    private void bg() {
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

    public void aK() {
        try {
            if (this.F == null || System.currentTimeMillis() - this.a > 300000) {
                this.F = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.E != null) {
                    this.E.removeUpdates(this.av);
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
            this.E.requestLocationUpdates(str, 10000L, 100.0f, this.av);
        }
    }

    public void aL() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.E != null) {
            this.E.removeUpdates(this.av);
        }
        if (this.A && this.B != null && this.B.c()) {
            this.B.e();
        }
        if (this.G != null) {
            this.G.cancel();
        }
    }

    public Address aM() {
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
            aK();
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

    public int aN() {
        this.y = getSharedPreferences("settings", 0).getInt("check_network_confirm", 0);
        return this.y;
    }

    public int u(boolean z) {
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
        this.s = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("message_id", j);
        edit.commit();
    }

    public long aO() {
        return this.s;
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
        this.x = cVar;
    }

    public com.baidu.tieba.a.c aP() {
        return this.x;
    }

    public boolean aQ() {
        return this.aw;
    }

    public void v(boolean z) {
        this.aw = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aR() {
        if (e().aQ()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(e().J()).longValue() > 86400000;
        }
        return false;
    }

    public BMapManager aS() {
        return this.ax;
    }

    public boolean c(Context context) {
        boolean z = false;
        try {
            if (this.ax == null) {
                this.ax = new BMapManager(context);
            }
            if (this.ax != null) {
                if (this.ax.init(ay, new ao())) {
                    z = true;
                }
            }
        } catch (Exception e) {
            this.ax = null;
            com.baidu.tieba.d.ae.a(getClass().getName(), "initEngineManager", e.toString());
        }
        this.az = z;
        return z;
    }

    public static boolean aT() {
        synchronized (aA) {
            if (aB == null) {
                try {
                    aA.wait();
                } catch (Exception e) {
                    com.baidu.adp.lib.e.b.a(e.getMessage());
                }
            }
            if (aB != null) {
                return aB.booleanValue();
            }
            return false;
        }
    }
}
