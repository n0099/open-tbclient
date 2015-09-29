package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ayP;

    public static a Ep() {
        if (ayP == null) {
            synchronized (a.class) {
                if (ayP == null) {
                    ayP = new a();
                }
            }
        }
        return ayP;
    }

    private a() {
    }

    public String[] Eq() {
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

    public void fD(String str) {
        String[] Eq;
        if (!StringUtils.isNull(str) && (Eq = Eq()) != null && Eq.length != 0) {
            for (int i = 0; i < Eq.length; i++) {
                if (str.equals(Eq[i])) {
                    Eq[i] = "";
                }
            }
            l(Eq);
        }
    }

    public void fE(String str) {
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
