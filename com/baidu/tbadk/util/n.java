package com.baidu.tbadk.util;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.switchs.TBCdnPortraitSwitch;
/* loaded from: classes.dex */
public class n {
    public static boolean bFv() {
        return bFw();
    }

    public static boolean bFw() {
        return com.baidu.tbadk.core.util.o.checkSD() && com.baidu.adp.gif.c.lf();
    }

    public static boolean canUseIp(String str) {
        if (str == null) {
            return false;
        }
        if (isCdn(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (SwitchManager.getInstance().findType(TBCdnPortraitSwitch.CDNPORTRAIT_SWITCH_KEY) != 0) && isPortrait(str);
        }
        return true;
    }

    public static boolean isCdn(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf <= 0 || indexOf >= 20) {
            int indexOf2 = str.indexOf("tiebapic");
            return indexOf2 > 0 && indexOf2 < 20;
        }
        return true;
    }

    public static boolean DR(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tiebapic")) > 0 && indexOf < 20;
    }

    public static boolean isPortrait(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
