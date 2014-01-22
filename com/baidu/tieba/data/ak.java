package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;

    public void a(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public void b(int i) {
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("MessageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("replyme", 0);
                this.b = jSONObject.optInt("atme", 0);
                this.c = jSONObject.optInt("fans", 0);
                this.d = jSONObject.optInt("pletter", 0);
                this.e = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("MessageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
