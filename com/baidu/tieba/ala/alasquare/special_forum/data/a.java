package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String fKc;
    public String fKd;
    public String fKe;
    public int fKf;
    public int fKg;
    public List<bw> fku;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.fKc = jSONObject.optString("head_pic");
            this.fKd = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.fKe = jSONObject.optString("url");
            this.fKf = jSONObject.optInt("head_type", 0);
            this.fKg = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fku = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bw bwVar = new bw();
                            bwVar.parserJson(jSONObject2);
                            this.fku.add(bwVar);
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
