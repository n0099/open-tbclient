package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public List<bx> fNt;
    public String gpk;
    public String gpl;
    public String gpm;
    public int gpn;
    public int gpo;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gpk = jSONObject.optString("head_pic");
            this.gpl = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gpm = jSONObject.optString("url");
            this.gpn = jSONObject.optInt("head_type", 0);
            this.gpo = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fNt = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bx bxVar = new bx();
                            bxVar.parserJson(jSONObject2);
                            this.fNt.add(bxVar);
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
