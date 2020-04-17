package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.data.k {
    private String fZv;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fZv = jSONObject.optString("qq", "");
        }
    }

    public String bBU() {
        return this.fZv;
    }
}
