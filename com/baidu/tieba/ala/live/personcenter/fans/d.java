package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    private int dZo = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dZq = 0;
    private int has_more = 0;
    private int dZr = 0;
    private int total_count = 0;
    private int dZp = 0;

    public int bdq() {
        return this.total_count;
    }

    public int bds() {
        return this.current_page;
    }

    public int bdu() {
        return this.has_more;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dZo = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dZq = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dZr = jSONObject.optInt("has_prev", 0);
                this.dZp = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
