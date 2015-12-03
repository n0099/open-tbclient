package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a azT;

    public static a Fh() {
        if (azT == null) {
            synchronized (a.class) {
                if (azT == null) {
                    azT = new a();
                }
            }
        }
        return azT;
    }

    private a() {
    }

    public String[] Fi() {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getString("key_discover_show_plugin_list", "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.tZ().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void fT(String str) {
        String[] Fi;
        if (!StringUtils.isNull(str) && (Fi = Fi()) != null && Fi.length != 0) {
            for (int i = 0; i < Fi.length; i++) {
                if (str.equals(Fi[i])) {
                    Fi[i] = "";
                }
            }
            l(Fi);
        }
    }

    public void fU(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.tZ().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int fV(String str) {
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

    public boolean fW(String str) {
        return fV(str) == 1;
    }
}
