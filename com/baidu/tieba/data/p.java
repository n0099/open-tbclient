package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class p {
    private String g;
    private String h;
    private int a = 0;
    private String b = "";
    private String c = "";
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private ArrayList<q> i = new ArrayList<>();

    public final void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
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
                        q qVar = new q();
                        qVar.a(optJSONArray.optJSONObject(i));
                        this.i.add(qVar);
                    }
                    this.f = optJSONArray.length() == 0;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public final void a(p pVar, boolean z) {
        if (pVar != null) {
            this.e = pVar.e;
            this.g = pVar.g;
            this.h = pVar.h;
            this.f = pVar.i == null || pVar.i.size() == 0;
            this.i.addAll(pVar.i);
        }
    }

    public final int a() {
        return this.d;
    }

    public final ArrayList<q> b() {
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
