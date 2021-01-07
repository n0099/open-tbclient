package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class l {
    private long amount;
    private int gUc;

    public void parserJson(JSONObject jSONObject) {
        this.gUc = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bXr() {
        return this.gUc == 1;
    }

    public long bXs() {
        return this.amount;
    }
}
