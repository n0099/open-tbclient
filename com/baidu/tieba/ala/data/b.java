package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private String fUh;
    private int fUi = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fUh = jSONObject.optString("content");
            this.fUi = jSONObject.optInt("type", 1);
        }
    }

    public String bIK() {
        return this.fUh;
    }

    public int bIL() {
        return this.fUi;
    }

    public void Ff(String str) {
        this.fUh = str;
    }

    public void th(int i) {
        this.fUi = i;
    }
}
