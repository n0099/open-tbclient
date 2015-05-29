package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int aif = 0;
    private int aig = 0;
    private int fans = 0;
    private int chat = 0;
    private int aih = 0;

    public int yJ() {
        return this.aif;
    }

    public int yK() {
        return this.aig;
    }

    public int yL() {
        return this.fans;
    }

    public int yM() {
        return this.aih;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aif = jSONObject.optInt("replyme", 0);
                this.aig = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.aih = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
