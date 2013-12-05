package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    private int f1210a;
    private int b;
    private AntiData c;
    private Context d;
    private ArrayList<ar> e;

    public ac() {
        this.f1210a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList<>();
        this.c = new AntiData();
    }

    public ac(Context context) {
        this.f1210a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList<>();
        this.c = new AntiData();
        this.d = context;
    }

    public ArrayList<ar> a() {
        return this.e;
    }

    public int b() {
        return this.f1210a;
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
            com.baidu.tieba.util.bd.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("comment_list");
            if (jSONArray != null) {
                int size = this.e.size() - (this.e.size() % 10);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    ar arVar = new ar();
                    arVar.a(jSONObject2);
                    if (this.d != null) {
                        arVar.b(this.d);
                    }
                    if (size < this.e.size()) {
                        this.e.remove(size);
                        this.e.add(size, arVar);
                    } else {
                        this.e.add(arVar);
                    }
                    size++;
                }
                this.f1210a = this.e.size();
            }
            this.b = jSONObject.optInt("comment_amount", 0);
            this.c.setTbs(jSONObject.getJSONObject("tbs").optString("common"));
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "paserJson", e.toString());
        }
    }
}
