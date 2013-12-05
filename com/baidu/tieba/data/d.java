package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private UserData f1244a;
    private ArrayList<String> b;

    public d() {
        this.f1244a = null;
        this.b = null;
        this.f1244a = new UserData();
        this.b = new ArrayList<>(3);
    }

    public UserData a() {
        return this.f1244a;
    }

    public ArrayList<String> b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f1244a.parserJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.b.add(optJSONArray.optString(i, null));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
