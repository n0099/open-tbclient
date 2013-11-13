package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<UserData> f1171a = new ArrayList<>();
    private an b = new an();

    public void a(an anVar) {
        this.b = anVar;
    }

    public an a() {
        return this.b;
    }

    public ArrayList<UserData> b() {
        return this.f1171a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            bg.b(getClass().getName(), "parserJson", e.getMessage());
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
                        this.f1171a.add(userData);
                    }
                }
                this.b.a(jSONObject.optJSONObject("page"));
            } catch (Exception e) {
                bg.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
