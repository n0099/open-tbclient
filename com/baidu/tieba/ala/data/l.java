package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l {
    private long amount;
    private int gPw;

    public void parserJson(JSONObject jSONObject) {
        this.gPw = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bTz() {
        return this.gPw == 1;
    }

    public long bTA() {
        return this.amount;
    }
}
