package com.baidu.tieba.data;

import com.baidu.tieba.util.bo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private String a = null;
    private int b = 0;

    public void a(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optInt("class_id", 0);
                this.a = jSONObject.optString("class_name");
            } catch (Exception e) {
                bo.b("GoodData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
