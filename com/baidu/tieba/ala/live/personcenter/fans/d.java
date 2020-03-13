package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int cPO = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int cPQ = 0;
    private int has_more = 0;
    private int cPR = 0;
    private int total_count = 0;
    private int cPP = 0;

    public int aBg() {
        return this.total_count;
    }

    public int aBi() {
        return this.current_page;
    }

    public int aBk() {
        return this.has_more;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cPO = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.cPQ = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.cPR = jSONObject.optInt("has_prev", 0);
                this.cPP = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
