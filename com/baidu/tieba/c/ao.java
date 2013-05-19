package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ao {
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
        ap apVar = null;
        try {
            int size = this.a.size();
            if (size > 0) {
                apVar = (ap) this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                ap apVar2 = apVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    ap apVar3 = new ap(this);
                    apVar3.b = optJSONObject.optString("time_shaft");
                    apVar3.a = optJSONObject.optInt("type", 0);
                    apVar3.c = optJSONObject.optString("title");
                    apVar3.d = optJSONObject.optString("reply_num");
                    apVar3.e = optJSONObject.optString("reply_time");
                    apVar3.f = optJSONObject.optString("fname");
                    apVar3.g = optJSONObject.optString("tid");
                    apVar3.h = optJSONObject.optString("pid");
                    apVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (apVar2 != null && apVar3.b.equals(apVar2.b)) {
                        this.a.add(apVar3);
                    } else {
                        ap apVar4 = new ap(this);
                        apVar4.b = apVar3.b;
                        apVar4.a = 0;
                        this.a.add(apVar4);
                        this.a.add(apVar3);
                    }
                    i++;
                    apVar2 = apVar3;
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
