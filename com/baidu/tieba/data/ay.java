package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ay {
    private ArrayList<ax> f;

    /* renamed from: a  reason: collision with root package name */
    private int f1015a = 0;
    private int d = 0;
    private int e = 0;
    private boolean c = false;
    private boolean b = false;

    public ay() {
        this.f = null;
        this.f = new ArrayList<>();
    }

    public ArrayList<ax> a() {
        return this.f;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("SearchPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("page");
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                this.f.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    ax axVar = new ax();
                    axVar.a(optJSONObject2);
                    this.f.add(axVar);
                }
                this.f1015a = optJSONObject.optInt("total_count");
                this.e = optJSONObject.optInt("total_page");
                this.b = optJSONObject.optInt("has_more") != 0;
                this.c = optJSONObject.optInt("has_prev") != 0;
                this.d = optJSONObject.optInt("current_page");
            } catch (Exception e) {
                com.baidu.tieba.util.av.b("SearchPostModel", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
