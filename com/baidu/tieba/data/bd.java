package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bd {

    /* renamed from: a  reason: collision with root package name */
    private int f1184a = 0;
    private int b = 0;
    private String c = "";

    public int a() {
        return this.f1184a;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1184a = jSONObject.optInt("is_lpost", 0);
                this.b = jSONObject.optInt("topic_type", 0);
                this.c = jSONObject.optString("link", "");
            } catch (Exception e) {
                bg.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
