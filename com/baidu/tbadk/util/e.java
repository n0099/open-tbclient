package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class e {
    public static boolean Gw() {
        return Gx();
    }

    public static boolean Gx() {
        return com.baidu.tbadk.core.util.m.fq() && com.baidu.adp.gif.e.fp();
    }

    public static boolean ga(String str) {
        if (str == null) {
            return false;
        }
        if (gb(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.c.e.gE().ai("portrait_cdn_open") != 0) && gc(str);
        }
        return true;
    }

    public static boolean gb(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gc(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
