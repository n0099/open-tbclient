package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private ArrayList<q> e = new ArrayList<>();

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public ArrayList<q> c() {
        return this.e;
    }

    public boolean d() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("publish_time");
            this.a = jSONObject.optString("total");
            this.c = jSONObject.optString("update_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    q qVar = new q();
                    qVar.a(optJSONArray.getJSONObject(i));
                    this.e.add(qVar);
                }
            }
        } catch (JSONException e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.toString());
        }
    }
}
