package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    private long amount;
    private int gzs;

    public void parserJson(JSONObject jSONObject) {
        this.gzs = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bRb() {
        return this.gzs == 1;
    }

    public long bRc() {
        return this.amount;
    }
}
