package com.baidu.tieba.b;

import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
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
            ag.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        l lVar = null;
        try {
            int size = this.a.size();
            if (size > 0) {
                lVar = (l) this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                l lVar2 = lVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    l lVar3 = new l(this);
                    lVar3.b = optJSONObject.optString("time_shaft");
                    lVar3.a = optJSONObject.optInt("type", 0);
                    lVar3.c = optJSONObject.optString("title");
                    lVar3.d = optJSONObject.optString("reply_num");
                    lVar3.e = optJSONObject.optString("reply_time");
                    lVar3.f = optJSONObject.optString("fname");
                    lVar3.g = optJSONObject.optString("tid");
                    lVar3.h = optJSONObject.optString("pid");
                    lVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (lVar2 != null && lVar3.b.equals(lVar2.b)) {
                        this.a.add(lVar3);
                    } else {
                        l lVar4 = new l(this);
                        lVar4.b = lVar3.b;
                        lVar4.a = 0;
                        this.a.add(lVar4);
                        this.a.add(lVar3);
                    }
                    i++;
                    lVar2 = lVar3;
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
            ag.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
