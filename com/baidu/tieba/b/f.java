package com.baidu.tieba.b;

import com.baidu.tieba.a.ah;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private ArrayList a = new ArrayList();
    private ArrayList b = new ArrayList();
    private ah c = new ah();
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
            ag.b("LikeForumModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.a.y yVar = new com.baidu.tieba.a.y();
                    yVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(yVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("commend_forum_list");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    com.baidu.tieba.a.y yVar2 = new com.baidu.tieba.a.y();
                    yVar2.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(yVar2);
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
            ag.b("LikeForumModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
