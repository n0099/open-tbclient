package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class u {
    private String g;
    private String h;
    private int a = 0;
    private String b = "";
    private String c = "";
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private ArrayList<v> i = new ArrayList<>();

    public final void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.d = jSONObject.optInt("is_new_url", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.a = optJSONObject.optInt("errno", 0);
                    this.b = optJSONObject.optString("errmsg", "");
                    this.c = optJSONObject.optString("usermsg", "");
                }
                this.g = jSONObject.optString("total");
                this.e = jSONObject.optInt("has_more");
                JSONArray optJSONArray = jSONObject.optJSONArray("feed_thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        v vVar = new v();
                        vVar.a(optJSONArray.optJSONObject(i));
                        this.i.add(vVar);
                    }
                    this.f = optJSONArray.length() == 0;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public final void a(u uVar, boolean z) {
        if (uVar != null) {
            this.e = uVar.e;
            this.g = uVar.g;
            this.h = uVar.h;
            this.f = uVar.i == null || uVar.i.size() == 0;
            this.i.addAll(uVar.i);
        }
    }

    public final int a() {
        return this.d;
    }

    public final ArrayList<v> b() {
        return this.i;
    }

    public final boolean c() {
        return this.e > 0;
    }

    public final int d() {
        return this.a;
    }

    public final String e() {
        return this.c;
    }
}
