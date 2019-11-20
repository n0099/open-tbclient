package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l extends com.baidu.tbadk.core.data.k {
    private int exm;
    private int exn;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.exm = jSONObject.optInt("open_level", 1);
            this.exn = jSONObject.optInt("open_status", 2);
        }
    }
}
