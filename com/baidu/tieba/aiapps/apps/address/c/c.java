package com.baidu.tieba.aiapps.apps.address.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static List<b> kv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                return o(optJSONObject.optJSONArray("list"));
            }
            return arrayList;
        } catch (JSONException e) {
            return arrayList;
        }
    }

    public static JSONArray am(List<b> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                JSONObject c = b.c(list.get(i2));
                if (c != null) {
                    jSONArray.put(c);
                }
                i = i2 + 1;
            }
        }
        return jSONArray;
    }

    public static List<b> o(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(b.K(optJSONObject));
            }
        }
        return arrayList;
    }
}
