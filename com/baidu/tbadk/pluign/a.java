package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ayH;

    public static a Es() {
        if (ayH == null) {
            synchronized (a.class) {
                if (ayH == null) {
                    ayH = new a();
                }
            }
        }
        return ayH;
    }

    private a() {
    }

    public String[] Et() {
        return com.baidu.tbadk.core.sharedPref.b.ts().getString("key_discover_show_plugin_list", "").split("#");
    }

    private void l(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (!StringUtils.isNull(strArr[i])) {
                    sb.append(strArr[i]).append("#");
                }
            }
        }
        com.baidu.tbadk.core.sharedPref.b.ts().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void fq(String str) {
        String[] Et;
        if (!StringUtils.isNull(str) && (Et = Et()) != null && Et.length != 0) {
            for (int i = 0; i < Et.length; i++) {
                if (str.equals(Et[i])) {
                    Et[i] = "";
                }
            }
            l(Et);
        }
    }

    public void fr(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.ts().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.ts().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int fs(String str) {
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

    public boolean ft(String str) {
        return fs(str) == 1;
    }
}
