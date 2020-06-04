package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p extends com.baidu.tbadk.core.data.j {
    private int gpf;
    private int gpg;

    @Override // com.baidu.tbadk.core.data.j
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gpf = jSONObject.optInt("open_level", 1);
            this.gpg = jSONObject.optInt("open_status", 2);
        }
    }
}
