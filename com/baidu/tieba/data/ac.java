package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ac {
    private int a;
    private int b;
    private AntiData c;
    private Context d;
    private ArrayList<aq> e;

    public ac() {
        this.a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList<>();
        this.c = new AntiData();
    }

    public ac(Context context) {
        this.a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList<>();
        this.c = new AntiData();
        this.d = context;
    }

    public final ArrayList<aq> a() {
        return this.e;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final boolean d() {
        return this.e.size() >= this.b;
    }

    public final boolean e() {
        return this.e != null && this.e.size() < this.b && this.e.size() < 200;
    }

    public final void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("comment_list");
            if (jSONArray != null) {
                int size = this.e.size() - (this.e.size() % 10);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    aq aqVar = new aq();
                    aqVar.a(jSONObject2);
                    if (this.d != null) {
                        aqVar.b(this.d);
                    }
                    if (size < this.e.size()) {
                        this.e.remove(size);
                        this.e.add(size, aqVar);
                    } else {
                        this.e.add(aqVar);
                    }
                    size++;
                }
                this.a = this.e.size();
            }
            this.b = jSONObject.optInt("comment_amount", 0);
            this.c.setTbs(jSONObject.getJSONObject("tbs").optString("common"));
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "paserJson", e.toString());
        }
    }
}
