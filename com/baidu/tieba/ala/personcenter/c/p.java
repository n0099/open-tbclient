package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p extends com.baidu.tbadk.core.data.k {
    private int fZV;
    private int fZW;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fZV = jSONObject.optInt("open_level", 1);
            this.fZW = jSONObject.optInt("open_status", 2);
        }
    }
}
