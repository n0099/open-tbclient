package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.au;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class y {
    public static final List<String> fsF = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> fsG;

    public static boolean Cc(String str) {
        String string;
        if (au.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || !"file".equals(parse.getScheme()) || parse.getPath() == null || !parse.getPath().contains("bdtbNWCache")) {
            if (fsG == null && (string = com.baidu.tbadk.core.sharedPref.b.brR().getString("js_host_white_list", null)) != null) {
                fsG = Ce(string);
            }
            if (fsG == null) {
                fsG = fsF;
            }
            if (parse != null) {
                String host = parse.getHost();
                for (String str2 : fsG) {
                    if (host.endsWith(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static void Cd(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.brR().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.brR().putString("js_host_white_list", str);
        }
        fsG = Ce(str);
    }

    private static List<String> Ce(String str) {
        if (au.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
