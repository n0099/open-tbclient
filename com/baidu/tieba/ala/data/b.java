package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private String fXw;
    private int fXx = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fXw = jSONObject.optString("content");
            this.fXx = jSONObject.optInt("type", 1);
        }
    }

    public String bJT() {
        return this.fXw;
    }

    public int bJU() {
        return this.fXx;
    }

    public void FD(String str) {
        this.fXw = str;
    }

    public void tA(int i) {
        this.fXx = i;
    }
}
