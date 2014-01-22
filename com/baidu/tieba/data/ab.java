package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private as e;
    private ArrayList<j> f;
    private Context n;
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = null;
    private int g = 0;
    private int h = 0;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private int m = -1;

    public ab(Context context) {
        this.e = null;
        this.f = null;
        this.n = null;
        this.n = context;
        this.e = new as();
        this.f = new ArrayList<>();
    }

    public as a() {
        return this.e;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.k;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public int h() {
        return this.m;
    }

    public String i() {
        return this.l;
    }

    public String j() {
        return this.d;
    }

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.i = jSONObject.optString("post_id");
            this.k = jSONObject.optString("user_name");
            this.l = jSONObject.optString(PushConstants.EXTRA_USER_ID);
            this.j = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.m = jSONObject.optInt("index", -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.a = optJSONObject.optString("id");
                this.b = optJSONObject.optString(SocialConstants.PARAM_URL);
                this.g = optJSONObject.optInt("width", 0);
                this.h = optJSONObject.optInt("height", 0);
                this.c = optJSONObject.optString("cdn_src", "");
                if (this.c == null || this.c.length() == 0) {
                    this.c = this.b;
                }
                this.d = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    j jVar = new j();
                    jVar.a(optJSONArray.optJSONObject(i));
                    this.f.add(jVar);
                }
            }
            this.e.a(this.f);
            if (this.n != null) {
                this.e.b(this.n);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "paserJson", e.toString());
        }
    }
}
