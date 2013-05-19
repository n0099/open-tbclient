package com.baidu.tieba.a;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
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
                    com.baidu.tieba.d.ae.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
                    return;
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ai aiVar = new ai();
                    aiVar.a(optJSONArray.getJSONObject(i));
                    if (aiVar.d() != null) {
                        this.a.add(aiVar);
                        if (z) {
                            this.b.put(aiVar.d(), aiVar.e());
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
            com.baidu.tieba.d.ae.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
        }
    }

    public ArrayList a() {
        return this.a;
    }

    public HashMap b() {
        return this.b;
    }
}
