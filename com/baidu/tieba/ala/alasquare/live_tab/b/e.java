package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.tbadk.core.data.bh;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    private boolean dwp = false;
    public bh dws;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dwp = jSONObject.optInt("need_show") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
            if (optJSONObject != null) {
                this.dws = new bh();
                this.dws.parserJson(optJSONObject);
            }
        }
    }

    public boolean isValid() {
        return (this.dws == null || this.dws.aiX() == null || this.dws.aiX().live_id <= 0) ? false : true;
    }

    public boolean aJp() {
        return this.dwp && this.dws != null;
    }
}
