package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<DATA extends c> implements c {
    public String dbT;
    public String dbU;
    public DATA dbV;

    public d() {
    }

    public d(DATA data) {
        this.dbV = data;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dbT = jSONObject.optString("errno");
            this.dbU = jSONObject.optString("tipmsg");
            if (this.dbV != null) {
                this.dbV.bh(o.cZ(jSONObject.optString("data")));
            }
        }
    }
}
