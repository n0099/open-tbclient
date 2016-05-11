package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a azq;

    public static a Ff() {
        if (azq == null) {
            synchronized (a.class) {
                if (azq == null) {
                    azq = new a();
                }
            }
        }
        return azq;
    }

    private a() {
    }

    public String[] Fg() {
        return com.baidu.tbadk.core.sharedPref.b.sQ().getString("key_discover_show_plugin_list", "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.sQ().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void ga(String str) {
        String[] Fg;
        if (!StringUtils.isNull(str) && (Fg = Fg()) != null && Fg.length != 0) {
            for (int i = 0; i < Fg.length; i++) {
                if (str.equals(Fg[i])) {
                    Fg[i] = "";
                }
            }
            r(Fg);
        }
    }

    public void gb(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.sQ().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.sQ().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int gc(String str) {
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

    public boolean gd(String str) {
        return gc(str) == 1;
    }
}
