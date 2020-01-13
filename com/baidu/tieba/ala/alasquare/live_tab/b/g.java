package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.tbadk.core.data.bj;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    private boolean ehB = false;
    public bj ehH;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ehB = jSONObject.optInt("need_show") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
            if (optJSONObject != null) {
                this.ehH = new bj();
                this.ehH.parserJson(optJSONObject);
            }
        }
    }

    public boolean isValid() {
        return (this.ehH == null || this.ehH.aAq() == null || this.ehH.aAq().live_id <= 0) ? false : true;
    }

    public boolean baj() {
        return this.ehB && this.ehH != null;
    }
}
