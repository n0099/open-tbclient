package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static String f1248a = "http://c.tieba.baidu.com/";
    public static String b = "http://tieba.baidu.com/";
    public static String c = "http://static.tieba.baidu.com/";
    public static final Long d = Long.valueOf((long) Util.MILLSECONDS_OF_HOUR);
    public static final Long e = 36000000L;
    public static final Long f = 36000000L;
    public static final Long g = Long.valueOf((long) Util.MILLSECONDS_OF_DAY);
    public static final String h = b + "mo/q/topic_page/136_1";
    public static final String i = f1248a + "c/s/recommend/";
    public static final String j = f1248a + "c/s/classic";
    public static String k = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String l = f1248a + "c/p/img?";
    public static int m = 80;
    public static final Bitmap.Config n = Bitmap.Config.RGB_565;
    private static String p = null;
    private static String q = null;
    private static int r = 300;
    private static String s = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String t = s;
    private static int u = 80;
    private static int v = Util.BYTE_OF_MB;
    private static int w = 1024;
    private static int x = 1;
    private static String y = "贴吧客户端反馈";
    private static String z = "2631903";
    private static int A = 640;
    private static String B = "";
    public static final Long o = Long.valueOf((long) Util.MILLSECONDS_OF_HOUR);

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

    public static void d(String str) {
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

    public static int k() {
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

    public static String l() {
        return t;
    }

    public static int m() {
        return u;
    }

    public static void e(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            k = str;
        }
    }

    public static void a(int i2) {
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

    public static void b(int i2) {
        x = i2;
    }

    public static int n() {
        return x;
    }

    public static int o() {
        switch (TiebaApplication.h().aj()) {
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
        switch (TiebaApplication.h().aj()) {
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
