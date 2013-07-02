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
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.hp.LayoutProxy;
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
import com.mofamulu.tieba.ch.bg;
import com.mofamulu.tieba.map.FreeLocationService;
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
@org.acra.a.a(i = "")
/* loaded from: classes.dex */
public class TiebaApplication extends com.baidu.adp.a.b {
    private static TiebaApplication f;
    private LocationManager E;
    private SharedPreferences ag;
    private Boolean z;
    private static AccountData i = null;
    private static String n = null;
    private static boolean o = false;
    private static boolean ah = false;
    private static Intent ai = null;
    private static String az = "79A74DC064B49770ED928E44E679A79E86AD9B9A";
    private static final byte[] aB = new byte[0];
    private static volatile Boolean aC = null;
    private int e = 0;
    private HashMap g = null;
    private boolean h = true;
    private boolean j = false;
    private com.baidu.tieba.util.w k = null;
    private com.baidu.tieba.util.w l = null;
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
    public long a = 0;
    private int y = -1;
    private boolean A = true;
    private LocationClient B = null;
    private BDLocationListener C = null;
    private int D = 0;
    private Address F = null;
    private ax G = null;
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
    private Hashtable ak = null;
    public Handler c = new Handler(new as(this));
    private int al = 0;
    private boolean am = true;
    private boolean an = true;
    private boolean ao = true;
    private boolean ap = true;
    private boolean aq = false;
    private boolean ar = true;
    private long as = 0;
    private long at = 0;
    private long au = 0;
    private long av = 0;
    NotificationManager d = null;
    private final LocationListener aw = new at(this);
    private boolean ax = false;
    private BMapManager ay = null;
    private boolean aA = false;

    public static void a(Intent intent) {
        ai = intent;
    }

    public static Intent d() {
        return ai;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        f = this;
        this.ag = getSharedPreferences("settings", 0);
        LayoutProxy.a(this);
        new ay(null).execute(new String[0]);
        com.baidu.tieba.data.g.r();
        NetWorkCore.e();
        aZ();
        ba();
        aV();
        aY();
        com.baidu.tieba.util.ad.a(this);
        n = a((Context) this);
        aW();
        aX();
        i();
        com.baidu.tieba.data.g.d(this);
        com.baidu.tieba.data.g.b(this);
        com.baidu.tieba.data.g.c(this);
        getContentResolver().registerContentObserver(Uri.parse("content://telephony/carriers"), true, new au(this, new Handler()));
        if (p()) {
            com.baidu.tbadk.a.e.a().a(50, com.baidu.tieba.data.g.d());
            com.baidu.tbadk.a.a.a().a(this, new com.baidu.tieba.util.l());
            aO();
            this.g = new HashMap();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                i = DatabaseService.p();
            }
            if (m()) {
                c.a(this);
            } else {
                com.baidu.tieba.account.a.a().a(this);
            }
            DatabaseService.x();
            j();
            this.k = new com.baidu.tieba.util.w(MKEvent.ERROR_PERMISSION_DENIED);
            this.l = new com.baidu.tieba.util.w(100);
            this.d = (NotificationManager) getSystemService("notification");
            new com.baidu.tieba.account.af("open").start();
            if (S()) {
                k();
            }
            if (aq()) {
                new com.baidu.tieba.account.af("frs_abstract", "1").start();
            }
            bg();
            this.H = new ArrayList();
            ak();
            new com.baidu.tieba.data.a.a().a();
        } else {
            this.b = new ArrayList();
        }
        try {
            registerReceiver(new com.baidu.tieba.service.g(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e) {
            com.baidu.adp.lib.c.b.a(e.getMessage());
        }
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
        if (com.baidu.adp.lib.c.b.a()) {
            com.baidu.adp.lib.c.b.b("device:[" + str + "], default GPU on:" + z);
        }
        return z;
    }

    public static TiebaApplication f() {
        return f;
    }

    public void a(String str) {
        this.p = str;
    }

    public boolean b(String str) {
        return (this.ak == null || str == null || !this.ak.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.ak != null && str != null) {
            if (this.ak.size() > 100) {
                this.ak.clear();
            }
            this.ak.put(str, 1);
        }
    }

    public void g() {
        if (this.ak != null) {
            this.ak.clear();
        }
    }

    public int h() {
        if (this.ak != null) {
            return this.ak.size();
        }
        return 0;
    }

    public void i() {
        if (this.ak == null) {
            this.ak = new Hashtable();
        }
    }

    public boolean d(String str) {
        return (this.aj == null || str == null || !this.aj.containsKey(str)) ? false : true;
    }

    public void e(String str) {
        if (!d(str) && this.aj != null && str != null) {
            this.aj.put(str, 1);
            new com.baidu.tieba.util.n(1, str).start();
        }
    }

    public void f(String str) {
        if (d(str) && this.aj != null && str != null) {
            this.aj.remove(str);
            new com.baidu.tieba.util.n(2, str).start();
        }
    }

    public void j() {
        this.aj = new Hashtable();
        new com.baidu.tieba.util.n(this.aj).start();
    }

    public void k() {
        try {
            startService(new Intent(this, MessagePullService.class));
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "startPullMessageService", e.toString());
        }
    }

