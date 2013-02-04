package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private ArrayList a = new ArrayList();
    private aj b = new aj();

    public aj a() {
        return this.b;
    }

    public void a(aj ajVar) {
        this.b = ajVar;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ah ahVar = new ah();
                    ahVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(ahVar);
                }
            }
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public ArrayList b() {
        return this.a;
    }
}
