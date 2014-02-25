package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.webkit.URLUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class i {
    public static String a = "http://c.tieba.baidu.com/";
    public static String b = "http://tieba.baidu.com/";
    public static final Long c = 3600000L;
    public static final Long d = 36000000L;
    public static final Long e = 36000000L;
    public static final Long f = 86400000L;
    public static final String g = String.valueOf(b) + "mo/q/topic_page/136_1";
    public static final String h = String.valueOf(a) + "c/s/recommend/";
    public static final String i = String.valueOf(a) + "c/s/classic";
    public static String j = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String k = String.valueOf(a) + "c/p/img?";
    public static int l = 80;
    public static final Bitmap.Config m = Bitmap.Config.RGB_565;
    private static String o = null;
    private static String p = null;
    private static int q = 300;
    private static String r = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String s = r;
    private static int t = 80;
    private static int u = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
    private static int v = 1024;
    private static int w = 1;
    private static String x = "贴吧客户端反馈";
    private static String y = "2631903";
    private static int z = 640;
    private static String A = "";
    private static String B = "";
    private static int C = 3;
    public static final Long n = 3600000L;
    private static boolean D = false;

    public static final String a() {
        return "com.baidu.tieba.broadcast.newversion";
    }

    public static final String b() {
        return "com.baidu.tieba.broadcast.image.resized";
    }

    public static final String c() {
        return "com.baidu.tieba.broadcast.imagepb.pagechanged";
    }

    public static final String d() {
        return "com.baidu.tieba.broadcast.imagepb.pageadded";
    }

    public static final String e() {
        return "com.baidu.tieba.broadcast.service";
    }

    public static final String f() {
        return "com.baidu.tieba.broadcast.changeskin";
    }

    public static final String g() {
        return "com.baidu.tieba.broadcast.sync";
    }

    public static final String h() {
        return "com.baidu.tieba.broadcast.signalert";
    }

    public static final String i() {
        return "com.baidu.tieba.broadcast.newrecommends";
    }

    public static final String j() {
        return "com.baidu.tieba.broadcast.changeSharedPref";
    }

    public static final String k() {
        return "tieba";
    }

    public static String l() {
        return o;
    }

    public static void a(String str) {
        o = str;
    }

    public static String m() {
        return p;
    }

    public static void b(String str) {
        p = str;
    }

    public static int n() {
        return q;
    }

    public static String o() {
        return r;
    }

    public static int p() {
        return u;
    }

    public static int q() {
        return v;
    }

    public static String r() {
        return x;
    }

    public static String s() {
        return y;
    }

    public static int t() {
        return z;
    }

    public static String u() {
        return A;
    }

    public static void c(String str) {
        A = str;
    }

    public static String v() {
        return B;
    }

    public static void d(String str) {
        B = str;
    }

    public static int w() {
        return C;
    }

    public static void a(int i2) {
        C = i2;
    }

    public static void e(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            r = str;
        }
    }

    public static int a(Context context) {
        int a2 = BdUtilHelper.a(context, 427.0f);
        int i2 = a2 <= 640 ? a2 : 640;
        v = (int) (i2 * i2 * 1.6f * 2.0f);
        com.baidu.adp.lib.util.f.e("BIG_IMAGE_SIZE = " + v);
        return v;
    }

    public static int x() {
        return v;
    }

    public static final int y() {
        return 230400;
    }

    public static void b(Context context) {
        u = a(context) * 13;
        if (u < UtilHelper.a(context) * 0.28d) {
            u = (int) (UtilHelper.a(context) * 0.28d);
        }
        com.baidu.adp.lib.util.f.e("BIG_IMAGE_MAX_USED_MEMORY = " + u);
    }

    public static void c(Context context) {
        if (context != null && context.getResources() != null) {
            if (context.getResources().getDisplayMetrics().density < 1.0f) {
                s = r;
                t = 80;
                return;
            }
            s = j;
            t = SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN;
        }
    }

    public static String z() {
        return s;
    }

    public static int A() {
        return t;
    }

    public static void f(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            j = str;
        }
    }

    public static void b(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            q = i2;
        }
    }

    public static void d(Context context) {
        int sqrt = (int) Math.sqrt(BdUtilHelper.b(context) * BdUtilHelper.c(context));
        if (sqrt > z) {
            z = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            z = (int) (z * 0.8d);
        }
    }

    public static void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            x = str;
            y = str2;
        }
    }

    public static void c(int i2) {
        w = i2;
    }

    public static int B() {
        switch (TiebaApplication.g().ah()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int C() {
        return B() + 1;
    }

    public static int D() {
        return 14;
    }

    public static int E() {
        switch (TiebaApplication.g().ah()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static boolean F() {
        return com.baidu.adp.a.b.a().d();
    }
}
