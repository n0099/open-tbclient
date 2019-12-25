package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    public static final List<String> dic = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> die;

    public static boolean tO(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (die == null && (string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("js_host_white_list", null)) != null) {
            die = tQ(string);
        }
        if (die == null) {
            die = dic;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : die) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void tP(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aCY().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aCY().putString("js_host_white_list", str);
        }
        die = tQ(str);
    }

    private static List<String> tQ(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
