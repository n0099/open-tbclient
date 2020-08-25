package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.core.data.m {
    private String gTu;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gTu = jSONObject.optString("qq", "");
        }
    }

    public String bYB() {
        return this.gTu;
    }
}
