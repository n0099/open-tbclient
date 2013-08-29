package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.AlarmManager;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.service.MessagePullService;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.switchs.SwitchModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.av;
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
    private LocationManager E;
    private SharedPreferences ah;
    private boolean al;
    private String am;
    private Boolean z;
    private static AccountData h = null;
    private static String m = null;
    private static boolean n = false;
    private static boolean ai = false;
    private static Intent aj = null;
    private static final byte[] ay = new byte[0];
    private static volatile Boolean az = null;
    private int d = 0;
    private HashMap f = null;
    private boolean g = true;
    private boolean i = false;
    private com.baidu.tieba.util.ag j = null;
    private com.baidu.tieba.util.ag k = null;
    private String l = null;
    private String o = null;
    private int p = 0;
    private long q = 0;
    private long r = 0;
    private long s = -1;
    private String t = null;
    private String u = null;
    private VersionData v = null;
    private BannerData w = null;

    /* renamed from: a  reason: collision with root package name */
    public long f846a = 0;
    private int x = 0;
    private Boolean y = false;
    private boolean A = true;
    private LocationClient B = null;
    private BDLocationListener C = null;
    private int D = 0;
    private Address F = null;
    private al G = null;
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
    private boolean U = false;
    private boolean V = true;
    private com.baidu.adp.lib.cache.q W = null;
    private int X = 0;
    private int Y = 10;
    private int Z = 0;
    private boolean aa = false;
    private boolean ab = true;
    private int ac = 0;
    private long ad = 0;
    private long ae = 0;
    private boolean af = false;
    private long ag = 0;
    public ArrayList b = null;
    private Hashtable ak = null;
    private Hashtable an = null;
    private Hashtable ao = null;
    public Handler c = new Handler(new ai(this));
    private int ap = 0;
    private boolean aq = true;
    private boolean ar = true;
    private boolean as = true;
    private boolean at = true;
    private boolean au = false;
    private boolean av = true;
    private final LocationListener aw = new aj(this);
    private boolean ax = false;

    public void a(Boolean bool) {
        this.y = bool;
    }

    public Boolean d() {
        return this.y;
    }

    public static void a(Intent intent) {
        aj = intent;
    }

    public static Intent e() {
        return aj;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        e = this;
        this.ah = getSharedPreferences("settings", 0);
        new am(null).execute(new String[0]);
        NetWorkCore.z();
        bg();
        bh();
        bc();
        bf();
        av.a(this);
        m = a((Context) this);
        bd();
        be();
        com.baidu.tieba.data.g.d(this);
        com.baidu.tieba.data.g.b(this);
        com.baidu.tieba.data.g.c(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.util.as());
        } catch (SecurityException e2) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "onCreate", e2.getMessage());
        }
        if (s()) {
            this.ac = this.ah.getInt("guide_page_bits", 0);
            if (aC()) {
                this.ac = 0;
                SharedPreferences.Editor edit = this.ah.edit();
                edit.putInt("guide_page_bits", this.ac);
                edit.commit();
                com.baidu.adp.lib.a.d.a().b();
            }
            com.baidu.tbadk.a.e.a().a(50, com.baidu.tieba.data.g.e());
            com.baidu.adp.lib.c.c.a().a(com.baidu.tieba.util.a.d.a());
            com.baidu.tbadk.a.a.a().a(this, new com.baidu.tieba.util.o());
            aL();
            this.f = new HashMap();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                h = DatabaseService.n();
            }
            if (p()) {
                c.a(this);
            } else {
                com.baidu.tieba.account.a.a().b(this);
            }
            DatabaseService.v();
            m();
            this.j = new com.baidu.tieba.util.ag(300);
            this.k = new com.baidu.tieba.util.ag(100);
            com.baidu.tieba.mention.r.a().b();
            new com.baidu.tieba.account.ag("open").start();
            if (U()) {
                n();
            }
            if (al()) {
                new com.baidu.tieba.account.ag("frs_abstract", "1").start();
            }
            bm();
            this.H = new ArrayList();
            af();
            new com.baidu.tieba.data.a.a().a();
            k();
            l();
        } else {
            this.b = new ArrayList();
        }
        try {
            registerReceiver(new com.baidu.tieba.service.g(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e3) {
            com.baidu.adp.lib.e.d.a(e3.getMessage());
        }
        com.baidu.tieba.util.ar.a(this);
        TbImageView.setSkinMode(this.O);
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
        if (com.baidu.adp.lib.e.d.a()) {
            com.baidu.adp.lib.e.d.b("device:[" + trim + "], default GPU on:" + z);
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
        return (this.an == null || str == null || !this.an.containsKey(str)) ? false : true;
    }

    public void c(String str) {
        if (!b(str) && this.an != null && str != null) {
            if (this.an.size() > 100) {
                this.an.clear();
            }
            this.an.put(str, 1);
        }
    }

    public void i() {
        if (this.an != null) {
            this.an.clear();
        }
    }

    public int j() {
        if (this.an != null) {
            return this.an.size();
        }
        return 0;
    }

    public void k() {
        if (this.an == null) {
            this.an = new Hashtable();
        }
    }

    public int d(String str) {
        if (this.ao == null || str == null || !this.ao.containsKey(str)) {
            return 0;
        }
        return ((Integer) this.ao.get(str)).intValue();
    }

    public void e(String str) {
        if (this.ao != null && str != null) {
            this.ao.put(str, 1);
            i(true);
            if (this.ao.size() > 200) {
                this.ao.clear();
            }
        }
    }

    public void f(String str) {
        if (this.ao != null && str != null) {
            this.ao.put(str, -1);
            i(true);
            if (this.ao.size() > 200) {
                this.ao.clear();
            }
        }
    }

    public void l() {
        if (this.ao == null) {
            this.ao = new Hashtable();
        }
    }

    public boolean g(String str) {
        return (this.ak == null || str == null || !this.ak.containsKey(str)) ? false : true;
    }

    public void h(String str) {
        if (!g(str) && this.ak != null && str != null) {
            this.ak.put(str, 1);
            new com.baidu.tieba.util.q(1, str).start();
        }
    }

    public void i(String str) {
        if (g(str) && this.ak != null && str != null) {
            this.ak.remove(str);
            new com.baidu.tieba.util.q(2, str).start();
        }
    }

    public void m() {
        this.ak = new Hashtable();
        new com.baidu.tieba.util.q(this.ak).start();
    }

    public void n() {
        try {
            startService(new Intent(this, MessagePullService.class));
        } catch (Exception e2) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "startPullMessageService", e2.toString());
        }
    }

    public void o() {
        stopService(new Intent(this, MessagePullService.class));
    }

    public void a(g gVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                try {
                    ((g) this.b.get(i)).a_();
                } catch (Exception e2) {
                    com.baidu.tieba.util.aq.b(getClass().getName(), "addRemoteActivity", e2.getMessage());
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

    private void bc() {
        if (Build.VERSION.SDK_INT >= 5) {
            n = new AccountProxy(this).hasBaiduAccount();
        } else {
            n = false;
        }
    }

    public static boolean p() {
        return n;
    }

    private void bd() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.l = telephonyManager.getDeviceId();
        }
    }

    private void be() {
        if ((this.u == null || this.u.length() < 0) && s()) {
            this.u = CommonParam.getCUID(this);
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("cuid", this.u);
            edit.commit();
        }
    }

    public String q() {
        return this.u;
    }

    public String r() {
        return this.l;
    }

    public boolean s() {
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

    private void bf() {
        SwitchModel.initSwitchManager();
        SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
        this.J = sharedPreferences.getInt("image_quality", 2);
        this.K = sharedPreferences.getInt("view_image_quality", 2);
        this.L = sharedPreferences.getBoolean("show_images", true);
        this.M = sharedPreferences.getInt("font_size", 2);
        this.av = sharedPreferences.getBoolean("permoted_message", true);
        this.g = sharedPreferences.getBoolean("display_photo", true);
        this.N = sharedPreferences.getBoolean("abstract_state", true);
        this.O = sharedPreferences.getInt("skin", 0);
        this.r = sharedPreferences.getLong("message_id", 0L);
        this.T = sharedPreferences.getBoolean("gpu_open", f());
        this.U = sharedPreferences.getBoolean("app_switcher", false);
        this.aa = sharedPreferences.getBoolean("manage_mode", false);
        this.P = sharedPreferences.getBoolean("location_on", true);
        this.ad = sharedPreferences.getLong("refresh_recommend_time", 0L);
        this.ae = sharedPreferences.getLong("refresh_guess_time", 0L);
        this.Q = sharedPreferences.getBoolean("open_local_popularize", false);
        this.af = sharedPreferences.getBoolean("local_app_has_showed_in_nearby", false);
        this.t = sharedPreferences.getString("show_all_like_items", null);
        this.X = sharedPreferences.getInt("webview_crash_count", 0);
        this.Z = sharedPreferences.getInt("new_vcode_webview_crash_count", 0);
        this.A = sharedPreferences.getBoolean("bd_loc_switcher", true);
        this.ab = sharedPreferences.getBoolean("search_mode", true);
        this.ag = sharedPreferences.getLong("show_nearby_guide_time", 0L);
        this.u = sharedPreferences.getString("cuid", null);
        this.Y = sharedPreferences.getInt("perform_sample_count", 0);
        if (Build.VERSION.SDK_INT <= 4) {
            this.A = false;
        }
        this.am = sharedPreferences.getString("last_recommend_time", "");
    }

    public void a(boolean z) {
        this.A = z;
        if (s()) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putBoolean("bd_loc_switcher", this.A);
            edit.commit();
        }
    }

    public void b(boolean z) {
        this.ab = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("search_mode", this.ab);
        edit.commit();
    }

    public boolean t() {
        return this.ab;
    }

    public boolean u() {
        return this.V;
    }

    public void c(boolean z) {
        this.V = z;
    }

    public boolean v() {
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
        edit.putBoolean("gpu_open", z);
        edit.commit();
        this.T = z;
    }

    public boolean w() {
        return this.T;
    }

    public void f(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("moplus_service", z);
        edit.commit();
    }

    public boolean x() {
        return getSharedPreferences("settings", 0).getBoolean("moplus_service", true);
    }

    public void g(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("push_service", z);
        edit.commit();
    }

    public boolean y() {
        return getSharedPreferences("settings", 0).getBoolean("push_service", true);
    }

    public void h(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.U = z;
    }

    public boolean z() {
        return this.U;
    }

    private void bg() {
        try {
            com.baidu.tieba.data.g.c(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            if (com.baidu.tieba.data.g.j() == null) {
                com.baidu.tieba.data.g.c("");
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "InitVersion", e2.getMessage());
            com.baidu.tieba.data.g.c("");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bh() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String bi = bi();
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.tieba.data.g.b(readLine);
                    if (bi == null) {
                        String bj = bj();
                        if (bj != null && bj.length() > 0) {
                            com.baidu.tieba.data.g.a(bj);
                            w(bj);
                        } else if (readLine != null && readLine.length() > 0) {
                            com.baidu.tieba.data.g.a(readLine);
                            w(readLine);
                            x(readLine);
                        }
                    } else {
                        com.baidu.tieba.data.g.a(bi);
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
                    com.baidu.tieba.util.aq.b(getClass().getName(), "InitFrom", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    com.baidu.tieba.util.aq.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.g.a());
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
        com.baidu.tieba.util.aq.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.g.a());
    }

    private String bi() {
        return getSharedPreferences("settings", 0).getString("from_id", null);
    }

    private void w(String str) {
        if (str != null && str.length() > 0 && s()) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("from_id", str);
            edit.commit();
        }
    }

    private String bj() {
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
            com.baidu.tieba.util.aq.b(getClass().getName(), "getFromByFile", e2.getMessage());
        }
        return str;
    }

    private void x(String str) {
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
                com.baidu.tieba.util.aq.b(getClass().getName(), "saveFromToFile", e3.getMessage());
            }
        }
    }

    public static String A() {
        return com.baidu.tieba.data.g.a();
    }

    public void B() {
        com.baidu.tieba.mention.r.a().a(true);
        DatabaseService.v();
    }

    public com.baidu.adp.widget.a.b j(String str) {
        SoftReference softReference = (SoftReference) this.f.get(str);
        if (softReference != null && softReference.get() != null) {
            return (com.baidu.adp.widget.a.b) softReference.get();
        }
        com.baidu.adp.widget.a.b a2 = com.baidu.tbadk.a.a.a().a(str);
        if (a2 != null) {
            this.f.put(str, new SoftReference(a2));
            return a2;
        }
        return a2;
    }

    public void b(Boolean bool) {
        this.g = bool.booleanValue();
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("display_photo", bool.booleanValue());
        edit.commit();
    }

    public boolean C() {
        return this.g;
    }

    public void a(long j) {
        this.ad = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public long D() {
        return this.ad;
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
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.a.e.a().b(max);
        }
    }

    public static String E() {
        if (h != null) {
            com.baidu.tieba.util.aq.a("TiebaApplication", "getCurrentAccount", String.valueOf(h.getID()));
            return h.getID();
        }
        return null;
    }

    public static boolean F() {
        String E = E();
        return E != null && E.length() > 0;
    }

    public static void a(AccountData accountData, Context context) {
        boolean z = true;
        if ((accountData != null || h == null) && ((h != null || accountData == null) && (h == null || accountData == null || TextUtils.equals(h.getAccount(), accountData.getAccount())))) {
            z = false;
        }
        if (z) {
            com.baidu.tieba.mention.r.a().c();
        }
        h = accountData;
        if (g().y()) {
            UtilHelper.g(context);
        } else {
            UtilHelper.h(context);
        }
        if (accountData != null) {
            com.baidu.tieba.util.ar.a(accountData.getAccount(), accountData.getID());
        }
    }

    public static String G() {
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

    public static AccountData H() {
        return h;
    }

    public static String I() {
        if (h != null) {
            return h.getAccount();
        }
        return null;
    }

    public int J() {
        int i = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        com.baidu.tieba.util.aq.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i));
        return i;
    }

    public void a(int i) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i);
        edit.commit();
    }

    public long K() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        com.baidu.tieba.util.aq.a("TiebaApplication", "getTDatabaseCreateTime", com.baidu.tieba.util.ap.a(j));
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

    public void l(String str) {
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

    public void m(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (h != null) {
                    h.setTbs(str);
                }
            }
        }
    }

    public String P() {
        if (h != null) {
            return h.getTbs();
        }
        return null;
    }

    public String a(Context context) {
        String str = null;
        String string = context.getSharedPreferences("settings", 0).getString("client_id", null);
        if (string != null) {
            int indexOf = string.indexOf("\t");
            if (indexOf != -1) {
                if (com.baidu.tieba.data.g.j().equals(string.substring(0, indexOf))) {
                    str = string.substring(indexOf + 1);
                } else {
                    b((Context) g());
                }
            } else {
                b((Context) g());
            }
        } else {
            str = string;
        }
        com.baidu.tieba.util.aq.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String Q() {
        return m;
    }

    public void b(Context context) {
        if (s()) {
            SharedPreferences.Editor edit = context.getSharedPreferences("settings", 0).edit();
            edit.remove("client_id");
            edit.commit();
        }
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences("settings", 0).edit();
            edit.putString("client_id", String.valueOf(com.baidu.tieba.data.g.j()) + "\t" + str);
            edit.commit();
        }
    }

    public static void n(String str) {
        m = str;
    }

    public void i(boolean z) {
        this.i = z;
    }

    public boolean R() {
        return this.i;
    }

    public int S() {
        return this.ap;
    }

    public void T() {
        c(300);
        m(true);
        o(true);
        n(true);
    }

    public void j(boolean z) {
        this.av = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            n();
        } else {
            o();
        }
    }

    public boolean U() {
        return this.av;
    }

    public void k(boolean z) {
        if (this.at != z) {
            this.at = z;
        }
    }

    public boolean V() {
        return this.at;
    }

    public void l(boolean z) {
        this.au = z;
    }

    public boolean W() {
        return this.au;
    }

    public int X() {
        if (!this.at && !this.au) {
            return 0;
        }
        if (this.at && !this.au) {
            return 1;
        }
        if (!this.at && this.au) {
            return 2;
        }
        return 3;
    }

    public void b(int i) {
        if (i == 0) {
            g().k(false);
            g().l(false);
        } else if (i == 1) {
            g().k(true);
            g().l(false);
        } else if (i == 2) {
            g().k(false);
            g().l(true);
        } else {
            g().k(true);
            g().l(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 int)] */
    public void c(int i) {
        com.baidu.tieba.util.aq.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i).toString());
        this.ap = i;
        if (i == 0) {
            com.baidu.tieba.mention.r.a().a(true);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean Y() {
        return this.aq;
    }

    public void m(boolean z) {
        this.aq = z;
        if (!z) {
            com.baidu.tieba.mention.r.a().c(0L);
        }
    }

    public boolean Z() {
        return this.ar;
    }

    public void n(boolean z) {
        this.ar = z;
        if (!z) {
            com.baidu.tieba.mention.r.a().b(0L);
        }
    }

    public boolean aa() {
        return this.as;
    }

    public void o(boolean z) {
        this.as = z;
        if (!z) {
            com.baidu.tieba.mention.r.a().a(0L);
        }
    }

    public boolean ab() {
        return this.ap > 0;
    }

    protected void a(String str, boolean z) {
        try {
            SharedPreferences.Editor edit = this.ah.edit();
            edit.putBoolean(str, z);
            edit.commit();
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.a("failed to saveBoolean:" + str + ", " + th.getMessage());
            }
        }
    }

    protected void a(String str, int i) {
        try {
            SharedPreferences.Editor edit = this.ah.edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.a("failed to saveInt:" + str + ", " + th.getMessage());
            }
        }
    }

    public boolean ac() {
        return this.ah.getBoolean("alert_sign_on", false);
    }

    public void p(boolean z) {
        a("alert_sign_on", z);
        af();
    }

    public int ad() {
        int i = this.ah.getInt("alert_sign_hours", -1);
        if (i == -1) {
            bk();
            return this.ah.getInt("alert_sign_hours", 12);
        }
        return i;
    }

    private void bk() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int ae() {
        int i = this.ah.getInt("alert_sign_mins", -1);
        if (i == -1) {
            bk();
            return this.ah.getInt("alert_sign_mins", 30);
        }
        return i;
    }

    public void a(int i, int i2) {
        a("alert_sign_hours", i);
        a("alert_sign_mins", i2);
        af();
    }

    public void af() {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent ag = ag();
        if (ac()) {
            Calendar calendar = Calendar.getInstance();
            int ad = ad();
            int i = calendar.get(11);
            int ae = ae();
            int i2 = calendar.get(12);
            calendar.set(11, ad);
            calendar.set(12, ae);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= ad && (i != ad || i2 >= ae)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this, 0, ag, 268435456));
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.c("sign-alert alarm set to :" + com.baidu.tieba.util.ap.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, ag, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.c("sign-alert alarm cancelled.");
            }
        }
    }

    protected Intent ag() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.signalert");
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(this, SignAlertReceiver.class);
        return intent;
    }

    public int ah() {
        return this.J;
    }

    public int ai() {
        return this.K;
    }

    public void d(int i) {
        if (this.J != i) {
            this.J = i;
            getSharedPreferences("settings", 0).edit().putInt("image_quality", i).commit();
        }
    }

    public void e(int i) {
        if (this.K != i) {
            this.K = i;
            getSharedPreferences("settings", 0).edit().putInt("view_image_quality", i).commit();
        }
    }

    public boolean aj() {
        return this.L;
    }

    public void q(boolean z) {
        if (this.L != z) {
            this.L = z;
            getSharedPreferences("settings", 0).edit().putBoolean("show_images", z).commit();
        }
    }

    public int ak() {
        return this.M;
    }

    public void f(int i) {
        if (this.M != i) {
            this.M = i;
            getSharedPreferences("settings", 0).edit().putInt("font_size", i).commit();
        }
    }

    public void r(boolean z) {
        this.N = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    public boolean al() {
        return this.N;
    }

    public void s(boolean z) {
        this.Q = z;
        getSharedPreferences("settings", 0).edit().putBoolean("open_local_popularize", z).commit();
    }

    public boolean am() {
        return this.Q;
    }

    public void g(int i) {
        AppsActivity.b();
        h(i);
        getSharedPreferences("settings", 0).edit().putInt("skin", i).commit();
        TbImageView.setSkinMode(i);
        p(i);
    }

    public void h(int i) {
        this.O = i;
    }

    private void p(int i) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i);
        sendBroadcast(intent);
    }

    public int an() {
        return this.O;
    }

    public int ao() {
        return this.X;
    }

    public void i(int i) {
        this.X = i;
        getSharedPreferences("settings", 0).edit().putInt("webview_crash_count", i).commit();
    }

    public int ap() {
        return this.Y;
    }

    public void j(int i) {
        this.Y = i;
        getSharedPreferences("settings", 0).edit().putInt("perform_sample_count", i).commit();
    }

    public int aq() {
        return this.Z;
    }

    public void k(int i) {
        this.Z = i;
        getSharedPreferences("settings", 0).edit().putInt("new_vcode_webview_crash_count", i).commit();
    }

    public void o(String str) {
        getSharedPreferences("settings", 0).edit().putString("pk_before_message_id", str).commit();
    }

    public String ar() {
        return getSharedPreferences("settings", 0).getString("pk_before_message_id", "");
    }

    public void p(String str) {
        getSharedPreferences("settings", 0).edit().putString("pk_after_message_id", str).commit();
    }

    public String as() {
        return getSharedPreferences("settings", 0).getString("pk_after_message_id", "");
    }

    public void at() {
        int i = getSharedPreferences("settings", 0).getInt("bd_loc_crash_count", 0) + 1;
        getSharedPreferences("settings", 0).edit().putInt("bd_loc_crash_count", i).commit();
        if (i > 3) {
            a(false);
        }
    }

    public void a(VersionData versionData) {
        this.v = versionData;
    }

    public static boolean au() {
        return ai;
    }

    public static void t(boolean z) {
        ai = z;
    }

    public com.baidu.tieba.util.ag av() {
        return this.j;
    }

    public int aw() {
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
                com.baidu.tieba.util.ar.a("op_launch", this.s, 0L);
            }
            com.baidu.tieba.util.aq.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.s));
        }
        this.s = -1L;
    }

    public void aA() {
        this.p++;
        bl();
    }

    public void aB() {
        this.p--;
        bl();
    }

    private void bl() {
        if (s()) {
            if (this.p < 0) {
                this.p = 0;
            }
            if (this.q == 0 && this.p > 0) {
                this.q = System.nanoTime();
            }
            com.baidu.tieba.util.aq.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.p));
            this.c.removeMessages(4);
            if (this.p == 0 && this.q > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), Util.MILLSECONDS_OF_MINUTE);
            }
        }
    }

    public boolean aC() {
        String string = getSharedPreferences("main_settings", 0).getString("lase_version", "");
        if (string.equals(com.baidu.tieba.data.g.j())) {
            return false;
        }
        q(string);
        return true;
    }

    public void aD() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("lase_version", com.baidu.tieba.data.g.j());
        edit.commit();
        SharedPreferences.Editor edit2 = getSharedPreferences("main_settings", 0).edit();
        edit2.putString("lase_version", com.baidu.tieba.data.g.j());
        edit2.commit();
    }

    public void q(String str) {
        if (s()) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("active_version", str);
            edit.commit();
        }
    }

    public String aE() {
        String string = getSharedPreferences("settings", 0).getString("active_version", "");
        if ("active_clear".equals(string)) {
            return null;
        }
        return string;
    }

    public void aF() {
        q("active_clear");
    }

    public void aG() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.remove("account_share");
        edit.commit();
    }

    public String aH() {
        return getSharedPreferences("settings", 0).getString("account_share", null);
    }

    public void r(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("account_share", str);
        edit.commit();
    }

    private void bm() {
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
        } catch (Exception e2) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "initLocationServer", e2.toString());
        }
    }

    public void aI() {
        try {
            if (this.F == null || System.currentTimeMillis() - this.f846a > 300000) {
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
                    y("gps");
                } else {
                    this.D = 1;
                }
                if (this.E != null && this.E.isProviderEnabled("network")) {
                    y("network");
                } else {
                    this.D = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), Util.MILLSECONDS_OF_MINUTE);
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "startLocationServer", e2.toString());
        }
    }

    private void y(String str) {
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
                TiebaApplication.this.aJ();
                TiebaApplication.this.F = new Address(Locale.getDefault());
                TiebaApplication.this.F.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.F.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.f846a = System.currentTimeMillis();
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

    public void aJ() {
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

    public Address aK() {
        return this.F;
    }

    public Address a(ak akVar) {
        boolean z;
        if (this.F != null && System.currentTimeMillis() - this.f846a <= 300000) {
            return this.F;
        }
        if (akVar != null) {
            int i = 0;
            while (true) {
                if (i < this.H.size()) {
                    ak akVar2 = (ak) ((SoftReference) this.H.get(i)).get();
                    if (akVar2 == null || !akVar2.equals(akVar)) {
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
                if (this.H.size() > 10) {
                    this.H.remove(0);
                }
                this.H.add(new SoftReference(akVar));
            }
            aI();
        }
        return null;
    }

    public void a(int i, String str, Address address) {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.H != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.H.size()) {
                    ak akVar = (ak) ((SoftReference) this.H.get(i3)).get();
                    if (akVar != null) {
                        akVar.a(i, str, address);
                    }
                    i2 = i3 + 1;
                } else {
                    this.H.clear();
                    return;
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        x(z2);
        this.x = 0;
        this.x |= 1;
        if (z) {
            this.R = true;
            this.x |= 2;
        } else {
            this.R = false;
            if (z2) {
                this.x |= 4;
            }
        }
        edit.putInt("check_network_notify_confirm", this.x);
        edit.commit();
    }

    public int aL() {
        this.x = getSharedPreferences("settings", 0).getInt("check_network_notify_confirm", 0);
        return this.x;
    }

    public int aM() {
        if ((this.x & 1) == 0) {
            return -1;
        }
        if ((this.x & 2) == 0) {
            this.R = false;
            return (this.x & 4) == 0 ? 2 : 1;
        }
        this.R = true;
        return 0;
    }

    public void c(long j) {
        this.r = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("message_id", j);
        edit.commit();
    }

    public long aN() {
        return this.r;
    }

    public void a(int i, int i2, String str) {
        if (this.I == null) {
            this.I = Executors.newSingleThreadExecutor();
        }
        com.baidu.tieba.util.aq.a(getClass().getName(), "pv_addImagePv", "img_num=" + i + " img_total" + i2);
        com.baidu.tieba.account.af afVar = new com.baidu.tieba.account.af(i, i2);
        afVar.a(str);
        this.I.execute(afVar);
    }

    public boolean aO() {
        return this.ax;
    }

    public void u(boolean z) {
        this.ax = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aP() {
        if (g().aO()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(g().L()).longValue() > Util.MILLSECONDS_OF_DAY;
        }
        return false;
    }

    public static boolean aQ() {
        synchronized (ay) {
            while (az == null) {
                try {
                    ay.wait();
                } catch (Exception e2) {
                    com.baidu.adp.lib.e.d.a(e2.getMessage());
                }
            }
            if (az != null) {
                return az.booleanValue();
            }
            return false;
        }
    }

    public void v(boolean z) {
        this.al = z;
    }

    public boolean aR() {
        return this.R;
    }

    public void s(String str) {
        this.am = str;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("last_recommend_time", str);
        edit.commit();
    }

    public void w(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("is_pk_offline", z);
        edit.commit();
    }

    public boolean aS() {
        return getSharedPreferences("settings", 0).getBoolean("is_pk_offline", false);
    }

    public void t(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("pk_change_title", str);
        edit.commit();
    }

    public void u(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("pk_change_link", str);
        edit.commit();
    }

    public long aT() {
        return getSharedPreferences("settings", 0).getLong("last_notify_sound_time", 0L);
    }

    public void d(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("last_notify_sound_time", j);
        edit.commit();
    }

    public int aU() {
        return getSharedPreferences("settings", 0).getInt("kn_vote_cd", 600);
    }

    public void l(int i) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("kn_vote_cd", i);
        edit.commit();
    }

    public int aV() {
        return getSharedPreferences("settings", 0).getInt("networkcore_type", 1);
    }

    public void m(int i) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("networkcore_type", i);
        edit.commit();
    }

    public int aW() {
        return getSharedPreferences("settings", 0).getInt("kn_vote_max", 10);
    }

    public void n(int i) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("kn_vote_max", i);
        edit.commit();
    }

    public int aX() {
        return getSharedPreferences("settings", 0).getInt("kn_vote_rate", 10);
    }

    public void o(int i) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("kn_vote_rate", i);
        edit.commit();
    }

    public void v(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("push_channel_id", str);
        edit.commit();
    }

    public String aY() {
        return getSharedPreferences("settings", 0).getString("push_channel_id", "");
    }

    public void x(boolean z) {
        if (z) {
            if (aj()) {
                e(1);
            }
            y(true);
            d(1);
            return;
        }
        if (aj()) {
            e(2);
        }
        y(false);
        if (ah() == 1) {
            d(2);
        }
    }

    public void y(boolean z) {
        this.S = z;
    }

    public boolean aZ() {
        return this.S;
    }

    public com.baidu.adp.lib.cache.q ba() {
        if (this.W == null) {
            this.W = BdCacheService.c().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.W;
    }
}
