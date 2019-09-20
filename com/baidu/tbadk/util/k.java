package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class k {
    public static boolean awu() {
        return awv();
    }

    public static boolean awv() {
        return com.baidu.tbadk.core.util.m.gB() && com.baidu.adp.gif.c.gA();
    }

    public static boolean ro(String str) {
        if (str == null) {
            return false;
        }
        if (rp(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.hS().az("portrait_cdn_open") != 0) && rr(str);
        }
        return true;
    }

    public static boolean rp(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf <= 0 || indexOf >= 20) {
            int indexOf2 = str.indexOf("tiebapic");
            return indexOf2 > 0 && indexOf2 < 20;
        }
        return true;
    }

    public static boolean rq(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tiebapic")) > 0 && indexOf < 20;
    }

    public static boolean rr(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
