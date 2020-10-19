package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private long amount;
    private int gjT;

    public void parserJson(JSONObject jSONObject) {
        this.gjT = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bMI() {
        return this.gjT == 1;
    }

    public long bMJ() {
        return this.amount;
    }
}
