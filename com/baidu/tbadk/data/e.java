package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int WT = 0;
    private int WU = 0;
    private int fans = 0;
    private int chat = 0;
    private int WV = 0;

    public int uG() {
        return this.WT;
    }

    public int uH() {
        return this.WU;
    }

    public int uI() {
        return this.fans;
    }

    public int uJ() {
        return this.WV;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WT = jSONObject.optInt("replyme", 0);
                this.WU = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.WV = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
