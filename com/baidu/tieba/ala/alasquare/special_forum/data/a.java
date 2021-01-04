package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String gIA;
    public int gIB;
    public int gIC;
    public String gIy;
    public String gIz;
    public List<bz> geK;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gIy = jSONObject.optString("head_pic");
            this.gIz = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gIA = jSONObject.optString("url");
            this.gIB = jSONObject.optInt("head_type", 0);
            this.gIC = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.geK = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bz bzVar = new bz();
                            bzVar.parserJson(jSONObject2);
                            this.geK.add(bzVar);
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
