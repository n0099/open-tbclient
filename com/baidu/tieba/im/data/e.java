package com.baidu.tieba.im.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    private ArrayList<d> b;
    private int a = 0;
    private boolean c = false;

    public final ArrayList<d> a() {
        return this.b;
    }

    public final void a(String str) {
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
            com.baidu.adp.lib.util.e.b("InviteFriendListData", "parserJson", "error = " + e.getMessage());
        }
    }

    public final boolean b() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }
}
