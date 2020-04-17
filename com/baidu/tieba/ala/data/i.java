package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private long feK;
    private int fep;

    public void parserJson(JSONObject jSONObject) {
        this.fep = jSONObject.optInt("loot_result");
        this.feK = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bnH() {
        return this.fep == 1;
    }

    public long bnI() {
        return this.feK;
    }
}
