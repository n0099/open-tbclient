package com.baidu.tieba.a;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private ArrayList a = new ArrayList();
    private HashMap b = null;

    public ArrayList a() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str), true);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        if (z) {
            try {
                if (this.b == null) {
                    this.b = new HashMap();
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
                return;
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                ah ahVar = new ah();
                ahVar.a(optJSONArray.getJSONObject(i));
                if (ahVar.c() != null) {
                    this.a.add(ahVar);
                    if (z) {
                        this.b.put(ahVar.c(), ahVar.d());
                    }
                }
            }
        }
    }

    public HashMap b() {
        return this.b;
    }
}
