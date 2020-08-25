package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class x {
    public static final List<String> eAF = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> eAG;

    public static boolean AV(String str) {
        String string;
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            return true;
        }
        if (at.isEmpty(str)) {
            return false;
        }
        if (eAG == null && (string = com.baidu.tbadk.core.sharedPref.b.bik().getString("js_host_white_list", null)) != null) {
            eAG = AX(string);
        }
        if (eAG == null) {
            eAG = eAF;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : eAG) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void AW(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.bik().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.bik().putString("js_host_white_list", str);
        }
        eAG = AX(str);
    }

    private static List<String> AX(String str) {
        if (at.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
