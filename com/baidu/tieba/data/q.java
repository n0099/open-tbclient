package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private String g;
    private String h;
    private int a = 0;
    private String b = "";
    private String c = "";
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private ArrayList<r> i = new ArrayList<>();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                a(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.a = optJSONObject.optInt("errno", 0);
                    this.b = optJSONObject.optString("errmsg", "");
                    this.c = optJSONObject.optString("usermsg", "");
                }
                b(jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.TOTAL));
                b(jSONObject.optInt("has_more"));
                JSONArray optJSONArray = jSONObject.optJSONArray("feed_thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        r rVar = new r();
                        rVar.a(optJSONArray.optJSONObject(i));
                        this.i.add(rVar);
                    }
                    a(optJSONArray.length() == 0);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.c());
            b(qVar.e());
            c(qVar.f());
            a(qVar.b() == null || qVar.b().size() == 0);
            if (z) {
                this.i.addAll(qVar.b());
            } else {
                this.i = qVar.b();
            }
        }
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public ArrayList<r> b() {
        return this.i;
    }

    public void b(int i) {
        this.e = i;
    }

    public int c() {
        return this.e;
    }

    public boolean d() {
        return this.e > 0;
    }

    public void b(String str) {
        this.g = str;
    }

    public String e() {
        return this.g;
    }

    public void c(String str) {
        this.h = str;
    }

    public String f() {
        return this.h;
    }

    public int g() {
        return this.a;
    }

    public String h() {
        return this.c;
    }
}
