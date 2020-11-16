package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.core.data.n {
    private String hDD;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hDD = jSONObject.optString("qq", "");
        }
    }

    public String ciT() {
        return this.hDD;
    }
}