    public void l() {
        stopService(new Intent(this, MessagePullService.class));
    }

    public void a(g gVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ((g) this.b.get(i2)).a_();
                } catch (Exception e) {
                    com.baidu.tieba.util.z.b(getClass().getName(), "addRemoteActivity", e.getMessage());
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

    private void aV() {
        if (Build.VERSION.SDK_INT >= 5) {
            o = new AccountProxy(this).hasBaiduAccount();
        } else {
            o = false;
        }
    }

    public static boolean m() {
        if (bg.c().L()) {
            return false;
        }
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

    public String n() {
        return this.v;
    }

    public String o() {
        return this.m;
    }

    public boolean p() {
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
        this.ar = sharedPreferences.getBoolean("permoted_message", true);
        this.h = sharedPreferences.getBoolean("display_photo", true);
        this.N = sharedPreferences.getBoolean("abstract_state", true);
        this.O = sharedPreferences.getInt("skin", 0);
        this.s = sharedPreferences.getLong("message_id", 0L);
        this.S = sharedPreferences.getBoolean("gpu_open", e());
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
        if (aF()) {
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
        com.baidu.tieba.data.a.a = getString(R.string.neterror);
    }

    public int q() {
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
        this.aa = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("search_mode", this.aa);
        edit.commit();
    }

    public boolean r() {
        return this.aa;
    }

    public boolean s() {
        return this.V;
    }

    public void b(boolean z) {
        this.V = z;
    }

    public boolean t() {
        return this.P;
    }

    public void c(boolean z) {
        this.P = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("location_on", this.P);
        edit.commit();
    }

    public void d(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("motu_on", z);
        edit.commit();
        this.R = z;
    }

    public boolean u() {
        return this.R;
    }

    public void e(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("gpu_open", z);
        edit.commit();
        this.S = z;
    }

    public boolean v() {
        return this.S;
    }

    public void f(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.T = z;
    }

    public boolean w() {
        return this.T;
    }

    private void aZ() {
        try {
            com.baidu.tieba.data.g.b(getPackageManager().getPackageInfo("com.baidu.tieba", JNITaskBuffer.BufferSize).versionName);
            if (com.baidu.tieba.data.g.i() == null) {
                com.baidu.tieba.data.g.b("");
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "InitVersion", e.getMessage());
            com.baidu.tieba.data.g.b("");
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
                        com.baidu.tieba.data.g.a(bc);
                        g(bc);
                        bufferedReader = null;
                    } else {
                        bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && readLine.length() > 0) {
                                com.baidu.tieba.data.g.a(readLine);
                                g(readLine);
                                o(readLine);
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            com.baidu.tieba.util.z.b(getClass().getName(), "InitFrom", e.getMessage());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            com.baidu.tieba.util.z.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.g.a());
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
                    com.baidu.tieba.data.g.a(bb);
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
        com.baidu.tieba.util.z.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.g.a());
    }

    private String bb() {
        return getSharedPreferences("settings", 0).getString("from_id", null);
    }

    public void g(String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("from_id", str);
            edit.commit();
        }
    }

    private String bc() {
        String str = null;
        try {
            File c = com.baidu.tieba.util.m.c("from.dat");
            if (c != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(c));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "getFromByFile", e.getMessage());
        }
        return str;
    }

