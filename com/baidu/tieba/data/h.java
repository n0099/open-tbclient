package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.zeus.NotificationProxy;
/* loaded from: classes.dex */
public class h {
    public static String a = "http://c.tieba.baidu.com/";
    public static String b = "http://tieba.baidu.com/";
    public static String c = "http://static.tieba.baidu.com/";
    public static String d = "mo/q/tbeanwireless?_client_version=";
    public static final Long e = 3600000L;
    public static final Long f = 36000000L;
    public static final Long g = 36000000L;
    public static final Long h = 86400000L;
    public static final String i = b + "mo/q/topic_page/136_1";
    public static final String j = a + "c/s/recommend/";
    public static final String k = a + "c/s/classic";
    public static String l = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String m = a + "c/p/img?";
    public static int n = 80;
    public static final Bitmap.Config o = Bitmap.Config.RGB_565;
    private static String q = null;
    private static String r = null;
    private static int s = 300;
    private static String t = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String u = t;
    private static int v = 80;
    private static int w = 1048576;
    private static int x = NotificationProxy.MAX_URL_LENGTH;
    private static int y = 1;
    private static String z = "贴吧客户端反馈";
    private static String A = "2631903";
    private static int B = 640;
    private static String C = "";
    private static String D = "";
    private static int E = 3;
    public static final Long p = 3600000L;

    public static String a() {
        return q;
    }

    public static void a(String str) {
        q = str;
    }

    public static String b() {
        return r;
    }

    public static void b(String str) {
        r = str;
    }

    public static int c() {
        return s;
    }

    public static String d() {
        return t;
    }

    public static int e() {
        return w;
    }

    public static int f() {
        return x;
    }

    public static String g() {
        return z;
    }

    public static String h() {
        return A;
    }

    public static int i() {
        return B;
    }

    public static String j() {
        return C;
    }

    public static void c(String str) {
        C = str;
    }

    public static String k() {
        return D;
    }

    public static void d(String str) {
        D = str;
    }

    public static int l() {
        return E;
    }

    public static void a(int i2) {
        E = i2;
    }

    public static void e(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            t = str;
        }
    }

    public static int a(Context context) {
        int a2 = com.baidu.adp.lib.h.g.a(context, 427.0f);
        int i2 = a2 <= 640 ? a2 : 640;
        x = (int) (i2 * i2 * 1.6f * 2.0f);
        com.baidu.adp.lib.h.e.d("BIG_IMAGE_SIZE = " + x);
        return x;
    }

    public static int m() {
        return x;
    }

    public static final int n() {
        return 160000;
    }

    public static void b(Context context) {
        w = a(context) * 13;
        if (w < UtilHelper.a(context) * 0.28d) {
            w = (int) (UtilHelper.a(context) * 0.28d);
        }
        com.baidu.adp.lib.h.e.d("BIG_IMAGE_MAX_USED_MEMORY = " + w);
    }

    public static void c(Context context) {
        if (context.getResources().getDisplayMetrics().density < 1.0f) {
            u = t;
            v = 80;
            return;
        }
        u = l;
        v = SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN;
    }

    public static String o() {
        return u;
    }

    public static int p() {
        return v;
    }

    public static void f(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            l = str;
        }
    }

    public static void b(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            s = i2;
        }
    }

    public static void d(Context context) {
        int sqrt = (int) Math.sqrt(com.baidu.adp.lib.h.g.b(context) * com.baidu.adp.lib.h.g.c(context));
        if (sqrt > B) {
            B = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            B = (int) (B * 0.8d);
        }
    }

    public static void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            z = str;
            A = str2;
        }
    }

    public static void c(int i2) {
        y = i2;
    }

    public static int q() {
        return y;
    }

    public static int r() {
        switch (TiebaApplication.g().aj()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int s() {
        return r() + 1;
    }

    public static int t() {
        return 14;
    }

    public static int u() {
        switch (TiebaApplication.g().aj()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static boolean v() {
        return com.baidu.adp.a.b.a().b();
    }
}
