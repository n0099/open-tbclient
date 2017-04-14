package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class g {
    public static boolean Hj() {
        return Hk();
    }

    public static boolean Hk() {
        return com.baidu.tbadk.core.util.l.dG() && com.baidu.adp.gif.e.dF();
    }

    public static boolean ge(String str) {
        if (str == null) {
            return false;
        }
        if (gf(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.eY().Y("portrait_cdn_open") != 0) && gg(str);
        }
        return true;
    }

    public static boolean gf(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gg(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
