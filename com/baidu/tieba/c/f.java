package com.baidu.tieba.c;

import android.content.SharedPreferences;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private h b = null;
    private i c = null;
    private g d = null;
    private int f = 0;
    protected com.baidu.tieba.h a = null;
    private ArrayList e = new ArrayList();

    public int a() {
        return this.e.size();
    }

    public ArrayList b() {
        return this.e;
    }

    public void a(ArrayList arrayList) {
        this.e = arrayList;
    }

    public void b(ArrayList arrayList) {
        this.e.addAll(arrayList);
    }

    public void a(com.baidu.tieba.a.af afVar) {
        this.e.add(afVar);
    }

    public int c() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public int d() {
        return this.f;
    }

    public void e() {
        ArrayList s = com.baidu.tieba.d.k.s();
        if (s != null) {
            a(s);
        }
    }

    public String a(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.e == null) {
            return null;
        }
        if (i >= this.e.size()) {
            i2 -= (i - this.e.size()) - 1;
            i = this.e.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (true) {
            if (i5 < 0) {
                jSONArray = jSONArray2;
                break;
            } else if (i5 <= i - i2) {
                jSONArray = jSONArray2;
                break;
            } else {
                try {
                    JSONObject j = ((com.baidu.tieba.a.af) this.e.get(i5)).j();
                    if (j == null || i4 < 0) {
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        jSONArray2.put(i4, j);
                    }
                    i5--;
                    i4 = i3;
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.b(getClass().getName(), "toJson", e.toString());
                    jSONArray = null;
                }
            }
        }
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.a.af afVar = new com.baidu.tieba.a.af();
                    afVar.a(optJSONArray.getJSONObject(i));
                    this.e.add(afVar);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void f() {
        if (this.b != null) {
            this.b.cancel();
        }
        this.b = new h(this, a());
        this.b.setPriority(3);
        this.b.execute(new Boolean[0]);
    }

    public void g() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new i(this, null);
        this.c.setPriority(2);
        this.c.execute(new f[0]);
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.cancel();
        }
        if (this.e.get(i) != null && ((com.baidu.tieba.a.af) this.e.get(i)).c() != null) {
            this.d = new g(this, ((com.baidu.tieba.a.af) this.e.get(i)).c(), i);
            this.d.setPriority(2);
            this.d.execute(new Boolean[0]);
        }
    }

    public int h() {
        return TiebaApplication.e().getSharedPreferences("settings", 0).getInt("uploac_mark_offset", 399);
    }

    public void b(int i) {
        SharedPreferences.Editor edit = TiebaApplication.e().getSharedPreferences("settings", 0).edit();
        edit.putInt("uploac_mark_offset", i);
        edit.commit();
    }

    public void i() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.d != null) {
            this.d.cancel();
        }
    }

    public void a(com.baidu.tieba.h hVar) {
        this.a = hVar;
    }
}
