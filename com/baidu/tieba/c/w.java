package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private String i = null;
    private String j = null;
    private x k = null;
    private z l = null;
    private com.baidu.tieba.frs.ax m = null;
    private com.baidu.tieba.frs.ax n = null;
    private com.baidu.tieba.a.s a = new com.baidu.tieba.a.s();
    private ArrayList b = new ArrayList();
    private ArrayList c = new ArrayList();
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private com.baidu.tieba.a.b g = new com.baidu.tieba.a.b();
    private com.baidu.tieba.a.aj h = new com.baidu.tieba.a.aj();

    public com.baidu.tieba.a.s a() {
        return this.a;
    }

    public ArrayList b() {
        return this.b;
    }

    public ArrayList c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public com.baidu.tieba.a.b e() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a.a(jSONObject.optJSONObject("forum"));
                this.h.a(jSONObject.optJSONObject("user"));
                this.g.a(jSONObject.optJSONObject("anti"));
                JSONObject optJSONObject = jSONObject.optJSONObject("photo_data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("thread_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            com.baidu.tieba.a.bc bcVar = new com.baidu.tieba.a.bc();
                            bcVar.a(optJSONArray.optJSONObject(i));
                            this.b.add(bcVar);
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("alb_id_list");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            this.c.add(optJSONArray2.optString(i2));
                        }
                    }
                    this.d = optJSONObject.optInt("has_more", 0);
                    this.e = optJSONObject.optInt("amount", 0);
                    this.f = optJSONObject.optInt("current_count", 0);
                }
            } catch (Exception e) {
            }
        }
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(int i) {
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = new x(this, i);
        this.k.setPriority(3);
        this.k.execute(new Object[0]);
    }

    public void b(int i) {
        if (this.k == null && this.l == null) {
            this.l = new z(this, i);
            this.l.setPriority(3);
            this.l.execute(new Object[0]);
        }
    }

    public void f() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
    }

    public void a(String str, String str2) {
        this.i = str;
        this.j = str2;
    }

    public void a(com.baidu.tieba.frs.ax axVar) {
        this.m = axVar;
    }

    public void b(com.baidu.tieba.frs.ax axVar) {
        this.n = axVar;
    }
}
