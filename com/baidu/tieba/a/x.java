package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x extends c {
    private y a;
    private ArrayList b;

    public x() {
        this.a = null;
        this.b = null;
        this.a = new y(this);
        this.b = new ArrayList();
    }

    public y a() {
        return this.a;
    }

    @Override // com.baidu.tieba.a.c
    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("zlist");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        ab abVar = new ab(this);
                        abVar.a(optJSONObject);
                        this.b.add(abVar);
                    }
                }
            }
            this.a.a(jSONObject.optJSONObject("area"));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public ArrayList b() {
        return this.b;
    }
}
