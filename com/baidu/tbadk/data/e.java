package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int Wo = 0;
    private int Wp = 0;
    private int fans = 0;
    private int chat = 0;
    private int Wq = 0;

    public int up() {
        return this.Wo;
    }

    public int uq() {
        return this.Wp;
    }

    public int ur() {
        return this.fans;
    }

    public int us() {
        return this.Wq;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wo = jSONObject.optInt("replyme", 0);
                this.Wp = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.Wq = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
