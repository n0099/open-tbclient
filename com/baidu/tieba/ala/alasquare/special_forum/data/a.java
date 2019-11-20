package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public String dBb;
    public String dBc;
    public String dBd;
    public int dBe;
    public int dBf;
    public List<bh> daV;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.dBb = jSONObject.optString("head_pic");
            this.dBc = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.dBd = jSONObject.optString("url");
            this.dBe = jSONObject.optInt("head_type", 0);
            this.dBf = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.daV = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bh bhVar = new bh();
                            bhVar.parserJson(jSONObject2);
                            this.daV.add(bhVar);
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
