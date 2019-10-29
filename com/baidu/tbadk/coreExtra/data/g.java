package com.baidu.tbadk.coreExtra.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private List<h> cuO = new ArrayList();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("applist")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    h hVar = new h();
                    hVar.parserJson(jSONObject2);
                    this.cuO.add(hVar);
                }
            }
        }
    }
}
