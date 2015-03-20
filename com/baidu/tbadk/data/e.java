package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int agW = 0;
    private int agX = 0;
    private int fans = 0;
    private int chat = 0;
    private int agY = 0;

    public int xQ() {
        return this.agW;
    }

    public int xR() {
        return this.agX;
    }

    public int xS() {
        return this.fans;
    }

    public int xT() {
        return this.agY;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.agW = jSONObject.optInt("replyme", 0);
                this.agX = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.agY = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
