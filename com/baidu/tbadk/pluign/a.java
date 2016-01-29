package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aCp;

    public static a Gm() {
        if (aCp == null) {
            synchronized (a.class) {
                if (aCp == null) {
                    aCp = new a();
                }
            }
        }
        return aCp;
    }

    private a() {
    }

    public String[] Gn() {
        return com.baidu.tbadk.core.sharedPref.b.uO().getString("key_discover_show_plugin_list", "").split(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR);
    }

    private void p(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (!StringUtils.isNull(strArr[i])) {
                    sb.append(strArr[i]).append(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR);
                }
            }
        }
        com.baidu.tbadk.core.sharedPref.b.uO().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void fU(String str) {
        String[] Gn;
        if (!StringUtils.isNull(str) && (Gn = Gn()) != null && Gn.length != 0) {
            for (int i = 0; i < Gn.length; i++) {
                if (str.equals(Gn[i])) {
                    Gn[i] = "";
                }
            }
            p(Gn);
        }
    }

    public void fV(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.uO().getString("key_discover_show_plugin_list", "").split(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR)) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.uO().putString("key_discover_show_plugin_list", String.valueOf(string) + ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR + str);
        }
    }

    private int fW(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return new JSONObject(str).optInt("plugintype", 0);
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean fX(String str) {
        return fW(str) == 1;
    }
}
