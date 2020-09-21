package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private int fXA;
    private long fXV;

    public void parserJson(JSONObject jSONObject) {
        this.fXA = jSONObject.optInt("loot_result");
        this.fXV = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bJY() {
        return this.fXA == 1;
    }

    public long bJZ() {
        return this.fXV;
    }
}
