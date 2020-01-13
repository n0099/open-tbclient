package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends com.baidu.tbadk.core.data.k {
    private int frY;
    private int frZ;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.frY = jSONObject.optInt("open_level", 1);
            this.frZ = jSONObject.optInt("open_status", 2);
        }
    }
}
