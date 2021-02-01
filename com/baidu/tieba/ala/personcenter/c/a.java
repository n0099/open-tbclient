package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.tbadk.core.data.o {
    private String hZw;

    @Override // com.baidu.tbadk.core.data.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hZw = jSONObject.optString("qq", "");
        }
    }

    public String cmN() {
        return this.hZw;
    }
}
