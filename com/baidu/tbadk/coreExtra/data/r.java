package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    public static final List<String> dMV = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> dMW;

    public static boolean vB(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (dMW == null && (string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("js_host_white_list", null)) != null) {
            dMW = vD(string);
        }
        if (dMW == null) {
            dMW = dMV;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : dMW) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void vC(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aNT().putString("js_host_white_list", str);
        }
        dMW = vD(str);
    }

    private static List<String> vD(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
