package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
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
            com.baidu.tieba.d.ae.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        as asVar = null;
        try {
            int size = this.a.size();
            if (size > 0) {
                asVar = (as) this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                as asVar2 = asVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    as asVar3 = new as(this);
                    asVar3.b = optJSONObject.optString("time_shaft");
                    asVar3.a = optJSONObject.optInt("type", 0);
                    asVar3.c = optJSONObject.optString("title");
                    asVar3.d = optJSONObject.optString("reply_num");
                    asVar3.e = optJSONObject.optString("reply_time");
                    asVar3.f = optJSONObject.optString("fname");
                    asVar3.g = optJSONObject.optString("tid");
                    asVar3.h = optJSONObject.optString("pid");
                    asVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (asVar2 != null && asVar3.b.equals(asVar2.b)) {
                        this.a.add(asVar3);
                    } else {
                        as asVar4 = new as(this);
                        asVar4.b = asVar3.b;
                        asVar4.a = 0;
                        this.a.add(asVar4);
                        this.a.add(asVar3);
                    }
                    i++;
                    asVar2 = asVar3;
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
            com.baidu.tieba.d.ae.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
