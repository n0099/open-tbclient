package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends com.baidu.tbadk.core.data.k {
    private int fuB;
    private int fuC;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fuB = jSONObject.optInt("open_level", 1);
            this.fuC = jSONObject.optInt("open_status", 2);
        }
    }
}
