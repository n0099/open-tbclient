package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    public static final List<String> dmJ = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> dmK;

    public static boolean uk(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (dmK == null && (string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("js_host_white_list", null)) != null) {
            dmK = um(string);
        }
        if (dmK == null) {
            dmK = dmJ;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : dmK) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void ul(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aFD().putString("js_host_white_list", str);
        }
        dmK = um(str);
    }

    private static List<String> um(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
