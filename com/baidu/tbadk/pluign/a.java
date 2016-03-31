package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aDn;

    public static a Hi() {
        if (aDn == null) {
            synchronized (a.class) {
                if (aDn == null) {
                    aDn = new a();
                }
            }
        }
        return aDn;
    }

    private a() {
    }

    public String[] Hj() {
        return com.baidu.tbadk.core.sharedPref.b.vk().getString("key_discover_show_plugin_list", "").split("#");
    }

    private void p(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (!StringUtils.isNull(strArr[i])) {
                    sb.append(strArr[i]).append("#");
                }
            }
        }
        com.baidu.tbadk.core.sharedPref.b.vk().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void gd(String str) {
        String[] Hj;
        if (!StringUtils.isNull(str) && (Hj = Hj()) != null && Hj.length != 0) {
            for (int i = 0; i < Hj.length; i++) {
                if (str.equals(Hj[i])) {
                    Hj[i] = "";
                }
            }
            p(Hj);
        }
    }

    public void ge(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.vk().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.vk().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int gf(String str) {
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

    public boolean gg(String str) {
        return gf(str) == 1;
    }
}
