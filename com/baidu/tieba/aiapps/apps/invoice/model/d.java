package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<DATA extends c> implements c {
    public String ddw;
    public String ddx;
    public DATA ddy;

    public d() {
    }

    public d(DATA data) {
        this.ddy = data;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ddw = jSONObject.optString("errno");
            this.ddx = jSONObject.optString("tipmsg");
            if (this.ddy != null) {
                this.ddy.bh(o.dd(jSONObject.optString("data")));
            }
        }
    }
}
