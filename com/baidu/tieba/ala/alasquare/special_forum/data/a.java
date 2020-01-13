package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public List<bj> dOX;
    public String emW;
    public String emX;
    public String emY;
    public int emZ;
    public int ena;

    public void parse(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.emW = jSONObject.optString("head_pic");
            this.emX = jSONObject.optString(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
            this.emY = jSONObject.optString("url");
            this.emZ = jSONObject.optInt("head_type", 0);
            this.ena = jSONObject.optInt("is_set", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.dOX = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null) {
                            bj bjVar = new bj();
                            bjVar.parserJson(jSONObject2);
                            this.dOX.add(bjVar);
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
