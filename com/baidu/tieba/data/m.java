package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class m {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private ArrayList<l> e = new ArrayList<>();

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final ArrayList<l> c() {
        return this.e;
    }

    public final boolean d() {
        return this.d;
    }

    public final void a(boolean z) {
        this.d = true;
    }

    public final void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("publish_time");
            this.a = jSONObject.optString("total");
            this.c = jSONObject.optString("update_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    l lVar = new l();
                    lVar.a(optJSONArray.getJSONObject(i));
                    this.e.add(lVar);
                }
            }
        } catch (JSONException e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.toString());
        }
    }
}
