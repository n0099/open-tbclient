package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class g {
    public static boolean GK() {
        return GL();
    }

    public static boolean GL() {
        return com.baidu.tbadk.core.util.l.dH() && com.baidu.adp.gif.e.dG();
    }

    public static boolean fY(String str) {
        if (str == null) {
            return false;
        }
        if (fZ(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.eT().ab("portrait_cdn_open") != 0) && ga(str);
        }
        return true;
    }

    public static boolean fZ(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean ga(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
