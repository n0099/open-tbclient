package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class az {

    /* renamed from: a  reason: collision with root package name */
    private int f1180a = 0;
    private String b = null;

    public int a() {
        return this.f1180a;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject("error"));
        } catch (Exception e) {
            bg.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f1180a = jSONObject.optInt("errno");
            this.b = jSONObject.optString("usermsg");
        } catch (Exception e) {
            bg.b(getClass().getName(), "parserJson", e.toString());
        }
    }
}
