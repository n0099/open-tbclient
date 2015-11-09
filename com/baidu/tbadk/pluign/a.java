package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a axP;

    public static a Ef() {
        if (axP == null) {
            synchronized (a.class) {
                if (axP == null) {
                    axP = new a();
                }
            }
        }
        return axP;
    }

    private a() {
    }

    public String[] Eg() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getString("key_discover_show_plugin_list", "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.tu().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void fF(String str) {
        String[] Eg;
        if (!StringUtils.isNull(str) && (Eg = Eg()) != null && Eg.length != 0) {
            for (int i = 0; i < Eg.length; i++) {
                if (str.equals(Eg[i])) {
                    Eg[i] = "";
                }
            }
            l(Eg);
        }
    }

    public void fG(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.tu().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tu().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int fH(String str) {
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

    public boolean fI(String str) {
        return fH(str) == 1;
    }
}
