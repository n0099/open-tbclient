package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private String gjP;
    private int gjQ = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gjP = jSONObject.optString("content");
            this.gjQ = jSONObject.optInt("type", 1);
        }
    }

    public String bMD() {
        return this.gjP;
    }

    public int bME() {
        return this.gjQ;
    }

    public void Go(String str) {
        this.gjP = str;
    }

    public void tY(int i) {
        this.gjQ = i;
    }
}
