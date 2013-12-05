package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<UserData> f1223a = new ArrayList<>();
    private am b = new am();

    public void a(am amVar) {
        this.b = amVar;
    }

    public am a() {
        return this.b;
    }

    public ArrayList<UserData> b() {
        return this.f1223a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        this.f1223a.add(userData);
                    }
                }
                this.b.a(jSONObject.optJSONObject("page"));
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
