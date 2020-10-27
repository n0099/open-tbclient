package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private String bzV;
    private int bzW = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bzV = jSONObject.optString("content");
            this.bzW = jSONObject.optInt("type", 1);
        }
    }

    public String RL() {
        return this.bzV;
    }

    public int RM() {
        return this.bzW;
    }

    /* renamed from: if  reason: not valid java name */
    public void m40if(String str) {
        this.bzV = str;
    }

    public void fS(int i) {
        this.bzW = i;
    }
}
