package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tieba.util.bg;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private int f1158a;
    private int b;
    private AntiData c;
    private Context d;
    private ArrayList<as> e;

    public ad() {
        this.f1158a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList<>();
        this.c = new AntiData();
    }

    public ad(Context context) {
        this.f1158a = 0;
        this.b = 0;
        this.d = null;
        this.e = null;
        this.e = new ArrayList<>();
        this.c = new AntiData();
        this.d = context;
    }

    public ArrayList<as> a() {
        return this.e;
    }

    public int b() {
        return this.f1158a;
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
            bg.b(getClass().getName(), "paserJson", e.toString());
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
                        asVar.b(this.d);
                    }
                    if (size < this.e.size()) {
                        this.e.remove(size);
                        this.e.add(size, asVar);
                    } else {
                        this.e.add(asVar);
                    }
                    size++;
                }
                this.f1158a = this.e.size();
            }
            this.b = jSONObject.optInt("comment_amount", 0);
            this.c.setTbs(jSONObject.getJSONObject("tbs").optString("common"));
        } catch (Exception e) {
            bg.b(getClass().getName(), "paserJson", e.toString());
        }
    }
}
