package com.baidu.tieba.b;

import com.baidu.tieba.a.ah;
import com.baidu.tieba.a.at;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.a.b c;
    private boolean f = false;
    private com.baidu.tieba.a.q a = new com.baidu.tieba.a.q();
    private ArrayList b = new ArrayList();
    private ah d = new ah();
    private com.baidu.tieba.a.s e = new com.baidu.tieba.a.s();

    public c() {
        a(new com.baidu.tieba.a.b());
    }

    public com.baidu.tieba.a.q a() {
        return this.a;
    }

    public ArrayList b() {
        return this.b;
    }

    public void a(com.baidu.tieba.a.b bVar) {
        this.c = bVar;
    }

    public com.baidu.tieba.a.b c() {
        return this.c;
    }

    public ah d() {
        return this.d;
    }

    public com.baidu.tieba.a.s e() {
        return this.e;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ag.b("FrsModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.a(jSONObject.optJSONObject("forum"));
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    at atVar = new at();
                    atVar.a(optJSONArray.optJSONObject(i));
                    atVar.p();
                    this.b.add(atVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("anti"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
        } catch (Exception e) {
            ag.b("FrsModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean f() {
        return this.f;
    }
}
