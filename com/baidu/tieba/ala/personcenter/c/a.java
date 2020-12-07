package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.core.data.n {
    private String hNk;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hNk = jSONObject.optString("qq", "");
        }
    }

    public String cmN() {
        return this.hNk;
    }
}
