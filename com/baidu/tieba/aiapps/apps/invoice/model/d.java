package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<DATA extends c> implements c {
    public String dnS;
    public String dnT;
    public DATA dnU;

    public d() {
    }

    public d(DATA data) {
        this.dnU = data;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bF(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dnS = jSONObject.optString("errno");
            this.dnT = jSONObject.optString("tipmsg");
            if (this.dnU != null) {
                this.dnU.bF(o.dP(jSONObject.optString("data")));
            }
        }
    }
}
