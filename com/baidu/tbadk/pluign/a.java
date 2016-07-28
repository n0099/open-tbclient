package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aAW;

    public static a Fp() {
        if (aAW == null) {
            synchronized (a.class) {
                if (aAW == null) {
                    aAW = new a();
                }
            }
        }
        return aAW;
    }

    private a() {
    }

    public String[] Fq() {
        return com.baidu.tbadk.core.sharedPref.b.sN().getString("key_discover_show_plugin_list", "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.sN().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void ge(String str) {
        String[] Fq;
        if (!StringUtils.isNull(str) && (Fq = Fq()) != null && Fq.length != 0) {
            for (int i = 0; i < Fq.length; i++) {
                if (str.equals(Fq[i])) {
                    Fq[i] = "";
                }
            }
            r(Fq);
        }
    }

    public void gf(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.sN().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.sN().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int gg(String str) {
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

    public boolean gh(String str) {
        return gg(str) == 1;
    }
}
