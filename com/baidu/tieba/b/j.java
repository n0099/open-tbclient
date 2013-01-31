package com.baidu.tieba.b;

import com.baidu.tieba.c.af;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private int b = 0;
    private boolean c = false;
    private ArrayList a = new ArrayList();

    public ArrayList a() {
        return this.a;
    }

    public void b() {
        this.a.clear();
        this.b = 0;
        this.c = false;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            af.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        k kVar = null;
        try {
            int size = this.a.size();
            if (size > 0) {
                kVar = (k) this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                k kVar2 = kVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    k kVar3 = new k(this);
                    kVar3.b = optJSONObject.optString("time_shaft");
                    kVar3.a = optJSONObject.optInt("type", 0);
                    kVar3.c = optJSONObject.optString("title");
                    kVar3.d = optJSONObject.optString("reply_num");
                    kVar3.e = optJSONObject.optString("reply_time");
                    kVar3.f = optJSONObject.optString("fname");
                    kVar3.g = optJSONObject.optString("tid");
                    kVar3.h = optJSONObject.optString("pid");
                    kVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (kVar2 != null && kVar3.b.equals(kVar2.b)) {
                        this.a.add(kVar3);
                    } else {
                        k kVar4 = new k(this);
                        kVar4.b = kVar3.b;
                        kVar4.a = 0;
                        this.a.add(kVar4);
                        this.a.add(kVar3);
                    }
                    i++;
                    kVar2 = kVar3;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("page");
                int optInt = jSONObject2.optInt("current_page", 0);
                if (optInt > this.b) {
                    this.b = optInt;
                    this.c = jSONObject2.optInt("has_more", 0) == 1;
                    return;
                }
                return;
            }
            this.c = false;
        } catch (Exception e) {
            af.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
