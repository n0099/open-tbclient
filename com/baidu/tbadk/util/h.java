package com.baidu.tbadk.util;

import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class h {
    public static boolean zL() {
        return zM();
    }

    public static boolean zM() {
        return s.bL() && com.baidu.adp.gif.f.bK();
    }

    public static boolean eB(String str) {
        if (str == null) {
            return false;
        }
        if (eC(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.f.da().Z("portrait_cdn_open") != 0) && eD(str);
        }
        return true;
    }

    public static boolean eC(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean eD(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
