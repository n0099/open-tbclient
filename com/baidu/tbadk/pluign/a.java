package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aEd;

    public static a GJ() {
        if (aEd == null) {
            synchronized (a.class) {
                if (aEd == null) {
                    aEd = new a();
                }
            }
        }
        return aEd;
    }

    private a() {
    }

    public String[] GK() {
        return com.baidu.tbadk.core.sharedPref.b.tS().getString("key_discover_show_plugin_list", "").split("#");
    }

    private void r(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (!StringUtils.isNull(strArr[i])) {
                    sb.append(strArr[i]).append("#");
                }
            }
        }
        com.baidu.tbadk.core.sharedPref.b.tS().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void gh(String str) {
        String[] GK;
        if (!StringUtils.isNull(str) && (GK = GK()) != null && GK.length != 0) {
            for (int i = 0; i < GK.length; i++) {
                if (str.equals(GK[i])) {
                    GK[i] = "";
                }
            }
            r(GK);
        }
    }

    public void gi(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.tS().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tS().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int gj(String str) {
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

    public boolean gk(String str) {
        return gj(str) == 1;
    }
}
