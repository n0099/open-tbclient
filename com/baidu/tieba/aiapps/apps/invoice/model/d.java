package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<DATA extends c> implements c {
    public String dbU;
    public String dbV;
    public DATA dbW;

    public d() {
    }

    public d(DATA data) {
        this.dbW = data;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dbU = jSONObject.optString("errno");
            this.dbV = jSONObject.optString("tipmsg");
            if (this.dbW != null) {
                this.dbW.bh(o.cY(jSONObject.optString("data")));
            }
        }
    }
}
