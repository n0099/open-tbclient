package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private int cLz = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int cLB = 0;
    private int has_more = 0;
    private int cLC = 0;
    private int total_count = 0;
    private int cLA = 0;

    public int ayu() {
        return this.total_count;
    }

    public int ayw() {
        return this.current_page;
    }

    public int ayy() {
        return this.has_more;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cLz = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.cLB = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.cLC = jSONObject.optInt("has_prev", 0);
                this.cLA = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
