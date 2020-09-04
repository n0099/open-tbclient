package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends com.baidu.tbadk.core.data.m {
    private int gTY;
    private int gTZ;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gTY = jSONObject.optInt("open_level", 1);
            this.gTZ = jSONObject.optInt("open_status", 2);
        }
    }
}
