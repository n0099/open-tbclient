package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private String bOr;
    private int bOs = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bOr = jSONObject.optString("content");
            this.bOs = jSONObject.optInt("type", 1);
        }
    }

    public String Xn() {
        return this.bOr;
    }

    public int Xo() {
        return this.bOs;
    }

    public void iL(String str) {
        this.bOr = str;
    }

    public void gB(int i) {
        this.bOs = i;
    }
}
