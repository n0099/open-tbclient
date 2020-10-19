package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.core.data.m {
    private String hme;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hme = jSONObject.optString("qq", "");
        }
    }

    public String cdW() {
        return this.hme;
    }
}
