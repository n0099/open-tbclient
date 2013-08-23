package com.baidu.tieba.data.a;

import com.baidu.tieba.util.aq;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f968a = null;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private boolean f = false;
    private LinkedList g;

    public c() {
        this.g = null;
        this.g = new LinkedList();
    }

    public void a(String str) {
        this.f968a = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public LinkedList d() {
        return this.g;
    }

    public void e() {
        this.g.clear();
    }

    public void a(LinkedList linkedList) {
        this.g = linkedList;
    }

    public void a(d dVar) {
        this.g.add(dVar);
        while (this.g.size() > 1000) {
            this.g.remove(0);
        }
    }

    public void a(c cVar) {
        long f;
        long f2;
        long f3;
        long f4;
        LinkedList d = cVar.d();
        LinkedList linkedList = new LinkedList();
        if (d != null && d.size() != 0 && ((d) d.get(0)).b() != 0) {
            long j = 0;
            while (this.g.size() > 0 && d.size() > 0) {
                d dVar = (d) d.get(0);
                d dVar2 = (d) this.g.get(0);
                try {
                    f3 = Long.valueOf(dVar.b()).longValue();
                    f4 = Long.valueOf(dVar2.b()).longValue();
                } catch (Exception e) {
                    f3 = dVar.f();
                    f4 = dVar2.f();
                }
                if (f3 > f4) {
                    j = Math.max(j, f4);
                    linkedList.add(dVar2);
                    this.g.remove(0);
                } else if (f3 < f4) {
                    long max = Math.max(j, f3);
                    linkedList.add(dVar);
                    d.remove(0);
                    j = max;
                } else {
                    long max2 = Math.max(j, f3);
                    linkedList.add(dVar);
                    d.remove(0);
                    this.g.remove(0);
                    j = max2;
                }
            }
            while (this.g.size() > 0) {
                d dVar3 = (d) this.g.remove(0);
                try {
                    f2 = Long.valueOf(dVar3.b()).longValue();
                } catch (Exception e2) {
                    f2 = dVar3.f();
                }
                if (f2 > j) {
                    linkedList.add(dVar3);
                    j = f2;
                }
            }
            while (d.size() > 0) {
                d dVar4 = (d) d.remove(0);
                try {
                    f = Long.valueOf(dVar4.b()).longValue();
                } catch (Exception e3) {
                    f = dVar4.f();
                }
                if (f > j) {
                    linkedList.add(dVar4);
                    j = f;
                }
            }
            this.g = linkedList;
            while (this.g.size() > 1000) {
                this.g.remove(0);
            }
        }
    }

    public void e(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject.optInt("has_more") == 0) {
                this.f = false;
            } else {
                this.f = true;
            }
            this.d = jSONObject.optString("com_portrait");
            this.e = jSONObject.optString("user_portrait");
            JSONArray optJSONArray = jSONObject.optJSONArray("message");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    d dVar = new d();
                    dVar.a(optJSONArray.getJSONObject(i));
                    dVar.b(this.f968a);
                    dVar.a(this.c);
                    this.g.add(dVar);
                }
            }
        } catch (Exception e) {
            aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public d f() {
        if (this.g.size() < 1) {
            return null;
        }
        return (d) this.g.get(this.g.size() - 1);
    }

    public d a(int i) {
        if (this.g != null && i < this.g.size() && i >= 0) {
            return (d) this.g.get(i);
        }
        return null;
    }

    public String g() {
        return this.b;
    }

    public void f(String str) {
        this.b = str;
    }
}
