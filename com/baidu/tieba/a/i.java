package com.baidu.tieba.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.NotificationProxy;
/* loaded from: classes.dex */
public class i {
    public static final Long a = 3600000L;
    public static final Long b = 36000000L;
    public static final Long c = 36000000L;
    public static String d = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static int e = 80;
    public static final Bitmap.Config f = Bitmap.Config.RGB_565;
    private static String g = null;
    private static int h = 300;
    private static String i = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static int j = 1048576;
    private static int k = NotificationProxy.MAX_URL_LENGTH;
    private static int l = 1;
    private static String m = "贴吧客户端反馈";
    private static String n = "2631903";
    private static int o = 640;
    private static String p = "";
    private static boolean q = false;

    public static String a() {
        return g;
    }

    public static void a(String str) {
        g = str;
    }

    public static int b() {
        return h;
    }

    public static String c() {
        return i;
    }

    public static int d() {
        return j;
    }

    public static String e() {
        return m;
    }

    public static String f() {
        return n;
    }

    public static int g() {
        return o;
    }

    public static String h() {
        return p;
    }

    public static void b(String str) {
        p = str;
    }

    public static void c(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            i = str;
        }
    }

    public static int a(Context context) {
        int a2 = com.baidu.tieba.c.ah.a(context, 234.0f);
        int i2 = a2 <= 350 ? a2 : 350;
        k = (int) (i2 * i2 * 1.62f * 2.0f);
        return k;
    }

    public static int i() {
        return k;
    }

    public static void b(Context context) {
        j = a(context) * 13;
        if (j < com.baidu.tieba.c.ah.c(context) * 0.28d) {
            j = (int) (com.baidu.tieba.c.ah.c(context) * 0.28d);
        }
    }

    public static void d(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            d = str;
        }
    }

    public static void a(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            h = i2;
        }
    }

    public static void c(Context context) {
        int sqrt = (int) Math.sqrt(com.baidu.tieba.c.ah.a(context) * com.baidu.tieba.c.ah.b(context));
        if (sqrt > o) {
            o = sqrt;
        }
    }

    public static void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            m = str;
            n = str2;
        }
    }

    public static void b(int i2) {
        l = i2;
    }

    public static int j() {
        return l;
    }

    public static int k() {
        switch (TiebaApplication.b().ad()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int l() {
        switch (TiebaApplication.b().ad()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static void m() {
        if ((TiebaApplication.b().getApplicationInfo().flags & 2) == 0) {
            q = false;
        } else {
            q = true;
        }
    }

    public static boolean n() {
        return q;
    }
}
