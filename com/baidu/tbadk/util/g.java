package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class g {
    public static boolean Gt() {
        return Gu();
    }

    public static boolean Gu() {
        return com.baidu.tbadk.core.util.m.cA() && com.baidu.adp.gif.e.cz();
    }

    public static boolean gm(String str) {
        if (str == null) {
            return false;
        }
        if (gn(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.c.e.dN().ac("portrait_cdn_open") != 0) && go(str);
        }
        return true;
    }

    public static boolean gn(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean go(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
