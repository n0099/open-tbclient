package com.baidu.tieba.b;

import com.baidu.tieba.a.ae;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private ArrayList a = new ArrayList();

    public int a() {
        return this.a.size();
    }

    public ArrayList b() {
        return this.a;
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void b(ArrayList arrayList) {
        this.a.addAll(arrayList);
    }

    public void a(ae aeVar) {
        this.a.add(aeVar);
    }

    public int c() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public void d() {
        this.a.clear();
    }

    public void e() {
        ArrayList r = com.baidu.tieba.c.k.r();
        if (r != null) {
            a(r);
        }
    }

    public String a(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.a == null) {
            return null;
        }
        if (i >= this.a.size()) {
            i2 -= (i - this.a.size()) - 1;
            i = this.a.size() - 1;
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
                    JSONObject i6 = ((ae) this.a.get(i5)).i();
                    if (i6 == null || i4 < 0) {
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        jSONArray2.put(i4, i6);
                    }
                    i5--;
                    i4 = i3;
                } catch (Exception e) {
                    ag.b(getClass().getName(), "toJson", e.toString());
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
            ag.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ae aeVar = new ae();
                    aeVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(aeVar);
                }
            }
        } catch (Exception e) {
            ag.b(getClass().getName(), "parserJson", e.toString());
        }
    }
}
