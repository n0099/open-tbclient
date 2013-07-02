package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.NotificationProxy;
/* loaded from: classes.dex */
public class g {
    public static String a = "http://c.tieba.baidu.com/";
    public static final Long b = 3600000L;
    public static final Long c = 36000000L;
    public static final Long d = 36000000L;
    public static final Long e = 86400000L;
    public static final String f = String.valueOf(a) + "c/s/apprecommend";
    public static final String g = String.valueOf(a) + "c/s/recommend/";
    public static final String h = String.valueOf(a) + "c/s/classic";
    public static String i = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String j = String.valueOf(a) + "c/p/img?";
    public static String k = "com.baidu.tieba.broadcast.notify";
    public static String l = "com.baidu.tieba.broadcast.newversion";
    public static int m = 80;
    public static final Bitmap.Config n = Bitmap.Config.RGB_565;
    private static String o = null;
    private static int p = MKEvent.ERROR_PERMISSION_DENIED;
    private static String q = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String r = q;
    private static int s = 80;
    private static int t = 1048576;
    private static int u = NotificationProxy.MAX_URL_LENGTH;
    private static int v = 1;
    private static String w = "贴吧客户端反馈";
    private static String x = "2631903";
    private static int y = 640;
    private static String z = "";
    private static boolean A = false;

    public static String a() {
        return o;
    }

    public static void a(String str) {
        o = str;
    }

    public static int b() {
        return p;
    }

    public static String c() {
        return q;
    }

    public static int d() {
        return t;
    }

    public static int e() {
        return u;
    }

    public static String f() {
        return w;
    }

    public static String g() {
        return x;
    }

    public static int h() {
        return y;
    }

    public static String i() {
        return z;
    }

    public static void b(String str) {
        z = str;
    }

    public static void c(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            q = str;
        }
    }

    public static int a(Context context) {
        int i2 = BdWebErrorView.ERROR_CODE_400;
        int a2 = com.baidu.tieba.util.aa.a(context, 267.0f);
        if (a2 <= 400) {
            i2 = a2;
        }
        u = (int) (i2 * i2 * 1.62f * 2.0f);
        com.baidu.adp.lib.c.b.c("BIG_IMAGE_SIZE = " + u);
        return u;
    }

    public static int j() {
        return u;
    }

    public static void b(Context context) {
        t = a(context) * 13;
        if (t < com.baidu.tieba.util.aa.c(context) * 0.28d) {
            t = (int) (com.baidu.tieba.util.aa.c(context) * 0.28d);
        }
        com.baidu.adp.lib.c.b.c("BIG_IMAGE_MAX_USED_MEMORY = " + t);
    }

    public static void c(Context context) {
        if (context.getResources().getDisplayMetrics().density < 1.0f) {
            r = q;
            s = 80;
            return;
        }
        r = i;
        s = 110;
    }

    public static String k() {
        return r;
    }

    public static int l() {
        return s;
    }

    public static void d(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            i = str;
        }
    }

    public static void a(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            p = i2;
        }
    }

    public static void d(Context context) {
        int sqrt = (int) Math.sqrt(com.baidu.tieba.util.aa.a(context) * com.baidu.tieba.util.aa.b(context));
        if (sqrt > y) {
            y = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            y = (int) (y * 0.8d);
        }
    }

    public static void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            w = str;
            x = str2;
        }
    }

    public static void b(int i2) {
        v = i2;
    }

    public static int m() {
        return v;
    }

    public static int n() {
        switch (TiebaApplication.f().ap()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int o() {
        return n() + 1;
    }

    public static int p() {
        return 14;
    }

    public static int q() {
        switch (TiebaApplication.f().ap()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static void r() {
        if ((TiebaApplication.f().getApplicationInfo().flags & 2) == 0) {
            A = false;
        } else {
            A = true;
        }
    }

    public static boolean s() {
        return A;
    }
}
