package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private List<d> aoO = new ArrayList();
    private String aoP;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    d dVar = new d();
                    dVar.parserJson(jSONObject2);
                    this.aoO.add(dVar);
                }
            }
        }
    }

    public String xA() {
        if (TextUtils.isEmpty(this.aoP)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (d dVar : this.aoO) {
                if (dVar.xC()) {
                    if (i == 0) {
                        sb.append(dVar.getAppId());
                    } else {
                        sb.append(",");
                        sb.append(dVar.getAppId());
                    }
                    i++;
                }
            }
            this.aoP = sb.toString();
        }
        return this.aoP;
    }

    public List<d> xB() {
        return this.aoO;
    }
}
