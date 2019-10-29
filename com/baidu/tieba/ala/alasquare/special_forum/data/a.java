package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public String dBS;
    public String dBT;
    public String dBU;
    public int dBV;
    public int dBW;
    public List<bh> dbM;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.dBS = jSONObject.optString("head_pic");
            this.dBT = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.dBU = jSONObject.optString("url");
            this.dBV = jSONObject.optInt("head_type", 0);
            this.dBW = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.dbM = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bh bhVar = new bh();
                            bhVar.parserJson(jSONObject2);
                            this.dbM.add(bhVar);
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
