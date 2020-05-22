package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p extends com.baidu.tbadk.core.data.j {
    private int goU;
    private int goV;

    @Override // com.baidu.tbadk.core.data.j
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.goU = jSONObject.optInt("open_level", 1);
            this.goV = jSONObject.optInt("open_status", 2);
        }
    }
}
