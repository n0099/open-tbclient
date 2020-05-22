package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int frZ;
    private long fsu;

    public void parserJson(JSONObject jSONObject) {
        this.frZ = jSONObject.optInt("loot_result");
        this.fsu = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean btx() {
        return this.frZ == 1;
    }

    public long bty() {
        return this.fsu;
    }
}
