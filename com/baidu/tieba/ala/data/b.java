package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private String fIM;
    private int fIN = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fIM = jSONObject.optString("content");
            this.fIN = jSONObject.optInt("type", 1);
        }
    }

    public String bzG() {
        return this.fIM;
    }

    public int bzH() {
        return this.fIN;
    }

    public void CJ(String str) {
        this.fIM = str;
    }

    public void qV(int i) {
        this.fIN = i;
    }
}
