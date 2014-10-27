package com.baidu.tieba.discover.memberprivilege;

import org.json.JSONObject;
/* loaded from: classes.dex */
class e {
    public long apm;
    public long apn;
    public long apo;
    public long apq;
    public long apr;
    public long aps;
    public long apt;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apm = jSONObject.optLong("scores_total");
            this.apn = jSONObject.optLong("scores_fetch");
            this.apo = jSONObject.optLong("scores_money");
            this.apq = jSONObject.optLong("scores_other");
            this.apr = jSONObject.optLong("update_time");
            this.aps = jSONObject.optLong("level");
            this.apt = jSONObject.optLong("limit");
        }
    }

    public boolean isValid() {
        return this.apo >= 0 && this.apq >= 0;
    }
}
