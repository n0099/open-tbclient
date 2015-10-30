package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aza;

    public static a Em() {
        if (aza == null) {
            synchronized (a.class) {
                if (aza == null) {
                    aza = new a();
                }
            }
        }
        return aza;
    }

    private a() {
    }

    public String[] En() {
        return com.baidu.tbadk.core.sharedPref.b.tr().getString("key_discover_show_plugin_list", "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.tr().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void fD(String str) {
        String[] En;
        if (!StringUtils.isNull(str) && (En = En()) != null && En.length != 0) {
            for (int i = 0; i < En.length; i++) {
                if (str.equals(En[i])) {
                    En[i] = "";
                }
            }
            l(En);
        }
    }

    public void fE(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.tr().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tr().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int fF(String str) {
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

    public boolean fG(String str) {
        return fF(str) == 1;
    }
}
