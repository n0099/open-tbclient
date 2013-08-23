package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private int f976a;
    private int b;
    private AntiData c;
    private Context d;
    private ArrayList e;

    public ad() {
        this.f976a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList();
        this.c = new AntiData();
    }

    public ad(Context context) {
        this.f976a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList();
        this.c = new AntiData();
        this.d = context;
    }

    public ArrayList a() {
        return this.e;
    }

    public int b() {
        return this.f976a;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.e.size() >= this.b;
    }

    public boolean e() {
        return this.e != null && this.e.size() < this.b && this.e.size() < 200;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("comment_list");
            if (jSONArray != null) {
                int size = this.e.size() - (this.e.size() % 10);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    as asVar = new as();
                    asVar.a(jSONObject2);
                    if (this.d != null) {
                        asVar.c(this.d);
                    }
                    if (size < this.e.size()) {
                        this.e.remove(size);
                        this.e.add(size, asVar);
                    } else {
                        this.e.add(asVar);
                    }
                    size++;
                }
                this.f976a = this.e.size();
            }
            this.b = jSONObject.optInt("comment_amount", 0);
            this.c.setTbs(jSONObject.getJSONObject("tbs").optString("common"));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "paserJson", e.toString());
        }
    }
}
