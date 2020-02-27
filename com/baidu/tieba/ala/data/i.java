package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private long ezG;
    private int ezl;

    public void parserJson(JSONObject jSONObject) {
        this.ezl = jSONObject.optInt("loot_result");
        this.ezG = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bej() {
        return this.ezl == 1;
    }

    public long bek() {
        return this.ezG;
    }
}
