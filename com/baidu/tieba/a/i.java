package com.baidu.tieba.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.NotificationProxy;
/* loaded from: classes.dex */
public class i {
    public static final Long a = 3600000L;
    public static final Long b = 36000000L;
    public static final Long c = 36000000L;
    public static final Long d = 86400000L;
    public static String e = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static int f = 80;
    public static final Bitmap.Config g = Bitmap.Config.RGB_565;
    private static String h = null;
    private static int i = MKEvent.ERROR_PERMISSION_DENIED;
    private static String j = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static int k = 1048576;
    private static int l = NotificationProxy.MAX_URL_LENGTH;
    private static int m = 1;
    private static String n = "贴吧客户端反馈";
    private static String o = "2631903";
    private static int p = 640;
    private static String q = "";
    private static boolean r = false;

    public static String a() {
        return h;
    }

    public static void a(String str) {
        h = str;
    }

    public static int b() {
        return i;
    }

    public static String c() {
        return j;
    }

    public static int d() {
        return k;
    }

    public static String e() {
        return n;
    }

    public static String f() {
        return o;
    }

    public static int g() {
        return p;
    }

    public static String h() {
        return q;
    }

    public static void b(String str) {
        q = str;
    }

    public static void c(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            j = str;
        }
    }

    public static int a(Context context) {
        int a2 = com.baidu.tieba.c.ai.a(context, 234.0f);
        int i2 = a2 <= 350 ? a2 : 350;
        l = (int) (i2 * i2 * 1.62f * 2.0f);
        return l;
    }

    public static int i() {
        return l;
    }

    public static void b(Context context) {
        k = a(context) * 13;
        if (k < com.baidu.tieba.c.ai.c(context) * 0.28d) {
            k = (int) (com.baidu.tieba.c.ai.c(context) * 0.28d);
        }
    }

    public static void d(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            e = str;
        }
    }

    public static void a(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            i = i2;
        }
    }

    public static void c(Context context) {
        int sqrt = (int) Math.sqrt(com.baidu.tieba.c.ai.a(context) * com.baidu.tieba.c.ai.b(context));
        if (sqrt > p) {
            p = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            p = (int) (p * 0.8d);
        }
    }

    public static void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            n = str;
            o = str2;
        }
    }

    public static void b(int i2) {
        m = i2;
    }

    public static int j() {
        return m;
    }

    public static int k() {
        switch (TiebaApplication.b().af()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int l() {
        switch (TiebaApplication.b().af()) {
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
            r = false;
        } else {
            r = true;
        }
    }

    public static boolean n() {
        return r;
    }
}
