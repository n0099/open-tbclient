package com.baidu.tieba.data;
/* loaded from: classes.dex */
public final class d {
    public static String a = "http://tieba.baidu.com/";
    public static final Long b = 3600000L;
    public static final Long c = 36000000L;
    public static final Long d = 36000000L;
    public static final Long e = 86400000L;
    public static final String f = String.valueOf(a) + "mo/q/topic_page/136_1";
    public static final String g = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/recommend/";
    public static final String h = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/classic";
    public static int i = 80;
    private static int k = 300;
    private static int l = 1;
    private static String m = "贴吧客户端反馈";
    private static String n = "2631903";
    public static final Long j = 3600000L;

    public static final String a() {
        return "com.baidu.tieba.broadcast.imagepb.pageadded";
    }

    public static final String b() {
        return "com.baidu.tieba.broadcast.service";
    }

    public static final String c() {
        return "com.baidu.tieba.broadcast.changeskin";
    }

    public static final String d() {
        return "com.baidu.tieba.broadcast.sync";
    }

    public static final String e() {
        return "com.baidu.tieba.broadcast.signalert";
    }

    public static int f() {
        return k;
    }

    public static void a(int i2) {
        if (i2 >= 60 && i2 <= 1000) {
            k = i2;
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
}
