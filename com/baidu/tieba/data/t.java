package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<s> f1208a = new ArrayList<>();
    private ArrayList<s> b = new ArrayList<>();
    private an c = new an();
    private Date d = null;
    private boolean e = true;
    private int f = 0;

    public boolean a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public ArrayList<s> c() {
        return this.f1208a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.e = false;
            bg.b("LikeForumModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    s sVar = new s();
                    sVar.a(optJSONArray.getJSONObject(i));
                    this.f1208a.add(sVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("commend_forum_list");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    s sVar2 = new s();
                    sVar2.a(optJSONArray2.getJSONObject(i2));
                    this.b.add(sVar2);
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
            bg.b("LikeForumModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
