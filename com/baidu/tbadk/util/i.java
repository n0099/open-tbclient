package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean Hd() {
        return He();
    }

    public static boolean He() {
        return com.baidu.tbadk.core.util.k.dR() && com.baidu.adp.gif.c.dQ();
    }

    public static boolean gH(String str) {
        if (str == null) {
            return false;
        }
        if (gI(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.fh().al("portrait_cdn_open") != 0) && gJ(str);
        }
        return true;
    }

    public static boolean gI(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gJ(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
