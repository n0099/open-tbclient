package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.as;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    public static final List<String> eql = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> eqm;

    public static boolean yF(String str) {
        String string;
        if (as.isEmpty(str)) {
            return false;
        }
        if (eqm == null && (string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("js_host_white_list", null)) != null) {
            eqm = yH(string);
        }
        if (eqm == null) {
            eqm = eql;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : eqm) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void yG(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("js_host_white_list", str);
        }
        eqm = yH(str);
    }

    private static List<String> yH(String str) {
        if (as.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
