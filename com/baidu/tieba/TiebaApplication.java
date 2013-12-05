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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.im.message.BackgroundSwitchMessage;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.square.SquareActivity;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.switchs.SwitchModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.UtilHelper;
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
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class TiebaApplication extends com.baidu.adp.a.b {
    private static TiebaApplication f;
    private Boolean A;
    private LocationManager F;
    private int ac;
    private static AccountData i = null;
    private static String n = null;
    private static boolean o = false;
    private static boolean ad = false;
    private static Intent ah = null;
    private static final byte[] az = new byte[0];
    private static volatile Boolean aA = null;
    private int e = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.e>> g = null;
    private int h = 1;
    private boolean j = false;
    private com.baidu.tieba.util.az k = null;
    private com.baidu.tieba.util.az l = null;
    private String m = null;
    private String p = null;
    private int q = 0;
    private long r = 0;
    private long s = 0;
    private long t = -1;
    private String u = null;
    private boolean v = false;
    private VersionData w = null;
    private CombineDownload x = null;
    private BannerData y = null;

    /* renamed from: a  reason: collision with root package name */
    public long f1014a = 0;
    private Boolean z = false;
    private boolean B = true;
    private LocationClient C = null;
    private BDLocationListener D = null;
    private int E = 0;
    private Address G = null;
    private bf H = null;
    private ArrayList<SoftReference<be>> I = null;
    private ExecutorService J = null;
    private int K = 0;
    private int L = 0;
    private boolean M = true;
    private int N = 3;
    private int O = 1;
    private int P = 0;
    private boolean Q = true;
    private boolean R = false;
    private int S = 0;
    private boolean T = false;
    private boolean U = false;
    private boolean V = true;
    private com.baidu.adp.lib.cache.s<String> W = null;
    private int X = 0;
    private int Y = 10;
    private int Z = 0;
    private boolean aa = false;
    private boolean ab = true;
    private AtomicBoolean ae = null;
    private int af = 0;
    private long ag = 0;
    public ArrayList<j> b = null;
    private Hashtable<String, Integer> ai = null;
    private Hashtable<String, Integer> aj = null;
    private Hashtable<String, Integer> ak = null;
    private Hashtable<String, Integer> al = null;
    public Handler c = new Handler(new az(this));
    com.baidu.adp.lib.c.d d = new ba(this);
    private int am = 0;
    private boolean an = true;
    private boolean ao = true;
    private boolean ap = true;
    private boolean aq = true;
    private boolean ar = false;
    private boolean as = true;
    private boolean at = true;
    private boolean au = false;
    private String av = "23:00";
    private String aw = "09:00";
    private final LocationListener ax = new bd(this);
    private boolean ay = false;

    public void a(Boolean bool) {
        this.z = bool;
    }

    public Boolean d() {
        return this.z;
    }

    public static void a(Intent intent) {
        ah = intent;
    }

    public static Intent e() {
        return ah;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        super.onCreate();
        f = this;
        new bg(null).execute(new String[0]);
        NetWorkCore.C();
        bm();
        if (r()) {
            com.baidu.tieba.sharedPref.b.a().b();
        }
        bn();
        bi();
        bl();
        com.baidu.tieba.util.bj.a(this);
        n = a((Context) this);
        bj();
        bk();
        com.baidu.tieba.data.h.d(this);
        com.baidu.tieba.data.h.b(this);
        com.baidu.tieba.data.h.c(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.util.bg());
        } catch (SecurityException e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "onCreate", e.getMessage());
        }
        com.baidu.tieba.util.be.a(this);
        if (r()) {
            if (aH()) {
                com.baidu.adp.lib.a.d.a().b();
            }
            com.baidu.tbadk.imageManager.d.a().a(50, com.baidu.tieba.data.h.e());
            com.baidu.adp.lib.e.c.a().a(com.baidu.tieba.util.a.f.a());
            TbFaceManager.a().a(this, new com.baidu.tieba.util.w());
            this.g = new HashMap<>();
            if (getDatabasePath("baidu_tieba.db").exists()) {
                i = DatabaseService.n();
                if (i != null) {
                    com.baidu.tieba.util.be.a(i.getAccount(), i.getID());
                }
            }
            if (o()) {
                f.a(this);
            } else {
                com.baidu.tieba.account.a.a().b(this);
            }
            DatabaseService.v();
            n();
            this.k = new com.baidu.tieba.util.az(300);
            this.l = new com.baidu.tieba.util.az(100);
            com.baidu.tieba.mention.t.a().b();
            new com.baidu.tieba.account.ai("open").start();
            if (am()) {
                new com.baidu.tieba.account.ai("frs_abstract", SocialConstants.TRUE).start();
            }
            bt();
            this.I = new ArrayList<>();
            af();
            new com.baidu.tieba.data.chat.a().a();
            l();
            m();
            com.baidu.tieba.im.i.a(this);
        } else {
            this.b = new ArrayList<>();
        }
        try {
            registerReceiver(new com.baidu.tieba.service.f(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e2) {
            com.baidu.adp.lib.h.e.a(e2.getMessage());
        }
        TbImageView.setSkinMode(this.P);
        try {
            com.baidu.adp.lib.c.a.a().a(this, "tieba");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (r()) {
            br();
            f();
        }
    }

    public void f() {
        com.baidu.adp.lib.c.a.a().a(true, this.d);
    }

    public boolean g() {
        boolean z = false;
        String trim = Build.MODEL.trim();
        if (trim == null) {
            return true;
        }
        String[] strArr = {"M040", "M032", "M031", "M030", "HUAWEI C8813", "ZTE U970", "MediaPad 10 FHD", "GT-I9000", "DOEASY E930", "H8205", "GT-N7108", "GT-N7102", "GT-N719", "GT-N7100", "galaxy nexus", " ZTE U808", "UMI_X1", "nexus s", "AMOI N820", "JY-G", "XT885", "U701T", "Lenovo A750", "ZTE U807", "vivo S11t", "Droid Bionic", "MORAL_N01", "XT910", "GT-S7562", "Lenovo A798t", "vivo E5", "U705T", "HUAWEI T8951", "ME865", "HUAWEI P1XL", "KPT A9PLUS", "vivo Y11", "T9200", "XT928", "HUAWEI Y500-T00", "BBK Y3t", "Lenovo K860", "vivo X1", "HUAWEI T8833", "Lenovo A789", "ZTE U960E"};
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (strArr[i2].equalsIgnoreCase(trim)) {
                break;
            } else {
                i2++;
            }
        }
        if (com.baidu.adp.lib.h.e.a()) {
            com.baidu.adp.lib.h.e.c("device:[" + trim + "], default GPU on:" + z);
        }
        return z;
    }

    public static TiebaApplication h() {
        return f;
    }

    public void a(String str) {
        this.p = str;
    }

    public String i() {
        return this.p;
    }

    public boolean b(String str) {
        if (this.aj == null || str == null) {
            return false;
        }
        return this.aj.containsKey(str);
    }

    public void a(String str, int i2, int i3) {
        if (!b(str) && this.aj != null && str != null) {
            if (this.aj.size() > 100) {
                this.aj.clear();
                this.ak.clear();
            }
            this.aj.put(str, Integer.valueOf(i2));
            this.ak.put(str, Integer.valueOf(i3));
        }
    }

    public void j() {
        if (this.aj != null) {
            this.aj.clear();
        }
        if (this.ak != null) {
            this.ak.clear();
        }
    }

    public int c(String str) {
        if (b(str)) {
            return this.aj.get(str).intValue();
        }
        return 0;
    }

    public int d(String str) {
        if (b(str)) {
            return this.ak.get(str).intValue();
        }
        return -1;
    }

    public int k() {
        if (this.aj != null) {
            return this.aj.size();
        }
        return 0;
    }

    public void l() {
        if (this.aj == null) {
            this.aj = new Hashtable<>();
        }
        if (this.ak == null) {
            this.ak = new Hashtable<>();
        }
    }

    public int e(String str) {
        if (this.al == null || str == null || !this.al.containsKey(str)) {
            return 0;
        }
        return this.al.get(str).intValue();
    }

    public void f(String str) {
        if (this.al != null && str != null) {
            this.al.put(str, 1);
            h(true);
            if (this.al.size() > 200) {
                this.al.clear();
            }
        }
    }

    public void g(String str) {
        if (this.al != null && str != null) {
            this.al.put(str, -1);
            h(true);
            if (this.al.size() > 200) {
                this.al.clear();
            }
        }
    }

    public void m() {
        if (this.al == null) {
            this.al = new Hashtable<>();
        }
    }

    public boolean h(String str) {
        if (this.ai == null || str == null) {
            return false;
        }
        return this.ai.containsKey(str);
    }

    public void i(String str) {
        if (!h(str) && this.ai != null && str != null) {
            this.ai.put(str, 1);
            new com.baidu.tieba.util.z(1, str).start();
        }
    }

    public void j(String str) {
        if (h(str) && this.ai != null && str != null) {
            this.ai.remove(str);
            new com.baidu.tieba.util.z(2, str).start();
        }
    }

    public void n() {
        this.ai = new Hashtable<>();
        new com.baidu.tieba.util.z(this.ai).start();
    }

    public void a(j jVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.b.get(i2).releaseResouce();
                } catch (Exception e) {
                    com.baidu.tieba.util.bd.b(getClass().getName(), "addRemoteActivity", e.getMessage());
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

    private void bi() {
        if (Build.VERSION.SDK_INT >= 5) {
            o = new AccountProxy(this).hasBaiduAccount();
        } else {
            o = false;
        }
    }

    public static boolean o() {
        return o;
    }

    private void bj() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.m = telephonyManager.getDeviceId();
        }
        if (this.m == null) {
            this.m = "000000000000000";
        }
    }

    private void bk() {
        if (this.u == null || this.u.length() < 0) {
            this.u = CommonParam.getCUID(this);
            com.baidu.adp.lib.h.e.c("----cuid:" + this.u);
            com.baidu.tieba.sharedPref.b.a().b(SocialConstants.PARAM_CUID, this.u);
        }
    }

    public String p() {
        return this.u;
    }

    public String q() {
        return this.m;
    }

    public boolean r() {
        boolean z = false;
        if (this.A != null) {
            return this.A.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        int myPid = Process.myPid();
        if (runningAppProcesses != null) {
            this.A = Boolean.TRUE;
            int i2 = 0;
            while (true) {
                if (i2 >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i2).pid != myPid) {
                    i2++;
                } else {
                    String str = runningAppProcesses.get(i2).processName;
                    if (str != null && (str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1") || str.equalsIgnoreCase("com.baidu.tieba:remote") || str.equalsIgnoreCase("com.baidu.tieba:bdservice_v1"))) {
                        this.A = Boolean.FALSE;
                    }
                }
            }
        }
        z = true;
        return z;
    }

    private void bl() {
        SwitchModel.initSwitchManager();
        this.K = com.baidu.tieba.sharedPref.b.a().a("image_quality", 0);
        this.L = com.baidu.tieba.sharedPref.b.a().a("view_image_quality", 0);
        this.M = com.baidu.tieba.sharedPref.b.a().a("show_images", true);
        this.N = com.baidu.tieba.sharedPref.b.a().a("font_size", 2);
        this.as = com.baidu.tieba.sharedPref.b.a().a("permoted_message", true);
        this.h = com.baidu.tieba.sharedPref.b.a().a("new_display_photo", 1);
        this.O = com.baidu.tieba.sharedPref.b.a().a("new_abstract_state", 0);
        this.P = com.baidu.tieba.sharedPref.b.a().a("skin", 0);
        this.s = com.baidu.tieba.sharedPref.b.a().a("message_id", 0L);
        this.S = com.baidu.tieba.sharedPref.b.a().a("voice_headset_mode", 0);
        this.T = com.baidu.tieba.sharedPref.b.a().a("gpu_open", g());
        this.U = com.baidu.tieba.sharedPref.b.a().a("app_switcher", false);
        this.aa = com.baidu.tieba.sharedPref.b.a().a("manage_mode", false);
        this.Q = com.baidu.tieba.sharedPref.b.a().a("location_on", true);
        this.R = com.baidu.tieba.sharedPref.b.a().a("open_local_popularize", false);
        this.X = com.baidu.tieba.sharedPref.b.a().a("webview_crash_count", 0);
        this.Z = com.baidu.tieba.sharedPref.b.a().a("new_vcode_webview_crash_count", 0);
        this.B = com.baidu.tieba.sharedPref.b.a().a("bd_loc_switcher", true);
        this.ab = com.baidu.tieba.sharedPref.b.a().a("search_mode", true);
        this.ac = com.baidu.tieba.sharedPref.b.a().a("search_mode_int", 0);
        this.u = com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CUID, (String) null);
        this.Y = com.baidu.tieba.sharedPref.b.a().a("perform_sample_count", 0);
        if (Build.VERSION.SDK_INT <= 4) {
            this.B = false;
        }
        com.baidu.tieba.d.a.a().b();
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.LOG) == 0) {
            com.baidu.tieba.log.a.a(true);
        } else {
            com.baidu.tieba.log.a.a(false);
        }
    }

    public void a(boolean z) {
        this.B = z;
        com.baidu.tieba.sharedPref.b.a().b("bd_loc_switcher", z);
    }

    public void b(boolean z) {
        this.ab = z;
        com.baidu.tieba.sharedPref.b.a().b("search_mode", z);
    }

    public boolean s() {
        return this.ab;
    }

    public boolean t() {
        return this.V;
    }

    public void c(boolean z) {
        this.V = z;
    }

    public boolean u() {
        return this.Q;
    }

    public void d(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("gpu_open", z);
        this.T = z;
    }

    public boolean v() {
        return this.T;
    }

    public void e(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("moplus_service", z);
    }

    public boolean w() {
        return com.baidu.tieba.sharedPref.b.a().a("moplus_service", true);
    }

    public void f(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("push_service", z);
    }

    public boolean x() {
        return com.baidu.tieba.sharedPref.b.a().a("push_service", true);
    }

    public void g(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("app_switcher", z);
        this.U = z;
    }

    public boolean y() {
        return this.U;
    }

    private void bm() {
        try {
            com.baidu.tieba.data.h.c(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            if (com.baidu.tieba.data.h.j() == null) {
                com.baidu.tieba.data.h.c("");
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "InitVersion", e.getMessage());
            com.baidu.tieba.data.h.c("");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bn() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String bo = bo();
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.tieba.data.h.b(readLine);
                    if (bo == null) {
                        String bp = bp();
                        if (bp != null && bp.length() > 0) {
                            com.baidu.tieba.data.h.a(bp);
                            B(bp);
                        } else if (readLine != null && readLine.length() > 0) {
                            com.baidu.tieba.data.h.a(readLine);
                            B(readLine);
                            C(readLine);
                        }
                    } else {
                        com.baidu.tieba.data.h.a(bo);
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.tieba.util.bd.b(getClass().getName(), "InitFrom", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    com.baidu.tieba.util.bd.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.h.a());
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        com.baidu.tieba.util.bd.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.data.h.a());
    }

    private String bo() {
        return com.baidu.tieba.sharedPref.b.a().a("from_id", (String) null);
    }

    private void B(String str) {
        if (str != null && str.length() > 0 && r()) {
            com.baidu.tieba.sharedPref.b.a().b("from_id", str);
        }
    }

    private String bp() {
        String str = null;
        try {
            File d = com.baidu.tieba.util.x.d("from.dat");
            if (d != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "getFromByFile", e.getMessage());
        }
        return str;
    }

    private void C(String str) {
        if (str != null && str.length() > 0) {
            try {
                File f2 = com.baidu.tieba.util.x.f("from.dat");
                if (f2 != null) {
                    FileWriter fileWriter = new FileWriter(f2);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "saveFromToFile", e.getMessage());
            }
        }
    }

    public static String z() {
        return com.baidu.tieba.data.h.a();
    }

    public void A() {
        com.baidu.tieba.mention.t.a().a(true);
        DatabaseService.v();
    }

    public com.baidu.adp.widget.ImageView.e k(String str) {
        SoftReference<com.baidu.adp.widget.ImageView.e> softReference = this.g.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.ImageView.e a2 = TbFaceManager.a().a(str);
        if (a2 != null) {
            this.g.put(str, new SoftReference<>(a2));
            return a2;
        }
        return a2;
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
            if (com.baidu.adp.lib.h.e.a()) {
                com.baidu.adp.lib.h.e.c(TiebaApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.imageManager.d.a().b(max);
        }
    }

    public static String B() {
        if (i != null) {
            return i.getID();
        }
        return null;
    }

    public static boolean C() {
        String B = B();
        return B != null && B.length() > 0;
    }

    public static void a(AccountData accountData, Context context) {
        boolean z = true;
        if ((accountData != null || i == null) && ((i != null || accountData == null) && (i == null || accountData == null || TextUtils.equals(i.getAccount(), accountData.getAccount())))) {
            z = false;
        }
        i = accountData;
        if (h().x()) {
            UtilHelper.e(context);
        } else {
            UtilHelper.f(context);
        }
        if (accountData != null) {
            com.baidu.tieba.util.be.a(accountData.getAccount(), accountData.getID());
        } else {
            com.baidu.tieba.util.be.a(null, null);
        }
        if (z) {
            a(accountData, h());
        }
    }

    protected static void a(AccountData accountData, TiebaApplication tiebaApplication) {
        com.baidu.tieba.mention.t.a().d();
        com.baidu.tieba.im.i.a(accountData, tiebaApplication);
        com.baidu.tieba.im.m.b();
        D();
        com.baidu.tieba.mention.t.a().j();
    }

    public static void D() {
        com.baidu.tieba.im.db.ad.a().c();
        com.baidu.tieba.im.m.a(new bb(), new bc());
    }

    public static String E() {
        if (i != null) {
            return i.getBDUSS();
        }
        return null;
    }

    public static void l(String str) {
        boolean z = true;
        if (i != null) {
            if (str != null ? str.equals(i.getBDUSS()) : i.getBDUSS() == null) {
                z = false;
            }
            i.setBDUSS(str);
            if (z) {
                a(i, h());
            }
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

    public void a(long j) {
        com.baidu.tieba.sharedPref.b.a().b("update_notify_time", j);
    }

    public long H() {
        return com.baidu.tieba.sharedPref.b.a().a("update_notify_time", 0L);
    }

    public void m(String str) {
        com.baidu.tieba.sharedPref.b.a().b("install_other_app_file_name", str);
    }

    public String I() {
        return com.baidu.tieba.sharedPref.b.a().a("install_other_app_file_name", (String) null);
    }

    public void J() {
        com.baidu.tieba.sharedPref.b.a().b("tdatabasecreatetime", new Date().getTime());
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public void n(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (i != null) {
                    i.setTbs(str);
                }
            }
        }
    }

    public String K() {
        if (i != null) {
            return i.getTbs();
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
                    b((Context) h());
                }
            } else {
                b((Context) h());
            }
        } else {
            str = a2;
        }
        com.baidu.tieba.util.bd.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String L() {
        return n;
    }

    public void b(Context context) {
        com.baidu.tieba.sharedPref.b.a().a(SocialConstants.PARAM_CLIENT_ID);
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tieba.sharedPref.b.a().b(SocialConstants.PARAM_CLIENT_ID, com.baidu.tieba.data.h.j() + "\t" + str);
        }
    }

    public static void o(String str) {
        n = str;
    }

    public void h(boolean z) {
        this.j = z;
    }

    public boolean M() {
        return this.j;
    }

    public int N() {
        return this.am;
    }

    public void O() {
        b(300);
        m(true);
        o(true);
        n(true);
        p(true);
        k(false);
        p("23:00");
        q("09:00");
    }

    public void i(boolean z) {
        this.as = z;
        com.baidu.tieba.sharedPref.b.a().b("permoted_message", z);
    }

    public boolean P() {
        return this.as;
    }

    public void j(boolean z) {
        if (this.aq != z) {
            this.aq = z;
        }
    }

    public boolean Q() {
        return this.au;
    }

    public void k(boolean z) {
        this.au = z;
    }

    public String R() {
        return this.av;
    }

    public void p(String str) {
        this.av = str;
    }

    public String S() {
        return this.aw;
    }

    public void q(String str) {
        this.aw = str;
    }

    public boolean T() {
        return this.aq;
    }

    public void l(boolean z) {
        this.ar = z;
    }

    public boolean U() {
        return this.ar;
    }

    public int V() {
        if (!this.aq && !this.ar) {
            return 0;
        }
        if (!this.aq || this.ar) {
            if (!this.aq && this.ar) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public void a(int i2) {
        if (i2 == 0) {
            h().j(false);
            h().l(false);
        } else if (i2 == 1) {
            h().j(true);
            h().l(false);
        } else if (i2 == 2) {
            h().j(false);
            h().l(true);
        } else {
            h().j(true);
            h().l(true);
        }
    }

    public void b(int i2) {
        com.baidu.tieba.util.bd.a(getClass().getName(), "setMsgFrequence", "" + i2);
        if (i2 == 0) {
            this.am = i2;
            com.baidu.tieba.mention.t.a().a(true);
            this.c.sendMessage(this.c.obtainMessage(3));
            return;
        }
        this.am = 300;
        this.c.sendMessage(this.c.obtainMessage(2));
    }

    public boolean W() {
        return this.an;
    }

    public void m(boolean z) {
        this.an = z;
        if (!z) {
            com.baidu.tieba.mention.t.a().c(0L);
        }
    }

    public boolean X() {
        return this.ao;
    }

    public void n(boolean z) {
        this.ao = z;
        if (!z) {
            com.baidu.tieba.mention.t.a().b(0L);
        }
    }

    public boolean Y() {
        return this.ap;
    }

    public void o(boolean z) {
        this.ap = z;
        if (!z) {
            com.baidu.tieba.mention.t.a().a(0L);
        }
    }

    public boolean Z() {
        return this.at;
    }

    public void p(boolean z) {
        this.at = z;
        if (!z) {
            com.baidu.tieba.mention.t.a().d(0L);
        }
    }

    public boolean aa() {
        return com.baidu.tieba.sharedPref.b.a().a("group_notify", true);
    }

    public void q(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("group_notify", z);
    }

    public boolean ab() {
        return this.am > 0;
    }

    public boolean ac() {
        return com.baidu.tieba.sharedPref.b.a().a("alert_sign_on", false);
    }

    public void r(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_on", z);
        af();
    }

    public int ad() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("alert_sign_hours", -1);
        if (a2 == -1) {
            bq();
            return com.baidu.tieba.sharedPref.b.a().a("alert_sign_hours", 12);
        }
        return a2;
    }

    private void bq() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public int ae() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("alert_sign_mins", -1);
        if (a2 == -1) {
            bq();
            return com.baidu.tieba.sharedPref.b.a().a("alert_sign_mins", 30);
        }
        return a2;
    }

    public void a(int i2, int i3) {
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_hours", i2);
        com.baidu.tieba.sharedPref.b.a().b("alert_sign_mins", i3);
        af();
    }

    public void af() {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent ag = ag();
        if (ac()) {
            Calendar calendar = Calendar.getInstance();
            int ad2 = ad();
            int i2 = calendar.get(11);
            int ae = ae();
            int i3 = calendar.get(12);
            calendar.set(11, ad2);
            calendar.set(12, ae);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i2 >= ad2 && (i2 != ad2 || i3 >= ae)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this, 0, ag, 268435456));
            if (com.baidu.adp.lib.h.e.a()) {
                com.baidu.adp.lib.h.e.d("sign-alert alarm set to :" + com.baidu.tieba.util.bb.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, ag, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.h.e.a()) {
                com.baidu.adp.lib.h.e.d("sign-alert alarm cancelled.");
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
        return this.L;
    }

    public boolean ai() {
        return this.M;
    }

    public int aj() {
        return this.N;
    }

    public void c(int i2) {
        if (this.N != i2) {
            this.N = i2;
            com.baidu.tieba.sharedPref.b.a().b("font_size", i2);
        }
    }

    public boolean ak() {
        return this.S == 1;
    }

    public void s(boolean z) {
        int i2 = z ? 1 : 0;
        if (this.S != i2) {
            this.S = i2;
            com.baidu.tieba.sharedPref.b.a().b("voice_headset_mode", i2);
        }
    }

    public void d(int i2) {
        this.O = i2;
        com.baidu.tieba.sharedPref.b.a().b("new_abstract_state", i2);
    }

    public int al() {
        return this.O;
    }

    public boolean am() {
        if (this.O == 0) {
            if (com.baidu.tieba.util.bc.a().c()) {
                return true;
            }
        } else if (this.O == 1) {
            return true;
        }
        return false;
    }

    public void t(boolean z) {
        this.R = z;
        com.baidu.tieba.sharedPref.b.a().b("open_local_popularize", z);
    }

    public void e(int i2) {
        AppsActivity.a();
        f(i2);
        com.baidu.tieba.sharedPref.b.a().b("skin", i2);
        TbImageView.setSkinMode(i2);
        p(i2);
    }

    public void f(int i2) {
        this.P = i2;
    }

    private void p(int i2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeskin");
        intent.putExtra("skin_type", i2);
        sendBroadcast(intent);
    }

    public int an() {
        return this.P;
    }

    public int ao() {
        return this.X;
    }

    public void g(int i2) {
        this.X = i2;
        com.baidu.tieba.sharedPref.b.a().b("webview_crash_count", i2);
    }

    public int ap() {
        return this.Y;
    }

    public void h(int i2) {
        this.Y = i2;
        com.baidu.tieba.sharedPref.b.a().b("perform_sample_count", i2);
    }

    public int aq() {
        return this.Z;
    }

    public void i(int i2) {
        this.Z = i2;
        com.baidu.tieba.sharedPref.b.a().a("new_vcode_webview_crash_count", i2);
    }

    public void ar() {
        int a2 = com.baidu.tieba.sharedPref.b.a().a("bd_loc_crash_count", 0) + 1;
        com.baidu.tieba.sharedPref.b.a().b("bd_loc_crash_count", a2);
        if (a2 > 3) {
            a(false);
        }
    }

    public boolean as() {
        return this.v;
    }

    public void u(boolean z) {
        this.v = z;
    }

    public void a(CombineDownload combineDownload) {
        this.x = combineDownload;
    }

    public CombineDownload at() {
        return this.x;
    }

    public VersionData au() {
        return this.w;
    }

    public void a(VersionData versionData) {
        this.w = versionData;
    }

    public static boolean av() {
        return ad;
    }

    public static void v(boolean z) {
        ad = z;
    }

    public com.baidu.tieba.util.az aw() {
        return this.k;
    }

    public void ax() {
        this.t = System.currentTimeMillis();
    }

    public void ay() {
        this.t = -1L;
    }

    public void az() {
        if (this.t > 0) {
            this.t = System.currentTimeMillis() - this.t;
            if (this.t > 0) {
                new com.baidu.tieba.account.ai("startup_time", String.valueOf(this.t));
                com.baidu.tieba.util.be.a("op_launch", this.t, 0L);
            }
            com.baidu.tieba.util.bd.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.t));
        }
        this.t = -1L;
    }

    public void aA() {
        this.q++;
        bs();
    }

    public void aB() {
        this.q--;
        bs();
    }

    private void br() {
        this.c.sendMessageDelayed(this.c.obtainMessage(6, Boolean.TRUE), 1000L);
    }

    private void bs() {
        if (r()) {
            if (this.q < 0) {
                this.q = 0;
            }
            if (this.r == 0 && this.q > 0) {
                this.r = System.nanoTime();
            }
            com.baidu.tieba.util.bd.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.q));
            this.c.removeMessages(4);
            if (this.q == 0 && this.r > 0) {
                this.c.sendMessageDelayed(this.c.obtainMessage(4), Util.MILLSECONDS_OF_MINUTE);
            }
            this.c.removeMessages(6);
            if (this.q == 0) {
                br();
            } else if (this.ae == null || this.ae.get()) {
                this.c.sendMessageDelayed(this.c.obtainMessage(6, Boolean.FALSE), 1000L);
            }
        }
    }

    public boolean aC() {
        if (this.ae == null) {
            return true;
        }
        return this.ae.get();
    }

    public void aD() {
        if (this.ae == null) {
            this.ae = new AtomicBoolean(false);
        }
        if (!this.ae.get()) {
            SquareActivity.f2468a = true;
            this.ae.set(true);
            com.baidu.tieba.im.messageCenter.e.a().d(new BackgroundSwitchMessage(true));
        }
    }

    public void aE() {
        if (this.ae == null) {
            this.ae = new AtomicBoolean(true);
        }
        if (this.ae.get()) {
            this.ae.set(false);
            this.af++;
            if (System.currentTimeMillis() - this.ag > Util.MILLSECONDS_OF_HOUR || this.ag == 0) {
                this.ag = System.currentTimeMillis();
                new com.baidu.tieba.account.l().start();
            }
            com.baidu.tieba.im.messageCenter.e.a().d(new BackgroundSwitchMessage(false));
        }
    }

    public int aF() {
        return this.af;
    }

    public void aG() {
        this.af = 0;
    }

    public boolean aH() {
        if (com.baidu.tieba.util.y.a("/package.cur/" + com.baidu.tieba.data.h.j())) {
            return false;
        }
        r(com.baidu.tieba.util.y.d("/package.cur"));
        return true;
    }

    public void aI() {
        com.baidu.tieba.util.y.c("/package.cur");
        com.baidu.tieba.util.y.b("/package.cur/" + com.baidu.tieba.data.h.j());
    }

    public void r(String str) {
        if (!com.baidu.tieba.util.bb.c(str) && !"null".equals(str)) {
            com.baidu.tieba.util.y.c("/package.last");
            com.baidu.tieba.util.y.b("/package.last/" + str);
        }
    }

    public String aJ() {
        String d;
        if (!com.baidu.tieba.util.y.a("/package.last")) {
            d = com.baidu.tieba.sharedPref.b.a().a("active_version", "");
        } else {
            d = com.baidu.tieba.util.y.d("/package.last");
        }
        if ("active_clear".equals(d)) {
            return null;
        }
        return d;
    }

    public void w(boolean z) {
        com.baidu.tieba.sharedPref.b.a().b("first_sync_image_quality", z);
    }

    public boolean aK() {
        return com.baidu.tieba.sharedPref.b.a().a("first_sync_image_quality", true);
    }

    public void aL() {
        r("active_clear");
    }

    public void aM() {
        com.baidu.tieba.sharedPref.b.a().a("account_share");
    }

    public String aN() {
        return com.baidu.tieba.sharedPref.b.a().a("account_share", (String) null);
    }

    public void s(String str) {
        com.baidu.tieba.sharedPref.b.a().b("account_share", str);
    }

    private void bt() {
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
            com.baidu.tieba.util.bd.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public void aO() {
        try {
            if (this.G == null || System.currentTimeMillis() - this.f1014a > 300000) {
                this.G = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.F != null) {
                    this.F.removeUpdates(this.ax);
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
                    D("gps");
                } else {
                    this.E = 1;
                }
                if (this.F != null && this.F.isProviderEnabled("network")) {
                    D("network");
                } else {
                    this.E = 2;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), Util.MILLSECONDS_OF_MINUTE);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    private void D(String str) {
        if (this.F.isProviderEnabled(str)) {
            this.F.requestLocationUpdates(str, 10000L, 100.0f, this.ax);
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
                TiebaApplication.this.aP();
                TiebaApplication.this.G = new Address(Locale.getDefault());
                TiebaApplication.this.G.setLatitude(bDLocation.getLatitude());
                TiebaApplication.this.G.setLongitude(bDLocation.getLongitude());
                TiebaApplication.this.f1014a = System.currentTimeMillis();
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
                    TiebaApplication.this.G.setAddressLine(0, stringBuffer.toString());
                }
                TiebaApplication.this.a(TiebaApplication.this.E, "", TiebaApplication.this.G);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public void aP() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.F != null) {
            this.F.removeUpdates(this.ax);
        }
        if (this.B && this.C != null && this.C.isStarted()) {
            this.C.stop();
        }
        if (this.H != null) {
            this.H.cancel();
        }
    }

    public Address aQ() {
        return this.G;
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
                    be beVar = this.I.get(i4).get();
                    if (beVar != null) {
                        beVar.a(i2, str, address);
                    }
                    i3 = i4 + 1;
                } else {
                    this.I.clear();
                    return;
                }
            }
        }
    }

    public void b(long j) {
        this.s = j;
        com.baidu.tieba.sharedPref.b.a().b("message_id", j);
    }

    public void a(int i2, int i3, String str) {
        if (this.J == null) {
            this.J = Executors.newSingleThreadExecutor();
        }
        com.baidu.tieba.util.bd.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + " img_total" + i3);
        com.baidu.tieba.account.ah ahVar = new com.baidu.tieba.account.ah(i2, i3);
        ahVar.a(str);
        this.J.execute(ahVar);
    }

    public boolean aR() {
        return this.ay;
    }

    public void x(boolean z) {
        this.ay = z;
        sendBroadcast(new Intent("com.baidu.tieba.broadcast.newversion"));
    }

    public static boolean aS() {
        if (h().aR()) {
            return Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(h().H()).longValue() > Util.MILLSECONDS_OF_DAY;
        }
        return false;
    }

    public long aT() {
        return com.baidu.tieba.sharedPref.b.a().a("last_notify_sound_time", 0L);
    }

    public void c(long j) {
        com.baidu.tieba.sharedPref.b.a().b("last_notify_sound_time", j);
    }

    public void j(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_cd", i2);
    }

    public int aU() {
        return com.baidu.tieba.sharedPref.b.a().a("networkcore_type", 1);
    }

    public void k(int i2) {
        com.baidu.tieba.util.av.a(i2);
        com.baidu.tieba.sharedPref.b.a().b("networkcore_type", i2);
    }

    public int aV() {
        return com.baidu.tieba.sharedPref.b.a().a("keepalive_wifi", 1);
    }

    public void l(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("keepalive_wifi", i2);
    }

    public int aW() {
        return com.baidu.tieba.sharedPref.b.a().a("keepalive_nonwifi", 1);
    }

    public void m(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("keepalive_nonwifi", i2);
    }

    public void t(String str) {
        com.baidu.tieba.sharedPref.b.a().b("socket_reconn_strategy", str);
    }

    public void u(String str) {
        com.baidu.tieba.sharedPref.b.a().b("socket_heartbeat_strategy", str);
    }

    public void v(String str) {
        com.baidu.tieba.sharedPref.b.a().b("socket_getmsg_strategy", str);
    }

    public void a(int[] iArr) {
        if (iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i2 : iArr) {
                sb.append(i2);
                sb.append("|");
            }
            com.baidu.tieba.sharedPref.b.a().b("socket_time_out", sb.toString());
            com.baidu.tieba.im.net.f.a().a(iArr);
        }
    }

    public int[] aX() {
        String[] split;
        String a2 = com.baidu.tieba.sharedPref.b.a().a("socket_time_out", (String) null);
        if (a2 == null || (split = a2.split("\\|")) == null || split.length != 3) {
            return null;
        }
        int[] iArr = new int[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            iArr[i2] = 0;
            try {
                iArr[i2] = Integer.valueOf(split[i2]).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a(e.getMessage());
            }
        }
        return iArr;
    }

    public int[] aY() {
        int[] iArr = new int[0];
        try {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("socket_reconn_strategy", "");
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                String[] split = a2.split(",");
                iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.valueOf(split[i2]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public int[] aZ() {
        int[] iArr = new int[0];
        try {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("socket_heartbeat_strategy", "");
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                String[] split = a2.split(",");
                iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.valueOf(split[i2]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public int[] ba() {
        int[] iArr = new int[0];
        try {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("socket_getmsg_strategy", "");
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                String[] split = a2.split(",");
                iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.valueOf(split[i2]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public void n(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_max", i2);
    }

    public void o(int i2) {
        com.baidu.tieba.sharedPref.b.a().b("kn_vote_rate", i2);
    }

    public void w(String str) {
        com.baidu.tieba.sharedPref.b.a().b("push_channel_id", str);
    }

    public String bb() {
        return com.baidu.tieba.sharedPref.b.a().a("push_channel_userId", "");
    }

    public void x(String str) {
        com.baidu.tieba.sharedPref.b.a().b("push_channel_userId", str);
    }

    public String bc() {
        return com.baidu.tieba.sharedPref.b.a().a("push_channel_id", "");
    }

    public void d(long j) {
        com.baidu.tieba.sharedPref.b.a().b("nearbygroup_date", j);
    }

    public long bd() {
        return com.baidu.tieba.sharedPref.b.a().a("nearbygroup_date", 0L);
    }

    public void y(String str) {
        com.baidu.tieba.sharedPref.b.a().b("location_lat", str);
    }

    public String be() {
        return com.baidu.tieba.sharedPref.b.a().a("location_lat", "");
    }

    public void z(String str) {
        com.baidu.tieba.sharedPref.b.a().b("location_lng", str);
    }

    public String bf() {
        return com.baidu.tieba.sharedPref.b.a().a("location_lng", "");
    }

    public void A(String str) {
        com.baidu.tieba.sharedPref.b.a().b("location_pos", str);
    }

    public com.baidu.adp.lib.cache.s<String> bg() {
        if (this.W == null) {
            this.W = BdCacheService.c().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.W;
    }
}
