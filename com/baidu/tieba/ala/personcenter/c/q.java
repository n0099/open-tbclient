package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q extends com.baidu.tbadk.core.data.o {
    private int hZX;
    private int hZY;

    @Override // com.baidu.tbadk.core.data.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hZX = jSONObject.optInt("open_level", 1);
            this.hZY = jSONObject.optInt("open_status", 2);
        }
    }
}
