package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    public static final List<String> eAJ = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> eAK;

    public static boolean AW(String str) {
        String string;
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            return true;
        }
        if (at.isEmpty(str)) {
            return false;
        }
        if (eAK == null && (string = com.baidu.tbadk.core.sharedPref.b.bik().getString("js_host_white_list", null)) != null) {
            eAK = AY(string);
        }
        if (eAK == null) {
            eAK = eAJ;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : eAK) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void AX(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.bik().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.bik().putString("js_host_white_list", str);
        }
        eAK = AY(str);
    }

    private static List<String> AY(String str) {
        if (at.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
