package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class h {
    public static boolean Gj() {
        return Gk();
    }

    public static boolean Gk() {
        return com.baidu.tbadk.core.util.l.dH() && com.baidu.adp.gif.e.dG();
    }

    public static boolean gb(String str) {
        if (str == null) {
            return false;
        }
        if (gc(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.eZ().Y("portrait_cdn_open") != 0) && gd(str);
        }
        return true;
    }

    public static boolean gc(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gd(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
