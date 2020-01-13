package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    public static final List<String> dip = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> diq;

    public static boolean tS(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (diq == null && (string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("js_host_white_list", null)) != null) {
            diq = tU(string);
        }
        if (diq == null) {
            diq = dip;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : diq) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void tT(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aDr().putString("js_host_white_list", str);
        }
        diq = tU(str);
    }

    private static List<String> tU(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
