package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class l {
    public static boolean awi() {
        return awj();
    }

    public static boolean awj() {
        return com.baidu.tbadk.core.util.m.gB() && com.baidu.adp.gif.c.gA();
    }

    public static boolean re(String str) {
        if (str == null) {
            return false;
        }
        if (rf(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.hS().az("portrait_cdn_open") != 0) && rg(str);
        }
        return true;
    }

    public static boolean rf(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean rg(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
