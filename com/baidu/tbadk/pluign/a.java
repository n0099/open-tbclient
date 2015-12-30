package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aBA;

    public static a EV() {
        if (aBA == null) {
            synchronized (a.class) {
                if (aBA == null) {
                    aBA = new a();
                }
            }
        }
        return aBA;
    }

    private a() {
    }

    public String[] EW() {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getString("key_discover_show_plugin_list", "").split(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR);
    }

    private void l(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (!StringUtils.isNull(strArr[i])) {
                    sb.append(strArr[i]).append(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR);
                }
            }
        }
        com.baidu.tbadk.core.sharedPref.b.tJ().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void fX(String str) {
        String[] EW;
        if (!StringUtils.isNull(str) && (EW = EW()) != null && EW.length != 0) {
            for (int i = 0; i < EW.length; i++) {
                if (str.equals(EW[i])) {
                    EW[i] = "";
                }
            }
            l(EW);
        }
    }

    public void fY(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.tJ().getString("key_discover_show_plugin_list", "").split(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR)) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tJ().putString("key_discover_show_plugin_list", String.valueOf(string) + ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR + str);
        }
    }

    private int fZ(String str) {
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

    public boolean ga(String str) {
        return fZ(str) == 1;
    }
}
