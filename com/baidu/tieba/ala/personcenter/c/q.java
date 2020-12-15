package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q extends com.baidu.tbadk.core.data.n {
    private int hNO;
    private int hNP;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hNO = jSONObject.optInt("open_level", 1);
            this.hNP = jSONObject.optInt("open_status", 2);
        }
    }
}
