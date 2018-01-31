package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean Ou() {
        return Ov();
    }

    public static boolean Ov() {
        return com.baidu.tbadk.core.util.k.lk() && com.baidu.adp.gif.c.lj();
    }

    public static boolean gX(String str) {
        if (str == null) {
            return false;
        }
        if (gY(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.mA().an("portrait_cdn_open") != 0) && gZ(str);
        }
        return true;
    }

    public static boolean gY(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gZ(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
