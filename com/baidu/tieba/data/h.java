package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.zeus.NotificationProxy;
/* loaded from: classes.dex */
public class h {
    public static String a = "http://c.tieba.baidu.com/";
    public static String b = "http://tieba.baidu.com/";
    public static String c = "http://static.tieba.baidu.com/";
    public static final Long d = 3600000L;
    public static final Long e = 36000000L;
    public static final Long f = 36000000L;
    public static final Long g = 86400000L;
    public static final String h = b + "mo/q/topic_page/136_1";
    public static final String i = a + "c/s/recommend/";
    public static final String j = a + "c/s/classic";
    public static String k = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String l = a + "c/p/img?";
    public static int m = 80;
    public static final Bitmap.Config n = Bitmap.Config.RGB_565;
    private static String p = null;
    private static String q = null;
    private static int r = 300;
    private static String s = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String t = s;
    private static int u = 80;
    private static int v = 1048576;
    private static int w = NotificationProxy.MAX_URL_LENGTH;
    private static int x = 1;
    private static String y = "贴吧客户端反馈";
    private static String z = "2631903";
    private static int A = 640;
    private static String B = "";
    private static String C = "";
    private static int D = 3;
    public static final Long o = 3600000L;

    public static String a() {
        return p;
    }

    public static void a(String str) {
        p = str;
    }

    public static String b() {
        return q;
    }

    public static void b(String str) {
        q = str;
    }

    public static int c() {
        return r;
    }

    public static String d() {
        return s;
    }

    public static int e() {
        return v;
    }

    public static int f() {
        return w;
    }

    public static String g() {
        return y;
    }

    public static String h() {
        return z;
    }

    public static int i() {
        return A;
    }

    public static String j() {
        return B;
    }

    public static void c(String str) {
        B = str;
    }

    public static String k() {
        return C;
    }

    public static void d(String str) {
        C = str;
    }

    public static int l() {
        return D;
    }

    public static void a(int i2) {
        D = i2;
    }

    public static void e(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            s = str;
        }
    }

    public static int a(Context context) {
        int i2 = BdWebErrorView.ERROR_CODE_400;
        int a2 = com.baidu.adp.lib.h.g.a(context, 267.0f);
        if (a2 <= 400) {
            i2 = a2;
        }
        w = (int) (i2 * i2 * 1.62f * 2.0f);
        com.baidu.adp.lib.h.e.d("BIG_IMAGE_SIZE = " + w);
        return w;
    }

    public static int m() {
        return w;
    }

    public static void b(Context context) {
        v = a(context) * 13;
        if (v < UtilHelper.a(context) * 0.28d) {
            v = (int) (UtilHelper.a(context) * 0.28d);
        }
        com.baidu.adp.lib.h.e.d("BIG_IMAGE_MAX_USED_MEMORY = " + v);
    }

    public static void c(Context context) {
        if (context.getResources().getDisplayMetrics().density < 1.0f) {
            t = s;
            u = 80;
            return;
        }
        t = k;
        u = SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN;
    }

    public static String n() {
        return t;
    }

    public static int o() {
        return u;
    }

    public static void f(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            k = str;
        }
    }

    public static void b(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            r = i2;
        }
    }

    public static void d(Context context) {
        int sqrt = (int) Math.sqrt(com.baidu.adp.lib.h.g.b(context) * com.baidu.adp.lib.h.g.c(context));
        if (sqrt > A) {
            A = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            A = (int) (A * 0.8d);
        }
    }

    public static void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            y = str;
            z = str2;
        }
    }

    public static void c(int i2) {
        x = i2;
    }

    public static int p() {
        return x;
    }

    public static int q() {
        switch (TiebaApplication.h().aj()) {
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
        switch (TiebaApplication.h().aj()) {
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
