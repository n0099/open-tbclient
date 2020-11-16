package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends com.baidu.tbadk.core.data.n {
    private int hEf;
    private int hEg;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hEf = jSONObject.optInt("open_level", 1);
            this.hEg = jSONObject.optInt("open_status", 2);
        }
    }
}
