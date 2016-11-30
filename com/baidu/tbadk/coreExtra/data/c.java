package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private List<d> aki = new ArrayList();
    private String akj;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    d dVar = new d();
                    dVar.parserJson(jSONObject2);
                    this.aki.add(dVar);
                }
            }
        }
    }

    public String xI() {
        if (TextUtils.isEmpty(this.akj)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (d dVar : this.aki) {
                if (dVar.xK()) {
                    if (i == 0) {
                        sb.append(dVar.getAppId());
                    } else {
                        sb.append(",");
                        sb.append(dVar.getAppId());
                    }
                    i++;
                }
            }
            this.akj = sb.toString();
        }
        return this.akj;
    }

    public List<d> xJ() {
        return this.aki;
    }
}
