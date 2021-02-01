package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class l {
    private long amount;
    private int gSf;

    public void parserJson(JSONObject jSONObject) {
        this.gSf = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bUe() {
        return this.gSf == 1;
    }

    public long bUf() {
        return this.amount;
    }
}
