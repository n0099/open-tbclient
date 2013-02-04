package com.baidu.tieba.b;

import com.baidu.tieba.a.aw;
import com.baidu.tieba.c.ae;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private int d = 0;
    private aw a = new aw();
    private com.baidu.tieba.a.g b = new com.baidu.tieba.a.g();
    private com.baidu.tieba.a.i c = new com.baidu.tieba.a.i();

    public aw a() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a.a(jSONObject.optJSONObject("version"));
            this.b.a(jSONObject.optJSONObject("client"));
            this.c.a(jSONObject.optJSONObject("config"));
            this.d = jSONObject.optInt("sync_active", 0);
        } catch (Exception e) {
            ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public com.baidu.tieba.a.g b() {
        return this.b;
    }
}
