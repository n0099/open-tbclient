package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends com.baidu.tbadk.core.data.k {
    private int foO;
    private int foP;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.foO = jSONObject.optInt("open_level", 1);
            this.foP = jSONObject.optInt("open_status", 2);
        }
    }
}
