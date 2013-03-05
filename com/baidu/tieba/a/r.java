package com.baidu.tieba.a;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private ArrayList a = new ArrayList();
    private HashMap b = null;

    public void a(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            if (z) {
                try {
                    if (this.b == null) {
                        this.b = new HashMap();
                    }
                } catch (Exception e) {
                    com.baidu.tieba.c.ag.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
                    return;
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    af afVar = new af();
                    afVar.a(optJSONArray.getJSONObject(i));
                    if (afVar.c() != null) {
                        this.a.add(afVar);
                        if (z) {
                            this.b.put(afVar.c(), afVar.d());
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        try {
            a(new JSONObject(str), true);
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
        }
    }

    public ArrayList a() {
        return this.a;
    }

    public HashMap b() {
        return this.b;
    }
}
