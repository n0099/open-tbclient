package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ao {
    private ArrayList<UserData> a = new ArrayList<>();
    private al b = new al();

    public final void a(al alVar) {
        this.b = alVar;
    }

    public final al a() {
        return this.b;
    }

    public final ArrayList<UserData> b() {
        return this.a;
    }

    public final void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        this.a.add(userData);
                    }
                }
                this.b.a(jSONObject.optJSONObject("page"));
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
