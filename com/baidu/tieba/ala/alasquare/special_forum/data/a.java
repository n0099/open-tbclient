package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public List<bw> fNQ;
    public String gpD;
    public String gpE;
    public String gpF;
    public int gpG;
    public int gpH;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gpD = jSONObject.optString("head_pic");
            this.gpE = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gpF = jSONObject.optString("url");
            this.gpG = jSONObject.optInt("head_type", 0);
            this.gpH = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fNQ = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bw bwVar = new bw();
                            bwVar.parserJson(jSONObject2);
                            this.fNQ.add(bwVar);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
