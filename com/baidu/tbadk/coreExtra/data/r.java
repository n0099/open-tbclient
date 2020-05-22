package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    public static final List<String> ebm = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> ebn;

    public static boolean xh(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (ebn == null && (string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("js_host_white_list", null)) != null) {
            ebn = xj(string);
        }
        if (ebn == null) {
            ebn = ebm;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : ebn) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void xi(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("js_host_white_list", str);
        }
        ebn = xj(str);
    }

    private static List<String> xj(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
