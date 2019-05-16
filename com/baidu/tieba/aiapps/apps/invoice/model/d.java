package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<DATA extends c> implements c {
    public String dbS;
    public String dbT;
    public DATA dbU;

    public d() {
    }

    public d(DATA data) {
        this.dbU = data;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dbS = jSONObject.optString("errno");
            this.dbT = jSONObject.optString("tipmsg");
            if (this.dbU != null) {
                this.dbU.bh(o.cZ(jSONObject.optString("data")));
            }
        }
    }
}
