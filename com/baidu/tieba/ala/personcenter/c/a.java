package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.core.data.n {
    private String hVb;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hVb = jSONObject.optString("qq", "");
        }
    }

    public String clP() {
        return this.hVb;
    }
}
