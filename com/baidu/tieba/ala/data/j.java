package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private int fIQ;
    private long fJl;

    public void parserJson(JSONObject jSONObject) {
        this.fIQ = jSONObject.optInt("loot_result");
        this.fJl = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bzL() {
        return this.fIQ == 1;
    }

    public long bzM() {
        return this.fJl;
    }
}
