package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class l {
    public static boolean auX() {
        return auY();
    }

    public static boolean auY() {
        return com.baidu.tbadk.core.util.m.gs() && com.baidu.adp.gif.c.gr();
    }

    public static boolean qN(String str) {
        if (str == null) {
            return false;
        }
        if (qO(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.hI().ay("portrait_cdn_open") != 0) && qP(str);
        }
        return true;
    }

    public static boolean qO(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean qP(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
