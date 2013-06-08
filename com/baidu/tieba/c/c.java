package com.baidu.tieba.c;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.a.c {
    private String k;
    private List e = null;
    private String f = null;
    private String g = null;
    private String h = "1";
    private String i = "20";
    private int j = -1;
    private boolean l = false;
    private e m = null;
    private d n = null;

    public void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            this.f = str;
            this.h = str2;
            if (this.m == null) {
                this.m = new e(this, null);
                this.m.setPriority(2);
                this.m.execute(new Object[0]);
            }
        }
    }

    public void b(String str) {
        if (str != null && str.length() > 0) {
            this.g = str;
            if (this.n == null) {
                this.n = new d(this, null);
                this.n.setPriority(2);
                this.n.execute(new Object[0]);
            }
        }
    }

    public List d() {
        return this.e;
    }

    public void c(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    b(optJSONObject.optInt("errno"));
                    e(optJSONObject.optString("errmsg"));
                }
                this.l = jSONObject.optInt("has_more") != 0;
                JSONArray optJSONArray = jSONObject.optJSONArray("record");
                long currentTimeMillis = System.currentTimeMillis();
                this.e = new ArrayList();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        com.baidu.tieba.a.a.g gVar = new com.baidu.tieba.a.a.g();
                        gVar.a(this.f);
                        gVar.b(optJSONObject2.optString(PushConstants.EXTRA_USER_ID));
                        gVar.e(optJSONObject2.optString("user_name"));
                        gVar.a(1);
                        gVar.b(optJSONObject2.optLong("time") * 1000);
                        gVar.b(optJSONObject2.optInt("unread_count"));
                        gVar.c(optJSONObject2.optString("portrait"));
                        gVar.a(currentTimeMillis);
                        String optString = optJSONObject2.optString("abstract");
                        if (optString != null && optString.length() >= 1) {
                            gVar.d(optString);
                        }
                        this.e.add(gVar);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public List d(String str) {
        this.e = com.baidu.tieba.a.a.f.a().a(str);
        for (com.baidu.tieba.a.a.g gVar : this.e) {
            gVar.b(0);
        }
        return this.e;
    }

    public boolean e() {
        return this.l;
    }

    public void b(int i) {
        this.j = i;
    }

    public int f() {
        return this.j;
    }

    public void e(String str) {
        this.k = str;
    }

    public String g() {
        return this.k;
    }
}
