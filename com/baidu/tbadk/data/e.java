package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int aoX = 0;
    private int aoY = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int Ah() {
        return this.aoX;
    }

    public int Ai() {
        return this.aoY;
    }

    public int Aj() {
        return this.fans;
    }

    public int Ak() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aoX = jSONObject.optInt("replyme", 0);
                this.aoY = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
