package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j {
    private long fUC;
    private int fUh;

    public void parserJson(JSONObject jSONObject) {
        this.fUh = jSONObject.optInt("loot_result");
        this.fUC = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bIO() {
        return this.fUh == 1;
    }

    public long bIP() {
        return this.fUC;
    }
}
