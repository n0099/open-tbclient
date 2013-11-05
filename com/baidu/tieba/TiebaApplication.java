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
import android.os.Message;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.account.AccountProxy;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.android.common.util.CommonParam;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.im.message.BackgroundSwitchMessage;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.switchs.SwitchModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.util.bj;
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
    private static boolean Z = false;
    private static Intent ab = null;
    private static final byte[] as = new byte[0];
    private static volatile Boolean at = null;
    private int d = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.e>> f = null;
    private int g = 1;
    private boolean i = false;
    private com.baidu.tieba.util.at j = null;
    private com.baidu.tieba.util.at k = null;
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
    public long f988a = 0;
    private Boolean w = false;
    private boolean y = true;
    private LocationClient z = null;
    private BDLocationListener A = null;
    private int B = 0;
    private Address D = null;
    private av E = null;
    private ArrayList<SoftReference<au>> F = null;
    private ExecutorService G = null;
    private int H = 0;
    private int I = 0;
    private boolean J = true;
    private int K = 3;
    private int L = 1;
    private int M = 0;
    private boolean N = true;
    private boolean O = false;
    private int P = 0;
    private boolean Q = false;
    private boolean R = false;
    private boolean S = true;
    private com.baidu.adp.lib.cache.s<String> T = null;
    private int U = 0;
    private int V = 10;
    private int W = 0;
    private boolean X = false;
    private boolean Y = true;
    private boolean aa = false;
    public ArrayList<j> b = null;
    private Hashtable<String, Integer> ac = null;
    private Hashtable<String, Integer> ad = null;
    private Hashtable<String, Integer> ae = null;
    public Handler c = new Handler(new aq(this));
    private int af = 0;
    private boolean ag = true;
    private boolean ah = true;
    private boolean ai = true;
    private boolean aj = true;
    private boolean ak = false;
    private boolean al = true;
    private boolean am = true;
    private boolean an = false;
    private String ao = "23:00";
    private String ap = "09:00";
    private final LocationListener aq = new at(this);
    private boolean ar = false;

    public void a(Boolean bool) {
        this.w = bool;
    }

    public Boolean d() {
        return this.w;
    }

    public static void a(Intent intent) {
        ab = intent;
    }

    public static Intent e() {
        return ab;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        e = this;
        new aw(null).execute(new String[0]);
        NetWorkCore.A();
        bn();
        if (q()) {
            com.baidu.tieba.sharedPref.b.a().b();
        }
        bo();
        bj();
        bm();
        bj.a(this);
        m = a((Context) this);
        bk();
        bl();
        com.baidu.tieba.data.h.d(this);
        com.baidu.tieba.data.h.b(this);
        com.baidu.tieba.data.h.c(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new bg());
        } catch (SecurityException e2) {
            be.b(getClass().getName(), "onCreate", e2.getMessage());
        }
        bf.a(this);
        if (q()) {
            if (aH()) {
                com.baidu.adp.lib.a.d.a().b();
            }
            com.baidu.tbadk.imageManager.d.a().a(50, com.baidu.tieba.data.h.e());
            com.baidu.adp.lib.e.c.a().a(com.baidu.tieba.util.a.e.a());
            TbFaceManager.a().a(this, new com.baidu.tieba.util.v());
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
            this.j = new com.baidu.tieba.util.at(300);
            this.k = new com.baidu.tieba.util.at(100);
            com.baidu.tieba.mention.t.a().b();
            new com.baidu.tieba.account.ah("open").start();
            if (ar()) {
                new com.baidu.tieba.account.ah("frs_abstract", SocialConstants.TRUE).start();
            }
            bu();
            this.F = new ArrayList<>();
            aj();
            new com.baidu.tieba.data.chat.a().a();
            k();
            l();
            com.baidu.tieba.im.i.a(this);
        } else {
            this.b = new ArrayList<>();
        }
        try {
            registerReceiver(new com.baidu.tieba.service.f(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e3) {
            com.baidu.adp.lib.h.d.a(e3.getMessage());
        }
        TbImageView.setSkinMode(this.M);
        try {
            com.baidu.adp.lib.c.a.a().a(this, "tieba");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (q()) {
            bs();
        }
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
            if (i >= length) {
                z = true;
                break;
            } else if (strArr[i].equalsIgnoreCase(trim)) {
                break;
            } else {
                i++;
            }
        }
        if (com.baidu.adp.lib.h.d.a()) {
            com.baidu.adp.lib.h.d.c("device:[" + trim + "], default GPU on:" + z);
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
        if (this.ad == null || str == null) {
            return false;
        }
        return this.ad.containsKey(str);
    }

    public void c(String str) {
        if (!b(str) && this.ad != null && str != null) {
            if (this.ad.size() > 100) {
                this.ad.clear();
            }
            this.ad.put(str, 1);
        }
    }

    public void i() {
        if (this.ad != null) {
            this.ad.clear();
        }
    }

    public int j() {
        if (this.ad != null) {
            return this.ad.size();
        }
        return 0;
    }

    public void k() {
        if (this.ad == null) {
            this.ad = new Hashtable<>();
        }
    }

    public int d(String str) {
        if (this.ae == null || str == null || !this.ae.containsKey(str)) {
            return 0;
        }
        return this.ae.get(str).intValue();
    }

    public void e(String str) {
        if (this.ae != null && str != null) {
            this.ae.put(str, 1);
            h(true);
            if (this.ae.size() > 200) {
                this.ae.clear();
            }
        }
    }

    public void f(String str) {
        if (this.ae != null && str != null) {
            this.ae.put(str, -1);
            h(true);
            if (this.ae.size() > 200) {
                this.ae.clear();
            }
        }
    }

    public void l() {
        if (this.ae == null) {
            this.ae = new Hashtable<>();
        }
    }

    public boolean g(String str) {
        if (this.ac == null || str == null) {
            return false;
        }
        return this.ac.containsKey(str);
    }

    public void h(String str) {
        if (!g(str) && this.ac != null && str != null) {
            this.ac.put(str, 1);
            new com.baidu.tieba.util.x(1, str).start();
        }
    }

    public void i(String str) {
        if (g(str) && this.ac != null && str != null) {
            this.ac.remove(str);
            new com.baidu.tieba.util.x(2, str).start();
        }
    }

    public void m() {
        this.ac = new Hashtable<>();
        new com.baidu.tieba.util.x(this.ac).start();
    }

    public void a(j jVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.b.get(i).a_();
                } catch (Exception e2) {
                    be.b(getClass().getName(), "addRemoteActivity", e2.getMessage());
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

    private void bj() {
        if (Build.VERSION.SDK_INT >= 5) {
            n = new AccountProxy(this).hasBaiduAccount();
        } else {
            n = false;
        }
    }

    public static boolean n() {
        return n;
    }

    private void bk() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.l = telephonyManager.getDeviceId();
        }
    }

    private void bl() {
        if (this.t == null || this.t.length() < 0) {
            this.t = CommonParam.getCUID(this);
            com.baidu.adp.lib.h.d.c("----cuid:" + this.t);
            com.baidu.tieba.sharedPref.b.a().b(SocialConstants.PARAM_CUID, this.t);
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

    private void bm() {
        SwitchModel.initSwitchManager();
        this.H = com.baidu.tieba.sharedPref.b.a().a("image_quality", 0);
        this.I = com.baidu.tieba.sharedPref.b.a().a("view_image_quality", 0);
        this.J = com.baidu.tieba.sharedPref.b.a().a("show_images", true);
        this.K = com.baidu.tieba.sharedPref.b.a().a("font_size", 2);
        this.al = com.baidu.tieba.sharedPref.b.a().a("permoted_message", true);
        this.g = com.baidu.tieba.sharedPref.b.a().a("new_display_photo", 1);
        this.L = com.baidu.tieba.sharedPref.b.a().a("new_abstract_state", 0);
        this.M = com.baidu.tieba.sharedPref.b.a().a("skin", 0);
        this.r = com.baidu.tieba.sharedPref.b.a().a("message_id", 0L);
        this.P = com.baidu.tieba.sharedPref.b.a().a("voice_headset_mode", 0);
        this.Q = com.baidu.tieba.sharedPref.b.a().a("gpu_open", f());
        this.R = com.baidu.tieba.sharedPref.b.a().a("app_switcher", false);
        this.X = com.baidu.tieba.sharedPref.b.a().a("manage_mode", false);
        this.N = com.baidu.tieba.sharedPref.b.a().a("location_on", true);
        this.O = com.baidu.tieba.sharedPref.b.a().a("open_local_popularize", false);
        this.U = com.baidu.tieba.sharedPref.b.a().a("webview_crash_count", 0);
        this.W = com.baidu.tieba.sharedPref.b.a().a("new_vcode_webview_crash_count", 0);
        this.y = com.baidu.tieba.sharedPref.b.a().a("bd_loc_switcher", true);
        this.Y = com.baidu.tieba.sharedPref.b.a().a("search_mode", true);
        this.t = com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CUID, (String) null);
        this.V = com.baidu.tieba.sharedPref.b.a().a("perform_sample_count", 0);
        if (Build.VERSION.SDK_INT <= 4) {
            this.y = false;
        }
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.DEBUG) == 0) {
            com.baidu.tieba.util.o.a(true);
        } else {
            com.baidu.tieba.util.o.a(false);
        }
    }

    public void a(boolean z) {
        this.y = z;
        com.baidu.tieba.sharedPref.b.a().b("bd_loc_switcher", z);
    }

    public void b(boolean z) {
        this.Y = z;
        com.baidu.tieba.sharedPref.b.a().b("search_mode", z);
    }

    public boolean r() {
        return this.Y;
    }

    public boolean s() {
        return this.S;
    }

    public void c(boolean z) {
        this.S = z;
    }

    public boolean t() {
        return this.N;
    }

    public void d(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("gpu_open", z);
        this.Q = z;
    }

    public boolean u() {
        return this.Q;
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
        this.R = z;
    }

    public boolean x() {
        return this.R;
    }

    private void bn() {
        try {
            com.baidu.tieba.data.h.c(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            if (com.baidu.tieba.data.h.j() == null) {
                com.baidu.tieba.data.h.c("");
            }
        } catch (Exception e2) {
            be.b(getClass().getName(), "InitVersion", e2.getMessage());
            com.baidu.tieba.data.h.c("");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bo() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String bp = bp();
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.tieba.data.h.b(readLine);
                    if (bp == null) {
                        String bq = bq();
                        if (bq != null && bq.length() > 0) {
                            com.baidu.tieba.data.h.a(bq);
                            y(bq);
                        } else if (readLine != null && readLine.length() > 0) {
                            com.baidu.tieba.data.h.a(readLine);
                            y(readLine);
                            z(readLine);
                        }
                    } else {
                        com.baidu.tieba.data.h.a(bp);
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
                    be.b(getClass().getName(), "InitFrom", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    be.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.h.a());
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
        be.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.h.a());
    }

    private String bp() {
        return com.baidu.tieba.sharedPref.b.a().a("from_id", (String) null);
    }

    private void y(String str) {
        if (str != null && str.length() > 0 && q()) {
            com.baidu.tieba.sharedPref.b.a().b("from_id", str);
        }
    }

    private String bq() {
        String str = null;
        try {
            File d = com.baidu.tieba.util.w.d("from.dat");
            if (d != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e2) {
            be.b(getClass().getName(), "getFromByFile", e2.getMessage());
        }
        return str;
    }

    private void z(String str) {
        if (str != null && str.length() > 0) {
            try {
                File f = com.baidu.tieba.util.w.f("from.dat");
                if (f != null) {
                    FileWriter fileWriter = new FileWriter(f);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e2) {
                be.b(getClass().getName(), "saveFromToFile", e2.getMessage());
            }
        }
    }

    public static String y() {
        return com.baidu.tieba.data.h.a();
    }

    public void z() {
        com.baidu.tieba.mention.t.a().a(true);
        DatabaseService.v();
    }

    public com.baidu.adp.widget.ImageView.e j(String str) {
        SoftReference<com.baidu.adp.widget.ImageView.e> softReference = this.f.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.ImageView.e a2 = TbFaceManager.a().a(str);
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
            if (com.baidu.tieba.util.bd.a().c()) {
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
        int b = com.baidu.tbadk.imageManager.d.a().b();
        int max = (int) Math.max(b * 0.8d, com.baidu.tieba.data.h.e());
        if (max < b) {
            if (com.baidu.adp.lib.h.d.a()) {
                com.baidu.adp.lib.h.d.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.imageManager.d.a().b(max);
        }
    }

    public static String C() {
        if (h != null) {
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
        h = accountData;
        if (g().w()) {
            UtilHelper.g(context);
        } else {
            UtilHelper.h(context);
        }
        if (accountData != null) {
            bf.a(accountData.getAccount(), accountData.getID());
        }
        if (z) {
            a(accountData, g());
        }
    }

    protected static void a(AccountData accountData, TiebaApplication tiebaApplication) {
        com.baidu.tieba.mention.t.a().d();
        com.baidu.tieba.im.i.a(accountData, tiebaApplication);
        com.baidu.tieba.im.m.b();
        E();
    }

    public static void E() {
        com.baidu.tieba.im.db.x.a().b();
        com.baidu.tieba.im.m.a(new ar(), new as());
    }

    public static String F() {
        if (h != null) {
            return h.getBDUSS();
        }
        return null;
    }

    public static void k(String str) {
        boolean z = true;
        if (h != null) {
            if (str != null ? str.equals(h.getBDUSS()) : h.getBDUSS() == null) {
                z = false;
            }
            h.setBDUSS(str);
            if (z) {
                a(h, g());
            }
        }
    }

    public static AccountData G() {
        return h;
    }

    public static String H() {
        if (h != null) {
            return h.getAccount();
        }
        return null;
    }

    public int I() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("tdatabaseusetimes", 0);
        be.a("TiebaApplication", "getAPPUseTimes", String.valueOf(a2));
        return a2;
    }

    public void b(int i) {
        com.baidu.tieba.sharedPref.b.a().a("tdatabaseusetimes", i);
    }

    public long J() {
        long a2 = com.baidu.tieba.sharedPref.b.a().a("tdatabasecreatetime", 0L);
        be.a("TiebaApplication", "getTDatabaseCreateTime", com.baidu.tieba.util.bc.a(a2));
        return a2;
    }

    public void a(long j) {
        com.baidu.tieba.sharedPref.b.a().b("update_notify_time", j);
    }

    public long K() {
        return com.baidu.tieba.sharedPref.b.a().a("update_notify_time", 0L);
    }

    public void l(String str) {
        com.baidu.tieba.sharedPref.b.a().b("install_other_app_file_name", str);
    }

    public String L() {
        return com.baidu.tieba.sharedPref.b.a().a("install_other_app_file_name", (String) null);
    }

    public void M() {
        com.baidu.tieba.sharedPref.b.a().b("tdatabasecreatetime", new Date().getTime());
    }

    public boolean N() {
        return I() > 50 && new Date().getTime() - J() > 2592000000L;
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

    public String O() {
        if (h != null) {
            return h.getTbs();
        }
        return null;
    }

    public String a(Context context) {
        String str = null;
        String a2 = com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CLIENT_ID, (String) null);
        if (a2 != null) {
            int indexOf = a2.indexOf("\t");
            if (indexOf != -1) {
                if (com.baidu.tieba.data.h.j().equals(a2.substring(0, indexOf))) {
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
        be.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String P() {
        return m;
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
        m = str;
    }

    public void h(boolean z) {
        this.i = z;
    }

    public boolean Q() {
        return this.i;
    }

    public int R() {
        return this.af;
    }

    public void S() {
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
        this.al = z;
        com.baidu.tieba.sharedPref.b.a().b("permoted_message", z);
    }

    public boolean T() {
        return this.al;
    }

    public void j(boolean z) {
        if (this.aj != z) {
            this.aj = z;
        }
    }

    public boolean U() {
        return this.an;
    }

    public void k(boolean z) {
        this.an = z;
    }

    public String V() {
        return this.ao;
    }

    public void o(String str) {
        this.ao = str;
    }

    public String W() {
        return this.ap;
    }

    public void p(String str) {
        this.ap = str;
    }

    public boolean X() {
        return this.aj;
    }

    public void l(boolean z) {
        this.ak = z;
    }

    public boolean Y() {
        return this.ak;
    }

    public int Z() {
        if (!this.aj && !this.ak) {
            return 0;
        }
        if (!this.aj || this.ak) {
            if (!this.aj && this.ak) {
                return 2;
            }
            return 3;
        }
        return 1;
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

    public void d(int i) {
        be.a(getClass().getName(), "setMsgFrequence", "" + i);
        if (i == 0) {
            this.af = i;
            com.baidu.tieba.mention.t.a().a(true);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.af = 300;
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean aa() {
        return this.ag;
    }

    public void m(boolean z) {
        this.ag = z;
        if (!z) {
            com.baidu.tieba.mention.t.a().c(0L);
        }
    }

    public boolean ab() {
        return this.ah;
    }

    public void n(boolean z) {
        this.ah = z;
        if (!z) {
            com.baidu.tieba.mention.t.a().b(0L);
        }
    }

    public boolean ac() {
        return this.ai;
    }

    public void o(boolean z) {
        this.ai = z;
        if (!z) {
            com.baidu.tieba.mention.t.a().a(0L);
        }
    }

    public boolean ad() {
        return this.am;
    }

    public void p(boolean z) {
        this.am = z;
        if (!z) {
            com.baidu.tieba.mention.t.a().d(0L);
        }
    }

    public boolean ae() {
        return com.baidu.tieba.sharedPref.b.a().a("group_notify", true);
    }

    public void q(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("group_notify", z);
    }

    public boolean af() {
        return this.af > 0;
    }

    public boolean ag() {
        return com.baidu.tieba.sharedPref.b.a().a("alert_sign_on", false);
    }

    public void r(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_on", z);
        aj();
    }

    public int ah() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("alert_sign_hours", -1);
        if (a2 == -1) {
            br();
            return com.baidu.tieba.sharedPref.b.a().a("alert_sign_hours", 12);
        }
        return a2;
    }

    private void br() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int ai() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("alert_sign_mins", -1);
        if (a2 == -1) {
            br();
            return com.baidu.tieba.sharedPref.b.a().a("alert_sign_mins", 30);
        }
        return a2;
    }

    public void a(int i, int i2) {
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_hours", i);
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_mins", i2);
        aj();
    }

    public void aj() {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent ak = ak();
        if (ag()) {
            Calendar calendar = Calendar.getInstance();
            int ah = ah();
            int i = calendar.get(11);
            int ai = ai();
            int i2 = calendar.get(12);
            calendar.set(11, ah);
            calendar.set(12, ai);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= ah && (i != ah || i2 >= ai)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this, 0, ak, 268435456));
            if (com.baidu.adp.lib.h.d.a()) {
                com.baidu.adp.lib.h.d.d("sign-alert alarm set to :" + com.baidu.tieba.util.bc.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, ak, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.h.d.a()) {
                com.baidu.adp.lib.h.d.d("sign-alert alarm cancelled.");
            }
        }
    }

    protected Intent ak() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.signalert");
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(this, SignAlertReceiver.class);
        return intent;
    }

    public int al() {
        this.H = com.baidu.tieba.sharedPref.b.a().a("image_quality", 0);
        return this.H;
    }

    public int am() {
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

    public boolean an() {
        return this.J;
    }

    public void s(boolean z) {
        if (this.J != z) {
            this.J = z;
            com.baidu.tieba.sharedPref.b.a().b("show_images", z);
        }
    }

    public int ao() {
        return this.K;
    }

    public void g(int i) {
        if (this.K != i) {
            this.K = i;
            com.baidu.tieba.sharedPref.b.a().b("font_size", i);
        }
    }

    public boolean ap() {
        return this.P == 1;
    }

    public void t(boolean z) {
        int i = z ? 1 : 0;
        if (this.P != i) {
            this.P = i;
            com.baidu.tieba.sharedPref.b.a().b("voice_headset_mode", i);
        }
    }

    public void h(int i) {
        this.L = i;
        com.baidu.tieba.sharedPref.b.a().b("new_abstract_state", i);
    }

    public int aq() {
        return this.L;
    }

    public boolean ar() {
        if (this.L == 0) {
            if (com.baidu.tieba.util.bd.a().c()) {
                return true;
            }
        } else if (this.L == 1) {
            return true;
        }
        return false;
    }

    public void u(boolean z) {
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

    public int as() {
        return this.M;
    }

    public int at() {
        return this.U;
    }

    public void k(int i) {
        this.U = i;
        com.baidu.tieba.sharedPref.b.a().b("webview_crash_count", i);
    }

    public int au() {
        return this.V;
    }

    public void l(int i) {
        this.V = i;
        com.baidu.tieba.sharedPref.b.a().b("perform_sample_count", i);
    }

    public int av() {
        return this.W;
    }

    public void m(int i) {
        this.W = i;
        com.baidu.tieba.sharedPref.b.a().a("new_vcode_webview_crash_count", i);
    }

    public void aw() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("bd_loc_crash_count", 0) + 1;
        com.baidu.tieba.sharedPref.b.a().b("bd_loc_crash_count", a2);
        if (a2 > 3) {
            a(false);
        }
    }

    public VersionData ax() {
        return this.u;
    }

    public void a(VersionData versionData) {
        this.u = versionData;
    }

    public static boolean ay() {
        return Z;
    }

    public static void v(boolean z) {
        Z = z;
    }

    public com.baidu.tieba.util.at az() {
        return this.j;
    }

    public void aA() {
        this.s = System.currentTimeMillis();
    }

    public void aB() {
        this.s = -1L;
    }

    public void aC() {
        if (this.s > 0) {
            this.s = System.currentTimeMillis() - this.s;
            if (this.s > 0) {
                new com.baidu.tieba.account.ah("startup_time", String.valueOf(this.s));
                bf.a("op_launch", this.s, 0L);
            }
            be.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.s));
        }
        this.s = -1L;
    }

    public void aD() {
        this.p++;
        bt();
    }

    public void aE() {
        this.p--;
        bt();
    }

    private void bs() {
        Message message = new Message();
        message.what = 6;
        message.obj = Boolean.TRUE;
        this.c.sendMessageDelayed(message, 1000L);
    }

    private void bt() {
        if (q()) {
            if (this.p < 0) {
                this.p = 0;
            }
            if (this.q == 0 && this.p > 0) {
                this.q = System.nanoTime();
            }
            be.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.p));
            this.c.removeMessages(4);
            if (this.p == 0 && this.q > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), Util.MILLSECONDS_OF_MINUTE);
            }
            this.c.removeMessages(6);
            if (this.p == 0) {
                bs();
            } else if (this.aa) {
                Message message = new Message();
                message.what = 6;
                message.obj = Boolean.FALSE;
                this.c.sendMessageDelayed(message, 1000L);
            }
        }
    }

    public void aF() {
        if (!this.aa) {
            this.aa = true;
            com.baidu.tieba.im.messageCenter.f.a().d(new BackgroundSwitchMessage(true));
        }
    }

    public void aG() {
        if (this.aa) {
            this.aa = false;
            com.baidu.tieba.im.messageCenter.f.a().d(new BackgroundSwitchMessage(false));
        }
    }

    public boolean aH() {
        String a2 = com.baidu.tieba.sharedPref.b.a().a("lase_version", "");
        if (a2.equals(com.baidu.tieba.data.h.j())) {
            return false;
        }
        q(a2);
        return true;
    }

    public void aI() {
        com.baidu.tieba.sharedPref.b.a().b("lase_version", com.baidu.tieba.data.h.j());
    }

    public void q(String str) {
        com.baidu.tieba.sharedPref.b.a().b("active_version", str);
    }

    public String aJ() {
        String a2 = com.baidu.tieba.sharedPref.b.a().a("active_version", "");
        if ("active_clear".equals(a2)) {
            return null;
        }
        return a2;
    }

    public void aK() {
        q("active_clear");
    }

    public void aL() {
        com.baidu.tieba.sharedPref.b.a().a("account_share");
    }

    public String aM() {
        return com.baidu.tieba.sharedPref.b.a().a("account_share", (String) null);
    }

    public void r(String str) {
        com.baidu.tieba.sharedPref.b.a().b("account_share", str);
    }

    private void bu() {
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
            be.b(getClass().getName(), "initLocationServer", e2.toString());
        }
    }

    public void aN() {
        try {
            if (this.D == null || System.currentTimeMillis() - this.f988a > 300000) {
                this.D = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.C != null) {
                    this.C.removeUpdates(this.aq);
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
                    A("gps");
                } else {
                    this.B = 1;
                }
                if (this.C != null && this.C.isProviderEnabled("network")) {
                    A("network");
                } else {
                    this.B = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), Util.MILLSECONDS_OF_MINUTE);
            }
        } catch (Exception e2) {
            be.b(getClass().getName(), "startLocationServer", e2.toString());
        }
    }

    private void A(String str) {
        if (this.C.isProviderEnabled(str)) {
            this.C.requestLocationUpdates(str, 10000L, 100.0f, this.aq);
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
                TiebaApplication.this.aO();
                TiebaApplication.this.D = new Address(Locale.getDefault());
                TiebaApplication.this.D.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.D.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.f988a = System.currentTimeMillis();
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

    public void aO() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.C != null) {
            this.C.removeUpdates(this.aq);
        }
        if (this.y && this.z != null && this.z.isStarted()) {
            this.z.stop();
        }
        if (this.E != null) {
            this.E.cancel();
        }
    }

    public Address aP() {
        return this.D;
    }

    public Address a(au auVar) {
        boolean z;
        if (this.D != null && System.currentTimeMillis() - this.f988a <= 300000) {
            return this.D;
        }
        if (auVar != null) {
            int i = 0;
            while (true) {
                if (i >= this.F.size()) {
                    z = false;
                    break;
                }
                au auVar2 = this.F.get(i).get();
                if (auVar2 == null || !auVar2.equals(auVar)) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                if (this.F.size() > 10) {
                    this.F.remove(0);
                }
                this.F.add(new SoftReference<>(auVar));
            }
            aN();
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
                    au auVar = this.F.get(i3).get();
                    if (auVar != null) {
                        auVar.a(i, str, address);
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
        be.a(getClass().getName(), "pv_addImagePv", "img_num=" + i + " img_total" + i2);
        com.baidu.tieba.account.ag agVar = new com.baidu.tieba.account.ag(i, i2);
        agVar.a(str);
        this.G.execute(agVar);
    }

    public boolean aQ() {
        return this.ar;
    }

    public void w(boolean z) {
        this.ar = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aR() {
        if (g().aQ()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(g().K()).longValue() > Util.MILLSECONDS_OF_DAY;
        }
        return false;
    }

    public static boolean aS() {
        boolean booleanValue;
        synchronized (as) {
            while (at == null) {
                try {
                    as.wait();
                } catch (Exception e2) {
                    com.baidu.adp.lib.h.d.a(e2.getMessage());
                }
            }
            booleanValue = at != null ? at.booleanValue() : false;
        }
        return booleanValue;
    }

    public boolean aT() {
        return com.baidu.tieba.sharedPref.b.a().a("is_pk_offline", false);
    }

    public long aU() {
        return com.baidu.tieba.sharedPref.b.a().a("last_notify_sound_time", 0L);
    }

    public void c(long j) {
        com.baidu.tieba.sharedPref.b.a().b("last_notify_sound_time", j);
    }

    public int aV() {
        return com.baidu.tieba.sharedPref.b.a().a("kn_vote_cd", 600);
    }

    public void n(int i) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_cd", i);
    }

    public int aW() {
        return com.baidu.tieba.sharedPref.b.a().a("networkcore_type", 1);
    }

    public void o(int i) {
        com.baidu.tieba.util.ap.a(i);
        com.baidu.tieba.sharedPref.b.a().b("networkcore_type", i);
    }

    public int aX() {
        return com.baidu.tieba.sharedPref.b.a().a("keepalive_wifi", 1);
    }

    public void p(int i) {
        com.baidu.tieba.sharedPref.b.a().b("keepalive_wifi", i);
    }

    public int aY() {
        return com.baidu.tieba.sharedPref.b.a().a("keepalive_nonwifi", 1);
    }

    public void q(int i) {
        com.baidu.tieba.sharedPref.b.a().b("keepalive_nonwifi", i);
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

    public void v(String str) {
        com.baidu.tieba.sharedPref.b.a().b("socket_online_strategy", str);
    }

    public int[] aZ() {
        int[] iArr = new int[0];
        try {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("socket_reconn_strategy", "");
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                String[] split = a2.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public int[] ba() {
        int[] iArr = new int[0];
        try {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("socket_heartbeat_strategy", "");
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                String[] split = a2.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public int[] bb() {
        int[] iArr = new int[0];
        try {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("socket_getmsg_strategy", "");
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                String[] split = a2.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public int[] bc() {
        int[] iArr = new int[0];
        try {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("socket_online_strategy", "");
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                String[] split = a2.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public int bd() {
        return com.baidu.tieba.sharedPref.b.a().a("kn_vote_max", 10);
    }

    public void r(int i) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_max", i);
    }

    public int be() {
        return com.baidu.tieba.sharedPref.b.a().a("kn_vote_rate", 10);
    }

    public void s(int i) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_rate", i);
    }

    public void w(String str) {
        com.baidu.tieba.sharedPref.b.a().b("push_channel_id", str);
    }

    public String bf() {
        return com.baidu.tieba.sharedPref.b.a().a("push_channel_userId", "");
    }

    public void x(String str) {
        com.baidu.tieba.sharedPref.b.a().b("push_channel_userId", str);
    }

    public String bg() {
        return com.baidu.tieba.sharedPref.b.a().a("push_channel_id", "");
    }

    public com.baidu.adp.lib.cache.s<String> bh() {
        if (this.T == null) {
            this.T = BdCacheService.c().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.T;
    }
}
