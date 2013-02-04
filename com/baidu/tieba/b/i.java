package com.baidu.tieba.b;

import com.baidu.tieba.a.ag;
import com.baidu.tieba.a.aj;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private ag c = new ag();
    private ArrayList a = new ArrayList();
    private aj b = new aj();
    private boolean d = true;

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            ae.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                    oVar.a(optJSONArray2.optJSONObject(i));
                    this.a.add(oVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("message"));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            ae.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public boolean a() {
        return this.d;
    }

    public ArrayList b() {
        return this.a;
    }

    public aj c() {
        return this.b;
    }
}
