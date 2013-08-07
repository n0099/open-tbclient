package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f967a = null;

    public ae() {
        a(new ArrayList());
    }

    public ArrayList a() {
        return this.f967a;
    }

    public void a(ArrayList arrayList) {
        this.f967a = arrayList;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f967a = new ArrayList();
            b();
            JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("user_tag");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    bl blVar = new bl();
                    blVar.a(optJSONArray.optJSONObject(i));
                    this.f967a.add(blVar);
                }
            }
        } catch (Exception e) {
        }
    }

    public void b() {
        bl blVar = new bl();
        blVar.a("get_all_interest");
        blVar.b("全部兴趣");
        this.f967a.add(blVar);
    }
}
