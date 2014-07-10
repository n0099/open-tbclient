package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int k;
    private String l;
    private String m;
    private int n = 0;
    private int o = 0;
    private List<y> p = null;
    private int a = 0;
    private long b = 0;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private MetaData i = new MetaData();
    private MetaData j = new MetaData();

    public String a() {
        return this.m;
    }

    public int b() {
        return this.n;
    }

    public List<y> c() {
        return this.p;
    }

    public int d() {
        return this.a;
    }

    public long e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.d;
    }

    public String h() {
        return this.e;
    }

    public String i() {
        return this.f;
    }

    public String j() {
        return this.g;
    }

    public String k() {
        return this.h;
    }

    public MetaData l() {
        return this.i;
    }

    public boolean m() {
        return this.k == 1;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("type", 0);
                this.c = jSONObject.optString("title");
                this.b = jSONObject.optLong("time", 0L) * 1000;
                this.d = jSONObject.optString("fname");
                this.e = jSONObject.optString("content");
                this.f = jSONObject.optString("quote_content");
                this.g = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
                this.h = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.POST_ID);
                this.k = jSONObject.optInt("is_floor");
                this.l = jSONObject.optString("quote_pid");
                this.m = jSONObject.optString("item_type");
                if (!com.baidu.adp.lib.util.i.b(this.m) && this.m.equals("zan")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("zan");
                    this.n = optJSONObject.optInt("num");
                    this.o = optJSONObject.optInt("is_liked");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("liker_list");
                    if (optJSONArray != null) {
                        this.p = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            y yVar = new y();
                            yVar.a(optJSONArray.optJSONObject(i));
                            this.p.add(yVar);
                        }
                    }
                }
                this.i.parserJson(jSONObject.optJSONObject("replyer"));
                this.j.parserJson(jSONObject.optJSONObject("quote_user"));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
