package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q extends com.baidu.tbadk.core.data.n {
    private int hVC;
    private int hVD;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hVC = jSONObject.optInt("open_level", 1);
            this.hVD = jSONObject.optInt("open_status", 2);
        }
    }
}
