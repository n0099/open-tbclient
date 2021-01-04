package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q extends com.baidu.tbadk.core.data.n {
    private int iaj;
    private int iak;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.iaj = jSONObject.optInt("open_level", 1);
            this.iak = jSONObject.optInt("open_status", 2);
        }
    }
}
