package com.baidu.tieba.im.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private ArrayList<d> b;
    private int a = 0;
    private boolean c = false;

    public ArrayList<d> a() {
        return this.b;
    }

    public void a(String str) {
        d a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optInt("total_count", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("res_user_infos");
            if (optJSONArray != null) {
                this.b = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && (a = d.a(optJSONObject)) != null) {
                        this.b.add(a);
                    }
                }
            }
        } catch (JSONException e) {
            com.baidu.adp.lib.util.f.b("InviteFriendListData", "parserJson", "error = " + e.getMessage());
        }
    }

    public boolean b() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
