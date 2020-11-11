package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private String bGg;
    private int bGh = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bGg = jSONObject.optString("content");
            this.bGh = jSONObject.optInt("type", 1);
        }
    }

    public String Ut() {
        return this.bGg;
    }

    public int Uu() {
        return this.bGh;
    }

    public void iy(String str) {
        this.bGg = str;
    }

    public void gf(int i) {
        this.bGh = i;
    }
}
