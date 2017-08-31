package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean Hc() {
        return Hd();
    }

    public static boolean Hd() {
        return com.baidu.tbadk.core.util.k.dH() && com.baidu.adp.gif.c.dG();
    }

    public static boolean gG(String str) {
        if (str == null) {
            return false;
        }
        if (gH(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.eW().af("portrait_cdn_open") != 0) && gI(str);
        }
        return true;
    }

    public static boolean gH(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gI(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
