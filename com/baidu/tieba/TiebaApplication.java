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
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.account.aj;
import com.baidu.tieba.account.ak;
import com.baidu.tieba.c.aa;
import com.baidu.tieba.c.ab;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.af;
import com.baidu.tieba.service.MessagePullService;
import com.baidu.tieba.service.TiebaMessageService;
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
    private LocationManager B;
    private static com.baidu.tieba.a.a i = null;
    private static String o = null;
    private static boolean p = false;
    private static boolean V = false;
    private int e = 0;
    private HashMap g = null;
    private boolean h = true;
    private boolean j = false;
    private ab k = null;
    private aa l = null;
    private aa m = null;
    private String n = null;
    private boolean q = false;
    private String r = null;
    private int s = 0;
    private long t = 0;
    private long u = 0;
    private String v = null;
    public long a = 0;
    private int w = -1;
    private boolean x = true;
    private LocationClient y = null;
    private BDLocationListener z = null;
    private int A = 0;
    private Location C = null;
    private ArrayList D = null;
    private ExecutorService E = null;
    private int F = 2;
    private int G = 1;
    private boolean H = true;
    private int I = 3;
    private boolean J = true;
    private float K = 0.0f;
    private boolean L = true;
    private boolean M = true;
    private boolean N = false;
    private int O = 1;
    private boolean P = true;
    private int Q = 0;
    private boolean R = false;
    private int S = 0;
    private long T = 0;
    private long U = 0;
    public ArrayList b = null;
    private Hashtable W = null;
    public Handler c = new Handler(new r(this));
    private int X = 0;
    private boolean Y = true;
    private boolean Z = true;
    private boolean aa = true;
    private boolean ab = true;
    private boolean ac = false;
    private boolean ad = true;
    private long ae = 0;
    private long af = 0;
    private long ag = 0;
    NotificationManager d = null;
    private final LocationListener ah = new s(this);

    /* loaded from: classes.dex */
    public class MyBDLocationListenner implements BDLocationListener {
        public MyBDLocationListenner() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                return;
            }
            TiebaApplication.this.A = 0;
            TiebaApplication.this.as();
            TiebaApplication.this.C = new Location("baidu_provider");
            TiebaApplication.this.C.setAltitude(bDLocation.getAltitude());
            TiebaApplication.this.C.setLatitude(bDLocation.getLatitude());
            TiebaApplication.this.C.setLongitude(bDLocation.getLongitude());
            TiebaApplication.this.a = System.currentTimeMillis();
            TiebaApplication.this.a(TiebaApplication.this.A, "", TiebaApplication.this.C);
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public static String E() {
        return o;
    }

    public static TiebaApplication a() {
        return f;
    }

    public static String a(Context context) {
        String str = null;
        String string = context.getSharedPreferences("settings", 0).getString("client_id", null);
        if (string != null) {
            int indexOf = string.indexOf("\t");
            if (indexOf != -1) {
                if (com.baidu.tieba.a.h.h().equals(string.substring(0, indexOf))) {
                    str = string.substring(indexOf + 1);
                } else {
                    b((Context) a());
                }
            } else {
                b((Context) a());
            }
        } else {
            str = string;
        }
        ae.a("TiebaApplication", "readClientId", str);
        return str;
    }

    public static void a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("settings", 0).edit();
        edit.putString("client_id", String.valueOf(com.baidu.tieba.a.h.h()) + "\t" + str);
        edit.commit();
    }

    public static void a(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    private void aA() {
        try {
            com.baidu.tieba.a.h.b(getPackageManager().getPackageInfo("com.baidu.tieba", 16384).versionName);
            if (com.baidu.tieba.a.h.h() == null) {
                com.baidu.tieba.a.h.b("");
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "InitVersion", e.getMessage());
            com.baidu.tieba.a.h.b("");
        }
    }

    private void aB() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String aC = aC();
                if (aC == null) {
                    String aD = aD();
                    if (aD == null || aD.length() <= 0) {
                        bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && readLine.length() > 0) {
                                com.baidu.tieba.a.h.a(readLine);
                                j(readLine);
                                k(readLine);
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            ae.b(getClass().getName(), "InitFrom", e.getMessage());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            ae.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.h.a());
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
                    } else {
                        com.baidu.tieba.a.h.a(aD);
                        j(aD);
                        bufferedReader = null;
                    }
                } else {
                    com.baidu.tieba.a.h.a(aC);
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
        ae.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tieba.a.h.a());
    }

    private String aC() {
        return getSharedPreferences("settings", 0).getString("from_id", null);
    }

    private String aD() {
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
            ae.b(getClass().getName(), "getFromByFile", e.getMessage());
        }
        return str;
    }

    private void aE() {
        Intent intent = new Intent("com.baidu.tieba.broadcast.notify");
        intent.putExtra("relay", S());
        intent.putExtra("at_me", T());
        intent.putExtra("fans", U());
        sendBroadcast(intent);
        ae.a(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(S()), Long.valueOf(T()), Long.valueOf(U())));
    }

    private void aF() {
        if (this.q) {
            if (this.s < 0) {
                this.s = 0;
            }
            if (this.t == 0 && this.s > 0) {
                this.t = System.nanoTime();
            }
            ae.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.s));
            this.c.removeMessages(4);
            if (this.s != 0 || this.t <= 0) {
                return;
            }
            this.c.sendMessageDelayed(this.c.obtainMessage(4), 180000L);
        }
    }

    private void aG() {
        try {
            this.B = (LocationManager) getSystemService("location");
            if (this.x) {
                this.z = new MyBDLocationListenner();
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName("tieba");
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(500);
                locationClientOption.disableCache(true);
                this.y = new LocationClient(getApplicationContext());
                this.y.registerLocationListener(this.z);
                this.y.setLocOption(locationClientOption);
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "initLocationServer", e.toString());
        }
    }

    public static boolean ag() {
        return V;
    }

    private void aw() {
        if (Build.VERSION.SDK_INT >= 5) {
            p = new AccountProxy(this).hasBaiduAccount();
        } else {
            p = false;
        }
    }

    private void ax() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.n = telephonyManager.getDeviceId();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r0.equalsIgnoreCase("com.baidu.tieba:remote") != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean ay() {
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
                } else if (runningAppProcesses.get(i2).pid == myPid) {
                    String str = runningAppProcesses.get(i2).processName;
                    if (str != null) {
                        if (!str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1")) {
                        }
                    }
                } else {
                    i2++;
                }
            }
        }
        z = true;
        return z;
    }

    private void az() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
        this.F = sharedPreferences.getInt("image_quality", 2);
        this.G = sharedPreferences.getInt("view_image_quality", 2);
        this.H = sharedPreferences.getBoolean("show_images", true);
        this.I = sharedPreferences.getInt("font_size", 2);
        this.ad = sharedPreferences.getBoolean("permoted_message", true);
        this.h = sharedPreferences.getBoolean("display_photo", true);
        this.J = sharedPreferences.getBoolean("abstract_state", true);
        this.K = sharedPreferences.getFloat("eyeshield_mode_1", 0.0f);
        this.u = sharedPreferences.getLong("message_id", 0L);
        this.M = sharedPreferences.getBoolean("motu_on", true);
        this.N = sharedPreferences.getBoolean("app_switcher", false);
        this.O = sharedPreferences.getInt("browser_type", 1);
        this.R = sharedPreferences.getBoolean("manage_mode", false);
        this.L = sharedPreferences.getBoolean("location_on", true);
        this.T = sharedPreferences.getLong("refresh_recommend_time", 0L);
        this.U = sharedPreferences.getLong("refresh_guess_time", 0L);
        this.S = sharedPreferences.getInt("guide_page_bits", 0);
        this.v = sharedPreferences.getString("show_all_like_items", null);
        this.Q = sharedPreferences.getInt("webview_crash_count", 0);
        this.x = sharedPreferences.getBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            this.x = false;
        }
    }

    public static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("settings", 0).edit();
        edit.remove("client_id");
        edit.commit();
    }

    public static void b(com.baidu.tieba.a.a aVar) {
        i = aVar;
    }

    private void c(float f2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.eyeshield");
        intent.putExtra("eyeshield_mode", f2);
        sendBroadcast(intent);
    }

    public static void f(String str) {
        if (i != null) {
            i.d(str);
        }
    }

    public static boolean f() {
        return p;
    }

    public static void h(String str) {
        o = str;
    }

    private void i(int i2) {
        if (this.d == null) {
            return;
        }
        try {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.d.cancel(R.drawable.icon);
                    return;
                }
                return;
            }
            Notification notification = new Notification(R.drawable.icon, "您有新消息了", System.currentTimeMillis());
            Intent intent = new Intent(this, MainTabActivity.class);
            if (this.ae > 0 || this.af > 0 || this.ag > 0) {
                intent.putExtra("goto_type", "goto_person");
            }
            intent.putExtra("close_dialog", true);
            intent.setFlags(872415232);
            notification.setLatestEventInfo(this, "百度贴吧", String.valueOf(String.valueOf(V())) + "条新消息，刷新看看", PendingIntent.getActivity(this, 0, intent, 0));
            notification.defaults = -1;
            notification.flags = 16;
            notification.audioStreamType = 5;
            if (!this.ab) {
                notification.defaults &= -2;
            }
            if (!this.ac) {
                notification.defaults &= -3;
            }
            this.d.notify(R.drawable.icon, notification);
        } catch (Exception e) {
            ae.b(getClass().toString(), "showNotification", e.getMessage());
        }
    }

    private void j(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("from_id", str);
        edit.commit();
    }

    private void k(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            File e = com.baidu.tieba.c.o.e("from.dat");
            if (e != null) {
                FileWriter fileWriter = new FileWriter(e);
                fileWriter.append((CharSequence) str);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Exception e2) {
            ae.b(getClass().getName(), "saveFromToFile", e2.getMessage());
        }
    }

    private void l(String str) {
        if (this.B.isProviderEnabled(str)) {
            this.B.requestLocationUpdates(str, 10000L, 100.0f, this.ah);
        }
    }

    public static String o() {
        return com.baidu.tieba.a.h.a();
    }

    public static void o(boolean z) {
        V = z;
    }

    public static String u() {
        if (i != null) {
            ae.a("TiebaApplication", "getCurrentAccount", String.valueOf(i.a()));
            return i.a();
        }
        return null;
    }

    public static String v() {
        if (i != null) {
            return i.d();
        }
        return null;
    }

    public static com.baidu.tieba.a.a w() {
        return i;
    }

    public static String x() {
        if (i != null) {
            return i.b();
        }
        return null;
    }

    public long A() {
        return getSharedPreferences("settings", 0).getLong("update_notify_time", 0L);
    }

    public void B() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("tdatabasecreatetime", new Date().getTime());
        edit.commit();
    }

    public boolean C() {
        return y() > 50 && new Date().getTime() - z() > 2592000000L;
    }

    public String D() {
        if (i != null) {
            return i.f();
        }
        return null;
    }

    public boolean F() {
        return this.j;
    }

    public int G() {
        return this.X;
    }

    public void H() {
        d(300);
        j(true);
        l(true);
        k(true);
    }

    public boolean I() {
        return this.ad;
    }

    public boolean J() {
        return this.ab;
    }

    public boolean K() {
        return this.ac;
    }

    public int L() {
        if (this.ab || this.ac) {
            if (!this.ab || this.ac) {
                return (this.ab || !this.ac) ? 3 : 2;
            }
            return 1;
        }
        return 0;
    }

    public boolean M() {
        return this.Y;
    }

    public boolean N() {
        return this.Z;
    }

    public boolean O() {
        return this.aa;
    }

    public boolean P() {
        return this.X > 0 && (this.aa || this.Z || this.Y);
    }

    public void Q() {
        if (a().P()) {
            startService(new Intent(this, TiebaMessageService.class));
        }
    }

    public void R() {
        stopService(new Intent(this, TiebaMessageService.class));
    }

    public long S() {
        return this.ae;
    }

    public long T() {
        return this.af;
    }

    public long U() {
        return this.ag;
    }

    public long V() {
        return this.ae + this.af + this.ag;
    }

    public void W() {
        this.ae = 0L;
        this.af = 0L;
        this.ag = 0L;
    }

    public int X() {
        return this.F;
    }

    public int Y() {
        return this.G;
    }

    public boolean Z() {
        return this.H;
    }

    public Location a(u uVar) {
        boolean z;
        if (this.C == null || System.currentTimeMillis() - this.a > 300000) {
            if (uVar != null) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.D.size()) {
                        u uVar2 = (u) ((SoftReference) this.D.get(i2)).get();
                        if (uVar2 != null && uVar2.equals(uVar)) {
                            z = true;
                            break;
                        }
                        i2++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    if (this.D.size() > 10) {
                        this.D.remove(0);
                    }
                    this.D.add(new SoftReference(uVar));
                }
                ar();
            }
            return null;
        }
        return this.C;
    }

    public void a(float f2) {
        b(f2);
        getSharedPreferences("settings", 0).edit().putFloat("eyeshield_mode_1", f2).commit();
        c(f2);
    }

    public void a(int i2) {
        if (this.O == i2) {
            return;
        }
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("browser_type", i2);
        edit.commit();
        this.O = i2;
    }

    public void a(int i2, int i3, String str) {
        if (this.E == null) {
            this.E = Executors.newSingleThreadExecutor();
        }
        ae.a(getClass().getName(), "pv_addImagePv", "img_num=" + i2 + " img_total" + i3);
        aj ajVar = new aj(i2, i3);
        ajVar.a(str);
        this.E.execute(ajVar);
    }

    public void a(int i2, String str, Location location) {
        if (this.D == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.D.size()) {
                this.D.clear();
                return;
            }
            u uVar = (u) ((SoftReference) this.D.get(i4)).get();
            if (uVar != null) {
                uVar.a(i2, str, location);
            }
            i3 = i4 + 1;
        }
    }

    public void a(long j) {
        this.T = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_recommend_time", j);
        edit.commit();
    }

    public void a(long j, long j2, long j3) {
        if (j == this.ae && j2 == this.af && j3 == this.ag) {
            return;
        }
        int i2 = 0;
        if (j > this.ae || j2 > this.af || j3 > this.ag) {
            i2 = 1;
        } else if (j < this.ae || j2 < this.af || j3 < this.ag) {
            i2 = 2;
        }
        this.ae = j;
        this.af = j2;
        this.ag = j3;
        aE();
        i(i2);
    }

    public void a(e eVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ((e) this.b.get(i2)).a();
                } catch (Exception e) {
                    ae.b(getClass().getName(), "addRemoteActivity", e.getMessage());
                }
            }
            if (eVar != null) {
                this.b.add(eVar);
            }
        }
    }

    public void a(Boolean bool) {
        this.h = bool.booleanValue();
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("display_photo", bool.booleanValue());
        edit.commit();
    }

    public void a(String str) {
        this.r = str;
    }

    public void a(boolean z) {
        this.x = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("bd_loc_switcher", this.x);
        edit.commit();
    }

    public void a(boolean z, boolean z2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        if (z2) {
            this.w |= 16;
            if (z) {
                this.w |= 32;
            }
        } else {
            this.w |= 256;
            if (z) {
                this.w |= 512;
            }
        }
        edit.putInt("check_network_confirm", this.w);
        edit.commit();
    }

    public int aa() {
        return this.I;
    }

    public boolean ab() {
        return this.J;
    }

    public float ac() {
        return this.K;
    }

    public int ad() {
        return this.Q;
    }

    public void ae() {
        int i2 = getSharedPreferences("settings", 0).getInt("bd_loc_crash_count", 0) + 1;
        getSharedPreferences("settings", 0).edit().putInt("bd_loc_crash_count", i2).commit();
        if (i2 > 3) {
            a(false);
        }
    }

    public void af() {
        if (this.d != null) {
            this.d.cancel(R.drawable.icon);
        }
    }

    public ab ah() {
        return this.k;
    }

    public aa ai() {
        return this.l;
    }

    public aa aj() {
        return this.m;
    }

    public int ak() {
        switch (this.F) {
            case 1:
                return 900;
            case 2:
            default:
                return 600;
            case 3:
                return 300;
        }
    }

    public void al() {
        this.s++;
        aF();
    }

    public void am() {
        this.s--;
        aF();
    }

    public boolean an() {
        return !getSharedPreferences("settings", 0).getString("lase_version", "").equals(com.baidu.tieba.a.h.h());
    }

    public void ao() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("lase_version", com.baidu.tieba.a.h.h());
        edit.commit();
    }

    public void ap() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.remove("account_share");
        edit.commit();
    }

    public String aq() {
        return getSharedPreferences("settings", 0).getString("account_share", null);
    }

    public void ar() {
        try {
            if (this.C == null || System.currentTimeMillis() - this.a > 300000) {
                this.C = null;
                if (this.c.hasMessages(5)) {
                    this.c.removeMessages(5);
                }
                if (this.B != null) {
                    this.B.removeUpdates(this.ah);
                }
                if (this.x) {
                    if (!this.y.isStarted()) {
                        this.y.start();
                    }
                    this.y.requestLocation();
                }
                this.A = 4;
                if (this.B != null && !this.B.isProviderEnabled("gps") && !this.B.isProviderEnabled("network")) {
                    this.A = 3;
                    if (!this.x) {
                        this.c.sendMessageDelayed(this.c.obtainMessage(5), 100L);
                        return;
                    }
                }
                if (this.B == null || !this.B.isProviderEnabled("gps")) {
                    this.A = 1;
                } else {
                    l("gps");
                }
                if (this.B == null || !this.B.isProviderEnabled("network")) {
                    this.A = 2;
                } else {
                    l("network");
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(5), 60000L);
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "startLocationServer", e.toString());
        }
    }

    public void as() {
        if (this.c.hasMessages(5)) {
            this.c.removeMessages(5);
        }
        if (this.B != null) {
            this.B.removeUpdates(this.ah);
        }
        if (this.x && this.y != null && this.y.isStarted()) {
            this.y.stop();
        }
    }

    public Location at() {
        return this.C;
    }

    public int au() {
        this.w = getSharedPreferences("settings", 0).getInt("check_network_confirm", 0);
        return this.w;
    }

    public long av() {
        return this.u;
    }

    public String b() {
        return this.r;
    }

    public void b(float f2) {
        this.K = f2;
    }

    public void b(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("tdatabaseusetimes", i2);
        edit.commit();
    }

    public void b(long j) {
        this.U = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("refresh_guess_time", j);
        edit.commit();
    }

    public void b(e eVar) {
        if (this.b != null) {
            this.b.remove(eVar);
        }
    }

    public void b(u uVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.D.size()) {
                return;
            }
            SoftReference softReference = (SoftReference) this.D.get(i3);
            u uVar2 = (u) softReference.get();
            if (uVar2 != null && uVar2.equals(uVar)) {
                this.D.remove(softReference);
                return;
            }
            i2 = i3 + 1;
        }
    }

    public void b(Boolean bool) {
        this.R = bool.booleanValue();
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("manage_mode", bool.booleanValue());
        edit.commit();
    }

    public void b(boolean z) {
        this.P = z;
    }

    public boolean b(String str) {
        return (this.W == null || str == null || !this.W.containsKey(str)) ? false : true;
    }

    public void c() {
        this.W = new Hashtable();
        new com.baidu.tieba.c.p(this.W).start();
    }

    public void c(int i2) {
        if (i2 == 0) {
            a().h(false);
            a().i(false);
        } else if (i2 == 1) {
            a().h(true);
            a().i(false);
        } else if (i2 == 2) {
            a().h(false);
            a().i(true);
        } else {
            a().h(true);
            a().i(true);
        }
    }

    public void c(long j) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("update_notify_time", j);
        edit.commit();
    }

    public void c(String str) {
        if (b(str) || this.W == null || str == null) {
            return;
        }
        this.W.put(str, 1);
        new com.baidu.tieba.c.p(1, str).start();
    }

    public void c(boolean z) {
        this.L = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("location_on", this.L);
        edit.commit();
    }

    public void d() {
        startService(new Intent(this, MessagePullService.class));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 int)] */
    public void d(int i2) {
        ae.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i2).toString());
        this.X = i2;
        if (i2 != 0) {
            this.c.sendMessage(this.c.obtainMessage(2));
            return;
        }
        a(0L, 0L, 0L);
        this.c.sendMessage(this.c.obtainMessage(3));
    }

    public void d(long j) {
        if (j >= 0) {
            a(j, this.af, this.ag);
        }
    }

    public void d(String str) {
        if (!b(str) || this.W == null || str == null) {
            return;
        }
        this.W.remove(str);
        new com.baidu.tieba.c.p(2, str).start();
    }

    public void d(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("motu_on", z);
        edit.commit();
        this.M = z;
    }

    public Bitmap e(String str) {
        SoftReference softReference = (SoftReference) this.g.get(str);
        if (softReference == null || softReference.get() == null) {
            Bitmap a = com.baidu.tieba.c.n.a(f, str);
            if (a != null) {
                this.g.put(str, new SoftReference(a));
                return a;
            }
            return a;
        }
        return (Bitmap) softReference.get();
    }

    public void e() {
        stopService(new Intent(this, MessagePullService.class));
    }

    public void e(int i2) {
        if (this.F == i2) {
            return;
        }
        this.F = i2;
        getSharedPreferences("settings", 0).edit().putInt("image_quality", i2).commit();
    }

    public void e(long j) {
        if (j >= 0) {
            a(this.ae, j, this.ag);
        }
    }

    public void e(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("app_switcher", z);
        edit.commit();
        this.N = z;
    }

    public void f(int i2) {
        if (this.G == i2) {
            return;
        }
        this.G = i2;
        getSharedPreferences("settings", 0).edit().putInt("view_image_quality", i2).commit();
    }

    public void f(long j) {
        if (j >= 0) {
            a(this.ae, this.af, j);
        }
    }

    public void f(boolean z) {
        this.j = z;
    }

    public String g() {
        return this.n;
    }

    public void g(int i2) {
        if (this.I == i2) {
            return;
        }
        this.I = i2;
        getSharedPreferences("settings", 0).edit().putInt("font_size", i2).commit();
    }

    public void g(long j) {
        this.u = j;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putLong("message_id", j);
        edit.commit();
    }

    public void g(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        synchronized (this) {
            if (i != null) {
                i.e(str);
            }
        }
    }

    public void g(boolean z) {
        this.ad = z;
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putBoolean("permoted_message", z);
        edit.commit();
        if (z) {
            d();
        } else {
            e();
        }
    }

    public int h() {
        return this.O;
    }

    public void h(int i2) {
        this.Q = i2;
        getSharedPreferences("settings", 0).edit().putInt("webview_crash_count", i2).commit();
    }

    public void h(boolean z) {
        if (this.ab == z) {
            return;
        }
        this.ab = z;
    }

    public void i(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("account_share", str);
        edit.commit();
    }

    public void i(boolean z) {
        this.ac = z;
    }

    public boolean i() {
        return this.P;
    }

    public void j(boolean z) {
        this.Y = z;
        if (z) {
            return;
        }
        f(0L);
    }

    public boolean j() {
        return this.L;
    }

    public void k(boolean z) {
        this.Z = z;
        if (z) {
            return;
        }
        e(0L);
    }

    public boolean k() {
        return this.M;
    }

    public void l(boolean z) {
        this.aa = z;
        if (z) {
            return;
        }
        d(0L);
    }

    public boolean l() {
        return this.N;
    }

    public void m() {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putString("show_all_like_items", com.baidu.tieba.a.h.h());
        edit.commit();
        this.v = com.baidu.tieba.a.h.h();
    }

    public void m(boolean z) {
        if (this.H == z) {
            return;
        }
        this.H = z;
        getSharedPreferences("settings", 0).edit().putBoolean("show_images", z).commit();
    }

    public String n() {
        return this.v;
    }

    public void n(boolean z) {
        this.J = z;
        getSharedPreferences("settings", 0).edit().putBoolean("abstract_state", z).commit();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        f = this;
        com.baidu.tieba.c.w.c();
        aA();
        aB();
        aw();
        az();
        o = a((Context) this);
        ax();
        com.baidu.tieba.a.h.c(this);
        com.baidu.tieba.a.h.b(this);
        try {
            Thread.setDefaultUncaughtExceptionHandler(new af());
        } catch (SecurityException e) {
            ae.b(getClass().getName(), "onCreate", e.getMessage());
        }
        getContentResolver().registerContentObserver(Uri.parse("content://telephony/carriers"), true, new t(this, new Handler()));
        this.q = ay();
        if (this.q) {
            au();
            this.g = new HashMap();
            i = com.baidu.tieba.c.k.l();
            if (f()) {
                a.a(this);
            } else {
                com.baidu.tieba.account.a.a().a(this);
            }
            com.baidu.tieba.c.k.u();
            c();
            this.k = new ab();
            this.l = new aa(300);
            this.m = new aa(100);
            this.d = (NotificationManager) getSystemService("notification");
            new ak("open").start();
            if (I()) {
                d();
            }
            if (ab()) {
                new ak("frs_abstract", "1").start();
            }
            aG();
            this.D = new ArrayList();
        } else {
            this.b = new ArrayList();
        }
        registerReceiver(new com.baidu.tieba.service.f(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        super.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public int p(boolean z) {
        if (z) {
            if ((this.w & 16) == 0) {
                return -1;
            }
            return (this.w & 32) == 0 ? 0 : 1;
        } else if ((this.w & 256) != 0) {
            return (this.w & 512) == 0 ? 0 : 1;
        } else {
            return -1;
        }
    }

    public void p() {
        a(0L, 0L, 0L);
        com.baidu.tieba.c.k.u();
    }

    public boolean q() {
        return this.h;
    }

    public boolean r() {
        return this.R;
    }

    public long s() {
        return this.T;
    }

    public long t() {
        return this.U;
    }

    public int y() {
        int i2 = getSharedPreferences("settings", 0).getInt("tdatabaseusetimes", 0);
        ae.a("TiebaApplication", "getAPPUseTimes", String.valueOf(i2));
        return i2;
    }

    public long z() {
        long j = getSharedPreferences("settings", 0).getLong("tdatabasecreatetime", 0L);
        ae.a("TiebaApplication", "getTDatabaseCreateTime", ad.a(j));
        return j;
    }
}
