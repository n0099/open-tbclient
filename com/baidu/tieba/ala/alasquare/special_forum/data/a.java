package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String fNu;
    public String fNv;
    public String fNw;
    public int fNx;
    public int fNy;
    public List<bw> fnr;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.fNu = jSONObject.optString("head_pic");
            this.fNv = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.fNw = jSONObject.optString("url");
            this.fNx = jSONObject.optInt("head_type", 0);
            this.fNy = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fnr = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bw bwVar = new bw();
                            bwVar.parserJson(jSONObject2);
                            this.fnr.add(bwVar);
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
