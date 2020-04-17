package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    public static final List<String> dMR = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> dMS;

    public static boolean vy(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (dMS == null && (string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("js_host_white_list", null)) != null) {
            dMS = vA(string);
        }
        if (dMS == null) {
            dMS = dMR;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : dMS) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void vz(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.aNV().putString("js_host_white_list", str);
        }
        dMS = vA(str);
    }

    private static List<String> vA(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
