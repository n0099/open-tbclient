package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private String f1023a;
    private String b;
    private String c;
    private boolean d;
    private ArrayList e = new ArrayList();

    public String a() {
        return this.f1023a;
    }

    public String b() {
        return this.b;
    }

    public ArrayList c() {
        return this.e;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("publish_time");
            this.f1023a = jSONObject.optString("total");
            this.c = jSONObject.optString("update_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    o oVar = new o();
                    oVar.a(optJSONArray.getJSONObject(i));
                    this.e.add(oVar);
                }
            }
        } catch (JSONException e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }
}
