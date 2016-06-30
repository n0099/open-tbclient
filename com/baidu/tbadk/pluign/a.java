package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aAg;

    public static a Fo() {
        if (aAg == null) {
            synchronized (a.class) {
                if (aAg == null) {
                    aAg = new a();
                }
            }
        }
        return aAg;
    }

    private a() {
    }

    public String[] Fp() {
        return com.baidu.tbadk.core.sharedPref.b.sO().getString("key_discover_show_plugin_list", "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.sO().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void gg(String str) {
        String[] Fp;
        if (!StringUtils.isNull(str) && (Fp = Fp()) != null && Fp.length != 0) {
            for (int i = 0; i < Fp.length; i++) {
                if (str.equals(Fp[i])) {
                    Fp[i] = "";
                }
            }
            r(Fp);
        }
    }

    public void gh(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.sO().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.sO().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int gi(String str) {
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

    public boolean gj(String str) {
        return gi(str) == 1;
    }
}
