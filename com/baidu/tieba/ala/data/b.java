package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private String bOP;
    private int bOQ = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bOP = jSONObject.optString("content");
            this.bOQ = jSONObject.optInt("type", 1);
        }
    }

    public String Ve() {
        return this.bOP;
    }

    public int Vf() {
        return this.bOQ;
    }

    public void ic(String str) {
        this.bOP = str;
    }

    public void eZ(int i) {
        this.bOQ = i;
    }
}
