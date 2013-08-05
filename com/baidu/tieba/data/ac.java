package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    private int f967a;
    private boolean b;
    private String c;
    private String d;
    private ArrayList e;

    public ac() {
        a(0);
        b(null);
        c(null);
        a(false);
        this.e = new ArrayList();
    }

    public ArrayList a() {
        return this.e;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("InterestData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                c(jSONObject.optString("pn"));
                b(jSONObject.optString("total_page"));
                a(jSONObject.optInt("has_more"));
                JSONArray optJSONArray = jSONObject.optJSONArray("goodthreadfeed");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        af afVar = new af();
                        afVar.a(optJSONArray.optJSONObject(i));
                        this.e.add(afVar);
                    }
                    if (optJSONArray.length() == 0) {
                        a(true);
                    } else {
                        a(false);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("InterestData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(int i) {
        this.f967a = i;
    }

    public int b() {
        return this.f967a;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void a(ac acVar, boolean z) {
        if (acVar != null) {
            a(acVar.b());
            b(acVar.c());
            c(acVar.d());
            if (acVar.a() == null || acVar.a().size() == 0) {
                a(true);
            } else {
                a(false);
            }
            if (z) {
                Iterator it = acVar.a().iterator();
                while (it.hasNext()) {
                    this.e.add((af) it.next());
                }
                return;
            }
            this.e = acVar.a();
        }
    }

    public boolean e() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
