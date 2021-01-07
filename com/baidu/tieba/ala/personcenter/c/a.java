package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.tbadk.core.data.n {
    private String hZI;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hZI = jSONObject.optString("qq", "");
        }
    }

    public String cpH() {
        return this.hZI;
    }
}
