package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.cb;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String gIA;
    public String gIB;
    public int gIC;
    public int gID;
    public String gIz;
    public List<cb> gdY;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gIz = jSONObject.optString("head_pic");
            this.gIA = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gIB = jSONObject.optString("url");
            this.gIC = jSONObject.optInt("head_type", 0);
            this.gID = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gdY = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            cb cbVar = new cb();
                            cbVar.parserJson(jSONObject2);
                            this.gdY.add(cbVar);
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
