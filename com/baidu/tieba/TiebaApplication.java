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
import android.text.TextUtils;
import com.baidu.account.AccountProxy;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.android.common.util.CommonParam;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.service.MessagePullService;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.service.TiebaMessageService;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.video.download.JNITaskBuffer;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
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
    private static TiebaApplication f;
    private LocationManager E;
    private SharedPreferences aj;
    private boolean an;
    private String ao;
    private Boolean z;
    private static AccountData i = null;
    private static String n = null;
    private static boolean o = false;
    private static boolean ak = false;
    private static Intent al = null;
    private static final byte[] aD = new byte[0];
    private static volatile Boolean aE = null;
    private int e = 0;
    private HashMap g = null;
    private boolean h = true;
    private boolean j = false;
    private com.baidu.tieba.util.z k = null;
    private com.baidu.tieba.util.z l = null;
    private String m = null;
    private String p = null;
    private int q = 0;
    private long r = 0;
    private long s = 0;
    private long t = -1;
    private String u = null;
    private String v = null;
    private VersionData w = null;
    private BannerData x = null;

    /* renamed from: a  reason: collision with root package name */
    public long f824a = 0;
    private int y = 0;
    private boolean A = true;
    private LocationClient B = null;
    private BDLocationListener C = null;
    private int D = 0;
    private Address F = null;
    private aw G = null;
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
    private boolean T = true;
    private boolean U = false;
    private boolean V = false;
    private int W = 2;
    private boolean X = true;
    private com.baidu.adp.lib.cache.q Y = null;
    private int Z = 0;
    private int aa = 10;
    private int ab = 0;
    private boolean ac = false;
    private boolean ad = true;
    private int ae = 0;
    private long af = 0;
    private long ag = 0;
    private boolean ah = false;
    private long ai = 0;
    public ArrayList b = null;
    private Hashtable am = null;
    private Hashtable ap = null;
    public Handler c = new Handler(new as(this));
    private int aq = 0;
    private boolean ar = true;
    private boolean as = true;
    private boolean at = true;
    private boolean au = true;
    private boolean av = false;
    private boolean aw = true;
    private long ax = 0;
    private long ay = 0;
    private long az = 0;
    private long aA = 0;
    NotificationManager d = null;
    private final LocationListener aB = new at(this);
    private boolean aC = false;

    public static void a(Intent intent) {
        al = intent;
    }

    public static Intent d() {
        return al;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        f = this;
        this.aj = getSharedPreferences("settings", 0);
        new ax(null).execute(new String[0]);
        NetWorkCore.l();
        bs();
        bt();
        bo();
        br();
        com.baidu.tieba.util.ap.a(this);
        n = a((Context) this);
        bp();
        bq();
        j();
        com.baidu.tieba.data.g.d(this);
        com.baidu.tieba.data.g.b(this);
        com.baidu.tieba.data.g.c(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.util.al());
        } catch (SecurityException e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "onCreate", e.getMessage());
        }
        getContentResolver().registerContentObserver(Uri.parse("content://telephony/carriers"), true, new au(this, new Handler()));
        if (q()) {
            com.baidu.tbadk.a.e.a().a(50, com.baidu.tieba.data.g.d());
            com.baidu.adp.lib.c.c.a().a(com.baidu.tieba.util.a.d.a());
            com.baidu.tbadk.a.a.a().a(this, new com.baidu.tieba.util.o());
            aU();
            this.g = new HashMap();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                i = DatabaseService.p();
            }
            if (n()) {
                c.a(this);
            } else {
                com.baidu.tieba.account.a.a().b(this);
            }
            DatabaseService.x();
            k();
            this.k = new com.baidu.tieba.util.z(300);
            this.l = new com.baidu.tieba.util.z(100);
            this.d = (NotificationManager) getSystemService("notification");
            new com.baidu.tieba.account.ag("open").start();
            if (U()) {
                l();
            }
            if (as()) {
                new com.baidu.tieba.account.ag("frs_abstract", "1").start();
            }
            bz();
            this.H = new ArrayList();
            am();
            new com.baidu.tieba.data.a.a().a();
        } else {
            this.b = new ArrayList();
        }
        try {
            registerReceiver(new com.baidu.tieba.service.g(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e2) {
            com.baidu.adp.lib.e.d.a(e2.getMessage());
        }
        com.baidu.tieba.util.ak.a(this);
    }

    public boolean e() {
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
        if (com.baidu.adp.lib.e.d.a()) {
            com.baidu.adp.lib.e.d.b("device:[" + str + "], default GPU on:" + z);
        }
        return z;
    }

    public static TiebaApplication f() {
        return f;
    }

    public void a(String str) {
        this.p = str;
    }

    public String g() {
        return this.p;
    }

    public boolean b(String str) {
        return (this.ap == null || str == null || !this.ap.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.ap != null && str != null) {
            if (this.ap.size() > 100) {
                this.ap.clear();
            }
            this.ap.put(str, 1);
        }
    }

    public void h() {
        if (this.ap != null) {
            this.ap.clear();
        }
    }

    public int i() {
        if (this.ap != null) {
            return this.ap.size();
        }
        return 0;
    }

    public void j() {
        if (this.ap == null) {
            this.ap = new Hashtable();
        }
    }

    public boolean d(String str) {
        return (this.am == null || str == null || !this.am.containsKey(str)) ? false : true;
    }

    public void e(String str) {
        if (!d(str) && this.am != null && str != null) {
            this.am.put(str, 1);
            new com.baidu.tieba.util.q(1, str).start();
        }
    }

    public void f(String str) {
        if (d(str) && this.am != null && str != null) {
            this.am.remove(str);
            new com.baidu.tieba.util.q(2, str).start();
        }
    }

    public void k() {
        this.am = new Hashtable();
        new com.baidu.tieba.util.q(this.am).start();
    }

    public void l() {
        try {
            startService(new Intent(this, MessagePullService.class));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "startPullMessageService", e.toString());
        }
    }

    public void m() {
        stopService(new Intent(this, MessagePullService.class));
    }

    public void a(g gVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ((g) this.b.get(i2)).a_();
                } catch (Exception e) {
                    com.baidu.tieba.util.aj.b(getClass().getName(), "addRemoteActivity", e.getMessage());
                }
            }
            if (gVar != null) {
                this.b.add(gVar);
            }
        }
    }

    public void b(g gVar) {
        if (this.b != null) {
            this.b.remove(gVar);
        }
    }

    private void bo() {
        if (Build.VERSION.SDK_INT >= 5) {
            o = new AccountProxy(this).hasBaiduAccount();
        } else {
            o = false;
        }
    }

    public static boolean n() {
        return o;
    }

    private void bp() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.m = telephonyManager.getDeviceId();
        }
    }

    private void bq() {
        if (this.v == null || this.v.length() < 0) {
            this.v = CommonParam.getCUID(this);
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("cuid", this.v);
            edit.commit();
        }
    }

    public String o() {
        return this.v;
    }

    public String p() {
        return this.m;
    }

    public boolean q() {
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
                    if (str != null && (str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1") || str.equalsIgnoreCase("com.baidu.tieba:remote") || str.equalsIgnoreCase("com.baidu.tieba:bdservice_v1"))) {
                        this.z = Boolean.FALSE;
                    }
                }
            }
        }
        z = true;
        return z;
    }

    private void br() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
        this.J = sharedPreferences.getInt("image_quality", 2);
        this.K = sharedPreferences.getInt("view_image_quality", 2);
        this.L = sharedPreferences.getBoolean("show_images", true);
        this.M = sharedPreferences.getInt("font_size", 2);
        this.aw = sharedPreferences.getBoolean("permoted_message", true);
        this.h = sharedPreferences.getBoolean("display_photo", true);
        this.N = sharedPreferences.getBoolean("abstract_state", true);
        this.O = sharedPreferences.getInt("skin", 0);
        this.s = sharedPreferences.getLong("message_id", 0L);
        this.U = sharedPreferences.getBoolean("gpu_open", e());
        this.T = sharedPreferences.getBoolean("motu_on", true);
        this.V = sharedPreferences.getBoolean("app_switcher", false);
        this.W = sharedPreferences.getInt("browser_type", 2);
        this.ac = sharedPreferences.getBoolean("manage_mode", false);
        this.P = sharedPreferences.getBoolean("location_on", true);
        this.af = sharedPreferences.getLong("refresh_recommend_time", 0L);
        this.ag = sharedPreferences.getLong("refresh_guess_time", 0L);
        this.Q = sharedPreferences.getBoolean("open_local_popularize", false);
        this.ah = sharedPreferences.getBoolean("local_app_has_showed_in_nearby", false);
        this.ae = sharedPreferences.getInt("guide_page_bits", 0);
        if (aL()) {
            this.ae = 0;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("guide_page_bits", this.ae);
            edit.commit();
        }
        this.u = sharedPreferences.getString("show_all_like_items", null);
        this.Z = sharedPreferences.getInt("webview_crash_count", 0);
        this.ab = sharedPreferences.getInt("new_vcode_webview_crash_count", 0);
        this.A = sharedPreferences.getBoolean("bd_loc_switcher", true);
        this.ad = sharedPreferences.getBoolean("search_mode", true);
        this.ai = sharedPreferences.getLong("show_nearby_guide_time", 0L);
        this.v = sharedPreferences.getString("cuid", null);
        this.aa = sharedPreferences.getInt("perform_sample_count", 0);
        if (Build.VERSION.SDK_INT <= 4) {
            this.A = false;
        }
        this.ao = sharedPreferences.getString("last_recommend_time", "");
    }

    public int r() {
        return this.W;
    }

    public void a(int i2) {
        if (this.W != i2) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putInt("browser_type", i2);
            edit.commit();
            this.W = i2;
        }
    }

    public void a(boolean z) {
        this.A = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("bd_loc_switcher", this.A);
        edit.commit();
    }

    public void b(boolean z) {
        this.ad = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("search_mode", this.ad);
        edit.commit();
    }

    public boolean s() {
        return this.ad;
    }

    public boolean t() {
        return this.X;
    }

    public void c(boolean z) {
        this.X = z;
    }

    public boolean u() {
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
        this.T = z;
    }

    public boolean v() {
        return this.T;
    }

    public void f(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("gpu_open", z);
        edit.commit();
        this.U = z;
    }

    public boolean w() {
        return this.U;
    }

    public void g(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("moplus_service", z);
        edit.commit();
    }

    public boolean x() {
        return getSharedPreferences("settings", 0).getBoolean("moplus_service", true);
    }

    public void h(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("push_service", z);
        edit.commit();
    }

    public boolean y() {
        return getSharedPreferences("settings", 0).getBoolean("push_service", true);
    }

    public void i(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.V = z;
    }

    public boolean z() {
        return this.V;
    }

    private void bs() {
        try {
            com.baidu.tieba.data.g.b(getPackageManager().getPackageInfo("com.baidu.tieba", JNITaskBuffer.BufferSize).versionName);
            if (com.baidu.tieba.data.g.i() == null) {
                com.baidu.tieba.data.g.b("");
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "InitVersion", e.getMessage());
            com.baidu.tieba.data.g.b("");
        }
    }

    private void bt() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String bu = bu();
                if (bu == null) {
                    String bv = bv();
                    if (bv != null && bv.length() > 0) {
                        com.baidu.tieba.data.g.a(bv);
                        t(bv);
                        bufferedReader = null;
                    } else {
                        bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && readLine.length() > 0) {
                                com.baidu.tieba.data.g.a(readLine);
                                t(readLine);
                                u(readLine);
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            com.baidu.tieba.util.aj.b(getClass().getName(), "InitFrom", e.getMessage());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            com.baidu.tieba.util.aj.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.g.a());
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
                    com.baidu.tieba.data.g.a(bu);
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
        com.baidu.tieba.util.aj.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.g.a());
    }

    private String bu() {
        return getSharedPreferences("settings", 0).getString("from_id", null);
    }

    private void t(String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("from_id", str);
            edit.commit();
        }
    }

    private String bv() {
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
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "getFromByFile", e.getMessage());
        }
        return str;
    }

    private void u(String str) {
        if (str != null && str.length() > 0) {
            try {
                File e = com.baidu.tieba.util.p.e("from.dat");
                if (e != null) {
                    FileWriter fileWriter = new FileWriter(e);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e2) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "saveFromToFile", e2.getMessage());
            }
        }
    }

    public static String A() {
        return com.baidu.tieba.data.g.a();
    }

    public void B() {
        a(0L, 0L, 0L, 0L);
        DatabaseService.x();
    }

    public com.baidu.adp.widget.a.b g(String str) {
        SoftReference softReference = (SoftReference) this.g.get(str);
        if (softReference != null && softReference.get() != null) {
            return (com.baidu.adp.widget.a.b) softReference.get();
        }
        com.baidu.adp.widget.a.b a2 = com.baidu.tbadk.a.a.a().a(str);
        if (a2 != null) {
            this.g.put(str, new SoftReference(a2));
            return a2;
        }
        return a2;
    }

    public void a(Boolean bool) {
        this.h = bool.booleanValue();
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("display_photo", bool.booleanValue());
        edit.commit();
    }

    public boolean C() {
        return this.h;
    }

    public void a(long j) {
        this.af = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public long D() {
        return this.af;
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
        int max = (int) Math.max(b * 0.8d, com.baidu.tieba.data.g.d());
        if (max < b) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.a.e.a().b(max);
        }
    }

    public static String E() {
        if (i != null) {
            com.baidu.tieba.util.aj.a("TiebaApplication", "getCurrentAccount", String.valueOf(i.getID()));
            return i.getID();
        }
        return null;
    }

    public static boolean F() {
        String E = E();
        return E != null && E.length() > 0;
    }

    public static void a(AccountData accountData, Context context) {
        boolean z = true;
        if ((accountData != null || i == null) && ((i != null || accountData == null) && (i == null || accountData == null || TextUtils.equals(i.getAccount(), accountData.getAccount())))) {
            z = false;
        }
        if (z) {
            f().aB();
        }
        i = accountData;
        if (f().y()) {
            com.baidu.tieba.util.am.g(context);
        } else {
            com.baidu.tieba.util.am.h(context);
        }
        if (accountData != null) {
            com.baidu.tieba.util.ak.a(accountData.getAccount(), accountData.getID());
        }
    }

    public static String G() {
        if (i != null) {
            return i.getBDUSS();
        }
        return null;
    }

    public static void h(String str) {
        if (i != null) {
            i.setBDUSS(str);
        }
    }

    public static AccountData H() {
        return i;
    }

    public static String I() {
        if (i != null) {
            return i.getAccount();
        }
        return null;
    }

    public int J() {
        int i2 = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        com.baidu.tieba.util.aj.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i2));
        return i2;
    }

    public void b(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i2);
        edit.commit();
    }

    public long K() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        com.baidu.tieba.util.aj.a("TiebaApplication", "getTDatabaseCreateTime", com.baidu.tieba.util.ai.a(j));
        return j;
    }

    public void b(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("update_notify_time", j);
        edit.commit();
    }

    public long L() {
        return getSharedPreferences("settings", 0).getLong("update_notify_time", 0L);
    }

    public void i(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("install_other_app_file_name", str);
        edit.commit();
    }

    public String M() {
        return getSharedPreferences("settings", 0).getString("install_other_app_file_name", null);
    }

    public void N() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("tdatabasecreatetime", new Date().getTime());
        edit.commit();
    }

    public boolean O() {
        return J() > 50 && new Date().getTime() - K() > 2592000000L;
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public void j(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (i != null) {
                    i.setTbs(str);
                }
            }
        }
    }

    public String P() {
        if (i != null) {
            return i.getTbs();
        }
        return null;
    }

    public static String a(Context context) {
        String str = null;
        String string = context.getSharedPreferences("settings", 0).getString("client_id", null);
        if (string != null) {
            int indexOf = string.indexOf("\t");
            if (indexOf != -1) {
                if (com.baidu.tieba.data.g.i().equals(string.substring(0, indexOf))) {
                    str = string.substring(indexOf + 1);
                } else {
                    b((Context) f());
                }
            } else {
                b((Context) f());
            }
        } else {
            str = string;
        }
        com.baidu.tieba.util.aj.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String Q() {
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
            edit.putString("client_id", String.valueOf(com.baidu.tieba.data.g.i()) + "\t" + str);
            edit.commit();
        }
    }

    public static void k(String str) {
        n = str;
    }

    public void j(boolean z) {
        this.j = z;
    }

    public boolean R() {
        return this.j;
    }

    public int S() {
        return this.aq;
    }

    public void T() {
        d(300);
        n(true);
        p(true);
        o(true);
    }

    public void k(boolean z) {
        this.aw = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            l();
        } else {
            m();
        }
    }

    public boolean U() {
        return this.aw;
    }

    public void l(boolean z) {
        if (this.au != z) {
            this.au = z;
        }
    }

    public boolean V() {
        return this.au;
    }

    public void m(boolean z) {
        this.av = z;
    }

    public boolean W() {
        return this.av;
    }

    public int X() {
        if (!this.au && !this.av) {
            return 0;
        }
        if (this.au && !this.av) {
            return 1;
        }
        if (!this.au && this.av) {
            return 2;
        }
        return 3;
    }

    public void c(int i2) {
        if (i2 == 0) {
            f().l(false);
            f().m(false);
        } else if (i2 == 1) {
            f().l(true);
            f().m(false);
        } else if (i2 == 2) {
            f().l(false);
            f().m(true);
        } else {
            f().l(true);
            f().m(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r10v0 int)] */
    public void d(int i2) {
        com.baidu.tieba.util.aj.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i2).toString());
        this.aq = i2;
        if (i2 == 0) {
            a(0L, 0L, 0L, 0L);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean Y() {
        return this.ar;
    }

    public void n(boolean z) {
        this.ar = z;
        if (!z) {
            e(0L);
        }
    }

    public boolean Z() {
        return this.as;
    }

    public void o(boolean z) {
        this.as = z;
        if (!z) {
            d(0L);
        }
    }

    public boolean aa() {
        return this.at;
    }

    public void p(boolean z) {
        this.at = z;
        if (!z) {
            c(0L);
        }
    }

    public boolean ab() {
        return this.aq > 0;
    }

    public void ac() {
        if (f().ab()) {
            try {
                startService(new Intent(this, TiebaMessageService.class));
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void ad() {
        stopService(new Intent(this, TiebaMessageService.class));
    }

    public long ae() {
        return this.ax;
    }

    public void c(long j) {
        if (j >= 0) {
            a(j, this.ay, this.az, this.aA);
        }
    }

    public long af() {
        return this.ay;
    }

    public void d(long j) {
        if (j >= 0) {
            a(this.ax, j, this.az, this.aA);
        }
    }

    public long ag() {
        return this.az;
    }

    public void e(long j) {
        if (j >= 0) {
            a(this.ax, this.ay, j, this.aA);
        }
    }

    public long ah() {
        return this.aA;
    }

    public void ai() {
        this.ax = 0L;
        this.ay = 0L;
        this.az = 0L;
        this.aA = 0L;
    }

    protected void a(String str, boolean z) {
        try {
            SharedPreferences.Editor edit = this.aj.edit();
            edit.putBoolean(str, z);
            edit.commit();
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.a("failed to saveBoolean:" + str + ", " + th.getMessage());
            }
        }
    }

    protected void a(String str, int i2) {
        try {
            SharedPreferences.Editor edit = this.aj.edit();
            edit.putInt(str, i2);
            edit.commit();
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.a("failed to saveInt:" + str + ", " + th.getMessage());
            }
        }
    }

    public boolean aj() {
        return this.aj.getBoolean("alert_sign_on", false);
    }

    public void q(boolean z) {
        a("alert_sign_on", z);
        am();
    }

    public int ak() {
        int i2 = this.aj.getInt("alert_sign_hours", -1);
        if (i2 == -1) {
            bw();
            return this.aj.getInt("alert_sign_hours", 12);
        }
        return i2;
    }

    private void bw() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int al() {
        int i2 = this.aj.getInt("alert_sign_mins", -1);
        if (i2 == -1) {
            bw();
            return this.aj.getInt("alert_sign_mins", 30);
        }
        return i2;
    }

    public void a(int i2, int i3) {
        a("alert_sign_hours", i2);
        a("alert_sign_mins", i3);
        am();
    }

    public void am() {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent an = an();
        if (aj()) {
            Calendar calendar = Calendar.getInstance();
            int ak2 = ak();
            int i2 = calendar.get(11);
            int al2 = al();
            int i3 = calendar.get(12);
            calendar.set(11, ak2);
            calendar.set(12, al2);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i2 >= ak2 && (i2 != ak2 || i3 >= al2)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this, 0, an, 268435456));
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.c("sign-alert alarm set to :" + com.baidu.tieba.util.ai.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, an, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.c("sign-alert alarm cancelled.");
            }
        }
    }

    protected Intent an() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.signalert");
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(this, SignAlertReceiver.class);
        return intent;
    }

    public int ao() {
        return this.J;
    }

    public int ap() {
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

    public boolean aq() {
        return this.L;
    }

    public void r(boolean z) {
        if (this.L != z) {
            this.L = z;
            getSharedPreferences("settings", 0).edit().putBoolean("show_images", z).commit();
        }
    }

    public int ar() {
        return this.M;
    }

    public void g(int i2) {
        if (this.M != i2) {
            this.M = i2;
            getSharedPreferences("settings", 0).edit().putInt("font_size", i2).commit();
        }
    }

    public void s(boolean z) {
        this.N = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    public boolean as() {
        return this.N;
    }

    public void t(boolean z) {
        this.Q = z;
        getSharedPreferences("settings", 0).edit().putBoolean("open_local_popularize", z).commit();
    }

    public boolean at() {
        return this.Q;
    }

    public void h(int i2) {
        AppsActivity.b();
        i(i2);
        getSharedPreferences("settings", 0).edit().putInt("skin", i2).commit();
        p(i2);
    }

    public void i(int i2) {
        this.O = i2;
    }

    private void p(int i2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i2);
        sendBroadcast(intent);
    }

    public int au() {
        return this.O;
    }

    public int av() {
        return this.Z;
    }

    public void j(int i2) {
        this.Z = i2;
        getSharedPreferences("settings", 0).edit().putInt("webview_crash_count", i2).commit();
    }

    public int aw() {
        return this.aa;
    }

    public void k(int i2) {
        this.aa = i2;
        getSharedPreferences("settings", 0).edit().putInt("perform_sample_count", i2).commit();
    }

    public int ax() {
        return this.ab;
    }

    public void l(int i2) {
        this.ab = i2;
        getSharedPreferences("settings", 0).edit().putInt("new_vcode_webview_crash_count", i2).commit();
    }

    public void l(String str) {
        getSharedPreferences("settings", 0).edit().putString("pk_before_message_id", str).commit();
    }

    public String ay() {
        return getSharedPreferences("settings", 0).getString("pk_before_message_id", "");
    }

    public void m(String str) {
        getSharedPreferences("settings", 0).edit().putString("pk_after_message_id", str).commit();
    }

    public String az() {
        return getSharedPreferences("settings", 0).getString("pk_after_message_id", "");
    }

    public void aA() {
        int i2 = getSharedPreferences("settings", 0).getInt("bd_loc_crash_count", 0) + 1;
        getSharedPreferences("settings", 0).edit().putInt("bd_loc_crash_count", i2).commit();
        if (i2 > 3) {
            a(false);
        }
    }

    public void a(VersionData versionData) {
        this.w = versionData;
    }

    public void a(long j, long j2, long j3, long j4) {
        if (j != this.ax || j2 != this.ay || j3 != this.az || j4 != this.aA) {
            int i2 = 0;
            if (j > this.ax || j2 > this.ay || j3 > this.az || j4 > this.aA) {
                i2 = 1;
            } else if (j < this.ax || j2 < this.ay || j3 < this.az || j4 < this.aA) {
                i2 = 2;
            }
            this.ax = j;
            this.ay = j2;
            this.az = j3;
            this.aA = j4;
            bx();
            q(i2);
        }
    }

    public void b(long j, long j2, long j3, long j4) {
        if (j != this.ax || j2 != this.ay || j3 != this.az || j4 != this.aA) {
            this.ax = j;
            this.ay = j2;
            this.az = j3;
            this.aA = j4;
            bx();
        }
    }

    private void q(int i2) {
        Intent intent;
        if (this.d != null) {
            try {
                if (i2 == 1) {
                    Notification notification = new Notification(R.drawable.icon, getString(R.string.notify_text), System.currentTimeMillis());
                    StringBuffer stringBuffer = new StringBuffer();
                    if (this.ax > 0 || this.ay > 0) {
                        stringBuffer.append(String.valueOf(this.ax + this.ay));
                        stringBuffer.append(getString(R.string.notify_msg));
                    }
                    if (this.az > 0) {
                        stringBuffer.append(String.valueOf(this.az));
                        stringBuffer.append(getString(R.string.notify_fans));
                    }
                    if (this.aA > 0) {
                        stringBuffer.append(String.valueOf(this.aA));
                        stringBuffer.append(getString(R.string.notify_chat));
                    }
                    if (this.az != 0 || this.ax != 0 || this.ay != 0 || this.aA != 0) {
                        if ((this.ax > 0 || this.ay > 0) && this.az == 0 && this.aA == 0) {
                            intent = new Intent(this, MentionActivity.class);
                        } else if (this.az > 0 && this.ax == 0 && this.ay == 0 && this.aA == 0) {
                            intent = new Intent(this, PersonListActivity.class);
                            intent.putExtra("follow", false);
                            intent.putExtra("un", E());
                        } else if (this.aA > 0 && this.az == 0 && this.ax == 0 && this.ay == 0) {
                            intent = new Intent(this, ChatListActivity.class);
                        } else {
                            intent = new Intent(this, PersonInfoActivity.class);
                            intent.putExtra("self", true);
                            intent.putExtra("tab_page", false);
                            intent.putExtra("tab_msg", true);
                            intent.putExtra("un", E());
                        }
                        stringBuffer.append(getString(R.string.notify_click));
                        intent.setFlags(268435456);
                        notification.setLatestEventInfo(this, getString(R.string.app_name), stringBuffer, PendingIntent.getActivity(this, 0, intent, 0));
                        notification.defaults = -1;
                        notification.flags = 16;
                        notification.audioStreamType = 5;
                        if (!this.au) {
                            notification.defaults &= -2;
                        }
                        if (!this.av) {
                            notification.defaults &= -3;
                        }
                        this.d.notify(11, notification);
                    }
                } else if (i2 == 2) {
                    this.d.cancel(11);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    public void aB() {
        if (this.d != null) {
            this.d.cancel(11);
            this.d.cancel(15);
            this.d.cancel(13);
            this.d.cancel(12);
        }
    }

    public void aC() {
        if (this.d != null) {
            this.d.cancel(11);
        }
    }

    public static boolean aD() {
        return ak;
    }

    public static void u(boolean z) {
        ak = z;
    }

    private void bx() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", ae());
        intent.putExtra("at_me", af());
        intent.putExtra("fans", ag());
        intent.putExtra("pletter", ah());
        sendBroadcast(intent);
        com.baidu.tieba.util.aj.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(ae()), Long.valueOf(af()), Long.valueOf(ag())));
    }

    public com.baidu.tieba.util.z aE() {
        return this.k;
    }

    public int aF() {
        switch (this.J) {
            case 1:
                return BdWebErrorView.ERROR_CODE_900;
            case 2:
            default:
                return 600;
            case 3:
                return 300;
        }
    }

    public void aG() {
        this.t = System.currentTimeMillis();
    }

    public void aH() {
        this.t = -1L;
    }

    public void aI() {
        if (this.t > 0) {
            this.t = System.currentTimeMillis() - this.t;
            if (this.t > 0) {
                new com.baidu.tieba.account.ag("startup_time", String.valueOf(this.t));
                com.baidu.tieba.util.ak.a("op_launch", this.t, 0L);
            }
            com.baidu.tieba.util.aj.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.t));
        }
        this.t = -1L;
    }

    public void aJ() {
        this.q++;
        by();
    }

    public void aK() {
        this.q--;
        by();
    }

    private void by() {
        if (q()) {
            if (this.q < 0) {
                this.q = 0;
            }
            if (this.r == 0 && this.q > 0) {
                this.r = System.nanoTime();
            }
            com.baidu.tieba.util.aj.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.q));
            this.c.removeMessages(4);
            if (this.q == 0 && this.r > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), Util.MILLSECONDS_OF_MINUTE);
            }
        }
    }

    public boolean aL() {
        String string = getSharedPreferences("settings", 0).getString("lase_version", "");
        if (string.equals(com.baidu.tieba.data.g.i())) {
            return false;
        }
        n(string);
        return true;
    }

    public void aM() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("lase_version", com.baidu.tieba.data.g.i());
        edit.commit();
    }

    public void n(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("active_version", str);
        edit.commit();
    }

    public String aN() {
        String string = getSharedPreferences("settings", 0).getString("active_version", "");
        if ("active_clear".equals(string)) {
            return null;
        }
        return string;
    }

    public void aO() {
        n("active_clear");
    }

    public void aP() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.remove("account_share");
        edit.commit();
    }

    public String aQ() {
        return getSharedPreferences("settings", 0).getString("account_share", null);
    }

    public void o(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("account_share", str);
        edit.commit();
    }

    private void bz() {
        try {
            this.E = (LocationManager) getSystemService(Headers.LOCATION);
            if (this.A) {
                this.C = new MyBDLocationListenner();
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName("tieba");
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(BdWebErrorView.ERROR_CODE_500);
                locationClientOption.disableCache(true);
                this.B = new LocationClient(getApplicationContext());
                this.B.registerLocationListener(this.C);
                this.B.setLocOption(locationClientOption);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public void aR() {
        try {
            if (this.F == null || System.currentTimeMillis() - this.f824a > 300000) {
                this.F = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.E != null) {
                    this.E.removeUpdates(this.aB);
                }
                if (this.A) {
                    if (!this.B.isStarted()) {
                        this.B.start();
                    }
                    this.B.requestLocation();
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
                    v("gps");
                } else {
                    this.D = 1;
                }
                if (this.E != null && this.E.isProviderEnabled("network")) {
                    v("network");
                } else {
                    this.D = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), Util.MILLSECONDS_OF_MINUTE);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    private void v(String str) {
        if (this.E.isProviderEnabled(str)) {
            this.E.requestLocationUpdates(str, 10000L, 100.0f, this.aB);
        }
    }

    /* loaded from: classes.dex */
    public class MyBDLocationListenner implements BDLocationListener {
        public MyBDLocationListenner() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                TiebaApplication.this.D = 0;
                TiebaApplication.this.aS();
                TiebaApplication.this.F = new Address(Locale.getDefault());
                TiebaApplication.this.F.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.F.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.f824a = System.currentTimeMillis();
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
                    TiebaApplication.this.F.setAddressLine(0, stringBuffer.toString());
                }
                TiebaApplication.this.a(TiebaApplication.this.D, "", TiebaApplication.this.F);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public void aS() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.E != null) {
            this.E.removeUpdates(this.aB);
        }
        if (this.A && this.B != null && this.B.isStarted()) {
            this.B.stop();
        }
        if (this.G != null) {
            this.G.cancel();
        }
    }

    public Address aT() {
        return this.F;
    }

    public Address a(av avVar) {
        boolean z;
        if (this.F != null && System.currentTimeMillis() - this.f824a <= 300000) {
            return this.F;
        }
        if (avVar != null) {
            int i2 = 0;
            while (true) {
                if (i2 < this.H.size()) {
                    av avVar2 = (av) ((SoftReference) this.H.get(i2)).get();
                    if (avVar2 == null || !avVar2.equals(avVar)) {
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
                this.H.add(new SoftReference(avVar));
            }
            aR();
        }
        return null;
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
                    av avVar = (av) ((SoftReference) this.H.get(i4)).get();
                    if (avVar != null) {
                        avVar.a(i2, str, address);
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
        y(z2);
        this.y = 0;
        this.y |= 1;
        if (z) {
            this.R = true;
            this.y |= 2;
        } else {
            this.R = false;
            if (z2) {
                this.y |= 4;
            }
        }
        edit.putInt("check_network_notify_confirm", this.y);
        edit.commit();
    }

    public int aU() {
        this.y = getSharedPreferences("settings", 0).getInt("check_network_notify_confirm", 0);
        return this.y;
    }

    public int aV() {
        if ((this.y & 1) == 0) {
            return -1;
        }
        if ((this.y & 2) == 0) {
            this.R = false;
            return (this.y & 4) == 0 ? 2 : 1;
        }
        this.R = true;
        return 0;
    }

    public void f(long j) {
        this.s = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("message_id", j);
        edit.commit();
    }

    public long aW() {
        return this.s;
    }

    public void a(int i2, int i3, String str) {
        if (this.I == null) {
            this.I = Executors.newSingleThreadExecutor();
        }
        com.baidu.tieba.util.aj.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + " img_total" + i3);
        com.baidu.tieba.account.af afVar = new com.baidu.tieba.account.af(i2, i3);
        afVar.a(str);
        this.I.execute(afVar);
    }

    public boolean aX() {
        return this.aC;
    }

    public void v(boolean z) {
        this.aC = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aY() {
        if (f().aX()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(f().L()).longValue() > Util.MILLSECONDS_OF_DAY;
        }
        return false;
    }

    public static boolean aZ() {
        synchronized (aD) {
            while (aE == null) {
                try {
                    aD.wait();
                } catch (Exception e) {
                    com.baidu.adp.lib.e.d.a(e.getMessage());
                }
            }
            if (aE != null) {
                return aE.booleanValue();
            }
            return false;
        }
    }

    public boolean ba() {
        return this.an;
    }

    public void w(boolean z) {
        this.an = z;
    }

    public boolean bb() {
        return this.R;
    }

    public String bc() {
        return this.ao;
    }

    public void p(String str) {
        this.ao = str;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("last_recommend_time", str);
        edit.commit();
    }

    public void x(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("is_pk_offline", z);
        edit.commit();
    }

    public boolean bd() {
        return getSharedPreferences("settings", 0).getBoolean("is_pk_offline", false);
    }

    public void q(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("pk_change_title", str);
        edit.commit();
    }

    public String be() {
        return getSharedPreferences("settings", 0).getString("pk_change_title", "");
    }

    public void r(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("pk_change_link", str);
        edit.commit();
    }

    public long bf() {
        return getSharedPreferences("settings", 0).getLong("last_notify_sound_time", 0L);
    }

    public void g(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("last_notify_sound_time", j);
        edit.commit();
    }

    public int bg() {
        return getSharedPreferences("settings", 0).getInt("kn_vote_cd", 600);
    }

    public void m(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("kn_vote_cd", i2);
        edit.commit();
    }

    public int bh() {
        return getSharedPreferences("settings", 0).getInt("kn_vote_max", 10);
    }

    public void n(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("kn_vote_max", i2);
        edit.commit();
    }

    public int bi() {
        return getSharedPreferences("settings", 0).getInt("kn_vote_rate", 10);
    }

    public void o(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("kn_vote_rate", i2);
        edit.commit();
    }

    public void s(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("push_channel_id", str);
        edit.commit();
    }

    public String bj() {
        return getSharedPreferences("settings", 0).getString("push_channel_id", "");
    }

    public String bk() {
        return getSharedPreferences("settings", 0).getString("pk_change_link", "");
    }

    public void y(boolean z) {
        if (z) {
            if (aq()) {
                f(1);
            }
            z(true);
            e(1);
            return;
        }
        if (aq()) {
            f(2);
        }
        z(false);
        if (ao() == 1) {
            e(2);
        }
    }

    public void z(boolean z) {
        this.S = z;
    }

    public boolean bl() {
        return this.S;
    }

    public com.baidu.adp.lib.cache.q bm() {
        if (this.Y == null) {
            this.Y = BdCacheService.c().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.Y;
    }
}
