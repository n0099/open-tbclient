package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    public static String a;
    private Date b;
    private String c;

    protected abstract void a(JSONObject jSONObject);

    public boolean a() {
        return this.c != null;
    }

    public String b() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        try {
            b(new JSONObject(str));
        } catch (Exception e) {
            a(a);
            com.baidu.tieba.util.z.a("error = " + e.getMessage());
        }
    }

    public void b(JSONObject jSONObject) {
        try {
            if (jSONObject.optInt("error_code", 0) != 0) {
                a(jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, a));
                return;
            }
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.b = new Date(optLong * 1000);
            }
            a(jSONObject);
        } catch (Exception e) {
            a(a);
            com.baidu.tieba.util.z.a("error = " + e.getMessage());
        }
    }
}
