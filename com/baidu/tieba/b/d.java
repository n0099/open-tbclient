package com.baidu.tieba.b;

import com.baidu.tieba.a.ai;
import com.baidu.tieba.a.ay;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tieba.a.q a = new com.baidu.tieba.a.q();
    private ArrayList b = new ArrayList();
    private ArrayList c = new ArrayList();
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private com.baidu.tieba.a.b g = new com.baidu.tieba.a.b();
    private ai h = new ai();

    public com.baidu.tieba.a.q a() {
        return this.a;
    }

    public ArrayList b() {
        return this.b;
    }

    public ArrayList c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public com.baidu.tieba.a.b e() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a.a(jSONObject.optJSONObject("forum"));
                this.h.a(jSONObject.optJSONObject("user"));
                this.g.a(jSONObject.optJSONObject("anti"));
                JSONObject optJSONObject = jSONObject.optJSONObject("photo_data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("thread_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ay ayVar = new ay();
                            ayVar.a(optJSONArray.optJSONObject(i));
                            this.b.add(ayVar);
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("alb_id_list");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            this.c.add(optJSONArray2.optString(i2));
                        }
                    }
                    this.d = optJSONObject.optInt("has_more", 0);
                    this.e = optJSONObject.optInt("amount", 0);
                    this.f = optJSONObject.optInt("current_count", 0);
                }
            } catch (Exception e) {
                ag.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ag.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
        }
    }
}
