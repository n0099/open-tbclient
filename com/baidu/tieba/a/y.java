package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y extends d {
    private z a;
    private ArrayList b;

    public y() {
        this.a = null;
        this.b = null;
        this.a = new z(this);
        this.b = new ArrayList();
    }

    public z a() {
        return this.a;
    }

    public ArrayList b() {
        return this.b;
    }

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("zlist");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        ac acVar = new ac(this);
                        acVar.a(optJSONObject);
                        this.b.add(acVar);
                    }
                }
            }
            this.a.a(jSONObject.optJSONObject("area"));
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
