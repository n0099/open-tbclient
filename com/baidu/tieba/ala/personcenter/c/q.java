package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q extends com.baidu.tbadk.core.data.n {
    private int hNM;
    private int hNN;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hNM = jSONObject.optInt("open_level", 1);
            this.hNN = jSONObject.optInt("open_status", 2);
        }
    }
}
