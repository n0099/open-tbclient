package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.core.data.o {
    private String ibt;

    @Override // com.baidu.tbadk.core.data.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ibt = jSONObject.optString("qq", "");
        }
    }

    public String cna() {
        return this.ibt;
    }
}
