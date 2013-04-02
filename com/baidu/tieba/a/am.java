package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class am {
    private ArrayList a = new ArrayList();
    private aj b = new aj();

    public void a(aj ajVar) {
        this.b = ajVar;
    }

    public aj a() {
        return this.b;
    }

    public ArrayList b() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
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
                com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
