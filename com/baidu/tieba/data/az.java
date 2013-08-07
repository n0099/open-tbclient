package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class az {

    /* renamed from: a  reason: collision with root package name */
    private ba f988a;
    private ArrayList b;

    public az(JSONObject jSONObject) {
        a(jSONObject);
    }

    public ba a() {
        return this.f988a;
    }

    public ArrayList b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("daily_forum");
            if (jSONObject2 != null) {
                this.f988a = new ba(this);
                this.f988a.c = jSONObject2.optString("forum_name");
                this.f988a.d = jSONObject2.optInt("star_level");
                this.f988a.e = jSONObject2.optString("recommend_reason");
                this.f988a.f = jSONObject2.optString("avatar");
                this.f988a.g = jSONObject2.optString("member_count");
                this.f988a.b = jSONObject2.optString("forum_id");
                this.f988a.h = jSONObject2.optString("thread_count");
            }
            String optString = jSONObject.optString("tag_name");
            JSONArray optJSONArray = jSONObject.optJSONArray("recommed_forum");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.b = new ArrayList();
                for (int i = 0; i < optJSONArray.length() && i < 3; i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    bb bbVar = new bb(this);
                    if (jSONObject3 != null) {
                        bbVar.b = optString;
                        bbVar.c = jSONObject3.optString("forum_id");
                        bbVar.d = jSONObject3.optString("forum_name");
                        bbVar.e = jSONObject3.optString("avatar");
                        bbVar.f = jSONObject3.optString("slogan");
                        bbVar.g = jSONObject3.optString("member_count");
                        bbVar.h = jSONObject3.optString("thread_count");
                        bbVar.i = jSONObject3.optInt("is_like");
                    }
                    this.b.add(bbVar);
                }
            }
        }
    }
}
