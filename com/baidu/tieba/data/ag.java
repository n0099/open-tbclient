package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends ak {
    private String AI;
    private String alC;
    private String alD;
    private String alE;
    private String alF;
    private String alG;
    private int pos;

    @Override // com.baidu.tieba.data.ak
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.alC = jSONObject.optString("app_name", "");
                this.alD = jSONObject.optString("app_desc", "");
                this.alE = jSONObject.optString("p_name", "");
                this.alF = jSONObject.optString("p_url", "");
                this.alG = jSONObject.optString("web_url", "");
                this.AI = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
