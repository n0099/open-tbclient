package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.data.m {
    private String qq;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.qq = jSONObject.optString("qq", "");
        }
    }

    public String bLt() {
        return this.qq;
    }
}
