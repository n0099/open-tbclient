package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q extends com.baidu.tbadk.core.data.o {
    private int ial;
    private int iam;

    @Override // com.baidu.tbadk.core.data.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ial = jSONObject.optInt("open_level", 1);
            this.iam = jSONObject.optInt("open_status", 2);
        }
    }
}
