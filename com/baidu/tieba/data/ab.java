package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private int f964a;
    private int b;
    private AntiData c;
    private Context d;
    private ArrayList e;

    public ab() {
        this.f964a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList();
        this.c = new AntiData();
    }

    public ab(Context context) {
        this.f964a = 0;
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
        return this.f964a;
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
            com.baidu.tieba.util.aj.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("comment_list");
            if (jSONArray != null) {
                int size = this.e.size() - (this.e.size() % 10);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    aw awVar = new aw();
                    awVar.a(jSONObject2);
                    if (this.d != null) {
                        awVar.c(this.d);
                    }
                    if (size < this.e.size()) {
                        this.e.remove(size);
                        this.e.add(size, awVar);
                    } else {
                        this.e.add(awVar);
                    }
                    size++;
                }
                this.f964a = this.e.size();
            }
            this.b = jSONObject.optInt("comment_amount", 0);
            this.c.setTbs(jSONObject.getJSONObject("tbs").optString("common"));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "paserJson", e.toString());
        }
    }
}
