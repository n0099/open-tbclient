package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private String bJD;
    private int bJE = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bJD = jSONObject.optString("content");
            this.bJE = jSONObject.optInt("type", 1);
        }
    }

    public String Wk() {
        return this.bJD;
    }

    public int Wl() {
        return this.bJE;
    }

    public void iW(String str) {
        this.bJD = str;
    }

    public void gA(int i) {
        this.bJE = i;
    }
}
