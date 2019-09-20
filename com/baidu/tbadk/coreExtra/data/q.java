package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    public static final List<String> chm = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> chn;

    public static boolean pn(String str) {
        String string;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (chn == null && (string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("js_host_white_list", null)) != null) {
            chn = pp(string);
        }
        if (chn == null) {
            chn = chm;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : chn) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void po(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahU().putString("js_host_white_list", str);
        }
        chn = pp(str);
    }

    private static List<String> pp(String str) {
        if (aq.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
