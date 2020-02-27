package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends com.baidu.tbadk.core.data.k {
    private int fuA;
    private int fuB;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fuA = jSONObject.optInt("open_level", 1);
            this.fuB = jSONObject.optInt("open_status", 2);
        }
    }
}
