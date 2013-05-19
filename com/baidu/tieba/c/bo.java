package com.baidu.tieba.c;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bo {
    private int d = 0;
    private com.baidu.tieba.a.bf a = new com.baidu.tieba.a.bf();
    private com.baidu.tieba.a.h b = new com.baidu.tieba.a.h();
    private com.baidu.tieba.a.j c = new com.baidu.tieba.a.j();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a.a(jSONObject.optJSONObject("version"));
                this.b.a(jSONObject.optJSONObject("client"));
                this.c.a(jSONObject.optJSONObject("config"));
                this.d = jSONObject.optInt("sync_active", 0);
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public com.baidu.tieba.a.j a() {
        return this.c;
    }

    public com.baidu.tieba.a.bf b() {
        return this.a;
    }

    public com.baidu.tieba.a.h c() {
        return this.b;
    }
}
