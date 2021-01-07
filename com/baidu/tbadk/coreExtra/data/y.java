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
    public static final List<String> fty = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> ftz;

    public static boolean CP(String str) {
        String string;
        if (TbadkCoreApplication.getInst().isDebugMode() || TbSingleton.getInstance().isDebugToolMode()) {
            return true;
        }
        if (at.isEmpty(str)) {
            return false;
        }
        if (ftz == null && (string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("js_host_white_list", null)) != null) {
            ftz = CR(string);
        }
        if (ftz == null) {
            ftz = fty;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : ftz) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void CQ(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("js_host_white_list", str);
        }
        ftz = CR(str);
    }

    private static List<String> CR(String str) {
        if (at.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
