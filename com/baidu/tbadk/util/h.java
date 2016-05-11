package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class h {
    public static boolean Fq() {
        return Fr();
    }

    public static boolean Fr() {
        return com.baidu.tbadk.core.util.m.bF() && com.baidu.adp.gif.e.bE();
    }

    public static boolean gg(String str) {
        if (str == null) {
            return false;
        }
        if (gh(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.c.e.cS().Z("portrait_cdn_open") != 0) && gi(str);
        }
        return true;
    }

    public static boolean gh(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gi(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
