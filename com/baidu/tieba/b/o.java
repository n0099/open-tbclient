package com.baidu.tieba.b;

import com.baidu.tieba.a.ab;
import com.baidu.tieba.a.af;
import com.baidu.tieba.a.ah;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private ArrayList a = new ArrayList();
    private ah b = new ah();
    private int c;

    public ArrayList a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public ah c() {
        return this.b;
    }

    public void a(ah ahVar) {
        if (ahVar != null) {
            this.b = ahVar;
        }
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0 && ((p) arrayList.get(0)).a() == 3) {
            int size = this.a.size();
            if (size > 0) {
                if (((p) this.a.get(size - 1)).b().equals(((p) arrayList.get(0)).b())) {
                    arrayList.remove(0);
                }
                this.a.addAll(arrayList);
                return;
            }
            this.a = arrayList;
        }
    }

    public void a(String str, com.baidu.tieba.a.k kVar, String str2, af afVar) {
        if (str != null && str.length() != 0 && kVar != null && kVar.a() == 0 && kVar.d() != null && this.a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    if (!str.equals(((p) this.a.get(i2)).h())) {
                        i = i2 + 1;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(kVar);
                        ((p) this.a.get(i2)).a(arrayList);
                        ((p) this.a.get(i2)).a(str2);
                        ((p) this.a.get(i2)).a(((p) this.a.get(i2)).d() + 1);
                        ((p) this.a.get(i2)).a(afVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ag.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                p pVar = null;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    p pVar2 = new p(this);
                    pVar2.b = optJSONObject.optString("distance");
                    pVar2.c = optJSONObject.optString("lng");
                    pVar2.d = optJSONObject.optString("lat");
                    pVar2.a = optJSONObject.optInt("type", 0);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("content");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            com.baidu.tieba.a.k kVar = new com.baidu.tieba.a.k();
                            kVar.a(optJSONArray2.optJSONObject(i2));
                            pVar2.e.add(kVar);
                        }
                    }
                    pVar2.f = optJSONObject.optString("time");
                    pVar2.g = optJSONObject.optString("tid");
                    pVar2.h = optJSONObject.optString("fid");
                    pVar2.i = optJSONObject.optString("fname");
                    pVar2.k = optJSONObject.optString("link");
                    pVar2.j.a(optJSONObject.optJSONObject("author"));
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("reply_content");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            com.baidu.tieba.a.k kVar2 = new com.baidu.tieba.a.k();
                            kVar2.a(optJSONArray3.optJSONObject(i3));
                            pVar2.l.add(kVar2);
                        }
                    }
                    pVar2.m = optJSONObject.optInt("reply_num");
                    pVar2.n = optJSONObject.optString("reply_time");
                    pVar2.o.a(optJSONObject.optJSONObject("replyer"));
                    if (pVar != null && pVar2.b.equals(pVar.b)) {
                        this.a.add(pVar2);
                    } else {
                        p pVar3 = new p(this);
                        pVar3.b = pVar2.b;
                        pVar3.a = 3;
                        this.a.add(pVar3);
                        this.a.add(pVar2);
                    }
                    i++;
                    pVar = pVar2;
                }
                this.b.a(jSONObject.getJSONObject("page"));
                this.c = jSONObject.optInt("zoom_level");
                return;
            }
            this.b.a(0);
        } catch (Exception e) {
            ag.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public ArrayList d() {
        ab p;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                if (((p) this.a.get(i2)).a() == 0 && (p = ((p) this.a.get(i2)).p()) != null) {
                    arrayList.add(p);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }
}
