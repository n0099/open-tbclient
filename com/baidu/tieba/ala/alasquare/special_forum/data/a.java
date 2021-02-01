package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.cb;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String gGC;
    public String gGD;
    public String gGE;
    public int gGF;
    public int gGG;
    public List<cb> gcs;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gGC = jSONObject.optString("head_pic");
            this.gGD = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gGE = jSONObject.optString("url");
            this.gGF = jSONObject.optInt("head_type", 0);
            this.gGG = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gcs = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            cb cbVar = new cb();
                            cbVar.parserJson(jSONObject2);
                            this.gcs.add(cbVar);
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
