package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends ak {
    private String AI;
    private String alL;
    private String alM;
    private String alN;
    private String alO;
    private String alP;
    private int pos;

    @Override // com.baidu.tieba.data.ak
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.alL = jSONObject.optString("app_name", "");
                this.alM = jSONObject.optString("app_desc", "");
                this.alN = jSONObject.optString("p_name", "");
                this.alO = jSONObject.optString("p_url", "");
                this.alP = jSONObject.optString("web_url", "");
                this.AI = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
