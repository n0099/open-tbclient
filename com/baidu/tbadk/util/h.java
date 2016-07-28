package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class h {
    public static boolean FB() {
        return FC();
    }

    public static boolean FC() {
        return com.baidu.tbadk.core.util.m.bF() && com.baidu.adp.gif.e.bE();
    }

    public static boolean gk(String str) {
        if (str == null) {
            return false;
        }
        if (gl(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.c.e.cS().ab("portrait_cdn_open") != 0) && gm(str);
        }
        return true;
    }

    public static boolean gl(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gm(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
