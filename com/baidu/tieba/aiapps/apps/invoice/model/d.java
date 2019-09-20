package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<DATA extends c> implements c {
    public String dfp;
    public String dfq;
    public DATA dfr;

    public d() {
    }

    public d(DATA data) {
        this.dfr = data;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dfp = jSONObject.optString("errno");
            this.dfq = jSONObject.optString("tipmsg");
            if (this.dfr != null) {
                this.dfr.bh(o.df(jSONObject.optString("data")));
            }
        }
    }
}
