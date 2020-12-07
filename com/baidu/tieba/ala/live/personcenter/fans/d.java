package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int eHj = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int eHl = 0;
    private int has_more = 0;
    private int eHm = 0;
    private int total_count = 0;
    private int eHk = 0;

    public int bnB() {
        return this.total_count;
    }

    public int bnD() {
        return this.current_page;
    }

    public int bnF() {
        return this.has_more;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eHj = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.eHl = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.eHm = jSONObject.optInt("has_prev", 0);
                this.eHk = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
