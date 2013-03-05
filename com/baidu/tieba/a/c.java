package com.baidu.tieba.a;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends d implements Serializable {
    private int a = 0;
    private String b = null;
    private String c = null;

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("open", 0);
                this.b = jSONObject.optString("message_url", null);
                this.c = jSONObject.optString("dest_url", null);
            } catch (Exception e) {
                com.baidu.tieba.c.ag.a(e.getMessage());
            }
        }
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
