package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class y {
    public static final List<String> fjO = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> fjP;

    public static boolean CS(String str) {
        String string;
        if (TbadkCoreApplication.getInst().isDebugMode() || TbSingleton.getInstance().isDebugToolMode()) {
            return true;
        }
        if (au.isEmpty(str)) {
            return false;
        }
        if (fjP == null && (string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("js_host_white_list", null)) != null) {
            fjP = CU(string);
        }
        if (fjP == null) {
            fjP = fjO;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : fjP) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void CT(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.bsO().putString("js_host_white_list", str);
        }
        fjP = CU(str);
    }

    private static List<String> CU(String str) {
        if (au.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
