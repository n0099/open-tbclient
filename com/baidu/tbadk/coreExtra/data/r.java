package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    public static final List<String> dmW = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> dmX;

    public static boolean uj(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (dmX == null && (string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("js_host_white_list", null)) != null) {
            dmX = ul(string);
        }
        if (dmX == null) {
            dmX = dmW;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : dmX) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void uk(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aFH().putString("js_host_white_list", str);
        }
        dmX = ul(str);
    }

    private static List<String> ul(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
