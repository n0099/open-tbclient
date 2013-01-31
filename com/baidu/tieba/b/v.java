package com.baidu.tieba.b;

import com.baidu.tieba.a.az;
import com.baidu.tieba.c.af;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private int d = 0;
    private az a = new az();
    private com.baidu.tieba.a.h b = new com.baidu.tieba.a.h();
    private com.baidu.tieba.a.j c = new com.baidu.tieba.a.j();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            af.b(getClass().getName(), "parserJson", e.getMessage());
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
                af.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public az a() {
        return this.a;
    }

    public com.baidu.tieba.a.j b() {
        return this.c;
    }

    public com.baidu.tieba.a.h c() {
        return this.b;
    }
}
