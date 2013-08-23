package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f1014a = "http://c.tieba.baidu.com/";
    public static String b = "http://tieba.baidu.com/";
    public static final Long c = Long.valueOf((long) Util.MILLSECONDS_OF_HOUR);
    public static final Long d = 36000000L;
    public static final Long e = 36000000L;
    public static final Long f = Long.valueOf((long) Util.MILLSECONDS_OF_DAY);
    public static final String g = String.valueOf(f1014a) + "c/s/apprecommend";
    public static final String h = String.valueOf(f1014a) + "c/s/recommend/";
    public static final String i = String.valueOf(f1014a) + "c/s/classic";
    public static String j = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String k = String.valueOf(f1014a) + "c/p/img?";
    public static int l = 80;
    public static final Bitmap.Config m = Bitmap.Config.RGB_565;
    private static String o = null;
    private static String p = null;
    private static int q = 300;
    private static String r = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String s = r;
    private static int t = 80;
    private static int u = Util.BYTE_OF_MB;
    private static int v = 1024;
    private static int w = 1;
    private static String x = "贴吧客户端反馈";
    private static String y = "2631903";
    private static int z = 640;
    private static String A = "";
    public static final Long n = Long.valueOf((long) Util.MILLSECONDS_OF_HOUR);

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

    public static void d(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            r = str;
        }
    }

    public static int a(Context context) {
        int i2 = BdWebErrorView.ERROR_CODE_400;
        int a2 = UtilHelper.a(context, 267.0f);
        if (a2 <= 400) {
            i2 = a2;
        }
        v = (int) (i2 * i2 * 1.62f * 2.0f);
        com.baidu.adp.lib.e.d.c("BIG_IMAGE_SIZE = " + v);
        return v;
    }

    public static int k() {
        return v;
    }

    public static void b(Context context) {
        u = a(context) * 13;
        if (u < UtilHelper.c(context) * 0.28d) {
            u = (int) (UtilHelper.c(context) * 0.28d);
        }
        com.baidu.adp.lib.e.d.c("BIG_IMAGE_MAX_USED_MEMORY = " + u);
    }

    public static void c(Context context) {
        if (context.getResources().getDisplayMetrics().density < 1.0f) {
            s = r;
            t = 80;
            return;
        }
        s = j;
        t = 110;
    }

    public static String l() {
        return s;
    }

    public static int m() {
        return t;
    }

    public static void e(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            j = str;
        }
    }

    public static void a(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            q = i2;
        }
    }

    public static void d(Context context) {
        int sqrt = (int) Math.sqrt(UtilHelper.a(context) * UtilHelper.b(context));
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

    public static void b(int i2) {
        w = i2;
    }

    public static int n() {
        return w;
    }

    public static int o() {
        switch (TiebaApplication.g().ak()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int p() {
        return o() + 1;
    }

    public static int q() {
        return 14;
    }

    public static int r() {
        switch (TiebaApplication.g().ak()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static boolean s() {
        return com.baidu.adp.a.b.a().b();
    }
}
