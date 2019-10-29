package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private int bZX = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bZZ = 0;
    private int has_more = 0;
    private int caa = 0;
    private int total_count = 0;
    private int bZY = 0;

    public int ahw() {
        return this.total_count;
    }

    public int ahy() {
        return this.current_page;
    }

    public int ahA() {
        return this.has_more;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bZX = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bZZ = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.caa = jSONObject.optInt("has_prev", 0);
                this.bZY = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
