package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private long fDQ;
    private int fDv;

    public void parserJson(JSONObject jSONObject) {
        this.fDv = jSONObject.optInt("loot_result");
        this.fDQ = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bwu() {
        return this.fDv == 1;
    }

    public long bwv() {
        return this.fDQ;
    }
}
