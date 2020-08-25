package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private String fUd;
    private int fUe = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fUd = jSONObject.optString("content");
            this.fUe = jSONObject.optInt("type", 1);
        }
    }

    public String bIJ() {
        return this.fUd;
    }

    public int bIK() {
        return this.fUe;
    }

    public void Fe(String str) {
        this.fUd = str;
    }

    public void th(int i) {
        this.fUe = i;
    }
}
