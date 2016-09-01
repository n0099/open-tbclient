package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class h {
    public static boolean GV() {
        return GW();
    }

    public static boolean GW() {
        return com.baidu.tbadk.core.util.m.cA() && com.baidu.adp.gif.e.cz();
    }

    public static boolean gn(String str) {
        if (str == null) {
            return false;
        }
        if (go(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.c.e.dN().ac("portrait_cdn_open") != 0) && gp(str);
        }
        return true;
    }

    public static boolean go(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gp(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
