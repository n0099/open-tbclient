package com.baidu.tieba.discover.memberpay;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public List<h> aou = new ArrayList();
    public List<j> aov = new ArrayList();
    public String mContent;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mContent = jSONObject.optString("content");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    h hVar = new h();
                    hVar.parseJson(jSONObject2);
                    this.aou.add(hVar);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        j jVar = new j();
                        jVar.parseJson(jSONObject3);
                        this.aov.add(jVar);
                    }
                }
            }
        }
    }
}
