package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    private long amount;
    private int gzL;

    public void parserJson(JSONObject jSONObject) {
        this.gzL = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bRI() {
        return this.gzL == 1;
    }

    public long bRJ() {
        return this.amount;
    }
}
