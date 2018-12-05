package com.baidu.tieba.aiapps.apps.address.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public List<d> acq = new ArrayList();
    public String code;
    public String name;

    public static d L(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.code = jSONObject.optString("code");
        dVar.name = jSONObject.optString("name");
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d L = L(optJSONArray.optJSONObject(i));
                if (L != null) {
                    dVar.acq.add(L);
                }
            }
        }
        return dVar;
    }

    public static JSONObject a(d dVar) {
        if (dVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", dVar.name);
            jSONObject.put("code", dVar.code);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public boolean Ya() {
        return this.acq.size() > 0;
    }

    public static String an(List<d> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                d dVar = list.get(i2);
                if (i2 != 0) {
                    sb.append(" ");
                }
                sb.append(dVar.name);
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.code)) ? false : true;
    }
}
