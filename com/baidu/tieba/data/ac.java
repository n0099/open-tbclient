package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {
    private int als = 0;
    private int alt = 0;
    private int fans = 0;
    private int chat = 0;
    private int alu = 0;

    public int zA() {
        return this.als;
    }

    public int zB() {
        return this.alt;
    }

    public int zC() {
        return this.fans;
    }

    public int zD() {
        return this.alu;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.als = jSONObject.optInt("replyme", 0);
                this.alt = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.alu = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
