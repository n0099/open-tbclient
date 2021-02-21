package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class l {
    private long amount;
    private int gSt;

    public void parserJson(JSONObject jSONObject) {
        this.gSt = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bUl() {
        return this.gSt == 1;
    }

    public long bUm() {
        return this.amount;
    }
}
