package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    public static final String[] amk = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR};

    public static boolean eA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(amk).contains(str);
    }
}
