package com.baidu.tieba.a;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w implements Serializable {
    private String a = null;
    private int b = 0;
    private int c = 0;

    public String a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("pic_id");
            this.b = jSONObject.optInt("width", 0);
            this.c = jSONObject.optInt("height", 0);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("InfoData", "parserJson", "error = " + e.getMessage());
        }
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }
}
