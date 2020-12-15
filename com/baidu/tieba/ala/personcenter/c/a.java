package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.core.data.n {
    private String hNm;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hNm = jSONObject.optString("qq", "");
        }
    }

    public String cmO() {
        return this.hNm;
    }
}
