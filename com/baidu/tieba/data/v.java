package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private am e;
    private ArrayList<g> f;
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

    public v(Context context) {
        this.e = null;
        this.f = null;
        this.n = null;
        this.n = context;
        this.e = new am();
        this.f = new ArrayList<>();
    }

    public am a() {
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
            this.i = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.POST_ID);
            this.k = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
            this.l = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_ID);
            this.j = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.m = jSONObject.optInt("index", -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.a = optJSONObject.optString("id");
                this.b = optJSONObject.optString("url");
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
                    g gVar = new g();
                    gVar.a(optJSONArray.optJSONObject(i));
                    this.f.add(gVar);
                }
            }
            this.e.a(this.f);
            if (this.n != null) {
                this.e.b(this.n);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
