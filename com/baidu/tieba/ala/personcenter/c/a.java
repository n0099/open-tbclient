package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.data.j {
    private String goF;

    @Override // com.baidu.tbadk.core.data.j
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.goF = jSONObject.optString("qq", "");
        }
    }

    public String bIn() {
        return this.goF;
    }
}
