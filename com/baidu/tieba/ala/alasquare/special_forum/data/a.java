package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String gDS;
    public String gDT;
    public String gDU;
    public int gDV;
    public int gDW;
    public List<bz> gaa;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gDS = jSONObject.optString("head_pic");
            this.gDT = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gDU = jSONObject.optString("url");
            this.gDV = jSONObject.optInt("head_type", 0);
            this.gDW = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gaa = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bz bzVar = new bz();
                            bzVar.parserJson(jSONObject2);
                            this.gaa.add(bzVar);
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
