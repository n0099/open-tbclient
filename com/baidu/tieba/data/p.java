package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private ArrayList a = new ArrayList();
    private ArrayList b = new ArrayList();
    private ai c = new ai();
    private Date d = null;
    private boolean e = true;
    private int f = 0;

    public boolean a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public ArrayList c() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.e = false;
            com.baidu.tieba.util.z.b("LikeForumModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    o oVar = new o();
                    oVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(oVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("commend_forum_list");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    o oVar2 = new o();
                    oVar2.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(oVar2);
                }
            }
            this.c.a(jSONObject.optJSONObject("page"));
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.d = new Date(optLong);
            } else {
                this.d = new Date();
            }
            this.f = jSONObject.optInt("is_login", 0);
        } catch (Exception e) {
            this.e = false;
            com.baidu.tieba.util.z.b("LikeForumModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
