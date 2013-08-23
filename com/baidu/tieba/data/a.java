package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private Date f965a;
    private String b;
    private int c;

    protected abstract void a(JSONObject jSONObject);

    public int a() {
        return this.c;
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
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
            com.baidu.tieba.util.aq.a("error = " + e.getMessage());
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
                this.f965a = new Date(optLong * 1000);
            }
            a(jSONObject);
        } catch (Exception e) {
            a("你的网络状况不大好，请稍后重试");
            com.baidu.tieba.util.aq.a("error = " + e.getMessage());
        }
    }
}
