package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public List<bw> fIa;
    public String gjQ;
    public String gjR;
    public String gjS;
    public int gjT;
    public int gjU;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gjQ = jSONObject.optString("head_pic");
            this.gjR = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gjS = jSONObject.optString("url");
            this.gjT = jSONObject.optInt("head_type", 0);
            this.gjU = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fIa = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bw bwVar = new bw();
                            bwVar.parserJson(jSONObject2);
                            this.fIa.add(bwVar);
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
