package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class h {
    public static boolean GG() {
        return GH();
    }

    public static boolean GH() {
        return com.baidu.tbadk.core.util.k.dG() && com.baidu.adp.gif.c.dF();
    }

    public static boolean gD(String str) {
        if (str == null) {
            return false;
        }
        if (gE(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.eV().af("portrait_cdn_open") != 0) && gF(str);
        }
        return true;
    }

    public static boolean gE(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gF(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
