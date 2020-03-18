package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private long eAq;
    private int ezV;

    public void parserJson(JSONObject jSONObject) {
        this.ezV = jSONObject.optInt("loot_result");
        this.eAq = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean ber() {
        return this.ezV == 1;
    }

    public long bes() {
        return this.eAq;
    }
}
