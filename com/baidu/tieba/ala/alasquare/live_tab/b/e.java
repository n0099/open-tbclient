package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.tbadk.core.data.bj;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private boolean ehr = false;
    public bj ehu;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ehr = jSONObject.optInt("need_show") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
            if (optJSONObject != null) {
                this.ehu = new bj();
                this.ehu.parserJson(optJSONObject);
            }
        }
    }

    public boolean isValid() {
        return (this.ehu == null || this.ehu.azX() == null || this.ehu.azX().live_id <= 0) ? false : true;
    }

    public boolean aZN() {
        return this.ehr && this.ehu != null;
    }
}
