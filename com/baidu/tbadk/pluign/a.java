package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aDB;

    public static a GI() {
        if (aDB == null) {
            synchronized (a.class) {
                if (aDB == null) {
                    aDB = new a();
                }
            }
        }
        return aDB;
    }

    private a() {
    }

    public String[] GJ() {
        return com.baidu.tbadk.core.sharedPref.b.uh().getString("key_discover_show_plugin_list", "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.uh().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void gl(String str) {
        String[] GJ;
        if (!StringUtils.isNull(str) && (GJ = GJ()) != null && GJ.length != 0) {
            for (int i = 0; i < GJ.length; i++) {
                if (str.equals(GJ[i])) {
                    GJ[i] = "";
                }
            }
            r(GJ);
        }
    }

    public void gm(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.uh().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.uh().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int gn(String str) {
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

    public boolean go(String str) {
        return gn(str) == 1;
    }
}
