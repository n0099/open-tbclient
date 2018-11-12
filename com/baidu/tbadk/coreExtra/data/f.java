package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class f {
    public static List<String> j(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String optString = jSONArray.optString(i);
            if (!StringUtils.isNull(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    public static List<String> Fx() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("scheme_white_list", null);
        if (StringUtils.isNull(string)) {
            return null;
        }
        try {
            return j(new JSONArray(string));
        } catch (Exception e) {
            return null;
        }
    }

    public static void k(JSONArray jSONArray) {
        if (jSONArray == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("scheme_white_list", "");
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("scheme_white_list", jSONArray.toString());
        }
    }
}
