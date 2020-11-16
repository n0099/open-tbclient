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
    public static final List<String> fco = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    private static List<String> fcq;

    public static boolean Ck(String str) {
        String string;
        if (TbadkCoreApplication.getInst().isDebugMode() || TbSingleton.getInstance().isDebugToolMode()) {
            return true;
        }
        if (au.isEmpty(str)) {
            return false;
        }
        if (fcq == null && (string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("js_host_white_list", null)) != null) {
            fcq = Cm(string);
        }
        if (fcq == null) {
            fcq = fco;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            for (String str2 : fcq) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void Cl(String str) {
        if (str == null) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putString("js_host_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.bpu().putString("js_host_white_list", str);
        }
        fcq = Cm(str);
    }

    private static List<String> Cm(String str) {
        if (au.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
    }
}
