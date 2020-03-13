package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private long ezU;
    private int ezz;

    public void parserJson(JSONObject jSONObject) {
        this.ezz = jSONObject.optInt("loot_result");
        this.ezU = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bem() {
        return this.ezz == 1;
    }

    public long ben() {
        return this.ezU;
    }
}
