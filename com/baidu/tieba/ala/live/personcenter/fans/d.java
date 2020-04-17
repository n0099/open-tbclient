package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int dph = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dpj = 0;
    private int has_more = 0;
    private int dpk = 0;
    private int total_count = 0;
    private int dpi = 0;

    public int aJw() {
        return this.total_count;
    }

    public int aJy() {
        return this.current_page;
    }

    public int aJA() {
        return this.has_more;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dph = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dpj = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dpk = jSONObject.optInt("has_prev", 0);
                this.dpi = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
