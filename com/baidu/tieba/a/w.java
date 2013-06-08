package com.baidu.tieba.a;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private ar c;
    private ArrayList d;
    private Context l;
    private String a = null;
    private String b = null;
    private int e = 0;
    private int f = 0;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private int k = -1;

    public w(Context context) {
        this.c = null;
        this.d = null;
        this.l = null;
        this.l = context;
        this.c = new ar();
        this.d = new ArrayList();
    }

    public ar a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.k;
    }

    public String i() {
        return this.j;
    }

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.g = jSONObject.getString("post_id");
            this.i = jSONObject.getString("user_name");
            this.j = jSONObject.getString(PushConstants.EXTRA_USER_ID);
            this.h = jSONObject.getString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.k = jSONObject.optInt("index", -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.a = optJSONObject.optString("id");
                this.b = optJSONObject.optString("url");
                this.e = optJSONObject.optInt("width", 0);
                this.f = optJSONObject.optInt("height", 0);
            }
            JSONArray jSONArray = jSONObject.getJSONArray("descr");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    k kVar = new k();
                    kVar.a(jSONArray.getJSONObject(i));
                    this.d.add(kVar);
                }
            }
            this.c.a(this.d);
            if (this.l != null) {
                this.c.d(this.l);
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "paserJson", e.toString());
        }
    }
}
