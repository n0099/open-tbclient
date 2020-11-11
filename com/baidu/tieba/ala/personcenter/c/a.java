package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.core.data.m {
    private String hDW;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hDW = jSONObject.optString("qq", "");
        }
    }

    public String cjA() {
        return this.hDW;
    }
}
