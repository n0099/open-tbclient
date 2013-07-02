package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private ar a;
    private ArrayList b;

    public aq(JSONObject jSONObject) {
        a(jSONObject);
    }

    public ar a() {
        return this.a;
    }

    public ArrayList b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("daily_forum");
            if (jSONObject2 != null) {
                this.a = new ar(this);
                this.a.c = jSONObject2.optString("forum_name");
                this.a.d = jSONObject2.optInt("star_level");
                this.a.e = jSONObject2.optString("recommend_reason");
                this.a.f = jSONObject2.optString("avatar");
                this.a.g = jSONObject2.optString("member_count");
                this.a.b = jSONObject2.optString("forum_id");
                this.a.h = jSONObject2.optString("thread_count");
            }
            String optString = jSONObject.optString("tag_name");
            JSONArray optJSONArray = jSONObject.optJSONArray("recommed_forum");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.b = new ArrayList();
                for (int i = 0; i < optJSONArray.length() && i < 3; i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    as asVar = new as(this);
                    if (jSONObject3 != null) {
                        asVar.b = optString;
                        asVar.c = jSONObject3.optString("forum_id");
                        asVar.d = jSONObject3.optString("forum_name");
                        asVar.e = jSONObject3.optString("avatar");
                        asVar.f = jSONObject3.optString("slogan");
                        asVar.g = jSONObject3.optString("member_count");
                        asVar.h = jSONObject3.optString("thread_count");
                        asVar.i = jSONObject3.optInt("is_like");
                    }
                    this.b.add(asVar);
                }
            }
        }
    }
}
