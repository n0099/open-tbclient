package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l extends com.baidu.tbadk.core.data.k {
    private int eye;
    private int eyf;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eye = jSONObject.optInt("open_level", 1);
            this.eyf = jSONObject.optInt("open_status", 2);
        }
    }
}
