package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.ar;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    public static final List<String> ejX = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> ejY;

    public static boolean xA(String str) {
        String string;
        if (ar.isEmpty(str)) {
            return false;
        }
        if (ejY == null && (string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("js_host_white_list", null)) != null) {
            ejY = xC(string);
        }
        if (ejY == null) {
            ejY = ejX;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : ejY) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void xB(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("js_host_white_list", str);
        }
        ejY = xC(str);
    }

    private static List<String> xC(String str) {
        if (ar.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
