package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends com.baidu.tbadk.core.data.m {
    private int hmG;
    private int hmH;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hmG = jSONObject.optInt("open_level", 1);
            this.hmH = jSONObject.optInt("open_status", 2);
        }
    }
}
