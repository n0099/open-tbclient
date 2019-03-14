package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class l {
    public static boolean apW() {
        return apX();
    }

    public static boolean apX() {
        return com.baidu.tbadk.core.util.m.hy() && com.baidu.adp.gif.c.hx();
    }

    public static boolean pE(String str) {
        if (str == null) {
            return false;
        }
        if (pF(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.iQ().aO("portrait_cdn_open") != 0) && pG(str);
        }
        return true;
    }

    public static boolean pF(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean pG(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
