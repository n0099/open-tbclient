package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int WQ = 0;
    private int WR = 0;
    private int fans = 0;
    private int chat = 0;
    private int WS = 0;

    public int uA() {
        return this.WQ;
    }

    public int uB() {
        return this.WR;
    }

    public int uC() {
        return this.fans;
    }

    public int uD() {
        return this.WS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WQ = jSONObject.optInt("replyme", 0);
                this.WR = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.WS = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
