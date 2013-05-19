package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private int a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("error_code", 0);
                this.b = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                this.c = jSONObject.optString("error_data");
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
