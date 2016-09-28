package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private List<d> ajq = new ArrayList();
    private String ajr;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    d dVar = new d();
                    dVar.parserJson(jSONObject2);
                    this.ajq.add(dVar);
                }
            }
        }
    }

    public String xD() {
        if (TextUtils.isEmpty(this.ajr)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (d dVar : this.ajq) {
                if (dVar.xF()) {
                    if (i == 0) {
                        sb.append(dVar.getAppId());
                    } else {
                        sb.append(",");
                        sb.append(dVar.getAppId());
                    }
                    i++;
                }
            }
            this.ajr = sb.toString();
        }
        return this.ajr;
    }

    public List<d> xE() {
        return this.ajq;
    }
}
