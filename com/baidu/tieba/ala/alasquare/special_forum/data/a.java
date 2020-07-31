package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public List<bv> eZc;
    public String fyK;
    public String fyL;
    public String fyM;
    public int fyN;
    public int fyO;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.fyK = jSONObject.optString("head_pic");
            this.fyL = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.fyM = jSONObject.optString("url");
            this.fyN = jSONObject.optInt("head_type", 0);
            this.fyO = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.eZc = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bv bvVar = new bv();
                            bvVar.parserJson(jSONObject2);
                            this.eZc.add(bvVar);
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
