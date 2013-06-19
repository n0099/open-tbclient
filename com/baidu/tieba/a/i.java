package com.baidu.tieba.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.NotificationProxy;
/* loaded from: classes.dex */
public class i {
    public static final Long a = 3600000L;
    public static final Long b = 36000000L;
    public static final Long c = 36000000L;
    public static final Long d = 86400000L;
    public static String e = "http://c.tieba.baidu.com/";
    public static final String f = String.valueOf(e) + "c/s/apprecommend";
    public static final String g = String.valueOf(e) + "c/s/recommend/";
    public static final String h = String.valueOf(e) + "c/s/classic";
    public static String i = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String j = String.valueOf(e) + "c/p/img?";
    public static int k = 80;
    public static final Bitmap.Config l = Bitmap.Config.RGB_565;
    private static String m = null;
    private static int n = MKEvent.ERROR_PERMISSION_DENIED;
    private static String o = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String p = o;
    private static int q = 80;
    private static int r = 1048576;
    private static int s = NotificationProxy.MAX_URL_LENGTH;
    private static int t = 1;
    private static String u = "贴吧客户端反馈";
    private static String v = "2631903";
    private static int w = 640;
    private static String x = "";
    private static boolean y = false;

    public static String a() {
        return m;
    }

    public static void a(String str) {
        m = str;
    }

    public static int b() {
        return n;
    }

    public static String c() {
        return o;
    }

    public static int d() {
        return r;
    }

    public static int e() {
        return s;
    }

    public static String f() {
        return u;
    }

    public static String g() {
        return v;
    }

    public static int h() {
        return w;
    }

    public static String i() {
        return x;
    }

    public static void b(String str) {
        x = str;
    }

    public static void c(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            o = str;
        }
    }

    public static int a(Context context) {
        int i2 = BdWebErrorView.ERROR_CODE_400;
        int a2 = com.baidu.tieba.d.ag.a(context, 267.0f);
        if (a2 <= 400) {
            i2 = a2;
        }
        s = (int) (i2 * i2 * 1.62f * 2.0f);
        com.baidu.adp.lib.e.b.c("BIG_IMAGE_SIZE = " + s);
        return s;
    }

    public static int j() {
        return s;
    }

    public static void b(Context context) {
        r = a(context) * 13;
        if (r < com.baidu.tieba.d.ag.c(context) * 0.28d) {
            r = (int) (com.baidu.tieba.d.ag.c(context) * 0.28d);
        }
        com.baidu.adp.lib.e.b.c("BIG_IMAGE_MAX_USED_MEMORY = " + r);
    }

    public static void c(Context context) {
        if (context.getResources().getDisplayMetrics().density < 1.0f) {
            p = o;
            q = 80;
            return;
        }
        p = i;
        q = 110;
    }

    public static String k() {
        return p;
    }

    public static int l() {
        return q;
    }

    public static void d(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            i = str;
        }
    }

    public static void a(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            n = i2;
        }
    }

    public static void d(Context context) {
        int sqrt = (int) Math.sqrt(com.baidu.tieba.d.ag.a(context) * com.baidu.tieba.d.ag.b(context));
        if (sqrt > w) {
            w = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            w = (int) (w * 0.8d);
        }
    }

    public static void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            u = str;
            v = str2;
        }
    }

    public static void b(int i2) {
        t = i2;
    }

    public static int m() {
        return t;
    }

    public static int n() {
        switch (TiebaApplication.e().ap()) {
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
        switch (TiebaApplication.e().ap()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static void r() {
        if ((TiebaApplication.e().getApplicationInfo().flags & 2) == 0) {
            y = false;
        } else {
            y = true;
        }
    }

    public static boolean s() {
        return y;
    }
}
