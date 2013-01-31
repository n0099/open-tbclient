package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class am {
    private ArrayList a = new ArrayList();
    private ak b = new ak();

    public void a(ak akVar) {
        this.b = akVar;
    }

    public ak a() {
        return this.b;
    }

    public ArrayList b() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ai aiVar = new ai();
                        aiVar.a(optJSONArray.getJSONObject(i));
                        this.a.add(aiVar);
                    }
                }
                this.b.a(jSONObject.optJSONObject("page"));
            } catch (Exception e) {
                com.baidu.tieba.c.af.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
