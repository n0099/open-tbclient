package com.baidu.tbadk.pluign;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a arA;

    public static a DM() {
        if (arA == null) {
            synchronized (a.class) {
                if (arA == null) {
                    arA = new a();
                }
            }
        }
        return arA;
    }

    private a() {
    }

    public String[] DN() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getString("key_discover_show_plugin_list", "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.sl().putString("key_discover_show_plugin_list", sb.toString());
    }

    public void eY(String str) {
        String[] DN;
        if (!StringUtils.isNull(str) && (DN = DN()) != null && DN.length != 0) {
            for (int i = 0; i < DN.length; i++) {
                if (str.equals(DN[i])) {
                    DN[i] = "";
                }
            }
            l(DN);
        }
    }

    public void eZ(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.sl().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.sl().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private int fa(String str) {
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

    public boolean fb(String str) {
        return fa(str) == 1;
    }
}
