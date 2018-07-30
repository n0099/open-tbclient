package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class h {
    public static boolean Lh() {
        return Li();
    }

    public static boolean Li() {
        return com.baidu.tbadk.core.util.l.gd() && com.baidu.adp.gif.c.gb();
    }

    public static boolean hv(String str) {
        if (str == null) {
            return false;
        }
        if (hw(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.hv().ax("portrait_cdn_open") != 0) && hx(str);
        }
        return true;
    }

    public static boolean hw(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean hx(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
