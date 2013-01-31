package com.baidu.tieba.b;

import com.baidu.tieba.a.ad;
import com.baidu.tieba.a.ak;
import com.baidu.tieba.c.af;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private ArrayList a = new ArrayList();
    private ArrayList b = new ArrayList();
    private ak c = new ak();
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

    public ArrayList d() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.e = false;
            af.b("LikeForumModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ad adVar = new ad();
                    adVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(adVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("commend_forum_list");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ad adVar2 = new ad();
                    adVar2.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(adVar2);
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
            af.b("LikeForumModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
