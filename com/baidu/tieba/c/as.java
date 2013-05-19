package com.baidu.tieba.c;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {
    private ArrayList a = new ArrayList();
    private com.baidu.tieba.a.ak b = new com.baidu.tieba.a.ak();
    private int c;

    public ArrayList a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public com.baidu.tieba.a.ak c() {
        return this.b;
    }

    public void a(com.baidu.tieba.a.ak akVar) {
        if (akVar != null) {
            this.b = akVar;
        }
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0 && ((at) arrayList.get(0)).a() == 3) {
            int size = this.a.size();
            if (size > 0) {
                if (((at) this.a.get(size - 1)).b().equals(((at) arrayList.get(0)).b())) {
                    arrayList.remove(0);
                }
                this.a.addAll(arrayList);
                return;
            }
            this.a = arrayList;
        }
    }

    public void a(String str, com.baidu.tieba.a.k kVar, String str2, com.baidu.tieba.a.ai aiVar) {
        if (str != null && str.length() != 0 && kVar != null && kVar.a() == 0 && kVar.d() != null && this.a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    if (!str.equals(((at) this.a.get(i2)).h())) {
                        i = i2 + 1;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(kVar);
                        ((at) this.a.get(i2)).a(arrayList);
                        ((at) this.a.get(i2)).a(str2);
                        ((at) this.a.get(i2)).a(((at) this.a.get(i2)).d() + 1);
                        ((at) this.a.get(i2)).a(aiVar);
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
            com.baidu.tieba.d.ae.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                at atVar = null;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    at atVar2 = new at(this);
                    atVar2.b = optJSONObject.optString("distance");
                    atVar2.c = optJSONObject.optString("lng");
                    atVar2.d = optJSONObject.optString("lat");
                    atVar2.a = optJSONObject.optInt("type", 0);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(PushConstants.EXTRA_CONTENT);
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            com.baidu.tieba.a.k kVar = new com.baidu.tieba.a.k();
                            kVar.a(optJSONArray2.optJSONObject(i2));
                            atVar2.e.add(kVar);
                        }
                    }
                    atVar2.f = optJSONObject.optString("time");
                    atVar2.g = optJSONObject.optString("tid");
                    atVar2.h = optJSONObject.optString("fid");
                    atVar2.i = optJSONObject.optString("fname");
                    atVar2.k = optJSONObject.optString("link");
                    atVar2.j.a(optJSONObject.optJSONObject("author"));
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("reply_content");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            com.baidu.tieba.a.k kVar2 = new com.baidu.tieba.a.k();
                            kVar2.a(optJSONArray3.optJSONObject(i3));
                            atVar2.l.add(kVar2);
                        }
                    }
                    atVar2.m = optJSONObject.optInt("reply_num");
                    atVar2.n = optJSONObject.optString("reply_time");
                    atVar2.o.a(optJSONObject.optJSONObject("replyer"));
                    if (atVar != null && atVar2.b.equals(atVar.b)) {
                        this.a.add(atVar2);
                    } else {
                        at atVar3 = new at(this);
                        atVar3.b = atVar2.b;
                        atVar3.a = 3;
                        this.a.add(atVar3);
                        this.a.add(atVar2);
                    }
                    i++;
                    atVar = atVar2;
                }
                this.b.a(jSONObject.getJSONObject("page"));
                this.c = jSONObject.optInt("zoom_level");
                return;
            }
            this.b.e(0);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public ArrayList d() {
        com.baidu.tieba.a.ae p;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                if (((at) this.a.get(i2)).a() == 0 && (p = ((at) this.a.get(i2)).p()) != null) {
                    arrayList.add(p);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }
}
