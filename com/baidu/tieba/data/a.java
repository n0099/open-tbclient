package com.baidu.tieba.data;

import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private Date a;
    private String b;
    private int c;

    protected abstract void a(JSONObject jSONObject);

    public final int a() {
        return this.c;
    }

    public final boolean b() {
        return this.b != null;
    }

    public final String c() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        try {
            b(new JSONObject(str));
        } catch (Exception e) {
            this.b = "你的网络状况不大好，请稍后重试";
            com.baidu.adp.lib.util.f.b("error = " + e.getMessage());
        }
    }

    public final void b(JSONObject jSONObject) {
        try {
            this.c = jSONObject.optInt("error_code", 0);
            if (this.c != 0) {
                this.b = jSONObject.optString("error_msg", "你的网络状况不大好，请稍后重试");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.c = optJSONObject.optInt("errno", 0);
                if (this.c != 0) {
                    this.b = optJSONObject.optString("usermsg", "你的网络状况不大好，请稍后重试");
                    return;
                }
            }
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.a = new Date(optLong * 1000);
            }
            a(jSONObject);
        } catch (Exception e) {
            this.b = "你的网络状况不大好，请稍后重试";
            com.baidu.adp.lib.util.f.b("error = " + e.getMessage());
        }
    }
}
