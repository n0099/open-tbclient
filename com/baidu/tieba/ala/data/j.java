package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j {
    private long fUG;
    private int fUl;

    public void parserJson(JSONObject jSONObject) {
        this.fUl = jSONObject.optInt("loot_result");
        this.fUG = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bIP() {
        return this.fUl == 1;
    }

    public long bIQ() {
        return this.fUG;
    }
}
