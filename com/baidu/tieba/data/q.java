package com.baidu.tieba.data;

import com.baidu.tieba.util.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private ArrayList<p> e = new ArrayList<>();

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public ArrayList<p> c() {
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
                    p pVar = new p();
                    pVar.a(optJSONArray.getJSONObject(i));
                    this.e.add(pVar);
                }
            }
        } catch (JSONException e) {
            bo.b(getClass().getName(), "parserJson", e.toString());
        }
    }
}
