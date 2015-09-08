package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aAp;

    public static a EC() {
        if (aAp == null) {
            synchronized (a.class) {
                if (aAp == null) {
                    aAp = new a();
                }
            }
        }
        return aAp;
    }

    private a() {
    }

    public String[] ED() {
        return com.baidu.tbadk.core.sharedPref.b.tx().getString("key_discover_show_plugin_list", "").split("#");
    }

    private void m(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (!StringUtils.isNull(strArr[i])) {
                    sb.append(strArr[i]).append("#");
                }
            }
        }
        com.baidu.tbadk.core.sharedPref.b.tx().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void fy(String str) {
        String[] ED;
        if (!StringUtils.isNull(str) && (ED = ED()) != null && ED.length != 0) {
            for (int i = 0; i < ED.length; i++) {
                if (str.equals(ED[i])) {
                    ED[i] = "";
                }
            }
            m(ED);
        }
    }

    public void fz(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.tx().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tx().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int fA(String str) {
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

    public boolean fB(String str) {
        return fA(str) == 1;
    }
}
