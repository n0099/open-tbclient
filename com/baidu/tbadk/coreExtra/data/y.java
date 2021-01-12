package com.baidu.tbadk.coreExtra.data;

import android.net.Uri;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class y {
    public static final List<String> foM = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> foN;

    public static boolean BE(String str) {
        String string;
        if (TbadkCoreApplication.getInst().isDebugMode() || TbSingleton.getInstance().isDebugToolMode()) {
            return true;
        }
        if (at.isEmpty(str)) {
            return false;
        }
        if (foN == null && (string = com.baidu.tbadk.core.sharedPref.b.brx().getString("js_host_white_list", null)) != null) {
            foN = BG(string);
        }
        if (foN == null) {
            foN = foM;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : foN) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void BF(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.brx().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.brx().putString("js_host_white_list", str);
        }
        foN = BG(str);
    }

    private static List<String> BG(String str) {
        if (at.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
