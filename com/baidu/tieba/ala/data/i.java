package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    private int etO;
    private long euk;

    public void parserJson(JSONObject jSONObject) {
        this.etO = jSONObject.optInt("loot_result");
        this.euk = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bbz() {
        return this.etO == 1;
    }

    public long bbA() {
        return this.euk;
    }
}
