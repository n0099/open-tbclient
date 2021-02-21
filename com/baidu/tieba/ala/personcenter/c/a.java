package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.tbadk.core.data.o {
    private String hZK;

    @Override // com.baidu.tbadk.core.data.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hZK = jSONObject.optString("qq", "");
        }
    }

    public String cmU() {
        return this.hZK;
    }
}
