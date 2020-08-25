package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends com.baidu.tbadk.core.data.m {
    private int gTU;
    private int gTV;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gTU = jSONObject.optInt("open_level", 1);
            this.gTV = jSONObject.optInt("open_status", 2);
        }
    }
}
