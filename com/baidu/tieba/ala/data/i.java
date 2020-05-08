package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private long feP;
    private int feu;

    public void parserJson(JSONObject jSONObject) {
        this.feu = jSONObject.optInt("loot_result");
        this.feP = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bnF() {
        return this.feu == 1;
    }

    public long bnG() {
        return this.feP;
    }
}
