package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private int f1043a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.f1043a;
    }

    public void a(int i) {
        this.f1043a = i;
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
            com.baidu.tieba.util.av.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1043a = jSONObject.optInt("error_code", 0);
                this.b = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                this.c = jSONObject.optString("error_data");
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
