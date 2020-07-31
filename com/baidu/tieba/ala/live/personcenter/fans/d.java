package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int dPR = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dPT = 0;
    private int has_more = 0;
    private int dPU = 0;
    private int total_count = 0;
    private int dPS = 0;

    public int aUX() {
        return this.total_count;
    }

    public int aUZ() {
        return this.current_page;
    }

    public int aVb() {
        return this.has_more;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dPR = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dPT = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dPU = jSONObject.optInt("has_prev", 0);
                this.dPS = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
