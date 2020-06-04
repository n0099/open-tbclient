package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private long fsF;
    private int fsk;

    public void parserJson(JSONObject jSONObject) {
        this.fsk = jSONObject.optInt("loot_result");
        this.fsF = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean btz() {
        return this.fsk == 1;
    }

    public long btA() {
        return this.fsF;
    }
}
