package com.baidu.tieba.a;

import com.baidu.tieba.TiebaApplication;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements Serializable {
    private int a;
    private int b;
    private int c;
    private String d;
    private int e;
    private String f;
    private String g;
    private String h;

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public String b() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("ifpost", 0);
                this.b = jSONObject.optInt("ifposta", 0);
                this.c = jSONObject.optInt("forbid_flag", 0);
                this.d = jSONObject.optString("tbs");
                if (TiebaApplication.d() != null && this.d != null && this.d.length() > 0) {
                    TiebaApplication.d().h(this.d);
                }
                this.e = jSONObject.optInt("need_vcode", 0);
                this.f = jSONObject.optString("vcode_md5");
                this.g = jSONObject.optString("vcode_pic_url");
                this.h = jSONObject.optString("forbid_info");
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b("AntiData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public String e() {
        return this.h;
    }
}
