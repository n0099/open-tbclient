package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public List<bk> eIk;
    public String fie;
    public String fif;
    public String fig;
    public int fih;
    public int fii;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.fie = jSONObject.optString("head_pic");
            this.fif = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.fig = jSONObject.optString("url");
            this.fih = jSONObject.optInt("head_type", 0);
            this.fii = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.eIk = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bk bkVar = new bk();
                            bkVar.parserJson(jSONObject2);
                            this.eIk.add(bkVar);
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
