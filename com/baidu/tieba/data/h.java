package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class h {
    public static String a = "http://c.tieba.baidu.com/";
    public static String b = "http://tieba.baidu.com/";
    public static final Long c = 3600000L;
    public static final Long d = 36000000L;
    public static final Long e = 36000000L;
    public static final Long f = 86400000L;
    public static final String g = b + "mo/q/topic_page/136_1";
    public static final String h = a + "c/s/recommend/";
    public static final String i = a + "c/s/classic";
    public static String j = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String k = a + "c/p/img?";
    public static int l = 80;
    public static final Bitmap.Config m = Bitmap.Config.RGB_565;
    private static String o = null;
    private static String p = null;
    private static int q = 300;
    private static String r = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String s = r;
    private static int t = 80;
    private static int u = 1048576;
    private static int v = 1024;
    private static int w = 1;
    private static String x = "贴吧客户端反馈";
    private static String y = "2631903";
    private static int z = 640;
    private static String A = "";
    private static String B = "";
    private static int C = 3;
    public static final Long n = 3600000L;

    public static String a() {
        return o;
    }

    public static void a(String str) {
        o = str;
    }

    public static String b() {
        return p;
    }

    public static void b(String str) {
        p = str;
    }

    public static int c() {
        return q;
    }

    public static String d() {
        return r;
    }

    public static int e() {
        return u;
    }

    public static int f() {
        return v;
    }

    public static String g() {
        return x;
    }

    public static String h() {
        return y;
    }

    public static int i() {
        return z;
    }

    public static String j() {
        return A;
    }

    public static void c(String str) {
        A = str;
    }

    public static String k() {
        return B;
    }

    public static void d(String str) {
        B = str;
    }

    public static int l() {
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
        int a2 = com.baidu.adp.lib.g.g.a(context, 427.0f);
        int i2 = a2 <= 640 ? a2 : 640;
        v = (int) (i2 * i2 * 1.6f * 2.0f);
        com.baidu.adp.lib.g.e.d("BIG_IMAGE_SIZE = " + v);
        return v;
    }

    public static int m() {
        return v;
    }

    public static final int n() {
        return 230400;
    }

    public static void b(Context context) {
        u = a(context) * 13;
        if (u < UtilHelper.a(context) * 0.28d) {
            u = (int) (UtilHelper.a(context) * 0.28d);
        }
        com.baidu.adp.lib.g.e.d("BIG_IMAGE_MAX_USED_MEMORY = " + u);
    }

    public static void c(Context context) {
        if (context.getResources().getDisplayMetrics().density < 1.0f) {
            s = r;
            t = 80;
            return;
        }
        s = j;
        t = SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN;
    }

    public static String o() {
        return s;
    }

    public static int p() {
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
        int sqrt = (int) Math.sqrt(com.baidu.adp.lib.g.g.b(context) * com.baidu.adp.lib.g.g.c(context));
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

    public static int q() {
        switch (TiebaApplication.h().ai()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int r() {
        return q() + 1;
    }

    public static int s() {
        return 14;
    }

    public static int t() {
        switch (TiebaApplication.h().ai()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static boolean u() {
        return com.baidu.adp.a.b.a().b();
    }
}