    private void o(String str) {
        if (str != null && str.length() > 0) {
            try {
                File e = com.baidu.tieba.util.m.e("from.dat");
                if (e != null) {
                    FileWriter fileWriter = new FileWriter(e);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e2) {
                com.baidu.tieba.util.z.b(getClass().getName(), "saveFromToFile", e2.getMessage());
            }
        }
    }

    public static String x() {
        return com.baidu.tieba.data.g.a();
    }

    public void y() {
        a(0L, 0L, 0L, 0L);
        DatabaseService.x();
    }

    public com.baidu.adp.widget.a.b h(String str) {
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

    public boolean z() {
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

    public long A() {
        return this.af;
    }

    public void b(long j) {
        this.ac = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public long B() {
        return this.ac;
    }

    public void g(boolean z) {
        this.ae = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("local_app_has_showed_in_nearby", z);
        edit.commit();
    }

    public boolean C() {
        return this.ae;
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
            if (com.baidu.adp.lib.c.b.a()) {
                com.baidu.adp.lib.c.b.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.a.e.a().b(max);
        }
    }

    public static String D() {
        if (i != null) {
            com.baidu.tieba.util.z.a("TiebaApplication", "getCurrentAccount", String.valueOf(i.getID()));
            return i.getID();
        }
        return null;
    }

    public static void a(AccountData accountData) {
        i = accountData;
    }

    public static String E() {
        if (i != null) {
            return i.getBDUSS();
        }
        return null;
    }

    public static void i(String str) {
        if (i != null) {
            i.setBDUSS(str);
        }
    }

    public static AccountData F() {
        return i;
    }

    public static String G() {
        if (i != null) {
            return i.getAccount();
        }
        return null;
    }

    public static void b(AccountData accountData) {
        i = accountData;
    }

    public int H() {
        int i2 = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        com.baidu.tieba.util.z.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i2));
        return i2;
    }

    public void d(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i2);
        edit.commit();
    }

    public long I() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        com.baidu.tieba.util.z.a("TiebaApplication", "getTDatabaseCreateTime", com.baidu.tieba.util.y.a(j));
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

    public void j(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("install_other_app_file_name", str);
        edit.commit();
    }

    public String K() {
        return getSharedPreferences("settings", 0).getString("install_other_app_file_name", null);
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
        if (this.ay != null) {
            this.ay.destroy();
            this.ay = null;
        }
        super.onTerminate();
    }

    public void k(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (i != null) {
                    i.setTbs(str);
                }
            }
        }
    }

    public String N() {
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
        com.baidu.tieba.util.z.a("TiebaApplication", "readClientId", str);
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
            edit.putString("client_id", String.valueOf(com.baidu.tieba.data.g.i()) + "\t" + str);
            edit.commit();
        }
    }

    public static void l(String str) {
        n = str;
    }

    public void h(boolean z) {
        this.j = z;
    }

    public boolean P() {
        return this.j;
    }

    public int Q() {
        return this.al;
    }

    public void R() {
        f(MKEvent.ERROR_PERMISSION_DENIED);
        l(true);
        n(true);
        m(true);
    }

    public void i(boolean z) {
        this.ar = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            k();
        } else {
            l();
        }
    }

    public boolean S() {
        return this.ar;
    }

    public void j(boolean z) {
        if (this.ap != z) {
            this.ap = z;
        }
    }

    public boolean T() {
        return this.ap;
    }

    public void k(boolean z) {
        this.aq = z;
    }

    public boolean U() {
        return this.aq;
    }

    public int V() {
        if (!this.ap && !this.aq) {
            return 0;
        }
        if (this.ap && !this.aq) {
            return 1;
        }
        if (!this.ap && this.aq) {
            return 2;
        }
        return 3;
    }

    public void e(int i2) {
        if (i2 == 0) {
            f().j(false);
            f().k(false);
        } else if (i2 == 1) {
            f().j(true);
            f().k(false);
        } else if (i2 == 2) {
            f().j(false);
            f().k(true);
        } else {
            f().j(true);
            f().k(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r10v0 int)] */
    public void f(int i2) {
        com.baidu.tieba.util.z.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i2).toString());
        this.al = i2;
        if (i2 == 0) {
            a(0L, 0L, 0L, 0L);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean W() {
        return this.am;
    }

    public void l(boolean z) {
        this.am = z;
        if (!z) {
            f(0L);
        }
    }

    public boolean X() {
        return this.an;
    }

    public void m(boolean z) {
        this.an = z;
        if (!z) {
            e(0L);
        }
    }

    public boolean Y() {
        return this.ao;
    }

    public void n(boolean z) {
        this.ao = z;
        if (!z) {
            d(0L);
        }
    }

    public boolean Z() {
        return this.al > 0;
    }

    public void aa() {
        if (f().Z()) {
            try {
                startService(new Intent(this, TiebaMessageService.class));
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "startMsgReceive", e.toString());
            }
        }
    }

    public void ab() {
        stopService(new Intent(this, TiebaMessageService.class));
    }

    public long ac() {
        return this.as;
    }

    public void d(long j) {
        if (j >= 0) {
            a(j, this.at, this.au, this.av);
        }
    }

    public long ad() {
        return this.at;
    }

    public void e(long j) {
        if (j >= 0) {
            a(this.as, j, this.au, this.av);
        }
    }

    public long ae() {
        return this.au;
    }

    public void f(long j) {
        if (j >= 0) {
            a(this.as, this.at, j, this.av);
        }
    }

    public long af() {
        return this.av;
    }

    public void ag() {
        this.as = 0L;
        this.at = 0L;
        this.au = 0L;
        this.av = 0L;
    }

    protected void a(String str, boolean z) {
        try {
            SharedPreferences.Editor edit = this.ag.edit();
            edit.putBoolean(str, z);
            edit.commit();
        } catch (Throwable th) {
            if (com.baidu.adp.lib.c.b.a()) {
                com.baidu.adp.lib.c.b.a("failed to saveBoolean:" + str + ", " + th.getMessage());
            }
        }
    }

    protected void a(String str, int i2) {
        try {
            SharedPreferences.Editor edit = this.ag.edit();
            edit.putInt(str, i2);
            edit.commit();
        } catch (Throwable th) {
            if (com.baidu.adp.lib.c.b.a()) {
                com.baidu.adp.lib.c.b.a("failed to saveInt:" + str + ", " + th.getMessage());
            }
        }
    }

    public boolean ah() {
        return this.ag.getBoolean("alert_sign_on", true);
    }

    public void o(boolean z) {
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
            if (com.baidu.adp.lib.c.b.a()) {
                com.baidu.adp.lib.c.b.c("sign-alert alarm set to :" + com.baidu.tieba.util.y.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, al, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.c.b.a()) {
                com.baidu.adp.lib.c.b.c("sign-alert alarm cancelled.");
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

    public void p(boolean z) {
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

    public void q(boolean z) {
        this.N = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    public boolean aq() {
        return this.N;
    }

    public void r(boolean z) {
        this.Q = z;
        getSharedPreferences("settings", 0).edit().putBoolean("open_local_popularize", z).commit();
    }

    public boolean ar() {
        return false;
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

    public void a(VersionData versionData) {
        this.w = versionData;
    }

    public void a(long j, long j2, long j3, long j4) {
        if (j != this.as || j2 != this.at || j3 != this.au || j4 != this.av) {
            int i2 = 0;
            if (j > this.as || j2 > this.at || j3 > this.au || j4 > this.av) {
                i2 = 1;
            } else if (j < this.as || j2 < this.at || j3 < this.au || j4 < this.av) {
                i2 = 2;
            }
            this.as = j;
            this.at = j2;
            this.au = j3;
            this.av = j4;
            be();
            p(i2);
        }
    }

    public void b(long j, long j2, long j3, long j4) {
        if (j != this.as || j2 != this.at || j3 != this.au || j4 != this.av) {
            this.as = j;
            this.at = j2;
            this.au = j3;
            this.av = j4;
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
                    if (this.as > 0 || this.at > 0) {
                        stringBuffer.append(String.valueOf(this.as + this.at));
                        stringBuffer.append(getString(R.string.notify_msg));
                    }
                    if (this.au > 0) {
                        stringBuffer.append(String.valueOf(this.au));
                        stringBuffer.append(getString(R.string.notify_fans));
                    }
                    if (this.av > 0) {
                        stringBuffer.append(String.valueOf(this.av));
                        stringBuffer.append(getString(R.string.notify_chat));
                    }
                    if (this.au != 0 || this.as != 0 || this.at != 0 || this.av != 0) {
                        if ((this.as > 0 || this.at > 0) && this.au == 0 && this.av == 0) {
                            intent = new Intent(this, MentionActivity.class);
                        } else if (this.au > 0 && this.as == 0 && this.at == 0 && this.av == 0) {
                            intent = new Intent(this, PersonListActivity.class);
                            intent.putExtra("follow", false);
                            intent.putExtra("un", D());
                        } else if (this.av > 0 && this.au == 0 && this.as == 0 && this.at == 0) {
                            intent = new Intent(this, ChatListActivity.class);
                        } else {
                            intent = new Intent(this, PersonInfoActivity.class);
                            intent.putExtra("self", true);
                            intent.putExtra("tab_page", false);
                            intent.putExtra("tab_msg", true);
                            intent.putExtra("un", D());
                        }
                        stringBuffer.append(getString(R.string.notify_click));
                        intent.setFlags(268435456);
                        notification.setLatestEventInfo(this, getString(R.string.app_name), stringBuffer, PendingIntent.getActivity(this, 0, intent, 0));
                        notification.defaults = -1;
                        notification.flags = 16;
                        notification.audioStreamType = 5;
                        if (!this.ap) {
                            notification.defaults &= -2;
                        }
                        if (!this.aq) {
                            notification.defaults &= -3;
                        }
                        this.d.notify(11, notification);
                    }
                } else if (i2 == 2) {
                    this.d.cancel(11);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    public void aw() {
        if (this.d != null) {
            this.d.cancel(11);
        }
    }

    public static boolean ax() {
        return ah;
    }

    public static void s(boolean z) {
        ah = z;
    }

    private void be() {
        Intent intent = new Intent(com.baidu.tieba.data.g.k);
        intent.putExtra("relay", ac());
        intent.putExtra("at_me", ad());
        intent.putExtra("fans", ae());
        intent.putExtra("pletter", af());
        sendBroadcast(intent);
        com.baidu.tieba.util.z.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(ac()), Long.valueOf(ad()), Long.valueOf(ae())));
    }

    public com.baidu.tieba.util.w ay() {
        return this.k;
    }

    public int az() {
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

    public void aA() {
        this.t = System.currentTimeMillis();
    }

    public void aB() {
        this.t = -1L;
    }

    public void aC() {
        if (this.t > 0) {
            this.t = System.currentTimeMillis() - this.t;
            if (this.t > 0) {
                new com.baidu.tieba.account.af("startup_time", String.valueOf(this.t));
            }
            com.baidu.tieba.util.z.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.t));
        }
        this.t = -1L;
    }

    public void aD() {
        this.q++;
        bf();
    }

    public void aE() {
        this.q--;
        bf();
    }

    private void bf() {
        if (p()) {
            if (this.q < 0) {
                this.q = 0;
            }
            if (this.r == 0 && this.q > 0) {
                this.r = System.nanoTime();
            }
            com.baidu.tieba.util.z.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.q));
            this.c.removeMessages(4);
            if (this.q == 0 && this.r > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), 60000L);
            }
        }
    }

    public boolean aF() {
        String string = getSharedPreferences("settings", 0).getString("lase_version", "");
        if (string.equals(com.baidu.tieba.data.g.i())) {
            return false;
        }
        m(string);
        return true;
    }

    public void aG() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("lase_version", com.baidu.tieba.data.g.i());
        edit.commit();
    }

    public void m(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("active_version", str);
        edit.commit();
    }

    public String aH() {
        String string = getSharedPreferences("settings", 0).getString("active_version", "");
        if ("active_clear".equals(string)) {
            return null;
        }
        return string;
    }

    public void aI() {
        m("active_clear");
    }

    public void aJ() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.remove("account_share");
        edit.commit();
    }

    public String aK() {
        return getSharedPreferences("settings", 0).getString("account_share", null);
    }

    public void n(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("account_share", str);
        edit.commit();
    }

    private void bg() {
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
            com.baidu.tieba.util.z.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public void aL() {
        try {
            if (this.F == null || System.currentTimeMillis() - this.a > 300000) {
                this.F = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.E != null) {
                    this.E.removeUpdates(this.aw);
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
                    p("gps");
                } else {
                    this.D = 1;
                }
                if (this.E != null && this.E.isProviderEnabled("network")) {
                    p("network");
                } else {
                    this.D = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), 60000L);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    private void p(String str) {
        if (this.E.isProviderEnabled(str)) {
            this.E.requestLocationUpdates(str, 10000L, 100.0f, this.aw);
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
                TiebaApplication.this.aM();
                TiebaApplication.this.F = new Address(Locale.getDefault());
                TiebaApplication.this.F.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.F.setLongitude(bDLocation.getLongitude());
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
                    TiebaApplication.this.F.setAddressLine(0, stringBuffer.toString());
                }
                TiebaApplication.this.a(TiebaApplication.this.D, "", TiebaApplication.this.F);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public void aM() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.E != null) {
            this.E.removeUpdates(this.aw);
        }
        if (this.A && this.B != null && this.B.isStarted()) {
            this.B.stop();
        }
        if (this.G != null) {
            this.G.cancel();
        }
    }

    public Address aN() {
        if (bg.c().S()) {
            FreeLocationService a = FreeLocationService.a(this);
            if (a != null) {
                return a.a();
            }
            return null;
        }
        return this.F;
    }

    public Address a(av avVar) {
        boolean z;
        if (bg.c().S()) {
            FreeLocationService a = FreeLocationService.a(this);
            if (a != null) {
                return a.a();
            }
            return null;
        } else if (this.F != null && System.currentTimeMillis() - this.a <= 300000) {
            return this.F;
        } else {
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
                aL();
            }
            return null;
        }
    }

    public void b(av avVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.H.size()) {
                SoftReference softReference = (SoftReference) this.H.get(i3);
                av avVar2 = (av) softReference.get();
                if (avVar2 == null || !avVar2.equals(avVar)) {
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

    public int aO() {
        this.y = getSharedPreferences("settings", 0).getInt("check_network_confirm", 0);
        return this.y;
    }

    public int t(boolean z) {
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

    public long aP() {
        return this.s;
    }

    public void a(int i2, int i3, String str) {
        if (this.I == null) {
            this.I = Executors.newSingleThreadExecutor();
        }
        com.baidu.tieba.util.z.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + " img_total" + i3);
        com.baidu.tieba.account.ae aeVar = new com.baidu.tieba.account.ae(i2, i3);
        aeVar.a(str);
        this.I.execute(aeVar);
    }

    public boolean aQ() {
        return this.ax;
    }

    public void u(boolean z) {
        this.ax = z;
        sendBroadcast(new Intent(com.baidu.tieba.data.g.l));
    }

    public static boolean aR() {
        if (f().aQ()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(f().J()).longValue() > 86400000;
        }
        return false;
    }

    public BMapManager aS() {
        return this.ay;
    }

    public boolean c(Context context) {
        boolean z = false;
        try {
            if (this.ay == null) {
                this.ay = new BMapManager(context);
            }
            if (this.ay != null) {
                if (this.ay.init(az, new aw())) {
                    z = true;
                }
            }
        } catch (Exception e) {
            this.ay = null;
            com.baidu.tieba.util.z.a(getClass().getName(), "initEngineManager", e.toString());
        }
        this.aA = z;
        return z;
    }

    public static boolean aT() {
        synchronized (aB) {
            if (aC == null) {
                try {
                    aB.wait();
                } catch (Exception e) {
                    com.baidu.adp.lib.c.b.a(e.getMessage());
                }
            }
            if (aC != null) {
                return aC.booleanValue();
            }
            return false;
        }
    }
}
