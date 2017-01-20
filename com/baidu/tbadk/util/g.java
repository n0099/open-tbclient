package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class g {
    public static boolean Gl() {
        return Gm();
    }

    public static boolean Gm() {
        return com.baidu.tbadk.core.util.l.cy() && com.baidu.adp.gif.e.cx();
    }

    public static boolean gj(String str) {
        if (str == null) {
            return false;
        }
        if (gk(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.dL().ac("portrait_cdn_open") != 0) && gl(str);
        }
        return true;
    }

    public static boolean gk(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gl(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
