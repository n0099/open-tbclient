package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends com.baidu.tbadk.core.data.k {
    private int fuO;
    private int fuP;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fuO = jSONObject.optInt("open_level", 1);
            this.fuP = jSONObject.optInt("open_status", 2);
        }
    }
}
