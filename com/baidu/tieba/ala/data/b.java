package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private String bNp;
    private int bNq = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bNp = jSONObject.optString("content");
            this.bNq = jSONObject.optInt("type", 1);
        }
    }

    public String Vb() {
        return this.bNp;
    }

    public int Vc() {
        return this.bNq;
    }

    public void hW(String str) {
        this.bNp = str;
    }

    public void eY(int i) {
        this.bNq = i;
    }
}
