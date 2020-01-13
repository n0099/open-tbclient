package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    private int euZ;
    private long evv;

    public void parserJson(JSONObject jSONObject) {
        this.euZ = jSONObject.optInt("loot_result");
        this.evv = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bbU() {
        return this.euZ == 1;
    }

    public long bbV() {
        return this.evv;
    }
}
