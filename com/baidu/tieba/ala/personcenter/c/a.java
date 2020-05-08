package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.data.k {
    private String fZA;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fZA = jSONObject.optString("qq", "");
        }
    }

    public String bBS() {
        return this.fZA;
    }
}
