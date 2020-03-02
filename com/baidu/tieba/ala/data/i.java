package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private long ezH;
    private int ezm;

    public void parserJson(JSONObject jSONObject) {
        this.ezm = jSONObject.optInt("loot_result");
        this.ezH = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bel() {
        return this.ezm == 1;
    }

    public long bem() {
        return this.ezH;
    }
}
