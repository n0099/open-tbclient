package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {
    private int alB = 0;
    private int alC = 0;
    private int fans = 0;
    private int chat = 0;
    private int alD = 0;

    public int zC() {
        return this.alB;
    }

    public int zD() {
        return this.alC;
    }

    public int zE() {
        return this.fans;
    }

    public int zF() {
        return this.alD;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.alB = jSONObject.optInt("replyme", 0);
                this.alC = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.alD = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
