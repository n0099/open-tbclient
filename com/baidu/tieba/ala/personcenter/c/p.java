package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p extends com.baidu.tbadk.core.data.m {
    private int gBU;
    private int gBV;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gBU = jSONObject.optInt("open_level", 1);
            this.gBV = jSONObject.optInt("open_status", 2);
        }
    }
}
