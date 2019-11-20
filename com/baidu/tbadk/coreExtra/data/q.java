package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    public static final List<String> cut = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> cuu;

    public static boolean oL(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (cuu == null && (string = com.baidu.tbadk.core.sharedPref.b.alP().getString("js_host_white_list", null)) != null) {
            cuu = oN(string);
        }
        if (cuu == null) {
            cuu = cut;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : cuu) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void oM(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.alP().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.alP().putString("js_host_white_list", str);
        }
        cuu = oN(str);
    }

    private static List<String> oN(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
