package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.data.j {
    private String gou;

    @Override // com.baidu.tbadk.core.data.j
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gou = jSONObject.optString("qq", "");
        }
    }

    public String bIl() {
        return this.gou;
    }
}
