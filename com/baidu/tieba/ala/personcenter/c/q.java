package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends com.baidu.tbadk.core.data.m {
    private int hEy;
    private int hEz;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hEy = jSONObject.optInt("open_level", 1);
            this.hEz = jSONObject.optInt("open_status", 2);
        }
    }
}
