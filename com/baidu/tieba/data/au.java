package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList f;
    private int a = 0;
    private int d = 0;
    private int e = 0;
    private boolean c = false;
    private boolean b = false;

    public au() {
        this.f = null;
        this.f = new ArrayList();
    }

    public ArrayList a() {
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
            com.baidu.tieba.util.z.b("SearchPostModel", "parserJson", "error = " + e.getMessage());
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
                    at atVar = new at();
                    atVar.a(optJSONObject2);
                    this.f.add(atVar);
                }
                this.a = optJSONObject.optInt("total_count");
                this.e = optJSONObject.optInt("total_page");
                this.b = optJSONObject.optInt("has_more") != 0;
                this.c = optJSONObject.optInt("has_prev") != 0;
                this.d = optJSONObject.optInt("current_page");
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("SearchPostModel", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
