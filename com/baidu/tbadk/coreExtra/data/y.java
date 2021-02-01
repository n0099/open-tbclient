package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.au;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class y {
    public static final List<String> frf = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> frg;

    public static boolean BV(String str) {
        String string;
        if (au.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || !"file".equals(parse.getScheme()) || parse.getPath() == null || !parse.getPath().contains("bdtbNWCache")) {
            if (frg == null && (string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("js_host_white_list", null)) != null) {
                frg = BX(string);
            }
            if (frg == null) {
                frg = frf;
            }
            if (parse != null) {
                String host = parse.getHost();
                for (String str2 : frg) {
                    if (host.endsWith(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static void BW(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("js_host_white_list", str);
        }
        frg = BX(str);
    }

    private static List<String> BX(String str) {
        if (au.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
