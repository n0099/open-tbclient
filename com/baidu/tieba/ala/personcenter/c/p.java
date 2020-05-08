package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p extends com.baidu.tbadk.core.data.k {
    private int gaa;
    private int gab;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gaa = jSONObject.optInt("open_level", 1);
            this.gab = jSONObject.optInt("open_status", 2);
        }
    }
}
