package com.baidu.tieba.b;

import com.baidu.tieba.a.aj;
import com.baidu.tieba.a.as;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.a.b c;
    private boolean f = false;
    private com.baidu.tieba.a.p a = new com.baidu.tieba.a.p();
    private ArrayList b = new ArrayList();
    private aj d = new aj();
    private com.baidu.tieba.a.r e = new com.baidu.tieba.a.r();

    public c() {
        a(new com.baidu.tieba.a.b());
    }

    public com.baidu.tieba.a.p a() {
        return this.a;
    }

    public void a(com.baidu.tieba.a.b bVar) {
        this.c = bVar;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ae.b("FrsModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.a(jSONObject.optJSONObject("forum"));
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    as asVar = new as();
                    asVar.a(optJSONArray.optJSONObject(i));
                    asVar.p();
                    this.b.add(asVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("anti"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
        } catch (Exception e) {
            ae.b("FrsModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.f = z;
    }

    public ArrayList b() {
        return this.b;
    }

    public com.baidu.tieba.a.b c() {
        return this.c;
    }

    public aj d() {
        return this.d;
    }

    public com.baidu.tieba.a.r e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }
}
