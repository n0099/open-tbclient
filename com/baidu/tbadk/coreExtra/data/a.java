package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private UserData a;
    private ArrayList<String> b;

    public a() {
        this.a = null;
        this.b = null;
        this.a = new UserData();
        this.b = new ArrayList<>(3);
    }

    public final UserData a() {
        return this.a;
    }

    public final ArrayList<String> b() {
        return this.b;
    }

    public final void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            this.a.parserJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.b.add(optJSONArray.optString(i, null));
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
