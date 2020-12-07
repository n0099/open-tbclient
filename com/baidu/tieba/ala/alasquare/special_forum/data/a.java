package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.by;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public List<by> fVe;
    public String gxt;
    public String gxu;
    public String gxv;
    public int gxw;
    public int gxx;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gxt = jSONObject.optString("head_pic");
            this.gxu = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gxv = jSONObject.optString("url");
            this.gxw = jSONObject.optInt("head_type", 0);
            this.gxx = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fVe = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            by byVar = new by();
                            byVar.parserJson(jSONObject2);
                            this.fVe.add(byVar);
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
