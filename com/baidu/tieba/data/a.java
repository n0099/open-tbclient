package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private Date f955a;
    private String b;
    private int c;

    protected abstract void a(JSONObject jSONObject);

    public boolean a() {
        return this.b != null;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        try {
            b(new JSONObject(str));
        } catch (Exception e) {
            a("你的网络状况不大好，请稍后重试");
            com.baidu.tieba.util.aj.a("error = " + e.getMessage());
        }
    }

    public void b(JSONObject jSONObject) {
        try {
            this.c = jSONObject.optInt("error_code", 0);
            if (this.c != 0) {
                a(jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "你的网络状况不大好，请稍后重试"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.c = optJSONObject.optInt("errno", 0);
                if (this.c != 0) {
                    a(optJSONObject.optString("usermsg", "你的网络状况不大好，请稍后重试"));
                    return;
                }
            }
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.f955a = new Date(optLong * 1000);
            }
            a(jSONObject);
        } catch (Exception e) {
            a("你的网络状况不大好，请稍后重试");
            com.baidu.tieba.util.aj.a("error = " + e.getMessage());
        }
    }
}
