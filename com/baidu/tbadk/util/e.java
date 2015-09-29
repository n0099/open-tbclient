package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class e {
    public static boolean Ez() {
        return EA();
    }

    public static boolean EA() {
        return com.baidu.tbadk.core.util.n.fi() && com.baidu.adp.gif.e.fh();
    }

    public static boolean fJ(String str) {
        if (str == null) {
            return false;
        }
        if (fK(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.gv().ah("portrait_cdn_open") != 0) && fL(str);
        }
        return true;
    }

    public static boolean fK(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean fL(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
