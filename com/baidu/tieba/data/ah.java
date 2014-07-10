package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah extends am {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    @Override // com.baidu.tieba.data.am
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("pos", 1);
                this.b = jSONObject.optString("app_name", "");
                this.c = jSONObject.optString("app_desc", "");
                this.d = jSONObject.optString("p_name", "");
                this.e = jSONObject.optString("p_url", "");
                this.f = jSONObject.optString("web_url", "");
                this.g = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
