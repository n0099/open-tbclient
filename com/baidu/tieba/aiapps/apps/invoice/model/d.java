package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<DATA extends c> implements c {
    public String doK;
    public String doL;
    public DATA doM;

    public d() {
    }

    public d(DATA data) {
        this.doM = data;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bE(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.doK = jSONObject.optString("errno");
            this.doL = jSONObject.optString("tipmsg");
            if (this.doM != null) {
                this.doM.bE(o.dP(jSONObject.optString("data")));
            }
        }
    }
}
