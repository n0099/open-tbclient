package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public List<bu> eSH;
    public String ftD;
    public String ftE;
    public String ftF;
    public int ftG;
    public int ftH;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.ftD = jSONObject.optString("head_pic");
            this.ftE = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.ftF = jSONObject.optString("url");
            this.ftG = jSONObject.optInt("head_type", 0);
            this.ftH = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.eSH = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bu buVar = new bu();
                            buVar.parserJson(jSONObject2);
                            this.eSH.add(buVar);
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
