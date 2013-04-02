package com.baidu.tieba.b;

import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
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
        m mVar = null;
        try {
            int size = this.a.size();
            if (size > 0) {
                mVar = (m) this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                m mVar2 = mVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    m mVar3 = new m(this);
                    mVar3.b = optJSONObject.optString("time_shaft");
                    mVar3.a = optJSONObject.optInt("type", 0);
                    mVar3.c = optJSONObject.optString("title");
                    mVar3.d = optJSONObject.optString("reply_num");
                    mVar3.e = optJSONObject.optString("reply_time");
                    mVar3.f = optJSONObject.optString("fname");
                    mVar3.g = optJSONObject.optString("tid");
                    mVar3.h = optJSONObject.optString("pid");
                    mVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (mVar2 != null && mVar3.b.equals(mVar2.b)) {
                        this.a.add(mVar3);
                    } else {
                        m mVar4 = new m(this);
                        mVar4.b = mVar3.b;
                        mVar4.a = 0;
                        this.a.add(mVar4);
                        this.a.add(mVar3);
                    }
                    i++;
                    mVar2 = mVar3;
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
