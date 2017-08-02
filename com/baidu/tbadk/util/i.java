package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean GV() {
        return GW();
    }

    public static boolean GW() {
        return com.baidu.tbadk.core.util.k.dG() && com.baidu.adp.gif.c.dF();
    }

    public static boolean gC(String str) {
        if (str == null) {
            return false;
        }
        if (gD(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.eW().af("portrait_cdn_open") != 0) && gE(str);
        }
        return true;
    }

    public static boolean gD(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gE(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
