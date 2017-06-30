package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean GG() {
        return GH();
    }

    public static boolean GH() {
        return com.baidu.tbadk.core.util.n.dH() && com.baidu.adp.gif.e.dG();
    }

    public static boolean gw(String str) {
        if (str == null) {
            return false;
        }
        if (gx(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.eY().ad("portrait_cdn_open") != 0) && gy(str);
        }
        return true;
    }

    public static boolean gx(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gy(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
