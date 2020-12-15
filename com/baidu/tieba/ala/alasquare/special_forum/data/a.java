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
    public String gxv;
    public String gxw;
    public String gxx;
    public int gxy;
    public int gxz;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.gxv = jSONObject.optString("head_pic");
            this.gxw = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.gxx = jSONObject.optString("url");
            this.gxy = jSONObject.optInt("head_type", 0);
            this.gxz = jSONObject.optInt("is_set", -1);
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
