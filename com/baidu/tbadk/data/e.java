package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int ahe = 0;
    private int ahf = 0;
    private int fans = 0;
    private int chat = 0;
    private int ahg = 0;

    public int xW() {
        return this.ahe;
    }

    public int xX() {
        return this.ahf;
    }

    public int xY() {
        return this.fans;
    }

    public int xZ() {
        return this.ahg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ahe = jSONObject.optInt("replyme", 0);
                this.ahf = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.ahg = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
