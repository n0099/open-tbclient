package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f1011a = "http://c.tieba.baidu.com/";
    public static String b = "http://tieba.baidu.com/";
    public static final Long c = Long.valueOf((long) Util.MILLSECONDS_OF_HOUR);
    public static final Long d = 36000000L;
    public static final Long e = 36000000L;
    public static final Long f = Long.valueOf((long) Util.MILLSECONDS_OF_DAY);
    public static final String g = String.valueOf(f1011a) + "c/s/apprecommend";
    public static final String h = String.valueOf(f1011a) + "c/s/recommend/";
    public static final String i = String.valueOf(f1011a) + "c/s/classic";
    public static String j = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String k = String.valueOf(f1011a) + "c/p/img?";
    public static int l = 80;
    public static final Bitmap.Config m = Bitmap.Config.RGB_565;
    private static String o = null;
    private static int p = 300;
    private static String q = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String r = q;
    private static int s = 80;
    private static int t = Util.BYTE_OF_MB;
    private static int u = 1024;
    private static int v = 1;
    private static String w = "贴吧客户端反馈";
    private static String x = "2631903";
    private static int y = 640;
    private static String z = "";
    public static final Long n = Long.valueOf((long) Util.MILLSECONDS_OF_HOUR);

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
        int a2 = com.baidu.tieba.util.am.a(context, 267.0f);
        if (a2 <= 400) {
            i2 = a2;
        }
        u = (int) (i2 * i2 * 1.62f * 2.0f);
        com.baidu.adp.lib.e.d.c("BIG_IMAGE_SIZE = " + u);
        return u;
    }

    public static int j() {
        return u;
    }

    public static void b(Context context) {
        t = a(context) * 13;
        if (t < com.baidu.tieba.util.am.c(context) * 0.28d) {
            t = (int) (com.baidu.tieba.util.am.c(context) * 0.28d);
        }
        com.baidu.adp.lib.e.d.c("BIG_IMAGE_MAX_USED_MEMORY = " + t);
    }

    public static void c(Context context) {
        if (context.getResources().getDisplayMetrics().density < 1.0f) {
            r = q;
            s = 80;
            return;
        }
        r = j;
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
            j = str;
        }
    }

    public static void a(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            p = i2;
        }
    }

    public static void d(Context context) {
        int sqrt = (int) Math.sqrt(com.baidu.tieba.util.am.a(context) * com.baidu.tieba.util.am.b(context));
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
        switch (TiebaApplication.f().ar()) {
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
        switch (TiebaApplication.f().ar()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static boolean r() {
        return com.baidu.adp.a.b.a().b();
    }
}
