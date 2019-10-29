package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.tbadk.core.data.bh;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    private boolean dxg = false;
    public bh dxj;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dxg = jSONObject.optInt("need_show") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
            if (optJSONObject != null) {
                this.dxj = new bh();
                this.dxj.parserJson(optJSONObject);
            }
        }
    }

    public boolean isValid() {
        return (this.dxj == null || this.dxj.aiZ() == null || this.dxj.aiZ().live_id <= 0) ? false : true;
    }

    public boolean aJr() {
        return this.dxg && this.dxj != null;
    }
}
