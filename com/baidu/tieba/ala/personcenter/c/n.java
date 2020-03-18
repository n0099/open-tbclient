package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n extends com.baidu.tbadk.core.data.k {
    private int fvu;
    private int fvv;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fvu = jSONObject.optInt("open_level", 1);
            this.fvv = jSONObject.optInt("open_status", 2);
        }
    }
}
