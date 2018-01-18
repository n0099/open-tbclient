package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean Os() {
        return Ot();
    }

    public static boolean Ot() {
        return com.baidu.tbadk.core.util.k.lk() && com.baidu.adp.gif.c.lj();
    }

    public static boolean gQ(String str) {
        if (str == null) {
            return false;
        }
        if (gR(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.mz().an("portrait_cdn_open") != 0) && gS(str);
        }
        return true;
    }

    public static boolean gR(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gS(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
