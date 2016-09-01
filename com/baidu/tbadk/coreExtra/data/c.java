package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private List<d> ajK = new ArrayList();
    private String ajL;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    d dVar = new d();
                    dVar.parserJson(jSONObject2);
                    this.ajK.add(dVar);
                }
            }
        }
    }

    public String xz() {
        if (TextUtils.isEmpty(this.ajL)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (d dVar : this.ajK) {
                if (dVar.xB()) {
                    if (i == 0) {
                        sb.append(dVar.getAppId());
                    } else {
                        sb.append(",");
                        sb.append(dVar.getAppId());
                    }
                    i++;
                }
            }
            this.ajL = sb.toString();
        }
        return this.ajL;
    }

    public List<d> xA() {
        return this.ajK;
    }
}
