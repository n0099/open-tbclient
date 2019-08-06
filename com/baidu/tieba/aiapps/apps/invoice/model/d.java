package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<DATA extends c> implements c {
    public String ddD;
    public String ddE;
    public DATA ddF;

    public d() {
    }

    public d(DATA data) {
        this.ddF = data;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ddD = jSONObject.optString("errno");
            this.ddE = jSONObject.optString("tipmsg");
            if (this.ddF != null) {
                this.ddF.bh(o.dd(jSONObject.optString("data")));
            }
        }
    }
}
