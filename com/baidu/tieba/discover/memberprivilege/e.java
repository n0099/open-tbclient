package com.baidu.tieba.discover.memberprivilege;

import org.json.JSONObject;
/* loaded from: classes.dex */
class e {
    public long apA;
    public long apB;
    public long apC;
    public long apw;
    public long apx;
    public long apy;
    public long apz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apw = jSONObject.optLong("scores_total");
            this.apx = jSONObject.optLong("scores_fetch");
            this.apy = jSONObject.optLong("scores_money");
            this.apz = jSONObject.optLong("scores_other");
            this.apA = jSONObject.optLong("update_time");
            this.apB = jSONObject.optLong("level");
            this.apC = jSONObject.optLong("limit");
        }
    }

    public boolean isValid() {
        return this.apy >= 0 && this.apz >= 0;
    }
}
