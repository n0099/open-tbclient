package com.baidu.tieba.b;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.a.ad;
import com.baidu.tieba.a.ah;
import com.baidu.tieba.a.aj;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private ArrayList a = new ArrayList();
    private aj b = new aj();
    private int c;

    public ArrayList a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public aj c() {
        return this.b;
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            this.b = ajVar;
        }
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0 && ((q) arrayList.get(0)).a() == 3) {
            int size = this.a.size();
            if (size > 0) {
                if (((q) this.a.get(size - 1)).b().equals(((q) arrayList.get(0)).b())) {
                    arrayList.remove(0);
                }
                this.a.addAll(arrayList);
                return;
            }
            this.a = arrayList;
        }
    }

    public void a(String str, com.baidu.tieba.a.k kVar, String str2, ah ahVar) {
        if (str != null && str.length() != 0 && kVar != null && kVar.a() == 0 && kVar.d() != null && this.a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    if (!str.equals(((q) this.a.get(i2)).h())) {
                        i = i2 + 1;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(kVar);
                        ((q) this.a.get(i2)).a(arrayList);
                        ((q) this.a.get(i2)).a(str2);
                        ((q) this.a.get(i2)).a(((q) this.a.get(i2)).d() + 1);
                        ((q) this.a.get(i2)).a(ahVar);
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
                q qVar = null;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    q qVar2 = new q(this);
                    qVar2.b = optJSONObject.optString("distance");
                    qVar2.c = optJSONObject.optString("lng");
                    qVar2.d = optJSONObject.optString("lat");
                    qVar2.a = optJSONObject.optInt("type", 0);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(PushConstants.EXTRA_CONTENT);
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            com.baidu.tieba.a.k kVar = new com.baidu.tieba.a.k();
                            kVar.a(optJSONArray2.optJSONObject(i2));
                            qVar2.e.add(kVar);
                        }
                    }
                    qVar2.f = optJSONObject.optString("time");
                    qVar2.g = optJSONObject.optString("tid");
                    qVar2.h = optJSONObject.optString("fid");
                    qVar2.i = optJSONObject.optString("fname");
                    qVar2.k = optJSONObject.optString("link");
                    qVar2.j.a(optJSONObject.optJSONObject("author"));
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("reply_content");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            com.baidu.tieba.a.k kVar2 = new com.baidu.tieba.a.k();
                            kVar2.a(optJSONArray3.optJSONObject(i3));
                            qVar2.l.add(kVar2);
                        }
                    }
                    qVar2.m = optJSONObject.optInt("reply_num");
                    qVar2.n = optJSONObject.optString("reply_time");
                    qVar2.o.a(optJSONObject.optJSONObject("replyer"));
                    if (qVar != null && qVar2.b.equals(qVar.b)) {
                        this.a.add(qVar2);
                    } else {
                        q qVar3 = new q(this);
                        qVar3.b = qVar2.b;
                        qVar3.a = 3;
                        this.a.add(qVar3);
                        this.a.add(qVar2);
                    }
                    i++;
                    qVar = qVar2;
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
        ad p;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                if (((q) this.a.get(i2)).a() == 0 && (p = ((q) this.a.get(i2)).p()) != null) {
                    arrayList.add(p);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }
}
