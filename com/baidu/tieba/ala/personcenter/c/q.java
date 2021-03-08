package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q extends com.baidu.tbadk.core.data.o {
    private int ibU;
    private int ibV;

    @Override // com.baidu.tbadk.core.data.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ibU = jSONObject.optInt("open_level", 1);
            this.ibV = jSONObject.optInt("open_status", 2);
        }
    }
}
