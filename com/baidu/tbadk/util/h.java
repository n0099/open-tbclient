package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class h {
    public static boolean FA() {
        return FB();
    }

    public static boolean FB() {
        return com.baidu.tbadk.core.util.m.bG() && com.baidu.adp.gif.e.bF();
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
            return (com.baidu.adp.lib.c.e.cT().Z("portrait_cdn_open") != 0) && go(str);
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
