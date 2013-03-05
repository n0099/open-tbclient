package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private ArrayList a = new ArrayList();
    private ah b = new ah();

    public void a(ah ahVar) {
        this.b = ahVar;
    }

    public ah a() {
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
                        af afVar = new af();
                        afVar.a(optJSONArray.getJSONObject(i));
                        this.a.add(afVar);
                    }
                }
                this.b.a(jSONObject.optJSONObject("page"));
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
